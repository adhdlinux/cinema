package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.ParsableNalUnitBitArray;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H264Reader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final SeiReader f9294a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9295b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9296c;

    /* renamed from: d  reason: collision with root package name */
    private final NalUnitTargetBuffer f9297d = new NalUnitTargetBuffer(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f9298e = new NalUnitTargetBuffer(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final NalUnitTargetBuffer f9299f = new NalUnitTargetBuffer(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f9300g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f9301h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f9302i;

    /* renamed from: j  reason: collision with root package name */
    private TrackOutput f9303j;

    /* renamed from: k  reason: collision with root package name */
    private SampleReader f9304k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9305l;

    /* renamed from: m  reason: collision with root package name */
    private long f9306m = -9223372036854775807L;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9307n;

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f9308o = new ParsableByteArray();

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f9309a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f9310b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f9311c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.SpsData> f9312d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<NalUnitUtil.PpsData> f9313e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final ParsableNalUnitBitArray f9314f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f9315g;

        /* renamed from: h  reason: collision with root package name */
        private int f9316h;

        /* renamed from: i  reason: collision with root package name */
        private int f9317i;

        /* renamed from: j  reason: collision with root package name */
        private long f9318j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9319k;

        /* renamed from: l  reason: collision with root package name */
        private long f9320l;

        /* renamed from: m  reason: collision with root package name */
        private SliceHeaderData f9321m = new SliceHeaderData();

        /* renamed from: n  reason: collision with root package name */
        private SliceHeaderData f9322n = new SliceHeaderData();

        /* renamed from: o  reason: collision with root package name */
        private boolean f9323o;

        /* renamed from: p  reason: collision with root package name */
        private long f9324p;

        /* renamed from: q  reason: collision with root package name */
        private long f9325q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f9326r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f9327s;

        private static final class SliceHeaderData {

            /* renamed from: a  reason: collision with root package name */
            private boolean f9328a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f9329b;

            /* renamed from: c  reason: collision with root package name */
            private NalUnitUtil.SpsData f9330c;

            /* renamed from: d  reason: collision with root package name */
            private int f9331d;

            /* renamed from: e  reason: collision with root package name */
            private int f9332e;

            /* renamed from: f  reason: collision with root package name */
            private int f9333f;

            /* renamed from: g  reason: collision with root package name */
            private int f9334g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f9335h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f9336i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f9337j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f9338k;

            /* renamed from: l  reason: collision with root package name */
            private int f9339l;

            /* renamed from: m  reason: collision with root package name */
            private int f9340m;

            /* renamed from: n  reason: collision with root package name */
            private int f9341n;

            /* renamed from: o  reason: collision with root package name */
            private int f9342o;

            /* renamed from: p  reason: collision with root package name */
            private int f9343p;

            private SliceHeaderData() {
            }

            /* access modifiers changed from: private */
            public boolean c(SliceHeaderData sliceHeaderData) {
                int i2;
                int i3;
                int i4;
                boolean z2;
                if (!this.f9328a) {
                    return false;
                }
                if (!sliceHeaderData.f9328a) {
                    return true;
                }
                NalUnitUtil.SpsData spsData = (NalUnitUtil.SpsData) Assertions.j(this.f9330c);
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.j(sliceHeaderData.f9330c);
                if (this.f9333f == sliceHeaderData.f9333f && this.f9334g == sliceHeaderData.f9334g && this.f9335h == sliceHeaderData.f9335h && ((!this.f9336i || !sliceHeaderData.f9336i || this.f9337j == sliceHeaderData.f9337j) && (((i2 = this.f9331d) == (i3 = sliceHeaderData.f9331d) || (i2 != 0 && i3 != 0)) && (((i4 = spsData.f4785n) != 0 || spsData2.f4785n != 0 || (this.f9340m == sliceHeaderData.f9340m && this.f9341n == sliceHeaderData.f9341n)) && ((i4 != 1 || spsData2.f4785n != 1 || (this.f9342o == sliceHeaderData.f9342o && this.f9343p == sliceHeaderData.f9343p)) && (z2 = this.f9338k) == sliceHeaderData.f9338k && (!z2 || this.f9339l == sliceHeaderData.f9339l)))))) {
                    return false;
                }
                return true;
            }

            public void b() {
                this.f9329b = false;
                this.f9328a = false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.f9332e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean d() {
                /*
                    r2 = this;
                    boolean r0 = r2.f9329b
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.f9332e
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
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.SliceHeaderData.d():boolean");
            }

            public void e(NalUnitUtil.SpsData spsData, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, int i6, int i7, int i8, int i9, int i10) {
                this.f9330c = spsData;
                this.f9331d = i2;
                this.f9332e = i3;
                this.f9333f = i4;
                this.f9334g = i5;
                this.f9335h = z2;
                this.f9336i = z3;
                this.f9337j = z4;
                this.f9338k = z5;
                this.f9339l = i6;
                this.f9340m = i7;
                this.f9341n = i8;
                this.f9342o = i9;
                this.f9343p = i10;
                this.f9328a = true;
                this.f9329b = true;
            }

            public void f(int i2) {
                this.f9332e = i2;
                this.f9329b = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z2, boolean z3) {
            this.f9309a = trackOutput;
            this.f9310b = z2;
            this.f9311c = z3;
            byte[] bArr = new byte[128];
            this.f9315g = bArr;
            this.f9314f = new ParsableNalUnitBitArray(bArr, 0, 0);
            h();
        }

        private void e(int i2) {
            long j2 = this.f9325q;
            if (j2 != -9223372036854775807L) {
                boolean z2 = this.f9326r;
                this.f9309a.f(j2, z2 ? 1 : 0, (int) (this.f9318j - this.f9324p), i2, (TrackOutput.CryptoData) null);
            }
        }

        private void i() {
            boolean z2;
            if (this.f9310b) {
                z2 = this.f9322n.d();
            } else {
                z2 = this.f9327s;
            }
            boolean z3 = this.f9326r;
            int i2 = this.f9317i;
            boolean z4 = true;
            if (i2 != 5 && (!z2 || i2 != 1)) {
                z4 = false;
            }
            this.f9326r = z3 | z4;
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
                boolean r2 = r0.f9319k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f9315g
                int r4 = r3.length
                int r5 = r0.f9316h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f9315g = r3
            L_0x001e:
                byte[] r3 = r0.f9315g
                int r4 = r0.f9316h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.f9316h
                int r1 = r1 + r2
                r0.f9316h = r1
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                byte[] r3 = r0.f9315g
                r4 = 0
                r2.i(r3, r4, r1)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                r1.k()
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                int r10 = r1.e(r7)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                r2 = 5
                r1.l(r2)
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0059
                return
            L_0x0059:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                r1.h()
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0067
                return
            L_0x0067:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                int r11 = r1.h()
                boolean r1 = r0.f9311c
                if (r1 != 0) goto L_0x0079
                r0.f9319k = r4
                androidx.media3.extractor.ts.H264Reader$SampleReader$SliceHeaderData r1 = r0.f9322n
                r1.f(r11)
                return
            L_0x0079:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0082
                return
            L_0x0082:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                int r13 = r1.h()
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$PpsData> r1 = r0.f9313e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0093
                r0.f9319k = r4
                return
            L_0x0093:
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$PpsData> r1 = r0.f9313e
                java.lang.Object r1 = r1.get(r13)
                androidx.media3.container.NalUnitUtil$PpsData r1 = (androidx.media3.container.NalUnitUtil.PpsData) r1
                android.util.SparseArray<androidx.media3.container.NalUnitUtil$SpsData> r3 = r0.f9312d
                int r5 = r1.f4770b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                androidx.media3.container.NalUnitUtil$SpsData r9 = (androidx.media3.container.NalUnitUtil.SpsData) r9
                boolean r3 = r9.f4782k
                if (r3 == 0) goto L_0x00b8
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b3
                return
            L_0x00b3:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                r3.l(r7)
            L_0x00b8:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                int r5 = r9.f4784m
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c3
                return
            L_0x00c3:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                int r5 = r9.f4784m
                int r12 = r3.e(r5)
                boolean r3 = r9.f4783l
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00d9
                return
            L_0x00d9:
                androidx.media3.container.ParsableNalUnitBitArray r3 = r0.f9314f
                boolean r3 = r3.d()
                if (r3 == 0) goto L_0x00f5
                androidx.media3.container.ParsableNalUnitBitArray r6 = r0.f9314f
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ea
                return
            L_0x00ea:
                androidx.media3.container.ParsableNalUnitBitArray r6 = r0.f9314f
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
                int r3 = r0.f9317i
                if (r3 != r2) goto L_0x0102
                r17 = 1
                goto L_0x0104
            L_0x0102:
                r17 = 0
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                int r2 = r2.h()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = 0
            L_0x011a:
                int r2 = r9.f4785n
                if (r2 != 0) goto L_0x014e
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                int r3 = r9.f4786o
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                int r3 = r9.f4786o
                int r2 = r2.e(r3)
                boolean r1 = r1.f4771c
                if (r1 == 0) goto L_0x014b
                if (r14 != 0) goto L_0x014b
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                int r1 = r1.g()
                r20 = r1
                r19 = r2
                goto L_0x018c
            L_0x014b:
                r19 = r2
                goto L_0x018a
            L_0x014e:
                if (r2 != r5) goto L_0x0188
                boolean r2 = r9.f4787p
                if (r2 != 0) goto L_0x0188
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x015d
                return
            L_0x015d:
                androidx.media3.container.ParsableNalUnitBitArray r2 = r0.f9314f
                int r2 = r2.g()
                boolean r1 = r1.f4771c
                if (r1 == 0) goto L_0x0181
                if (r14 != 0) goto L_0x0181
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0172
                return
            L_0x0172:
                androidx.media3.container.ParsableNalUnitBitArray r1 = r0.f9314f
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
                androidx.media3.extractor.ts.H264Reader$SampleReader$SliceHeaderData r8 = r0.f9322n
                r8.e(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.f9319k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H264Reader.SampleReader.a(byte[], int, int):void");
        }

        public void b(long j2) {
            i();
            this.f9318j = j2;
            e(0);
            this.f9323o = false;
        }

        public boolean c(long j2, int i2, boolean z2) {
            if (this.f9317i == 9 || (this.f9311c && this.f9322n.c(this.f9321m))) {
                if (z2 && this.f9323o) {
                    e(i2 + ((int) (j2 - this.f9318j)));
                }
                this.f9324p = this.f9318j;
                this.f9325q = this.f9320l;
                this.f9326r = false;
                this.f9323o = true;
            }
            i();
            return this.f9326r;
        }

        public boolean d() {
            return this.f9311c;
        }

        public void f(NalUnitUtil.PpsData ppsData) {
            this.f9313e.append(ppsData.f4769a, ppsData);
        }

        public void g(NalUnitUtil.SpsData spsData) {
            this.f9312d.append(spsData.f4775d, spsData);
        }

        public void h() {
            this.f9319k = false;
            this.f9323o = false;
            this.f9322n.b();
        }

        public void j(long j2, int i2, long j3, boolean z2) {
            this.f9317i = i2;
            this.f9320l = j3;
            this.f9318j = j2;
            this.f9327s = z2;
            if (!this.f9310b || i2 != 1) {
                if (!this.f9311c) {
                    return;
                }
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f9321m;
            this.f9321m = this.f9322n;
            this.f9322n = sliceHeaderData;
            sliceHeaderData.b();
            this.f9316h = 0;
            this.f9319k = true;
        }
    }

    public H264Reader(SeiReader seiReader, boolean z2, boolean z3) {
        this.f9294a = seiReader;
        this.f9295b = z2;
        this.f9296c = z3;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void c() {
        Assertions.j(this.f9303j);
        Util.i(this.f9304k);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void g(long j2, int i2, int i3, long j3) {
        if (!this.f9305l || this.f9304k.d()) {
            this.f9297d.b(i3);
            this.f9298e.b(i3);
            if (!this.f9305l) {
                if (this.f9297d.c() && this.f9298e.c()) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.f9297d;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.f9443d, nalUnitTargetBuffer.f9444e));
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f9298e;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.f9443d, nalUnitTargetBuffer2.f9444e));
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f9297d;
                    NalUnitUtil.SpsData l2 = NalUnitUtil.l(nalUnitTargetBuffer3.f9443d, 3, nalUnitTargetBuffer3.f9444e);
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.f9298e;
                    NalUnitUtil.PpsData j4 = NalUnitUtil.j(nalUnitTargetBuffer4.f9443d, 3, nalUnitTargetBuffer4.f9444e);
                    this.f9303j.c(new Format.Builder().a0(this.f9302i).o0(MimeTypes.VIDEO_H264).O(CodecSpecificDataUtil.a(l2.f4772a, l2.f4773b, l2.f4774c)).v0(l2.f4777f).Y(l2.f4778g).P(new ColorInfo.Builder().d(l2.f4788q).c(l2.f4789r).e(l2.f4790s).g(l2.f4780i + 8).b(l2.f4781j + 8).a()).k0(l2.f4779h).b0(arrayList).g0(l2.f4791t).K());
                    this.f9305l = true;
                    this.f9304k.g(l2);
                    this.f9304k.f(j4);
                    this.f9297d.d();
                    this.f9298e.d();
                }
            } else if (this.f9297d.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.f9297d;
                this.f9304k.g(NalUnitUtil.l(nalUnitTargetBuffer5.f9443d, 3, nalUnitTargetBuffer5.f9444e));
                this.f9297d.d();
            } else if (this.f9298e.c()) {
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.f9298e;
                this.f9304k.f(NalUnitUtil.j(nalUnitTargetBuffer6.f9443d, 3, nalUnitTargetBuffer6.f9444e));
                this.f9298e.d();
            }
        }
        if (this.f9299f.b(i3)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.f9299f;
            this.f9308o.S(this.f9299f.f9443d, NalUnitUtil.r(nalUnitTargetBuffer7.f9443d, nalUnitTargetBuffer7.f9444e));
            this.f9308o.U(4);
            this.f9294a.a(j3, this.f9308o);
        }
        if (this.f9304k.c(j2, i2, this.f9305l)) {
            this.f9307n = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void h(byte[] bArr, int i2, int i3) {
        if (!this.f9305l || this.f9304k.d()) {
            this.f9297d.a(bArr, i2, i3);
            this.f9298e.a(bArr, i2, i3);
        }
        this.f9299f.a(bArr, i2, i3);
        this.f9304k.a(bArr, i2, i3);
    }

    @RequiresNonNull({"sampleReader"})
    private void i(long j2, int i2, long j3) {
        if (!this.f9305l || this.f9304k.d()) {
            this.f9297d.e(i2);
            this.f9298e.e(i2);
        }
        this.f9299f.e(i2);
        this.f9304k.j(j2, i2, j3, this.f9307n);
    }

    public void a() {
        this.f9300g = 0;
        this.f9307n = false;
        this.f9306m = -9223372036854775807L;
        NalUnitUtil.a(this.f9301h);
        this.f9297d.d();
        this.f9298e.d();
        this.f9299f.d();
        SampleReader sampleReader = this.f9304k;
        if (sampleReader != null) {
            sampleReader.h();
        }
    }

    public void b(ParsableByteArray parsableByteArray) {
        int i2;
        c();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f9300g += (long) parsableByteArray.a();
        this.f9303j.b(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f9301h);
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
            long j2 = this.f9300g - ((long) i4);
            if (i3 < 0) {
                i2 = -i3;
            } else {
                i2 = 0;
            }
            g(j2, i4, i2, this.f9306m);
            i(j2, f3, this.f9306m);
            f2 = c2 + 3;
        }
    }

    public void d(long j2, int i2) {
        boolean z2;
        this.f9306m = j2;
        boolean z3 = this.f9307n;
        if ((i2 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f9307n = z3 | z2;
    }

    public void e(boolean z2) {
        c();
        if (z2) {
            this.f9304k.b(this.f9300g);
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9302i = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f9303j = d2;
        this.f9304k = new SampleReader(d2, this.f9295b, this.f9296c);
        this.f9294a.b(extractorOutput, trackIdGenerator);
    }
}
