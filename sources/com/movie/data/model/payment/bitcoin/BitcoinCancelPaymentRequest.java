package com.movie.data.model.payment.bitcoin;

public class BitcoinCancelPaymentRequest {
    private String address;
    private String deviceID;
    private String email;

    public String getAddress() {
        return this.address;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getEmail() {
        return this.email;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }
}
