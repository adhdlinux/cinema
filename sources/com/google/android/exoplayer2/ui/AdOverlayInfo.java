package com.google.android.exoplayer2.ui;

import android.view.View;

public final class AdOverlayInfo {

    /* renamed from: a  reason: collision with root package name */
    public final View f27827a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27828b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27829c;

    @Deprecated
    public AdOverlayInfo(View view, int i2) {
        this(view, i2, (String) null);
    }

    @Deprecated
    public AdOverlayInfo(View view, int i2, String str) {
        this.f27827a = view;
        this.f27828b = i2;
        this.f27829c = str;
    }
}
