package com.applovin.impl.adview;

import android.os.Handler;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class j {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final v f14071a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f14072b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b> f14073c = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f14074d = new AtomicInteger();

    public interface a {
        void a();

        boolean b();
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f14078a;

        /* renamed from: b  reason: collision with root package name */
        private final a f14079b;

        /* renamed from: c  reason: collision with root package name */
        private final long f14080c;

        private b(String str, long j2, a aVar) {
            this.f14078a = str;
            this.f14080c = j2;
            this.f14079b = aVar;
        }

        /* access modifiers changed from: private */
        public String a() {
            return this.f14078a;
        }

        /* access modifiers changed from: private */
        public long b() {
            return this.f14080c;
        }

        /* access modifiers changed from: private */
        public a c() {
            return this.f14079b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            String str = this.f14078a;
            String str2 = ((b) obj).f14078a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f14078a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f14078a + '\'' + ", countdownStepMillis=" + this.f14080c + '}';
        }
    }

    public j(Handler handler, m mVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        } else if (mVar != null) {
            this.f14072b = handler;
            this.f14071a = mVar.A();
        } else {
            throw new IllegalArgumentException("No sdk specified.");
        }
    }

    /* access modifiers changed from: private */
    public void a(final b bVar, final int i2) {
        this.f14072b.postDelayed(new Runnable() {
            public void run() {
                a b2 = bVar.c();
                if (b2.b()) {
                    if (j.this.f14074d.get() == i2) {
                        try {
                            b2.a();
                            j.this.a(bVar, i2);
                        } catch (Throwable th) {
                            if (v.a()) {
                                v b3 = j.this.f14071a;
                                b3.b("CountdownManager", "Encountered error on countdown step for: " + bVar.a(), th);
                            }
                            j.this.b();
                        }
                    } else if (v.a()) {
                        v b4 = j.this.f14071a;
                        b4.d("CountdownManager", "Killing duplicate countdown from previous generation: " + bVar.a());
                    }
                } else if (v.a()) {
                    v b5 = j.this.f14071a;
                    b5.b("CountdownManager", "Ending countdown for " + bVar.a());
                }
            }
        }, bVar.b());
    }

    public void a() {
        HashSet<b> hashSet = new HashSet<>(this.f14073c);
        if (v.a()) {
            v vVar = this.f14071a;
            vVar.b("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int incrementAndGet = this.f14074d.incrementAndGet();
        for (b bVar : hashSet) {
            if (v.a()) {
                v vVar2 = this.f14071a;
                vVar2.b("CountdownManager", "Starting countdown: " + bVar.a() + " for generation " + incrementAndGet + "...");
            }
            a(bVar, incrementAndGet);
        }
    }

    public void a(String str, long j2, a aVar) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        } else if (this.f14072b != null) {
            if (v.a()) {
                v vVar = this.f14071a;
                vVar.b("CountdownManager", "Adding countdown: " + str);
            }
            this.f14073c.add(new b(str, j2, aVar));
        } else {
            throw new IllegalArgumentException("No handler specified.");
        }
    }

    public void b() {
        if (v.a()) {
            this.f14071a.b("CountdownManager", "Removing all countdowns...");
        }
        c();
        this.f14073c.clear();
    }

    public void c() {
        if (v.a()) {
            this.f14071a.b("CountdownManager", "Stopping countdowns...");
        }
        this.f14074d.incrementAndGet();
        this.f14072b.removeCallbacksAndMessages((Object) null);
    }
}
