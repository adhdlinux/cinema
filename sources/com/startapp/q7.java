package com.startapp;

import com.startapp.sdk.adsbase.model.AdPreferences;

public class q7 implements Comparable<q7> {

    /* renamed from: a  reason: collision with root package name */
    public long f35682a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public AdPreferences.Placement f35683b;

    /* renamed from: c  reason: collision with root package name */
    public String f35684c;

    public q7(AdPreferences.Placement placement, String str) {
        this.f35683b = placement;
        this.f35684c = str == null ? "" : str;
    }

    public int compareTo(Object obj) {
        int i2 = ((this.f35682a - ((q7) obj).f35682a) > 0 ? 1 : ((this.f35682a - ((q7) obj).f35682a) == 0 ? 0 : -1));
        if (i2 > 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return -1;
    }

    public String toString() {
        return "AdDisplayEvent [displayTime=" + this.f35682a + ", placement=" + this.f35683b + ", adTag=" + this.f35684c + "]";
    }
}
