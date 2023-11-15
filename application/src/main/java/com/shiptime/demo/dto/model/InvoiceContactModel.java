/**
 * SANDBOX REST API
 * Welcome to the Rest API documentation. Don't have API keys? Login or create an account <a href=\"https://restapi.appspaces.ca/\">here</a> to get started.
 *
 * OpenAPI spec version: 0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.shiptime.demo.dto.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;


/**
 * Address Info
 */
public class InvoiceContactModel   {
  @SerializedName("companyName")
  private String companyName = null;

  @SerializedName("streetAddress")
  private String streetAddress = null;

  @SerializedName("streetAddress2")
  private String streetAddress2 = null;

  @SerializedName("city")
  private String city = null;

  @SerializedName("countryCode")
  private String countryCode = null;

  @SerializedName("state")
  private String state = null;

  @SerializedName("postalCode")
  private String postalCode = null;

  @SerializedName("attention")
  private String attention = null;

  @SerializedName("email")
  private String email = null;

  @SerializedName("phone")
  private String phone = null;

  @SerializedName("instructions")
  private String instructions = null;

  @SerializedName("residential")
  private Boolean residential = null;

  @SerializedName("notify")
  private Boolean notify = null;

  @SerializedName("customsBroker")
  private String customsBroker = null;

  @SerializedName("shipperTaxId")
  private String shipperTaxId = null;

  public InvoiceContactModel companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

   /**
   * Company name. Maximum: 40 characters.
   * @return companyName
  **/
  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public InvoiceContactModel streetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
    return this;
  }

   /**
   * Street Address. Maximum: 50 characters.
   * @return streetAddress
  **/
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public InvoiceContactModel streetAddress2(String streetAddress2) {
    this.streetAddress2 = streetAddress2;
    return this;
  }

   /**
   * Street Address Line 2. Maximum: 35 characters.
   * @return streetAddress2
  **/
  public String getStreetAddress2() {
    return streetAddress2;
  }

  public void setStreetAddress2(String streetAddress2) {
    this.streetAddress2 = streetAddress2;
  }

  public InvoiceContactModel city(String city) {
    this.city = city;
    return this;
  }

   /**
   * City. Maximum: 40 characters.
   * @return city
  **/
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public InvoiceContactModel countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Country Code
   * @return countryCode
  **/
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public InvoiceContactModel state(String state) {
    this.state = state;
    return this;
  }

   /**
   * State or Province. Required for CA and US
   * @return state
  **/
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public InvoiceContactModel postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Postal Code or ZIP code. Maximum: 10 characters.
   * @return postalCode
  **/
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public InvoiceContactModel attention(String attention) {
    this.attention = attention;
    return this;
  }

   /**
   * Recipient's Name. Minimum: 2 characters. Maximum: 40 characters.
   * @return attention
  **/
  public String getAttention() {
    return attention;
  }

  public void setAttention(String attention) {
    this.attention = attention;
  }

  public InvoiceContactModel email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Email Address. Maximum: 40 characters.
   * @return email
  **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InvoiceContactModel phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Phone Number. Minimum: 10 characters. Maximum: 15 characters. For Canada and USA the format should be NNN NNN NNNN, for other countries adhere to the E.123 international notation. Example, +22 607 123 4567
   * @return phone
  **/
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public InvoiceContactModel instructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

   /**
   * Special Instructions. Maximum: 60 characters.
   * @return instructions
  **/
  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public InvoiceContactModel residential(Boolean residential) {
    this.residential = residential;
    return this;
  }

   /**
   * Residential Address?
   * @return residential
  **/
  public Boolean getResidential() {
    return residential;
  }

  public void setResidential(Boolean residential) {
    this.residential = residential;
  }

  public InvoiceContactModel notify(Boolean notify) {
    this.notify = notify;
    return this;
  }

   /**
   * Notify Recipient?
   * @return notify
  **/
  public Boolean getNotify() {
    return notify;
  }

  public void setNotify(Boolean notify) {
    this.notify = notify;
  }

  public InvoiceContactModel customsBroker(String customsBroker) {
    this.customsBroker = customsBroker;
    return this;
  }

   /**
   * Customs Broker
   * @return customsBroker
  **/
  public String getCustomsBroker() {
    return customsBroker;
  }

  public void setCustomsBroker(String customsBroker) {
    this.customsBroker = customsBroker;
  }

  public InvoiceContactModel shipperTaxId(String shipperTaxId) {
    this.shipperTaxId = shipperTaxId;
    return this;
  }

   /**
   * Shipper's Tax Id
   * @return shipperTaxId
  **/
  public String getShipperTaxId() {
    return shipperTaxId;
  }

  public void setShipperTaxId(String shipperTaxId) {
    this.shipperTaxId = shipperTaxId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceContactModel invoiceContactModel = (InvoiceContactModel) o;
    return Objects.equals(this.companyName, invoiceContactModel.companyName) &&
        Objects.equals(this.streetAddress, invoiceContactModel.streetAddress) &&
        Objects.equals(this.streetAddress2, invoiceContactModel.streetAddress2) &&
        Objects.equals(this.city, invoiceContactModel.city) &&
        Objects.equals(this.countryCode, invoiceContactModel.countryCode) &&
        Objects.equals(this.state, invoiceContactModel.state) &&
        Objects.equals(this.postalCode, invoiceContactModel.postalCode) &&
        Objects.equals(this.attention, invoiceContactModel.attention) &&
        Objects.equals(this.email, invoiceContactModel.email) &&
        Objects.equals(this.phone, invoiceContactModel.phone) &&
        Objects.equals(this.instructions, invoiceContactModel.instructions) &&
        Objects.equals(this.residential, invoiceContactModel.residential) &&
        Objects.equals(this.notify, invoiceContactModel.notify) &&
        Objects.equals(this.customsBroker, invoiceContactModel.customsBroker) &&
        Objects.equals(this.shipperTaxId, invoiceContactModel.shipperTaxId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyName, streetAddress, streetAddress2, city, countryCode, state, postalCode, attention, email, phone, instructions, residential, notify, customsBroker, shipperTaxId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceContactModel {\n");
    
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    streetAddress: ").append(toIndentedString(streetAddress)).append("\n");
    sb.append("    streetAddress2: ").append(toIndentedString(streetAddress2)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    attention: ").append(toIndentedString(attention)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
    sb.append("    residential: ").append(toIndentedString(residential)).append("\n");
    sb.append("    notify: ").append(toIndentedString(notify)).append("\n");
    sb.append("    customsBroker: ").append(toIndentedString(customsBroker)).append("\n");
    sb.append("    shipperTaxId: ").append(toIndentedString(shipperTaxId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
