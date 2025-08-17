package com.adcolony.sdk;

class e0 {

    /* renamed from: c  reason: collision with root package name */
    static e0 f13108c = new e0(3, true);

    /* renamed from: d  reason: collision with root package name */
    static e0 f13109d = new e0(2, false);

    /* renamed from: e  reason: collision with root package name */
    static e0 f13110e = new e0(2, true);

    /* renamed from: f  reason: collision with root package name */
    static e0 f13111f = new e0(1, false);

    /* renamed from: g  reason: collision with root package name */
    static e0 f13112g = new e0(1, true);

    /* renamed from: h  reason: collision with root package name */
    static e0 f13113h = new e0(0, false);

    /* renamed from: i  reason: collision with root package name */
    static e0 f13114i = new e0(0, true);

    /* renamed from: a  reason: collision with root package name */
    private final int f13115a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13116b;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        StringBuilder f13117a = new StringBuilder();

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(int i2) {
            this.f13117a.append(i2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b(Object obj) {
            if (obj != null) {
                this.f13117a.append(obj.toString());
            } else {
                this.f13117a.append("null");
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public a c(String str) {
            this.f13117a.append(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void d(e0 e0Var) {
            e0Var.b(this.f13117a.toString());
        }
    }

    static {
        new e0(3, false);
    }

    e0(int i2, boolean z2) {
        this.f13115a = i2;
        this.f13116b = z2;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        a.f().D0().f(this.f13115a, str, this.f13116b);
    }
}
