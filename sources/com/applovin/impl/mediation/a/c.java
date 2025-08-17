package com.applovin.impl.mediation.a;

import android.os.SystemClock;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.m;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<com.applovin.impl.sdk.b.c> f14224c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f14225d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f14226e;

    private c(c cVar, g gVar) {
        super(cVar.T(), cVar.J(), cVar.I(), gVar, cVar.f14230b);
        this.f14226e = new AtomicBoolean();
        this.f14224c = cVar.f14224c;
        this.f14225d = cVar.f14225d;
    }

    public c(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
        this.f14226e = new AtomicBoolean();
        this.f14224c = new AtomicReference<>();
        this.f14225d = new AtomicBoolean();
    }

    public long A() {
        return b("ahdm", ((Long) this.f14230b.a(a.f15202x)).longValue());
    }

    public boolean B() {
        return b("susaode", (Boolean) this.f14230b.a(a.f15201w)).booleanValue();
    }

    public String C() {
        return b("bcode", "");
    }

    public String D() {
        return a("mcode", "");
    }

    public boolean E() {
        return this.f14225d.get();
    }

    public void F() {
        this.f14225d.set(true);
    }

    public com.applovin.impl.sdk.b.c G() {
        return this.f14224c.getAndSet((Object) null);
    }

    public AtomicBoolean H() {
        return this.f14226e;
    }

    public a a(g gVar) {
        return new c(this, gVar);
    }

    public void a(com.applovin.impl.sdk.b.c cVar) {
        this.f14224c.set(cVar);
    }

    public long u() {
        long b2 = b("ad_expiration_ms", -1);
        return b2 >= 0 ? b2 : a("ad_expiration_ms", ((Long) this.f14230b.a(a.D)).longValue());
    }

    public long v() {
        long b2 = b("ad_hidden_timeout_ms", -1);
        return b2 >= 0 ? b2 : a("ad_hidden_timeout_ms", ((Long) this.f14230b.a(a.G)).longValue());
    }

    public boolean w() {
        if (b("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f14230b.a(a.H)).booleanValue();
    }

    public long x() {
        long b2 = b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1);
        return b2 >= 0 ? b2 : a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f14230b.a(a.I)).longValue());
    }

    public long y() {
        if (q() > 0) {
            return SystemClock.elapsedRealtime() - q();
        }
        return -1;
    }

    public long z() {
        long b2 = b("fullscreen_display_delay_ms", -1);
        return b2 >= 0 ? b2 : ((Long) this.f14230b.a(a.f15200v)).longValue();
    }
}
