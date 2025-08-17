package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class H262Reader implements ElementaryStreamReader {

    /* renamed from: q  reason: collision with root package name */
    private static final double[] f24856q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f24857a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f24858b;

    /* renamed from: c  reason: collision with root package name */
    private final UserDataReader f24859c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f24860d;

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f24861e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f24862f;

    /* renamed from: g  reason: collision with root package name */
    private final CsdBuffer f24863g;

    /* renamed from: h  reason: collision with root package name */
    private long f24864h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24865i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24866j;

    /* renamed from: k  reason: collision with root package name */
    private long f24867k;

    /* renamed from: l  reason: collision with root package name */
    private long f24868l;

    /* renamed from: m  reason: collision with root package name */
    private long f24869m;

    /* renamed from: n  reason: collision with root package name */
    private long f24870n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24871o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24872p;

    private static final class CsdBuffer {

        /* renamed from: e  reason: collision with root package name */
        private static final byte[] f24873e = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f24874a;

        /* renamed from: b  reason: collision with root package name */
        public int f24875b;

        /* renamed from: c  reason: collision with root package name */
        public int f24876c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f24877d;

        public CsdBuffer(int i2) {
            this.f24877d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f24874a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f24877d;
                int length = bArr2.length;
                int i5 = this.f24875b;
                if (length < i5 + i4) {
                    this.f24877d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f24877d, this.f24875b, i4);
                this.f24875b += i4;
            }
        }

        public boolean b(int i2, int i3) {
            if (this.f24874a) {
                int i4 = this.f24875b - i3;
                this.f24875b = i4;
                if (this.f24876c == 0 && i2 == 181) {
                    this.f24876c = i4;
                } else {
                    this.f24874a = false;
                    return true;
                }
            } else if (i2 == 179) {
                this.f24874a = true;
            }
            byte[] bArr = f24873e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f24874a = false;
            this.f24875b = 0;
            this.f24876c = 0;
        }
    }

    public H262Reader() {
        this((UserDataReader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> b(com.google.android.exoplayer2.extractor.ts.H262Reader.CsdBuffer r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f24877d
            int r1 = r8.f24875b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            byte r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            byte r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            byte r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            byte r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L_0x003d
            r7 = 3
            if (r6 == r7) goto L_0x0037
            if (r6 == r1) goto L_0x0031
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0044
        L_0x0031:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L_0x0042
        L_0x0037:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L_0x0042
        L_0x003d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L_0x0042:
            float r6 = (float) r6
            float r1 = r1 / r6
        L_0x0044:
            com.google.android.exoplayer2.Format$Builder r6 = new com.google.android.exoplayer2.Format$Builder
            r6.<init>()
            com.google.android.exoplayer2.Format$Builder r9 = r6.U(r9)
            java.lang.String r6 = "video/mpeg2"
            com.google.android.exoplayer2.Format$Builder r9 = r9.g0(r6)
            com.google.android.exoplayer2.Format$Builder r9 = r9.n0(r2)
            com.google.android.exoplayer2.Format$Builder r9 = r9.S(r4)
            com.google.android.exoplayer2.Format$Builder r9 = r9.c0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.google.android.exoplayer2.Format$Builder r9 = r9.V(r1)
            com.google.android.exoplayer2.Format r9 = r9.G()
            byte r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0099
            double[] r2 = f24856q
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0099
            r1 = r2[r1]
            int r8 = r8.f24876c
            int r8 = r8 + 9
            byte r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L_0x0091
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L_0x0091:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L_0x009b
        L_0x0099:
            r0 = 0
        L_0x009b:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H262Reader.b(com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer, java.lang.String):android.util.Pair");
    }

    public void a() {
        NalUnitUtil.a(this.f24862f);
        this.f24863g.c();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f24861e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f24864h = 0;
        this.f24865i = false;
        this.f24868l = -9223372036854775807L;
        this.f24870n = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.google.android.exoplayer2.util.ParsableByteArray r21) {
        /*
            r20 = this;
            r0 = r20
            com.google.android.exoplayer2.extractor.TrackOutput r1 = r0.f24858b
            com.google.android.exoplayer2.util.Assertions.i(r1)
            int r1 = r21.f()
            int r2 = r21.g()
            byte[] r3 = r21.e()
            long r4 = r0.f24864h
            int r6 = r21.a()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.f24864h = r4
            com.google.android.exoplayer2.extractor.TrackOutput r4 = r0.f24858b
            int r5 = r21.a()
            r6 = r21
            r4.c(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.f24862f
            int r4 = com.google.android.exoplayer2.util.NalUnitUtil.c(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.f24866j
            if (r4 != 0) goto L_0x0039
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r4 = r0.f24863g
            r4.a(r3, r1, r2)
        L_0x0039:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r4 = r0.f24861e
            if (r4 == 0) goto L_0x0040
            r4.a(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r21.e()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.f24866j
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x008a
            if (r8 <= 0) goto L_0x005a
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r9 = r0.f24863g
            r9.a(r3, r1, r4)
        L_0x005a:
            if (r8 >= 0) goto L_0x005e
            int r9 = -r8
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r12 = r0.f24863g
            boolean r9 = r12.b(r5, r9)
            if (r9 == 0) goto L_0x008a
            com.google.android.exoplayer2.extractor.ts.H262Reader$CsdBuffer r9 = r0.f24863g
            java.lang.String r12 = r0.f24857a
            java.lang.Object r12 = com.google.android.exoplayer2.util.Assertions.e(r12)
            java.lang.String r12 = (java.lang.String) r12
            android.util.Pair r9 = b(r9, r12)
            com.google.android.exoplayer2.extractor.TrackOutput r12 = r0.f24858b
            java.lang.Object r13 = r9.first
            com.google.android.exoplayer2.Format r13 = (com.google.android.exoplayer2.Format) r13
            r12.d(r13)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            r0.f24867k = r12
            r0.f24866j = r11
        L_0x008a:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r9 = r0.f24861e
            if (r9 == 0) goto L_0x00d9
            if (r8 <= 0) goto L_0x0095
            r9.a(r3, r1, r4)
            r1 = 0
            goto L_0x0096
        L_0x0095:
            int r1 = -r8
        L_0x0096:
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r8 = r0.f24861e
            boolean r1 = r8.b(r1)
            if (r1 == 0) goto L_0x00c6
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r1 = r0.f24861e
            byte[] r8 = r1.f25022d
            int r1 = r1.f25023e
            int r1 = com.google.android.exoplayer2.util.NalUnitUtil.q(r8, r1)
            com.google.android.exoplayer2.util.ParsableByteArray r8 = r0.f24860d
            java.lang.Object r8 = com.google.android.exoplayer2.util.Util.j(r8)
            com.google.android.exoplayer2.util.ParsableByteArray r8 = (com.google.android.exoplayer2.util.ParsableByteArray) r8
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r9 = r0.f24861e
            byte[] r9 = r9.f25022d
            r8.S(r9, r1)
            com.google.android.exoplayer2.extractor.ts.UserDataReader r1 = r0.f24859c
            java.lang.Object r1 = com.google.android.exoplayer2.util.Util.j(r1)
            com.google.android.exoplayer2.extractor.ts.UserDataReader r1 = (com.google.android.exoplayer2.extractor.ts.UserDataReader) r1
            long r8 = r0.f24870n
            com.google.android.exoplayer2.util.ParsableByteArray r12 = r0.f24860d
            r1.a(r8, r12)
        L_0x00c6:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x00d9
            byte[] r1 = r21.e()
            int r8 = r4 + 2
            byte r1 = r1[r8]
            if (r1 != r11) goto L_0x00d9
            com.google.android.exoplayer2.extractor.ts.NalUnitTargetBuffer r1 = r0.f24861e
            r1.e(r5)
        L_0x00d9:
            if (r5 == 0) goto L_0x00e7
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x00e0
            goto L_0x00e7
        L_0x00e0:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x0145
            r0.f24871o = r11
            goto L_0x0145
        L_0x00e7:
            int r1 = r2 - r4
            boolean r4 = r0.f24872p
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0112
            boolean r4 = r0.f24866j
            if (r4 == 0) goto L_0x0112
            long r13 = r0.f24870n
            int r4 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0112
            boolean r15 = r0.f24871o
            long r11 = r0.f24864h
            r19 = r5
            long r4 = r0.f24869m
            long r11 = r11 - r4
            int r4 = (int) r11
            int r16 = r4 - r1
            com.google.android.exoplayer2.extractor.TrackOutput r12 = r0.f24858b
            r18 = 0
            r17 = r1
            r12.e(r13, r15, r16, r17, r18)
            goto L_0x0114
        L_0x0112:
            r19 = r5
        L_0x0114:
            boolean r4 = r0.f24865i
            if (r4 == 0) goto L_0x011f
            boolean r4 = r0.f24872p
            if (r4 == 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r1 = 1
            goto L_0x0140
        L_0x011f:
            long r4 = r0.f24864h
            long r11 = (long) r1
            long r4 = r4 - r11
            r0.f24869m = r4
            long r4 = r0.f24868l
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012c
            goto L_0x0137
        L_0x012c:
            long r4 = r0.f24870n
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0136
            long r11 = r0.f24867k
            long r4 = r4 + r11
            goto L_0x0137
        L_0x0136:
            r4 = r8
        L_0x0137:
            r0.f24870n = r4
            r0.f24871o = r10
            r0.f24868l = r8
            r1 = 1
            r0.f24865i = r1
        L_0x0140:
            if (r19 != 0) goto L_0x0143
            r10 = 1
        L_0x0143:
            r0.f24872p = r10
        L_0x0145:
            r1 = r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H262Reader.c(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    public void d(long j2, int i2) {
        this.f24868l = j2;
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24857a = trackIdGenerator.b();
        this.f24858b = extractorOutput.d(trackIdGenerator.c(), 2);
        UserDataReader userDataReader = this.f24859c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    public void f() {
    }

    H262Reader(UserDataReader userDataReader) {
        this.f24859c = userDataReader;
        this.f24862f = new boolean[4];
        this.f24863g = new CsdBuffer(128);
        if (userDataReader != null) {
            this.f24861e = new NalUnitTargetBuffer(178, 128);
            this.f24860d = new ParsableByteArray();
        } else {
            this.f24861e = null;
            this.f24860d = null;
        }
        this.f24868l = -9223372036854775807L;
        this.f24870n = -9223372036854775807L;
    }
}
