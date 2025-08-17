package com.applovin.impl.mediation.debugger.ui.b.a;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.mediation.debugger.ui.d.c;
import com.applovin.impl.sdk.j;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f14636a;

    /* renamed from: o  reason: collision with root package name */
    private final Context f14637o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f14638p;

    public b(j.a aVar, boolean z2, Context context) {
        super(c.b.RIGHT_DETAIL);
        this.f14636a = aVar;
        this.f14637o = context;
        this.f14702d = new SpannedString(aVar.a());
        this.f14638p = z2;
    }

    public boolean b() {
        return true;
    }

    public SpannedString c_() {
        return new SpannedString(this.f14636a.b(this.f14637o));
    }

    public boolean d_() {
        Boolean a2 = this.f14636a.a(this.f14637o);
        if (a2 != null) {
            return a2.equals(Boolean.valueOf(this.f14638p));
        }
        return false;
    }
}
