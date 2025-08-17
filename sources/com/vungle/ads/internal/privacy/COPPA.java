package com.vungle.ads.internal.privacy;

public enum COPPA {
    COPPA_ENABLED(Boolean.TRUE),
    COPPA_DISABLED(Boolean.FALSE),
    COPPA_NOTSET((String) null);
    
    private final Boolean value;

    private COPPA(Boolean bool) {
        this.value = bool;
    }

    public final Boolean getValue() {
        return this.value;
    }
}
