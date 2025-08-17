package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.ParserException;
import androidx.media3.common.StreamKey;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.dash.manifest.UtcTimingElement;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.util.SntpClient;
import androidx.media3.extractor.text.SubtitleParser;
import com.facebook.common.time.Clock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.base.Charsets;
import com.google.common.math.LongMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource extends BaseMediaSource {
    /* access modifiers changed from: private */
    public Loader A;
    private TransferListener B;
    /* access modifiers changed from: private */
    public IOException C;
    private Handler D;
    private MediaItem.LiveConfiguration E;
    private Uri F;
    private Uri G;
    private DashManifest H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private int M;
    private long N;
    private int O;
    private MediaItem P;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5940h;

    /* renamed from: i  reason: collision with root package name */
    private final DataSource.Factory f5941i;

    /* renamed from: j  reason: collision with root package name */
    private final DashChunkSource.Factory f5942j;

    /* renamed from: k  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f5943k;

    /* renamed from: l  reason: collision with root package name */
    private final DrmSessionManager f5944l;

    /* renamed from: m  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f5945m;

    /* renamed from: n  reason: collision with root package name */
    private final BaseUrlExclusionList f5946n;

    /* renamed from: o  reason: collision with root package name */
    private final long f5947o;

    /* renamed from: p  reason: collision with root package name */
    private final long f5948p;

    /* renamed from: q  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f5949q;

    /* renamed from: r  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends DashManifest> f5950r;

    /* renamed from: s  reason: collision with root package name */
    private final ManifestCallback f5951s;

    /* renamed from: t  reason: collision with root package name */
    private final Object f5952t;

    /* renamed from: u  reason: collision with root package name */
    private final SparseArray<DashMediaPeriod> f5953u;

    /* renamed from: v  reason: collision with root package name */
    private final Runnable f5954v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f5955w;

    /* renamed from: x  reason: collision with root package name */
    private final PlayerEmsgHandler.PlayerEmsgCallback f5956x;

    /* renamed from: y  reason: collision with root package name */
    private final LoaderErrorThrower f5957y;

    /* renamed from: z  reason: collision with root package name */
    private DataSource f5958z;

    private static final class DashTimeline extends Timeline {

        /* renamed from: e  reason: collision with root package name */
        private final long f5960e;

        /* renamed from: f  reason: collision with root package name */
        private final long f5961f;

        /* renamed from: g  reason: collision with root package name */
        private final long f5962g;

        /* renamed from: h  reason: collision with root package name */
        private final int f5963h;

        /* renamed from: i  reason: collision with root package name */
        private final long f5964i;

        /* renamed from: j  reason: collision with root package name */
        private final long f5965j;

        /* renamed from: k  reason: collision with root package name */
        private final long f5966k;

        /* renamed from: l  reason: collision with root package name */
        private final DashManifest f5967l;

        /* renamed from: m  reason: collision with root package name */
        private final MediaItem f5968m;

        /* renamed from: n  reason: collision with root package name */
        private final MediaItem.LiveConfiguration f5969n;

        public DashTimeline(long j2, long j3, long j4, int i2, long j5, long j6, long j7, DashManifest dashManifest, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
            boolean z2;
            DashManifest dashManifest2 = dashManifest;
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            boolean z3 = dashManifest2.f6052d;
            boolean z4 = true;
            if (liveConfiguration2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z3 != z2 ? false : z4);
            this.f5960e = j2;
            this.f5961f = j3;
            this.f5962g = j4;
            this.f5963h = i2;
            this.f5964i = j5;
            this.f5965j = j6;
            this.f5966k = j7;
            this.f5967l = dashManifest2;
            this.f5968m = mediaItem;
            this.f5969n = liveConfiguration2;
        }

        private long s(long j2) {
            DashSegmentIndex l2;
            long j3 = this.f5966k;
            if (!t(this.f5967l)) {
                return j3;
            }
            if (j2 > 0) {
                j3 += j2;
                if (j3 > this.f5965j) {
                    return -9223372036854775807L;
                }
            }
            long j4 = this.f5964i + j3;
            long g2 = this.f5967l.g(0);
            int i2 = 0;
            while (i2 < this.f5967l.e() - 1 && j4 >= g2) {
                j4 -= g2;
                i2++;
                g2 = this.f5967l.g(i2);
            }
            Period d2 = this.f5967l.d(i2);
            int a2 = d2.a(2);
            if (a2 == -1 || (l2 = d2.f6086c.get(a2).f6041c.get(0).l()) == null || l2.h(g2) == 0) {
                return j3;
            }
            return (j3 + l2.b(l2.g(j4, g2))) - j4;
        }

        private static boolean t(DashManifest dashManifest) {
            return dashManifest.f6052d && dashManifest.f6053e != -9223372036854775807L && dashManifest.f6050b == -9223372036854775807L;
        }

        public int b(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f5963h) >= 0 && intValue < i()) {
                return intValue;
            }
            return -1;
        }

        public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
            String str;
            Assertions.c(i2, 0, i());
            Integer num = null;
            if (z2) {
                str = this.f5967l.d(i2).f6084a;
            } else {
                str = null;
            }
            if (z2) {
                num = Integer.valueOf(this.f5963h + i2);
            }
            return period.s(str, num, 0, this.f5967l.g(i2), Util.P0(this.f5967l.d(i2).f6085b - this.f5967l.d(0).f6085b) - this.f5964i);
        }

        public int i() {
            return this.f5967l.e();
        }

        public Object m(int i2) {
            Assertions.c(i2, 0, i());
            return Integer.valueOf(this.f5963h + i2);
        }

        public Timeline.Window o(int i2, Timeline.Window window, long j2) {
            Assertions.c(i2, 0, 1);
            long s2 = s(j2);
            Object obj = Timeline.Window.f4362q;
            MediaItem mediaItem = this.f5968m;
            DashManifest dashManifest = this.f5967l;
            return window.g(obj, mediaItem, dashManifest, this.f5960e, this.f5961f, this.f5962g, true, t(dashManifest), this.f5969n, s2, this.f5965j, 0, i() - 1, this.f5964i);
        }

        public int p() {
            return 1;
        }
    }

    private final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        public void a(long j2) {
            DashMediaSource.this.Q(j2);
        }

        public void b() {
            DashMediaSource.this.R();
        }
    }

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DashChunkSource.Factory f5971a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f5972b;

        /* renamed from: c  reason: collision with root package name */
        private CmcdConfiguration.Factory f5973c;

        /* renamed from: d  reason: collision with root package name */
        private DrmSessionManagerProvider f5974d;

        /* renamed from: e  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f5975e;

        /* renamed from: f  reason: collision with root package name */
        private LoadErrorHandlingPolicy f5976f;

        /* renamed from: g  reason: collision with root package name */
        private long f5977g;

        /* renamed from: h  reason: collision with root package name */
        private long f5978h;

        /* renamed from: i  reason: collision with root package name */
        private ParsingLoadable.Parser<? extends DashManifest> f5979i;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        /* renamed from: g */
        public DashMediaSource c(MediaItem mediaItem) {
            FilteringManifestParser filteringManifestParser;
            MediaItem mediaItem2 = mediaItem;
            Assertions.f(mediaItem2.f4079b);
            ParsingLoadable.Parser parser = this.f5979i;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            List<StreamKey> list = mediaItem2.f4079b.f4174d;
            if (!list.isEmpty()) {
                filteringManifestParser = new FilteringManifestParser(parser, list);
            } else {
                filteringManifestParser = parser;
            }
            CmcdConfiguration.Factory factory = this.f5973c;
            if (factory != null) {
                factory.a(mediaItem2);
            }
            return new DashMediaSource(mediaItem, (DashManifest) null, this.f5972b, filteringManifestParser, this.f5971a, this.f5975e, (CmcdConfiguration) null, this.f5974d.a(mediaItem2), this.f5976f, this.f5977g, this.f5978h);
        }

        @Deprecated
        /* renamed from: h */
        public Factory b(boolean z2) {
            this.f5971a.b(z2);
            return this;
        }

        /* renamed from: i */
        public Factory f(CmcdConfiguration.Factory factory) {
            this.f5973c = (CmcdConfiguration.Factory) Assertions.f(factory);
            return this;
        }

        /* renamed from: j */
        public Factory d(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f5974d = (DrmSessionManagerProvider) Assertions.g(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: k */
        public Factory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f5976f = (LoadErrorHandlingPolicy) Assertions.g(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: l */
        public Factory a(SubtitleParser.Factory factory) {
            this.f5971a.a((SubtitleParser.Factory) Assertions.f(factory));
            return this;
        }

        public Factory(DashChunkSource.Factory factory, DataSource.Factory factory2) {
            this.f5971a = (DashChunkSource.Factory) Assertions.f(factory);
            this.f5972b = factory2;
            this.f5974d = new DefaultDrmSessionManagerProvider();
            this.f5976f = new DefaultLoadErrorHandlingPolicy();
            this.f5977g = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
            this.f5978h = 5000000;
            this.f5975e = new DefaultCompositeSequenceableLoaderFactory();
            b(true);
        }
    }

    static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f5980a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        Iso8601Parser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            long j2;
            long j3;
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)).readLine();
            try {
                Matcher matcher = f5980a.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        if ("+".equals(matcher.group(4))) {
                            j2 = 1;
                        } else {
                            j2 = -1;
                        }
                        long parseLong = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        if (TextUtils.isEmpty(group2)) {
                            j3 = 0;
                        } else {
                            j3 = Long.parseLong(group2);
                        }
                        time -= j2 * ((((parseLong * 60) + j3) * 60) * 1000);
                    }
                    return Long.valueOf(time);
                }
                throw ParserException.c("Couldn't parse timestamp: " + readLine, (Throwable) null);
            } catch (ParseException e2) {
                throw ParserException.c((String) null, e2);
            }
        }
    }

    private final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        /* renamed from: a */
        public void u(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, boolean z2) {
            DashMediaSource.this.S(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void t(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.T(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction p(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.U(parsingLoadable, j2, j3, iOException, i2);
        }
    }

    final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        private void b() throws IOException {
            if (DashMediaSource.this.C != null) {
                throw DashMediaSource.this.C;
            }
        }

        public void a() throws IOException {
            DashMediaSource.this.A.a();
            b();
        }
    }

    private final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        /* renamed from: a */
        public void u(ParsingLoadable<Long> parsingLoadable, long j2, long j3, boolean z2) {
            DashMediaSource.this.S(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void t(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.V(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction p(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.W(parsingLoadable, j2, j3, iOException);
        }
    }

    private static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.W0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.dash");
    }

    private static long I(Period period, long j2, long j3) {
        Period period2 = period;
        long j4 = j2;
        long j5 = j3;
        long P0 = Util.P0(period2.f6085b);
        boolean M2 = M(period);
        long j6 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < period2.f6086c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f6086c.get(i2);
            List<Representation> list = adaptationSet.f6041c;
            int i3 = adaptationSet.f6040b;
            boolean z2 = true;
            if (i3 == 1 || i3 == 2) {
                z2 = false;
            }
            if ((!M2 || !z2) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null) {
                    return P0 + j4;
                }
                long k2 = l2.k(j4, j5);
                if (k2 == 0) {
                    return P0;
                }
                long d2 = (l2.d(j4, j5) + k2) - 1;
                j6 = Math.min(j6, l2.c(d2, j4) + l2.b(d2) + P0);
            }
        }
        return j6;
    }

    private static long J(Period period, long j2, long j3) {
        Period period2 = period;
        long j4 = j2;
        long j5 = j3;
        long P0 = Util.P0(period2.f6085b);
        boolean M2 = M(period);
        long j6 = P0;
        for (int i2 = 0; i2 < period2.f6086c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f6086c.get(i2);
            List<Representation> list = adaptationSet.f6041c;
            int i3 = adaptationSet.f6040b;
            boolean z2 = true;
            if (i3 == 1 || i3 == 2) {
                z2 = false;
            }
            if ((!M2 || !z2) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null || l2.k(j4, j5) == 0) {
                    return P0;
                }
                j6 = Math.max(j6, l2.b(l2.d(j4, j5)) + P0);
            }
        }
        return j6;
    }

    private static long K(DashManifest dashManifest, long j2) {
        DashSegmentIndex l2;
        DashManifest dashManifest2 = dashManifest;
        int e2 = dashManifest.e() - 1;
        Period d2 = dashManifest2.d(e2);
        long P0 = Util.P0(d2.f6085b);
        long g2 = dashManifest2.g(e2);
        long P02 = Util.P0(j2);
        long P03 = Util.P0(dashManifest2.f6049a);
        long P04 = Util.P0(5000);
        for (int i2 = 0; i2 < d2.f6086c.size(); i2++) {
            List<Representation> list = d2.f6086c.get(i2).f6041c;
            if (!list.isEmpty() && (l2 = list.get(0).l()) != null) {
                long e3 = ((P03 + P0) + l2.e(g2, P02)) - P02;
                if (e3 < P04 - 100000 || (e3 > P04 && e3 < P04 + 100000)) {
                    P04 = e3;
                }
            }
        }
        return LongMath.b(P04, 1000, RoundingMode.CEILING);
    }

    private long L() {
        return (long) Math.min((this.M - 1) * 1000, 5000);
    }

    private static boolean M(Period period) {
        for (int i2 = 0; i2 < period.f6086c.size(); i2++) {
            int i3 = period.f6086c.get(i2).f6040b;
            if (i3 == 1 || i3 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean N(Period period) {
        for (int i2 = 0; i2 < period.f6086c.size(); i2++) {
            DashSegmentIndex l2 = period.f6086c.get(i2).f6041c.get(0).l();
            if (l2 == null || l2.i()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O() {
        Z(false);
    }

    private void P() {
        SntpClient.j(this.A, new SntpClient.InitializationCallback() {
            public void a(IOException iOException) {
                DashMediaSource.this.X(iOException);
            }

            public void b() {
                DashMediaSource.this.Y(SntpClient.h());
            }
        });
    }

    /* access modifiers changed from: private */
    public void X(IOException iOException) {
        Log.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.L = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        Z(true);
    }

    /* access modifiers changed from: private */
    public void Y(long j2) {
        this.L = j2;
        Z(true);
    }

    private void Z(boolean z2) {
        boolean z3;
        long j2;
        long j3;
        Period period;
        MediaItem.LiveConfiguration liveConfiguration;
        boolean z4;
        for (int i2 = 0; i2 < this.f5953u.size(); i2++) {
            int keyAt = this.f5953u.keyAt(i2);
            if (keyAt >= this.O) {
                this.f5953u.valueAt(i2).P(this.H, keyAt - this.O);
            }
        }
        Period d2 = this.H.d(0);
        int e2 = this.H.e() - 1;
        Period d3 = this.H.d(e2);
        long g2 = this.H.g(e2);
        long P0 = Util.P0(Util.f0(this.L));
        long J2 = J(d2, this.H.g(0), P0);
        long I2 = I(d3, g2, P0);
        if (!this.H.f6052d || N(d3)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            long j4 = this.H.f6054f;
            if (j4 != -9223372036854775807L) {
                J2 = Math.max(J2, I2 - Util.P0(j4));
            }
        }
        long j5 = I2 - J2;
        DashManifest dashManifest = this.H;
        Period period2 = d2;
        if (dashManifest.f6052d) {
            if (dashManifest.f6049a != -9223372036854775807L) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.h(z4);
            long P02 = (P0 - Util.P0(this.H.f6049a)) - J2;
            g0(P02, j5);
            long t1 = this.H.f6049a + Util.t1(J2);
            long P03 = P02 - Util.P0(this.E.f4153a);
            long min = Math.min(this.f5948p, j5 / 2);
            j3 = t1;
            if (P03 < min) {
                j2 = min;
            } else {
                j2 = P03;
            }
            period = period2;
        } else {
            period = period2;
            j3 = -9223372036854775807L;
            j2 = 0;
        }
        long P04 = J2 - Util.P0(period.f6085b);
        DashManifest dashManifest2 = this.H;
        long j6 = dashManifest2.f6049a;
        long j7 = this.L;
        int i3 = this.O;
        MediaItem a2 = a();
        if (this.H.f6052d) {
            liveConfiguration = this.E;
        } else {
            liveConfiguration = null;
        }
        A(new DashTimeline(j6, j3, j7, i3, P04, j5, j2, dashManifest2, a2, liveConfiguration));
        if (!this.f5940h) {
            this.D.removeCallbacks(this.f5955w);
            if (z3) {
                this.D.postDelayed(this.f5955w, K(this.H, Util.f0(this.L)));
            }
            if (this.I) {
                f0();
            } else if (z2) {
                DashManifest dashManifest3 = this.H;
                if (dashManifest3.f6052d) {
                    long j8 = dashManifest3.f6053e;
                    if (j8 != -9223372036854775807L) {
                        if (j8 == 0) {
                            j8 = 5000;
                        }
                        d0(Math.max(0, (this.J + j8) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    private void a0(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.f6138a;
        if (Util.c(str, "urn:mpeg:dash:utc:direct:2014") || Util.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            b0(utcTimingElement);
        } else if (Util.c(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            c0(utcTimingElement, new Iso8601Parser());
        } else if (Util.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            c0(utcTimingElement, new XsDateTimeParser());
        } else if (Util.c(str, "urn:mpeg:dash:utc:ntp:2014") || Util.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            P();
        } else {
            X(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void b0(UtcTimingElement utcTimingElement) {
        try {
            Y(Util.W0(utcTimingElement.f6139b) - this.K);
        } catch (ParserException e2) {
            X(e2);
        }
    }

    private void c0(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        e0(new ParsingLoadable(this.f5958z, Uri.parse(utcTimingElement.f6139b), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void d0(long j2) {
        this.D.postDelayed(this.f5954v, j2);
    }

    private <T> void e0(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        this.f5949q.y(new LoadEventInfo(parsingLoadable.f7552a, parsingLoadable.f7553b, this.A.n(parsingLoadable, callback, i2)), parsingLoadable.f7554c);
    }

    /* access modifiers changed from: private */
    public void f0() {
        Uri uri;
        this.D.removeCallbacks(this.f5954v);
        if (!this.A.i()) {
            if (this.A.j()) {
                this.I = true;
                return;
            }
            synchronized (this.f5952t) {
                uri = this.F;
            }
            this.I = false;
            e0(new ParsingLoadable(this.f5958z, uri, 4, this.f5950r), this.f5951s, this.f5945m.a(4));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g0(long r19, long r21) {
        /*
            r18 = this;
            r0 = r18
            androidx.media3.common.MediaItem r1 = r18.a()
            androidx.media3.common.MediaItem$LiveConfiguration r1 = r1.f4081d
            long r6 = androidx.media3.common.util.Util.t1(r19)
            long r2 = r1.f4155c
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x001d
            long r2 = java.lang.Math.min(r6, r2)
        L_0x001b:
            r10 = r2
            goto L_0x002f
        L_0x001d:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r2 = r2.f6058j
            if (r2 == 0) goto L_0x002e
            long r2 = r2.f6131c
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x002e
            long r2 = java.lang.Math.min(r6, r2)
            goto L_0x001b
        L_0x002e:
            r10 = r6
        L_0x002f:
            long r2 = r19 - r21
            long r2 = androidx.media3.common.util.Util.t1(r2)
            r4 = 0
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x0040
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0040
            r2 = r4
        L_0x0040:
            androidx.media3.exoplayer.dash.manifest.DashManifest r4 = r0.H
            long r4 = r4.f6051c
            int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x004d
            long r2 = r2 + r4
            long r2 = java.lang.Math.min(r2, r6)
        L_0x004d:
            r4 = r2
            long r2 = r1.f4154b
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0059
            long r4 = androidx.media3.common.util.Util.q(r2, r4, r6)
            goto L_0x0069
        L_0x0059:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r2 = r2.f6058j
            if (r2 == 0) goto L_0x0069
            long r2 = r2.f6130b
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0069
            long r4 = androidx.media3.common.util.Util.q(r2, r4, r6)
        L_0x0069:
            int r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x006e
            r10 = r4
        L_0x006e:
            androidx.media3.common.MediaItem$LiveConfiguration r2 = r0.E
            long r2 = r2.f4153a
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0077
            goto L_0x008e
        L_0x0077:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r3 = r2.f6058j
            if (r3 == 0) goto L_0x0085
            long r6 = r3.f6129a
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x0085
            r2 = r6
            goto L_0x008e
        L_0x0085:
            long r2 = r2.f6055g
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            long r2 = r0.f5947o
        L_0x008e:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0093
            r2 = r4
        L_0x0093:
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00ae
            long r2 = r0.f5948p
            r6 = 2
            long r6 = r21 / r6
            long r2 = java.lang.Math.min(r2, r6)
            long r2 = r19 - r2
            long r12 = androidx.media3.common.util.Util.t1(r2)
            r14 = r4
            r16 = r10
            long r2 = androidx.media3.common.util.Util.q(r12, r14, r16)
        L_0x00ae:
            float r6 = r1.f4156d
            r7 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r12 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00b8
            goto L_0x00c4
        L_0x00b8:
            androidx.media3.exoplayer.dash.manifest.DashManifest r6 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r6 = r6.f6058j
            if (r6 == 0) goto L_0x00c1
            float r6 = r6.f6132d
            goto L_0x00c4
        L_0x00c1:
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00c4:
            float r1 = r1.f4157e
            int r12 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00cb
            goto L_0x00d7
        L_0x00cb:
            androidx.media3.exoplayer.dash.manifest.DashManifest r1 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r1 = r1.f6058j
            if (r1 == 0) goto L_0x00d4
            float r1 = r1.f6133e
            goto L_0x00d7
        L_0x00d4:
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00d7:
            int r12 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x00ef
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x00ef
            androidx.media3.exoplayer.dash.manifest.DashManifest r7 = r0.H
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r7 = r7.f6058j
            if (r7 == 0) goto L_0x00eb
            long r12 = r7.f6129a
            int r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x00ef
        L_0x00eb:
            r6 = 1065353216(0x3f800000, float:1.0)
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x00ef:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = new androidx.media3.common.MediaItem$LiveConfiguration$Builder
            r7.<init>()
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r7.k(r2)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.i(r4)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.g(r10)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.j(r6)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r1 = r2.h(r1)
            androidx.media3.common.MediaItem$LiveConfiguration r1 = r1.f()
            r0.E = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.g0(long, long):void");
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.I = false;
        this.f5958z = null;
        Loader loader = this.A;
        if (loader != null) {
            loader.l();
            this.A = null;
        }
        this.J = 0;
        this.K = 0;
        this.F = this.G;
        this.C = null;
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.D = null;
        }
        this.L = -9223372036854775807L;
        this.M = 0;
        this.N = -9223372036854775807L;
        this.f5953u.clear();
        this.f5946n.i();
        this.f5944l.release();
    }

    /* access modifiers changed from: package-private */
    public void Q(long j2) {
        long j3 = this.N;
        if (j3 == -9223372036854775807L || j3 < j2) {
            this.N = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        this.D.removeCallbacks(this.f5955w);
        f0();
    }

    /* access modifiers changed from: package-private */
    public void S(ParsingLoadable<?> parsingLoadable, long j2, long j3) {
        ParsingLoadable<?> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f5945m.b(parsingLoadable2.f7552a);
        this.f5949q.p(loadEventInfo, parsingLoadable2.f7554c);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T(androidx.media3.exoplayer.upstream.ParsingLoadable<androidx.media3.exoplayer.dash.manifest.DashManifest> r19, long r20, long r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r14 = r20
            androidx.media3.exoplayer.source.LoadEventInfo r12 = new androidx.media3.exoplayer.source.LoadEventInfo
            long r3 = r0.f7552a
            androidx.media3.datasource.DataSpec r5 = r0.f7553b
            android.net.Uri r6 = r19.f()
            java.util.Map r7 = r19.d()
            long r16 = r19.c()
            r2 = r12
            r8 = r20
            r10 = r22
            r14 = r12
            r12 = r16
            r2.<init>(r3, r5, r6, r7, r8, r10, r12)
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r2 = r1.f5945m
            long r3 = r0.f7552a
            r2.b(r3)
            androidx.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher r2 = r1.f5949q
            int r3 = r0.f7554c
            r2.s(r14, r3)
            java.lang.Object r2 = r19.e()
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = (androidx.media3.exoplayer.dash.manifest.DashManifest) r2
            androidx.media3.exoplayer.dash.manifest.DashManifest r3 = r1.H
            r4 = 0
            if (r3 != 0) goto L_0x003e
            r3 = 0
            goto L_0x0042
        L_0x003e:
            int r3 = r3.e()
        L_0x0042:
            androidx.media3.exoplayer.dash.manifest.Period r5 = r2.d(r4)
            long r5 = r5.f6085b
            r7 = 0
        L_0x0049:
            if (r7 >= r3) goto L_0x005a
            androidx.media3.exoplayer.dash.manifest.DashManifest r8 = r1.H
            androidx.media3.exoplayer.dash.manifest.Period r8 = r8.d(r7)
            long r8 = r8.f6085b
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x005a
            int r7 = r7 + 1
            goto L_0x0049
        L_0x005a:
            boolean r5 = r2.f6052d
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r5 == 0) goto L_0x00cc
            int r3 = r3 - r7
            int r5 = r2.e()
            if (r3 <= r5) goto L_0x0074
            java.lang.String r3 = "DashMediaSource"
            java.lang.String r5 = "Loaded out of sync manifest"
            androidx.media3.common.util.Log.h(r3, r5)
        L_0x0072:
            r3 = 1
            goto L_0x00a8
        L_0x0074:
            long r10 = r1.N
            int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00a7
            long r12 = r2.f6056h
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r14
            int r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x00a7
            java.lang.String r3 = "DashMediaSource"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r10 = "Loaded stale dynamic manifest: "
            r5.append(r10)
            long r10 = r2.f6056h
            r5.append(r10)
            java.lang.String r10 = ", "
            r5.append(r10)
            long r10 = r1.N
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            androidx.media3.common.util.Log.h(r3, r5)
            goto L_0x0072
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            if (r3 == 0) goto L_0x00ca
            int r2 = r1.M
            int r3 = r2 + 1
            r1.M = r3
            androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r3 = r1.f5945m
            int r0 = r0.f7554c
            int r0 = r3.a(r0)
            if (r2 >= r0) goto L_0x00c2
            long r2 = r18.L()
            r1.d0(r2)
            goto L_0x00c9
        L_0x00c2:
            androidx.media3.exoplayer.dash.DashManifestStaleException r0 = new androidx.media3.exoplayer.dash.DashManifestStaleException
            r0.<init>()
            r1.C = r0
        L_0x00c9:
            return
        L_0x00ca:
            r1.M = r4
        L_0x00cc:
            r1.H = r2
            boolean r3 = r1.I
            boolean r2 = r2.f6052d
            r2 = r2 & r3
            r1.I = r2
            r2 = r20
            long r10 = r2 - r22
            r1.J = r10
            r1.K = r2
            int r2 = r1.O
            int r2 = r2 + r7
            r1.O = r2
            java.lang.Object r2 = r1.f5952t
            monitor-enter(r2)
            androidx.media3.datasource.DataSpec r3 = r0.f7553b     // Catch:{ all -> 0x011a }
            android.net.Uri r3 = r3.f4823a     // Catch:{ all -> 0x011a }
            android.net.Uri r5 = r1.F     // Catch:{ all -> 0x011a }
            if (r3 != r5) goto L_0x00ee
            r4 = 1
        L_0x00ee:
            if (r4 == 0) goto L_0x00fd
            androidx.media3.exoplayer.dash.manifest.DashManifest r3 = r1.H     // Catch:{ all -> 0x011a }
            android.net.Uri r3 = r3.f6059k     // Catch:{ all -> 0x011a }
            if (r3 == 0) goto L_0x00f7
            goto L_0x00fb
        L_0x00f7:
            android.net.Uri r3 = r19.f()     // Catch:{ all -> 0x011a }
        L_0x00fb:
            r1.F = r3     // Catch:{ all -> 0x011a }
        L_0x00fd:
            monitor-exit(r2)     // Catch:{ all -> 0x011a }
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r1.H
            boolean r2 = r0.f6052d
            if (r2 == 0) goto L_0x0116
            long r2 = r1.L
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0116
            androidx.media3.exoplayer.dash.manifest.UtcTimingElement r0 = r0.f6057i
            if (r0 == 0) goto L_0x0112
            r1.a0(r0)
            goto L_0x0119
        L_0x0112:
            r18.P()
            goto L_0x0119
        L_0x0116:
            r1.Z(r6)
        L_0x0119:
            return
        L_0x011a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.T(androidx.media3.exoplayer.upstream.ParsingLoadable, long, long):void");
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction U(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        long c2 = this.f5945m.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f7554c), iOException2, i2));
        if (c2 == -9223372036854775807L) {
            loadErrorAction = Loader.f7535g;
        } else {
            loadErrorAction = Loader.h(false, c2);
        }
        boolean z2 = !loadErrorAction.c();
        this.f5949q.w(loadEventInfo, parsingLoadable2.f7554c, iOException2, z2);
        if (z2) {
            this.f5945m.b(parsingLoadable2.f7552a);
        }
        return loadErrorAction;
    }

    /* access modifiers changed from: package-private */
    public void V(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f5945m.b(parsingLoadable2.f7552a);
        this.f5949q.s(loadEventInfo, parsingLoadable2.f7554c);
        Y(parsingLoadable.e().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction W(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f5949q;
        LoadEventInfo loadEventInfo = r4;
        LoadEventInfo loadEventInfo2 = new LoadEventInfo(parsingLoadable2.f7552a, parsingLoadable2.f7553b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        eventDispatcher.w(loadEventInfo, parsingLoadable2.f7554c, iOException2, true);
        this.f5945m.b(parsingLoadable2.f7552a);
        X(iOException2);
        return Loader.f7534f;
    }

    public synchronized MediaItem a() {
        return this.P;
    }

    public void c() throws IOException {
        this.f5957y.a();
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int intValue = ((Integer) mediaPeriodId.f6971a).intValue() - this.O;
        int i2 = intValue;
        MediaSourceEventListener.EventDispatcher u2 = u(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher s2 = s(mediaPeriodId);
        DashMediaPeriod dashMediaPeriod = r1;
        DashMediaPeriod dashMediaPeriod2 = new DashMediaPeriod(intValue + this.O, this.H, this.f5946n, i2, this.f5942j, this.B, (CmcdConfiguration) null, this.f5944l, s2, this.f5945m, u2, this.L, this.f5957y, allocator, this.f5943k, this.f5956x, x());
        DashMediaPeriod dashMediaPeriod3 = dashMediaPeriod;
        this.f5953u.put(dashMediaPeriod3.f5908b, dashMediaPeriod3);
        return dashMediaPeriod3;
    }

    public void l(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.L();
        this.f5953u.remove(dashMediaPeriod.f5908b);
    }

    public synchronized void o(MediaItem mediaItem) {
        this.P = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        this.B = transferListener;
        this.f5944l.a(Looper.myLooper(), x());
        this.f5944l.prepare();
        if (this.f5940h) {
            Z(false);
            return;
        }
        this.f5958z = this.f5941i.a();
        this.A = new Loader("DashMediaSource");
        this.D = Util.A();
        f0();
    }

    private DashMediaSource(MediaItem mediaItem, DashManifest dashManifest, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2, long j3) {
        this.P = mediaItem;
        this.E = mediaItem.f4081d;
        this.F = ((MediaItem.LocalConfiguration) Assertions.f(mediaItem.f4079b)).f4171a;
        this.G = mediaItem.f4079b.f4171a;
        this.H = dashManifest;
        this.f5941i = factory;
        this.f5950r = parser;
        this.f5942j = factory2;
        this.f5944l = drmSessionManager;
        this.f5945m = loadErrorHandlingPolicy;
        this.f5947o = j2;
        this.f5948p = j3;
        this.f5943k = compositeSequenceableLoaderFactory;
        this.f5946n = new BaseUrlExclusionList();
        boolean z2 = dashManifest != null;
        this.f5940h = z2;
        this.f5949q = u((MediaSource.MediaPeriodId) null);
        this.f5952t = new Object();
        this.f5953u = new SparseArray<>();
        this.f5956x = new DefaultPlayerEmsgCallback();
        this.N = -9223372036854775807L;
        this.L = -9223372036854775807L;
        if (z2) {
            Assertions.h(true ^ dashManifest.f6052d);
            this.f5951s = null;
            this.f5954v = null;
            this.f5955w = null;
            this.f5957y = new LoaderErrorThrower.Placeholder();
            return;
        }
        this.f5951s = new ManifestCallback();
        this.f5957y = new ManifestLoadErrorThrower();
        this.f5954v = new c(this);
        this.f5955w = new d(this);
    }
}
