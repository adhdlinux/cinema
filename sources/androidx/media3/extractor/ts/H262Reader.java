package androidx.media3.extractor.ts;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;

public final class H262Reader implements ElementaryStreamReader {

    /* renamed from: q  reason: collision with root package name */
    private static final double[] f9246q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f9247a;

    /* renamed from: b  reason: collision with root package name */
    private TrackOutput f9248b;

    /* renamed from: c  reason: collision with root package name */
    private final UserDataReader f9249c;

    /* renamed from: d  reason: collision with root package name */
    private final ParsableByteArray f9250d;

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f9251e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f9252f;

    /* renamed from: g  reason: collision with root package name */
    private final CsdBuffer f9253g;

    /* renamed from: h  reason: collision with root package name */
    private long f9254h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9255i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9256j;

    /* renamed from: k  reason: collision with root package name */
    private long f9257k;

    /* renamed from: l  reason: collision with root package name */
    private long f9258l;

    /* renamed from: m  reason: collision with root package name */
    private long f9259m;

    /* renamed from: n  reason: collision with root package name */
    private long f9260n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9261o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f9262p;

    private static final class CsdBuffer {

        /* renamed from: e  reason: collision with root package name */
        private static final byte[] f9263e = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f9264a;

        /* renamed from: b  reason: collision with root package name */
        public int f9265b;

        /* renamed from: c  reason: collision with root package name */
        public int f9266c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f9267d;

        public CsdBuffer(int i2) {
            this.f9267d = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f9264a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f9267d;
                int length = bArr2.length;
                int i5 = this.f9265b;
                if (length < i5 + i4) {
                    this.f9267d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f9267d, this.f9265b, i4);
                this.f9265b += i4;
            }
        }

