package com.facebook.ads.internal.view.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.adapters.a.i;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.b.d;
import com.facebook.ads.internal.view.component.e;

public class c extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private e f21032a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f21033b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f21034c;

    public c(Context context) {
        super(context);
        a(context);
    }

    public void a(int i2, int i3) {
        this.f21033b.setTextColor(i2);
        this.f21034c.setTextColor(i3);
    }

    public void a(Context context) {
        float f2 = x.f20694b;
        int i2 = (int) (32.0f * f2);
        setGravity(16);
        e eVar = new e(context);
        this.f21032a = eVar;
        eVar.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.setMargins(0, 0, (int) (f2 * 8.0f), 0);
        addView(this.f21032a, layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.f21033b = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        x.a(this.f21033b, true, 16);
        this.f21033b.setEllipsize(TextUtils.TruncateAt.END);
        this.f21033b.setSingleLine(true);
        TextView textView = new TextView(context);
        this.f21034c = textView;
        x.a(textView, false, 14);
        linearLayout.addView(this.f21033b);
        linearLayout.addView(this.f21034c);
        addView(linearLayout, layoutParams2);
    }

    public void setPageDetails(i iVar) {
        d dVar = new d((ImageView) this.f21032a);
        float f2 = x.f20694b;
        dVar.a((int) (f2 * 32.0f), (int) (f2 * 32.0f));
        dVar.a(iVar.b());
        this.f21033b.setText(iVar.a());
        this.f21034c.setText(iVar.d());
    }
}
