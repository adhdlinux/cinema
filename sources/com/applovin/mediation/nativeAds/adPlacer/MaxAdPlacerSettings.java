package com.applovin.mediation.nativeAds.adPlacer;

import com.applovin.impl.sdk.v;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Set;
import java.util.TreeSet;

public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;

    /* renamed from: a  reason: collision with root package name */
    private final String f16026a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f16027b = new TreeSet();

    /* renamed from: c  reason: collision with root package name */
    private int f16028c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f16029d = UserVerificationMethods.USER_VERIFY_HANDPRINT;

    /* renamed from: e  reason: collision with root package name */
    private int f16030e = 4;

    public MaxAdPlacerSettings(String str) {
        this.f16026a = str;
    }

    public void addFixedPosition(int i2) {
        this.f16027b.add(Integer.valueOf(i2));
    }

    public String getAdUnitId() {
        return this.f16026a;
    }

    public Set<Integer> getFixedPositions() {
        return this.f16027b;
    }

    public int getMaxAdCount() {
        return this.f16029d;
    }

    public int getMaxPreloadedAdCount() {
        return this.f16030e;
    }

    public int getRepeatingInterval() {
        return this.f16028c;
    }

    public boolean hasValidPositioning() {
        return !this.f16027b.isEmpty() || isRepeatingEnabled();
    }

    public boolean isRepeatingEnabled() {
        return this.f16028c >= 2;
    }

    public void resetFixedPositions() {
        this.f16027b.clear();
    }

    public void setMaxAdCount(int i2) {
        this.f16029d = i2;
    }

    public void setMaxPreloadedAdCount(int i2) {
        this.f16030e = i2;
    }

    public void setRepeatingInterval(int i2) {
        if (i2 >= 2) {
            this.f16028c = i2;
            v.f("MaxAdPlacerSettings", "Repeating interval set to " + i2);
            return;
        }
        this.f16028c = 0;
        v.h("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i2 + ", which is less than minimum value of " + 2);
    }

    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.f16026a + '\'' + ", fixedPositions=" + this.f16027b + ", repeatingInterval=" + this.f16028c + ", maxAdCount=" + this.f16029d + ", maxPreloadedAdCount=" + this.f16030e + '}';
    }
}