        public boolean b(int i2, int i3) {
            if (this.f9264a) {
                int i4 = this.f9265b - i3;
                this.f9265b = i4;
                if (this.f9266c == 0 && i2 == 181) {
                    this.f9266c = i4;
                } else {
                    this.f9264a = false;
                    return true;
                }
            } else if (i2 == 179) {
                this.f9264a = true;
            }
            byte[] bArr = f9263e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f9264a = false;
            this.f9265b = 0;
            this.f9266c = 0;
        }
    }

    public H262Reader() {
        this((UserDataReader) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<androidx.media3.common.Format, java.lang.Long> c(androidx.media3.extractor.ts.H262Reader.CsdBuffer r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f9267d
            int r1 = r8.f9265b
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
            androidx.media3.common.Format$Builder r6 = new androidx.media3.common.Format$Builder
            r6.<init>()
            androidx.media3.common.Format$Builder r9 = r6.a0(r9)
            java.lang.String r6 = "video/mpeg2"
            androidx.media3.common.Format$Builder r9 = r9.o0(r6)
            androidx.media3.common.Format$Builder r9 = r9.v0(r2)
            androidx.media3.common.Format$Builder r9 = r9.Y(r4)
            androidx.media3.common.Format$Builder r9 = r9.k0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            androidx.media3.common.Format$Builder r9 = r9.b0(r1)
            androidx.media3.common.Format r9 = r9.K()
            byte r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0099
            double[] r2 = f9246q
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0099
            r1 = r2[r1]
            int r8 = r8.f9266c
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.c(androidx.media3.extractor.ts.H262Reader$CsdBuffer, java.lang.String):android.util.Pair");
    }

    public void a() {
        NalUnitUtil.a(this.f9252f);
        this.f9253g.c();
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f9251e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f9254h = 0;
        this.f9255i = false;
        this.f9258l = -9223372036854775807L;
        this.f9260n = -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(androidx.media3.common.util.ParsableByteArray r21) {
        /*
            r20 = this;
            r0 = r20
            androidx.media3.extractor.TrackOutput r1 = r0.f9248b
            androidx.media3.common.util.Assertions.j(r1)
            int r1 = r21.f()
            int r2 = r21.g()
            byte[] r3 = r21.e()
            long r4 = r0.f9254h
            int r6 = r21.a()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.f9254h = r4
            androidx.media3.extractor.TrackOutput r4 = r0.f9248b
            int r5 = r21.a()
            r6 = r21
            r4.b(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.f9252f
            int r4 = androidx.media3.container.NalUnitUtil.c(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.f9256j
            if (r4 != 0) goto L_0x0039
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r4 = r0.f9253g
            r4.a(r3, r1, r2)
        L_0x0039:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r4 = r0.f9251e
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
            boolean r9 = r0.f9256j
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x008a
            if (r8 <= 0) goto L_0x005a
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r9 = r0.f9253g
            r9.a(r3, r1, r4)
        L_0x005a:
            if (r8 >= 0) goto L_0x005e
            int r9 = -r8
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r12 = r0.f9253g
            boolean r9 = r12.b(r5, r9)
            if (r9 == 0) goto L_0x008a
            androidx.media3.extractor.ts.H262Reader$CsdBuffer r9 = r0.f9253g
            java.lang.String r12 = r0.f9247a
            java.lang.Object r12 = androidx.media3.common.util.Assertions.f(r12)
            java.lang.String r12 = (java.lang.String) r12
            android.util.Pair r9 = c(r9, r12)
            androidx.media3.extractor.TrackOutput r12 = r0.f9248b
            java.lang.Object r13 = r9.first
            androidx.media3.common.Format r13 = (androidx.media3.common.Format) r13
            r12.c(r13)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            r0.f9257k = r12
            r0.f9256j = r11
        L_0x008a:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r9 = r0.f9251e
            if (r9 == 0) goto L_0x00d9
            if (r8 <= 0) goto L_0x0095
            r9.a(r3, r1, r4)
            r1 = 0
            goto L_0x0096
        L_0x0095:
            int r1 = -r8
        L_0x0096:
            androidx.media3.extractor.ts.NalUnitTargetBuffer r8 = r0.f9251e
            boolean r1 = r8.b(r1)
            if (r1 == 0) goto L_0x00c6
            androidx.media3.extractor.ts.NalUnitTargetBuffer r1 = r0.f9251e
            byte[] r8 = r1.f9443d
            int r1 = r1.f9444e
            int r1 = androidx.media3.container.NalUnitUtil.r(r8, r1)
            androidx.media3.common.util.ParsableByteArray r8 = r0.f9250d
            java.lang.Object r8 = androidx.media3.common.util.Util.i(r8)
            androidx.media3.common.util.ParsableByteArray r8 = (androidx.media3.common.util.ParsableByteArray) r8
            androidx.media3.extractor.ts.NalUnitTargetBuffer r9 = r0.f9251e
            byte[] r9 = r9.f9443d
            r8.S(r9, r1)
            androidx.media3.extractor.ts.UserDataReader r1 = r0.f9249c
            java.lang.Object r1 = androidx.media3.common.util.Util.i(r1)
            androidx.media3.extractor.ts.UserDataReader r1 = (androidx.media3.extractor.ts.UserDataReader) r1
            long r8 = r0.f9260n
            androidx.media3.common.util.ParsableByteArray r12 = r0.f9250d
            r1.a(r8, r12)
        L_0x00c6:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x00d9
            byte[] r1 = r21.e()
            int r8 = r4 + 2
            byte r1 = r1[r8]
            if (r1 != r11) goto L_0x00d9
            androidx.media3.extractor.ts.NalUnitTargetBuffer r1 = r0.f9251e
            r1.e(r5)
        L_0x00d9:
            if (r5 == 0) goto L_0x00e7
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x00e0
            goto L_0x00e7
        L_0x00e0:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x0145
            r0.f9261o = r11
            goto L_0x0145
        L_0x00e7:
            int r1 = r2 - r4
            boolean r4 = r0.f9262p
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0112
            boolean r4 = r0.f9256j
            if (r4 == 0) goto L_0x0112
            long r13 = r0.f9260n
            int r4 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0112
            boolean r15 = r0.f9261o
            long r11 = r0.f9254h
            r19 = r5
            long r4 = r0.f9259m
            long r11 = r11 - r4
            int r4 = (int) r11
            int r16 = r4 - r1
            androidx.media3.extractor.TrackOutput r12 = r0.f9248b
            r18 = 0
            r17 = r1
            r12.f(r13, r15, r16, r17, r18)
            goto L_0x0114
        L_0x0112:
            r19 = r5
        L_0x0114:
            boolean r4 = r0.f9255i
            if (r4 == 0) goto L_0x011f
            boolean r4 = r0.f9262p
            if (r4 == 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r1 = 1
            goto L_0x0140
        L_0x011f:
            long r4 = r0.f9254h
            long r11 = (long) r1
            long r4 = r4 - r11
            r0.f9259m = r4
            long r4 = r0.f9258l
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012c
            goto L_0x0137
        L_0x012c:
            long r4 = r0.f9260n
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0136
            long r11 = r0.f9257k
            long r4 = r4 + r11
            goto L_0x0137
        L_0x0136:
            r4 = r8
        L_0x0137:
            r0.f9260n = r4
            r0.f9261o = r10
            r0.f9258l = r8
            r1 = 1
            r0.f9255i = r1
        L_0x0140:
            if (r19 != 0) goto L_0x0143
            r10 = 1
        L_0x0143:
            r0.f9262p = r10
        L_0x0145:
            r1 = r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.H262Reader.b(androidx.media3.common.util.ParsableByteArray):void");
    }

    public void d(long j2, int i2) {
        this.f9258l = j2;
    }

    public void e(boolean z2) {
        Assertions.j(this.f9248b);
        if (z2) {
            boolean z3 = this.f9261o;
            this.f9248b.f(this.f9260n, z3 ? 1 : 0, (int) (this.f9254h - this.f9259m), 0, (TrackOutput.CryptoData) null);
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9247a = trackIdGenerator.b();
        this.f9248b = extractorOutput.d(trackIdGenerator.c(), 2);
        UserDataReader userDataReader = this.f9249c;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    H262Reader(UserDataReader userDataReader) {
        this.f9249c = userDataReader;
        this.f9252f = new boolean[4];
        this.f9253g = new CsdBuffer(128);
        if (userDataReader != null) {
            this.f9251e = new NalUnitTargetBuffer(178, 128);
            this.f9250d = new ParsableByteArray();
        } else {
            this.f9251e = null;
            this.f9250d = null;
        }
        this.f9258l = -9223372036854775807L;
        this.f9260n = -9223372036854775807L;
    }
}
