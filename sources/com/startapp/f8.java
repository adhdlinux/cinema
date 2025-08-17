package com.startapp;

import android.os.Handler;
import android.os.Looper;
import com.startapp.j8;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

public abstract class f8 {

    /* renamed from: a  reason: collision with root package name */
    public j8 f34519a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34520b = null;

    /* renamed from: c  reason: collision with root package name */
    public Long f34521c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34522d = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            f8.this.c();
        }
    }

    public f8(j8 j8Var) {
        this.f34519a = j8Var;
    }

    public abstract boolean a();

    public abstract long b();

    public void c() {
        boolean z2;
        this.f34521c = null;
        this.f34522d = false;
        j8 j8Var = this.f34519a;
        if (j8Var.f34755m < MetaData.f36379h.G()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            j8Var.f34755m++;
            j8Var.a((StartAppAd) null, (AdEventListener) null, true, false);
            return;
        }
        j8.b bVar = j8Var.f34758p;
        if (bVar != null) {
            ((c8) bVar).a(j8Var);
        }
    }

    public void d() {
        if (!this.f34522d) {
            if (this.f34521c == null) {
                this.f34521c = Long.valueOf(System.currentTimeMillis());
            }
            if (a()) {
                if (this.f34520b == null) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = Looper.getMainLooper();
                    }
                    this.f34520b = new Handler(myLooper);
                }
                long b2 = b();
                if (b2 >= 0) {
                    this.f34522d = true;
                    this.f34520b.postDelayed(new a(), b2);
                }
            }
        }
    }

    public void e() {
        Handler handler = this.f34520b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f34521c = null;
        this.f34522d = false;
    }
}
