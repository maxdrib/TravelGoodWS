package testHotels;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import ws.hotels.BookHotelFault;
import ws.hotels.BookHotelResponse;
import ws.hotels.CancelHotelFault;
import ws.hotels.GetHotelsRequest;
import ws.hotels.GetHotelsResponse;

/**
 *
 * @author xavi
 */
public class testHotels {
    
    @Test
    public void test1() throws DatatypeConfigurationException {
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar arrivalDate = df.newXMLGregorianCalendar("2015-09-17");
        XMLGregorianCalendar departureDate = df.newXMLGregorianCalendar("2015-09-18");
        GetHotelsRequest request = new GetHotelsRequest();
        request.setCity("City1");
        request.setArrivalDate(arrivalDate);
        request.setDepartureDate(departureDate);
        getHotels(request);
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
