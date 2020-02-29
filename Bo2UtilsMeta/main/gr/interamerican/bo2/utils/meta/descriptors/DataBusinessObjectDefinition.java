package gr.interamerican.bo2.utils.meta.descriptors;

import gr.interamerican.bo2.utils.meta.BusinessObjectDescriptor;
import gr.interamerican.bo2.utils.meta.BusinessObjectDescriptorOwner;

import java.util.Set;

/**
 * An object definition is an object that holds meta-data for 
 * a business object. Note that there is not a one-to-one relationship
 * between business objects and classes defined in the application.
 */
public interface DataBusinessObjectDefinition 
extends BusinessObjectDescriptorOwner {

	/**
	 * Gets the name of the business object.
	 * 
	 * @return ObjectNm
	 */
	public String getObjectNm();
	
	/**
	 * Sets the name of the business object.
	 * 
	 * @param objectNm
	 */
	public void setObjectNm(String objectNm);
	
	/**
	 * ����� package ��� ����� ������ � �����.
	 *
	 * @return ���������� �� package
	 */
	public String getPackageName();

	/**
	 * ��������� �� ����� ��� package ��� ����� ������ �� �����.
	 *
	 * @param packageName ��� package
	 */
	public void setPackageName(String packageName);

	/**
	 * ����� ������ ���� ����� ������ � ��������, ����� ����� �� package.
	 *
	 * @return ���������� �� ����� ������ ����� �� package.
	 */
	public String getClassName();

	/**
	 * ��������� �� ����� ������ ���� ����� ������ � ��������.
	 * 
	 * �� ����� ������ ��� ������ �� �������� ��� �� package.
	 *
	 * @param className ��� ����� ������.
	 */
	public void setClassName(String className);
	
	/**
	 * ���������� ��������� ��� ������
	 * 
	 * @return ���������� ��� ���������� ��������� ��� ������
	 */
	public Set<? extends PropertyDefinition> getPropertyDefinitions();
	
	/**
	 * ����� ��� descriptor ��� ������.
	 * 
	 * @param descriptor
	 */
	public void setBusinessObjectDescriptor(BusinessObjectDescriptor<?> descriptor);
	
	/**
	 * ������� �� �� ������������ ����� ����� ��������.
	 * 
	 * @return ���������� true �� �� ����� ����� ��������.
	 */
	public boolean isDynamicObject();
	
	/**
	 * ��������� �� ���� �� ����������� ����� ��������.
	 * 
	 * @param dynamicObject
	 *        ��� �������.
	 */
	public void setDynamicObject(boolean dynamicObject);
	
	
}
