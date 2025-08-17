package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import com.facebook.imageutils.JfifUtil;

public class RippleUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29943a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f29944b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f29945c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f29946d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f29947e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f29948f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f29949g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f29950h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f29951i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f29952j = {16842913};

    private RippleUtils() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f29943a) {
            return new ColorStateList(new int[][]{f29952j, StateSet.NOTHING}, new int[]{c(colorStateList, f29948f), c(colorStateList, f29944b)});
        }
        int[] iArr = f29948f;
        int[] iArr2 = f29949g;
        int[] iArr3 = f29950h;
        int[] iArr4 = f29951i;
        int[] iArr5 = f29944b;
        int[] iArr6 = f29945c;
        int[] iArr7 = f29946d;
        int[] iArr8 = f29947e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f29952j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i2) {
        return ColorUtils.p(i2, Math.min(Color.alpha(i2) * 2, JfifUtil.MARKER_FIRST_BYTE));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int i2;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i2 = 0;
        }
        if (f29943a) {
            return b(i2);
        }
        return i2;
    }
}
