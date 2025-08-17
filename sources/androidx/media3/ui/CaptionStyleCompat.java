package androidx.media3.ui;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import androidx.media3.common.util.Util;

public final class CaptionStyleCompat {

    /* renamed from: g  reason: collision with root package name */
    public static final CaptionStyleCompat f9766g = new CaptionStyleCompat(-1, -16777216, 0, 0, -1, (Typeface) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f9767a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9768b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9769c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9770d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9771e;

    /* renamed from: f  reason: collision with root package name */
    public final Typeface f9772f;

    public CaptionStyleCompat(int i2, int i3, int i4, int i5, int i6, Typeface typeface) {
        this.f9767a = i2;
        this.f9768b = i3;
        this.f9769c = i4;
        this.f9770d = i5;
        this.f9771e = i6;
        this.f9772f = typeface;
    }

    public static CaptionStyleCompat a(CaptioningManager.CaptionStyle captionStyle) {
        if (Util.f4714a >= 21) {
            return b(captionStyle);
        }
        return new CaptionStyleCompat(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static CaptionStyleCompat b(CaptioningManager.CaptionStyle captionStyle) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (captionStyle.hasForegroundColor()) {
            i2 = captionStyle.foregroundColor;
        } else {
            i2 = f9766g.f9767a;
        }
        int i7 = i2;
        if (captionStyle.hasBackgroundColor()) {
            i3 = captionStyle.backgroundColor;
        } else {
            i3 = f9766g.f9768b;
        }
        int i8 = i3;
        if (captionStyle.hasWindowColor()) {
            i4 = captionStyle.windowColor;
        } else {
            i4 = f9766g.f9769c;
        }
        int i9 = i4;
        if (captionStyle.hasEdgeType()) {
            i5 = captionStyle.edgeType;
        } else {
            i5 = f9766g.f9770d;
        }
        int i10 = i5;
        if (captionStyle.hasEdgeColor()) {
            i6 = captionStyle.edgeColor;
        } else {
            i6 = f9766g.f9771e;
        }
        return new CaptionStyleCompat(i7, i8, i9, i10, i6, captionStyle.getTypeface());
    }
}
