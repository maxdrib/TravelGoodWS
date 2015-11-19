/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotels.ws;

import dk.dtu.imm.fastmoney.BankService;
import dk.dtu.imm.fastmoney.CreditCardFaultMessage;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import schema.hotelws.HotelListType;
import schema.hotelws.HotelType;
import ws.hotels.BookHotelFault;
import ws.hotels.CancelHotelFault;

/**
 *
 * @author ernestbofill
 */
@WebService(serviceName = "hotelsWSDLService", portName = "hotelsPort", endpointInterface = "ws.hotels.HotelsPort", targetNamespace = "http://hotels.ws", wsdlLocation = "WEB-INF/wsdl/HotelWebService/hotelsWSDL.wsdl")
public class HotelWebService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/fastmoney.imm.dtu.dk_8080/BankService.wsdl")
    private BankService service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/fastmoney.imm.dtu.dk_8080/BankService.wsdl")

    private static ArrayList<HotelType> unbooked_hotels;
    private static ArrayList<HotelType> booked_hotels;
    
    public HotelWebService() {
        
        /* UNBOOKED HOTELS */
        unbooked_hotels = new ArrayList<>();
        HotelType hotel1 = new HotelType();
        hotel1.setName("Hotel1");
        hotel1.setAddress("C/hojskolevej,Lyngby");
        hotel1.setBookingNumber("1");
        hotel1.setCreditcardGuarantee(true);
        hotel1.setServiceName("Service1");
        hotel1.setTotalPrice(12);
        unbooked_hotels.add(hotel1);
     
        HotelType hotel5 = new HotelType();
        hotel5.setName("Hotel5");
        hotel5.setAddress("234 Monseur,Paris");
        hotel5.setBookingNumber("5");
        hotel5.setCreditcardGuarantee(true);
        hotel5.setServiceName("Service4");
        hotel5.setTotalPrice(1002);
        unbooked_hotels.add(hotel5);
        
        HotelType hotel2 = new HotelType();
        hotel2.setName("Hotel2");
        hotel2.setAddress("210 Lundtoftevej,Lyngby");
        hotel2.setBookingNumber("2");
        hotel2.setCreditcardGuarantee(true);
        hotel2.setServiceName("Service1");
        hotel2.setTotalPrice(12);
        unbooked_hotels.add(hotel2);  
        
        HotelType hotel3 = new HotelType();
        hotel3.setName("Hotel3");
        hotel3.setAddress("221 Durham Ct,Naperville");
        hotel3.setBookingNumber("3");
        hotel3.setCreditcardGuarantee(false);
        hotel3.setServiceName("Service2");
        hotel3.setTotalPrice(12);
        unbooked_hotels.add(hotel3);
        
        /* BOOKED HOTELS */
        booked_hotels = new ArrayList<>();
        HotelType hotel4 = new HotelType();
        hotel4.setName("Hotel4");
        hotel4.setAddress("123 Johnston,London");
        hotel4.setBookingNumber("4");
        hotel4.setCreditcardGuarantee(false);
        hotel4.setServiceName("Service4");
        hotel4.setTotalPrice(12);
        booked_hotels.add(hotel4);
    }
    
    public schema.hotelws.HotelListType getHotels(ws.hotels.GetHotelsRequestType getHotelsRequest) {
        HotelListType hotelList = new HotelListType();
        String requested_city = getHotelsRequest.getCity();
        System.out.println("GETHOTELS: requested city: " + requested_city);
        for (int i = 0; i < unbooked_hotels.size(); i++) {
            HotelType curr_hotel = unbooked_hotels.get(i);
            System.out.println("GETHOTELS:" + curr_hotel.getName() + curr_hotel.getAddress().split(",")[1]);
            if (requested_city.equals(curr_hotel.getAddress().split(",")[1])) {
                System.out.println("Found match: "+curr_hotel.getName());
                hotelList.getHotel().add(curr_hotel);
            }
        }
        return hotelList;
    }

    public boolean bookHotel(ws.hotels.BookHotelRequestType bookHotelRequest) throws BookHotelFault {
        boolean response = false;
        
        // Originally consider failure
        String bookingNum = bookHotelRequest.getBookingNumber();
        
        for (int i = 0; i < unbooked_hotels.size(); ++i) {
            HotelType curr_hotel = unbooked_hotels.get(i);
            
            // Set matching hotel's price to above 25
            // to make it unavailable
            if(curr_hotel.getBookingNumber().equals(bookingNum)) {
                //curr_hotel.setTotalPrice(30.0f);
                System.out.print("Booked hotel ");
                System.out.println(curr_hotel.getName());
                if (curr_hotel.isCreditcardGuarantee()) {
                    dk.dtu.imm.fastmoney.types.CreditCardInfoType creditcard = bookHotelRequest.getCreditcardInformation();
                    try {
                        if(validateCreditCard(4, creditcard, (int)curr_hotel.getTotalPrice())) {
                            System.out.println("Card is valid");
                            booked_hotels.add(curr_hotel);
                            unbooked_hotels.remove(curr_hotel);
                            response=true;
                            break;
                        }
                    }
                    catch (CreditCardFaultMessage m) {
//                        ErrorType error = new ErrorType();
//                        error.setHotel(curr_hotel);
//                        error.setMessage("Booking failed.");
//                        BookHotelFault fault = new BookHotelFault("Credit card invalid", error);
//            
//                        throw fault;
                    }
                }
                else {
                    booked_hotels.add(curr_hotel);
                    unbooked_hotels.remove(curr_hotel);
                    response=false;
                    break;
                }
            }
        }
        if (response) {
            return response;
        }
        
        // If booking number not found, send empty hotel and throw fault
        else {
//            HotelType badHotel = new HotelType();
//            ErrorType error = new ErrorType();
//            error.setHotel(badHotel);
//            error.setMessage("Booking failed.");
//            BookHotelFault fault = new BookHotelFault("No hotel exists with this booking number", error);
//            
//            throw fault;
        }
        return response;
    }

    public void cancelHotel(java.lang.String bookingNumber) throws CancelHotelFault {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    private boolean validateCreditCard(int group, dk.dtu.imm.fastmoney.types.CreditCardInfoType creditCardInfo, int amount) throws CreditCardFaultMessage {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        dk.dtu.imm.fastmoney.BankPortType port = service.getBankPort();
        return port.validateCreditCard(group, creditCardInfo, amount);
    }
    
}
