﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This source code was auto-generated by Microsoft.VSDesigner, Version 4.0.30319.42000.
// 
#pragma warning disable 1591

namespace TravelGood.hotelService {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="hotelsWSDLPortTypeBinding", Namespace="http://hotels.ws")]
    public partial class hotelsWSDLService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback cancelHotelOperationCompleted;
        
        private System.Threading.SendOrPostCallback getHotelsOperationCompleted;
        
        private System.Threading.SendOrPostCallback bookHotelOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public hotelsWSDLService() {
            this.Url = global::TravelGood.Properties.Settings.Default.TravelGood_hotelService_hotelsWSDLService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event cancelHotelCompletedEventHandler cancelHotelCompleted;
        
        /// <remarks/>
        public event getHotelsCompletedEventHandler getHotelsCompleted;
        
        /// <remarks/>
        public event bookHotelCompletedEventHandler bookHotelCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare)]
        public void cancelHotel([System.Xml.Serialization.XmlElementAttribute(Namespace="http://hotels.ws")] cancelHotelRequest cancelHotelRequest) {
            this.Invoke("cancelHotel", new object[] {
                        cancelHotelRequest});
        }
        
        /// <remarks/>
        public void cancelHotelAsync(cancelHotelRequest cancelHotelRequest) {
            this.cancelHotelAsync(cancelHotelRequest, null);
        }
        
        /// <remarks/>
        public void cancelHotelAsync(cancelHotelRequest cancelHotelRequest, object userState) {
            if ((this.cancelHotelOperationCompleted == null)) {
                this.cancelHotelOperationCompleted = new System.Threading.SendOrPostCallback(this.OncancelHotelOperationCompleted);
            }
            this.InvokeAsync("cancelHotel", new object[] {
                        cancelHotelRequest}, this.cancelHotelOperationCompleted, userState);
        }
        
        private void OncancelHotelOperationCompleted(object arg) {
            if ((this.cancelHotelCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.cancelHotelCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare)]
        [return: System.Xml.Serialization.XmlElementAttribute("getHotelsResponse", Namespace="http://hotels.ws")]
        public getHotelsResponse getHotels([System.Xml.Serialization.XmlElementAttribute(Namespace="http://hotels.ws")] getHotelsRequest getHotelsRequest) {
            object[] results = this.Invoke("getHotels", new object[] {
                        getHotelsRequest});
            return ((getHotelsResponse)(results[0]));
        }
        
        /// <remarks/>
        public void getHotelsAsync(getHotelsRequest getHotelsRequest) {
            this.getHotelsAsync(getHotelsRequest, null);
        }
        
        /// <remarks/>
        public void getHotelsAsync(getHotelsRequest getHotelsRequest, object userState) {
            if ((this.getHotelsOperationCompleted == null)) {
                this.getHotelsOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetHotelsOperationCompleted);
            }
            this.InvokeAsync("getHotels", new object[] {
                        getHotelsRequest}, this.getHotelsOperationCompleted, userState);
        }
        
        private void OngetHotelsOperationCompleted(object arg) {
            if ((this.getHotelsCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getHotelsCompleted(this, new getHotelsCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Bare)]
        [return: System.Xml.Serialization.XmlElementAttribute("bookHotelResponse", Namespace="http://hotels.ws")]
        public bookHotelResponse bookHotel([System.Xml.Serialization.XmlElementAttribute(Namespace="http://hotels.ws")] bookHotelRequest bookHotelRequest) {
            object[] results = this.Invoke("bookHotel", new object[] {
                        bookHotelRequest});
            return ((bookHotelResponse)(results[0]));
        }
        
        /// <remarks/>
        public void bookHotelAsync(bookHotelRequest bookHotelRequest) {
            this.bookHotelAsync(bookHotelRequest, null);
        }
        
        /// <remarks/>
        public void bookHotelAsync(bookHotelRequest bookHotelRequest, object userState) {
            if ((this.bookHotelOperationCompleted == null)) {
                this.bookHotelOperationCompleted = new System.Threading.SendOrPostCallback(this.OnbookHotelOperationCompleted);
            }
            this.InvokeAsync("bookHotel", new object[] {
                        bookHotelRequest}, this.bookHotelOperationCompleted, userState);
        }
        
        private void OnbookHotelOperationCompleted(object arg) {
            if ((this.bookHotelCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.bookHotelCompleted(this, new bookHotelCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://hotels.ws")]
    public partial class cancelHotelRequest {
        
        private string bookingNumberField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string bookingNumber {
            get {
                return this.bookingNumberField;
            }
            set {
                this.bookingNumberField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://hotels.ws")]
    public partial class hotelType {
        
        private string nameField;
        
        private string addressField;
        
        private string bookingNumberField;
        
        private float totalPriceField;
        
        private bool creditcardGuaranteeField;
        
        private string serviceNameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string address {
            get {
                return this.addressField;
            }
            set {
                this.addressField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string bookingNumber {
            get {
                return this.bookingNumberField;
            }
            set {
                this.bookingNumberField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public float totalPrice {
            get {
                return this.totalPriceField;
            }
            set {
                this.totalPriceField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool creditcardGuarantee {
            get {
                return this.creditcardGuaranteeField;
            }
            set {
                this.creditcardGuaranteeField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string serviceName {
            get {
                return this.serviceNameField;
            }
            set {
                this.serviceNameField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://hotels.ws")]
    public partial class getHotelsRequest {
        
        private string cityField;
        
        private System.DateTime arrivalDateField;
        
        private System.DateTime departureDateField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string city {
            get {
                return this.cityField;
            }
            set {
                this.cityField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, DataType="date")]
        public System.DateTime arrivalDate {
            get {
                return this.arrivalDateField;
            }
            set {
                this.arrivalDateField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, DataType="date")]
        public System.DateTime departureDate {
            get {
                return this.departureDateField;
            }
            set {
                this.departureDateField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://hotels.ws")]
    public partial class getHotelsResponse {
        
        private hotelType[] hotelListField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlArrayAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        [System.Xml.Serialization.XmlArrayItemAttribute("hotel", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=false)]
        public hotelType[] hotelList {
            get {
                return this.hotelListField;
            }
            set {
                this.hotelListField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://hotels.ws")]
    public partial class bookHotelRequest {
        
        private string bookingNumberField;
        
        private string creditcardField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string bookingNumber {
            get {
                return this.bookingNumberField;
            }
            set {
                this.bookingNumberField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string creditcard {
            get {
                return this.creditcardField;
            }
            set {
                this.creditcardField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.81.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://hotels.ws")]
    public partial class bookHotelResponse {
        
        private bool statusField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool status {
            get {
                return this.statusField;
            }
            set {
                this.statusField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    public delegate void cancelHotelCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    public delegate void getHotelsCompletedEventHandler(object sender, getHotelsCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getHotelsCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getHotelsCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public getHotelsResponse Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((getHotelsResponse)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    public delegate void bookHotelCompletedEventHandler(object sender, bookHotelCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.6.81.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class bookHotelCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal bookHotelCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bookHotelResponse Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bookHotelResponse)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591