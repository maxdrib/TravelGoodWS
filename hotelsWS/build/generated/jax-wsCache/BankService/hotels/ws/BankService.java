
package hotels.ws;

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
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankService", targetNamespace = "urn://fastmoney.imm.dtu.dk", wsdlLocation = "http://fastmoney.imm.dtu.dk:8080/BankService?wsdl")
public class BankService
    extends Service
{

    private final static URL BANKSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKSERVICE_EXCEPTION;
    private final static QName BANKSERVICE_QNAME = new QName("urn://fastmoney.imm.dtu.dk", "BankService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://fastmoney.imm.dtu.dk:8080/BankService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKSERVICE_WSDL_LOCATION = url;
        BANKSERVICE_EXCEPTION = e;
    }

    public BankService() {
        super(__getWsdlLocation(), BANKSERVICE_QNAME);
    }

    public BankService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKSERVICE_QNAME, features);
    }

    public BankService(URL wsdlLocation) {
        super(wsdlLocation, BANKSERVICE_QNAME);
    }

    public BankService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKSERVICE_QNAME, features);
    }

    public BankService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BankPortType
     */
    @WebEndpoint(name = "BankPort")
    public BankPortType getBankPort() {
        return super.getPort(new QName("urn://fastmoney.imm.dtu.dk", "BankPort"), BankPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankPortType
     */
    @WebEndpoint(name = "BankPort")
    public BankPortType getBankPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn://fastmoney.imm.dtu.dk", "BankPort"), BankPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKSERVICE_EXCEPTION!= null) {
            throw BANKSERVICE_EXCEPTION;
        }
        return BANKSERVICE_WSDL_LOCATION;
    }

}
