using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CCS
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "NewUser" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select NewUser.svc or NewUser.svc.cs at the Solution Explorer and start debugging.
    public class NewUser : INewUser
    {
        public int CreateAccount(string email, string password, string fullname)
        {
            // return an ID if an account has been created successfully
            // return -1 if failed to create because of an unknown reason
            // return -2 if duplicated email
            int retValue = 0;

            try
            {
                CampusConnectionEntities context = new CampusConnectionEntities();

                // if the email exists, return an error
                Account checkAcc = (from a in context.Accounts where a.Email == email select a).SingleOrDefault();
                if (checkAcc != null)
                    retValue = -2;

                // if doesn't exist, then create a new account
                else
                {
                    Account acc = new CCS.Account();
                    acc.Email = email;
                    acc.Password = password;
                    acc.FullName = fullname;
                    context.Accounts.Add(acc);
                    context.SaveChanges();
                    retValue = acc.Id;
                }
            }
            catch (Exception e)
            {
                // TODO: Write log with e

                retValue = -1;
            }

            return retValue;
        }
    }
}
