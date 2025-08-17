package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioBecomingNoisyManager;
import androidx.media3.exoplayer.AudioFocusManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.StreamVolumeManager;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import e.g;
import e.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private final AudioBecomingNoisyManager A;
    private final AudioFocusManager B;
    /* access modifiers changed from: private */
    public final StreamVolumeManager C;
    private final WakeLockManager D;
    private final WifiLockManager E;
    private final long F;
    private AudioManager G;
    private final boolean H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private SeekParameters N;
    private ShuffleOrder O;
    private ExoPlayer.PreloadConfiguration P;
    private boolean Q;
    private Player.Commands R;
    /* access modifiers changed from: private */
    public MediaMetadata S;
    private MediaMetadata T;
    /* access modifiers changed from: private */
    public Format U;
    /* access modifiers changed from: private */
    public Format V;
    private AudioTrack W;
    /* access modifiers changed from: private */
    public Object X;
    private Surface Y;
    private SurfaceHolder Z;

    /* renamed from: a0  reason: collision with root package name */
    private SphericalGLSurfaceView f5271a0;

    /* renamed from: b  reason: collision with root package name */
    final TrackSelectorResult f5272b;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public boolean f5273b0;

    /* renamed from: c  reason: collision with root package name */
    final Player.Commands f5274c;

    /* renamed from: c0  reason: collision with root package name */
    private TextureView f5275c0;

    /* renamed from: d  reason: collision with root package name */
    private final ConditionVariable f5276d;

    /* renamed from: d0  reason: collision with root package name */
    private int f5277d0;

    /* renamed from: e  reason: collision with root package name */
    private final Context f5278e;

    /* renamed from: e0  reason: collision with root package name */
    private int f5279e0;

    /* renamed from: f  reason: collision with root package name */
    private final Player f5280f;

    /* renamed from: f0  reason: collision with root package name */
    private Size f5281f0;

    /* renamed from: g  reason: collision with root package name */
    private final Renderer[] f5282g;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public DecoderCounters f5283g0;

    /* renamed from: h  reason: collision with root package name */
    private final TrackSelector f5284h;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public DecoderCounters f5285h0;

    /* renamed from: i  reason: collision with root package name */
    private final HandlerWrapper f5286i;

    /* renamed from: i0  reason: collision with root package name */
    private int f5287i0;

    /* renamed from: j  reason: collision with root package name */
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener f5288j;

    /* renamed from: j0  reason: collision with root package name */
    private AudioAttributes f5289j0;

    /* renamed from: k  reason: collision with root package name */
    private final ExoPlayerImplInternal f5290k;

    /* renamed from: k0  reason: collision with root package name */
    private float f5291k0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final ListenerSet<Player.Listener> f5292l;
    /* access modifiers changed from: private */

    /* renamed from: l0  reason: collision with root package name */
    public boolean f5293l0;

    /* renamed from: m  reason: collision with root package name */
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> f5294m;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public CueGroup f5295m0;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline.Period f5296n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f5297n0;

    /* renamed from: o  reason: collision with root package name */
    private final List<MediaSourceHolderSnapshot> f5298o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f5299o0;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f5300p;

    /* renamed from: p0  reason: collision with root package name */
    private int f5301p0;

    /* renamed from: q  reason: collision with root package name */
    private final MediaSource.Factory f5302q;

    /* renamed from: q0  reason: collision with root package name */
    private PriorityTaskManager f5303q0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final AnalyticsCollector f5304r;

    /* renamed from: r0  reason: collision with root package name */
    private boolean f5305r0;

    /* renamed from: s  reason: collision with root package name */
    private final Looper f5306s;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f5307s0;

    /* renamed from: t  reason: collision with root package name */
    private final BandwidthMeter f5308t;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public DeviceInfo f5309t0;

    /* renamed from: u  reason: collision with root package name */
    private final long f5310u;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public VideoSize f5311u0;

    /* renamed from: v  reason: collision with root package name */
    private final long f5312v;
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public MediaMetadata f5313v0;

    /* renamed from: w  reason: collision with root package name */
    private final long f5314w;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public PlaybackInfo f5315w0;

    /* renamed from: x  reason: collision with root package name */
    private final Clock f5316x;

    /* renamed from: x0  reason: collision with root package name */
    private int f5317x0;

    /* renamed from: y  reason: collision with root package name */
    private final ComponentListener f5318y;

    /* renamed from: y0  reason: collision with root package name */
    private int f5319y0;

    /* renamed from: z  reason: collision with root package name */
    private final FrameMetadataListener f5320z;

    /* renamed from: z0  reason: collision with root package name */
    private long f5321z0;

    private static final class Api23 {
        private Api23() {
        }

        public static boolean a(Context context, AudioDeviceInfo[] audioDeviceInfoArr) {
            if (!Util.K0(context)) {
                return true;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i2 = Util.f4714a;
                if (i2 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i2 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i2 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i2 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        public static void b(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static PlayerId a(Context context, ExoPlayerImpl exoPlayerImpl, boolean z2, String str) {
            MediaMetricsListener v02 = MediaMetricsListener.v0(context);
            if (v02 == null) {
                Log.h("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE, str);
            }
            if (z2) {
                exoPlayerImpl.o1(v02);
            }
            return new PlayerId(v02.C0(), str);
        }
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Q(Player.Listener listener) {
            listener.F(ExoPlayerImpl.this.S);
        }

        public void A(CueGroup cueGroup) {
            CueGroup unused = ExoPlayerImpl.this.f5295m0 = cueGroup;
            ExoPlayerImpl.this.f5292l.l(27, new c0(cueGroup));
        }

        public void B(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata unused = exoPlayerImpl.f5313v0 = exoPlayerImpl.f5313v0.a().L(metadata).I();
            MediaMetadata Q0 = ExoPlayerImpl.this.r1();
            if (!Q0.equals(ExoPlayerImpl.this.S)) {
                MediaMetadata unused2 = ExoPlayerImpl.this.S = Q0;
                ExoPlayerImpl.this.f5292l.i(14, new z(this));
            }
            ExoPlayerImpl.this.f5292l.i(28, new a0(metadata));
            ExoPlayerImpl.this.f5292l.f();
        }

        public void C(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.U = format;
            ExoPlayerImpl.this.f5304r.C(format, decoderReuseEvaluation);
        }

        public void D(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f5304r.D(decoderCounters);
            Format unused = ExoPlayerImpl.this.U = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.f5283g0 = null;
        }

        public /* synthetic */ void E(boolean z2) {
            g.a(this, z2);
        }

        public void F(boolean z2) {
            ExoPlayerImpl.this.D2();
        }

        public void a(Exception exc) {
            ExoPlayerImpl.this.f5304r.a(exc);
        }

        public void b(String str) {
            ExoPlayerImpl.this.f5304r.b(str);
        }

        public void c(String str, long j2, long j3) {
            ExoPlayerImpl.this.f5304r.c(str, j2, j3);
        }

        public void d(String str) {
            ExoPlayerImpl.this.f5304r.d(str);
        }

        public void e(String str, long j2, long j3) {
            ExoPlayerImpl.this.f5304r.e(str, j2, j3);
        }

        public void f(long j2) {
            ExoPlayerImpl.this.f5304r.f(j2);
        }

        public void g(Exception exc) {
            ExoPlayerImpl.this.f5304r.g(exc);
        }

        public void h(int i2, long j2) {
            ExoPlayerImpl.this.f5304r.h(i2, j2);
        }

        public void i(Object obj, long j2) {
            ExoPlayerImpl.this.f5304r.i(obj, j2);
            if (ExoPlayerImpl.this.X == obj) {
                ExoPlayerImpl.this.f5292l.l(26, new u());
            }
        }

        public void j(Exception exc) {
            ExoPlayerImpl.this.f5304r.j(exc);
        }

        public void k(int i2, long j2, long j3) {
            ExoPlayerImpl.this.f5304r.k(i2, j2, j3);
        }

        public void l(long j2, int i2) {
            ExoPlayerImpl.this.f5304r.l(j2, i2);
        }

        public void m(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.f5304r.m(audioTrackConfig);
        }

        public void n(VideoSize videoSize) {
            VideoSize unused = ExoPlayerImpl.this.f5311u0 = videoSize;
            ExoPlayerImpl.this.f5292l.l(25, new e0(videoSize));
        }

        public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.f5304r.o(audioTrackConfig);
        }

        public void onCues(List<Cue> list) {
            ExoPlayerImpl.this.f5292l.l(27, new y(list));
        }

        public void onSkipSilenceEnabledChanged(boolean z2) {
            if (ExoPlayerImpl.this.f5293l0 != z2) {
                boolean unused = ExoPlayerImpl.this.f5293l0 = z2;
                ExoPlayerImpl.this.f5292l.l(23, new f0(z2));
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.u2(surfaceTexture);
            ExoPlayerImpl.this.k2(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.v2((Object) null);
            ExoPlayerImpl.this.k2(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.k2(i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void p(int i2) {
            DeviceInfo b12 = ExoPlayerImpl.v1(ExoPlayerImpl.this.C);
            if (!b12.equals(ExoPlayerImpl.this.f5309t0)) {
                DeviceInfo unused = ExoPlayerImpl.this.f5309t0 = b12;
                ExoPlayerImpl.this.f5292l.l(29, new d0(b12));
            }
        }

        public void q() {
            ExoPlayerImpl.this.z2(false, -1, 3);
        }

        public void r(Surface surface) {
            ExoPlayerImpl.this.v2((Object) null);
        }

        public void s(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.f5285h0 = decoderCounters;
            ExoPlayerImpl.this.f5304r.s(decoderCounters);
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ExoPlayerImpl.this.k2(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.f5273b0) {
                ExoPlayerImpl.this.v2(surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.f5273b0) {
                ExoPlayerImpl.this.v2((Object) null);
            }
            ExoPlayerImpl.this.k2(0, 0);
        }

        public void t(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.f5283g0 = decoderCounters;
            ExoPlayerImpl.this.f5304r.t(decoderCounters);
        }

        public void u(Surface surface) {
            ExoPlayerImpl.this.v2(surface);
        }

        public void v(int i2, boolean z2) {
            ExoPlayerImpl.this.f5292l.l(30, new b0(i2, z2));
        }

        public void w(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.V = format;
            ExoPlayerImpl.this.f5304r.w(format, decoderReuseEvaluation);
        }

        public void x(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.f5304r.x(decoderCounters);
            Format unused = ExoPlayerImpl.this.V = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.f5285h0 = null;
        }

        public void y(float f2) {
            ExoPlayerImpl.this.q2();
        }

        public void z(int i2) {
            ExoPlayerImpl.this.z2(ExoPlayerImpl.this.A(), i2, ExoPlayerImpl.C1(i2));
        }
    }

    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {

        /* renamed from: b  reason: collision with root package name */
        private VideoFrameMetadataListener f5323b;

        /* renamed from: c  reason: collision with root package name */
        private CameraMotionListener f5324c;

        /* renamed from: d  reason: collision with root package name */
        private VideoFrameMetadataListener f5325d;

        /* renamed from: e  reason: collision with root package name */
        private CameraMotionListener f5326e;

        private FrameMetadataListener() {
        }

        public void b(long j2, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f5326e;
            if (cameraMotionListener != null) {
                cameraMotionListener.b(j2, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f5324c;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.b(j2, fArr);
            }
        }

        public void c() {
            CameraMotionListener cameraMotionListener = this.f5326e;
            if (cameraMotionListener != null) {
                cameraMotionListener.c();
            }
            CameraMotionListener cameraMotionListener2 = this.f5324c;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.c();
            }
        }

        public void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.f5325d;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.e(j2, j3, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f5323b;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.e(j2, j3, format, mediaFormat);
            }
        }

        public void j(int i2, Object obj) {
            if (i2 == 7) {
                this.f5323b = (VideoFrameMetadataListener) obj;
            } else if (i2 == 8) {
                this.f5324c = (CameraMotionListener) obj;
            } else if (i2 == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    this.f5325d = null;
                    this.f5326e = null;
                    return;
                }
                this.f5325d = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f5326e = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        private final Object f5327a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaSource f5328b;

        /* renamed from: c  reason: collision with root package name */
        private Timeline f5329c;

        public MediaSourceHolderSnapshot(Object obj, MaskingMediaSource maskingMediaSource) {
            this.f5327a = obj;
            this.f5328b = maskingMediaSource;
            this.f5329c = maskingMediaSource.Z();
        }

        public Object a() {
            return this.f5327a;
        }

        public Timeline b() {
            return this.f5329c;
        }

        public void c(Timeline timeline) {
            this.f5329c = timeline;
        }
    }

    private final class NoSuitableOutputPlaybackSuppressionAudioDeviceCallback extends AudioDeviceCallback {
        private NoSuitableOutputPlaybackSuppressionAudioDeviceCallback() {
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (ExoPlayerImpl.this.I1() && ExoPlayerImpl.this.f5315w0.f5477n == 3) {
                ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                exoPlayerImpl.B2(exoPlayerImpl.f5315w0.f5475l, 1, 0);
            }
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (!ExoPlayerImpl.this.I1()) {
                ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                exoPlayerImpl.B2(exoPlayerImpl.f5315w0.f5475l, 1, 3);
            }
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r46v0, types: [androidx.media3.common.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(androidx.media3.exoplayer.ExoPlayer.Builder r45, androidx.media3.common.Player r46) {
        /*
            r44 = this;
            r1 = r44
            r0 = r45
            r44.<init>()
            androidx.media3.common.util.ConditionVariable r2 = new androidx.media3.common.util.ConditionVariable
            r2.<init>()
            r1.f5276d = r2
            java.lang.String r3 = "ExoPlayerImpl"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03c9 }
            r4.<init>()     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = "Init "
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            int r5 = java.lang.System.identityHashCode(r44)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = java.lang.Integer.toHexString(r5)     // Catch:{ all -> 0x03c9 }
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = " ["
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = "AndroidXMedia3/1.4.1"
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = "] ["
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = androidx.media3.common.util.Util.f4718e     // Catch:{ all -> 0x03c9 }
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r5 = "]"
            r4.append(r5)     // Catch:{ all -> 0x03c9 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.util.Log.f(r3, r4)     // Catch:{ all -> 0x03c9 }
            android.content.Context r3 = r0.f5243a     // Catch:{ all -> 0x03c9 }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x03c9 }
            r1.f5278e = r3     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Function<androidx.media3.common.util.Clock, androidx.media3.exoplayer.analytics.AnalyticsCollector> r4 = r0.f5251i     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.util.Clock r5 = r0.f5244b     // Catch:{ all -> 0x03c9 }
            java.lang.Object r4 = r4.apply(r5)     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.analytics.AnalyticsCollector r4 = (androidx.media3.exoplayer.analytics.AnalyticsCollector) r4     // Catch:{ all -> 0x03c9 }
            r1.f5304r = r4     // Catch:{ all -> 0x03c9 }
            int r5 = r0.f5253k     // Catch:{ all -> 0x03c9 }
            r1.f5301p0 = r5     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.PriorityTaskManager r5 = r0.f5254l     // Catch:{ all -> 0x03c9 }
            r1.f5303q0 = r5     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.AudioAttributes r5 = r0.f5255m     // Catch:{ all -> 0x03c9 }
            r1.f5289j0 = r5     // Catch:{ all -> 0x03c9 }
            int r5 = r0.f5261s     // Catch:{ all -> 0x03c9 }
            r1.f5277d0 = r5     // Catch:{ all -> 0x03c9 }
            int r5 = r0.f5262t     // Catch:{ all -> 0x03c9 }
            r1.f5279e0 = r5     // Catch:{ all -> 0x03c9 }
            boolean r5 = r0.f5259q     // Catch:{ all -> 0x03c9 }
            r1.f5293l0 = r5     // Catch:{ all -> 0x03c9 }
            long r5 = r0.B     // Catch:{ all -> 0x03c9 }
            r1.F = r5     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener r15 = new androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener     // Catch:{ all -> 0x03c9 }
            r14 = 0
            r15.<init>()     // Catch:{ all -> 0x03c9 }
            r1.f5318y = r15     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayerImpl$FrameMetadataListener r13 = new androidx.media3.exoplayer.ExoPlayerImpl$FrameMetadataListener     // Catch:{ all -> 0x03c9 }
            r13.<init>()     // Catch:{ all -> 0x03c9 }
            r1.f5320z = r13     // Catch:{ all -> 0x03c9 }
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x03c9 }
            android.os.Looper r5 = r0.f5252j     // Catch:{ all -> 0x03c9 }
            r6.<init>(r5)     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.RenderersFactory> r5 = r0.f5246d     // Catch:{ all -> 0x03c9 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03c9 }
            r7 = r5
            androidx.media3.exoplayer.RenderersFactory r7 = (androidx.media3.exoplayer.RenderersFactory) r7     // Catch:{ all -> 0x03c9 }
            r8 = r6
            r9 = r15
            r10 = r15
            r11 = r15
            r12 = r15
            androidx.media3.exoplayer.Renderer[] r7 = r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x03c9 }
            r1.f5282g = r7     // Catch:{ all -> 0x03c9 }
            int r5 = r7.length     // Catch:{ all -> 0x03c9 }
            if (r5 <= 0) goto L_0x00a4
            r5 = 1
            goto L_0x00a5
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            androidx.media3.common.util.Assertions.h(r5)     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.trackselection.TrackSelector> r5 = r0.f5248f     // Catch:{ all -> 0x03c9 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03c9 }
            r10 = r5
            androidx.media3.exoplayer.trackselection.TrackSelector r10 = (androidx.media3.exoplayer.trackselection.TrackSelector) r10     // Catch:{ all -> 0x03c9 }
            r1.f5284h = r10     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource$Factory> r5 = r0.f5247e     // Catch:{ all -> 0x03c9 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.source.MediaSource$Factory r5 = (androidx.media3.exoplayer.source.MediaSource.Factory) r5     // Catch:{ all -> 0x03c9 }
            r1.f5302q = r5     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.upstream.BandwidthMeter> r5 = r0.f5250h     // Catch:{ all -> 0x03c9 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03c9 }
            r9 = r5
            androidx.media3.exoplayer.upstream.BandwidthMeter r9 = (androidx.media3.exoplayer.upstream.BandwidthMeter) r9     // Catch:{ all -> 0x03c9 }
            r1.f5308t = r9     // Catch:{ all -> 0x03c9 }
            boolean r5 = r0.f5263u     // Catch:{ all -> 0x03c9 }
            r1.f5300p = r5     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.SeekParameters r5 = r0.f5264v     // Catch:{ all -> 0x03c9 }
            r1.N = r5     // Catch:{ all -> 0x03c9 }
            r16 = r15
            long r14 = r0.f5265w     // Catch:{ all -> 0x03c9 }
            r1.f5310u = r14     // Catch:{ all -> 0x03c9 }
            long r14 = r0.f5266x     // Catch:{ all -> 0x03c9 }
            r1.f5312v = r14     // Catch:{ all -> 0x03c9 }
            long r14 = r0.f5267y     // Catch:{ all -> 0x03c9 }
            r1.f5314w = r14     // Catch:{ all -> 0x03c9 }
            boolean r5 = r0.C     // Catch:{ all -> 0x03c9 }
            r1.Q = r5     // Catch:{ all -> 0x03c9 }
            android.os.Looper r15 = r0.f5252j     // Catch:{ all -> 0x03c9 }
            r1.f5306s = r15     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.util.Clock r14 = r0.f5244b     // Catch:{ all -> 0x03c9 }
            r1.f5316x = r14     // Catch:{ all -> 0x03c9 }
            if (r46 != 0) goto L_0x00ee
            r5 = r1
            goto L_0x00f0
        L_0x00ee:
            r5 = r46
        L_0x00f0:
            r1.f5280f = r5     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.G     // Catch:{ all -> 0x03c9 }
            r1.H = r8     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.util.ListenerSet r11 = new androidx.media3.common.util.ListenerSet     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.q r12 = new androidx.media3.exoplayer.q     // Catch:{ all -> 0x03c9 }
            r12.<init>(r1)     // Catch:{ all -> 0x03c9 }
            r11.<init>(r15, r14, r12)     // Catch:{ all -> 0x03c9 }
            r1.f5292l = r11     // Catch:{ all -> 0x03c9 }
            java.util.concurrent.CopyOnWriteArraySet r11 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x03c9 }
            r11.<init>()     // Catch:{ all -> 0x03c9 }
            r1.f5294m = r11     // Catch:{ all -> 0x03c9 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ all -> 0x03c9 }
            r11.<init>()     // Catch:{ all -> 0x03c9 }
            r1.f5298o = r11     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder r11 = new androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder     // Catch:{ all -> 0x03c9 }
            r12 = 0
            r11.<init>(r12)     // Catch:{ all -> 0x03c9 }
            r1.O = r11     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayer$PreloadConfiguration r11 = androidx.media3.exoplayer.ExoPlayer.PreloadConfiguration.f5269b     // Catch:{ all -> 0x03c9 }
            r1.P = r11     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r11 = new androidx.media3.exoplayer.trackselection.TrackSelectorResult     // Catch:{ all -> 0x03c9 }
            int r12 = r7.length     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.RendererConfiguration[] r12 = new androidx.media3.exoplayer.RendererConfiguration[r12]     // Catch:{ all -> 0x03c9 }
            r20 = r6
            int r6 = r7.length     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r6 = new androidx.media3.exoplayer.trackselection.ExoTrackSelection[r6]     // Catch:{ all -> 0x03c9 }
            r21 = r8
            androidx.media3.common.Tracks r8 = androidx.media3.common.Tracks.f4470b     // Catch:{ all -> 0x03c9 }
            r22 = r9
            r9 = 0
            r11.<init>(r12, r6, r8, r9)     // Catch:{ all -> 0x03c9 }
            r1.f5272b = r11     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Timeline$Period r6 = new androidx.media3.common.Timeline$Period     // Catch:{ all -> 0x03c9 }
            r6.<init>()     // Catch:{ all -> 0x03c9 }
            r1.f5296n = r6     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands$Builder r6 = new androidx.media3.common.Player$Commands$Builder     // Catch:{ all -> 0x03c9 }
            r6.<init>()     // Catch:{ all -> 0x03c9 }
            r8 = 20
            int[] r9 = new int[r8]     // Catch:{ all -> 0x03c9 }
            r12 = 0
            r18 = 1
            r9[r12] = r18     // Catch:{ all -> 0x03c9 }
            r8 = 2
            r9[r18] = r8     // Catch:{ all -> 0x03c9 }
            r26 = r2
            r2 = 3
            r9[r8] = r2     // Catch:{ all -> 0x03c9 }
            r19 = 13
            r9[r2] = r19     // Catch:{ all -> 0x03c9 }
            r23 = 14
            r2 = 4
            r9[r2] = r23     // Catch:{ all -> 0x03c9 }
            r24 = 15
            r2 = 5
            r9[r2] = r24     // Catch:{ all -> 0x03c9 }
            r2 = 6
            r25 = r13
            r13 = 16
            r9[r2] = r13     // Catch:{ all -> 0x03c9 }
            r27 = 17
            r2 = 7
            r9[r2] = r27     // Catch:{ all -> 0x03c9 }
            r28 = 18
            r2 = 8
            r9[r2] = r28     // Catch:{ all -> 0x03c9 }
            r29 = 19
            r2 = 9
            r9[r2] = r29     // Catch:{ all -> 0x03c9 }
            r8 = 31
            r2 = 10
            r9[r2] = r8     // Catch:{ all -> 0x03c9 }
            r31 = 11
            r32 = 20
            r9[r31] = r32     // Catch:{ all -> 0x03c9 }
            r31 = 12
            r32 = 30
            r9[r31] = r32     // Catch:{ all -> 0x03c9 }
            r8 = 21
            r9[r19] = r8     // Catch:{ all -> 0x03c9 }
            r19 = 35
            r9[r23] = r19     // Catch:{ all -> 0x03c9 }
            r19 = 22
            r9[r24] = r19     // Catch:{ all -> 0x03c9 }
            r19 = 24
            r9[r13] = r19     // Catch:{ all -> 0x03c9 }
            r19 = 27
            r9[r27] = r19     // Catch:{ all -> 0x03c9 }
            r19 = 28
            r9[r28] = r19     // Catch:{ all -> 0x03c9 }
            r19 = 32
            r9[r29] = r19     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands$Builder r6 = r6.c(r9)     // Catch:{ all -> 0x03c9 }
            boolean r9 = r10.h()     // Catch:{ all -> 0x03c9 }
            r8 = 29
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r8, r9)     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.f5260r     // Catch:{ all -> 0x03c9 }
            r9 = 23
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r9, r8)     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.f5260r     // Catch:{ all -> 0x03c9 }
            r9 = 25
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r9, r8)     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.f5260r     // Catch:{ all -> 0x03c9 }
            r9 = 33
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r9, r8)     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.f5260r     // Catch:{ all -> 0x03c9 }
            r9 = 26
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r9, r8)     // Catch:{ all -> 0x03c9 }
            boolean r8 = r0.f5260r     // Catch:{ all -> 0x03c9 }
            r9 = 34
            androidx.media3.common.Player$Commands$Builder r6 = r6.d(r9, r8)     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands r6 = r6.e()     // Catch:{ all -> 0x03c9 }
            r1.f5274c = r6     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands$Builder r8 = new androidx.media3.common.Player$Commands$Builder     // Catch:{ all -> 0x03c9 }
            r8.<init>()     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands$Builder r6 = r8.b(r6)     // Catch:{ all -> 0x03c9 }
            r8 = 4
            androidx.media3.common.Player$Commands$Builder r6 = r6.a(r8)     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands$Builder r6 = r6.a(r2)     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.Player$Commands r6 = r6.e()     // Catch:{ all -> 0x03c9 }
            r1.R = r6     // Catch:{ all -> 0x03c9 }
            r9 = 0
            androidx.media3.common.util.HandlerWrapper r6 = r14.b(r15, r9)     // Catch:{ all -> 0x03c9 }
            r1.f5286i = r6     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.r r8 = new androidx.media3.exoplayer.r     // Catch:{ all -> 0x03c9 }
            r8.<init>(r1)     // Catch:{ all -> 0x03c9 }
            r1.f5288j = r8     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.PlaybackInfo r6 = androidx.media3.exoplayer.PlaybackInfo.k(r11)     // Catch:{ all -> 0x03c9 }
            r1.f5315w0 = r6     // Catch:{ all -> 0x03c9 }
            r4.Z(r5, r15)     // Catch:{ all -> 0x03c9 }
            int r6 = androidx.media3.common.util.Util.f4714a     // Catch:{ all -> 0x03c9 }
            r5 = 31
            if (r6 >= r5) goto L_0x021c
            androidx.media3.exoplayer.analytics.PlayerId r5 = new androidx.media3.exoplayer.analytics.PlayerId     // Catch:{ all -> 0x03c9 }
            java.lang.String r9 = r0.H     // Catch:{ all -> 0x03c9 }
            r5.<init>(r9)     // Catch:{ all -> 0x03c9 }
            goto L_0x0224
        L_0x021c:
            boolean r5 = r0.D     // Catch:{ all -> 0x03c9 }
            java.lang.String r9 = r0.H     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.analytics.PlayerId r5 = androidx.media3.exoplayer.ExoPlayerImpl.Api31.a(r3, r1, r5, r9)     // Catch:{ all -> 0x03c9 }
        L_0x0224:
            r23 = r5
            androidx.media3.exoplayer.ExoPlayerImplInternal r9 = new androidx.media3.exoplayer.ExoPlayerImplInternal     // Catch:{ all -> 0x03c9 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.LoadControl> r5 = r0.f5249g     // Catch:{ all -> 0x03c9 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x03c9 }
            r24 = r5
            androidx.media3.exoplayer.LoadControl r24 = (androidx.media3.exoplayer.LoadControl) r24     // Catch:{ all -> 0x03c9 }
            int r5 = r1.I     // Catch:{ all -> 0x03c9 }
            boolean r12 = r1.J     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.SeekParameters r2 = r1.N     // Catch:{ all -> 0x03c9 }
            r28 = r15
            androidx.media3.exoplayer.LivePlaybackSpeedControl r15 = r0.f5268z     // Catch:{ all -> 0x03c9 }
            r31 = r2
            r29 = r3
            long r2 = r0.A     // Catch:{ all -> 0x03c9 }
            r32 = r2
            boolean r2 = r1.Q     // Catch:{ all -> 0x03c9 }
            boolean r3 = r0.I     // Catch:{ all -> 0x03c9 }
            r34 = r3
            android.os.Looper r3 = r0.E     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayer$PreloadConfiguration r0 = r1.P     // Catch:{ all -> 0x03c9 }
            r35 = r5
            r5 = r9
            r37 = r6
            r36 = r20
            r6 = r7
            r7 = r10
            r38 = r8
            r30 = r21
            r8 = r11
            r39 = r9
            r11 = r22
            r17 = 0
            r9 = r24
            r40 = r10
            r10 = r11
            r41 = r11
            r11 = r35
            r42 = r25
            r13 = r4
            r21 = r14
            r14 = r31
            r43 = r16
            r16 = r32
            r18 = r2
            r19 = r34
            r20 = r28
            r22 = r38
            r24 = r3
            r25 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x03c9 }
            r0 = r39
            r1.f5290k = r0     // Catch:{ all -> 0x03c9 }
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.f5291k0 = r2     // Catch:{ all -> 0x03c9 }
            r2 = 0
            r1.I = r2     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.MediaMetadata r3 = androidx.media3.common.MediaMetadata.J     // Catch:{ all -> 0x03c9 }
            r1.S = r3     // Catch:{ all -> 0x03c9 }
            r1.T = r3     // Catch:{ all -> 0x03c9 }
            r1.f5313v0 = r3     // Catch:{ all -> 0x03c9 }
            r3 = -1
            r1.f5317x0 = r3     // Catch:{ all -> 0x03c9 }
            r3 = r37
            r5 = 21
            if (r3 >= r5) goto L_0x02a8
            int r5 = r1.J1(r2)     // Catch:{ all -> 0x03c9 }
            r1.f5287i0 = r5     // Catch:{ all -> 0x03c9 }
            goto L_0x02ae
        L_0x02a8:
            int r5 = androidx.media3.common.util.Util.J(r29)     // Catch:{ all -> 0x03c9 }
            r1.f5287i0 = r5     // Catch:{ all -> 0x03c9 }
        L_0x02ae:
            androidx.media3.common.text.CueGroup r5 = androidx.media3.common.text.CueGroup.f4592c     // Catch:{ all -> 0x03c9 }
            r1.f5295m0 = r5     // Catch:{ all -> 0x03c9 }
            r5 = 1
            r1.f5297n0 = r5     // Catch:{ all -> 0x03c9 }
            r1.Y(r4)     // Catch:{ all -> 0x03c9 }
            android.os.Handler r6 = new android.os.Handler     // Catch:{ all -> 0x03c9 }
            r7 = r28
            r6.<init>(r7)     // Catch:{ all -> 0x03c9 }
            r8 = r41
            r8.e(r6, r4)     // Catch:{ all -> 0x03c9 }
            r4 = r43
            r1.p1(r4)     // Catch:{ all -> 0x03c9 }
            r6 = r45
            long r8 = r6.f5245c     // Catch:{ all -> 0x03c9 }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x02d6
            r0.B(r8)     // Catch:{ all -> 0x03c9 }
        L_0x02d6:
            androidx.media3.exoplayer.AudioBecomingNoisyManager r0 = new androidx.media3.exoplayer.AudioBecomingNoisyManager     // Catch:{ all -> 0x03c9 }
            android.content.Context r8 = r6.f5243a     // Catch:{ all -> 0x03c9 }
            r9 = r36
            r0.<init>(r8, r9, r4)     // Catch:{ all -> 0x03c9 }
            r1.A = r0     // Catch:{ all -> 0x03c9 }
            boolean r8 = r6.f5258p     // Catch:{ all -> 0x03c9 }
            r0.b(r8)     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.AudioFocusManager r0 = new androidx.media3.exoplayer.AudioFocusManager     // Catch:{ all -> 0x03c9 }
            android.content.Context r8 = r6.f5243a     // Catch:{ all -> 0x03c9 }
            r0.<init>(r8, r9, r4)     // Catch:{ all -> 0x03c9 }
            r1.B = r0     // Catch:{ all -> 0x03c9 }
            boolean r8 = r6.f5256n     // Catch:{ all -> 0x03c9 }
            if (r8 == 0) goto L_0x02f6
            androidx.media3.common.AudioAttributes r14 = r1.f5289j0     // Catch:{ all -> 0x03c9 }
            goto L_0x02f7
        L_0x02f6:
            r14 = 0
        L_0x02f7:
            r0.m(r14)     // Catch:{ all -> 0x03c9 }
            if (r30 == 0) goto L_0x031b
            r0 = 23
            if (r3 < r0) goto L_0x031b
            java.lang.String r0 = "audio"
            r3 = r29
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch:{ all -> 0x03c9 }
            android.media.AudioManager r0 = (android.media.AudioManager) r0     // Catch:{ all -> 0x03c9 }
            r1.G = r0     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback r3 = new androidx.media3.exoplayer.ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback     // Catch:{ all -> 0x03c9 }
            r8 = 0
            r3.<init>()     // Catch:{ all -> 0x03c9 }
            android.os.Handler r10 = new android.os.Handler     // Catch:{ all -> 0x03c9 }
            r10.<init>(r7)     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.ExoPlayerImpl.Api23.b(r0, r3, r10)     // Catch:{ all -> 0x03c9 }
            goto L_0x031c
        L_0x031b:
            r8 = 0
        L_0x031c:
            boolean r0 = r6.f5260r     // Catch:{ all -> 0x03c9 }
            if (r0 == 0) goto L_0x0335
            androidx.media3.exoplayer.StreamVolumeManager r0 = new androidx.media3.exoplayer.StreamVolumeManager     // Catch:{ all -> 0x03c9 }
            android.content.Context r3 = r6.f5243a     // Catch:{ all -> 0x03c9 }
            r0.<init>(r3, r9, r4)     // Catch:{ all -> 0x03c9 }
            r1.C = r0     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.AudioAttributes r3 = r1.f5289j0     // Catch:{ all -> 0x03c9 }
            int r3 = r3.f3917c     // Catch:{ all -> 0x03c9 }
            int r3 = androidx.media3.common.util.Util.m0(r3)     // Catch:{ all -> 0x03c9 }
            r0.h(r3)     // Catch:{ all -> 0x03c9 }
            goto L_0x0337
        L_0x0335:
            r1.C = r8     // Catch:{ all -> 0x03c9 }
        L_0x0337:
            androidx.media3.exoplayer.WakeLockManager r0 = new androidx.media3.exoplayer.WakeLockManager     // Catch:{ all -> 0x03c9 }
            android.content.Context r3 = r6.f5243a     // Catch:{ all -> 0x03c9 }
            r0.<init>(r3)     // Catch:{ all -> 0x03c9 }
            r1.D = r0     // Catch:{ all -> 0x03c9 }
            int r3 = r6.f5257o     // Catch:{ all -> 0x03c9 }
            if (r3 == 0) goto L_0x0346
            r12 = 1
            goto L_0x0347
        L_0x0346:
            r12 = 0
        L_0x0347:
            r0.a(r12)     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.WifiLockManager r0 = new androidx.media3.exoplayer.WifiLockManager     // Catch:{ all -> 0x03c9 }
            android.content.Context r3 = r6.f5243a     // Catch:{ all -> 0x03c9 }
            r0.<init>(r3)     // Catch:{ all -> 0x03c9 }
            r1.E = r0     // Catch:{ all -> 0x03c9 }
            int r3 = r6.f5257o     // Catch:{ all -> 0x03c9 }
            r4 = 2
            if (r3 != r4) goto L_0x035a
            r12 = 1
            goto L_0x035b
        L_0x035a:
            r12 = 0
        L_0x035b:
            r0.a(r12)     // Catch:{ all -> 0x03c9 }
            androidx.media3.exoplayer.StreamVolumeManager r0 = r1.C     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.DeviceInfo r0 = v1(r0)     // Catch:{ all -> 0x03c9 }
            r1.f5309t0 = r0     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.VideoSize r0 = androidx.media3.common.VideoSize.f4483e     // Catch:{ all -> 0x03c9 }
            r1.f5311u0 = r0     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.util.Size r0 = androidx.media3.common.util.Size.f4698c     // Catch:{ all -> 0x03c9 }
            r1.f5281f0 = r0     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.AudioAttributes r0 = r1.f5289j0     // Catch:{ all -> 0x03c9 }
            r2 = r40
            r2.l(r0)     // Catch:{ all -> 0x03c9 }
            int r0 = r1.f5287i0     // Catch:{ all -> 0x03c9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r2 = 10
            r1.o2(r5, r2, r0)     // Catch:{ all -> 0x03c9 }
            int r0 = r1.f5287i0     // Catch:{ all -> 0x03c9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r1.o2(r4, r2, r0)     // Catch:{ all -> 0x03c9 }
            androidx.media3.common.AudioAttributes r0 = r1.f5289j0     // Catch:{ all -> 0x03c9 }
            r2 = 3
            r1.o2(r5, r2, r0)     // Catch:{ all -> 0x03c9 }
            int r0 = r1.f5277d0     // Catch:{ all -> 0x03c9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r2 = 4
            r1.o2(r4, r2, r0)     // Catch:{ all -> 0x03c9 }
            int r0 = r1.f5279e0     // Catch:{ all -> 0x03c9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r2 = 5
            r1.o2(r4, r2, r0)     // Catch:{ all -> 0x03c9 }
            boolean r0 = r1.f5293l0     // Catch:{ all -> 0x03c9 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r2 = 9
            r1.o2(r5, r2, r0)     // Catch:{ all -> 0x03c9 }
            r0 = r42
            r2 = 7
            r1.o2(r4, r2, r0)     // Catch:{ all -> 0x03c9 }
            r2 = 8
            r3 = 6
            r1.o2(r3, r2, r0)     // Catch:{ all -> 0x03c9 }
            int r0 = r1.f5301p0     // Catch:{ all -> 0x03c9 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x03c9 }
            r2 = 16
            r1.p2(r2, r0)     // Catch:{ all -> 0x03c9 }
            r26.e()
            return
        L_0x03c9:
            r0 = move-exception
            androidx.media3.common.util.ConditionVariable r2 = r1.f5276d
            r2.e()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImpl.<init>(androidx.media3.exoplayer.ExoPlayer$Builder, androidx.media3.common.Player):void");
    }

    private long A1(PlaybackInfo playbackInfo) {
        long j2;
        if (playbackInfo.f5464a.q()) {
            return Util.P0(this.f5321z0);
        }
        if (playbackInfo.f5479p) {
            j2 = playbackInfo.m();
        } else {
            j2 = playbackInfo.f5482s;
        }
        if (playbackInfo.f5465b.b()) {
            return j2;
        }
        return l2(playbackInfo.f5464a, playbackInfo.f5465b, j2);
    }

    private void A2(PlaybackInfo playbackInfo, int i2, boolean z2, int i3, long j2, int i4, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        PlaybackInfo playbackInfo2 = playbackInfo;
        int i5 = i3;
        PlaybackInfo playbackInfo3 = this.f5315w0;
        this.f5315w0 = playbackInfo2;
        boolean z7 = !playbackInfo3.f5464a.equals(playbackInfo2.f5464a);
        Pair<Boolean, Integer> y1 = y1(playbackInfo, playbackInfo3, z2, i3, z7, z3);
        boolean booleanValue = ((Boolean) y1.first).booleanValue();
        int intValue = ((Integer) y1.second).intValue();
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo2.f5464a.q()) {
                mediaItem = playbackInfo2.f5464a.n(playbackInfo2.f5464a.h(playbackInfo2.f5465b.f6971a, this.f5296n).f4357c, this.f3929a).f4374c;
            }
            this.f5313v0 = MediaMetadata.J;
        }
        if (booleanValue || !playbackInfo3.f5473j.equals(playbackInfo2.f5473j)) {
            this.f5313v0 = this.f5313v0.a().M(playbackInfo2.f5473j).I();
        }
        MediaMetadata r12 = r1();
        boolean z8 = !r12.equals(this.S);
        this.S = r12;
        if (playbackInfo3.f5475l != playbackInfo2.f5475l) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (playbackInfo3.f5468e != playbackInfo2.f5468e) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || z4) {
            D2();
        }
        boolean z9 = playbackInfo3.f5470g;
        boolean z10 = playbackInfo2.f5470g;
        if (z9 != z10) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            C2(z10);
        }
        if (z7) {
            this.f5292l.i(0, new t(playbackInfo2, i2));
        }
        if (z2) {
            this.f5292l.i(11, new b(i5, F1(i5, playbackInfo3, i4), E1(j2)));
        }
        if (booleanValue) {
            this.f5292l.i(1, new c(mediaItem, intValue));
        }
        if (playbackInfo3.f5469f != playbackInfo2.f5469f) {
            this.f5292l.i(10, new d(playbackInfo2));
            if (playbackInfo2.f5469f != null) {
                this.f5292l.i(10, new e(playbackInfo2));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo3.f5472i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo2.f5472i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f5284h.i(trackSelectorResult2.f7476e);
            this.f5292l.i(2, new f(playbackInfo2));
        }
        if (z8) {
            this.f5292l.i(14, new g(this.S));
        }
        if (z6) {
            this.f5292l.i(3, new h(playbackInfo2));
        }
        if (z5 || z4) {
            this.f5292l.i(-1, new i(playbackInfo2));
        }
        if (z5) {
            this.f5292l.i(4, new j(playbackInfo2));
        }
        if (z4 || playbackInfo3.f5476m != playbackInfo2.f5476m) {
            this.f5292l.i(5, new u(playbackInfo2));
        }
        if (playbackInfo3.f5477n != playbackInfo2.f5477n) {
            this.f5292l.i(6, new v(playbackInfo2));
        }
        if (playbackInfo3.n() != playbackInfo.n()) {
            this.f5292l.i(7, new w(playbackInfo2));
        }
        if (!playbackInfo3.f5478o.equals(playbackInfo2.f5478o)) {
            this.f5292l.i(12, new x(playbackInfo2));
        }
        y2();
        this.f5292l.f();
        if (playbackInfo3.f5479p != playbackInfo2.f5479p) {
            Iterator<ExoPlayer.AudioOffloadListener> it2 = this.f5294m.iterator();
            while (it2.hasNext()) {
                it2.next().F(playbackInfo2.f5479p);
            }
        }
    }

    private int B1(PlaybackInfo playbackInfo) {
        if (playbackInfo.f5464a.q()) {
            return this.f5317x0;
        }
        return playbackInfo.f5464a.h(playbackInfo.f5465b.f6971a, this.f5296n).f4357c;
    }

    /* access modifiers changed from: private */
    public void B2(boolean z2, int i2, int i3) {
        this.K++;
        PlaybackInfo playbackInfo = this.f5315w0;
        if (playbackInfo.f5479p) {
            playbackInfo = playbackInfo.a();
        }
        PlaybackInfo e2 = playbackInfo.e(z2, i2, i3);
        this.f5290k.a1(z2, i2, i3);
        A2(e2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* access modifiers changed from: private */
    public static int C1(int i2) {
        return i2 == -1 ? 2 : 1;
    }

    private void C2(boolean z2) {
        PriorityTaskManager priorityTaskManager = this.f5303q0;
        if (priorityTaskManager == null) {
            return;
        }
        if (z2 && !this.f5305r0) {
            priorityTaskManager.a(this.f5301p0);
            this.f5305r0 = true;
        } else if (!z2 && this.f5305r0) {
            priorityTaskManager.c(this.f5301p0);
            this.f5305r0 = false;
        }
    }

    /* access modifiers changed from: private */
    public void D2() {
        int playbackState = getPlaybackState();
        boolean z2 = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean K1 = K1();
                WakeLockManager wakeLockManager = this.D;
                if (!A() || K1) {
                    z2 = false;
                }
                wakeLockManager.b(z2);
                this.E.b(A());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.D.b(false);
        this.E.b(false);
    }

    private Player.PositionInfo E1(long j2) {
        int i2;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        long j3;
        int M2 = M();
        if (!this.f5315w0.f5464a.q()) {
            PlaybackInfo playbackInfo = this.f5315w0;
            Object obj3 = playbackInfo.f5465b.f6971a;
            playbackInfo.f5464a.h(obj3, this.f5296n);
            int b2 = this.f5315w0.f5464a.b(obj3);
            i2 = b2;
            obj = obj3;
            obj2 = this.f5315w0.f5464a.n(M2, this.f3929a).f4372a;
            mediaItem = this.f3929a.f4374c;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
            i2 = -1;
        }
        long t1 = Util.t1(j2);
        if (this.f5315w0.f5465b.b()) {
            j3 = Util.t1(G1(this.f5315w0));
        } else {
            j3 = t1;
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.f5315w0.f5465b;
        return new Player.PositionInfo(obj2, M2, mediaItem, obj, i2, t1, j3, mediaPeriodId.f6972b, mediaPeriodId.f6973c);
    }

    private void E2() {
        IllegalStateException illegalStateException;
        this.f5276d.b();
        if (Thread.currentThread() != u().getThread()) {
            String G2 = Util.G("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), u().getThread().getName());
            if (!this.f5297n0) {
                if (this.f5299o0) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                Log.i("ExoPlayerImpl", G2, illegalStateException);
                this.f5299o0 = true;
                return;
            }
            throw new IllegalStateException(G2);
        }
    }

    private Player.PositionInfo F1(int i2, PlaybackInfo playbackInfo, int i3) {
        int i4;
        Object obj;
        MediaItem mediaItem;
        int i5;
        Object obj2;
        long j2;
        long j3;
        PlaybackInfo playbackInfo2 = playbackInfo;
        Timeline.Period period = new Timeline.Period();
        if (!playbackInfo2.f5464a.q()) {
            Object obj3 = playbackInfo2.f5465b.f6971a;
            playbackInfo2.f5464a.h(obj3, period);
            int i6 = period.f4357c;
            int b2 = playbackInfo2.f5464a.b(obj3);
            Object obj4 = playbackInfo2.f5464a.n(i6, this.f3929a).f4372a;
            mediaItem = this.f3929a.f4374c;
            obj = obj3;
            i4 = b2;
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
            if (playbackInfo2.f5465b.b()) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.f5465b;
                j3 = period.b(mediaPeriodId.f6972b, mediaPeriodId.f6973c);
                j2 = G1(playbackInfo);
                long t1 = Util.t1(j3);
                long t12 = Util.t1(j2);
                MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f5465b;
                return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, t1, t12, mediaPeriodId2.f6972b, mediaPeriodId2.f6973c);
            } else if (playbackInfo2.f5465b.f6975e != -1) {
                j3 = G1(this.f5315w0);
            } else {
                j3 = period.f4359e + period.f4358d;
            }
        } else if (playbackInfo2.f5465b.b()) {
            j3 = playbackInfo2.f5482s;
            j2 = G1(playbackInfo);
            long t13 = Util.t1(j3);
            long t122 = Util.t1(j2);
            MediaSource.MediaPeriodId mediaPeriodId22 = playbackInfo2.f5465b;
            return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, t13, t122, mediaPeriodId22.f6972b, mediaPeriodId22.f6973c);
        } else {
            j3 = period.f4359e + playbackInfo2.f5482s;
        }
        j2 = j3;
        long t132 = Util.t1(j3);
        long t1222 = Util.t1(j2);
        MediaSource.MediaPeriodId mediaPeriodId222 = playbackInfo2.f5465b;
        return new Player.PositionInfo(obj2, i5, mediaItem, obj, i4, t132, t1222, mediaPeriodId222.f6972b, mediaPeriodId222.f6973c);
    }

    private static long G1(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.f5464a.h(playbackInfo.f5465b.f6971a, period);
        if (playbackInfo.f5466c == -9223372036854775807L) {
            return playbackInfo.f5464a.n(period.f4357c, window).c();
        }
        return period.n() + playbackInfo.f5466c;
    }

    /* access modifiers changed from: private */
    /* renamed from: H1 */
    public void N1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j2;
        boolean z2;
        int i2 = this.K - playbackInfoUpdate.f5371c;
        this.K = i2;
        boolean z3 = true;
        if (playbackInfoUpdate.f5372d) {
            this.L = playbackInfoUpdate.f5373e;
            this.M = true;
        }
        if (i2 == 0) {
            Timeline timeline = playbackInfoUpdate.f5370b.f5464a;
            if (!this.f5315w0.f5464a.q() && timeline.q()) {
                this.f5317x0 = -1;
                this.f5321z0 = 0;
                this.f5319y0 = 0;
            }
            if (!timeline.q()) {
                List<Timeline> F2 = ((PlaylistTimeline) timeline).F();
                if (F2.size() == this.f5298o.size()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.h(z2);
                for (int i3 = 0; i3 < F2.size(); i3++) {
                    this.f5298o.get(i3).c(F2.get(i3));
                }
            }
            long j3 = -9223372036854775807L;
            if (this.M) {
                if (playbackInfoUpdate.f5370b.f5465b.equals(this.f5315w0.f5465b) && playbackInfoUpdate.f5370b.f5467d == this.f5315w0.f5482s) {
                    z3 = false;
                }
                if (z3) {
                    if (timeline.q() || playbackInfoUpdate.f5370b.f5465b.b()) {
                        j2 = playbackInfoUpdate.f5370b.f5467d;
                    } else {
                        PlaybackInfo playbackInfo = playbackInfoUpdate.f5370b;
                        j2 = l2(timeline, playbackInfo.f5465b, playbackInfo.f5467d);
                    }
                    j3 = j2;
                }
            } else {
                z3 = false;
            }
            this.M = false;
            A2(playbackInfoUpdate.f5370b, 1, z3, this.L, j3, -1, false);
        }
    }

    /* access modifiers changed from: private */
    public boolean I1() {
        AudioManager audioManager = this.G;
        if (audioManager == null || Util.f4714a < 23) {
            return true;
        }
        return Api23.a(this.f5278e, audioManager.getDevices(2));
    }

    private int J1(int i2) {
        AudioTrack audioTrack = this.W;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i2)) {
            this.W.release();
            this.W = null;
        }
        if (this.W == null) {
            this.W = new AudioTrack(3, 4000, 4, 2, 2, 0, i2);
        }
        return this.W.getAudioSessionId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1(Player.Listener listener, FlagSet flagSet) {
        listener.P(this.f5280f, new Player.Events(flagSet));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f5286i.g(new p(this, playbackInfoUpdate));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T1(Player.Listener listener) {
        listener.L(this.R);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void V1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.onPositionDiscontinuity(i2);
        listener.a0(positionInfo, positionInfo2, i2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b2(PlaybackInfo playbackInfo, Player.Listener listener) {
        listener.onLoadingChanged(playbackInfo.f5470g);
        listener.onIsLoadingChanged(playbackInfo.f5470g);
    }

    private PlaybackInfo i2(PlaybackInfo playbackInfo, Timeline timeline, Pair<Object, Long> pair) {
        boolean z2;
        MediaSource.MediaPeriodId mediaPeriodId;
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List list;
        int i2;
        long j2;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        if (timeline.q() || pair2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        Timeline timeline3 = playbackInfo.f5464a;
        long z1 = z1(playbackInfo);
        PlaybackInfo j3 = playbackInfo.j(timeline);
        if (timeline.q()) {
            MediaSource.MediaPeriodId l2 = PlaybackInfo.l();
            long P0 = Util.P0(this.f5321z0);
            PlaybackInfo c2 = j3.d(l2, P0, P0, P0, 0, TrackGroupArray.f7176d, this.f5272b, ImmutableList.r()).c(l2);
            c2.f5480q = c2.f5482s;
            return c2;
        }
        Object obj = j3.f5465b.f6971a;
        boolean z3 = !obj.equals(((Pair) Util.i(pair)).first);
        if (z3) {
            mediaPeriodId = new MediaSource.MediaPeriodId(pair2.first);
        } else {
            mediaPeriodId = j3.f5465b;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long longValue = ((Long) pair2.second).longValue();
        long P02 = Util.P0(z1);
        if (!timeline3.q()) {
            P02 -= timeline3.h(obj, this.f5296n).n();
        }
        if (z3 || longValue < P02) {
            long j4 = longValue;
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            Assertions.h(!mediaPeriodId3.b());
            if (z3) {
                trackGroupArray = TrackGroupArray.f7176d;
            } else {
                trackGroupArray = j3.f5471h;
            }
            TrackGroupArray trackGroupArray2 = trackGroupArray;
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId3;
            if (z3) {
                trackSelectorResult = this.f5272b;
            } else {
                trackSelectorResult = j3.f5472i;
            }
            TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
            if (z3) {
                list = ImmutableList.r();
            } else {
                list = j3.f5473j;
            }
            PlaybackInfo c3 = j3.d(mediaPeriodId4, j4, j4, j4, 0, trackGroupArray2, trackSelectorResult2, list).c(mediaPeriodId4);
            c3.f5480q = j4;
            return c3;
        }
        if (i2 == 0) {
            int b2 = timeline2.b(j3.f5474k.f6971a);
            if (b2 == -1 || timeline2.f(b2, this.f5296n).f4357c != timeline2.h(mediaPeriodId2.f6971a, this.f5296n).f4357c) {
                timeline2.h(mediaPeriodId2.f6971a, this.f5296n);
                if (mediaPeriodId2.b()) {
                    j2 = this.f5296n.b(mediaPeriodId2.f6972b, mediaPeriodId2.f6973c);
                } else {
                    j2 = this.f5296n.f4358d;
                }
                j3 = j3.d(mediaPeriodId2, j3.f5482s, j3.f5482s, j3.f5467d, j2 - j3.f5482s, j3.f5471h, j3.f5472i, j3.f5473j).c(mediaPeriodId2);
                j3.f5480q = j2;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId2;
            Assertions.h(!mediaPeriodId5.b());
            long max = Math.max(0, j3.f5481r - (longValue - P02));
            long j5 = j3.f5480q;
            if (j3.f5474k.equals(j3.f5465b)) {
                j5 = longValue + max;
            }
            j3 = j3.d(mediaPeriodId5, longValue, longValue, longValue, max, j3.f5471h, j3.f5472i, j3.f5473j);
            j3.f5480q = j5;
        }
        return j3;
    }

    private Pair<Object, Long> j2(Timeline timeline, int i2, long j2) {
        if (timeline.q()) {
            this.f5317x0 = i2;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.f5321z0 = j2;
            this.f5319y0 = 0;
            return null;
        }
        if (i2 == -1 || i2 >= timeline.p()) {
            i2 = timeline.a(this.J);
            j2 = timeline.n(i2, this.f3929a).b();
        }
        return timeline.j(this.f3929a, this.f5296n, i2, Util.P0(j2));
    }

    /* access modifiers changed from: private */
    public void k2(int i2, int i3) {
        if (i2 != this.f5281f0.b() || i3 != this.f5281f0.a()) {
            this.f5281f0 = new Size(i2, i3);
            this.f5292l.l(24, new n(i2, i3));
            o2(2, 14, new Size(i2, i3));
        }
    }

    private long l2(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        timeline.h(mediaPeriodId.f6971a, this.f5296n);
        return j2 + this.f5296n.n();
    }

    private void m2(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            this.f5298o.remove(i4);
        }
        this.O = this.O.a(i2, i3);
    }

    private void n2() {
        if (this.f5271a0 != null) {
            x1(this.f5320z).n(10000).m((Object) null).l();
            this.f5271a0.i(this.f5318y);
            this.f5271a0 = null;
        }
        TextureView textureView = this.f5275c0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f5318y) {
                Log.h("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f5275c0.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.f5275c0 = null;
        }
        SurfaceHolder surfaceHolder = this.Z;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f5318y);
            this.Z = null;
        }
    }

    private void o2(int i2, int i3, Object obj) {
        for (Renderer renderer : this.f5282g) {
            if (i2 == -1 || renderer.d() == i2) {
                x1(renderer).n(i3).m(obj).l();
            }
        }
    }

    private void p2(int i2, Object obj) {
        o2(-1, i2, obj);
    }

    private List<MediaSourceList.MediaSourceHolder> q1(int i2, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i3), this.f5300p);
            arrayList.add(mediaSourceHolder);
            this.f5298o.add(i3 + i2, new MediaSourceHolderSnapshot(mediaSourceHolder.f5459b, mediaSourceHolder.f5458a));
        }
        this.O = this.O.g(i2, arrayList.size());
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void q2() {
        o2(1, 2, Float.valueOf(this.f5291k0 * this.B.g()));
    }

    /* access modifiers changed from: private */
    public MediaMetadata r1() {
        Timeline t2 = t();
        if (t2.q()) {
            return this.f5313v0;
        }
        return this.f5313v0.a().K(t2.n(M(), this.f3929a).f4374c.f4082e).I();
    }

    private void s2(List<MediaSource> list, int i2, long j2, boolean z2) {
        int i3;
        long j3;
        int i4 = i2;
        int B1 = B1(this.f5315w0);
        long currentPosition = getCurrentPosition();
        boolean z3 = true;
        this.K++;
        if (!this.f5298o.isEmpty()) {
            m2(0, this.f5298o.size());
        }
        List<MediaSourceList.MediaSourceHolder> q12 = q1(0, list);
        Timeline w1 = w1();
        if (w1.q() || i4 < w1.p()) {
            long j4 = j2;
            if (z2) {
                j3 = -9223372036854775807L;
                i3 = w1.a(this.J);
            } else if (i4 == -1) {
                i3 = B1;
                j3 = currentPosition;
            } else {
                i3 = i4;
                j3 = j4;
            }
            PlaybackInfo i22 = i2(this.f5315w0, w1, j2(w1, i3, j3));
            int i5 = i22.f5468e;
            if (!(i3 == -1 || i5 == 1)) {
                i5 = (w1.q() || i3 >= w1.p()) ? 4 : 2;
            }
            PlaybackInfo h2 = i22.h(i5);
            this.f5290k.X0(q12, i3, Util.P0(j3), this.O);
            if (this.f5315w0.f5465b.f6971a.equals(h2.f5465b.f6971a) || this.f5315w0.f5464a.q()) {
                z3 = false;
            }
            A2(h2, 0, z3, 4, A1(h2), -1, false);
            return;
        }
        throw new IllegalSeekPositionException(w1, i4, j2);
    }

    private void t2(SurfaceHolder surfaceHolder) {
        this.f5273b0 = false;
        this.Z = surfaceHolder;
        surfaceHolder.addCallback(this.f5318y);
        Surface surface = this.Z.getSurface();
        if (surface == null || !surface.isValid()) {
            k2(0, 0);
            return;
        }
        Rect surfaceFrame = this.Z.getSurfaceFrame();
        k2(surfaceFrame.width(), surfaceFrame.height());
    }

    private int u1(boolean z2, int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (!this.H) {
            return 0;
        }
        if (z2 && !I1()) {
            return 3;
        }
        if (z2 || this.f5315w0.f5477n != 3) {
            return 0;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public void u2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        v2(surface);
        this.Y = surface;
    }

    /* access modifiers changed from: private */
    public static DeviceInfo v1(StreamVolumeManager streamVolumeManager) {
        int i2;
        int i3 = 0;
        DeviceInfo.Builder builder = new DeviceInfo.Builder(0);
        if (streamVolumeManager != null) {
            i2 = streamVolumeManager.d();
        } else {
            i2 = 0;
        }
        DeviceInfo.Builder g2 = builder.g(i2);
        if (streamVolumeManager != null) {
            i3 = streamVolumeManager.c();
        }
        return g2.f(i3).e();
    }

    /* access modifiers changed from: private */
    public void v2(Object obj) {
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        boolean z2 = false;
        for (Renderer renderer : this.f5282g) {
            if (renderer.d() == 2) {
                arrayList.add(x1(renderer).n(1).m(obj).l());
            }
        }
        Object obj2 = this.X;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (PlayerMessage a2 : arrayList) {
                    a2.a(this.F);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            Object obj3 = this.X;
            Surface surface = this.Y;
            if (obj3 == surface) {
                surface.release();
                this.Y = null;
            }
        }
        this.X = obj;
        if (z2) {
            x2(ExoPlaybackException.f(new ExoTimeoutException(3), 1003));
        }
    }

    private Timeline w1() {
        return new PlaylistTimeline(this.f5298o, this.O);
    }

    private PlayerMessage x1(PlayerMessage.Target target) {
        int i2;
        int B1 = B1(this.f5315w0);
        ExoPlayerImplInternal exoPlayerImplInternal = this.f5290k;
        Timeline timeline = this.f5315w0.f5464a;
        if (B1 == -1) {
            i2 = 0;
        } else {
            i2 = B1;
        }
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, i2, this.f5316x, exoPlayerImplInternal.I());
    }

    private void x2(ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo = this.f5315w0;
        PlaybackInfo c2 = playbackInfo.c(playbackInfo.f5465b);
        c2.f5480q = c2.f5482s;
        c2.f5481r = 0;
        PlaybackInfo h2 = c2.h(1);
        if (exoPlaybackException != null) {
            h2 = h2.f(exoPlaybackException);
        }
        this.K++;
        this.f5290k.s1();
        A2(h2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    private Pair<Boolean, Integer> y1(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, boolean z2, int i2, boolean z3, boolean z4) {
        Timeline timeline = playbackInfo2.f5464a;
        Timeline timeline2 = playbackInfo.f5464a;
        if (timeline2.q() && timeline.q()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i3 = 3;
        if (timeline2.q() != timeline.q()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!timeline.n(timeline.h(playbackInfo2.f5465b.f6971a, this.f5296n).f4357c, this.f3929a).f4372a.equals(timeline2.n(timeline2.h(playbackInfo.f5465b.f6971a, this.f5296n).f4357c, this.f3929a).f4372a)) {
            if (z2 && i2 == 0) {
                i3 = 1;
            } else if (z2 && i2 == 1) {
                i3 = 2;
            } else if (!z3) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i3));
        } else if (z2 && i2 == 0 && playbackInfo2.f5465b.f6974d < playbackInfo.f5465b.f6974d) {
            return new Pair<>(Boolean.TRUE, 0);
        } else {
            if (!z2 || i2 != 1 || !z4) {
                return new Pair<>(Boolean.FALSE, -1);
            }
            return new Pair<>(Boolean.TRUE, 2);
        }
    }

    private void y2() {
        Player.Commands commands = this.R;
        Player.Commands N2 = Util.N(this.f5280f, this.f5274c);
        this.R = N2;
        if (!N2.equals(commands)) {
            this.f5292l.i(13, new o(this));
        }
    }

    private long z1(PlaybackInfo playbackInfo) {
        if (!playbackInfo.f5465b.b()) {
            return Util.t1(A1(playbackInfo));
        }
        playbackInfo.f5464a.h(playbackInfo.f5465b.f6971a, this.f5296n);
        if (playbackInfo.f5466c == -9223372036854775807L) {
            return playbackInfo.f5464a.n(B1(playbackInfo), this.f3929a).b();
        }
        return this.f5296n.m() + Util.t1(playbackInfo.f5466c);
    }

    /* access modifiers changed from: private */
    public void z2(boolean z2, int i2, int i3) {
        boolean z3;
        if (!z2 || i2 == -1) {
            z3 = false;
        } else {
            z3 = true;
        }
        int u1 = u1(z3, i2);
        PlaybackInfo playbackInfo = this.f5315w0;
        if (playbackInfo.f5475l != z3 || playbackInfo.f5477n != u1 || playbackInfo.f5476m != i3) {
            B2(z3, i3, u1);
        }
    }

    public boolean A() {
        E2();
        return this.f5315w0.f5475l;
    }

    public void B(boolean z2) {
        E2();
        if (this.J != z2) {
            this.J = z2;
            this.f5290k.i1(z2);
            this.f5292l.i(9, new m(z2));
            y2();
            this.f5292l.f();
        }
    }

    public long C() {
        E2();
        return this.f5314w;
    }

    /* renamed from: D1 */
    public ExoPlaybackException k() {
        E2();
        return this.f5315w0.f5469f;
    }

    public int E() {
        E2();
        if (this.f5315w0.f5464a.q()) {
            return this.f5319y0;
        }
        PlaybackInfo playbackInfo = this.f5315w0;
        return playbackInfo.f5464a.b(playbackInfo.f5465b.f6971a);
    }

    public void F(TextureView textureView) {
        E2();
        if (textureView != null && textureView == this.f5275c0) {
            s1();
        }
    }

    public VideoSize G() {
        E2();
        return this.f5311u0;
    }

    public int I() {
        E2();
        if (f()) {
            return this.f5315w0.f5465b.f6973c;
        }
        return -1;
    }

    public long J() {
        E2();
        return this.f5312v;
    }

    public long K() {
        E2();
        return z1(this.f5315w0);
    }

    public boolean K1() {
        E2();
        return this.f5315w0.f5479p;
    }

    public int M() {
        E2();
        int B1 = B1(this.f5315w0);
        if (B1 == -1) {
            return 0;
        }
        return B1;
    }

    public void N(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        E2();
        if (surfaceView == null) {
            surfaceHolder = null;
        } else {
            surfaceHolder = surfaceView.getHolder();
        }
        t1(surfaceHolder);
    }

    public boolean O() {
        E2();
        return this.J;
    }

    public long P() {
        E2();
        if (this.f5315w0.f5464a.q()) {
            return this.f5321z0;
        }
        PlaybackInfo playbackInfo = this.f5315w0;
        if (playbackInfo.f5474k.f6974d != playbackInfo.f5465b.f6974d) {
            return playbackInfo.f5464a.n(M(), this.f3929a).d();
        }
        long j2 = playbackInfo.f5480q;
        if (this.f5315w0.f5474k.b()) {
            PlaybackInfo playbackInfo2 = this.f5315w0;
            Timeline.Period h2 = playbackInfo2.f5464a.h(playbackInfo2.f5474k.f6971a, this.f5296n);
            long f2 = h2.f(this.f5315w0.f5474k.f6972b);
            if (f2 == Long.MIN_VALUE) {
                j2 = h2.f4358d;
            } else {
                j2 = f2;
            }
        }
        PlaybackInfo playbackInfo3 = this.f5315w0;
        return Util.t1(l2(playbackInfo3.f5464a, playbackInfo3.f5474k, j2));
    }

    public MediaMetadata S() {
        E2();
        return this.S;
    }

    public long T() {
        E2();
        return this.f5310u;
    }

    public void W(Player.Listener listener) {
        E2();
        this.f5292l.k((Player.Listener) Assertions.f(listener));
    }

    public void X(boolean z2) {
        E2();
        if (!this.f5307s0) {
            this.A.b(z2);
        }
    }

    public void Y(Player.Listener listener) {
        this.f5292l.c((Player.Listener) Assertions.f(listener));
    }

    public Format Z() {
        E2();
        return this.V;
    }

    public Format a() {
        E2();
        return this.U;
    }

    public void a0(TrackSelectionParameters trackSelectionParameters) {
        E2();
        if (this.f5284h.h() && !trackSelectionParameters.equals(this.f5284h.b())) {
            this.f5284h.m(trackSelectionParameters);
            this.f5292l.l(19, new l(trackSelectionParameters));
        }
    }

    public PlaybackParameters b() {
        E2();
        return this.f5315w0.f5478o;
    }

    public TrackSelector c() {
        E2();
        return this.f5284h;
    }

    public void d(MediaSource mediaSource, long j2) {
        E2();
        r2(Collections.singletonList(mediaSource), 0, j2);
    }

    public void e(PlaybackParameters playbackParameters) {
        E2();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.f4303d;
        }
        if (!this.f5315w0.f5478o.equals(playbackParameters)) {
            PlaybackInfo g2 = this.f5315w0.g(playbackParameters);
            this.K++;
            this.f5290k.c1(playbackParameters);
            A2(g2, 0, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public boolean f() {
        E2();
        return this.f5315w0.f5465b.b();
    }

    public long g() {
        E2();
        return Util.t1(this.f5315w0.f5481r);
    }

    public void g0(int i2, long j2, int i3, boolean z2) {
        boolean z3;
        E2();
        if (i2 != -1) {
            if (i2 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.a(z3);
            Timeline timeline = this.f5315w0.f5464a;
            if (timeline.q() || i2 < timeline.p()) {
                this.f5304r.q();
                this.K++;
                if (f()) {
                    Log.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.f5315w0);
                    playbackInfoUpdate.b(1);
                    this.f5288j.a(playbackInfoUpdate);
                    return;
                }
                PlaybackInfo playbackInfo = this.f5315w0;
                int i4 = playbackInfo.f5468e;
                if (i4 == 3 || (i4 == 4 && !timeline.q())) {
                    playbackInfo = this.f5315w0.h(2);
                }
                int M2 = M();
                PlaybackInfo i22 = i2(playbackInfo, timeline, j2(timeline, i2, j2));
                this.f5290k.K0(timeline, i2, Util.P0(j2));
                A2(i22, 0, true, 1, A1(i22), M2, z2);
            }
        }
    }

    public long getCurrentPosition() {
        E2();
        return Util.t1(A1(this.f5315w0));
    }

    public long getDuration() {
        E2();
        if (!f()) {
            return D();
        }
        PlaybackInfo playbackInfo = this.f5315w0;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f5465b;
        playbackInfo.f5464a.h(mediaPeriodId.f6971a, this.f5296n);
        return Util.t1(this.f5296n.b(mediaPeriodId.f6972b, mediaPeriodId.f6973c));
    }

    public int getPlaybackState() {
        E2();
        return this.f5315w0.f5468e;
    }

    public int getRepeatMode() {
        E2();
        return this.I;
    }

    public void i(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder;
        E2();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            n2();
            v2(surfaceView);
            t2(surfaceView.getHolder());
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            n2();
            this.f5271a0 = (SphericalGLSurfaceView) surfaceView;
            x1(this.f5320z).n(10000).m(this.f5271a0).l();
            this.f5271a0.d(this.f5318y);
            v2(this.f5271a0.getVideoSurface());
            t2(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder = null;
            } else {
                surfaceHolder = surfaceView.getHolder();
            }
            w2(surfaceHolder);
        }
    }

    public void l(boolean z2) {
        E2();
        int p2 = this.B.p(z2, getPlaybackState());
        z2(z2, p2, C1(p2));
    }

    public Tracks m() {
        E2();
        return this.f5315w0.f5472i.f7475d;
    }

    public CueGroup o() {
        E2();
        return this.f5295m0;
    }

    public void o1(AnalyticsListener analyticsListener) {
        this.f5304r.Q((AnalyticsListener) Assertions.f(analyticsListener));
    }

    public int p() {
        E2();
        if (f()) {
            return this.f5315w0.f5465b.f6972b;
        }
        return -1;
    }

    public void p1(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.f5294m.add(audioOffloadListener);
    }

    public void prepare() {
        E2();
        boolean A2 = A();
        int i2 = 2;
        int p2 = this.B.p(A2, 2);
        z2(A2, p2, C1(p2));
        PlaybackInfo playbackInfo = this.f5315w0;
        if (playbackInfo.f5468e == 1) {
            PlaybackInfo f2 = playbackInfo.f((ExoPlaybackException) null);
            if (f2.f5464a.q()) {
                i2 = 4;
            }
            PlaybackInfo h2 = f2.h(i2);
            this.K++;
            this.f5290k.r0();
            A2(h2, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public void r2(List<MediaSource> list, int i2, long j2) {
        E2();
        s2(list, i2, j2, false);
    }

    public void release() {
        AudioTrack audioTrack;
        Log.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + "AndroidXMedia3/1.4.1" + "] [" + Util.f4718e + "] [" + MediaLibraryInfo.b() + "]");
        E2();
        if (Util.f4714a < 21 && (audioTrack = this.W) != null) {
            audioTrack.release();
            this.W = null;
        }
        this.A.b(false);
        StreamVolumeManager streamVolumeManager = this.C;
        if (streamVolumeManager != null) {
            streamVolumeManager.g();
        }
        this.D.b(false);
        this.E.b(false);
        this.B.i();
        if (!this.f5290k.t0()) {
            this.f5292l.l(10, new k());
        }
        this.f5292l.j();
        this.f5286i.d((Object) null);
        this.f5308t.d(this.f5304r);
        PlaybackInfo playbackInfo = this.f5315w0;
        if (playbackInfo.f5479p) {
            this.f5315w0 = playbackInfo.a();
        }
        PlaybackInfo h2 = this.f5315w0.h(1);
        this.f5315w0 = h2;
        PlaybackInfo c2 = h2.c(h2.f5465b);
        this.f5315w0 = c2;
        c2.f5480q = c2.f5482s;
        this.f5315w0.f5481r = 0;
        this.f5304r.release();
        this.f5284h.j();
        n2();
        Surface surface = this.Y;
        if (surface != null) {
            surface.release();
            this.Y = null;
        }
        if (this.f5305r0) {
            ((PriorityTaskManager) Assertions.f(this.f5303q0)).c(this.f5301p0);
            this.f5305r0 = false;
        }
        this.f5295m0 = CueGroup.f4592c;
        this.f5307s0 = true;
    }

    public int s() {
        E2();
        return this.f5315w0.f5477n;
    }

    public void s1() {
        E2();
        n2();
        v2((Object) null);
        k2(0, 0);
    }

    public void setImageOutput(ImageOutput imageOutput) {
        E2();
        o2(4, 15, imageOutput);
    }

    public void setRepeatMode(int i2) {
        E2();
        if (this.I != i2) {
            this.I = i2;
            this.f5290k.f1(i2);
            this.f5292l.i(8, new s(i2));
            y2();
            this.f5292l.f();
        }
    }

    public void stop() {
        E2();
        this.B.p(A(), 1);
        x2((ExoPlaybackException) null);
        this.f5295m0 = new CueGroup(ImmutableList.r(), this.f5315w0.f5482s);
    }

    public Timeline t() {
        E2();
        return this.f5315w0.f5464a;
    }

    public void t1(SurfaceHolder surfaceHolder) {
        E2();
        if (surfaceHolder != null && surfaceHolder == this.Z) {
            s1();
        }
    }

    public Looper u() {
        return this.f5306s;
    }

    public TrackSelectionParameters v() {
        E2();
        return this.f5284h.b();
    }

    public void w2(SurfaceHolder surfaceHolder) {
        E2();
        if (surfaceHolder == null) {
            s1();
            return;
        }
        n2();
        this.f5273b0 = true;
        this.Z = surfaceHolder;
        surfaceHolder.addCallback(this.f5318y);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            v2((Object) null);
            k2(0, 0);
            return;
        }
        v2(surface);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        k2(surfaceFrame.width(), surfaceFrame.height());
    }

    public void x(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        E2();
        if (textureView == null) {
            s1();
            return;
        }
        n2();
        this.f5275c0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.h("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f5318y);
        if (textureView.isAvailable()) {
            surfaceTexture = textureView.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        if (surfaceTexture == null) {
            v2((Object) null);
            k2(0, 0);
            return;
        }
        u2(surfaceTexture);
        k2(textureView.getWidth(), textureView.getHeight());
    }

    public Player.Commands z() {
        E2();
        return this.R;
    }
}
