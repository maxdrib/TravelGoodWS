
package ws.hotels;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.hotels package. 
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

    private final static QName _HotelList_QNAME = new QName("http://hotels.ws", "hotelList");
    private final static QName _Fault_QNAME = new QName("http://hotels.ws", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.hotels
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
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link BookHotelResponse }
     * 
     */
    public BookHotelResponse createBookHotelResponse() {
        return new BookHotelResponse();
    }

    /**
     * Create an instance of {@link HotelType }
     * 
     */
    public HotelType createHotelType() {
        return new HotelType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "hotelList")
    public JAXBElement<HotelListType> createHotelList(HotelListType value) {
        return new JAXBElement<HotelListType>(_HotelList_QNAME, HotelListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "fault")
    public JAXBElement<ErrorType> createFault(ErrorType value) {
        return new JAXBElement<ErrorType>(_Fault_QNAME, ErrorType.class, null, value);
    }

}
