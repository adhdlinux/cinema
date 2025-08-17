package com.facebook.ads.internal.view.component.a.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.c.a.a;
import com.facebook.ads.internal.view.component.h;

public class d extends b {

    /* renamed from: c  reason: collision with root package name */
    private static final int f21081c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f21082d;

    static {
        float f2 = x.f20694b;
        f21081c = (int) (20.0f * f2);
        f21082d = (int) (f2 * 16.0f);
    }

    d(com.facebook.ads.internal.view.component.a.d dVar, com.facebook.ads.internal.adapters.a.d dVar2, String str, a aVar) {
        super(dVar, dVar2, false, str, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        h titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        titleDescContainer.setPadding(0, 0, 0, f21081c);
        getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(context);
        x.a((View) linearLayout, (Drawable) new ColorDrawable(-1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, getMediaContainer().getId());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        int i2 = f21082d;
        linearLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(titleDescContainer);
        linearLayout.addView(getCtaButton());
        addView(getMediaContainer());
        addView(linearLayout);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }
}
