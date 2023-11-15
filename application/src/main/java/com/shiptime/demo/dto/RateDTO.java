package com.shiptime.demo.dto;

import java.math.BigDecimal;

public class RateDTO {
    String carrier;
    String service;
    Integer estimateDelivery;
    String carrierId;
    String servicesId;
    BigDecimal totalPrice;
    BigDecimal totalPriceBeforeTax;
    String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getService() {
        return service;
    }

    public void setService(String services) {
        this.service = services;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getServicesId() {
        return servicesId;
    }

    public void setServicesId(String servicesId) {
        this.servicesId = servicesId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPriceBeforeTax() {
        return totalPriceBeforeTax;
    }

    public void setTotalPriceBeforeTax(BigDecimal totalPriceBeforeTax) {
        this.totalPriceBeforeTax = totalPriceBeforeTax;
    }

    public Integer getEstimateDelivery() {
        return estimateDelivery;
    }

    public void setEstimateDelivery(Integer estimateDelivery) {
        this.estimateDelivery = estimateDelivery;
    }
}
