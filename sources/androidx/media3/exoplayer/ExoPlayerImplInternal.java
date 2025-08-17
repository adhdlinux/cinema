package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.LoadControl;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.cast.framework.media.NotificationOptions;
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
    private static final long Y = Util.t1(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    private PlaybackInfo A;
    private PlaybackInfoUpdate B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private long G = -9223372036854775807L;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    /* access modifiers changed from: private */
    public boolean L;
    /* access modifiers changed from: private */
    public boolean M;
    private int N;
    private SeekPosition O;
    private long P;
    private long Q;
    private int R;
    private boolean S;
    private ExoPlaybackException T;
    private long U;
    private long V = -9223372036854775807L;
    private ExoPlayer.PreloadConfiguration W;
    private Timeline X;

    /* renamed from: b  reason: collision with root package name */
    private final Renderer[] f5331b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Renderer> f5332c;

    /* renamed from: d  reason: collision with root package name */
    private final RendererCapabilities[] f5333d;

    /* renamed from: e  reason: collision with root package name */
    private final TrackSelector f5334e;

    /* renamed from: f  reason: collision with root package name */
    private final TrackSelectorResult f5335f;

    /* renamed from: g  reason: collision with root package name */
    private final LoadControl f5336g;

    /* renamed from: h  reason: collision with root package name */
    private final BandwidthMeter f5337h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final HandlerWrapper f5338i;

    /* renamed from: j  reason: collision with root package name */
    private final HandlerThread f5339j;

    /* renamed from: k  reason: collision with root package name */
    private final Looper f5340k;

    /* renamed from: l  reason: collision with root package name */
    private final Timeline.Window f5341l;

    /* renamed from: m  reason: collision with root package name */
    private final Timeline.Period f5342m;

    /* renamed from: n  reason: collision with root package name */
    private final long f5343n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f5344o;

    /* renamed from: p  reason: collision with root package name */
    private final DefaultMediaClock f5345p;

    /* renamed from: q  reason: collision with root package name */
    private final ArrayList<PendingMessageInfo> f5346q;

    /* renamed from: r  reason: collision with root package name */
    private final Clock f5347r;

    /* renamed from: s  reason: collision with root package name */
    private final PlaybackInfoUpdateListener f5348s;

    /* renamed from: t  reason: collision with root package name */
    private final MediaPeriodQueue f5349t;

    /* renamed from: u  reason: collision with root package name */
    private final MediaSourceList f5350u;

    /* renamed from: v  reason: collision with root package name */
    private final LivePlaybackSpeedControl f5351v;

    /* renamed from: w  reason: collision with root package name */
    private final long f5352w;

    /* renamed from: x  reason: collision with root package name */
    private final PlayerId f5353x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final boolean f5354y;

    /* renamed from: z  reason: collision with root package name */
    private SeekParameters f5355z;

    private static final class MediaSourceListUpdateMessage {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<MediaSourceList.MediaSourceHolder> f5357a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ShuffleOrder f5358b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f5359c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f5360d;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i2, long j2) {
            this.f5357a = list;
            this.f5358b = shuffleOrder;
            this.f5359c = i2;
            this.f5360d = j2;
        }
    }

    private static class MoveMediaItemsMessage {

        /* renamed from: a  reason: collision with root package name */
        public final int f5361a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5362b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5363c;

        /* renamed from: d  reason: collision with root package name */
        public final ShuffleOrder f5364d;
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final PlayerMessage f5365b;

        /* renamed from: c  reason: collision with root package name */
        public int f5366c;

        /* renamed from: d  reason: collision with root package name */
        public long f5367d;

        /* renamed from: e  reason: collision with root package name */
        public Object f5368e;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.f5365b = playerMessage;
        }

        /* renamed from: a */
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            boolean z2;
            boolean z3;
            Object obj = this.f5368e;
            if (obj == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (pendingMessageInfo.f5368e == null) {
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
                int i2 = this.f5366c - pendingMessageInfo.f5366c;
                if (i2 != 0) {
                    return i2;
                }
                return Util.n(this.f5367d, pendingMessageInfo.f5367d);
            }
        }

        public void b(int i2, long j2, Object obj) {
            this.f5366c = i2;
            this.f5367d = j2;
            this.f5368e = obj;
        }
    }

    public static final class PlaybackInfoUpdate {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f5369a;

        /* renamed from: b  reason: collision with root package name */
        public PlaybackInfo f5370b;

        /* renamed from: c  reason: collision with root package name */
        public int f5371c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5372d;

        /* renamed from: e  reason: collision with root package name */
        public int f5373e;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.f5370b = playbackInfo;
        }

        public void b(int i2) {
            boolean z2;
            boolean z3 = this.f5369a;
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f5369a = z3 | z2;
            this.f5371c += i2;
        }

        public void c(PlaybackInfo playbackInfo) {
            boolean z2;
            boolean z3 = this.f5369a;
            if (this.f5370b != playbackInfo) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f5369a = z3 | z2;
            this.f5370b = playbackInfo;
        }

        public void d(int i2) {
            boolean z2 = true;
            if (!this.f5372d || this.f5373e == 5) {
                this.f5369a = true;
                this.f5372d = true;
                this.f5373e = i2;
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
        public final MediaSource.MediaPeriodId f5374a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5375b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5376c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f5377d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5378e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f5379f;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, boolean z2, boolean z3, boolean z4) {
            this.f5374a = mediaPeriodId;
            this.f5375b = j2;
            this.f5376c = j3;
            this.f5377d = z2;
            this.f5378e = z3;
            this.f5379f = z4;
        }
    }

    private static final class SeekPosition {

        /* renamed from: a  reason: collision with root package name */
        public final Timeline f5380a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5381b;

        /* renamed from: c  reason: collision with root package name */
        public final long f5382c;

        public SeekPosition(Timeline timeline, int i2, long j2) {
            this.f5380a = timeline;
            this.f5381b = i2;
            this.f5382c = j2;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i2, boolean z2, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j2, boolean z3, boolean z4, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2, ExoPlayer.PreloadConfiguration preloadConfiguration) {
        Renderer[] rendererArr2 = rendererArr;
        TrackSelector trackSelector2 = trackSelector;
        LoadControl loadControl2 = loadControl;
        BandwidthMeter bandwidthMeter2 = bandwidthMeter;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long j3 = j2;
        Clock clock2 = clock;
        PlayerId playerId2 = playerId;
        Looper looper3 = looper2;
        ExoPlayer.PreloadConfiguration preloadConfiguration2 = preloadConfiguration;
        this.f5348s = playbackInfoUpdateListener;
        this.f5331b = rendererArr2;
        this.f5334e = trackSelector2;
        this.f5335f = trackSelectorResult;
        this.f5336g = loadControl2;
        this.f5337h = bandwidthMeter2;
        this.I = i2;
        this.J = z2;
        this.f5355z = seekParameters;
        this.f5351v = livePlaybackSpeedControl;
        this.f5352w = j3;
        this.U = j3;
        this.D = z3;
        this.f5354y = z4;
        this.f5347r = clock2;
        this.f5353x = playerId2;
        this.W = preloadConfiguration2;
        this.f5343n = loadControl2.j(playerId2);
        this.f5344o = loadControl2.i(playerId2);
        this.X = Timeline.f4346a;
        PlaybackInfo k2 = PlaybackInfo.k(trackSelectorResult);
        this.A = k2;
        this.B = new PlaybackInfoUpdate(k2);
        this.f5333d = new RendererCapabilities[rendererArr2.length];
        RendererCapabilities.Listener c2 = trackSelector.c();
        for (int i3 = 0; i3 < rendererArr2.length; i3++) {
            rendererArr2[i3].v(i3, playerId2, clock2);
            this.f5333d[i3] = rendererArr2[i3].m();
            if (c2 != null) {
                this.f5333d[i3].C(c2);
            }
        }
        this.f5345p = new DefaultMediaClock(this, clock2);
        this.f5346q = new ArrayList<>();
        this.f5332c = Sets.h();
        this.f5341l = new Timeline.Window();
        this.f5342m = new Timeline.Period();
        trackSelector2.e(this, bandwidthMeter2);
        this.S = true;
        HandlerWrapper b2 = clock2.b(looper, (Handler.Callback) null);
        this.f5349t = new MediaPeriodQueue(analyticsCollector2, b2, new i0(this), preloadConfiguration2);
        this.f5350u = new MediaSourceList(this, analyticsCollector2, b2, playerId2);
        if (looper3 != null) {
            this.f5339j = null;
            this.f5340k = looper3;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.f5339j = handlerThread;
            handlerThread.start();
            this.f5340k = handlerThread.getLooper();
        }
        this.f5338i = clock2.b(this.f5340k, this);
    }

    private void A(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0(boolean r34, boolean r35, boolean r36, boolean r37) {
        /*
            r33 = this;
            r1 = r33
            androidx.media3.common.util.HandlerWrapper r0 = r1.f5338i
            r2 = 2
            r0.j(r2)
            r2 = 0
            r1.T = r2
            r3 = 0
            r4 = 1
            r1.B1(r3, r4)
            androidx.media3.exoplayer.DefaultMediaClock r0 = r1.f5345p
            r0.h()
            r5 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.P = r5
            androidx.media3.exoplayer.Renderer[] r5 = r1.f5331b
            int r6 = r5.length
            r7 = 0
        L_0x0020:
            java.lang.String r8 = "ExoPlayerImplInternal"
            if (r7 >= r6) goto L_0x0035
            r0 = r5[r7]
            r1.v(r0)     // Catch:{ ExoPlaybackException -> 0x002c, RuntimeException -> 0x002a }
            goto L_0x0032
        L_0x002a:
            r0 = move-exception
            goto L_0x002d
        L_0x002c:
            r0 = move-exception
        L_0x002d:
            java.lang.String r9 = "Disable failed."
            androidx.media3.common.util.Log.d(r8, r9, r0)
        L_0x0032:
            int r7 = r7 + 1
            goto L_0x0020
        L_0x0035:
            if (r34 == 0) goto L_0x0055
            androidx.media3.exoplayer.Renderer[] r5 = r1.f5331b
            int r6 = r5.length
            r7 = 0
        L_0x003b:
            if (r7 >= r6) goto L_0x0055
            r0 = r5[r7]
            java.util.Set<androidx.media3.exoplayer.Renderer> r9 = r1.f5332c
            boolean r9 = r9.remove(r0)
            if (r9 == 0) goto L_0x0052
            r0.reset()     // Catch:{ RuntimeException -> 0x004b }
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = "Reset failed."
            androidx.media3.common.util.Log.d(r8, r0, r9)
        L_0x0052:
            int r7 = r7 + 1
            goto L_0x003b
        L_0x0055:
            r1.N = r3
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f5465b
            long r6 = r0.f5482s
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f5465b
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x0077
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.common.Timeline$Period r8 = r1.f5342m
            boolean r0 = Z(r0, r8)
            if (r0 == 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            long r8 = r0.f5482s
            goto L_0x007b
        L_0x0077:
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            long r8 = r0.f5466c
        L_0x007b:
            if (r35 == 0) goto L_0x00a6
            r1.O = r2
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.common.Timeline r0 = r0.f5464a
            android.util.Pair r0 = r1.H(r0)
            java.lang.Object r5 = r0.first
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = (androidx.media3.exoplayer.source.MediaSource.MediaPeriodId) r5
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f5465b
            boolean r0 = r5.equals(r0)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L_0x00a6
            r28 = r6
            r9 = r8
            goto L_0x00aa
        L_0x00a6:
            r28 = r6
            r9 = r8
            r4 = 0
        L_0x00aa:
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r1.f5349t
            r0.f()
            r1.H = r3
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.A
            androidx.media3.common.Timeline r0 = r0.f5464a
            if (r36 == 0) goto L_0x00f0
            boolean r3 = r0 instanceof androidx.media3.exoplayer.PlaylistTimeline
            if (r3 == 0) goto L_0x00f0
            androidx.media3.exoplayer.PlaylistTimeline r0 = (androidx.media3.exoplayer.PlaylistTimeline) r0
            androidx.media3.exoplayer.MediaSourceList r3 = r1.f5350u
            androidx.media3.exoplayer.source.ShuffleOrder r3 = r3.q()
            androidx.media3.exoplayer.PlaylistTimeline r0 = r0.E(r3)
            int r3 = r5.f6972b
            r6 = -1
            if (r3 == r6) goto L_0x00f0
            java.lang.Object r3 = r5.f6971a
            androidx.media3.common.Timeline$Period r6 = r1.f5342m
            r0.h(r3, r6)
            androidx.media3.common.Timeline$Period r3 = r1.f5342m
            int r3 = r3.f4357c
            androidx.media3.common.Timeline$Window r6 = r1.f5341l
            androidx.media3.common.Timeline$Window r3 = r0.n(r3, r6)
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x00f0
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            java.lang.Object r6 = r5.f6971a
            long r7 = r5.f6974d
            r3.<init>(r6, r7)
            r7 = r0
            r19 = r3
            goto L_0x00f3
        L_0x00f0:
            r7 = r0
            r19 = r5
        L_0x00f3:
            androidx.media3.exoplayer.PlaybackInfo r0 = new androidx.media3.exoplayer.PlaybackInfo
            androidx.media3.exoplayer.PlaybackInfo r3 = r1.A
            int r13 = r3.f5468e
            if (r37 == 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            androidx.media3.exoplayer.ExoPlaybackException r2 = r3.f5469f
        L_0x00fe:
            r14 = r2
            r15 = 0
            if (r4 == 0) goto L_0x0105
            androidx.media3.exoplayer.source.TrackGroupArray r2 = androidx.media3.exoplayer.source.TrackGroupArray.f7176d
            goto L_0x0107
        L_0x0105:
            androidx.media3.exoplayer.source.TrackGroupArray r2 = r3.f5471h
        L_0x0107:
            r16 = r2
            if (r4 == 0) goto L_0x010e
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r2 = r1.f5335f
            goto L_0x0110
        L_0x010e:
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r2 = r3.f5472i
        L_0x0110:
            r17 = r2
            if (r4 == 0) goto L_0x0119
            com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.r()
            goto L_0x011b
        L_0x0119:
            java.util.List<androidx.media3.common.Metadata> r2 = r3.f5473j
        L_0x011b:
            r18 = r2
            androidx.media3.exoplayer.PlaybackInfo r2 = r1.A
            boolean r3 = r2.f5475l
            r20 = r3
            int r3 = r2.f5476m
            r21 = r3
            int r3 = r2.f5477n
            r22 = r3
            androidx.media3.common.PlaybackParameters r2 = r2.f5478o
            r23 = r2
            r26 = 0
            r30 = 0
            r32 = 0
            r6 = r0
            r8 = r19
            r11 = r28
            r24 = r28
            r6.<init>(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r28, r30, r32)
            r1.A = r0
            if (r36 == 0) goto L_0x014d
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r1.f5349t
            r0.H()
            androidx.media3.exoplayer.MediaSourceList r0 = r1.f5350u
            r0.z()
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.A0(boolean, boolean, boolean, boolean):void");
    }

    private void A1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j2, boolean z2) throws ExoPlaybackException {
        Object obj;
        PlaybackParameters playbackParameters;
        if (!q1(timeline, mediaPeriodId)) {
            if (mediaPeriodId.b()) {
                playbackParameters = PlaybackParameters.f4303d;
            } else {
                playbackParameters = this.A.f5478o;
            }
            if (!this.f5345p.b().equals(playbackParameters)) {
                V0(playbackParameters);
                Q(this.A.f5478o, playbackParameters.f4306a, false, false);
                return;
            }
            return;
        }
        timeline.n(timeline.h(mediaPeriodId.f6971a, this.f5342m).f4357c, this.f5341l);
        this.f5351v.e((MediaItem.LiveConfiguration) Util.i(this.f5341l.f4381j));
        if (j2 != -9223372036854775807L) {
            this.f5351v.d(F(timeline, mediaPeriodId.f6971a, j2));
            return;
        }
        Object obj2 = this.f5341l.f4372a;
        if (!timeline2.q()) {
            obj = timeline2.n(timeline2.h(mediaPeriodId2.f6971a, this.f5342m).f4357c, this.f5341l).f4372a;
        } else {
            obj = null;
        }
        if (!Util.c(obj, obj2) || z2) {
            this.f5351v.d(-9223372036854775807L);
        }
    }

    private void B0() {
        boolean z2;
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 == null || !t2.f5406f.f5423h || !this.D) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.E = z2;
    }

    private void B1(boolean z2, boolean z3) {
        long j2;
        this.F = z2;
        if (!z2 || z3) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.f5347r.elapsedRealtime();
        }
        this.G = j2;
    }

    private ImmutableList<Metadata> C(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z2 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.b(0).f4012k;
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

    private void C0(long j2) throws ExoPlaybackException {
        long j3;
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 == null) {
            j3 = j2 + 1000000000000L;
        } else {
            j3 = t2.B(j2);
        }
        this.P = j3;
        this.f5345p.d(j3);
        for (Renderer renderer : this.f5331b) {
            if (X(renderer)) {
                renderer.r(this.P);
            }
        }
        n0();
    }

    private void C1(float f2) {
        for (MediaPeriodHolder t2 = this.f5349t.t(); t2 != null; t2 = t2.k()) {
            for (ExoTrackSelection exoTrackSelection : t2.p().f7474c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.d(f2);
                }
            }
        }
    }

    private long D() {
        PlaybackInfo playbackInfo = this.A;
        return F(playbackInfo.f5464a, playbackInfo.f5465b.f6971a, playbackInfo.f5482s);
    }

    private static void D0(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        long j2;
        int i2 = timeline.n(timeline.h(pendingMessageInfo.f5368e, period).f4357c, window).f4386o;
        Object obj = timeline.g(i2, period, true).f4356b;
        long j3 = period.f4358d;
        if (j3 != -9223372036854775807L) {
            j2 = j3 - 1;
        } else {
            j2 = com.facebook.common.time.Clock.MAX_TIME;
        }
        pendingMessageInfo.b(i2, j2, obj);
    }

    private synchronized void D1(Supplier<Boolean> supplier, long j2) {
        long elapsedRealtime = this.f5347r.elapsedRealtime() + j2;
        boolean z2 = false;
        while (!supplier.get().booleanValue() && j2 > 0) {
            try {
                this.f5347r.c();
                wait(j2);
            } catch (InterruptedException unused) {
                z2 = true;
            }
            j2 = elapsedRealtime - this.f5347r.elapsedRealtime();
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private static Format[] E(ExoTrackSelection exoTrackSelection) {
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

    private static boolean E0(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        long j2;
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window2 = window;
        Timeline.Period period2 = period;
        Object obj = pendingMessageInfo2.f5368e;
        if (obj == null) {
            if (pendingMessageInfo2.f5365b.f() == Long.MIN_VALUE) {
                j2 = -9223372036854775807L;
            } else {
                j2 = Util.P0(pendingMessageInfo2.f5365b.f());
            }
            Pair<Object, Long> H0 = H0(timeline, new SeekPosition(pendingMessageInfo2.f5365b.h(), pendingMessageInfo2.f5365b.d(), j2), false, i2, z2, window, period);
            if (H0 == null) {
                return false;
            }
            pendingMessageInfo.b(timeline3.b(H0.first), ((Long) H0.second).longValue(), H0.first);
            if (pendingMessageInfo2.f5365b.f() == Long.MIN_VALUE) {
                D0(timeline3, pendingMessageInfo, window2, period2);
            }
            return true;
        }
        int b2 = timeline3.b(obj);
        if (b2 == -1) {
            return false;
        }
        if (pendingMessageInfo2.f5365b.f() == Long.MIN_VALUE) {
            D0(timeline3, pendingMessageInfo, window2, period2);
            return true;
        }
        pendingMessageInfo2.f5366c = b2;
        timeline4.h(pendingMessageInfo2.f5368e, period2);
        if (period2.f4360f && timeline4.n(period2.f4357c, window2).f4385n == timeline4.b(pendingMessageInfo2.f5368e)) {
            long n2 = pendingMessageInfo2.f5367d + period.n();
            Pair<Object, Long> j3 = timeline.j(window, period, timeline3.h(pendingMessageInfo2.f5368e, period2).f4357c, n2);
            pendingMessageInfo.b(timeline3.b(j3.first), ((Long) j3.second).longValue(), j3.first);
        }
        return true;
    }

    private long F(Timeline timeline, Object obj, long j2) {
        timeline.n(timeline.h(obj, this.f5342m).f4357c, this.f5341l);
        Timeline.Window window = this.f5341l;
        if (window.f4377f != -9223372036854775807L && window.f()) {
            Timeline.Window window2 = this.f5341l;
            if (window2.f4380i) {
                return Util.P0(window2.a() - this.f5341l.f4377f) - (j2 + this.f5342m.n());
            }
        }
        return -9223372036854775807L;
    }

    private void F0(Timeline timeline, Timeline timeline2) {
        if (!timeline.q() || !timeline2.q()) {
            for (int size = this.f5346q.size() - 1; size >= 0; size--) {
                if (!E0(this.f5346q.get(size), timeline, timeline2, this.I, this.J, this.f5341l, this.f5342m)) {
                    this.f5346q.get(size).f5365b.k(false);
                    this.f5346q.remove(size);
                }
            }
            Collections.sort(this.f5346q);
        }
    }

    private long G() {
        MediaPeriodHolder u2 = this.f5349t.u();
        if (u2 == null) {
            return 0;
        }
        long m2 = u2.m();
        if (!u2.f5404d) {
            return m2;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f5331b;
            if (i2 >= rendererArr.length) {
                return m2;
            }
            if (X(rendererArr[i2]) && this.f5331b[i2].getStream() == u2.f5403c[i2]) {
                long q2 = this.f5331b[i2].q();
                if (q2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                m2 = Math.max(q2, m2);
            }
            i2++;
        }
    }

    private static PositionUpdateForPlaylistChange G0(Timeline timeline, PlaybackInfo playbackInfo, SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
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
        boolean z8;
        boolean z9;
        boolean z10;
        Timeline timeline2 = timeline;
        PlaybackInfo playbackInfo2 = playbackInfo;
        SeekPosition seekPosition2 = seekPosition;
        boolean z11 = z2;
        Timeline.Period period2 = period;
        if (timeline.q()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.l(), 0, -9223372036854775807L, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f5465b;
        Object obj = mediaPeriodId2.f6971a;
        boolean Z = Z(playbackInfo2, period2);
        if (playbackInfo2.f5465b.b() || Z) {
            j2 = playbackInfo2.f5466c;
        } else {
            j2 = playbackInfo2.f5482s;
        }
        long j7 = j2;
        boolean z12 = true;
        if (seekPosition2 != null) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            i3 = -1;
            Pair<Object, Long> H0 = H0(timeline, seekPosition, true, i2, z2, window, period);
            if (H0 == null) {
                i7 = timeline2.a(z11);
                j3 = j7;
                z10 = false;
                z9 = false;
                z8 = true;
            } else {
                if (seekPosition2.f5382c == -9223372036854775807L) {
                    i7 = timeline2.h(H0.first, period2).f4357c;
                    j3 = j7;
                    z10 = false;
                } else {
                    obj = H0.first;
                    j3 = ((Long) H0.second).longValue();
                    z10 = true;
                    i7 = -1;
                }
                if (playbackInfo2.f5468e == 4) {
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
            i4 = i7;
            mediaPeriodId = mediaPeriodId3;
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId2;
            i3 = -1;
            if (playbackInfo2.f5464a.q()) {
                i6 = timeline2.a(z11);
            } else if (timeline2.b(obj) == -1) {
                int I0 = I0(window, period, i2, z2, obj, playbackInfo2.f5464a, timeline);
                if (I0 == -1) {
                    I0 = timeline2.a(z11);
                    z7 = true;
                } else {
                    z7 = false;
                }
                Timeline.Window window3 = window;
                i4 = I0;
                z4 = z7;
                j5 = j7;
                mediaPeriodId = mediaPeriodId4;
                z5 = false;
                z3 = false;
            } else if (j7 == -9223372036854775807L) {
                i6 = timeline2.h(obj, period2).f4357c;
            } else if (Z) {
                mediaPeriodId = mediaPeriodId4;
                playbackInfo2.f5464a.h(mediaPeriodId.f6971a, period2);
                if (playbackInfo2.f5464a.n(period2.f4357c, window).f4385n == playbackInfo2.f5464a.b(mediaPeriodId.f6971a)) {
                    Pair<Object, Long> j8 = timeline.j(window, period, timeline2.h(obj, period2).f4357c, j7 + period.n());
                    obj = j8.first;
                    j6 = ((Long) j8.second).longValue();
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
            Pair<Object, Long> j9 = timeline.j(window, period, i4, -9223372036854775807L);
            obj = j9.first;
            j3 = ((Long) j9.second).longValue();
            mediaPeriodQueue2 = mediaPeriodQueue;
            j4 = -9223372036854775807L;
        } else {
            mediaPeriodQueue2 = mediaPeriodQueue;
            j4 = j3;
        }
        MediaSource.MediaPeriodId L2 = mediaPeriodQueue2.L(timeline2, obj, j3);
        int i8 = L2.f6975e;
        if (i8 == i3 || ((i5 = mediaPeriodId.f6975e) != i3 && i8 >= i5)) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!mediaPeriodId.f6971a.equals(obj) || mediaPeriodId.b() || L2.b() || !z6) {
            z12 = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId;
        boolean V2 = V(Z, mediaPeriodId, j7, L2, timeline2.h(obj, period2), j4);
        if (z12 || V2) {
            L2 = mediaPeriodId5;
        }
        if (L2.b()) {
            if (L2.equals(mediaPeriodId5)) {
                j3 = playbackInfo2.f5482s;
            } else {
                timeline2.h(L2.f6971a, period2);
                if (L2.f6973c == period2.k(L2.f6972b)) {
                    j3 = period.g();
                } else {
                    j3 = 0;
                }
            }
        }
        return new PositionUpdateForPlaylistChange(L2, j3, j4, z5, z4, z3);
    }

    private Pair<MediaSource.MediaPeriodId, Long> H(Timeline timeline) {
        long j2 = 0;
        if (timeline.q()) {
            return Pair.create(PlaybackInfo.l(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> j3 = timeline2.j(this.f5341l, this.f5342m, timeline.a(this.J), -9223372036854775807L);
        MediaSource.MediaPeriodId L2 = this.f5349t.L(timeline, j3.first, 0);
        long longValue = ((Long) j3.second).longValue();
        if (L2.b()) {
            timeline.h(L2.f6971a, this.f5342m);
            if (L2.f6973c == this.f5342m.k(L2.f6972b)) {
                j2 = this.f5342m.g();
            }
            longValue = j2;
        }
        return Pair.create(L2, Long.valueOf(longValue));
    }

    private static Pair<Object, Long> H0(Timeline timeline, SeekPosition seekPosition, boolean z2, int i2, boolean z3, Timeline.Window window, Timeline.Period period) {
        Timeline timeline2;
        int I0;
        Timeline timeline3 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period2 = period;
        Timeline timeline4 = seekPosition2.f5380a;
        if (timeline.q()) {
            return null;
        }
        if (timeline4.q()) {
            timeline2 = timeline3;
        } else {
            timeline2 = timeline4;
        }
        try {
            Pair<Object, Long> j2 = timeline2.j(window, period, seekPosition2.f5381b, seekPosition2.f5382c);
            if (timeline.equals(timeline2)) {
                return j2;
            }
            if (timeline.b(j2.first) == -1) {
                Timeline.Window window2 = window;
                if (z2 && (I0 = I0(window, period, i2, z3, j2.first, timeline2, timeline)) != -1) {
                    return timeline.j(window, period, I0, -9223372036854775807L);
                }
                return null;
            } else if (!timeline2.h(j2.first, period2).f4360f || timeline2.n(period2.f4357c, window).f4385n != timeline2.b(j2.first)) {
                return j2;
            } else {
                return timeline.j(window, period, timeline.h(j2.first, period2).f4357c, seekPosition2.f5382c);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    static int I0(Timeline.Window window, Timeline.Period period, int i2, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        Object obj2 = timeline.n(timeline.h(obj, period).f4357c, window).f4372a;
        for (int i3 = 0; i3 < timeline2.p(); i3++) {
            if (timeline2.n(i3, window).f4372a.equals(obj2)) {
                return i3;
            }
        }
        int b2 = timeline.b(obj);
        int i4 = timeline.i();
        int i5 = b2;
        int i6 = -1;
        for (int i7 = 0; i7 < i4 && i6 == -1; i7++) {
            i5 = timeline.d(i5, period, window, i2, z2);
            if (i5 == -1) {
                break;
            }
            i6 = timeline2.b(timeline.m(i5));
        }
        if (i6 == -1) {
            return -1;
        }
        return timeline2.f(i6, period).f4357c;
    }

    private long J() {
        return K(this.A.f5480q);
    }

    private void J0(long j2) {
        long j3;
        if (this.A.f5468e != 3 || (!this.f5354y && o1())) {
            j3 = Y;
        } else {
            j3 = 1000;
        }
        if (this.f5354y && o1()) {
            for (Renderer renderer : this.f5331b) {
                if (X(renderer)) {
                    j3 = Math.min(j3, Util.t1(renderer.A(this.P, this.Q)));
                }
            }
        }
        this.f5338i.i(2, j2 + j3);
    }

    private long K(long j2) {
        MediaPeriodHolder m2 = this.f5349t.m();
        if (m2 == null) {
            return 0;
        }
        return Math.max(0, j2 - m2.A(this.P));
    }

    private void L(MediaPeriod mediaPeriod) {
        if (this.f5349t.B(mediaPeriod)) {
            this.f5349t.F(this.P);
            c0();
        }
    }

    private void L0(boolean z2) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.f5349t.t().f5406f.f5416a;
        long O0 = O0(mediaPeriodId, this.A.f5482s, true, false);
        if (O0 != this.A.f5482s) {
            PlaybackInfo playbackInfo = this.A;
            this.A = S(mediaPeriodId, O0, playbackInfo.f5466c, playbackInfo.f5467d, z2, 5);
        }
    }

    private void M(IOException iOException, int i2) {
        ExoPlaybackException e2 = ExoPlaybackException.e(iOException, i2);
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 != null) {
            e2 = e2.c(t2.f5406f.f5416a);
        }
        Log.d("ExoPlayerImplInternal", "Playback error", e2);
        t1(false, false);
        this.A = this.A.f(e2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ae A[Catch:{ all -> 0x0146 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M0(androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r20) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            androidx.media3.exoplayer.ExoPlayerImplInternal$PlaybackInfoUpdate r1 = r11.B
            r8 = 1
            r1.b(r8)
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.common.Timeline r1 = r1.f5464a
            r3 = 1
            int r4 = r11.I
            boolean r5 = r11.J
            androidx.media3.common.Timeline$Window r6 = r11.f5341l
            androidx.media3.common.Timeline$Period r7 = r11.f5342m
            r2 = r20
            android.util.Pair r1 = H0(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004b
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.A
            androidx.media3.common.Timeline r7 = r7.f5464a
            android.util.Pair r7 = r11.H(r7)
            java.lang.Object r9 = r7.first
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = (androidx.media3.exoplayer.source.MediaSource.MediaPeriodId) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.A
            androidx.media3.common.Timeline r7 = r7.f5464a
            boolean r7 = r7.q()
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
            long r9 = r0.f5382c
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005d
            r9 = r4
            goto L_0x005e
        L_0x005d:
            r9 = r12
        L_0x005e:
            androidx.media3.exoplayer.MediaPeriodQueue r14 = r11.f5349t
            androidx.media3.exoplayer.PlaybackInfo r15 = r11.A
            androidx.media3.common.Timeline r15 = r15.f5464a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = r14.L(r15, r7, r12)
            boolean r14 = r7.b()
            if (r14 == 0) goto L_0x0093
            androidx.media3.exoplayer.PlaybackInfo r4 = r11.A
            androidx.media3.common.Timeline r4 = r4.f5464a
            java.lang.Object r5 = r7.f6971a
            androidx.media3.common.Timeline$Period r12 = r11.f5342m
            r4.h(r5, r12)
            androidx.media3.common.Timeline$Period r4 = r11.f5342m
            int r5 = r7.f6972b
            int r4 = r4.k(r5)
            int r5 = r7.f6973c
            if (r4 != r5) goto L_0x008d
            androidx.media3.common.Timeline$Period r4 = r11.f5342m
            long r4 = r4.g()
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
            long r14 = r0.f5382c
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
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.A     // Catch:{ all -> 0x0146 }
            androidx.media3.common.Timeline r7 = r7.f5464a     // Catch:{ all -> 0x0146 }
            boolean r7 = r7.q()     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00ae
            r11.O = r0     // Catch:{ all -> 0x0146 }
            goto L_0x00bd
        L_0x00ae:
            r0 = 4
            if (r1 != 0) goto L_0x00c0
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A     // Catch:{ all -> 0x0146 }
            int r1 = r1.f5468e     // Catch:{ all -> 0x0146 }
            if (r1 == r8) goto L_0x00ba
            r11.l1(r0)     // Catch:{ all -> 0x0146 }
        L_0x00ba:
            r11.A0(r6, r8, r6, r8)     // Catch:{ all -> 0x0146 }
        L_0x00bd:
            r7 = r4
            goto L_0x0134
        L_0x00c0:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A     // Catch:{ all -> 0x0146 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r1.f5465b     // Catch:{ all -> 0x0146 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x010f
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.f5349t     // Catch:{ all -> 0x0146 }
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.t()     // Catch:{ all -> 0x0146 }
            if (r1 == 0) goto L_0x00e3
            boolean r7 = r1.f5404d     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x00e3
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00e3
            androidx.media3.exoplayer.source.MediaPeriod r1 = r1.f5401a     // Catch:{ all -> 0x0146 }
            androidx.media3.exoplayer.SeekParameters r2 = r11.f5355z     // Catch:{ all -> 0x0146 }
            long r1 = r1.h(r4, r2)     // Catch:{ all -> 0x0146 }
            goto L_0x00e4
        L_0x00e3:
            r1 = r4
        L_0x00e4:
            long r14 = androidx.media3.common.util.Util.t1(r1)     // Catch:{ all -> 0x0146 }
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.A     // Catch:{ all -> 0x0146 }
            long r6 = r3.f5482s     // Catch:{ all -> 0x0146 }
            long r6 = androidx.media3.common.util.Util.t1(r6)     // Catch:{ all -> 0x0146 }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0110
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.A     // Catch:{ all -> 0x0146 }
            int r6 = r3.f5468e     // Catch:{ all -> 0x0146 }
            r7 = 2
            if (r6 == r7) goto L_0x00fe
            r7 = 3
            if (r6 != r7) goto L_0x0110
        L_0x00fe:
            long r7 = r3.f5482s     // Catch:{ all -> 0x0146 }
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.S(r2, r3, r5, r7, r9, r10)
            r11.A = r0
            return
        L_0x010f:
            r1 = r4
        L_0x0110:
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.A     // Catch:{ all -> 0x0146 }
            int r3 = r3.f5468e     // Catch:{ all -> 0x0146 }
            if (r3 != r0) goto L_0x0118
            r0 = 1
            goto L_0x0119
        L_0x0118:
            r0 = 0
        L_0x0119:
            long r14 = r11.N0(r9, r1, r0)     // Catch:{ all -> 0x0146 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0122
            goto L_0x0123
        L_0x0122:
            r8 = 0
        L_0x0123:
            r10 = r10 | r8
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A     // Catch:{ all -> 0x0143 }
            androidx.media3.common.Timeline r4 = r0.f5464a     // Catch:{ all -> 0x0143 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f5465b     // Catch:{ all -> 0x0143 }
            r8 = 1
            r1 = r19
            r2 = r4
            r3 = r9
            r6 = r12
            r1.A1(r2, r3, r4, r5, r6, r8)     // Catch:{ all -> 0x0143 }
            r7 = r14
        L_0x0134:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.S(r2, r3, r5, r7, r9, r10)
            r11.A = r0
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
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.S(r2, r3, r5, r7, r9, r10)
            r11.A = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.M0(androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition):void");
    }

    private void N(boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId;
        long j2;
        MediaPeriodHolder m2 = this.f5349t.m();
        if (m2 == null) {
            mediaPeriodId = this.A.f5465b;
        } else {
            mediaPeriodId = m2.f5406f.f5416a;
        }
        boolean z3 = !this.A.f5474k.equals(mediaPeriodId);
        if (z3) {
            this.A = this.A.c(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.A;
        if (m2 == null) {
            j2 = playbackInfo.f5482s;
        } else {
            j2 = m2.j();
        }
        playbackInfo.f5480q = j2;
        this.A.f5481r = J();
        if ((z3 || z2) && m2 != null && m2.f5404d) {
            w1(m2.f5406f.f5416a, m2.o(), m2.p());
        }
    }

    private long N0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2) throws ExoPlaybackException {
        boolean z3;
        if (this.f5349t.t() != this.f5349t.u()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return O0(mediaPeriodId, j2, z3, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x018a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void O(androidx.media3.common.Timeline r29, boolean r30) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r28 = this;
            r11 = r28
            r12 = r29
            androidx.media3.exoplayer.PlaybackInfo r2 = r11.A
            androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition r3 = r11.O
            androidx.media3.exoplayer.MediaPeriodQueue r4 = r11.f5349t
            int r5 = r11.I
            boolean r6 = r11.J
            androidx.media3.common.Timeline$Window r7 = r11.f5341l
            androidx.media3.common.Timeline$Period r8 = r11.f5342m
            r1 = r29
            androidx.media3.exoplayer.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r7 = G0(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = r7.f5374a
            long r13 = r7.f5376c
            boolean r0 = r7.f5377d
            long r5 = r7.f5375b
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r1.f5465b
            boolean r1 = r1.equals(r9)
            r10 = 1
            r15 = 0
            if (r1 == 0) goto L_0x0038
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            long r1 = r1.f5482s
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
            r2 = 4
            boolean r1 = r7.f5378e     // Catch:{ all -> 0x0152 }
            if (r1 == 0) goto L_0x0053
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A     // Catch:{ all -> 0x0152 }
            int r1 = r1.f5468e     // Catch:{ all -> 0x0152 }
            if (r1 == r10) goto L_0x0050
            r11.l1(r2)     // Catch:{ all -> 0x0152 }
        L_0x0050:
            r11.A0(r15, r15, r15, r10)     // Catch:{ all -> 0x0152 }
        L_0x0053:
            androidx.media3.exoplayer.Renderer[] r1 = r11.f5331b     // Catch:{ all -> 0x0152 }
            int r2 = r1.length     // Catch:{ all -> 0x0152 }
            r3 = 0
        L_0x0057:
            if (r3 >= r2) goto L_0x0061
            r4 = r1[r3]     // Catch:{ all -> 0x0152 }
            r4.B(r12)     // Catch:{ all -> 0x0152 }
            int r3 = r3 + 1
            goto L_0x0057
        L_0x0061:
            if (r16 != 0) goto L_0x0085
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.f5349t     // Catch:{ all -> 0x007e }
            long r3 = r11.P     // Catch:{ all -> 0x007e }
            long r23 = r28.G()     // Catch:{ all -> 0x007e }
            r20 = 4
            r2 = r29
            r10 = -1
            r26 = r5
            r5 = r23
            boolean r0 = r1.R(r2, r3, r5)     // Catch:{ all -> 0x014c }
            if (r0 != 0) goto L_0x00c3
            r11.L0(r15)     // Catch:{ all -> 0x014c }
            goto L_0x00c3
        L_0x007e:
            r0 = move-exception
            r10 = -1
            r20 = 4
        L_0x0082:
            r15 = r8
            goto L_0x0150
        L_0x0085:
            r26 = r5
            r10 = -1
            r20 = 4
            boolean r1 = r29.q()     // Catch:{ all -> 0x014c }
            if (r1 != 0) goto L_0x00c3
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.f5349t     // Catch:{ all -> 0x00bf }
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.t()     // Catch:{ all -> 0x00bf }
        L_0x0096:
            if (r1 == 0) goto L_0x00b4
            androidx.media3.exoplayer.MediaPeriodInfo r2 = r1.f5406f     // Catch:{ all -> 0x014c }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f5416a     // Catch:{ all -> 0x014c }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x014c }
            if (r2 == 0) goto L_0x00af
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r11.f5349t     // Catch:{ all -> 0x014c }
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.f5406f     // Catch:{ all -> 0x014c }
            androidx.media3.exoplayer.MediaPeriodInfo r2 = r2.v(r12, r3)     // Catch:{ all -> 0x014c }
            r1.f5406f = r2     // Catch:{ all -> 0x014c }
            r1.C()     // Catch:{ all -> 0x014c }
        L_0x00af:
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.k()     // Catch:{ all -> 0x014c }
            goto L_0x0096
        L_0x00b4:
            r5 = r26
            long r0 = r11.N0(r9, r5, r0)     // Catch:{ all -> 0x00bd }
            r22 = r0
            goto L_0x00c7
        L_0x00bd:
            r0 = move-exception
            goto L_0x0082
        L_0x00bf:
            r0 = move-exception
            r5 = r26
            goto L_0x0082
        L_0x00c3:
            r5 = r26
            r22 = r5
        L_0x00c7:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            androidx.media3.common.Timeline r4 = r0.f5464a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f5465b
            boolean r0 = r7.f5379f
            if (r0 == 0) goto L_0x00d4
            r6 = r22
            goto L_0x00d6
        L_0x00d4:
            r6 = r18
        L_0x00d6:
            r0 = 0
            r1 = r28
            r2 = r29
            r3 = r9
            r15 = r8
            r8 = r0
            r1.A1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x00eb
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            long r0 = r0.f5466c
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0127
        L_0x00eb:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r0.f5465b
            java.lang.Object r1 = r1.f6971a
            androidx.media3.common.Timeline r0 = r0.f5464a
            if (r16 == 0) goto L_0x010a
            if (r30 == 0) goto L_0x010a
            boolean r2 = r0.q()
            if (r2 != 0) goto L_0x010a
            androidx.media3.common.Timeline$Period r2 = r11.f5342m
            androidx.media3.common.Timeline$Period r0 = r0.h(r1, r2)
            boolean r0 = r0.f4360f
            if (r0 != 0) goto L_0x010a
            r21 = 1
            goto L_0x010c
        L_0x010a:
            r21 = 0
        L_0x010c:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            long r7 = r0.f5467d
            int r0 = r12.b(r1)
            if (r0 != r10) goto L_0x0118
            r10 = 4
            goto L_0x0119
        L_0x0118:
            r10 = 3
        L_0x0119:
            r1 = r28
            r2 = r9
            r3 = r22
            r5 = r13
            r9 = r21
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.S(r2, r3, r5, r7, r9, r10)
            r11.A = r0
        L_0x0127:
            r28.B0()
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            androidx.media3.common.Timeline r0 = r0.f5464a
            r11.F0(r12, r0)
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.A
            androidx.media3.exoplayer.PlaybackInfo r0 = r0.j(r12)
            r11.A = r0
            boolean r0 = r29.q()
            if (r0 != 0) goto L_0x0141
            r11.O = r15
        L_0x0141:
            r1 = 0
            r11.N(r1)
            androidx.media3.common.util.HandlerWrapper r0 = r11.f5338i
            r8 = 2
            r0.h(r8)
            return
        L_0x014c:
            r0 = move-exception
            r15 = r8
            r5 = r26
        L_0x0150:
            r8 = 2
            goto L_0x0158
        L_0x0152:
            r0 = move-exception
            r15 = r8
            r8 = 2
            r10 = -1
            r20 = 4
        L_0x0158:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.common.Timeline r4 = r1.f5464a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r1.f5465b
            boolean r1 = r7.f5379f
            if (r1 == 0) goto L_0x0164
            r18 = r5
        L_0x0164:
            r22 = 0
            r1 = r28
            r2 = r29
            r7 = r3
            r3 = r9
            r25 = r5
            r5 = r7
            r6 = r18
            r8 = r22
            r1.A1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x0180
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            long r1 = r1.f5466c
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x01bc
        L_0x0180:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r1.f5465b
            java.lang.Object r2 = r2.f6971a
            androidx.media3.common.Timeline r1 = r1.f5464a
            if (r16 == 0) goto L_0x019f
            if (r30 == 0) goto L_0x019f
            boolean r3 = r1.q()
            if (r3 != 0) goto L_0x019f
            androidx.media3.common.Timeline$Period r3 = r11.f5342m
            androidx.media3.common.Timeline$Period r1 = r1.h(r2, r3)
            boolean r1 = r1.f4360f
            if (r1 != 0) goto L_0x019f
            r21 = 1
            goto L_0x01a1
        L_0x019f:
            r21 = 0
        L_0x01a1:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            long r7 = r1.f5467d
            int r1 = r12.b(r2)
            if (r1 != r10) goto L_0x01ad
            r10 = 4
            goto L_0x01ae
        L_0x01ad:
            r10 = 3
        L_0x01ae:
            r1 = r28
            r2 = r9
            r3 = r25
            r5 = r13
            r9 = r21
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.S(r2, r3, r5, r7, r9, r10)
            r11.A = r1
        L_0x01bc:
            r28.B0()
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.common.Timeline r1 = r1.f5464a
            r11.F0(r12, r1)
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.A
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.j(r12)
            r11.A = r1
            boolean r1 = r29.q()
            if (r1 != 0) goto L_0x01d6
            r11.O = r15
        L_0x01d6:
            r1 = 0
            r11.N(r1)
            androidx.media3.common.util.HandlerWrapper r1 = r11.f5338i
            r2 = 2
            r1.h(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.O(androidx.media3.common.Timeline, boolean):void");
    }

    private long O0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z2, boolean z3) throws ExoPlaybackException {
        u1();
        B1(false, true);
        if (z3 || this.A.f5468e == 3) {
            l1(2);
        }
        MediaPeriodHolder t2 = this.f5349t.t();
        MediaPeriodHolder mediaPeriodHolder = t2;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.f5406f.f5416a)) {
            mediaPeriodHolder = mediaPeriodHolder.k();
        }
        if (z2 || t2 != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.B(j2) < 0)) {
            for (Renderer v2 : this.f5331b) {
                v(v2);
            }
            if (mediaPeriodHolder != null) {
                while (this.f5349t.t() != mediaPeriodHolder) {
                    this.f5349t.b();
                }
                this.f5349t.I(mediaPeriodHolder);
                mediaPeriodHolder.z(1000000000000L);
                y();
            }
        }
        if (mediaPeriodHolder != null) {
            this.f5349t.I(mediaPeriodHolder);
            if (!mediaPeriodHolder.f5404d) {
                mediaPeriodHolder.f5406f = mediaPeriodHolder.f5406f.b(j2);
            } else if (mediaPeriodHolder.f5405e) {
                long i2 = mediaPeriodHolder.f5401a.i(j2);
                mediaPeriodHolder.f5401a.o(i2 - this.f5343n, this.f5344o);
                j2 = i2;
            }
            C0(j2);
            c0();
        } else {
            this.f5349t.f();
            C0(j2);
        }
        N(false);
        this.f5338i.h(2);
        return j2;
    }

    private void P(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.f5349t.B(mediaPeriod)) {
            MediaPeriodHolder m2 = this.f5349t.m();
            m2.q(this.f5345p.b().f4306a, this.A.f5464a);
            w1(m2.f5406f.f5416a, m2.o(), m2.p());
            if (m2 == this.f5349t.t()) {
                C0(m2.f5406f.f5417b);
                y();
                PlaybackInfo playbackInfo = this.A;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f5465b;
                long j2 = m2.f5406f.f5417b;
                this.A = S(mediaPeriodId, j2, playbackInfo.f5466c, j2, false, 5);
            }
            c0();
        }
    }

    private void P0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.f() == -9223372036854775807L) {
            Q0(playerMessage);
        } else if (this.A.f5464a.q()) {
            this.f5346q.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            Timeline timeline = this.A.f5464a;
            if (E0(pendingMessageInfo, timeline, timeline, this.I, this.J, this.f5341l, this.f5342m)) {
                this.f5346q.add(pendingMessageInfo);
                Collections.sort(this.f5346q);
                return;
            }
            playerMessage.k(false);
        }
    }

    private void Q(PlaybackParameters playbackParameters, float f2, boolean z2, boolean z3) throws ExoPlaybackException {
        if (z2) {
            if (z3) {
                this.B.b(1);
            }
            this.A = this.A.g(playbackParameters);
        }
        C1(playbackParameters.f4306a);
        for (Renderer renderer : this.f5331b) {
            if (renderer != null) {
                renderer.o(f2, playbackParameters.f4306a);
            }
        }
    }

    private void Q0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.c() == this.f5340k) {
            u(playerMessage);
            int i2 = this.A.f5468e;
            if (i2 == 3 || i2 == 2) {
                this.f5338i.h(2);
                return;
            }
            return;
        }
        this.f5338i.c(15, playerMessage).a();
    }

    private void R(PlaybackParameters playbackParameters, boolean z2) throws ExoPlaybackException {
        Q(playbackParameters, playbackParameters.f4306a, true, z2);
    }

    private void R0(PlayerMessage playerMessage) {
        Looper c2 = playerMessage.c();
        if (!c2.getThread().isAlive()) {
            Log.h("TAG", "Trying to send message on a dead thread.");
            playerMessage.k(false);
            return;
        }
        this.f5347r.b(c2, (Handler.Callback) null).g(new h0(this, playerMessage));
    }

    private PlaybackInfo S(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, boolean z2, int i2) {
        boolean z3;
        ImmutableList<Metadata> immutableList;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j5 = j3;
        if (this.S || j2 != this.A.f5482s || !mediaPeriodId.equals(this.A.f5465b)) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.S = z3;
        B0();
        PlaybackInfo playbackInfo = this.A;
        TrackGroupArray trackGroupArray3 = playbackInfo.f5471h;
        TrackSelectorResult trackSelectorResult3 = playbackInfo.f5472i;
        List<Metadata> list = playbackInfo.f5473j;
        if (this.f5350u.t()) {
            MediaPeriodHolder t2 = this.f5349t.t();
            if (t2 == null) {
                trackGroupArray2 = TrackGroupArray.f7176d;
            } else {
                trackGroupArray2 = t2.o();
            }
            if (t2 == null) {
                trackSelectorResult2 = this.f5335f;
            } else {
                trackSelectorResult2 = t2.p();
            }
            ImmutableList<Metadata> C2 = C(trackSelectorResult2.f7474c);
            if (t2 != null) {
                MediaPeriodInfo mediaPeriodInfo = t2.f5406f;
                if (mediaPeriodInfo.f5418c != j5) {
                    t2.f5406f = mediaPeriodInfo.a(j5);
                }
            }
            g0();
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
            immutableList = C2;
        } else if (!mediaPeriodId.equals(this.A.f5465b)) {
            TrackGroupArray trackGroupArray4 = TrackGroupArray.f7176d;
            trackGroupArray = trackGroupArray4;
            trackSelectorResult = this.f5335f;
            immutableList = ImmutableList.r();
        } else {
            immutableList = list;
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
        }
        if (z2) {
            this.B.d(i2);
        }
        return this.A.d(mediaPeriodId, j2, j3, j4, J(), trackGroupArray, trackSelectorResult, immutableList);
    }

    private void S0(long j2) {
        for (Renderer renderer : this.f5331b) {
            if (renderer.getStream() != null) {
                T0(renderer, j2);
            }
        }
    }

    private boolean T(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder k2 = mediaPeriodHolder.k();
        if (!mediaPeriodHolder.f5406f.f5421f || !k2.f5404d || (!(renderer instanceof TextRenderer) && !(renderer instanceof MetadataRenderer) && renderer.q() < k2.n())) {
            return false;
        }
        return true;
    }

    private void T0(Renderer renderer, long j2) {
        renderer.i();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).s0(j2);
        }
    }

    private boolean U() {
        MediaPeriodHolder u2 = this.f5349t.u();
        if (!u2.f5404d) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.f5331b;
            if (i2 >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i2];
            SampleStream sampleStream = u2.f5403c[i2];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.g() && !T(renderer, u2))) {
                return false;
            }
            i2++;
        }
        return false;
    }

    private void U0(boolean z2, AtomicBoolean atomicBoolean) {
        if (this.K != z2) {
            this.K = z2;
            if (!z2) {
                for (Renderer renderer : this.f5331b) {
                    if (!X(renderer) && this.f5332c.remove(renderer)) {
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

    private static boolean V(boolean z2, MediaSource.MediaPeriodId mediaPeriodId, long j2, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j3) {
        if (z2 || j2 != j3 || !mediaPeriodId.f6971a.equals(mediaPeriodId2.f6971a)) {
            return false;
        }
        if (!mediaPeriodId.b() || !period.r(mediaPeriodId.f6972b)) {
            if (!mediaPeriodId2.b() || !period.r(mediaPeriodId2.f6972b)) {
                return false;
            }
            return true;
        } else if (period.h(mediaPeriodId.f6972b, mediaPeriodId.f6973c) == 4 || period.h(mediaPeriodId.f6972b, mediaPeriodId.f6973c) == 2) {
            return false;
        } else {
            return true;
        }
    }

    private void V0(PlaybackParameters playbackParameters) {
        this.f5338i.j(16);
        this.f5345p.e(playbackParameters);
    }

    private boolean W() {
        MediaPeriodHolder m2 = this.f5349t.m();
        if (m2 == null || m2.r() || m2.l() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private void W0(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.B.b(1);
        if (mediaSourceListUpdateMessage.f5359c != -1) {
            this.O = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.f5357a, mediaSourceListUpdateMessage.f5358b), mediaSourceListUpdateMessage.f5359c, mediaSourceListUpdateMessage.f5360d);
        }
        O(this.f5350u.D(mediaSourceListUpdateMessage.f5357a, mediaSourceListUpdateMessage.f5358b), false);
    }

    private static boolean X(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean Y() {
        MediaPeriodHolder t2 = this.f5349t.t();
        long j2 = t2.f5406f.f5420e;
        if (!t2.f5404d || (j2 != -9223372036854775807L && this.A.f5482s >= j2 && o1())) {
            return false;
        }
        return true;
    }

    private void Y0(boolean z2) {
        if (z2 != this.M) {
            this.M = z2;
            if (!z2 && this.A.f5479p) {
                this.f5338i.h(2);
            }
        }
    }

    private static boolean Z(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f5465b;
        Timeline timeline = playbackInfo.f5464a;
        if (timeline.q() || timeline.h(mediaPeriodId.f6971a, period).f4360f) {
            return true;
        }
        return false;
    }

    private void Z0(boolean z2) throws ExoPlaybackException {
        this.D = z2;
        B0();
        if (this.E && this.f5349t.u() != this.f5349t.t()) {
            L0(true);
            N(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean a0() {
        return Boolean.valueOf(this.C);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(PlayerMessage playerMessage) {
        try {
            u(playerMessage);
        } catch (ExoPlaybackException e2) {
            Log.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void b1(boolean z2, int i2, boolean z3, int i3) throws ExoPlaybackException {
        this.B.b(z3 ? 1 : 0);
        this.A = this.A.e(z2, i3, i2);
        B1(false, false);
        o0(z2);
        if (!o1()) {
            u1();
            z1();
            return;
        }
        int i4 = this.A.f5468e;
        if (i4 == 3) {
            this.f5345p.g();
            r1();
            this.f5338i.h(2);
        } else if (i4 == 2) {
            this.f5338i.h(2);
        }
    }

    private void c0() {
        boolean n12 = n1();
        this.H = n12;
        if (n12) {
            this.f5349t.m().e(this.P, this.f5345p.b().f4306a, this.G);
        }
        v1();
    }

    private void d0() {
        this.B.c(this.A);
        if (this.B.f5369a) {
            this.f5348s.a(this.B);
            this.B = new PlaybackInfoUpdate(this.A);
        }
    }

    private void d1(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        V0(playbackParameters);
        R(this.f5345p.b(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[LOOP:1: B:24:0x0074->B:34:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0062 A[EDGE_INSN: B:65:0x0062->B:20:0x0062 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0073 A[EDGE_INSN: B:72:0x0073->B:23:0x0073 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(long r8, long r10) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r7 = this;
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r0 = r7.f5346q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f7
            androidx.media3.exoplayer.PlaybackInfo r0 = r7.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f5465b
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0014
            goto L_0x00f7
        L_0x0014:
            boolean r0 = r7.S
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r8 = r8 - r0
            r0 = 0
            r7.S = r0
        L_0x001e:
            androidx.media3.exoplayer.PlaybackInfo r0 = r7.A
            androidx.media3.common.Timeline r1 = r0.f5464a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f5465b
            java.lang.Object r0 = r0.f6971a
            int r0 = r1.b(r0)
            int r1 = r7.R
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r2 = r7.f5346q
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r3 == 0) goto L_0x0062
            int r4 = r3.f5366c
            if (r4 > r0) goto L_0x0053
            if (r4 != r0) goto L_0x0062
            long r3 = r3.f5367d
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
        L_0x0053:
            int r1 = r1 + -1
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0062:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            java.lang.Object r3 = r3.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0073:
            r3 = r2
        L_0x0074:
            if (r3 == 0) goto L_0x0099
            java.lang.Object r4 = r3.f5368e
            if (r4 == 0) goto L_0x0099
            int r4 = r3.f5366c
            if (r4 < r0) goto L_0x0086
            if (r4 != r0) goto L_0x0099
            long r4 = r3.f5367d
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x0099
        L_0x0086:
            int r1 = r1 + 1
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            java.lang.Object r3 = r3.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0099:
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r4 = r3.f5368e
            if (r4 == 0) goto L_0x00f5
            int r4 = r3.f5366c
            if (r4 != r0) goto L_0x00f5
            long r4 = r3.f5367d
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f5
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x00f5
            androidx.media3.exoplayer.PlayerMessage r4 = r3.f5365b     // Catch:{ all -> 0x00de }
            r7.Q0(r4)     // Catch:{ all -> 0x00de }
            androidx.media3.exoplayer.PlayerMessage r4 = r3.f5365b
            boolean r4 = r4.b()
            if (r4 != 0) goto L_0x00c6
            androidx.media3.exoplayer.PlayerMessage r3 = r3.f5365b
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            int r1 = r1 + 1
            goto L_0x00cb
        L_0x00c6:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            r3.remove(r1)
        L_0x00cb:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00dc
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.f5346q
            java.lang.Object r3 = r3.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0099
        L_0x00dc:
            r3 = r2
            goto L_0x0099
        L_0x00de:
            r8 = move-exception
            androidx.media3.exoplayer.PlayerMessage r9 = r3.f5365b
            boolean r9 = r9.b()
            if (r9 != 0) goto L_0x00ef
            androidx.media3.exoplayer.PlayerMessage r9 = r3.f5365b
            boolean r9 = r9.j()
            if (r9 == 0) goto L_0x00f4
        L_0x00ef:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r9 = r7.f5346q
            r9.remove(r1)
        L_0x00f4:
            throw r8
        L_0x00f5:
            r7.R = r1
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.e0(long, long):void");
    }

    private void e1(ExoPlayer.PreloadConfiguration preloadConfiguration) {
        this.W = preloadConfiguration;
        this.f5349t.Q(this.A.f5464a, preloadConfiguration);
    }

    private boolean f0() throws ExoPlaybackException {
        MediaPeriodInfo s2;
        this.f5349t.F(this.P);
        boolean z2 = false;
        if (this.f5349t.O() && (s2 = this.f5349t.s(this.P, this.A)) != null) {
            MediaPeriodHolder g2 = this.f5349t.g(s2);
            g2.f5401a.s(this, s2.f5417b);
            if (this.f5349t.t() == g2) {
                C0(s2.f5417b);
            }
            N(false);
            z2 = true;
        }
        if (this.H) {
            this.H = W();
            v1();
        } else {
            c0();
        }
        return z2;
    }

    private void g0() {
        boolean z2;
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 != null) {
            TrackSelectorResult p2 = t2.p();
            boolean z3 = false;
            int i2 = 0;
            boolean z4 = false;
            while (true) {
                if (i2 >= this.f5331b.length) {
                    z2 = true;
                    break;
                }
                if (p2.c(i2)) {
                    if (this.f5331b[i2].d() != 1) {
                        z2 = false;
                        break;
                    } else if (p2.f7473b[i2].f5508a != 0) {
                        z4 = true;
                    }
                }
                i2++;
            }
            if (z4 && z2) {
                z3 = true;
            }
            Y0(z3);
        }
    }

    private void g1(int i2) throws ExoPlaybackException {
        this.I = i2;
        if (!this.f5349t.S(this.A.f5464a, i2)) {
            L0(true);
        }
        N(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h0() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            boolean r2 = r14.m1()
            if (r2 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x000d
            r14.d0()
        L_0x000d:
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r14.f5349t
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.b()
            java.lang.Object r1 = androidx.media3.common.util.Assertions.f(r1)
            androidx.media3.exoplayer.MediaPeriodHolder r1 = (androidx.media3.exoplayer.MediaPeriodHolder) r1
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f5465b
            java.lang.Object r2 = r2.f6971a
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.f5406f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r3.f5416a
            java.lang.Object r3 = r3.f6971a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L_0x0045
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.A
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f5465b
            int r4 = r2.f6972b
            r5 = -1
            if (r4 != r5) goto L_0x0045
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.f5406f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r4.f5416a
            int r6 = r4.f6972b
            if (r6 != r5) goto L_0x0045
            int r2 = r2.f6975e
            int r4 = r4.f6975e
            if (r2 == r4) goto L_0x0045
            r2 = 1
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r1.f5406f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r1.f5416a
            long r10 = r1.f5417b
            long r8 = r1.f5418c
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            androidx.media3.exoplayer.PlaybackInfo r1 = r4.S(r5, r6, r8, r10, r12, r13)
            r14.A = r1
            r14.B0()
            r14.z1()
            androidx.media3.exoplayer.PlaybackInfo r1 = r14.A
            int r1 = r1.f5468e
            r2 = 3
            if (r1 != r2) goto L_0x0069
            r14.r1()
        L_0x0069:
            r14.q()
            r1 = 1
            goto L_0x0002
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.h0():void");
    }

    private void h1(SeekParameters seekParameters) {
        this.f5355z = seekParameters;
    }

    private void i0(boolean z2) {
        if (this.W.f5270a == -9223372036854775807L) {
            return;
        }
        if (z2 || !this.A.f5464a.equals(this.X)) {
            Timeline timeline = this.A.f5464a;
            this.X = timeline;
            this.f5349t.x(timeline);
        }
    }

    private void j0() throws ExoPlaybackException {
        long j2;
        boolean z2;
        MediaPeriodHolder u2 = this.f5349t.u();
        if (u2 != null) {
            int i2 = 0;
            if (u2.k() == null || this.E) {
                if (u2.f5406f.f5424i || this.E) {
                    while (true) {
                        Renderer[] rendererArr = this.f5331b;
                        if (i2 < rendererArr.length) {
                            Renderer renderer = rendererArr[i2];
                            SampleStream sampleStream = u2.f5403c[i2];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.g()) {
                                long j3 = u2.f5406f.f5420e;
                                if (j3 == -9223372036854775807L || j3 == Long.MIN_VALUE) {
                                    j2 = -9223372036854775807L;
                                } else {
                                    j2 = u2.m() + u2.f5406f.f5420e;
                                }
                                T0(renderer, j2);
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (U()) {
                if (u2.k().f5404d || this.P >= u2.k().n()) {
                    TrackSelectorResult p2 = u2.p();
                    MediaPeriodHolder c2 = this.f5349t.c();
                    TrackSelectorResult p3 = c2.p();
                    Timeline timeline = this.A.f5464a;
                    A1(timeline, c2.f5406f.f5416a, timeline, u2.f5406f.f5416a, -9223372036854775807L, false);
                    if (!c2.f5404d || c2.f5401a.j() == -9223372036854775807L) {
                        for (int i3 = 0; i3 < this.f5331b.length; i3++) {
                            boolean c3 = p2.c(i3);
                            boolean c4 = p3.c(i3);
                            if (c3 && !this.f5331b[i3].l()) {
                                if (this.f5333d[i3].d() == -2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                RendererConfiguration rendererConfiguration = p2.f7473b[i3];
                                RendererConfiguration rendererConfiguration2 = p3.f7473b[i3];
                                if (!c4 || !rendererConfiguration2.equals(rendererConfiguration) || z2) {
                                    T0(this.f5331b[i3], c2.n());
                                }
                            }
                        }
                        return;
                    }
                    S0(c2.n());
                    if (!c2.s()) {
                        this.f5349t.I(c2);
                        N(false);
                        c0();
                    }
                }
            }
        }
    }

    private void j1(boolean z2) throws ExoPlaybackException {
        this.J = z2;
        if (!this.f5349t.T(this.A.f5464a, z2)) {
            L0(true);
        }
        N(false);
    }

    private void k0() throws ExoPlaybackException {
        MediaPeriodHolder u2 = this.f5349t.u();
        if (u2 != null && this.f5349t.t() != u2 && !u2.f5407g && x0()) {
            y();
        }
    }

    private void k1(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.B.b(1);
        O(this.f5350u.E(shuffleOrder), false);
    }

    private void l0() throws ExoPlaybackException {
        O(this.f5350u.i(), true);
    }

    private void l1(int i2) {
        PlaybackInfo playbackInfo = this.A;
        if (playbackInfo.f5468e != i2) {
            if (i2 != 2) {
                this.V = -9223372036854775807L;
            }
            this.A = playbackInfo.h(i2);
        }
    }

    private void m0(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.B.b(1);
        O(this.f5350u.w(moveMediaItemsMessage.f5361a, moveMediaItemsMessage.f5362b, moveMediaItemsMessage.f5363c, moveMediaItemsMessage.f5364d), false);
    }

    private boolean m1() {
        MediaPeriodHolder t2;
        MediaPeriodHolder k2;
        if (o1() && !this.E && (t2 = this.f5349t.t()) != null && (k2 = t2.k()) != null && this.P >= k2.n() && k2.f5407g) {
            return true;
        }
        return false;
    }

    private void n0() {
        for (MediaPeriodHolder t2 = this.f5349t.t(); t2 != null; t2 = t2.k()) {
            for (ExoTrackSelection exoTrackSelection : t2.p().f7474c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.f();
                }
            }
        }
    }

    private boolean n1() {
        long j2;
        long j3;
        if (!W()) {
            return false;
        }
        MediaPeriodHolder m2 = this.f5349t.m();
        long K2 = K(m2.l());
        if (m2 == this.f5349t.t()) {
            j2 = m2.A(this.P);
        } else {
            j2 = m2.A(this.P) - m2.f5406f.f5417b;
        }
        long j4 = j2;
        if (q1(this.A.f5464a, m2.f5406f.f5416a)) {
            j3 = this.f5351v.b();
        } else {
            j3 = -9223372036854775807L;
        }
        long j5 = K2;
        LoadControl.Parameters parameters = r5;
        LoadControl.Parameters parameters2 = new LoadControl.Parameters(this.f5353x, this.A.f5464a, m2.f5406f.f5416a, j4, j5, this.f5345p.b().f4306a, this.A.f5475l, this.F, j3);
        boolean f2 = this.f5336g.f(parameters);
        MediaPeriodHolder t2 = this.f5349t.t();
        if (f2 || !t2.f5404d || K2 >= 500000) {
            return f2;
        }
        if (this.f5343n <= 0 && !this.f5344o) {
            return f2;
        }
        t2.f5401a.o(this.A.f5482s, false);
        return this.f5336g.f(parameters);
    }

    private void o(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i2) throws ExoPlaybackException {
        this.B.b(1);
        MediaSourceList mediaSourceList = this.f5350u;
        if (i2 == -1) {
            i2 = mediaSourceList.r();
        }
        O(mediaSourceList.f(i2, mediaSourceListUpdateMessage.f5357a, mediaSourceListUpdateMessage.f5358b), false);
    }

    private void o0(boolean z2) {
        for (MediaPeriodHolder t2 = this.f5349t.t(); t2 != null; t2 = t2.k()) {
            for (ExoTrackSelection exoTrackSelection : t2.p().f7474c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.i(z2);
                }
            }
        }
    }

    private boolean o1() {
        PlaybackInfo playbackInfo = this.A;
        return playbackInfo.f5475l && playbackInfo.f5477n == 0;
    }

    private void p0() {
        for (MediaPeriodHolder t2 = this.f5349t.t(); t2 != null; t2 = t2.k()) {
            for (ExoTrackSelection exoTrackSelection : t2.p().f7474c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.n();
                }
            }
        }
    }

    private boolean p1(boolean z2) {
        long j2;
        boolean z3;
        boolean z4;
        if (this.N == 0) {
            return Y();
        }
        if (!z2) {
            return false;
        }
        if (!this.A.f5470g) {
            return true;
        }
        MediaPeriodHolder t2 = this.f5349t.t();
        if (q1(this.A.f5464a, t2.f5406f.f5416a)) {
            j2 = this.f5351v.b();
        } else {
            j2 = -9223372036854775807L;
        }
        long j3 = j2;
        MediaPeriodHolder m2 = this.f5349t.m();
        if (!m2.s() || !m2.f5406f.f5424i) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!m2.f5406f.f5416a.b() || m2.f5404d) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z3 || z4 || this.f5336g.c(new LoadControl.Parameters(this.f5353x, this.A.f5464a, t2.f5406f.f5416a, t2.A(this.P), J(), this.f5345p.b().f4306a, this.A.f5475l, this.F, j3))) {
            return true;
        }
        return false;
    }

    private void q() {
        TrackSelectorResult p2 = this.f5349t.t().p();
        for (int i2 = 0; i2 < this.f5331b.length; i2++) {
            if (p2.c(i2)) {
                this.f5331b[i2].h();
            }
        }
    }

    private boolean q1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.b() || timeline.q()) {
            return false;
        }
        timeline.n(timeline.h(mediaPeriodId.f6971a, this.f5342m).f4357c, this.f5341l);
        if (!this.f5341l.f()) {
            return false;
        }
        Timeline.Window window = this.f5341l;
        if (!window.f4380i || window.f4377f == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    private void r1() throws ExoPlaybackException {
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 != null) {
            TrackSelectorResult p2 = t2.p();
            for (int i2 = 0; i2 < this.f5331b.length; i2++) {
                if (p2.c(i2) && this.f5331b[i2].getState() == 1) {
                    this.f5331b[i2].start();
                }
            }
        }
    }

    private void s() throws ExoPlaybackException {
        z0();
    }

    private void s0() {
        int i2;
        this.B.b(1);
        A0(false, false, false, true);
        this.f5336g.d(this.f5353x);
        if (this.A.f5464a.q()) {
            i2 = 4;
        } else {
            i2 = 2;
        }
        l1(i2);
        this.f5350u.x(this.f5337h.b());
        this.f5338i.h(2);
    }

    /* access modifiers changed from: private */
    public MediaPeriodHolder t(MediaPeriodInfo mediaPeriodInfo, long j2) {
        return new MediaPeriodHolder(this.f5333d, j2, this.f5334e, this.f5336g.b(), this.f5350u, mediaPeriodInfo, this.f5335f);
    }

    private void t1(boolean z2, boolean z3) {
        boolean z4;
        if (z2 || !this.K) {
            z4 = true;
        } else {
            z4 = false;
        }
        A0(z4, false, true, false);
        this.B.b(z3 ? 1 : 0);
        this.f5336g.g(this.f5353x);
        l1(1);
    }

    private void u(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.j()) {
            try {
                playerMessage.g().j(playerMessage.i(), playerMessage.e());
            } finally {
                playerMessage.k(true);
            }
        }
    }

    private void u0() {
        try {
            A0(true, false, true, false);
            v0();
            this.f5336g.e(this.f5353x);
            l1(1);
            HandlerThread handlerThread = this.f5339j;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            synchronized (this) {
                this.C = true;
                notifyAll();
            }
        } catch (Throwable th) {
            HandlerThread handlerThread2 = this.f5339j;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            synchronized (this) {
                this.C = true;
                notifyAll();
                throw th;
            }
        }
    }

    private void u1() throws ExoPlaybackException {
        this.f5345p.h();
        for (Renderer renderer : this.f5331b) {
            if (X(renderer)) {
                A(renderer);
            }
        }
    }

    private void v(Renderer renderer) throws ExoPlaybackException {
        if (X(renderer)) {
            this.f5345p.a(renderer);
            A(renderer);
            renderer.disable();
            this.N--;
        }
    }

    private void v0() {
        for (int i2 = 0; i2 < this.f5331b.length; i2++) {
            this.f5333d[i2].t();
            this.f5331b[i2].release();
        }
    }

    private void v1() {
        boolean z2;
        MediaPeriodHolder m2 = this.f5349t.m();
        if (this.H || (m2 != null && m2.f5401a.c())) {
            z2 = true;
        } else {
            z2 = false;
        }
        PlaybackInfo playbackInfo = this.A;
        if (z2 != playbackInfo.f5470g) {
            this.A = playbackInfo.b(z2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w() throws androidx.media3.exoplayer.ExoPlaybackException, java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            androidx.media3.common.util.Clock r1 = r0.f5347r
            long r1 = r1.a()
            androidx.media3.common.util.HandlerWrapper r3 = r0.f5338i
            r4 = 2
            r3.j(r4)
            r16.y1()
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.A
            int r3 = r3.f5468e
            r5 = 1
            if (r3 == r5) goto L_0x01ff
            r6 = 4
            if (r3 != r6) goto L_0x001d
            goto L_0x01ff
        L_0x001d:
            androidx.media3.exoplayer.MediaPeriodQueue r3 = r0.f5349t
            androidx.media3.exoplayer.MediaPeriodHolder r3 = r3.t()
            if (r3 != 0) goto L_0x0029
            r0.J0(r1)
            return
        L_0x0029:
            java.lang.String r7 = "doSomeWork"
            androidx.media3.common.util.TraceUtil.a(r7)
            r16.z1()
            boolean r7 = r3.f5404d
            r8 = 0
            if (r7 == 0) goto L_0x00ae
            androidx.media3.common.util.Clock r7 = r0.f5347r
            long r9 = r7.elapsedRealtime()
            long r9 = androidx.media3.common.util.Util.P0(r9)
            r0.Q = r9
            androidx.media3.exoplayer.source.MediaPeriod r7 = r3.f5401a
            androidx.media3.exoplayer.PlaybackInfo r9 = r0.A
            long r9 = r9.f5482s
            long r11 = r0.f5343n
            long r9 = r9 - r11
            boolean r11 = r0.f5344o
            r7.o(r9, r11)
            r7 = 0
            r9 = 1
            r10 = 1
        L_0x0053:
            androidx.media3.exoplayer.Renderer[] r11 = r0.f5331b
            int r12 = r11.length
            if (r7 >= r12) goto L_0x00b5
            r11 = r11[r7]
            boolean r12 = X(r11)
            if (r12 != 0) goto L_0x0061
            goto L_0x00ab
        L_0x0061:
            long r12 = r0.P
            long r14 = r0.Q
            r11.f(r12, r14)
            if (r9 == 0) goto L_0x0072
            boolean r9 = r11.a()
            if (r9 == 0) goto L_0x0072
            r9 = 1
            goto L_0x0073
        L_0x0072:
            r9 = 0
        L_0x0073:
            androidx.media3.exoplayer.source.SampleStream[] r12 = r3.f5403c
            r12 = r12[r7]
            androidx.media3.exoplayer.source.SampleStream r13 = r11.getStream()
            if (r12 == r13) goto L_0x007f
            r12 = 1
            goto L_0x0080
        L_0x007f:
            r12 = 0
        L_0x0080:
            if (r12 != 0) goto L_0x008a
            boolean r13 = r11.g()
            if (r13 == 0) goto L_0x008a
            r13 = 1
            goto L_0x008b
        L_0x008a:
            r13 = 0
        L_0x008b:
            if (r12 != 0) goto L_0x009e
            if (r13 != 0) goto L_0x009e
            boolean r12 = r11.isReady()
            if (r12 != 0) goto L_0x009e
            boolean r12 = r11.a()
            if (r12 == 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r12 = 0
            goto L_0x009f
        L_0x009e:
            r12 = 1
        L_0x009f:
            if (r10 == 0) goto L_0x00a5
            if (r12 == 0) goto L_0x00a5
            r10 = 1
            goto L_0x00a6
        L_0x00a5:
            r10 = 0
        L_0x00a6:
            if (r12 != 0) goto L_0x00ab
            r11.k()
        L_0x00ab:
            int r7 = r7 + 1
            goto L_0x0053
        L_0x00ae:
            androidx.media3.exoplayer.source.MediaPeriod r7 = r3.f5401a
            r7.l()
            r9 = 1
            r10 = 1
        L_0x00b5:
            androidx.media3.exoplayer.MediaPeriodInfo r7 = r3.f5406f
            long r11 = r7.f5420e
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 == 0) goto L_0x00d2
            boolean r7 = r3.f5404d
            if (r7 == 0) goto L_0x00d2
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x00d0
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.A
            long r13 = r7.f5482s
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 > 0) goto L_0x00d2
        L_0x00d0:
            r7 = 1
            goto L_0x00d3
        L_0x00d2:
            r7 = 0
        L_0x00d3:
            if (r7 == 0) goto L_0x00e3
            boolean r9 = r0.E
            if (r9 == 0) goto L_0x00e3
            r0.E = r8
            androidx.media3.exoplayer.PlaybackInfo r9 = r0.A
            int r9 = r9.f5477n
            r11 = 5
            r0.b1(r8, r9, r8, r11)
        L_0x00e3:
            r9 = 3
            if (r7 == 0) goto L_0x00f3
            androidx.media3.exoplayer.MediaPeriodInfo r7 = r3.f5406f
            boolean r7 = r7.f5424i
            if (r7 == 0) goto L_0x00f3
            r0.l1(r6)
            r16.u1()
            goto L_0x0143
        L_0x00f3:
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.A
            int r7 = r7.f5468e
            if (r7 != r4) goto L_0x0117
            boolean r7 = r0.p1(r10)
            if (r7 == 0) goto L_0x0117
            r0.l1(r9)
            r7 = 0
            r0.T = r7
            boolean r7 = r16.o1()
            if (r7 == 0) goto L_0x0143
            r0.B1(r8, r8)
            androidx.media3.exoplayer.DefaultMediaClock r7 = r0.f5345p
            r7.g()
            r16.r1()
            goto L_0x0143
        L_0x0117:
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.A
            int r7 = r7.f5468e
            if (r7 != r9) goto L_0x0143
            int r7 = r0.N
            if (r7 != 0) goto L_0x0128
            boolean r7 = r16.Y()
            if (r7 == 0) goto L_0x012a
            goto L_0x0143
        L_0x0128:
            if (r10 != 0) goto L_0x0143
        L_0x012a:
            boolean r7 = r16.o1()
            r0.B1(r7, r8)
            r0.l1(r4)
            boolean r7 = r0.F
            if (r7 == 0) goto L_0x0140
            r16.p0()
            androidx.media3.exoplayer.LivePlaybackSpeedControl r7 = r0.f5351v
            r7.c()
        L_0x0140:
            r16.u1()
        L_0x0143:
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.A
            int r7 = r7.f5468e
            if (r7 != r4) goto L_0x0186
            r7 = 0
        L_0x014a:
            androidx.media3.exoplayer.Renderer[] r10 = r0.f5331b
            int r11 = r10.length
            if (r7 >= r11) goto L_0x016f
            r10 = r10[r7]
            boolean r10 = X(r10)
            if (r10 == 0) goto L_0x016c
            androidx.media3.exoplayer.Renderer[] r10 = r0.f5331b
            r10 = r10[r7]
            androidx.media3.exoplayer.source.SampleStream r10 = r10.getStream()
            androidx.media3.exoplayer.source.SampleStream[] r11 = r3.f5403c
            r11 = r11[r7]
            if (r10 != r11) goto L_0x016c
            androidx.media3.exoplayer.Renderer[] r10 = r0.f5331b
            r10 = r10[r7]
            r10.k()
        L_0x016c:
            int r7 = r7 + 1
            goto L_0x014a
        L_0x016f:
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.A
            boolean r7 = r3.f5470g
            if (r7 != 0) goto L_0x0186
            long r10 = r3.f5481r
            r12 = 500000(0x7a120, double:2.47033E-318)
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x0186
            boolean r3 = r16.W()
            if (r3 == 0) goto L_0x0186
            r3 = 1
            goto L_0x0187
        L_0x0186:
            r3 = 0
        L_0x0187:
            if (r3 != 0) goto L_0x0191
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.V = r10
            goto L_0x01b4
        L_0x0191:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r12 = r0.V
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x01a5
            androidx.media3.common.util.Clock r3 = r0.f5347r
            long r10 = r3.elapsedRealtime()
            r0.V = r10
            goto L_0x01b4
        L_0x01a5:
            androidx.media3.common.util.Clock r3 = r0.f5347r
            long r10 = r3.elapsedRealtime()
            long r12 = r0.V
            long r10 = r10 - r12
            r12 = 4000(0xfa0, double:1.9763E-320)
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x01f7
        L_0x01b4:
            boolean r3 = r16.o1()
            if (r3 == 0) goto L_0x01c2
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.A
            int r3 = r3.f5468e
            if (r3 != r9) goto L_0x01c2
            r3 = 1
            goto L_0x01c3
        L_0x01c2:
            r3 = 0
        L_0x01c3:
            boolean r7 = r0.M
            if (r7 == 0) goto L_0x01ce
            boolean r7 = r0.L
            if (r7 == 0) goto L_0x01ce
            if (r3 == 0) goto L_0x01ce
            goto L_0x01cf
        L_0x01ce:
            r5 = 0
        L_0x01cf:
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.A
            boolean r10 = r7.f5479p
            if (r10 == r5) goto L_0x01db
            androidx.media3.exoplayer.PlaybackInfo r7 = r7.i(r5)
            r0.A = r7
        L_0x01db:
            r0.L = r8
            if (r5 != 0) goto L_0x01f3
            androidx.media3.exoplayer.PlaybackInfo r5 = r0.A
            int r5 = r5.f5468e
            if (r5 != r6) goto L_0x01e6
            goto L_0x01f3
        L_0x01e6:
            if (r3 != 0) goto L_0x01f0
            if (r5 == r4) goto L_0x01f0
            if (r5 != r9) goto L_0x01f3
            int r3 = r0.N
            if (r3 == 0) goto L_0x01f3
        L_0x01f0:
            r0.J0(r1)
        L_0x01f3:
            androidx.media3.common.util.TraceUtil.b()
            return
        L_0x01f7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Playback stuck buffering and not loading"
            r1.<init>(r2)
            throw r1
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.w():void");
    }

    private void w0(int i2, int i3, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.B.b(1);
        O(this.f5350u.B(i2, i3, shuffleOrder), false);
    }

    private void w1(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.f5336g.h(this.f5353x, this.A.f5464a, mediaPeriodId, this.f5331b, trackGroupArray, trackSelectorResult.f7474c);
    }

    private void x(int i2, boolean z2, long j2) throws ExoPlaybackException {
        boolean z3;
        boolean z4;
        boolean z5;
        Renderer renderer = this.f5331b[i2];
        if (!X(renderer)) {
            MediaPeriodHolder u2 = this.f5349t.u();
            if (u2 == this.f5349t.t()) {
                z3 = true;
            } else {
                z3 = false;
            }
            TrackSelectorResult p2 = u2.p();
            RendererConfiguration rendererConfiguration = p2.f7473b[i2];
            Format[] E2 = E(p2.f7474c[i2]);
            if (!o1() || this.A.f5468e != 3) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z2 || !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.N++;
            this.f5332c.add(renderer);
            renderer.u(rendererConfiguration, E2, u2.f5403c[i2], this.P, z5, z3, j2, u2.m(), u2.f5406f.f5416a);
            renderer.j(11, new Renderer.WakeupListener() {
                public void a() {
                    boolean unused = ExoPlayerImplInternal.this.L = true;
                }

                public void b() {
                    if (ExoPlayerImplInternal.this.f5354y || ExoPlayerImplInternal.this.M) {
                        ExoPlayerImplInternal.this.f5338i.h(2);
                    }
                }
            });
            this.f5345p.c(renderer);
            if (z4 && z3) {
                renderer.start();
            }
        }
    }

    private boolean x0() throws ExoPlaybackException {
        boolean z2;
        MediaPeriodHolder u2 = this.f5349t.u();
        TrackSelectorResult p2 = u2.p();
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            Renderer[] rendererArr = this.f5331b;
            if (i2 >= rendererArr.length) {
                return !z3;
            }
            Renderer renderer = rendererArr[i2];
            if (X(renderer)) {
                if (renderer.getStream() != u2.f5403c[i2]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!p2.c(i2) || z2) {
                    if (!renderer.l()) {
                        renderer.x(E(p2.f7474c[i2]), u2.f5403c[i2], u2.n(), u2.m(), u2.f5406f.f5416a);
                        if (this.M) {
                            Y0(false);
                        }
                    } else if (renderer.a()) {
                        v(renderer);
                    } else {
                        z3 = true;
                    }
                }
            }
            i2++;
        }
    }

    private void x1(int i2, int i3, List<MediaItem> list) throws ExoPlaybackException {
        this.B.b(1);
        O(this.f5350u.F(i2, i3, list), false);
    }

    private void y() throws ExoPlaybackException {
        z(new boolean[this.f5331b.length], this.f5349t.u().n());
    }

    private void y0() throws ExoPlaybackException {
        boolean z2;
        float f2 = this.f5345p.b().f4306a;
        MediaPeriodHolder t2 = this.f5349t.t();
        MediaPeriodHolder u2 = this.f5349t.u();
        TrackSelectorResult trackSelectorResult = null;
        boolean z3 = true;
        while (t2 != null && t2.f5404d) {
            TrackSelectorResult x2 = t2.x(f2, this.A.f5464a);
            if (t2 == this.f5349t.t()) {
                trackSelectorResult = x2;
            }
            if (!x2.a(t2.p())) {
                if (z3) {
                    MediaPeriodHolder t3 = this.f5349t.t();
                    boolean I2 = this.f5349t.I(t3);
                    boolean[] zArr = new boolean[this.f5331b.length];
                    long b2 = t3.b((TrackSelectorResult) Assertions.f(trackSelectorResult), this.A.f5482s, I2, zArr);
                    PlaybackInfo playbackInfo = this.A;
                    if (playbackInfo.f5468e == 4 || b2 == playbackInfo.f5482s) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    PlaybackInfo playbackInfo2 = this.A;
                    long j2 = b2;
                    this.A = S(playbackInfo2.f5465b, b2, playbackInfo2.f5466c, playbackInfo2.f5467d, z2, 5);
                    if (z2) {
                        C0(j2);
                    }
                    boolean[] zArr2 = new boolean[this.f5331b.length];
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.f5331b;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        boolean X2 = X(renderer);
                        zArr2[i2] = X2;
                        SampleStream sampleStream = t3.f5403c[i2];
                        if (X2) {
                            if (sampleStream != renderer.getStream()) {
                                v(renderer);
                            } else if (zArr[i2]) {
                                renderer.r(this.P);
                            }
                        }
                        i2++;
                    }
                    z(zArr2, this.P);
                } else {
                    this.f5349t.I(t2);
                    if (t2.f5404d) {
                        t2.a(x2, Math.max(t2.f5406f.f5417b, t2.A(this.P)), false);
                    }
                }
                N(true);
                if (this.A.f5468e != 4) {
                    c0();
                    z1();
                    this.f5338i.h(2);
                    return;
                }
                return;
            }
            if (t2 == u2) {
                z3 = false;
            }
            t2 = t2.k();
        }
    }

    private void y1() throws ExoPlaybackException {
        if (!this.A.f5464a.q() && this.f5350u.t()) {
            boolean f02 = f0();
            j0();
            k0();
            h0();
            i0(f02);
        }
    }

    private void z(boolean[] zArr, long j2) throws ExoPlaybackException {
        MediaPeriodHolder u2 = this.f5349t.u();
        TrackSelectorResult p2 = u2.p();
        for (int i2 = 0; i2 < this.f5331b.length; i2++) {
            if (!p2.c(i2) && this.f5332c.remove(this.f5331b[i2])) {
                this.f5331b[i2].reset();
            }
        }
        for (int i3 = 0; i3 < this.f5331b.length; i3++) {
            if (p2.c(i3)) {
                x(i3, zArr[i3], j2);
            }
        }
        u2.f5407g = true;
    }

    private void z0() throws ExoPlaybackException {
        y0();
        L0(true);
    }

    private void z1() throws ExoPlaybackException {
        long j2;
        boolean z2;
        MediaPeriodHolder t2 = this.f5349t.t();
        if (t2 != null) {
            if (t2.f5404d) {
                j2 = t2.f5401a.j();
            } else {
                j2 = -9223372036854775807L;
            }
            if (j2 != -9223372036854775807L) {
                if (!t2.s()) {
                    this.f5349t.I(t2);
                    N(false);
                    c0();
                }
                C0(j2);
                if (j2 != this.A.f5482s) {
                    PlaybackInfo playbackInfo = this.A;
                    this.A = S(playbackInfo.f5465b, j2, playbackInfo.f5466c, j2, true, 5);
                }
            } else {
                DefaultMediaClock defaultMediaClock = this.f5345p;
                if (t2 != this.f5349t.u()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                long i2 = defaultMediaClock.i(z2);
                this.P = i2;
                long A2 = t2.A(i2);
                e0(this.A.f5482s, A2);
                if (this.f5345p.w()) {
                    boolean z3 = !this.B.f5372d;
                    PlaybackInfo playbackInfo2 = this.A;
                    this.A = S(playbackInfo2.f5465b, A2, playbackInfo2.f5466c, A2, z3, 6);
                } else {
                    this.A.o(A2);
                }
            }
            this.A.f5480q = this.f5349t.m().j();
            this.A.f5481r = J();
            PlaybackInfo playbackInfo3 = this.A;
            if (playbackInfo3.f5475l && playbackInfo3.f5468e == 3 && q1(playbackInfo3.f5464a, playbackInfo3.f5465b) && this.A.f5478o.f4306a == 1.0f) {
                float a2 = this.f5351v.a(D(), J());
                if (this.f5345p.b().f4306a != a2) {
                    V0(this.A.f5478o.b(a2));
                    Q(this.A.f5478o, this.f5345p.b().f4306a, false, false);
                }
            }
        }
    }

    public void B(long j2) {
        this.U = j2;
    }

    public Looper I() {
        return this.f5340k;
    }

    public void K0(Timeline timeline, int i2, long j2) {
        this.f5338i.c(3, new SeekPosition(timeline, i2, j2)).a();
    }

    public void X0(List<MediaSourceList.MediaSourceHolder> list, int i2, long j2, ShuffleOrder shuffleOrder) {
        this.f5338i.c(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i2, j2)).a();
    }

    public void a1(boolean z2, int i2, int i3) {
        this.f5338i.f(1, z2 ? 1 : 0, i2 | (i3 << 4)).a();
    }

    public void b() {
        this.f5338i.h(10);
    }

    public void c() {
        this.f5338i.j(2);
        this.f5338i.h(22);
    }

    public void c1(PlaybackParameters playbackParameters) {
        this.f5338i.c(4, playbackParameters).a();
    }

    public void d(Renderer renderer) {
        this.f5338i.h(26);
    }

    public synchronized void e(PlayerMessage playerMessage) {
        if (!this.C) {
            if (this.f5340k.getThread().isAlive()) {
                this.f5338i.c(14, playerMessage).a();
                return;
            }
        }
        Log.h("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        playerMessage.k(false);
    }

    public void f1(int i2) {
        this.f5338i.f(11, i2, 0).a();
    }

    public boolean handleMessage(Message message) {
        int i2;
        MediaPeriodHolder u2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Message message2 = message;
        int i3 = 1000;
        try {
            switch (message2.what) {
                case 1:
                    if (message2.arg1 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i4 = message2.arg2;
                    b1(z2, i4 >> 4, true, i4 & 15);
                    break;
                case 2:
                    w();
                    break;
                case 3:
                    M0((SeekPosition) message2.obj);
                    break;
                case 4:
                    d1((PlaybackParameters) message2.obj);
                    break;
                case 5:
                    h1((SeekParameters) message2.obj);
                    break;
                case 6:
                    t1(false, true);
                    break;
                case 7:
                    u0();
                    return true;
                case 8:
                    P((MediaPeriod) message2.obj);
                    break;
                case 9:
                    L((MediaPeriod) message2.obj);
                    break;
                case 10:
                    y0();
                    break;
                case 11:
                    g1(message2.arg1);
                    break;
                case 12:
                    if (message2.arg1 != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    j1(z3);
                    break;
                case 13:
                    if (message2.arg1 != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    U0(z4, (AtomicBoolean) message2.obj);
                    break;
                case 14:
                    P0((PlayerMessage) message2.obj);
                    break;
                case 15:
                    R0((PlayerMessage) message2.obj);
                    break;
                case 16:
                    R((PlaybackParameters) message2.obj, false);
                    break;
                case 17:
                    W0((MediaSourceListUpdateMessage) message2.obj);
                    break;
                case 18:
                    o((MediaSourceListUpdateMessage) message2.obj, message2.arg1);
                    break;
                case 19:
                    m0((MoveMediaItemsMessage) message2.obj);
                    break;
                case 20:
                    w0(message2.arg1, message2.arg2, (ShuffleOrder) message2.obj);
                    break;
                case 21:
                    k1((ShuffleOrder) message2.obj);
                    break;
                case 22:
                    l0();
                    break;
                case 23:
                    if (message2.arg1 != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    Z0(z5);
                    break;
                case 25:
                    s();
                    break;
                case 26:
                    z0();
                    break;
                case 27:
                    x1(message2.arg1, message2.arg2, (List) message2.obj);
                    break;
                case 28:
                    e1((ExoPlayer.PreloadConfiguration) message2.obj);
                    break;
                case 29:
                    s0();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            ExoPlaybackException exoPlaybackException = e2;
            if (exoPlaybackException.f5236k == 1 && (u2 = this.f5349t.u()) != null) {
                exoPlaybackException = exoPlaybackException.c(u2.f5406f.f5416a);
            }
            if (!exoPlaybackException.f5242q || !(this.T == null || (i2 = exoPlaybackException.f4300b) == 5004 || i2 == 5003)) {
                ExoPlaybackException exoPlaybackException2 = this.T;
                if (exoPlaybackException2 != null) {
                    exoPlaybackException2.addSuppressed(exoPlaybackException);
                    exoPlaybackException = this.T;
                }
                ExoPlaybackException exoPlaybackException3 = exoPlaybackException;
                Log.d("ExoPlayerImplInternal", "Playback error", exoPlaybackException3);
                if (exoPlaybackException3.f5236k == 1 && this.f5349t.t() != this.f5349t.u()) {
                    while (this.f5349t.t() != this.f5349t.u()) {
                        this.f5349t.b();
                    }
                    d0();
                    MediaPeriodInfo mediaPeriodInfo = ((MediaPeriodHolder) Assertions.f(this.f5349t.t())).f5406f;
                    MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f5416a;
                    long j2 = mediaPeriodInfo.f5417b;
                    this.A = S(mediaPeriodId, j2, mediaPeriodInfo.f5418c, j2, true, 0);
                }
                t1(true, false);
                this.A = this.A.f(exoPlaybackException3);
            } else {
                Log.i("ExoPlayerImplInternal", "Recoverable renderer error", exoPlaybackException);
                ExoPlaybackException exoPlaybackException4 = this.T;
                if (exoPlaybackException4 != null) {
                    exoPlaybackException4.addSuppressed(exoPlaybackException);
                    exoPlaybackException = this.T;
                } else {
                    this.T = exoPlaybackException;
                }
                HandlerWrapper handlerWrapper = this.f5338i;
                handlerWrapper.k(handlerWrapper.c(25, exoPlaybackException));
            }
        } catch (DrmSession.DrmSessionException e3) {
            DrmSession.DrmSessionException drmSessionException = e3;
            M(drmSessionException, drmSessionException.f6221b);
        } catch (ParserException e4) {
            ParserException parserException = e4;
            int i5 = parserException.f4293c;
            if (i5 == 1) {
                if (parserException.f4292b) {
                    i3 = 3001;
                } else {
                    i3 = AuthApiStatusCodes.AUTH_API_SERVER_ERROR;
                }
            } else if (i5 == 4) {
                if (parserException.f4292b) {
                    i3 = 3002;
                } else {
                    i3 = AuthApiStatusCodes.AUTH_TOKEN_ERROR;
                }
            }
            M(parserException, i3);
        } catch (DataSourceException e5) {
            DataSourceException dataSourceException = e5;
            M(dataSourceException, dataSourceException.f4816b);
        } catch (BehindLiveWindowException e6) {
            M(e6, 1002);
        } catch (IOException e7) {
            M(e7, 2000);
        } catch (RuntimeException e8) {
            RuntimeException runtimeException = e8;
            if ((runtimeException instanceof IllegalStateException) || (runtimeException instanceof IllegalArgumentException)) {
                i3 = GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION;
            }
            ExoPlaybackException f2 = ExoPlaybackException.f(runtimeException, i3);
            Log.d("ExoPlayerImplInternal", "Playback error", f2);
            t1(true, false);
            this.A = this.A.f(f2);
        }
        d0();
        return true;
    }

    public void i1(boolean z2) {
        this.f5338i.f(12, z2 ? 1 : 0, 0).a();
    }

    public void m(MediaPeriod mediaPeriod) {
        this.f5338i.c(8, mediaPeriod).a();
    }

    /* renamed from: q0 */
    public void p(MediaPeriod mediaPeriod) {
        this.f5338i.c(9, mediaPeriod).a();
    }

    public void r(PlaybackParameters playbackParameters) {
        this.f5338i.c(16, playbackParameters).a();
    }

    public void r0() {
        this.f5338i.a(29).a();
    }

    public void s1() {
        this.f5338i.a(6).a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean t0() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.C     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0026
            android.os.Looper r0 = r3.f5340k     // Catch:{ all -> 0x0029 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0029 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            androidx.media3.common.util.HandlerWrapper r0 = r3.f5338i     // Catch:{ all -> 0x0029 }
            r1 = 7
            r0.h(r1)     // Catch:{ all -> 0x0029 }
            androidx.media3.exoplayer.g0 r0 = new androidx.media3.exoplayer.g0     // Catch:{ all -> 0x0029 }
            r0.<init>(r3)     // Catch:{ all -> 0x0029 }
            long r1 = r3.f5352w     // Catch:{ all -> 0x0029 }
            r3.D1(r0, r1)     // Catch:{ all -> 0x0029 }
            boolean r0 = r3.C     // Catch:{ all -> 0x0029 }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.t0():boolean");
    }
}
