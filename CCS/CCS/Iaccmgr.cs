﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CCS
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "Iaccmgr" in both code and config file together.
    [ServiceContract]
    public interface Iaccmgr
    {
        [OperationContract]
        Account DoLogin(string email, string password);

        [OperationContract]
        int CreateAccount(string email, string password, string fullname);

        [OperationContract]
        List<Course> GetCourses();


    }
}
