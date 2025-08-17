package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.SensorsConfig;
import com.startapp.sdk.components.ComponentLocator;

public class kd extends jd<String> implements xb {

    /* renamed from: j  reason: collision with root package name */
    public final s8 f34844j;

    /* renamed from: k  reason: collision with root package name */
    public final ua<SensorsConfig> f34845k;

    public kd(Context context, x6 x6Var, s8 s8Var, va vaVar, ua<SensorsConfig> uaVar) {
        super(context, x6Var, vaVar, "cc8b2544ce91bcdf", "7099d13208ad24ae");
        this.f34844j = s8Var;
        this.f34845k = uaVar;
    }

    public Object a(String str) {
        return str;
    }

    public void a(Object obj) {
        b(obj != null ? obj.toString() : null);
    }

    public /* bridge */ /* synthetic */ Object c() {
        return "";
    }

    public long d() {
        SensorsConfig call = this.f34845k.call();
        if (call != null) {
            return call.h();
        }
        return 0;
    }

    public boolean f() {
        SensorsConfig call;
        if (!this.f34844j.c() || (call = this.f34845k.call()) == null || !call.l()) {
            return false;
        }
        return true;
    }

    public void g() {
        Context context = this.f34373a;
        ComponentLocator.a(context).i().execute(new x9(context, this).f36737d);
    }
}
