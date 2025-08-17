package com.facebook.ads.internal.view.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.component.e;
import com.facebook.ads.internal.view.component.h;

public class a extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21145a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21146b;

    /* renamed from: c  reason: collision with root package name */
    private static final RelativeLayout.LayoutParams f21147c = new RelativeLayout.LayoutParams(-1, -1);

    /* renamed from: d  reason: collision with root package name */
    private final k f21148d;

    static {
        float f2 = x.f20694b;
        f21145a = (int) (72.0f * f2);
        f21146b = (int) (f2 * 16.0f);
    }

    public a(Context context, k kVar) {
        super(context);
        this.f21148d = kVar;
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        e eVar = new e(getContext());
        x.a((View) eVar, 0);
        eVar.setRadius(50);
        new d((ImageView) eVar).a().a(this.f21148d.a().b());
        int i2 = f21145a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        h hVar = new h(getContext(), this.f21148d.d().a(), true, false, true);
        hVar.a(this.f21148d.b().a(), this.f21148d.b().b(), false, true);
        hVar.setAlignment(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = f21146b;
        layoutParams2.setMargins(0, i3, 0, i3);
        TextView textView = new TextView(getContext());
        textView.setTextColor(-1);
        x.a(textView, false, 16);
        textView.setText(this.f21148d.e().j().c());
        textView.setPadding(i3, i3 / 2, i3, i3 / 2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, i3 / 2, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(100.0f);
        gradientDrawable.setColor(469762047);
        x.a((View) textView, (Drawable) gradientDrawable);
        linearLayout.addView(eVar, layoutParams);
        linearLayout.addView(hVar, layoutParams2);
        linearLayout.addView(textView, layoutParams3);
        x.a((View) this, -14473425);
        addView(linearLayout, f21147c);
    }
}
