package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.ColorUtils;
import com.facebook.ads.internal.q.a.x;
import java.util.ArrayList;
import java.util.List;

public class d extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f21122a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21123b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21124c;

    /* renamed from: d  reason: collision with root package name */
    private int f21125d = -1;

    /* renamed from: e  reason: collision with root package name */
    private List<GradientDrawable> f21126e;

    public d(Context context, com.facebook.ads.internal.adapters.a.d dVar, int i2) {
        super(context);
        setOrientation(0);
        setGravity(17);
        float f2 = x.f20694b;
        int i3 = (int) (8.0f * f2);
        int i4 = (int) (6.0f * f2);
        this.f21124c = (int) (f2 * 1.0f);
        int a2 = dVar.a(false);
        this.f21122a = a2;
        this.f21123b = ColorUtils.p(a2, 128);
        this.f21126e = new ArrayList();
        for (int i5 = 0; i5 < i2; i5++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i3, i3);
            gradientDrawable.setStroke(this.f21124c, 0);
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i4, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.f21126e.add(gradientDrawable);
            addView(imageView);
        }
        a(0);
    }

    public void a(int i2) {
        int i3;
        int i4;
        if (this.f21125d != i2) {
            this.f21125d = i2;
            for (int i5 = 0; i5 < this.f21126e.size(); i5++) {
                if (i5 == i2) {
                    i4 = this.f21122a;
                    i3 = i4;
                } else {
                    i3 = this.f21123b;
                    i4 = 0;
                }
                this.f21126e.get(i5).setStroke(this.f21124c, i4);
                this.f21126e.get(i5).setColor(i3);
                this.f21126e.get(i5).invalidateSelf();
            }
        }
    }
}
