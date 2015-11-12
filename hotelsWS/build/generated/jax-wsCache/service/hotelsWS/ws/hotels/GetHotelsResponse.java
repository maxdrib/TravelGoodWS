
package ws.hotels;

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
 *         &lt;element name="hotelList" type="{http://hotels.ws}hotelListType"/>
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
    "hotelList"
})
@XmlRootElement(name = "getHotelsResponse")
public class GetHotelsResponse {

    @XmlElement(required = true)
    protected HotelListType hotelList;

    /**
     * Gets the value of the hotelList property.
     * 
     * @return
     *     possible object is
     *     {@link HotelListType }
     *     
     */
    public HotelListType getHotelList() {
        return hotelList;
    }

    /**
     * Sets the value of the hotelList property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelListType }
     *     
     */
    public void setHotelList(HotelListType value) {
        this.hotelList = value;
    }

}
