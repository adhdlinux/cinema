package com.google.android.exoplayer2.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;

public final class CaptionStyleCompat {

    /* renamed from: g  reason: collision with root package name */
    public static final CaptionStyleCompat f27844g = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f27845a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27846b;

    /* renamed from: c  reason: collision with root package name */
    public final int f27847c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27848d;

    /* renamed from: e  reason: collision with root package name */
    public final int f27849e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f27850f;

    public CaptionStyleCompat(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f27845a = i2;
        this.f27846b = i3;
        this.f27847c = i4;
        this.f27848d = i5;
        this.f27849e = i6;
        this.f27850f = typeface;
    }

    public static CaptionStyleCompat a(CaptioningManager.CaptionStyle captionStyle) {
        if (Util.f28808a >= 21) {
            return c(captionStyle);
        }
        return b(captionStyle);
    }

    private static CaptionStyleCompat b(CaptioningManager.CaptionStyle captionStyle) {
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static CaptionStyleCompat c(CaptioningManager.CaptionStyle captionStyle) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (captionStyle.hasForegroundColor()) {
            i2 = captionStyle.foregroundColor;
        } else {
            i2 = f27844g.f27845a;
        }
        int i7 = i2;
        if (captionStyle.hasBackgroundColor()) {
            i3 = captionStyle.backgroundColor;
        } else {
            i3 = f27844g.f27846b;
        }
        int i8 = i3;
        if (captionStyle.hasWindowColor()) {
            i4 = captionStyle.windowColor;
        } else {
            i4 = f27844g.f27847c;
        }
        int i9 = i4;
        if (captionStyle.hasEdgeType()) {
            i5 = captionStyle.edgeType;
        } else {
            i5 = f27844g.f27848d;
        }
        int i10 = i5;
        if (captionStyle.hasEdgeColor()) {
            i6 = captionStyle.edgeColor;
        } else {
            i6 = f27844g.f27849e;
        }
        return new CaptionStyleCompat(i7, i8, i9, i10, i6, captionStyle.getTypeface());
    }
}
