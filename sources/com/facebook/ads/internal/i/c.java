package com.facebook.ads.internal.i;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.ads.internal.f.e;
import com.facebook.ads.internal.g.a;
import com.facebook.ads.internal.g.b;
import com.facebook.ads.internal.q.a.g;
import com.facebook.ads.internal.q.a.h;
import com.facebook.ads.internal.q.a.i;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.n;
import com.facebook.ads.internal.q.a.s;
import com.facebook.ads.internal.q.a.t;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f20210a = 1303;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicInteger f20211b = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static String f20212c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final g.a f20213d = g.a();

    /* renamed from: e  reason: collision with root package name */
    private final Context f20214e;

    /* renamed from: f  reason: collision with root package name */
    private final b f20215f;

    public c(Context context, boolean z2) {
        this.f20214e = context;
        this.f20215f = new b(context);
        a(context, z2);
    }

    private static void a(final Context context, boolean z2) {
        if (f20211b.compareAndSet(0, 1)) {
            try {
                n.a();
                final SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                b bVar = new b(context);
                final String str = "AFP;" + bVar.g();
                f20212c = sharedPreferences.getString(str, (String) null);
                FutureTask futureTask = new FutureTask(new Callable<Boolean>() {
                    /* renamed from: a */
                    public Boolean call() {
                        Context context = context;
                        String unused = c.f20212c = c.b(context, context.getPackageName());
                        sharedPreferences.edit().putString(str, c.f20212c).apply();
                        c.f20211b.set(2);
                        return Boolean.TRUE;
                    }
                });
                Executors.newSingleThreadExecutor().submit(futureTask);
                if (z2) {
                    futureTask.get();
                }
            } catch (Exception unused) {
                f20211b.set(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static String b(Context context, String str) {
        try {
            return i.a(context.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e2) {
            Map<String, String> b2 = new c(context, false).b();
            b2.put("subtype", "generic");
            b2.put("subtype_code", String.valueOf(f20210a));
            e.a(e2, context, b2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084 A[SYNTHETIC, Splitter:B:34:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0089 A[Catch:{ IOException -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e A[Catch:{ IOException -> 0x0091 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a() {
        /*
            r7 = this;
            android.content.Context r0 = r7.f20214e
            r1 = 1
            a((android.content.Context) r0, (boolean) r1)
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0074, all -> 0x006e }
            r1.<init>()     // Catch:{ IOException -> 0x0074, all -> 0x006e }
            android.util.Base64OutputStream r2 = new android.util.Base64OutputStream     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            java.util.zip.DeflaterOutputStream r3 = new java.util.zip.DeflaterOutputStream     // Catch:{ IOException -> 0x005f, all -> 0x005a }
            r3.<init>(r2)     // Catch:{ IOException -> 0x005f, all -> 0x005a }
            java.util.Map r0 = r7.b()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r4 = com.facebook.ads.internal.c.b.f20056b     // Catch:{ IOException -> 0x0058 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IOException -> 0x0058 }
            if (r4 == 0) goto L_0x0028
            android.content.Context r4 = r7.f20214e     // Catch:{ IOException -> 0x0058 }
            com.facebook.ads.internal.c.b.a(r4)     // Catch:{ IOException -> 0x0058 }
        L_0x0028:
            java.lang.String r4 = "IDFA"
            java.lang.String r5 = com.facebook.ads.internal.c.b.f20056b     // Catch:{ IOException -> 0x0058 }
            r0.put(r4, r5)     // Catch:{ IOException -> 0x0058 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ IOException -> 0x0058 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0058 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0058 }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0058 }
            r3.write(r0)     // Catch:{ IOException -> 0x0058 }
            r3.close()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0058 }
            java.lang.String r4 = "\n"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.replaceAll(r4, r5)     // Catch:{ IOException -> 0x0058 }
            r3.close()     // Catch:{ IOException -> 0x0057 }
            r2.close()     // Catch:{ IOException -> 0x0057 }
            r1.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            return r0
        L_0x0058:
            r0 = move-exception
            goto L_0x0079
        L_0x005a:
            r3 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0082
        L_0x005f:
            r3 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x0079
        L_0x0064:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
            goto L_0x0082
        L_0x0069:
            r2 = move-exception
            r3 = r0
            r0 = r2
            r2 = r3
            goto L_0x0079
        L_0x006e:
            r1 = move-exception
            r2 = r0
            r3 = r2
            r0 = r1
            r1 = r3
            goto L_0x0082
        L_0x0074:
            r1 = move-exception
            r2 = r0
            r3 = r2
            r0 = r1
            r1 = r3
        L_0x0079:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = "Failed to build user token"
            r4.<init>(r5, r0)     // Catch:{ all -> 0x0081 }
            throw r4     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r0 = move-exception
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            r3.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ IOException -> 0x0091 }
        L_0x008c:
            if (r1 == 0) goto L_0x0091
            r1.close()     // Catch:{ IOException -> 0x0091 }
        L_0x0091:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.i.c.a():java.lang.String");
    }

    public Map<String, String> b() {
        a(this.f20214e, false);
        a.a(this.f20214e);
        HashMap hashMap = new HashMap();
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.99.1");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f2 = x.f20694b;
        int i2 = this.f20214e.getResources().getDisplayMetrics().widthPixels;
        int i3 = this.f20214e.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f2));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i2) / f2)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i3) / f2)));
        hashMap.put("ATTRIBUTION_ID", com.facebook.ads.internal.c.b.f20055a);
        hashMap.put("ID_SOURCE", com.facebook.ads.internal.c.b.f20058d);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", b.f20170a);
        hashMap.put("BUNDLE", this.f20215f.f());
        hashMap.put("APPNAME", this.f20215f.d());
        hashMap.put("APPVERS", this.f20215f.g());
        hashMap.put("APPBUILD", String.valueOf(this.f20215f.h()));
        hashMap.put("CARRIER", this.f20215f.c());
        hashMap.put("MAKE", this.f20215f.a());
        hashMap.put("MODEL", this.f20215f.b());
        hashMap.put("ROOTED", String.valueOf(f20213d.f20630d));
        hashMap.put("INSTALLER", this.f20215f.e());
        hashMap.put("SDK_CAPABILITY", com.facebook.ads.internal.q.a.c.b());
        hashMap.put("NETWORK_TYPE", String.valueOf(s.a(this.f20214e).f20673g));
        hashMap.put("SESSION_TIME", t.a(n.b()));
        hashMap.put("SESSION_ID", n.c());
        String str = f20212c;
        if (str != null) {
            hashMap.put("AFP", str);
        }
        String a2 = g.a(this.f20214e);
        if (a2 != null) {
            hashMap.put("ASHAS", a2);
        }
        hashMap.put("UNITY", String.valueOf(h.a(this.f20214e)));
        String mediationService = AdInternalSettings.getMediationService();
        if (mediationService != null) {
            hashMap.put("MEDIATION_SERVICE", mediationService);
        }
        hashMap.put("ACCESSIBILITY_ENABLED", String.valueOf(this.f20215f.i()));
        if (this.f20215f.j() != -1) {
            hashMap.put("APP_MIN_SDK_VERSION", String.valueOf(this.f20215f.j()));
        }
        hashMap.put("VALPARAMS", b.a());
        hashMap.put("ANALOG", k.a(a.a()));
        return hashMap;
    }
}
