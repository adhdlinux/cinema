package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.StaleDcConfig;
import com.startapp.x6;
import com.vungle.ads.internal.signals.SignalManager;

public class md extends dd<ld> {

    /* renamed from: e  reason: collision with root package name */
    public final x6 f34937e;

    /* renamed from: f  reason: collision with root package name */
    public final ua<StaleDcConfig> f34938f;

    public md(Context context, x6 x6Var, ua<StaleDcConfig> uaVar) {
        super(context, SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        this.f34937e = x6Var;
        this.f34938f = uaVar;
    }

    public Object a(boolean z2) {
        ld ldVar = new ld();
        String str = null;
        if (!z2) {
            str = this.f34937e.getString("a83b59c2138cbf65", (String) null);
        }
        if (str == null) {
            Context context = this.f34373a;
            context.getPackageName();
            str = lb.b(context);
            x6.a a2 = this.f34937e.edit();
            a2.a("a83b59c2138cbf65", str);
            a2.f36915a.putString("a83b59c2138cbf65", str);
            a2.apply();
        }
        ldVar.f34878a = str;
        return ldVar;
    }

    public Object c() {
        return new ld();
    }
}
