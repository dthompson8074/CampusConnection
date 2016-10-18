using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CCS
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Login" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Login.svc or Login.svc.cs at the Solution Explorer and start debugging.
    public class Login : ILogin
    {
        public void DoWork()
        {
        }

        public Account DoLogin(string email, string password)
        {
            CampusConnectionEntitiesContainer context = new CCS.CampusConnectionEntitiesContainer();
            return (from a in context.Accounts where a.Email == email && a.Password == password select a).SingleOrDefault();            
        }        
    }
}
