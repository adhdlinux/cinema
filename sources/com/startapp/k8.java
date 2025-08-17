package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public final class k8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34836a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q8 f34837b;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ((z7) k8.this.f34837b).f36993a.f34357d = false;
        }
    }

    public k8(Context context, q8 q8Var) {
        this.f34836a = context;
        this.f34837b = q8Var;
    }

    public void run() {
        try {
            ra.a(this.f34836a, "startapp_ads");
            new Handler(Looper.getMainLooper()).post(new a());
        } catch (Throwable th) {
            y8.a(this.f34836a, th);
        }
    }
}
