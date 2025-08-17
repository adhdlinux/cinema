package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.JsonReader;
import android.util.MalformedJsonException;
import com.facebook.common.time.Clock;
import com.startapp.ee;
import com.startapp.sdk.common.advertisingid.AdvertisingIdResolver;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.jobs.JobRequest;
import com.startapp.sdk.triggeredlinks.AppEventsMetadata;
import com.startapp.sdk.triggeredlinks.PeriodicAppEventMetadata;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import com.startapp.x6;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class bf {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34264a;

    /* renamed from: b  reason: collision with root package name */
    public final x6 f34265b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f34266c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f34267d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Long> f34268e;

    /* renamed from: f  reason: collision with root package name */
    public final AdvertisingIdResolver f34269f;

    /* renamed from: g  reason: collision with root package name */
    public final ua<TriggeredLinksMetadata> f34270g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f34271h = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            bf.this.b();
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TriggeredLinksMetadata f34273a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f34274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f34275c;

        public b(TriggeredLinksMetadata triggeredLinksMetadata, Map map, String str) {
            this.f34273a = triggeredLinksMetadata;
            this.f34274b = map;
            this.f34275c = str;
        }

        public void run() {
            try {
                bf.this.b(this.f34273a, this.f34274b, this.f34275c);
            } catch (Throwable th) {
                if (bf.this.a(2)) {
                    y8.a(bf.this.f34264a, th);
                }
            }
        }
    }

    public bf(Context context, x6 x6Var, Executor executor, AdvertisingIdResolver advertisingIdResolver, ua<TriggeredLinksMetadata> uaVar) {
        this.f34264a = context;
        this.f34265b = x6Var;
        this.f34266c = new gb(executor);
        this.f34267d = new Handler(Looper.getMainLooper());
        this.f34268e = new HashMap();
        this.f34269f = advertisingIdResolver;
        this.f34270g = uaVar;
    }

    public final TriggeredLinksMetadata a() {
        TriggeredLinksMetadata call = this.f34270g.call();
        if (call == null || !call.e()) {
            return null;
        }
        return call;
    }

    public void b() {
        String b2;
        this.f34267d.removeCallbacks(this.f34271h);
        ce l2 = ComponentLocator.a(this.f34264a).l();
        int i2 = 1;
        Class<af> cls = af.class;
        l2.a(JobRequest.a((Class<? extends be>[]) new Class[]{cls}));
        TriggeredLinksMetadata a2 = a();
        Map<String, PeriodicAppEventMetadata> map = null;
        AppEventsMetadata a3 = a2 != null ? a2.a() : null;
        if (a3 != null) {
            map = a3.d();
        }
        if (map != null && map.size() >= 1) {
            x6.a a4 = this.f34265b.edit();
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = Long.MAX_VALUE;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                PeriodicAppEventMetadata periodicAppEventMetadata = (PeriodicAppEventMetadata) next.getValue();
                if (!(str == null || str.length() < i2 || periodicAppEventMetadata == null || (b2 = periodicAppEventMetadata.b()) == null || b2.length() < i2)) {
                    int a5 = periodicAppEventMetadata.a();
                    int i3 = a5 < 5 ? 5 : a5;
                    long j3 = this.f34265b.getLong(str, 0);
                    if (j3 > currentTimeMillis) {
                        a4.a(str, Long.valueOf(j3));
                        a4.f36915a.putLong(str, j3);
                        if (j2 > j3) {
                            j2 = j3;
                        }
                    } else {
                        long j4 = ((long) (i3 * 1000)) + currentTimeMillis;
                        a4.a(str, Long.valueOf(j4));
                        a4.f36915a.putLong(str, j4);
                        df dfVar = r0;
                        Executor executor = this.f34266c;
                        df dfVar2 = new df(this, a2, str, b2, i3);
                        executor.execute(dfVar);
                    }
                }
                i2 = 1;
            }
            a4.apply();
            if (j2 != Clock.MAX_TIME) {
                long j5 = j2 - currentTimeMillis;
                if (j5 < 5000) {
                    a(j5);
                    return;
                }
                ee.a aVar = new ee.a(cls);
                aVar.f34490d = Long.valueOf(j5);
                aVar.f36521b = JobRequest.Network.f36517b;
                l2.a(new ee((ee.a) aVar.a()));
            }
        }
    }

    public boolean a(int i2) {
        TriggeredLinksMetadata a2 = a();
        return a2 != null && (a2.b() & i2) == i2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.f34267d.postDelayed(this.f34271h, j2);
        } else {
            this.f34267d.post(this.f34271h);
        }
    }

    public void a(String str, int i2) {
        x6.a a2 = this.f34265b.edit();
        long currentTimeMillis = System.currentTimeMillis() + ((long) (i2 * 1000));
        a2.a(str, Long.valueOf(currentTimeMillis));
        a2.f36915a.putLong(str, currentTimeMillis);
        a2.apply();
    }

    public void a(TriggeredLinksMetadata triggeredLinksMetadata, Map<String, String> map, String str) {
        this.f34266c.execute(new b(triggeredLinksMetadata, map, str));
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.net.URLConnection] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r7.equals("startapp_advertising_id") == false) goto L_0x0035;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011d A[Catch:{ all -> 0x0122 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) throws java.io.IOException, org.json.JSONException {
        /*
            r10 = this;
            android.net.Uri r14 = android.net.Uri.parse(r14)
            android.net.Uri$Builder r0 = r14.buildUpon()
            r1 = 0
            r0.query(r1)
            java.util.Set r2 = r14.getQueryParameterNames()
            java.util.Iterator r2 = r2.iterator()
        L_0x0014:
            boolean r3 = r2.hasNext()
            r4 = 2
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0026
            goto L_0x0014
        L_0x0026:
            java.lang.String r7 = r14.getQueryParameter(r3)
            if (r7 != 0) goto L_0x002d
            goto L_0x0014
        L_0x002d:
            int r8 = r7.hashCode()
            r9 = -1
            switch(r8) {
                case -1089147532: goto L_0x004b;
                case 613582261: goto L_0x0040;
                case 1311708630: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            r4 = -1
            goto L_0x0055
        L_0x0037:
            java.lang.String r5 = "startapp_advertising_id"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x0055
            goto L_0x0035
        L_0x0040:
            java.lang.String r4 = "startapp_no_tracking"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x0049
            goto L_0x0035
        L_0x0049:
            r4 = 1
            goto L_0x0055
        L_0x004b:
            java.lang.String r4 = "startapp_package_id"
            boolean r4 = r7.equals(r4)
            if (r4 != 0) goto L_0x0054
            goto L_0x0035
        L_0x0054:
            r4 = 0
        L_0x0055:
            java.lang.String r5 = "0"
            switch(r4) {
                case 0: goto L_0x0082;
                case 1: goto L_0x0072;
                case 2: goto L_0x005e;
                default: goto L_0x005a;
            }
        L_0x005a:
            r0.appendQueryParameter(r3, r7)
            goto L_0x0014
        L_0x005e:
            com.startapp.sdk.common.advertisingid.AdvertisingIdResolver r4 = r10.f34269f
            com.startapp.yb r4 = r4.a()
            java.lang.String r4 = r4.f36967b
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x006e
            java.lang.String r4 = "00000000-0000-0000-0000-000000000000"
        L_0x006e:
            r0.appendQueryParameter(r3, r4)
            goto L_0x0014
        L_0x0072:
            com.startapp.sdk.common.advertisingid.AdvertisingIdResolver r4 = r10.f34269f
            com.startapp.yb r4 = r4.a()
            boolean r4 = r4.f36969d
            if (r4 == 0) goto L_0x007e
            java.lang.String r5 = "1"
        L_0x007e:
            r0.appendQueryParameter(r3, r5)
            goto L_0x0014
        L_0x0082:
            android.content.Context r4 = r10.f34264a
            java.lang.String r4 = r4.getPackageName()
            r0.appendQueryParameter(r3, r4)
            goto L_0x0014
        L_0x008c:
            android.net.Uri r14 = r0.build()
            java.lang.String r14 = r14.toString()
            java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x0114 }
            r0.<init>(r14)     // Catch:{ all -> 0x0114 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x0114 }
            boolean r2 = r0 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x00d2
            r2 = r0
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ all -> 0x0110 }
            r2.setInstanceFollowRedirects(r5)     // Catch:{ all -> 0x0110 }
            int r3 = r11.c()     // Catch:{ all -> 0x0110 }
            int r3 = r3 * 1000
            r2.setReadTimeout(r3)     // Catch:{ all -> 0x0110 }
            int r3 = r11.c()     // Catch:{ all -> 0x0110 }
            int r3 = r3 * 1000
            r2.setConnectTimeout(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "User-Agent"
            android.content.Context r5 = r10.f34264a     // Catch:{ all -> 0x0110 }
            java.lang.String r5 = android.webkit.WebSettings.getDefaultUserAgent(r5)     // Catch:{ all -> 0x0110 }
            r2.setRequestProperty(r3, r5)     // Catch:{ all -> 0x0110 }
            r2.connect()     // Catch:{ all -> 0x0110 }
            int r6 = r2.getResponseCode()     // Catch:{ all -> 0x0110 }
            java.io.InputStream r1 = r2.getInputStream()     // Catch:{ all -> 0x0110 }
            r10.a((java.lang.String) r12, (java.lang.String) r13, (java.io.InputStream) r1)     // Catch:{ all -> 0x0110 }
        L_0x00d2:
            com.startapp.lb.a((java.io.Closeable) r1)
            boolean r1 = r0 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x00df }
            if (r1 == 0) goto L_0x00e0
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x00df }
            r0.disconnect()     // Catch:{ all -> 0x00df }
            goto L_0x00e0
        L_0x00df:
        L_0x00e0:
            boolean r11 = r11.f()
            if (r11 == 0) goto L_0x010f
            int r6 = r6 / 100
            if (r6 != r4) goto L_0x010f
            com.startapp.y8 r11 = new com.startapp.y8
            com.startapp.z8 r0 = com.startapp.z8.f37004k
            r11.<init>((com.startapp.z8) r0)
            r11.f36954d = r13
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r0 = "eventType"
            org.json.JSONObject r12 = r13.put(r0, r12)
            java.lang.String r13 = "url"
            org.json.JSONObject r12 = r12.put(r13, r14)
            java.lang.String r12 = r12.toString()
            r11.f36955e = r12
            android.content.Context r12 = r10.f34264a
            r11.a(r12)
        L_0x010f:
            return
        L_0x0110:
            r11 = move-exception
            r12 = r1
            r1 = r0
            goto L_0x0116
        L_0x0114:
            r11 = move-exception
            r12 = r1
        L_0x0116:
            com.startapp.lb.a((java.io.Closeable) r12)
            boolean r12 = r1 instanceof java.net.HttpURLConnection     // Catch:{ all -> 0x0122 }
            if (r12 == 0) goto L_0x0122
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x0122 }
            r1.disconnect()     // Catch:{ all -> 0x0122 }
        L_0x0122:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.bf.a(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r2.longValue() > android.os.SystemClock.elapsedRealtime()) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11) {
        /*
            r8 = this;
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0008:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x0097
            java.lang.Object r0 = r10.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            if (r1 == 0) goto L_0x0097
            int r2 = r1.length()
            r3 = 1
            if (r2 >= r3) goto L_0x002b
            goto L_0x0097
        L_0x002b:
            if (r0 == 0) goto L_0x0097
            int r2 = r0.length()
            if (r2 >= r3) goto L_0x0034
            goto L_0x0097
        L_0x0034:
            java.util.List r2 = r9.d()
            if (r2 != 0) goto L_0x003b
            goto L_0x0080
        L_0x003b:
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.String r4 = java.lang.String.valueOf(r4)
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x003f
            java.util.Map<java.lang.String, java.lang.Long> r2 = r8.f34268e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r5 = "-"
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            java.lang.Object r2 = r2.get(r4)
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x0080
            long r4 = r2.longValue()
            long r6 = android.os.SystemClock.elapsedRealtime()
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r3 = 0
        L_0x0081:
            if (r3 == 0) goto L_0x0084
            return
        L_0x0084:
            r8.a(r9, r11, r1, r0)     // Catch:{ all -> 0x0088 }
            goto L_0x0008
        L_0x0088:
            r0 = move-exception
            r1 = 4
            boolean r1 = r8.a((int) r1)
            if (r1 == 0) goto L_0x0008
            android.content.Context r1 = r8.f34264a
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
            goto L_0x0008
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.bf.b(com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata, java.util.Map, java.lang.String):void");
    }

    public final void a(String str, String str2, InputStream inputStream) throws IOException {
        try {
            Object b2 = p.b(new JsonReader(new InputStreamReader(inputStream)));
            if (b2 instanceof Map) {
                Object obj = ((Map) b2).get("throttleSec");
                if (obj instanceof Number) {
                    int intValue = ((Number) obj).intValue();
                    Map<String, Long> map = this.f34268e;
                    map.put(str2 + "-" + str, Long.valueOf(SystemClock.elapsedRealtime() + ((long) (intValue * 1000))));
                }
            }
        } catch (IOException e2) {
            if (!(e2 instanceof MalformedJsonException)) {
                throw e2;
            }
        }
    }
}
