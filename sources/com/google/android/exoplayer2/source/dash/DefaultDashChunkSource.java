package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.InitializationChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.SingleSampleMediaChunk;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DefaultDashChunkSource implements DashChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final LoaderErrorThrower f26216a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseUrlExclusionList f26217b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f26218c;

    /* renamed from: d  reason: collision with root package name */
    private final int f26219d;

    /* renamed from: e  reason: collision with root package name */
    private final DataSource f26220e;

    /* renamed from: f  reason: collision with root package name */
    private final long f26221f;

    /* renamed from: g  reason: collision with root package name */
    private final int f26222g;

    /* renamed from: h  reason: collision with root package name */
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler f26223h;

    /* renamed from: i  reason: collision with root package name */
    protected final RepresentationHolder[] f26224i;

    /* renamed from: j  reason: collision with root package name */
    private ExoTrackSelection f26225j;

    /* renamed from: k  reason: collision with root package name */
    private DashManifest f26226k;

    /* renamed from: l  reason: collision with root package name */
    private int f26227l;

    /* renamed from: m  reason: collision with root package name */
    private IOException f26228m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26229n;

    public static final class Factory implements DashChunkSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f26230a;

        /* renamed from: b  reason: collision with root package name */
        private final int f26231b;

        /* renamed from: c  reason: collision with root package name */
        private final ChunkExtractor.Factory f26232c;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public DashChunkSource a(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, long j2, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId) {
            TransferListener transferListener2 = transferListener;
            DataSource a2 = this.f26230a.a();
            if (transferListener2 != null) {
                a2.p(transferListener2);
            }
            return new DefaultDashChunkSource(this.f26232c, loaderErrorThrower, dashManifest, baseUrlExclusionList, i2, iArr, exoTrackSelection, i3, a2, j2, this.f26231b, z2, list, playerTrackEmsgHandler, playerId);
        }

        public Factory(DataSource.Factory factory, int i2) {
            this(BundledChunkExtractor.f26060k, factory, i2);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i2) {
            this.f26232c = factory;
            this.f26230a = factory2;
            this.f26231b = i2;
        }
    }

    protected static final class RepresentationHolder {

        /* renamed from: a  reason: collision with root package name */
        final ChunkExtractor f26233a;

        /* renamed from: b  reason: collision with root package name */
        public final Representation f26234b;

        /* renamed from: c  reason: collision with root package name */
        public final BaseUrl f26235c;

        /* renamed from: d  reason: collision with root package name */
        public final DashSegmentIndex f26236d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f26237e;

        /* renamed from: f  reason: collision with root package name */
        private final long f26238f;

        RepresentationHolder(long j2, Representation representation, BaseUrl baseUrl, ChunkExtractor chunkExtractor, long j3, DashSegmentIndex dashSegmentIndex) {
            this.f26237e = j2;
            this.f26234b = representation;
            this.f26235c = baseUrl;
            this.f26238f = j3;
            this.f26233a = chunkExtractor;
            this.f26236d = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder b(long j2, Representation representation) throws BehindLiveWindowException {
            long g2;
            long g3;
            long j3 = j2;
            DashSegmentIndex l2 = this.f26234b.l();
            DashSegmentIndex l3 = representation.l();
            if (l2 == null) {
                return new RepresentationHolder(j2, representation, this.f26235c, this.f26233a, this.f26238f, l2);
            } else if (!l2.i()) {
                return new RepresentationHolder(j2, representation, this.f26235c, this.f26233a, this.f26238f, l3);
            } else {
                long h2 = l2.h(j3);
                if (h2 == 0) {
                    return new RepresentationHolder(j2, representation, this.f26235c, this.f26233a, this.f26238f, l3);
                }
                long j4 = l2.j();
                long b2 = l2.b(j4);
                long j5 = (h2 + j4) - 1;
                long j6 = l3.j();
                DashSegmentIndex dashSegmentIndex = l2;
                long b3 = l3.b(j6);
                long j7 = j4;
                long j8 = this.f26238f;
                int i2 = ((l2.b(j5) + l2.c(j5, j3)) > b3 ? 1 : ((l2.b(j5) + l2.c(j5, j3)) == b3 ? 0 : -1));
                if (i2 == 0) {
                    g2 = j5 + 1;
                } else if (i2 < 0) {
                    throw new BehindLiveWindowException();
                } else if (b3 < b2) {
                    g3 = j8 - (l3.g(b2, j3) - j7);
                    return new RepresentationHolder(j2, representation, this.f26235c, this.f26233a, g3, l3);
                } else {
                    g2 = dashSegmentIndex.g(b3, j3);
                }
                g3 = j8 + (g2 - j6);
                return new RepresentationHolder(j2, representation, this.f26235c, this.f26233a, g3, l3);
            }
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder c(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.f26237e, this.f26234b, this.f26235c, this.f26233a, this.f26238f, dashSegmentIndex);
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder d(BaseUrl baseUrl) {
            return new RepresentationHolder(this.f26237e, this.f26234b, baseUrl, this.f26233a, this.f26238f, this.f26236d);
        }

        public long e(long j2) {
            return this.f26236d.d(this.f26237e, j2) + this.f26238f;
        }

        public long f() {
            return this.f26236d.j() + this.f26238f;
        }

        public long g(long j2) {
            return (e(j2) + this.f26236d.k(this.f26237e, j2)) - 1;
        }

        public long h() {
            return this.f26236d.h(this.f26237e);
        }

        public long i(long j2) {
            return k(j2) + this.f26236d.c(j2 - this.f26238f, this.f26237e);
        }

        public long j(long j2) {
            return this.f26236d.g(j2, this.f26237e) + this.f26238f;
        }

        public long k(long j2) {
            return this.f26236d.b(j2 - this.f26238f);
        }

        public RangedUri l(long j2) {
            return this.f26236d.f(j2 - this.f26238f);
        }

        public boolean m(long j2, long j3) {
            if (!this.f26236d.i() && j3 != -9223372036854775807L && i(j2) > j3) {
                return false;
            }
            return true;
        }
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final RepresentationHolder f26239e;

        /* renamed from: f  reason: collision with root package name */
        private final long f26240f;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j2, long j3, long j4) {
            super(j2, j3);
            this.f26239e = representationHolder;
            this.f26240f = j4;
        }

        public long a() {
            c();
            return this.f26239e.k(d());
        }

        public long b() {
            c();
            return this.f26239e.i(d());
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, PlayerId playerId) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList2 = baseUrlExclusionList;
        int i5 = i2;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.f26216a = loaderErrorThrower;
        this.f26226k = dashManifest2;
        this.f26217b = baseUrlExclusionList2;
        this.f26218c = iArr;
        this.f26225j = exoTrackSelection2;
        this.f26219d = i3;
        this.f26220e = dataSource;
        this.f26227l = i5;
        this.f26221f = j2;
        this.f26222g = i4;
        this.f26223h = playerTrackEmsgHandler;
        long g2 = dashManifest2.g(i5);
        ArrayList<Representation> n2 = n();
        this.f26224i = new RepresentationHolder[exoTrackSelection.length()];
        int i6 = 0;
        while (i6 < this.f26224i.length) {
            Representation representation = n2.get(exoTrackSelection2.c(i6));
            BaseUrl j3 = baseUrlExclusionList2.j(representation.f26329c);
            RepresentationHolder[] representationHolderArr = this.f26224i;
            if (j3 == null) {
                j3 = representation.f26329c.get(0);
            }
            int i7 = i6;
            long j4 = g2;
            Representation representation2 = representation;
            representationHolderArr[i7] = new RepresentationHolder(j4, representation2, j3, factory.a(i3, representation.f26328b, z2, list, playerTrackEmsgHandler, playerId), 0, representation.l());
            i6 = i7 + 1;
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions k(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.p(i3, elapsedRealtime)) {
                i2++;
            }
        }
        int f2 = BaseUrlExclusionList.f(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(f2, f2 - this.f26217b.g(list), length, i2);
    }

    private long l(long j2, long j3) {
        if (!this.f26226k.f26281d || this.f26224i[0].h() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0, Math.min(m(j2), this.f26224i[0].i(this.f26224i[0].g(j2))) - j3);
    }

    private long m(long j2) {
        DashManifest dashManifest = this.f26226k;
        long j3 = dashManifest.f26278a;
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 - Util.F0(j3 + dashManifest.d(this.f26227l).f26314b);
    }

    private ArrayList<Representation> n() {
        List<AdaptationSet> list = this.f26226k.d(this.f26227l).f26315c;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i2 : this.f26218c) {
            arrayList.addAll(list.get(i2).f26270c);
        }
        return arrayList;
    }

    private long o(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j2, long j3, long j4) {
        if (mediaChunk != null) {
            return mediaChunk.g();
        }
        return Util.r(representationHolder.j(j2), j3, j4);
    }

    private RepresentationHolder r(int i2) {
        RepresentationHolder representationHolder = this.f26224i[i2];
        BaseUrl j2 = this.f26217b.j(representationHolder.f26234b.f26329c);
        if (j2 == null || j2.equals(representationHolder.f26235c)) {
            return representationHolder;
        }
        RepresentationHolder d2 = representationHolder.d(j2);
        this.f26224i[i2] = d2;
        return d2;
    }

    public void a() throws IOException {
        IOException iOException = this.f26228m;
        if (iOException == null) {
            this.f26216a.a();
            return;
        }
        throw iOException;
    }

    public void b(ExoTrackSelection exoTrackSelection) {
        this.f26225j = exoTrackSelection;
    }

    public int c(long j2, List<? extends MediaChunk> list) {
        if (this.f26228m != null || this.f26225j.length() < 2) {
            return list.size();
        }
        return this.f26225j.j(j2, list);
    }

    public boolean d(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f26228m != null) {
            return false;
        }
        return this.f26225j.q(j2, chunk, list);
    }

    public void f(Chunk chunk) {
        ChunkIndex b2;
        if (chunk instanceof InitializationChunk) {
            int r2 = this.f26225j.r(((InitializationChunk) chunk).f26081d);
            RepresentationHolder representationHolder = this.f26224i[r2];
            if (representationHolder.f26236d == null && (b2 = representationHolder.f26233a.b()) != null) {
                this.f26224i[r2] = representationHolder.c(new DashWrappingSegmentIndex(b2, representationHolder.f26234b.f26330d));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f26223h;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.i(chunk);
        }
    }

    public long g(long j2, SeekParameters seekParameters) {
        long j3;
        long j4 = j2;
        for (RepresentationHolder representationHolder : this.f26224i) {
            if (representationHolder.f26236d != null) {
                long h2 = representationHolder.h();
                if (h2 != 0) {
                    long j5 = representationHolder.j(j4);
                    long k2 = representationHolder.k(j5);
                    if (k2 >= j4 || (h2 != -1 && j5 >= (representationHolder.f() + h2) - 1)) {
                        j3 = k2;
                    } else {
                        j3 = representationHolder.k(j5 + 1);
                    }
                    return seekParameters.a(j2, k2, j3);
                }
            }
        }
        return j4;
    }

    public boolean h(Chunk chunk, boolean z2, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection d2;
        if (!z2) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f26223h;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.j(chunk)) {
            return true;
        }
        if (!this.f26226k.f26281d && (chunk instanceof MediaChunk)) {
            IOException iOException = loadErrorInfo.f28460c;
            if ((iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) iOException).f28444e == 404) {
                RepresentationHolder representationHolder = this.f26224i[this.f26225j.r(chunk.f26081d)];
                long h2 = representationHolder.h();
                if (!(h2 == -1 || h2 == 0)) {
                    if (((MediaChunk) chunk).g() > (representationHolder.f() + h2) - 1) {
                        this.f26229n = true;
                        return true;
                    }
                }
            }
        }
        RepresentationHolder representationHolder2 = this.f26224i[this.f26225j.r(chunk.f26081d)];
        BaseUrl j2 = this.f26217b.j(representationHolder2.f26234b.f26329c);
        if (j2 != null && !representationHolder2.f26235c.equals(j2)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions k2 = k(this.f26225j, representationHolder2.f26234b.f26329c);
        if ((!k2.a(2) && !k2.a(1)) || (d2 = loadErrorHandlingPolicy.d(k2, loadErrorInfo)) == null || !k2.a(d2.f28456a)) {
            return false;
        }
        int i2 = d2.f28456a;
        if (i2 == 2) {
            ExoTrackSelection exoTrackSelection = this.f26225j;
            return exoTrackSelection.o(exoTrackSelection.r(chunk.f26081d), d2.f28457b);
        } else if (i2 != 1) {
            return false;
        } else {
            this.f26217b.e(representationHolder2.f26235c, d2.f28457b);
            return true;
        }
    }

    public void i(DashManifest dashManifest, int i2) {
        try {
            this.f26226k = dashManifest;
            this.f26227l = i2;
            long g2 = dashManifest.g(i2);
            ArrayList<Representation> n2 = n();
            for (int i3 = 0; i3 < this.f26224i.length; i3++) {
                RepresentationHolder[] representationHolderArr = this.f26224i;
                representationHolderArr[i3] = representationHolderArr[i3].b(g2, n2.get(this.f26225j.c(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.f26228m = e2;
        }
    }

    public void j(long j2, long j3, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        MediaChunk mediaChunk;
        boolean z2;
        RangedUri rangedUri;
        RangedUri rangedUri2;
        long j4;
        int i2;
        MediaChunkIterator[] mediaChunkIteratorArr;
        int i3;
        long j5;
        long j6 = j2;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.f26228m == null) {
            long j7 = j3 - j6;
            long F0 = Util.F0(this.f26226k.f26278a) + Util.F0(this.f26226k.d(this.f26227l).f26314b) + j3;
            PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f26223h;
            if (playerTrackEmsgHandler == null || !playerTrackEmsgHandler.h(F0)) {
                long F02 = Util.F0(Util.c0(this.f26221f));
                long m2 = m(F02);
                if (list.isEmpty()) {
                    List<? extends MediaChunk> list2 = list;
                    mediaChunk = null;
                } else {
                    mediaChunk = (MediaChunk) list.get(list.size() - 1);
                }
                int length = this.f26225j.length();
                MediaChunkIterator[] mediaChunkIteratorArr2 = new MediaChunkIterator[length];
                int i4 = 0;
                while (i4 < length) {
                    RepresentationHolder representationHolder = this.f26224i[i4];
                    if (representationHolder.f26236d == null) {
                        mediaChunkIteratorArr2[i4] = MediaChunkIterator.f26130a;
                        i3 = i4;
                        i2 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j4 = j7;
                        j5 = F02;
                    } else {
                        long e2 = representationHolder.e(F02);
                        long g2 = representationHolder.g(F02);
                        i3 = i4;
                        i2 = length;
                        mediaChunkIteratorArr = mediaChunkIteratorArr2;
                        j4 = j7;
                        j5 = F02;
                        long o2 = o(representationHolder, mediaChunk, j3, e2, g2);
                        if (o2 < e2) {
                            mediaChunkIteratorArr[i3] = MediaChunkIterator.f26130a;
                        } else {
                            mediaChunkIteratorArr[i3] = new RepresentationSegmentIterator(r(i3), o2, g2, m2);
                        }
                    }
                    i4 = i3 + 1;
                    List<? extends MediaChunk> list3 = list;
                    F02 = j5;
                    mediaChunkIteratorArr2 = mediaChunkIteratorArr;
                    length = i2;
                    j7 = j4;
                }
                long j8 = j7;
                long j9 = F02;
                this.f26225j.s(j2, j8, l(j9, j6), list, mediaChunkIteratorArr2);
                RepresentationHolder r2 = r(this.f26225j.a());
                ChunkExtractor chunkExtractor = r2.f26233a;
                if (chunkExtractor != null) {
                    Representation representation = r2.f26234b;
                    if (chunkExtractor.c() == null) {
                        rangedUri = representation.n();
                    } else {
                        rangedUri = null;
                    }
                    if (r2.f26236d == null) {
                        rangedUri2 = representation.m();
                    } else {
                        rangedUri2 = null;
                    }
                    if (!(rangedUri == null && rangedUri2 == null)) {
                        chunkHolder2.f26087a = p(r2, this.f26220e, this.f26225j.l(), this.f26225j.m(), this.f26225j.e(), rangedUri, rangedUri2);
                        return;
                    }
                }
                long a2 = r2.f26237e;
                long j10 = -9223372036854775807L;
                int i5 = (a2 > -9223372036854775807L ? 1 : (a2 == -9223372036854775807L ? 0 : -1));
                if (i5 != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (r2.h() == 0) {
                    chunkHolder2.f26088b = z2;
                    return;
                }
                long e3 = r2.e(j9);
                long g3 = r2.g(j9);
                long o3 = o(r2, mediaChunk, j3, e3, g3);
                if (o3 < e3) {
                    this.f26228m = new BehindLiveWindowException();
                    return;
                }
                int i6 = (o3 > g3 ? 1 : (o3 == g3 ? 0 : -1));
                if (i6 > 0 || (this.f26229n && i6 >= 0)) {
                    chunkHolder2.f26088b = z2;
                } else if (!z2 || r2.k(o3) < a2) {
                    int min = (int) Math.min((long) this.f26222g, (g3 - o3) + 1);
                    if (i5 != 0) {
                        while (min > 1 && r2.k((((long) min) + o3) - 1) >= a2) {
                            min--;
                        }
                    }
                    int i7 = min;
                    if (list.isEmpty()) {
                        j10 = j3;
                    }
                    chunkHolder2.f26087a = q(r2, this.f26220e, this.f26219d, this.f26225j.l(), this.f26225j.m(), this.f26225j.e(), o3, i7, j10, m2);
                } else {
                    chunkHolder2.f26088b = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Chunk p(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i2, Object obj, RangedUri rangedUri, RangedUri rangedUri2) {
        RepresentationHolder representationHolder2 = representationHolder;
        RangedUri rangedUri3 = rangedUri;
        Representation representation = representationHolder2.f26234b;
        if (rangedUri3 != null) {
            RangedUri a2 = rangedUri3.a(rangedUri2, representationHolder2.f26235c.f26274a);
            if (a2 != null) {
                rangedUri3 = a2;
            }
        } else {
            rangedUri3 = rangedUri2;
        }
        return new InitializationChunk(dataSource, DashUtil.a(representation, representationHolder2.f26235c.f26274a, rangedUri3, 0), format, i2, obj, representationHolder2.f26233a);
    }

    /* access modifiers changed from: protected */
    public Chunk q(RepresentationHolder representationHolder, DataSource dataSource, int i2, Format format, int i3, Object obj, long j2, int i4, long j3, long j4) {
        long j5;
        RepresentationHolder representationHolder2 = representationHolder;
        long j6 = j2;
        long j7 = j4;
        Representation representation = representationHolder2.f26234b;
        long k2 = representationHolder2.k(j6);
        RangedUri l2 = representationHolder2.l(j6);
        int i5 = 0;
        if (representationHolder2.f26233a == null) {
            long i6 = representationHolder2.i(j6);
            if (!representationHolder2.m(j6, j7)) {
                i5 = 8;
            }
            return new SingleSampleMediaChunk(dataSource, DashUtil.a(representation, representationHolder2.f26235c.f26274a, l2, i5), format, i3, obj, k2, i6, j2, i2, format);
        }
        int i7 = 1;
        int i8 = i4;
        int i9 = 1;
        while (i7 < i8) {
            RangedUri a2 = l2.a(representationHolder2.l(((long) i7) + j6), representationHolder2.f26235c.f26274a);
            if (a2 == null) {
                break;
            }
            i9++;
            i7++;
            l2 = a2;
        }
        long j8 = (((long) i9) + j6) - 1;
        long i10 = representationHolder2.i(j8);
        long a3 = representationHolder.f26237e;
        if (a3 == -9223372036854775807L || a3 > i10) {
            j5 = -9223372036854775807L;
        } else {
            j5 = a3;
        }
        if (!representationHolder2.m(j8, j7)) {
            i5 = 8;
        }
        ChunkExtractor chunkExtractor = representationHolder2.f26233a;
        return new ContainerMediaChunk(dataSource, DashUtil.a(representation, representationHolder2.f26235c.f26274a, l2, i5), format, i3, obj, k2, i10, j3, j5, j2, i9, -representation.f26330d, chunkExtractor);
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.f26224i) {
            ChunkExtractor chunkExtractor = representationHolder.f26233a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }
}
