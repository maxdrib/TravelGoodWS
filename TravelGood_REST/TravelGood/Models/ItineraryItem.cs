using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace TravelGood.Models
{
    public enum itemState
    {
        unconfirmed,
        confirmed,
        cancelled
    }

    public abstract class ItineraryItem
    {
        public ItineraryItem()
        {
            state = itemState.unconfirmed;
        }
        [JsonIgnore]
        public int ID { get; set; }
        public string bookingNumber { get; set; }
        public itemState state { get; set; }
    }

    public class HotelItem:ItineraryItem { }
}