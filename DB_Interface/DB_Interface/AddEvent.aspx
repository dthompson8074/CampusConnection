<%@ Page Title="" Language="C#" MasterPageFile="~/Default.Master" AutoEventWireup="true" CodeBehind="AddEvent.aspx.cs" Inherits="DB_Interface.AddEvent" %>
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
                <td class="element-name">Creator</td>
                <td class="element-input">
                    <asp:DropDownList ID="ddlCreators" runat="server"></asp:DropDownList>
                </td>
            </tr>
            <tr>
                <td class="element-name">Subject</td>
                <td class="element-input">
                    <asp:TextBox ID="txtSubject" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td class="element-name">Start Time</td>
                <td class="element-input">
                    <asp:TextBox ID="txtStart" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td class="element-name">End Time</td>
                <td class="element-input">
                    <asp:TextBox ID="txtEnd" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td class="element-name">Max Responders</td>
                <td class="element-input">
                    <asp:TextBox ID="txtMaxResponders" runat="server" TextMode="Number"></asp:TextBox></td>
            </tr>
            <tr>
                <td class="element-name">Location</td>
                <td class="element-input">
                    <asp:TextBox ID="txtLocation" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td class="element-name">Extra Info</td>
                <td class="element-input">
                    <asp:TextBox ID="txtExtraInfo" runat="server"></asp:TextBox></td>
            </tr>
        </table>
        <div class="pagination-centered">
            <asp:Button ID="btnSubmit" runat="server" Text="Create Event" CssClass="btn btn-large" OnClick="btnSubmit_Click" />
            <asp:Button ID="btnCancel" runat="server" Text="Cancel" CssClass="btn btn-large" OnClick="btnCancel_Click" />
        </div>
    </div>
</asp:Content>
