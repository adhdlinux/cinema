package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCardView extends CardView {

    /* renamed from: k  reason: collision with root package name */
    private final MaterialCardViewHelper f29668k;

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.e2, i2, R$style.Widget_MaterialComponents_CardView, new int[0]);
        MaterialCardViewHelper materialCardViewHelper = new MaterialCardViewHelper(this);
        this.f29668k = materialCardViewHelper;
        materialCardViewHelper.e(h2);
        h2.recycle();
    }

    public int getStrokeColor() {
        return this.f29668k.c();
    }

    public int getStrokeWidth() {
        return this.f29668k.d();
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f29668k.h();
    }

    public void setStrokeColor(int i2) {
        this.f29668k.f(i2);
    }

    public void setStrokeWidth(int i2) {
        this.f29668k.g(i2);
    }
}
