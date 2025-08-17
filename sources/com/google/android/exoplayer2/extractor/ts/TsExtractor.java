package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TsExtractor implements Extractor {

    /* renamed from: t  reason: collision with root package name */
    public static final ExtractorsFactory f25090t = new e();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f25091a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25092b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final List<TimestampAdjuster> f25093c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f25094d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseIntArray f25095e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final TsPayloadReader.Factory f25096f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<TsPayloadReader> f25097g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SparseBooleanArray f25098h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SparseBooleanArray f25099i;

    /* renamed from: j  reason: collision with root package name */
    private final TsDurationReader f25100j;

    /* renamed from: k  reason: collision with root package name */
    private TsBinarySearchSeeker f25101k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ExtractorOutput f25102l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f25103m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f25104n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f25105o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25106p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public TsPayloadReader f25107q;

    /* renamed from: r  reason: collision with root package name */
    private int f25108r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f25109s;

    private class PatReader implements SectionPayloadReader {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f25110a = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public void c(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.H() == 0 && (parsableByteArray.H() & 128) != 0) {
                parsableByteArray.V(6);
                int a2 = parsableByteArray.a() / 4;
                for (int i2 = 0; i2 < a2; i2++) {
                    parsableByteArray.k(this.f25110a, 4);
                    int h2 = this.f25110a.h(16);
                    this.f25110a.r(3);
                    if (h2 == 0) {
                        this.f25110a.r(13);
                    } else {
                        int h3 = this.f25110a.h(13);
                        if (TsExtractor.this.f25097g.get(h3) == null) {
                            TsExtractor.this.f25097g.put(h3, new SectionReader(new PmtReader(h3)));
                            TsExtractor.k(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.f25091a != 2) {
                    TsExtractor.this.f25097g.remove(0);
                }
            }
        }
    }

    private class PmtReader implements SectionPayloadReader {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableBitArray f25112a = new ParsableBitArray(new byte[5]);

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<TsPayloadReader> f25113b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private final SparseIntArray f25114c = new SparseIntArray();

        /* renamed from: d  reason: collision with root package name */
        private final int f25115d;

        public PmtReader(int i2) {
            this.f25115d = i2;
        }

        private TsPayloadReader.EsInfo a(ParsableByteArray parsableByteArray, int i2) {
            int f2 = parsableByteArray.f();
            int i3 = i2 + f2;
            int i4 = -1;
            String str = null;
            ArrayList arrayList = null;
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
                                parsableByteArray.V(f3 - parsableByteArray.f());
                            }
                        }
                        i4 = Sdk$SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE;
                        parsableByteArray.V(f3 - parsableByteArray.f());
                    }
                    i4 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
                    parsableByteArray.V(f3 - parsableByteArray.f());
                } else {
                    if (H != 106) {
                        if (H != 122) {
                            if (H == 127) {
                                if (parsableByteArray.H() != 21) {
                                }
                            } else if (H == 123) {
                                i4 = Sdk$SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE;
                            } else if (H == 10) {
                                str = parsableByteArray.E(3).trim();
                            } else if (H == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.f() < f3) {
                                    String trim = parsableByteArray.E(3).trim();
                                    int H2 = parsableByteArray.H();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.l(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim, H2, bArr));
                                }
                                arrayList = arrayList2;
                                i4 = 89;
                            } else if (H == 111) {
                                i4 = 257;
                            }
                            parsableByteArray.V(f3 - parsableByteArray.f());
                        }
                        i4 = Sdk$SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE;
                        parsableByteArray.V(f3 - parsableByteArray.f());
                    }
                    i4 = Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE;
                    parsableByteArray.V(f3 - parsableByteArray.f());
                }
                i4 = 172;
                parsableByteArray.V(f3 - parsableByteArray.f());
            }
            parsableByteArray.U(i3);
            return new TsPayloadReader.EsInfo(i4, str, arrayList, Arrays.copyOfRange(parsableByteArray.e(), f2, i3));
        }

        public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }

        public void c(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            int i2;
            int i3;
            TsPayloadReader tsPayloadReader;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.H() == 2) {
                if (TsExtractor.this.f25091a == 1 || TsExtractor.this.f25091a == 2 || TsExtractor.this.f25103m == 1) {
                    timestampAdjuster = (TimestampAdjuster) TsExtractor.this.f25093c.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.f25093c.get(0)).c());
                    TsExtractor.this.f25093c.add(timestampAdjuster);
                }
                if ((parsableByteArray.H() & 128) != 0) {
                    parsableByteArray2.V(1);
                    int N = parsableByteArray.N();
                    int i4 = 3;
                    parsableByteArray2.V(3);
                    parsableByteArray2.k(this.f25112a, 2);
                    this.f25112a.r(3);
                    int i5 = 13;
                    int unused = TsExtractor.this.f25109s = this.f25112a.h(13);
                    parsableByteArray2.k(this.f25112a, 2);
                    int i6 = 4;
                    this.f25112a.r(4);
                    parsableByteArray2.V(this.f25112a.h(12));
                    if (TsExtractor.this.f25091a == 2 && TsExtractor.this.f25107q == null) {
                        TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, (String) null, (List<TsPayloadReader.DvbSubtitleInfo>) null, Util.f28813f);
                        TsExtractor tsExtractor = TsExtractor.this;
                        TsPayloadReader unused2 = tsExtractor.f25107q = tsExtractor.f25096f.b(21, esInfo);
                        if (TsExtractor.this.f25107q != null) {
                            TsExtractor.this.f25107q.b(timestampAdjuster, TsExtractor.this.f25102l, new TsPayloadReader.TrackIdGenerator(N, 21, 8192));
                        }
                    }
                    this.f25113b.clear();
                    this.f25114c.clear();
                    int a2 = parsableByteArray.a();
                    while (a2 > 0) {
                        parsableByteArray2.k(this.f25112a, 5);
                        int h2 = this.f25112a.h(8);
                        this.f25112a.r(i4);
                        int h3 = this.f25112a.h(i5);
                        this.f25112a.r(i6);
                        int h4 = this.f25112a.h(12);
                        TsPayloadReader.EsInfo a3 = a(parsableByteArray2, h4);
                        if (h2 == 6 || h2 == 5) {
                            h2 = a3.f25120a;
                        }
                        a2 -= h4 + 5;
                        if (TsExtractor.this.f25091a == 2) {
                            i3 = h2;
                        } else {
                            i3 = h3;
                        }
                        if (!TsExtractor.this.f25098h.get(i3)) {
                            if (TsExtractor.this.f25091a == 2 && h2 == 21) {
                                tsPayloadReader = TsExtractor.this.f25107q;
                            } else {
                                tsPayloadReader = TsExtractor.this.f25096f.b(h2, a3);
                            }
                            if (TsExtractor.this.f25091a != 2 || h3 < this.f25114c.get(i3, 8192)) {
                                this.f25114c.put(i3, h3);
                                this.f25113b.put(i3, tsPayloadReader);
                            }
                        }
                        i4 = 3;
                        i6 = 4;
                        i5 = 13;
                    }
                    int size = this.f25114c.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        int keyAt = this.f25114c.keyAt(i7);
                        int valueAt = this.f25114c.valueAt(i7);
                        TsExtractor.this.f25098h.put(keyAt, true);
                        TsExtractor.this.f25099i.put(valueAt, true);
                        TsPayloadReader valueAt2 = this.f25113b.valueAt(i7);
                        if (valueAt2 != null) {
                            if (valueAt2 != TsExtractor.this.f25107q) {
                                valueAt2.b(timestampAdjuster, TsExtractor.this.f25102l, new TsPayloadReader.TrackIdGenerator(N, keyAt, 8192));
                            }
                            TsExtractor.this.f25097g.put(valueAt, valueAt2);
                        }
                    }
                    if (TsExtractor.this.f25091a != 2) {
                        TsExtractor.this.f25097g.remove(this.f25115d);
                        TsExtractor tsExtractor2 = TsExtractor.this;
                        if (tsExtractor2.f25091a == 1) {
                            i2 = 0;
                        } else {
                            i2 = TsExtractor.this.f25103m - 1;
                        }
                        int unused3 = tsExtractor2.f25103m = i2;
                        if (TsExtractor.this.f25103m == 0) {
                            TsExtractor.this.f25102l.m();
                            boolean unused4 = TsExtractor.this.f25104n = true;
                        }
                    } else if (!TsExtractor.this.f25104n) {
                        TsExtractor.this.f25102l.m();
                        int unused5 = TsExtractor.this.f25103m = 0;
                        boolean unused6 = TsExtractor.this.f25104n = true;
                    }
                }
            }
        }
    }

    public TsExtractor() {
        this(0);
    }

    static /* synthetic */ int k(TsExtractor tsExtractor) {
        int i2 = tsExtractor.f25103m;
        tsExtractor.f25103m = i2 + 1;
        return i2;
    }

    private boolean u(ExtractorInput extractorInput) throws IOException {
        byte[] e2 = this.f25094d.e();
        if (9400 - this.f25094d.f() < 188) {
            int a2 = this.f25094d.a();
            if (a2 > 0) {
                System.arraycopy(e2, this.f25094d.f(), e2, 0, a2);
            }
            this.f25094d.S(e2, a2);
        }
        while (this.f25094d.a() < 188) {
            int g2 = this.f25094d.g();
            int read = extractorInput.read(e2, g2, 9400 - g2);
            if (read == -1) {
                return false;
            }
            this.f25094d.T(g2 + read);
        }
        return true;
    }

    private int v() throws ParserException {
        int f2 = this.f25094d.f();
        int g2 = this.f25094d.g();
        int a2 = TsUtil.a(this.f25094d.e(), f2, g2);
        this.f25094d.U(a2);
        int i2 = a2 + 188;
        if (i2 > g2) {
            int i3 = this.f25108r + (a2 - f2);
            this.f25108r = i3;
            if (this.f25091a == 2 && i3 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.f25108r = 0;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] w() {
        return new Extractor[]{new TsExtractor()};
    }

    private void x(long j2) {
        if (!this.f25105o) {
            this.f25105o = true;
            if (this.f25100j.b() != -9223372036854775807L) {
                TsBinarySearchSeeker tsBinarySearchSeeker = new TsBinarySearchSeeker(this.f25100j.c(), this.f25100j.b(), j2, this.f25109s, this.f25092b);
                this.f25101k = tsBinarySearchSeeker;
                this.f25102l.u(tsBinarySearchSeeker.b());
                return;
            }
            this.f25102l.u(new SeekMap.Unseekable(this.f25100j.b()));
        }
    }

    private void y() {
        this.f25098h.clear();
        this.f25097g.clear();
        SparseArray<TsPayloadReader> a2 = this.f25096f.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f25097g.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f25097g.put(0, new SectionReader(new PatReader()));
        this.f25107q = null;
    }

    private boolean z(int i2) {
        if (this.f25091a == 2 || this.f25104n || !this.f25099i.get(i2, false)) {
            return true;
        }
        return false;
    }

    public void a(long j2, long j3) {
        boolean z2;
        TsBinarySearchSeeker tsBinarySearchSeeker;
        boolean z3;
        if (this.f25091a != 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        int size = this.f25093c.size();
        for (int i2 = 0; i2 < size; i2++) {
            TimestampAdjuster timestampAdjuster = this.f25093c.get(i2);
            if (timestampAdjuster.e() == -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                long c2 = timestampAdjuster.c();
                if (c2 == -9223372036854775807L || c2 == 0 || c2 == j3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            if (z3) {
                timestampAdjuster.g(j3);
            }
        }
        if (!(j3 == 0 || (tsBinarySearchSeeker = this.f25101k) == null)) {
            tsBinarySearchSeeker.h(j3);
        }
        this.f25094d.Q(0);
        this.f25095e.clear();
        for (int i3 = 0; i3 < this.f25097g.size(); i3++) {
            this.f25097g.valueAt(i3).a();
        }
        this.f25108r = 0;
    }

    public void c(ExtractorOutput extractorOutput) {
        this.f25102l = extractorOutput;
    }

    public boolean g(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] e2 = this.f25094d.e();
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

    public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i2;
        boolean z2;
        boolean z3;
        TsPayloadReader tsPayloadReader;
        int i3;
        boolean z4;
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        long length = extractorInput.getLength();
        if (this.f25104n) {
            if (length == -1 || this.f25091a == 2) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4 && !this.f25100j.d()) {
                return this.f25100j.e(extractorInput2, positionHolder2, this.f25109s);
            }
            x(length);
            if (this.f25106p) {
                this.f25106p = false;
                a(0, 0);
                if (extractorInput.getPosition() != 0) {
                    positionHolder2.f24231a = 0;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker = this.f25101k;
            if (tsBinarySearchSeeker != null && tsBinarySearchSeeker.d()) {
                return this.f25101k.c(extractorInput2, positionHolder2);
            }
        }
        if (!u(extractorInput)) {
            return -1;
        }
        int v2 = v();
        int g2 = this.f25094d.g();
        if (v2 > g2) {
            return 0;
        }
        int q2 = this.f25094d.q();
        if ((8388608 & q2) != 0) {
            this.f25094d.U(v2);
            return 0;
        }
        if ((4194304 & q2) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = i2 | 0;
        int i5 = (2096896 & q2) >> 8;
        if ((q2 & 32) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((q2 & 16) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            tsPayloadReader = this.f25097g.get(i5);
        } else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.f25094d.U(v2);
            return 0;
        }
        if (this.f25091a != 2) {
            int i6 = q2 & 15;
            int i7 = this.f25095e.get(i5, i6 - 1);
            this.f25095e.put(i5, i6);
            if (i7 == i6) {
                this.f25094d.U(v2);
                return 0;
            } else if (i6 != ((i7 + 1) & 15)) {
                tsPayloadReader.a();
            }
        }
        if (z2) {
            int H = this.f25094d.H();
            if ((this.f25094d.H() & 64) != 0) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            i4 |= i3;
            this.f25094d.V(H - 1);
        }
        boolean z5 = this.f25104n;
        if (z(i5)) {
            this.f25094d.T(v2);
            tsPayloadReader.c(this.f25094d, i4);
            this.f25094d.T(g2);
        }
        if (this.f25091a != 2 && !z5 && this.f25104n && length != -1) {
            this.f25106p = true;
        }
        this.f25094d.U(v2);
        return 0;
    }

    public void release() {
    }

    public TsExtractor(int i2) {
        this(1, i2, 112800);
    }

    public TsExtractor(int i2, int i3, int i4) {
        this(i2, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i3), i4);
    }

    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this(i2, timestampAdjuster, factory, 112800);
    }

    public TsExtractor(int i2, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory, int i3) {
        this.f25096f = (TsPayloadReader.Factory) Assertions.e(factory);
        this.f25092b = i3;
        this.f25091a = i2;
        if (i2 == 1 || i2 == 2) {
            this.f25093c = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f25093c = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.f25094d = new ParsableByteArray(new byte[9400], 0);
        this.f25098h = new SparseBooleanArray();
        this.f25099i = new SparseBooleanArray();
        this.f25097g = new SparseArray<>();
        this.f25095e = new SparseIntArray();
        this.f25100j = new TsDurationReader(i3);
        this.f25102l = ExtractorOutput.f24202z0;
        this.f25109s = -1;
        y();
    }
}
