package com.applovin.impl.sdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15783a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f15784b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Collection<CountDownLatch> f15785c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f15786d = false;

    /* renamed from: e  reason: collision with root package name */
    private static o.a f15787e = null;

    public static o.a a(Context context) {
        return b(context);
    }

    public static boolean a() {
        return Utils.checkClassExistence("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        if (r2 == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r5 = c(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        f15786d = true;
        f15787e = r5;
        r5 = new java.util.HashSet(r1);
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r5.hasNext() == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        ((java.util.concurrent.CountDownLatch) r5.next()).countDown();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        if (r3.await(60, java.util.concurrent.TimeUnit.SECONDS) != false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0054, code lost:
        if (com.applovin.impl.sdk.v.a() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        com.applovin.impl.sdk.v.i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
        if (com.applovin.impl.sdk.v.a() != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
        com.applovin.impl.sdk.v.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
        r5 = f15784b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0 = f15787e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0071, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0072, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.impl.sdk.o.a b(android.content.Context r5) {
        /*
            java.lang.Object r0 = f15784b
            monitor-enter(r0)
            boolean r1 = f15786d     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x000b
            com.applovin.impl.sdk.o$a r5 = f15787e     // Catch:{ all -> 0x0076 }
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return r5
        L_0x000b:
            java.util.Collection<java.util.concurrent.CountDownLatch> r1 = f15785c     // Catch:{ all -> 0x0076 }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0076 }
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x0076 }
            r4 = 1
            r3.<init>(r4)     // Catch:{ all -> 0x0076 }
            r1.add(r3)     // Catch:{ all -> 0x0076 }
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0046
            com.applovin.impl.sdk.o$a r5 = c(r5)
            monitor-enter(r0)
            f15786d = r4     // Catch:{ all -> 0x0043 }
            f15787e = r5     // Catch:{ all -> 0x0043 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0043 }
            r5.<init>(r1)     // Catch:{ all -> 0x0043 }
            r1.clear()     // Catch:{ all -> 0x0043 }
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            java.util.Iterator r5 = r5.iterator()
        L_0x0033:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0046
            java.lang.Object r0 = r5.next()
            java.util.concurrent.CountDownLatch r0 = (java.util.concurrent.CountDownLatch) r0
            r0.countDown()
            goto L_0x0033
        L_0x0043:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r5
        L_0x0046:
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x005e }
            r0 = 60
            boolean r5 = r3.await(r0, r5)     // Catch:{ InterruptedException -> 0x005e }
            if (r5 != 0) goto L_0x006c
            boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ InterruptedException -> 0x005e }
            if (r5 == 0) goto L_0x006c
            java.lang.String r5 = "DataCollector"
            java.lang.String r0 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }: collection timeout"
            com.applovin.impl.sdk.v.i(r5, r0)     // Catch:{ InterruptedException -> 0x005e }
            goto L_0x006c
        L_0x005e:
            r5 = move-exception
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = "DataCollector"
            java.lang.String r1 = "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }"
            com.applovin.impl.sdk.v.c(r0, r1, r5)
        L_0x006c:
            java.lang.Object r5 = f15784b
            monitor-enter(r5)
            com.applovin.impl.sdk.o$a r0 = f15787e     // Catch:{ all -> 0x0073 }
            monitor-exit(r5)     // Catch:{ all -> 0x0073 }
            return r0
        L_0x0073:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0073 }
            throw r0
        L_0x0076:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.c.b(android.content.Context):com.applovin.impl.sdk.o$a");
    }

    private static o.a c(Context context) {
        o.a d2 = d(context);
        if (d2 == null) {
            d2 = e(context);
        }
        return d2 == null ? new o.a() : d2;
    }

    private static o.a d(Context context) {
        if (a()) {
            try {
                o.a aVar = new o.a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                aVar.f15743a = advertisingIdInfo.isLimitAdTrackingEnabled();
                aVar.f15744b = advertisingIdInfo.getId();
                return aVar;
            } catch (Throwable th) {
                if (AppLovinSdkUtils.isFireOS(context) || !v.a()) {
                    return null;
                }
                v.c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
                return null;
            }
        } else if (AppLovinSdkUtils.isFireOS(context) || !v.a()) {
            return null;
        } else {
            v.i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
            return null;
        }
    }

    private static o.a e(Context context) {
        String str;
        if (f15783a) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                o.a aVar = new o.a();
                aVar.f15744b = StringUtils.emptyIfNull(Settings.Secure.getString(contentResolver, "advertising_id"));
                aVar.f15743a = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
                return aVar;
            } catch (Settings.SettingNotFoundException e2) {
                th = e2;
                if (v.a()) {
                    str = "Unable to determine if Fire OS limited ad tracking is turned on";
                    v.c("DataCollector", str, th);
                }
            } catch (Throwable th) {
                th = th;
                if (v.a()) {
                    str = "Unable to collect Fire OS IDFA";
                    v.c("DataCollector", str, th);
                }
            }
        }
        f15783a = false;
        return null;
    }
}
