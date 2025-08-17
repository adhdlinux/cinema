package com.movie.data.model.payment.bitcoin;

public class BitcoinAdressRequest {
    private String address;
    private String deviceID;
    private String deviceName;
    private String email;
    private Boolean isSplitKey;
    private Boolean isTest;
    private int productID;

    public String getAddress() {
        return this.address;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getEmail() {
        return this.email;
    }

    public int getProductID() {
        return this.productID;
    }

    public Boolean getSplitKey() {
        return this.isSplitKey;
    }

    public Boolean getTest() {
        return this.isTest;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setDeviceID(String str) {
        this.deviceID = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setProductID(int i2) {
        this.productID = i2;
    }

    public void setSplitKey(Boolean bool) {
        this.isSplitKey = bool;
    }

    public void setTest(Boolean bool) {
        this.isTest = bool;
    }
}
