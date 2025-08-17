package com.chartboost.sdk;

import com.chartboost.sdk.impl.z7;

public class Mediation {
    public final String adapterVersion;
    public final String libraryVersion;
    public final String mediationType;

    public Mediation(String str, String str2, String str3) {
        this.mediationType = a(str);
        this.libraryVersion = str2;
        this.adapterVersion = str3;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace(" ", "_");
        return replace.length() > 50 ? replace.substring(0, 50) : replace;
    }

    public z7 toMediationBodyFields() {
        if (this.mediationType == null) {
            return null;
        }
        String str = this.libraryVersion;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = this.adapterVersion;
        if (str3 != null) {
            str2 = str3;
        }
        return new z7(a(), str, str2);
    }

    public final String a() {
        String str = this.libraryVersion;
        if (str == null || str.isEmpty()) {
            return this.mediationType;
        }
        return this.mediationType + " " + this.libraryVersion;
    }
}
