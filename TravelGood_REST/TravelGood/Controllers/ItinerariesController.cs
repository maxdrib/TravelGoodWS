using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using TravelGood.Models;
using TravelGood.hotelService;

namespace TravelGood.Controllers
{
    public class itineraryStatus
    {
        public string status { get; set; }
        public string creditcard { get; set; }
    }

    [RoutePrefix("api/itineraries")]
    public class ItinerariesController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();
        private hotelsWSDLService hotelWS = new hotelsWSDLService();

        [Route("{id:int}/hotels")]
        [ResponseType(typeof(void))]
        public IHttpActionResult PostHotel(int id, [FromBody] string hotelBookingNumber)
        {
            Itinerary itinerary = db.Itineraries.Find(id);
            if (itinerary == null)
            {
                return NotFound();
            }

            itinerary.addHotel(hotelBookingNumber);
            return PutItinerary(id, itinerary);
        }

        [Route("{id:int}/status")]
        [ResponseType(typeof(void))]
        [HttpPut]
        public IHttpActionResult BookItinerary(int id, [FromBody] itineraryStatus status)
        {
            Itinerary itinerary = db.Itineraries.Find(id);
            if (itinerary == null)
            {
                return NotFound();
            }

            //BOOK
            if ("booked" == status.status.ToLower()) { 
                foreach (var hotelNum in itinerary.hotelList())
                {
                    if (BookHotel(hotelNum, status.creditcard) == false) {
                        DeleteItinerary(id);
                        return ResponseMessage(Request.CreateErrorResponse(HttpStatusCode.InternalServerError, "Failed booking hotel: " + hotelNum));
                    }
                }

                itinerary.state = itineraryStates.booked;
                return PutItinerary(id, itinerary);
            }
            //CANCEL
            else if ("cancelled" == status.status.ToLower())
            {
                itinerary.state = itineraryStates.cancelled;
                foreach (var hotelNum in itinerary.hotelList())
                {
                    if (CancelHotel(hotelNum) == false)
                    {
                        //add to failed hotels
                        itinerary.state = itineraryStates.cancellingFail;
                    }
                }

                if (itinerary.state == itineraryStates.cancellingFail) { 
                    return ResponseMessage(Request.CreateErrorResponse(HttpStatusCode.InternalServerError, "One or more cancellations failed"));
                }
            }

            return BadRequest();
        }

        // GET: api/Itinerary
        public IQueryable<Itinerary> GetItineraries()
        {
            return db.Itineraries;
        }

        // GET: api/Itinerary/5
        [ResponseType(typeof(Itinerary))]
        public IHttpActionResult GetItinerary(int id)
        {
            Itinerary itinerary = db.Itineraries.Find(id);
            if (itinerary == null)
            {
                return NotFound();
            }

            return Ok(itinerary);
        }

        // PUT: api/Itinerary/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutItinerary(int id, Itinerary itinerary)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != itinerary.ID)
            {
                return BadRequest();
            }

            db.Entry(itinerary).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ItineraryExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Itinerary
        [ResponseType(typeof(Itinerary))]
        public IHttpActionResult PostItinerary(Itinerary itinerary)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Itineraries.Add(itinerary);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = itinerary.ID }, itinerary);
        }

        // DELETE: api/Itinerary/5
        [ResponseType(typeof(Itinerary))]
        public IHttpActionResult DeleteItinerary(int id)
        {
            Itinerary itinerary = db.Itineraries.Find(id);
            if (itinerary == null)
            {
                return NotFound();
            }

            db.Itineraries.Remove(itinerary);
            db.SaveChanges();

            return Ok(itinerary);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ItineraryExists(int id)
        {
            return db.Itineraries.Count(e => e.ID == id) > 0;
        }

        private bool BookHotel(string bookingNumber, string creditcard)
        {
            var hotelRequest = new bookHotelRequest();
            hotelRequest.bookingNumber = bookingNumber;
            hotelRequest.creditcard = creditcard;
            try { 
                bookHotelResponse response = hotelWS.bookHotel(hotelRequest);
                return response.status;
            }
            catch
            {
                return false;
            }
        }

        private bool CancelHotel(string bookingNumber)
        {
            try
            {
                cancelHotelRequest request = new cancelHotelRequest();
                request.bookingNumber = bookingNumber;
                hotelWS.cancelHotel(request);
                return true;
            }
            catch
            {
                return false;
            }
        }
    }
}