package androidx.media3.exoplayer.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource$HttpDataSourceException;
import androidx.media3.datasource.HttpDataSource$InvalidContentTypeException;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import f.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    private final Context f5586a;

    /* renamed from: b  reason: collision with root package name */
    private final PlaybackSessionManager f5587b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaybackSession f5588c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5589d = SystemClock.elapsedRealtime();

    /* renamed from: e  reason: collision with root package name */
    private final Timeline.Window f5590e = new Timeline.Window();

    /* renamed from: f  reason: collision with root package name */
    private final Timeline.Period f5591f = new Timeline.Period();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, Long> f5592g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, Long> f5593h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private String f5594i;

    /* renamed from: j  reason: collision with root package name */
    private PlaybackMetrics.Builder f5595j;

    /* renamed from: k  reason: collision with root package name */
    private int f5596k;

    /* renamed from: l  reason: collision with root package name */
    private int f5597l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f5598m = 0;

    /* renamed from: n  reason: collision with root package name */
    private PlaybackException f5599n;

    /* renamed from: o  reason: collision with root package name */
    private PendingFormatUpdate f5600o;

    /* renamed from: p  reason: collision with root package name */
    private PendingFormatUpdate f5601p;

    /* renamed from: q  reason: collision with root package name */
    private PendingFormatUpdate f5602q;

    /* renamed from: r  reason: collision with root package name */
    private Format f5603r;

    /* renamed from: s  reason: collision with root package name */
    private Format f5604s;

    /* renamed from: t  reason: collision with root package name */
    private Format f5605t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f5606u;

    /* renamed from: v  reason: collision with root package name */
    private int f5607v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f5608w;

    /* renamed from: x  reason: collision with root package name */
    private int f5609x;

    /* renamed from: y  reason: collision with root package name */
    private int f5610y;

    /* renamed from: z  reason: collision with root package name */
    private int f5611z;

    private static final class ErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f5612a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5613b;

        public ErrorInfo(int i2, int i3) {
            this.f5612a = i2;
            this.f5613b = i3;
        }
    }

    private static final class PendingFormatUpdate {

        /* renamed from: a  reason: collision with root package name */
        public final Format f5614a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5615b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5616c;

        public PendingFormatUpdate(Format format, int i2, String str) {
            this.f5614a = format;
            this.f5615b = i2;
            this.f5616c = str;
        }
    }

    private MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.f5586a = context.getApplicationContext();
        this.f5588c = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f5587b = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.f(this);
    }

    private static ErrorInfo A0(PlaybackException playbackException, Context context, boolean z2) {
        boolean z3;
        int i2;
        int i3;
        if (playbackException.f4300b == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            if (exoPlaybackException.f5236k == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            i2 = exoPlaybackException.f5240o;
        } else {
            i2 = 0;
            z3 = false;
        }
        Throwable th = (Throwable) Assertions.f(playbackException.getCause());
        if (th instanceof IOException) {
            if (th instanceof HttpDataSource$InvalidResponseCodeException) {
                return new ErrorInfo(5, ((HttpDataSource$InvalidResponseCodeException) th).f4892e);
            }
            if ((th instanceof HttpDataSource$InvalidContentTypeException) || (th instanceof ParserException)) {
                if (z2) {
                    i3 = 10;
                } else {
                    i3 = 11;
                }
                return new ErrorInfo(i3, 0);
            } else if ((th instanceof HttpDataSource$HttpDataSourceException) || (th instanceof UdpDataSource.UdpDataSourceException)) {
                if (NetworkTypeObserver.d(context).f() == 1) {
                    return new ErrorInfo(3, 0);
                }
                Throwable cause = th.getCause();
                if (cause instanceof UnknownHostException) {
                    return new ErrorInfo(6, 0);
                }
                if (cause instanceof SocketTimeoutException) {
                    return new ErrorInfo(7, 0);
                }
                if (!(th instanceof HttpDataSource$HttpDataSourceException) || ((HttpDataSource$HttpDataSourceException) th).f4890d != 1) {
                    return new ErrorInfo(8, 0);
                }
                return new ErrorInfo(4, 0);
            } else if (playbackException.f4300b == 1002) {
                return new ErrorInfo(21, 0);
            } else {
                if (th instanceof DrmSession.DrmSessionException) {
                    Throwable th2 = (Throwable) Assertions.f(th.getCause());
                    int i4 = Util.f4714a;
                    if (i4 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
                        int Z = Util.Z(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
                        return new ErrorInfo(x0(Z), Z);
                    } else if (i4 >= 23 && (th2 instanceof MediaDrmResetException)) {
                        return new ErrorInfo(27, 0);
                    } else {
                        if (th2 instanceof NotProvisionedException) {
                            return new ErrorInfo(24, 0);
                        }
                        if (th2 instanceof DeniedByServerException) {
                            return new ErrorInfo(29, 0);
                        }
                        if (th2 instanceof UnsupportedDrmException) {
                            return new ErrorInfo(23, 0);
                        }
                        if (th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                            return new ErrorInfo(28, 0);
                        }
                        return new ErrorInfo(30, 0);
                    }
                } else if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                    return new ErrorInfo(9, 0);
                } else {
                    Throwable cause2 = ((Throwable) Assertions.f(th.getCause())).getCause();
                    if (Util.f4714a < 21 || !(cause2 instanceof ErrnoException) || ((ErrnoException) cause2).errno != OsConstants.EACCES) {
                        return new ErrorInfo(31, 0);
                    }
                    return new ErrorInfo(32, 0);
                }
            }
        } else if (z3 && (i2 == 0 || i2 == 1)) {
            return new ErrorInfo(35, 0);
        } else {
            if (z3 && i2 == 3) {
                return new ErrorInfo(15, 0);
            }
            if (z3 && i2 == 2) {
                return new ErrorInfo(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new ErrorInfo(13, Util.Z(((MediaCodecRenderer.DecoderInitializationException) th).f6734e));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, ((MediaCodecDecoderException) th).f6686d);
            }
            if (th instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th).f5664b);
            }
            if (th instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th).f5669b);
            }
            if (!(th instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new ErrorInfo(x0(errorCode), errorCode);
        }
    }

    private static Pair<String, String> B0(String str) {
        String str2;
        String[] k12 = Util.k1(str, "-");
        String str3 = k12[0];
        if (k12.length >= 2) {
            str2 = k12[1];
        } else {
            str2 = null;
        }
        return Pair.create(str3, str2);
    }

    private static int D0(Context context) {
        switch (NetworkTypeObserver.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
            default:
                return 1;
        }
    }

    private static int E0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f4079b;
        if (localConfiguration == null) {
            return 0;
        }
        int z02 = Util.z0(localConfiguration.f4171a, localConfiguration.f4172b);
        if (z02 == 0) {
            return 3;
        }
        if (z02 == 1) {
            return 5;
        }
        if (z02 != 2) {
            return 1;
        }
        return 4;
    }

    private static int F0(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void G0(AnalyticsListener.Events events) {
        for (int i2 = 0; i2 < events.d(); i2++) {
            int b2 = events.b(i2);
            AnalyticsListener.EventTime c2 = events.c(b2);
            if (b2 == 0) {
                this.f5587b.d(c2);
            } else if (b2 == 11) {
                this.f5587b.g(c2, this.f5596k);
            } else {
                this.f5587b.b(c2);
            }
        }
    }

    private void H0(long j2) {
        int D0 = D0(this.f5586a);
        if (D0 != this.f5598m) {
            this.f5598m = D0;
            this.f5588c.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(D0).setTimeSinceCreatedMillis(j2 - this.f5589d).build());
        }
    }

    private void I0(long j2) {
        boolean z2;
        PlaybackException playbackException = this.f5599n;
        if (playbackException != null) {
            Context context = this.f5586a;
            if (this.f5607v == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            ErrorInfo A0 = A0(playbackException, context, z2);
            this.f5588c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j2 - this.f5589d).setErrorCode(A0.f5612a).setSubErrorCode(A0.f5613b).setException(playbackException).build());
            this.A = true;
            this.f5599n = null;
        }
    }

    private void J0(Player player, AnalyticsListener.Events events, long j2) {
        if (player.getPlaybackState() != 2) {
            this.f5606u = false;
        }
        if (player.k() == null) {
            this.f5608w = false;
        } else if (events.a(10)) {
            this.f5608w = true;
        }
        int R0 = R0(player);
        if (this.f5597l != R0) {
            this.f5597l = R0;
            this.A = true;
            this.f5588c.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.f5597l).setTimeSinceCreatedMillis(j2 - this.f5589d).build());
        }
    }

    private void K0(Player player, AnalyticsListener.Events events, long j2) {
        if (events.a(2)) {
            Tracks m2 = player.m();
            boolean c2 = m2.c(2);
            boolean c3 = m2.c(1);
            boolean c4 = m2.c(3);
            if (c2 || c3 || c4) {
                if (!c2) {
                    P0(j2, (Format) null, 0);
                }
                if (!c3) {
                    L0(j2, (Format) null, 0);
                }
                if (!c4) {
                    N0(j2, (Format) null, 0);
                }
            }
        }
        if (u0(this.f5600o)) {
            PendingFormatUpdate pendingFormatUpdate = this.f5600o;
            Format format = pendingFormatUpdate.f5614a;
            if (format.f4022u != -1) {
                P0(j2, format, pendingFormatUpdate.f5615b);
                this.f5600o = null;
            }
        }
        if (u0(this.f5601p)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.f5601p;
            L0(j2, pendingFormatUpdate2.f5614a, pendingFormatUpdate2.f5615b);
            this.f5601p = null;
        }
        if (u0(this.f5602q)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.f5602q;
            N0(j2, pendingFormatUpdate3.f5614a, pendingFormatUpdate3.f5615b);
            this.f5602q = null;
        }
    }

    private void L0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f5604s, format)) {
            if (this.f5604s == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f5604s = format;
            Q0(0, j2, format, i3);
        }
    }

    private void M0(Player player, AnalyticsListener.Events events) {
        DrmInitData y02;
        if (events.a(0)) {
            AnalyticsListener.EventTime c2 = events.c(0);
            if (this.f5595j != null) {
                O0(c2.f5543b, c2.f5545d);
            }
        }
        if (!(!events.a(2) || this.f5595j == null || (y02 = y0(player.m().a())) == null)) {
            PlaybackMetrics.Builder unused = ((PlaybackMetrics.Builder) Util.i(this.f5595j)).setDrmType(z0(y02));
        }
        if (events.a(1011)) {
            this.f5611z++;
        }
    }

    private void N0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f5605t, format)) {
            if (this.f5605t == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f5605t = format;
            Q0(2, j2, format, i3);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private void O0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int b2;
        int i2;
        PlaybackMetrics.Builder builder = this.f5595j;
        if (mediaPeriodId != null && (b2 = timeline.b(mediaPeriodId.f6971a)) != -1) {
            timeline.f(b2, this.f5591f);
            timeline.n(this.f5591f.f4357c, this.f5590e);
            PlaybackMetrics.Builder unused = builder.setStreamType(E0(this.f5590e.f4374c));
            Timeline.Window window = this.f5590e;
            if (window.f4384m != -9223372036854775807L && !window.f4382k && !window.f4380i && !window.f()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(this.f5590e.d());
            }
            if (this.f5590e.f()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(i2);
            this.A = true;
        }
    }

    private void P0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f5603r, format)) {
            if (this.f5603r == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f5603r = format;
            Q0(1, j2, format, i3);
        }
    }

    private void Q0(int i2, long j2, Format format, int i3) {
        TrackChangeEvent.Builder a2 = new TrackChangeEvent.Builder(i2).setTimeSinceCreatedMillis(j2 - this.f5589d);
        if (format != null) {
            TrackChangeEvent.Builder unused = a2.setTrackState(1);
            TrackChangeEvent.Builder unused2 = a2.setTrackChangeReason(F0(i3));
            String str = format.f4014m;
            if (str != null) {
                TrackChangeEvent.Builder unused3 = a2.setContainerMimeType(str);
            }
            String str2 = format.f4015n;
            if (str2 != null) {
                TrackChangeEvent.Builder unused4 = a2.setSampleMimeType(str2);
            }
            String str3 = format.f4011j;
            if (str3 != null) {
                TrackChangeEvent.Builder unused5 = a2.setCodecName(str3);
            }
            int i4 = format.f4010i;
            if (i4 != -1) {
                TrackChangeEvent.Builder unused6 = a2.setBitrate(i4);
            }
            int i5 = format.f4021t;
            if (i5 != -1) {
                TrackChangeEvent.Builder unused7 = a2.setWidth(i5);
            }
            int i6 = format.f4022u;
            if (i6 != -1) {
                TrackChangeEvent.Builder unused8 = a2.setHeight(i6);
            }
            int i7 = format.B;
            if (i7 != -1) {
                TrackChangeEvent.Builder unused9 = a2.setChannelCount(i7);
            }
            int i8 = format.C;
            if (i8 != -1) {
                TrackChangeEvent.Builder unused10 = a2.setAudioSampleRate(i8);
            }
            String str4 = format.f4005d;
            if (str4 != null) {
                Pair<String, String> B0 = B0(str4);
                TrackChangeEvent.Builder unused11 = a2.setLanguage((String) B0.first);
                Object obj = B0.second;
                if (obj != null) {
                    TrackChangeEvent.Builder unused12 = a2.setLanguageRegion((String) obj);
                }
            }
            float f2 = format.f4023v;
            if (f2 != -1.0f) {
                TrackChangeEvent.Builder unused13 = a2.setVideoFrameRate(f2);
            }
        } else {
            TrackChangeEvent.Builder unused14 = a2.setTrackState(0);
        }
        this.A = true;
        this.f5588c.reportTrackChangeEvent(a2.build());
    }

    private int R0(Player player) {
        int playbackState = player.getPlaybackState();
        if (this.f5606u) {
            return 5;
        }
        if (this.f5608w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i2 = this.f5597l;
            if (i2 == 0 || i2 == 2 || i2 == 12) {
                return 2;
            }
            if (!player.A()) {
                return 7;
            }
            if (player.s() != 0) {
                return 10;
            }
            return 6;
        } else if (playbackState == 3) {
            if (!player.A()) {
                return 4;
            }
            if (player.s() != 0) {
                return 9;
            }
            return 3;
        } else if (playbackState != 1 || this.f5597l == 0) {
            return this.f5597l;
        } else {
            return 12;
        }
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private boolean u0(PendingFormatUpdate pendingFormatUpdate) {
        if (pendingFormatUpdate == null || !pendingFormatUpdate.f5616c.equals(this.f5587b.a())) {
            return false;
        }
        return true;
    }

    public static MediaMetricsListener v0(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new MediaMetricsListener(context, mediaMetricsManager.createPlaybackSession());
    }

    private void w0() {
        long j2;
        long j3;
        int i2;
        PlaybackMetrics.Builder builder = this.f5595j;
        if (builder != null && this.A) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.f5611z);
            PlaybackMetrics.Builder unused2 = this.f5595j.setVideoFramesDropped(this.f5609x);
            PlaybackMetrics.Builder unused3 = this.f5595j.setVideoFramesPlayed(this.f5610y);
            Long l2 = this.f5592g.get(this.f5594i);
            PlaybackMetrics.Builder builder2 = this.f5595j;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            PlaybackMetrics.Builder unused4 = builder2.setNetworkTransferDurationMillis(j2);
            Long l3 = this.f5593h.get(this.f5594i);
            PlaybackMetrics.Builder builder3 = this.f5595j;
            if (l3 == null) {
                j3 = 0;
            } else {
                j3 = l3.longValue();
            }
            PlaybackMetrics.Builder unused5 = builder3.setNetworkBytesRead(j3);
            PlaybackMetrics.Builder builder4 = this.f5595j;
            if (l3 == null || l3.longValue() <= 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused6 = builder4.setStreamSource(i2);
            this.f5588c.reportPlaybackMetrics(this.f5595j.build());
        }
        this.f5595j = null;
        this.f5594i = null;
        this.f5611z = 0;
        this.f5609x = 0;
        this.f5610y = 0;
        this.f5603r = null;
        this.f5604s = null;
        this.f5605t = null;
        this.A = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int x0(int i2) {
        switch (Util.Y(i2)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE /*6002*/:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE /*6003*/:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData y0(ImmutableList<Tracks.Group> immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator<Tracks.Group> h2 = immutableList.iterator();
        while (h2.hasNext()) {
            Tracks.Group next = h2.next();
            int i2 = 0;
            while (true) {
                if (i2 < next.f4477a) {
                    if (next.h(i2) && (drmInitData = next.b(i2).f4019r) != null) {
                        return drmInitData;
                    }
                    i2++;
                }
            }
        }
        return null;
    }

    private static int z0(DrmInitData drmInitData) {
        for (int i2 = 0; i2 < drmInitData.f3973e; i2++) {
            UUID uuid = drmInitData.f(i2).f3975c;
            if (uuid.equals(C.f3933d)) {
                return 3;
            }
            if (uuid.equals(C.f3934e)) {
                return 2;
            }
            if (uuid.equals(C.f3932c)) {
                return 6;
            }
        }
        return 1;
    }

    public void A(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.f5606u = true;
        }
        this.f5596k = i2;
    }

    public /* synthetic */ void B(AnalyticsListener.EventTime eventTime, int i2) {
        a.v(this, eventTime, i2);
    }

    public /* synthetic */ void C(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        a.m(this, eventTime, commands);
    }

    public LogSessionId C0() {
        return this.f5588c.getSessionId();
    }

    public /* synthetic */ void D(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.a0(this, eventTime, exc);
    }

    public /* synthetic */ void E(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.e0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void F(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.i(this, eventTime, exc);
    }

    public /* synthetic */ void G(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.T(this, eventTime, z2);
    }

    public /* synthetic */ void H(AnalyticsListener.EventTime eventTime, int i2) {
        a.K(this, eventTime, i2);
    }

    public void I(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f5607v = mediaLoadData.f6964a;
    }

    public /* synthetic */ void J(AnalyticsListener.EventTime eventTime, long j2) {
        a.h(this, eventTime, j2);
    }

    public /* synthetic */ void K(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        a.l(this, eventTime, i2, j2, j3);
    }

    public /* synthetic */ void L(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.g(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void M(AnalyticsListener.EventTime eventTime, String str, long j2) {
        a.b(this, eventTime, str, j2);
    }

    public /* synthetic */ void N(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        a.j(this, eventTime, audioTrackConfig);
    }

    public /* synthetic */ void O(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        a.J(this, eventTime, playbackParameters);
    }

    public /* synthetic */ void P(AnalyticsListener.EventTime eventTime, String str) {
        a.d(this, eventTime, str);
    }

    public /* synthetic */ void Q(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        a.k(this, eventTime, audioTrackConfig);
    }

    public /* synthetic */ void R(AnalyticsListener.EventTime eventTime, String str) {
        a.d0(this, eventTime, str);
    }

    public /* synthetic */ void S(AnalyticsListener.EventTime eventTime, int i2) {
        a.L(this, eventTime, i2);
    }

    public /* synthetic */ void T(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        a.Z(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void U(AnalyticsListener.EventTime eventTime) {
        a.s(this, eventTime);
    }

    public /* synthetic */ void V(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        a.h0(this, eventTime, i2, i3, i4, f2);
    }

    public /* synthetic */ void W(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.E(this, eventTime, z2);
    }

    public /* synthetic */ void X(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        a.y(this, eventTime, i2, j2);
    }

    public /* synthetic */ void Y(AnalyticsListener.EventTime eventTime) {
        a.u(this, eventTime);
    }

    public /* synthetic */ void Z(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.D(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void a(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        a.Q(this, eventTime, obj, j2);
    }

    public /* synthetic */ void a0(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        a.O(this, eventTime, z2, i2);
    }

    public /* synthetic */ void b(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.z(this, eventTime, z2);
    }

    public /* synthetic */ void b0(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        a.M(this, eventTime, playbackException);
    }

    public void c(AnalyticsListener.EventTime eventTime, String str, String str2) {
    }

    public /* synthetic */ void c0(AnalyticsListener.EventTime eventTime, String str, long j2) {
        a.b0(this, eventTime, str, j2);
    }

    public /* synthetic */ void d(AnalyticsListener.EventTime eventTime, int i2, boolean z2) {
        a.q(this, eventTime, i2, z2);
    }

    public /* synthetic */ void d0(AnalyticsListener.EventTime eventTime) {
        a.S(this, eventTime);
    }

    public /* synthetic */ void e(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.A(this, eventTime, z2);
    }

    public /* synthetic */ void e0(AnalyticsListener.EventTime eventTime) {
        a.t(this, eventTime);
    }

    public /* synthetic */ void f(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        a.H(this, eventTime, metadata);
    }

    public /* synthetic */ void f0(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        a.Y(this, eventTime, tracks);
    }

    public /* synthetic */ void g(AnalyticsListener.EventTime eventTime, List list) {
        a.o(this, eventTime, list);
    }

    public void g0(AnalyticsListener.EventTime eventTime, String str, boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f5545d;
        if ((mediaPeriodId == null || !mediaPeriodId.b()) && str.equals(this.f5594i)) {
            w0();
        }
        this.f5592g.remove(str);
        this.f5593h.remove(str);
    }

    public /* synthetic */ void h(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.U(this, eventTime, z2);
    }

    public /* synthetic */ void h0(AnalyticsListener.EventTime eventTime, int i2) {
        a.R(this, eventTime, i2);
    }

    public void i(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f5599n = playbackException;
    }

    public /* synthetic */ void i0(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        a.n(this, eventTime, cueGroup);
    }

    public /* synthetic */ void j(AnalyticsListener.EventTime eventTime, int i2) {
        a.P(this, eventTime, i2);
    }

    public /* synthetic */ void j0(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        a.c0(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void k(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        a.I(this, eventTime, z2, i2);
    }

    public void k0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.f5600o;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.f5614a;
            if (format.f4022u == -1) {
                this.f5600o = new PendingFormatUpdate(format.a().v0(videoSize.f4488a).Y(videoSize.f4489b).K(), pendingFormatUpdate.f5615b, pendingFormatUpdate.f5616c);
            }
        }
    }

    public void l(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f5609x += decoderCounters.f5156g;
        this.f5610y += decoderCounters.f5154e;
    }

    public /* synthetic */ void l0(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        a.f0(this, eventTime, j2, i2);
    }

    public /* synthetic */ void m(AnalyticsListener.EventTime eventTime) {
        a.x(this, eventTime);
    }

    public void m0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        if (eventTime.f5545d != null) {
            PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.f(mediaLoadData.f6966c), mediaLoadData.f6967d, this.f5587b.c(eventTime.f5543b, (MediaSource.MediaPeriodId) Assertions.f(eventTime.f5545d)));
            int i2 = mediaLoadData.f6965b;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f5601p = pendingFormatUpdate;
                    return;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.f5602q = pendingFormatUpdate;
                        return;
                    }
                    return;
                }
            }
            this.f5600o = pendingFormatUpdate;
        }
    }

    public void n(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        long j4;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f5545d;
        if (mediaPeriodId != null) {
            String c2 = this.f5587b.c(eventTime.f5543b, (MediaSource.MediaPeriodId) Assertions.f(mediaPeriodId));
            Long l2 = this.f5593h.get(c2);
            Long l3 = this.f5592g.get(c2);
            HashMap<String, Long> hashMap = this.f5593h;
            long j5 = 0;
            if (l2 == null) {
                j4 = 0;
            } else {
                j4 = l2.longValue();
            }
            hashMap.put(c2, Long.valueOf(j4 + j2));
            HashMap<String, Long> hashMap2 = this.f5592g;
            if (l3 != null) {
                j5 = l3.longValue();
            }
            hashMap2.put(c2, Long.valueOf(j5 + ((long) i2)));
        }
    }

    public void n0(Player player, AnalyticsListener.Events events) {
        if (events.d() != 0) {
            G0(events);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            M0(player, events);
            I0(elapsedRealtime);
            K0(player, events, elapsedRealtime);
            H0(elapsedRealtime);
            J0(player, events, elapsedRealtime);
            if (events.a(1028)) {
                this.f5587b.e(events.c(1028));
            }
        }
    }

    public /* synthetic */ void o(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.a(this, eventTime, exc);
    }

    public /* synthetic */ void o0(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        a.p(this, eventTime, deviceInfo);
    }

    public /* synthetic */ void p(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.C(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void p0(AnalyticsListener.EventTime eventTime, String str) {
    }

    public /* synthetic */ void q(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        a.c(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void q0(AnalyticsListener.EventTime eventTime) {
        a.r(this, eventTime);
    }

    public /* synthetic */ void r(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        a.X(this, eventTime, trackSelectionParameters);
    }

    public /* synthetic */ void r0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.B(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void s(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        a.G(this, eventTime, mediaMetadata);
    }

    public void s0(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f5545d;
        if (mediaPeriodId == null || !mediaPeriodId.b()) {
            w0();
            this.f5594i = str;
            this.f5595j = new PlaybackMetrics.Builder().setPlayerName("AndroidXMedia3").setPlayerVersion("1.4.1");
            O0(eventTime.f5543b, eventTime.f5545d);
        }
    }

    public /* synthetic */ void t(AnalyticsListener.EventTime eventTime, int i2) {
        a.W(this, eventTime, i2);
    }

    public /* synthetic */ void t0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.g0(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void u(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.w(this, eventTime, exc);
    }

    public /* synthetic */ void v(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.e(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void w(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        a.F(this, eventTime, mediaItem, i2);
    }

    public /* synthetic */ void x(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.f(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void y(AnalyticsListener.EventTime eventTime) {
        a.N(this, eventTime);
    }

    public /* synthetic */ void z(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        a.V(this, eventTime, i2, i3);
    }
}
