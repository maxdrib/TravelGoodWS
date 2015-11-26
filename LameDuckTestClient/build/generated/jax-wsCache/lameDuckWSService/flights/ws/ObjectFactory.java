
package flights.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the flights.ws package. 
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

    private final static QName _GetFlightsResponse_QNAME = new QName("http://lameDuck/xsd.ws", "getFlightsResponse");
    private final static QName _StatusCancel_QNAME = new QName("http://lameDuck/web", "statusCancel");
    private final static QName _GetCancelRequest_QNAME = new QName("http://lameDuck/web", "getCancelRequest");
    private final static QName _CancelFault_QNAME = new QName("http://lameDuck/web", "cancelFault");
    private final static QName _GetFlighRequest_QNAME = new QName("http://lameDuck/xsd.ws", "getFlighRequest");
    private final static QName _Status_QNAME = new QName("http://lameDuck/web", "status");
    private final static QName _BookFault_QNAME = new QName("http://lameDuck/web", "bookFault");
    private final static QName _GetBookRequest_QNAME = new QName("http://lameDuck/web", "getBookRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: flights.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCardInfoType }
     * 
     */
    public CreditCardInfoType createCreditCardInfoType() {
        return new CreditCardInfoType();
    }

    /**
     * Create an instance of {@link CancelFaultType }
     * 
     */
    public CancelFaultType createCancelFaultType() {
        return new CancelFaultType();
    }

    /**
     * Create an instance of {@link CancelRequest }
     * 
     */
    public CancelRequest createCancelRequest() {
        return new CancelRequest();
    }

    /**
     * Create an instance of {@link BookRequest }
     * 
     */
    public BookRequest createBookRequest() {
        return new BookRequest();
    }

    /**
     * Create an instance of {@link BookFaultType }
     * 
     */
    public BookFaultType createBookFaultType() {
        return new BookFaultType();
    }

    /**
     * Create an instance of {@link FlightInformationList }
     * 
     */
    public FlightInformationList createFlightInformationList() {
        return new FlightInformationList();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link FligthInformation }
     * 
     */
    public FligthInformation createFligthInformation() {
        return new FligthInformation();
    }

    /**
     * Create an instance of {@link AccountType }
     * 
     */
    public AccountType createAccountType() {
        return new AccountType();
    }

    /**
     * Create an instance of {@link CreditCardInfoType.ExpirationDate }
     * 
     */
    public CreditCardInfoType.ExpirationDate createCreditCardInfoTypeExpirationDate() {
        return new CreditCardInfoType.ExpirationDate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightInformationList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/xsd.ws", name = "getFlightsResponse")
    public JAXBElement<FlightInformationList> createGetFlightsResponse(FlightInformationList value) {
        return new JAXBElement<FlightInformationList>(_GetFlightsResponse_QNAME, FlightInformationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "statusCancel")
    public JAXBElement<Boolean> createStatusCancel(Boolean value) {
        return new JAXBElement<Boolean>(_StatusCancel_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "getCancelRequest")
    public JAXBElement<CancelRequest> createGetCancelRequest(CancelRequest value) {
        return new JAXBElement<CancelRequest>(_GetCancelRequest_QNAME, CancelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "cancelFault")
    public JAXBElement<CancelFaultType> createCancelFault(CancelFaultType value) {
        return new JAXBElement<CancelFaultType>(_CancelFault_QNAME, CancelFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/xsd.ws", name = "getFlighRequest")
    public JAXBElement<Request> createGetFlighRequest(Request value) {
        return new JAXBElement<Request>(_GetFlighRequest_QNAME, Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "status")
    public JAXBElement<Boolean> createStatus(Boolean value) {
        return new JAXBElement<Boolean>(_Status_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "bookFault")
    public JAXBElement<BookFaultType> createBookFault(BookFaultType value) {
        return new JAXBElement<BookFaultType>(_BookFault_QNAME, BookFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/web", name = "getBookRequest")
    public JAXBElement<BookRequest> createGetBookRequest(BookRequest value) {
        return new JAXBElement<BookRequest>(_GetBookRequest_QNAME, BookRequest.class, null, value);
    }

}
