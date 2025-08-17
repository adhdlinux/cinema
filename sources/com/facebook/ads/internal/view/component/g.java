package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.m;

public class g extends LinearLayout {
    public g(Context context, f fVar, k kVar) {
        super(context);
        float f2 = x.f20694b;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setVerticalGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        float f3 = f2 * 15.0f;
        layoutParams.setMargins(Math.round(f3), Math.round(f3), Math.round(f3), Math.round(f3));
        linearLayout.setLayoutParams(layoutParams);
        addView(linearLayout);
        String n2 = fVar.n();
        TextView textView = new TextView(getContext());
        textView.setText(TextUtils.isEmpty(n2) ? fVar.m() : n2);
        m.a(textView, kVar);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        linearLayout.addView(textView);
        TextView textView2 = new TextView(getContext());
        textView2.setText(fVar.o());
        m.b(textView2, kVar);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(2);
        linearLayout.addView(textView2);
    }
}
