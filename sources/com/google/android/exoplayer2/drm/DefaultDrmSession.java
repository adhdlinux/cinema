package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

class DefaultDrmSession implements DrmSession {

    /* renamed from: a  reason: collision with root package name */
    public final List<DrmInitData.SchemeData> f23996a;

    /* renamed from: b  reason: collision with root package name */
    private final ExoMediaDrm f23997b;

    /* renamed from: c  reason: collision with root package name */
    private final ProvisioningManager f23998c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceCountListener f23999d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24000e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24001f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f24002g;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, String> f24003h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> f24004i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final LoadErrorHandlingPolicy f24005j;

    /* renamed from: k  reason: collision with root package name */
    private final PlayerId f24006k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final MediaDrmCallback f24007l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final UUID f24008m;

    /* renamed from: n  reason: collision with root package name */
    private final Looper f24009n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final ResponseHandler f24010o;

    /* renamed from: p  reason: collision with root package name */
    private int f24011p;

    /* renamed from: q  reason: collision with root package name */
    private int f24012q;

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f24013r;

    /* renamed from: s  reason: collision with root package name */
    private RequestHandler f24014s;

    /* renamed from: t  reason: collision with root package name */
    private CryptoConfig f24015t;

    /* renamed from: u  reason: collision with root package name */
    private DrmSession.DrmSessionException f24016u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f24017v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f24018w;

    /* renamed from: x  reason: collision with root package name */
    private ExoMediaDrm.KeyRequest f24019x;

    /* renamed from: y  reason: collision with root package name */
    private ExoMediaDrm.ProvisionRequest f24020y;

    public interface ProvisioningManager {
        void a(Exception exc, boolean z2);

        void b();

        void c(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void a(DefaultDrmSession defaultDrmSession, int i2);

        void b(DefaultDrmSession defaultDrmSession, int i2);
    }

