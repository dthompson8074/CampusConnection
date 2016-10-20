<%@ Page Title="" Language="C#" MasterPageFile="~/Default.Master" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="DB_Interface.Index" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="pagination-centered">
        <asp:Button ID="btnAccount" runat="server" Text="Accounts" CssClass="btn btn-large" OnClick="btnAccount_Click" />
        <asp:Button ID="btnCourse" runat="server" Text="Courses" CssClass="btn btn-large" OnClick="btnCourse_Click" />
        <asp:Button ID="btnEvent" runat="server" Text="Events" CssClass="btn btn-large" OnClick="btnEvent_Click" />
    </div>
</asp:Content>
