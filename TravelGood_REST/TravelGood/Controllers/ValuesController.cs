using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using TravelGood.dk.dtu.imm.fastmoney;

namespace TravelGood.Controllers
{
    //[Authorize]
    public class ValuesController : ApiController
    {
        // GET api/values
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/values
        public bool Post([FromBody]string value)
        {
            var service = new BankService();
            var card = new creditCardInfoType();
            card.name = "Thor-Jensen Claus";
            card.number = "50408825";
            card.expirationDate = new creditCardInfoTypeExpirationDate
            {
                month = 5,
                year = 9
            };
            var result = service.validateCreditCard(4, card, 100);
            return result;
        }

        // PUT api/values/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
        }
    }
}
