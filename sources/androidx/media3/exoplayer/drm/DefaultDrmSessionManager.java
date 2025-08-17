package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class DefaultDrmSessionManager implements DrmSessionManager {

    /* renamed from: b  reason: collision with root package name */
    private final UUID f6173b;

    /* renamed from: c  reason: collision with root package name */
    private final ExoMediaDrm.Provider f6174c;

    /* renamed from: d  reason: collision with root package name */
    private final MediaDrmCallback f6175d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, String> f6176e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f6177f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f6178g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6179h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final ProvisioningManagerImpl f6180i;

    /* renamed from: j  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f6181j;

    /* renamed from: k  reason: collision with root package name */
    private final ReferenceCountListenerImpl f6182k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final long f6183l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final List<DefaultDrmSession> f6184m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Set<PreacquiredSessionReference> f6185n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Set<DefaultDrmSession> f6186o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f6187p;

    /* renamed from: q  reason: collision with root package name */
    private ExoMediaDrm f6188q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public DefaultDrmSession f6189r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public DefaultDrmSession f6190s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Looper f6191t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Handler f6192u;

    /* renamed from: v  reason: collision with root package name */
    private int f6193v;

    /* renamed from: w  reason: collision with root package name */
    private byte[] f6194w;

    /* renamed from: x  reason: collision with root package name */
    private PlayerId f6195x;

    /* renamed from: y  reason: collision with root package name */
    volatile MediaDrmHandler f6196y;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, String> f6197a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private UUID f6198b = C.f3933d;

        /* renamed from: c  reason: collision with root package name */
        private ExoMediaDrm.Provider f6199c = FrameworkMediaDrm.f6239d;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6200d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f6201e = new int[0];

        /* renamed from: f  reason: collision with root package name */
        private boolean f6202f = true;

        /* renamed from: g  reason: collision with root package name */
        private LoadErrorHandlingPolicy f6203g = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: h  reason: collision with root package name */
        private long f6204h = 300000;

        public DefaultDrmSessionManager a(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f6198b, this.f6199c, mediaDrmCallback, this.f6197a, this.f6200d, this.f6201e, this.f6202f, this.f6203g, this.f6204h);
        }

        public Builder b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f6203g = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy);
            return this;
        }

        public Builder c(boolean z2) {
            this.f6200d = z2;
            return this;
        }

        public Builder d(boolean z2) {
            this.f6202f = z2;
            return this;
        }

        public Builder e(int... iArr) {
            for (int i2 : iArr) {
                boolean z2 = true;
                if (!(i2 == 2 || i2 == 1)) {
                    z2 = false;
                }
                Assertions.a(z2);
            }
            this.f6201e = (int[]) iArr.clone();
            return this;
        }

        public Builder f(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f6198b = (UUID) Assertions.f(uuid);
            this.f6199c = (ExoMediaDrm.Provider) Assertions.f(provider);
            return this;
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        public void a(ExoMediaDrm exoMediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
            ((MediaDrmHandler) Assertions.f(DefaultDrmSessionManager.this.f6196y)).obtainMessage(i2, bArr).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f6184m) {
                    if (defaultDrmSession.s(bArr)) {
                        defaultDrmSession.A(message.what);
                        return;
                    }
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    private class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {

        /* renamed from: b  reason: collision with root package name */
        private final DrmSessionEventListener.EventDispatcher f6207b;

        /* renamed from: c  reason: collision with root package name */
        private DrmSession f6208c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f6209d;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.f6207b = eventDispatcher;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Format format) {
            if (DefaultDrmSessionManager.this.f6187p != 0 && !this.f6209d) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                this.f6208c = defaultDrmSessionManager.s((Looper) Assertions.f(defaultDrmSessionManager.f6191t), this.f6207b, format, false);
                DefaultDrmSessionManager.this.f6185n.add(this);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (!this.f6209d) {
                DrmSession drmSession = this.f6208c;
                if (drmSession != null) {
                    drmSession.g(this.f6207b);
                }
                DefaultDrmSessionManager.this.f6185n.remove(this);
                this.f6209d = true;
            }
        }

        public void c(Format format) {
            ((Handler) Assertions.f(DefaultDrmSessionManager.this.f6192u)).post(new g(this, format));
        }

        public void release() {
            Util.Y0((Handler) Assertions.f(DefaultDrmSessionManager.this.f6192u), new f(this));
        }
    }

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {

        /* renamed from: a  reason: collision with root package name */
        private final Set<DefaultDrmSession> f6211a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private DefaultDrmSession f6212b;

        public ProvisioningManagerImpl() {
        }

        public void a(Exception exc, boolean z2) {
            this.f6212b = null;
            ImmutableList<DefaultDrmSession> n2 = ImmutableList.n(this.f6211a);
            this.f6211a.clear();
            UnmodifiableIterator<DefaultDrmSession> h2 = n2.iterator();
            while (h2.hasNext()) {
                h2.next().C(exc, z2);
            }
        }

        public void b() {
            this.f6212b = null;
            ImmutableList<DefaultDrmSession> n2 = ImmutableList.n(this.f6211a);
            this.f6211a.clear();
            UnmodifiableIterator<DefaultDrmSession> h2 = n2.iterator();
            while (h2.hasNext()) {
                h2.next().B();
            }
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f6211a.add(defaultDrmSession);
            if (this.f6212b == null) {
                this.f6212b = defaultDrmSession;
                defaultDrmSession.G();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.f6211a.remove(defaultDrmSession);
            if (this.f6212b == defaultDrmSession) {
                this.f6212b = null;
                if (!this.f6211a.isEmpty()) {
                    DefaultDrmSession next = this.f6211a.iterator().next();
                    this.f6212b = next;
                    next.G();
                }
            }
        }
    }

    private class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        private ReferenceCountListenerImpl() {
        }

        public void a(DefaultDrmSession defaultDrmSession, int i2) {
            if (DefaultDrmSessionManager.this.f6183l != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f6186o.remove(defaultDrmSession);
                ((Handler) Assertions.f(DefaultDrmSessionManager.this.f6192u)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        public void b(DefaultDrmSession defaultDrmSession, int i2) {
            if (i2 == 1 && DefaultDrmSessionManager.this.f6187p > 0 && DefaultDrmSessionManager.this.f6183l != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f6186o.add(defaultDrmSession);
                ((Handler) Assertions.f(DefaultDrmSessionManager.this.f6192u)).postAtTime(new h(defaultDrmSession), defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f6183l);
            } else if (i2 == 0) {
                DefaultDrmSessionManager.this.f6184m.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f6189r == defaultDrmSession) {
                    DefaultDrmSession unused = DefaultDrmSessionManager.this.f6189r = null;
                }
                if (DefaultDrmSessionManager.this.f6190s == defaultDrmSession) {
                    DefaultDrmSession unused2 = DefaultDrmSessionManager.this.f6190s = null;
                }
                DefaultDrmSessionManager.this.f6180i.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f6183l != -9223372036854775807L) {
                    ((Handler) Assertions.f(DefaultDrmSessionManager.this.f6192u)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f6186o.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    private void A(Looper looper) {
        if (this.f6196y == null) {
            this.f6196y = new MediaDrmHandler(looper);
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        if (this.f6188q != null && this.f6187p == 0 && this.f6184m.isEmpty() && this.f6185n.isEmpty()) {
            ((ExoMediaDrm) Assertions.f(this.f6188q)).release();
            this.f6188q = null;
        }
    }

    private void C() {
        UnmodifiableIterator<DefaultDrmSession> h2 = ImmutableSet.m(this.f6186o).iterator();
        while (h2.hasNext()) {
            h2.next().g((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void D() {
        UnmodifiableIterator<PreacquiredSessionReference> h2 = ImmutableSet.m(this.f6185n).iterator();
        while (h2.hasNext()) {
            h2.next().release();
        }
    }

    private void F(DrmSession drmSession, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.g(eventDispatcher);
        if (this.f6183l != -9223372036854775807L) {
            drmSession.g((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void G(boolean z2) {
        if (z2 && this.f6191t == null) {
            Log.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
        } else if (Thread.currentThread() != ((Looper) Assertions.f(this.f6191t)).getThread()) {
            Log.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f6191t.getThread().getName(), new IllegalStateException());
        }
    }

    /* access modifiers changed from: private */
    public DrmSession s(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z2) {
        List<DrmInitData.SchemeData> list;
        A(looper);
        DrmInitData drmInitData = format.f4019r;
        if (drmInitData == null) {
            return z(MimeTypes.k(format.f4015n), z2);
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.f6194w == null) {
            list = x((DrmInitData) Assertions.f(drmInitData), this.f6173b, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f6173b);
                Log.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.l(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE));
            }
        } else {
            list = null;
        }
        if (this.f6177f) {
            Iterator<DefaultDrmSession> it2 = this.f6184m.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it2.next();
                if (Util.c(next.f6140a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f6190s;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = w(list, false, eventDispatcher, z2);
            if (!this.f6177f) {
                this.f6190s = defaultDrmSession;
            }
            this.f6184m.add(defaultDrmSession);
        } else {
            defaultDrmSession.f(eventDispatcher);
        }
        return defaultDrmSession;
    }

    private static boolean t(DrmSession drmSession) {
        if (drmSession.getState() != 1) {
            return false;
        }
        Throwable cause = ((DrmSession.DrmSessionException) Assertions.f(drmSession.getError())).getCause();
        if ((cause instanceof ResourceBusyException) || DrmUtil.c(cause)) {
            return true;
        }
        return false;
    }

    private boolean u(DrmInitData drmInitData) {
        if (this.f6194w != null) {
            return true;
        }
        if (x(drmInitData, this.f6173b, true).isEmpty()) {
            if (drmInitData.f3973e != 1 || !drmInitData.f(0).e(C.f3931b)) {
                return false;
            }
            Log.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f6173b);
        }
        String str = drmInitData.f3972d;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            if (Util.f4714a >= 25) {
                return true;
            }
            return false;
        } else if ("cbc1".equals(str) || "cens".equals(str)) {
            return false;
        } else {
            return true;
        }
    }

    private DefaultDrmSession v(List<DrmInitData.SchemeData> list, boolean z2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.f(this.f6188q);
        List<DrmInitData.SchemeData> list2 = list;
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f6173b, this.f6188q, this.f6180i, this.f6182k, list2, this.f6193v, this.f6179h | z2, z2, this.f6194w, this.f6176e, this.f6175d, (Looper) Assertions.f(this.f6191t), this.f6181j, (PlayerId) Assertions.f(this.f6195x));
        defaultDrmSession.f(eventDispatcher);
        if (this.f6183l != -9223372036854775807L) {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession w(List<DrmInitData.SchemeData> list, boolean z2, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z3) {
        DefaultDrmSession v2 = v(list, z2, eventDispatcher);
        if (t(v2) && !this.f6186o.isEmpty()) {
            C();
            F(v2, eventDispatcher);
            v2 = v(list, z2, eventDispatcher);
        }
        if (!t(v2) || !z3 || this.f6185n.isEmpty()) {
            return v2;
        }
        D();
        if (!this.f6186o.isEmpty()) {
            C();
        }
        F(v2, eventDispatcher);
        return v(list, z2, eventDispatcher);
    }

    private static List<DrmInitData.SchemeData> x(DrmInitData drmInitData, UUID uuid, boolean z2) {
        boolean z3;
        ArrayList arrayList = new ArrayList(drmInitData.f3973e);
        for (int i2 = 0; i2 < drmInitData.f3973e; i2++) {
            DrmInitData.SchemeData f2 = drmInitData.f(i2);
            if (f2.e(uuid) || (C.f3932c.equals(uuid) && f2.e(C.f3931b))) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && (f2.f3978f != null || z2)) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void y(Looper looper) {
        boolean z2;
        Looper looper2 = this.f6191t;
        if (looper2 == null) {
            this.f6191t = looper;
            this.f6192u = new Handler(looper);
        } else {
            if (looper2 == looper) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            Assertions.f(this.f6192u);
        }
    }

    private DrmSession z(int i2, boolean z2) {
        boolean z3;
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.f(this.f6188q);
        if (exoMediaDrm.f() != 2 || !FrameworkCryptoConfig.f6235d) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || Util.M0(this.f6178g, i2) == -1 || exoMediaDrm.f() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f6189r;
        if (defaultDrmSession == null) {
            DefaultDrmSession w2 = w(ImmutableList.r(), true, (DrmSessionEventListener.EventDispatcher) null, z2);
            this.f6184m.add(w2);
            this.f6189r = w2;
        } else {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return this.f6189r;
    }

    public void E(int i2, byte[] bArr) {
        Assertions.h(this.f6184m.isEmpty());
        if (i2 == 1 || i2 == 3) {
            Assertions.f(bArr);
        }
        this.f6193v = i2;
        this.f6194w = bArr;
    }

    public void a(Looper looper, PlayerId playerId) {
        y(looper);
        this.f6195x = playerId;
    }

    public DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z2 = false;
        G(false);
        if (this.f6187p > 0) {
            z2 = true;
        }
        Assertions.h(z2);
        Assertions.j(this.f6191t);
        return s(this.f6191t, eventDispatcher, format, true);
    }

    public int c(Format format) {
        G(false);
        int f2 = ((ExoMediaDrm) Assertions.f(this.f6188q)).f();
        DrmInitData drmInitData = format.f4019r;
        if (drmInitData == null) {
            if (Util.M0(this.f6178g, MimeTypes.k(format.f4015n)) != -1) {
                return f2;
            }
            return 0;
        } else if (u(drmInitData)) {
            return f2;
        } else {
            return 1;
        }
    }

    public DrmSessionManager.DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z2;
        if (this.f6187p > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        Assertions.j(this.f6191t);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        preacquiredSessionReference.c(format);
        return preacquiredSessionReference;
    }

    public final void prepare() {
        G(true);
        int i2 = this.f6187p;
        this.f6187p = i2 + 1;
        if (i2 == 0) {
            if (this.f6188q == null) {
                ExoMediaDrm a2 = this.f6174c.a(this.f6173b);
                this.f6188q = a2;
                a2.l(new MediaDrmEventListener());
            } else if (this.f6183l != -9223372036854775807L) {
                for (int i3 = 0; i3 < this.f6184m.size(); i3++) {
                    this.f6184m.get(i3).f((DrmSessionEventListener.EventDispatcher) null);
                }
            }
        }
    }

    public final void release() {
        G(true);
        int i2 = this.f6187p - 1;
        this.f6187p = i2;
        if (i2 == 0) {
            if (this.f6183l != -9223372036854775807L) {
                ArrayList arrayList = new ArrayList(this.f6184m);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((DefaultDrmSession) arrayList.get(i3)).g((DrmSessionEventListener.EventDispatcher) null);
                }
            }
            D();
            B();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        Assertions.f(uuid);
        Assertions.b(!C.f3931b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f6173b = uuid;
        this.f6174c = provider;
        this.f6175d = mediaDrmCallback;
        this.f6176e = hashMap;
        this.f6177f = z2;
        this.f6178g = iArr;
        this.f6179h = z3;
        this.f6181j = loadErrorHandlingPolicy;
        this.f6180i = new ProvisioningManagerImpl();
        this.f6182k = new ReferenceCountListenerImpl();
        this.f6193v = 0;
        this.f6184m = new ArrayList();
        this.f6185n = Sets.h();
        this.f6186o = Sets.h();
        this.f6183l = j2;
    }
}
