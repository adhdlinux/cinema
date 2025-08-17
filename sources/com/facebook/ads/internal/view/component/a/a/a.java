package com.facebook.ads.internal.view.component.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.component.a.d;
import com.facebook.ads.internal.view.component.h;

public class a extends b {

    /* renamed from: c  reason: collision with root package name */
    private static final int f21054c = ((int) (x.f20694b * 12.0f));

    a(d dVar, com.facebook.ads.internal.adapters.a.d dVar2, String str, com.facebook.ads.internal.view.c.a.a aVar) {
        super(dVar, dVar2, true, str, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        h titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, getMediaContainer().getId());
        titleDescContainer.setLayoutParams(layoutParams);
        int i2 = f21054c;
        titleDescContainer.setPadding(i2, i2, i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        x.a((View) titleDescContainer, (Drawable) gradientDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, getMediaContainer().getId());
        getCtaButton().setLayoutParams(layoutParams2);
        addView(getMediaContainer());
        addView(titleDescContainer);
        addView(getCtaButton());
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }
}
