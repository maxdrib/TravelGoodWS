
package ws.hotels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;


/**
 * <p>Clase Java para bookHotelRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="bookHotelRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditcardInformation" type="{http://types.fastmoney.imm.dtu.dk}creditCardInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookHotelRequestType", propOrder = {
    "bookingNumber",
    "creditcardInformation"
})
public class BookHotelRequestType {

    @XmlElement(required = true)
    protected String bookingNumber;
    protected CreditCardInfoType creditcardInformation;

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
     * Obtiene el valor de la propiedad creditcardInformation.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardInfoType }
     *     
     */
    public CreditCardInfoType getCreditcardInformation() {
        return creditcardInformation;
    }

    /**
     * Define el valor de la propiedad creditcardInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardInfoType }
     *     
     */
    public void setCreditcardInformation(CreditCardInfoType value) {
        this.creditcardInformation = value;
    }

}
