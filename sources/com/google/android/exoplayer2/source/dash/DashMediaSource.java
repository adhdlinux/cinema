package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
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
    private DataSource A;
    /* access modifiers changed from: private */
    public Loader B;
    private TransferListener C;
    /* access modifiers changed from: private */
    public IOException D;
    private Handler E;
    private MediaItem.LiveConfiguration F;
    private Uri G;
    private Uri H;
    private DashManifest I;
    private boolean J;
    private long K;
    private long L;
    private long M;
    private int N;
    private long O;
    private int P;

    /* renamed from: i  reason: collision with root package name */
    private final MediaItem f26173i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f26174j;

    /* renamed from: k  reason: collision with root package name */
    private final DataSource.Factory f26175k;

    /* renamed from: l  reason: collision with root package name */
    private final DashChunkSource.Factory f26176l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f26177m;

    /* renamed from: n  reason: collision with root package name */
    private final DrmSessionManager f26178n;

    /* renamed from: o  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26179o;

    /* renamed from: p  reason: collision with root package name */
    private final BaseUrlExclusionList f26180p;

    /* renamed from: q  reason: collision with root package name */
    private final long f26181q;

    /* renamed from: r  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f26182r;

    /* renamed from: s  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends DashManifest> f26183s;

    /* renamed from: t  reason: collision with root package name */
    private final ManifestCallback f26184t;

    /* renamed from: u  reason: collision with root package name */
    private final Object f26185u;

    /* renamed from: v  reason: collision with root package name */
    private final SparseArray<DashMediaPeriod> f26186v;

    /* renamed from: w  reason: collision with root package name */
    private final Runnable f26187w;

    /* renamed from: x  reason: collision with root package name */
    private final Runnable f26188x;

    /* renamed from: y  reason: collision with root package name */
    private final PlayerEmsgHandler.PlayerEmsgCallback f26189y;

    /* renamed from: z  reason: collision with root package name */
    private final LoaderErrorThrower f26190z;

    private static final class DashTimeline extends Timeline {

        /* renamed from: g  reason: collision with root package name */
        private final long f26192g;

        /* renamed from: h  reason: collision with root package name */
        private final long f26193h;

        /* renamed from: i  reason: collision with root package name */
        private final long f26194i;

        /* renamed from: j  reason: collision with root package name */
        private final int f26195j;

        /* renamed from: k  reason: collision with root package name */
        private final long f26196k;

        /* renamed from: l  reason: collision with root package name */
        private final long f26197l;

        /* renamed from: m  reason: collision with root package name */
        private final long f26198m;

        /* renamed from: n  reason: collision with root package name */
        private final DashManifest f26199n;

        /* renamed from: o  reason: collision with root package name */
        private final MediaItem f26200o;

        /* renamed from: p  reason: collision with root package name */
        private final MediaItem.LiveConfiguration f26201p;

        public DashTimeline(long j2, long j3, long j4, int i2, long j5, long j6, long j7, DashManifest dashManifest, MediaItem mediaItem, MediaItem.LiveConfiguration liveConfiguration) {
            boolean z2;
            DashManifest dashManifest2 = dashManifest;
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            boolean z3 = dashManifest2.f26281d;
            boolean z4 = true;
            if (liveConfiguration2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z3 != z2 ? false : z4);
            this.f26192g = j2;
            this.f26193h = j3;
            this.f26194i = j4;
            this.f26195j = i2;
            this.f26196k = j5;
            this.f26197l = j6;
            this.f26198m = j7;
            this.f26199n = dashManifest2;
            this.f26200o = mediaItem;
            this.f26201p = liveConfiguration2;
        }

        private long w(long j2) {
            DashSegmentIndex l2;
            long j3 = this.f26198m;
            if (!x(this.f26199n)) {
                return j3;
            }
            if (j2 > 0) {
                j3 += j2;
                if (j3 > this.f26197l) {
                    return -9223372036854775807L;
                }
            }
            long j4 = this.f26196k + j3;
            long g2 = this.f26199n.g(0);
            int i2 = 0;
            while (i2 < this.f26199n.e() - 1 && j4 >= g2) {
                j4 -= g2;
                i2++;
                g2 = this.f26199n.g(i2);
            }
            Period d2 = this.f26199n.d(i2);
            int a2 = d2.a(2);
            if (a2 == -1 || (l2 = d2.f26315c.get(a2).f26270c.get(0).l()) == null || l2.h(g2) == 0) {
                return j3;
            }
            return (j3 + l2.b(l2.g(j4, g2))) - j4;
        }

        private static boolean x(DashManifest dashManifest) {
            return dashManifest.f26281d && dashManifest.f26282e != -9223372036854775807L && dashManifest.f26279b == -9223372036854775807L;
        }

        public int f(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f26195j) >= 0 && intValue < m()) {
                return intValue;
            }
            return -1;
        }

        public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
            String str;
            Assertions.c(i2, 0, m());
            Integer num = null;
            if (z2) {
                str = this.f26199n.d(i2).f26313a;
            } else {
                str = null;
            }
            if (z2) {
                num = Integer.valueOf(this.f26195j + i2);
            }
            return period.u(str, num, 0, this.f26199n.g(i2), Util.F0(this.f26199n.d(i2).f26314b - this.f26199n.d(0).f26314b) - this.f26196k);
        }

        public int m() {
            return this.f26199n.e();
        }

        public Object q(int i2) {
            Assertions.c(i2, 0, m());
            return Integer.valueOf(this.f26195j + i2);
        }

        public Timeline.Window s(int i2, Timeline.Window window, long j2) {
            Assertions.c(i2, 0, 1);
            long w2 = w(j2);
            Object obj = Timeline.Window.f23503s;
            MediaItem mediaItem = this.f26200o;
            DashManifest dashManifest = this.f26199n;
            return window.i(obj, mediaItem, dashManifest, this.f26192g, this.f26193h, this.f26194i, true, x(dashManifest), this.f26201p, w2, this.f26197l, 0, m() - 1, this.f26196k);
        }

        public int t() {
            return 1;
        }
    }

    private final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        public void a(long j2) {
            DashMediaSource.this.T(j2);
        }

        public void b() {
            DashMediaSource.this.U();
        }
    }

    public static final class Factory implements MediaSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DashChunkSource.Factory f26203a;

        /* renamed from: b  reason: collision with root package name */
        private final DataSource.Factory f26204b;

        /* renamed from: c  reason: collision with root package name */
        private DrmSessionManagerProvider f26205c;

        /* renamed from: d  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f26206d;

        /* renamed from: e  reason: collision with root package name */
        private LoadErrorHandlingPolicy f26207e;

        /* renamed from: f  reason: collision with root package name */
        private long f26208f;

        /* renamed from: g  reason: collision with root package name */
        private ParsingLoadable.Parser<? extends DashManifest> f26209g;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        /* renamed from: d */
        public DashMediaSource a(MediaItem mediaItem) {
            FilteringManifestParser filteringManifestParser;
            Assertions.e(mediaItem.f23129c);
            ParsingLoadable.Parser parser = this.f26209g;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            List<StreamKey> list = mediaItem.f23129c.f23205d;
            if (!list.isEmpty()) {
                filteringManifestParser = new FilteringManifestParser(parser, list);
            } else {
                filteringManifestParser = parser;
            }
            return new DashMediaSource(mediaItem, (DashManifest) null, this.f26204b, filteringManifestParser, this.f26203a, this.f26206d, this.f26205c.a(mediaItem), this.f26207e, this.f26208f);
        }

        /* renamed from: e */
        public Factory b(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f26205c = (DrmSessionManagerProvider) Assertions.f(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        /* renamed from: f */
        public Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f26207e = (LoadErrorHandlingPolicy) Assertions.f(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(DashChunkSource.Factory factory, DataSource.Factory factory2) {
            this.f26203a = (DashChunkSource.Factory) Assertions.e(factory);
            this.f26204b = factory2;
            this.f26205c = new DefaultDrmSessionManagerProvider();
            this.f26207e = new DefaultLoadErrorHandlingPolicy();
            this.f26208f = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
            this.f26206d = new DefaultCompositeSequenceableLoaderFactory();
        }
    }

    static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f26210a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        Iso8601Parser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            long j2;
            long j3;
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)).readLine();
            try {
                Matcher matcher = f26210a.matcher(readLine);
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
        public void p(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, boolean z2) {
            DashMediaSource.this.V(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void q(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.W(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction t(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.X(parsingLoadable, j2, j3, iOException, i2);
        }
    }

    final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        private void b() throws IOException {
            if (DashMediaSource.this.D != null) {
                throw DashMediaSource.this.D;
            }
        }

        public void a() throws IOException {
            DashMediaSource.this.B.a();
            b();
        }
    }

    private final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        /* renamed from: a */
        public void p(ParsingLoadable<Long> parsingLoadable, long j2, long j3, boolean z2) {
            DashMediaSource.this.V(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void q(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.Y(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction t(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.Z(parsingLoadable, j2, j3, iOException);
        }
    }

    private static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.M0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.dash");
    }

    private static long L(Period period, long j2, long j3) {
        Period period2 = period;
        long j4 = j2;
        long j5 = j3;
        long F0 = Util.F0(period2.f26314b);
        boolean P2 = P(period);
        long j6 = Clock.MAX_TIME;
        for (int i2 = 0; i2 < period2.f26315c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f26315c.get(i2);
            List<Representation> list = adaptationSet.f26270c;
            int i3 = adaptationSet.f26269b;
            boolean z2 = true;
            if (i3 == 1 || i3 == 2) {
                z2 = false;
            }
            if ((!P2 || !z2) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null) {
                    return F0 + j4;
                }
                long k2 = l2.k(j4, j5);
                if (k2 == 0) {
                    return F0;
                }
                long d2 = (l2.d(j4, j5) + k2) - 1;
                j6 = Math.min(j6, l2.c(d2, j4) + l2.b(d2) + F0);
            }
        }
        return j6;
    }

    private static long M(Period period, long j2, long j3) {
        Period period2 = period;
        long j4 = j2;
        long j5 = j3;
        long F0 = Util.F0(period2.f26314b);
        boolean P2 = P(period);
        long j6 = F0;
        for (int i2 = 0; i2 < period2.f26315c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f26315c.get(i2);
            List<Representation> list = adaptationSet.f26270c;
            int i3 = adaptationSet.f26269b;
            boolean z2 = true;
            if (i3 == 1 || i3 == 2) {
                z2 = false;
            }
            if ((!P2 || !z2) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null || l2.k(j4, j5) == 0) {
                    return F0;
                }
                j6 = Math.max(j6, l2.b(l2.d(j4, j5)) + F0);
            }
        }
        return j6;
    }

    private static long N(DashManifest dashManifest, long j2) {
        DashSegmentIndex l2;
        DashManifest dashManifest2 = dashManifest;
        int e2 = dashManifest.e() - 1;
        Period d2 = dashManifest2.d(e2);
        long F0 = Util.F0(d2.f26314b);
        long g2 = dashManifest2.g(e2);
        long F02 = Util.F0(j2);
        long F03 = Util.F0(dashManifest2.f26278a);
        long F04 = Util.F0(5000);
        for (int i2 = 0; i2 < d2.f26315c.size(); i2++) {
            List<Representation> list = d2.f26315c.get(i2).f26270c;
            if (!list.isEmpty() && (l2 = list.get(0).l()) != null) {
                long e3 = ((F03 + F0) + l2.e(g2, F02)) - F02;
                if (e3 < F04 - 100000 || (e3 > F04 && e3 < F04 + 100000)) {
                    F04 = e3;
                }
            }
        }
        return LongMath.b(F04, 1000, RoundingMode.CEILING);
    }

    private long O() {
        return (long) Math.min((this.N - 1) * 1000, 5000);
    }

    private static boolean P(Period period) {
        for (int i2 = 0; i2 < period.f26315c.size(); i2++) {
            int i3 = period.f26315c.get(i2).f26269b;
            if (i3 == 1 || i3 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean Q(Period period) {
        for (int i2 = 0; i2 < period.f26315c.size(); i2++) {
            DashSegmentIndex l2 = period.f26315c.get(i2).f26270c.get(0).l();
            if (l2 == null || l2.i()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        c0(false);
    }

    private void S() {
        SntpClient.j(this.B, new SntpClient.InitializationCallback() {
            public void a(IOException iOException) {
                DashMediaSource.this.a0(iOException);
            }

            public void b() {
                DashMediaSource.this.b0(SntpClient.h());
            }
        });
    }

    /* access modifiers changed from: private */
    public void a0(IOException iOException) {
        Log.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        c0(true);
    }

    /* access modifiers changed from: private */
    public void b0(long j2) {
        this.M = j2;
        c0(true);
    }

    private void c0(boolean z2) {
        boolean z3;
        long j2;
        long j3;
        Period period;
        MediaItem.LiveConfiguration liveConfiguration;
        boolean z4;
        for (int i2 = 0; i2 < this.f26186v.size(); i2++) {
            int keyAt = this.f26186v.keyAt(i2);
            if (keyAt >= this.P) {
                this.f26186v.valueAt(i2).M(this.I, keyAt - this.P);
            }
        }
        Period d2 = this.I.d(0);
        int e2 = this.I.e() - 1;
        Period d3 = this.I.d(e2);
        long g2 = this.I.g(e2);
        long F0 = Util.F0(Util.c0(this.M));
        long M2 = M(d2, this.I.g(0), F0);
        long L2 = L(d3, g2, F0);
        if (!this.I.f26281d || Q(d3)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            long j4 = this.I.f26283f;
            if (j4 != -9223372036854775807L) {
                M2 = Math.max(M2, L2 - Util.F0(j4));
            }
        }
        long j5 = L2 - M2;
        DashManifest dashManifest = this.I;
        Period period2 = d2;
        if (dashManifest.f26281d) {
            if (dashManifest.f26278a != -9223372036854775807L) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.g(z4);
            long F02 = (F0 - Util.F0(this.I.f26278a)) - M2;
            j0(F02, j5);
            long i12 = this.I.f26278a + Util.i1(M2);
            long F03 = F02 - Util.F0(this.F.f23192b);
            long min = Math.min(5000000, j5 / 2);
            j3 = i12;
            if (F03 < min) {
                j2 = min;
            } else {
                j2 = F03;
            }
            period = period2;
        } else {
            period = period2;
            j3 = -9223372036854775807L;
            j2 = 0;
        }
        long F04 = M2 - Util.F0(period.f26314b);
        DashManifest dashManifest2 = this.I;
        long j6 = dashManifest2.f26278a;
        long j7 = this.M;
        int i3 = this.P;
        MediaItem mediaItem = this.f26173i;
        if (dashManifest2.f26281d) {
            liveConfiguration = this.F;
        } else {
            liveConfiguration = null;
        }
        D(new DashTimeline(j6, j3, j7, i3, F04, j5, j2, dashManifest2, mediaItem, liveConfiguration));
        if (!this.f26174j) {
            this.E.removeCallbacks(this.f26188x);
            if (z3) {
                this.E.postDelayed(this.f26188x, N(this.I, Util.c0(this.M)));
            }
            if (this.J) {
                i0();
            } else if (z2) {
                DashManifest dashManifest3 = this.I;
                if (dashManifest3.f26281d) {
                    long j8 = dashManifest3.f26282e;
                    if (j8 != -9223372036854775807L) {
                        if (j8 == 0) {
                            j8 = 5000;
                        }
                        g0(Math.max(0, (this.K + j8) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    private void d0(UtcTimingElement utcTimingElement) {
        String str = utcTimingElement.f26368a;
        if (Util.c(str, "urn:mpeg:dash:utc:direct:2014") || Util.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            e0(utcTimingElement);
        } else if (Util.c(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            f0(utcTimingElement, new Iso8601Parser());
        } else if (Util.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            f0(utcTimingElement, new XsDateTimeParser());
        } else if (Util.c(str, "urn:mpeg:dash:utc:ntp:2014") || Util.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            S();
        } else {
            a0(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void e0(UtcTimingElement utcTimingElement) {
        try {
            b0(Util.M0(utcTimingElement.f26369b) - this.L);
        } catch (ParserException e2) {
            a0(e2);
        }
    }

    private void f0(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        h0(new ParsingLoadable(this.A, Uri.parse(utcTimingElement.f26369b), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void g0(long j2) {
        this.E.postDelayed(this.f26187w, j2);
    }

    private <T> void h0(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        this.f26182r.z(new LoadEventInfo(parsingLoadable.f28482a, parsingLoadable.f28483b, this.B.n(parsingLoadable, callback, i2)), parsingLoadable.f28484c);
    }

    /* access modifiers changed from: private */
    public void i0() {
        Uri uri;
        this.E.removeCallbacks(this.f26187w);
        if (!this.B.i()) {
            if (this.B.j()) {
                this.J = true;
                return;
            }
            synchronized (this.f26185u) {
                uri = this.G;
            }
            this.J = false;
            h0(new ParsingLoadable(this.A, uri, 4, this.f26183s), this.f26184t, this.f26179o.a(4));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j0(long r18, long r20) {
        /*
            r17 = this;
            r0 = r17
            long r5 = com.google.android.exoplayer2.util.Util.i1(r18)
            com.google.android.exoplayer2.MediaItem r1 = r0.f26173i
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r1 = r1.f23131e
            long r1 = r1.f23194d
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x001b
            long r1 = java.lang.Math.min(r5, r1)
        L_0x0019:
            r9 = r1
            goto L_0x002d
        L_0x001b:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r1 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r1 = r1.f26287j
            if (r1 == 0) goto L_0x002c
            long r1 = r1.f26360c
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x002c
            long r1 = java.lang.Math.min(r5, r1)
            goto L_0x0019
        L_0x002c:
            r9 = r5
        L_0x002d:
            long r1 = r18 - r20
            long r1 = com.google.android.exoplayer2.util.Util.i1(r1)
            r3 = 0
            int r11 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x003e
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 <= 0) goto L_0x003e
            r1 = r3
        L_0x003e:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r3 = r0.I
            long r3 = r3.f26280c
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x004b
            long r1 = r1 + r3
            long r1 = java.lang.Math.min(r1, r5)
        L_0x004b:
            r3 = r1
            com.google.android.exoplayer2.MediaItem r1 = r0.f26173i
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r1 = r1.f23131e
            long r1 = r1.f23193c
            int r11 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x005b
            long r3 = com.google.android.exoplayer2.util.Util.r(r1, r3, r5)
            goto L_0x006b
        L_0x005b:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r1 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r1 = r1.f26287j
            if (r1 == 0) goto L_0x006b
            long r1 = r1.f26359b
            int r11 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x006b
            long r3 = com.google.android.exoplayer2.util.Util.r(r1, r3, r5)
        L_0x006b:
            int r1 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x0070
            r9 = r3
        L_0x0070:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r1 = r0.F
            long r1 = r1.f23192b
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r1 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r2 = r1.f26287j
            if (r2 == 0) goto L_0x0087
            long r5 = r2.f26358a
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0087
            r1 = r5
            goto L_0x0090
        L_0x0087:
            long r1 = r1.f26284g
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            long r1 = r0.f26181q
        L_0x0090:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0095
            r1 = r3
        L_0x0095:
            int r5 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00b0
            r1 = 2
            long r1 = r20 / r1
            r5 = 5000000(0x4c4b40, double:2.470328E-317)
            long r1 = java.lang.Math.min(r5, r1)
            long r1 = r18 - r1
            long r11 = com.google.android.exoplayer2.util.Util.i1(r1)
            r13 = r3
            r15 = r9
            long r1 = com.google.android.exoplayer2.util.Util.r(r11, r13, r15)
        L_0x00b0:
            com.google.android.exoplayer2.MediaItem r5 = r0.f26173i
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r5 = r5.f23131e
            float r6 = r5.f23195e
            r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r12 == 0) goto L_0x00be
            goto L_0x00ca
        L_0x00be:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r6 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r6 = r6.f26287j
            if (r6 == 0) goto L_0x00c7
            float r6 = r6.f26361d
            goto L_0x00ca
        L_0x00c7:
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00ca:
            float r5 = r5.f23196f
            int r12 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r12 == 0) goto L_0x00d1
            goto L_0x00dd
        L_0x00d1:
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r5 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r5 = r5.f26287j
            if (r5 == 0) goto L_0x00da
            float r5 = r5.f26362e
            goto L_0x00dd
        L_0x00da:
            r5 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00dd:
            int r12 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r12 != 0) goto L_0x00f5
            int r11 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r11 != 0) goto L_0x00f5
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r11 = r0.I
            com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement r11 = r11.f26287j
            if (r11 == 0) goto L_0x00f1
            long r11 = r11.f26358a
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x00f5
        L_0x00f1:
            r6 = 1065353216(0x3f800000, float:1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x00f5:
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r7 = new com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder
            r7.<init>()
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r1 = r7.k(r1)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r1 = r1.i(r3)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r1 = r1.g(r9)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r1 = r1.j(r6)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration$Builder r1 = r1.h(r5)
            com.google.android.exoplayer2.MediaItem$LiveConfiguration r1 = r1.f()
            r0.F = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.j0(long, long):void");
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.C = transferListener;
        this.f26178n.b(Looper.myLooper(), A());
        this.f26178n.prepare();
        if (this.f26174j) {
            c0(false);
            return;
        }
        this.A = this.f26175k.a();
        this.B = new Loader("DashMediaSource");
        this.E = Util.w();
        i0();
    }

    /* access modifiers changed from: protected */
    public void E() {
        DashManifest dashManifest;
        this.J = false;
        this.A = null;
        Loader loader = this.B;
        if (loader != null) {
            loader.l();
            this.B = null;
        }
        this.K = 0;
        this.L = 0;
        if (this.f26174j) {
            dashManifest = this.I;
        } else {
            dashManifest = null;
        }
        this.I = dashManifest;
        this.G = this.H;
        this.D = null;
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.E = null;
        }
        this.M = -9223372036854775807L;
        this.N = 0;
        this.O = -9223372036854775807L;
        this.P = 0;
        this.f26186v.clear();
        this.f26180p.i();
        this.f26178n.release();
    }

    /* access modifiers changed from: package-private */
    public void T(long j2) {
        long j3 = this.O;
        if (j3 == -9223372036854775807L || j3 < j2) {
            this.O = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.E.removeCallbacks(this.f26188x);
        i0();
    }

    /* access modifiers changed from: package-private */
    public void V(ParsingLoadable<?> parsingLoadable, long j2, long j3) {
        ParsingLoadable<?> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f26179o.b(parsingLoadable2.f28482a);
        this.f26182r.q(loadEventInfo, parsingLoadable2.f28484c);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W(com.google.android.exoplayer2.upstream.ParsingLoadable<com.google.android.exoplayer2.source.dash.manifest.DashManifest> r19, long r20, long r22) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r14 = r20
            com.google.android.exoplayer2.source.LoadEventInfo r12 = new com.google.android.exoplayer2.source.LoadEventInfo
            long r3 = r0.f28482a
            com.google.android.exoplayer2.upstream.DataSpec r5 = r0.f28483b
            android.net.Uri r6 = r19.f()
            java.util.Map r7 = r19.d()
            long r16 = r19.c()
            r2 = r12
            r8 = r20
            r10 = r22
            r14 = r12
            r12 = r16
            r2.<init>(r3, r5, r6, r7, r8, r10, r12)
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r1.f26179o
            long r3 = r0.f28482a
            r2.b(r3)
            com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher r2 = r1.f26182r
            int r3 = r0.f28484c
            r2.t(r14, r3)
            java.lang.Object r2 = r19.e()
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r2 = (com.google.android.exoplayer2.source.dash.manifest.DashManifest) r2
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r3 = r1.I
            r4 = 0
            if (r3 != 0) goto L_0x003e
            r3 = 0
            goto L_0x0042
        L_0x003e:
            int r3 = r3.e()
        L_0x0042:
            com.google.android.exoplayer2.source.dash.manifest.Period r5 = r2.d(r4)
            long r5 = r5.f26314b
            r7 = 0
        L_0x0049:
            if (r7 >= r3) goto L_0x005a
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r8 = r1.I
            com.google.android.exoplayer2.source.dash.manifest.Period r8 = r8.d(r7)
            long r8 = r8.f26314b
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x005a
            int r7 = r7 + 1
            goto L_0x0049
        L_0x005a:
            boolean r5 = r2.f26281d
            r6 = 1
            if (r5 == 0) goto L_0x00cd
            int r5 = r3 - r7
            int r8 = r2.e()
            if (r5 <= r8) goto L_0x0070
            java.lang.String r5 = "DashMediaSource"
            java.lang.String r8 = "Loaded out of sync manifest"
            com.google.android.exoplayer2.util.Log.i(r5, r8)
        L_0x006e:
            r5 = 1
            goto L_0x00a9
        L_0x0070:
            long r8 = r1.O
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x00a8
            long r10 = r2.f26285h
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r12
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x00a8
            java.lang.String r5 = "DashMediaSource"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Loaded stale dynamic manifest: "
            r8.append(r9)
            long r9 = r2.f26285h
            r8.append(r9)
            java.lang.String r9 = ", "
            r8.append(r9)
            long r9 = r1.O
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.android.exoplayer2.util.Log.i(r5, r8)
            goto L_0x006e
        L_0x00a8:
            r5 = 0
        L_0x00a9:
            if (r5 == 0) goto L_0x00cb
            int r2 = r1.N
            int r3 = r2 + 1
            r1.N = r3
            com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r3 = r1.f26179o
            int r0 = r0.f28484c
            int r0 = r3.a(r0)
            if (r2 >= r0) goto L_0x00c3
            long r2 = r18.O()
            r1.g0(r2)
            goto L_0x00ca
        L_0x00c3:
            com.google.android.exoplayer2.source.dash.DashManifestStaleException r0 = new com.google.android.exoplayer2.source.dash.DashManifestStaleException
            r0.<init>()
            r1.D = r0
        L_0x00ca:
            return
        L_0x00cb:
            r1.N = r4
        L_0x00cd:
            r1.I = r2
            boolean r5 = r1.J
            boolean r2 = r2.f26281d
            r2 = r2 & r5
            r1.J = r2
            r8 = r20
            long r10 = r8 - r22
            r1.K = r10
            r1.L = r8
            java.lang.Object r2 = r1.f26185u
            monitor-enter(r2)
            com.google.android.exoplayer2.upstream.DataSpec r5 = r0.f28483b     // Catch:{ all -> 0x011b }
            android.net.Uri r5 = r5.f28339a     // Catch:{ all -> 0x011b }
            android.net.Uri r8 = r1.G     // Catch:{ all -> 0x011b }
            if (r5 != r8) goto L_0x00ea
            r4 = 1
        L_0x00ea:
            if (r4 == 0) goto L_0x00f9
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r4 = r1.I     // Catch:{ all -> 0x011b }
            android.net.Uri r4 = r4.f26288k     // Catch:{ all -> 0x011b }
            if (r4 == 0) goto L_0x00f3
            goto L_0x00f7
        L_0x00f3:
            android.net.Uri r4 = r19.f()     // Catch:{ all -> 0x011b }
        L_0x00f7:
            r1.G = r4     // Catch:{ all -> 0x011b }
        L_0x00f9:
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            if (r3 != 0) goto L_0x0112
            com.google.android.exoplayer2.source.dash.manifest.DashManifest r0 = r1.I
            boolean r2 = r0.f26281d
            if (r2 == 0) goto L_0x010e
            com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement r0 = r0.f26286i
            if (r0 == 0) goto L_0x010a
            r1.d0(r0)
            goto L_0x011a
        L_0x010a:
            r18.S()
            goto L_0x011a
        L_0x010e:
            r1.c0(r6)
            goto L_0x011a
        L_0x0112:
            int r0 = r1.P
            int r0 = r0 + r7
            r1.P = r0
            r1.c0(r6)
        L_0x011a:
            return
        L_0x011b:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x011b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.W(com.google.android.exoplayer2.upstream.ParsingLoadable, long, long):void");
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction X(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
        Loader.LoadErrorAction loadErrorAction;
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        long c2 = this.f26179o.c(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f28484c), iOException2, i2));
        if (c2 == -9223372036854775807L) {
            loadErrorAction = Loader.f28465g;
        } else {
            loadErrorAction = Loader.h(false, c2);
        }
        boolean z2 = !loadErrorAction.c();
        this.f26182r.x(loadEventInfo, parsingLoadable2.f28484c, iOException2, z2);
        if (z2) {
            this.f26179o.b(parsingLoadable2.f28482a);
        }
        return loadErrorAction;
    }

    /* access modifiers changed from: package-private */
    public void Y(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        this.f26179o.b(parsingLoadable2.f28482a);
        this.f26182r.t(loadEventInfo, parsingLoadable2.f28484c);
        b0(parsingLoadable.e().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction Z(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.f26182r;
        LoadEventInfo loadEventInfo = r4;
        LoadEventInfo loadEventInfo2 = new LoadEventInfo(parsingLoadable2.f28482a, parsingLoadable2.f28483b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.c());
        eventDispatcher.x(loadEventInfo, parsingLoadable2.f28484c, iOException2, true);
        this.f26179o.b(parsingLoadable2.f28482a);
        a0(iOException2);
        return Loader.f28464f;
    }

    public MediaItem a() {
        return this.f26173i;
    }

    public void c() throws IOException {
        this.f26190z.a();
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        int intValue = ((Integer) mediaPeriodId2.f25793a).intValue() - this.P;
        int i2 = intValue;
        MediaSourceEventListener.EventDispatcher x2 = x(mediaPeriodId2, this.I.d(intValue).f26314b);
        DrmSessionEventListener.EventDispatcher u2 = u(mediaPeriodId);
        DashMediaPeriod dashMediaPeriod = r2;
        DashMediaPeriod dashMediaPeriod2 = new DashMediaPeriod(intValue + this.P, this.I, this.f26180p, i2, this.f26176l, this.C, this.f26178n, u2, this.f26179o, x2, this.M, this.f26190z, allocator, this.f26177m, this.f26189y, A());
        DashMediaPeriod dashMediaPeriod3 = dashMediaPeriod;
        this.f26186v.put(dashMediaPeriod3.f26142b, dashMediaPeriod3);
        return dashMediaPeriod3;
    }

    public void l(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.I();
        this.f26186v.remove(dashMediaPeriod.f26142b);
    }

    private DashMediaSource(MediaItem mediaItem, DashManifest dashManifest, DataSource.Factory factory, ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        this.f26173i = mediaItem;
        this.F = mediaItem.f23131e;
        this.G = ((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f23129c)).f23202a;
        this.H = mediaItem.f23129c.f23202a;
        this.I = dashManifest;
        this.f26175k = factory;
        this.f26183s = parser;
        this.f26176l = factory2;
        this.f26178n = drmSessionManager;
        this.f26179o = loadErrorHandlingPolicy;
        this.f26181q = j2;
        this.f26177m = compositeSequenceableLoaderFactory;
        this.f26180p = new BaseUrlExclusionList();
        boolean z2 = dashManifest != null;
        this.f26174j = z2;
        this.f26182r = w((MediaSource.MediaPeriodId) null);
        this.f26185u = new Object();
        this.f26186v = new SparseArray<>();
        this.f26189y = new DefaultPlayerEmsgCallback();
        this.O = -9223372036854775807L;
        this.M = -9223372036854775807L;
        if (z2) {
            Assertions.g(true ^ dashManifest.f26281d);
            this.f26184t = null;
            this.f26187w = null;
            this.f26188x = null;
            this.f26190z = new LoaderErrorThrower.Dummy();
            return;
        }
        this.f26184t = new ManifestCallback();
        this.f26190z = new ManifestLoadErrorThrower();
        this.f26187w = new b(this);
        this.f26188x = new c(this);
    }
}
