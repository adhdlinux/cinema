package com.facebook.ads.internal.adapters.a;

import java.io.Serializable;

public class c implements Serializable {
    private static final long serialVersionUID = 5306126965868117466L;

    /* renamed from: a  reason: collision with root package name */
    private final String f19694a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19695b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19696c;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f19697a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f19698b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f19699c;

        /* access modifiers changed from: package-private */
        public a a(String str) {
            this.f19697a = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public c a() {
            return new c(this);
        }

        /* access modifiers changed from: package-private */
        public a b(String str) {
            this.f19698b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a c(String str) {
            this.f19699c = str;
            return this;
        }
    }

    private c(a aVar) {
        this.f19694a = aVar.f19697a;
        this.f19695b = aVar.f19698b;
        this.f19696c = aVar.f19699c;
    }

    public String a() {
        return this.f19694a;
    }

    public String b() {
        return this.f19695b;
    }

    public String c() {
        return this.f19696c;
    }
}