    @SuppressLint({"HandlerLeak"})
    private class RequestHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24021a;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException iOException;
            MediaDrmCallbackException mediaDrmCallbackException2 = mediaDrmCallbackException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.f24024b) {
                return false;
            }
            int i2 = requestTask.f24027e + 1;
            requestTask.f24027e = i2;
            if (i2 > DefaultDrmSession.this.f24005j.a(3)) {
                return false;
            }
            LoadEventInfo loadEventInfo = new LoadEventInfo(requestTask.f24023a, mediaDrmCallbackException2.f24111b, mediaDrmCallbackException2.f24112c, mediaDrmCallbackException2.f24113d, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.f24025c, mediaDrmCallbackException2.f24114e);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                iOException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                iOException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long c2 = DefaultDrmSession.this.f24005j.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, iOException, requestTask.f24027e));
            if (c2 == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f24021a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), c2);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, Object obj, boolean z2) {
            obtainMessage(i2, new RequestTask(LoadEventInfo.a(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages((Object) null);
            this.f24021a = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
        /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                com.google.android.exoplayer2.drm.DefaultDrmSession$RequestTask r0 = (com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask) r0
                int r1 = r6.what     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                if (r1 == 0) goto L_0x0026
                r2 = 1
                if (r1 != r2) goto L_0x0020
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.f24007l     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.util.UUID r2 = r2.f24008m     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.lang.Object r3 = r0.f24026d     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                byte[] r1 = r1.b(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                goto L_0x004c
            L_0x0020:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                r1.<init>()     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                throw r1     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
            L_0x0026:
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.f24007l     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.util.UUID r2 = r2.f24008m     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.lang.Object r3 = r0.f24026d     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                byte[] r1 = r1.a(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                goto L_0x004c
            L_0x003b:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.google.android.exoplayer2.util.Log.j(r2, r3, r1)
                goto L_0x004c
            L_0x0044:
                r1 = move-exception
                boolean r2 = r5.a(r6, r1)
                if (r2 == 0) goto L_0x004c
                return
            L_0x004c:
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r2.f24005j
                long r3 = r0.f24023a
                r2.b(r3)
                monitor-enter(r5)
                boolean r2 = r5.f24021a     // Catch:{ all -> 0x0073 }
                if (r2 != 0) goto L_0x0071
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ all -> 0x0073 }
                com.google.android.exoplayer2.drm.DefaultDrmSession$ResponseHandler r2 = r2.f24010o     // Catch:{ all -> 0x0073 }
                int r6 = r6.what     // Catch:{ all -> 0x0073 }
                java.lang.Object r0 = r0.f24026d     // Catch:{ all -> 0x0073 }
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0073 }
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0073 }
                r6.sendToTarget()     // Catch:{ all -> 0x0073 }
            L_0x0071:
                monitor-exit(r5)     // Catch:{ all -> 0x0073 }
                return
            L_0x0073:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0073 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler.handleMessage(android.os.Message):void");
        }
    }

    private static final class RequestTask {

        /* renamed from: a  reason: collision with root package name */
        public final long f24023a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f24024b;

        /* renamed from: c  reason: collision with root package name */
        public final long f24025c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f24026d;

        /* renamed from: e  reason: collision with root package name */
        public int f24027e;

        public RequestTask(long j2, boolean z2, long j3, Object obj) {
            this.f24023a = j2;
            this.f24024b = z2;
            this.f24025c = j3;
            this.f24026d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                DefaultDrmSession.this.D(obj, obj2);
            } else if (i2 == 1) {
                DefaultDrmSession.this.x(obj, obj2);
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, List<DrmInitData.SchemeData> list, int i2, boolean z2, boolean z3, byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy, PlayerId playerId) {
        if (i2 == 1 || i2 == 3) {
            Assertions.e(bArr);
        }
        this.f24008m = uuid;
        this.f23998c = provisioningManager;
        this.f23999d = referenceCountListener;
        this.f23997b = exoMediaDrm;
        this.f24000e = i2;
        this.f24001f = z2;
        this.f24002g = z3;
        if (bArr != null) {
            this.f24018w = bArr;
            this.f23996a = null;
        } else {
            this.f23996a = Collections.unmodifiableList((List) Assertions.e(list));
        }
        this.f24003h = hashMap;
        this.f24007l = mediaDrmCallback;
        this.f24004i = new CopyOnWriteMultiset<>();
        this.f24005j = loadErrorHandlingPolicy;
        this.f24006k = playerId;
        this.f24011p = 2;
        this.f24009n = looper;
        this.f24010o = new ResponseHandler(looper);
    }

    /* access modifiers changed from: private */
    public void D(Object obj, Object obj2) {
        if (obj != this.f24020y) {
            return;
        }
        if (this.f24011p == 2 || t()) {
            this.f24020y = null;
            if (obj2 instanceof Exception) {
                this.f23998c.a((Exception) obj2, false);
                return;
            }
            try {
                this.f23997b.e((byte[]) obj2);
                this.f23998c.b();
            } catch (Exception e2) {
                this.f23998c.a(e2, true);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean E() {
        if (t()) {
            return true;
        }
        try {
            byte[] c2 = this.f23997b.c();
            this.f24017v = c2;
            this.f23997b.l(c2, this.f24006k);
            this.f24015t = this.f23997b.g(this.f24017v);
            this.f24011p = 3;
            p(new c(3));
            Assertions.e(this.f24017v);
            return true;
        } catch (NotProvisionedException unused) {
            this.f23998c.c(this);
            return false;
        } catch (Exception e2) {
            w(e2, 1);
            return false;
        }
    }

    private void F(byte[] bArr, int i2, boolean z2) {
        try {
            this.f24019x = this.f23997b.k(bArr, this.f23996a, i2, this.f24003h);
            ((RequestHandler) Util.j(this.f24014s)).b(1, Assertions.e(this.f24019x), z2);
        } catch (Exception e2) {
            y(e2, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean H() {
        try {
            this.f23997b.d(this.f24017v, this.f24018w);
            return true;
        } catch (Exception e2) {
            w(e2, 1);
            return false;
        }
    }

    private void I() {
        if (Thread.currentThread() != this.f24009n.getThread()) {
            Log.j("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f24009n.getThread().getName(), new IllegalStateException());
        }
    }

    private void p(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        for (DrmSessionEventListener.EventDispatcher accept : this.f24004i.f()) {
            consumer.accept(accept);
        }
    }

    @RequiresNonNull({"sessionId"})
    private void q(boolean z2) {
        if (!this.f24002g) {
            byte[] bArr = (byte[]) Util.j(this.f24017v);
            int i2 = this.f24000e;
            if (i2 == 0 || i2 == 1) {
                if (this.f24018w == null) {
                    F(bArr, 1, z2);
                } else if (this.f24011p == 4 || H()) {
                    long r2 = r();
                    if (this.f24000e == 0 && r2 <= 60) {
                        Log.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + r2);
                        F(bArr, 2, z2);
                    } else if (r2 <= 0) {
                        w(new KeysExpiredException(), 2);
                    } else {
                        this.f24011p = 4;
                        p(new e());
                    }
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Assertions.e(this.f24018w);
                    Assertions.e(this.f24017v);
                    F(this.f24018w, 3, z2);
                }
            } else if (this.f24018w == null || H()) {
                F(bArr, 2, z2);
            }
        }
    }

    private long r() {
        if (!C.f22819d.equals(this.f24008m)) {
            return Clock.MAX_TIME;
        }
        Pair pair = (Pair) Assertions.e(WidevineUtil.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean t() {
        int i2 = this.f24011p;
        return i2 == 3 || i2 == 4;
    }

    private void w(Exception exc, int i2) {
        this.f24016u = new DrmSession.DrmSessionException(exc, DrmUtil.a(exc, i2));
        Log.d("DefaultDrmSession", "DRM session error", exc);
        p(new d(exc));
        if (this.f24011p != 4) {
            this.f24011p = 1;
        }
    }

    /* access modifiers changed from: private */
    public void x(Object obj, Object obj2) {
        if (obj == this.f24019x && t()) {
            this.f24019x = null;
            if (obj2 instanceof Exception) {
                y((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f24000e == 3) {
                    this.f23997b.j((byte[]) Util.j(this.f24018w), bArr);
                    p(new a());
                    return;
                }
                byte[] j2 = this.f23997b.j(this.f24017v, bArr);
                int i2 = this.f24000e;
                if (!((i2 != 2 && (i2 != 0 || this.f24018w == null)) || j2 == null || j2.length == 0)) {
                    this.f24018w = j2;
                }
                this.f24011p = 4;
                p(new b());
            } catch (Exception e2) {
                y(e2, true);
            }
        }
    }

    private void y(Exception exc, boolean z2) {
        int i2;
        if (exc instanceof NotProvisionedException) {
            this.f23998c.c(this);
            return;
        }
        if (z2) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        w(exc, i2);
    }

    private void z() {
        if (this.f24000e == 0 && this.f24011p == 4) {
            Util.j(this.f24017v);
            q(false);
        }
    }

    public void A(int i2) {
        if (i2 == 2) {
            z();
        }
    }

    public void B() {
        if (E()) {
            q(true);
        }
    }

    public void C(Exception exc, boolean z2) {
        w(exc, z2 ? 1 : 3);
    }

    public void G() {
        this.f24020y = this.f23997b.b();
        ((RequestHandler) Util.j(this.f24014s)).b(0, Assertions.e(this.f24020y), true);
    }

    public final UUID a() {
        I();
        return this.f24008m;
    }

    public boolean b() {
        I();
        return this.f24001f;
    }

    public final CryptoConfig c() {
        I();
        return this.f24015t;
    }

    public Map<String, String> d() {
        I();
        byte[] bArr = this.f24017v;
        if (bArr == null) {
            return null;
        }
        return this.f23997b.a(bArr);
    }

    public boolean e(String str) {
        I();
        return this.f23997b.h((byte[]) Assertions.i(this.f24017v), str);
    }

    public void f(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        I();
        boolean z2 = false;
        if (this.f24012q < 0) {
            Log.c("DefaultDrmSession", "Session reference count less than zero: " + this.f24012q);
            this.f24012q = 0;
        }
        if (eventDispatcher != null) {
            this.f24004i.a(eventDispatcher);
        }
        int i2 = this.f24012q + 1;
        this.f24012q = i2;
        if (i2 == 1) {
            if (this.f24011p == 2) {
                z2 = true;
            }
            Assertions.g(z2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f24013r = handlerThread;
            handlerThread.start();
            this.f24014s = new RequestHandler(this.f24013r.getLooper());
            if (E()) {
                q(true);
            }
        } else if (eventDispatcher != null && t() && this.f24004i.b(eventDispatcher) == 1) {
            eventDispatcher.k(this.f24011p);
        }
        this.f23999d.a(this, this.f24012q);
    }

    public void g(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        I();
        int i2 = this.f24012q;
        if (i2 <= 0) {
            Log.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i3 = i2 - 1;
        this.f24012q = i3;
        if (i3 == 0) {
            this.f24011p = 0;
            ((ResponseHandler) Util.j(this.f24010o)).removeCallbacksAndMessages((Object) null);
            ((RequestHandler) Util.j(this.f24014s)).c();
            this.f24014s = null;
            ((HandlerThread) Util.j(this.f24013r)).quit();
            this.f24013r = null;
            this.f24015t = null;
            this.f24016u = null;
            this.f24019x = null;
            this.f24020y = null;
            byte[] bArr = this.f24017v;
            if (bArr != null) {
                this.f23997b.i(bArr);
                this.f24017v = null;
            }
        }
        if (eventDispatcher != null) {
            this.f24004i.c(eventDispatcher);
            if (this.f24004i.b(eventDispatcher) == 0) {
                eventDispatcher.m();
            }
        }
        this.f23999d.b(this, this.f24012q);
    }

    public final DrmSession.DrmSessionException getError() {
        I();
        if (this.f24011p == 1) {
            return this.f24016u;
        }
        return null;
    }

    public final int getState() {
        I();
        return this.f24011p;
    }

    public boolean s(byte[] bArr) {
        I();
        return Arrays.equals(this.f24017v, bArr);
    }
}
