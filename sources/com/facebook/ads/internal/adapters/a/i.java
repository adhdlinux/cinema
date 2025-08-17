package com.facebook.ads.internal.adapters.a;

import java.io.Serializable;

public class i implements Serializable {
    private static final long serialVersionUID = 351643298236575728L;

    /* renamed from: a  reason: collision with root package name */
    private final String f19730a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19731b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19732c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19733d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f19734a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f19735b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f19736c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f19737d;

        /* access modifiers changed from: package-private */
        public a a(String str) {
            this.f19734a = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public i a() {
            return new i(this);
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            this.f19735b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a c(String str) {
            this.f19736c = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a d(String str) {
            this.f19737d = str;
            return this;
        }
    }

    private i(a aVar) {
        this.f19730a = aVar.f19734a;
        this.f19731b = aVar.f19735b;
        this.f19732c = aVar.f19736c;
        this.f19733d = aVar.f19737d;
    }

    public String a() {
        return this.f19730a;
    }

    public String b() {
        return this.f19731b;
    }

    public String c() {
        return this.f19732c;
    }

    public String d() {
        return this.f19733d;
    }
}
