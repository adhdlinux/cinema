package com.adcolony.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class f0 {

    /* renamed from: e  reason: collision with root package name */
    static final SimpleDateFormat f13120e = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Date f13121a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f13122b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b0 f13123c;

    /* renamed from: d  reason: collision with root package name */
    protected String f13124d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        protected f0 f13125a = new f0();

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(int i2) {
            int unused = this.f13125a.f13122b = i2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b(b0 b0Var) {
            b0 unused = this.f13125a.f13123c = b0Var;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a c(String str) {
            this.f13125a.f13124d = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public f0 d() {
            if (this.f13125a.f13121a == null) {
                Date unused = this.f13125a.f13121a = new Date(System.currentTimeMillis());
            }
            return this.f13125a;
        }
    }

    f0() {
    }

    /* access modifiers changed from: package-private */
    public b0 b() {
        return this.f13123c;
    }

    /* access modifiers changed from: package-private */
    public String f() {
        int i2 = this.f13122b;
        return i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "UNKNOWN LOG LEVEL" : "Debug" : "Info" : "Warn" : "Error" : "Fatal";
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f13124d;
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return f13120e.format(this.f13121a);
    }

    public String toString() {
        return h() + " " + f() + "/" + b().a() + ": " + g();
    }
}
