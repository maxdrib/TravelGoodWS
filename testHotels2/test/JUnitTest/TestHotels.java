/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTest;

import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;
import test.BookHotelFault;
import test.BookHotelRequestType;
import test.CancelHotelFault;
import test.CreditCardInfoType;
import test.CreditCardInfoType.ExpirationDate;
import test.GetHotelsRequestType;
import test.HotelListType;
import test.HotelType;

/**
 *
 * @author Max
 */
public class TestHotels {
    @Test
    /* Attempts to fetch all hotels where city is Lyngby */
    /* Hotel list should contain 2 entries. */
    public void testGetHotels() throws DatatypeConfigurationException {
        // Set up the request
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar arrivalDate = df.newXMLGregorianCalendar("2015-09-17");
        XMLGregorianCalendar departureDate = df.newXMLGregorianCalendar("2015-09-18");
        GetHotelsRequestType request = new GetHotelsRequestType();
        request.setCity("Lyngby");
        request.setArrivalDate(arrivalDate);
        request.setDepartureDate(departureDate); // Call the operation
        HotelListType hotelList = getHotels(request);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        
        // Iterate through hotel list to see if hotels match request critera
        for (HotelType curr_hotel : list_of_hotels) {
            String city = curr_hotel.getAddress().split(",")[1];
            
            // Check to see if all matches really have an address in Lyngby
            assertEquals(city, "Lyngby");
        }
        
        // Check correct size of hotel list, should be two
        assertEquals( 2, list_of_hotels.size());
    }    
    
    @Test
    /* Attempts to fetch all hotels where city is Lyngby */
    /* Hotel list should contain 2 entries. */
    public void testGetHotelsEmpty() throws DatatypeConfigurationException {
        
        // Set up the request
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar arrivalDate = df.newXMLGregorianCalendar("2015-09-17");
        XMLGregorianCalendar departureDate = df.newXMLGregorianCalendar("2015-09-18");
        GetHotelsRequestType request = new GetHotelsRequestType();
        request.setCity("Barcelona");
        request.setArrivalDate(arrivalDate);
        request.setDepartureDate(departureDate);
        
        // Call the operation
        HotelListType hotelList = getHotels(request);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        
        // Iterate through hotel list to see if hotels match request critera
        for (HotelType curr_hotel : list_of_hotels) {
            String city = curr_hotel.getAddress().split(",")[1];
            
            // Check to see if all matches really have an address in Lyngby
            assertEquals(city, "Barcelona");
        }
        
        // Check correct size of hotel list, should be two
        assertEquals( 0, list_of_hotels.size());
    }
    @Test
    /* Attempt a basic booking for a hotel that requires no CC guarantee */
    /* Status should return true. */
    public void testBookingNoCreditCard() throws BookHotelFault, CancelHotelFault {
        BookHotelRequestType request = new BookHotelRequestType();
        request.setBookingNumber("3");
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(2);
        exp_date.setYear(11);
        cc.setExpirationDate(exp_date);
        cc.setNumber("50408824");
        cc.setName("Tick Joachim");
        request.setCreditcardInformation(cc);
        boolean resp = bookHotel(request);
        assertEquals(resp, true);
        
        // RESET
        String reset_booking_num = "3";
        cancelHotel(reset_booking_num);
        
    }
    
