//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.04 at 09:59:23 AM EEST 
//


package gr.interamerican.bo2.hbm.meta.beans;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meta",
    "tuplizer",
    "keyPropertyOrKeyManyToOne",
    "generator"
})
@XmlRootElement(name = "composite-id")
public class CompositeId {

    @XmlAttribute(name = "class")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String clazz;
    @XmlAttribute(name = "mapped")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mapped;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "node")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String node;
    @XmlAttribute(name = "access")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String access;
    @XmlAttribute(name = "unsaved-value")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String unsavedValue;
    protected List<Meta> meta;
    protected List<Tuplizer> tuplizer;
    @XmlElements({
        @XmlElement(name = "key-property", required = true, type = KeyProperty.class),
        @XmlElement(name = "key-many-to-one", required = true, type = KeyManyToOne.class)
    })
    protected List<Object> keyPropertyOrKeyManyToOne;
    protected Generator generator;

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
     * Gets the value of the mapped property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapped() {
        if (mapped == null) {
            return "false";
        } else {
            return mapped;
        }
    }

    /**
     * Sets the value of the mapped property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapped(String value) {
        this.mapped = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccess(String value) {
        this.access = value;
    }

    /**
     * Gets the value of the unsavedValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnsavedValue() {
        if (unsavedValue == null) {
            return "undefined";
        } else {
            return unsavedValue;
        }
    }

    /**
     * Sets the value of the unsavedValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnsavedValue(String value) {
        this.unsavedValue = value;
    }

    /**
     * Gets the value of the meta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Meta }
     * 
     * 
     */
    public List<Meta> getMeta() {
        if (meta == null) {
            meta = new ArrayList<Meta>();
        }
        return this.meta;
    }

    /**
     * Gets the value of the tuplizer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tuplizer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTuplizer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tuplizer }
     * 
     * 
     */
    public List<Tuplizer> getTuplizer() {
        if (tuplizer == null) {
            tuplizer = new ArrayList<Tuplizer>();
        }
        return this.tuplizer;
    }

    /**
     * Gets the value of the keyPropertyOrKeyManyToOne property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyPropertyOrKeyManyToOne property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyPropertyOrKeyManyToOne().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyProperty }
     * {@link KeyManyToOne }
     * 
     * 
     */
    public List<Object> getKeyPropertyOrKeyManyToOne() {
        if (keyPropertyOrKeyManyToOne == null) {
            keyPropertyOrKeyManyToOne = new ArrayList<Object>();
        }
        return this.keyPropertyOrKeyManyToOne;
    }

    /**
     * Gets the value of the generator property.
     * 
     * @return
     *     possible object is
     *     {@link Generator }
     *     
     */
    public Generator getGenerator() {
        return generator;
    }

    /**
     * Sets the value of the generator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Generator }
     *     
     */
    public void setGenerator(Generator value) {
        this.generator = value;
    }

}
