/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ld.test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import ld.ws.FlightInformationList;
import ld.ws.GetFligthsRequest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ernestbofill
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() throws DatatypeConfigurationException {
        GetFligthsRequest request = new GetFligthsRequest();
        XMLGregorianCalendar datetime = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-25");
        request.setDepartureDate(datetime);
        request.setDestination("Paris");
        request.setOrigin("DTU");
        FlightInformationList response = getFlights(request);
        String expected = "lameduck";
         assertEquals(expected, response.getNewElement().get(0).getAirlineReservationService());
     }

    private static FlightInformationList getFlights(ld.ws.GetFligthsRequest getFlightsRequest) {
        ld.ws.LameduckWsService service = new ld.ws.LameduckWsService();
        ld.ws.LameduckWsPortType port = service.getLameduckWsPortTypeBindingPort();
        return port.getFlights(getFlightsRequest);
    }
}
