package com.facebook.ads.internal.protocol;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.h;
import java.util.HashMap;
import java.util.Map;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<e, f> f20583a;

    static {
        HashMap hashMap = new HashMap();
        f20583a = hashMap;
        hashMap.put(e.RECTANGLE_HEIGHT_250, f.WEBVIEW_BANNER_250);
        hashMap.put(e.BANNER_HEIGHT_90, f.WEBVIEW_BANNER_90);
        hashMap.put(e.BANNER_HEIGHT_50, f.WEBVIEW_BANNER_50);
    }

    public static f a(DisplayMetrics displayMetrics) {
        float f2 = displayMetrics.density;
        int i2 = (int) (((float) displayMetrics.widthPixels) / f2);
        int i3 = (int) (((float) displayMetrics.heightPixels) / f2);
        return h.a(i2, i3) ? f.WEBVIEW_INTERSTITIAL_TABLET : i3 > i2 ? f.WEBVIEW_INTERSTITIAL_VERTICAL : f.WEBVIEW_INTERSTITIAL_HORIZONTAL;
    }

    public static f a(e eVar) {
        f fVar = f20583a.get(eVar);
        return fVar == null ? f.WEBVIEW_BANNER_LEGACY : fVar;
    }

    public static void a(DisplayMetrics displayMetrics, View view, e eVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= eVar.a() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) eVar.a()) * displayMetrics.density)), (int) Math.ceil((double) (((float) eVar.b()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
