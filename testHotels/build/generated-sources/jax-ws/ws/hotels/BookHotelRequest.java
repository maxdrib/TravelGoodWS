
package ws.hotels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditcard" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "bookingNumber",
    "creditcard"
})
@XmlRootElement(name = "bookHotelRequest")
public class BookHotelRequest {

    @XmlElement(required = true)
    protected String bookingNumber;
    @XmlElement(required = true)
    protected String creditcard;

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
     * Obtiene el valor de la propiedad creditcard.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditcard() {
        return creditcard;
    }

    /**
     * Define el valor de la propiedad creditcard.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditcard(String value) {
        this.creditcard = value;
    }

}
