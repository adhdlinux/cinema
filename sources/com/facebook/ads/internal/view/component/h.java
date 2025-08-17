package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.q.a.x;

public class h extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final float f21135a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21136b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f21137c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f21138d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f21139e;

    static {
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        f21135a = f2;
        f21136b = (int) (6.0f * f2);
        f21137c = (int) (f2 * 8.0f);
    }

    public h(Context context, d dVar, boolean z2, boolean z3, boolean z4) {
        super(context);
        setOrientation(1);
        TextView textView = new TextView(context);
        this.f21138d = textView;
        x.a(textView, true, z3 ? 18 : 22);
        textView.setTextColor(dVar.c(z2));
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int i2 = f21136b;
        textView.setLineSpacing((float) i2, 1.0f);
        TextView textView2 = new TextView(context);
        this.f21139e = textView2;
        x.a(textView2, false, z3 ? 14 : 16);
        textView2.setTextColor(dVar.b(z2));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setLineSpacing((float) i2, 1.0f);
        addView(textView, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = f21137c;
        layoutParams.setMargins(0, z4 ? i3 / 2 : i3, 0, 0);
        addView(textView2, layoutParams);
    }

    public void a(String str, String str2, boolean z2, boolean z3) {
        int i2 = 1;
        boolean z4 = !TextUtils.isEmpty(str);
        boolean z5 = !TextUtils.isEmpty(str2);
        TextView textView = this.f21138d;
        if (!z4) {
            str = str2;
        }
        textView.setText(str);
        TextView textView2 = this.f21139e;
        if (!z4) {
            str2 = "";
        }
        textView2.setText(str2);
        int i3 = 3;
        if (!z4 || !z5) {
            TextView textView3 = this.f21138d;
            if (z2) {
                i3 = 2;
            } else if (z3) {
                i3 = 4;
            }
            textView3.setMaxLines(i3);
            return;
        }
        this.f21138d.setMaxLines(z2 ? 1 : 2);
        TextView textView4 = this.f21139e;
        if (!z2) {
            i2 = z3 ? 3 : 2;
        }
        textView4.setMaxLines(i2);
    }

    public void setAlignment(int i2) {
        this.f21138d.setGravity(i2);
        this.f21139e.setGravity(i2);
    }
}
