package com.shiptime.demo.dto;

public class CreateShipmentRequestDTO {
    RateRequestDTO rateRequest;
    String carrierId;
    String serviceId;
    ShipmentDetailDTO shipmentDetail;

    public RateRequestDTO getRateRequest() {
        return rateRequest;
    }

    public void setRateRequest(RateRequestDTO rateRequest) {
        this.rateRequest = rateRequest;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ShipmentDetailDTO getShipmentDetail() {
        return shipmentDetail;
    }

    public void setShipmentDetail(ShipmentDetailDTO shipmentDetail) {
        this.shipmentDetail = shipmentDetail;
    }
}
