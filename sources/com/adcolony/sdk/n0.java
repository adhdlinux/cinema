package com.adcolony.sdk;

import com.facebook.hermes.intl.Constants;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

class n0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f13265a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f13266b = new ArrayList();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f13267a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13268b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13269c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String[] f13270d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final String[] f13271e;

        /* renamed from: f  reason: collision with root package name */
        private final List<b> f13272f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        private final List<c> f13273g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        private final d f13274h;

        /* renamed from: i  reason: collision with root package name */
        private final Map<String, String> f13275i;

        a(f1 f1Var) throws JSONException {
            String[] strArr;
            String[] strArr2;
            d dVar;
            this.f13267a = f1Var.w("stream");
            this.f13268b = f1Var.w("table_name");
            this.f13269c = f1Var.b("max_rows", 10000);
            e1 D = f1Var.D("event_types");
            if (D != null) {
                strArr = c0.p(D);
            } else {
                strArr = new String[0];
            }
            this.f13270d = strArr;
            e1 D2 = f1Var.D("request_types");
            if (D2 != null) {
                strArr2 = c0.p(D2);
            } else {
                strArr2 = new String[0];
            }
            this.f13271e = strArr2;
            for (f1 bVar : c0.x(f1Var.r("columns"))) {
                this.f13272f.add(new b(bVar));
            }
            for (f1 cVar : c0.x(f1Var.r("indexes"))) {
                this.f13273g.add(new c(cVar, this.f13268b));
            }
            f1 F = f1Var.F("ttl");
            if (F != null) {
                dVar = new d(F);
            } else {
                dVar = null;
            }
            this.f13274h = dVar;
            this.f13275i = f1Var.E("queries").x();
        }

        /* access modifiers changed from: package-private */
        public List<b> a() {
            return this.f13272f;
        }

        /* access modifiers changed from: package-private */
        public List<c> c() {
            return this.f13273g;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f13269c;
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.f13267a;
        }

        /* access modifiers changed from: package-private */
        public Map<String, String> g() {
            return this.f13275i;
        }

        /* access modifiers changed from: package-private */
        public String h() {
            return this.f13268b;
        }

        /* access modifiers changed from: package-private */
        public d i() {
            return this.f13274h;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f13276a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13277b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f13278c;

        b(f1 f1Var) throws JSONException {
            this.f13276a = f1Var.w("name");
            this.f13277b = f1Var.w("type");
            this.f13278c = f1Var.G(Constants.COLLATION_DEFAULT);
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.f13278c;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f13276a;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return this.f13277b;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f13279a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f13280b;

        c(f1 f1Var, String str) throws JSONException {
            this.f13279a = str + "_" + f1Var.w("name");
            this.f13280b = c0.p(f1Var.r("columns"));
        }

        /* access modifiers changed from: package-private */
        public String[] a() {
            return this.f13280b;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f13279a;
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        private final long f13281a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13282b;

        d(f1 f1Var) throws JSONException {
            this.f13281a = f1Var.v("seconds");
            this.f13282b = f1Var.w("column");
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.f13282b;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f13281a;
        }
    }

    n0(f1 f1Var) throws JSONException {
        this.f13265a = f1Var.l(MediationMetaData.KEY_VERSION);
        for (f1 aVar : c0.x(f1Var.r("streams"))) {
            this.f13266b.add(new a(aVar));
        }
    }

    static n0 b(f1 f1Var) {
        try {
            return new n0(f1Var);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public a a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        for (a next : this.f13266b) {
            int i2 = 0;
            for (String equals : next.f13270d) {
                if (str.equals(equals)) {
                    return next;
                }
            }
            String[] d2 = next.f13271e;
            int length = d2.length;
            while (true) {
                if (i2 < length) {
                    if (str.equals(d2[i2])) {
                        return next;
                    }
                    i2++;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<a> c() {
        return this.f13266b;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f13265a;
    }
}
