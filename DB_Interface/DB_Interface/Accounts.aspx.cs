using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace DB_Interface
{
    public partial class Accounts : System.Web.UI.Page
    {
        string editedEmail;
        string editedPassword;
        string editedFullName;

        protected void Page_Load(object sender, EventArgs e)
        {
            divMsg.Visible = false;
        }

        // The return type can be changed to IEnumerable, however to support
        // paging and sorting, the following parameters must be added:
        //     int maximumRows
        //     int startRowIndex
        //     out int totalRowCount
        //     string sortByExpression
        public IQueryable GridViewAccounts_GetData()
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            return (from a in context.Accounts select a);
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewAccounts_UpdateItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Account acc = (from a in context.Accounts where a.Id == id select a).SingleOrDefault();
            if (acc == null) return;
            acc.Email = editedEmail;
            acc.Password = editedPassword;
            acc.FullName = editedFullName;
            context.SaveChanges();
            lblMsg.Text = "Changes saved!";
            divMsg.Visible = true;
        }

        // The id parameter name should match the DataKeyNames value set on the control
        public void GridViewAccounts_DeleteItem(int id)
        {
            CampusConnectionEntities context = new CampusConnectionEntities();
            Account acc = (from a in context.Accounts where a.Id == id select a).SingleOrDefault();
            if (acc == null) return;
            context.Accounts.Remove(acc);
            context.SaveChanges();
            lblMsg.Text = "Removed!";
            divMsg.Visible = true;
        }

        protected void GridViewAccounts_RowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            editedEmail = e.NewValues[1].ToString().Trim();
            editedPassword = e.NewValues[2].ToString().Trim();
            editedFullName = e.NewValues[3].ToString().Trim();
        }

        protected void btnGoBack_Click(object sender, EventArgs e)
        {
            Response.Redirect("~/Index.aspx");
        }
    }
}