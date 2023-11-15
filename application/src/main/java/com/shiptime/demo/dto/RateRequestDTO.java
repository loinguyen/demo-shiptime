package com.shiptime.demo.dto;

public class RateRequestDTO {
    private AddressDTO from;
    private AddressDTO to;
    private String shipDate;
    private PackageDTO packageDetail;

    public AddressDTO getFrom() {
        return from;
    }

    public void setFrom(AddressDTO from) {
        this.from = from;
    }

    public AddressDTO getTo() {
        return to;
    }

    public void setTo(AddressDTO to) {
        this.to = to;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public PackageDTO getPackageDetail() {
        return packageDetail;
    }

    public void setPackageDetail(PackageDTO packageDetail) {
        this.packageDetail = packageDetail;
    }

    @Override
    public String toString() {
        return "RateRequestDTO{" +
                "from=" + from +
                ", to=" + to +
                ", shipDate='" + shipDate + '\'' +
                ", packageDetail=" + packageDetail +
                '}' + '\n';
    }
}
