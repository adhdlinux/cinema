package com.original.tase.model.debrid.realdebrid;

public class RealDebridGetDeviceCodeResult {
    private String device_code;
    private String direct_verification_url;
    private int expires_in;
    private int interval;
    private String user_code;
    private String verification_url;

    public String getDevice_code() {
        return this.device_code;
    }

    public String getDirect_verification_url() {
        return this.direct_verification_url;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getUser_code() {
        return this.user_code;
    }

    public String getVerification_url() {
        return this.verification_url;
    }

    public void setDevice_code(String str) {
        this.device_code = str;
    }

    public void setDirect_verification_url(String str) {
        this.direct_verification_url = str;
    }

    public void setExpires_in(int i2) {
        this.expires_in = i2;
    }

    public void setInterval(int i2) {
        this.interval = i2;
    }

    public void setUser_code(String str) {
        this.user_code = str;
    }

    public void setVerification_url(String str) {
        this.verification_url = str;
    }
}
