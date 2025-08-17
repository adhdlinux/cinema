package com.facebook.ads.internal.q.a;

import android.view.View;

public enum j {
    INTERNAL_NO_TAG(0),
    INTERNAL_NO_CLICK(1),
    INTERNAL_API_TOO_LOW(2),
    INTERNAL_WRONG_TAG_CLASS(3),
    INTERNAL_NULL_VIEW(4),
    INTERNAL_AD_ICON(5),
    INTERNAL_AD_TITLE(6),
    INTERNAL_AD_COVER_IMAGE(7),
    INTERNAL_AD_SUBTITLE(8),
    INTERNAL_AD_BODY(9),
    INTERNAL_AD_CALL_TO_ACTION(10),
    INTERNAL_AD_SOCIAL_CONTEXT(11),
    INTERNAL_AD_CHOICES_ICON(12),
    INTERNAL_AD_MEDIA(13);
    

    /* renamed from: o  reason: collision with root package name */
    public static int f20645o;

    /* renamed from: p  reason: collision with root package name */
    private final int f20647p;

    static {
        f20645o = -1593835521;
    }

    private j(int i2) {
        this.f20647p = i2;
    }

    public static void a(View view, j jVar) {
        if (view != null && jVar != null) {
            view.setTag(f20645o, jVar);
        }
    }

    public int a() {
        return this.f20647p;
    }
}
