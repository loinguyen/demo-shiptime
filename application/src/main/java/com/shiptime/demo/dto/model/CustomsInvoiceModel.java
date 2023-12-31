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

import java.util.ArrayList;
import java.util.List;


/**
 * Customs Invoice
 */
public class CustomsInvoiceModel   {
  @SerializedName("invoiceContact")
  private InvoiceContactModel invoiceContact = null;

  @SerializedName("dutiesAndTaxes")
  private DutiesAndTaxesModel dutiesAndTaxes = null;

  /**
   * Currency of this invoice (USD or CAD)
   */
  public enum CurrencyEnum {
    @SerializedName("CAD")
    CAD("CAD"),
    
    @SerializedName("USD")
    USD("USD");

    private String value;

    CurrencyEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("currency")
  private CurrencyEnum currency = null;

  @SerializedName("invoiceItems")
  private List<InvoiceItemModel> invoiceItems = new ArrayList<InvoiceItemModel>();

  /**
   * Reason For Export
   */
  public enum ReasonForExportEnum {
    @SerializedName("COMMERCIAL")
    COMMERCIAL("COMMERCIAL"),
    
    @SerializedName("GIFT")
    GIFT("GIFT"),
    
    @SerializedName("SAMPLE")
    SAMPLE("SAMPLE"),
    
    @SerializedName("PERSONAL")
    PERSONAL("PERSONAL"),
    
    @SerializedName("RETURN_AND_REPAIR")
    RETURN_AND_REPAIR("RETURN_AND_REPAIR");

    private String value;

    ReasonForExportEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("reasonForExport")
  private ReasonForExportEnum reasonForExport = null;

  public CustomsInvoiceModel invoiceContact(InvoiceContactModel invoiceContact) {
    this.invoiceContact = invoiceContact;
    return this;
  }

   /**
   * Invoice Contact Details
   * @return invoiceContact
  **/
  public InvoiceContactModel getInvoiceContact() {
    return invoiceContact;
  }

  public void setInvoiceContact(InvoiceContactModel invoiceContact) {
    this.invoiceContact = invoiceContact;
  }

  public CustomsInvoiceModel dutiesAndTaxes(DutiesAndTaxesModel dutiesAndTaxes) {
    this.dutiesAndTaxes = dutiesAndTaxes;
    return this;
  }

   /**
   * Duties and Taxes information
   * @return dutiesAndTaxes
  **/
  public DutiesAndTaxesModel getDutiesAndTaxes() {
    return dutiesAndTaxes;
  }

  public void setDutiesAndTaxes(DutiesAndTaxesModel dutiesAndTaxes) {
    this.dutiesAndTaxes = dutiesAndTaxes;
  }

  public CustomsInvoiceModel currency(CurrencyEnum currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Currency of this invoice (USD or CAD)
   * @return currency
  **/
  public CurrencyEnum getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyEnum currency) {
    this.currency = currency;
  }

  public CustomsInvoiceModel invoiceItems(List<InvoiceItemModel> invoiceItems) {
    this.invoiceItems = invoiceItems;
    return this;
  }

  public CustomsInvoiceModel addInvoiceItemsItem(InvoiceItemModel invoiceItemsItem) {
    this.invoiceItems.add(invoiceItemsItem);
    return this;
  }

   /**
   * List of Invoice Items
   * @return invoiceItems
  **/
  public List<InvoiceItemModel> getInvoiceItems() {
    return invoiceItems;
  }

  public void setInvoiceItems(List<InvoiceItemModel> invoiceItems) {
    this.invoiceItems = invoiceItems;
  }

  public CustomsInvoiceModel reasonForExport(ReasonForExportEnum reasonForExport) {
    this.reasonForExport = reasonForExport;
    return this;
  }

   /**
   * Reason For Export
   * @return reasonForExport
  **/
  public ReasonForExportEnum getReasonForExport() {
    return reasonForExport;
  }

  public void setReasonForExport(ReasonForExportEnum reasonForExport) {
    this.reasonForExport = reasonForExport;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomsInvoiceModel customsInvoiceModel = (CustomsInvoiceModel) o;
    return Objects.equals(this.invoiceContact, customsInvoiceModel.invoiceContact) &&
        Objects.equals(this.dutiesAndTaxes, customsInvoiceModel.dutiesAndTaxes) &&
        Objects.equals(this.currency, customsInvoiceModel.currency) &&
        Objects.equals(this.invoiceItems, customsInvoiceModel.invoiceItems) &&
        Objects.equals(this.reasonForExport, customsInvoiceModel.reasonForExport);
  }

  @Override
  public int hashCode() {
    return Objects.hash(invoiceContact, dutiesAndTaxes, currency, invoiceItems, reasonForExport);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomsInvoiceModel {\n");
    
    sb.append("    invoiceContact: ").append(toIndentedString(invoiceContact)).append("\n");
    sb.append("    dutiesAndTaxes: ").append(toIndentedString(dutiesAndTaxes)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    invoiceItems: ").append(toIndentedString(invoiceItems)).append("\n");
    sb.append("    reasonForExport: ").append(toIndentedString(reasonForExport)).append("\n");
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

