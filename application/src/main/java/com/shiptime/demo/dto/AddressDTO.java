package com.shiptime.demo.dto;

public class AddressDTO {
    private String company;
    private String streetAdd;
    private String streetAdd2;
    private String city;
    private String countryCode;
    private String state;
    private String postalCode;
    private String attention;
    private String email;
    private String phone;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreetAdd() {
        return streetAdd;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
    }

    public String getStreetAdd2() {
        return streetAdd2;
    }

    public void setStreetAdd2(String streetAdd2) {
        this.streetAdd2 = streetAdd2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "company='" + company + '\'' +
                ", streetAdd='" + streetAdd + '\'' +
                ", streetAdd2='" + streetAdd2 + '\'' +
                ", city='" + city + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", attention='" + attention + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}' + '\n';
    }
}
