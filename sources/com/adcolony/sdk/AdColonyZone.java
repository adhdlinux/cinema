package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.vungle.ads.internal.Constants;

public class AdColonyZone {

    /* renamed from: a  reason: collision with root package name */
    private String f12882a;

    /* renamed from: b  reason: collision with root package name */
    private String f12883b;

    /* renamed from: c  reason: collision with root package name */
    private int f12884c = 5;

    /* renamed from: d  reason: collision with root package name */
    private int f12885d;

    /* renamed from: e  reason: collision with root package name */
    private int f12886e;

    /* renamed from: f  reason: collision with root package name */
    private int f12887f;

    /* renamed from: g  reason: collision with root package name */
    private int f12888g;

    /* renamed from: h  reason: collision with root package name */
    private int f12889h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12890i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12891j;

    AdColonyZone(String str) {
        this.f12882a = str;
    }

    private int a(int i2) {
        if (a.i() && !a.f().d() && !a.f().e()) {
            return i2;
        }
        e();
        return 0;
    }

    private String b(String str) {
        return c(str, "");
    }

    private String c(String str, String str2) {
        if (a.i() && !a.f().d() && !a.f().e()) {
            return str;
        }
        e();
        return str2;
    }

    private void e() {
        new e0.a().c("The AdColonyZone API is not available while AdColony is disabled.").d(e0.f13113h);
    }

    /* access modifiers changed from: package-private */
    public void d(h0 h0Var) {
        f1 a2 = h0Var.a();
        f1 C = c0.C(a2, "reward");
        this.f12883b = c0.E(C, "reward_name");
        this.f12889h = c0.A(C, "reward_amount");
        this.f12887f = c0.A(C, "views_per_reward");
        this.f12886e = c0.A(C, "views_until_reward");
        this.f12891j = c0.t(a2, Constants.PLACEMENT_TYPE_REWARDED);
        this.f12884c = c0.A(a2, "status");
        this.f12885d = c0.A(a2, "type");
        this.f12888g = c0.A(a2, "play_interval");
        this.f12882a = c0.E(a2, "zone_id");
        boolean z2 = true;
        if (this.f12884c == 1) {
            z2 = false;
        }
        this.f12890i = z2;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.f12884c = i2;
    }

    public int g() {
        return a(this.f12889h);
    }

    public String h() {
        return b(this.f12883b);
    }

    public boolean i() {
        return this.f12891j;
    }
}
