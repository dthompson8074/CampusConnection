using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class AddCourse : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Course c = new Course();
            c.Prefix = txtPrefix.Text;
            c.Number = int.Parse(txtNumber.Text);
            c.Name = txtName.Text;
            c.StartTime = txtStart.Text;
            c.EndTime = txtEnd.Text;
            c.Days = txtDays.Text;
            c.Instructor = txtInstructor.Text;
            context.Courses.Add(c);
            context.SaveChanges();
            Response.Redirect("~/Courses.aspx");
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Courses.aspx");
        }
    }
}