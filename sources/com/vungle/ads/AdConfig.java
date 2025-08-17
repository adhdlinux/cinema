package com.vungle.ads;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public class AdConfig {
    public static final int AUTO_ROTATE = 2;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int IMMEDIATE_BACK = 2;
    public static final int LANDSCAPE = 1;
    public static final int PORTRAIT = 0;
    private static final String WATERMARK = "WATERMARK";
    private int adOrientation = 2;
    private Map<String, String> extras = new LinkedHashMap();
    private int settings;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void getAdOrientation$annotations() {
    }

    public final int getAdOrientation() {
        return this.adOrientation;
    }

    public final int getSettings() {
        return this.settings;
    }

    public final String getWatermark$vungle_ads_release() {
        return this.extras.get(WATERMARK);
    }

    public final void setAdOrientation(int i2) {
        this.adOrientation = i2;
    }

    public final void setBackButtonImmediatelyEnabled(boolean z2) {
        int i2;
        if (z2) {
            i2 = this.settings | 2;
        } else {
            i2 = this.settings & -3;
        }
        this.settings = i2;
    }

    public final void setWatermark(String str) {
        Intrinsics.f(str, "watermark");
        this.extras.put(WATERMARK, str);
    }
}
