
package ws.hotels;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para hotelType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="hotelType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="totalPrice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="creditcardGuarantee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelType", propOrder = {
    "name",
    "address",
    "bookingNumber",
    "totalPrice",
    "creditcardGuarantee",
    "serviceName"
})
public class HotelType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected String bookingNumber;
    protected float totalPrice;
    protected boolean creditcardGuarantee;
    @XmlElement(required = true)
    protected String serviceName;

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
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
     * Obtiene el valor de la propiedad totalPrice.
     * 
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * Define el valor de la propiedad totalPrice.
     * 
     */
    public void setTotalPrice(float value) {
        this.totalPrice = value;
    }

    /**
     * Obtiene el valor de la propiedad creditcardGuarantee.
     * 
     */
    public boolean isCreditcardGuarantee() {
        return creditcardGuarantee;
    }

    /**
     * Define el valor de la propiedad creditcardGuarantee.
     * 
     */
    public void setCreditcardGuarantee(boolean value) {
        this.creditcardGuarantee = value;
    }

    /**
     * Obtiene el valor de la propiedad serviceName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Define el valor de la propiedad serviceName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

}
