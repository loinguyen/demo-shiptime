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
 * An amount and a currency
 */
public class MoneyAmountModel   {
  /**
   * Currency (USD or CAD)
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

  @SerializedName("amount")
  private Integer amount = null;

  public MoneyAmountModel currency(CurrencyEnum currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Currency (USD or CAD)
   * @return currency
  **/
  public CurrencyEnum getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyEnum currency) {
    this.currency = currency;
  }

  public MoneyAmountModel amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Money amount in cents
   * @return amount
  **/
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneyAmountModel moneyAmountModel = (MoneyAmountModel) o;
    return Objects.equals(this.currency, moneyAmountModel.currency) &&
        Objects.equals(this.amount, moneyAmountModel.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyAmountModel {\n");
    
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

