package com.applovin.impl.adview.activity.a;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.m;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    final m f13864a;

    /* renamed from: b  reason: collision with root package name */
    final Activity f13865b;

    /* renamed from: c  reason: collision with root package name */
    final e f13866c;

    /* renamed from: d  reason: collision with root package name */
    final ViewGroup f13867d;

    /* renamed from: e  reason: collision with root package name */
    final FrameLayout.LayoutParams f13868e;

    a(e eVar, Activity activity, m mVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f13868e = layoutParams;
        this.f13866c = eVar;
        this.f13864a = mVar;
        this.f13865b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f13867d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void a(e.c cVar, int i2, com.applovin.impl.adview.m mVar) {
        mVar.a(cVar.f15120a, cVar.f15124e, cVar.f15123d, i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mVar.getLayoutParams());
        int i3 = cVar.f15122c;
        layoutParams.setMargins(i3, cVar.f15121b, i3, 0);
        layoutParams.gravity = i2;
        this.f13867d.addView(mVar, layoutParams);
    }
}
