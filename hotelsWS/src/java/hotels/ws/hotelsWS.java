
package hotels.ws;

import hotels.ws.CreditCardInfoType.ExpirationDate;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import ws.hotels.BookHotelFault;
import ws.hotels.BookHotelResponse;
import ws.hotels.CancelHotelFault;
import ws.hotels.ErrorType;
import ws.hotels.GetHotelsResponse;
import ws.hotels.HotelListType;
import ws.hotels.HotelType;

/**
 *
 * @author xavi&max
 */
@WebService(serviceName = "hotelsWSDLService", portName = "hotelsWSDLPort", endpointInterface = "ws.hotels.HotelsWSDLPortType", targetNamespace = "http://hotels.ws", wsdlLocation = "WEB-INF/wsdl/hotelsWS/hotelsWSDL.wsdl")
public class hotelsWS {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/fastmoney.imm.dtu.dk_8080/BankService.wsdl")
    private BankService service;

    private static ArrayList<HotelType> unbooked_hotels;
    private static ArrayList<HotelType> booked_hotels;
    
    public hotelsWS() {
        
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
    
    public ws.hotels.GetHotelsResponse getHotels(ws.hotels.GetHotelsRequest getHotelsRequest) {
        GetHotelsResponse response = new GetHotelsResponse();
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
        response.setHotelList(hotelList);
        return response;
    }

    public ws.hotels.BookHotelResponse bookHotel(ws.hotels.BookHotelRequest bookHotelRequest) throws BookHotelFault, CreditCardFaultMessage {
        BookHotelResponse response = new BookHotelResponse();
        
        // Originally consider failure
        response.setStatus(false);
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
                    String[] creditcard = bookHotelRequest.getCreditcard().split(",");
                    CreditCardInfoType cc = new CreditCardInfoType();
                    ExpirationDate exp = new ExpirationDate();
                    
                    // Credit card order is name, number, exp month, exp year
                    cc.setName(creditcard[0]);
                    cc.setNumber(creditcard[1]);
                    exp.setMonth(Integer.parseInt(creditcard[2]));
                    exp.setYear(Integer.parseInt(creditcard[3]));
                    cc.setExpirationDate(exp);
                    System.out.print("Checking credit card for ");
                    System.out.println(creditcard[0]);
                    // Check if credit card is valid
                    try {
                        
                        if(validateCreditCard(4, cc, curr_hotel.getTotalPrice())) {
                            System.out.println("Card is valid");
                            booked_hotels.add(curr_hotel);
                            unbooked_hotels.remove(curr_hotel);
                            response.setStatus(true);
                            break;
                        }
                    }
                    catch (CreditCardFaultMessage m) {
                        ErrorType error = new ErrorType();
                        error.setHotel(curr_hotel);
                        error.setMessage("Booking failed.");
                        BookHotelFault fault = new BookHotelFault("Credit card invalid", error);
            
                        throw fault;
                    }
                }
                else {
                    booked_hotels.add(curr_hotel);
                    unbooked_hotels.remove(curr_hotel);
                    response.setStatus(true);
                    break;
                }
                    
            }
        }
        if (response.isStatus()) {
            return response;
        }
        
        // If booking number not found, send empty hotel and throw fault
        else {
            HotelType badHotel = new HotelType();
            ErrorType error = new ErrorType();
            error.setHotel(badHotel);
            error.setMessage("Booking failed.");
            BookHotelFault fault = new BookHotelFault("No hotel exists with this booking number", error);
            
            throw fault;
        }
    }
    
    public void cancelHotel(ws.hotels.CancelHotelRequest cancelHotelRequest) throws CancelHotelFault {
        //TODO implement this method
        String bookingNum = cancelHotelRequest.getBookingNumber();
        for (int i = 0; i < booked_hotels.size(); ++i) {
            HotelType curr_hotel = booked_hotels.get(i);
            
            // Set matching hotel's price to above 25
            // to make it unavailable
            if(curr_hotel.getBookingNumber().equals(bookingNum)) {
                //curr_hotel.setTotalPrice(30.0f);
                unbooked_hotels.add(curr_hotel);
                booked_hotels.remove(curr_hotel);
                System.out.print("Cancelled hotel");
                return;
            }
        }
        
        HotelType badHotel = new HotelType();
        ErrorType error = new ErrorType();
        error.setHotel(badHotel);
        error.setMessage("Cancel booking failed. Original booking was not found.");
        CancelHotelFault fault = new CancelHotelFault("No booking exists with this booking number", error);
        throw fault;
    }

    private boolean chargeCreditCard(int group, hotels.ws.CreditCardInfoType creditCardInfo, int amount, hotels.ws.AccountType account) throws CreditCardFaultMessage {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        hotels.ws.BankPortType port = service.getBankPort();
        return port.chargeCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean refundCreditCard(int group, hotels.ws.CreditCardInfoType creditCardInfo, int amount, hotels.ws.AccountType account) throws CreditCardFaultMessage {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        hotels.ws.BankPortType port = service.getBankPort();
        return port.refundCreditCard(group, creditCardInfo, amount, account);
    }

    private boolean validateCreditCard(int group, hotels.ws.CreditCardInfoType creditCardInfo, int amount) throws CreditCardFaultMessage {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        hotels.ws.BankPortType port = service.getBankPort();
        return port.validateCreditCard(group, creditCardInfo, amount);
    }
}
