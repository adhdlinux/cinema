package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    private static final AtomicInteger M = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final PlayerId C;
    private HlsMediaChunkExtractor D;
    private HlsSampleStreamWrapper E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;
    private ImmutableList<Integer> J;
    private boolean K;
    private boolean L;

    /* renamed from: k  reason: collision with root package name */
    public final int f26428k;

    /* renamed from: l  reason: collision with root package name */
    public final int f26429l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f26430m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f26431n;

    /* renamed from: o  reason: collision with root package name */
    public final int f26432o;

    /* renamed from: p  reason: collision with root package name */
    private final DataSource f26433p;

    /* renamed from: q  reason: collision with root package name */
    private final DataSpec f26434q;

    /* renamed from: r  reason: collision with root package name */
    private final HlsMediaChunkExtractor f26435r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f26436s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f26437t;

    /* renamed from: u  reason: collision with root package name */
    private final TimestampAdjuster f26438u;

    /* renamed from: v  reason: collision with root package name */
    private final HlsExtractorFactory f26439v;

    /* renamed from: w  reason: collision with root package name */
    private final List<Format> f26440w;

    /* renamed from: x  reason: collision with root package name */
    private final DrmInitData f26441x;

    /* renamed from: y  reason: collision with root package name */
    private final Id3Decoder f26442y;

    /* renamed from: z  reason: collision with root package name */
    private final ParsableByteArray f26443z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z2, DataSource dataSource2, DataSpec dataSpec2, boolean z3, Uri uri, List<Format> list, int i2, Object obj, long j2, long j3, long j4, int i3, boolean z4, int i4, boolean z5, boolean z6, TimestampAdjuster timestampAdjuster, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z7, PlayerId playerId) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4);
        DataSpec dataSpec3 = dataSpec2;
        this.A = z2;
        this.f26432o = i3;
        this.L = z4;
        this.f26429l = i4;
        this.f26434q = dataSpec3;
        this.f26433p = dataSource2;
        this.G = dataSpec3 != null;
        this.B = z3;
        this.f26430m = uri;
        this.f26436s = z6;
        this.f26438u = timestampAdjuster;
        this.f26437t = z5;
        this.f26439v = hlsExtractorFactory;
        this.f26440w = list;
        this.f26441x = drmInitData;
        this.f26435r = hlsMediaChunkExtractor;
        this.f26442y = id3Decoder;
        this.f26443z = parsableByteArray;
        this.f26431n = z7;
        this.C = playerId;
        this.J = ImmutableList.r();
        this.f26428k = M.getAndIncrement();
    }

    private static DataSource i(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        Assertions.e(bArr2);
        return new Aes128DataSource(dataSource, bArr, bArr2);
    }

    public static HlsMediaChunk j(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, Format format, long j2, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, Uri uri, List<Format> list, int i2, Object obj, boolean z2, TimestampAdjusterProvider timestampAdjusterProvider, HlsMediaChunk hlsMediaChunk, byte[] bArr, byte[] bArr2, boolean z3, PlayerId playerId) {
        boolean z4;
        boolean z5;
        DataSpec dataSpec;
        DataSource dataSource2;
        ParsableByteArray parsableByteArray;
        Id3Decoder id3Decoder;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        DataSource dataSource3 = dataSource;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        HlsChunkSource.SegmentBaseHolder segmentBaseHolder2 = segmentBaseHolder;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder2.f26420a;
        DataSpec a2 = new DataSpec.Builder().i(UriUtil.e(hlsMediaPlaylist2.f26645a, segmentBase.f26608b)).h(segmentBase.f26616j).g(segmentBase.f26617k).b(segmentBaseHolder2.f26423d ? 8 : 0).a();
        boolean z6 = bArr3 != null;
        DataSource i3 = i(dataSource3, bArr3, z6 ? l((String) Assertions.e(segmentBase.f26615i)) : null);
        HlsMediaPlaylist.Segment segment = segmentBase.f26609c;
        if (segment != null) {
            boolean z7 = bArr4 != null;
            byte[] l2 = z7 ? l((String) Assertions.e(segment.f26615i)) : null;
            z4 = z6;
            dataSpec = new DataSpec(UriUtil.e(hlsMediaPlaylist2.f26645a, segment.f26608b), segment.f26616j, segment.f26617k);
            dataSource2 = i(dataSource3, bArr4, l2);
            z5 = z7;
        } else {
            z4 = z6;
            dataSource2 = null;
            dataSpec = null;
            z5 = false;
        }
        long j3 = j2 + segmentBase.f26612f;
        long j4 = j3 + segmentBase.f26610d;
        int i4 = hlsMediaPlaylist2.f26588j + segmentBase.f26611e;
        if (hlsMediaChunk2 != null) {
            DataSpec dataSpec2 = hlsMediaChunk2.f26434q;
            boolean z8 = dataSpec == dataSpec2 || (dataSpec != null && dataSpec2 != null && dataSpec.f28339a.equals(dataSpec2.f28339a) && dataSpec.f28345g == hlsMediaChunk2.f26434q.f28345g);
            boolean z9 = uri.equals(hlsMediaChunk2.f26430m) && hlsMediaChunk2.I;
            Id3Decoder id3Decoder2 = hlsMediaChunk2.f26442y;
            id3Decoder = id3Decoder2;
            parsableByteArray = hlsMediaChunk2.f26443z;
            hlsMediaChunkExtractor = (!z8 || !z9 || hlsMediaChunk2.K || hlsMediaChunk2.f26429l != i4) ? null : hlsMediaChunk2.D;
        } else {
            Uri uri2 = uri;
            id3Decoder = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            hlsMediaChunkExtractor = null;
        }
        return new HlsMediaChunk(hlsExtractorFactory, i3, a2, format, z4, dataSource2, dataSpec, z5, uri, list, i2, obj, j3, j4, segmentBaseHolder2.f26421b, segmentBaseHolder2.f26422c, !segmentBaseHolder2.f26423d, i4, segmentBase.f26618l, z2, timestampAdjusterProvider.a(i4), segmentBase.f26613g, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z3, playerId);
    }

    @RequiresNonNull({"output"})
    private void k(DataSource dataSource, DataSpec dataSpec, boolean z2, boolean z3) throws IOException {
        DataSpec dataSpec2;
        DefaultExtractorInput u2;
        long position;
        long j2;
        boolean z4 = false;
        if (z2) {
            if (this.F != 0) {
                z4 = true;
            }
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.e((long) this.F);
        }
        try {
            u2 = u(dataSource, dataSpec2, z3);
            if (z4) {
                u2.k(this.F);
            }
            do {
                if (this.H || !this.D.a(u2)) {
                    break;
                }
                break;
                break;
            } while (!this.D.a(u2));
            break;
            position = u2.getPosition();
            j2 = dataSpec.f28345g;
        } catch (EOFException e2) {
            if ((this.f26081d.f23064f & Http2.INITIAL_MAX_FRAME_SIZE) != 0) {
                this.D.b();
                position = u2.getPosition();
                j2 = dataSpec.f28345g;
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            DataSourceUtil.a(dataSource);
            throw th;
        }
        this.F = (int) (position - j2);
        DataSourceUtil.a(dataSource);
    }

    private static byte[] l(String str) {
        int i2;
        if (Ascii.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        if (byteArray.length > 16) {
            i2 = byteArray.length - 16;
        } else {
            i2 = 0;
        }
        System.arraycopy(byteArray, i2, bArr, (16 - byteArray.length) + i2, byteArray.length - i2);
        return bArr;
    }

    private static boolean p(HlsChunkSource.SegmentBaseHolder segmentBaseHolder, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.f26420a;
        if (!(segmentBase instanceof HlsMediaPlaylist.Part)) {
            return hlsMediaPlaylist.f26647c;
        }
        if (((HlsMediaPlaylist.Part) segmentBase).f26601m || (segmentBaseHolder.f26422c == 0 && hlsMediaPlaylist.f26647c)) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void r() throws IOException {
        k(this.f26086i, this.f26079b, this.A, true);
    }

    @RequiresNonNull({"output"})
    private void s() throws IOException {
        if (this.G) {
            Assertions.e(this.f26433p);
            Assertions.e(this.f26434q);
            k(this.f26433p, this.f26434q, this.B, false);
            this.F = 0;
            this.G = false;
        }
    }

    private long t(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        try {
            this.f26443z.Q(10);
            extractorInput.m(this.f26443z.e(), 0, 10);
            if (this.f26443z.K() != 4801587) {
                return -9223372036854775807L;
            }
            this.f26443z.V(3);
            int G2 = this.f26443z.G();
            int i2 = G2 + 10;
            if (i2 > this.f26443z.b()) {
                byte[] e2 = this.f26443z.e();
                this.f26443z.Q(i2);
                System.arraycopy(e2, 0, this.f26443z.e(), 0, 10);
            }
            extractorInput.m(this.f26443z.e(), 10, G2);
            Metadata e3 = this.f26442y.e(this.f26443z.e(), G2);
            if (e3 == null) {
                return -9223372036854775807L;
            }
            int f2 = e3.f();
            for (int i3 = 0; i3 < f2; i3++) {
                Metadata.Entry e4 = e3.e(i3);
                if (e4 instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) e4;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f25437c)) {
                        System.arraycopy(privFrame.f25438d, 0, this.f26443z.e(), 0, 8);
                        this.f26443z.U(0);
                        this.f26443z.T(8);
                        return this.f26443z.A() & 8589934591L;
                    }
                }
            }
            return -9223372036854775807L;
        } catch (EOFException unused) {
        }
    }

    @RequiresNonNull({"output"})
    @EnsuresNonNull({"extractor"})
    private DefaultExtractorInput u(DataSource dataSource, DataSpec dataSpec, boolean z2) throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        long j2;
        long i2 = dataSource.i(dataSpec);
        if (z2) {
            try {
                this.f26438u.h(this.f26436s, this.f26084g);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, dataSpec.f28345g, i2);
        if (this.D == null) {
            long t2 = t(defaultExtractorInput);
            defaultExtractorInput.e();
            HlsMediaChunkExtractor hlsMediaChunkExtractor2 = this.f26435r;
            if (hlsMediaChunkExtractor2 != null) {
                hlsMediaChunkExtractor = hlsMediaChunkExtractor2.i();
            } else {
                hlsMediaChunkExtractor = this.f26439v.a(dataSpec.f28339a, this.f26081d, this.f26440w, this.f26438u, dataSource.d(), defaultExtractorInput, this.C);
            }
            this.D = hlsMediaChunkExtractor;
            if (hlsMediaChunkExtractor.h()) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.E;
                if (t2 != -9223372036854775807L) {
                    j2 = this.f26438u.b(t2);
                } else {
                    j2 = this.f26084g;
                }
                hlsSampleStreamWrapper.n0(j2);
            } else {
                this.E.n0(0);
            }
            this.E.Z();
            this.D.c(this.E);
        }
        this.E.k0(this.f26441x);
        return defaultExtractorInput;
    }

    public static boolean w(HlsMediaChunk hlsMediaChunk, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, long j2) {
        if (hlsMediaChunk == null) {
            return false;
        }
        if (uri.equals(hlsMediaChunk.f26430m) && hlsMediaChunk.I) {
            return false;
        }
        long j3 = j2 + segmentBaseHolder.f26420a.f26612f;
        if (!p(segmentBaseHolder, hlsMediaPlaylist) || j3 < hlsMediaChunk.f26085h) {
            return true;
        }
        return false;
    }

    public void a() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.e(this.E);
        if (this.D == null && (hlsMediaChunkExtractor = this.f26435r) != null && hlsMediaChunkExtractor.d()) {
            this.D = this.f26435r;
            this.G = false;
        }
        s();
        if (!this.H) {
            if (!this.f26437t) {
                r();
            }
            this.I = !this.H;
        }
    }

    public void b() {
        this.H = true;
    }

    public boolean h() {
        return this.I;
    }

    public int m(int i2) {
        Assertions.g(!this.f26431n);
        if (i2 >= this.J.size()) {
            return 0;
        }
        return this.J.get(i2).intValue();
    }

    public void n(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.E = hlsSampleStreamWrapper;
        this.J = immutableList;
    }

    public void o() {
        this.K = true;
    }

    public boolean q() {
        return this.L;
    }

    public void v() {
        this.L = true;
    }
}
