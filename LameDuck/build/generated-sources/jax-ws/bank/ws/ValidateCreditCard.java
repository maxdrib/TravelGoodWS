
package bank.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para validateCreditCard complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="validateCreditCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="group" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creditCardInfo" type="{http://types.fastmoney.imm.dtu.dk}creditCardInfoType"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateCreditCard", propOrder = {
    "group",
    "creditCardInfo",
    "amount"
})
public class ValidateCreditCard {

    protected int group;
    @XmlElement(required = true)
    protected CreditCardInfoType creditCardInfo;
    protected int amount;

    /**
     * Obtiene el valor de la propiedad group.
     * 
     */
    public int getGroup() {
        return group;
    }

    /**
     * Define el valor de la propiedad group.
     * 
     */
    public void setGroup(int value) {
        this.group = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCardInfo.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardInfoType }
     *     
     */
    public CreditCardInfoType getCreditCardInfo() {
        return creditCardInfo;
    }

    /**
     * Define el valor de la propiedad creditCardInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardInfoType }
     *     
     */
    public void setCreditCardInfo(CreditCardInfoType value) {
        this.creditCardInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad amount.
     * 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Define el valor de la propiedad amount.
     * 
     */
    public void setAmount(int value) {
        this.amount = value;
    }

}
