using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TravelGood.Models
{
    public enum itineraryStates
    {
        draft,
        booked,
        bookingFail,
        cancelled,
        cancellingFail
    }

    public class Itinerary
    {
        public Itinerary() {
            state = itineraryStates.draft;
        }

        [JsonIgnore]
        public int ID { get; set; }
        public string username { get; set; }
        public virtual ICollection<HotelItem> hotels { get; set; }
        public itineraryStates state { get; set; }
    }
}