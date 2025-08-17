package com.applovin.impl.sdk.e;

import com.applovin.impl.a.e;
import com.applovin.impl.a.f;
import com.applovin.impl.a.l;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAdLoadListener;

class x extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f15446a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AppLovinAdLoadListener f15447c;

    x(e eVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskResolveVastWrapper", mVar);
        this.f15447c = appLovinAdLoadListener;
        this.f15446a = eVar;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (v.a()) {
            d("Failed to resolve VAST wrapper due to error code " + i2);
        }
        if (i2 == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.f15447c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i2);
                return;
            }
            return;
        }
        l.a(this.f15446a, this.f15447c, i2 == -1001 ? f.TIMED_OUT : f.GENERAL_WRAPPER_ERROR, i2, this.f15333b);
    }

    public void run() {
        String a2 = l.a(this.f15446a);
        if (StringUtils.isValidString(a2)) {
            if (v.a()) {
                a("Resolving VAST ad with depth " + this.f15446a.a() + " at " + a2);
            }
            try {
                this.f15333b.S().a((a) new u<r>(c.a(this.f15333b).a(a2).b("GET").a(r.f15920a).a(((Integer) this.f15333b.a(b.en)).intValue()).b(((Integer) this.f15333b.a(b.eo)).intValue()).c(false).a(), this.f15333b) {
                    public void a(int i2, String str, r rVar) {
                        if (v.a()) {
                            d("Unable to resolve VAST wrapper. Server returned " + i2);
                        }
                        x.this.a(i2);
                    }

                    public void a(r rVar, int i2) {
                        this.f15333b.S().a((a) r.a(rVar, x.this.f15446a, x.this.f15447c, x.this.f15333b));
                    }
                });
            } catch (Throwable th) {
                if (v.a()) {
                    a("Unable to resolve VAST wrapper", th);
                }
            }
        } else {
            if (v.a()) {
                d("Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
        }
    }
}
