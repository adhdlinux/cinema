package com.facebook.ads.internal.d;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f20062a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f20063b = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final ExecutorService f20064c = Executors.newFixedThreadPool(5);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f20065d = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final c f20066e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final d f20067f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Callable<Boolean>> f20068g;

    private class a implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final String f20075b;

        /* renamed from: c  reason: collision with root package name */
        private final int f20076c;

        /* renamed from: d  reason: collision with root package name */
        private final int f20077d;

        public a(String str, int i2, int i3) {
            this.f20075b = str;
            this.f20076c = i2;
            this.f20077d = i3;
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(b.this.f20066e.a(this.f20075b, this.f20076c, this.f20077d) != null);
        }
    }

    /* renamed from: com.facebook.ads.internal.d.b$b  reason: collision with other inner class name */
    private class C0031b implements Callable<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        private final String f20079b;

        public C0031b(String str) {
            this.f20079b = str;
        }

        /* renamed from: a */
        public Boolean call() {
            return Boolean.valueOf(b.this.f20067f.a(this.f20079b));
        }
    }

    public b(Context context) {
        this.f20066e = c.a(context);
        this.f20067f = d.a(context);
        this.f20068g = new ArrayList();
    }

    public void a(final a aVar) {
        final ArrayList arrayList = new ArrayList(this.f20068g);
        f20063b.execute(new Runnable() {
            public void run() {
                ArrayList<Future> arrayList = new ArrayList<>(arrayList.size());
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList.add(b.f20064c.submit((Callable) it2.next()));
                }
                final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    for (Future future : arrayList) {
                        atomicBoolean.set(((Boolean) future.get()).booleanValue() & atomicBoolean.get());
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    Log.e(b.f20062a, "Exception while executing cache downloads.", e2);
                    atomicBoolean.set(false);
                }
                b.this.f20065d.post(new Runnable() {
                    public void run() {
                        if (aVar == null) {
                            return;
                        }
                        if (atomicBoolean.get()) {
                            aVar.a();
                        } else {
                            aVar.b();
                        }
                    }
                });
            }
        });
        this.f20068g.clear();
    }

    public void a(String str) {
        this.f20068g.add(new C0031b(str));
    }

    public void a(String str, int i2, int i3) {
        this.f20068g.add(new a(str, i2, i3));
    }

    public String b(String str) {
        return this.f20067f.b(str);
    }
}
