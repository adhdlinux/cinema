package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adcolony.sdk.e0;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class m0 {

    /* renamed from: a  reason: collision with root package name */
    private ScheduledExecutorService f13254a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledFuture<?> f13255b;

    /* renamed from: c  reason: collision with root package name */
    private String f13256c;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            m0.this.e();
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            m0.this.i();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            m0.this.g();
        }
    }

    m0() {
    }

    @SuppressLint({"MissingPermission"})
    private String a() {
        NetworkInfo networkInfo;
        Context a2 = a.a();
        if (a2 == null) {
            return "none";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) a2.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                return "none";
            }
            int type = networkInfo.getType();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                return "cell";
            }
            if (type >= 2) {
                return "cell";
            }
            return "none";
        } catch (SecurityException e2) {
            new e0.a().c("SecurityException - please ensure you added the ").c("ACCESS_NETWORK_STATE permission: ").c(e2.toString()).d(e0.f13113h);
            return "none";
        } catch (Exception e3) {
            new e0.a().c("Exception occurred when retrieving activeNetworkInfo in ").c("ADCNetwork.getConnectivityStatus(): ").c(e3.toString()).d(e0.f13114i);
            return "none";
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f13254a == null) {
            this.f13254a = Executors.newSingleThreadScheduledExecutor();
        }
        if (this.f13255b == null) {
            try {
                this.f13255b = this.f13254a.scheduleAtFixedRate(new c(), 0, 1000, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                new e0.a().c("Error when scheduling network checks: ").c(e2.toString()).d(e0.f13114i);
            }
            g();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        String h2 = h();
        if (!h2.equals(this.f13256c)) {
            this.f13256c = h2;
            f1 q2 = c0.q();
            c0.n(q2, "network_type", h2);
            new h0("Network.on_status_change", 1, q2).e();
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        ScheduledFuture<?> scheduledFuture = this.f13255b;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isCancelled()) {
                this.f13255b.cancel(false);
            }
            this.f13255b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f13256c = h();
        a.e("Network.start_notifications", new a());
        a.e("Network.stop_notifications", new b());
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return a();
    }
}
