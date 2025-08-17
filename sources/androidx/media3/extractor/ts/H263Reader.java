package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import java.util.Arrays;
import java.util.Collections;

public final class H263Reader implements ElementaryStreamReader {

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f9268l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final UserDataReader f9269a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f9270b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean[] f9271c;

    /* renamed from: d  reason: collision with root package name */
    private final CsdBuffer f9272d;

    /* renamed from: e  reason: collision with root package name */
    private final NalUnitTargetBuffer f9273e;

    /* renamed from: f  reason: collision with root package name */
    private SampleReader f9274f;

    /* renamed from: g  reason: collision with root package name */
    private long f9275g;

    /* renamed from: h  reason: collision with root package name */
    private String f9276h;

    /* renamed from: i  reason: collision with root package name */
    private TrackOutput f9277i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9278j;

    /* renamed from: k  reason: collision with root package name */
    private long f9279k;

    private static final class CsdBuffer {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f9280f = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        private boolean f9281a;

        /* renamed from: b  reason: collision with root package name */
        private int f9282b;

        /* renamed from: c  reason: collision with root package name */
        public int f9283c;

        /* renamed from: d  reason: collision with root package name */
        public int f9284d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f9285e;

        public CsdBuffer(int i2) {
            this.f9285e = new byte[i2];
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f9281a) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f9285e;
                int length = bArr2.length;
                int i5 = this.f9283c;
                if (length < i5 + i4) {
                    this.f9285e = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f9285e, this.f9283c, i4);
                this.f9283c += i4;
            }
        }

        public boolean b(int i2, int i3) {
            int i4 = this.f9282b;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                throw new IllegalStateException();
                            } else if (i2 == 179 || i2 == 181) {
                                this.f9283c -= i3;
                                this.f9281a = false;
                                return true;
                            }
                        } else if ((i2 & 240) != 32) {
                            Log.h("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f9284d = this.f9283c;
                            this.f9282b = 4;
                        }
                    } else if (i2 > 31) {
                        Log.h("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f9282b = 3;
                    }
                } else if (i2 != 181) {
                    Log.h("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f9282b = 2;
                }
            } else if (i2 == 176) {
                this.f9282b = 1;
                this.f9281a = true;
            }
            byte[] bArr = f9280f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f9281a = false;
            this.f9283c = 0;
            this.f9282b = 0;
        }
    }

    private static final class SampleReader {

        /* renamed from: a  reason: collision with root package name */
        private final TrackOutput f9286a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9287b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9288c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9289d;

        /* renamed from: e  reason: collision with root package name */
        private int f9290e;

        /* renamed from: f  reason: collision with root package name */
        private int f9291f;

        /* renamed from: g  reason: collision with root package name */
        private long f9292g;

        /* renamed from: h  reason: collision with root package name */
        private long f9293h;

        public SampleReader(TrackOutput trackOutput) {
            this.f9286a = trackOutput;
        }

        public void a(byte[] bArr, int i2, int i3) {
            boolean z2;
            if (this.f9288c) {
                int i4 = this.f9291f;
                int i5 = (i2 + 1) - i4;
                if (i5 < i3) {
                    if (((bArr[i5] & 192) >> 6) == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f9289d = z2;
                    this.f9288c = false;
                    return;
                }
                this.f9291f = i4 + (i3 - i2);
            }
        }

        public void b(long j2, int i2, boolean z2) {
            boolean z3;
            if (this.f9293h != -9223372036854775807L) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assertions.h(z3);
            if (this.f9290e == 182 && z2 && this.f9287b) {
                boolean z4 = this.f9289d;
                this.f9286a.f(this.f9293h, z4 ? 1 : 0, (int) (j2 - this.f9292g), i2, (TrackOutput.CryptoData) null);
            }
            if (this.f9290e != 179) {
                this.f9292g = j2;
            }
        }

        public void c(int i2, long j2) {
            boolean z2;
            this.f9290e = i2;
            this.f9289d = false;
            boolean z3 = true;
            if (i2 == 182 || i2 == 179) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f9287b = z2;
            if (i2 != 182) {
                z3 = false;
            }
            this.f9288c = z3;
            this.f9291f = 0;
            this.f9293h = j2;
        }

        public void d() {
            this.f9287b = false;
            this.f9288c = false;
            this.f9289d = false;
            this.f9290e = -1;
        }
    }

    public H263Reader() {
        this((UserDataReader) null);
    }

    private static Format c(CsdBuffer csdBuffer, int i2, String str) {
        byte[] copyOf = Arrays.copyOf(csdBuffer.f9285e, csdBuffer.f9283c);
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
                Log.h("H263Reader", "Invalid aspect ratio");
            } else {
                f2 = ((float) h3) / ((float) h4);
            }
        } else {
            float[] fArr = f9268l;
            if (h2 < fArr.length) {
                f2 = fArr[h2];
            } else {
                Log.h("H263Reader", "Invalid aspect ratio");
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
            Log.h("H263Reader", "Unhandled video object layer shape");
        }
        parsableBitArray.q();
        int h5 = parsableBitArray.h(16);
        parsableBitArray.q();
        if (parsableBitArray.g()) {
            if (h5 == 0) {
                Log.h("H263Reader", "Invalid vop_increment_time_resolution");
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
        return new Format.Builder().a0(str).o0("video/mp4v-es").v0(h6).Y(h7).k0(f2).b0(Collections.singletonList(copyOf)).K();
    }

    public void a() {
        NalUnitUtil.a(this.f9271c);
        this.f9272d.c();
        SampleReader sampleReader = this.f9274f;
        if (sampleReader != null) {
            sampleReader.d();
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f9273e;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.d();
        }
        this.f9275g = 0;
        this.f9279k = -9223372036854775807L;
    }

    public void b(ParsableByteArray parsableByteArray) {
        int i2;
        Assertions.j(this.f9274f);
        Assertions.j(this.f9277i);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        byte[] e2 = parsableByteArray.e();
        this.f9275g += (long) parsableByteArray.a();
        this.f9277i.b(parsableByteArray, parsableByteArray.a());
        while (true) {
            int c2 = NalUnitUtil.c(e2, f2, g2, this.f9271c);
            if (c2 == g2) {
                break;
            }
            int i3 = c2 + 3;
            byte b2 = parsableByteArray.e()[i3] & 255;
            int i4 = c2 - f2;
            int i5 = 0;
            if (!this.f9278j) {
                if (i4 > 0) {
                    this.f9272d.a(e2, f2, c2);
                }
                if (i4 < 0) {
                    i2 = -i4;
                } else {
                    i2 = 0;
                }
                if (this.f9272d.b(b2, i2)) {
                    TrackOutput trackOutput = this.f9277i;
                    CsdBuffer csdBuffer = this.f9272d;
                    trackOutput.c(c(csdBuffer, csdBuffer.f9284d, (String) Assertions.f(this.f9276h)));
                    this.f9278j = true;
                }
            }
            this.f9274f.a(e2, f2, c2);
            NalUnitTargetBuffer nalUnitTargetBuffer = this.f9273e;
            if (nalUnitTargetBuffer != null) {
                if (i4 > 0) {
                    nalUnitTargetBuffer.a(e2, f2, c2);
                } else {
                    i5 = -i4;
                }
                if (this.f9273e.b(i5)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f9273e;
                    ((ParsableByteArray) Util.i(this.f9270b)).S(this.f9273e.f9443d, NalUnitUtil.r(nalUnitTargetBuffer2.f9443d, nalUnitTargetBuffer2.f9444e));
                    ((UserDataReader) Util.i(this.f9269a)).a(this.f9279k, this.f9270b);
                }
                if (b2 == 178 && parsableByteArray.e()[c2 + 2] == 1) {
                    this.f9273e.e(b2);
                }
            }
            int i6 = g2 - c2;
            this.f9274f.b(this.f9275g - ((long) i6), i6, this.f9278j);
            this.f9274f.c(b2, this.f9279k);
            f2 = i3;
        }
        if (!this.f9278j) {
            this.f9272d.a(e2, f2, g2);
        }
        this.f9274f.a(e2, f2, g2);
        NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f9273e;
        if (nalUnitTargetBuffer3 != null) {
            nalUnitTargetBuffer3.a(e2, f2, g2);
        }
    }

    public void d(long j2, int i2) {
        this.f9279k = j2;
    }

    public void e(boolean z2) {
        Assertions.j(this.f9274f);
        if (z2) {
            this.f9274f.b(this.f9275g, 0, this.f9278j);
            this.f9274f.d();
        }
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9276h = trackIdGenerator.b();
        TrackOutput d2 = extractorOutput.d(trackIdGenerator.c(), 2);
        this.f9277i = d2;
        this.f9274f = new SampleReader(d2);
        UserDataReader userDataReader = this.f9269a;
        if (userDataReader != null) {
            userDataReader.b(extractorOutput, trackIdGenerator);
        }
    }

    H263Reader(UserDataReader userDataReader) {
        this.f9269a = userDataReader;
        this.f9271c = new boolean[4];
        this.f9272d = new CsdBuffer(128);
        this.f9279k = -9223372036854775807L;
        if (userDataReader != null) {
            this.f9273e = new NalUnitTargetBuffer(178, 128);
            this.f9270b = new ParsableByteArray();
            return;
        }
        this.f9273e = null;
        this.f9270b = null;
    }
}
