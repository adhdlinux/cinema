package com.original.tase.model.debrid.alldebrid;

public class AllDebridCredentialsInfo {
    private boolean activated;
    private String apikey;
    private long expires_in;
    private String pin;

    public String getApikey() {
        return this.apikey;
    }

    public long getExpires_in() {
        return this.expires_in;
    }

    public String getPin() {
        return this.pin;
    }

    public boolean isValid() {
        String str = this.apikey;
        return str != null && !str.isEmpty();
    }

    public void setApiKey(String str, long j2) {
        this.apikey = str;
        this.expires_in = j2;
    }

    public void setExpires_in(long j2) {
        this.expires_in = j2;
    }

    public void setPin(String str) {
        this.pin = str;
    }
}
