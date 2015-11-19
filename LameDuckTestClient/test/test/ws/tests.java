/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws;

import clientLameDuck.ws.BookRequest;
import clientLameDuck.ws.CancelRequest;
import clientLameDuck.ws.CreditCardInfoType;
import clientLameDuck.ws.FlightInformationList;
import clientLameDuck.ws.GetBookingFault;
import clientLameDuck.ws.GetCancelFault;
import clientLameDuck.ws.Request;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Omar
 */
public class tests {
    
    public tests() {
    }

    @Test
    public void getFlightsTest() throws DatatypeConfigurationException {
        //GetFligthsRequest request = new GetFligthsRequest();
        Request request = new Request();
        XMLGregorianCalendar datetime = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-25");
        request.setDepartureDate(datetime);
        request.setDestination("Paris");
        request.setOrigin("DTU");
        FlightInformationList response = getFlights(request);
        String expected = "travelGood";
         assertEquals(expected, response.getFlightInformation().get(0).getAirlineReservationService());
        
    }
    
    @Test
    public void bookFlightTestFail() throws DatatypeConfigurationException {
        BookRequest request = new BookRequest();
        request.setBookingNumber("1234");
        // Credit card info
        CreditCardInfoType cc = new CreditCardInfoType();
        CreditCardInfoType.ExpirationDate exp = new CreditCardInfoType.ExpirationDate();
        exp.setMonth(9);
        exp.setYear(10);
        cc.setExpirationDate(exp);
        cc.setName("Tobiasen Inge");
        cc.setNumber("50408823");
        request.setCreditCardInfo(cc);
        
        
        try{
            boolean success = bookFlight(request);
            assertEquals(true, success);
            System.out.println("Success!");
        }catch (GetBookingFault ex){
            //ex.printStackTrace();
            //System.out.println(ex.getFaultInfo().getCreditCard().getExpirationDate().getMonth());
            String error = ex.getFaultInfo().getErrorMessage();
            System.out.println(error);
        }
    }
    
    
    @Test
    public void bookFlightTestSuccess() throws DatatypeConfigurationException {
        BookRequest request = new BookRequest();
        request.setBookingNumber("1234");
        // Credit card info
        CreditCardInfoType cc = new CreditCardInfoType();
        CreditCardInfoType.ExpirationDate exp = new CreditCardInfoType.ExpirationDate();
        exp.setMonth(2);
        exp.setYear(11);
        cc.setExpirationDate(exp);
        cc.setName("Tick Joachim");
        cc.setNumber("50408824");
        request.setCreditCardInfo(cc);
        
        
        try{
            boolean success = bookFlight(request);
            assertEquals(true, success);
            System.out.println("Success!");
        }catch (GetBookingFault ex){
            //ex.printStackTrace();
            //System.out.println(ex.getFaultInfo().getCreditCard().getExpirationDate().getMonth());
            String error = ex.getFaultInfo().getErrorMessage();
            System.out.println(error);
        }
    }
    @Test
    public void cancelFlightTest() throws DatatypeConfigurationException {
        CancelRequest request = new CancelRequest();
        request.setPrice(1000);
        request.setBookingNumber("1234");
        // Credit card info
        CreditCardInfoType cc = new CreditCardInfoType();
        CreditCardInfoType.ExpirationDate exp = new CreditCardInfoType.ExpirationDate();
        exp.setMonth(2);
        exp.setYear(11);
        cc.setExpirationDate(exp);
        cc.setName("Tick Joachim");
        cc.setNumber("50408824");
        request.setCreditCardInfo(cc);
        
        
        try{
            boolean success = cancelFlight(request);
            assertEquals(true, success);
            System.out.println("Cancel Success!");
        }catch (GetCancelFault ex){
            //ex.printStackTrace();
            //System.out.println(ex.getFaultInfo().getCreditCard().getExpirationDate().getMonth());
            System.out.println("Cancel Fault");
            String error = ex.getFaultInfo().getErrorMessage();
            System.out.println(error);
        }
    }

    private static FlightInformationList getFlights(clientLameDuck.ws.Request getFlightRequest) {
        clientLameDuck.ws.LameDuckWSService service = new clientLameDuck.ws.LameDuckWSService();
        clientLameDuck.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.getFlights(getFlightRequest);
    }

    private static boolean bookFlight(clientLameDuck.ws.BookRequest getBookRequest) throws GetBookingFault {
        clientLameDuck.ws.LameDuckWSService service = new clientLameDuck.ws.LameDuckWSService();
        clientLameDuck.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.bookFlight(getBookRequest);
    }

    private static boolean cancelFlight(clientLameDuck.ws.CancelRequest getCancelRequest) throws GetCancelFault {
        clientLameDuck.ws.LameDuckWSService service = new clientLameDuck.ws.LameDuckWSService();
        clientLameDuck.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.cancelFlight(getCancelRequest);
    }
}
