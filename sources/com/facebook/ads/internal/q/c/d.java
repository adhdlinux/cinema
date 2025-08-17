package com.facebook.ads.internal.q.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.facebook.ads.internal.g.b;
import com.facebook.ads.internal.i.c;
import com.facebook.ads.internal.p.a.a;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f20730a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f20731b;

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f20732c;

    static {
        HashSet hashSet = new HashSet(1);
        f20731b = hashSet;
        HashSet hashSet2 = new HashSet(2);
        f20732c = hashSet2;
        hashSet.add("1ww8E0AYsR2oX5lndk2hwp2Uosk=\n");
        hashSet2.add("toZ2GRnRjC9P5VVUdCpOrFH8lfQ=\n");
        hashSet2.add("3lKvjNsfmrn+WmfDhvr2iVh/yRs=\n");
        hashSet2.add("B08QtE4yLCdli4rptyqAEczXOeA=\n");
        hashSet2.add("XZXI6anZbdKf+taURdnyUH5ipgM=\n");
    }

    public static a a(Context context) {
        return a(context, true);
    }

    public static a a(Context context, boolean z2) {
        a aVar = new a();
        a(context, aVar, z2);
        return aVar;
    }

    private static String a(Context context, String str, String str2) {
        Class<?> cls = Class.forName(str);
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            return (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    private static void a(Context context, a aVar, boolean z2) {
        b bVar = new b(context);
        aVar.c((int) HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
        aVar.b(3);
        if (!com.facebook.ads.internal.c.b.f20057c) {
            aVar.a("X-FB-Pool-Routing-Token", new c(context, true).a());
        }
        aVar.a("user-agent", c(context, z2) + " [FBAN/AudienceNetworkForAndroid;FBSN/" + "Android" + ";FBSV/" + b.f20170a + ";FBAB/" + bVar.f() + ";FBAV/" + bVar.g() + ";FBBV/" + bVar.h() + ";FBVS/" + "4.99.1" + ";FBLC/" + Locale.getDefault().toString() + "]");
    }

    public static boolean a() {
        String urlPrefix = AdInternalSettings.getUrlPrefix();
        return !TextUtils.isEmpty(urlPrefix) && urlPrefix.endsWith(".sb");
    }

    public static a b(Context context) {
        return b(context, true);
    }

    public static a b(Context context, boolean z2) {
        a aVar = new a();
        a(context, aVar, z2);
        if (!a()) {
            aVar.b(f20732c);
            aVar.a(f20731b);
        }
        return aVar;
    }

    @TargetApi(17)
    private static String c(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:25|24|26|27|28|29) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String c(android.content.Context r2, boolean r3) {
        /*
            if (r2 != 0) goto L_0x0005
            java.lang.String r2 = "Unknown"
            return r2
        L_0x0005:
            if (r3 == 0) goto L_0x000e
            java.lang.String r2 = "http.agent"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            return r2
        L_0x000e:
            java.lang.String r3 = f20730a
            if (r3 == 0) goto L_0x0013
            return r3
        L_0x0013:
            java.lang.Class<com.facebook.ads.internal.q.c.d> r3 = com.facebook.ads.internal.q.c.d.class
            monitor-enter(r3)
            java.lang.String r0 = f20730a     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            return r0
        L_0x001c:
            java.lang.String r0 = c(r2)     // Catch:{ Exception -> 0x0024 }
            f20730a = r0     // Catch:{ Exception -> 0x0024 }
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            return r0
        L_0x0024:
            java.lang.String r0 = "android.webkit.WebSettings"
            java.lang.String r1 = "android.webkit.WebView"
            java.lang.String r0 = a((android.content.Context) r2, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x002f }
            f20730a = r0     // Catch:{ Exception -> 0x002f }
            goto L_0x0050
        L_0x002f:
            java.lang.String r0 = "android.webkit.WebSettingsClassic"
            java.lang.String r1 = "android.webkit.WebViewClassic"
            java.lang.String r0 = a((android.content.Context) r2, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x003a }
            f20730a = r0     // Catch:{ Exception -> 0x003a }
            goto L_0x0050
        L_0x003a:
            android.webkit.WebView r0 = new android.webkit.WebView     // Catch:{ all -> 0x0054 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            android.webkit.WebSettings r2 = r0.getSettings()     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = r2.getUserAgentString()     // Catch:{ all -> 0x0054 }
            f20730a = r2     // Catch:{ all -> 0x0054 }
            r0.destroy()     // Catch:{ all -> 0x0054 }
        L_0x0050:
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = f20730a
            return r2
        L_0x0054:
            r2 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0054 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.q.c.d.c(android.content.Context, boolean):java.lang.String");
    }
}
