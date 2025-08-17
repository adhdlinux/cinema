package com.facebook.ads.internal.d;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.p.b.f;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20083a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static d f20084b;

    /* renamed from: c  reason: collision with root package name */
    private final Future<f> f20085c;

    private d(final Context context) {
        this.f20085c = Executors.newSingleThreadExecutor().submit(new Callable<f>() {
            /* renamed from: a */
            public f call() {
                return new f(context);
            }
        });
    }

    public static d a(Context context) {
        if (f20084b == null) {
            Context applicationContext = context.getApplicationContext();
            synchronized (d.class) {
                if (f20084b == null) {
                    f20084b = new d(applicationContext);
                }
            }
        }
        return f20084b;
    }

    private f a() {
        try {
            return this.f20085c.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            Log.e(f20083a, "Timed out waiting for cache server.", e2);
            return null;
        }
    }

    public boolean a(String str) {
        f a2 = a();
        return a2 != null && a2.a(str);
    }

    public String b(String str) {
        f a2 = a();
        if (a2 == null) {
            return null;
        }
        return a2.b(str);
    }
}
