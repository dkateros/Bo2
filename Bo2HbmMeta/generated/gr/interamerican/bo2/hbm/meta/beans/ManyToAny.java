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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metaValueOrColumn"
})
@XmlRootElement(name = "many-to-any")
public class ManyToAny {

    @XmlAttribute(name = "id-type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String idType;
    @XmlAttribute(name = "meta-type")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String metaType;
    @XmlElements({
        @XmlElement(name = "meta-value", type = MetaValue.class),
        @XmlElement(name = "column", type = Column.class)
    })
    protected List<Object> metaValueOrColumn;

    /**
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    /**
     * Gets the value of the metaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaType() {
        return metaType;
    }

    /**
     * Sets the value of the metaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaType(String value) {
        this.metaType = value;
    }

    /**
     * Gets the value of the metaValueOrColumn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaValueOrColumn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaValueOrColumn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetaValue }
     * {@link Column }
     * 
     * 
     */
    public List<Object> getMetaValueOrColumn() {
        if (metaValueOrColumn == null) {
            metaValueOrColumn = new ArrayList<Object>();
        }
        return this.metaValueOrColumn;
    }

}
