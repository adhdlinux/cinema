package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UriUtil;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.HlsChunkSource;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Http2;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    private static final AtomicInteger N = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final PlayerId C;
    private final long D;
    private HlsMediaChunkExtractor E;
    private HlsSampleStreamWrapper F;
    private int G;
    private boolean H;
    private volatile boolean I;
    private boolean J;
    private ImmutableList<Integer> K;
    private boolean L;
    private boolean M;

    /* renamed from: k  reason: collision with root package name */
    public final int f6338k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6339l;

    /* renamed from: m  reason: collision with root package name */
    public final Uri f6340m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f6341n;

    /* renamed from: o  reason: collision with root package name */
    public final int f6342o;

    /* renamed from: p  reason: collision with root package name */
    private final DataSource f6343p;

    /* renamed from: q  reason: collision with root package name */
    private final DataSpec f6344q;

    /* renamed from: r  reason: collision with root package name */
    private final HlsMediaChunkExtractor f6345r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f6346s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f6347t;

    /* renamed from: u  reason: collision with root package name */
    private final TimestampAdjuster f6348u;

    /* renamed from: v  reason: collision with root package name */
    private final HlsExtractorFactory f6349v;

    /* renamed from: w  reason: collision with root package name */
    private final List<Format> f6350w;

    /* renamed from: x  reason: collision with root package name */
    private final DrmInitData f6351x;

    /* renamed from: y  reason: collision with root package name */
    private final Id3Decoder f6352y;

    /* renamed from: z  reason: collision with root package name */
    private final ParsableByteArray f6353z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, Format format, boolean z2, DataSource dataSource2, DataSpec dataSpec2, boolean z3, Uri uri, List<Format> list, int i2, Object obj, long j2, long j3, long j4, int i3, boolean z4, int i4, boolean z5, boolean z6, TimestampAdjuster timestampAdjuster, long j5, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, Id3Decoder id3Decoder, ParsableByteArray parsableByteArray, boolean z7, PlayerId playerId) {
        super(dataSource, dataSpec, format, i2, obj, j2, j3, j4);
        DataSpec dataSpec3 = dataSpec2;
        this.A = z2;
        this.f6342o = i3;
        this.M = z4;
        this.f6339l = i4;
        this.f6344q = dataSpec3;
        this.f6343p = dataSource2;
        this.H = dataSpec3 != null;
        this.B = z3;
        this.f6340m = uri;
        this.f6346s = z6;
        this.f6348u = timestampAdjuster;
        this.D = j5;
        this.f6347t = z5;
        this.f6349v = hlsExtractorFactory;
        this.f6350w = list;
        this.f6351x = drmInitData;
        this.f6345r = hlsMediaChunkExtractor;
        this.f6352y = id3Decoder;
        this.f6353z = parsableByteArray;
        this.f6341n = z7;
        this.C = playerId;
        this.K = ImmutableList.r();
        this.f6338k = N.getAndIncrement();
    }

    private static DataSource i(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return dataSource;
        }
        Assertions.f(bArr2);
        return new Aes128DataSource(dataSource, bArr, bArr2);
    }

    public static HlsMediaChunk j(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, Format format, long j2, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, Uri uri, List<Format> list, int i2, Object obj, boolean z2, TimestampAdjusterProvider timestampAdjusterProvider, long j3, HlsMediaChunk hlsMediaChunk, byte[] bArr, byte[] bArr2, boolean z3, PlayerId playerId, CmcdData.Factory factory) {
        boolean z4;
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
        CmcdData.Factory factory2 = factory;
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder2.f6331a;
        DataSpec a2 = new DataSpec.Builder().i(UriUtil.f(hlsMediaPlaylist2.f6562a, segmentBase.f6525b)).h(segmentBase.f6533j).g(segmentBase.f6534k).b(segmentBaseHolder2.f6334d ? 8 : 0).a();
        if (factory2 != null) {
            a2 = factory2.c(segmentBase.f6527d).a().a(a2);
        }
        DataSpec dataSpec2 = a2;
        boolean z5 = bArr3 != null;
        DataSource i3 = i(dataSource3, bArr3, z5 ? l((String) Assertions.f(segmentBase.f6532i)) : null);
        HlsMediaPlaylist.Segment segment = segmentBase.f6526c;
        if (segment != null) {
            boolean z6 = bArr4 != null;
            byte[] l2 = z6 ? l((String) Assertions.f(segment.f6532i)) : null;
            boolean z7 = z6;
            dataSpec = new DataSpec.Builder().i(UriUtil.f(hlsMediaPlaylist2.f6562a, segment.f6525b)).h(segment.f6533j).g(segment.f6534k).a();
            if (factory2 != null) {
                dataSpec = factory2.f(ContextChain.TAG_INFRA).a().a(dataSpec);
            }
            dataSource2 = i(dataSource3, bArr4, l2);
            z4 = z7;
        } else {
            dataSource2 = null;
            dataSpec = null;
            z4 = false;
        }
        long j4 = j2 + segmentBase.f6529f;
        long j5 = j4 + segmentBase.f6527d;
        int i4 = hlsMediaPlaylist2.f6505j + segmentBase.f6528e;
        if (hlsMediaChunk2 != null) {
            DataSpec dataSpec3 = hlsMediaChunk2.f6344q;
            boolean z8 = dataSpec == dataSpec3 || (dataSpec != null && dataSpec3 != null && dataSpec.f4823a.equals(dataSpec3.f4823a) && dataSpec.f4829g == hlsMediaChunk2.f6344q.f4829g);
            boolean z9 = uri.equals(hlsMediaChunk2.f6340m) && hlsMediaChunk2.J;
            Id3Decoder id3Decoder2 = hlsMediaChunk2.f6352y;
            id3Decoder = id3Decoder2;
            parsableByteArray = hlsMediaChunk2.f6353z;
            hlsMediaChunkExtractor = (!z8 || !z9 || hlsMediaChunk2.L || hlsMediaChunk2.f6339l != i4) ? null : hlsMediaChunk2.E;
        } else {
            Uri uri2 = uri;
            id3Decoder = new Id3Decoder();
            parsableByteArray = new ParsableByteArray(10);
            hlsMediaChunkExtractor = null;
        }
        return new HlsMediaChunk(hlsExtractorFactory, i3, dataSpec2, format, z5, dataSource2, dataSpec, z4, uri, list, i2, obj, j4, j5, segmentBaseHolder2.f6332b, segmentBaseHolder2.f6333c, !segmentBaseHolder2.f6334d, i4, segmentBase.f6535l, z2, timestampAdjusterProvider.a(i4), j3, segmentBase.f6530g, hlsMediaChunkExtractor, id3Decoder, parsableByteArray, z3, playerId);
    }

    @RequiresNonNull({"output"})
    private void k(DataSource dataSource, DataSpec dataSpec, boolean z2, boolean z3) throws IOException {
        DataSpec dataSpec2;
        DefaultExtractorInput u2;
        long position;
        long j2;
        boolean z4 = false;
        if (z2) {
            if (this.G != 0) {
                z4 = true;
            }
            dataSpec2 = dataSpec;
        } else {
            dataSpec2 = dataSpec.e((long) this.G);
        }
        try {
            u2 = u(dataSource, dataSpec2, z3);
            if (z4) {
                u2.k(this.G);
            }
            do {
                if (this.I || !this.E.a(u2)) {
                    break;
                }
                break;
                break;
            } while (!this.E.a(u2));
            break;
            position = u2.getPosition();
            j2 = dataSpec.f4829g;
        } catch (EOFException e2) {
            if ((this.f7220d.f4007f & Http2.INITIAL_MAX_FRAME_SIZE) != 0) {
                this.E.b();
                position = u2.getPosition();
                j2 = dataSpec.f4829g;
            } else {
                throw e2;
            }
        } catch (Throwable th) {
            DataSourceUtil.a(dataSource);
            throw th;
        }
        this.G = (int) (position - j2);
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
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.f6331a;
        if (!(segmentBase instanceof HlsMediaPlaylist.Part)) {
            return hlsMediaPlaylist.f6564c;
        }
        if (((HlsMediaPlaylist.Part) segmentBase).f6518m || (segmentBaseHolder.f6333c == 0 && hlsMediaPlaylist.f6564c)) {
            return true;
        }
        return false;
    }

    @RequiresNonNull({"output"})
    private void r() throws IOException {
        k(this.f7225i, this.f7218b, this.A, true);
    }

    @RequiresNonNull({"output"})
    private void s() throws IOException {
        if (this.H) {
            Assertions.f(this.f6343p);
            Assertions.f(this.f6344q);
            k(this.f6343p, this.f6344q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    private long t(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        try {
            this.f6353z.Q(10);
            extractorInput.m(this.f6353z.e(), 0, 10);
            if (this.f6353z.K() != 4801587) {
                return -9223372036854775807L;
            }
            this.f6353z.V(3);
            int G2 = this.f6353z.G();
            int i2 = G2 + 10;
            if (i2 > this.f6353z.b()) {
                byte[] e2 = this.f6353z.e();
                this.f6353z.Q(i2);
                System.arraycopy(e2, 0, this.f6353z.e(), 0, 10);
            }
            extractorInput.m(this.f6353z.e(), 10, G2);
            Metadata e3 = this.f6352y.e(this.f6353z.e(), G2);
            if (e3 == null) {
                return -9223372036854775807L;
            }
            int f2 = e3.f();
            for (int i3 = 0; i3 < f2; i3++) {
                Metadata.Entry e4 = e3.e(i3);
                if (e4 instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) e4;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f8338c)) {
                        System.arraycopy(privFrame.f8339d, 0, this.f6353z.e(), 0, 8);
                        this.f6353z.U(0);
                        this.f6353z.T(8);
                        return this.f6353z.A() & 8589934591L;
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
                this.f6348u.j(this.f6346s, this.f7223g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e2) {
                throw new IOException(e2);
            }
        }
        DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, dataSpec.f4829g, i2);
        if (this.E == null) {
            long t2 = t(defaultExtractorInput);
            defaultExtractorInput.e();
            HlsMediaChunkExtractor hlsMediaChunkExtractor2 = this.f6345r;
            if (hlsMediaChunkExtractor2 != null) {
                hlsMediaChunkExtractor = hlsMediaChunkExtractor2.i();
            } else {
                hlsMediaChunkExtractor = this.f6349v.d(dataSpec.f4823a, this.f7220d, this.f6350w, this.f6348u, dataSource.d(), defaultExtractorInput, this.C);
            }
            this.E = hlsMediaChunkExtractor;
            if (hlsMediaChunkExtractor.h()) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.F;
                if (t2 != -9223372036854775807L) {
                    j2 = this.f6348u.b(t2);
                } else {
                    j2 = this.f7223g;
                }
                hlsSampleStreamWrapper.p0(j2);
            } else {
                this.F.p0(0);
            }
            this.F.b0();
            this.E.g(this.F);
        }
        this.F.m0(this.f6351x);
        return defaultExtractorInput;
    }

    public static boolean w(HlsMediaChunk hlsMediaChunk, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, long j2) {
        if (hlsMediaChunk == null) {
            return false;
        }
        if (uri.equals(hlsMediaChunk.f6340m) && hlsMediaChunk.J) {
            return false;
        }
        long j3 = j2 + segmentBaseHolder.f6331a.f6529f;
        if (!p(segmentBaseHolder, hlsMediaPlaylist) || j3 < hlsMediaChunk.f7224h) {
            return true;
        }
        return false;
    }

    public void a() throws IOException {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        Assertions.f(this.F);
        if (this.E == null && (hlsMediaChunkExtractor = this.f6345r) != null && hlsMediaChunkExtractor.d()) {
            this.E = this.f6345r;
            this.H = false;
        }
        s();
        if (!this.I) {
            if (!this.f6347t) {
                r();
            }
            this.J = !this.I;
        }
    }

    public void b() {
        this.I = true;
    }

    public boolean h() {
        return this.J;
    }

    public int m(int i2) {
        Assertions.h(!this.f6341n);
        if (i2 >= this.K.size()) {
            return 0;
        }
        return this.K.get(i2).intValue();
    }

    public void n(HlsSampleStreamWrapper hlsSampleStreamWrapper, ImmutableList<Integer> immutableList) {
        this.F = hlsSampleStreamWrapper;
        this.K = immutableList;
    }

    public void o() {
        this.L = true;
    }

    public boolean q() {
        return this.M;
    }

    public void v() {
        this.M = true;
    }
}
