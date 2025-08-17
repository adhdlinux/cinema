package com.original.tase.model.debrid.premiumize;

public class PremiumizeCredentialsInfo {
    private String apikey;
    private long premium_until;

    public String getAccessToken() {
        return this.apikey;
    }

    public long getPremium_until() {
        return this.premium_until;
    }

    public boolean isValid() {
        String str = this.apikey;
        return str != null && !str.isEmpty();
    }

    public void setAccessToken(String str) {
        this.apikey = str;
    }

    public void setPremium_until(long j2) {
        this.premium_until = j2;
    }
}
