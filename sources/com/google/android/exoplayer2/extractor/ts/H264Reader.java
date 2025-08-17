package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f24904a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24905b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24906c;

    /* renamed from: d  reason: collision with root package name */
    private final NalUnitTargetBuffer f24907d = new NalUnitTargetBuffer(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f24908e = new NalUnitTargetBuffer(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final NalUnitTargetBuffer f24909f = new NalUnitTargetBuffer(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f24910g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f24911h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f24912i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f24913j;

    /* renamed from: k  reason: collision with root package name */
    private SampleReader f24914k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24915l;

    /* renamed from: m  reason: collision with root package name */
    private long f24916m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24917n;

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f24918o = new ParsableByteArray();

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f24919a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f24920b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f24921c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.SpsData> f24922d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.PpsData> f24923e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final ParsableNalUnitBitArray f24924f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f24925g;

        /* renamed from: h  reason: collision with root package name */
        private int f24926h;

        /* renamed from: i  reason: collision with root package name */
        private int f24927i;

        /* renamed from: j  reason: collision with root package name */
        private long f24928j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f24929k;

        /* renamed from: l  reason: collision with root package name */
        private long f24930l;

        /* renamed from: m  reason: collision with root package name */
        private SliceHeaderData f24931m = new SliceHeaderData();

        /* renamed from: n  reason: collision with root package name */
        private SliceHeaderData f24932n = new SliceHeaderData();

        /* renamed from: o  reason: collision with root package name */
        private boolean f24933o;

        /* renamed from: p  reason: collision with root package name */
        private long f24934p;

        /* renamed from: q  reason: collision with root package name */
        private long f24935q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f24936r;

        private static final class SliceHeaderData {

            /* renamed from: a  reason: collision with root package name */
            private boolean f24937a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f24938b;

            /* renamed from: c  reason: collision with root package name */
            private NalUnitUtil.SpsData f24939c;

            /* renamed from: d  reason: collision with root package name */
            private int f24940d;

            /* renamed from: e  reason: collision with root package name */
            private int f24941e;

            /* renamed from: f  reason: collision with root package name */
            private int f24942f;

            /* renamed from: g  reason: collision with root package name */
            private int f24943g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f24944h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f24945i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f24946j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f24947k;

            /* renamed from: l  reason: collision with root package name */
            private int f24948l;

            /* renamed from: m  reason: collision with root package name */
            private int f24949m;

            /* renamed from: n  reason: collision with root package name */
            private int f24950n;

            /* renamed from: o  reason: collision with root package name */
            private int f24951o;

            /* renamed from: p  reason: collision with root package name */
            private int f24952p;

            private SliceHeaderData() {
            }

            /* access modifiers changed from: private */
            public boolean c(SliceHeaderData sliceHeaderData) {
                int i2;
                int i3;
                int i4;
                boolean z2;
                if (!this.f24937a) {
                    return false;
                }
                if (!sliceHeaderData.f24937a) {
                    return true;
                }
                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) Assertions.i(this.f24939c);
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.i(sliceHeaderData.f24939c);
                if (this.f24942f == sliceHeaderData.f24942f && this.f24943g == sliceHeaderData.f24943g && this.f24944h == sliceHeaderData.f24944h && ((!this.f24945i || !sliceHeaderData.f24945i || this.f24946j == sliceHeaderData.f24946j) && (((i2 = this.f24940d) == (i3 = sliceHeaderData.f24940d) || (i2 != 0 && i3 != 0)) && (((i4 = spsData.f28747l) != 0 || spsData2.f28747l != 0 || (this.f24949m == sliceHeaderData.f24949m && this.f24950n == sliceHeaderData.f24950n)) && ((i4 != 1 || spsData2.f28747l != 1 || (this.f24951o == sliceHeaderData.f24951o && this.f24952p == sliceHeaderData.f24952p)) && (z2 = this.f24947k) == sliceHeaderData.f24947k && (!z2 || this.f24948l == sliceHeaderData.f24948l)))))) {
                    return false;
                }
                return true;
            }

            public void b() {
                this.f24938b = false;
                this.f24937a = false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.f24941e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean d() {
                /*
                    r2 = this;
                    boolean r0 = r2.f24938b
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.f24941e
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData.d():boolean");
            }

            public void e(NalUnitUtil.SpsData spsData, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, int i6, int i7, int i8, int i9, int i10) {
                this.f24939c = spsData;
                this.f24940d = i2;
                this.f24941e = i3;
                this.f24942f = i4;
                this.f24943g = i5;
                this.f24944h = z2;
                this.f24945i = z3;
                this.f24946j = z4;
                this.f24947k = z5;
                this.f24948l = i6;
                this.f24949m = i7;
                this.f24950n = i8;
                this.f24951o = i9;
                this.f24952p = i10;
                this.f24937a = true;
                this.f24938b = true;
            }

            public void f(int i2) {
                this.f24941e = i2;
                this.f24938b = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z2, boolean z3) {
            this.f24919a = trackOutput;
            this.f24920b = z2;
            this.f24921c = z3;
            byte[] bArr = new byte[128];
            this.f24925g = bArr;
            this.f24924f = new ParsableNalUnitBitArray(bArr, 0, 0);
            g();
        }

        private void d(int i2) {
            long j2 = this.f24935q;
            if (j2 != -9223372036854775807L) {
                boolean z2 = this.f24936r;
                this.f24919a.e(j2, z2 ? 1 : 0, (int) (this.f24928j - this.f24934p), i2, (TrackOutput.CryptoData) null);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x014e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.f24929k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f24925g
                int r4 = r3.length
                int r5 = r0.f24926h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f24925g = r3
            L_0x001e:
                byte[] r3 = r0.f24925g
                int r4 = r0.f24926h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.f24926h
                int r1 = r1 + r2
                r0.f24926h = r1
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                byte[] r3 = r0.f24925g
                r4 = 0
                r2.i(r3, r4, r1)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                r1.k()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                int r10 = r1.e(r7)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                r2 = 5
                r1.l(r2)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0059
                return
            L_0x0059:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                r1.h()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0067
                return
            L_0x0067:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                int r11 = r1.h()
                boolean r1 = r0.f24921c
                if (r1 != 0) goto L_0x0079
                r0.f24929k = r4
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r1 = r0.f24932n
                r1.f(r11)
                return
            L_0x0079:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0082
                return
            L_0x0082:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                int r13 = r1.h()
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.f24923e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0093
                r0.f24929k = r4
                return
            L_0x0093:
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.f24923e
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.util.NalUnitUtil$PpsData r1 = (com.google.android.exoplayer2.util.NalUnitUtil.PpsData) r1
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$SpsData> r3 = r0.f24922d
                int r5 = r1.f28734b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.util.NalUnitUtil$SpsData r9 = (com.google.android.exoplayer2.util.NalUnitUtil.SpsData) r9
                boolean r3 = r9.f28744i
                if (r3 == 0) goto L_0x00b8
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b3
                return
            L_0x00b3:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                r3.l(r7)
            L_0x00b8:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                int r5 = r9.f28746k
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c3
                return
            L_0x00c3:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                int r5 = r9.f28746k
                int r12 = r3.e(r5)
                boolean r3 = r9.f28745j
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00d9
                return
            L_0x00d9:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.f24924f
                boolean r3 = r3.d()
                if (r3 == 0) goto L_0x00f5
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.f24924f
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ea
                return
            L_0x00ea:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.f24924f
                boolean r6 = r6.d()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fb
            L_0x00f5:
                r14 = r3
                goto L_0x00f8
            L_0x00f7:
                r14 = 0
            L_0x00f8:
                r15 = 0
                r16 = 0
            L_0x00fb:
                int r3 = r0.f24927i
                if (r3 != r2) goto L_0x0102
                r17 = 1
                goto L_0x0104
            L_0x0102:
                r17 = 0
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                int r2 = r2.h()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = 0
            L_0x011a:
                int r2 = r9.f28747l
                if (r2 != 0) goto L_0x014e
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                int r3 = r9.f28748m
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                int r3 = r9.f28748m
                int r2 = r2.e(r3)
                boolean r1 = r1.f28735c
                if (r1 == 0) goto L_0x014b
                if (r14 != 0) goto L_0x014b
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                int r1 = r1.g()
                r20 = r1
                r19 = r2
                goto L_0x018c
            L_0x014b:
                r19 = r2
                goto L_0x018a
            L_0x014e:
                if (r2 != r5) goto L_0x0188
                boolean r2 = r9.f28749n
                if (r2 != 0) goto L_0x0188
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x015d
                return
            L_0x015d:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.f24924f
                int r2 = r2.g()
                boolean r1 = r1.f28735c
                if (r1 == 0) goto L_0x0181
                if (r14 != 0) goto L_0x0181
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0172
                return
            L_0x0172:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.f24924f
                int r1 = r1.g()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0190
            L_0x0181:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x018e
            L_0x0188:
                r19 = 0
            L_0x018a:
                r20 = 0
            L_0x018c:
                r21 = 0
            L_0x018e:
                r22 = 0
            L_0x0190:
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r8 = r0.f24932n
                r8.e(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.f24929k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.a(byte[], int, int):void");
        }

        public boolean b(long j2, int i2, boolean z2, boolean z3) {
            boolean z4 = false;
            if (this.f24927i == 9 || (this.f24921c && this.f24932n.c(this.f24931m))) {
                if (z2 && this.f24933o) {
                    d(i2 + ((int) (j2 - this.f24928j)));
                }
                this.f24934p = this.f24928j;
                this.f24935q = this.f24930l;
                this.f24936r = false;
                this.f24933o = true;
            }
            if (this.f24920b) {
                z3 = this.f24932n.d();
            }
            boolean z5 = this.f24936r;
            int i3 = this.f24927i;
            if (i3 == 5 || (z3 && i3 == 1)) {
                z4 = true;
            }
            boolean z6 = z5 | z4;
            this.f24936r = z6;
            return z6;
        }

        public boolean c() {
            return this.f24921c;
        }

        public void e(NalUnitUtil.PpsData ppsData) {
            this.f24923e.append(ppsData.f28733a, ppsData);
        }

        public void f(NalUnitUtil.SpsData spsData) {
            this.f24922d.append(spsData.f28739d, spsData);
        }

        public void g() {
            this.f24929k = false;
            this.f24933o = false;
            this.f24932n.b();
        }

        public void h(long j2, int i2, long j3) {
            this.f24927i = i2;
            this.f24930l = j3;
            this.f24928j = j2;
            if (!this.f24920b || i2 != 1) {
                if (!this.f24921c) {
                    return;
                }
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f24931m;
            this.f24931m = this.f24932n;
            this.f24932n = sliceHeaderData;
            sliceHeaderData.b();
            this.f24926h = 0;
            this.f24929k = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z2, boolean z3) {
        this.f24904a = seiReader;
        this.f24905b = z2;
        this.f24906c = z3;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void b() {
        Assertions.i(this.f24913j);
        Util.j(this.f24914k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        if (!this.f24915l || this.f24914k.c()) {
            this.f24907d.b(i3);
            this.f24908e.b(i3);
            if (!this.f24915l) {
                if (this.f24907d.c() && this.f24908e.c()) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.f24907d;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.f25022d, nalUnitTargetBuffer.f25023e));
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f24908e;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.f25022d, nalUnitTargetBuffer2.f25023e));
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f24907d;
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l(nalUnitTargetBuffer3.f25022d, 3, nalUnitTargetBuffer3.f25023e);
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f24908e;
                    NalUnitUtil.PpsData j4 = NalUnitUtil.j(nalUnitTargetBuffer4.f25022d, 3, nalUnitTargetBuffer4.f25023e);
                    this.f24913j.d(new Format.Builder().U(this.f24912i).g0(MimeTypes.VIDEO_H264).K(CodecSpecificDataUtil.a(l2.f28736a, l2.f28737b, l2.f28738c)).n0(l2.f28741f).S(l2.f28742g).c0(l2.f28743h).V(arrayList).G());
                    this.f24915l = true;
                    this.f24914k.f(l2);
                    this.f24914k.e(j4);
                    this.f24907d.d();
                    this.f24908e.d();
                }
            } else if (this.f24907d.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f24907d;
                this.f24914k.f(NalUnitUtil.l(nalUnitTargetBuffer5.f25022d, 3, nalUnitTargetBuffer5.f25023e));
                this.f24907d.d();
            } else if (this.f24908e.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.f24908e;
                this.f24914k.e(NalUnitUtil.j(nalUnitTargetBuffer6.f25022d, 3, nalUnitTargetBuffer6.f25023e));
                this.f24908e.d();
            }
        }
        if (this.f24909f.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f24909f;
            this.f24918o.S(this.f24909f.f25022d, NalUnitUtil.q(nalUnitTargetBuffer7.f25022d, nalUnitTargetBuffer7.f25023e));
            this.f24918o.U(4);
            this.f24904a.a(j3, this.f24918o);
        }
        if (this.f24914k.b(j2, i2, this.f24915l, this.f24917n)) {
            this.f24917n = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        if (!this.f24915l || this.f24914k.c()) {
            this.f24907d.a(bArr, i2, i3);
            this.f24908e.a(bArr, i2, i3);
        }
        this.f24909f.a(bArr, i2, i3);
        this.f24914k.a(bArr, i2, i3);
    }

    @RequiresNonNull({"sampleReader"})
    private void i(long j2, int i2, long j3) {
        if (!this.f24915l || this.f24914k.c()) {
            this.f24907d.e(i2);
            this.f24908e.e(i2);
        }
        this.f24909f.e(i2);
        this.f24914k.h(j2, i2, j3);
    }

    public void a() {
        this.f24910g = 0;
        this.f24917n = false;
        this.f24916m = -9223372036854775807L;
        NalUnitUtil.a(this.f24911h);
        this.f24907d.d();
        this.f24908e.d();
        this.f24909f.d();
        SampleReader sampleReader = this.f24914k;
        if (sampleReader != null) {
            sampleReader.g();
        }
    }

    public void c(ParsableByteArray parsableByteArray) {
        int i2;
        b();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f24910g += (long) parsableByteArray.a();
        this.f24913j.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f24911h);
            if (c2 == g2) {
                h(e2, f2, g2);
                return;
            }
            int f3 = NalUnitUtil.f(e2, c2);
            int i3 = c2 - f2;
            if (i3 > 0) {
                h(e2, f2, c2);
            }
            int i4 = g2 - c2;
            long j2 = this.f24910g - ((long) i4);
            if (i3 < 0) {
                i2 = -i3;
            } else {
                i2 = 0;
            }
            g(j2, i4, i2, this.f24916m);
            i(j2, f3, this.f24916m);
            f2 = c2 + 3;
        }
    }

    public void d(long j2, int i2) {
        boolean z2;
        if (j2 != -9223372036854775807L) {
            this.f24916m = j2;
        }
        boolean z3 = this.f24917n;
        if ((i2 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f24917n = z3 | z2;
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24912i = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f24913j = d2;
        this.f24914k = new SampleReader(d2, this.f24905b, this.f24906c);
        this.f24904a.b(extractorOutput, trackIdGenerator);
    }

    public void f() {
    }
}
