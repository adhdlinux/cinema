package com.applovin.impl.sdk.network;

import androidx.core.util.Consumer;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.v;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f15605a = Arrays.asList(new String[]{"5.0/i", "4.0/ad", "1.0/mediate"});
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final m f15606b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final v f15607c;

    /* renamed from: d  reason: collision with root package name */
    private final e f15608d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f15609a;

        /* renamed from: b  reason: collision with root package name */
        private long f15610b;

        /* access modifiers changed from: private */
        public void a(long j2) {
            this.f15609a = j2;
        }

        /* access modifiers changed from: private */
        public void b(long j2) {
            this.f15610b = j2;
        }

        public long a() {
            return this.f15609a;
        }

        public long b() {
            return this.f15610b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$b  reason: collision with other inner class name */
    private class C0022b<T> implements Consumer<e.c> {

        /* renamed from: b  reason: collision with root package name */
        private final String f15612b;

        /* renamed from: c  reason: collision with root package name */
        private final c<T> f15613c;

        /* renamed from: d  reason: collision with root package name */
        private final String f15614d;

        /* renamed from: e  reason: collision with root package name */
        private final T f15615e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f15616f;

        /* renamed from: g  reason: collision with root package name */
        private final long f15617g;

        /* renamed from: h  reason: collision with root package name */
        private final a f15618h;

        /* renamed from: i  reason: collision with root package name */
        private final c<T> f15619i;

        private C0022b(String str, c<T> cVar, String str2, T t2, boolean z2, long j2, a aVar, c<T> cVar2) {
            this.f15612b = str;
            this.f15613c = cVar;
            this.f15614d = str2;
            this.f15615e = t2;
            this.f15616f = z2;
            this.f15617g = j2;
            this.f15618h = aVar;
            this.f15619i = cVar2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0132, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0133, code lost:
            r9 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0134, code lost:
            if (r1 == 0) goto L_0x0136;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0136, code lost:
            r1 = com.applovin.impl.sdk.network.b.a(r10.f15611a, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r11 = r11.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
            if (r11 != null) goto L_0x0142;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0144, code lost:
            if (r10.f15616f != false) goto L_0x0146;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
            r11 = com.applovin.impl.sdk.utils.m.a(r11, com.applovin.impl.sdk.network.b.a(r10.f15611a).z());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
            r0 = com.applovin.impl.sdk.network.b.a(r10.f15611a, r11, (java.lang.Object) r10.f15615e);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0173, code lost:
            r11 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0174, code lost:
            r5 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
            com.applovin.impl.sdk.network.b.a(r10.f15611a, r10.f15614d, r10.f15612b, r5, r10.f15617g, r11);
            r10.f15619i.a(-901, r11.getMessage(), null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0191, code lost:
            com.applovin.impl.sdk.network.b.a(r10.f15611a, r10.f15614d, r10.f15612b, r5, r10.f15617g);
            r10.f15619i.a(r10.f15615e, -901);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0132 A[ExcHandler: all (r2v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v4 int) = (r1v0 int), (r1v8 int), (r1v8 int), (r1v8 int), (r1v8 int) binds: [B:1:0x0002, B:4:0x0008, B:41:0x00cf, B:27:0x0070, B:18:0x0045] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0002] */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x017b  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0191  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(com.applovin.impl.sdk.network.e.c r11) {
            /*
                r10 = this;
                r0 = 0
                r1 = 0
                int r1 = r11.a()     // Catch:{ MalformedURLException -> 0x0173, all -> 0x0132 }
                if (r1 <= 0) goto L_0x011f
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                long r4 = r10.f15617g     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                long r2 = r2 - r4
                r4 = 200(0xc8, float:2.8E-43)
                if (r1 < r4) goto L_0x0118
                r4 = 400(0x190, float:5.6E-43)
                if (r1 >= r4) goto L_0x0118
                com.applovin.impl.sdk.network.b$a r4 = r10.f15618h     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r4 == 0) goto L_0x001e
                r4.a(r2)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x001e:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = r10.f15614d     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r4 = r10.f15612b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                long r6 = r10.f15617g     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r5 = r1
                r2.a(r3, r4, r5, r6)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r2 = r11.b()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.m r3 = r3.f15606b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                android.content.Context r3 = r3.L()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                boolean r3 = com.applovin.impl.sdk.utils.Utils.isDspDemoApp(r3)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r3 == 0) goto L_0x0066
                java.lang.String r3 = ""
                if (r2 == 0) goto L_0x0044
                r4 = r2
                goto L_0x0045
            L_0x0044:
                r4 = r3
            L_0x0045:
                com.applovin.impl.sdk.network.c<T> r5 = r10.f15613c     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                org.json.JSONObject r5 = r5.e()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r5 == 0) goto L_0x0057
                com.applovin.impl.sdk.network.c<T> r3 = r10.f15613c     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                org.json.JSONObject r3 = r3.e()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x0057:
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.m r5 = r5.f15606b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.i r5 = r5.ag()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r6 = r10.f15612b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r5.a(r4, r6, r3)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x0066:
                if (r2 == 0) goto L_0x010f
                boolean r3 = com.applovin.impl.sdk.v.a()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r4 = "ConnectionManager"
                if (r3 == 0) goto L_0x0079
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.v r3 = r3.f15607c     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r3.a((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x0079:
                com.applovin.impl.sdk.network.b$a r3 = r10.f15618h     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r3 == 0) goto L_0x0085
                int r5 = r2.length()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                long r5 = (long) r5     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r3.b(r5)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x0085:
                boolean r3 = r10.f15616f     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r3 == 0) goto L_0x00bf
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.m r3 = r3.f15606b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = r3.z()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r3 != 0) goto L_0x00be
                java.util.HashMap r5 = new java.util.HashMap     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r6 = 2
                r5.<init>(r6)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r6 = "request"
                java.lang.String r7 = r10.f15612b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r7 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r7)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r5.put(r6, r7)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r6 = "response"
                r5.put(r6, r2)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.m r2 = r2.f15606b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.sdk.AppLovinEventService r2 = r2.w()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r6 = "rdf"
                r2.trackEvent(r6, r5)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x00be:
                r2 = r3
            L_0x00bf:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x00ce }
                T r5 = r10.f15615e     // Catch:{ all -> 0x00ce }
                java.lang.Object r2 = r3.a((java.lang.String) r2, r5)     // Catch:{ all -> 0x00ce }
                com.applovin.impl.sdk.network.b$c<T> r3 = r10.f15619i     // Catch:{ all -> 0x00ce }
                r3.a(r2, r1)     // Catch:{ all -> 0x00ce }
                goto L_0x01a5
            L_0x00ce:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r3.<init>()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r5 = "Unable to parse response from "
                r3.append(r5)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r6 = r10.f15612b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r5 = r5.a((java.lang.String) r6)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r3.append(r5)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                if (r5 == 0) goto L_0x00f7
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.v r5 = r5.f15607c     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r5.b(r4, r3, r2)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x00f7:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.m r2 = r2.f15606b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.d.g r2 = r2.T()     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.d.f r4 = com.applovin.impl.sdk.d.f.f15310i     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r2.a(r4)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.network.b$c<T> r2 = r10.f15619i     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r4 = -800(0xfffffffffffffce0, float:NaN)
                r2.a(r4, r3, r0)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                goto L_0x01a5
            L_0x010f:
                com.applovin.impl.sdk.network.b$c<T> r2 = r10.f15619i     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                T r3 = r10.f15615e     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r2.a(r3, r1)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                goto L_0x01a5
            L_0x0118:
                com.applovin.impl.sdk.network.b$c<T> r2 = r10.f15619i     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
            L_0x011a:
                r2.a(r1, r0, r0)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                goto L_0x01a5
            L_0x011f:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r3 = r10.f15614d     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                java.lang.String r4 = r10.f15612b     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                long r6 = r10.f15617g     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                r8 = 0
                r5 = r1
                r2.a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6, (java.lang.Throwable) r8)     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                com.applovin.impl.sdk.network.b$c<T> r2 = r10.f15619i     // Catch:{ MalformedURLException -> 0x012f, all -> 0x0132 }
                goto L_0x011a
            L_0x012f:
                r11 = move-exception
                r5 = r1
                goto L_0x0175
            L_0x0132:
                r2 = move-exception
                r9 = r2
                if (r1 != 0) goto L_0x013c
                com.applovin.impl.sdk.network.b r1 = com.applovin.impl.sdk.network.b.this
                int r1 = r1.a((java.lang.Throwable) r9)
            L_0x013c:
                java.lang.String r11 = r11.c()     // Catch:{ all -> 0x015c }
                if (r11 == 0) goto L_0x015c
                boolean r2 = r10.f15616f     // Catch:{ all -> 0x015c }
                if (r2 == 0) goto L_0x0154
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x015c }
                com.applovin.impl.sdk.m r2 = r2.f15606b     // Catch:{ all -> 0x015c }
                java.lang.String r2 = r2.z()     // Catch:{ all -> 0x015c }
                java.lang.String r11 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r11, (java.lang.String) r2)     // Catch:{ all -> 0x015c }
            L_0x0154:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x015c }
                T r3 = r10.f15615e     // Catch:{ all -> 0x015c }
                java.lang.Object r0 = r2.a((java.lang.String) r11, r3)     // Catch:{ all -> 0x015c }
            L_0x015c:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                java.lang.String r3 = r10.f15614d
                java.lang.String r4 = r10.f15612b
                long r6 = r10.f15617g
                r5 = r1
                r8 = r9
                r2.a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6, (java.lang.Throwable) r8)
                com.applovin.impl.sdk.network.b$c<T> r11 = r10.f15619i
                java.lang.String r2 = r9.getMessage()
                r11.a(r1, r2, r0)
                goto L_0x01a5
            L_0x0173:
                r11 = move-exception
                r5 = 0
            L_0x0175:
                T r1 = r10.f15615e
                r9 = -901(0xfffffffffffffc7b, float:NaN)
                if (r1 == 0) goto L_0x0191
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                java.lang.String r3 = r10.f15614d
                java.lang.String r4 = r10.f15612b
                long r6 = r10.f15617g
                r8 = r11
                r2.a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6, (java.lang.Throwable) r8)
                com.applovin.impl.sdk.network.b$c<T> r1 = r10.f15619i
                java.lang.String r11 = r11.getMessage()
                r1.a(r9, r11, r0)
                goto L_0x01a5
            L_0x0191:
                com.applovin.impl.sdk.network.b r1 = com.applovin.impl.sdk.network.b.this
                java.lang.String r2 = r10.f15614d
                java.lang.String r3 = r10.f15612b
                long r6 = r10.f15617g
                r4 = r5
                r5 = r6
                r1.a(r2, r3, r4, r5)
                com.applovin.impl.sdk.network.b$c<T> r11 = r10.f15619i
                T r0 = r10.f15615e
                r11.a(r0, r9)
            L_0x01a5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.C0022b.accept(com.applovin.impl.sdk.network.e$c):void");
        }
    }

    public interface c<T> {
        void a(int i2, String str, T t2);

        void a(T t2, int i2);
    }

    public b(m mVar) {
        this.f15606b = mVar;
        this.f15607c = mVar.A();
        e eVar = new e(mVar);
        this.f15608d = eVar;
        eVar.a();
    }

    /* access modifiers changed from: private */
    public int a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* access modifiers changed from: private */
    public <T> T a(String str, T t2) throws JSONException, SAXException, ClassCastException {
        if (t2 == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t2 instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t2 instanceof r) {
                return s.a(str, this.f15606b);
            }
            if (t2 instanceof String) {
                return str;
            }
            if (v.a()) {
                v vVar = this.f15607c;
                vVar.e("ConnectionManager", "Failed to process response of type '" + t2.getClass().getName() + "'");
            }
        }
        return t2;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i2, long j2) {
        if (v.a()) {
            v vVar = this.f15607c;
            vVar.c("ConnectionManager", "Successful " + str + " returned " + i2 + " in " + (((float) (System.currentTimeMillis() - j2)) / 1000.0f) + " s over " + h.f(this.f15606b) + " to " + a(str2));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i2, long j2, Throwable th) {
        if (v.a()) {
            v vVar = this.f15607c;
            vVar.b("ConnectionManager", "Failed " + str + " returned " + i2 + " in " + (((float) (System.currentTimeMillis() - j2)) / 1000.0f) + " s over " + h.f(this.f15606b) + " to " + a(str2), th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01f3 A[Catch:{ all -> 0x01cb, all -> 0x0294 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0231 A[Catch:{ all -> 0x01cb, all -> 0x0294 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(com.applovin.impl.sdk.network.c<T> r23, com.applovin.impl.sdk.network.b.a r24, com.applovin.impl.sdk.network.b.c<T> r25) {
        /*
            r22 = this;
            r13 = r22
            r14 = r25
            if (r23 == 0) goto L_0x02c5
            java.lang.String r0 = r23.a()
            java.lang.String r15 = r23.b()
            if (r0 == 0) goto L_0x02bd
            if (r15 == 0) goto L_0x02b5
            if (r14 == 0) goto L_0x02ad
            java.lang.String r1 = r0.toLowerCase()
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)
            r12 = 0
            java.lang.String r2 = "ConnectionManager"
            if (r1 != 0) goto L_0x0048
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Requested postback submission to non HTTP endpoint "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = "; skipping..."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            boolean r1 = com.applovin.impl.sdk.v.a()
            if (r1 == 0) goto L_0x0042
            com.applovin.impl.sdk.v.i(r2, r0)
        L_0x0042:
            r1 = -900(0xfffffffffffffc7c, float:NaN)
            r14.a(r1, r0, r12)
            return
        L_0x0048:
            com.applovin.impl.sdk.m r1 = r13.f15606b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.c.b.cQ
            java.lang.Object r1 = r1.a(r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0077
            java.lang.String r1 = "https://"
            boolean r3 = r0.contains(r1)
            if (r3 != 0) goto L_0x0077
            boolean r3 = com.applovin.impl.sdk.v.a()
            if (r3 == 0) goto L_0x0071
            com.applovin.impl.sdk.m r3 = r13.f15606b
            com.applovin.impl.sdk.v r3 = r3.A()
            java.lang.String r4 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r3.d(r2, r4)
        L_0x0071:
            java.lang.String r3 = "http://"
            java.lang.String r0 = r0.replace(r3, r1)
        L_0x0077:
            java.util.HashMap r1 = new java.util.HashMap
            r3 = 2
            r1.<init>(r3)
            boolean r7 = r23.n()
            com.applovin.impl.sdk.m r3 = r13.f15606b
            long r3 = com.applovin.impl.sdk.utils.Utils.getServerAdjustedUnixTimestampMillis(r3)
            java.util.Map r5 = r23.c()
            if (r5 == 0) goto L_0x0097
            java.util.Map r5 = r23.c()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x009d
        L_0x0097:
            int r5 = r23.i()
            if (r5 < 0) goto L_0x0100
        L_0x009d:
            java.util.Map r5 = r23.c()
            com.applovin.impl.sdk.m r6 = r13.f15606b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.df
            java.lang.Object r6 = r6.a(r8)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r5 == 0) goto L_0x00c6
            int r8 = r23.i()
            if (r8 < 0) goto L_0x00c6
            int r8 = r23.i()
            if (r8 <= 0) goto L_0x00c6
            int r8 = r23.i()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "current_retry_attempt"
            r5.put(r9, r8)
        L_0x00c6:
            boolean r6 = r6.booleanValue()
            if (r7 == 0) goto L_0x00fc
            com.applovin.impl.sdk.m r8 = r13.f15606b
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r9 = com.applovin.impl.sdk.c.b.dg
            java.lang.Object r8 = r8.a(r9)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.String r5 = com.applovin.impl.sdk.utils.Utils.encodeUrlMap(r5, r6, r8)
            com.applovin.impl.sdk.m r6 = r13.f15606b
            java.lang.String r6 = r6.z()
            java.lang.String r6 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r5, (java.lang.String) r6, (long) r3)
            boolean r8 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)
            if (r8 == 0) goto L_0x00f5
            if (r6 != 0) goto L_0x00f5
            java.lang.String r8 = "query"
            r1.put(r8, r5)
        L_0x00f5:
            java.lang.String r5 = "p"
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameter(r0, r5, r6)
            goto L_0x0100
        L_0x00fc:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameters(r0, r5, r6)
        L_0x0100:
            r11 = r0
            long r16 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r11)     // Catch:{ all -> 0x0294 }
            java.util.List<java.lang.String> r5 = f15605a     // Catch:{ all -> 0x0294 }
            java.lang.Boolean r0 = com.applovin.impl.sdk.utils.StringUtils.endsWith(r0, r5)     // Catch:{ all -> 0x0294 }
            boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0294 }
            if (r5 == 0) goto L_0x0150
            com.applovin.impl.sdk.v r5 = r13.f15607c     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r6.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = "Sending "
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            r6.append(r15)     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = " request to id=#"
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            int r8 = r11.hashCode()     // Catch:{ all -> 0x0294 }
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = " \""
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x013d
            r0 = r11
            goto L_0x0141
        L_0x013d:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r11)     // Catch:{ all -> 0x0294 }
        L_0x0141:
            r6.append(r0)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = "\"..."
            r6.append(r0)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0294 }
            r5.c(r2, r0)     // Catch:{ all -> 0x0294 }
        L_0x0150:
            com.applovin.impl.sdk.network.e$b$a r0 = new com.applovin.impl.sdk.network.e$b$a     // Catch:{ all -> 0x0294 }
            r0.<init>()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.a((java.lang.String) r11)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.b((java.lang.String) r15)     // Catch:{ all -> 0x0294 }
            java.util.Map r5 = r23.d()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ all -> 0x0294 }
            int r5 = r23.j()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r10 = r0.a((int) r5)     // Catch:{ all -> 0x0294 }
            org.json.JSONObject r0 = r23.e()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x0238
            if (r7 == 0) goto L_0x0197
            org.json.JSONObject r0 = r23.e()     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.m r5 = r13.f15606b     // Catch:{ all -> 0x0294 }
            java.lang.String r5 = r5.z()     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = com.applovin.impl.sdk.utils.m.a((java.lang.String) r0, (java.lang.String) r5, (long) r3)     // Catch:{ all -> 0x0294 }
            if (r0 != 0) goto L_0x019f
            java.lang.String r3 = "body"
            org.json.JSONObject r4 = r23.e()     // Catch:{ all -> 0x0294 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0294 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0294 }
            goto L_0x019f
        L_0x0197:
            org.json.JSONObject r0 = r23.e()     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0294 }
        L_0x019f:
            r3 = r0
            boolean r0 = r23.o()     // Catch:{ all -> 0x0294 }
            java.lang.String r4 = "UTF-8"
            if (r0 == 0) goto L_0x01ec
            if (r3 == 0) goto L_0x01ec
            int r0 = r3.length()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.m r5 = r13.f15606b     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r6 = com.applovin.impl.sdk.c.b.et     // Catch:{ all -> 0x0294 }
            java.lang.Object r5 = r5.a(r6)     // Catch:{ all -> 0x0294 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0294 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0294 }
            if (r0 <= r5) goto L_0x01ec
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r4)     // Catch:{ all -> 0x01cb }
            byte[] r0 = r3.getBytes(r0)     // Catch:{ all -> 0x01cb }
            byte[] r0 = com.applovin.impl.sdk.utils.Utils.gzip(r0)     // Catch:{ all -> 0x01cb }
            goto L_0x01ed
        L_0x01cb:
            r0 = move-exception
            boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0294 }
            if (r5 == 0) goto L_0x01ec
            com.applovin.impl.sdk.v r5 = r13.f15607c     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r6.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = "Failed to gzip POST body for request "
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = r13.a((java.lang.String) r11)     // Catch:{ all -> 0x0294 }
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0294 }
            r5.b(r2, r6, r0)     // Catch:{ all -> 0x0294 }
        L_0x01ec:
            r0 = r12
        L_0x01ed:
            boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0294 }
            if (r5 == 0) goto L_0x0215
            com.applovin.impl.sdk.v r5 = r13.f15607c     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r6.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = "Request to "
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = r13.a((java.lang.String) r11)     // Catch:{ all -> 0x0294 }
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = " is "
            r6.append(r8)     // Catch:{ all -> 0x0294 }
            r6.append(r3)     // Catch:{ all -> 0x0294 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0294 }
            r5.b(r2, r6)     // Catch:{ all -> 0x0294 }
        L_0x0215:
            java.lang.String r2 = "Content-Type"
            java.lang.String r5 = "application/json; charset=utf-8"
            r10.a(r2, r5)     // Catch:{ all -> 0x0294 }
            boolean r2 = r23.o()     // Catch:{ all -> 0x0294 }
            if (r2 == 0) goto L_0x022f
            if (r0 == 0) goto L_0x022f
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r10.a(r2, r3)     // Catch:{ all -> 0x0294 }
            r10.a((byte[]) r0)     // Catch:{ all -> 0x0294 }
            goto L_0x0238
        L_0x022f:
            if (r3 == 0) goto L_0x0238
            byte[] r0 = r3.getBytes(r4)     // Catch:{ all -> 0x0294 }
            r10.a((byte[]) r0)     // Catch:{ all -> 0x0294 }
        L_0x0238:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x0294 }
            if (r0 != 0) goto L_0x0252
            java.lang.String r0 = "request"
            java.lang.String r2 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r11)     // Catch:{ all -> 0x0294 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.m r0 = r13.f15606b     // Catch:{ all -> 0x0294 }
            com.applovin.sdk.AppLovinEventService r0 = r0.w()     // Catch:{ all -> 0x0294 }
            java.lang.String r2 = "ref"
            r0.trackEvent(r2, r1)     // Catch:{ all -> 0x0294 }
        L_0x0252:
            com.applovin.impl.sdk.network.e r0 = r13.f15608d     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.b$b r8 = new com.applovin.impl.sdk.network.b$b     // Catch:{ all -> 0x0294 }
            java.lang.Object r6 = r23.g()     // Catch:{ all -> 0x0294 }
            r18 = 0
            r1 = r8
            r2 = r22
            r3 = r11
            r4 = r23
            r5 = r15
            r19 = r8
            r8 = r16
            r20 = r10
            r10 = r24
            r21 = r11
            r11 = r25
            r12 = r18
            r1.<init>(r3, r4, r5, r6, r7, r8, r10, r11)     // Catch:{ all -> 0x0292 }
            r2 = r19
            r1 = r20
            com.applovin.impl.sdk.network.e$b$a r1 = r1.a((androidx.core.util.Consumer<com.applovin.impl.sdk.network.e.c>) r2)     // Catch:{ all -> 0x0292 }
            com.applovin.impl.sdk.m r2 = r13.f15606b     // Catch:{ all -> 0x0292 }
            com.applovin.impl.sdk.e.o r2 = r2.S()     // Catch:{ all -> 0x0292 }
            java.util.concurrent.Executor r2 = r2.b()     // Catch:{ all -> 0x0292 }
            com.applovin.impl.sdk.network.e$b$a r1 = r1.a((java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0292 }
            com.applovin.impl.sdk.network.e$b r1 = r1.a()     // Catch:{ all -> 0x0292 }
            r0.a(r1)     // Catch:{ all -> 0x0292 }
            goto L_0x02ac
        L_0x0292:
            r0 = move-exception
            goto L_0x0297
        L_0x0294:
            r0 = move-exception
            r21 = r11
        L_0x0297:
            r4 = 0
            r1 = r22
            r2 = r15
            r3 = r21
            r5 = r16
            r7 = r0
            r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5, (java.lang.Throwable) r7)
            r1 = 0
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            r14.a(r1, r0, r2)
        L_0x02ac:
            return
        L_0x02ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x02b5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x02bd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x02c5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.a(com.applovin.impl.sdk.network.c, com.applovin.impl.sdk.network.b$a, com.applovin.impl.sdk.network.b$c):void");
    }
}
