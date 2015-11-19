
package clientLameDuck.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "lameDuckWSService", targetNamespace = "http://lameDuck/web", wsdlLocation = "http://omarsillo-pc:8080/LameDuck/lameDuckWSService?wsdl")
public class LameDuckWSService
    extends Service
{

    private final static URL LAMEDUCKWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException LAMEDUCKWSSERVICE_EXCEPTION;
    private final static QName LAMEDUCKWSSERVICE_QNAME = new QName("http://lameDuck/web", "lameDuckWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://omarsillo-pc:8080/LameDuck/lameDuckWSService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        LAMEDUCKWSSERVICE_WSDL_LOCATION = url;
        LAMEDUCKWSSERVICE_EXCEPTION = e;
    }

    public LameDuckWSService() {
        super(__getWsdlLocation(), LAMEDUCKWSSERVICE_QNAME);
    }

    public LameDuckWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), LAMEDUCKWSSERVICE_QNAME, features);
    }

    public LameDuckWSService(URL wsdlLocation) {
        super(wsdlLocation, LAMEDUCKWSSERVICE_QNAME);
    }

    public LameDuckWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, LAMEDUCKWSSERVICE_QNAME, features);
    }

    public LameDuckWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LameDuckWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns LameDuckWSPortType
     */
    @WebEndpoint(name = "lameDuckWSPortTypeBindingPort")
    public LameDuckWSPortType getLameDuckWSPortTypeBindingPort() {
        return super.getPort(new QName("http://lameDuck/web", "lameDuckWSPortTypeBindingPort"), LameDuckWSPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LameDuckWSPortType
     */
    @WebEndpoint(name = "lameDuckWSPortTypeBindingPort")
    public LameDuckWSPortType getLameDuckWSPortTypeBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://lameDuck/web", "lameDuckWSPortTypeBindingPort"), LameDuckWSPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (LAMEDUCKWSSERVICE_EXCEPTION!= null) {
            throw LAMEDUCKWSSERVICE_EXCEPTION;
        }
        return LAMEDUCKWSSERVICE_WSDL_LOCATION;
    }

}
