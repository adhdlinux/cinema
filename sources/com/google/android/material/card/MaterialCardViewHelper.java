package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.R$styleable;

class MaterialCardViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f29669a;

    /* renamed from: b  reason: collision with root package name */
    private int f29670b;

    /* renamed from: c  reason: collision with root package name */
    private int f29671c;

    public MaterialCardViewHelper(MaterialCardView materialCardView) {
        this.f29669a = materialCardView;
    }

    private void a() {
        this.f29669a.d(this.f29669a.getContentPaddingLeft() + this.f29671c, this.f29669a.getContentPaddingTop() + this.f29671c, this.f29669a.getContentPaddingRight() + this.f29671c, this.f29669a.getContentPaddingBottom() + this.f29671c);
    }

    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f29669a.getRadius());
        int i2 = this.f29670b;
        if (i2 != -1) {
            gradientDrawable.setStroke(this.f29671c, i2);
        }
        return gradientDrawable;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f29670b;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f29671c;
    }

    public void e(TypedArray typedArray) {
        this.f29670b = typedArray.getColor(R$styleable.f2, -1);
        this.f29671c = typedArray.getDimensionPixelSize(R$styleable.g2, 0);
        h();
        a();
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.f29670b = i2;
        h();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        this.f29671c = i2;
        h();
        a();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f29669a.setForeground(b());
    }
}
