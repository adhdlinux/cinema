package com.applovin.impl.sdk.network;

import android.os.Process;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.m;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final PriorityBlockingQueue<b> f15650a = new PriorityBlockingQueue<>();

    /* renamed from: b  reason: collision with root package name */
    private final m f15651b;

    static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final BlockingQueue<b> f15652a;

        /* renamed from: b  reason: collision with root package name */
        private final m f15653b;

        private a(BlockingQueue<b> blockingQueue, int i2, m mVar) {
            super("AL-Network-" + i2);
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            } else if (mVar != null) {
                this.f15652a = blockingQueue;
                this.f15653b = mVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        private void a() throws InterruptedException {
            a(this.f15652a.take());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.Closeable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Throwable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.net.HttpURLConnection} */
        /* JADX WARNING: type inference failed for: r1v0, types: [java.io.Closeable] */
        /* JADX WARNING: type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
        /* JADX WARNING: type inference failed for: r1v3 */
        /* JADX WARNING: type inference failed for: r2v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x00b7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0073 A[SYNTHETIC, Splitter:B:27:0x0073] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(final com.applovin.impl.sdk.network.e.b r10) {
            /*
                r9 = this;
                r0 = 0
                r1 = 0
                java.net.HttpURLConnection r2 = r9.b(r10)     // Catch:{ all -> 0x005b }
                byte[] r3 = r10.f15661e     // Catch:{ all -> 0x0058 }
                if (r3 == 0) goto L_0x002d
                byte[] r3 = r10.f15661e     // Catch:{ all -> 0x0058 }
                int r3 = r3.length     // Catch:{ all -> 0x0058 }
                if (r3 <= 0) goto L_0x002d
                r3 = 1
                r2.setDoOutput(r3)     // Catch:{ all -> 0x0058 }
                byte[] r3 = r10.f15661e     // Catch:{ all -> 0x0058 }
                int r3 = r3.length     // Catch:{ all -> 0x0058 }
                r2.setFixedLengthStreamingMode(r3)     // Catch:{ all -> 0x0058 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ all -> 0x0058 }
                byte[] r4 = r10.f15661e     // Catch:{ all -> 0x0058 }
                r3.write(r4)     // Catch:{ all -> 0x0058 }
                r3.close()     // Catch:{ all -> 0x0058 }
            L_0x002d:
                int r0 = r2.getResponseCode()     // Catch:{ all -> 0x0058 }
                if (r0 <= 0) goto L_0x0043
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ all -> 0x0058 }
                com.applovin.impl.sdk.m r4 = r9.f15653b     // Catch:{ all -> 0x003e }
                java.lang.String r4 = com.applovin.impl.sdk.utils.h.a((java.io.InputStream) r3, (com.applovin.impl.sdk.m) r4)     // Catch:{ all -> 0x003e }
                goto L_0x0045
            L_0x003e:
                r4 = move-exception
                r8 = r4
                r4 = r3
                r3 = r8
                goto L_0x005e
            L_0x0043:
                r3 = r1
                r4 = r3
            L_0x0045:
                com.applovin.impl.sdk.m r5 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r3, r5)
                com.applovin.impl.sdk.m r3 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r1, r3)
                com.applovin.impl.sdk.m r3 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.disconnect(r2, r3)
                r3 = r1
                r6 = r3
                r1 = r4
                goto L_0x0092
            L_0x0058:
                r3 = move-exception
                r4 = r1
                goto L_0x005e
            L_0x005b:
                r3 = move-exception
                r2 = r1
                r4 = r2
            L_0x005e:
                boolean r5 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x00b7 }
                if (r5 == 0) goto L_0x0071
                com.applovin.impl.sdk.m r5 = r9.f15653b     // Catch:{ all -> 0x00b7 }
                com.applovin.impl.sdk.v r5 = r5.A()     // Catch:{ all -> 0x00b7 }
                java.lang.String r6 = "NetworkCommunicationThread"
                java.lang.String r7 = "Failed to make HTTP request"
                r5.a((java.lang.String) r6, (java.lang.String) r7, (java.lang.Throwable) r3)     // Catch:{ all -> 0x00b7 }
            L_0x0071:
                if (r2 == 0) goto L_0x0081
                java.io.InputStream r5 = r2.getErrorStream()     // Catch:{ all -> 0x007e }
                com.applovin.impl.sdk.m r6 = r9.f15653b     // Catch:{ all -> 0x007f }
                java.lang.String r6 = com.applovin.impl.sdk.utils.h.a((java.io.InputStream) r5, (com.applovin.impl.sdk.m) r6)     // Catch:{ all -> 0x007f }
                goto L_0x0083
            L_0x007e:
                r5 = r1
            L_0x007f:
                r6 = r1
                goto L_0x0083
            L_0x0081:
                r5 = r1
                r6 = r5
            L_0x0083:
                com.applovin.impl.sdk.m r7 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r4, r7)
                com.applovin.impl.sdk.m r4 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r5, r4)
                com.applovin.impl.sdk.m r4 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.disconnect(r2, r4)
            L_0x0092:
                com.applovin.impl.sdk.network.e$c$a r2 = com.applovin.impl.sdk.network.e.c.d()
                com.applovin.impl.sdk.network.e$c$a r0 = r2.a((int) r0)
                com.applovin.impl.sdk.network.e$c$a r0 = r0.a((java.lang.String) r1)
                com.applovin.impl.sdk.network.e$c$a r0 = r0.b((java.lang.String) r6)
                com.applovin.impl.sdk.network.e$c$a r0 = r0.a((java.lang.Throwable) r3)
                com.applovin.impl.sdk.network.e$c r0 = r0.a()
                java.util.concurrent.Executor r1 = r10.f15664h
                com.applovin.impl.sdk.network.e$a$1 r2 = new com.applovin.impl.sdk.network.e$a$1
                r2.<init>(r10, r0)
                r1.execute(r2)
                return
            L_0x00b7:
                r10 = move-exception
                com.applovin.impl.sdk.m r0 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r4, r0)
                com.applovin.impl.sdk.m r0 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.close(r1, r0)
                com.applovin.impl.sdk.m r0 = r9.f15653b
                com.applovin.impl.sdk.utils.Utils.disconnect(r2, r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.e.a.a(com.applovin.impl.sdk.network.e$b):void");
        }

        private HttpURLConnection b(b bVar) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bVar.f15658b).openConnection();
            httpURLConnection.setRequestMethod(bVar.f15659c);
            httpURLConnection.setConnectTimeout(bVar.f15662f);
            httpURLConnection.setReadTimeout(bVar.f15662f);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!bVar.f15660d.isEmpty()) {
                for (Map.Entry entry : bVar.f15660d.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicInteger f15657a = new AtomicInteger();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f15658b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f15659c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final Map<String, String> f15660d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f15661e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final int f15662f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final Consumer<c> f15663g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public final Executor f15664h;

        /* renamed from: i  reason: collision with root package name */
        private final int f15665i;

        static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public String f15666a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f15667b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public Map<String, String> f15668c = new HashMap();
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public byte[] f15669d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public int f15670e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public Consumer<c> f15671f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public Executor f15672g;

            a() {
            }

            /* access modifiers changed from: package-private */
            public a a(int i2) {
                this.f15670e = i2;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(Consumer<c> consumer) {
                this.f15671f = consumer;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(String str) {
                this.f15666a = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(String str, String str2) {
                this.f15668c.put(str, str2);
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(Map<String, String> map) {
                if (map == null) {
                    map = new HashMap<>();
                }
                this.f15668c = map;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(Executor executor) {
                this.f15672g = executor;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(byte[] bArr) {
                this.f15669d = bArr;
                return this;
            }

            /* access modifiers changed from: package-private */
            public b a() {
                return new b(this);
            }

            /* access modifiers changed from: package-private */
            public a b(String str) {
                this.f15667b = str;
                return this;
            }
        }

        private b(a aVar) {
            this.f15658b = aVar.f15666a;
            this.f15659c = aVar.f15667b;
            this.f15660d = aVar.f15668c != null ? aVar.f15668c : Collections.emptyMap();
            this.f15661e = aVar.f15669d;
            this.f15662f = aVar.f15670e;
            this.f15663g = aVar.f15671f;
            this.f15664h = aVar.f15672g;
            this.f15665i = f15657a.incrementAndGet();
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.f15665i - bVar.f15665i;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f15673a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15674b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15675c;

        /* renamed from: d  reason: collision with root package name */
        private final Throwable f15676d;

        static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f15677a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f15678b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public String f15679c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public Throwable f15680d;

            a() {
            }

            /* access modifiers changed from: package-private */
            public a a(int i2) {
                this.f15677a = i2;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(String str) {
                this.f15678b = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a(Throwable th) {
                this.f15680d = th;
                return this;
            }

            /* access modifiers changed from: package-private */
            public c a() {
                return new c(this);
            }

            /* access modifiers changed from: package-private */
            public a b(String str) {
                this.f15679c = str;
                return this;
            }
        }

        private c(a aVar) {
            this.f15673a = aVar.f15677a;
            this.f15674b = aVar.f15678b;
            this.f15675c = aVar.f15679c;
            this.f15676d = aVar.f15680d;
        }

        static a d() {
            return new a();
        }

        /* access modifiers changed from: package-private */
        public int a() throws Throwable {
            Throwable th = this.f15676d;
            if (th == null) {
                return this.f15673a;
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public String b() throws Throwable {
            Throwable th = this.f15676d;
            if (th == null) {
                return this.f15674b;
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return this.f15675c;
        }
    }

    e(m mVar) {
        this.f15651b = mVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        for (int i2 = 0; i2 < ((Integer) this.f15651b.a(com.applovin.impl.sdk.c.b.ap)).intValue(); i2++) {
            new a(this.f15650a, i2, this.f15651b).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        if (bVar != null) {
            this.f15650a.add(bVar);
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }
}
