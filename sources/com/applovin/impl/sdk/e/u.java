package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

public abstract class u<T> extends a implements b.c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f15436a;

    /* renamed from: c  reason: collision with root package name */
    private final b.c<T> f15437c;

    /* renamed from: d  reason: collision with root package name */
    protected b.a f15438d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public o.a f15439e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public com.applovin.impl.sdk.c.b<String> f15440f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.applovin.impl.sdk.c.b<String> f15441g;

    public u(c<T> cVar, m mVar) {
        this(cVar, mVar, false);
    }

    public u(c<T> cVar, final m mVar, boolean z2) {
        super("TaskRepeatRequest", mVar, z2);
        this.f15439e = o.a.BACKGROUND;
        this.f15440f = null;
        this.f15441g = null;
        if (cVar != null) {
            this.f15436a = cVar;
            this.f15438d = new b.a();
            this.f15437c = new b.c<T>() {
                public void a(int i2, String str, T t2) {
                    com.applovin.impl.sdk.c.b bVar;
                    u uVar;
                    boolean z2 = false;
                    boolean z3 = i2 < 200 || i2 >= 500;
                    boolean z4 = i2 == 429;
                    if ((i2 != -1009) && (z3 || z4 || u.this.f15436a.m())) {
                        String f2 = u.this.f15436a.f();
                        if (u.this.f15436a.h() > 0) {
                            if (v.a()) {
                                u uVar2 = u.this;
                                uVar2.c("Unable to send request due to server failure (code " + i2 + "). " + u.this.f15436a.h() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds((long) u.this.f15436a.k()) + " seconds...");
                            }
                            int h2 = u.this.f15436a.h() - 1;
                            u.this.f15436a.a(h2);
                            if (h2 == 0) {
                                u uVar3 = u.this;
                                uVar3.c(uVar3.f15440f);
                                if (StringUtils.isValidString(f2) && f2.length() >= 4) {
                                    if (v.a()) {
                                        u uVar4 = u.this;
                                        uVar4.b("Switching to backup endpoint " + f2);
                                    }
                                    u.this.f15436a.a(f2);
                                    z2 = true;
                                }
                            }
                            long millis = (!((Boolean) mVar.a(com.applovin.impl.sdk.c.b.dd)).booleanValue() || !z2) ? u.this.f15436a.l() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, (double) u.this.f15436a.i())) : (long) u.this.f15436a.k() : 0;
                            o S = mVar.S();
                            u uVar5 = u.this;
                            S.a((a) uVar5, uVar5.f15439e, millis);
                            return;
                        }
                        if (f2 == null || !f2.equals(u.this.f15436a.a())) {
                            uVar = u.this;
                            bVar = uVar.f15440f;
                        } else {
                            uVar = u.this;
                            bVar = uVar.f15441g;
                        }
                        uVar.c(bVar);
                    }
                    u.this.a(i2, str, t2);
                }

                public void a(T t2, int i2) {
                    u.this.f15436a.a(0);
                    u.this.a(t2, i2);
                }
            };
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    /* access modifiers changed from: private */
    public <ST> void c(com.applovin.impl.sdk.c.b<ST> bVar) {
        if (bVar != null) {
            d().K().a((com.applovin.impl.sdk.c.b<?>) bVar, (Object) bVar.b());
        }
    }

    public abstract void a(int i2, String str, T t2);

    public void a(com.applovin.impl.sdk.c.b<String> bVar) {
        this.f15440f = bVar;
    }

    public void a(o.a aVar) {
        this.f15439e = aVar;
    }

    public abstract void a(T t2, int i2);

    public void b(com.applovin.impl.sdk.c.b<String> bVar) {
        this.f15441g = bVar;
    }

    public void run() {
        int i2;
        b R = d().R();
        if (!d().c() && !d().d()) {
            if (v.a()) {
                v.i("AppLovinSdk", "AppLovin SDK is disabled");
            }
            i2 = -22;
        } else if (!StringUtils.isValidString(this.f15436a.a()) || this.f15436a.a().length() < 4) {
            if (v.a()) {
                d("Task has an invalid or null request endpoint.");
            }
            i2 = AppLovinErrorCodes.INVALID_URL;
        } else {
            if (TextUtils.isEmpty(this.f15436a.b())) {
                this.f15436a.b(this.f15436a.e() != null ? "POST" : "GET");
            }
            R.a(this.f15436a, this.f15438d, this.f15437c);
            return;
        }
        a(i2, (String) null, (Object) null);
    }
}
