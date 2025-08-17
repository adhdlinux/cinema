package com.facebook.ads.internal.view.component.a;

import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.h;

public class e extends b {

    /* renamed from: c  reason: collision with root package name */
    private static final int f21112c = Resources.getSystem().getDisplayMetrics().widthPixels;

    /* renamed from: d  reason: collision with root package name */
    private final f f21113d;

    public e(d dVar, boolean z2, d dVar2) {
        super(dVar, dVar2, z2);
        f fVar = new f(dVar.a(), dVar.d());
        this.f21113d = fVar;
        fVar.a(dVar.h(), dVar.i(), getTitleDescContainer(), z2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        int i2 = b.f21083a;
        layoutParams.setMargins(i2, i2, i2, i2);
        getCtaButton().setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(dVar.a());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(i2, 0, i2, 0);
        frameLayout.addView(fVar, layoutParams3);
        addView(frameLayout);
        addView(getCtaButton());
    }

    public void a(h hVar, String str, double d2) {
        super.a(hVar, str, d2);
        if (d2 > 0.0d) {
            this.f21113d.a((int) (((double) (f21112c - (b.f21083a * 2))) / d2));
        }
    }

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }
}
