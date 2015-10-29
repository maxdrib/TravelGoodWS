
package org.netbeans.j2ee.wsdl.lameduckws.java.lameduck_ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightInformationList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightInformationList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newElement" type="{http://j2ee.netbeans.org/wsdl/LameDuckWS/java/lameduck_ws}fligthInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightInformationList", propOrder = {
    "newElement"
})
public class FlightInformationList {

    protected List<FligthInformation> newElement;

    /**
     * Gets the value of the newElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FligthInformation }
     * 
     * 
     */
    public List<FligthInformation> getNewElement() {
        if (newElement == null) {
            newElement = new ArrayList<FligthInformation>();
        }
        return this.newElement;
    }

}
