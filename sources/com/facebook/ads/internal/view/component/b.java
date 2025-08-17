package com.facebook.ads.internal.view.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.view.m;
import com.facebook.ads.internal.view.p;

public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private p f21116a;

    /* renamed from: b  reason: collision with root package name */
    private int f21117b;

    public b(Context context, f fVar, k kVar) {
        super(context);
        setOrientation(1);
        setVerticalGravity(16);
        p pVar = new p(getContext(), 2);
        this.f21116a = pVar;
        pVar.setMinTextSize((float) (kVar.h() - 2));
        this.f21116a.setText(fVar.m());
        m.a(this.f21116a, kVar);
        this.f21116a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f21116a);
        this.f21117b = fVar.m() != null ? Math.min(fVar.m().length(), 21) : 21;
        addView(m.a(context, fVar, kVar));
    }

    public int getMinVisibleTitleCharacters() {
        return this.f21117b;
    }

    public TextView getTitleTextView() {
        return this.f21116a;
    }
}
