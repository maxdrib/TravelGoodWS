
package clientLameDuck.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para fligthInformation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
@XmlType(name = "fligthInformation", namespace = "http://lameDuck/xsd.ws", propOrder = {
    "flight",
    "bookingNumber",
    "price",
    "airlineReservationService"
})
public class FligthInformation {

    @XmlElement(namespace = "http://lameDuck/xsd.ws", required = true)
    protected Flight flight;
    @XmlElement(namespace = "http://lameDuck/xsd.ws", required = true)
    protected String bookingNumber;
    @XmlElement(namespace = "http://lameDuck/xsd.ws")
    protected float price;
    @XmlElement(namespace = "http://lameDuck/xsd.ws", required = true)
    protected String airlineReservationService;

    /**
     * Obtiene el valor de la propiedad flight.
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
     * Define el valor de la propiedad flight.
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
     * Obtiene el valor de la propiedad bookingNumber.
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
     * Define el valor de la propiedad bookingNumber.
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
     * Obtiene el valor de la propiedad price.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad airlineReservationService.
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
     * Define el valor de la propiedad airlineReservationService.
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
