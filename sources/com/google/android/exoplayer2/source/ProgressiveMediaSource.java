package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {

    /* renamed from: i  reason: collision with root package name */
    private final MediaItem f25882i;

    /* renamed from: j  reason: collision with root package name */
    private final MediaItem.LocalConfiguration f25883j;

    /* renamed from: k  reason: collision with root package name */
    private final DataSource.Factory f25884k;

    /* renamed from: l  reason: collision with root package name */
    private final ProgressiveMediaExtractor.Factory f25885l;

    /* renamed from: m  reason: collision with root package name */
    private final DrmSessionManager f25886m;

    /* renamed from: n  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f25887n;

    /* renamed from: o  reason: collision with root package name */
    private final int f25888o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25889p;

    /* renamed from: q  reason: collision with root package name */
    private long f25890q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f25891r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f25892s;

    /* renamed from: t  reason: collision with root package name */
    private TransferListener f25893t;

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f25894a;

        /* renamed from: b  reason: collision with root package name */
        private ProgressiveMediaExtractor.Factory f25895b;

        /* renamed from: c  reason: collision with root package name */
        private DrmSessionManagerProvider f25896c;

        /* renamed from: d  reason: collision with root package name */
        private LoadErrorHandlingPolicy f25897d;

        /* renamed from: e  reason: collision with root package name */
        private int f25898e;

        /* renamed from: f  reason: collision with root package name */
        private String f25899f;

        /* renamed from: g  reason: collision with root package name */
        private Object f25900g;

        public Factory(DataSource.Factory factory) {
            this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ProgressiveMediaExtractor f(ExtractorsFactory extractorsFactory, PlayerId playerId) {
            return new BundledExtractorsAdapter(extractorsFactory);
        }

        /* renamed from: e */
        public ProgressiveMediaSource a(MediaItem mediaItem) {
            boolean z2;
            Assertions.e(mediaItem.f23129c);
            MediaItem.LocalConfiguration localConfiguration = mediaItem.f23129c;
            boolean z3 = true;
            if (localConfiguration.f23209h != null || this.f25900g == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (localConfiguration.f23206e != null || this.f25899f == null) {
                z3 = false;
            }
            if (z2 && z3) {
                mediaItem = mediaItem.b().h(this.f25900g).b(this.f25899f).a();
            } else if (z2) {
                mediaItem = mediaItem.b().h(this.f25900g).a();
            } else if (z3) {
                mediaItem = mediaItem.b().b(this.f25899f).a();
            }
            MediaItem mediaItem2 = mediaItem;
            return new ProgressiveMediaSource(mediaItem2, this.f25894a, this.f25895b, this.f25896c.a(mediaItem2), this.f25897d, this.f25898e);
        }

        /* renamed from: g */
        public Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f25896c = (DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: h */
        public Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f25897d = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
            this(factory, (ProgressiveMediaExtractor.Factory) new s(extractorsFactory));
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2) {
            this(factory, factory2, new DefaultDrmSessionManagerProvider(), new DefaultLoadErrorHandlingPolicy(), 1048576);
        }

        public Factory(DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManagerProvider drmSessionManagerProvider, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
            this.f25894a = factory;
            this.f25895b = factory2;
            this.f25896c = drmSessionManagerProvider;
            this.f25897d = loadErrorHandlingPolicy;
            this.f25898e = i2;
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.ProgressiveMediaSource$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void F() {
        /*
            r9 = this;
            com.google.android.exoplayer2.source.SinglePeriodTimeline r8 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            long r1 = r9.f25890q
            boolean r3 = r9.f25891r
            r4 = 0
            boolean r5 = r9.f25892s
            r6 = 0
            com.google.android.exoplayer2.MediaItem r7 = r9.f25882i
            r0 = r8
            r0.<init>(r1, r3, r4, r5, r6, r7)
            boolean r0 = r9.f25889p
            if (r0 == 0) goto L_0x001a
            com.google.android.exoplayer2.source.ProgressiveMediaSource$1 r0 = new com.google.android.exoplayer2.source.ProgressiveMediaSource$1
            r0.<init>(r9, r8)
            r8 = r0
        L_0x001a:
            r9.D(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ProgressiveMediaSource.F():void");
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.f25893t = transferListener;
        this.f25886m.b((Looper) Assertions.e(Looper.myLooper()), A());
        this.f25886m.prepare();
        F();
    }

    /* access modifiers changed from: protected */
    public void E() {
        this.f25886m.release();
    }

    public MediaItem a() {
        return this.f25882i;
    }

    public void b(long j2, boolean z2, boolean z3) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f25890q;
        }
        if (this.f25889p || this.f25890q != j2 || this.f25891r != z2 || this.f25892s != z3) {
            this.f25890q = j2;
            this.f25891r = z2;
            this.f25892s = z3;
            this.f25889p = false;
            F();
        }
    }

    public void c() {
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        DataSource a2 = this.f25884k.a();
        TransferListener transferListener = this.f25893t;
        if (transferListener != null) {
            a2.p(transferListener);
        }
        return new ProgressiveMediaPeriod(this.f25883j.f23202a, a2, this.f25885l.a(A()), this.f25886m, u(mediaPeriodId), this.f25887n, w(mediaPeriodId), this, allocator, this.f25883j.f23206e, this.f25888o);
    }

    public void l(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).f0();
    }

    private ProgressiveMediaSource(MediaItem mediaItem, DataSource.Factory factory, ProgressiveMediaExtractor.Factory factory2, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i2) {
        this.f25883j = (MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c);
        this.f25882i = mediaItem;
        this.f25884k = factory;
        this.f25885l = factory2;
        this.f25886m = drmSessionManager;
        this.f25887n = loadErrorHandlingPolicy;
        this.f25888o = i2;
        this.f25889p = true;
        this.f25890q = -9223372036854775807L;
    }
}
