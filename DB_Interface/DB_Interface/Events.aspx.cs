using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class Events : System.Web.UI.Page
    {
        int creatorID;
        string subject;
        string start;
        string end;
        byte maxResponders;
        string location;
        string extraInfo;

        protected void Page_Load(object sender, EventArgs e)
        {
            divMsg.Visible = false;
        }

        protected void btnGoBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Index.aspx");
        }

        protected void btnNewEvent_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/AddEvent.aspx");
        }

        // The return type can be changed to IEnumerable, however to support
        // paging and sorting, the following parameters must be added:
        //     int maximumRows
        //     int startRowIndex
        //     out int totalRowCount
        //     string sortByExpression
        public IQueryable GridViewEvents_GetData()
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            return from ev in context.Events select ev;
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewEvents_UpdateItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Event ev = (from a in context.Events where a.Id == id select a).SingleOrDefault();
            if (ev == null) return;
            ev.Creator = creatorID;
            ev.Subject = subject;
            ev.StartTime = start;
            ev.EndTime = end;
            ev.MaxResponders = maxResponders;
            ev.Location = location;
            ev.ExtraInfo = extraInfo;
            context.SaveChanges();
            lblMsg.Text = "Changes saved!";
            divMsg.Visible = true;
            EnableButtons(true);
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewEvents_DeleteItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Event ev = (from a in context.Events where a.Id == id select a).SingleOrDefault();
            if (ev == null) return;
            context.Events.Remove(ev);
            context.SaveChanges();
            lblMsg.Text = "Removed!";
            divMsg.Visible = true;
        }

        protected void GridViewEvents_RowEditing(object sender, GridViewEditEventArgs e)
        {
            EnableButtons(false);
        }

        protected void GridViewEvents_RowCancelingEdit(object sender, GridViewCancelEditEventArgs e)
        {
            EnableButtons(true);
        }

        protected void GridViewEvents_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            creatorID = int.Parse(e.NewValues[1].ToString());
            subject = e.NewValues[2].ToString();
            start = e.NewValues[3].ToString();
            end = e.NewValues[4].ToString();
            maxResponders = byte.Parse(e.NewValues[5].ToString());
            location = e.NewValues[6].ToString();
            extraInfo = e.NewValues[7].ToString();
        }

        private void EnableButtons(bool enabled)
        {
            btnNewEvent.Visible = enabled;
            btnGoBack.Visible = enabled;
        }
    }
}