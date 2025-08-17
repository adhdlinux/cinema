package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.a.f;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.List;

public class a extends com.applovin.impl.sdk.e.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<f> f14373a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Activity f14374c;

    /* renamed from: com.applovin.impl.mediation.c.a$a  reason: collision with other inner class name */
    public static class C0012a extends com.applovin.impl.sdk.e.a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final f f14377a;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final List<f> f14378c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final Activity f14379d;

        private C0012a(f fVar, List<f> list, m mVar, Activity activity) {
            super("TaskSequentialInitAdapter:" + fVar.K(), mVar, true);
            this.f14379d = activity;
            this.f14377a = fVar;
            this.f14378c = list;
        }

        public void run() {
            if (v.a()) {
                a("Auto-initing " + this.f14377a + "...");
            }
            this.f15333b.D().a(this.f14377a, this.f14379d, new Runnable() {
                public void run() {
                    if (v.a()) {
                        C0012a aVar = C0012a.this;
                        aVar.a("Initialization task for adapter '" + C0012a.this.f14377a.L() + "' finished");
                    }
                    int indexOf = C0012a.this.f14378c.indexOf(C0012a.this.f14377a);
                    if (indexOf < C0012a.this.f14378c.size() - 1) {
                        f fVar = (f) C0012a.this.f14378c.get(indexOf + 1);
                        C0012a.this.f15333b.S().a((com.applovin.impl.sdk.e.a) new C0012a(fVar, C0012a.this.f14378c, C0012a.this.f15333b, C0012a.this.f14379d), o.a.MAIN, fVar.Y());
                    } else if (v.a()) {
                        C0012a.this.a("Finished initializing adapters");
                    }
                }
            });
        }
    }

    public a(List<f> list, Activity activity, m mVar) {
        super("TaskAutoInitAdapters", mVar, true);
        this.f14373a = list;
        this.f14374c = activity;
    }

    public void run() {
        try {
            if (this.f14373a.size() > 0) {
                if (v.a()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Auto-initing ");
                    sb.append(this.f14373a.size());
                    sb.append(" adapters");
                    sb.append(this.f15333b.J().a() ? " in test mode" : "");
                    sb.append("...");
                    a(sb.toString());
                }
                if (TextUtils.isEmpty(this.f15333b.t())) {
                    this.f15333b.c(AppLovinMediationProvider.MAX);
                } else if (!this.f15333b.f() && v.a()) {
                    v.i("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f15333b.t());
                }
                if (v.a() && this.f14374c == null) {
                    v.i("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
                }
                if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.a.Q)).booleanValue()) {
                    f fVar = this.f14373a.get(0);
                    this.f15333b.S().a((com.applovin.impl.sdk.e.a) new C0012a(fVar, this.f14373a, this.f15333b, this.f14374c), o.a.MAIN, fVar.Y());
                    return;
                }
                for (final f next : this.f14373a) {
                    this.f15333b.S().a((Runnable) new Runnable() {
                        public void run() {
                            if (v.a()) {
                                a aVar = a.this;
                                aVar.a("Auto-initing adapter: " + next);
                            }
                            a.this.f15333b.D().a(next, a.this.f14374c);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            if (v.a()) {
                a("Failed to auto-init adapters", th);
            }
        }
    }
}
