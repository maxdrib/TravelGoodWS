package testHotels;

import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ws.hotels.BookHotelFault;
import ws.hotels.BookHotelRequest;
import ws.hotels.BookHotelResponse;
import ws.hotels.CancelHotelFault;
import ws.hotels.CancelHotelRequest;
import ws.hotels.GetHotelsRequest;
import ws.hotels.GetHotelsResponse;
import ws.hotels.HotelListType;
import ws.hotels.HotelType;

/**
 *
 * @author xavi
 */
public class testHotels {
    
    @Test
    /* Attempts to fetch all hotels where city is Lyngby */
    /* Hotel list should contain 2 entries. */
    public void testGetHotels() throws DatatypeConfigurationException {
        
        // Set up the request
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar arrivalDate = df.newXMLGregorianCalendar("2015-09-17");
        XMLGregorianCalendar departureDate = df.newXMLGregorianCalendar("2015-09-18");
        GetHotelsRequest request = new GetHotelsRequest();
        request.setCity("Lyngby");
        request.setArrivalDate(arrivalDate);
        request.setDepartureDate(departureDate);
        
        // Call the operation
        GetHotelsResponse response = getHotels(request);
        HotelListType hotelList = response.getHotelList();
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
    /* Attempt a basic booking for a hotel that requires no CC guarantee */
    /* Status should return true. */
    public void testBookingNoCreditCard() throws BookHotelFault, CancelHotelFault {
        BookHotelRequest request = new BookHotelRequest();
        request.setBookingNumber("3");
        request.setCreditcard("Tick Joachim(CC Guarantee false),50408824,2,11");
        BookHotelResponse resp = bookHotel(request);
        assertEquals(resp.isStatus(), true);
        
        // RESET
        CancelHotelRequest reset = new CancelHotelRequest();
        reset.setBookingNumber("3");
        cancelHotel(reset);
        
    }
    
    @Test
    /* Attempts to book a hotel with made up CC info */
    /* Should throw BookHotelFault */
    public void testHotelBookingFakeCC() throws BookHotelFault {
        BookHotelRequest request = new BookHotelRequest();
        request.setBookingNumber("5");
        request.setCreditcard("Anne Strandberg(fake CC),98765321,8,12"); //CC# is made up
        boolean thrown = false;
        try {
            BookHotelResponse resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
    }
        
    @Test
    /* Attempts to book a hotel requiring a CC using an improperly formatted */
    /* Number */
    public void testHotelBookingIncorrectCC() throws BookHotelFault {
        BookHotelRequest request = new BookHotelRequest();
        request.setBookingNumber("5");
        request.setCreditcard("Anne Strandberg(mistyped CC),5068816,5,9");   //CC number is too short
        boolean thrown = false;
        try {
            BookHotelResponse resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
    }
          
    @Test
    /* Attempts to book a hotel using a CC with credit limit 0 */
    /* Should throw a BookHotelFault */
    public void testHotelBookingCreditLimit0() throws BookHotelFault {
        BookHotelRequest request = new BookHotelRequest();
        request.setBookingNumber("5");
        request.setCreditcard("Klinkby Poul(CC Limit 0),50408817,3,10");   //CC limit is 0
        boolean thrown = false;
        try {
            BookHotelResponse resp = bookHotel(request);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        assertEquals(thrown, true);
    }
        
    @Test
    /* Books a hotel, passes if the response is true */
    public void testHotelBookingSuccess() throws BookHotelFault {
        BookHotelRequest request = new BookHotelRequest();
        request.setBookingNumber("5");
        request.setCreditcard("Tick Joachim,50408824,2,11");
        BookHotelResponse resp = bookHotel(request);
        
        // Successfully booked hotel
        assertEquals(resp.isStatus(), true);
    }    
    
    @Test
    /* Attempts to book same hotel as previous test, should fail */
    public void testHotelBookingFailure() throws BookHotelFault, CancelHotelFault {        
        // Try booking again, should fail
        BookHotelRequest request2 = new BookHotelRequest();
        request2.setBookingNumber("5");
        request2.setCreditcard("Thor-Jensen Claus,50408825,5,9");
        boolean thrown = false;
        try {
            BookHotelResponse resp2 = bookHotel(request2);
        } catch (BookHotelFault f) {
            thrown = true;
        }
        
        // Successfully threw exception
        assertEquals(thrown, true);
        
        // RESET
        CancelHotelRequest request3 = new CancelHotelRequest();
        request3.setBookingNumber("5");
        cancelHotel(request3);
    }
    
    @Test
    /* Cancels a booked hotel, then re-books it */
    public void testCancelBookingSuccess() throws CancelHotelFault, BookHotelFault {
        // Cancel booked hotel
        CancelHotelRequest request = new CancelHotelRequest();
        request.setBookingNumber("4");
        cancelHotel(request);
        
        // Rebook the same hotel
        BookHotelRequest request2 = new BookHotelRequest();
        request2.setBookingNumber("4");
        request2.setCreditcard("Thor-Jensen Claus,50408825,5,9");
        BookHotelResponse resp2 = bookHotel(request2);
        assertEquals(resp2.isStatus(), true);
        
    }

    private static GetHotelsResponse getHotels(ws.hotels.GetHotelsRequest getHotelsRequest) {
        ws.hotels.HotelsWSDLService service = new ws.hotels.HotelsWSDLService();
        ws.hotels.HotelsWSDLPortType port = service.getHotelsWSDLPort();
        return port.getHotels(getHotelsRequest);
    }

    private static BookHotelResponse bookHotel(ws.hotels.BookHotelRequest bookHotelRequest) throws BookHotelFault {
        ws.hotels.HotelsWSDLService service = new ws.hotels.HotelsWSDLService();
        ws.hotels.HotelsWSDLPortType port = service.getHotelsWSDLPort();
        return port.bookHotel(bookHotelRequest);
    }

    private static void cancelHotel(ws.hotels.CancelHotelRequest cancelHotelRequest) throws CancelHotelFault {
        ws.hotels.HotelsWSDLService service = new ws.hotels.HotelsWSDLService();
        ws.hotels.HotelsWSDLPortType port = service.getHotelsWSDLPort();
        port.cancelHotel(cancelHotelRequest);
    }
}
