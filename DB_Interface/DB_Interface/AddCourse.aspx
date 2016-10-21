<%@ Page Title="" Language="C#" MasterPageFile="~/Default.Master" AutoEventWireup="true" CodeBehind="AddCourse.aspx.cs" Inherits="DB_Interface.AddCourse" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolderMessage" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div style="width: 500px; margin: 0 auto">
    <div style="padding:10px; border:3px solid gray">
        <span class="notice">Please do NOT try to enter wrong or invalid data, this registration page won't check the validation of data.</span>
    </div>
    <br />
    <table class="table-input-elements">
        <tr>
            <td class="element-name">Prefix</td>
            <td class="element-input"><asp:TextBox ID="txtPrefix" placeholder="CS" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">Number</td>
            <td class="element-input"><asp:TextBox ID="txtNumber" placeholder="1234" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">Course Name</td>
            <td class="element-input"><asp:TextBox ID="txtName" placeholder="Software Engineering II" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">Start Time</td>
            <td class="element-input"><asp:TextBox ID="txtStart" placeholder="8am" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">End Time</td>
            <td class="element-input"><asp:TextBox ID="txtEnd" placeholder="9:30am" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">Days</td>
            <td class="element-input"><asp:TextBox ID="txtDays" placeholder="TTh" runat="server"></asp:TextBox></td>
        </tr>
        <tr>
            <td class="element-name">Instructor</td>
            <td class="element-input"><asp:TextBox ID="txtInstructor" placeholder="John Smith" runat="server"></asp:TextBox></td>
        </tr>
    </table>
    <div class="pagination-centered">
        <asp:Button ID="btnSubmit" runat="server" Text="Create This Course" CssClass="btn btn-large" OnClick="btnSubmit_Click" />
        <asp:Button ID="btnCancel" runat="server" Text="Cancel" CssClass="btn btn-large" OnClick="btnCancel_Click" />
    </div>
    </div>
</asp:Content>
