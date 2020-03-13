//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.04 at 09:59:23 AM EEST 
//


package gr.interamerican.bo2.hbm.meta.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "one-to-many")
public class OneToMany {

    @XmlAttribute(name = "class")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String clazz;
    @XmlAttribute(name = "not-found")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String notFound;
    @XmlAttribute(name = "node")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String node;
    @XmlAttribute(name = "embed-xml")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String embedXml;
    @XmlAttribute(name = "entity-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String entityName;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the notFound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotFound() {
        if (notFound == null) {
            return "exception";
        } else {
            return notFound;
        }
    }

    /**
     * Sets the value of the notFound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotFound(String value) {
        this.notFound = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNode() {
        return node;
    }

    /**
     * Sets the value of the node property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNode(String value) {
        this.node = value;
    }

    /**
     * Gets the value of the embedXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbedXml() {
        if (embedXml == null) {
            return "true";
        } else {
            return embedXml;
        }
    }

    /**
     * Sets the value of the embedXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbedXml(String value) {
        this.embedXml = value;
    }

    /**
     * Gets the value of the entityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets the value of the entityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityName(String value) {
        this.entityName = value;
    }

}
