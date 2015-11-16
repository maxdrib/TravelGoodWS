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
            hotels = "[]";
            state = itineraryStates.draft;
        }

        public int ID { get; set; }
        public string username { get; set; }
        public string hotels { get; set; }  //they cannot be simple strings!
        public itineraryStates state { get; set; }

        public void addHotel(string num)
        {
            var hList = JsonConvert.DeserializeObject<IList<string>>(hotels);
            hList.Add(num);
            hotels = JsonConvert.SerializeObject(hList);
        }

        public string getHotel(int index)
        {
            var hList = JsonConvert.DeserializeObject<IList<string>>(hotels);
            return hList[index];
        }

        public IList<string> hotelList()
        {
            return JsonConvert.DeserializeObject<IList<string>>(hotels);
        }
    }
}