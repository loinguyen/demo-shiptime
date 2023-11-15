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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Quote Info
 */
public class QuoteModel   {
  @SerializedName("baseCharge")
  private MoneyAmountModel baseCharge = null;

  @SerializedName("surcharges")
  private List<SurchargeModel> surcharges = new ArrayList<SurchargeModel>();

  @SerializedName("taxes")
  private List<TaxModel> taxes = new ArrayList<TaxModel>();

  @SerializedName("totalCharge")
  private MoneyAmountModel totalCharge = null;

  @SerializedName("totalBeforeTaxes")
  private MoneyAmountModel totalBeforeTaxes = null;

  @SerializedName("exchangeRate")
  private BigDecimal exchangeRate = null;

  @SerializedName("carrierId")
  private String carrierId = null;

  @SerializedName("carrierName")
  private String carrierName = null;

  @SerializedName("serviceId")
  private String serviceId = null;

  @SerializedName("serviceName")
  private String serviceName = null;

  @SerializedName("transitDays")
  private Integer transitDays = null;

  @SerializedName("cutoffTime")
  private String cutoffTime = null;

  @SerializedName("accessTimeInterval")
  private String accessTimeInterval = null;

  @SerializedName("serviceTerms")
  private String serviceTerms = null;

  @SerializedName("quoteId")
  private String quoteId = null;

  public QuoteModel baseCharge(MoneyAmountModel baseCharge) {
    this.baseCharge = baseCharge;
    return this;
  }

   /**
   * Base Charge
   * @return baseCharge
  **/
  public MoneyAmountModel getBaseCharge() {
    return baseCharge;
  }

  public void setBaseCharge(MoneyAmountModel baseCharge) {
    this.baseCharge = baseCharge;
  }

  public QuoteModel surcharges(List<SurchargeModel> surcharges) {
    this.surcharges = surcharges;
    return this;
  }

  public QuoteModel addSurchargesItem(SurchargeModel surchargesItem) {
    this.surcharges.add(surchargesItem);
    return this;
  }

   /**
   * Surcharges
   * @return surcharges
  **/
  public List<SurchargeModel> getSurcharges() {
    return surcharges;
  }

  public void setSurcharges(List<SurchargeModel> surcharges) {
    this.surcharges = surcharges;
  }

  public QuoteModel taxes(List<TaxModel> taxes) {
    this.taxes = taxes;
    return this;
  }

  public QuoteModel addTaxesItem(TaxModel taxesItem) {
    this.taxes.add(taxesItem);
    return this;
  }

   /**
   * Taxes
   * @return taxes
  **/
  public List<TaxModel> getTaxes() {
    return taxes;
  }

  public void setTaxes(List<TaxModel> taxes) {
    this.taxes = taxes;
  }

  public QuoteModel totalCharge(MoneyAmountModel totalCharge) {
    this.totalCharge = totalCharge;
    return this;
  }

   /**
   * Total Charge
   * @return totalCharge
  **/
  public MoneyAmountModel getTotalCharge() {
    return totalCharge;
  }

  public void setTotalCharge(MoneyAmountModel totalCharge) {
    this.totalCharge = totalCharge;
  }

  public QuoteModel totalBeforeTaxes(MoneyAmountModel totalBeforeTaxes) {
    this.totalBeforeTaxes = totalBeforeTaxes;
    return this;
  }

   /**
   * Total Charge before taxes
   * @return totalBeforeTaxes
  **/
  public MoneyAmountModel getTotalBeforeTaxes() {
    return totalBeforeTaxes;
  }

  public void setTotalBeforeTaxes(MoneyAmountModel totalBeforeTaxes) {
    this.totalBeforeTaxes = totalBeforeTaxes;
  }

