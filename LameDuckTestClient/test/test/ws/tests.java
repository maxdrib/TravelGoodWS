/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ws;

import flights.ws.BookRequest;
import flights.ws.CreditCardInfoType;
import flights.ws.FlightInformationList;
import flights.ws.GetBookingFault;
import flights.ws.GetCancelFault;
import flights.ws.Request;
import flights.ws.CancelRequest;
import flights.ws.FlightInformationList;
import flights.ws.GetBookingFault;
import flights.ws.GetCancelFault;
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
    
    // In the web service implementation the price of the only flight is 
    // 5000.1
    
    @Test
    public void bookFlightTestFail() throws DatatypeConfigurationException {
        BookRequest request = new BookRequest();
        request.setBookingNumber("1234");
        // Credit card info
        CreditCardInfoType cc = new CreditCardInfoType();
        CreditCardInfoType.ExpirationDate exp = new CreditCardInfoType.ExpirationDate();
        exp.setMonth(9);                // Valid Month
        exp.setYear(10);                // Valid Year
        cc.setExpirationDate(exp);
        cc.setName("Tobiasen Inge");    // Only 1000 in his account, it will fail
        cc.setNumber("50408823");       // This is his valid CC
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
        cc.setName("Tick Joachim");     // He has 10000 more than enough to pay the 5000.1
        cc.setNumber("50408824");
        request.setCreditCardInfo(cc);
        
        
        try{
            boolean success = bookFlight(request);
            assertEquals(true, success);
            System.out.println("Successful booking!");
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
        request.setPrice(1000); // How much is the flight worth? We will receive back only half of it
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

    private static boolean bookFlight(flights.ws.BookRequest getBookRequest) throws GetBookingFault {
        flights.ws.LameDuckWSService service = new flights.ws.LameDuckWSService();
        flights.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.bookFlight(getBookRequest);
    }

    private static boolean cancelFlight(flights.ws.CancelRequest getCancelRequest) throws GetCancelFault {
        flights.ws.LameDuckWSService service = new flights.ws.LameDuckWSService();
        flights.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.cancelFlight(getCancelRequest);
    }

    private static FlightInformationList getFlights(flights.ws.Request getFlightRequest) {
        flights.ws.LameDuckWSService service = new flights.ws.LameDuckWSService();
        flights.ws.LameDuckWSPortType port = service.getLameDuckWSPortTypeBindingPort();
        return port.getFlights(getFlightRequest);
    }

}
