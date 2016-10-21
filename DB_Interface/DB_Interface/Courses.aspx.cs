using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class Courses : System.Web.UI.Page
    {
        string prefix;
        int number;
        string name;
        string start;
        string end;
        string days;
        string instructor;

        protected void Page_Load(object sender, EventArgs e)
        {
            divMsg.Visible = false;
        }

        protected void btnGoBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Index.aspx");
        }

        // The return type can be changed to IEnumerable, however to support
        // paging and sorting, the following parameters must be added:
        //     int maximumRows
        //     int startRowIndex
        //     out int totalRowCount
        //     string sortByExpression
        public IQueryable GridViewCourses_GetData()
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            return (from c in context.Courses select c);
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewCourses_UpdateItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Course course = (from a in context.Courses where a.Id == id select a).SingleOrDefault();
            if (course == null) return;
            course.Prefix = prefix;
            course.Number = number;
            course.Name = name;
            course.StartTime = start;
            course.EndTime = end;
            course.Days = days;
            course.Instructor = instructor;
            context.SaveChanges();
            lblMsg.Text = "Changes saved!";
            divMsg.Visible = true;
            EnableButtons(true);
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewCourses_DeleteItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Course course = (from a in context.Courses where a.Id == id select a).SingleOrDefault();
            if (course == null) return;
            context.Courses.Remove(course);
            context.SaveChanges();
            lblMsg.Text = "Removed!";
            divMsg.Visible = true;
        }

        protected void GridViewCourses_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            prefix = e.NewValues[1].ToString();
            number = int.Parse(e.NewValues[2].ToString());
            name = e.NewValues[3].ToString();
            start = e.NewValues[4].ToString();
            end = e.NewValues[5].ToString();
            days = e.NewValues[6].ToString();
            instructor = e.NewValues[7].ToString();
        }

        protected void btnNewCourse_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/AddCourse.aspx");
        }

        protected void GridViewCourses_RowEditing(object sender, GridViewEditEventArgs e)
        {
            EnableButtons(false);
        }

        protected void GridViewCourses_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            EnableButtons(true);
        }

        private void EnableButtons(bool enabled)
        {
            btnNewCourse.Visible = enabled;
            btnGoBack.Visible = enabled;
        }        
    }
}