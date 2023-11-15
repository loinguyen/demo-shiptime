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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;


/**
 * Represents pickup information either in a request or in response. The pickup address will be the origin address of the shipment.
 */
public class PickupDetailModel   {
  /**
   * Location of pickup
   */
  public enum LocationEnum {
    @SerializedName("FrontDoor")
    FRONTDOOR("FrontDoor"),
    
    @SerializedName("Office")
    OFFICE("Office"),
    
    @SerializedName("Lobby")
    LOBBY("Lobby"),
    
    @SerializedName("MailRoom")
    MAILROOM("MailRoom"),
    
    @SerializedName("Mailbox")
    MAILBOX("Mailbox"),
    
    @SerializedName("PartsDepartment")
    PARTSDEPARTMENT("PartsDepartment"),
    
    @SerializedName("Pharmacy")
    PHARMACY("Pharmacy"),
    
    @SerializedName("Receiving")
    RECEIVING("Receiving"),
    
    @SerializedName("Reception")
    RECEPTION("Reception"),
    
    @SerializedName("ServiceCounter")
    SERVICECOUNTER("ServiceCounter"),
    
    @SerializedName("SideDoor")
    SIDEDOOR("SideDoor"),
    
    @SerializedName("BackDoor")
    BACKDOOR("BackDoor"),
    
    @SerializedName("Basement")
    BASEMENT("Basement"),
    
    @SerializedName("Garage")
    GARAGE("Garage"),
    
    @SerializedName("Shipping")
    SHIPPING("Shipping"),
    
    @SerializedName("Kiosk")
    KIOSK("Kiosk"),
    
    @SerializedName("LoadingDock")
    LOADINGDOCK("LoadingDock"),
    
    @SerializedName("Warehouse")
    WAREHOUSE("Warehouse"),
    
    @SerializedName("Other")
    OTHER("Other");

    private String value;

    LocationEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonValue
    public String getValue() {
      return this.value;
    }
  }

  @SerializedName("location")
  private LocationEnum location = null;

  @SerializedName("otherLocation")
  private String otherLocation = null;

  @SerializedName("pickupDate")
  private String pickupDate = null;

  @SerializedName("readyTime")
  private String readyTime = null;

  @SerializedName("closeTime")
  private String closeTime = null;

  public PickupDetailModel location(LocationEnum location) {
    this.location = location;
    return this;
  }

   /**
   * Location of pickup
   * @return location
  **/
  public LocationEnum getLocation() {
    return location;
  }

  public void setLocation(LocationEnum location) {
    this.location = location;
  }

  public PickupDetailModel otherLocation(String otherLocation) {
    this.otherLocation = otherLocation;
    return this;
  }

   /**
   * Other location of pickup
   * @return otherLocation
  **/
  public String getOtherLocation() {
    return otherLocation;
  }

  public void setOtherLocation(String otherLocation) {
    this.otherLocation = otherLocation;
  }

  public PickupDetailModel pickupDate(String pickupDate) {
    this.pickupDate = pickupDate;
    return this;
  }

   /**
   * The date of the pickup. Has to be on a business day in most cases. (Format: \"yyyy-MM-dd\")
   * @return pickupDate
  **/
  public String getPickupDate() {
    return pickupDate;
  }

  public void setPickupDate(String pickupDate) {
    this.pickupDate = pickupDate;
  }

  public PickupDetailModel readyTime(String readyTime) {
    this.readyTime = readyTime;
    return this;
  }

   /**
   * The time the shipments will be ready for pickup in 24 hour format. (Format: \"HH:mm\")
   * @return readyTime
  **/
  public String getReadyTime() {
    return readyTime;
  }

  public void setReadyTime(String readyTime) {
    this.readyTime = readyTime;
  }

  public PickupDetailModel closeTime(String closeTime) {
    this.closeTime = closeTime;
    return this;
  }

   /**
   * Latest time the pickup can be done in 24 hour format. Cannot be later than pickup cutoff time provided along with the rate quote. Normally there must be few hours interval between readyTime and closeTime. (Format: \"HH:mm\")
   * @return closeTime
  **/
  public String getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(String closeTime) {
    this.closeTime = closeTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PickupDetailModel pickupDetailModel = (PickupDetailModel) o;
    return Objects.equals(this.location, pickupDetailModel.location) &&
        Objects.equals(this.otherLocation, pickupDetailModel.otherLocation) &&
        Objects.equals(this.pickupDate, pickupDetailModel.pickupDate) &&
        Objects.equals(this.readyTime, pickupDetailModel.readyTime) &&
        Objects.equals(this.closeTime, pickupDetailModel.closeTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, otherLocation, pickupDate, readyTime, closeTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PickupDetailModel {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    otherLocation: ").append(toIndentedString(otherLocation)).append("\n");
    sb.append("    pickupDate: ").append(toIndentedString(pickupDate)).append("\n");
    sb.append("    readyTime: ").append(toIndentedString(readyTime)).append("\n");
    sb.append("    closeTime: ").append(toIndentedString(closeTime)).append("\n");
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
