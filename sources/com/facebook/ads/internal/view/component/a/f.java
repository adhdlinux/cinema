package com.facebook.ads.internal.view.component.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.component.h;

final class f extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final View f21114a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.ads.internal.view.component.f f21115b;

    public f(Context context, View view) {
        super(context);
        this.f21114a = view;
        com.facebook.ads.internal.view.component.f fVar = new com.facebook.ads.internal.view.component.f(context);
        this.f21115b = fVar;
        x.a((View) fVar);
    }

    public void a(int i2) {
        this.f21114a.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
    }

    public void a(View view, View view2, h hVar, boolean z2) {
        this.f21115b.addView(this.f21114a, new RelativeLayout.LayoutParams(-1, -2));
        if (view2 != null) {
            int i2 = b.f21084b;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(6, this.f21114a.getId());
            layoutParams.addRule(7, this.f21114a.getId());
            int i3 = b.f21083a;
            layoutParams.setMargins(i3, i3, i3, i3);
            this.f21115b.addView(view2, layoutParams);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(8, this.f21114a.getId());
        if (hVar != null) {
            if (z2) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                hVar.setAlignment(3);
                int i4 = b.f21083a;
                layoutParams3.setMargins(i4 / 2, i4 / 2, i4 / 2, i4 / 2);
                linearLayout.addView(hVar, layoutParams3);
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
                gradientDrawable.setCornerRadius(0.0f);
                gradientDrawable.setGradientType(0);
                x.a((View) linearLayout, (Drawable) gradientDrawable);
            } else {
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams4.addRule(3, this.f21115b.getId());
                layoutParams4.setMargins(0, b.f21083a, 0, 0);
                hVar.setAlignment(17);
                addView(hVar, layoutParams4);
            }
        }
        if (view != null) {
            linearLayout.addView(view, new RelativeLayout.LayoutParams(-1, -2));
        }
        this.f21115b.addView(linearLayout, layoutParams2);
        addView(this.f21115b, new RelativeLayout.LayoutParams(-1, -2));
    }
}
