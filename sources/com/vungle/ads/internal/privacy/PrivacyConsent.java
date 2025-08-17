package com.vungle.ads.internal.privacy;

public enum PrivacyConsent {
    OPT_IN("opted_in"),
    OPT_OUT("opted_out");
    
    private final String value;

    private PrivacyConsent(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
