package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.facebook.common.time.Clock;
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
    public final List<DrmInitData.SchemeData> f6140a;

    /* renamed from: b  reason: collision with root package name */
    private final ExoMediaDrm f6141b;

    /* renamed from: c  reason: collision with root package name */
    private final ProvisioningManager f6142c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceCountListener f6143d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6144e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6145f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6146g;

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, String> f6147h;

    /* renamed from: i  reason: collision with root package name */
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> f6148i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final LoadErrorHandlingPolicy f6149j;

    /* renamed from: k  reason: collision with root package name */
    private final PlayerId f6150k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final MediaDrmCallback f6151l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final UUID f6152m;

    /* renamed from: n  reason: collision with root package name */
    private final Looper f6153n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final ResponseHandler f6154o;

    /* renamed from: p  reason: collision with root package name */
    private int f6155p;

    /* renamed from: q  reason: collision with root package name */
    private int f6156q;

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f6157r;

    /* renamed from: s  reason: collision with root package name */
    private RequestHandler f6158s;

    /* renamed from: t  reason: collision with root package name */
    private CryptoConfig f6159t;

    /* renamed from: u  reason: collision with root package name */
    private DrmSession.DrmSessionException f6160u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f6161v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f6162w;

    /* renamed from: x  reason: collision with root package name */
    private ExoMediaDrm.KeyRequest f6163x;

    /* renamed from: y  reason: collision with root package name */
    private ExoMediaDrm.ProvisionRequest f6164y;

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
        private boolean f6165a;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException iOException;
            MediaDrmCallbackException mediaDrmCallbackException2 = mediaDrmCallbackException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.f6168b) {
                return false;
            }
            int i2 = requestTask.f6171e + 1;
            requestTask.f6171e = i2;
            if (i2 > DefaultDrmSession.this.f6149j.a(3)) {
                return false;
            }
            LoadEventInfo loadEventInfo = new LoadEventInfo(requestTask.f6167a, mediaDrmCallbackException2.f6247b, mediaDrmCallbackException2.f6248c, mediaDrmCallbackException2.f6249d, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.f6169c, mediaDrmCallbackException2.f6250e);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                iOException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                iOException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long c2 = DefaultDrmSession.this.f6149j.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, iOException, requestTask.f6171e));
            if (c2 == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f6165a) {
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
            this.f6165a = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
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
                androidx.media3.exoplayer.drm.DefaultDrmSession$RequestTask r0 = (androidx.media3.exoplayer.drm.DefaultDrmSession.RequestTask) r0
                int r1 = r6.what     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                r2 = 1
                if (r1 == r2) goto L_0x0027
                r2 = 2
                if (r1 != r2) goto L_0x0021
                androidx.media3.exoplayer.drm.DefaultDrmSession r1 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.MediaDrmCallback r1 = r1.f6151l     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                java.util.UUID r2 = r2.f6152m     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                java.lang.Object r3 = r0.f6170d     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.ExoMediaDrm$KeyRequest r3 = (androidx.media3.exoplayer.drm.ExoMediaDrm.KeyRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                byte[] r1 = r1.a(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                goto L_0x004d
            L_0x0021:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                r1.<init>()     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                throw r1     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
            L_0x0027:
                androidx.media3.exoplayer.drm.DefaultDrmSession r1 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.MediaDrmCallback r1 = r1.f6151l     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                java.util.UUID r2 = r2.f6152m     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                java.lang.Object r3 = r0.f6170d     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                androidx.media3.exoplayer.drm.ExoMediaDrm$ProvisionRequest r3 = (androidx.media3.exoplayer.drm.ExoMediaDrm.ProvisionRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                byte[] r1 = r1.b(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0045, Exception -> 0x003c }
                goto L_0x004d
            L_0x003c:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                androidx.media3.common.util.Log.i(r2, r3, r1)
                goto L_0x004d
            L_0x0045:
                r1 = move-exception
                boolean r2 = r5.a(r6, r1)
                if (r2 == 0) goto L_0x004d
                return
            L_0x004d:
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this
                androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r2 = r2.f6149j
                long r3 = r0.f6167a
                r2.b(r3)
                monitor-enter(r5)
                boolean r2 = r5.f6165a     // Catch:{ all -> 0x0074 }
                if (r2 != 0) goto L_0x0072
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ all -> 0x0074 }
                androidx.media3.exoplayer.drm.DefaultDrmSession$ResponseHandler r2 = r2.f6154o     // Catch:{ all -> 0x0074 }
                int r6 = r6.what     // Catch:{ all -> 0x0074 }
                java.lang.Object r0 = r0.f6170d     // Catch:{ all -> 0x0074 }
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0074 }
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0074 }
                r6.sendToTarget()     // Catch:{ all -> 0x0074 }
            L_0x0072:
                monitor-exit(r5)     // Catch:{ all -> 0x0074 }
                return
            L_0x0074:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0074 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.RequestHandler.handleMessage(android.os.Message):void");
        }
    }

    private static final class RequestTask {

        /* renamed from: a  reason: collision with root package name */
        public final long f6167a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6168b;

        /* renamed from: c  reason: collision with root package name */
        public final long f6169c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f6170d;

        /* renamed from: e  reason: collision with root package name */
        public int f6171e;

        public RequestTask(long j2, boolean z2, long j3, Object obj) {
            this.f6167a = j2;
            this.f6168b = z2;
            this.f6169c = j3;
            this.f6170d = obj;
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
            if (i2 == 1) {
                DefaultDrmSession.this.D(obj, obj2);
            } else if (i2 == 2) {
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
            Assertions.f(bArr);
        }
        this.f6152m = uuid;
        this.f6142c = provisioningManager;
        this.f6143d = referenceCountListener;
        this.f6141b = exoMediaDrm;
        this.f6144e = i2;
        this.f6145f = z2;
        this.f6146g = z3;
        if (bArr != null) {
            this.f6162w = bArr;
            this.f6140a = null;
        } else {
            this.f6140a = Collections.unmodifiableList((List) Assertions.f(list));
        }
        this.f6147h = hashMap;
        this.f6151l = mediaDrmCallback;
        this.f6148i = new CopyOnWriteMultiset<>();
        this.f6149j = loadErrorHandlingPolicy;
        this.f6150k = playerId;
        this.f6155p = 2;
        this.f6153n = looper;
        this.f6154o = new ResponseHandler(looper);
    }

    /* access modifiers changed from: private */
    public void D(Object obj, Object obj2) {
        if (obj != this.f6164y) {
            return;
        }
        if (this.f6155p == 2 || t()) {
            this.f6164y = null;
            if (obj2 instanceof Exception) {
                this.f6142c.a((Exception) obj2, false);
                return;
            }
            try {
                this.f6141b.e((byte[]) obj2);
                this.f6142c.b();
            } catch (Exception e2) {
                this.f6142c.a(e2, true);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean E() {
        if (t()) {
            return true;
        }
        try {
            byte[] c2 = this.f6141b.c();
            this.f6161v = c2;
            this.f6141b.m(c2, this.f6150k);
            this.f6159t = this.f6141b.g(this.f6161v);
            this.f6155p = 3;
            p(new b(3));
            Assertions.f(this.f6161v);
            return true;
        } catch (NotProvisionedException unused) {
            this.f6142c.c(this);
            return false;
        } catch (Exception | NoSuchMethodError e2) {
            if (DrmUtil.b(e2)) {
                this.f6142c.c(this);
                return false;
            }
            w(e2, 1);
            return false;
        }
    }

    private void F(byte[] bArr, int i2, boolean z2) {
        try {
            this.f6163x = this.f6141b.k(bArr, this.f6140a, i2, this.f6147h);
            ((RequestHandler) Util.i(this.f6158s)).b(2, Assertions.f(this.f6163x), z2);
        } catch (Exception | NoSuchMethodError e2) {
            y(e2, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean H() {
        try {
            this.f6141b.d(this.f6161v, this.f6162w);
            return true;
        } catch (Exception | NoSuchMethodError e2) {
            w(e2, 1);
            return false;
        }
    }

    private void I() {
        if (Thread.currentThread() != this.f6153n.getThread()) {
            Log.i("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f6153n.getThread().getName(), new IllegalStateException());
        }
    }

    private void p(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        for (DrmSessionEventListener.EventDispatcher accept : this.f6148i.f()) {
            consumer.accept(accept);
        }
    }

    @RequiresNonNull({"sessionId"})
    private void q(boolean z2) {
        if (!this.f6146g) {
            byte[] bArr = (byte[]) Util.i(this.f6161v);
            int i2 = this.f6144e;
            if (i2 == 0 || i2 == 1) {
                if (this.f6162w == null) {
                    F(bArr, 1, z2);
                } else if (this.f6155p == 4 || H()) {
                    long r2 = r();
                    if (this.f6144e == 0 && r2 <= 60) {
                        Log.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + r2);
                        F(bArr, 2, z2);
                    } else if (r2 <= 0) {
                        w(new KeysExpiredException(), 2);
                    } else {
                        this.f6155p = 4;
                        p(new c());
                    }
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Assertions.f(this.f6162w);
                    Assertions.f(this.f6161v);
                    F(this.f6162w, 3, z2);
                }
            } else if (this.f6162w == null || H()) {
                F(bArr, 2, z2);
            }
        }
    }

    private long r() {
        if (!C.f3933d.equals(this.f6152m)) {
            return Clock.MAX_TIME;
        }
        Pair pair = (Pair) Assertions.f(WidevineUtil.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean t() {
        int i2 = this.f6155p;
        return i2 == 3 || i2 == 4;
    }

    private void w(Throwable th, int i2) {
        this.f6160u = new DrmSession.DrmSessionException(th, DrmUtil.a(th, i2));
        Log.d("DefaultDrmSession", "DRM session error", th);
        if (th instanceof Exception) {
            p(new a(th));
        } else if (!(th instanceof Error)) {
            throw new IllegalStateException("Unexpected Throwable subclass", th);
        } else if (!DrmUtil.c(th) && !DrmUtil.b(th)) {
            throw ((Error) th);
        }
        if (this.f6155p != 4) {
            this.f6155p = 1;
        }
    }

    /* access modifiers changed from: private */
    public void x(Object obj, Object obj2) {
        if (obj == this.f6163x && t()) {
            this.f6163x = null;
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                y((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f6144e == 3) {
                    this.f6141b.j((byte[]) Util.i(this.f6162w), bArr);
                    p(new d());
                    return;
                }
                byte[] j2 = this.f6141b.j(this.f6161v, bArr);
                int i2 = this.f6144e;
                if (!((i2 != 2 && (i2 != 0 || this.f6162w == null)) || j2 == null || j2.length == 0)) {
                    this.f6162w = j2;
                }
                this.f6155p = 4;
                p(new e());
            } catch (Exception | NoSuchMethodError e2) {
                y(e2, true);
            }
        }
    }

    private void y(Throwable th, boolean z2) {
        int i2;
        if ((th instanceof NotProvisionedException) || DrmUtil.b(th)) {
            this.f6142c.c(this);
            return;
        }
        if (z2) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        w(th, i2);
    }

    private void z() {
        if (this.f6144e == 0 && this.f6155p == 4) {
            Util.i(this.f6161v);
            q(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void A(int i2) {
        if (i2 == 2) {
            z();
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
        if (E()) {
            q(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(Exception exc, boolean z2) {
        w(exc, z2 ? 1 : 3);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.f6164y = this.f6141b.b();
        ((RequestHandler) Util.i(this.f6158s)).b(1, Assertions.f(this.f6164y), true);
    }

    public final UUID a() {
        I();
        return this.f6152m;
    }

    public boolean b() {
        I();
        return this.f6145f;
    }

    public final CryptoConfig c() {
        I();
        return this.f6159t;
    }

    public Map<String, String> d() {
        I();
        byte[] bArr = this.f6161v;
        if (bArr == null) {
            return null;
        }
        return this.f6141b.a(bArr);
    }

    public boolean e(String str) {
        I();
        return this.f6141b.h((byte[]) Assertions.j(this.f6161v), str);
    }

    public void f(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        I();
        boolean z2 = false;
        if (this.f6156q < 0) {
            Log.c("DefaultDrmSession", "Session reference count less than zero: " + this.f6156q);
            this.f6156q = 0;
        }
        if (eventDispatcher != null) {
            this.f6148i.a(eventDispatcher);
        }
        int i2 = this.f6156q + 1;
        this.f6156q = i2;
        if (i2 == 1) {
            if (this.f6155p == 2) {
                z2 = true;
            }
            Assertions.h(z2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f6157r = handlerThread;
            handlerThread.start();
            this.f6158s = new RequestHandler(this.f6157r.getLooper());
            if (E()) {
                q(true);
            }
        } else if (eventDispatcher != null && t() && this.f6148i.b(eventDispatcher) == 1) {
            eventDispatcher.k(this.f6155p);
        }
        this.f6143d.a(this, this.f6156q);
    }

    public void g(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        I();
        int i2 = this.f6156q;
        if (i2 <= 0) {
            Log.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i3 = i2 - 1;
        this.f6156q = i3;
        if (i3 == 0) {
            this.f6155p = 0;
            ((ResponseHandler) Util.i(this.f6154o)).removeCallbacksAndMessages((Object) null);
            ((RequestHandler) Util.i(this.f6158s)).c();
            this.f6158s = null;
            ((HandlerThread) Util.i(this.f6157r)).quit();
            this.f6157r = null;
            this.f6159t = null;
            this.f6160u = null;
            this.f6163x = null;
            this.f6164y = null;
            byte[] bArr = this.f6161v;
            if (bArr != null) {
                this.f6141b.i(bArr);
                this.f6161v = null;
            }
        }
        if (eventDispatcher != null) {
            this.f6148i.c(eventDispatcher);
            if (this.f6148i.b(eventDispatcher) == 0) {
                eventDispatcher.m();
            }
        }
        this.f6143d.b(this, this.f6156q);
    }

    public final DrmSession.DrmSessionException getError() {
        I();
        if (this.f6155p == 1) {
            return this.f6160u;
        }
        return null;
    }

    public final int getState() {
        I();
        return this.f6155p;
    }

    public boolean s(byte[] bArr) {
        I();
        return Arrays.equals(this.f6161v, bArr);
    }
}
