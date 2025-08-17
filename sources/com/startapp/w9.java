package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.x6;
import java.util.concurrent.TimeUnit;

public class w9 extends v9 {

    /* renamed from: e  reason: collision with root package name */
    public final x6 f36824e;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ x7 f36825a;

        public a(x7 x7Var) {
            this.f36825a = x7Var;
        }

        public void run() {
            this.f36825a.c();
            w9.this.f36735b.a(this.f36825a.b());
        }
    }

    public w9(Context context, x6 x6Var, xb xbVar) {
        super(context, xbVar);
        this.f36824e = x6Var;
    }

    public void a() {
        try {
            long millis = TimeUnit.SECONDS.toMillis((long) MetaData.f36379h.g().c());
            x7 x7Var = new x7(this.f36734a, this.f36735b);
            this.f36736c.postDelayed(new a(x7Var), millis);
            x7Var.a(b());
        } catch (Throwable th) {
            y8.a(this.f36734a, th);
            this.f36735b.a((Object) null);
        }
    }

    public final boolean b() {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f36824e.getLong("lastBtDiscoveringTime", 0) >= ((long) MetaData.f36379h.g().a()) * 60000) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            x6.a a2 = this.f36824e.edit();
            a2.a("lastBtDiscoveringTime", Long.valueOf(currentTimeMillis));
            a2.f36915a.putLong("lastBtDiscoveringTime", currentTimeMillis);
            a2.apply();
        }
        return z2;
    }
}
