package hotels.ws;

import java.util.ArrayList;
import javax.jws.WebService;
import ws.hotels.BookHotelFault;
import ws.hotels.CancelHotelFault;
import ws.hotels.GetHotelsResponse;
import ws.hotels.HotelListType;
import ws.hotels.HotelType;

/**
 *
 * @author xavi&max
 */
@WebService(serviceName = "hotelsWSDLService", portName = "hotelsWSDLPort", endpointInterface = "ws.hotels.HotelsWSDLPortType", targetNamespace = "http://hotels.ws", wsdlLocation = "WEB-INF/wsdl/hotelsWS/hotelsWSDL.wsdl")
public class hotelsWS {

    private static ArrayList<HotelType> hotels;
    
    public hotelsWS() {
        hotels = new ArrayList<HotelType>();
        HotelType hotel = new HotelType();
        hotel.setName("Hotel1");
        hotel.setAddress("C/hojskolevej");
        hotel.setBookingNumber("2564864");
        hotel.setCreditcardGuarantee(false);
        hotel.setServiceName("Service1");
        hotel.setTotalPrice(25.56f);
        hotels.add(hotel);
    }
    
    public ws.hotels.GetHotelsResponse getHotels(ws.hotels.GetHotelsRequest getHotelsRequest) {
        GetHotelsResponse response = new GetHotelsResponse();
        HotelListType hotelList = new HotelListType();
        for (int i = 0; i < hotels.size(); ++i) {
            hotelList.getHotel().add(hotels.get(i));
        }
        response.setHotelList(hotelList);
        return response;
    }

    public ws.hotels.BookHotelResponse bookHotel(ws.hotels.BookHotelRequest bookHotelRequest) throws BookHotelFault {
        
    }
    
    public void cancelHotel(ws.hotels.CancelHotelRequest cancelHotelRequest) throws CancelHotelFault {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
