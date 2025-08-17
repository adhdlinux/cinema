package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource$InvalidResponseCodeException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.hls.HlsChunkSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DiscardingTrackOutput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.emsg.EventMessageDecoder;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final Set<Integer> Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    private TrackOutput A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private Format G;
    private Format H;
    private boolean I;
    private TrackGroupArray J;
    private Set<TrackGroup> K;
    private int[] L;
    private int M;
    private boolean N;
    private boolean[] O;
    private boolean[] P;
    private long Q;
    private long R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private long W;
    private DrmInitData X;
    private HlsMediaChunk Y;

    /* renamed from: b  reason: collision with root package name */
    private final String f6410b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6411c;

    /* renamed from: d  reason: collision with root package name */
    private final Callback f6412d;

    /* renamed from: e  reason: collision with root package name */
    private final HlsChunkSource f6413e;

    /* renamed from: f  reason: collision with root package name */
    private final Allocator f6414f;

    /* renamed from: g  reason: collision with root package name */
    private final Format f6415g;

    /* renamed from: h  reason: collision with root package name */
    private final DrmSessionManager f6416h;

    /* renamed from: i  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f6417i;

    /* renamed from: j  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f6418j;

    /* renamed from: k  reason: collision with root package name */
    private final Loader f6419k = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: l  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f6420l;

    /* renamed from: m  reason: collision with root package name */
    private final int f6421m;

    /* renamed from: n  reason: collision with root package name */
    private final HlsChunkSource.HlsChunkHolder f6422n = new HlsChunkSource.HlsChunkHolder();

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList<HlsMediaChunk> f6423o;

    /* renamed from: p  reason: collision with root package name */
    private final List<HlsMediaChunk> f6424p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f6425q;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f6426r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f6427s;

    /* renamed from: t  reason: collision with root package name */
    private final ArrayList<HlsSampleStream> f6428t;

    /* renamed from: u  reason: collision with root package name */
    private final Map<String, DrmInitData> f6429u;

    /* renamed from: v  reason: collision with root package name */
    private Chunk f6430v;

    /* renamed from: w  reason: collision with root package name */
    private HlsSampleQueue[] f6431w;

    /* renamed from: x  reason: collision with root package name */
    private int[] f6432x = new int[0];

    /* renamed from: y  reason: collision with root package name */
    private Set<Integer> f6433y;

    /* renamed from: z  reason: collision with root package name */
    private SparseIntArray f6434z;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void a();

        void k(Uri uri);
    }

    private static class EmsgUnwrappingTrackOutput implements TrackOutput {

        /* renamed from: g  reason: collision with root package name */
        private static final Format f6435g = new Format.Builder().o0("application/id3").K();

        /* renamed from: h  reason: collision with root package name */
        private static final Format f6436h = new Format.Builder().o0("application/x-emsg").K();

        /* renamed from: a  reason: collision with root package name */
        private final EventMessageDecoder f6437a = new EventMessageDecoder();

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f6438b;

        /* renamed from: c  reason: collision with root package name */
        private final Format f6439c;

        /* renamed from: d  reason: collision with root package name */
        private Format f6440d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f6441e;

        /* renamed from: f  reason: collision with root package name */
        private int f6442f;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i2) {
            this.f6438b = trackOutput;
            if (i2 == 1) {
                this.f6439c = f6435g;
            } else if (i2 == 3) {
                this.f6439c = f6436h;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: " + i2);
            }
            this.f6441e = new byte[0];
            this.f6442f = 0;
        }

        private boolean g(EventMessage eventMessage) {
            Format D = eventMessage.D();
            if (D == null || !Util.c(this.f6439c.f4015n, D.f4015n)) {
                return false;
            }
            return true;
        }

        private void h(int i2) {
            byte[] bArr = this.f6441e;
            if (bArr.length < i2) {
                this.f6441e = Arrays.copyOf(bArr, i2 + (i2 / 2));
            }
        }

        private ParsableByteArray i(int i2, int i3) {
            int i4 = this.f6442f - i3;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f6441e, i4 - i2, i4));
            byte[] bArr = this.f6441e;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.f6442f = i3;
            return parsableByteArray;
        }

        public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
            h(this.f6442f + i2);
            parsableByteArray.l(this.f6441e, this.f6442f, i2);
            this.f6442f += i2;
        }

        public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
            g.b(this, parsableByteArray, i2);
        }

        public void c(Format format) {
            this.f6440d = format;
            this.f6438b.c(this.f6439c);
        }

        public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
            return g.a(this, dataReader, i2, z2);
        }

        public int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            h(this.f6442f + i2);
            int read = dataReader.read(this.f6441e, this.f6442f, i2);
            if (read != -1) {
                this.f6442f += read;
                return read;
            } else if (z2) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            Assertions.f(this.f6440d);
            ParsableByteArray i5 = i(i3, i4);
            if (!Util.c(this.f6440d.f4015n, this.f6439c.f4015n)) {
                if ("application/x-emsg".equals(this.f6440d.f4015n)) {
                    EventMessage c2 = this.f6437a.c(i5);
                    if (!g(c2)) {
                        Log.h("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.f6439c.f4015n, c2.D()}));
                        return;
                    }
                    i5 = new ParsableByteArray((byte[]) Assertions.f(c2.E()));
                } else {
                    Log.h("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f6440d.f4015n);
                    return;
                }
            }
            int a2 = i5.a();
            this.f6438b.b(i5, a2);
            this.f6438b.f(j2, i2, a2, 0, cryptoData);
        }
    }

    private static final class HlsSampleQueue extends SampleQueue {
        private final Map<String, DrmInitData> H;
        private DrmInitData I;

        private Metadata i0(Metadata metadata) {
            int i2;
            if (metadata == null) {
                return null;
            }
            int f2 = metadata.f();
            int i3 = 0;
            while (true) {
                if (i3 >= f2) {
                    i3 = -1;
                    break;
                }
                Metadata.Entry e2 = metadata.e(i3);
                if ((e2 instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) e2).f8338c)) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return metadata;
            }
            if (f2 == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(f2 - 1)];
            for (int i4 = 0; i4 < f2; i4++) {
                if (i4 != i3) {
                    if (i4 < i3) {
                        i2 = i4;
                    } else {
                        i2 = i4 - 1;
                    }
                    entryArr[i2] = metadata.e(i4);
                }
            }
            return new Metadata(entryArr);
        }

        public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            super.f(j2, i2, i3, i4, cryptoData);
        }

        public void j0(DrmInitData drmInitData) {
            this.I = drmInitData;
            J();
        }

        public void k0(HlsMediaChunk hlsMediaChunk) {
            g0((long) hlsMediaChunk.f6338k);
        }

        public Format x(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = format.f4019r;
            }
            if (!(drmInitData2 == null || (drmInitData = this.H.get(drmInitData2.f3972d)) == null)) {
                drmInitData2 = drmInitData;
            }
            Metadata i02 = i0(format.f4012k);
            if (!(drmInitData2 == format.f4019r && i02 == format.f4012k)) {
                format = format.a().U(drmInitData2).h0(i02).K();
            }
            return super.x(format);
        }

        private HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.H = map;
        }
    }

    public HlsSampleStreamWrapper(String str, int i2, Callback callback, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator, long j2, Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i3) {
        this.f6410b = str;
        this.f6411c = i2;
        this.f6412d = callback;
        this.f6413e = hlsChunkSource;
        this.f6429u = map;
        this.f6414f = allocator;
        this.f6415g = format;
        this.f6416h = drmSessionManager;
        this.f6417i = eventDispatcher;
        this.f6418j = loadErrorHandlingPolicy;
        this.f6420l = eventDispatcher2;
        this.f6421m = i3;
        Set<Integer> set = Z;
        this.f6433y = new HashSet(set.size());
        this.f6434z = new SparseIntArray(set.size());
        this.f6431w = new HlsSampleQueue[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.f6423o = arrayList;
        this.f6424p = Collections.unmodifiableList(arrayList);
        this.f6428t = new ArrayList<>();
        this.f6425q = new d(this);
        this.f6426r = new e(this);
        this.f6427s = Util.A();
        this.Q = j2;
        this.R = j2;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void A() {
        Format format;
        int i2;
        Format format2;
        Format format3;
        int length = this.f6431w.length;
        boolean z2 = false;
        int i3 = 0;
        int i4 = -2;
        int i5 = -1;
        while (true) {
            int i6 = 2;
            if (i3 >= length) {
                break;
            }
            String str = ((Format) Assertions.j(this.f6431w[i3].G())).f4015n;
            if (!MimeTypes.s(str)) {
                if (MimeTypes.o(str)) {
                    i6 = 1;
                } else if (MimeTypes.r(str)) {
                    i6 = 3;
                } else {
                    i6 = -2;
                }
            }
            if (N(i6) > N(i4)) {
                i5 = i3;
                i4 = i6;
            } else if (i6 == i4 && i5 != -1) {
                i5 = -1;
            }
            i3++;
        }
        TrackGroup k2 = this.f6413e.k();
        int i7 = k2.f4390a;
        this.M = -1;
        this.L = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            this.L[i8] = i8;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i9 = 0; i9 < length; i9++) {
            Format format4 = (Format) Assertions.j(this.f6431w[i9].G());
            if (i9 == i5) {
                Format[] formatArr = new Format[i7];
                for (int i10 = 0; i10 < i7; i10++) {
                    Format a2 = k2.a(i10);
                    if (i4 == 1 && (format3 = this.f6415g) != null) {
                        a2 = a2.h(format3);
                    }
                    if (i7 == 1) {
                        format2 = format4.h(a2);
                    } else {
                        format2 = G(a2, format4, true);
                    }
                    formatArr[i10] = format2;
                }
                trackGroupArr[i9] = new TrackGroup(this.f6410b, formatArr);
                this.M = i9;
            } else {
                if (i4 != 2 || !MimeTypes.o(format4.f4015n)) {
                    format = null;
                } else {
                    format = this.f6415g;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f6410b);
                sb.append(":muxed:");
                if (i9 < i5) {
                    i2 = i9;
                } else {
                    i2 = i9 - 1;
                }
                sb.append(i2);
                trackGroupArr[i9] = new TrackGroup(sb.toString(), G(format, format4, false));
            }
        }
        this.J = F(trackGroupArr);
        if (this.K == null) {
            z2 = true;
        }
        Assertions.h(z2);
        this.K = Collections.emptySet();
    }

    private boolean B(int i2) {
        for (int i3 = i2; i3 < this.f6423o.size(); i3++) {
            if (this.f6423o.get(i3).f6341n) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = this.f6423o.get(i2);
        for (int i4 = 0; i4 < this.f6431w.length; i4++) {
            if (this.f6431w[i4].D() > hlsMediaChunk.m(i4)) {
                return false;
            }
        }
        return true;
    }

    private static DiscardingTrackOutput D(int i2, int i3) {
        Log.h("HlsSampleStreamWrapper", "Unmapped track with id " + i2 + " of type " + i3);
        return new DiscardingTrackOutput();
    }

    private SampleQueue E(int i2, int i3) {
        int length = this.f6431w.length;
        boolean z2 = true;
        if (!(i3 == 1 || i3 == 2)) {
            z2 = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.f6414f, this.f6416h, this.f6417i, this.f6429u);
        hlsSampleQueue.c0(this.Q);
        if (z2) {
            hlsSampleQueue.j0(this.X);
        }
        hlsSampleQueue.b0(this.W);
        HlsMediaChunk hlsMediaChunk = this.Y;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.k0(hlsMediaChunk);
        }
        hlsSampleQueue.e0(this);
        int i4 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f6432x, i4);
        this.f6432x = copyOf;
        copyOf[length] = i2;
        this.f6431w = (HlsSampleQueue[]) Util.S0(this.f6431w, hlsSampleQueue);
        boolean[] copyOf2 = Arrays.copyOf(this.P, i4);
        this.P = copyOf2;
        copyOf2[length] = z2;
        this.N |= z2;
        this.f6433y.add(Integer.valueOf(i3));
        this.f6434z.append(i3, length);
        if (N(i3) > N(this.B)) {
            this.C = length;
            this.B = i3;
        }
        this.O = Arrays.copyOf(this.O, i4);
        return hlsSampleQueue;
    }

    private TrackGroupArray F(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.f4390a];
            for (int i3 = 0; i3 < trackGroup.f4390a; i3++) {
                Format a2 = trackGroup.a(i3);
                formatArr[i3] = a2.b(this.f6416h.c(a2));
            }
            trackGroupArr[i2] = new TrackGroup(trackGroup.f4391b, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static Format G(Format format, Format format2, boolean z2) {
        String str;
        String str2;
        int i2;
        int i3;
        if (format == null) {
            return format2;
        }
        int k2 = MimeTypes.k(format2.f4015n);
        if (Util.P(format.f4011j, k2) == 1) {
            str2 = Util.Q(format.f4011j, k2);
            str = MimeTypes.g(str2);
        } else {
            str2 = MimeTypes.d(format.f4011j, format2.f4015n);
            str = format2.f4015n;
        }
        Format.Builder m02 = format2.a().a0(format.f4002a).c0(format.f4003b).d0(format.f4004c).e0(format.f4005d).q0(format.f4006e).m0(format.f4007f);
        if (z2) {
            i2 = format.f4008g;
        } else {
            i2 = -1;
        }
        Format.Builder M2 = m02.M(i2);
        if (z2) {
            i3 = format.f4009h;
        } else {
            i3 = -1;
        }
        Format.Builder O2 = M2.j0(i3).O(str2);
        if (k2 == 2) {
            O2.v0(format.f4021t).Y(format.f4022u).X(format.f4023v);
        }
        if (str != null) {
            O2.o0(str);
        }
        int i4 = format.B;
        if (i4 != -1 && k2 == 1) {
            O2.N(i4);
        }
        Metadata metadata = format.f4012k;
        if (metadata != null) {
            Metadata metadata2 = format2.f4012k;
            if (metadata2 != null) {
                metadata = metadata2.c(metadata);
            }
            O2.h0(metadata);
        }
        return O2.K();
    }

    private void H(int i2) {
        Assertions.h(!this.f6419k.j());
        while (true) {
            if (i2 >= this.f6423o.size()) {
                i2 = -1;
                break;
            } else if (B(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            long j2 = L().f7224h;
            HlsMediaChunk I2 = I(i2);
            if (this.f6423o.isEmpty()) {
                this.R = this.Q;
            } else {
                ((HlsMediaChunk) Iterables.d(this.f6423o)).o();
            }
            this.U = false;
            this.f6420l.C(this.B, I2.f7223g, j2);
        }
    }

    private HlsMediaChunk I(int i2) {
        HlsMediaChunk hlsMediaChunk = this.f6423o.get(i2);
        ArrayList<HlsMediaChunk> arrayList = this.f6423o;
        Util.a1(arrayList, i2, arrayList.size());
        for (int i3 = 0; i3 < this.f6431w.length; i3++) {
            this.f6431w[i3].u(hlsMediaChunk.m(i3));
        }
        return hlsMediaChunk;
    }

    private boolean J(HlsMediaChunk hlsMediaChunk) {
        int i2 = hlsMediaChunk.f6338k;
        int length = this.f6431w.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.O[i3] && this.f6431w[i3].R() == ((long) i2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean K(Format format, Format format2) {
        String str = format.f4015n;
        String str2 = format2.f4015n;
        int k2 = MimeTypes.k(str);
        if (k2 != 3) {
            if (k2 == MimeTypes.k(str2)) {
                return true;
            }
            return false;
        } else if (!Util.c(str, str2)) {
            return false;
        } else {
            if (("application/cea-608".equals(str) || "application/cea-708".equals(str)) && format.G != format2.G) {
                return false;
            }
            return true;
        }
    }

    private HlsMediaChunk L() {
        ArrayList<HlsMediaChunk> arrayList = this.f6423o;
        return arrayList.get(arrayList.size() - 1);
    }

    private TrackOutput M(int i2, int i3) {
        Assertions.a(Z.contains(Integer.valueOf(i3)));
        int i4 = this.f6434z.get(i3, -1);
        if (i4 == -1) {
            return null;
        }
        if (this.f6433y.add(Integer.valueOf(i3))) {
            this.f6432x[i4] = i2;
        }
        if (this.f6432x[i4] == i2) {
            return this.f6431w[i4];
        }
        return D(i2, i3);
    }

    private static int N(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void O(HlsMediaChunk hlsMediaChunk) {
        this.Y = hlsMediaChunk;
        this.G = hlsMediaChunk.f7220d;
        this.R = -9223372036854775807L;
        this.f6423o.add(hlsMediaChunk);
        ImmutableList.Builder k2 = ImmutableList.k();
        for (HlsSampleQueue H2 : this.f6431w) {
            k2.d(Integer.valueOf(H2.H()));
        }
        hlsMediaChunk.n(this, k2.k());
        for (HlsSampleQueue hlsSampleQueue : this.f6431w) {
            hlsSampleQueue.k0(hlsMediaChunk);
            if (hlsMediaChunk.f6341n) {
                hlsSampleQueue.h0();
            }
        }
    }

    private static boolean P(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean Q() {
        return this.R != -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(HlsMediaChunk hlsMediaChunk) {
        this.f6412d.k(hlsMediaChunk.f6340m);
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void U() {
        int i2 = this.J.f7178a;
        int[] iArr = new int[i2];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.f6431w;
                if (i4 >= hlsSampleQueueArr.length) {
                    break;
                } else if (K((Format) Assertions.j(hlsSampleQueueArr[i4].G()), this.J.b(i3).a(0))) {
                    this.L[i3] = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        Iterator<HlsSampleStream> it2 = this.f6428t.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    /* access modifiers changed from: private */
    public void V() {
        if (!this.I && this.L == null && this.D) {
            HlsSampleQueue[] hlsSampleQueueArr = this.f6431w;
            int length = hlsSampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (hlsSampleQueueArr[i2].G() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.J != null) {
                U();
                return;
            }
            A();
            n0();
            this.f6412d.a();
        }
    }

    /* access modifiers changed from: private */
    public void e0() {
        this.D = true;
        V();
    }

    private void i0() {
        for (HlsSampleQueue X2 : this.f6431w) {
            X2.X(this.S);
        }
        this.S = false;
    }

    private boolean j0(long j2, HlsMediaChunk hlsMediaChunk) {
        boolean z2;
        int length = this.f6431w.length;
        for (int i2 = 0; i2 < length; i2++) {
            HlsSampleQueue hlsSampleQueue = this.f6431w[i2];
            if (hlsMediaChunk != null) {
                z2 = hlsSampleQueue.Z(hlsMediaChunk.m(i2));
            } else {
                z2 = hlsSampleQueue.a0(j2, false);
            }
            if (!z2 && (this.P[i2] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void n0() {
        this.E = true;
    }

    private void s0(SampleStream[] sampleStreamArr) {
        this.f6428t.clear();
        for (HlsSampleStream hlsSampleStream : sampleStreamArr) {
            if (hlsSampleStream != null) {
                this.f6428t.add(hlsSampleStream);
            }
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void y() {
        Assertions.h(this.E);
        Assertions.f(this.J);
        Assertions.f(this.K);
    }

    public void C() {
        if (!this.E) {
            g(new LoadingInfo.Builder().f(this.Q).d());
        }
    }

    public boolean R(int i2) {
        return !Q() && this.f6431w[i2].L(this.U);
    }

    public boolean S() {
        return this.B == 2;
    }

    public void W() throws IOException {
        this.f6419k.a();
        this.f6413e.p();
    }

    public void X(int i2) throws IOException {
        W();
        this.f6431w[i2].O();
    }

    /* renamed from: Y */
    public void u(Chunk chunk, long j2, long j3, boolean z2) {
        Chunk chunk2 = chunk;
        this.f6430v = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f7217a, chunk2.f7218b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f6418j.b(chunk2.f7217a);
        this.f6420l.q(loadEventInfo, chunk2.f7219c, this.f6411c, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, chunk2.f7223g, chunk2.f7224h);
        if (!z2) {
            if (Q() || this.F == 0) {
                i0();
            }
            if (this.F > 0) {
                this.f6412d.p(this);
            }
        }
    }

    /* renamed from: Z */
    public void t(Chunk chunk, long j2, long j3) {
        Chunk chunk2 = chunk;
        this.f6430v = null;
        this.f6413e.r(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f7217a, chunk2.f7218b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f6418j.b(chunk2.f7217a);
        this.f6420l.t(loadEventInfo, chunk2.f7219c, this.f6411c, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, chunk2.f7223g, chunk2.f7224h);
        if (!this.E) {
            g(new LoadingInfo.Builder().f(this.Q).d());
        } else {
            this.f6412d.p(this);
        }
    }

    public void a(Format format) {
        this.f6427s.post(this.f6425q);
    }

    /* renamed from: a0 */
    public Loader.LoadErrorAction p(Chunk chunk, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        Loader.LoadErrorAction loadErrorAction;
        int i3;
        Chunk chunk2 = chunk;
        IOException iOException2 = iOException;
        boolean P2 = P(chunk);
        if (P2 && !((HlsMediaChunk) chunk2).q() && (iOException2 instanceof HttpDataSource$InvalidResponseCodeException) && ((i3 = ((HttpDataSource$InvalidResponseCodeException) iOException2).f4892e) == 410 || i3 == 404)) {
            return Loader.f7532d;
        }
        long c2 = chunk.c();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f7217a, chunk2.f7218b, chunk.f(), chunk.e(), j2, j3, c2);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk2.f7219c, this.f6411c, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, Util.t1(chunk2.f7223g), Util.t1(chunk2.f7224h)), iOException2, i2);
        LoadErrorHandlingPolicy.FallbackSelection d2 = this.f6418j.d(TrackSelectionUtil.c(this.f6413e.l()), loadErrorInfo);
        boolean z3 = false;
        if (d2 == null || d2.f7526a != 2) {
            z2 = false;
        } else {
            z2 = this.f6413e.o(chunk2, d2.f7527b);
        }
        if (z2) {
            if (P2 && c2 == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.f6423o;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z3 = true;
                }
                Assertions.h(z3);
                if (this.f6423o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((HlsMediaChunk) Iterables.d(this.f6423o)).o();
                }
            }
            loadErrorAction = Loader.f7534f;
        } else {
            long c3 = this.f6418j.c(loadErrorInfo);
            if (c3 != -9223372036854775807L) {
                loadErrorAction = Loader.h(false, c3);
            } else {
                loadErrorAction = Loader.f7535g;
            }
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z4 = !loadErrorAction2.c();
        this.f6420l.v(loadEventInfo, chunk2.f7219c, this.f6411c, chunk2.f7220d, chunk2.f7221e, chunk2.f7222f, chunk2.f7223g, chunk2.f7224h, iOException, z4);
        if (z4) {
            this.f6430v = null;
            this.f6418j.b(chunk2.f7217a);
        }
        if (z2) {
            if (!this.E) {
                g(new LoadingInfo.Builder().f(this.Q).d());
            } else {
                this.f6412d.p(this);
            }
        }
        return loadErrorAction2;
    }

    public long b() {
        if (Q()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return L().f7224h;
    }

    public void b0() {
        this.f6433y.clear();
    }

    public boolean c() {
        return this.f6419k.j();
    }

    public boolean c0(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        long j2;
        LoadErrorHandlingPolicy.FallbackSelection d2;
        if (!this.f6413e.q(uri)) {
            return true;
        }
        if (z2 || (d2 = this.f6418j.d(TrackSelectionUtil.c(this.f6413e.l()), loadErrorInfo)) == null || d2.f7526a != 2) {
            j2 = -9223372036854775807L;
        } else {
            j2 = d2.f7527b;
        }
        if (!this.f6413e.s(uri, j2) || j2 == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    public TrackOutput d(int i2, int i3) {
        TrackOutput trackOutput;
        if (!Z.contains(Integer.valueOf(i3))) {
            int i4 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.f6431w;
                if (i4 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.f6432x[i4] == i2) {
                    trackOutput = trackOutputArr[i4];
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            trackOutput = M(i2, i3);
        }
        if (trackOutput == null) {
            if (this.V) {
                return D(i2, i3);
            }
            trackOutput = E(i2, i3);
        }
        if (i3 != 5) {
            return trackOutput;
        }
        if (this.A == null) {
            this.A = new EmsgUnwrappingTrackOutput(trackOutput, this.f6421m);
        }
        return this.A;
    }

    public void d0() {
        if (!this.f6423o.isEmpty()) {
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.d(this.f6423o);
            int d2 = this.f6413e.d(hlsMediaChunk);
            if (d2 == 1) {
                hlsMediaChunk.v();
            } else if (d2 == 0) {
                this.f6427s.post(new c(this, hlsMediaChunk));
            } else if (d2 == 2 && !this.U && this.f6419k.j()) {
                this.f6419k.f();
            }
        }
    }

    public long e() {
        if (this.U) {
            return Long.MIN_VALUE;
        }
        if (Q()) {
            return this.R;
        }
        long j2 = this.Q;
        HlsMediaChunk L2 = L();
        if (!L2.h()) {
            if (this.f6423o.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.f6423o;
                L2 = arrayList.get(arrayList.size() - 2);
            } else {
                L2 = null;
            }
        }
        if (L2 != null) {
            j2 = Math.max(j2, L2.f7224h);
        }
        if (this.D) {
            for (HlsSampleQueue A2 : this.f6431w) {
                j2 = Math.max(j2, A2.A());
            }
        }
        return j2;
    }

    public void f(long j2) {
        if (!this.f6419k.i() && !Q()) {
            if (this.f6419k.j()) {
                Assertions.f(this.f6430v);
                if (this.f6413e.x(j2, this.f6430v, this.f6424p)) {
                    this.f6419k.f();
                    return;
                }
                return;
            }
            int size = this.f6424p.size();
            while (size > 0 && this.f6413e.d(this.f6424p.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.f6424p.size()) {
                H(size);
            }
            int i2 = this.f6413e.i(j2, this.f6424p);
            if (i2 < this.f6423o.size()) {
                H(i2);
            }
        }
    }

    public void f0(TrackGroup[] trackGroupArr, int i2, int... iArr) {
        this.J = F(trackGroupArr);
        this.K = new HashSet();
        for (int b2 : iArr) {
            this.K.add(this.J.b(b2));
        }
        this.M = i2;
        Handler handler = this.f6427s;
        Callback callback = this.f6412d;
        Objects.requireNonNull(callback);
        handler.post(new b(callback));
        n0();
    }

    public boolean g(LoadingInfo loadingInfo) {
        long j2;
        List<HlsMediaChunk> list;
        boolean z2;
        if (this.U || this.f6419k.j() || this.f6419k.i()) {
            return false;
        }
        if (Q()) {
            list = Collections.emptyList();
            j2 = this.R;
            for (HlsSampleQueue c02 : this.f6431w) {
                c02.c0(this.R);
            }
        } else {
            list = this.f6424p;
            HlsMediaChunk L2 = L();
            if (L2.h()) {
                j2 = L2.f7224h;
            } else {
                j2 = Math.max(this.Q, L2.f7223g);
            }
        }
        List<HlsMediaChunk> list2 = list;
        long j3 = j2;
        this.f6422n.a();
        HlsChunkSource hlsChunkSource = this.f6413e;
        if (this.E || !list2.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        hlsChunkSource.f(loadingInfo, j3, list2, z2, this.f6422n);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.f6422n;
        boolean z3 = hlsChunkHolder.f6325b;
        Chunk chunk = hlsChunkHolder.f6324a;
        Uri uri = hlsChunkHolder.f6326c;
        if (z3) {
            this.R = -9223372036854775807L;
            this.U = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.f6412d.k(uri);
            }
            return false;
        } else {
            if (P(chunk)) {
                O((HlsMediaChunk) chunk);
            }
            this.f6430v = chunk;
            this.f6420l.z(new LoadEventInfo(chunk.f7217a, chunk.f7218b, this.f6419k.n(chunk, this, this.f6418j.a(chunk.f7219c))), chunk.f7219c, this.f6411c, chunk.f7220d, chunk.f7221e, chunk.f7222f, chunk.f7223g, chunk.f7224h);
            return true;
        }
    }

    public int g0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        Format format;
        if (Q()) {
            return -3;
        }
        int i4 = 0;
        if (!this.f6423o.isEmpty()) {
            int i5 = 0;
            while (i5 < this.f6423o.size() - 1 && J(this.f6423o.get(i5))) {
                i5++;
            }
            Util.a1(this.f6423o, 0, i5);
            HlsMediaChunk hlsMediaChunk = this.f6423o.get(0);
            Format format2 = hlsMediaChunk.f7220d;
            if (!format2.equals(this.H)) {
                this.f6420l.h(this.f6411c, format2, hlsMediaChunk.f7221e, hlsMediaChunk.f7222f, hlsMediaChunk.f7223g);
            }
            this.H = format2;
        }
        if (!this.f6423o.isEmpty() && !this.f6423o.get(0).q()) {
            return -3;
        }
        int T2 = this.f6431w[i2].T(formatHolder, decoderInputBuffer, i3, this.U);
        if (T2 == -5) {
            Format format3 = (Format) Assertions.f(formatHolder.f5385b);
            if (i2 == this.C) {
                int d2 = Ints.d(this.f6431w[i2].R());
                while (i4 < this.f6423o.size() && this.f6423o.get(i4).f6338k != d2) {
                    i4++;
                }
                if (i4 < this.f6423o.size()) {
                    format = this.f6423o.get(i4).f7220d;
                } else {
                    format = (Format) Assertions.f(this.G);
                }
                format3 = format3.h(format);
            }
            formatHolder.f5385b = format3;
        }
        return T2;
    }

    public long h(long j2, SeekParameters seekParameters) {
        return this.f6413e.c(j2, seekParameters);
    }

    public void h0() {
        if (this.E) {
            for (HlsSampleQueue S2 : this.f6431w) {
                S2.S();
            }
        }
        this.f6413e.t();
        this.f6419k.m(this);
        this.f6427s.removeCallbacksAndMessages((Object) null);
        this.I = true;
        this.f6428t.clear();
    }

    public void k() {
        for (HlsSampleQueue U2 : this.f6431w) {
            U2.U();
        }
    }

    public boolean k0(long j2, boolean z2) {
        HlsMediaChunk hlsMediaChunk;
        this.Q = j2;
        if (Q()) {
            this.R = j2;
            return true;
        }
        if (this.f6413e.m()) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f6423o.size()) {
                    break;
                }
                hlsMediaChunk = this.f6423o.get(i2);
                if (hlsMediaChunk.f7223g == j2) {
                    break;
                }
                i2++;
            }
        }
        hlsMediaChunk = null;
        if (this.D && !z2 && j0(j2, hlsMediaChunk)) {
            return false;
        }
        this.R = j2;
        this.U = false;
        this.f6423o.clear();
        if (this.f6419k.j()) {
            if (this.D) {
                for (HlsSampleQueue r2 : this.f6431w) {
                    r2.r();
                }
            }
            this.f6419k.f();
        } else {
            this.f6419k.g();
            i0();
        }
        return true;
    }

    public void l() throws IOException {
        W();
        if (this.U && !this.E) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l0(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r20, boolean[] r21, androidx.media3.exoplayer.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.y()
            int r3 = r0.F
            r14 = 0
            r4 = 0
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            androidx.media3.exoplayer.hls.HlsSampleStream r5 = (androidx.media3.exoplayer.hls.HlsSampleStream) r5
            if (r5 == 0) goto L_0x002c
            r7 = r1[r4]
            if (r7 == 0) goto L_0x0022
            boolean r7 = r21[r4]
            if (r7 != 0) goto L_0x002c
        L_0x0022:
            int r7 = r0.F
            int r7 = r7 - r15
            r0.F = r7
            r5.e()
            r2[r4] = r6
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002f:
            if (r26 != 0) goto L_0x0041
            boolean r4 = r0.T
            if (r4 == 0) goto L_0x0038
            if (r3 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r3 = r0.Q
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            androidx.media3.exoplayer.hls.HlsChunkSource r4 = r0.f6413e
            androidx.media3.exoplayer.trackselection.ExoTrackSelection r4 = r4.l()
            r16 = r3
            r11 = r4
            r3 = 0
        L_0x004c:
            int r5 = r1.length
            if (r3 >= r5) goto L_0x009f
            r5 = r1[r3]
            if (r5 != 0) goto L_0x0054
            goto L_0x009c
        L_0x0054:
            androidx.media3.exoplayer.source.TrackGroupArray r7 = r0.J
            androidx.media3.common.TrackGroup r8 = r5.h()
            int r7 = r7.d(r8)
            int r8 = r0.M
            if (r7 != r8) goto L_0x0068
            androidx.media3.exoplayer.hls.HlsChunkSource r8 = r0.f6413e
            r8.w(r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x009c
            int r5 = r0.F
            int r5 = r5 + r15
            r0.F = r5
            androidx.media3.exoplayer.hls.HlsSampleStream r5 = new androidx.media3.exoplayer.hls.HlsSampleStream
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r8 = r0.L
            if (r8 == 0) goto L_0x009c
            r5.b()
            if (r16 != 0) goto L_0x009c
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r5 = r0.f6431w
            int[] r8 = r0.L
            r7 = r8[r7]
            r5 = r5[r7]
            int r7 = r5.D()
            if (r7 == 0) goto L_0x0099
            boolean r5 = r5.a0(r12, r15)
            if (r5 != 0) goto L_0x0099
            r5 = 1
            goto L_0x009a
        L_0x0099:
            r5 = 0
        L_0x009a:
            r16 = r5
        L_0x009c:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x009f:
            int r1 = r0.F
            if (r1 != 0) goto L_0x00d6
            androidx.media3.exoplayer.hls.HlsChunkSource r1 = r0.f6413e
            r1.t()
            r0.H = r6
            r0.S = r15
            java.util.ArrayList<androidx.media3.exoplayer.hls.HlsMediaChunk> r1 = r0.f6423o
            r1.clear()
            androidx.media3.exoplayer.upstream.Loader r1 = r0.f6419k
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x00d1
            boolean r1 = r0.D
            if (r1 == 0) goto L_0x00ca
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r1 = r0.f6431w
            int r3 = r1.length
        L_0x00c0:
            if (r14 >= r3) goto L_0x00ca
            r4 = r1[r14]
            r4.r()
            int r14 = r14 + 1
            goto L_0x00c0
        L_0x00ca:
            androidx.media3.exoplayer.upstream.Loader r1 = r0.f6419k
            r1.f()
            goto L_0x013c
        L_0x00d1:
            r19.i0()
            goto L_0x013c
        L_0x00d6:
            java.util.ArrayList<androidx.media3.exoplayer.hls.HlsMediaChunk> r1 = r0.f6423o
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0129
            boolean r1 = androidx.media3.common.util.Util.c(r11, r4)
            if (r1 != 0) goto L_0x0129
            boolean r1 = r0.T
            if (r1 != 0) goto L_0x0120
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ef
            long r3 = -r12
        L_0x00ef:
            r6 = r3
            androidx.media3.exoplayer.hls.HlsMediaChunk r1 = r19.L()
            androidx.media3.exoplayer.hls.HlsChunkSource r3 = r0.f6413e
            androidx.media3.exoplayer.source.chunk.MediaChunkIterator[] r17 = r3.a(r1, r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<androidx.media3.exoplayer.hls.HlsMediaChunk> r10 = r0.f6424p
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.q(r4, r6, r8, r10, r11)
            androidx.media3.exoplayer.hls.HlsChunkSource r3 = r0.f6413e
            androidx.media3.common.TrackGroup r3 = r3.k()
            androidx.media3.common.Format r1 = r1.f7220d
            int r1 = r3.b(r1)
            int r3 = r18.k()
            if (r3 == r1) goto L_0x011e
            goto L_0x0120
        L_0x011e:
            r1 = 0
            goto L_0x0121
        L_0x0120:
            r1 = 1
        L_0x0121:
            if (r1 == 0) goto L_0x0129
            r0.S = r15
            r1 = 1
            r16 = 1
            goto L_0x012b
        L_0x0129:
            r1 = r26
        L_0x012b:
            if (r16 == 0) goto L_0x013c
            r0.k0(r12, r1)
        L_0x0130:
            int r1 = r2.length
            if (r14 >= r1) goto L_0x013c
            r1 = r2[r14]
            if (r1 == 0) goto L_0x0139
            r23[r14] = r15
        L_0x0139:
            int r14 = r14 + 1
            goto L_0x0130
        L_0x013c:
            r0.s0(r2)
            r0.T = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStreamWrapper.l0(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void m() {
        this.V = true;
        this.f6427s.post(this.f6426r);
    }

    public void m0(DrmInitData drmInitData) {
        if (!Util.c(this.X, drmInitData)) {
            this.X = drmInitData;
            int i2 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.f6431w;
                if (i2 < hlsSampleQueueArr.length) {
                    if (this.P[i2]) {
                        hlsSampleQueueArr[i2].j0(drmInitData);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public TrackGroupArray n() {
        y();
        return this.J;
    }

    public void o(long j2, boolean z2) {
        if (this.D && !Q()) {
            int length = this.f6431w.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f6431w[i2].q(j2, z2, this.O[i2]);
            }
        }
    }

    public void o0(boolean z2) {
        this.f6413e.v(z2);
    }

    public void p0(long j2) {
        if (this.W != j2) {
            this.W = j2;
            for (HlsSampleQueue b02 : this.f6431w) {
                b02.b0(j2);
            }
        }
    }

    public int q0(int i2, long j2) {
        if (Q()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.f6431w[i2];
        int F2 = hlsSampleQueue.F(j2, this.U);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.e(this.f6423o, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.q()) {
            F2 = Math.min(F2, hlsMediaChunk.m(i2) - hlsSampleQueue.D());
        }
        hlsSampleQueue.f0(F2);
        return F2;
    }

    public void r(SeekMap seekMap) {
    }

    public void r0(int i2) {
        y();
        Assertions.f(this.L);
        int i3 = this.L[i2];
        Assertions.h(this.O[i3]);
        this.O[i3] = false;
    }

    public int z(int i2) {
        y();
        Assertions.f(this.L);
        int i3 = this.L[i2];
        if (i3 != -1) {
            boolean[] zArr = this.O;
            if (zArr[i3]) {
                return -2;
            }
            zArr[i3] = true;
            return i3;
        } else if (this.K.contains(this.J.b(i2))) {
            return -3;
        } else {
            return -2;
        }
    }
}
