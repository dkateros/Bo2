/*******************************************************************************
 * Copyright (c) 2013 INTERAMERICAN PROPERTY AND CASUALTY INSURANCE COMPANY S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/copyleft/lesser.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 ******************************************************************************/
package gr.interamerican.bo2.impl.open.hibernate.types;

import gr.interamerican.bo2.utils.NumberUtils;
import gr.interamerican.bo2.utils.ReflectionUtils;
import gr.interamerican.bo2.utils.StringUtils;
import gr.interamerican.bo2.utils.meta.convert.TwoWayConverter;
import gr.interamerican.bo2.utils.meta.exceptions.ConversionException;
import gr.interamerican.bo2.utils.sql.types.TypeUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.HibernateException;

/**
 * General purpose user type that is used when there is an entity &lt;-&gt;
 * database table mismatch. This may happen when it is required to map an entity
 * with a legacy table. The configuration parameters are as follows:
 * <ul>
 * <li>twoWayConverterClass: Class of the {@link TwoWayConverter}. It MUST have
 * a default constructor.</li>
 * <li>propertyClass: java type of the entity property.</li>
 * <li>sqlType: sql type of the column. See {@link Types}.</li>
 * </ul>
 * <br>
 * Example configuration for this user type.
 * 
 * <pre>
 * &lt;typedef class="gr.interamerican.bo2.impl.open.hibernate.types.TwoWayConverterUserType" name="DamageCause"&gt;
 * 	&lt;param name="twoWayConverterClass"&gt;gr.interamerican.converters.StringToCountryConverter&lt;/param&gt;
 * 	&lt;param name="propertyClass"&gt;gr.interamerican.bo.def.pc.common.base.SystemListEntry&lt;/param&gt;
 * 	&lt;param name="columnSqlType"&gt;1&lt;/param&gt;
 * &lt;/typedef&gt;
 * </pre>
 * 
 * When writing a {@link TwoWayConverter} implementation for this user type, the
 * developer has to be aware of the java type that is created by the driver when
 * retrieving a column of the specified SQL type from the resultset. Use
 * {@link TypeUtils#getJavaTypeOfSqlType(int)} if you are not sure what the java
 * type will be.
 *
 * @param <L>
 *            Type to be inserted in / read from the database column.
 * @param <R>
 *            Type of the entity property.
 * @see TypeUtils
 * @see TwoWayConverter
 */
public class TwoWayConverterUserType<L, R> extends AbstractUserType {

	/**
	 * Parameter name for {@link TwoWayConverter} class name.
	 */
	private static final String TWO_WAY_CONVERTER_FQCN_PARAMETER = "twoWayConverterClass"; //$NON-NLS-1$

	/**
	 * Parameter name for java class of entity property.
	 */
	private static final String ENTITY_PROPERTY_FQCN_PARAMETER = "propertyClass"; //$NON-NLS-1$

	/**
	 * Parameter name for SQL type of column.
	 */
	private static final String COLUMN_SQL_TYPE_PARAMETER = "columnSqlType"; //$NON-NLS-1$

	/**
	 * Cache for known classes. The key is the converter class fqcn.
	 */
	private static final Map<String, Class<?>> knownClasses = new HashMap<String, Class<?>>();

	/**
	 * Cached converter instances. The key is the converter class fqcn.
	 */
	private static final Map<String, TwoWayConverter<?, ?>> converters = new HashMap<String, TwoWayConverter<?, ?>>();

	/**
	 * Class of the property.
	 */
	private Class<R> propertyClass;

	/**
	 * {@link TwoWayConverter} for L&lt;--&gt;R conversions.
	 */
	private TwoWayConverter<L, R> twoWayConverter;

	/**
	 * SQL type of column.
	 * 
	 * @see Types
	 */
	int sqlType;

	@Override
	@SuppressWarnings("unchecked")
	public void setParameterValues(Properties parameters) {
		String twoWayConverterFqcn = parameters.getProperty(TWO_WAY_CONVERTER_FQCN_PARAMETER);
		String propertyFqcn = parameters.getProperty(ENTITY_PROPERTY_FQCN_PARAMETER);
		sqlType = NumberUtils.string2Int(parameters.getProperty(COLUMN_SQL_TYPE_PARAMETER));
		propertyClass = (Class<R>) knownClasses.get(propertyFqcn);
		if (propertyClass == null) {
			propertyClass = (Class<R>) loadClass(propertyFqcn);
		}

		twoWayConverter = (TwoWayConverter<L, R>) converters.get(twoWayConverterFqcn);
		if (twoWayConverter == null) {
			Class<?> twoWayconverterClass = knownClasses.get(twoWayConverterFqcn);
			if (twoWayconverterClass == null) {
				twoWayconverterClass = loadClass(twoWayConverterFqcn);
			}
			twoWayConverter = (TwoWayConverter<L, R>) ReflectionUtils.newInstance(twoWayconverterClass);
			converters.put(twoWayConverterFqcn, twoWayConverter);
		}
	}

	@Deprecated
	@Override
	@SuppressWarnings({ "unchecked" })
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		Object column = TypeUtils.getTypeOfSqlType(sqlType).get(rs, names[0]);
		try {
			return twoWayConverter.convertL((L) column);
		} catch (ConversionException e) {
			throw new HibernateException(e);
		}
	}

	@Deprecated
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		R property = propertyClass.cast(value);
		try {
			L column = twoWayConverter.convertR(property);
			st.setObject(index, column, sqlType);
		} catch (ConversionException e) {
			throw new HibernateException(e);
		}
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { sqlType };
	}

	@Override
	public Class<?> returnedClass() {
		return propertyClass;
	}

	@Override
	public String objectToSQLString(Object value) {
		return StringUtils.toString(value);
	}

	@Override
	public String toXMLString(Object value) {
		return StringUtils.toString(value);
	}

	@Override
	public Object fromXMLString(String xmlValue) {
		return null;
	}

	/**
	 * Loads a class and updates the local cache.
	 *
	 * @param className
	 *            the class name
	 * @return loaded class.
	 */
	private Class<?> loadClass(String className) {
		try {
			Class<?> clazz = Class.forName(className);
			knownClasses.put(className, clazz);
			return clazz;
		} catch (ClassNotFoundException cnfe) {
			throw new RuntimeException(cnfe);
		}
	}
}