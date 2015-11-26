
package ws.hotels;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import schema.hotelws.HotelListType;


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

    private final static QName _GetHotelsRequest_QNAME = new QName("http://hotels.ws", "getHotelsRequest");
    private final static QName _GetHotelsResponse_QNAME = new QName("http://hotels.ws", "getHotelsResponse");
    private final static QName _BookHotelRequest_QNAME = new QName("http://hotels.ws", "bookHotelRequest");
    private final static QName _CancelHotelRequest_QNAME = new QName("http://hotels.ws", "cancelHotelRequest");
    private final static QName _BookHotelResponse_QNAME = new QName("http://hotels.ws", "bookHotelResponse");
    private final static QName _HotelFault_QNAME = new QName("http://hotels.ws", "hotelFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.hotels
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookHotelRequestType }
     * 
     */
    public BookHotelRequestType createBookHotelRequestType() {
        return new BookHotelRequestType();
    }

    /**
     * Create an instance of {@link GetHotelsRequestType }
     * 
     */
    public GetHotelsRequestType createGetHotelsRequestType() {
        return new GetHotelsRequestType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHotelsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "getHotelsRequest")
    public JAXBElement<GetHotelsRequestType> createGetHotelsRequest(GetHotelsRequestType value) {
        return new JAXBElement<GetHotelsRequestType>(_GetHotelsRequest_QNAME, GetHotelsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HotelListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "getHotelsResponse")
    public JAXBElement<HotelListType> createGetHotelsResponse(HotelListType value) {
        return new JAXBElement<HotelListType>(_GetHotelsResponse_QNAME, HotelListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookHotelRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "bookHotelRequest")
    public JAXBElement<BookHotelRequestType> createBookHotelRequest(BookHotelRequestType value) {
        return new JAXBElement<BookHotelRequestType>(_BookHotelRequest_QNAME, BookHotelRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "cancelHotelRequest")
    public JAXBElement<String> createCancelHotelRequest(String value) {
        return new JAXBElement<String>(_CancelHotelRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "bookHotelResponse")
    public JAXBElement<Boolean> createBookHotelResponse(Boolean value) {
        return new JAXBElement<Boolean>(_BookHotelResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://hotels.ws", name = "hotelFault")
    public JAXBElement<String> createHotelFault(String value) {
        return new JAXBElement<String>(_HotelFault_QNAME, String.class, null, value);
    }

}
