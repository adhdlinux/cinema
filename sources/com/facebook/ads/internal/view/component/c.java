package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdIconView;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.m;
import com.facebook.ads.internal.view.q;

public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private AdIconView f21118a;

    /* renamed from: b  reason: collision with root package name */
    private b f21119b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21120c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f21121d = new LinearLayout(getContext());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, f fVar, k kVar, AdIconView adIconView, boolean z2, int i2) {
        super(context);
        k kVar2 = kVar;
        boolean z3 = z2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        setVerticalGravity(16);
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f), Math.round(displayMetrics.density * 15.0f));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        this.f21121d.setOrientation(0);
        this.f21121d.setGravity(16);
        layoutParams2.weight = 3.0f;
        this.f21121d.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f21121d);
        this.f21118a = adIconView;
        float a2 = (float) a(z3, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Math.round(displayMetrics.density * a2), Math.round(a2 * displayMetrics.density));
        layoutParams3.setMargins(0, 0, Math.round(displayMetrics.density * 15.0f), 0);
        this.f21118a.setLayoutParams(layoutParams3);
        this.f21121d.addView(this.f21118a);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        this.f21121d.addView(linearLayout2);
        this.f21119b = new b(getContext(), fVar, kVar2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.setMargins(0, 0, Math.round(displayMetrics.density * 15.0f), 0);
        layoutParams4.weight = 0.5f;
        this.f21119b.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.f21119b);
        TextView textView = new TextView(getContext());
        this.f21120c = textView;
        textView.setPadding(Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f), Math.round(displayMetrics.density * 6.0f));
        this.f21120c.setText(fVar.q());
        this.f21120c.setTextColor(kVar.f());
        this.f21120c.setTextSize(14.0f);
        this.f21120c.setTypeface(kVar.a(), 1);
        this.f21120c.setMaxLines(2);
        this.f21120c.setEllipsize(TextUtils.TruncateAt.END);
        this.f21120c.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(kVar.e());
        gradientDrawable.setCornerRadius(displayMetrics.density * 5.0f);
        gradientDrawable.setStroke(1, kVar.g());
        x.a((View) this.f21120c, (Drawable) gradientDrawable);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.weight = 0.25f;
        this.f21120c.setLayoutParams(layoutParams5);
        if (!fVar.i()) {
            this.f21120c.setVisibility(4);
        }
        linearLayout2.addView(this.f21120c);
        if (z3) {
            q qVar = new q(getContext());
            qVar.setText(fVar.o());
            m.b(qVar, kVar2);
            qVar.setMinTextSize((float) (kVar.i() - 1));
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams6.weight = 1.0f;
            qVar.setLayoutParams(layoutParams6);
            qVar.setGravity(80);
            linearLayout.addView(qVar);
        }
    }

    private int a(boolean z2, int i2) {
        return (int) (((double) (i2 - 30)) * (3.0d / ((double) ((z2 ? 1 : 0) + true))));
    }

    public TextView getCallToActionView() {
        return this.f21120c;
    }

    public AdIconView getIconView() {
        return this.f21118a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        TextView titleTextView = this.f21119b.getTitleTextView();
        if (titleTextView.getLayout().getLineEnd(titleTextView.getLineCount() - 1) < this.f21119b.getMinVisibleTitleCharacters()) {
            this.f21121d.removeView(this.f21118a);
            super.onMeasure(i2, i3);
        }
    }
}
