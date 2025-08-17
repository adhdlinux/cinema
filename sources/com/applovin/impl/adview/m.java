package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.adview.i;

@SuppressLint({"ViewConstructor"})
public class m extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private i f14095a;

    /* renamed from: b  reason: collision with root package name */
    private int f14096b;

    public m(i.a aVar, Activity activity) {
        super(activity);
        setBackgroundColor(0);
        i a2 = i.a(aVar, activity);
        this.f14095a = a2;
        addView(a2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f14096b = i2;
        int i6 = i3 + i2 + i4;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i6;
            layoutParams.width = i6;
        } else {
            setLayoutParams(new FrameLayout.LayoutParams(i6, i6));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2, i5);
        layoutParams2.setMargins(i4, i4, i4, 0);
        this.f14095a.setLayoutParams(layoutParams2);
        this.f14095a.a(i2);
    }

    public void a(i.a aVar) {
        if (aVar != null && aVar != this.f14095a.getStyle()) {
            ViewGroup.LayoutParams layoutParams = this.f14095a.getLayoutParams();
            removeView(this.f14095a);
            i a2 = i.a(aVar, getContext());
            this.f14095a = a2;
            addView(a2);
            this.f14095a.setLayoutParams(layoutParams);
            this.f14095a.a(this.f14096b);
        }
    }
}
