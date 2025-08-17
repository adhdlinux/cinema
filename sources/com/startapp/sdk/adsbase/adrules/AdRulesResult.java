package com.startapp.sdk.adsbase.adrules;

import java.io.Serializable;

public class AdRulesResult implements Serializable {
    private static final long serialVersionUID = 1;
    private String reason;
    private boolean shouldDisplayAd;

    public AdRulesResult(boolean z2, String str) {
        this.shouldDisplayAd = z2;
        this.reason = str;
    }

    public String a() {
        String str = this.reason;
        if (str != null) {
            return str.split(" ")[0];
        }
        return "";
    }

    public boolean b() {
        return this.shouldDisplayAd;
    }
}
