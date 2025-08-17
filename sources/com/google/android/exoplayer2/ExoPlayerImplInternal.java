package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    /* access modifiers changed from: private */
    public boolean I;
    private boolean J;
    private int K;
    private SeekPosition L;
    private long M;
    private int N;
    private boolean O;
    private ExoPlaybackException P;
    private long Q;
    private long R = -9223372036854775807L;

    /* renamed from: b  reason: collision with root package name */
    private final Renderer[] f22985b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Renderer> f22986c;

    /* renamed from: d  reason: collision with root package name */
    private final RendererCapabilities[] f22987d;

    /* renamed from: e  reason: collision with root package name */
    private final TrackSelector f22988e;

    /* renamed from: f  reason: collision with root package name */
    private final TrackSelectorResult f22989f;

    /* renamed from: g  reason: collision with root package name */
    private final LoadControl f22990g;

    /* renamed from: h  reason: collision with root package name */
    private final BandwidthMeter f22991h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final HandlerWrapper f22992i;

    /* renamed from: j  reason: collision with root package name */
    private final HandlerThread f22993j;

    /* renamed from: k  reason: collision with root package name */
    private final Looper f22994k;

    /* renamed from: l  reason: collision with root package name */
    private final Timeline.Window f22995l;

    /* renamed from: m  reason: collision with root package name */
    private final Timeline.Period f22996m;

    /* renamed from: n  reason: collision with root package name */
    private final long f22997n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f22998o;

    /* renamed from: p  reason: collision with root package name */
    private final DefaultMediaClock f22999p;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<PendingMessageInfo> f23000q;

    /* renamed from: r  reason: collision with root package name */
    private final Clock f23001r;

    /* renamed from: s  reason: collision with root package name */
    private final PlaybackInfoUpdateListener f23002s;

    /* renamed from: t  reason: collision with root package name */
    private final MediaPeriodQueue f23003t;

    /* renamed from: u  reason: collision with root package name */
    private final MediaSourceList f23004u;

    /* renamed from: v  reason: collision with root package name */
    private final LivePlaybackSpeedControl f23005v;

    /* renamed from: w  reason: collision with root package name */
    private final long f23006w;

    /* renamed from: x  reason: collision with root package name */
    private SeekParameters f23007x;

    /* renamed from: y  reason: collision with root package name */
    private PlaybackInfo f23008y;

    /* renamed from: z  reason: collision with root package name */
    private PlaybackInfoUpdate f23009z;

    private static final class MediaSourceListUpdateMessage {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<MediaSourceList.MediaSourceHolder> f23011a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ShuffleOrder f23012b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f23013c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f23014d;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i2, long j2) {
            this.f23011a = list;
            this.f23012b = shuffleOrder;
            this.f23013c = i2;
            this.f23014d = j2;
        }
    }

    private static class MoveMediaItemsMessage {

        /* renamed from: a  reason: collision with root package name */
        public final int f23015a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23016b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23017c;

        /* renamed from: d  reason: collision with root package name */
        public final ShuffleOrder f23018d;
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final PlayerMessage f23019b;

        /* renamed from: c  reason: collision with root package name */
        public int f23020c;

        /* renamed from: d  reason: collision with root package name */
        public long f23021d;

        /* renamed from: e  reason: collision with root package name */
        public Object f23022e;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.f23019b = playerMessage;
        }

        /* renamed from: a */
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            boolean z2;
            boolean z3;
            Object obj = this.f23022e;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (pendingMessageInfo.f23022e == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (obj != null) {
                    return -1;
                }
                return 1;
            } else if (obj == null) {
                return 0;
            } else {
                int i2 = this.f23020c - pendingMessageInfo.f23020c;
                if (i2 != 0) {
                    return i2;
                }
                return Util.o(this.f23021d, pendingMessageInfo.f23021d);
            }
        }

        public void b(int i2, long j2, Object obj) {
            this.f23020c = i2;
            this.f23021d = j2;
            this.f23022e = obj;
        }
    }

    public static final class PlaybackInfoUpdate {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f23023a;

        /* renamed from: b  reason: collision with root package name */
        public PlaybackInfo f23024b;

        /* renamed from: c  reason: collision with root package name */
        public int f23025c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23026d;

        /* renamed from: e  reason: collision with root package name */
        public int f23027e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f23028f;

        /* renamed from: g  reason: collision with root package name */
        public int f23029g;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.f23024b = playbackInfo;
        }

        public void b(int i2) {
            boolean z2;
            boolean z3 = this.f23023a;
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f23023a = z3 | z2;
            this.f23025c += i2;
        }

        public void c(int i2) {
            this.f23023a = true;
            this.f23028f = true;
            this.f23029g = i2;
        }

        public void d(PlaybackInfo playbackInfo) {
            boolean z2;
            boolean z3 = this.f23023a;
            if (this.f23024b != playbackInfo) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f23023a = z3 | z2;
            this.f23024b = playbackInfo;
        }

        public void e(int i2) {
            boolean z2 = true;
            if (!this.f23026d || this.f23027e == 5) {
                this.f23023a = true;
                this.f23026d = true;
                this.f23027e = i2;
                return;
            }
            if (i2 != 5) {
                z2 = false;
            }
            Assertions.a(z2);
        }
    }

    public interface PlaybackInfoUpdateListener {
        void a(PlaybackInfoUpdate playbackInfoUpdate);
    }

    private static final class PositionUpdateForPlaylistChange {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f23030a;

        /* renamed from: b  reason: collision with root package name */
        public final long f23031b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23032c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23033d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f23034e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f23035f;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, boolean z2, boolean z3, boolean z4) {
            this.f23030a = mediaPeriodId;
            this.f23031b = j2;
            this.f23032c = j3;
            this.f23033d = z2;
            this.f23034e = z3;
            this.f23035f = z4;
        }
    }

    private static final class SeekPosition {

        /* renamed from: a  reason: collision with root package name */
        public final Timeline f23036a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23037b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23038c;

        public SeekPosition(Timeline timeline, int i2, long j2) {
            this.f23036a = timeline;
            this.f23037b = i2;
            this.f23038c = j2;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i2, boolean z2, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j2, boolean z3, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2) {
        Renderer[] rendererArr2 = rendererArr;
        BandwidthMeter bandwidthMeter2 = bandwidthMeter;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long j3 = j2;
        Clock clock2 = clock;
        PlayerId playerId2 = playerId;
        Looper looper3 = looper2;
        this.f23002s = playbackInfoUpdateListener;
        this.f22985b = rendererArr2;
        this.f22988e = trackSelector;
        this.f22989f = trackSelectorResult;
        this.f22990g = loadControl;
        this.f22991h = bandwidthMeter2;
        this.F = i2;
        this.G = z2;
        this.f23007x = seekParameters;
        this.f23005v = livePlaybackSpeedControl;
        this.f23006w = j3;
        this.Q = j3;
        this.B = z3;
        this.f23001r = clock2;
        this.f22997n = loadControl.d();
        this.f22998o = loadControl.c();
        PlaybackInfo j4 = PlaybackInfo.j(trackSelectorResult);
        this.f23008y = j4;
        this.f23009z = new PlaybackInfoUpdate(j4);
        this.f22987d = new RendererCapabilities[rendererArr2.length];
        for (int i3 = 0; i3 < rendererArr2.length; i3++) {
            rendererArr2[i3].h(i3, playerId2);
            this.f22987d[i3] = rendererArr2[i3].m();
        }
        this.f22999p = new DefaultMediaClock(this, clock2);
        this.f23000q = new ArrayList<>();
        this.f22986c = Sets.h();
        this.f22995l = new Timeline.Window();
        this.f22996m = new Timeline.Period();
        trackSelector.c(this, bandwidthMeter2);
        this.O = true;
        HandlerWrapper b2 = clock2.b(looper, (Handler.Callback) null);
        this.f23003t = new MediaPeriodQueue(analyticsCollector2, b2);
        this.f23004u = new MediaSourceList(this, analyticsCollector2, b2, playerId2);
        if (looper3 != null) {
            this.f22993j = null;
            this.f22994k = looper3;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.f22993j = handlerThread;
            handlerThread.start();
            this.f22994k = handlerThread.getLooper();
        }
        this.f22992i = clock2.b(this.f22994k, this);
    }

    private long A() {
        MediaPeriodHolder q2 = this.f23003t.q();
        if (q2 == null) {
            return 0;
        }
        long l2 = q2.l();
        if (!q2.f23307d) {
            return l2;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f22985b;
            if (i2 >= rendererArr.length) {
                return l2;
            }
            if (R(rendererArr[i2]) && this.f22985b[i2].getStream() == q2.f23306c[i2]) {
                long q3 = this.f22985b[i2].q();
                if (q3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l2 = Math.max(q3, l2);
            }
            i2++;
        }
    }

    private void A0(long j2, long j3) {
        this.f22992i.i(2, j2 + j3);
    }

    private Pair<MediaSource.MediaPeriodId, Long> B(Timeline timeline) {
        long j2 = 0;
        if (timeline.u()) {
            return Pair.create(PlaybackInfo.k(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> n2 = timeline2.n(this.f22995l, this.f22996m, timeline.e(this.G), -9223372036854775807L);
        MediaSource.MediaPeriodId B2 = this.f23003t.B(timeline, n2.first, 0);
        long longValue = ((Long) n2.second).longValue();
        if (B2.b()) {
            timeline.l(B2.f25793a, this.f22996m);
            if (B2.f25795c == this.f22996m.n(B2.f25794b)) {
                j2 = this.f22996m.j();
            }
            longValue = j2;
        }
        return Pair.create(B2, Long.valueOf(longValue));
    }

    private void C0(boolean z2) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.f23003t.p().f23309f.f23319a;
        long F0 = F0(mediaPeriodId, this.f23008y.f23394r, true, false);
        if (F0 != this.f23008y.f23394r) {
            PlaybackInfo playbackInfo = this.f23008y;
            this.f23008y = M(mediaPeriodId, F0, playbackInfo.f23379c, playbackInfo.f23380d, z2, 5);
        }
    }

    private long D() {
        return E(this.f23008y.f23392p);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[Catch:{ all -> 0x0146 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void D0(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r20) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r1 = r11.f23009z
            r8 = 1
            r1.b(r8)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.Timeline r1 = r1.f23377a
            r3 = 1
            int r4 = r11.F
            boolean r5 = r11.G
            com.google.android.exoplayer2.Timeline$Window r6 = r11.f22995l
            com.google.android.exoplayer2.Timeline$Period r7 = r11.f22996m
            r2 = r20
            android.util.Pair r1 = y0(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004b
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.f23008y
            com.google.android.exoplayer2.Timeline r7 = r7.f23377a
            android.util.Pair r7 = r11.B(r7)
            java.lang.Object r9 = r7.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.f23008y
            com.google.android.exoplayer2.Timeline r7 = r7.f23377a
            boolean r7 = r7.u()
            r7 = r7 ^ r8
            r10 = r7
            r17 = r4
        L_0x0047:
            r4 = r12
            r12 = r17
            goto L_0x00a1
        L_0x004b:
            java.lang.Object r7 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.f23038c
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005d
            r9 = r4
            goto L_0x005e
        L_0x005d:
            r9 = r12
        L_0x005e:
            com.google.android.exoplayer2.MediaPeriodQueue r14 = r11.f23003t
            com.google.android.exoplayer2.PlaybackInfo r15 = r11.f23008y
            com.google.android.exoplayer2.Timeline r15 = r15.f23377a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r14.B(r15, r7, r12)
            boolean r14 = r7.b()
            if (r14 == 0) goto L_0x0093
            com.google.android.exoplayer2.PlaybackInfo r4 = r11.f23008y
            com.google.android.exoplayer2.Timeline r4 = r4.f23377a
            java.lang.Object r5 = r7.f25793a
            com.google.android.exoplayer2.Timeline$Period r12 = r11.f22996m
            r4.l(r5, r12)
            com.google.android.exoplayer2.Timeline$Period r4 = r11.f22996m
            int r5 = r7.f25794b
            int r4 = r4.n(r5)
            int r5 = r7.f25795c
            if (r4 != r5) goto L_0x008d
            com.google.android.exoplayer2.Timeline$Period r4 = r11.f22996m
            long r4 = r4.j()
            r12 = r4
            goto L_0x008e
        L_0x008d:
            r12 = r2
        L_0x008e:
            r4 = r12
            r12 = r9
            r10 = 1
            r9 = r7
            goto L_0x00a1
        L_0x0093:
            long r14 = r0.f23038c
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x009b
            r4 = 1
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            r17 = r9
            r10 = r4
            r9 = r7
            goto L_0x0047
        L_0x00a1:
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.f23008y     // Catch:{ all -> 0x0146 }
            com.google.android.exoplayer2.Timeline r7 = r7.f23377a     // Catch:{ all -> 0x0146 }
            boolean r7 = r7.u()     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00ae
            r11.L = r0     // Catch:{ all -> 0x0146 }
            goto L_0x00bd
        L_0x00ae:
            r0 = 4
            if (r1 != 0) goto L_0x00c0
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y     // Catch:{ all -> 0x0146 }
            int r1 = r1.f23381e     // Catch:{ all -> 0x0146 }
            if (r1 == r8) goto L_0x00ba
            r11.b1(r0)     // Catch:{ all -> 0x0146 }
        L_0x00ba:
            r11.r0(r6, r8, r6, r8)     // Catch:{ all -> 0x0146 }
        L_0x00bd:
            r7 = r4
            goto L_0x0134
        L_0x00c0:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y     // Catch:{ all -> 0x0146 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.f23378b     // Catch:{ all -> 0x0146 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x010f
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.f23003t     // Catch:{ all -> 0x0146 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.p()     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x00e3
            boolean r7 = r1.f23307d     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00e3
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00e3
            com.google.android.exoplayer2.source.MediaPeriod r1 = r1.f23304a     // Catch:{ all -> 0x0146 }
            com.google.android.exoplayer2.SeekParameters r2 = r11.f23007x     // Catch:{ all -> 0x0146 }
            long r1 = r1.g(r4, r2)     // Catch:{ all -> 0x0146 }
            goto L_0x00e4
        L_0x00e3:
            r1 = r4
        L_0x00e4:
            long r14 = com.google.android.exoplayer2.util.Util.i1(r1)     // Catch:{ all -> 0x0146 }
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.f23008y     // Catch:{ all -> 0x0146 }
            long r6 = r3.f23394r     // Catch:{ all -> 0x0146 }
            long r6 = com.google.android.exoplayer2.util.Util.i1(r6)     // Catch:{ all -> 0x0146 }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0110
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.f23008y     // Catch:{ all -> 0x0146 }
            int r6 = r3.f23381e     // Catch:{ all -> 0x0146 }
            r7 = 2
            if (r6 == r7) goto L_0x00fe
            r7 = 3
            if (r6 != r7) goto L_0x0110
        L_0x00fe:
            long r7 = r3.f23394r     // Catch:{ all -> 0x0146 }
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.M(r2, r3, r5, r7, r9, r10)
            r11.f23008y = r0
            return
        L_0x010f:
            r1 = r4
        L_0x0110:
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.f23008y     // Catch:{ all -> 0x0146 }
            int r3 = r3.f23381e     // Catch:{ all -> 0x0146 }
            if (r3 != r0) goto L_0x0118
            r0 = 1
            goto L_0x0119
        L_0x0118:
            r0 = 0
        L_0x0119:
            long r14 = r11.E0(r9, r1, r0)     // Catch:{ all -> 0x0146 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            r8 = 0
        L_0x0123:
            r10 = r10 | r8
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y     // Catch:{ all -> 0x0143 }
            com.google.android.exoplayer2.Timeline r4 = r0.f23377a     // Catch:{ all -> 0x0143 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.f23378b     // Catch:{ all -> 0x0143 }
            r8 = 1
            r1 = r19
            r2 = r4
            r3 = r9
            r6 = r12
            r1.p1(r2, r3, r4, r5, r6, r8)     // Catch:{ all -> 0x0143 }
            r7 = r14
        L_0x0134:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.M(r2, r3, r5, r7, r9, r10)
            r11.f23008y = r0
            return
        L_0x0143:
            r0 = move-exception
            r7 = r14
            goto L_0x0148
        L_0x0146:
            r0 = move-exception
            r7 = r4
        L_0x0148:
            r14 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r14
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.M(r2, r3, r5, r7, r9, r10)
            r11.f23008y = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.D0(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long E(long j2) {
        MediaPeriodHolder j3 = this.f23003t.j();
        if (j3 == null) {
            return 0;
        }
        return Math.max(0, j2 - j3.y(this.M));
    }

    private long E0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2) throws ExoPlaybackException {
        boolean z3;
        if (this.f23003t.p() != this.f23003t.q()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return F0(mediaPeriodId, j2, z3, z2);
    }

    private void F(MediaPeriod mediaPeriod) {
        if (this.f23003t.v(mediaPeriod)) {
            this.f23003t.y(this.M);
            W();
        }
    }

    private long F0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2, boolean z3) throws ExoPlaybackException {
        k1();
        this.D = false;
        if (z3 || this.f23008y.f23381e == 3) {
            b1(2);
        }
        MediaPeriodHolder p2 = this.f23003t.p();
        MediaPeriodHolder mediaPeriodHolder = p2;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.f23309f.f23319a)) {
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        if (z2 || p2 != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.z(j2) < 0)) {
            for (Renderer o2 : this.f22985b) {
                o(o2);
            }
            if (mediaPeriodHolder != null) {
                while (this.f23003t.p() != mediaPeriodHolder) {
                    this.f23003t.b();
                }
                this.f23003t.z(mediaPeriodHolder);
                mediaPeriodHolder.x(1000000000000L);
                s();
            }
        }
        if (mediaPeriodHolder != null) {
            this.f23003t.z(mediaPeriodHolder);
            if (!mediaPeriodHolder.f23307d) {
                mediaPeriodHolder.f23309f = mediaPeriodHolder.f23309f.b(j2);
            } else if (mediaPeriodHolder.f23308e) {
                long i2 = mediaPeriodHolder.f23304a.i(j2);
                mediaPeriodHolder.f23304a.o(i2 - this.f22997n, this.f22998o);
                j2 = i2;
            }
            t0(j2);
            W();
        } else {
            this.f23003t.f();
            t0(j2);
        }
        H(false);
        this.f22992i.h(2);
        return j2;
    }

    private void G(IOException iOException, int i2) {
        ExoPlaybackException g2 = ExoPlaybackException.g(iOException, i2);
        MediaPeriodHolder p2 = this.f23003t.p();
        if (p2 != null) {
            g2 = g2.e(p2.f23309f.f23319a);
        }
        Log.d("ExoPlayerImplInternal", "Playback error", g2);
        j1(false, false);
        this.f23008y = this.f23008y.e(g2);
    }

    private void G0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.f() == -9223372036854775807L) {
            H0(playerMessage);
        } else if (this.f23008y.f23377a.u()) {
            this.f23000q.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            Timeline timeline = this.f23008y.f23377a;
            if (v0(pendingMessageInfo, timeline, timeline, this.F, this.G, this.f22995l, this.f22996m)) {
                this.f23000q.add(pendingMessageInfo);
                Collections.sort(this.f23000q);
                return;
            }
            playerMessage.k(false);
        }
    }

    private void H(boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId;
        long j2;
        MediaPeriodHolder j3 = this.f23003t.j();
        if (j3 == null) {
            mediaPeriodId = this.f23008y.f23378b;
        } else {
            mediaPeriodId = j3.f23309f.f23319a;
        }
        boolean z3 = !this.f23008y.f23387k.equals(mediaPeriodId);
        if (z3) {
            this.f23008y = this.f23008y.b(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.f23008y;
        if (j3 == null) {
            j2 = playbackInfo.f23394r;
        } else {
            j2 = j3.i();
        }
        playbackInfo.f23392p = j2;
        this.f23008y.f23393q = D();
        if ((z3 || z2) && j3 != null && j3.f23307d) {
            m1(j3.n(), j3.o());
        }
    }

    private void H0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.c() == this.f22994k) {
            n(playerMessage);
            int i2 = this.f23008y.f23381e;
            if (i2 == 3 || i2 == 2) {
                this.f22992i.h(2);
                return;
            }
            return;
        }
        this.f22992i.c(15, playerMessage).a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0173 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I(com.google.android.exoplayer2.Timeline r28, boolean r29) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r27 = this;
            r11 = r27
            r12 = r28
            com.google.android.exoplayer2.PlaybackInfo r2 = r11.f23008y
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r3 = r11.L
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r11.f23003t
            int r5 = r11.F
            boolean r6 = r11.G
            com.google.android.exoplayer2.Timeline$Window r7 = r11.f22995l
            com.google.android.exoplayer2.Timeline$Period r8 = r11.f22996m
            r1 = r28
            com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r7 = x0(r1, r2, r3, r4, r5, r6, r7, r8)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = r7.f23030a
            long r13 = r7.f23032c
            boolean r0 = r7.f23033d
            long r5 = r7.f23031b
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.f23378b
            boolean r1 = r1.equals(r9)
            r10 = 1
            r15 = 0
            if (r1 == 0) goto L_0x0038
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            long r1 = r1.f23394r
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r16 = 0
            goto L_0x003a
        L_0x0038:
            r16 = 1
        L_0x003a:
            r17 = 3
            r8 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 4
            boolean r1 = r7.f23034e     // Catch:{ all -> 0x013d }
            if (r1 == 0) goto L_0x0053
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y     // Catch:{ all -> 0x013d }
            int r1 = r1.f23381e     // Catch:{ all -> 0x013d }
            if (r1 == r10) goto L_0x0050
            r11.b1(r4)     // Catch:{ all -> 0x013d }
        L_0x0050:
            r11.r0(r15, r15, r15, r10)     // Catch:{ all -> 0x013d }
        L_0x0053:
            if (r16 != 0) goto L_0x0077
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.f23003t     // Catch:{ all -> 0x0070 }
            long r3 = r11.M     // Catch:{ all -> 0x0070 }
            long r22 = r27.A()     // Catch:{ all -> 0x0070 }
            r2 = r28
            r10 = -1
            r20 = 4
            r25 = r5
            r5 = r22
            boolean r0 = r1.F(r2, r3, r5)     // Catch:{ all -> 0x0138 }
            if (r0 != 0) goto L_0x00b5
            r11.C0(r15)     // Catch:{ all -> 0x0138 }
            goto L_0x00b5
        L_0x0070:
            r0 = move-exception
            r10 = -1
            r20 = 4
        L_0x0074:
            r15 = r8
            goto L_0x0142
        L_0x0077:
            r25 = r5
            r10 = -1
            r20 = 4
            boolean r1 = r28.u()     // Catch:{ all -> 0x0138 }
            if (r1 != 0) goto L_0x00b5
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.f23003t     // Catch:{ all -> 0x00b1 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.p()     // Catch:{ all -> 0x00b1 }
        L_0x0088:
            if (r1 == 0) goto L_0x00a6
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r1.f23309f     // Catch:{ all -> 0x0138 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.f23319a     // Catch:{ all -> 0x0138 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0138 }
            if (r2 == 0) goto L_0x00a1
            com.google.android.exoplayer2.MediaPeriodQueue r2 = r11.f23003t     // Catch:{ all -> 0x0138 }
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r1.f23309f     // Catch:{ all -> 0x0138 }
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r2.r(r12, r3)     // Catch:{ all -> 0x0138 }
            r1.f23309f = r2     // Catch:{ all -> 0x0138 }
            r1.A()     // Catch:{ all -> 0x0138 }
        L_0x00a1:
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.j()     // Catch:{ all -> 0x0138 }
            goto L_0x0088
        L_0x00a6:
            r5 = r25
            long r0 = r11.E0(r9, r5, r0)     // Catch:{ all -> 0x00af }
            r21 = r0
            goto L_0x00b9
        L_0x00af:
            r0 = move-exception
            goto L_0x0074
        L_0x00b1:
            r0 = move-exception
            r5 = r25
            goto L_0x0074
        L_0x00b5:
            r5 = r25
            r21 = r5
        L_0x00b9:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            com.google.android.exoplayer2.Timeline r4 = r0.f23377a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.f23378b
            boolean r0 = r7.f23035f
            if (r0 == 0) goto L_0x00c6
            r6 = r21
            goto L_0x00c8
        L_0x00c6:
            r6 = r18
        L_0x00c8:
            r0 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r15 = r8
            r8 = r0
            r1.p1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x00dd
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            long r0 = r0.f23379c
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0119
        L_0x00dd:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r0.f23378b
            java.lang.Object r1 = r1.f25793a
            com.google.android.exoplayer2.Timeline r0 = r0.f23377a
            if (r16 == 0) goto L_0x00fc
            if (r29 == 0) goto L_0x00fc
            boolean r2 = r0.u()
            if (r2 != 0) goto L_0x00fc
            com.google.android.exoplayer2.Timeline$Period r2 = r11.f22996m
            com.google.android.exoplayer2.Timeline$Period r0 = r0.l(r1, r2)
            boolean r0 = r0.f23497g
            if (r0 != 0) goto L_0x00fc
            r24 = 1
            goto L_0x00fe
        L_0x00fc:
            r24 = 0
        L_0x00fe:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            long r7 = r0.f23380d
            int r0 = r12.f(r1)
            if (r0 != r10) goto L_0x010a
            r10 = 4
            goto L_0x010b
        L_0x010a:
            r10 = 3
        L_0x010b:
            r1 = r27
            r2 = r9
            r3 = r21
            r5 = r13
            r9 = r24
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.M(r2, r3, r5, r7, r9, r10)
            r11.f23008y = r0
        L_0x0119:
            r27.s0()
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            com.google.android.exoplayer2.Timeline r0 = r0.f23377a
            r11.w0(r12, r0)
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.f23008y
            com.google.android.exoplayer2.PlaybackInfo r0 = r0.i(r12)
            r11.f23008y = r0
            boolean r0 = r28.u()
            if (r0 != 0) goto L_0x0133
            r11.L = r15
        L_0x0133:
            r1 = 0
            r11.H(r1)
            return
        L_0x0138:
            r0 = move-exception
            r15 = r8
            r5 = r25
            goto L_0x0142
        L_0x013d:
            r0 = move-exception
            r15 = r8
            r10 = -1
            r20 = 4
        L_0x0142:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.Timeline r4 = r1.f23377a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r8 = r1.f23378b
            boolean r1 = r7.f23035f
            if (r1 == 0) goto L_0x014e
            r18 = r5
        L_0x014e:
            r21 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r25 = r5
            r5 = r8
            r6 = r18
            r8 = r21
            r1.p1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x0169
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            long r1 = r1.f23379c
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x01a5
        L_0x0169:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r1.f23378b
            java.lang.Object r2 = r2.f25793a
            com.google.android.exoplayer2.Timeline r1 = r1.f23377a
            if (r16 == 0) goto L_0x0188
            if (r29 == 0) goto L_0x0188
            boolean r3 = r1.u()
            if (r3 != 0) goto L_0x0188
            com.google.android.exoplayer2.Timeline$Period r3 = r11.f22996m
            com.google.android.exoplayer2.Timeline$Period r1 = r1.l(r2, r3)
            boolean r1 = r1.f23497g
            if (r1 != 0) goto L_0x0188
            r24 = 1
            goto L_0x018a
        L_0x0188:
            r24 = 0
        L_0x018a:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            long r7 = r1.f23380d
            int r1 = r12.f(r2)
            if (r1 != r10) goto L_0x0196
            r10 = 4
            goto L_0x0197
        L_0x0196:
            r10 = 3
        L_0x0197:
            r1 = r27
            r2 = r9
            r3 = r25
            r5 = r13
            r9 = r24
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.M(r2, r3, r5, r7, r9, r10)
            r11.f23008y = r1
        L_0x01a5:
            r27.s0()
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.Timeline r1 = r1.f23377a
            r11.w0(r12, r1)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.f23008y
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.i(r12)
            r11.f23008y = r1
            boolean r1 = r28.u()
            if (r1 != 0) goto L_0x01bf
            r11.L = r15
        L_0x01bf:
            r1 = 0
            r11.H(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.I(com.google.android.exoplayer2.Timeline, boolean):void");
    }

    private void I0(PlayerMessage playerMessage) {
        Looper c2 = playerMessage.c();
        if (!c2.getThread().isAlive()) {
            Log.i("TAG", "Trying to send message on a dead thread.");
            playerMessage.k(false);
            return;
        }
        this.f23001r.b(c2, (Handler.Callback) null).g(new x0(this, playerMessage));
    }

    private void J(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.f23003t.v(mediaPeriod)) {
            MediaPeriodHolder j2 = this.f23003t.j();
            j2.p(this.f22999p.b().f23399b, this.f23008y.f23377a);
            m1(j2.n(), j2.o());
            if (j2 == this.f23003t.p()) {
                t0(j2.f23309f.f23320b);
                s();
                PlaybackInfo playbackInfo = this.f23008y;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f23378b;
                long j3 = j2.f23309f.f23320b;
                this.f23008y = M(mediaPeriodId, j3, playbackInfo.f23379c, j3, false, 5);
            }
            W();
        }
    }

    private void J0(long j2) {
        for (Renderer renderer : this.f22985b) {
            if (renderer.getStream() != null) {
                K0(renderer, j2);
            }
        }
    }

    private void K(PlaybackParameters playbackParameters, float f2, boolean z2, boolean z3) throws ExoPlaybackException {
        if (z2) {
            if (z3) {
                this.f23009z.b(1);
            }
            this.f23008y = this.f23008y.f(playbackParameters);
        }
        q1(playbackParameters.f23399b);
        for (Renderer renderer : this.f22985b) {
            if (renderer != null) {
                renderer.o(f2, playbackParameters.f23399b);
            }
        }
    }

    private void K0(Renderer renderer, long j2) {
        renderer.i();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).X(j2);
        }
    }

    private void L(PlaybackParameters playbackParameters, boolean z2) throws ExoPlaybackException {
        K(playbackParameters, playbackParameters.f23399b, true, z2);
    }

    private void L0(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.H != z2) {
            this.H = z2;
            if (!z2) {
                for (Renderer renderer : this.f22985b) {
                    if (!R(renderer) && this.f22986c.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private PlaybackInfo M(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, boolean z2, int i2) {
        boolean z3;
        ImmutableList<Metadata> immutableList;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j5 = j3;
        if (this.O || j2 != this.f23008y.f23394r || !mediaPeriodId.equals(this.f23008y.f23378b)) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.O = z3;
        s0();
        PlaybackInfo playbackInfo = this.f23008y;
        TrackGroupArray trackGroupArray3 = playbackInfo.f23384h;
        TrackSelectorResult trackSelectorResult3 = playbackInfo.f23385i;
        List<Metadata> list = playbackInfo.f23386j;
        if (this.f23004u.s()) {
            MediaPeriodHolder p2 = this.f23003t.p();
            if (p2 == null) {
                trackGroupArray2 = TrackGroupArray.f26007e;
            } else {
                trackGroupArray2 = p2.n();
            }
            if (p2 == null) {
                trackSelectorResult2 = this.f22989f;
            } else {
                trackSelectorResult2 = p2.o();
            }
            ImmutableList<Metadata> w2 = w(trackSelectorResult2.f27822c);
            if (p2 != null) {
                MediaPeriodInfo mediaPeriodInfo = p2.f23309f;
                if (mediaPeriodInfo.f23321c != j5) {
                    p2.f23309f = mediaPeriodInfo.a(j5);
                }
            }
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
            immutableList = w2;
        } else if (!mediaPeriodId.equals(this.f23008y.f23378b)) {
            TrackGroupArray trackGroupArray4 = TrackGroupArray.f26007e;
            trackGroupArray = trackGroupArray4;
            trackSelectorResult = this.f22989f;
            immutableList = ImmutableList.r();
        } else {
            immutableList = list;
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
        }
        if (z2) {
            this.f23009z.e(i2);
        }
        return this.f23008y.c(mediaPeriodId, j2, j3, j4, D(), trackGroupArray, trackSelectorResult, immutableList);
    }

    private void M0(PlaybackParameters playbackParameters) {
        this.f22992i.j(16);
        this.f22999p.e(playbackParameters);
    }

    private boolean N(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder j2 = mediaPeriodHolder.j();
        if (!mediaPeriodHolder.f23309f.f23324f || !j2.f23307d || (!(renderer instanceof TextRenderer) && !(renderer instanceof MetadataRenderer) && renderer.q() < j2.m())) {
            return false;
        }
        return true;
    }

    private void N0(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.f23009z.b(1);
        if (mediaSourceListUpdateMessage.f23013c != -1) {
            this.L = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.f23011a, mediaSourceListUpdateMessage.f23012b), mediaSourceListUpdateMessage.f23013c, mediaSourceListUpdateMessage.f23014d);
        }
        I(this.f23004u.C(mediaSourceListUpdateMessage.f23011a, mediaSourceListUpdateMessage.f23012b), false);
    }

    private boolean O() {
        MediaPeriodHolder q2 = this.f23003t.q();
        if (!q2.f23307d) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f22985b;
            if (i2 >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i2];
            SampleStream sampleStream = q2.f23306c[i2];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.g() && !N(renderer, q2))) {
                return false;
            }
            i2++;
        }
        return false;
    }

    private static boolean P(boolean z2, MediaSource.MediaPeriodId mediaPeriodId, long j2, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j3) {
        if (z2 || j2 != j3 || !mediaPeriodId.f25793a.equals(mediaPeriodId2.f25793a)) {
            return false;
        }
        if (!mediaPeriodId.b() || !period.t(mediaPeriodId.f25794b)) {
            if (!mediaPeriodId2.b() || !period.t(mediaPeriodId2.f25794b)) {
                return false;
            }
            return true;
        } else if (period.k(mediaPeriodId.f25794b, mediaPeriodId.f25795c) == 4 || period.k(mediaPeriodId.f25794b, mediaPeriodId.f25795c) == 2) {
            return false;
        } else {
            return true;
        }
    }

    private void P0(boolean z2) {
        if (z2 != this.J) {
            this.J = z2;
            if (!z2 && this.f23008y.f23391o) {
                this.f22992i.h(2);
            }
        }
    }

    private boolean Q() {
        MediaPeriodHolder j2 = this.f23003t.j();
        if (j2 == null || j2.k() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private void Q0(boolean z2) throws ExoPlaybackException {
        this.B = z2;
        s0();
        if (this.C && this.f23003t.q() != this.f23003t.p()) {
            C0(true);
            H(false);
        }
    }

    private static boolean R(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean S() {
        MediaPeriodHolder p2 = this.f23003t.p();
        long j2 = p2.f23309f.f23323e;
        if (!p2.f23307d || (j2 != -9223372036854775807L && this.f23008y.f23394r >= j2 && e1())) {
            return false;
        }
        return true;
    }

    private void S0(boolean z2, int i2, boolean z3, int i3) throws ExoPlaybackException {
        this.f23009z.b(z3 ? 1 : 0);
        this.f23009z.c(i3);
        this.f23008y = this.f23008y.d(z2, i2);
        this.D = false;
        g0(z2);
        if (!e1()) {
            k1();
            o1();
            return;
        }
        int i4 = this.f23008y.f23381e;
        if (i4 == 3) {
            h1();
            this.f22992i.h(2);
        } else if (i4 == 2) {
            this.f22992i.h(2);
        }
    }

    private static boolean T(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f23378b;
        Timeline timeline = playbackInfo.f23377a;
        if (timeline.u() || timeline.l(mediaPeriodId.f25793a, period).f23497g) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean U() {
        return Boolean.valueOf(this.A);
    }

    private void U0(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        M0(playbackParameters);
        L(this.f22999p.b(), true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(PlayerMessage playerMessage) {
        try {
            n(playerMessage);
        } catch (ExoPlaybackException e2) {
            Log.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void W() {
        boolean d12 = d1();
        this.E = d12;
        if (d12) {
            this.f23003t.j().d(this.M);
        }
        l1();
    }

    private void W0(int i2) throws ExoPlaybackException {
        this.F = i2;
        if (!this.f23003t.G(this.f23008y.f23377a, i2)) {
            C0(true);
        }
        H(false);
    }

    private void X() {
        this.f23009z.d(this.f23008y);
        if (this.f23009z.f23023a) {
            this.f23002s.a(this.f23009z);
            this.f23009z = new PlaybackInfoUpdate(this.f23008y);
        }
    }

    private void X0(SeekParameters seekParameters) {
        this.f23007x = seekParameters;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[LOOP:1: B:24:0x0074->B:34:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0062 A[EDGE_INSN: B:65:0x0062->B:20:0x0062 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0073 A[EDGE_INSN: B:72:0x0073->B:23:0x0073 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Y(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r7 = this;
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r0 = r7.f23000q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f7
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f23378b
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0014
            goto L_0x00f7
        L_0x0014:
            boolean r0 = r7.O
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r8 = r8 - r0
            r0 = 0
            r7.O = r0
        L_0x001e:
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.f23008y
            com.google.android.exoplayer2.Timeline r1 = r0.f23377a
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f23378b
            java.lang.Object r0 = r0.f25793a
            int r0 = r1.f(r0)
            int r1 = r7.N
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r2 = r7.f23000q
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r3 == 0) goto L_0x0062
            int r4 = r3.f23020c
            if (r4 > r0) goto L_0x0053
            if (r4 != r0) goto L_0x0062
            long r3 = r3.f23021d
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
        L_0x0053:
            int r1 = r1 + -1
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0062:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0073:
            r3 = r2
        L_0x0074:
            if (r3 == 0) goto L_0x0099
            java.lang.Object r4 = r3.f23022e
            if (r4 == 0) goto L_0x0099
            int r4 = r3.f23020c
            if (r4 < r0) goto L_0x0086
            if (r4 != r0) goto L_0x0099
            long r4 = r3.f23021d
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0099
        L_0x0086:
            int r1 = r1 + 1
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0099:
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r4 = r3.f23022e
            if (r4 == 0) goto L_0x00f5
            int r4 = r3.f23020c
            if (r4 != r0) goto L_0x00f5
            long r4 = r3.f23021d
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f5
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x00f5
            com.google.android.exoplayer2.PlayerMessage r4 = r3.f23019b     // Catch:{ all -> 0x00de }
            r7.H0(r4)     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.PlayerMessage r4 = r3.f23019b
            boolean r4 = r4.b()
            if (r4 != 0) goto L_0x00c6
            com.google.android.exoplayer2.PlayerMessage r3 = r3.f23019b
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            int r1 = r1 + 1
            goto L_0x00cb
        L_0x00c6:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            r3.remove(r1)
        L_0x00cb:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00dc
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f23000q
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0099
        L_0x00dc:
            r3 = r2
            goto L_0x0099
        L_0x00de:
            r8 = move-exception
            com.google.android.exoplayer2.PlayerMessage r9 = r3.f23019b
            boolean r9 = r9.b()
            if (r9 != 0) goto L_0x00ef
            com.google.android.exoplayer2.PlayerMessage r9 = r3.f23019b
            boolean r9 = r9.j()
            if (r9 == 0) goto L_0x00f4
        L_0x00ef:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r9 = r7.f23000q
            r9.remove(r1)
        L_0x00f4:
            throw r8
        L_0x00f5:
            r7.N = r1
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.Y(long, long):void");
    }

    private void Z() throws ExoPlaybackException {
        MediaPeriodInfo o2;
        this.f23003t.y(this.M);
        if (this.f23003t.D() && (o2 = this.f23003t.o(this.M, this.f23008y)) != null) {
            MediaPeriodHolder g2 = this.f23003t.g(this.f22987d, this.f22988e, this.f22990g.b(), this.f23004u, o2, this.f22989f);
            g2.f23304a.r(this, o2.f23320b);
            if (this.f23003t.p() == g2) {
                t0(o2.f23320b);
            }
            H(false);
        }
        if (this.E) {
            this.E = Q();
            l1();
            return;
        }
        W();
    }

    private void Z0(boolean z2) throws ExoPlaybackException {
        this.G = z2;
        if (!this.f23003t.H(this.f23008y.f23377a, z2)) {
            C0(true);
        }
        H(false);
    }

    private void a0() throws ExoPlaybackException {
        boolean z2;
        boolean z3 = false;
        while (c1()) {
            if (z3) {
                X();
            }
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.e(this.f23003t.b());
            if (this.f23008y.f23378b.f25793a.equals(mediaPeriodHolder.f23309f.f23319a.f25793a)) {
                MediaSource.MediaPeriodId mediaPeriodId = this.f23008y.f23378b;
                if (mediaPeriodId.f25794b == -1) {
                    MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodHolder.f23309f.f23319a;
                    if (mediaPeriodId2.f25794b == -1 && mediaPeriodId.f25797e != mediaPeriodId2.f25797e) {
                        z2 = true;
                        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f23309f;
                        MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodInfo.f23319a;
                        long j2 = mediaPeriodInfo.f23320b;
                        this.f23008y = M(mediaPeriodId3, j2, mediaPeriodInfo.f23321c, j2, !z2, 0);
                        s0();
                        o1();
                        z3 = true;
                    }
                }
            }
            z2 = false;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f23309f;
            MediaSource.MediaPeriodId mediaPeriodId32 = mediaPeriodInfo2.f23319a;
            long j22 = mediaPeriodInfo2.f23320b;
            this.f23008y = M(mediaPeriodId32, j22, mediaPeriodInfo2.f23321c, j22, !z2, 0);
            s0();
            o1();
            z3 = true;
        }
    }

    private void a1(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.f23009z.b(1);
        I(this.f23004u.D(shuffleOrder), false);
    }

    private void b0() throws ExoPlaybackException {
        long j2;
        boolean z2;
        MediaPeriodHolder q2 = this.f23003t.q();
        if (q2 != null) {
            int i2 = 0;
            if (q2.j() == null || this.C) {
                if (q2.f23309f.f23327i || this.C) {
                    while (true) {
                        Renderer[] rendererArr = this.f22985b;
                        if (i2 < rendererArr.length) {
                            Renderer renderer = rendererArr[i2];
                            SampleStream sampleStream = q2.f23306c[i2];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.g()) {
                                long j3 = q2.f23309f.f23323e;
                                if (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) {
                                    j2 = -9223372036854775807L;
                                } else {
                                    j2 = q2.l() + q2.f23309f.f23323e;
                                }
                                K0(renderer, j2);
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (O()) {
                if (q2.j().f23307d || this.M >= q2.j().m()) {
                    TrackSelectorResult o2 = q2.o();
                    MediaPeriodHolder c2 = this.f23003t.c();
                    TrackSelectorResult o3 = c2.o();
                    Timeline timeline = this.f23008y.f23377a;
                    p1(timeline, c2.f23309f.f23319a, timeline, q2.f23309f.f23319a, -9223372036854775807L, false);
                    if (!c2.f23307d || c2.f23304a.j() == -9223372036854775807L) {
                        for (int i3 = 0; i3 < this.f22985b.length; i3++) {
                            boolean c3 = o2.c(i3);
                            boolean c4 = o3.c(i3);
                            if (c3 && !this.f22985b[i3].l()) {
                                if (this.f22987d[i3].d() == -2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                RendererConfiguration rendererConfiguration = o2.f27821b[i3];
                                RendererConfiguration rendererConfiguration2 = o3.f27821b[i3];
                                if (!c4 || !rendererConfiguration2.equals(rendererConfiguration) || z2) {
                                    K0(this.f22985b[i3], c2.m());
                                }
                            }
                        }
                        return;
                    }
                    J0(c2.m());
                }
            }
        }
    }

    private void b1(int i2) {
        PlaybackInfo playbackInfo = this.f23008y;
        if (playbackInfo.f23381e != i2) {
            if (i2 != 2) {
                this.R = -9223372036854775807L;
            }
            this.f23008y = playbackInfo.g(i2);
        }
    }

    private void c0() throws ExoPlaybackException {
        MediaPeriodHolder q2 = this.f23003t.q();
        if (q2 != null && this.f23003t.p() != q2 && !q2.f23310g && p0()) {
            s();
        }
    }

    private boolean c1() {
        MediaPeriodHolder p2;
        MediaPeriodHolder j2;
        if (e1() && !this.C && (p2 = this.f23003t.p()) != null && (j2 = p2.j()) != null && this.M >= j2.m() && j2.f23310g) {
            return true;
        }
        return false;
    }

    private void d0() throws ExoPlaybackException {
        I(this.f23004u.i(), true);
    }

    private boolean d1() {
        long j2;
        if (!Q()) {
            return false;
        }
        MediaPeriodHolder j3 = this.f23003t.j();
        long E2 = E(j3.k());
        if (j3 == this.f23003t.p()) {
            j2 = j3.y(this.M);
        } else {
            j2 = j3.y(this.M) - j3.f23309f.f23320b;
        }
        long j4 = j2;
        boolean i2 = this.f22990g.i(j4, E2, this.f22999p.b().f23399b);
        if (i2 || E2 >= 500000) {
            return i2;
        }
        if (this.f22997n <= 0 && !this.f22998o) {
            return i2;
        }
        this.f23003t.p().f23304a.o(this.f23008y.f23394r, false);
        return this.f22990g.i(j4, E2, this.f22999p.b().f23399b);
    }

    private void e0(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.f23009z.b(1);
        I(this.f23004u.v(moveMediaItemsMessage.f23015a, moveMediaItemsMessage.f23016b, moveMediaItemsMessage.f23017c, moveMediaItemsMessage.f23018d), false);
    }

    private boolean e1() {
        PlaybackInfo playbackInfo = this.f23008y;
        return playbackInfo.f23388l && playbackInfo.f23389m == 0;
    }

    private void f0() {
        for (MediaPeriodHolder p2 = this.f23003t.p(); p2 != null; p2 = p2.j()) {
            for (ExoTrackSelection exoTrackSelection : p2.o().f27822c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.f();
                }
            }
        }
    }

    private boolean f1(boolean z2) {
        long j2;
        boolean z3;
        boolean z4;
        if (this.K == 0) {
            return S();
        }
        if (!z2) {
            return false;
        }
        PlaybackInfo playbackInfo = this.f23008y;
        if (!playbackInfo.f23383g) {
            return true;
        }
        if (g1(playbackInfo.f23377a, this.f23003t.p().f23309f.f23319a)) {
            j2 = this.f23005v.b();
        } else {
            j2 = -9223372036854775807L;
        }
        long j3 = j2;
        MediaPeriodHolder j4 = this.f23003t.j();
        if (!j4.q() || !j4.f23309f.f23327i) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!j4.f23309f.f23319a.b() || j4.f23307d) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z3 || z4 || this.f22990g.f(D(), this.f22999p.b().f23399b, this.D, j3)) {
            return true;
        }
        return false;
    }

    private void g0(boolean z2) {
        for (MediaPeriodHolder p2 = this.f23003t.p(); p2 != null; p2 = p2.j()) {
            for (ExoTrackSelection exoTrackSelection : p2.o().f27822c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.i(z2);
                }
            }
        }
    }

    private boolean g1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.b() || timeline.u()) {
            return false;
        }
        timeline.r(timeline.l(mediaPeriodId.f25793a, this.f22996m).f23494d, this.f22995l);
        if (!this.f22995l.h()) {
            return false;
        }
        Timeline.Window window = this.f22995l;
        if (!window.f23519j || window.f23516g == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    private void h0() {
        for (MediaPeriodHolder p2 = this.f23003t.p(); p2 != null; p2 = p2.j()) {
            for (ExoTrackSelection exoTrackSelection : p2.o().f27822c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.n();
                }
            }
        }
    }

    private void h1() throws ExoPlaybackException {
        this.D = false;
        this.f22999p.g();
        for (Renderer renderer : this.f22985b) {
            if (R(renderer)) {
                renderer.start();
            }
        }
    }

    private void j(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i2) throws ExoPlaybackException {
        this.f23009z.b(1);
        MediaSourceList mediaSourceList = this.f23004u;
        if (i2 == -1) {
            i2 = mediaSourceList.q();
        }
        I(mediaSourceList.f(i2, mediaSourceListUpdateMessage.f23011a, mediaSourceListUpdateMessage.f23012b), false);
    }

    private void j1(boolean z2, boolean z3) {
        boolean z4;
        if (z2 || !this.H) {
            z4 = true;
        } else {
            z4 = false;
        }
        r0(z4, false, true, false);
        this.f23009z.b(z3 ? 1 : 0);
        this.f22990g.g();
        b1(1);
    }

    private void k0() {
        int i2;
        this.f23009z.b(1);
        r0(false, false, false, true);
        this.f22990g.a();
        if (this.f23008y.f23377a.u()) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        b1(i2);
        this.f23004u.w(this.f22991h.b());
        this.f22992i.h(2);
    }

    private void k1() throws ExoPlaybackException {
        this.f22999p.h();
        for (Renderer renderer : this.f22985b) {
            if (R(renderer)) {
                u(renderer);
            }
        }
    }

    private void l1() {
        boolean z2;
        MediaPeriodHolder j2 = this.f23003t.j();
        if (this.E || (j2 != null && j2.f23304a.c())) {
            z2 = true;
        } else {
            z2 = false;
        }
        PlaybackInfo playbackInfo = this.f23008y;
        if (z2 != playbackInfo.f23383g) {
            this.f23008y = playbackInfo.a(z2);
        }
    }

    private void m() throws ExoPlaybackException {
        C0(true);
    }

    private void m0() {
        r0(true, false, true, false);
        this.f22990g.h();
        b1(1);
        HandlerThread handlerThread = this.f22993j;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.A = true;
            notifyAll();
        }
    }

    private void m1(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.f22990g.e(this.f22985b, trackGroupArray, trackSelectorResult.f27822c);
    }

    private void n(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.j()) {
            try {
                playerMessage.g().j(playerMessage.i(), playerMessage.e());
            } finally {
                playerMessage.k(true);
            }
        }
    }

    private void n0(int i2, int i3, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.f23009z.b(1);
        I(this.f23004u.A(i2, i3, shuffleOrder), false);
    }

    private void n1() throws ExoPlaybackException {
        if (!this.f23008y.f23377a.u() && this.f23004u.s()) {
            Z();
            b0();
            c0();
            a0();
        }
    }

    private void o(Renderer renderer) throws ExoPlaybackException {
        if (R(renderer)) {
            this.f22999p.a(renderer);
            u(renderer);
            renderer.disable();
            this.K--;
        }
    }

    private void o1() throws ExoPlaybackException {
        long j2;
        boolean z2;
        MediaPeriodHolder p2 = this.f23003t.p();
        if (p2 != null) {
            if (p2.f23307d) {
                j2 = p2.f23304a.j();
            } else {
                j2 = -9223372036854775807L;
            }
            if (j2 != -9223372036854775807L) {
                t0(j2);
                if (j2 != this.f23008y.f23394r) {
                    PlaybackInfo playbackInfo = this.f23008y;
                    this.f23008y = M(playbackInfo.f23378b, j2, playbackInfo.f23379c, j2, true, 5);
                }
            } else {
                DefaultMediaClock defaultMediaClock = this.f22999p;
                if (p2 != this.f23003t.q()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                long i2 = defaultMediaClock.i(z2);
                this.M = i2;
                long y2 = p2.y(i2);
                Y(this.f23008y.f23394r, y2);
                this.f23008y.f23394r = y2;
            }
            this.f23008y.f23392p = this.f23003t.j().i();
            this.f23008y.f23393q = D();
            PlaybackInfo playbackInfo2 = this.f23008y;
            if (playbackInfo2.f23388l && playbackInfo2.f23381e == 3 && g1(playbackInfo2.f23377a, playbackInfo2.f23378b) && this.f23008y.f23390n.f23399b == 1.0f) {
                float a2 = this.f23005v.a(x(), D());
                if (this.f22999p.b().f23399b != a2) {
                    M0(this.f23008y.f23390n.d(a2));
                    K(this.f23008y.f23390n, this.f22999p.b().f23399b, false, false);
                }
            }
        }
    }

    private boolean p0() throws ExoPlaybackException {
        boolean z2;
        MediaPeriodHolder q2 = this.f23003t.q();
        TrackSelectorResult o2 = q2.o();
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            Renderer[] rendererArr = this.f22985b;
            if (i2 >= rendererArr.length) {
                return !z3;
            }
            Renderer renderer = rendererArr[i2];
            if (R(renderer)) {
                if (renderer.getStream() != q2.f23306c[i2]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!o2.c(i2) || z2) {
                    if (!renderer.l()) {
                        renderer.t(y(o2.f27822c[i2]), q2.f23306c[i2], q2.m(), q2.l());
                    } else if (renderer.a()) {
                        o(renderer);
                    } else {
                        z3 = true;
                    }
                }
            }
            i2++;
        }
    }

    private void p1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j2, boolean z2) throws ExoPlaybackException {
        Object obj;
        PlaybackParameters playbackParameters;
        if (!g1(timeline, mediaPeriodId)) {
            if (mediaPeriodId.b()) {
                playbackParameters = PlaybackParameters.f23395e;
            } else {
                playbackParameters = this.f23008y.f23390n;
            }
            if (!this.f22999p.b().equals(playbackParameters)) {
                M0(playbackParameters);
                K(this.f23008y.f23390n, playbackParameters.f23399b, false, false);
                return;
            }
            return;
        }
        timeline.r(timeline.l(mediaPeriodId.f25793a, this.f22996m).f23494d, this.f22995l);
        this.f23005v.e((MediaItem.LiveConfiguration) Util.j(this.f22995l.f23521l));
        if (j2 != -9223372036854775807L) {
            this.f23005v.d(z(timeline, mediaPeriodId.f25793a, j2));
            return;
        }
        Object obj2 = this.f22995l.f23511b;
        if (!timeline2.u()) {
            obj = timeline2.r(timeline2.l(mediaPeriodId2.f25793a, this.f22996m).f23494d, this.f22995l).f23511b;
        } else {
            obj = null;
        }
        if (!Util.c(obj, obj2) || z2) {
            this.f23005v.d(-9223372036854775807L);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01db A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() throws com.google.android.exoplayer2.ExoPlaybackException, java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            com.google.android.exoplayer2.util.Clock r1 = r0.f23001r
            long r1 = r1.a()
            com.google.android.exoplayer2.util.HandlerWrapper r3 = r0.f22992i
            r4 = 2
            r3.j(r4)
            r16.n1()
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.f23008y
            int r3 = r3.f23381e
            r5 = 1
            if (r3 == r5) goto L_0x01f8
            r6 = 4
            if (r3 != r6) goto L_0x001d
            goto L_0x01f8
        L_0x001d:
            com.google.android.exoplayer2.MediaPeriodQueue r3 = r0.f23003t
            com.google.android.exoplayer2.MediaPeriodHolder r3 = r3.p()
            r7 = 10
            if (r3 != 0) goto L_0x002b
            r0.A0(r1, r7)
            return
        L_0x002b:
            java.lang.String r9 = "doSomeWork"
            com.google.android.exoplayer2.util.TraceUtil.a(r9)
            r16.o1()
            boolean r9 = r3.f23307d
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 0
            if (r9 == 0) goto L_0x00ac
            long r13 = android.os.SystemClock.elapsedRealtime()
            long r13 = r13 * r10
            com.google.android.exoplayer2.source.MediaPeriod r9 = r3.f23304a
            com.google.android.exoplayer2.PlaybackInfo r15 = r0.f23008y
            long r7 = r15.f23394r
            long r10 = r0.f22997n
            long r7 = r7 - r10
            boolean r10 = r0.f22998o
            r9.o(r7, r10)
            r7 = 0
            r8 = 1
            r9 = 1
        L_0x0051:
            com.google.android.exoplayer2.Renderer[] r10 = r0.f22985b
            int r11 = r10.length
            if (r7 >= r11) goto L_0x00b3
            r10 = r10[r7]
            boolean r11 = R(r10)
            if (r11 != 0) goto L_0x005f
            goto L_0x00a7
        L_0x005f:
            long r4 = r0.M
            r10.f(r4, r13)
            if (r8 == 0) goto L_0x006e
            boolean r4 = r10.a()
            if (r4 == 0) goto L_0x006e
            r8 = 1
            goto L_0x006f
        L_0x006e:
            r8 = 0
        L_0x006f:
            com.google.android.exoplayer2.source.SampleStream[] r4 = r3.f23306c
            r4 = r4[r7]
            com.google.android.exoplayer2.source.SampleStream r5 = r10.getStream()
            if (r4 == r5) goto L_0x007b
            r4 = 1
            goto L_0x007c
        L_0x007b:
            r4 = 0
        L_0x007c:
            if (r4 != 0) goto L_0x0086
            boolean r5 = r10.g()
            if (r5 == 0) goto L_0x0086
            r5 = 1
            goto L_0x0087
        L_0x0086:
            r5 = 0
        L_0x0087:
            if (r4 != 0) goto L_0x009a
            if (r5 != 0) goto L_0x009a
            boolean r4 = r10.isReady()
            if (r4 != 0) goto L_0x009a
            boolean r4 = r10.a()
            if (r4 == 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r4 = 0
            goto L_0x009b
        L_0x009a:
            r4 = 1
        L_0x009b:
            if (r9 == 0) goto L_0x00a1
            if (r4 == 0) goto L_0x00a1
            r9 = 1
            goto L_0x00a2
        L_0x00a1:
            r9 = 0
        L_0x00a2:
            if (r4 != 0) goto L_0x00a7
            r10.k()
        L_0x00a7:
            int r7 = r7 + 1
            r4 = 2
            r5 = 1
            goto L_0x0051
        L_0x00ac:
            com.google.android.exoplayer2.source.MediaPeriod r4 = r3.f23304a
            r4.l()
            r8 = 1
            r9 = 1
        L_0x00b3:
            com.google.android.exoplayer2.MediaPeriodInfo r4 = r3.f23309f
            long r4 = r4.f23323e
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 == 0) goto L_0x00d0
            boolean r7 = r3.f23307d
            if (r7 == 0) goto L_0x00d0
            int r7 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x00ce
            com.google.android.exoplayer2.PlaybackInfo r7 = r0.f23008y
            long r7 = r7.f23394r
            int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x00d0
        L_0x00ce:
            r4 = 1
            goto L_0x00d1
        L_0x00d0:
            r4 = 0
        L_0x00d1:
            if (r4 == 0) goto L_0x00e1
            boolean r5 = r0.C
            if (r5 == 0) goto L_0x00e1
            r0.C = r12
            com.google.android.exoplayer2.PlaybackInfo r5 = r0.f23008y
            int r5 = r5.f23389m
            r7 = 5
            r0.S0(r12, r5, r12, r7)
        L_0x00e1:
            r5 = 3
            if (r4 == 0) goto L_0x00f1
            com.google.android.exoplayer2.MediaPeriodInfo r4 = r3.f23309f
            boolean r4 = r4.f23327i
            if (r4 == 0) goto L_0x00f1
            r0.b1(r6)
            r16.k1()
            goto L_0x013a
        L_0x00f1:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.f23008y
            int r4 = r4.f23381e
            r7 = 2
            if (r4 != r7) goto L_0x010e
            boolean r4 = r0.f1(r9)
            if (r4 == 0) goto L_0x010e
            r0.b1(r5)
            r4 = 0
            r0.P = r4
            boolean r4 = r16.e1()
            if (r4 == 0) goto L_0x013a
            r16.h1()
            goto L_0x013a
        L_0x010e:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.f23008y
            int r4 = r4.f23381e
            if (r4 != r5) goto L_0x013a
            int r4 = r0.K
            if (r4 != 0) goto L_0x011f
            boolean r4 = r16.S()
            if (r4 == 0) goto L_0x0121
            goto L_0x013a
        L_0x011f:
            if (r9 != 0) goto L_0x013a
        L_0x0121:
            boolean r4 = r16.e1()
            r0.D = r4
            r4 = 2
            r0.b1(r4)
            boolean r4 = r0.D
            if (r4 == 0) goto L_0x0137
            r16.h0()
            com.google.android.exoplayer2.LivePlaybackSpeedControl r4 = r0.f23005v
            r4.c()
        L_0x0137:
            r16.k1()
        L_0x013a:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.f23008y
            int r4 = r4.f23381e
            r7 = 2
            if (r4 != r7) goto L_0x017e
            r4 = 0
        L_0x0142:
            com.google.android.exoplayer2.Renderer[] r7 = r0.f22985b
            int r8 = r7.length
            if (r4 >= r8) goto L_0x0167
            r7 = r7[r4]
            boolean r7 = R(r7)
            if (r7 == 0) goto L_0x0164
            com.google.android.exoplayer2.Renderer[] r7 = r0.f22985b
            r7 = r7[r4]
            com.google.android.exoplayer2.source.SampleStream r7 = r7.getStream()
            com.google.android.exoplayer2.source.SampleStream[] r8 = r3.f23306c
            r8 = r8[r4]
            if (r7 != r8) goto L_0x0164
            com.google.android.exoplayer2.Renderer[] r7 = r0.f22985b
            r7 = r7[r4]
            r7.k()
        L_0x0164:
            int r4 = r4 + 1
            goto L_0x0142
        L_0x0167:
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.f23008y
            boolean r4 = r3.f23383g
            if (r4 != 0) goto L_0x017e
            long r3 = r3.f23393q
            r7 = 500000(0x7a120, double:2.47033E-318)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x017e
            boolean r3 = r16.Q()
            if (r3 == 0) goto L_0x017e
            r3 = 1
            goto L_0x017f
        L_0x017e:
            r3 = 0
        L_0x017f:
            if (r3 != 0) goto L_0x0184
            r0.R = r13
            goto L_0x01a2
        L_0x0184:
            long r3 = r0.R
            int r7 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r7 != 0) goto L_0x0193
            com.google.android.exoplayer2.util.Clock r3 = r0.f23001r
            long r3 = r3.elapsedRealtime()
            r0.R = r3
            goto L_0x01a2
        L_0x0193:
            com.google.android.exoplayer2.util.Clock r3 = r0.f23001r
            long r3 = r3.elapsedRealtime()
            long r7 = r0.R
            long r3 = r3 - r7
            r7 = 4000(0xfa0, double:1.9763E-320)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x01f0
        L_0x01a2:
            boolean r3 = r16.e1()
            if (r3 == 0) goto L_0x01b0
            com.google.android.exoplayer2.PlaybackInfo r3 = r0.f23008y
            int r3 = r3.f23381e
            if (r3 != r5) goto L_0x01b0
            r3 = 1
            goto L_0x01b1
        L_0x01b0:
            r3 = 0
        L_0x01b1:
            boolean r4 = r0.J
            if (r4 == 0) goto L_0x01bd
            boolean r4 = r0.I
            if (r4 == 0) goto L_0x01bd
            if (r3 == 0) goto L_0x01bd
            r15 = 1
            goto L_0x01be
        L_0x01bd:
            r15 = 0
        L_0x01be:
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.f23008y
            boolean r7 = r4.f23391o
            if (r7 == r15) goto L_0x01ca
            com.google.android.exoplayer2.PlaybackInfo r4 = r4.h(r15)
            r0.f23008y = r4
        L_0x01ca:
            r0.I = r12
            if (r15 != 0) goto L_0x01ec
            com.google.android.exoplayer2.PlaybackInfo r4 = r0.f23008y
            int r4 = r4.f23381e
            if (r4 != r6) goto L_0x01d5
            goto L_0x01ec
        L_0x01d5:
            if (r3 != 0) goto L_0x01e7
            r3 = 2
            if (r4 != r3) goto L_0x01db
            goto L_0x01e7
        L_0x01db:
            if (r4 != r5) goto L_0x01ec
            int r3 = r0.K
            if (r3 == 0) goto L_0x01ec
            r3 = 1000(0x3e8, double:4.94E-321)
            r0.A0(r1, r3)
            goto L_0x01ec
        L_0x01e7:
            r3 = 10
            r0.A0(r1, r3)
        L_0x01ec:
            com.google.android.exoplayer2.util.TraceUtil.c()
            return
        L_0x01f0:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Playback stuck buffering and not loading"
            r1.<init>(r2)
            throw r1
        L_0x01f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.q():void");
    }

    private void q0() throws ExoPlaybackException {
        boolean z2;
        float f2 = this.f22999p.b().f23399b;
        MediaPeriodHolder p2 = this.f23003t.p();
        MediaPeriodHolder q2 = this.f23003t.q();
        boolean z3 = true;
        while (p2 != null && p2.f23307d) {
            TrackSelectorResult v2 = p2.v(f2, this.f23008y.f23377a);
            if (!v2.a(p2.o())) {
                if (z3) {
                    MediaPeriodHolder p3 = this.f23003t.p();
                    boolean z4 = this.f23003t.z(p3);
                    boolean[] zArr = new boolean[this.f22985b.length];
                    long b2 = p3.b(v2, this.f23008y.f23394r, z4, zArr);
                    PlaybackInfo playbackInfo = this.f23008y;
                    if (playbackInfo.f23381e == 4 || b2 == playbackInfo.f23394r) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    PlaybackInfo playbackInfo2 = this.f23008y;
                    MediaPeriodHolder mediaPeriodHolder = p3;
                    boolean[] zArr2 = zArr;
                    this.f23008y = M(playbackInfo2.f23378b, b2, playbackInfo2.f23379c, playbackInfo2.f23380d, z2, 5);
                    if (z2) {
                        t0(b2);
                    }
                    boolean[] zArr3 = new boolean[this.f22985b.length];
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.f22985b;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        boolean R2 = R(renderer);
                        zArr3[i2] = R2;
                        SampleStream sampleStream = mediaPeriodHolder.f23306c[i2];
                        if (R2) {
                            if (sampleStream != renderer.getStream()) {
                                o(renderer);
                            } else if (zArr2[i2]) {
                                renderer.r(this.M);
                            }
                        }
                        i2++;
                    }
                    t(zArr3);
                } else {
                    this.f23003t.z(p2);
                    if (p2.f23307d) {
                        p2.a(v2, Math.max(p2.f23309f.f23320b, p2.y(this.M)), false);
                    }
                }
                H(true);
                if (this.f23008y.f23381e != 4) {
                    W();
                    o1();
                    this.f22992i.h(2);
                    return;
                }
                return;
            }
            if (p2 == q2) {
                z3 = false;
            }
            p2 = p2.j();
        }
    }

    private void q1(float f2) {
        for (MediaPeriodHolder p2 = this.f23003t.p(); p2 != null; p2 = p2.j()) {
            for (ExoTrackSelection exoTrackSelection : p2.o().f27822c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.d(f2);
                }
            }
        }
    }

    private void r(int i2, boolean z2) throws ExoPlaybackException {
        boolean z3;
        boolean z4;
        boolean z5;
        Renderer renderer = this.f22985b[i2];
        if (!R(renderer)) {
            MediaPeriodHolder q2 = this.f23003t.q();
            if (q2 == this.f23003t.p()) {
                z3 = true;
            } else {
                z3 = false;
            }
            TrackSelectorResult o2 = q2.o();
            RendererConfiguration rendererConfiguration = o2.f27821b[i2];
            Format[] y2 = y(o2.f27822c[i2]);
            if (!e1() || this.f23008y.f23381e != 3) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z2 || !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.K++;
            this.f22986c.add(renderer);
            renderer.u(rendererConfiguration, y2, q2.f23306c[i2], this.M, z5, z3, q2.m(), q2.l());
            renderer.j(11, new Renderer.WakeupListener() {
                public void a() {
                    boolean unused = ExoPlayerImplInternal.this.I = true;
                }

                public void b() {
                    ExoPlayerImplInternal.this.f22992i.h(2);
                }
            });
            this.f22999p.c(renderer);
            if (z4) {
                renderer.start();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r0(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            r28 = this;
            r1 = r28
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r1.f22992i
            r2 = 2
            r0.j(r2)
            r2 = 0
            r1.P = r2
            r3 = 0
            r1.D = r3
            com.google.android.exoplayer2.DefaultMediaClock r0 = r1.f22999p
            r0.h()
            r4 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.M = r4
            com.google.android.exoplayer2.Renderer[] r4 = r1.f22985b
            int r5 = r4.length
            r6 = 0
        L_0x001e:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r5) goto L_0x0033
            r0 = r4[r6]
            r1.o(r0)     // Catch:{ ExoPlaybackException -> 0x002a, RuntimeException -> 0x0028 }
            goto L_0x0030
        L_0x0028:
            r0 = move-exception
            goto L_0x002b
        L_0x002a:
            r0 = move-exception
        L_0x002b:
            java.lang.String r8 = "Disable failed."
            com.google.android.exoplayer2.util.Log.d(r7, r8, r0)
        L_0x0030:
            int r6 = r6 + 1
            goto L_0x001e
        L_0x0033:
            if (r29 == 0) goto L_0x0053
            com.google.android.exoplayer2.Renderer[] r4 = r1.f22985b
            int r5 = r4.length
            r6 = 0
        L_0x0039:
            if (r6 >= r5) goto L_0x0053
            r0 = r4[r6]
            java.util.Set<com.google.android.exoplayer2.Renderer> r8 = r1.f22986c
            boolean r8 = r8.remove(r0)
            if (r8 == 0) goto L_0x0050
            r0.reset()     // Catch:{ RuntimeException -> 0x0049 }
            goto L_0x0050
        L_0x0049:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.util.Log.d(r7, r0, r8)
        L_0x0050:
            int r6 = r6 + 1
            goto L_0x0039
        L_0x0053:
            r1.K = r3
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r0.f23378b
            long r5 = r0.f23394r
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f23378b
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0075
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            com.google.android.exoplayer2.Timeline$Period r7 = r1.f22996m
            boolean r0 = T(r0, r7)
            if (r0 == 0) goto L_0x0070
            goto L_0x0075
        L_0x0070:
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            long r7 = r0.f23394r
            goto L_0x0079
        L_0x0075:
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            long r7 = r0.f23379c
        L_0x0079:
            if (r30 == 0) goto L_0x00a6
            r1.L = r2
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            com.google.android.exoplayer2.Timeline r0 = r0.f23377a
            android.util.Pair r0 = r1.B(r0)
            java.lang.Object r4 = r0.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r4
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.f23378b
            boolean r0 = r4.equals(r0)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L_0x00a6
            r0 = 1
            r17 = r4
            r25 = r5
            goto L_0x00ab
        L_0x00a6:
            r17 = r4
            r25 = r5
            r0 = 0
        L_0x00ab:
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r1.f23003t
            r4.f()
            r1.E = r3
            com.google.android.exoplayer2.PlaybackInfo r3 = new com.google.android.exoplayer2.PlaybackInfo
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.f23008y
            com.google.android.exoplayer2.Timeline r5 = r4.f23377a
            int r11 = r4.f23381e
            if (r32 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            com.google.android.exoplayer2.ExoPlaybackException r2 = r4.f23382f
        L_0x00bf:
            r12 = r2
            r13 = 0
            if (r0 == 0) goto L_0x00c6
            com.google.android.exoplayer2.source.TrackGroupArray r2 = com.google.android.exoplayer2.source.TrackGroupArray.f26007e
            goto L_0x00c8
        L_0x00c6:
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r4.f23384h
        L_0x00c8:
            r14 = r2
            if (r0 == 0) goto L_0x00ce
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r1.f22989f
            goto L_0x00d0
        L_0x00ce:
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r4.f23385i
        L_0x00d0:
            r15 = r2
            if (r0 == 0) goto L_0x00d8
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.r()
            goto L_0x00da
        L_0x00d8:
            java.util.List<com.google.android.exoplayer2.metadata.Metadata> r0 = r4.f23386j
        L_0x00da:
            r16 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.f23008y
            boolean r2 = r0.f23388l
            r18 = r2
            int r2 = r0.f23389m
            r19 = r2
            com.google.android.exoplayer2.PlaybackParameters r0 = r0.f23390n
            r20 = r0
            r23 = 0
            r27 = 0
            r4 = r3
            r6 = r17
            r9 = r25
            r21 = r25
            r4.<init>(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r25, r27)
            r1.f23008y = r3
            if (r31 == 0) goto L_0x0101
            com.google.android.exoplayer2.MediaSourceList r0 = r1.f23004u
            r0.y()
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.r0(boolean, boolean, boolean, boolean):void");
    }

    private synchronized void r1(Supplier<Boolean> supplier, long j2) {
        long elapsedRealtime = this.f23001r.elapsedRealtime() + j2;
        boolean z2 = false;
        while (!supplier.get().booleanValue() && j2 > 0) {
            try {
                this.f23001r.c();
                wait(j2);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j2 = elapsedRealtime - this.f23001r.elapsedRealtime();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private void s() throws ExoPlaybackException {
        t(new boolean[this.f22985b.length]);
    }

    private void s0() {
        boolean z2;
        MediaPeriodHolder p2 = this.f23003t.p();
        if (p2 == null || !p2.f23309f.f23326h || !this.B) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.C = z2;
    }

    private void t(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder q2 = this.f23003t.q();
        TrackSelectorResult o2 = q2.o();
        for (int i2 = 0; i2 < this.f22985b.length; i2++) {
            if (!o2.c(i2) && this.f22986c.remove(this.f22985b[i2])) {
                this.f22985b[i2].reset();
            }
        }
        for (int i3 = 0; i3 < this.f22985b.length; i3++) {
            if (o2.c(i3)) {
                r(i3, zArr[i3]);
            }
        }
        q2.f23310g = true;
    }

    private void t0(long j2) throws ExoPlaybackException {
        long j3;
        MediaPeriodHolder p2 = this.f23003t.p();
        if (p2 == null) {
            j3 = j2 + 1000000000000L;
        } else {
            j3 = p2.z(j2);
        }
        this.M = j3;
        this.f22999p.d(j3);
        for (Renderer renderer : this.f22985b) {
            if (R(renderer)) {
                renderer.r(this.M);
            }
        }
        f0();
    }

    private void u(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private static void u0(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        long j2;
        int i2 = timeline.r(timeline.l(pendingMessageInfo.f23022e, period).f23494d, window).f23526q;
        Object obj = timeline.k(i2, period, true).f23493c;
        long j3 = period.f23495e;
        if (j3 != -9223372036854775807L) {
            j2 = j3 - 1;
        } else {
            j2 = com.facebook.common.time.Clock.MAX_TIME;
        }
        pendingMessageInfo.b(i2, j2, obj);
    }

    private static boolean v0(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        long j2;
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window2 = window;
        Timeline.Period period2 = period;
        Object obj = pendingMessageInfo2.f23022e;
        if (obj == null) {
            if (pendingMessageInfo2.f23019b.f() == Long.MIN_VALUE) {
                j2 = -9223372036854775807L;
            } else {
                j2 = Util.F0(pendingMessageInfo2.f23019b.f());
            }
            Pair<Object, Long> y02 = y0(timeline, new SeekPosition(pendingMessageInfo2.f23019b.h(), pendingMessageInfo2.f23019b.d(), j2), false, i2, z2, window, period);
            if (y02 == null) {
                return false;
            }
            pendingMessageInfo.b(timeline3.f(y02.first), ((Long) y02.second).longValue(), y02.first);
            if (pendingMessageInfo2.f23019b.f() == Long.MIN_VALUE) {
                u0(timeline3, pendingMessageInfo, window2, period2);
            }
            return true;
        }
        int f2 = timeline3.f(obj);
        if (f2 == -1) {
            return false;
        }
        if (pendingMessageInfo2.f23019b.f() == Long.MIN_VALUE) {
            u0(timeline3, pendingMessageInfo, window2, period2);
            return true;
        }
        pendingMessageInfo2.f23020c = f2;
        timeline4.l(pendingMessageInfo2.f23022e, period2);
        if (period2.f23497g && timeline4.r(period2.f23494d, window2).f23525p == timeline4.f(pendingMessageInfo2.f23022e)) {
            long q2 = pendingMessageInfo2.f23021d + period.q();
            Pair<Object, Long> n2 = timeline.n(window, period, timeline3.l(pendingMessageInfo2.f23022e, period2).f23494d, q2);
            pendingMessageInfo.b(timeline3.f(n2.first), ((Long) n2.second).longValue(), n2.first);
        }
        return true;
    }

    private ImmutableList<Metadata> w(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z2 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.b(0).f23069k;
                if (metadata == null) {
                    builder.d(new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.d(metadata);
                    z2 = true;
                }
            }
        }
        if (z2) {
            return builder.k();
        }
        return ImmutableList.r();
    }

    private void w0(Timeline timeline, Timeline timeline2) {
        if (!timeline.u() || !timeline2.u()) {
            for (int size = this.f23000q.size() - 1; size >= 0; size--) {
                if (!v0(this.f23000q.get(size), timeline, timeline2, this.F, this.G, this.f22995l, this.f22996m)) {
                    this.f23000q.get(size).f23019b.k(false);
                    this.f23000q.remove(size);
                }
            }
            Collections.sort(this.f23000q);
        }
    }

    private long x() {
        PlaybackInfo playbackInfo = this.f23008y;
        return z(playbackInfo.f23377a, playbackInfo.f23378b.f25793a, playbackInfo.f23394r);
    }

    private static PositionUpdateForPlaylistChange x0(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        long j2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        MediaSource.MediaPeriodId mediaPeriodId;
        int i4;
        long j3;
        long j4;
        MediaPeriodQueue mediaPeriodQueue2;
        boolean z6;
        int i5;
        long j5;
        long j6;
        int i6;
        boolean z7;
        int i7;
        int i8;
        boolean z8;
        boolean z9;
        boolean z10;
        Timeline timeline2 = timeline;
        PlaybackInfo playbackInfo2 = playbackInfo;
        SeekPosition seekPosition2 = seekPosition;
        boolean z11 = z2;
        Timeline.Period period2 = period;
        if (timeline.u()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.k(), 0, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f23378b;
        Object obj = mediaPeriodId2.f25793a;
        boolean T = T(playbackInfo2, period2);
        if (playbackInfo2.f23378b.b() || T) {
            j2 = playbackInfo2.f23379c;
        } else {
            j2 = playbackInfo2.f23394r;
        }
        long j7 = j2;
        boolean z12 = true;
        if (seekPosition2 != null) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            i3 = -1;
            Pair<Object, Long> y02 = y0(timeline, seekPosition, true, i2, z2, window, period);
            if (y02 == null) {
                i8 = timeline2.e(z11);
                j3 = j7;
                z10 = false;
                z9 = false;
                z8 = true;
            } else {
                if (seekPosition2.f23038c == -9223372036854775807L) {
                    i8 = timeline2.l(y02.first, period2).f23494d;
                    j3 = j7;
                    z10 = false;
                } else {
                    obj = y02.first;
                    j3 = ((Long) y02.second).longValue();
                    z10 = true;
                    i8 = -1;
                }
                if (playbackInfo2.f23381e == 4) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                z8 = false;
            }
            Timeline.Window window2 = window;
            z3 = z10;
            z5 = z9;
            z4 = z8;
            i4 = i8;
            mediaPeriodId = mediaPeriodId3;
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId2;
            i3 = -1;
            if (playbackInfo2.f23377a.u()) {
                i6 = timeline2.e(z11);
            } else if (timeline2.f(obj) == -1) {
                Object z02 = z0(window, period, i2, z2, obj, playbackInfo2.f23377a, timeline);
                if (z02 == null) {
                    i7 = timeline2.e(z11);
                    z7 = true;
                } else {
                    i7 = timeline2.l(z02, period2).f23494d;
                    z7 = false;
                }
                Timeline.Window window3 = window;
                i4 = i7;
                z4 = z7;
                j5 = j7;
                mediaPeriodId = mediaPeriodId4;
                z5 = false;
                z3 = false;
            } else if (j7 == -9223372036854775807L) {
                i6 = timeline2.l(obj, period2).f23494d;
            } else if (T) {
                mediaPeriodId = mediaPeriodId4;
                playbackInfo2.f23377a.l(mediaPeriodId.f25793a, period2);
                if (playbackInfo2.f23377a.r(period2.f23494d, window).f23525p == playbackInfo2.f23377a.f(mediaPeriodId.f25793a)) {
                    Pair<Object, Long> n2 = timeline.n(window, period, timeline2.l(obj, period2).f23494d, j7 + period.q());
                    obj = n2.first;
                    j6 = ((Long) n2.second).longValue();
                } else {
                    j6 = j7;
                }
                i4 = -1;
                z5 = false;
                z4 = false;
                z3 = true;
            } else {
                Timeline.Window window4 = window;
                mediaPeriodId = mediaPeriodId4;
                j5 = j7;
                i4 = -1;
                z5 = false;
                z4 = false;
                z3 = false;
            }
            Timeline.Window window5 = window;
            i4 = i6;
            j5 = j7;
            mediaPeriodId = mediaPeriodId4;
            z5 = false;
            z4 = false;
            z3 = false;
        }
        if (i4 != i3) {
            Pair<Object, Long> n3 = timeline.n(window, period, i4, -9223372036854775807L);
            obj = n3.first;
            j3 = ((Long) n3.second).longValue();
            mediaPeriodQueue2 = mediaPeriodQueue;
            j4 = -9223372036854775807L;
        } else {
            mediaPeriodQueue2 = mediaPeriodQueue;
            j4 = j3;
        }
        MediaSource.MediaPeriodId B2 = mediaPeriodQueue2.B(timeline2, obj, j3);
        int i9 = B2.f25797e;
        if (i9 == i3 || ((i5 = mediaPeriodId.f25797e) != i3 && i9 >= i5)) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!mediaPeriodId.f25793a.equals(obj) || mediaPeriodId.b() || B2.b() || !z6) {
            z12 = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId;
        boolean P2 = P(T, mediaPeriodId, j7, B2, timeline2.l(obj, period2), j4);
        if (z12 || P2) {
            B2 = mediaPeriodId5;
        }
        if (B2.b()) {
            if (B2.equals(mediaPeriodId5)) {
                j3 = playbackInfo2.f23394r;
            } else {
                timeline2.l(B2.f25793a, period2);
                if (B2.f25795c == period2.n(B2.f25794b)) {
                    j3 = period.j();
                } else {
                    j3 = 0;
                }
            }
        }
        return new PositionUpdateForPlaylistChange(B2, j3, j4, z5, z4, z3);
    }

    private static Format[] y(ExoTrackSelection exoTrackSelection) {
        int i2;
        if (exoTrackSelection != null) {
            i2 = exoTrackSelection.length();
        } else {
            i2 = 0;
        }
        Format[] formatArr = new Format[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            formatArr[i3] = exoTrackSelection.b(i3);
        }
        return formatArr;
    }

    private static Pair<Object, Long> y0(Timeline timeline, SeekPosition seekPosition, boolean z2, int i2, boolean z3, Timeline.Window window, Timeline.Period period) {
        Timeline timeline2;
        Object z02;
        Timeline timeline3 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period2 = period;
        Timeline timeline4 = seekPosition2.f23036a;
        if (timeline.u()) {
            return null;
        }
        if (timeline4.u()) {
            timeline2 = timeline3;
        } else {
            timeline2 = timeline4;
        }
        try {
            Pair<Object, Long> n2 = timeline2.n(window, period, seekPosition2.f23037b, seekPosition2.f23038c);
            if (timeline.equals(timeline2)) {
                return n2;
            }
            if (timeline.f(n2.first) == -1) {
                Timeline.Window window2 = window;
                if (z2 && (z02 = z0(window, period, i2, z3, n2.first, timeline2, timeline)) != null) {
                    return timeline.n(window, period, timeline.l(z02, period2).f23494d, -9223372036854775807L);
                }
                return null;
            } else if (!timeline2.l(n2.first, period2).f23497g || timeline2.r(period2.f23494d, window).f23525p != timeline2.f(n2.first)) {
                return n2;
            } else {
                return timeline.n(window, period, timeline.l(n2.first, period2).f23494d, seekPosition2.f23038c);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private long z(Timeline timeline, Object obj, long j2) {
        timeline.r(timeline.l(obj, this.f22996m).f23494d, this.f22995l);
        Timeline.Window window = this.f22995l;
        if (window.f23516g != -9223372036854775807L && window.h()) {
            Timeline.Window window2 = this.f22995l;
            if (window2.f23519j) {
                return Util.F0(window2.c() - this.f22995l.f23516g) - (j2 + this.f22996m.q());
            }
        }
        return -9223372036854775807L;
    }

    static Object z0(Timeline.Window window, Timeline.Period period, int i2, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        int f2 = timeline.f(obj);
        int m2 = timeline.m();
        int i3 = f2;
        int i4 = -1;
        for (int i5 = 0; i5 < m2 && i4 == -1; i5++) {
            i3 = timeline.h(i3, period, window, i2, z2);
            if (i3 == -1) {
                break;
            }
            i4 = timeline2.f(timeline.q(i3));
        }
        if (i4 == -1) {
            return null;
        }
        return timeline2.q(i4);
    }

    public void B0(Timeline timeline, int i2, long j2) {
        this.f22992i.c(3, new SeekPosition(timeline, i2, j2)).a();
    }

    public Looper C() {
        return this.f22994k;
    }

    public void O0(List<MediaSourceList.MediaSourceHolder> list, int i2, long j2, ShuffleOrder shuffleOrder) {
        this.f22992i.c(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i2, j2)).a();
    }

    public void R0(boolean z2, int i2) {
        this.f22992i.f(1, z2 ? 1 : 0, i2).a();
    }

    public void T0(PlaybackParameters playbackParameters) {
        this.f22992i.c(4, playbackParameters).a();
    }

    public void V0(int i2) {
        this.f22992i.f(11, i2, 0).a();
    }

    public void Y0(boolean z2) {
        this.f22992i.f(12, z2 ? 1 : 0, 0).a();
    }

    public void b() {
        this.f22992i.h(10);
    }

    public void c() {
        this.f22992i.h(22);
    }

    public synchronized void e(PlayerMessage playerMessage) {
        if (!this.A) {
            if (this.f22994k.getThread().isAlive()) {
                this.f22992i.c(14, playerMessage).a();
                return;
            }
        }
        Log.i("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.k(false);
    }

    public boolean handleMessage(Message message) {
        MediaPeriodHolder q2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2 = 1000;
        try {
            switch (message.what) {
                case 0:
                    k0();
                    break;
                case 1:
                    if (message.arg1 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    S0(z2, message.arg2, true, 1);
                    break;
                case 2:
                    q();
                    break;
                case 3:
                    D0((SeekPosition) message.obj);
                    break;
                case 4:
                    U0((PlaybackParameters) message.obj);
                    break;
                case 5:
                    X0((SeekParameters) message.obj);
                    break;
                case 6:
                    j1(false, true);
                    break;
                case 7:
                    m0();
                    return true;
                case 8:
                    J((MediaPeriod) message.obj);
                    break;
                case 9:
                    F((MediaPeriod) message.obj);
                    break;
                case 10:
                    q0();
                    break;
                case 11:
                    W0(message.arg1);
                    break;
                case 12:
                    if (message.arg1 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Z0(z3);
                    break;
                case 13:
                    if (message.arg1 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    L0(z4, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    G0((PlayerMessage) message.obj);
                    break;
                case 15:
                    I0((PlayerMessage) message.obj);
                    break;
                case 16:
                    L((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    N0((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    j((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    e0((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    n0(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    a1((ShuffleOrder) message.obj);
                    break;
                case 22:
                    d0();
                    break;
                case 23:
                    if (message.arg1 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Q0(z5);
                    break;
                case 24:
                    if (message.arg1 == 1) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    P0(z6);
                    break;
                case 25:
                    m();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.f22898j == 1 && (q2 = this.f23003t.q()) != null) {
                e = e.e(q2.f23309f.f23319a);
            }
            if (!e.f22904p || this.P != null) {
                ExoPlaybackException exoPlaybackException = this.P;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.P;
                }
                Log.d("ExoPlayerImplInternal", "Playback error", e);
                j1(true, false);
                this.f23008y = this.f23008y.e(e);
            } else {
                Log.j("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.P = e;
                HandlerWrapper handlerWrapper = this.f22992i;
                handlerWrapper.k(handlerWrapper.c(25, e));
            }
        } catch (DrmSession.DrmSessionException e3) {
            G(e3, e3.f24084b);
        } catch (ParserException e4) {
            int i3 = e4.f23364c;
            if (i3 == 1) {
                if (e4.f23363b) {
                    i2 = 3001;
                } else {
                    i2 = AuthApiStatusCodes.AUTH_API_SERVER_ERROR;
                }
            } else if (i3 == 4) {
                if (e4.f23363b) {
                    i2 = 3002;
                } else {
                    i2 = AuthApiStatusCodes.AUTH_TOKEN_ERROR;
                }
            }
            G(e4, i2);
        } catch (DataSourceException e5) {
            G(e5, e5.f28332b);
        } catch (BehindLiveWindowException e6) {
            G(e6, 1002);
        } catch (IOException e7) {
            G(e7, 2000);
        } catch (RuntimeException e8) {
            if ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) {
                i2 = GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION;
            }
            ExoPlaybackException i4 = ExoPlaybackException.i(e8, i2);
            Log.d("ExoPlayerImplInternal", "Playback error", i4);
            j1(true, false);
            this.f23008y = this.f23008y.e(i4);
        }
        X();
        return true;
    }

    /* renamed from: i0 */
    public void d(MediaPeriod mediaPeriod) {
        this.f22992i.c(9, mediaPeriod).a();
    }

    public void i1() {
        this.f22992i.a(6).a();
    }

    public void j0() {
        this.f22992i.a(0).a();
    }

    public void l(int i2, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.f22992i.l(18, i2, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean l0() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.A     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0026
            android.os.Looper r0 = r3.f22994k     // Catch:{ all -> 0x0029 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r3.f22992i     // Catch:{ all -> 0x0029 }
            r1 = 7
            r0.h(r1)     // Catch:{ all -> 0x0029 }
            com.google.android.exoplayer2.w0 r0 = new com.google.android.exoplayer2.w0     // Catch:{ all -> 0x0029 }
            r0.<init>(r3)     // Catch:{ all -> 0x0029 }
            long r1 = r3.f23006w     // Catch:{ all -> 0x0029 }
            r3.r1(r0, r1)     // Catch:{ all -> 0x0029 }
            boolean r0 = r3.A     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)
            return r0
        L_0x0026:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.l0():boolean");
    }

    public void o0(int i2, int i3, ShuffleOrder shuffleOrder) {
        this.f22992i.l(20, i2, i3, shuffleOrder).a();
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.f22992i.c(16, playbackParameters).a();
    }

    public void p(MediaPeriod mediaPeriod) {
        this.f22992i.c(8, mediaPeriod).a();
    }

    public void v(long j2) {
        this.Q = j2;
    }
}
