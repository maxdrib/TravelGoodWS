
package xmlschema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xmlschema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FaultMessage_QNAME = new QName("http://XMLSchema", "message");
    private final static QName _FaultHotel_QNAME = new QName("http://XMLSchema", "hotel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xmlschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHotelsResponse }
     * 
     */
    public GetHotelsResponse createGetHotelsResponse() {
        return new GetHotelsResponse();
    }

    /**
     * Create an instance of {@link HotelListType }
     * 
     */
    public HotelListType createHotelListType() {
        return new HotelListType();
    }

    /**
     * Create an instance of {@link BookHotelRequest }
     * 
     */
    public BookHotelRequest createBookHotelRequest() {
        return new BookHotelRequest();
    }

    /**
     * Create an instance of {@link GetHotelsRequest }
     * 
     */
    public GetHotelsRequest createGetHotelsRequest() {
        return new GetHotelsRequest();
    }

    /**
     * Create an instance of {@link CancelHotelRequest }
     * 
     */
    public CancelHotelRequest createCancelHotelRequest() {
        return new CancelHotelRequest();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link HotelType }
     * 
     */
    public HotelType createHotelType() {
        return new HotelType();
    }

    /**
     * Create an instance of {@link BookHotelResponse }
     * 
     */
    public BookHotelResponse createBookHotelResponse() {
        return new BookHotelResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://XMLSchema", name = "message", scope = Fault.class)
    public JAXBElement<String> createFaultMessage(String value) {
        return new JAXBElement<String>(_FaultMessage_QNAME, String.class, Fault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://XMLSchema", name = "hotel", scope = Fault.class)
    public JAXBElement<HotelType> createFaultHotel(HotelType value) {
        return new JAXBElement<HotelType>(_FaultHotel_QNAME, HotelType.class, Fault.class, value);
    }

}
