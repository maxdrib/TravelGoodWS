/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ld.ws;

import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.j2ee.wsdl.lameduckws.java.lameduck_ws.*;

/**
 *
 * @author ernestbofill
 */
@WebService(serviceName = "lameduck_wsService", portName = "lameduck_wsPortTypeBindingPort", endpointInterface = "org.netbeans.j2ee.wsdl.lameduckws.java.lameduck_ws.LameduckWsPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/LameDuckWS/java/lameduck_ws", wsdlLocation = "WEB-INF/wsdl/LameDuckWS_Implementation/lameduck_ws.wsdl")
public class LameDuckWS_Implementation {
    
    public static FlightInformationList flightInfoList;
    
    public LameDuckWS_Implementation() throws DatatypeConfigurationException {
        flightInfoList = new FlightInformationList();
        List<FligthInformation> list = flightInfoList.getNewElement();
        FligthInformation fi1 = new FligthInformation();
        Flight f1 = new Flight();
        XMLGregorianCalendar datetime = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-25");
        datetime.setTime(11, 11, 11);
        f1.setArrivalDateTime(datetime);
        f1.setCarrier("Air Canada");
        f1.setOrigin("Denmark");
        f1.setDestination("Mexico");
        
        fi1.setAirlineReservationService("lameduck");
        fi1.setBookingNumber("book1");
        fi1.setPrice((float) 10.20);
        fi1.setFlight(f1);
        list.add(fi1);
    }

    public org.netbeans.j2ee.wsdl.lameduckws.java.lameduck_ws.FlightInformationList getFlights(org.netbeans.j2ee.wsdl.lameduckws.java.lameduck_ws.GetFligthsRequest getFlightsRequest) {
        return flightInfoList;
    }
    
}