    @Test
    /* Attempts to book a hotel with made up CC info */
    /* Should throw BookHotelFault */
    public void testHotelBookingFakeCC() throws BookHotelFault {
        BookHotelRequestType request = new BookHotelRequestType();
        request.setBookingNumber("5");
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(8);
        exp_date.setYear(12);
        cc.setExpirationDate(exp_date);
        cc.setNumber("98765321");
        cc.setName("Anne Strandberg");
        request.setCreditcardInformation(cc);
        boolean thrown = false;
        try {
            boolean resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
                
        System.out.println("Fake CC. Is hotelList empty? ");
        GetHotelsRequestType hotel5 = new GetHotelsRequestType();
        hotel5.setCity("Paris");
        HotelListType hotelList = getHotels(hotel5);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        System.out.println(list_of_hotels.isEmpty());
    }

    @Test
    /* Attempts to book a hotel requiring a CC using an improperly formatted */
    /* Number */
    public void testHotelBookingIncorrectCC() throws BookHotelFault {
        BookHotelRequestType request = new BookHotelRequestType();
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(5);
        exp_date.setYear(9);
        cc.setExpirationDate(exp_date);
        cc.setNumber("5068816");
        cc.setName("Anne Strandberg");
        request.setCreditcardInformation(cc);
        request.setBookingNumber("5");
        boolean thrown = false;
        try {
            boolean resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
        
                
        System.out.println("Incorrect CC. Is hotel booked? ");
        GetHotelsRequestType hotel5 = new GetHotelsRequestType();
        hotel5.setCity("Paris");
        HotelListType hotelList = getHotels(hotel5);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        System.out.println(list_of_hotels.isEmpty());
    }
    
    @Test
    /* Attempts to book a hotel using a CC with small Credit limit */
    /* Should throw a BookHotelFault */
    public void testHotelBookingCreditLimitReached() throws BookHotelFault {
        BookHotelRequestType request = new BookHotelRequestType();
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(7);
        exp_date.setYear(9);
        cc.setExpirationDate(exp_date);
        cc.setNumber("50408822");
        cc.setName("Bech Camilla");
        request.setCreditcardInformation(cc);
        request.setBookingNumber("5");
        //CC limit is 1000 but hotel costs $1001  
        boolean thrown = false;
        try {
            boolean resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
        
        
        System.out.println("CC Limit Reached. Is hotel booked? ");
        GetHotelsRequestType hotel5 = new GetHotelsRequestType();
        hotel5.setCity("Paris");
        HotelListType hotelList = getHotels(hotel5);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        System.out.println(list_of_hotels.isEmpty());
    }
    
    @Test
    /* Books a hotel, passes if the response is true */
    public void testHotelBookingSuccess() throws BookHotelFault {
        BookHotelRequestType request = new BookHotelRequestType();
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(2);
        exp_date.setYear(11);
        cc.setExpirationDate(exp_date);
        cc.setNumber("50408824");
        cc.setName("Tick Joachim");
        request.setCreditcardInformation(cc);
        request.setBookingNumber("5");
        boolean resp = bookHotel(request);
        
        // Successfully booked hotel
        assertEquals(resp, true);
        
                
        System.out.println("bookingSuccess. Is hotel5 booked? ");
        GetHotelsRequestType hotel5 = new GetHotelsRequestType();
        hotel5.setCity("Paris");
        HotelListType hotelList = getHotels(hotel5);
        List<HotelType> list_of_hotels = hotelList.getHotel();
        System.out.println(list_of_hotels.isEmpty());
        
    }    
    
    @Test
    /* Attempts to book same hotel as previous test, should fail */
    public void testHotelBookingFailure() throws BookHotelFault, CancelHotelFault {        
        // Try booking again, should fail
        BookHotelRequestType request2 = new BookHotelRequestType();
        CreditCardInfoType cc = new CreditCardInfoType();
        ExpirationDate exp_date = new ExpirationDate();
        exp_date.setMonth(5);
        exp_date.setYear(9);
        cc.setExpirationDate(exp_date);
        cc.setNumber("50408825");
        cc.setName("Thor-Jensen Claus");
        request2.setCreditcardInformation(cc);
        request2.setBookingNumber("5");
        boolean thrown = false;
        try {
            boolean resp2 = bookHotel(request2);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        
        // Successfully threw exception
        assertEquals(thrown, true);
        
        // RESET
        String request3 = "5";
        cancelHotel(request3);
    }
    
    
    private static boolean bookHotel(test.BookHotelRequestType bookHotelRequest) throws BookHotelFault {
        test.HotelsWSDLService service = new test.HotelsWSDLService();
        test.HotelsPort port = service.getHotelsPort();
        return port.bookHotel(bookHotelRequest);
    }

    private static void cancelHotel(java.lang.String bookingNumber) throws CancelHotelFault {
        test.HotelsWSDLService service = new test.HotelsWSDLService();
        test.HotelsPort port = service.getHotelsPort();
        port.cancelHotel(bookingNumber);
    }

    private static HotelListType getHotels(test.GetHotelsRequestType getHotelsRequest) {
        test.HotelsWSDLService service = new test.HotelsWSDLService();
        test.HotelsPort port = service.getHotelsPort();
        return port.getHotels(getHotelsRequest);
    }
    
}
