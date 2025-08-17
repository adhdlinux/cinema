package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import org.json.JSONException;

class h0 {

    /* renamed from: a  reason: collision with root package name */
    private String f13159a;

    /* renamed from: b  reason: collision with root package name */
    private f1 f13160b;

    h0(f1 f1Var) {
        if (f1Var == null) {
            try {
                f1Var = new f1();
            } catch (JSONException e2) {
                new e0.a().c("JSON Error in ADCMessage constructor: ").c(e2.toString()).d(e0.f13114i);
                return;
            }
        }
        this.f13160b = f1Var;
        this.f13159a = f1Var.w("m_type");
    }

    /* access modifiers changed from: package-private */
    public f1 a() {
        return this.f13160b;
    }

    /* access modifiers changed from: package-private */
    public h0 b(f1 f1Var) {
        try {
            h0 h0Var = new h0("reply", this.f13160b.l("m_origin"), f1Var);
            h0Var.f13160b.n("m_id", this.f13160b.l("m_id"));
            return h0Var;
        } catch (JSONException e2) {
            new e0.a().c("JSON error in ADCMessage's createReply(): ").c(e2.toString()).d(e0.f13114i);
            return new h0("JSONException", 0);
        }
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f13159a;
    }

    /* access modifiers changed from: package-private */
    public void d(f1 f1Var) {
        if (f1Var == null) {
            f1Var = new f1();
        }
        this.f13160b = f1Var;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a.d(this.f13159a, this.f13160b);
    }

    h0(String str, int i2) {
        try {
            this.f13159a = str;
            f1 f1Var = new f1();
            this.f13160b = f1Var;
            f1Var.n("m_target", i2);
        } catch (JSONException e2) {
            new e0.a().c("JSON Error in ADCMessage constructor: ").c(e2.toString()).d(e0.f13114i);
        }
    }

    h0(String str, int i2, f1 f1Var) {
        try {
            this.f13159a = str;
            f1Var = f1Var == null ? new f1() : f1Var;
            this.f13160b = f1Var;
            f1Var.n("m_target", i2);
        } catch (JSONException e2) {
            new e0.a().c("JSON Error in ADCMessage constructor: ").c(e2.toString()).d(e0.f13114i);
        }
    }
}
