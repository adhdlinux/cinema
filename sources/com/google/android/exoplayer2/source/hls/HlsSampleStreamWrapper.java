package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.f;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
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
    private final String f26498b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26499c;

    /* renamed from: d  reason: collision with root package name */
    private final Callback f26500d;

    /* renamed from: e  reason: collision with root package name */
    private final HlsChunkSource f26501e;

    /* renamed from: f  reason: collision with root package name */
    private final Allocator f26502f;

    /* renamed from: g  reason: collision with root package name */
    private final Format f26503g;

    /* renamed from: h  reason: collision with root package name */
    private final DrmSessionManager f26504h;

    /* renamed from: i  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f26505i;

    /* renamed from: j  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26506j;

    /* renamed from: k  reason: collision with root package name */
    private final Loader f26507k = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: l  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f26508l;

    /* renamed from: m  reason: collision with root package name */
    private final int f26509m;

    /* renamed from: n  reason: collision with root package name */
    private final HlsChunkSource.HlsChunkHolder f26510n = new HlsChunkSource.HlsChunkHolder();

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList<HlsMediaChunk> f26511o;

    /* renamed from: p  reason: collision with root package name */
    private final List<HlsMediaChunk> f26512p;

    /* renamed from: q  reason: collision with root package name */
    private final Runnable f26513q;

    /* renamed from: r  reason: collision with root package name */
    private final Runnable f26514r;

    /* renamed from: s  reason: collision with root package name */
    private final Handler f26515s;

    /* renamed from: t  reason: collision with root package name */
    private final ArrayList<HlsSampleStream> f26516t;

    /* renamed from: u  reason: collision with root package name */
    private final Map<String, DrmInitData> f26517u;

    /* renamed from: v  reason: collision with root package name */
    private Chunk f26518v;

    /* renamed from: w  reason: collision with root package name */
    private HlsSampleQueue[] f26519w;

    /* renamed from: x  reason: collision with root package name */
    private int[] f26520x = new int[0];

    /* renamed from: y  reason: collision with root package name */
    private Set<Integer> f26521y;

    /* renamed from: z  reason: collision with root package name */
    private SparseIntArray f26522z;

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void a();

        void k(Uri uri);
    }

    private static class EmsgUnwrappingTrackOutput implements TrackOutput {

        /* renamed from: g  reason: collision with root package name */
        private static final Format f26523g = new Format.Builder().g0("application/id3").G();

        /* renamed from: h  reason: collision with root package name */
        private static final Format f26524h = new Format.Builder().g0("application/x-emsg").G();

        /* renamed from: a  reason: collision with root package name */
        private final EventMessageDecoder f26525a = new EventMessageDecoder();

        /* renamed from: b  reason: collision with root package name */
        private final TrackOutput f26526b;

        /* renamed from: c  reason: collision with root package name */
        private final Format f26527c;

        /* renamed from: d  reason: collision with root package name */
        private Format f26528d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f26529e;

        /* renamed from: f  reason: collision with root package name */
        private int f26530f;

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput, int i2) {
            this.f26526b = trackOutput;
            if (i2 == 1) {
                this.f26527c = f26523g;
            } else if (i2 == 3) {
                this.f26527c = f26524h;
            } else {
                throw new IllegalArgumentException("Unknown metadataType: " + i2);
            }
            this.f26529e = new byte[0];
            this.f26530f = 0;
        }

        private boolean g(EventMessage eventMessage) {
            Format D = eventMessage.D();
            if (D == null || !Util.c(this.f26527c.f23071m, D.f23071m)) {
                return false;
            }
            return true;
        }

        private void h(int i2) {
            byte[] bArr = this.f26529e;
            if (bArr.length < i2) {
                this.f26529e = Arrays.copyOf(bArr, i2 + (i2 / 2));
            }
        }

        private ParsableByteArray i(int i2, int i3) {
            int i4 = this.f26530f - i3;
            ParsableByteArray parsableByteArray = new ParsableByteArray(Arrays.copyOfRange(this.f26529e, i4 - i2, i4));
            byte[] bArr = this.f26529e;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.f26530f = i3;
            return parsableByteArray;
        }

        public int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
            h(this.f26530f + i2);
            int read = dataReader.read(this.f26529e, this.f26530f, i2);
            if (read != -1) {
                this.f26530f += read;
                return read;
            } else if (z2) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
            return f.a(this, dataReader, i2, z2);
        }

        public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i2) {
            f.b(this, parsableByteArray, i2);
        }

        public void d(Format format) {
            this.f26528d = format;
            this.f26526b.d(this.f26527c);
        }

        public void e(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            Assertions.e(this.f26528d);
            ParsableByteArray i5 = i(i3, i4);
            if (!Util.c(this.f26528d.f23071m, this.f26527c.f23071m)) {
                if ("application/x-emsg".equals(this.f26528d.f23071m)) {
                    EventMessage c2 = this.f26525a.c(i5);
                    if (!g(c2)) {
                        Log.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.f26527c.f23071m, c2.D()}));
                        return;
                    }
                    i5 = new ParsableByteArray((byte[]) Assertions.e(c2.E()));
                } else {
                    Log.i("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.f26528d.f23071m);
                    return;
                }
            }
            int a2 = i5.a();
            this.f26526b.c(i5, a2);
            this.f26526b.e(j2, i2, a2, i4, cryptoData);
        }

        public void f(ParsableByteArray parsableByteArray, int i2, int i3) {
            h(this.f26530f + i2);
            parsableByteArray.l(this.f26529e, this.f26530f, i2);
            this.f26530f += i2;
        }
    }

    private static final class HlsSampleQueue extends SampleQueue {
        private final Map<String, DrmInitData> H;
        private DrmInitData I;

        private Metadata h0(Metadata metadata) {
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
                if ((e2 instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) e2).f25437c)) {
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

        public void e(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
            super.e(j2, i2, i3, i4, cryptoData);
        }

        public void i0(DrmInitData drmInitData) {
            this.I = drmInitData;
            I();
        }

        public void j0(HlsMediaChunk hlsMediaChunk) {
            f0(hlsMediaChunk.f26428k);
        }

        public Format w(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = format.f23074p;
            }
            if (!(drmInitData2 == null || (drmInitData = this.H.get(drmInitData2.f24077d)) == null)) {
                drmInitData2 = drmInitData;
            }
            Metadata h02 = h0(format.f23069k);
            if (!(drmInitData2 == format.f23074p && h02 == format.f23069k)) {
                format = format.b().O(drmInitData2).Z(h02).G();
            }
            return super.w(format);
        }

        private HlsSampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, Map<String, DrmInitData> map) {
            super(allocator, drmSessionManager, eventDispatcher);
            this.H = map;
        }
    }

    public HlsSampleStreamWrapper(String str, int i2, Callback callback, HlsChunkSource hlsChunkSource, Map<String, DrmInitData> map, Allocator allocator, long j2, Format format, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, int i3) {
        this.f26498b = str;
        this.f26499c = i2;
        this.f26500d = callback;
        this.f26501e = hlsChunkSource;
        this.f26517u = map;
        this.f26502f = allocator;
        this.f26503g = format;
        this.f26504h = drmSessionManager;
        this.f26505i = eventDispatcher;
        this.f26506j = loadErrorHandlingPolicy;
        this.f26508l = eventDispatcher2;
        this.f26509m = i3;
        Set<Integer> set = Z;
        this.f26521y = new HashSet(set.size());
        this.f26522z = new SparseIntArray(set.size());
        this.f26519w = new HlsSampleQueue[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList<HlsMediaChunk> arrayList = new ArrayList<>();
        this.f26511o = arrayList;
        this.f26512p = Collections.unmodifiableList(arrayList);
        this.f26516t = new ArrayList<>();
        this.f26513q = new b(this);
        this.f26514r = new c(this);
        this.f26515s = Util.w();
        this.Q = j2;
        this.R = j2;
    }

    private boolean A(int i2) {
        for (int i3 = i2; i3 < this.f26511o.size(); i3++) {
            if (this.f26511o.get(i3).f26431n) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = this.f26511o.get(i2);
        for (int i4 = 0; i4 < this.f26519w.length; i4++) {
            if (this.f26519w[i4].C() > hlsMediaChunk.m(i4)) {
                return false;
            }
        }
        return true;
    }

    private static DummyTrackOutput C(int i2, int i3) {
        Log.i("HlsSampleStreamWrapper", "Unmapped track with id " + i2 + " of type " + i3);
        return new DummyTrackOutput();
    }

    private SampleQueue D(int i2, int i3) {
        int length = this.f26519w.length;
        boolean z2 = true;
        if (!(i3 == 1 || i3 == 2)) {
            z2 = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.f26502f, this.f26504h, this.f26505i, this.f26517u);
        hlsSampleQueue.b0(this.Q);
        if (z2) {
            hlsSampleQueue.i0(this.X);
        }
        hlsSampleQueue.a0(this.W);
        HlsMediaChunk hlsMediaChunk = this.Y;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.j0(hlsMediaChunk);
        }
        hlsSampleQueue.d0(this);
        int i4 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f26520x, i4);
        this.f26520x = copyOf;
        copyOf[length] = i2;
        this.f26519w = (HlsSampleQueue[]) Util.I0(this.f26519w, hlsSampleQueue);
        boolean[] copyOf2 = Arrays.copyOf(this.P, i4);
        this.P = copyOf2;
        copyOf2[length] = z2;
        this.N |= z2;
        this.f26521y.add(Integer.valueOf(i3));
        this.f26522z.append(i3, length);
        if (M(i3) > M(this.B)) {
            this.C = length;
            this.B = i3;
        }
        this.O = Arrays.copyOf(this.O, i4);
        return hlsSampleQueue;
    }

    private TrackGroupArray E(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.f26002b];
            for (int i3 = 0; i3 < trackGroup.f26002b; i3++) {
                Format c2 = trackGroup.c(i3);
                formatArr[i3] = c2.c(this.f26504h.a(c2));
            }
            trackGroupArr[i2] = new TrackGroup(trackGroup.f26003c, formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static Format F(Format format, Format format2, boolean z2) {
        String str;
        String str2;
        int i2;
        int i3;
        if (format == null) {
            return format2;
        }
        int k2 = MimeTypes.k(format2.f23071m);
        if (Util.K(format.f23068j, k2) == 1) {
            str2 = Util.L(format.f23068j, k2);
            str = MimeTypes.g(str2);
        } else {
            str2 = MimeTypes.d(format.f23068j, format2.f23071m);
            str = format2.f23071m;
        }
        Format.Builder e02 = format2.b().U(format.f23060b).W(format.f23061c).X(format.f23062d).i0(format.f23063e).e0(format.f23064f);
        if (z2) {
            i2 = format.f23065g;
        } else {
            i2 = -1;
        }
        Format.Builder I2 = e02.I(i2);
        if (z2) {
            i3 = format.f23066h;
        } else {
            i3 = -1;
        }
        Format.Builder K2 = I2.b0(i3).K(str2);
        if (k2 == 2) {
            K2.n0(format.f23076r).S(format.f23077s).R(format.f23078t);
        }
        if (str != null) {
            K2.g0(str);
        }
        int i4 = format.f23084z;
        if (i4 != -1 && k2 == 1) {
            K2.J(i4);
        }
        Metadata metadata = format.f23069k;
        if (metadata != null) {
            Metadata metadata2 = format2.f23069k;
            if (metadata2 != null) {
                metadata = metadata2.c(metadata);
            }
            K2.Z(metadata);
        }
        return K2.G();
    }

    private void G(int i2) {
        Assertions.g(!this.f26507k.j());
        while (true) {
            if (i2 >= this.f26511o.size()) {
                i2 = -1;
                break;
            } else if (A(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            long j2 = K().f26085h;
            HlsMediaChunk H2 = H(i2);
            if (this.f26511o.isEmpty()) {
                this.R = this.Q;
            } else {
                ((HlsMediaChunk) Iterables.d(this.f26511o)).o();
            }
            this.U = false;
            this.f26508l.D(this.B, H2.f26084g, j2);
        }
    }

    private HlsMediaChunk H(int i2) {
        HlsMediaChunk hlsMediaChunk = this.f26511o.get(i2);
        ArrayList<HlsMediaChunk> arrayList = this.f26511o;
        Util.Q0(arrayList, i2, arrayList.size());
        for (int i3 = 0; i3 < this.f26519w.length; i3++) {
            this.f26519w[i3].u(hlsMediaChunk.m(i3));
        }
        return hlsMediaChunk;
    }

    private boolean I(HlsMediaChunk hlsMediaChunk) {
        int i2 = hlsMediaChunk.f26428k;
        int length = this.f26519w.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.O[i3] && this.f26519w[i3].Q() == i2) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(Format format, Format format2) {
        String str = format.f23071m;
        String str2 = format2.f23071m;
        int k2 = MimeTypes.k(str);
        if (k2 != 3) {
            if (k2 == MimeTypes.k(str2)) {
                return true;
            }
            return false;
        } else if (!Util.c(str, str2)) {
            return false;
        } else {
            if (("application/cea-608".equals(str) || "application/cea-708".equals(str)) && format.E != format2.E) {
                return false;
            }
            return true;
        }
    }

    private HlsMediaChunk K() {
        ArrayList<HlsMediaChunk> arrayList = this.f26511o;
        return arrayList.get(arrayList.size() - 1);
    }

    private TrackOutput L(int i2, int i3) {
        Assertions.a(Z.contains(Integer.valueOf(i3)));
        int i4 = this.f26522z.get(i3, -1);
        if (i4 == -1) {
            return null;
        }
        if (this.f26521y.add(Integer.valueOf(i3))) {
            this.f26520x[i4] = i2;
        }
        if (this.f26520x[i4] == i2) {
            return this.f26519w[i4];
        }
        return C(i2, i3);
    }

    private static int M(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void N(HlsMediaChunk hlsMediaChunk) {
        this.Y = hlsMediaChunk;
        this.G = hlsMediaChunk.f26081d;
        this.R = -9223372036854775807L;
        this.f26511o.add(hlsMediaChunk);
        ImmutableList.Builder k2 = ImmutableList.k();
        for (HlsSampleQueue G2 : this.f26519w) {
            k2.d(Integer.valueOf(G2.G()));
        }
        hlsMediaChunk.n(this, k2.k());
        for (HlsSampleQueue hlsSampleQueue : this.f26519w) {
            hlsSampleQueue.j0(hlsMediaChunk);
            if (hlsMediaChunk.f26431n) {
                hlsSampleQueue.g0();
            }
        }
    }

    private static boolean O(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean P() {
        return this.R != -9223372036854775807L;
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void S() {
        int i2 = this.J.f26010b;
        int[] iArr = new int[i2];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.f26519w;
                if (i4 >= hlsSampleQueueArr.length) {
                    break;
                } else if (J((Format) Assertions.i(hlsSampleQueueArr[i4].F()), this.J.b(i3).c(0))) {
                    this.L[i3] = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        Iterator<HlsSampleStream> it2 = this.f26516t.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    /* access modifiers changed from: private */
    public void T() {
        if (!this.I && this.L == null && this.D) {
            HlsSampleQueue[] hlsSampleQueueArr = this.f26519w;
            int length = hlsSampleQueueArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (hlsSampleQueueArr[i2].F() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.J != null) {
                S();
                return;
            }
            z();
            l0();
            this.f26500d.a();
        }
    }

    /* access modifiers changed from: private */
    public void c0() {
        this.D = true;
        T();
    }

    private void g0() {
        for (HlsSampleQueue W2 : this.f26519w) {
            W2.W(this.S);
        }
        this.S = false;
    }

    private boolean h0(long j2) {
        int length = this.f26519w.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.f26519w[i2].Z(j2, false) && (this.P[i2] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void l0() {
        this.E = true;
    }

    private void q0(SampleStream[] sampleStreamArr) {
        this.f26516t.clear();
        for (HlsSampleStream hlsSampleStream : sampleStreamArr) {
            if (hlsSampleStream != null) {
                this.f26516t.add(hlsSampleStream);
            }
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void x() {
        Assertions.g(this.E);
        Assertions.e(this.J);
        Assertions.e(this.K);
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void z() {
        Format format;
        int i2;
        Format format2;
        Format format3;
        int length = this.f26519w.length;
        boolean z2 = false;
        int i3 = 0;
        int i4 = -2;
        int i5 = -1;
        while (true) {
            int i6 = 2;
            if (i3 >= length) {
                break;
            }
            String str = ((Format) Assertions.i(this.f26519w[i3].F())).f23071m;
            if (!MimeTypes.s(str)) {
                if (MimeTypes.o(str)) {
                    i6 = 1;
                } else if (MimeTypes.r(str)) {
                    i6 = 3;
                } else {
                    i6 = -2;
                }
            }
            if (M(i6) > M(i4)) {
                i5 = i3;
                i4 = i6;
            } else if (i6 == i4 && i5 != -1) {
                i5 = -1;
            }
            i3++;
        }
        TrackGroup j2 = this.f26501e.j();
        int i7 = j2.f26002b;
        this.M = -1;
        this.L = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            this.L[i8] = i8;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i9 = 0; i9 < length; i9++) {
            Format format4 = (Format) Assertions.i(this.f26519w[i9].F());
            if (i9 == i5) {
                Format[] formatArr = new Format[i7];
                for (int i10 = 0; i10 < i7; i10++) {
                    Format c2 = j2.c(i10);
                    if (i4 == 1 && (format3 = this.f26503g) != null) {
                        c2 = c2.k(format3);
                    }
                    if (i7 == 1) {
                        format2 = format4.k(c2);
                    } else {
                        format2 = F(c2, format4, true);
                    }
                    formatArr[i10] = format2;
                }
                trackGroupArr[i9] = new TrackGroup(this.f26498b, formatArr);
                this.M = i9;
            } else {
                if (i4 != 2 || !MimeTypes.o(format4.f23071m)) {
                    format = null;
                } else {
                    format = this.f26503g;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f26498b);
                sb.append(":muxed:");
                if (i9 < i5) {
                    i2 = i9;
                } else {
                    i2 = i9 - 1;
                }
                sb.append(i2);
                trackGroupArr[i9] = new TrackGroup(sb.toString(), F(format, format4, false));
            }
        }
        this.J = E(trackGroupArr);
        if (this.K == null) {
            z2 = true;
        }
        Assertions.g(z2);
        this.K = Collections.emptySet();
    }

    public void B() {
        if (!this.E) {
            h(this.Q);
        }
    }

    public boolean Q(int i2) {
        return !P() && this.f26519w[i2].K(this.U);
    }

    public boolean R() {
        return this.B == 2;
    }

    public void U() throws IOException {
        this.f26507k.a();
        this.f26501e.n();
    }

    public void V(int i2) throws IOException {
        U();
        this.f26519w[i2].N();
    }

    /* renamed from: W */
    public void p(Chunk chunk, long j2, long j3, boolean z2) {
        Chunk chunk2 = chunk;
        this.f26518v = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f26078a, chunk2.f26079b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f26506j.b(chunk2.f26078a);
        this.f26508l.r(loadEventInfo, chunk2.f26080c, this.f26499c, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, chunk2.f26084g, chunk2.f26085h);
        if (!z2) {
            if (P() || this.F == 0) {
                g0();
            }
            if (this.F > 0) {
                this.f26500d.d(this);
            }
        }
    }

    /* renamed from: X */
    public void q(Chunk chunk, long j2, long j3) {
        Chunk chunk2 = chunk;
        this.f26518v = null;
        this.f26501e.p(chunk2);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f26078a, chunk2.f26079b, chunk.f(), chunk.e(), j2, j3, chunk.c());
        this.f26506j.b(chunk2.f26078a);
        this.f26508l.u(loadEventInfo, chunk2.f26080c, this.f26499c, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, chunk2.f26084g, chunk2.f26085h);
        if (!this.E) {
            h(this.Q);
        } else {
            this.f26500d.d(this);
        }
    }

    /* renamed from: Y */
    public Loader.LoadErrorAction t(Chunk chunk, long j2, long j3, IOException iOException, int i2) {
        boolean z2;
        Loader.LoadErrorAction loadErrorAction;
        int i3;
        Chunk chunk2 = chunk;
        IOException iOException2 = iOException;
        boolean O2 = O(chunk);
        if (O2 && !((HlsMediaChunk) chunk2).q() && (iOException2 instanceof HttpDataSource$InvalidResponseCodeException) && ((i3 = ((HttpDataSource$InvalidResponseCodeException) iOException2).f28444e) == 410 || i3 == 404)) {
            return Loader.f28462d;
        }
        long c2 = chunk.c();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk2.f26078a, chunk2.f26079b, chunk.f(), chunk.e(), j2, j3, c2);
        LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(chunk2.f26080c, this.f26499c, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, Util.i1(chunk2.f26084g), Util.i1(chunk2.f26085h)), iOException2, i2);
        LoadErrorHandlingPolicy.FallbackSelection d2 = this.f26506j.d(TrackSelectionUtil.c(this.f26501e.k()), loadErrorInfo);
        boolean z3 = false;
        if (d2 == null || d2.f28456a != 2) {
            z2 = false;
        } else {
            z2 = this.f26501e.m(chunk2, d2.f28457b);
        }
        if (z2) {
            if (O2 && c2 == 0) {
                ArrayList<HlsMediaChunk> arrayList = this.f26511o;
                if (arrayList.remove(arrayList.size() - 1) == chunk2) {
                    z3 = true;
                }
                Assertions.g(z3);
                if (this.f26511o.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((HlsMediaChunk) Iterables.d(this.f26511o)).o();
                }
            }
            loadErrorAction = Loader.f28464f;
        } else {
            long c3 = this.f26506j.c(loadErrorInfo);
            if (c3 != -9223372036854775807L) {
                loadErrorAction = Loader.h(false, c3);
            } else {
                loadErrorAction = Loader.f28465g;
            }
        }
        Loader.LoadErrorAction loadErrorAction2 = loadErrorAction;
        boolean z4 = !loadErrorAction2.c();
        this.f26508l.w(loadEventInfo, chunk2.f26080c, this.f26499c, chunk2.f26081d, chunk2.f26082e, chunk2.f26083f, chunk2.f26084g, chunk2.f26085h, iOException, z4);
        if (z4) {
            this.f26518v = null;
            this.f26506j.b(chunk2.f26078a);
        }
        if (z2) {
            if (!this.E) {
                h(this.Q);
            } else {
                this.f26500d.d(this);
            }
        }
        return loadErrorAction2;
    }

    public void Z() {
        this.f26521y.clear();
    }

    public void a(Format format) {
        this.f26515s.post(this.f26513q);
    }

    public boolean a0(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z2) {
        long j2;
        LoadErrorHandlingPolicy.FallbackSelection d2;
        if (!this.f26501e.o(uri)) {
            return true;
        }
        if (z2 || (d2 = this.f26506j.d(TrackSelectionUtil.c(this.f26501e.k()), loadErrorInfo)) == null || d2.f28456a != 2) {
            j2 = -9223372036854775807L;
        } else {
            j2 = d2.f28457b;
        }
        if (!this.f26501e.q(uri, j2) || j2 == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    public long b() {
        if (P()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return K().f26085h;
    }

    public void b0() {
        if (!this.f26511o.isEmpty()) {
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.d(this.f26511o);
            int c2 = this.f26501e.c(hlsMediaChunk);
            if (c2 == 1) {
                hlsMediaChunk.v();
            } else if (c2 == 2 && !this.U && this.f26507k.j()) {
                this.f26507k.f();
            }
        }
    }

    public boolean c() {
        return this.f26507k.j();
    }

    public TrackOutput d(int i2, int i3) {
        TrackOutput trackOutput;
        if (!Z.contains(Integer.valueOf(i3))) {
            int i4 = 0;
            while (true) {
                TrackOutput[] trackOutputArr = this.f26519w;
                if (i4 >= trackOutputArr.length) {
                    trackOutput = null;
                    break;
                } else if (this.f26520x[i4] == i2) {
                    trackOutput = trackOutputArr[i4];
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            trackOutput = L(i2, i3);
        }
        if (trackOutput == null) {
            if (this.V) {
                return C(i2, i3);
            }
            trackOutput = D(i2, i3);
        }
        if (i3 != 5) {
            return trackOutput;
        }
        if (this.A == null) {
            this.A = new EmsgUnwrappingTrackOutput(trackOutput, this.f26509m);
        }
        return this.A;
    }

    public void d0(TrackGroup[] trackGroupArr, int i2, int... iArr) {
        this.J = E(trackGroupArr);
        this.K = new HashSet();
        for (int b2 : iArr) {
            this.K.add(this.J.b(b2));
        }
        this.M = i2;
        Handler handler = this.f26515s;
        Callback callback = this.f26500d;
        Objects.requireNonNull(callback);
        handler.post(new a(callback));
        l0();
    }

    public long e() {
        if (this.U) {
            return Long.MIN_VALUE;
        }
        if (P()) {
            return this.R;
        }
        long j2 = this.Q;
        HlsMediaChunk K2 = K();
        if (!K2.h()) {
            if (this.f26511o.size() > 1) {
                ArrayList<HlsMediaChunk> arrayList = this.f26511o;
                K2 = arrayList.get(arrayList.size() - 2);
            } else {
                K2 = null;
            }
        }
        if (K2 != null) {
            j2 = Math.max(j2, K2.f26085h);
        }
        if (this.D) {
            for (HlsSampleQueue z2 : this.f26519w) {
                j2 = Math.max(j2, z2.z());
            }
        }
        return j2;
    }

    public int e0(int i2, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i3) {
        Format format;
        if (P()) {
            return -3;
        }
        int i4 = 0;
        if (!this.f26511o.isEmpty()) {
            int i5 = 0;
            while (i5 < this.f26511o.size() - 1 && I(this.f26511o.get(i5))) {
                i5++;
            }
            Util.Q0(this.f26511o, 0, i5);
            HlsMediaChunk hlsMediaChunk = this.f26511o.get(0);
            Format format2 = hlsMediaChunk.f26081d;
            if (!format2.equals(this.H)) {
                this.f26508l.i(this.f26499c, format2, hlsMediaChunk.f26082e, hlsMediaChunk.f26083f, hlsMediaChunk.f26084g);
            }
            this.H = format2;
        }
        if (!this.f26511o.isEmpty() && !this.f26511o.get(0).q()) {
            return -3;
        }
        int S2 = this.f26519w[i2].S(formatHolder, decoderInputBuffer, i3, this.U);
        if (S2 == -5) {
            Format format3 = (Format) Assertions.e(formatHolder.f23112b);
            if (i2 == this.C) {
                int Q2 = this.f26519w[i2].Q();
                while (i4 < this.f26511o.size() && this.f26511o.get(i4).f26428k != Q2) {
                    i4++;
                }
                if (i4 < this.f26511o.size()) {
                    format = this.f26511o.get(i4).f26081d;
                } else {
                    format = (Format) Assertions.e(this.G);
                }
                format3 = format3.k(format);
            }
            formatHolder.f23112b = format3;
        }
        return S2;
    }

    public void f(long j2) {
        if (!this.f26507k.i() && !P()) {
            if (this.f26507k.j()) {
                Assertions.e(this.f26518v);
                if (this.f26501e.v(j2, this.f26518v, this.f26512p)) {
                    this.f26507k.f();
                    return;
                }
                return;
            }
            int size = this.f26512p.size();
            while (size > 0 && this.f26501e.c(this.f26512p.get(size - 1)) == 2) {
                size--;
            }
            if (size < this.f26512p.size()) {
                G(size);
            }
            int h2 = this.f26501e.h(j2, this.f26512p);
            if (h2 < this.f26511o.size()) {
                G(h2);
            }
        }
    }

    public void f0() {
        if (this.E) {
            for (HlsSampleQueue R2 : this.f26519w) {
                R2.R();
            }
        }
        this.f26507k.m(this);
        this.f26515s.removeCallbacksAndMessages((Object) null);
        this.I = true;
        this.f26516t.clear();
    }

    public long g(long j2, SeekParameters seekParameters) {
        return this.f26501e.b(j2, seekParameters);
    }

    public boolean h(long j2) {
        long j3;
        List<HlsMediaChunk> list;
        boolean z2;
        if (this.U || this.f26507k.j() || this.f26507k.i()) {
            return false;
        }
        if (P()) {
            list = Collections.emptyList();
            j3 = this.R;
            for (HlsSampleQueue b02 : this.f26519w) {
                b02.b0(this.R);
            }
        } else {
            list = this.f26512p;
            HlsMediaChunk K2 = K();
            if (K2.h()) {
                j3 = K2.f26085h;
            } else {
                j3 = Math.max(this.Q, K2.f26084g);
            }
        }
        List<HlsMediaChunk> list2 = list;
        long j4 = j3;
        this.f26510n.a();
        HlsChunkSource hlsChunkSource = this.f26501e;
        if (this.E || !list2.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        hlsChunkSource.e(j2, j4, list2, z2, this.f26510n);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.f26510n;
        boolean z3 = hlsChunkHolder.f26414b;
        Chunk chunk = hlsChunkHolder.f26413a;
        Uri uri = hlsChunkHolder.f26415c;
        if (z3) {
            this.R = -9223372036854775807L;
            this.U = true;
            return true;
        } else if (chunk == null) {
            if (uri != null) {
                this.f26500d.k(uri);
            }
            return false;
        } else {
            if (O(chunk)) {
                N((HlsMediaChunk) chunk);
            }
            this.f26518v = chunk;
            this.f26508l.A(new LoadEventInfo(chunk.f26078a, chunk.f26079b, this.f26507k.n(chunk, this, this.f26506j.a(chunk.f26080c))), chunk.f26080c, this.f26499c, chunk.f26081d, chunk.f26082e, chunk.f26083f, chunk.f26084g, chunk.f26085h);
            return true;
        }
    }

    public boolean i0(long j2, boolean z2) {
        this.Q = j2;
        if (P()) {
            this.R = j2;
            return true;
        }
        if (this.D && !z2 && h0(j2)) {
            return false;
        }
        this.R = j2;
        this.U = false;
        this.f26511o.clear();
        if (this.f26507k.j()) {
            if (this.D) {
                for (HlsSampleQueue r2 : this.f26519w) {
                    r2.r();
                }
            }
            this.f26507k.f();
        } else {
            this.f26507k.g();
            g0();
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean j0(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.x()
            int r3 = r0.F
            r14 = 0
            r4 = 0
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = (com.google.android.exoplayer2.source.hls.HlsSampleStream) r5
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
            com.google.android.exoplayer2.source.hls.HlsChunkSource r4 = r0.f26501e
            com.google.android.exoplayer2.trackselection.ExoTrackSelection r4 = r4.k()
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
            com.google.android.exoplayer2.source.TrackGroupArray r7 = r0.J
            com.google.android.exoplayer2.source.TrackGroup r8 = r5.h()
            int r7 = r7.c(r8)
            int r8 = r0.M
            if (r7 != r8) goto L_0x0068
            com.google.android.exoplayer2.source.hls.HlsChunkSource r8 = r0.f26501e
            r8.u(r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x009c
            int r5 = r0.F
            int r5 = r5 + r15
            r0.F = r5
            com.google.android.exoplayer2.source.hls.HlsSampleStream r5 = new com.google.android.exoplayer2.source.hls.HlsSampleStream
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r8 = r0.L
            if (r8 == 0) goto L_0x009c
            r5.b()
            if (r16 != 0) goto L_0x009c
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r5 = r0.f26519w
            int[] r8 = r0.L
            r7 = r8[r7]
            r5 = r5[r7]
            boolean r7 = r5.Z(r12, r15)
            if (r7 != 0) goto L_0x0099
            int r5 = r5.C()
            if (r5 == 0) goto L_0x0099
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
            com.google.android.exoplayer2.source.hls.HlsChunkSource r1 = r0.f26501e
            r1.r()
            r0.H = r6
            r0.S = r15
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.f26511o
            r1.clear()
            com.google.android.exoplayer2.upstream.Loader r1 = r0.f26507k
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x00d1
            boolean r1 = r0.D
            if (r1 == 0) goto L_0x00ca
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r1 = r0.f26519w
            int r3 = r1.length
        L_0x00c0:
            if (r14 >= r3) goto L_0x00ca
            r4 = r1[r14]
            r4.r()
            int r14 = r14 + 1
            goto L_0x00c0
        L_0x00ca:
            com.google.android.exoplayer2.upstream.Loader r1 = r0.f26507k
            r1.f()
            goto L_0x013c
        L_0x00d1:
            r19.g0()
            goto L_0x013c
        L_0x00d6:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r1 = r0.f26511o
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0129
            boolean r1 = com.google.android.exoplayer2.util.Util.c(r11, r4)
            if (r1 != 0) goto L_0x0129
            boolean r1 = r0.T
            if (r1 != 0) goto L_0x0120
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ef
            long r3 = -r12
        L_0x00ef:
            r6 = r3
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r1 = r19.K()
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.f26501e
            com.google.android.exoplayer2.source.chunk.MediaChunkIterator[] r17 = r3.a(r1, r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.exoplayer2.source.hls.HlsMediaChunk> r10 = r0.f26512p
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.s(r4, r6, r8, r10, r11)
            com.google.android.exoplayer2.source.hls.HlsChunkSource r3 = r0.f26501e
            com.google.android.exoplayer2.source.TrackGroup r3 = r3.j()
            com.google.android.exoplayer2.Format r1 = r1.f26081d
            int r1 = r3.d(r1)
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
            r0.i0(r12, r1)
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
            r0.q0(r2)
            r0.T = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.j0(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void k() {
        for (HlsSampleQueue T2 : this.f26519w) {
            T2.T();
        }
    }

    public void k0(DrmInitData drmInitData) {
        if (!Util.c(this.X, drmInitData)) {
            this.X = drmInitData;
            int i2 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.f26519w;
                if (i2 < hlsSampleQueueArr.length) {
                    if (this.P[i2]) {
                        hlsSampleQueueArr[i2].i0(drmInitData);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void l() throws IOException {
        U();
        if (this.U && !this.E) {
            throw ParserException.a("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public void m() {
        this.V = true;
        this.f26515s.post(this.f26514r);
    }

    public void m0(boolean z2) {
        this.f26501e.t(z2);
    }

    public TrackGroupArray n() {
        x();
        return this.J;
    }

    public void n0(long j2) {
        if (this.W != j2) {
            this.W = j2;
            for (HlsSampleQueue a02 : this.f26519w) {
                a02.a0(j2);
            }
        }
    }

    public void o(long j2, boolean z2) {
        if (this.D && !P()) {
            int length = this.f26519w.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f26519w[i2].q(j2, z2, this.O[i2]);
            }
        }
    }

    public int o0(int i2, long j2) {
        if (P()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.f26519w[i2];
        int E2 = hlsSampleQueue.E(j2, this.U);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) Iterables.e(this.f26511o, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.q()) {
            E2 = Math.min(E2, hlsMediaChunk.m(i2) - hlsSampleQueue.C());
        }
        hlsSampleQueue.e0(E2);
        return E2;
    }

    public void p0(int i2) {
        x();
        Assertions.e(this.L);
        int i3 = this.L[i2];
        Assertions.g(this.O[i3]);
        this.O[i3] = false;
    }

    public void u(SeekMap seekMap) {
    }

    public int y(int i2) {
        x();
        Assertions.e(this.L);
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
