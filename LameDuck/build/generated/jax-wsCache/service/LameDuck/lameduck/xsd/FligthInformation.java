
package lameduck.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fligthInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fligthInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flight" type="{http://lameDuck/xsd.ws}flight"/>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="airlineReservationService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fligthInformation", propOrder = {
    "flight",
    "bookingNumber",
    "price",
    "airlineReservationService"
})
public class FligthInformation {

    @XmlElement(required = true)
    protected Flight flight;
    @XmlElement(required = true)
    protected String bookingNumber;
    protected float price;
    @XmlElement(required = true)
    protected String airlineReservationService;

    /**
     * Gets the value of the flight property.
     * 
     * @return
     *     possible object is
     *     {@link Flight }
     *     
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Sets the value of the flight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flight }
     *     
     */
    public void setFlight(Flight value) {
        this.flight = value;
    }

    /**
     * Gets the value of the bookingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Sets the value of the bookingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingNumber(String value) {
        this.bookingNumber = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Gets the value of the airlineReservationService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirlineReservationService() {
        return airlineReservationService;
    }

    /**
     * Sets the value of the airlineReservationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirlineReservationService(String value) {
        this.airlineReservationService = value;
    }

}
