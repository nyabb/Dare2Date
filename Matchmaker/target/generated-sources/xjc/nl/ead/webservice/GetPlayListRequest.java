//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.10 at 04:54:07 PM CET 
//


package nl.ead.webservice;

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
 *         &lt;element name="input" type="{http://www.han.nl/schemas/types}PlayListRequest"/>
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
    "input"
})
@XmlRootElement(name = "GetPlayListRequest", namespace = "http://www.han.nl/schemas/messages")
public class GetPlayListRequest {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    protected PlayListRequest input;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link PlayListRequest }
     *     
     */
    public PlayListRequest getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlayListRequest }
     *     
     */
    public void setInput(PlayListRequest value) {
        this.input = value;
    }

}
