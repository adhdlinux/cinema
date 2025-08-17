package okhttp3.internal.connection;

import com.vungle.ads.internal.ui.AdActivity;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed = new AtomicBoolean();
    private boolean expectMoreExchanges = true;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;
        final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            Intrinsics.f(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        public final void executeOn(ExecutorService executorService) {
            Intrinsics.f(executorService, "executorService");
            Dispatcher dispatcher = this.this$0.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock(dispatcher)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    this.this$0.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(this.this$0, interruptedIOException);
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
        }

        public final RealCall getCall() {
            return this.this$0;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            Intrinsics.f(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[Catch:{ all -> 0x006d, all -> 0x00b2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A[Catch:{ all -> 0x006d, all -> 0x00b2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0094 A[Catch:{ all -> 0x006d, all -> 0x00b2 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                okhttp3.internal.connection.RealCall r1 = r7.this$0
                java.lang.String r1 = r1.redactedUrl$okhttp()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                okhttp3.internal.connection.RealCall r1 = r7.this$0
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                java.lang.String r3 = r2.getName()
                r2.setName(r0)
                okhttp3.internal.connection.RealCall$timeout$1 r0 = r1.timeout     // Catch:{ all -> 0x00b2 }
                r0.enter()     // Catch:{ all -> 0x00b2 }
                r0 = 0
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain$okhttp()     // Catch:{ IOException -> 0x006f, all -> 0x0046 }
                r4 = 1
                okhttp3.Callback r5 = r7.responseCallback     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
                r5.onResponse(r1, r0)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00b2 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00b2 }
            L_0x003e:
                r0.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r7)     // Catch:{ all -> 0x00b2 }
                goto L_0x00a2
            L_0x0042:
                r0 = move-exception
                goto L_0x0049
            L_0x0044:
                r0 = move-exception
                goto L_0x0072
            L_0x0046:
                r4 = move-exception
                r0 = r4
                r4 = 0
            L_0x0049:
                r1.cancel()     // Catch:{ all -> 0x006d }
                if (r4 != 0) goto L_0x006c
                java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x006d }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
                r5.<init>()     // Catch:{ all -> 0x006d }
                java.lang.String r6 = "canceled due to "
                r5.append(r6)     // Catch:{ all -> 0x006d }
                r5.append(r0)     // Catch:{ all -> 0x006d }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006d }
                r4.<init>(r5)     // Catch:{ all -> 0x006d }
                kotlin.ExceptionsKt__ExceptionsKt.a(r4, r0)     // Catch:{ all -> 0x006d }
                okhttp3.Callback r5 = r7.responseCallback     // Catch:{ all -> 0x006d }
                r5.onFailure(r1, r4)     // Catch:{ all -> 0x006d }
            L_0x006c:
                throw r0     // Catch:{ all -> 0x006d }
            L_0x006d:
                r0 = move-exception
                goto L_0x00a6
            L_0x006f:
                r4 = move-exception
                r0 = r4
                r4 = 0
            L_0x0072:
                if (r4 == 0) goto L_0x0094
                okhttp3.internal.platform.Platform$Companion r4 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x006d }
                okhttp3.internal.platform.Platform r4 = r4.get()     // Catch:{ all -> 0x006d }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
                r5.<init>()     // Catch:{ all -> 0x006d }
                java.lang.String r6 = "Callback failure for "
                r5.append(r6)     // Catch:{ all -> 0x006d }
                java.lang.String r6 = r1.toLoggableString()     // Catch:{ all -> 0x006d }
                r5.append(r6)     // Catch:{ all -> 0x006d }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006d }
                r6 = 4
                r4.log(r5, r6, r0)     // Catch:{ all -> 0x006d }
                goto L_0x0099
            L_0x0094:
                okhttp3.Callback r4 = r7.responseCallback     // Catch:{ all -> 0x006d }
                r4.onFailure(r1, r0)     // Catch:{ all -> 0x006d }
            L_0x0099:
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00b2 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00b2 }
                goto L_0x003e
            L_0x00a2:
                r2.setName(r3)
                return
            L_0x00a6:
                okhttp3.OkHttpClient r1 = r1.getClient()     // Catch:{ all -> 0x00b2 }
                okhttp3.Dispatcher r1 = r1.dispatcher()     // Catch:{ all -> 0x00b2 }
                r1.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r7)     // Catch:{ all -> 0x00b2 }
                throw r0     // Catch:{ all -> 0x00b2 }
            L_0x00b2:
                r0 = move-exception
                r2.setName(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.AsyncCall.run():void");
        }
    }

    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            Intrinsics.f(realCall, "referent");
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z2) {
        Intrinsics.f(okHttpClient, "client");
        Intrinsics.f(request, "originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z2;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        RealCall$timeout$1 realCall$timeout$1 = new RealCall$timeout$1(this);
        realCall$timeout$1.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = realCall$timeout$1;
    }

    private final <E extends IOException> E callDone(E e2) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z2;
        boolean z3 = Util.assertionsEnabled;
        if (!z3 || !Thread.holdsLock(this)) {
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                if (!z3 || !Thread.holdsLock(realConnection)) {
                    synchronized (realConnection) {
                        releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
                    }
                    if (this.connection == null) {
                        if (releaseConnectionNoEvents$okhttp != null) {
                            Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                        }
                        this.eventListener.connectionReleased(this, realConnection);
                    } else {
                        if (releaseConnectionNoEvents$okhttp == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
                }
            }
            E timeoutExit = timeoutExit(e2);
            if (e2 != null) {
                EventListener eventListener2 = this.eventListener;
                Intrinsics.c(timeoutExit);
                eventListener2.callFailed(this, timeoutExit);
            } else {
                this.eventListener.callEnd(this);
            }
            return timeoutExit;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E e2) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return e2;
        }
        E interruptedIOException = new InterruptedIOException("timeout");
        if (e2 != null) {
            interruptedIOException.initCause(e2);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (isCanceled()) {
            str = "canceled ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.forWebSocket) {
            str2 = "web socket";
        } else {
            str2 = "call";
        }
        sb.append(str2);
        sb.append(" to ");
        sb.append(redactedUrl$okhttp());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        boolean z2;
        Intrinsics.f(realConnection, "connection");
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.connection = realConnection;
                realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public void cancel() {
        if (!this.canceled) {
            this.canceled = true;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                exchange2.cancel();
            }
            RealConnection realConnection = this.connectionToCancel;
            if (realConnection != null) {
                realConnection.cancel();
            }
            this.eventListener.canceled(this);
        }
    }

    public void enqueue(Callback callback) {
        Intrinsics.f(callback, "responseCallback");
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z2) {
        boolean z3;
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        if (this.interceptorScopedExchange == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            synchronized (this) {
                if (!(!this.responseBodyOpen)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.requestBodyOpen) {
                    Unit unit = Unit.f40298a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z2) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            this.timeout.enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z2) {
        Exchange exchange2;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.f40298a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (exchange2 = this.exchange) != null) {
            exchange2.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.interceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.u(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r10.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r10.forWebSocket
            if (r0 != 0) goto L_0x004a
            okhttp3.OkHttpClient r0 = r10.client
            java.util.List r0 = r0.networkInterceptors()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.u(r2, r0)
        L_0x004a:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r10.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r10.originalRequest
            okhttp3.OkHttpClient r0 = r10.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r10.client
            int r8 = r0.writeTimeoutMillis()
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r10.originalRequest     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            okhttp3.Response r2 = r9.proceed(r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            boolean r3 = r10.isCanceled()     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            if (r3 != 0) goto L_0x0083
            r10.noMoreExchanges$okhttp(r0)
            return r2
        L_0x0083:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0090, all -> 0x008e }
            throw r2     // Catch:{ IOException -> 0x0090, all -> 0x008e }
        L_0x008e:
            r2 = move-exception
            goto L_0x009f
        L_0x0090:
            r1 = move-exception
            r2 = 1
            java.io.IOException r1 = r10.noMoreExchanges$okhttp(r1)     // Catch:{ all -> 0x009c }
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            kotlin.jvm.internal.Intrinsics.d(r1, r3)     // Catch:{ all -> 0x009c }
            throw r1     // Catch:{ all -> 0x009c }
        L_0x009c:
            r1 = move-exception
            r2 = r1
            r1 = 1
        L_0x009f:
            if (r1 != 0) goto L_0x00a4
            r10.noMoreExchanges$okhttp(r0)
        L_0x00a4:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        Intrinsics.f(realInterceptorChain, "chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.requestBodyOpen) {
                Unit unit = Unit.f40298a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        Intrinsics.c(exchangeFinder2);
        Exchange exchange2 = new Exchange(this, this.eventListener, exchangeFinder2, exchangeFinder2.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange2;
        this.exchange = exchange2;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (!this.canceled) {
            return exchange2;
        }
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x0017 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[Catch:{ all -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            java.lang.String r0 = "exchange"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            okhttp3.internal.connection.Exchange r0 = r1.exchange
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r0)
            if (r2 != 0) goto L_0x000e
            return r5
        L_0x000e:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L_0x0019
            boolean r0 = r1.requestBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001f
            goto L_0x0019
        L_0x0017:
            r2 = move-exception
            goto L_0x0059
        L_0x0019:
            if (r4 == 0) goto L_0x0041
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0041
        L_0x001f:
            if (r3 == 0) goto L_0x0023
            r1.requestBodyOpen = r2     // Catch:{ all -> 0x0017 }
        L_0x0023:
            if (r4 == 0) goto L_0x0027
            r1.responseBodyOpen = r2     // Catch:{ all -> 0x0017 }
        L_0x0027:
            boolean r3 = r1.requestBodyOpen     // Catch:{ all -> 0x0017 }
            r4 = 1
            if (r3 != 0) goto L_0x0032
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.responseBodyOpen     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            boolean r3 = r1.expectMoreExchanges     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x003e
            r2 = 1
        L_0x003e:
            r3 = r2
            r2 = r0
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            kotlin.Unit r4 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x0051
            r2 = 0
            r1.exchange = r2
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            if (r2 == 0) goto L_0x0051
            r2.incrementSuccessCount$okhttp()
        L_0x0051:
            if (r3 == 0) goto L_0x0058
            java.io.IOException r2 = r1.callDone(r5)
            return r2
        L_0x0058:
            return r5
        L_0x0059:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z2 = true;
                }
            }
            Unit unit = Unit.f40298a;
        }
        if (z2) {
            return callDone(iOException);
        }
        return iOException;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.c(realConnection);
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            Iterator<Reference<RealCall>> it2 = calls.iterator();
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Intrinsics.a(it2.next().get(), this)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                z2 = true;
            }
            if (z2) {
                calls.remove(i2);
                this.connection = null;
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(realConnection)) {
                        return realConnection.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        Intrinsics.c(exchangeFinder2);
        return exchangeFinder2.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
