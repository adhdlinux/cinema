package com.chartboost.sdk.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

public final class t8 {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public p f18635a;

        /* renamed from: b  reason: collision with root package name */
        public k f18636b;

        /* renamed from: c  reason: collision with root package name */
        public x7 f18637c;

        public a(p pVar, k kVar, x7 x7Var) {
            this.f18635a = pVar;
            this.f18636b = kVar;
            this.f18637c = x7Var;
        }

        public final void a(p pVar) {
            this.f18635a = pVar;
        }

        public final k b() {
            return this.f18636b;
        }

        public final p c() {
            return this.f18635a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.a(this.f18635a, aVar.f18635a) && Intrinsics.a(this.f18636b, aVar.f18636b) && Intrinsics.a(this.f18637c, aVar.f18637c);
        }

        public int hashCode() {
            p pVar = this.f18635a;
            int i2 = 0;
            int hashCode = (pVar == null ? 0 : pVar.hashCode()) * 31;
            k kVar = this.f18636b;
            int hashCode2 = (hashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
            x7 x7Var = this.f18637c;
            if (x7Var != null) {
                i2 = x7Var.hashCode();
            }
            return hashCode2 + i2;
        }

        public String toString() {
            return "OMSessionHolder(omSession=" + this.f18635a + ", omAdEvents=" + this.f18636b + ", mediaEvents=" + this.f18637c + ')';
        }

        public final void a(k kVar) {
            this.f18636b = kVar;
        }

        public final x7 a() {
            return this.f18637c;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18638a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.chartboost.sdk.impl.y7[] r0 = com.chartboost.sdk.impl.y7.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.y7 r1 = com.chartboost.sdk.impl.y7.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.y7 r1 = com.chartboost.sdk.impl.y7.HTML     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.y7 r1 = com.chartboost.sdk.impl.y7.VIDEO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.impl.y7 r1 = com.chartboost.sdk.impl.y7.AUDIO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.impl.y7 r1 = com.chartboost.sdk.impl.y7.NATIVE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f18638a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.t8.b.<clinit>():void");
        }
    }

    public final a a(z2 z2Var, y7 y7Var, e9 e9Var, String str, List list, boolean z2, List list2) {
        z2 z2Var2 = z2Var;
        y7 y7Var2 = y7Var;
        Intrinsics.f(z2Var, "webView");
        Intrinsics.f(y7Var, "mtype");
        Intrinsics.f(list, "verificationScriptResourcesList");
        Intrinsics.f(list2, "verificationListConfig");
        try {
            p a2 = p.a(a(y7Var), a(e9Var, str, list, z2, list2, y7Var, z2Var));
            a2.a(z2Var);
            k a3 = k.a(a2);
            Intrinsics.e(a2, "it");
            return new a(a2, a3, a(y7Var, a2));
        } catch (Exception e2) {
            String a4 = u8.f18774a;
            Intrinsics.e(a4, "TAG");
            w7.b(a4, "OMSDK create session exception: " + e2);
            return null;
        }
    }

    public final c4 b(y7 y7Var) {
        int i2 = b.f18638a[y7Var.ordinal()];
        if (i2 == 1) {
            return c4.NATIVE_DISPLAY;
        }
        if (i2 == 2) {
            return c4.HTML_DISPLAY;
        }
        if (i2 == 3) {
            return c4.VIDEO;
        }
        if (i2 == 4) {
            return c4.AUDIO;
        }
        if (i2 == 5) {
            return c4.NATIVE_DISPLAY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final d9 c(y7 y7Var) {
        int i2 = b.f18638a[y7Var.ordinal()];
        if (i2 == 1) {
            return d9.NATIVE;
        }
        if (i2 == 2) {
            return d9.NONE;
        }
        if (i2 == 3) {
            return d9.NATIVE;
        }
        if (i2 == 4) {
            return d9.NATIVE;
        }
        if (i2 == 5) {
            return d9.NATIVE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final x7 a(y7 y7Var, p pVar) {
        if (y7Var == y7.HTML) {
            return null;
        }
        return x7.a(pVar);
    }

    public final r a(e9 e9Var, String str, List list, boolean z2, List list2, y7 y7Var, z2 z2Var) {
        if (y7Var == y7.HTML) {
            return a(e9Var, z2Var);
        }
        return a(e9Var, str, list, z2, list2);
    }

    public final r a(e9 e9Var, String str, List list, boolean z2, List list2) {
        try {
            return r.a(e9Var, str, a(list, list2, z2), (String) null, (String) null);
        } catch (IllegalArgumentException e2) {
            String a2 = u8.f18774a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "buildNativeContext error: " + e2);
            return null;
        }
    }

    public final r a(e9 e9Var, z2 z2Var) {
        try {
            return r.a(e9Var, z2Var, (String) null, (String) null);
        } catch (IllegalArgumentException e2) {
            String a2 = u8.f18774a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "buildHtmlContext error: " + e2);
            return null;
        }
    }

    public final List a(List list, List list2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.addAll(a(list2));
        }
        arrayList.addAll(list);
        return arrayList;
    }

    public final URL a(String str) {
        try {
            return new URL(str);
        } catch (Exception e2) {
            String a2 = u8.f18774a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "buildVerificationResources invalid url: " + e2);
            return null;
        }
    }

    public final q a(y7 y7Var) {
        try {
            return q.a(b(y7Var), h7.BEGIN_TO_RENDER, d9.NATIVE, c(y7Var), false);
        } catch (IllegalArgumentException e2) {
            String a2 = u8.f18774a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "buildAdSessionVideoConfig error: " + e2);
            return null;
        }
    }

    public final List a(List list) {
        try {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                pc pcVar = (pc) it2.next();
                arrayList.add(qc.a(pcVar.c(), a(pcVar.b()), pcVar.a()));
            }
            return arrayList;
        } catch (Exception e2) {
            String a2 = u8.f18774a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "buildVerificationResources error: " + e2);
            return CollectionsKt__CollectionsKt.f();
        }
    }
}
