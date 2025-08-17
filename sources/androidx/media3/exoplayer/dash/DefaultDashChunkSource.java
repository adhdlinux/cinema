package androidx.media3.exoplayer.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.BaseUrl;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.InitializationChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.SingleSampleMediaChunk;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.text.SubtitleParser;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class DefaultDashChunkSource implements DashChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final LoaderErrorThrower f5986a;

    /* renamed from: b  reason: collision with root package name */
    private final BaseUrlExclusionList f5987b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f5988c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5989d;

    /* renamed from: e  reason: collision with root package name */
    private final DataSource f5990e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5991f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5992g;

    /* renamed from: h  reason: collision with root package name */
    private final PlayerEmsgHandler.PlayerTrackEmsgHandler f5993h;

    /* renamed from: i  reason: collision with root package name */
    protected final RepresentationHolder[] f5994i;

    /* renamed from: j  reason: collision with root package name */
    private ExoTrackSelection f5995j;

    /* renamed from: k  reason: collision with root package name */
    private DashManifest f5996k;

    /* renamed from: l  reason: collision with root package name */
    private int f5997l;

    /* renamed from: m  reason: collision with root package name */
    private IOException f5998m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5999n;

    /* renamed from: o  reason: collision with root package name */
    private long f6000o = -9223372036854775807L;

    public static final class Factory implements DashChunkSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f6001a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6002b;

        /* renamed from: c  reason: collision with root package name */
        private final ChunkExtractor.Factory f6003c;

        public Factory(DataSource.Factory factory) {
            this(factory, 1);
        }

        public Format c(Format format) {
            return this.f6003c.c(format);
        }

        public DashChunkSource d(LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, long j2, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, TransferListener transferListener, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
            TransferListener transferListener2 = transferListener;
            DataSource a2 = this.f6001a.a();
            if (transferListener2 != null) {
                a2.n(transferListener2);
            }
            return new DefaultDashChunkSource(this.f6003c, loaderErrorThrower, dashManifest, baseUrlExclusionList, i2, iArr, exoTrackSelection, i3, a2, j2, this.f6002b, z2, list, playerTrackEmsgHandler, playerId, cmcdConfiguration);
        }

        /* renamed from: e */
        public Factory b(boolean z2) {
            this.f6003c.b(z2);
            return this;
        }

        /* renamed from: f */
        public Factory a(SubtitleParser.Factory factory) {
            this.f6003c.a(factory);
            return this;
        }

        public Factory(DataSource.Factory factory, int i2) {
            this(BundledChunkExtractor.f7197k, factory, i2);
        }

        public Factory(ChunkExtractor.Factory factory, DataSource.Factory factory2, int i2) {
            this.f6003c = factory;
            this.f6001a = factory2;
            this.f6002b = i2;
        }
    }

    protected static final class RepresentationHolder {

        /* renamed from: a  reason: collision with root package name */
        final ChunkExtractor f6004a;

        /* renamed from: b  reason: collision with root package name */
        public final Representation f6005b;

        /* renamed from: c  reason: collision with root package name */
        public final BaseUrl f6006c;

        /* renamed from: d  reason: collision with root package name */
        public final DashSegmentIndex f6007d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f6008e;

        /* renamed from: f  reason: collision with root package name */
        private final long f6009f;

        RepresentationHolder(long j2, Representation representation, BaseUrl baseUrl, ChunkExtractor chunkExtractor, long j3, DashSegmentIndex dashSegmentIndex) {
            this.f6008e = j2;
            this.f6005b = representation;
            this.f6006c = baseUrl;
            this.f6009f = j3;
            this.f6004a = chunkExtractor;
            this.f6007d = dashSegmentIndex;
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder b(long j2, Representation representation) throws BehindLiveWindowException {
            long g2;
            long g3;
            long j3 = j2;
            DashSegmentIndex l2 = this.f6005b.l();
            DashSegmentIndex l3 = representation.l();
            if (l2 == null) {
                return new RepresentationHolder(j2, representation, this.f6006c, this.f6004a, this.f6009f, l2);
            } else if (!l2.i()) {
                return new RepresentationHolder(j2, representation, this.f6006c, this.f6004a, this.f6009f, l3);
            } else {
                long h2 = l2.h(j3);
                if (h2 == 0) {
                    return new RepresentationHolder(j2, representation, this.f6006c, this.f6004a, this.f6009f, l3);
                }
                Assertions.j(l3);
                long j4 = l2.j();
                long b2 = l2.b(j4);
                long j5 = (h2 + j4) - 1;
                long j6 = l3.j();
                DashSegmentIndex dashSegmentIndex = l2;
                long b3 = l3.b(j6);
                long j7 = j4;
                long j8 = this.f6009f;
                int i2 = ((l2.b(j5) + l2.c(j5, j3)) > b3 ? 1 : ((l2.b(j5) + l2.c(j5, j3)) == b3 ? 0 : -1));
                if (i2 == 0) {
                    g2 = j5 + 1;
                } else if (i2 < 0) {
                    throw new BehindLiveWindowException();
                } else if (b3 < b2) {
                    g3 = j8 - (l3.g(b2, j3) - j7);
                    return new RepresentationHolder(j2, representation, this.f6006c, this.f6004a, g3, l3);
                } else {
                    g2 = dashSegmentIndex.g(b3, j3);
                }
                g3 = j8 + (g2 - j6);
                return new RepresentationHolder(j2, representation, this.f6006c, this.f6004a, g3, l3);
            }
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder c(DashSegmentIndex dashSegmentIndex) {
            return new RepresentationHolder(this.f6008e, this.f6005b, this.f6006c, this.f6004a, this.f6009f, dashSegmentIndex);
        }

        /* access modifiers changed from: package-private */
        public RepresentationHolder d(BaseUrl baseUrl) {
            return new RepresentationHolder(this.f6008e, this.f6005b, baseUrl, this.f6004a, this.f6009f, this.f6007d);
        }

        public long e(long j2) {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).d(this.f6008e, j2) + this.f6009f;
        }

        public long f() {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).j() + this.f6009f;
        }

        public long g(long j2) {
            return (e(j2) + ((DashSegmentIndex) Assertions.j(this.f6007d)).k(this.f6008e, j2)) - 1;
        }

        public long h() {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).h(this.f6008e);
        }

        public long i(long j2) {
            return k(j2) + ((DashSegmentIndex) Assertions.j(this.f6007d)).c(j2 - this.f6009f, this.f6008e);
        }

        public long j(long j2) {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).g(j2, this.f6008e) + this.f6009f;
        }

        public long k(long j2) {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).b(j2 - this.f6009f);
        }

        public RangedUri l(long j2) {
            return ((DashSegmentIndex) Assertions.j(this.f6007d)).f(j2 - this.f6009f);
        }

        public boolean m(long j2, long j3) {
            if (!((DashSegmentIndex) Assertions.j(this.f6007d)).i() && j3 != -9223372036854775807L && i(j2) > j3) {
                return false;
            }
            return true;
        }
    }

    protected static final class RepresentationSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final RepresentationHolder f6010e;

        /* renamed from: f  reason: collision with root package name */
        private final long f6011f;

        public RepresentationSegmentIterator(RepresentationHolder representationHolder, long j2, long j3, long j4) {
            super(j2, j3);
            this.f6010e = representationHolder;
            this.f6011f = j4;
        }

        public long a() {
            c();
            return this.f6010e.k(d());
        }

        public long b() {
            c();
            return this.f6010e.i(d());
        }
    }

    public DefaultDashChunkSource(ChunkExtractor.Factory factory, LoaderErrorThrower loaderErrorThrower, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i2, int[] iArr, ExoTrackSelection exoTrackSelection, int i3, DataSource dataSource, long j2, int i4, boolean z2, List<Format> list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        DashManifest dashManifest2 = dashManifest;
        BaseUrlExclusionList baseUrlExclusionList2 = baseUrlExclusionList;
        int i5 = i2;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.f5986a = loaderErrorThrower;
        this.f5996k = dashManifest2;
        this.f5987b = baseUrlExclusionList2;
        this.f5988c = iArr;
        this.f5995j = exoTrackSelection2;
        this.f5989d = i3;
        this.f5990e = dataSource;
        this.f5997l = i5;
        this.f5991f = j2;
        this.f5992g = i4;
        this.f5993h = playerTrackEmsgHandler;
        long g2 = dashManifest2.g(i5);
        ArrayList<Representation> n2 = n();
        this.f5994i = new RepresentationHolder[exoTrackSelection.length()];
        int i6 = 0;
        while (i6 < this.f5994i.length) {
            Representation representation = n2.get(exoTrackSelection2.c(i6));
            BaseUrl j3 = baseUrlExclusionList2.j(representation.f6100c);
            RepresentationHolder[] representationHolderArr = this.f5994i;
            if (j3 == null) {
                j3 = representation.f6100c.get(0);
            }
            int i7 = i6;
            long j4 = g2;
            Representation representation2 = representation;
            representationHolderArr[i7] = new RepresentationHolder(j4, representation2, j3, factory.d(i3, representation.f6099b, z2, list, playerTrackEmsgHandler, playerId), 0, representation.l());
            i6 = i7 + 1;
        }
    }

    private LoadErrorHandlingPolicy.FallbackOptions j(ExoTrackSelection exoTrackSelection, List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = exoTrackSelection.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (exoTrackSelection.o(i3, elapsedRealtime)) {
                i2++;
            }
        }
        int f2 = BaseUrlExclusionList.f(list);
        return new LoadErrorHandlingPolicy.FallbackOptions(f2, f2 - this.f5987b.g(list), length, i2);
    }

    private long k(long j2, long j3) {
        if (!this.f5996k.f6052d || this.f5994i[0].h() == 0) {
            return -9223372036854775807L;
        }
        return Math.max(0, Math.min(m(j2), this.f5994i[0].i(this.f5994i[0].g(j2))) - j3);
    }

    private Pair<String, String> l(long j2, RangedUri rangedUri, RepresentationHolder representationHolder) {
        long j3 = j2 + 1;
        if (j3 >= representationHolder.h()) {
            return null;
        }
        RangedUri l2 = representationHolder.l(j3);
        String a2 = UriUtil.a(rangedUri.b(representationHolder.f6006c.f6045a), l2.b(representationHolder.f6006c.f6045a));
        String str = l2.f6094a + "-";
        if (l2.f6095b != -1) {
            str = str + (l2.f6094a + l2.f6095b);
        }
        return new Pair<>(a2, str);
    }

    private long m(long j2) {
        DashManifest dashManifest = this.f5996k;
        long j3 = dashManifest.f6049a;
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j2 - Util.P0(j3 + dashManifest.d(this.f5997l).f6085b);
    }

    @RequiresNonNull({"manifest", "adaptationSetIndices"})
    private ArrayList<Representation> n() {
        List<AdaptationSet> list = this.f5996k.d(this.f5997l).f6086c;
        ArrayList<Representation> arrayList = new ArrayList<>();
        for (int i2 : this.f5988c) {
            arrayList.addAll(list.get(i2).f6041c);
        }
        return arrayList;
    }

    private long o(RepresentationHolder representationHolder, MediaChunk mediaChunk, long j2, long j3, long j4) {
        if (mediaChunk != null) {
            return mediaChunk.g();
        }
        return Util.q(representationHolder.j(j2), j3, j4);
    }

    private RepresentationHolder r(int i2) {
        RepresentationHolder representationHolder = this.f5994i[i2];
        BaseUrl j2 = this.f5987b.j(representationHolder.f6005b.f6100c);
        if (j2 == null || j2.equals(representationHolder.f6006c)) {
            return representationHolder;
        }
        RepresentationHolder d2 = representationHolder.d(j2);
        this.f5994i[i2] = d2;
        return d2;
    }

    public void a() throws IOException {
        IOException iOException = this.f5998m;
        if (iOException == null) {
            this.f5986a.a();
            return;
        }
        throw iOException;
    }

    public void b(DashManifest dashManifest, int i2) {
        try {
            this.f5996k = dashManifest;
            this.f5997l = i2;
            long g2 = dashManifest.g(i2);
            ArrayList<Representation> n2 = n();
            for (int i3 = 0; i3 < this.f5994i.length; i3++) {
                RepresentationHolder[] representationHolderArr = this.f5994i;
                representationHolderArr[i3] = representationHolderArr[i3].b(g2, n2.get(this.f5995j.c(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.f5998m = e2;
        }
    }

    public int c(long j2, List<? extends MediaChunk> list) {
        if (this.f5998m != null || this.f5995j.length() < 2) {
            return list.size();
        }
        return this.f5995j.j(j2, list);
    }

    public boolean d(Chunk chunk, boolean z2, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection d2;
        if (!z2) {
            return false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f5993h;
        if (playerTrackEmsgHandler != null && playerTrackEmsgHandler.j(chunk)) {
            return true;
        }
        if (!this.f5996k.f6052d && (chunk instanceof MediaChunk)) {
            IOException iOException = loadErrorInfo.f7530c;
            if ((iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((HttpDataSource$InvalidResponseCodeException) iOException).f4892e == 404) {
                RepresentationHolder representationHolder = this.f5994i[this.f5995j.p(chunk.f7220d)];
                long h2 = representationHolder.h();
                if (!(h2 == -1 || h2 == 0)) {
                    if (((MediaChunk) chunk).g() > (representationHolder.f() + h2) - 1) {
                        this.f5999n = true;
                        return true;
                    }
                }
            }
        }
        RepresentationHolder representationHolder2 = this.f5994i[this.f5995j.p(chunk.f7220d)];
        BaseUrl j2 = this.f5987b.j(representationHolder2.f6005b.f6100c);
        if (j2 != null && !representationHolder2.f6006c.equals(j2)) {
            return true;
        }
        LoadErrorHandlingPolicy.FallbackOptions j3 = j(this.f5995j, representationHolder2.f6005b.f6100c);
        if ((!j3.a(2) && !j3.a(1)) || (d2 = loadErrorHandlingPolicy.d(j3, loadErrorInfo)) == null || !j3.a(d2.f7526a)) {
            return false;
        }
        int i2 = d2.f7526a;
        if (i2 == 2) {
            ExoTrackSelection exoTrackSelection = this.f5995j;
            return exoTrackSelection.r(exoTrackSelection.p(chunk.f7220d), d2.f7527b);
        } else if (i2 != 1) {
            return false;
        } else {
            this.f5987b.e(representationHolder2.f6006c, d2.f7527b);
            return true;
        }
    }

    public boolean e(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f5998m != null) {
            return false;
        }
        return this.f5995j.s(j2, chunk, list);
    }

    public void f(Chunk chunk) {
        ChunkIndex b2;
        if (chunk instanceof InitializationChunk) {
            int p2 = this.f5995j.p(((InitializationChunk) chunk).f7220d);
            RepresentationHolder representationHolder = this.f5994i[p2];
            if (representationHolder.f6007d == null && (b2 = ((ChunkExtractor) Assertions.j(representationHolder.f6004a)).b()) != null) {
                this.f5994i[p2] = representationHolder.c(new DashWrappingSegmentIndex(b2, representationHolder.f6005b.f6101d));
            }
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.f5993h;
        if (playerTrackEmsgHandler != null) {
            playerTrackEmsgHandler.i(chunk);
        }
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.media3.exoplayer.LoadingInfo r33, long r34, java.util.List<? extends androidx.media3.exoplayer.source.chunk.MediaChunk> r36, androidx.media3.exoplayer.source.chunk.ChunkHolder r37) {
        /*
            r32 = this;
            r15 = r32
            r14 = r37
            java.io.IOException r0 = r15.f5998m
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            r0 = r33
            long r9 = r0.f5395a
            long r11 = r34 - r9
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.f5996k
            long r0 = r0.f6049a
            long r0 = androidx.media3.common.util.Util.P0(r0)
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r15.f5996k
            int r3 = r15.f5997l
            androidx.media3.exoplayer.dash.manifest.Period r2 = r2.d(r3)
            long r2 = r2.f6085b
            long r2 = androidx.media3.common.util.Util.P0(r2)
            long r0 = r0 + r2
            long r0 = r0 + r34
            androidx.media3.exoplayer.dash.PlayerEmsgHandler$PlayerTrackEmsgHandler r2 = r15.f5993h
            if (r2 == 0) goto L_0x0033
            boolean r0 = r2.h(r0)
            if (r0 == 0) goto L_0x0033
            return
        L_0x0033:
            long r0 = r15.f5991f
            long r0 = androidx.media3.common.util.Util.f0(r0)
            long r7 = androidx.media3.common.util.Util.P0(r0)
            long r24 = r15.m(r7)
            boolean r0 = r36.isEmpty()
            r5 = 1
            if (r0 == 0) goto L_0x004d
            r6 = r36
            r26 = 0
            goto L_0x005c
        L_0x004d:
            int r0 = r36.size()
            int r0 = r0 - r5
            r6 = r36
            java.lang.Object r0 = r6.get(r0)
            androidx.media3.exoplayer.source.chunk.MediaChunk r0 = (androidx.media3.exoplayer.source.chunk.MediaChunk) r0
            r26 = r0
        L_0x005c:
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            int r3 = r0.length()
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r4 = new androidx.media3.exoplayer.source.chunk.MediaChunkIterator[r3]
            r27 = 0
            r2 = 0
        L_0x0067:
            if (r2 >= r3) goto L_0x00c1
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder[] r0 = r15.f5994i
            r1 = r0[r2]
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r1.f6007d
            if (r0 != 0) goto L_0x007e
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.f7269a
            r4[r2] = r0
            r13 = r2
            r29 = r3
            r28 = r4
            r30 = r11
            r11 = r7
            goto L_0x00b4
        L_0x007e:
            long r16 = r1.e(r7)
            long r20 = r1.g(r7)
            r0 = r32
            r13 = r2
            r2 = r26
            r29 = r3
            r28 = r4
            r3 = r34
            r5 = r16
            r30 = r11
            r11 = r7
            r7 = r20
            long r18 = r0.o(r1, r2, r3, r5, r7)
            int r0 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a5
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator r0 = androidx.media3.exoplayer.source.chunk.MediaChunkIterator.f7269a
            r28[r13] = r0
            goto L_0x00b4
        L_0x00a5:
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r17 = r15.r(r13)
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator r0 = new androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationSegmentIterator
            r16 = r0
            r22 = r24
            r16.<init>(r17, r18, r20, r22)
            r28[r13] = r0
        L_0x00b4:
            int r2 = r13 + 1
            r6 = r36
            r7 = r11
            r4 = r28
            r3 = r29
            r11 = r30
            r5 = 1
            goto L_0x0067
        L_0x00c1:
            r28 = r4
            r30 = r11
            r11 = r7
            long r5 = r15.k(r11, r9)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            r1 = r9
            r3 = r30
            r7 = r36
            r8 = r28
            r0.q(r1, r3, r5, r7, r8)
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            int r0 = r0.a()
            r16 = 0
            long r1 = android.os.SystemClock.elapsedRealtime()
            r15.f6000o = r1
            androidx.media3.exoplayer.dash.DefaultDashChunkSource$RepresentationHolder r9 = r15.r(r0)
            androidx.media3.exoplayer.source.chunk.ChunkExtractor r0 = r9.f6004a
            if (r0 == 0) goto L_0x012a
            androidx.media3.exoplayer.dash.manifest.Representation r1 = r9.f6005b
            androidx.media3.common.Format[] r0 = r0.c()
            if (r0 != 0) goto L_0x00fa
            androidx.media3.exoplayer.dash.manifest.RangedUri r0 = r1.n()
            r6 = r0
            goto L_0x00fb
        L_0x00fa:
            r6 = 0
        L_0x00fb:
            androidx.media3.exoplayer.dash.DashSegmentIndex r0 = r9.f6007d
            if (r0 != 0) goto L_0x0105
            androidx.media3.exoplayer.dash.manifest.RangedUri r0 = r1.m()
            r7 = r0
            goto L_0x0106
        L_0x0105:
            r7 = 0
        L_0x0106:
            if (r6 != 0) goto L_0x010a
            if (r7 == 0) goto L_0x012a
        L_0x010a:
            androidx.media3.datasource.DataSource r2 = r15.f5990e
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            androidx.media3.common.Format r3 = r0.l()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            int r4 = r0.m()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            java.lang.Object r5 = r0.e()
            r0 = r32
            r1 = r9
            r8 = r16
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.p(r1, r2, r3, r4, r5, r6, r7, r8)
            r14.f7226a = r0
            return
        L_0x012a:
            long r17 = r9.f6008e
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r15.f5996k
            boolean r1 = r0.f6052d
            if (r1 == 0) goto L_0x0140
            int r1 = r15.f5997l
            int r0 = r0.e()
            r10 = 1
            int r0 = r0 - r10
            if (r1 != r0) goto L_0x0141
            r5 = 1
            goto L_0x0142
        L_0x0140:
            r10 = 1
        L_0x0141:
            r5 = 0
        L_0x0142:
            r19 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == 0) goto L_0x0150
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r0 = 0
            goto L_0x0151
        L_0x0150:
            r0 = 1
        L_0x0151:
            long r1 = r9.h()
            r3 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x015e
            r14.f7227b = r0
            return
        L_0x015e:
            long r21 = r9.e(r11)
            long r11 = r9.g(r11)
            if (r5 == 0) goto L_0x017b
            long r1 = r9.i(r11)
            long r3 = r9.k(r11)
            long r3 = r1 - r3
            long r1 = r1 + r3
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 < 0) goto L_0x0179
            r5 = 1
            goto L_0x017a
        L_0x0179:
            r5 = 0
        L_0x017a:
            r0 = r0 & r5
        L_0x017b:
            r13 = r0
            r0 = r32
            r1 = r9
            r2 = r26
            r3 = r34
            r5 = r21
            r7 = r11
            long r7 = r0.o(r1, r2, r3, r5, r7)
            int r0 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r0 >= 0) goto L_0x0196
            androidx.media3.exoplayer.source.BehindLiveWindowException r0 = new androidx.media3.exoplayer.source.BehindLiveWindowException
            r0.<init>()
            r15.f5998m = r0
            return
        L_0x0196:
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 > 0) goto L_0x01ff
            boolean r1 = r15.f5999n
            if (r1 == 0) goto L_0x01a1
            if (r0 < 0) goto L_0x01a1
            goto L_0x01ff
        L_0x01a1:
            if (r13 == 0) goto L_0x01ae
            long r0 = r9.k(r7)
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x01ae
            r14.f7227b = r10
            return
        L_0x01ae:
            int r0 = r15.f5992g
            long r0 = (long) r0
            long r11 = r11 - r7
            r2 = 1
            long r11 = r11 + r2
            long r0 = java.lang.Math.min(r0, r11)
            int r1 = (int) r0
            int r0 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x01ce
        L_0x01be:
            if (r1 <= r10) goto L_0x01ce
            long r4 = (long) r1
            long r4 = r4 + r7
            long r4 = r4 - r2
            long r4 = r9.k(r4)
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 < 0) goto L_0x01ce
            int r1 = r1 + -1
            goto L_0x01be
        L_0x01ce:
            r10 = r1
            boolean r0 = r36.isEmpty()
            if (r0 == 0) goto L_0x01d7
            r19 = r34
        L_0x01d7:
            androidx.media3.datasource.DataSource r2 = r15.f5990e
            int r3 = r15.f5989d
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            androidx.media3.common.Format r4 = r0.l()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            int r5 = r0.m()
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r0 = r15.f5995j
            java.lang.Object r6 = r0.e()
            r0 = r32
            r1 = r9
            r9 = r10
            r10 = r19
            r12 = r24
            r15 = r14
            r14 = r16
            androidx.media3.exoplayer.source.chunk.Chunk r0 = r0.q(r1, r2, r3, r4, r5, r6, r7, r9, r10, r12, r14)
            r15.f7226a = r0
            return
        L_0x01ff:
            r15 = r14
            r15.f7227b = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DefaultDashChunkSource.g(androidx.media3.exoplayer.LoadingInfo, long, java.util.List, androidx.media3.exoplayer.source.chunk.ChunkHolder):void");
    }

    public long h(long j2, SeekParameters seekParameters) {
        long j3;
        long j4 = j2;
        for (RepresentationHolder representationHolder : this.f5994i) {
            if (representationHolder.f6007d != null) {
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

    public void i(ExoTrackSelection exoTrackSelection) {
        this.f5995j = exoTrackSelection;
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"#1.chunkExtractor"})
    public Chunk p(RepresentationHolder representationHolder, DataSource dataSource, Format format, int i2, Object obj, RangedUri rangedUri, RangedUri rangedUri2, CmcdData.Factory factory) {
        Representation representation = representationHolder.f6005b;
        if (rangedUri != null) {
            RangedUri a2 = rangedUri.a(rangedUri2, representationHolder.f6006c.f6045a);
            if (a2 != null) {
                rangedUri = a2;
            }
        } else {
            rangedUri = (RangedUri) Assertions.f(rangedUri2);
        }
        DataSpec a3 = DashUtil.a(representation, representationHolder.f6006c.f6045a, rangedUri, 0, ImmutableMap.k());
        if (factory != null) {
            a3 = factory.f(ContextChain.TAG_INFRA).a().a(a3);
        }
        return new InitializationChunk(dataSource, a3, format, i2, obj, representationHolder.f6004a);
    }

    /* access modifiers changed from: protected */
    public Chunk q(RepresentationHolder representationHolder, DataSource dataSource, int i2, Format format, int i3, Object obj, long j2, int i4, long j3, long j4, CmcdData.Factory factory) {
        int i5;
        int i6;
        DataSpec dataSpec;
        RepresentationHolder representationHolder2 = representationHolder;
        long j5 = j2;
        long j6 = j4;
        CmcdData.Factory factory2 = factory;
        Representation representation = representationHolder2.f6005b;
        long k2 = representationHolder2.k(j5);
        RangedUri l2 = representationHolder2.l(j5);
        if (representationHolder2.f6004a == null) {
            long i7 = representationHolder2.i(j5);
            if (representationHolder2.m(j5, j6)) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            DataSpec a2 = DashUtil.a(representation, representationHolder2.f6006c.f6045a, l2, i6, ImmutableMap.k());
            if (factory2 != null) {
                factory2.c(i7 - k2).f(CmcdData.Factory.b(this.f5995j));
                Pair<String, String> l3 = l(j5, l2, representationHolder2);
                if (l3 != null) {
                    factory2.d((String) l3.first).e((String) l3.second);
                }
                dataSpec = factory.a().a(a2);
            } else {
                dataSpec = a2;
            }
            return new SingleSampleMediaChunk(dataSource, dataSpec, format, i3, obj, k2, i7, j2, i2, format);
        }
        int i8 = 1;
        int i9 = i4;
        int i10 = 1;
        while (i8 < i9) {
            RangedUri a3 = l2.a(representationHolder2.l(((long) i8) + j5), representationHolder2.f6006c.f6045a);
            if (a3 == null) {
                break;
            }
            i10++;
            i8++;
            l2 = a3;
        }
        long j7 = (((long) i10) + j5) - 1;
        long i11 = representationHolder2.i(j7);
        long a4 = representationHolder.f6008e;
        long j8 = -9223372036854775807L;
        if (a4 != -9223372036854775807L && a4 <= i11) {
            j8 = a4;
        }
        if (representationHolder2.m(j7, j6)) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        DataSpec a5 = DashUtil.a(representation, representationHolder2.f6006c.f6045a, l2, i5, ImmutableMap.k());
        if (factory2 != null) {
            factory2.c(i11 - k2).f(CmcdData.Factory.b(this.f5995j));
            Pair<String, String> l4 = l(j5, l2, representationHolder2);
            if (l4 != null) {
                factory2.d((String) l4.first).e((String) l4.second);
            }
            a5 = factory.a().a(a5);
        }
        DataSpec dataSpec2 = a5;
        long j9 = -representation.f6101d;
        if (MimeTypes.p(format.f4015n)) {
            j9 += k2;
        }
        ChunkExtractor chunkExtractor = representationHolder2.f6004a;
        return new ContainerMediaChunk(dataSource, dataSpec2, format, i3, obj, k2, i11, j3, j8, j2, i10, j9, chunkExtractor);
    }

    public void release() {
        for (RepresentationHolder representationHolder : this.f5994i) {
            ChunkExtractor chunkExtractor = representationHolder.f6004a;
            if (chunkExtractor != null) {
                chunkExtractor.release();
            }
        }
    }
}
