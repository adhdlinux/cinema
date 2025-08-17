package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.o;
import java.util.Map;

public class b implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private final m f15134a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f15135b;

    /* renamed from: c  reason: collision with root package name */
    private o f15136c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f15137d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private long f15138e;

    public interface a {
        void onAdExpired();
    }

    public b(m mVar, a aVar) {
        this.f15134a = mVar;
        this.f15135b = aVar;
    }

    private void b() {
        o oVar = this.f15136c;
        if (oVar != null) {
            oVar.d();
            this.f15136c = null;
        }
    }

    private void c() {
        synchronized (this.f15137d) {
            b();
        }
    }

    private void d() {
        boolean z2;
        synchronized (this.f15137d) {
            long currentTimeMillis = this.f15138e - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                a();
                z2 = true;
            } else {
                a(currentTimeMillis);
                z2 = false;
            }
        }
        if (z2) {
            this.f15135b.onAdExpired();
        }
    }

    public void a() {
        synchronized (this.f15137d) {
            b();
            this.f15134a.aj().unregisterReceiver(this);
        }
    }

    public void a(long j2) {
        synchronized (this.f15137d) {
            a();
            this.f15138e = System.currentTimeMillis() + j2;
            this.f15134a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
            this.f15134a.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
            if (((Boolean) this.f15134a.a(com.applovin.impl.sdk.c.a.E)).booleanValue() || !this.f15134a.ad().a()) {
                this.f15136c = o.a(j2, this.f15134a, new Runnable() {
                    public void run() {
                        b.this.a();
                        b.this.f15135b.onAdExpired();
                    }
                });
            }
        }
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            c();
        } else if ("com.applovin.application_resumed".equals(action)) {
            d();
        }
    }
}
