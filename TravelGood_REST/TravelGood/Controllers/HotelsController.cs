using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TravelGood.hotelService;

namespace TravelGood.Controllers
{
    public class HotelsController : ApiController
    {
        private hotelsWSDLService hotelWS = new hotelsWSDLService();

        // GET: api/Itinerary
        public getHotelsResponse GetHotels()
        {
            getHotelsRequest request = new getHotelsRequest();
            request.arrivalDate = DateTime.Now;
            request.departureDate = DateTime.Now;
            request.city = "Lyngby";
            return hotelWS.getHotels(request);
        }
    }
}
