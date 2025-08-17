package androidx.media3.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {
    @Deprecated

    /* renamed from: v  reason: collision with root package name */
    public static final ExtractorsFactory f9511v = new e();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f9512a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9513b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9514c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final List<TimestampAdjuster> f9515d;

    /* renamed from: e  reason: collision with root package name */
    private final ParsableByteArray f9516e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseIntArray f9517f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final TsPayloadReader.Factory f9518g;

    /* renamed from: h  reason: collision with root package name */
    private final SubtitleParser.Factory f9519h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SparseArray<TsPayloadReader> f9520i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final SparseBooleanArray f9521j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final SparseBooleanArray f9522k;

    /* renamed from: l  reason: collision with root package name */
    private final TsDurationReader f9523l;

    /* renamed from: m  reason: collision with root package name */
    private TsBinarySearchSeeker f9524m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ExtractorOutput f9525n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f9526o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f9527p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f9528q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f9529r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public TsPayloadReader f9530s;

    /* renamed from: t  reason: collision with root package name */
    private int f9531t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f9532u;

    private class PatReader implements SectionPayloadReader {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f9533a = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        public void b(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.H() == 0 && (parsableByteArray.H() & 128) != 0) {
                parsableByteArray.V(6);
                int a2 = parsableByteArray.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    parsableByteArray.k(this.f9533a, 4);
                    int h2 = this.f9533a.h(16);
                    this.f9533a.r(3);
                    if (h2 == 0) {
                        this.f9533a.r(13);
                    } else {
                        int h3 = this.f9533a.h(13);
                        if (TsExtractor.this.f9520i.get(h3) == null) {
                            TsExtractor.this.f9520i.put(h3, new SectionReader(new PmtReader(h3)));
                            TsExtractor.m(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.f9512a != 2) {
                    TsExtractor.this.f9520i.remove(0);
                }
            }
        }

        public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    private class PmtReader implements SectionPayloadReader {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f9535a = new ParsableBitArray(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<TsPayloadReader> f9536b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f9537c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f9538d;

        public PmtReader(int i2) {
            this.f9538d = i2;
        }

        private TsPayloadReader.EsInfo a(ParsableByteArray parsableByteArray, int i2) {
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            int f2 = parsableByteArray.f();
            int i3 = f2 + i2;
            String str = null;
            ArrayList arrayList = null;
            int i4 = -1;
            int i5 = 0;
            while (parsableByteArray.f() < i3) {
                int H = parsableByteArray.H();
                int f3 = parsableByteArray.f() + parsableByteArray.H();
                if (f3 > i3) {
                    break;
                }
                if (H == 5) {
                    long J = parsableByteArray.J();
                    if (J != 1094921523) {
                        if (J != 1161904947) {
                            if (J != 1094921524) {
                                if (J == 1212503619) {
                                    i4 = 36;
                                }
                                parsableByteArray2.V(f3 - parsableByteArray.f());
                            }
                        }
                        i4 = Sdk$SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE;
                        parsableByteArray2.V(f3 - parsableByteArray.f());
                    }
                    i4 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
                    parsableByteArray2.V(f3 - parsableByteArray.f());
                } else {
                    if (H != 106) {
                        if (H != 122) {
                            if (H == 127) {
                                int H2 = parsableByteArray.H();
                                if (H2 != 21) {
                                    if (H2 == 14) {
                                        i4 = Sdk$SDKError.Reason.PRIVACY_URL_ERROR_VALUE;
                                    } else if (H2 == 33) {
                                        i4 = 139;
                                    }
                                }
                            } else if (H == 123) {
                                i4 = Sdk$SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE;
                            } else if (H == 10) {
                                String trim = parsableByteArray2.E(3).trim();
                                i5 = parsableByteArray.H();
                                str = trim;
                            } else if (H == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.f() < f3) {
                                    String trim2 = parsableByteArray2.E(3).trim();
                                    int H3 = parsableByteArray.H();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray2.l(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim2, H3, bArr));
                                }
                                arrayList = arrayList2;
                                i4 = 89;
                            } else if (H == 111) {
                                i4 = 257;
                            }
                            parsableByteArray2.V(f3 - parsableByteArray.f());
                        }
                        i4 = Sdk$SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE;
                        parsableByteArray2.V(f3 - parsableByteArray.f());
                    }
                    i4 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
                    parsableByteArray2.V(f3 - parsableByteArray.f());
                }
                i4 = 172;
                parsableByteArray2.V(f3 - parsableByteArray.f());
            }
            parsableByteArray2.U(i3);
            return new TsPayloadReader.EsInfo(i4, str, i5, arrayList, Arrays.copyOfRange(parsableByteArray.e(), f2, i3));
        }

        public void b(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            int i2;
            int i3;
            TsPayloadReader tsPayloadReader;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.H() == 2) {
                if (TsExtractor.this.f9512a == 1 || TsExtractor.this.f9512a == 2 || TsExtractor.this.f9526o == 1) {
                    timestampAdjuster = (TimestampAdjuster) TsExtractor.this.f9515d.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.f9515d.get(0)).d());
                    TsExtractor.this.f9515d.add(timestampAdjuster);
                }
                if ((parsableByteArray.H() & 128) != 0) {
                    parsableByteArray2.V(1);
                    int N = parsableByteArray.N();
                    int i4 = 3;
                    parsableByteArray2.V(3);
                    parsableByteArray2.k(this.f9535a, 2);
                    this.f9535a.r(3);
                    int i5 = 13;
                    int unused = TsExtractor.this.f9532u = this.f9535a.h(13);
                    parsableByteArray2.k(this.f9535a, 2);
                    int i6 = 4;
                    this.f9535a.r(4);
                    parsableByteArray2.V(this.f9535a.h(12));
                    if (TsExtractor.this.f9512a == 2 && TsExtractor.this.f9530s == null) {
                        TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, (String) null, 0, (List<TsPayloadReader.DvbSubtitleInfo>) null, Util.f4719f);
                        TsExtractor tsExtractor = TsExtractor.this;
                        TsPayloadReader unused2 = tsExtractor.f9530s = tsExtractor.f9518g.b(21, esInfo);
                        if (TsExtractor.this.f9530s != null) {
                            TsExtractor.this.f9530s.c(timestampAdjuster, TsExtractor.this.f9525n, new TsPayloadReader.TrackIdGenerator(N, 21, 8192));
                        }
                    }
                    this.f9536b.clear();
                    this.f9537c.clear();
                    int a2 = parsableByteArray.a();
                    while (a2 > 0) {
                        parsableByteArray2.k(this.f9535a, 5);
                        int h2 = this.f9535a.h(8);
                        this.f9535a.r(i4);
                        int h3 = this.f9535a.h(i5);
                        this.f9535a.r(i6);
                        int h4 = this.f9535a.h(12);
                        TsPayloadReader.EsInfo a3 = a(parsableByteArray2, h4);
                        if (h2 == 6 || h2 == 5) {
                            h2 = a3.f9543a;
                        }
                        a2 -= h4 + 5;
                        if (TsExtractor.this.f9512a == 2) {
                            i3 = h2;
                        } else {
                            i3 = h3;
                        }
                        if (!TsExtractor.this.f9521j.get(i3)) {
                            if (TsExtractor.this.f9512a == 2 && h2 == 21) {
                                tsPayloadReader = TsExtractor.this.f9530s;
                            } else {
                                tsPayloadReader = TsExtractor.this.f9518g.b(h2, a3);
                            }
                            if (TsExtractor.this.f9512a != 2 || h3 < this.f9537c.get(i3, 8192)) {
                                this.f9537c.put(i3, h3);
                                this.f9536b.put(i3, tsPayloadReader);
                            }
                        }
                        i4 = 3;
                        i6 = 4;
                        i5 = 13;
                    }
                    int size = this.f9537c.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        int keyAt = this.f9537c.keyAt(i7);
                        int valueAt = this.f9537c.valueAt(i7);
                        TsExtractor.this.f9521j.put(keyAt, true);
                        TsExtractor.this.f9522k.put(valueAt, true);
                        TsPayloadReader valueAt2 = this.f9536b.valueAt(i7);
                        if (valueAt2 != null) {
                            if (valueAt2 != TsExtractor.this.f9530s) {
                                valueAt2.c(timestampAdjuster, TsExtractor.this.f9525n, new TsPayloadReader.TrackIdGenerator(N, keyAt, 8192));
                            }
                            TsExtractor.this.f9520i.put(valueAt, valueAt2);
                        }
                    }
                    if (TsExtractor.this.f9512a != 2) {
                        TsExtractor.this.f9520i.remove(this.f9538d);
                        TsExtractor tsExtractor2 = TsExtractor.this;
                        if (tsExtractor2.f9512a == 1) {
                            i2 = 0;
                        } else {
                            i2 = TsExtractor.this.f9526o - 1;
                        }
                        int unused3 = tsExtractor2.f9526o = i2;
                        if (TsExtractor.this.f9526o == 0) {
                            TsExtractor.this.f9525n.m();
                            boolean unused4 = TsExtractor.this.f9527p = true;
                        }
                    } else if (!TsExtractor.this.f9527p) {
                        TsExtractor.this.f9525n.m();
                        int unused5 = TsExtractor.this.f9526o = 0;
                        boolean unused6 = TsExtractor.this.f9527p = true;
                    }
                }
            }
        }

        public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    @Deprecated
    public TsExtractor() {
        this(1, 1, SubtitleParser.Factory.f8798a, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(0), 112800);
    }

    private void A() {
        this.f9521j.clear();
        this.f9520i.clear();
        SparseArray<TsPayloadReader> a2 = this.f9518g.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f9520i.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f9520i.put(0, new SectionReader(new PatReader()));
        this.f9530s = null;
    }

    private boolean B(int i2) {
        if (this.f9512a == 2 || this.f9527p || !this.f9522k.get(i2, false)) {
            return true;
        }
        return false;
    }

    static /* synthetic */ int m(TsExtractor tsExtractor) {
        int i2 = tsExtractor.f9526o;
        tsExtractor.f9526o = i2 + 1;
        return i2;
    }

    private boolean w(ExtractorInput extractorInput) throws IOException {
        byte[] e2 = this.f9516e.e();
        if (9400 - this.f9516e.f() < 188) {
            int a2 = this.f9516e.a();
            if (a2 > 0) {
                System.arraycopy(e2, this.f9516e.f(), e2, 0, a2);
            }
            this.f9516e.S(e2, a2);
        }
        while (this.f9516e.a() < 188) {
            int g2 = this.f9516e.g();
            int read = extractorInput.read(e2, g2, 9400 - g2);
            if (read == -1) {
                return false;
            }
            this.f9516e.T(g2 + read);
        }
        return true;
    }

    private int x() throws ParserException {
        int f2 = this.f9516e.f();
        int g2 = this.f9516e.g();
        int a2 = TsUtil.a(this.f9516e.e(), f2, g2);
        this.f9516e.U(a2);
        int i2 = a2 + 188;
        if (i2 > g2) {
            int i3 = this.f9531t + (a2 - f2);
            this.f9531t = i3;
            if (this.f9512a == 2 && i3 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.f9531t = 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] y() {
        return new Extractor[]{new TsExtractor(1, SubtitleParser.Factory.f8798a)};
    }

    private void z(long j2) {
        if (!this.f9528q) {
            this.f9528q = true;
            if (this.f9523l.b() != -9223372036854775807L) {
                TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(this.f9523l.c(), this.f9523l.b(), j2, this.f9532u, this.f9514c);
                this.f9524m = tsBinarySearchSeeker;
                this.f9525n.r(tsBinarySearchSeeker.b());
                return;
            }
            this.f9525n.r(new SeekMap.Unseekable(this.f9523l.b()));
        }
    }

    public void a(long j2, long j3) {
        boolean z2;
        TsBinarySearchSeeker tsBinarySearchSeeker;
        boolean z3;
        if (this.f9512a != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        int size = this.f9515d.size();
        for (int i2 = 0; i2 < size; i2++) {
            TimestampAdjuster timestampAdjuster = this.f9515d.get(i2);
            if (timestampAdjuster.f() == -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                long d2 = timestampAdjuster.d();
                if (d2 == -9223372036854775807L || d2 == 0 || d2 == j3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            if (z3) {
                timestampAdjuster.i(j3);
            }
        }
        if (!(j3 == 0 || (tsBinarySearchSeeker = this.f9524m) == null)) {
            tsBinarySearchSeeker.h(j3);
        }
        this.f9516e.Q(0);
        this.f9517f.clear();
        for (int i3 = 0; i3 < this.f9520i.size(); i3++) {
            this.f9520i.valueAt(i3).a();
        }
        this.f9531t = 0;
    }

    public /* synthetic */ Extractor c() {
        return d.b(this);
    }

    public void g(ExtractorOutput extractorOutput) {
        if ((this.f9513b & 1) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f9519h);
        }
        this.f9525n = extractorOutput;
    }

    public boolean i(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] e2 = this.f9516e.e();
        extractorInput.m(e2, 0, 940);
        for (int i2 = 0; i2 < 188; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    z2 = true;
                    break;
                } else if (e2[(i3 * 188) + i2] != 71) {
                    z2 = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                extractorInput.k(i2);
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ List j() {
        return d.a(this);
    }

    public int k(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        TsPayloadReader tsPayloadReader;
        int i3;
        boolean z5;
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        long length = extractorInput.getLength();
        if (this.f9512a == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f9527p) {
            if (length == -1 || z2) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5 && !this.f9523l.d()) {
                return this.f9523l.e(extractorInput2, positionHolder2, this.f9532u);
            }
            z(length);
            if (this.f9529r) {
                this.f9529r = false;
                a(0, 0);
                if (extractorInput.getPosition() != 0) {
                    positionHolder2.f8069a = 0;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker = this.f9524m;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.d()) {
                return this.f9524m.c(extractorInput2, positionHolder2);
            }
        }
        if (!w(extractorInput)) {
            for (int i4 = 0; i4 < this.f9520i.size(); i4++) {
                TsPayloadReader valueAt = this.f9520i.valueAt(i4);
                if (valueAt instanceof PesReader) {
                    PesReader pesReader = (PesReader) valueAt;
                    if (pesReader.d(z2)) {
                        pesReader.b(new ParsableByteArray(), 1);
                    }
                }
            }
            return -1;
        }
        int x2 = x();
        int g2 = this.f9516e.g();
        if (x2 > g2) {
            return 0;
        }
        int q2 = this.f9516e.q();
        if ((8388608 & q2) != 0) {
            this.f9516e.U(x2);
            return 0;
        }
        if ((4194304 & q2) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i5 = i2 | 0;
        int i6 = (2096896 & q2) >> 8;
        if ((q2 & 32) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((q2 & 16) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            tsPayloadReader = this.f9520i.get(i6);
        } else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.f9516e.U(x2);
            return 0;
        }
        if (this.f9512a != 2) {
            int i7 = q2 & 15;
            int i8 = this.f9517f.get(i6, i7 - 1);
            this.f9517f.put(i6, i7);
            if (i8 == i7) {
                this.f9516e.U(x2);
                return 0;
            } else if (i7 != ((i8 + 1) & 15)) {
                tsPayloadReader.a();
            }
        }
        if (z3) {
            int H = this.f9516e.H();
            if ((this.f9516e.H() & 64) != 0) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            i5 |= i3;
            this.f9516e.V(H - 1);
        }
        boolean z6 = this.f9527p;
        if (B(i6)) {
            this.f9516e.T(x2);
            tsPayloadReader.b(this.f9516e, i5);
            this.f9516e.T(g2);
        }
        if (this.f9512a != 2 && !z6 && this.f9527p && length != -1) {
            this.f9529r = true;
        }
        this.f9516e.U(x2);
        return 0;
    }

    public void release() {
    }

    public TsExtractor(int i2, SubtitleParser.Factory factory) {
        this(1, i2, factory, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(0), 112800);
    }

    public TsExtractor(int i2, int i3, SubtitleParser.Factory factory, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory2, int i4) {
        this.f9518g = (TsPayloadReader.Factory) Assertions.f(factory2);
        this.f9514c = i4;
        this.f9512a = i2;
        this.f9513b = i3;
        this.f9519h = factory;
        if (i2 == 1 || i2 == 2) {
            this.f9515d = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f9515d = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f9516e = new ParsableByteArray(new byte[9400], 0);
        this.f9521j = new SparseBooleanArray();
        this.f9522k = new SparseBooleanArray();
        this.f9520i = new SparseArray<>();
        this.f9517f = new SparseIntArray();
        this.f9523l = new TsDurationReader(i4);
        this.f9525n = ExtractorOutput.f8013y0;
        this.f9532u = -1;
        A();
    }
}
