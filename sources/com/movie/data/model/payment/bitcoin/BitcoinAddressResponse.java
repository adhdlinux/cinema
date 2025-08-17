package com.movie.data.model.payment.bitcoin;

public class BitcoinAddressResponse {
    private String address;
    private String btc;
    private Integer code;
    private Boolean isSplitKey;
    private String message;
    private Long remaining;
    private Long user_action_time;

    public String getAddress() {
        return this.address;
    }

    public String getBtc() {
        return this.btc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Long getRemainingTime() {
        return this.remaining;
    }

    public Boolean getSplitKey() {
        return this.isSplitKey;
    }

    public Long getUser_action_time() {
        return this.user_action_time;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBtc(String str) {
        this.btc = str;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRemainingTime(Long l2) {
        this.remaining = l2;
    }

    public void setSplitKey(Boolean bool) {
        this.isSplitKey = bool;
    }

    public void setUser_action_time(Long l2) {
        this.user_action_time = l2;
    }
}
