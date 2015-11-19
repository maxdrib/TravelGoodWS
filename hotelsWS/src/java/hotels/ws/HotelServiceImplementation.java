/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotels.ws;

import javax.jws.WebService;
import ws.hotels.BookHotelFault;
import ws.hotels.CancelHotelFault;

/**
 *
 * @author ernestbofill
 */
@WebService(serviceName = "hotelsService", portName = "hotelsPort", endpointInterface = "ws.hotels.HotelsPort", targetNamespace = "http://hotels.ws", wsdlLocation = "WEB-INF/wsdl/HotelServiceImplementation/hotelsWSDLWrapper.wsdl")
public class HotelServiceImplementation {

    public schema.hotelws.HotelListType getHotels(ws.hotels.GetHotelsRequestType getHotelsRequest) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean bookHotel(ws.hotels.BookHotelRequestType bookHotelRequest) throws BookHotelFault {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void cancelHotel(java.lang.String bookingNumber) throws CancelHotelFault {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
