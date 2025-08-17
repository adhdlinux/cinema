package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.MediaMetricsListener;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import w0.c;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private final AudioFocusManager A;
    /* access modifiers changed from: private */
    public final StreamVolumeManager B;
    private final WakeLockManager C;
    private final WifiLockManager D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private SeekParameters L;
    private ShuffleOrder M;
    private boolean N;
    private Player.Commands O;
    /* access modifiers changed from: private */
    public MediaMetadata P;
    private MediaMetadata Q;
    /* access modifiers changed from: private */
    public Format R;
    /* access modifiers changed from: private */
    public Format S;
    private AudioTrack T;
    /* access modifiers changed from: private */
    public Object U;
    private Surface V;
    private SurfaceHolder W;
    private SphericalGLSurfaceView X;
    /* access modifiers changed from: private */
    public boolean Y;
    private TextureView Z;

    /* renamed from: a0  reason: collision with root package name */
    private int f22931a0;

    /* renamed from: b  reason: collision with root package name */
    final TrackSelectorResult f22932b;

    /* renamed from: b0  reason: collision with root package name */
    private int f22933b0;

    /* renamed from: c  reason: collision with root package name */
    final Player.Commands f22934c;

    /* renamed from: c0  reason: collision with root package name */
    private Size f22935c0;

    /* renamed from: d  reason: collision with root package name */
    private final ConditionVariable f22936d;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public DecoderCounters f22937d0;

    /* renamed from: e  reason: collision with root package name */
    private final Context f22938e;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public DecoderCounters f22939e0;

    /* renamed from: f  reason: collision with root package name */
    private final Player f22940f;

    /* renamed from: f0  reason: collision with root package name */
    private int f22941f0;

    /* renamed from: g  reason: collision with root package name */
    private final Renderer[] f22942g;

    /* renamed from: g0  reason: collision with root package name */
    private AudioAttributes f22943g0;

    /* renamed from: h  reason: collision with root package name */
    private final TrackSelector f22944h;

    /* renamed from: h0  reason: collision with root package name */
    private float f22945h0;

    /* renamed from: i  reason: collision with root package name */
    private final HandlerWrapper f22946i;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public boolean f22947i0;

    /* renamed from: j  reason: collision with root package name */
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener f22948j;
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public CueGroup f22949j0;

    /* renamed from: k  reason: collision with root package name */
    private final ExoPlayerImplInternal f22950k;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f22951k0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final ListenerSet<Player.Listener> f22952l;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f22953l0;

    /* renamed from: m  reason: collision with root package name */
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> f22954m;

    /* renamed from: m0  reason: collision with root package name */
    private PriorityTaskManager f22955m0;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline.Period f22956n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f22957n0;

    /* renamed from: o  reason: collision with root package name */
    private final List<MediaSourceHolderSnapshot> f22958o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f22959o0;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f22960p;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public DeviceInfo f22961p0;

    /* renamed from: q  reason: collision with root package name */
    private final MediaSource.Factory f22962q;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public VideoSize f22963q0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final AnalyticsCollector f22964r;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public MediaMetadata f22965r0;

    /* renamed from: s  reason: collision with root package name */
    private final Looper f22966s;

    /* renamed from: s0  reason: collision with root package name */
    private PlaybackInfo f22967s0;

    /* renamed from: t  reason: collision with root package name */
    private final BandwidthMeter f22968t;

    /* renamed from: t0  reason: collision with root package name */
    private int f22969t0;

    /* renamed from: u  reason: collision with root package name */
    private final long f22970u;

    /* renamed from: u0  reason: collision with root package name */
    private int f22971u0;

    /* renamed from: v  reason: collision with root package name */
    private final long f22972v;

    /* renamed from: v0  reason: collision with root package name */
    private long f22973v0;

    /* renamed from: w  reason: collision with root package name */
    private final Clock f22974w;

    /* renamed from: x  reason: collision with root package name */
    private final ComponentListener f22975x;

    /* renamed from: y  reason: collision with root package name */
    private final FrameMetadataListener f22976y;

    /* renamed from: z  reason: collision with root package name */
    private final AudioBecomingNoisyManager f22977z;

    private static final class Api31 {
        private Api31() {
        }

        public static PlayerId a(Context context, ExoPlayerImpl exoPlayerImpl, boolean z2) {
            MediaMetricsListener B0 = MediaMetricsListener.B0(context);
            if (B0 == null) {
                Log.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z2) {
                exoPlayerImpl.m1(B0);
            }
            return new PlayerId(B0.I0());
        }
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void N(Player.Listener listener) {
            listener.onMediaMetadataChanged(ExoPlayerImpl.this.P);
        }

        public /* synthetic */ void A(boolean z2) {
            f.a(this, z2);
        }

        public void B(boolean z2) {
            ExoPlayerImpl.this.J2();
        }

        public /* synthetic */ void C(Format format) {
            b.a(this, format);
        }

        public void a(Exception exc) {
            ExoPlayerImpl.this.f22964r.a(exc);
        }

        public void b(String str) {
            ExoPlayerImpl.this.f22964r.b(str);
        }

        public void c(String str, long j2, long j3) {
            ExoPlayerImpl.this.f22964r.c(str, j2, j3);
        }

        public void d(String str) {
            ExoPlayerImpl.this.f22964r.d(str);
        }

        public void e(String str, long j2, long j3) {
            ExoPlayerImpl.this.f22964r.e(str, j2, j3);
        }

        public void f(long j2) {
            ExoPlayerImpl.this.f22964r.f(j2);
        }

        public void g(Exception exc) {
            ExoPlayerImpl.this.f22964r.g(exc);
        }

        public void h(int i2, long j2) {
            ExoPlayerImpl.this.f22964r.h(i2, j2);
        }

        public void i(Object obj, long j2) {
            ExoPlayerImpl.this.f22964r.i(obj, j2);
            if (ExoPlayerImpl.this.U == obj) {
                ExoPlayerImpl.this.f22952l.l(26, new t0());
            }
        }

        public void j(Exception exc) {
            ExoPlayerImpl.this.f22964r.j(exc);
        }

        public void k(int i2, long j2, long j3) {
            ExoPlayerImpl.this.f22964r.k(i2, j2, j3);
        }

        public void l(long j2, int i2) {
            ExoPlayerImpl.this.f22964r.l(j2, i2);
        }

        public void m(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.f22939e0 = decoderCounters;
            ExoPlayerImpl.this.f22964r.m(decoderCounters);
        }

        public void n(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.R = format;
            ExoPlayerImpl.this.f22964r.n(format, decoderReuseEvaluation);
        }

        public void o(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f22964r.o(decoderCounters);
            Format unused = ExoPlayerImpl.this.R = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.f22937d0 = null;
        }

        public void onCues(List<Cue> list) {
            ExoPlayerImpl.this.f22952l.l(27, new p0(list));
        }

        public void onMetadata(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata unused = exoPlayerImpl.f22965r0 = exoPlayerImpl.f22965r0.b().K(metadata).H();
            MediaMetadata Q0 = ExoPlayerImpl.this.q1();
            if (!Q0.equals(ExoPlayerImpl.this.P)) {
                MediaMetadata unused2 = ExoPlayerImpl.this.P = Q0;
                ExoPlayerImpl.this.f22952l.i(14, new n0(this));
            }
            ExoPlayerImpl.this.f22952l.i(28, new o0(metadata));
            ExoPlayerImpl.this.f22952l.f();
        }

        public void onSkipSilenceEnabledChanged(boolean z2) {
            if (ExoPlayerImpl.this.f22947i0 != z2) {
                boolean unused = ExoPlayerImpl.this.f22947i0 = z2;
                ExoPlayerImpl.this.f22952l.l(23, new v0(z2));
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.z2(surfaceTexture);
            ExoPlayerImpl.this.m2(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.A2((Object) null);
            ExoPlayerImpl.this.m2(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.m2(i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            VideoSize unused = ExoPlayerImpl.this.f22963q0 = videoSize;
            ExoPlayerImpl.this.f22952l.l(25, new u0(videoSize));
        }

        public void p(int i2) {
            DeviceInfo b12 = ExoPlayerImpl.t1(ExoPlayerImpl.this.B);
            if (!b12.equals(ExoPlayerImpl.this.f22961p0)) {
                DeviceInfo unused = ExoPlayerImpl.this.f22961p0 = b12;
                ExoPlayerImpl.this.f22952l.l(29, new q0(b12));
            }
        }

        public void q() {
            ExoPlayerImpl.this.G2(false, -1, 3);
        }

        public void r(Surface surface) {
            ExoPlayerImpl.this.A2((Object) null);
        }

        public void s(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f22964r.s(decoderCounters);
            Format unused = ExoPlayerImpl.this.S = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.f22939e0 = null;
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ExoPlayerImpl.this.m2(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.Y) {
                ExoPlayerImpl.this.A2(surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.Y) {
                ExoPlayerImpl.this.A2((Object) null);
            }
            ExoPlayerImpl.this.m2(0, 0);
        }

        public void t(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.S = format;
            ExoPlayerImpl.this.f22964r.t(format, decoderReuseEvaluation);
        }

        public void u(Surface surface) {
            ExoPlayerImpl.this.A2(surface);
        }

        public void v(int i2, boolean z2) {
            ExoPlayerImpl.this.f22952l.l(30, new r0(i2, z2));
        }

        public void w(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.f22937d0 = decoderCounters;
            ExoPlayerImpl.this.f22964r.w(decoderCounters);
        }

        public /* synthetic */ void x(Format format) {
            c.a(this, format);
        }

        public void y(float f2) {
            ExoPlayerImpl.this.t2();
        }

        public void z(int i2) {
            boolean A = ExoPlayerImpl.this.A();
            ExoPlayerImpl.this.G2(A, i2, ExoPlayerImpl.E1(A, i2));
        }

        public void onCues(CueGroup cueGroup) {
            CueGroup unused = ExoPlayerImpl.this.f22949j0 = cueGroup;
            ExoPlayerImpl.this.f22952l.l(27, new s0(cueGroup));
        }
    }

    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {

        /* renamed from: b  reason: collision with root package name */
        private VideoFrameMetadataListener f22979b;

        /* renamed from: c  reason: collision with root package name */
        private CameraMotionListener f22980c;

        /* renamed from: d  reason: collision with root package name */
        private VideoFrameMetadataListener f22981d;

        /* renamed from: e  reason: collision with root package name */
        private CameraMotionListener f22982e;

        private FrameMetadataListener() {
        }

        public void b(long j2, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f22982e;
            if (cameraMotionListener != null) {
                cameraMotionListener.b(j2, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f22980c;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.b(j2, fArr);
            }
        }

        public void c() {
            CameraMotionListener cameraMotionListener = this.f22982e;
            if (cameraMotionListener != null) {
                cameraMotionListener.c();
            }
            CameraMotionListener cameraMotionListener2 = this.f22980c;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.c();
            }
        }

        public void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.f22981d;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.e(j2, j3, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f22979b;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.e(j2, j3, format, mediaFormat);
            }
        }

        public void j(int i2, Object obj) {
            if (i2 == 7) {
                this.f22979b = (VideoFrameMetadataListener) obj;
            } else if (i2 == 8) {
                this.f22980c = (CameraMotionListener) obj;
            } else if (i2 == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    this.f22981d = null;
                    this.f22982e = null;
                    return;
                }
                this.f22981d = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f22982e = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        private final Object f22983a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Timeline f22984b;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline) {
            this.f22983a = obj;
            this.f22984b = timeline;
        }

        public Object a() {
            return this.f22983a;
        }

        public Timeline b() {
            return this.f22984b;
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r40v0, types: [com.google.android.exoplayer2.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(com.google.android.exoplayer2.ExoPlayer.Builder r39, com.google.android.exoplayer2.Player r40) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r38.<init>()
            com.google.android.exoplayer2.util.ConditionVariable r2 = new com.google.android.exoplayer2.util.ConditionVariable
            r2.<init>()
            r1.f22936d = r2
            java.lang.String r3 = "ExoPlayerImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0348 }
            r4.<init>()     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "Init "
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            int r5 = java.lang.System.identityHashCode(r38)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ all -> 0x0348 }
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = " ["
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "ExoPlayerLib/2.18.7"
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "] ["
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.f28812e     // Catch:{ all -> 0x0348 }
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r5 = "]"
            r4.append(r5)     // Catch:{ all -> 0x0348 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Log.f(r3, r4)     // Catch:{ all -> 0x0348 }
            android.content.Context r3 = r0.f22905a     // Catch:{ all -> 0x0348 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0348 }
            r1.f22938e = r3     // Catch:{ all -> 0x0348 }
            com.google.common.base.Function<com.google.android.exoplayer2.util.Clock, com.google.android.exoplayer2.analytics.AnalyticsCollector> r4 = r0.f22913i     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Clock r5 = r0.f22906b     // Catch:{ all -> 0x0348 }
            java.lang.Object r4 = r4.apply(r5)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.analytics.AnalyticsCollector r4 = (com.google.android.exoplayer2.analytics.AnalyticsCollector) r4     // Catch:{ all -> 0x0348 }
            r1.f22964r = r4     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.PriorityTaskManager r5 = r0.f22915k     // Catch:{ all -> 0x0348 }
            r1.f22955m0 = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r5 = r0.f22916l     // Catch:{ all -> 0x0348 }
            r1.f22943g0 = r5     // Catch:{ all -> 0x0348 }
            int r5 = r0.f22921q     // Catch:{ all -> 0x0348 }
            r1.f22931a0 = r5     // Catch:{ all -> 0x0348 }
            int r5 = r0.f22922r     // Catch:{ all -> 0x0348 }
            r1.f22933b0 = r5     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.f22920p     // Catch:{ all -> 0x0348 }
            r1.f22947i0 = r5     // Catch:{ all -> 0x0348 }
            long r5 = r0.f22929y     // Catch:{ all -> 0x0348 }
            r1.E = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener r15 = new com.google.android.exoplayer2.ExoPlayerImpl$ComponentListener     // Catch:{ all -> 0x0348 }
            r14 = 0
            r15.<init>()     // Catch:{ all -> 0x0348 }
            r1.f22975x = r15     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener r13 = new com.google.android.exoplayer2.ExoPlayerImpl$FrameMetadataListener     // Catch:{ all -> 0x0348 }
            r13.<init>()     // Catch:{ all -> 0x0348 }
            r1.f22976y = r13     // Catch:{ all -> 0x0348 }
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x0348 }
            android.os.Looper r5 = r0.f22914j     // Catch:{ all -> 0x0348 }
            r6.<init>(r5)     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.RenderersFactory> r5 = r0.f22908d     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r7 = r5
            com.google.android.exoplayer2.RenderersFactory r7 = (com.google.android.exoplayer2.RenderersFactory) r7     // Catch:{ all -> 0x0348 }
            r8 = r6
            r9 = r15
            r10 = r15
            r11 = r15
            r12 = r15
            com.google.android.exoplayer2.Renderer[] r7 = r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0348 }
            r1.f22942g = r7     // Catch:{ all -> 0x0348 }
            int r5 = r7.length     // Catch:{ all -> 0x0348 }
            r12 = 0
            if (r5 <= 0) goto L_0x00a1
            r5 = 1
            goto L_0x00a2
        L_0x00a1:
            r5 = 0
        L_0x00a2:
            com.google.android.exoplayer2.util.Assertions.g(r5)     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.trackselection.TrackSelector> r5 = r0.f22910f     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r10 = r5
            com.google.android.exoplayer2.trackselection.TrackSelector r10 = (com.google.android.exoplayer2.trackselection.TrackSelector) r10     // Catch:{ all -> 0x0348 }
            r1.f22944h = r10     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.source.MediaSource$Factory> r5 = r0.f22909e     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.source.MediaSource$Factory r5 = (com.google.android.exoplayer2.source.MediaSource.Factory) r5     // Catch:{ all -> 0x0348 }
            r1.f22962q = r5     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.upstream.BandwidthMeter> r5 = r0.f22912h     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r9 = r5
            com.google.android.exoplayer2.upstream.BandwidthMeter r9 = (com.google.android.exoplayer2.upstream.BandwidthMeter) r9     // Catch:{ all -> 0x0348 }
            r1.f22968t = r9     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.f22923s     // Catch:{ all -> 0x0348 }
            r1.f22960p = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.SeekParameters r5 = r0.f22924t     // Catch:{ all -> 0x0348 }
            r1.L = r5     // Catch:{ all -> 0x0348 }
            r16 = r15
            long r14 = r0.f22925u     // Catch:{ all -> 0x0348 }
            r1.f22970u = r14     // Catch:{ all -> 0x0348 }
            long r14 = r0.f22926v     // Catch:{ all -> 0x0348 }
            r1.f22972v = r14     // Catch:{ all -> 0x0348 }
            boolean r5 = r0.f22930z     // Catch:{ all -> 0x0348 }
            r1.N = r5     // Catch:{ all -> 0x0348 }
            android.os.Looper r15 = r0.f22914j     // Catch:{ all -> 0x0348 }
            r1.f22966s = r15     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Clock r14 = r0.f22906b     // Catch:{ all -> 0x0348 }
            r1.f22974w = r14     // Catch:{ all -> 0x0348 }
            if (r40 != 0) goto L_0x00e7
            r5 = r1
            goto L_0x00e9
        L_0x00e7:
            r5 = r40
        L_0x00e9:
            r1.f22940f = r5     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.ListenerSet r8 = new com.google.android.exoplayer2.util.ListenerSet     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.z r11 = new com.google.android.exoplayer2.z     // Catch:{ all -> 0x0348 }
            r11.<init>(r1)     // Catch:{ all -> 0x0348 }
            r8.<init>(r15, r14, r11)     // Catch:{ all -> 0x0348 }
            r1.f22952l = r8     // Catch:{ all -> 0x0348 }
            java.util.concurrent.CopyOnWriteArraySet r8 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x0348 }
            r8.<init>()     // Catch:{ all -> 0x0348 }
            r1.f22954m = r8     // Catch:{ all -> 0x0348 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0348 }
            r8.<init>()     // Catch:{ all -> 0x0348 }
            r1.f22958o = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder r8 = new com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder     // Catch:{ all -> 0x0348 }
            r8.<init>(r12)     // Catch:{ all -> 0x0348 }
            r1.M = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r8 = new com.google.android.exoplayer2.trackselection.TrackSelectorResult     // Catch:{ all -> 0x0348 }
            int r11 = r7.length     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.RendererConfiguration[] r11 = new com.google.android.exoplayer2.RendererConfiguration[r11]     // Catch:{ all -> 0x0348 }
            int r12 = r7.length     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r12 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection[r12]     // Catch:{ all -> 0x0348 }
            r20 = r6
            com.google.android.exoplayer2.Tracks r6 = com.google.android.exoplayer2.Tracks.f23528c     // Catch:{ all -> 0x0348 }
            r21 = r9
            r9 = 0
            r8.<init>(r11, r12, r6, r9)     // Catch:{ all -> 0x0348 }
            r1.f22932b = r8     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Timeline$Period r6 = new com.google.android.exoplayer2.Timeline$Period     // Catch:{ all -> 0x0348 }
            r6.<init>()     // Catch:{ all -> 0x0348 }
            r1.f22956n = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x0348 }
            r6.<init>()     // Catch:{ all -> 0x0348 }
            r12 = 21
            int[] r9 = new int[r12]     // Catch:{ all -> 0x0348 }
            r11 = 1
            r18 = 0
            r9[r18] = r11     // Catch:{ all -> 0x0348 }
            r12 = 2
            r9[r11] = r12     // Catch:{ all -> 0x0348 }
            r24 = r2
            r2 = 3
            r9[r12] = r2     // Catch:{ all -> 0x0348 }
            r19 = 13
            r9[r2] = r19     // Catch:{ all -> 0x0348 }
            r22 = 14
            r2 = 4
            r9[r2] = r22     // Catch:{ all -> 0x0348 }
            r23 = 15
            r2 = 5
            r9[r2] = r23     // Catch:{ all -> 0x0348 }
            r25 = 16
            r2 = 6
            r9[r2] = r25     // Catch:{ all -> 0x0348 }
            r26 = 17
            r2 = 7
            r9[r2] = r26     // Catch:{ all -> 0x0348 }
            r27 = 18
            r2 = 8
            r9[r2] = r27     // Catch:{ all -> 0x0348 }
            r28 = 19
            r2 = 9
            r9[r2] = r28     // Catch:{ all -> 0x0348 }
            r11 = 31
            r2 = 10
            r9[r2] = r11     // Catch:{ all -> 0x0348 }
            r29 = 11
            r30 = 20
            r9[r29] = r30     // Catch:{ all -> 0x0348 }
            r29 = 12
            r31 = 30
            r9[r29] = r31     // Catch:{ all -> 0x0348 }
            r29 = 21
            r9[r19] = r29     // Catch:{ all -> 0x0348 }
            r19 = 22
            r9[r22] = r19     // Catch:{ all -> 0x0348 }
            r19 = 23
            r9[r23] = r19     // Catch:{ all -> 0x0348 }
            r19 = 24
            r9[r25] = r19     // Catch:{ all -> 0x0348 }
            r19 = 25
            r9[r26] = r19     // Catch:{ all -> 0x0348 }
            r19 = 26
            r9[r27] = r19     // Catch:{ all -> 0x0348 }
            r19 = 27
            r9[r28] = r19     // Catch:{ all -> 0x0348 }
            r19 = 28
            r9[r30] = r19     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.c(r9)     // Catch:{ all -> 0x0348 }
            boolean r9 = r10.e()     // Catch:{ all -> 0x0348 }
            r12 = 29
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.d(r12, r9)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands r6 = r6.e()     // Catch:{ all -> 0x0348 }
            r1.f22934c = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r9 = new com.google.android.exoplayer2.Player$Commands$Builder     // Catch:{ all -> 0x0348 }
            r9.<init>()     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r9.b(r6)     // Catch:{ all -> 0x0348 }
            r9 = 4
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.a(r9)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands$Builder r6 = r6.a(r2)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.Player$Commands r6 = r6.e()     // Catch:{ all -> 0x0348 }
            r1.O = r6     // Catch:{ all -> 0x0348 }
            r12 = 0
            com.google.android.exoplayer2.util.HandlerWrapper r6 = r14.b(r15, r12)     // Catch:{ all -> 0x0348 }
            r1.f22946i = r6     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.f0 r9 = new com.google.android.exoplayer2.f0     // Catch:{ all -> 0x0348 }
            r9.<init>(r1)     // Catch:{ all -> 0x0348 }
            r1.f22948j = r9     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.PlaybackInfo r6 = com.google.android.exoplayer2.PlaybackInfo.j(r8)     // Catch:{ all -> 0x0348 }
            r1.f22967s0 = r6     // Catch:{ all -> 0x0348 }
            r4.x(r5, r15)     // Catch:{ all -> 0x0348 }
            int r6 = com.google.android.exoplayer2.util.Util.f28808a     // Catch:{ all -> 0x0348 }
            if (r6 >= r11) goto L_0x01e0
            com.google.android.exoplayer2.analytics.PlayerId r5 = new com.google.android.exoplayer2.analytics.PlayerId     // Catch:{ all -> 0x0348 }
            r5.<init>()     // Catch:{ all -> 0x0348 }
            goto L_0x01e6
        L_0x01e0:
            boolean r5 = r0.A     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.analytics.PlayerId r5 = com.google.android.exoplayer2.ExoPlayerImpl.Api31.a(r3, r1, r5)     // Catch:{ all -> 0x0348 }
        L_0x01e6:
            r22 = r5
            com.google.android.exoplayer2.ExoPlayerImplInternal r11 = new com.google.android.exoplayer2.ExoPlayerImplInternal     // Catch:{ all -> 0x0348 }
            com.google.common.base.Supplier<com.google.android.exoplayer2.LoadControl> r5 = r0.f22911g     // Catch:{ all -> 0x0348 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0348 }
            r17 = r5
            com.google.android.exoplayer2.LoadControl r17 = (com.google.android.exoplayer2.LoadControl) r17     // Catch:{ all -> 0x0348 }
            int r5 = r1.F     // Catch:{ all -> 0x0348 }
            boolean r12 = r1.G     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.SeekParameters r2 = r1.L     // Catch:{ all -> 0x0348 }
            r23 = r15
            com.google.android.exoplayer2.LivePlaybackSpeedControl r15 = r0.f22927w     // Catch:{ all -> 0x0348 }
            r27 = r2
            r26 = r3
            long r2 = r0.f22928x     // Catch:{ all -> 0x0348 }
            r30 = r2
            boolean r2 = r1.N     // Catch:{ all -> 0x0348 }
            android.os.Looper r3 = r0.B     // Catch:{ all -> 0x0348 }
            r28 = r5
            r5 = r11
            r0 = r6
            r32 = r20
            r6 = r7
            r7 = r10
            r33 = r21
            r21 = r9
            r9 = r17
            r34 = r10
            r10 = r33
            r35 = r0
            r0 = r11
            r11 = r28
            r17 = 0
            r36 = r13
            r13 = r4
            r20 = r14
            r28 = r17
            r14 = r27
            r37 = r16
            r40 = r23
            r16 = r30
            r18 = r2
            r19 = r40
            r23 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0348 }
            r1.f22950k = r0     // Catch:{ all -> 0x0348 }
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.f22945h0 = r2     // Catch:{ all -> 0x0348 }
            r2 = 0
            r1.F = r2     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.J     // Catch:{ all -> 0x0348 }
            r1.P = r3     // Catch:{ all -> 0x0348 }
            r1.Q = r3     // Catch:{ all -> 0x0348 }
            r1.f22965r0 = r3     // Catch:{ all -> 0x0348 }
            r3 = -1
            r1.f22969t0 = r3     // Catch:{ all -> 0x0348 }
            r3 = r35
            r5 = 21
            if (r3 >= r5) goto L_0x025c
            int r3 = r1.K1(r2)     // Catch:{ all -> 0x0348 }
            r1.f22941f0 = r3     // Catch:{ all -> 0x0348 }
            goto L_0x0262
        L_0x025c:
            int r3 = com.google.android.exoplayer2.util.Util.F(r26)     // Catch:{ all -> 0x0348 }
            r1.f22941f0 = r3     // Catch:{ all -> 0x0348 }
        L_0x0262:
            com.google.android.exoplayer2.text.CueGroup r3 = com.google.android.exoplayer2.text.CueGroup.f27236d     // Catch:{ all -> 0x0348 }
            r1.f22949j0 = r3     // Catch:{ all -> 0x0348 }
            r3 = 1
            r1.f22951k0 = r3     // Catch:{ all -> 0x0348 }
            r1.X(r4)     // Catch:{ all -> 0x0348 }
            android.os.Handler r5 = new android.os.Handler     // Catch:{ all -> 0x0348 }
            r6 = r40
            r5.<init>(r6)     // Catch:{ all -> 0x0348 }
            r6 = r33
            r6.g(r5, r4)     // Catch:{ all -> 0x0348 }
            r4 = r37
            r1.n1(r4)     // Catch:{ all -> 0x0348 }
            r5 = r39
            long r6 = r5.f22907c     // Catch:{ all -> 0x0348 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x028a
            r0.v(r6)     // Catch:{ all -> 0x0348 }
        L_0x028a:
            com.google.android.exoplayer2.AudioBecomingNoisyManager r0 = new com.google.android.exoplayer2.AudioBecomingNoisyManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.f22905a     // Catch:{ all -> 0x0348 }
            r7 = r32
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.f22977z = r0     // Catch:{ all -> 0x0348 }
            boolean r6 = r5.f22919o     // Catch:{ all -> 0x0348 }
            r0.b(r6)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.AudioFocusManager r0 = new com.google.android.exoplayer2.AudioFocusManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.f22905a     // Catch:{ all -> 0x0348 }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.A = r0     // Catch:{ all -> 0x0348 }
            boolean r6 = r5.f22917m     // Catch:{ all -> 0x0348 }
            if (r6 == 0) goto L_0x02aa
            com.google.android.exoplayer2.audio.AudioAttributes r14 = r1.f22943g0     // Catch:{ all -> 0x0348 }
            goto L_0x02ac
        L_0x02aa:
            r14 = r28
        L_0x02ac:
            r0.m(r14)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.StreamVolumeManager r0 = new com.google.android.exoplayer2.StreamVolumeManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.f22905a     // Catch:{ all -> 0x0348 }
            r0.<init>(r6, r7, r4)     // Catch:{ all -> 0x0348 }
            r1.B = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r4 = r1.f22943g0     // Catch:{ all -> 0x0348 }
            int r4 = r4.f23664d     // Catch:{ all -> 0x0348 }
            int r4 = com.google.android.exoplayer2.util.Util.h0(r4)     // Catch:{ all -> 0x0348 }
            r0.h(r4)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.WakeLockManager r4 = new com.google.android.exoplayer2.WakeLockManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.f22905a     // Catch:{ all -> 0x0348 }
            r4.<init>(r6)     // Catch:{ all -> 0x0348 }
            r1.C = r4     // Catch:{ all -> 0x0348 }
            int r6 = r5.f22918n     // Catch:{ all -> 0x0348 }
            if (r6 == 0) goto L_0x02d2
            r12 = 1
            goto L_0x02d3
        L_0x02d2:
            r12 = 0
        L_0x02d3:
            r4.a(r12)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.WifiLockManager r4 = new com.google.android.exoplayer2.WifiLockManager     // Catch:{ all -> 0x0348 }
            android.content.Context r6 = r5.f22905a     // Catch:{ all -> 0x0348 }
            r4.<init>(r6)     // Catch:{ all -> 0x0348 }
            r1.D = r4     // Catch:{ all -> 0x0348 }
            int r5 = r5.f22918n     // Catch:{ all -> 0x0348 }
            r6 = 2
            if (r5 != r6) goto L_0x02e6
            r12 = 1
            goto L_0x02e7
        L_0x02e6:
            r12 = 0
        L_0x02e7:
            r4.a(r12)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.DeviceInfo r0 = t1(r0)     // Catch:{ all -> 0x0348 }
            r1.f22961p0 = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.video.VideoSize r0 = com.google.android.exoplayer2.video.VideoSize.f28956f     // Catch:{ all -> 0x0348 }
            r1.f22963q0 = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.util.Size r0 = com.google.android.exoplayer2.util.Size.f28781c     // Catch:{ all -> 0x0348 }
            r1.f22935c0 = r0     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.f22943g0     // Catch:{ all -> 0x0348 }
            r5 = r34
            r5.i(r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.f22941f0     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 10
            r1.s2(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.f22941f0     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r1.s2(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r1.f22943g0     // Catch:{ all -> 0x0348 }
            r2 = 3
            r1.s2(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.f22931a0     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 4
            r1.s2(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            int r0 = r1.f22933b0     // Catch:{ all -> 0x0348 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 5
            r1.s2(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            boolean r0 = r1.f22947i0     // Catch:{ all -> 0x0348 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0348 }
            r2 = 9
            r1.s2(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            r0 = r36
            r2 = 7
            r1.s2(r6, r2, r0)     // Catch:{ all -> 0x0348 }
            r2 = 8
            r3 = 6
            r1.s2(r3, r2, r0)     // Catch:{ all -> 0x0348 }
            r24.f()
            return
        L_0x0348:
            r0 = move-exception
            com.google.android.exoplayer2.util.ConditionVariable r2 = r1.f22936d
            r2.f()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.<init>(com.google.android.exoplayer2.ExoPlayer$Builder, com.google.android.exoplayer2.Player):void");
    }

    /* access modifiers changed from: private */
    public void A2(Object obj) {
        boolean z2;
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        Renderer[] rendererArr = this.f22942g;
        int length = rendererArr.length;
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= length) {
                break;
            }
            Renderer renderer = rendererArr[i2];
            if (renderer.d() == 2) {
                arrayList.add(w1(renderer).n(1).m(obj).l());
            }
            i2++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                for (PlayerMessage a2 : arrayList) {
                    a2.a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z2 = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z2) {
            E2(false, ExoPlaybackException.i(new ExoTimeoutException(3), 1003));
        }
    }

    private long B1(PlaybackInfo playbackInfo) {
        if (playbackInfo.f23377a.u()) {
            return Util.F0(this.f22973v0);
        }
        if (playbackInfo.f23378b.b()) {
            return playbackInfo.f23394r;
        }
        return n2(playbackInfo.f23377a, playbackInfo.f23378b, playbackInfo.f23394r);
    }

    private int C1() {
        if (this.f22967s0.f23377a.u()) {
            return this.f22969t0;
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        return playbackInfo.f23377a.l(playbackInfo.f23378b.f25793a, this.f22956n).f23494d;
    }

    private Pair<Object, Long> D1(Timeline timeline, Timeline timeline2) {
        boolean z2;
        long K2 = K();
        int i2 = -1;
        if (timeline.u() || timeline2.u()) {
            if (timeline.u() || !timeline2.u()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                i2 = C1();
            }
            if (z2) {
                K2 = -9223372036854775807L;
            }
            return l2(timeline2, i2, K2);
        }
        Pair<Object, Long> n2 = timeline.n(this.f22800a, this.f22956n, M(), Util.F0(K2));
        Object obj = ((Pair) Util.j(n2)).first;
        if (timeline2.f(obj) != -1) {
            return n2;
        }
        Object z02 = ExoPlayerImplInternal.z0(this.f22800a, this.f22956n, this.F, this.G, obj, timeline, timeline2);
        if (z02 == null) {
            return l2(timeline2, -1, -9223372036854775807L);
        }
        timeline2.l(z02, this.f22956n);
        int i3 = this.f22956n.f23494d;
        return l2(timeline2, i3, timeline2.r(i3, this.f22800a).d());
    }

    /* access modifiers changed from: private */
    public static int E1(boolean z2, int i2) {
        return (!z2 || i2 == 1) ? 1 : 2;
    }

    private void E2(boolean z2, ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo;
        boolean z3;
        if (z2) {
            playbackInfo = p2(0, this.f22958o.size()).e((ExoPlaybackException) null);
        } else {
            PlaybackInfo playbackInfo2 = this.f22967s0;
            playbackInfo = playbackInfo2.b(playbackInfo2.f23378b);
            playbackInfo.f23392p = playbackInfo.f23394r;
            playbackInfo.f23393q = 0;
        }
        PlaybackInfo g2 = playbackInfo.g(1);
        if (exoPlaybackException != null) {
            g2 = g2.e(exoPlaybackException);
        }
        PlaybackInfo playbackInfo3 = g2;
        this.H++;
        this.f22950k.i1();
        if (!playbackInfo3.f23377a.u() || this.f22967s0.f23377a.u()) {
            z3 = false;
        } else {
            z3 = true;
        }
        H2(playbackInfo3, 0, 1, false, z3, 4, B1(playbackInfo3), -1, false);
    }

    private void F2() {
        Player.Commands commands = this.O;
        Player.Commands H2 = Util.H(this.f22940f, this.f22934c);
        this.O = H2;
        if (!H2.equals(commands)) {
            this.f22952l.i(13, new e0(this));
        }
    }

    private Player.PositionInfo G1(long j2) {
        int i2;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        long j3;
        int M2 = M();
        if (!this.f22967s0.f23377a.u()) {
            PlaybackInfo playbackInfo = this.f22967s0;
            Object obj3 = playbackInfo.f23378b.f25793a;
            playbackInfo.f23377a.l(obj3, this.f22956n);
            int f2 = this.f22967s0.f23377a.f(obj3);
            i2 = f2;
            obj = obj3;
            obj2 = this.f22967s0.f23377a.r(M2, this.f22800a).f23511b;
            mediaItem = this.f22800a.f23513d;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
            i2 = -1;
        }
        long i12 = Util.i1(j2);
        if (this.f22967s0.f23378b.b()) {
            j3 = Util.i1(I1(this.f22967s0));
        } else {
            j3 = i12;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.f22967s0.f23378b;
        return new Player.PositionInfo(obj2, M2, mediaItem, obj, i2, i12, j3, mediaPeriodId.f25794b, mediaPeriodId.f25795c);
    }

    /* access modifiers changed from: private */
    public void G2(boolean z2, int i2, int i3) {
        boolean z3;
        int i4 = 0;
        if (!z2 || i2 == -1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 && i2 != 1) {
            i4 = 1;
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        if (playbackInfo.f23388l != z3 || playbackInfo.f23389m != i4) {
            this.H++;
            PlaybackInfo d2 = playbackInfo.d(z3, i4);
            this.f22950k.R0(z3, i4);
            H2(d2, 0, i3, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    private Player.PositionInfo H1(int i2, PlaybackInfo playbackInfo, int i3) {
        int i4;
        Object obj;
        MediaItem mediaItem;
        int i5;
        Object obj2;
        long j2;
        long j3;
        PlaybackInfo playbackInfo2 = playbackInfo;
        Timeline.Period period = new Timeline.Period();
        if (!playbackInfo2.f23377a.u()) {
            Object obj3 = playbackInfo2.f23378b.f25793a;
            playbackInfo2.f23377a.l(obj3, period);
            int i6 = period.f23494d;
            int f2 = playbackInfo2.f23377a.f(obj3);
            Object obj4 = playbackInfo2.f23377a.r(i6, this.f22800a).f23511b;
            mediaItem = this.f22800a.f23513d;
            obj = obj3;
            i4 = f2;
            obj2 = obj4;
            i5 = i6;
        } else {
            i5 = i3;
            obj2 = null;
            mediaItem = null;
            obj = null;
            i4 = -1;
        }
        if (i2 == 0) {
            if (playbackInfo2.f23378b.b()) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.f23378b;
                j3 = period.e(mediaPeriodId.f25794b, mediaPeriodId.f25795c);
                j2 = I1(playbackInfo);
                long i12 = Util.i1(j3);
                long i13 = Util.i1(j2);
                MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f23378b;
                return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, i12, i13, mediaPeriodId2.f25794b, mediaPeriodId2.f25795c);
            } else if (playbackInfo2.f23378b.f25797e != -1) {
                j3 = I1(this.f22967s0);
            } else {
                j3 = period.f23496f + period.f23495e;
            }
        } else if (playbackInfo2.f23378b.b()) {
            j3 = playbackInfo2.f23394r;
            j2 = I1(playbackInfo);
            long i122 = Util.i1(j3);
            long i132 = Util.i1(j2);
            MediaSource.MediaPeriodId mediaPeriodId22 = playbackInfo2.f23378b;
            return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, i122, i132, mediaPeriodId22.f25794b, mediaPeriodId22.f25795c);
        } else {
            j3 = period.f23496f + playbackInfo2.f23394r;
        }
        j2 = j3;
        long i1222 = Util.i1(j3);
        long i1322 = Util.i1(j2);
        MediaSource.MediaPeriodId mediaPeriodId222 = playbackInfo2.f23378b;
        return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, i1222, i1322, mediaPeriodId222.f25794b, mediaPeriodId222.f25795c);
    }

    private void H2(PlaybackInfo playbackInfo, int i2, int i3, boolean z2, boolean z3, int i4, long j2, int i5, boolean z4) {
        boolean z5;
        boolean z6;
        boolean z7;
        PlaybackInfo playbackInfo2 = playbackInfo;
        int i6 = i4;
        PlaybackInfo playbackInfo3 = this.f22967s0;
        this.f22967s0 = playbackInfo2;
        boolean z8 = !playbackInfo3.f23377a.equals(playbackInfo2.f23377a);
        Pair<Boolean, Integer> x1 = x1(playbackInfo, playbackInfo3, z3, i4, z8, z4);
        boolean booleanValue = ((Boolean) x1.first).booleanValue();
        int intValue = ((Integer) x1.second).intValue();
        MediaMetadata mediaMetadata = this.P;
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo2.f23377a.u()) {
                mediaItem = playbackInfo2.f23377a.r(playbackInfo2.f23377a.l(playbackInfo2.f23378b.f25793a, this.f22956n).f23494d, this.f22800a).f23513d;
            }
            this.f22965r0 = MediaMetadata.J;
        }
        if (booleanValue || !playbackInfo3.f23386j.equals(playbackInfo2.f23386j)) {
            this.f22965r0 = this.f22965r0.b().L(playbackInfo2.f23386j).H();
            mediaMetadata = q1();
        }
        boolean z9 = !mediaMetadata.equals(this.P);
        this.P = mediaMetadata;
        if (playbackInfo3.f23388l != playbackInfo2.f23388l) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (playbackInfo3.f23381e != playbackInfo2.f23381e) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6 || z5) {
            J2();
        }
        boolean z10 = playbackInfo3.f23383g;
        boolean z11 = playbackInfo2.f23383g;
        if (z10 != z11) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            I2(z11);
        }
        if (z8) {
            this.f22952l.i(0, new j0(playbackInfo2, i2));
        }
        if (z3) {
            this.f22952l.i(11, new r(i6, H1(i6, playbackInfo3, i5), G1(j2)));
        }
        if (booleanValue) {
            this.f22952l.i(1, new s(mediaItem, intValue));
        }
        if (playbackInfo3.f23382f != playbackInfo2.f23382f) {
            this.f22952l.i(10, new t(playbackInfo2));
            if (playbackInfo2.f23382f != null) {
                this.f22952l.i(10, new u(playbackInfo2));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo3.f23385i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo2.f23385i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f22944h.f(trackSelectorResult2.f27824e);
            this.f22952l.i(2, new v(playbackInfo2));
        }
        if (z9) {
            this.f22952l.i(14, new w(this.P));
        }
        if (z7) {
            this.f22952l.i(3, new x(playbackInfo2));
        }
        if (z6 || z5) {
            this.f22952l.i(-1, new y(playbackInfo2));
        }
        if (z6) {
            this.f22952l.i(4, new a0(playbackInfo2));
        }
        if (z5) {
            this.f22952l.i(5, new k0(playbackInfo2, i3));
        }
        if (playbackInfo3.f23389m != playbackInfo2.f23389m) {
            this.f22952l.i(6, new l0(playbackInfo2));
        }
        if (L1(playbackInfo3) != L1(playbackInfo)) {
            this.f22952l.i(7, new m0(playbackInfo2));
        }
        if (!playbackInfo3.f23390n.equals(playbackInfo2.f23390n)) {
            this.f22952l.i(12, new p(playbackInfo2));
        }
        if (z2) {
            this.f22952l.i(-1, new q());
        }
        F2();
        this.f22952l.f();
        if (playbackInfo3.f23391o != playbackInfo2.f23391o) {
            Iterator<ExoPlayer.AudioOffloadListener> it2 = this.f22954m.iterator();
            while (it2.hasNext()) {
                it2.next().B(playbackInfo2.f23391o);
            }
        }
    }

    private static long I1(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.f23377a.l(playbackInfo.f23378b.f25793a, period);
        if (playbackInfo.f23379c == -9223372036854775807L) {
            return playbackInfo.f23377a.r(period.f23494d, window).e();
        }
        return period.q() + playbackInfo.f23379c;
    }

    private void I2(boolean z2) {
        PriorityTaskManager priorityTaskManager = this.f22955m0;
        if (priorityTaskManager == null) {
            return;
        }
        if (z2 && !this.f22957n0) {
            priorityTaskManager.a(0);
            this.f22957n0 = true;
        } else if (!z2 && this.f22957n0) {
            priorityTaskManager.d(0);
            this.f22957n0 = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: J1 */
    public void O1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j2;
        boolean z2;
        long j3;
        boolean z3;
        int i2 = this.H - playbackInfoUpdate.f23025c;
        this.H = i2;
        boolean z4 = true;
        if (playbackInfoUpdate.f23026d) {
            this.I = playbackInfoUpdate.f23027e;
            this.J = true;
        }
        if (playbackInfoUpdate.f23028f) {
            this.K = playbackInfoUpdate.f23029g;
        }
        if (i2 == 0) {
            Timeline timeline = playbackInfoUpdate.f23024b.f23377a;
            if (!this.f22967s0.f23377a.u() && timeline.u()) {
                this.f22969t0 = -1;
                this.f22973v0 = 0;
                this.f22971u0 = 0;
            }
            if (!timeline.u()) {
                List<Timeline> I2 = ((PlaylistTimeline) timeline).I();
                if (I2.size() == this.f22958o.size()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Assertions.g(z3);
                for (int i3 = 0; i3 < I2.size(); i3++) {
                    Timeline unused = this.f22958o.get(i3).f22984b = I2.get(i3);
                }
            }
            if (this.J) {
                if (playbackInfoUpdate.f23024b.f23378b.equals(this.f22967s0.f23378b) && playbackInfoUpdate.f23024b.f23380d == this.f22967s0.f23394r) {
                    z4 = false;
                }
                if (z4) {
                    if (timeline.u() || playbackInfoUpdate.f23024b.f23378b.b()) {
                        j3 = playbackInfoUpdate.f23024b.f23380d;
                    } else {
                        PlaybackInfo playbackInfo = playbackInfoUpdate.f23024b;
                        j3 = n2(timeline, playbackInfo.f23378b, playbackInfo.f23380d);
                    }
                    j2 = j3;
                } else {
                    j2 = -9223372036854775807L;
                }
                z2 = z4;
            } else {
                j2 = -9223372036854775807L;
                z2 = false;
            }
            this.J = false;
            H2(playbackInfoUpdate.f23024b, 1, this.K, false, z2, this.I, j2, -1, false);
        }
    }

    /* access modifiers changed from: private */
    public void J2() {
        int playbackState = getPlaybackState();
        boolean z2 = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean y1 = y1();
                WakeLockManager wakeLockManager = this.C;
                if (!A() || y1) {
                    z2 = false;
                }
                wakeLockManager.b(z2);
                this.D.b(A());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    private int K1(int i2) {
        AudioTrack audioTrack = this.T;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i2)) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
        }
        return this.T.getAudioSessionId();
    }

    private void K2() {
        IllegalStateException illegalStateException;
        this.f22936d.c();
        if (Thread.currentThread() != u().getThread()) {
            String C2 = Util.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), u().getThread().getName());
            if (!this.f22951k0) {
                if (this.f22953l0) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                Log.j("ExoPlayerImpl", C2, illegalStateException);
                this.f22953l0 = true;
                return;
            }
            throw new IllegalStateException(C2);
        }
    }

    private static boolean L1(PlaybackInfo playbackInfo) {
        return playbackInfo.f23381e == 3 && playbackInfo.f23388l && playbackInfo.f23389m == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N1(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(this.f22940f, new Player.Events(flagSet));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f22946i.g(new b0(this, playbackInfoUpdate));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V1(Player.Listener listener) {
        listener.onAvailableCommandsChanged(this.O);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void X1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i2);
        listener.onPositionDiscontinuity(positionInfo, positionInfo2, i2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d2(PlaybackInfo playbackInfo, Player.Listener listener) {
        listener.onLoadingChanged(playbackInfo.f23383g);
        listener.onIsLoadingChanged(playbackInfo.f23383g);
    }

    private PlaybackInfo k2(PlaybackInfo playbackInfo, Timeline timeline, Pair<Object, Long> pair) {
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        int i2;
        long j2;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        if (timeline.u() || pair2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        Timeline timeline3 = playbackInfo.f23377a;
        PlaybackInfo i3 = playbackInfo.i(timeline);
        if (timeline.u()) {
            MediaSource.MediaPeriodId k2 = PlaybackInfo.k();
            long F0 = Util.F0(this.f22973v0);
            PlaybackInfo b2 = i3.c(k2, F0, F0, F0, 0, TrackGroupArray.f26007e, this.f22932b, ImmutableList.r()).b(k2);
            b2.f23392p = b2.f23394r;
            return b2;
        }
        Object obj = i3.f23378b.f25793a;
        boolean z3 = !obj.equals(((Pair) Util.j(pair)).first);
        if (z3) {
            mediaPeriodId = new MediaSource.MediaPeriodId(pair2.first);
        } else {
            mediaPeriodId = i3.f23378b;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long longValue = ((Long) pair2.second).longValue();
        long F02 = Util.F0(K());
        if (!timeline3.u()) {
            F02 -= timeline3.l(obj, this.f22956n).q();
        }
        if (z3 || longValue < F02) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            Assertions.g(!mediaPeriodId3.b());
            if (z3) {
                trackGroupArray = TrackGroupArray.f26007e;
            } else {
                trackGroupArray = i3.f23384h;
            }
            TrackGroupArray trackGroupArray2 = trackGroupArray;
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId3;
            if (z3) {
                trackSelectorResult = this.f22932b;
            } else {
                trackSelectorResult = i3.f23385i;
            }
            TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
            if (z3) {
                list = ImmutableList.r();
            } else {
                list = i3.f23386j;
            }
            PlaybackInfo b3 = i3.c(mediaPeriodId4, longValue, longValue, longValue, 0, trackGroupArray2, trackSelectorResult2, list).b(mediaPeriodId4);
            b3.f23392p = longValue;
            return b3;
        }
        if (i2 == 0) {
            int f2 = timeline2.f(i3.f23387k.f25793a);
            if (f2 == -1 || timeline2.j(f2, this.f22956n).f23494d != timeline2.l(mediaPeriodId2.f25793a, this.f22956n).f23494d) {
                timeline2.l(mediaPeriodId2.f25793a, this.f22956n);
                if (mediaPeriodId2.b()) {
                    j2 = this.f22956n.e(mediaPeriodId2.f25794b, mediaPeriodId2.f25795c);
                } else {
                    j2 = this.f22956n.f23495e;
                }
                i3 = i3.c(mediaPeriodId2, i3.f23394r, i3.f23394r, i3.f23380d, j2 - i3.f23394r, i3.f23384h, i3.f23385i, i3.f23386j).b(mediaPeriodId2);
                i3.f23392p = j2;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId2;
            Assertions.g(!mediaPeriodId5.b());
            long max = Math.max(0, i3.f23393q - (longValue - F02));
            long j3 = i3.f23392p;
            if (i3.f23387k.equals(i3.f23378b)) {
                j3 = longValue + max;
            }
            i3 = i3.c(mediaPeriodId5, longValue, longValue, longValue, max, i3.f23384h, i3.f23385i, i3.f23386j);
            i3.f23392p = j3;
        }
        return i3;
    }

    private Pair<Object, Long> l2(Timeline timeline, int i2, long j2) {
        if (timeline.u()) {
            this.f22969t0 = i2;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.f22973v0 = j2;
            this.f22971u0 = 0;
            return null;
        }
        if (i2 == -1 || i2 >= timeline.t()) {
            i2 = timeline.e(this.G);
            j2 = timeline.r(i2, this.f22800a).d();
        }
        return timeline.n(this.f22800a, this.f22956n, i2, Util.F0(j2));
    }

    /* access modifiers changed from: private */
    public void m2(int i2, int i3) {
        if (i2 != this.f22935c0.b() || i3 != this.f22935c0.a()) {
            this.f22935c0 = new Size(i2, i3);
            this.f22952l.l(24, new o(i2, i3));
        }
    }

    private long n2(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        timeline.l(mediaPeriodId.f25793a, this.f22956n);
        return j2 + this.f22956n.q();
    }

    private List<MediaSourceList.MediaSourceHolder> o1(int i2, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i3), this.f22960p);
            arrayList.add(mediaSourceHolder);
            this.f22958o.add(i3 + i2, new MediaSourceHolderSnapshot(mediaSourceHolder.f23359b, mediaSourceHolder.f23358a.Z()));
        }
        this.M = this.M.g(i2, arrayList.size());
        return arrayList;
    }

    private PlaybackInfo p2(int i2, int i3) {
        int M2 = M();
        Timeline t2 = t();
        int size = this.f22958o.size();
        boolean z2 = true;
        this.H++;
        q2(i2, i3);
        Timeline u1 = u1();
        PlaybackInfo k2 = k2(this.f22967s0, u1, D1(t2, u1));
        int i4 = k2.f23381e;
        if (i4 == 1 || i4 == 4 || i2 >= i3 || i3 != size || M2 < k2.f23377a.t()) {
            z2 = false;
        }
        if (z2) {
            k2 = k2.g(4);
        }
        this.f22950k.o0(i2, i3, this.M);
        return k2;
    }

    /* access modifiers changed from: private */
    public MediaMetadata q1() {
        Timeline t2 = t();
        if (t2.u()) {
            return this.f22965r0;
        }
        return this.f22965r0.b().J(t2.r(M(), this.f22800a).f23513d.f23132f).H();
    }

    private void q2(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            this.f22958o.remove(i4);
        }
        this.M = this.M.a(i2, i3);
    }

    private void r2() {
        if (this.X != null) {
            w1(this.f22976y).n(10000).m((Object) null).l();
            this.X.i(this.f22975x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f22975x) {
                Log.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f22975x);
            this.W = null;
        }
    }

    private void s2(int i2, int i3, Object obj) {
        for (Renderer renderer : this.f22942g) {
            if (renderer.d() == i2) {
                w1(renderer).n(i3).m(obj).l();
            }
        }
    }

    /* access modifiers changed from: private */
    public static DeviceInfo t1(StreamVolumeManager streamVolumeManager) {
        return new DeviceInfo(0, streamVolumeManager.d(), streamVolumeManager.c());
    }

    /* access modifiers changed from: private */
    public void t2() {
        s2(1, 2, Float.valueOf(this.f22945h0 * this.A.g()));
    }

    private Timeline u1() {
        return new PlaylistTimeline(this.f22958o, this.M);
    }

    private List<MediaSource> v1(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(this.f22962q.a(list.get(i2)));
        }
        return arrayList;
    }

    private PlayerMessage w1(PlayerMessage.Target target) {
        int i2;
        int C1 = C1();
        ExoPlayerImplInternal exoPlayerImplInternal = this.f22950k;
        Timeline timeline = this.f22967s0.f23377a;
        if (C1 == -1) {
            i2 = 0;
        } else {
            i2 = C1;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, i2, this.f22974w, exoPlayerImplInternal.C());
    }

    private Pair<Boolean, Integer> x1(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, boolean z2, int i2, boolean z3, boolean z4) {
        Timeline timeline = playbackInfo2.f23377a;
        Timeline timeline2 = playbackInfo.f23377a;
        if (timeline2.u() && timeline.u()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i3 = 3;
        if (timeline2.u() != timeline.u()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!timeline.r(timeline.l(playbackInfo2.f23378b.f25793a, this.f22956n).f23494d, this.f22800a).f23511b.equals(timeline2.r(timeline2.l(playbackInfo.f23378b.f25793a, this.f22956n).f23494d, this.f22800a).f23511b)) {
            if (z2 && i2 == 0) {
                i3 = 1;
            } else if (z2 && i2 == 1) {
                i3 = 2;
            } else if (!z3) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i3));
        } else if (z2 && i2 == 0 && playbackInfo2.f23378b.f25796d < playbackInfo.f23378b.f25796d) {
            return new Pair<>(Boolean.TRUE, 0);
        } else {
            if (!z2 || i2 != 1 || !z4) {
                return new Pair<>(Boolean.FALSE, -1);
            }
            return new Pair<>(Boolean.TRUE, 2);
        }
    }

    private void x2(List<MediaSource> list, int i2, long j2, boolean z2) {
        int i3;
        long j3;
        int i4 = i2;
        int C1 = C1();
        long currentPosition = getCurrentPosition();
        boolean z3 = true;
        this.H++;
        if (!this.f22958o.isEmpty()) {
            q2(0, this.f22958o.size());
        }
        List<MediaSourceList.MediaSourceHolder> o12 = o1(0, list);
        Timeline u1 = u1();
        if (u1.u() || i4 < u1.t()) {
            long j4 = j2;
            if (z2) {
                j3 = -9223372036854775807L;
                i3 = u1.e(this.G);
            } else if (i4 == -1) {
                i3 = C1;
                j3 = currentPosition;
            } else {
                i3 = i4;
                j3 = j4;
            }
            PlaybackInfo k2 = k2(this.f22967s0, u1, l2(u1, i3, j3));
            int i5 = k2.f23381e;
            if (!(i3 == -1 || i5 == 1)) {
                i5 = (u1.u() || i3 >= u1.t()) ? 4 : 2;
            }
            PlaybackInfo g2 = k2.g(i5);
            this.f22950k.O0(o12, i3, Util.F0(j3), this.M);
            if (this.f22967s0.f23378b.f25793a.equals(g2.f23378b.f25793a) || this.f22967s0.f23377a.u()) {
                z3 = false;
            }
            H2(g2, 0, 1, false, z3, 4, B1(g2), -1, false);
            return;
        }
        throw new IllegalSeekPositionException(u1, i4, j2);
    }

    private void y2(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f22975x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            m2(0, 0);
            return;
        }
        Rect surfaceFrame = this.W.getSurfaceFrame();
        m2(surfaceFrame.width(), surfaceFrame.height());
    }

    /* access modifiers changed from: private */
    public void z2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        A2(surface);
        this.V = surface;
    }

    public boolean A() {
        K2();
        return this.f22967s0.f23388l;
    }

    public int A1() {
        K2();
        return this.f22941f0;
    }

    public void B(boolean z2) {
        K2();
        if (this.G != z2) {
            this.G = z2;
            this.f22950k.Y0(z2);
            this.f22952l.i(9, new c0(z2));
            F2();
            this.f22952l.f();
        }
    }

    public void B2(Surface surface) {
        int i2;
        K2();
        r2();
        A2(surface);
        if (surface == null) {
            i2 = 0;
        } else {
            i2 = -1;
        }
        m2(i2, i2);
    }

    public long C() {
        K2();
        return 3000;
    }

    public void C2(SurfaceHolder surfaceHolder) {
        K2();
        if (surfaceHolder == null) {
            r1();
            return;
        }
        r2();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.f22975x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            A2((Object) null);
            m2(0, 0);
            return;
        }
        A2(surface);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        m2(surfaceFrame.width(), surfaceFrame.height());
    }

    public void D2(boolean z2) {
        K2();
        this.A.p(A(), 1);
        E2(z2, (ExoPlaybackException) null);
        this.f22949j0 = new CueGroup(ImmutableList.r(), this.f22967s0.f23394r);
    }

    public int E() {
        K2();
        if (this.f22967s0.f23377a.u()) {
            return this.f22971u0;
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        return playbackInfo.f23377a.f(playbackInfo.f23378b.f25793a);
    }

    public void F(TextureView textureView) {
        K2();
        if (textureView != null && textureView == this.Z) {
            r1();
        }
    }

    /* renamed from: F1 */
    public ExoPlaybackException k() {
        K2();
        return this.f22967s0.f23382f;
    }

    public VideoSize G() {
        K2();
        return this.f22963q0;
    }

    public int I() {
        K2();
        if (f()) {
            return this.f22967s0.f23378b.f25795c;
        }
        return -1;
    }

    public long J() {
        K2();
        return this.f22972v;
    }

    public long K() {
        K2();
        if (!f()) {
            return getCurrentPosition();
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        playbackInfo.f23377a.l(playbackInfo.f23378b.f25793a, this.f22956n);
        PlaybackInfo playbackInfo2 = this.f22967s0;
        if (playbackInfo2.f23379c == -9223372036854775807L) {
            return playbackInfo2.f23377a.r(M(), this.f22800a).d();
        }
        return this.f22956n.p() + Util.i1(this.f22967s0.f23379c);
    }

    public int M() {
        K2();
        int C1 = C1();
        if (C1 == -1) {
            return 0;
        }
        return C1;
    }

    public void N(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        K2();
        if (surfaceView == null) {
            surfaceHolder = null;
        } else {
            surfaceHolder = surfaceView.getHolder();
        }
        s1(surfaceHolder);
    }

    public boolean O() {
        K2();
        return this.G;
    }

    public long P() {
        K2();
        if (this.f22967s0.f23377a.u()) {
            return this.f22973v0;
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        if (playbackInfo.f23387k.f25796d != playbackInfo.f23378b.f25796d) {
            return playbackInfo.f23377a.r(M(), this.f22800a).f();
        }
        long j2 = playbackInfo.f23392p;
        if (this.f22967s0.f23387k.b()) {
            PlaybackInfo playbackInfo2 = this.f22967s0;
            Timeline.Period l2 = playbackInfo2.f23377a.l(playbackInfo2.f23387k.f25793a, this.f22956n);
            long i2 = l2.i(this.f22967s0.f23387k.f25794b);
            if (i2 == Long.MIN_VALUE) {
                j2 = l2.f23495e;
            } else {
                j2 = i2;
            }
        }
        PlaybackInfo playbackInfo3 = this.f22967s0;
        return Util.i1(n2(playbackInfo3.f23377a, playbackInfo3.f23387k, j2));
    }

    public MediaMetadata S() {
        K2();
        return this.P;
    }

    public long T() {
        K2();
        return this.f22970u;
    }

    public void V(Player.Listener listener) {
        K2();
        this.f22952l.k((Player.Listener) Assertions.e(listener));
    }

    public void X(Player.Listener listener) {
        this.f22952l.c((Player.Listener) Assertions.e(listener));
    }

    public void Y(int i2, List<MediaItem> list) {
        K2();
        p1(i2, v1(list));
    }

    public long Z() {
        K2();
        if (!f()) {
            return P();
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        if (playbackInfo.f23387k.equals(playbackInfo.f23378b)) {
            return Util.i1(this.f22967s0.f23392p);
        }
        return getDuration();
    }

    public Format a() {
        K2();
        return this.R;
    }

    public void a0(TrackSelectionParameters trackSelectionParameters) {
        K2();
        if (this.f22944h.e() && !trackSelectionParameters.equals(this.f22944h.b())) {
            this.f22944h.j(trackSelectionParameters);
            this.f22952l.l(19, new d0(trackSelectionParameters));
        }
    }

    public PlaybackParameters b() {
        K2();
        return this.f22967s0.f23390n;
    }

    public void d(float f2) {
        K2();
        float p2 = Util.p(f2, 0.0f, 1.0f);
        if (this.f22945h0 != p2) {
            this.f22945h0 = p2;
            t2();
            this.f22952l.l(22, new h0(p2));
        }
    }

    public void e(PlaybackParameters playbackParameters) {
        K2();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.f23395e;
        }
        if (!this.f22967s0.f23390n.equals(playbackParameters)) {
            PlaybackInfo f2 = this.f22967s0.f(playbackParameters);
            this.H++;
            this.f22950k.T0(playbackParameters);
            H2(f2, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public boolean f() {
        K2();
        return this.f22967s0.f23378b.b();
    }

    public long g() {
        K2();
        return Util.i1(this.f22967s0.f23393q);
    }

    public void g0(int i2, long j2, int i3, boolean z2) {
        boolean z3;
        int i4 = i2;
        K2();
        int i5 = 1;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.a(z3);
        this.f22964r.q();
        Timeline timeline = this.f22967s0.f23377a;
        if (timeline.u() || i4 < timeline.t()) {
            this.H++;
            if (f()) {
                Log.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.f22967s0);
                playbackInfoUpdate.b(1);
                this.f22948j.a(playbackInfoUpdate);
                return;
            }
            if (getPlaybackState() != 1) {
                i5 = 2;
            }
            int M2 = M();
            long j3 = j2;
            PlaybackInfo k2 = k2(this.f22967s0.g(i5), timeline, l2(timeline, i2, j2));
            this.f22950k.B0(timeline, i2, Util.F0(j2));
            H2(k2, 0, 1, true, true, 1, B1(k2), M2, z2);
        }
    }

    public long getCurrentPosition() {
        K2();
        return Util.i1(B1(this.f22967s0));
    }

    public long getDuration() {
        K2();
        if (!f()) {
            return D();
        }
        PlaybackInfo playbackInfo = this.f22967s0;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f23378b;
        playbackInfo.f23377a.l(mediaPeriodId.f25793a, this.f22956n);
        return Util.i1(this.f22956n.e(mediaPeriodId.f25794b, mediaPeriodId.f25795c));
    }

    public int getPlaybackState() {
        K2();
        return this.f22967s0.f23381e;
    }

    public int getRepeatMode() {
        K2();
        return this.F;
    }

    public float getVolume() {
        K2();
        return this.f22945h0;
    }

    public void i(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        K2();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            r2();
            A2(surfaceView);
            y2(surfaceView.getHolder());
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            r2();
            this.X = (SphericalGLSurfaceView) surfaceView;
            w1(this.f22976y).n(10000).m(this.X).l();
            this.X.d(this.f22975x);
            A2(this.X.getVideoSurface());
            y2(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder = null;
            } else {
                surfaceHolder = surfaceView.getHolder();
            }
            C2(surfaceHolder);
        }
    }

    public void l(boolean z2) {
        K2();
        int p2 = this.A.p(z2, getPlaybackState());
        G2(z2, p2, E1(z2, p2));
    }

    public Tracks m() {
        K2();
        return this.f22967s0.f23385i.f27823d;
    }

    public void m1(AnalyticsListener analyticsListener) {
        this.f22964r.A((AnalyticsListener) Assertions.e(analyticsListener));
    }

    public void n1(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f22954m.add(audioOffloadListener);
    }

    public CueGroup o() {
        K2();
        return this.f22949j0;
    }

    @Deprecated
    public void o2(MediaSource mediaSource) {
        K2();
        u2(mediaSource);
        prepare();
    }

    public int p() {
        K2();
        if (f()) {
            return this.f22967s0.f23378b.f25794b;
        }
        return -1;
    }

    public void p1(int i2, List<MediaSource> list) {
        boolean z2;
        K2();
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int min = Math.min(i2, this.f22958o.size());
        Timeline t2 = t();
        this.H++;
        List<MediaSourceList.MediaSourceHolder> o12 = o1(min, list);
        Timeline u1 = u1();
        PlaybackInfo k2 = k2(this.f22967s0, u1, D1(t2, u1));
        this.f22950k.l(min, o12, this.M);
        H2(k2, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    public void prepare() {
        K2();
        boolean A2 = A();
        int i2 = 2;
        int p2 = this.A.p(A2, 2);
        G2(A2, p2, E1(A2, p2));
        PlaybackInfo playbackInfo = this.f22967s0;
        if (playbackInfo.f23381e == 1) {
            PlaybackInfo e2 = playbackInfo.e((ExoPlaybackException) null);
            if (e2.f23377a.u()) {
                i2 = 4;
            }
            PlaybackInfo g2 = e2.g(i2);
            this.H++;
            this.f22950k.j0();
            H2(g2, 1, 1, false, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public void r1() {
        K2();
        r2();
        A2((Object) null);
        m2(0, 0);
    }

    public void release() {
        AudioTrack audioTrack;
        Log.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + "ExoPlayerLib/2.18.7" + "] [" + Util.f28812e + "] [" + ExoPlayerLibraryInfo.b() + "]");
        K2();
        if (Util.f28808a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.f22977z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f22950k.l0()) {
            this.f22952l.l(10, new g0());
        }
        this.f22952l.j();
        this.f22946i.d((Object) null);
        this.f22968t.e(this.f22964r);
        PlaybackInfo g2 = this.f22967s0.g(1);
        this.f22967s0 = g2;
        PlaybackInfo b2 = g2.b(g2.f23378b);
        this.f22967s0 = b2;
        b2.f23392p = b2.f23394r;
        this.f22967s0.f23393q = 0;
        this.f22964r.release();
        this.f22944h.g();
        r2();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.f22957n0) {
            ((PriorityTaskManager) Assertions.e(this.f22955m0)).d(0);
            this.f22957n0 = false;
        }
        this.f22949j0 = CueGroup.f27236d;
        this.f22959o0 = true;
    }

    public int s() {
        K2();
        return this.f22967s0.f23389m;
    }

    public void s1(SurfaceHolder surfaceHolder) {
        K2();
        if (surfaceHolder != null && surfaceHolder == this.W) {
            r1();
        }
    }

    public void setRepeatMode(int i2) {
        K2();
        if (this.F != i2) {
            this.F = i2;
            this.f22950k.V0(i2);
            this.f22952l.i(8, new i0(i2));
            F2();
            this.f22952l.f();
        }
    }

    public void stop() {
        K2();
        D2(false);
    }

    public Timeline t() {
        K2();
        return this.f22967s0.f23377a;
    }

    public Looper u() {
        return this.f22966s;
    }

    public void u2(MediaSource mediaSource) {
        K2();
        v2(Collections.singletonList(mediaSource));
    }

    public TrackSelectionParameters v() {
        K2();
        return this.f22944h.b();
    }

    public void v2(List<MediaSource> list) {
        K2();
        w2(list, true);
    }

    public void w2(List<MediaSource> list, boolean z2) {
        K2();
        x2(list, -1, -9223372036854775807L, z2);
    }

    public void x(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        K2();
        if (textureView == null) {
            r1();
            return;
        }
        r2();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.i("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f22975x);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            A2((Object) null);
            m2(0, 0);
            return;
        }
        z2(surfaceTexture);
        m2(textureView.getWidth(), textureView.getHeight());
    }

    public boolean y1() {
        K2();
        return this.f22967s0.f23391o;
    }

    public Player.Commands z() {
        K2();
        return this.O;
    }

    public Format z1() {
        K2();
        return this.S;
    }
}
