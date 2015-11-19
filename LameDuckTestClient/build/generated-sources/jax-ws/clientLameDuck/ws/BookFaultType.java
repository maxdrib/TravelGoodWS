
package clientLameDuck.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para bookFaultType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="bookFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="creditCard" type="{http://types.fastmoney.imm.dtu.dk}creditCardInfoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookFaultType", propOrder = {
    "errorMessage",
    "creditCard"
})
public class BookFaultType {

    @XmlElement(required = true)
    protected String errorMessage;
    @XmlElement(required = true)
    protected CreditCardInfoType creditCard;

    /**
     * Obtiene el valor de la propiedad errorMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Define el valor de la propiedad errorMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCard.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardInfoType }
     *     
     */
    public CreditCardInfoType getCreditCard() {
        return creditCard;
    }

    /**
     * Define el valor de la propiedad creditCard.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardInfoType }
     *     
     */
    public void setCreditCard(CreditCardInfoType value) {
        this.creditCard = value;
    }

}
