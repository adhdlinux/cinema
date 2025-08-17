package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;

public final class H263Reader implements ElementaryStreamReader {

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f24878l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final UserDataReader f24879a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24880b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean[] f24881c;

    /* renamed from: d  reason: collision with root package name */
    private final CsdBuffer f24882d;

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f24883e;

    /* renamed from: f  reason: collision with root package name */
    private SampleReader f24884f;

    /* renamed from: g  reason: collision with root package name */
    private long f24885g;

    /* renamed from: h  reason: collision with root package name */
    private String f24886h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f24887i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24888j;

    /* renamed from: k  reason: collision with root package name */
    private long f24889k;

    private static final class CsdBuffer {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f24890f = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f24891a;

        /* renamed from: b  reason: collision with root package name */
        private int f24892b;

        /* renamed from: c  reason: collision with root package name */
        public int f24893c;

        /* renamed from: d  reason: collision with root package name */
        public int f24894d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f24895e;

        public CsdBuffer(int i2) {
            this.f24895e = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f24891a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f24895e;
                int length = bArr2.length;
                int i5 = this.f24893c;
                if (length < i5 + i4) {
                    this.f24895e = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f24895e, this.f24893c, i4);
                this.f24893c += i4;
            }
        }

        public boolean b(int i2, int i3) {
            int i4 = this.f24892b;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                throw new IllegalStateException();
                            } else if (i2 == 179 || i2 == 181) {
                                this.f24893c -= i3;
                                this.f24891a = false;
                                return true;
                            }
                        } else if ((i2 & 240) != 32) {
                            Log.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f24894d = this.f24893c;
                            this.f24892b = 4;
                        }
                    } else if (i2 > 31) {
                        Log.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f24892b = 3;
                    }
                } else if (i2 != 181) {
                    Log.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f24892b = 2;
                }
            } else if (i2 == 176) {
                this.f24892b = 1;
                this.f24891a = true;
            }
            byte[] bArr = f24890f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f24891a = false;
            this.f24893c = 0;
            this.f24892b = 0;
        }
    }

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f24896a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f24897b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f24898c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24899d;

        /* renamed from: e  reason: collision with root package name */
        private int f24900e;

        /* renamed from: f  reason: collision with root package name */
        private int f24901f;

        /* renamed from: g  reason: collision with root package name */
        private long f24902g;

        /* renamed from: h  reason: collision with root package name */
        private long f24903h;

        public SampleReader(TrackOutput trackOutput) {
            this.f24896a = trackOutput;
        }

        public void a(byte[] bArr, int i2, int i3) {
            boolean z2;
            if (this.f24898c) {
                int i4 = this.f24901f;
                int i5 = (i2 + 1) - i4;
                if (i5 < i3) {
                    if (((bArr[i5] & 192) >> 6) == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f24899d = z2;
                    this.f24898c = false;
                    return;
                }
                this.f24901f = i4 + (i3 - i2);
            }
        }

        public void b(long j2, int i2, boolean z2) {
            if (this.f24900e == 182 && z2 && this.f24897b) {
                long j3 = this.f24903h;
                if (j3 != -9223372036854775807L) {
                    int i3 = (int) (j2 - this.f24902g);
                    this.f24896a.e(j3, this.f24899d ? 1 : 0, i3, i2, (TrackOutput.CryptoData) null);
                }
            }
            if (this.f24900e != 179) {
                this.f24902g = j2;
            }
        }

        public void c(int i2, long j2) {
            boolean z2;
            this.f24900e = i2;
            this.f24899d = false;
            boolean z3 = true;
            if (i2 == 182 || i2 == 179) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f24897b = z2;
            if (i2 != 182) {
                z3 = false;
            }
            this.f24898c = z3;
            this.f24901f = 0;
            this.f24903h = j2;
        }

        public void d() {
            this.f24897b = false;
            this.f24898c = false;
            this.f24899d = false;
            this.f24900e = -1;
        }
    }

    public H263Reader() {
        this((UserDataReader) null);
    }

    private static Format b(CsdBuffer csdBuffer, int i2, String str) {
        byte[] copyOf = Arrays.copyOf(csdBuffer.f24895e, csdBuffer.f24893c);
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        parsableBitArray.s(i2);
        parsableBitArray.s(4);
        parsableBitArray.q();
        parsableBitArray.r(8);
        if (parsableBitArray.g()) {
            parsableBitArray.r(4);
            parsableBitArray.r(3);
        }
        int h2 = parsableBitArray.h(4);
        float f2 = 1.0f;
        if (h2 == 15) {
            int h3 = parsableBitArray.h(8);
            int h4 = parsableBitArray.h(8);
            if (h4 == 0) {
                Log.i("H263Reader", "Invalid aspect ratio");
            } else {
                f2 = ((float) h3) / ((float) h4);
            }
        } else {
            float[] fArr = f24878l;
            if (h2 < fArr.length) {
                f2 = fArr[h2];
            } else {
                Log.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(2);
            parsableBitArray.r(1);
            if (parsableBitArray.g()) {
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(3);
                parsableBitArray.r(11);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
            }
        }
        if (parsableBitArray.h(2) != 0) {
            Log.i("H263Reader", "Unhandled video object layer shape");
        }
        parsableBitArray.q();
        int h5 = parsableBitArray.h(16);
        parsableBitArray.q();
        if (parsableBitArray.g()) {
            if (h5 == 0) {
                Log.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i3 = 0;
                for (int i4 = h5 - 1; i4 > 0; i4 >>= 1) {
                    i3++;
                }
                parsableBitArray.r(i3);
            }
        }
        parsableBitArray.q();
        int h6 = parsableBitArray.h(13);
        parsableBitArray.q();
        int h7 = parsableBitArray.h(13);
        parsableBitArray.q();
        parsableBitArray.q();
        return new Format.Builder().U(str).g0("video/mp4v-es").n0(h6).S(h7).c0(f2).V(Collections.singletonList(copyOf)).G();
    }

    public void a() {
        NalUnitUtil.a(this.f24881c);
        this.f24882d.c();
        SampleReader sampleReader = this.f24884f;
        if (sampleReader != null) {
            sampleReader.d();
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f24883e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f24885g = 0;
        this.f24889k = -9223372036854775807L;
    }

    public void c(ParsableByteArray parsableByteArray) {
        int i2;
        Assertions.i(this.f24884f);
        Assertions.i(this.f24887i);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f24885g += (long) parsableByteArray.a();
        this.f24887i.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f24881c);
            if (c2 == g2) {
                break;
            }
            int i3 = c2 + 3;
            byte b2 = parsableByteArray.e()[i3] & 255;
            int i4 = c2 - f2;
            int i5 = 0;
            if (!this.f24888j) {
                if (i4 > 0) {
                    this.f24882d.a(e2, f2, c2);
                }
                if (i4 < 0) {
                    i2 = -i4;
                } else {
                    i2 = 0;
                }
                if (this.f24882d.b(b2, i2)) {
                    TrackOutput trackOutput = this.f24887i;
                    CsdBuffer csdBuffer = this.f24882d;
                    trackOutput.d(b(csdBuffer, csdBuffer.f24894d, (String) Assertions.e(this.f24886h)));
                    this.f24888j = true;
                }
            }
            this.f24884f.a(e2, f2, c2);
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f24883e;
            if (nalUnitTargetBuffer != null) {
                if (i4 > 0) {
                    nalUnitTargetBuffer.a(e2, f2, c2);
                } else {
                    i5 = -i4;
                }
                if (this.f24883e.b(i5)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f24883e;
                    ((ParsableByteArray) Util.j(this.f24880b)).S(this.f24883e.f25022d, NalUnitUtil.q(nalUnitTargetBuffer2.f25022d, nalUnitTargetBuffer2.f25023e));
                    ((UserDataReader) Util.j(this.f24879a)).a(this.f24889k, this.f24880b);
                }
                if (b2 == 178 && parsableByteArray.e()[c2 + 2] == 1) {
                    this.f24883e.e(b2);
                }
            }
            int i6 = g2 - c2;
            this.f24884f.b(this.f24885g - ((long) i6), i6, this.f24888j);
            this.f24884f.c(b2, this.f24889k);
            f2 = i3;
        }
        if (!this.f24888j) {
            this.f24882d.a(e2, f2, g2);
        }
        this.f24884f.a(e2, f2, g2);
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f24883e;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(e2, f2, g2);
        }
    }

    public void d(long j2, int i2) {
        if (j2 != -9223372036854775807L) {
            this.f24889k = j2;
        }
    }

    public void e(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f24886h = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f24887i = d2;
        this.f24884f = new SampleReader(d2);
        UserDataReader userDataReader = this.f24879a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    public void f() {
    }

    H263Reader(UserDataReader userDataReader) {
        this.f24879a = userDataReader;
        this.f24881c = new boolean[4];
        this.f24882d = new CsdBuffer(128);
        this.f24889k = -9223372036854775807L;
        if (userDataReader != null) {
            this.f24883e = new NalUnitTargetBuffer(178, 128);
            this.f24880b = new ParsableByteArray();
            return;
        }
        this.f24883e = null;
        this.f24880b = null;
    }
}
