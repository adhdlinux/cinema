package com.facebook.ads.internal.view.component.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.q.a.x;

public class a extends b {
    public a(d dVar, d dVar2, boolean z2) {
        super(dVar, dVar2, true);
        RelativeLayout relativeLayout = new RelativeLayout(dVar.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.setGradientType(0);
        x.a((View) relativeLayout, (Drawable) gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(dVar.a());
        linearLayout.setOrientation(z2 ^ true ? 1 : 0);
        linearLayout.setGravity(80);
        x.a((View) linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        int i2 = dVar.h() == null ? b.f21083a : b.f21083a / 2;
        int i3 = b.f21083a;
        layoutParams2.setMargins(i3, 0, i3, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z2 ? -2 : -1, -2);
        layoutParams3.setMargins(z2 ? i3 : 0, z2 ? 0 : i3, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z2 ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        if (dVar.h() != null) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams5.setMargins(0, 0, 0, 0);
            layoutParams5.addRule(3, linearLayout.getId());
            relativeLayout.addView(dVar.h(), layoutParams5);
        }
        addView(dVar.d(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
        if (dVar.i() != null) {
            int i4 = b.f21084b;
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i4, i4);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            layoutParams6.setMargins(i3, dVar.j() + i3, i3, i3);
            addView(dVar.i(), layoutParams6);
        }
    }

    public boolean a() {
        return true;
    }
}
