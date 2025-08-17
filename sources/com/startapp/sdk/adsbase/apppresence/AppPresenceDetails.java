package com.startapp.sdk.adsbase.apppresence;

import java.io.Serializable;

public class AppPresenceDetails implements Serializable {
    private static final long serialVersionUID = 1;
    private int adAttempt;
    private boolean appPresence = false;
    private boolean isShown = true;
    private int minAppVersion;
    private String packageName;
    private String trackingUrl;

    public AppPresenceDetails(String str, String str2, int i2, int i3) {
        this.trackingUrl = str;
        this.packageName = str2;
        this.adAttempt = i2;
        this.minAppVersion = i3;
    }

    public void a(String str) {
        this.trackingUrl = str;
    }

    public String b() {
        return this.packageName;
    }

    public String c() {
        return this.trackingUrl;
    }

    public boolean d() {
        return this.appPresence;
    }

    public boolean e() {
        return this.isShown;
    }

    public void a(boolean z2) {
        this.appPresence = z2;
    }

    public void b(boolean z2) {
        this.isShown = z2;
    }

    public int a() {
        return this.minAppVersion;
    }
}
