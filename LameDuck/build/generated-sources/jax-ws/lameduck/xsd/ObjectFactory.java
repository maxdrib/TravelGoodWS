
package lameduck.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lameduck.xsd package. 
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
    private final static QName _GetFlighRequest_QNAME = new QName("http://lameDuck/xsd.ws", "getFlighRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lameduck.xsd
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FlightInformationList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/xsd.ws", name = "getFlightsResponse")
    public JAXBElement<FlightInformationList> createGetFlightsResponse(FlightInformationList value) {
        return new JAXBElement<FlightInformationList>(_GetFlightsResponse_QNAME, FlightInformationList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lameDuck/xsd.ws", name = "getFlighRequest")
    public JAXBElement<Request> createGetFlighRequest(Request value) {
        return new JAXBElement<Request>(_GetFlighRequest_QNAME, Request.class, null, value);
    }

}
