package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
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

    /* renamed from: c  reason: collision with root package name */
    private final UUID f24029c;

    /* renamed from: d  reason: collision with root package name */
    private final ExoMediaDrm.Provider f24030d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaDrmCallback f24031e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f24032f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f24033g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f24034h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f24035i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ProvisioningManagerImpl f24036j;

    /* renamed from: k  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f24037k;

    /* renamed from: l  reason: collision with root package name */
    private final ReferenceCountListenerImpl f24038l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final long f24039m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final List<DefaultDrmSession> f24040n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Set<PreacquiredSessionReference> f24041o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final Set<DefaultDrmSession> f24042p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f24043q;

    /* renamed from: r  reason: collision with root package name */
    private ExoMediaDrm f24044r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public DefaultDrmSession f24045s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public DefaultDrmSession f24046t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public Looper f24047u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public Handler f24048v;

    /* renamed from: w  reason: collision with root package name */
    private int f24049w;

    /* renamed from: x  reason: collision with root package name */
    private byte[] f24050x;

    /* renamed from: y  reason: collision with root package name */
    private PlayerId f24051y;

    /* renamed from: z  reason: collision with root package name */
    volatile MediaDrmHandler f24052z;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, String> f24053a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private UUID f24054b = C.f22819d;

        /* renamed from: c  reason: collision with root package name */
        private ExoMediaDrm.Provider f24055c = FrameworkMediaDrm.f24103d;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24056d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f24057e = new int[0];

        /* renamed from: f  reason: collision with root package name */
        private boolean f24058f;

        /* renamed from: g  reason: collision with root package name */
        private LoadErrorHandlingPolicy f24059g = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: h  reason: collision with root package name */
        private long f24060h = 300000;

        public DefaultDrmSessionManager a(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f24054b, this.f24055c, mediaDrmCallback, this.f24053a, this.f24056d, this.f24057e, this.f24058f, this.f24059g, this.f24060h);
        }

        public Builder b(boolean z2) {
            this.f24056d = z2;
            return this;
        }

        public Builder c(boolean z2) {
            this.f24058f = z2;
            return this;
        }

        public Builder d(int... iArr) {
            for (int i2 : iArr) {
                boolean z2 = true;
                if (!(i2 == 2 || i2 == 1)) {
                    z2 = false;
                }
                Assertions.a(z2);
            }
            this.f24057e = (int[]) iArr.clone();
            return this;
        }

        public Builder e(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f24054b = (UUID) Assertions.e(uuid);
            this.f24055c = (ExoMediaDrm.Provider) Assertions.e(provider);
            return this;
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        public void a(ExoMediaDrm exoMediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
            ((MediaDrmHandler) Assertions.e(DefaultDrmSessionManager.this.f24052z)).obtainMessage(i2, bArr).sendToTarget();
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
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f24040n) {
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
        private final DrmSessionEventListener.EventDispatcher f24063b;

        /* renamed from: c  reason: collision with root package name */
        private DrmSession f24064c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24065d;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.f24063b = eventDispatcher;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Format format) {
            if (DefaultDrmSessionManager.this.f24043q != 0 && !this.f24065d) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                this.f24064c = defaultDrmSessionManager.s((Looper) Assertions.e(defaultDrmSessionManager.f24047u), this.f24063b, format, false);
                DefaultDrmSessionManager.this.f24041o.add(this);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (!this.f24065d) {
                DrmSession drmSession = this.f24064c;
                if (drmSession != null) {
                    drmSession.g(this.f24063b);
                }
                DefaultDrmSessionManager.this.f24041o.remove(this);
                this.f24065d = true;
            }
        }

        public void c(Format format) {
            ((Handler) Assertions.e(DefaultDrmSessionManager.this.f24048v)).post(new g(this, format));
        }

        public void release() {
            Util.O0((Handler) Assertions.e(DefaultDrmSessionManager.this.f24048v), new f(this));
        }
    }

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {

        /* renamed from: a  reason: collision with root package name */
        private final Set<DefaultDrmSession> f24067a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private DefaultDrmSession f24068b;

        public ProvisioningManagerImpl(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        public void a(Exception exc, boolean z2) {
            this.f24068b = null;
            ImmutableList<DefaultDrmSession> n2 = ImmutableList.n(this.f24067a);
            this.f24067a.clear();
            UnmodifiableIterator<DefaultDrmSession> h2 = n2.iterator();
            while (h2.hasNext()) {
                h2.next().C(exc, z2);
            }
        }

        public void b() {
            this.f24068b = null;
            ImmutableList<DefaultDrmSession> n2 = ImmutableList.n(this.f24067a);
            this.f24067a.clear();
            UnmodifiableIterator<DefaultDrmSession> h2 = n2.iterator();
            while (h2.hasNext()) {
                h2.next().B();
            }
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f24067a.add(defaultDrmSession);
            if (this.f24068b == null) {
                this.f24068b = defaultDrmSession;
                defaultDrmSession.G();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.f24067a.remove(defaultDrmSession);
            if (this.f24068b == defaultDrmSession) {
                this.f24068b = null;
                if (!this.f24067a.isEmpty()) {
                    DefaultDrmSession next = this.f24067a.iterator().next();
                    this.f24068b = next;
                    next.G();
                }
            }
        }
    }

    private class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        private ReferenceCountListenerImpl() {
        }

        public void a(DefaultDrmSession defaultDrmSession, int i2) {
            if (DefaultDrmSessionManager.this.f24039m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f24042p.remove(defaultDrmSession);
                ((Handler) Assertions.e(DefaultDrmSessionManager.this.f24048v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        public void b(DefaultDrmSession defaultDrmSession, int i2) {
            if (i2 == 1 && DefaultDrmSessionManager.this.f24043q > 0 && DefaultDrmSessionManager.this.f24039m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f24042p.add(defaultDrmSession);
                ((Handler) Assertions.e(DefaultDrmSessionManager.this.f24048v)).postAtTime(new h(defaultDrmSession), defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f24039m);
            } else if (i2 == 0) {
                DefaultDrmSessionManager.this.f24040n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f24045s == defaultDrmSession) {
                    DefaultDrmSession unused = DefaultDrmSessionManager.this.f24045s = null;
                }
                if (DefaultDrmSessionManager.this.f24046t == defaultDrmSession) {
                    DefaultDrmSession unused2 = DefaultDrmSessionManager.this.f24046t = null;
                }
                DefaultDrmSessionManager.this.f24036j.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f24039m != -9223372036854775807L) {
                    ((Handler) Assertions.e(DefaultDrmSessionManager.this.f24048v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f24042p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    private void A(Looper looper) {
        if (this.f24052z == null) {
            this.f24052z = new MediaDrmHandler(looper);
        }
    }

    /* access modifiers changed from: private */
    public void B() {
        if (this.f24044r != null && this.f24043q == 0 && this.f24040n.isEmpty() && this.f24041o.isEmpty()) {
            ((ExoMediaDrm) Assertions.e(this.f24044r)).release();
            this.f24044r = null;
        }
    }

    private void C() {
        UnmodifiableIterator<DefaultDrmSession> h2 = ImmutableSet.m(this.f24042p).iterator();
        while (h2.hasNext()) {
            h2.next().g((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void D() {
        UnmodifiableIterator<PreacquiredSessionReference> h2 = ImmutableSet.m(this.f24041o).iterator();
        while (h2.hasNext()) {
            h2.next().release();
        }
    }

    private void F(DrmSession drmSession, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.g(eventDispatcher);
        if (this.f24039m != -9223372036854775807L) {
            drmSession.g((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void G(boolean z2) {
        if (z2 && this.f24047u == null) {
            Log.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
        } else if (Thread.currentThread() != ((Looper) Assertions.e(this.f24047u)).getThread()) {
            Log.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f24047u.getThread().getName(), new IllegalStateException());
        }
    }

    /* access modifiers changed from: private */
    public DrmSession s(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z2) {
        List<DrmInitData.SchemeData> list;
        A(looper);
        DrmInitData drmInitData = format.f23074p;
        if (drmInitData == null) {
            return z(MimeTypes.k(format.f23071m), z2);
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.f24050x == null) {
            list = x((DrmInitData) Assertions.e(drmInitData), this.f24029c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f24029c);
                Log.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.l(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE));
            }
        } else {
            list = null;
        }
        if (this.f24033g) {
            Iterator<DefaultDrmSession> it2 = this.f24040n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it2.next();
                if (Util.c(next.f23996a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f24046t;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = w(list, false, eventDispatcher, z2);
            if (!this.f24033g) {
                this.f24046t = defaultDrmSession;
            }
            this.f24040n.add(defaultDrmSession);
        } else {
            defaultDrmSession.f(eventDispatcher);
        }
        return defaultDrmSession;
    }

    private static boolean t(DrmSession drmSession) {
        if (drmSession.getState() != 1 || (Util.f28808a >= 19 && !(((DrmSession.DrmSessionException) Assertions.e(drmSession.getError())).getCause() instanceof ResourceBusyException))) {
            return false;
        }
        return true;
    }

    private boolean u(DrmInitData drmInitData) {
        if (this.f24050x != null) {
            return true;
        }
        if (x(drmInitData, this.f24029c, true).isEmpty()) {
            if (drmInitData.f24078e != 1 || !drmInitData.f(0).e(C.f22817b)) {
                return false;
            }
            Log.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f24029c);
        }
        String str = drmInitData.f24077d;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            if (Util.f28808a >= 25) {
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
        Assertions.e(this.f24044r);
        List<DrmInitData.SchemeData> list2 = list;
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f24029c, this.f24044r, this.f24036j, this.f24038l, list2, this.f24049w, this.f24035i | z2, z2, this.f24050x, this.f24032f, this.f24031e, (Looper) Assertions.e(this.f24047u), this.f24037k, (PlayerId) Assertions.e(this.f24051y));
        defaultDrmSession.f(eventDispatcher);
        if (this.f24039m != -9223372036854775807L) {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession w(List<DrmInitData.SchemeData> list, boolean z2, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z3) {
        DefaultDrmSession v2 = v(list, z2, eventDispatcher);
        if (t(v2) && !this.f24042p.isEmpty()) {
            C();
            F(v2, eventDispatcher);
            v2 = v(list, z2, eventDispatcher);
        }
        if (!t(v2) || !z3 || this.f24041o.isEmpty()) {
            return v2;
        }
        D();
        if (!this.f24042p.isEmpty()) {
            C();
        }
        F(v2, eventDispatcher);
        return v(list, z2, eventDispatcher);
    }

    private static List<DrmInitData.SchemeData> x(DrmInitData drmInitData, UUID uuid, boolean z2) {
        boolean z3;
        ArrayList arrayList = new ArrayList(drmInitData.f24078e);
        for (int i2 = 0; i2 < drmInitData.f24078e; i2++) {
            DrmInitData.SchemeData f2 = drmInitData.f(i2);
            if (f2.e(uuid) || (C.f22818c.equals(uuid) && f2.e(C.f22817b))) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && (f2.f24083f != null || z2)) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void y(Looper looper) {
        boolean z2;
        Looper looper2 = this.f24047u;
        if (looper2 == null) {
            this.f24047u = looper;
            this.f24048v = new Handler(looper);
        } else {
            if (looper2 == looper) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            Assertions.e(this.f24048v);
        }
    }

    private DrmSession z(int i2, boolean z2) {
        boolean z3;
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.e(this.f24044r);
        if (exoMediaDrm.f() != 2 || !FrameworkCryptoConfig.f24099d) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || Util.C0(this.f24034h, i2) == -1 || exoMediaDrm.f() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f24045s;
        if (defaultDrmSession == null) {
            DefaultDrmSession w2 = w(ImmutableList.r(), true, (DrmSessionEventListener.EventDispatcher) null, z2);
            this.f24040n.add(w2);
            this.f24045s = w2;
        } else {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return this.f24045s;
    }

    public void E(int i2, byte[] bArr) {
        Assertions.g(this.f24040n.isEmpty());
        if (i2 == 1 || i2 == 3) {
            Assertions.e(bArr);
        }
        this.f24049w = i2;
        this.f24050x = bArr;
    }

    public int a(Format format) {
        G(false);
        int f2 = ((ExoMediaDrm) Assertions.e(this.f24044r)).f();
        DrmInitData drmInitData = format.f23074p;
        if (drmInitData == null) {
            if (Util.C0(this.f24034h, MimeTypes.k(format.f23071m)) != -1) {
                return f2;
            }
            return 0;
        } else if (u(drmInitData)) {
            return f2;
        } else {
            return 1;
        }
    }

    public void b(Looper looper, PlayerId playerId) {
        y(looper);
        this.f24051y = playerId;
    }

    public DrmSession c(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z2 = false;
        G(false);
        if (this.f24043q > 0) {
            z2 = true;
        }
        Assertions.g(z2);
        Assertions.i(this.f24047u);
        return s(this.f24047u, eventDispatcher, format, true);
    }

    public DrmSessionManager.DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z2;
        if (this.f24043q > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        Assertions.i(this.f24047u);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        preacquiredSessionReference.c(format);
        return preacquiredSessionReference;
    }

    public final void prepare() {
        G(true);
        int i2 = this.f24043q;
        this.f24043q = i2 + 1;
        if (i2 == 0) {
            if (this.f24044r == null) {
                ExoMediaDrm a2 = this.f24030d.a(this.f24029c);
                this.f24044r = a2;
                a2.m(new MediaDrmEventListener());
            } else if (this.f24039m != -9223372036854775807L) {
                for (int i3 = 0; i3 < this.f24040n.size(); i3++) {
                    this.f24040n.get(i3).f((DrmSessionEventListener.EventDispatcher) null);
                }
            }
        }
    }

    public final void release() {
        G(true);
        int i2 = this.f24043q - 1;
        this.f24043q = i2;
        if (i2 == 0) {
            if (this.f24039m != -9223372036854775807L) {
                ArrayList arrayList = new ArrayList(this.f24040n);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((DefaultDrmSession) arrayList.get(i3)).g((DrmSessionEventListener.EventDispatcher) null);
                }
            }
            D();
            B();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        Assertions.e(uuid);
        Assertions.b(!C.f22817b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f24029c = uuid;
        this.f24030d = provider;
        this.f24031e = mediaDrmCallback;
        this.f24032f = hashMap;
        this.f24033g = z2;
        this.f24034h = iArr;
        this.f24035i = z3;
        this.f24037k = loadErrorHandlingPolicy;
        this.f24036j = new ProvisioningManagerImpl(this);
        this.f24038l = new ReferenceCountListenerImpl();
        this.f24049w = 0;
        this.f24040n = new ArrayList();
        this.f24041o = Sets.h();
        this.f24042p = Sets.h();
        this.f24039m = j2;
    }
}
