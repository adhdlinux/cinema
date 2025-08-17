package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final a f15482a = new a("Age Restricted User", d.f15226l);

    /* renamed from: b  reason: collision with root package name */
    private static final a f15483b = new a("Has User Consent", d.f15225k);

    /* renamed from: c  reason: collision with root package name */
    private static final a f15484c = new a("\"Do Not Sell\"", d.f15227m);

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f15485a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Boolean> f15486b;

        a(String str, d<Boolean> dVar) {
            this.f15485a = str;
            this.f15486b = dVar;
        }

        public Boolean a(Context context) {
            if (context != null) {
                return (Boolean) e.b(this.f15486b, null, context);
            }
            if (v.a()) {
                v.i("AppLovinSdk", "Failed to get value for key: " + this.f15486b);
            }
            return null;
        }

        public String a() {
            return this.f15485a;
        }

        public String b(Context context) {
            Boolean a2 = a(context);
            return a2 != null ? a2.toString() : "No value set";
        }
    }

    public static a a() {
        return f15482a;
    }

    public static String a(Context context) {
        return a(f15482a, context) + a(f15483b, context) + a(f15484c, context);
    }

    private static String a(a aVar, Context context) {
        return ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + aVar.f15485a + " - " + aVar.b(context);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.c.d, java.lang.Object, com.applovin.impl.sdk.c.d<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.applovin.impl.sdk.c.d<java.lang.Boolean> r2, java.lang.Boolean r3, android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0020
            boolean r3 = com.applovin.impl.sdk.v.a()
            if (r3 == 0) goto L_0x001f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to update compliance value for key: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppLovinSdk"
            com.applovin.impl.sdk.v.i(r3, r2)
        L_0x001f:
            return r0
        L_0x0020:
            r1 = 0
            java.lang.Object r1 = com.applovin.impl.sdk.c.e.b(r2, r1, (android.content.Context) r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.applovin.impl.sdk.c.e.a(r2, r3, (android.content.Context) r4)
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r3) goto L_0x0030
            r0 = 1
        L_0x0030:
            return r0
        L_0x0031:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.j.a(com.applovin.impl.sdk.c.d, java.lang.Boolean, android.content.Context):boolean");
    }

    public static boolean a(boolean z2, Context context) {
        return a(d.f15226l, Boolean.valueOf(z2), context);
    }

    public static a b() {
        return f15483b;
    }

    public static boolean b(boolean z2, Context context) {
        return a(d.f15225k, Boolean.valueOf(z2), context);
    }

    public static a c() {
        return f15484c;
    }

    public static boolean c(boolean z2, Context context) {
        return a(d.f15227m, Boolean.valueOf(z2), context);
    }
}
