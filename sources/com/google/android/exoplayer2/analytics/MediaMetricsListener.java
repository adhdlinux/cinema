package com.google.android.exoplayer2.analytics;

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
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NetworkTypeObserver;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import h0.a;
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
    private final Context f23596a;

    /* renamed from: b  reason: collision with root package name */
    private final PlaybackSessionManager f23597b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaybackSession f23598c;

    /* renamed from: d  reason: collision with root package name */
    private final long f23599d = SystemClock.elapsedRealtime();

    /* renamed from: e  reason: collision with root package name */
    private final Timeline.Window f23600e = new Timeline.Window();

    /* renamed from: f  reason: collision with root package name */
    private final Timeline.Period f23601f = new Timeline.Period();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, Long> f23602g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<String, Long> f23603h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private String f23604i;

    /* renamed from: j  reason: collision with root package name */
    private PlaybackMetrics.Builder f23605j;

    /* renamed from: k  reason: collision with root package name */
    private int f23606k;

    /* renamed from: l  reason: collision with root package name */
    private int f23607l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f23608m = 0;

    /* renamed from: n  reason: collision with root package name */
    private PlaybackException f23609n;

    /* renamed from: o  reason: collision with root package name */
    private PendingFormatUpdate f23610o;

    /* renamed from: p  reason: collision with root package name */
    private PendingFormatUpdate f23611p;

    /* renamed from: q  reason: collision with root package name */
    private PendingFormatUpdate f23612q;

    /* renamed from: r  reason: collision with root package name */
    private Format f23613r;

    /* renamed from: s  reason: collision with root package name */
    private Format f23614s;

    /* renamed from: t  reason: collision with root package name */
    private Format f23615t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23616u;

    /* renamed from: v  reason: collision with root package name */
    private int f23617v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23618w;

    /* renamed from: x  reason: collision with root package name */
    private int f23619x;

    /* renamed from: y  reason: collision with root package name */
    private int f23620y;

    /* renamed from: z  reason: collision with root package name */
    private int f23621z;

    private static final class ErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f23622a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23623b;

        public ErrorInfo(int i2, int i3) {
            this.f23622a = i2;
            this.f23623b = i3;
        }
    }

    private static final class PendingFormatUpdate {

        /* renamed from: a  reason: collision with root package name */
        public final Format f23624a;

        /* renamed from: b  reason: collision with root package name */
        public final int f23625b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23626c;

        public PendingFormatUpdate(Format format, int i2, String str) {
            this.f23624a = format;
            this.f23625b = i2;
            this.f23626c = str;
        }
    }

    private MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.f23596a = context.getApplicationContext();
        this.f23598c = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.f23597b = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.b(this);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private boolean A0(PendingFormatUpdate pendingFormatUpdate) {
        if (pendingFormatUpdate == null || !pendingFormatUpdate.f23626c.equals(this.f23597b.a())) {
            return false;
        }
        return true;
    }

    public static MediaMetricsListener B0(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new MediaMetricsListener(context, mediaMetricsManager.createPlaybackSession());
    }

    private void C0() {
        long j2;
        long j3;
        int i2;
        PlaybackMetrics.Builder builder = this.f23605j;
        if (builder != null && this.A) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.f23621z);
            PlaybackMetrics.Builder unused2 = this.f23605j.setVideoFramesDropped(this.f23619x);
            PlaybackMetrics.Builder unused3 = this.f23605j.setVideoFramesPlayed(this.f23620y);
            Long l2 = this.f23602g.get(this.f23604i);
            PlaybackMetrics.Builder builder2 = this.f23605j;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            PlaybackMetrics.Builder unused4 = builder2.setNetworkTransferDurationMillis(j2);
            Long l3 = this.f23603h.get(this.f23604i);
            PlaybackMetrics.Builder builder3 = this.f23605j;
            if (l3 == null) {
                j3 = 0;
            } else {
                j3 = l3.longValue();
            }
            PlaybackMetrics.Builder unused5 = builder3.setNetworkBytesRead(j3);
            PlaybackMetrics.Builder builder4 = this.f23605j;
            if (l3 == null || l3.longValue() <= 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused6 = builder4.setStreamSource(i2);
            this.f23598c.reportPlaybackMetrics(this.f23605j.build());
        }
        this.f23605j = null;
        this.f23604i = null;
        this.f23621z = 0;
        this.f23619x = 0;
        this.f23620y = 0;
        this.f23613r = null;
        this.f23614s = null;
        this.f23615t = null;
        this.A = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int D0(int i2) {
        switch (Util.W(i2)) {
            case AdError.ICONVIEW_MISSING_ERROR_CODE:
                return 24;
            case AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static DrmInitData E0(ImmutableList<Tracks.Group> immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator<Tracks.Group> h2 = immutableList.iterator();
        while (h2.hasNext()) {
            Tracks.Group next = h2.next();
            int i2 = 0;
            while (true) {
                if (i2 < next.f23537b) {
                    if (next.g(i2) && (drmInitData = next.c(i2).f23074p) != null) {
                        return drmInitData;
                    }
                    i2++;
                }
            }
        }
        return null;
    }

    private static int F0(DrmInitData drmInitData) {
        for (int i2 = 0; i2 < drmInitData.f24078e; i2++) {
            UUID uuid = drmInitData.f(i2).f24080c;
            if (uuid.equals(C.f22819d)) {
                return 3;
            }
            if (uuid.equals(C.f22820e)) {
                return 2;
            }
            if (uuid.equals(C.f22818c)) {
                return 6;
            }
        }
        return 1;
    }

    private static ErrorInfo G0(PlaybackException playbackException, Context context, boolean z2) {
        boolean z3;
        int i2;
        int i3;
        if (playbackException.f23374b == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            if (exoPlaybackException.f22898j == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            i2 = exoPlaybackException.f22902n;
        } else {
            i2 = 0;
            z3 = false;
        }
        Throwable th = (Throwable) Assertions.e(playbackException.getCause());
        if (th instanceof IOException) {
            if (th instanceof HttpDataSource$InvalidResponseCodeException) {
                return new ErrorInfo(5, ((HttpDataSource$InvalidResponseCodeException) th).f28444e);
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
                if (!(th instanceof HttpDataSource$HttpDataSourceException) || ((HttpDataSource$HttpDataSourceException) th).f28442d != 1) {
                    return new ErrorInfo(8, 0);
                }
                return new ErrorInfo(4, 0);
            } else if (playbackException.f23374b == 1002) {
                return new ErrorInfo(21, 0);
            } else {
                if (th instanceof DrmSession.DrmSessionException) {
                    Throwable th2 = (Throwable) Assertions.e(th.getCause());
                    int i4 = Util.f28808a;
                    if (i4 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
                        int X = Util.X(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
                        return new ErrorInfo(D0(X), X);
                    } else if (i4 >= 23 && (th2 instanceof MediaDrmResetException)) {
                        return new ErrorInfo(27, 0);
                    } else {
                        if (i4 >= 18 && (th2 instanceof NotProvisionedException)) {
                            return new ErrorInfo(24, 0);
                        }
                        if (i4 >= 18 && (th2 instanceof DeniedByServerException)) {
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
                    Throwable cause2 = ((Throwable) Assertions.e(th.getCause())).getCause();
                    if (Util.f28808a < 21 || !(cause2 instanceof ErrnoException) || ((ErrnoException) cause2).errno != OsConstants.EACCES) {
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
                return new ErrorInfo(13, Util.X(((MediaCodecRenderer.DecoderInitializationException) th).f25323e));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, Util.X(((MediaCodecDecoderException) th).f25272c));
            }
            if (th instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th).f23689b);
            }
            if (th instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th).f23694b);
            }
            if (Util.f28808a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new ErrorInfo(D0(errorCode), errorCode);
        }
    }

    private static Pair<String, String> H0(String str) {
        String str2;
        String[] W0 = Util.W0(str, "-");
        String str3 = W0[0];
        if (W0.length >= 2) {
            str2 = W0[1];
        } else {
            str2 = null;
        }
        return Pair.create(str3, str2);
    }

    private static int J0(Context context) {
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

    private static int K0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.f23129c;
        if (localConfiguration == null) {
            return 0;
        }
        int s02 = Util.s0(localConfiguration.f23202a, localConfiguration.f23203b);
        if (s02 == 0) {
            return 3;
        }
        if (s02 == 1) {
            return 5;
        }
        if (s02 != 2) {
            return 1;
        }
        return 4;
    }

    private static int L0(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void M0(AnalyticsListener.Events events) {
        for (int i2 = 0; i2 < events.d(); i2++) {
            int b2 = events.b(i2);
            AnalyticsListener.EventTime c2 = events.c(b2);
            if (b2 == 0) {
                this.f23597b.f(c2);
            } else if (b2 == 11) {
                this.f23597b.e(c2, this.f23606k);
            } else {
                this.f23597b.d(c2);
            }
        }
    }

    private void N0(long j2) {
        int J0 = J0(this.f23596a);
        if (J0 != this.f23608m) {
            this.f23608m = J0;
            this.f23598c.reportNetworkEvent(new NetworkEvent.Builder().setNetworkType(J0).setTimeSinceCreatedMillis(j2 - this.f23599d).build());
        }
    }

    private void O0(long j2) {
        boolean z2;
        PlaybackException playbackException = this.f23609n;
        if (playbackException != null) {
            Context context = this.f23596a;
            if (this.f23617v == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            ErrorInfo G0 = G0(playbackException, context, z2);
            this.f23598c.reportPlaybackErrorEvent(new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j2 - this.f23599d).setErrorCode(G0.f23622a).setSubErrorCode(G0.f23623b).setException(playbackException).build());
            this.A = true;
            this.f23609n = null;
        }
    }

    private void P0(Player player, AnalyticsListener.Events events, long j2) {
        if (player.getPlaybackState() != 2) {
            this.f23616u = false;
        }
        if (player.k() == null) {
            this.f23618w = false;
        } else if (events.a(10)) {
            this.f23618w = true;
        }
        int X0 = X0(player);
        if (this.f23607l != X0) {
            this.f23607l = X0;
            this.A = true;
            this.f23598c.reportPlaybackStateEvent(new PlaybackStateEvent.Builder().setState(this.f23607l).setTimeSinceCreatedMillis(j2 - this.f23599d).build());
        }
    }

    private void Q0(Player player, AnalyticsListener.Events events, long j2) {
        if (events.a(2)) {
            Tracks m2 = player.m();
            boolean d2 = m2.d(2);
            boolean d3 = m2.d(1);
            boolean d4 = m2.d(3);
            if (d2 || d3 || d4) {
                if (!d2) {
                    V0(j2, (Format) null, 0);
                }
                if (!d3) {
                    R0(j2, (Format) null, 0);
                }
                if (!d4) {
                    T0(j2, (Format) null, 0);
                }
            }
        }
        if (A0(this.f23610o)) {
            PendingFormatUpdate pendingFormatUpdate = this.f23610o;
            Format format = pendingFormatUpdate.f23624a;
            if (format.f23077s != -1) {
                V0(j2, format, pendingFormatUpdate.f23625b);
                this.f23610o = null;
            }
        }
        if (A0(this.f23611p)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.f23611p;
            R0(j2, pendingFormatUpdate2.f23624a, pendingFormatUpdate2.f23625b);
            this.f23611p = null;
        }
        if (A0(this.f23612q)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.f23612q;
            T0(j2, pendingFormatUpdate3.f23624a, pendingFormatUpdate3.f23625b);
            this.f23612q = null;
        }
    }

    private void R0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f23614s, format)) {
            if (this.f23614s == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f23614s = format;
            W0(0, j2, format, i3);
        }
    }

    private void S0(Player player, AnalyticsListener.Events events) {
        DrmInitData E0;
        if (events.a(0)) {
            AnalyticsListener.EventTime c2 = events.c(0);
            if (this.f23605j != null) {
                U0(c2.f23554b, c2.f23556d);
            }
        }
        if (!(!events.a(2) || this.f23605j == null || (E0 = E0(player.m().b())) == null)) {
            PlaybackMetrics.Builder unused = ((PlaybackMetrics.Builder) Util.j(this.f23605j)).setDrmType(F0(E0));
        }
        if (events.a(1011)) {
            this.f23621z++;
        }
    }

    private void T0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f23615t, format)) {
            if (this.f23615t == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f23615t = format;
            W0(2, j2, format, i3);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private void U0(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        int f2;
        int i2;
        PlaybackMetrics.Builder builder = this.f23605j;
        if (mediaPeriodId != null && (f2 = timeline.f(mediaPeriodId.f25793a)) != -1) {
            timeline.j(f2, this.f23601f);
            timeline.r(this.f23601f.f23494d, this.f23600e);
            PlaybackMetrics.Builder unused = builder.setStreamType(K0(this.f23600e.f23513d));
            Timeline.Window window = this.f23600e;
            if (window.f23524o != -9223372036854775807L && !window.f23522m && !window.f23519j && !window.h()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(this.f23600e.f());
            }
            if (this.f23600e.h()) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(i2);
            this.A = true;
        }
    }

    private void V0(long j2, Format format, int i2) {
        int i3;
        if (!Util.c(this.f23613r, format)) {
            if (this.f23613r == null && i2 == 0) {
                i3 = 1;
            } else {
                i3 = i2;
            }
            this.f23613r = format;
            W0(1, j2, format, i3);
        }
    }

    private void W0(int i2, long j2, Format format, int i3) {
        TrackChangeEvent.Builder a2 = new TrackChangeEvent.Builder(i2).setTimeSinceCreatedMillis(j2 - this.f23599d);
        if (format != null) {
            TrackChangeEvent.Builder unused = a2.setTrackState(1);
            TrackChangeEvent.Builder unused2 = a2.setTrackChangeReason(L0(i3));
            String str = format.f23070l;
            if (str != null) {
                TrackChangeEvent.Builder unused3 = a2.setContainerMimeType(str);
            }
            String str2 = format.f23071m;
            if (str2 != null) {
                TrackChangeEvent.Builder unused4 = a2.setSampleMimeType(str2);
            }
            String str3 = format.f23068j;
            if (str3 != null) {
                TrackChangeEvent.Builder unused5 = a2.setCodecName(str3);
            }
            int i4 = format.f23067i;
            if (i4 != -1) {
                TrackChangeEvent.Builder unused6 = a2.setBitrate(i4);
            }
            int i5 = format.f23076r;
            if (i5 != -1) {
                TrackChangeEvent.Builder unused7 = a2.setWidth(i5);
            }
            int i6 = format.f23077s;
            if (i6 != -1) {
                TrackChangeEvent.Builder unused8 = a2.setHeight(i6);
            }
            int i7 = format.f23084z;
            if (i7 != -1) {
                TrackChangeEvent.Builder unused9 = a2.setChannelCount(i7);
            }
            int i8 = format.A;
            if (i8 != -1) {
                TrackChangeEvent.Builder unused10 = a2.setAudioSampleRate(i8);
            }
            String str4 = format.f23062d;
            if (str4 != null) {
                Pair<String, String> H0 = H0(str4);
                TrackChangeEvent.Builder unused11 = a2.setLanguage((String) H0.first);
                Object obj = H0.second;
                if (obj != null) {
                    TrackChangeEvent.Builder unused12 = a2.setLanguageRegion((String) obj);
                }
            }
            float f2 = format.f23078t;
            if (f2 != -1.0f) {
                TrackChangeEvent.Builder unused13 = a2.setVideoFrameRate(f2);
            }
        } else {
            TrackChangeEvent.Builder unused14 = a2.setTrackState(0);
        }
        this.A = true;
        this.f23598c.reportTrackChangeEvent(a2.build());
    }

    private int X0(Player player) {
        int playbackState = player.getPlaybackState();
        if (this.f23616u) {
            return 5;
        }
        if (this.f23618w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i2 = this.f23607l;
            if (i2 == 0 || i2 == 2) {
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
        } else if (playbackState != 1 || this.f23607l == 0) {
            return this.f23607l;
        } else {
            return 12;
        }
    }

    public /* synthetic */ void A(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        a.g0(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void B(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.l0(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void C(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.e0(this, eventTime, exc);
    }

    public /* synthetic */ void D(AnalyticsListener.EventTime eventTime, int i2) {
        a.a0(this, eventTime, i2);
    }

    public /* synthetic */ void E(AnalyticsListener.EventTime eventTime) {
        a.W(this, eventTime);
    }

    public /* synthetic */ void F(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        a.I(this, eventTime, mediaItem, i2);
    }

    public /* synthetic */ void G(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        a.c0(this, eventTime, tracks);
    }

    public /* synthetic */ void H(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        a.b0(this, eventTime, trackSelectionParameters);
    }

    public /* synthetic */ void I(AnalyticsListener.EventTime eventTime) {
        a.x(this, eventTime);
    }

    public LogSessionId I0() {
        return this.f23598c.getSessionId();
    }

    public void J(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.f23619x += decoderCounters.f23954g;
        this.f23620y += decoderCounters.f23952e;
    }

    public /* synthetic */ void K(AnalyticsListener.EventTime eventTime) {
        a.v(this, eventTime);
    }

    public void L(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        long j4;
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f23556d;
        if (mediaPeriodId != null) {
            String g2 = this.f23597b.g(eventTime.f23554b, (MediaSource.MediaPeriodId) Assertions.e(mediaPeriodId));
            Long l2 = this.f23603h.get(g2);
            Long l3 = this.f23602g.get(g2);
            HashMap<String, Long> hashMap = this.f23603h;
            long j5 = 0;
            if (l2 == null) {
                j4 = 0;
            } else {
                j4 = l2.longValue();
            }
            hashMap.put(g2, Long.valueOf(j4 + j2));
            HashMap<String, Long> hashMap2 = this.f23602g;
            if (l3 != null) {
                j5 = l3.longValue();
            }
            hashMap2.put(g2, Long.valueOf(j5 + ((long) i2)));
        }
    }

    public /* synthetic */ void M(AnalyticsListener.EventTime eventTime, int i2, boolean z2) {
        a.t(this, eventTime, i2, z2);
    }

    public /* synthetic */ void N(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        a.m0(this, eventTime, i2, i3, i4, f2);
    }

    public /* synthetic */ void O(AnalyticsListener.EventTime eventTime, int i2, Format format) {
        a.r(this, eventTime, i2, format);
    }

    public /* synthetic */ void P(AnalyticsListener.EventTime eventTime) {
        a.V(this, eventTime);
    }

    public /* synthetic */ void Q(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.G(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void R(AnalyticsListener.EventTime eventTime, int i2, String str, long j2) {
        a.q(this, eventTime, i2, str, j2);
    }

    public void S(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f23609n = playbackException;
    }

    public /* synthetic */ void T(AnalyticsListener.EventTime eventTime, int i2) {
        a.S(this, eventTime, i2);
    }

    public /* synthetic */ void U(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        a.m(this, eventTime, cueGroup);
    }

    public /* synthetic */ void V(AnalyticsListener.EventTime eventTime) {
        a.A(this, eventTime);
    }

    public /* synthetic */ void W(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        a.M(this, eventTime, playbackParameters);
    }

    public /* synthetic */ void X(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        a.k(this, eventTime, i2, j2, j3);
    }

    public /* synthetic */ void Y(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.e(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void Z(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.i0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void a(AnalyticsListener.EventTime eventTime, String str) {
        a.h0(this, eventTime, str);
    }

    public /* synthetic */ void a0(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        a.c(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void b(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        a.j0(this, eventTime, j2, i2);
    }

    public /* synthetic */ void b0(AnalyticsListener.EventTime eventTime, int i2) {
        a.U(this, eventTime, i2);
    }

    public /* synthetic */ void c(AnalyticsListener.EventTime eventTime, int i2) {
        a.y(this, eventTime, i2);
    }

    public /* synthetic */ void c0(AnalyticsListener.EventTime eventTime) {
        a.Q(this, eventTime);
    }

    public /* synthetic */ void d(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.z(this, eventTime, exc);
    }

    public void d0(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        PendingFormatUpdate pendingFormatUpdate = this.f23610o;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.f23624a;
            if (format.f23077s == -1) {
                this.f23610o = new PendingFormatUpdate(format.b().n0(videoSize.f28962b).S(videoSize.f28963c).G(), pendingFormatUpdate.f23625b, pendingFormatUpdate.f23626c);
            }
        }
    }

    public /* synthetic */ void e(AnalyticsListener.EventTime eventTime) {
        a.w(this, eventTime);
    }

    public void e0(AnalyticsListener.EventTime eventTime, String str, boolean z2) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f23556d;
        if ((mediaPeriodId == null || !mediaPeriodId.b()) && str.equals(this.f23604i)) {
            C0();
        }
        this.f23602g.remove(str);
        this.f23603h.remove(str);
    }

    public /* synthetic */ void f(AnalyticsListener.EventTime eventTime, int i2) {
        a.O(this, eventTime, i2);
    }

    public void f0(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f23556d;
        if (mediaPeriodId == null || !mediaPeriodId.b()) {
            C0();
            this.f23604i = str;
            this.f23605j = new PlaybackMetrics.Builder().setPlayerName("ExoPlayerLib").setPlayerVersion("2.18.7");
            U0(eventTime.f23554b, eventTime.f23556d);
        }
    }

    public /* synthetic */ void g(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.H(this, eventTime, z2);
    }

    public /* synthetic */ void g0(AnalyticsListener.EventTime eventTime, Format format) {
        a.g(this, eventTime, format);
    }

    public /* synthetic */ void h(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        a.J(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void h0(AnalyticsListener.EventTime eventTime) {
        a.u(this, eventTime);
    }

    public /* synthetic */ void i(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        a.P(this, eventTime, playbackException);
    }

    public /* synthetic */ void i0(AnalyticsListener.EventTime eventTime, float f2) {
        a.n0(this, eventTime, f2);
    }

    public /* synthetic */ void j(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        a.f(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void j0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.E(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void k(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        this.f23617v = mediaLoadData.f25786a;
    }

    public /* synthetic */ void k0(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.D(this, eventTime, z2);
    }

    public /* synthetic */ void l(AnalyticsListener.EventTime eventTime, int i2, DecoderCounters decoderCounters) {
        a.p(this, eventTime, i2, decoderCounters);
    }

    public /* synthetic */ void l0(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.a(this, eventTime, exc);
    }

    public /* synthetic */ void m(AnalyticsListener.EventTime eventTime, String str, long j2) {
        a.b(this, eventTime, str, j2);
    }

    public void m0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        if (eventTime.f23556d != null) {
            PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.e(mediaLoadData.f25788c), mediaLoadData.f25789d, this.f23597b.g(eventTime.f23554b, (MediaSource.MediaPeriodId) Assertions.e(eventTime.f23556d)));
            int i2 = mediaLoadData.f25787b;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.f23611p = pendingFormatUpdate;
                    return;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.f23612q = pendingFormatUpdate;
                        return;
                    }
                    return;
                }
            }
            this.f23610o = pendingFormatUpdate;
        }
    }

    public /* synthetic */ void n(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        a.K(this, eventTime, metadata);
    }

    public /* synthetic */ void n0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        a.F(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void o(Player player, AnalyticsListener.Events events) {
        if (events.d() != 0) {
            M0(events);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            S0(player, events);
            O0(elapsedRealtime);
            Q0(player, events, elapsedRealtime);
            N0(elapsedRealtime);
            P0(player, events, elapsedRealtime);
            if (events.a(1028)) {
                this.f23597b.c(events.c(1028));
            }
        }
    }

    public /* synthetic */ void o0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        a.d0(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void p(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        a.R(this, eventTime, z2, i2);
    }

    public void p0(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.f23616u = true;
        }
        this.f23606k = i2;
    }

    public /* synthetic */ void q(AnalyticsListener.EventTime eventTime, int i2) {
        a.N(this, eventTime, i2);
    }

    public /* synthetic */ void q0(AnalyticsListener.EventTime eventTime, String str) {
        a.d(this, eventTime, str);
    }

    public /* synthetic */ void r(AnalyticsListener.EventTime eventTime, Format format) {
        a.k0(this, eventTime, format);
    }

    public void r0(AnalyticsListener.EventTime eventTime, String str) {
    }

    public /* synthetic */ void s(AnalyticsListener.EventTime eventTime, long j2) {
        a.i(this, eventTime, j2);
    }

    public /* synthetic */ void s0(AnalyticsListener.EventTime eventTime, String str, long j2) {
        a.f0(this, eventTime, str, j2);
    }

    public /* synthetic */ void t(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        a.Z(this, eventTime, i2, i3);
    }

    public /* synthetic */ void t0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        a.h(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void u(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.X(this, eventTime, z2);
    }

    public /* synthetic */ void u0(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        a.l(this, eventTime, commands);
    }

    public /* synthetic */ void v(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        a.B(this, eventTime, i2, j2);
    }

    public /* synthetic */ void v0(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        a.T(this, eventTime, obj, j2);
    }

    public /* synthetic */ void w(AnalyticsListener.EventTime eventTime, Exception exc) {
        a.j(this, eventTime, exc);
    }

    public /* synthetic */ void w0(AnalyticsListener.EventTime eventTime, int i2, DecoderCounters decoderCounters) {
        a.o(this, eventTime, i2, decoderCounters);
    }

    public /* synthetic */ void x(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.Y(this, eventTime, z2);
    }

    public /* synthetic */ void x0(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        a.s(this, eventTime, deviceInfo);
    }

    public /* synthetic */ void y(AnalyticsListener.EventTime eventTime, List list) {
        a.n(this, eventTime, list);
    }

    public /* synthetic */ void y0(AnalyticsListener.EventTime eventTime, boolean z2) {
        a.C(this, eventTime, z2);
    }

    public /* synthetic */ void z(AnalyticsListener.EventTime eventTime, boolean z2, int i2) {
        a.L(this, eventTime, z2, i2);
    }

    public void z0(AnalyticsListener.EventTime eventTime, String str, String str2) {
    }
}
