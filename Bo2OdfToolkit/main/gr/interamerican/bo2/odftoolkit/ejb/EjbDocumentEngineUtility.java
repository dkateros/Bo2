package gr.interamerican.bo2.odftoolkit.ejb;

import gr.interamerican.bo2.odftoolkit.AbstractDocumentEngineUtility;
import gr.interamerican.bo2.utils.StringUtils;
import gr.interamerican.bo2.utils.doc.DocumentEngineException;
import gr.interamerican.bo2.utils.doc.DocumentEngineUtility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Implementation of {@link DocumentEngineUtility} based on EJB.
 */
public class EjbDocumentEngineUtility
extends AbstractDocumentEngineUtility {

	/**
	 * Creates a new EjbDocumentEngineUtility object. 
	 *
	 * @param properties the properties
	 */
	public EjbDocumentEngineUtility(Properties properties) {
		super(properties);
	}
	
	@Deprecated
	@Override
	public String toHtml(byte[] odf) throws DocumentEngineException {
		return getProxy().toHtml(odf);
	}

	@Override
	public byte[] toPdf(byte[] odf) throws DocumentEngineException {
		return getProxy().toPdf(odf);
	}
	
	/**
	 * Gets an EJB DocumentEngineUtility proxy.
	 *
	 * @return Returns an EJB DocumentEngineUtility proxy.
	 * @throws DocumentEngineException the document engine exception
	 */
	private DocumentEngineUtility getProxy() throws DocumentEngineException {
		try {
			boolean locallyAccessible = StringUtils.isNullOrBlank(ejbLookupUrl) || StringUtils.isNullOrBlank(initialCtxFactory);
			Context context = null;
			if(locallyAccessible) {
				context = new InitialContext();
			} else {
				Properties props = new Properties();
				props.put(Context.INITIAL_CONTEXT_FACTORY, initialCtxFactory);
				props.put(Context.PROVIDER_URL, ejbLookupUrl);
				context = new InitialContext(props);
			}
			return (DocumentEngineUtility) context.lookup(ejbName);
		} catch (NamingException ne) {
			throw new DocumentEngineException(ne);
		}
	}
}