  public QuoteModel exchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
    return this;
  }

   /**
   * Exchange Rate
   * @return exchangeRate
  **/
  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public QuoteModel carrierId(String carrierId) {
    this.carrierId = carrierId;
    return this;
  }

   /**
   * Carrier Id
   * @return carrierId
  **/
  public String getCarrierId() {
    return carrierId;
  }

  public void setCarrierId(String carrierId) {
    this.carrierId = carrierId;
  }

  public QuoteModel carrierName(String carrierName) {
    this.carrierName = carrierName;
    return this;
  }

   /**
   * Carrier Name
   * @return carrierName
  **/
  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public QuoteModel serviceId(String serviceId) {
    this.serviceId = serviceId;
    return this;
  }

   /**
   * Service Id
   * @return serviceId
  **/
  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public QuoteModel serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Service Name
   * @return serviceName
  **/
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public QuoteModel transitDays(Integer transitDays) {
    this.transitDays = transitDays;
    return this;
  }

   /**
   * Transit time in days
   * @return transitDays
  **/
  public Integer getTransitDays() {
    return transitDays;
  }

  public void setTransitDays(Integer transitDays) {
    this.transitDays = transitDays;
  }

  public QuoteModel cutoffTime(String cutoffTime) {
    this.cutoffTime = cutoffTime;
    return this;
  }

   /**
   * Represents the pickup cutoff time. Usually it is tied to an origin of the shipment
   * @return cutoffTime
  **/
  public String getCutoffTime() {
    return cutoffTime;
  }

  public void setCutoffTime(String cutoffTime) {
    this.cutoffTime = cutoffTime;
  }

  public QuoteModel accessTimeInterval(String accessTimeInterval) {
    this.accessTimeInterval = accessTimeInterval;
    return this;
  }

   /**
   * The minimum required time interval between the ReadyTime and office CloseTime. Default: 2 hrs
   * @return accessTimeInterval
  **/
  public String getAccessTimeInterval() {
    return accessTimeInterval;
  }

  public void setAccessTimeInterval(String accessTimeInterval) {
    this.accessTimeInterval = accessTimeInterval;
  }

  public QuoteModel serviceTerms(String serviceTerms) {
    this.serviceTerms = serviceTerms;
    return this;
  }

   /**
   * Terms of Service
   * @return serviceTerms
  **/
  public String getServiceTerms() {
    return serviceTerms;
  }

  public void setServiceTerms(String serviceTerms) {
    this.serviceTerms = serviceTerms;
  }

  public QuoteModel quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }

   /**
   * Quote Id is uniquely identifies rate request and a quote and can be used to create a shipment based on this rate request and quote. See ShipRequest for details.
   * @return quoteId
  **/
  public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteModel quoteModel = (QuoteModel) o;
    return Objects.equals(this.baseCharge, quoteModel.baseCharge) &&
        Objects.equals(this.surcharges, quoteModel.surcharges) &&
        Objects.equals(this.taxes, quoteModel.taxes) &&
        Objects.equals(this.totalCharge, quoteModel.totalCharge) &&
        Objects.equals(this.totalBeforeTaxes, quoteModel.totalBeforeTaxes) &&
        Objects.equals(this.exchangeRate, quoteModel.exchangeRate) &&
        Objects.equals(this.carrierId, quoteModel.carrierId) &&
        Objects.equals(this.carrierName, quoteModel.carrierName) &&
        Objects.equals(this.serviceId, quoteModel.serviceId) &&
        Objects.equals(this.serviceName, quoteModel.serviceName) &&
        Objects.equals(this.transitDays, quoteModel.transitDays) &&
        Objects.equals(this.cutoffTime, quoteModel.cutoffTime) &&
        Objects.equals(this.accessTimeInterval, quoteModel.accessTimeInterval) &&
        Objects.equals(this.serviceTerms, quoteModel.serviceTerms) &&
        Objects.equals(this.quoteId, quoteModel.quoteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseCharge, surcharges, taxes, totalCharge, totalBeforeTaxes, exchangeRate, carrierId, carrierName, serviceId, serviceName, transitDays, cutoffTime, accessTimeInterval, serviceTerms, quoteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteModel {\n");
    
    sb.append("    baseCharge: ").append(toIndentedString(baseCharge)).append("\n");
    sb.append("    surcharges: ").append(toIndentedString(surcharges)).append("\n");
    sb.append("    taxes: ").append(toIndentedString(taxes)).append("\n");
    sb.append("    totalCharge: ").append(toIndentedString(totalCharge)).append("\n");
    sb.append("    totalBeforeTaxes: ").append(toIndentedString(totalBeforeTaxes)).append("\n");
    sb.append("    exchangeRate: ").append(toIndentedString(exchangeRate)).append("\n");
    sb.append("    carrierId: ").append(toIndentedString(carrierId)).append("\n");
    sb.append("    carrierName: ").append(toIndentedString(carrierName)).append("\n");
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    transitDays: ").append(toIndentedString(transitDays)).append("\n");
    sb.append("    cutoffTime: ").append(toIndentedString(cutoffTime)).append("\n");
    sb.append("    accessTimeInterval: ").append(toIndentedString(accessTimeInterval)).append("\n");
    sb.append("    serviceTerms: ").append(toIndentedString(serviceTerms)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
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

