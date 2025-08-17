package okhttp3;

import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;

public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    private static final class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot2, String str, String str2) {
            Intrinsics.f(snapshot2, "snapshot");
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = Okio.d(new ForwardingSource(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1);
            }
            return -1;
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    private final class RealCacheRequest implements CacheRequest {
        private final Sink body;
        private final Sink cacheOut;
        private boolean done;
        /* access modifiers changed from: private */
        public final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor2) {
            Intrinsics.f(editor2, "editor");
            this.this$0 = cache;
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            this.body = new ForwardingSink(newSink) {
                public void close() throws IOException {
                    Cache cache = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache) {
                        if (!realCacheRequest.getDone()) {
                            realCacheRequest.setDone(true);
                            cache.setWriteSuccessCount$okhttp(cache.getWriteSuccessCount$okhttp() + 1);
                            super.close();
                            this.editor.commit();
                        }
                    }
                }
            };
        }

        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (!this.done) {
                    this.done = true;
                    cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                    Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z2) {
            this.done = z2;
        }
    }

    public Cache(File file, long j2, FileSystem fileSystem) {
        Intrinsics.f(file, "directory");
        Intrinsics.f(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j2, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory  reason: not valid java name */
    public final File m235deprecated_directory() {
        return this.cache.getDirectory();
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody body = response.body();
                if (body != null) {
                    Util.closeQuietly((Closeable) body);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        Intrinsics.f(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!Intrinsics.a(method, "GET")) {
            return null;
        } else {
            Companion companion = Companion;
            if (companion.hasVaryAll(response)) {
                return null;
            }
            Entry entry = new Entry(response);
            try {
                editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0, 2, (Object) null);
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new RealCacheRequest(this, editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i2) {
        this.writeAbortCount = i2;
    }

    public final void setWriteSuccessCount$okhttp(int i2) {
        this.writeSuccessCount = i2;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        Intrinsics.f(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Intrinsics.f(response, "cached");
        Intrinsics.f(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody body = response.body();
        Intrinsics.d(body, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editor = ((CacheResponseBody) body).getSnapshot().edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                if (StringsKt__StringsJVMKt.t("Vary", headers.name(i2), true)) {
                    String value = headers.value(i2);
                    if (treeSet == null) {
                        treeSet = new TreeSet(StringsKt__StringsJVMKt.u(StringCompanionObject.f40434a));
                    }
                    for (String N0 : StringsKt__StringsKt.u0(value, new char[]{','}, false, 0, 6, (Object) null)) {
                        treeSet.add(StringsKt__StringsKt.N0(N0).toString());
                    }
                }
            }
            if (treeSet == null) {
                return SetsKt__SetsKt.b();
            }
            return treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            Intrinsics.f(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            Intrinsics.f(httpUrl, ImagesContract.URL);
            return ByteString.f41331e.d(httpUrl.toString()).n().k();
        }

        public final int readInt$okhttp(BufferedSource bufferedSource) throws IOException {
            boolean z2;
            Intrinsics.f(bufferedSource, "source");
            try {
                long W = bufferedSource.W();
                String F = bufferedSource.F();
                if (W >= 0 && W <= 2147483647L) {
                    if (F.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        return (int) W;
                    }
                }
                throw new IOException("expected an int but was \"" + W + F + '\"');
            } catch (NumberFormatException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            Intrinsics.f(response, "<this>");
            Response networkResponse = response.networkResponse();
            Intrinsics.c(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            Intrinsics.f(response, "cachedResponse");
            Intrinsics.f(headers, "cachedRequest");
            Intrinsics.f(request, "newRequest");
            Iterable<String> varyFields = varyFields(response.headers());
            if ((varyFields instanceof Collection) && ((Collection) varyFields).isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!Intrinsics.a(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> varyFields = varyFields(headers2);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = headers.name(i2);
                if (varyFields.contains(name)) {
                    builder.add(name, headers.value(i2));
                }
            }
            return builder.build();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Cache(File file, long j2) {
        this(file, j2, FileSystem.SYSTEM);
        Intrinsics.f(file, "directory");
    }

    private static final class Entry {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0124, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0125, code lost:
            kotlin.io.CloseableKt.a(r10, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0128, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Entry(okio.Source r10) throws java.io.IOException {
            /*
                r9 = this;
                java.lang.String r0 = "rawSource"
                kotlin.jvm.internal.Intrinsics.f(r10, r0)
                r9.<init>()
                okio.BufferedSource r0 = okio.Okio.d(r10)     // Catch:{ all -> 0x0122 }
                java.lang.String r1 = r0.F()     // Catch:{ all -> 0x0122 }
                okhttp3.HttpUrl$Companion r2 = okhttp3.HttpUrl.Companion     // Catch:{ all -> 0x0122 }
                okhttp3.HttpUrl r2 = r2.parse(r1)     // Catch:{ all -> 0x0122 }
                if (r2 == 0) goto L_0x00ff
                r9.url = r2     // Catch:{ all -> 0x0122 }
                java.lang.String r1 = r0.F()     // Catch:{ all -> 0x0122 }
                r9.requestMethod = r1     // Catch:{ all -> 0x0122 }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x0122 }
                r1.<init>()     // Catch:{ all -> 0x0122 }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x0122 }
                int r2 = r2.readInt$okhttp(r0)     // Catch:{ all -> 0x0122 }
                r3 = 0
                r4 = 0
            L_0x002d:
                if (r4 >= r2) goto L_0x0039
                java.lang.String r5 = r0.F()     // Catch:{ all -> 0x0122 }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x0122 }
                int r4 = r4 + 1
                goto L_0x002d
            L_0x0039:
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x0122 }
                r9.varyHeaders = r1     // Catch:{ all -> 0x0122 }
                okhttp3.internal.http.StatusLine$Companion r1 = okhttp3.internal.http.StatusLine.Companion     // Catch:{ all -> 0x0122 }
                java.lang.String r2 = r0.F()     // Catch:{ all -> 0x0122 }
                okhttp3.internal.http.StatusLine r1 = r1.parse(r2)     // Catch:{ all -> 0x0122 }
                okhttp3.Protocol r2 = r1.protocol     // Catch:{ all -> 0x0122 }
                r9.protocol = r2     // Catch:{ all -> 0x0122 }
                int r2 = r1.code     // Catch:{ all -> 0x0122 }
                r9.code = r2     // Catch:{ all -> 0x0122 }
                java.lang.String r1 = r1.message     // Catch:{ all -> 0x0122 }
                r9.message = r1     // Catch:{ all -> 0x0122 }
                okhttp3.Headers$Builder r1 = new okhttp3.Headers$Builder     // Catch:{ all -> 0x0122 }
                r1.<init>()     // Catch:{ all -> 0x0122 }
                okhttp3.Cache$Companion r2 = okhttp3.Cache.Companion     // Catch:{ all -> 0x0122 }
                int r2 = r2.readInt$okhttp(r0)     // Catch:{ all -> 0x0122 }
                r4 = 0
            L_0x0061:
                if (r4 >= r2) goto L_0x006d
                java.lang.String r5 = r0.F()     // Catch:{ all -> 0x0122 }
                r1.addLenient$okhttp(r5)     // Catch:{ all -> 0x0122 }
                int r4 = r4 + 1
                goto L_0x0061
            L_0x006d:
                java.lang.String r2 = SENT_MILLIS     // Catch:{ all -> 0x0122 }
                java.lang.String r4 = r1.get(r2)     // Catch:{ all -> 0x0122 }
                java.lang.String r5 = RECEIVED_MILLIS     // Catch:{ all -> 0x0122 }
                java.lang.String r6 = r1.get(r5)     // Catch:{ all -> 0x0122 }
                r1.removeAll(r2)     // Catch:{ all -> 0x0122 }
                r1.removeAll(r5)     // Catch:{ all -> 0x0122 }
                r7 = 0
                if (r4 == 0) goto L_0x0088
                long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0122 }
                goto L_0x0089
            L_0x0088:
                r4 = r7
            L_0x0089:
                r9.sentRequestMillis = r4     // Catch:{ all -> 0x0122 }
                if (r6 == 0) goto L_0x0091
                long r7 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0122 }
            L_0x0091:
                r9.receivedResponseMillis = r7     // Catch:{ all -> 0x0122 }
                okhttp3.Headers r1 = r1.build()     // Catch:{ all -> 0x0122 }
                r9.responseHeaders = r1     // Catch:{ all -> 0x0122 }
                boolean r1 = r9.isHttps()     // Catch:{ all -> 0x0122 }
                r2 = 0
                if (r1 == 0) goto L_0x00f7
                java.lang.String r1 = r0.F()     // Catch:{ all -> 0x0122 }
                int r4 = r1.length()     // Catch:{ all -> 0x0122 }
                if (r4 <= 0) goto L_0x00ab
                r3 = 1
            L_0x00ab:
                if (r3 != 0) goto L_0x00db
                java.lang.String r1 = r0.F()     // Catch:{ all -> 0x0122 }
                okhttp3.CipherSuite$Companion r3 = okhttp3.CipherSuite.Companion     // Catch:{ all -> 0x0122 }
                okhttp3.CipherSuite r1 = r3.forJavaName(r1)     // Catch:{ all -> 0x0122 }
                java.util.List r3 = r9.readCertificateList(r0)     // Catch:{ all -> 0x0122 }
                java.util.List r4 = r9.readCertificateList(r0)     // Catch:{ all -> 0x0122 }
                boolean r5 = r0.V()     // Catch:{ all -> 0x0122 }
                if (r5 != 0) goto L_0x00d0
                okhttp3.TlsVersion$Companion r5 = okhttp3.TlsVersion.Companion     // Catch:{ all -> 0x0122 }
                java.lang.String r0 = r0.F()     // Catch:{ all -> 0x0122 }
                okhttp3.TlsVersion r0 = r5.forJavaName(r0)     // Catch:{ all -> 0x0122 }
                goto L_0x00d2
            L_0x00d0:
                okhttp3.TlsVersion r0 = okhttp3.TlsVersion.SSL_3_0     // Catch:{ all -> 0x0122 }
            L_0x00d2:
                okhttp3.Handshake$Companion r5 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x0122 }
                okhttp3.Handshake r0 = r5.get(r0, r1, r3, r4)     // Catch:{ all -> 0x0122 }
                r9.handshake = r0     // Catch:{ all -> 0x0122 }
                goto L_0x00f9
            L_0x00db:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
                r2.<init>()     // Catch:{ all -> 0x0122 }
                java.lang.String r3 = "expected \"\" but was \""
                r2.append(r3)     // Catch:{ all -> 0x0122 }
                r2.append(r1)     // Catch:{ all -> 0x0122 }
                r1 = 34
                r2.append(r1)     // Catch:{ all -> 0x0122 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0122 }
                r0.<init>(r1)     // Catch:{ all -> 0x0122 }
                throw r0     // Catch:{ all -> 0x0122 }
            L_0x00f7:
                r9.handshake = r2     // Catch:{ all -> 0x0122 }
            L_0x00f9:
                kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0122 }
                kotlin.io.CloseableKt.a(r10, r2)
                return
            L_0x00ff:
                java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0122 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
                r2.<init>()     // Catch:{ all -> 0x0122 }
                java.lang.String r3 = "Cache corruption for "
                r2.append(r3)     // Catch:{ all -> 0x0122 }
                r2.append(r1)     // Catch:{ all -> 0x0122 }
                java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0122 }
                r0.<init>(r1)     // Catch:{ all -> 0x0122 }
                okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0122 }
                okhttp3.internal.platform.Platform r1 = r1.get()     // Catch:{ all -> 0x0122 }
                java.lang.String r2 = "cache corruption"
                r3 = 5
                r1.log(r2, r3, r0)     // Catch:{ all -> 0x0122 }
                throw r0     // Catch:{ all -> 0x0122 }
            L_0x0122:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0124 }
            L_0x0124:
                r1 = move-exception
                kotlin.io.CloseableKt.a(r10, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.<init>(okio.Source):void");
        }

        private final boolean isHttps() {
            return Intrinsics.a(this.url.scheme(), UriUtil.HTTPS_SCHEME);
        }

        private final List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt$okhttp = Cache.Companion.readInt$okhttp(bufferedSource);
            if (readInt$okhttp == -1) {
                return CollectionsKt__CollectionsKt.f();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                int i2 = 0;
                while (i2 < readInt$okhttp) {
                    String F = bufferedSource.F();
                    Buffer buffer = new Buffer();
                    ByteString a2 = ByteString.f41331e.a(F);
                    if (a2 != null) {
                        buffer.h0(a2);
                        arrayList.add(instance.generateCertificate(buffer.d()));
                        i2++;
                    } else {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> list) throws IOException {
            try {
                bufferedSink.O((long) list.size()).writeByte(10);
                for (Certificate encoded : list) {
                    byte[] encoded2 = encoded.getEncoded();
                    ByteString.Companion companion = ByteString.f41331e;
                    Intrinsics.e(encoded2, "bytes");
                    bufferedSink.w(ByteString.Companion.g(companion, encoded2, 0, 0, 3, (Object) null).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
            Intrinsics.f(response, "response");
            if (!Intrinsics.a(this.url, request.url()) || !Intrinsics.a(this.requestMethod, request.method()) || !Cache.Companion.varyMatches(response, this.varyHeaders, request)) {
                return false;
            }
            return true;
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            Intrinsics.f(snapshot, "snapshot");
            String str = this.responseHeaders.get(TraktV2.HEADER_CONTENT_TYPE);
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0118, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0119, code lost:
            kotlin.io.CloseableKt.a(r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x011c, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(okhttp3.internal.cache.DiskLruCache.Editor r8) throws java.io.IOException {
            /*
                r7 = this;
                java.lang.String r0 = "editor"
                kotlin.jvm.internal.Intrinsics.f(r8, r0)
                r0 = 0
                okio.Sink r8 = r8.newSink(r0)
                okio.BufferedSink r8 = okio.Okio.c(r8)
                okhttp3.HttpUrl r1 = r7.url     // Catch:{ all -> 0x0116 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r1 = r8.w(r1)     // Catch:{ all -> 0x0116 }
                r2 = 10
                r1.writeByte(r2)     // Catch:{ all -> 0x0116 }
                java.lang.String r1 = r7.requestMethod     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r1 = r8.w(r1)     // Catch:{ all -> 0x0116 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0116 }
                int r1 = r1.size()     // Catch:{ all -> 0x0116 }
                long r3 = (long) r1     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r1 = r8.O(r3)     // Catch:{ all -> 0x0116 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r1 = r7.varyHeaders     // Catch:{ all -> 0x0116 }
                int r1 = r1.size()     // Catch:{ all -> 0x0116 }
                r3 = 0
            L_0x003b:
                java.lang.String r4 = ": "
                if (r3 >= r1) goto L_0x005d
                okhttp3.Headers r5 = r7.varyHeaders     // Catch:{ all -> 0x0116 }
                java.lang.String r5 = r5.name(r3)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r5 = r8.w(r5)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r4 = r5.w(r4)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r5 = r7.varyHeaders     // Catch:{ all -> 0x0116 }
                java.lang.String r5 = r5.value(r3)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r4 = r4.w(r5)     // Catch:{ all -> 0x0116 }
                r4.writeByte(r2)     // Catch:{ all -> 0x0116 }
                int r3 = r3 + 1
                goto L_0x003b
            L_0x005d:
                okhttp3.internal.http.StatusLine r1 = new okhttp3.internal.http.StatusLine     // Catch:{ all -> 0x0116 }
                okhttp3.Protocol r3 = r7.protocol     // Catch:{ all -> 0x0116 }
                int r5 = r7.code     // Catch:{ all -> 0x0116 }
                java.lang.String r6 = r7.message     // Catch:{ all -> 0x0116 }
                r1.<init>(r3, r5, r6)     // Catch:{ all -> 0x0116 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r1 = r8.w(r1)     // Catch:{ all -> 0x0116 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x0116 }
                int r1 = r1.size()     // Catch:{ all -> 0x0116 }
                int r1 = r1 + 2
                long r5 = (long) r1     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r1 = r8.O(r5)     // Catch:{ all -> 0x0116 }
                r1.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r1 = r7.responseHeaders     // Catch:{ all -> 0x0116 }
                int r1 = r1.size()     // Catch:{ all -> 0x0116 }
            L_0x0089:
                if (r0 >= r1) goto L_0x00a9
                okhttp3.Headers r3 = r7.responseHeaders     // Catch:{ all -> 0x0116 }
                java.lang.String r3 = r3.name(r0)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r3 = r8.w(r3)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r3 = r3.w(r4)     // Catch:{ all -> 0x0116 }
                okhttp3.Headers r5 = r7.responseHeaders     // Catch:{ all -> 0x0116 }
                java.lang.String r5 = r5.value(r0)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r3 = r3.w(r5)     // Catch:{ all -> 0x0116 }
                r3.writeByte(r2)     // Catch:{ all -> 0x0116 }
                int r0 = r0 + 1
                goto L_0x0089
            L_0x00a9:
                java.lang.String r0 = SENT_MILLIS     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r8.w(r0)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r0.w(r4)     // Catch:{ all -> 0x0116 }
                long r5 = r7.sentRequestMillis     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r0.O(r5)     // Catch:{ all -> 0x0116 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0116 }
                java.lang.String r0 = RECEIVED_MILLIS     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r8.w(r0)     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r0.w(r4)     // Catch:{ all -> 0x0116 }
                long r3 = r7.receivedResponseMillis     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r0.O(r3)     // Catch:{ all -> 0x0116 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0116 }
                boolean r0 = r7.isHttps()     // Catch:{ all -> 0x0116 }
                if (r0 == 0) goto L_0x010f
                r8.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0116 }
                kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x0116 }
                okhttp3.CipherSuite r0 = r0.cipherSuite()     // Catch:{ all -> 0x0116 }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r8.w(r0)     // Catch:{ all -> 0x0116 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0116 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0116 }
                java.util.List r0 = r0.peerCertificates()     // Catch:{ all -> 0x0116 }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x0116 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0116 }
                java.util.List r0 = r0.localCertificates()     // Catch:{ all -> 0x0116 }
                r7.writeCertList(r8, r0)     // Catch:{ all -> 0x0116 }
                okhttp3.Handshake r0 = r7.handshake     // Catch:{ all -> 0x0116 }
                okhttp3.TlsVersion r0 = r0.tlsVersion()     // Catch:{ all -> 0x0116 }
                java.lang.String r0 = r0.javaName()     // Catch:{ all -> 0x0116 }
                okio.BufferedSink r0 = r8.w(r0)     // Catch:{ all -> 0x0116 }
                r0.writeByte(r2)     // Catch:{ all -> 0x0116 }
            L_0x010f:
                kotlin.Unit r0 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0116 }
                r0 = 0
                kotlin.io.CloseableKt.a(r8, r0)
                return
            L_0x0116:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0118 }
            L_0x0118:
                r1 = move-exception
                kotlin.io.CloseableKt.a(r8, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.Entry.writeTo(okhttp3.internal.cache.DiskLruCache$Editor):void");
        }

        public Entry(Response response) {
            Intrinsics.f(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
