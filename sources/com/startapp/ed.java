package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.BluetoothConfig;
import com.startapp.sdk.components.ComponentLocator;

public class ed extends jd<String> implements xb {

    /* renamed from: j  reason: collision with root package name */
    public final x6 f34486j;

    /* renamed from: k  reason: collision with root package name */
    public final s8 f34487k;

    /* renamed from: l  reason: collision with root package name */
    public final ua<BluetoothConfig> f34488l;

    public ed(Context context, x6 x6Var, x6 x6Var2, s8 s8Var, va vaVar, ua<BluetoothConfig> uaVar) {
        super(context, x6Var2, vaVar, "26787005dc4a1477", "c8ef3e50475fc527");
        this.f34486j = x6Var;
        this.f34487k = s8Var;
        this.f34488l = uaVar;
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
        BluetoothConfig call = this.f34488l.call();
        if (call != null) {
            return call.b();
        }
        return 0;
    }

    public boolean f() {
        BluetoothConfig call;
        if (!this.f34487k.c() || (call = this.f34488l.call()) == null || !call.d()) {
            return false;
        }
        return true;
    }

    public void g() {
        if (hc.a(this.f34373a, "android.permission.BLUETOOTH")) {
            Context context = this.f34373a;
            ComponentLocator.a(context).i().execute(new w9(context, this.f34486j, this).f36737d);
        }
    }
}
