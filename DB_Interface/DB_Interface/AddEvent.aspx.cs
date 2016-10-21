using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class AddEvent : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            List<Account> accs = (from u in context.Accounts select u).OrderBy(a=>a.FullName).ToList();
            foreach (Account a in accs)
            {
                ListItem item = new ListItem();
                item.Value = a.Id.ToString();
                item.Text = a.FullName;
                ddlCreators.Items.Add(item);
            }
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Events.aspx");
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Event ev = new Event();
            ev.Creator = int.Parse(ddlCreators.SelectedValue.ToString());
            ev.Subject = txtSubject.Text;
            ev.StartTime = txtStart.Text;
            ev.EndTime = txtEnd.Text;
            ev.MaxResponders = byte.Parse(txtMaxResponders.Text);
            ev.Location = txtLocation.Text;
            ev.ExtraInfo = txtExtraInfo.Text;
            context.Events.Add(ev);
            context.SaveChanges();
            Response.Redirect("~/Events.aspx");
        }

    }
}