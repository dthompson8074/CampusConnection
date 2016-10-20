using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class Index : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnAccount_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Accounts.aspx");
        }

        protected void btnCourse_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Courses.aspx");
        }

        protected void btnEvent_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Events.aspx");
        }
    }
}