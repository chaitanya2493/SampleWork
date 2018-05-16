
package com.mtomImpl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pingInput" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pingInput"
})
@XmlRootElement(name = "pingStringInput")
public class PingStringInput {

    @XmlElement(required = true)
    protected String pingInput;

    /**
     * Gets the value of the pingInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPingInput() {
        return pingInput;
    }

    /**
     * Sets the value of the pingInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPingInput(String value) {
        this.pingInput = value;
    }

}
