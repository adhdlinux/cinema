package androidx.media3.extractor.ts;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ts.MpeghUtil;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class MpeghReader implements ElementaryStreamReader {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f9412a = new ParsableByteArray(new byte[15], 2);

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f9413b = new ParsableBitArray();

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f9414c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private int f9415d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f9416e;

    /* renamed from: f  reason: collision with root package name */
    private TrackOutput f9417f;

    /* renamed from: g  reason: collision with root package name */
    private double f9418g = -9.223372036854776E18d;

    /* renamed from: h  reason: collision with root package name */
    private double f9419h = -9.223372036854776E18d;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9420i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9421j = true;

    /* renamed from: k  reason: collision with root package name */
    private int f9422k;

    /* renamed from: l  reason: collision with root package name */
    private int f9423l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9424m = true;

    /* renamed from: n  reason: collision with root package name */
    private int f9425n;

    /* renamed from: o  reason: collision with root package name */
    private int f9426o;

    /* renamed from: p  reason: collision with root package name */
    private MpeghUtil.MhasPacketHeader f9427p = new MpeghUtil.MhasPacketHeader();

    /* renamed from: q  reason: collision with root package name */
    private int f9428q = -2147483647;

    /* renamed from: r  reason: collision with root package name */
    private int f9429r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f9430s;

    /* renamed from: t  reason: collision with root package name */
    private long f9431t = -1;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9432u;

    private void c(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z2) {
        int f2 = parsableByteArray.f();
        int min = Math.min(parsableByteArray.a(), parsableByteArray2.a());
        parsableByteArray.l(parsableByteArray2.e(), parsableByteArray2.f(), min);
        parsableByteArray2.V(min);
        if (z2) {
            parsableByteArray.U(f2);
        }
    }

    @RequiresNonNull({"output"})
    private void g() {
        int i2;
        if (this.f9432u) {
            this.f9421j = false;
            i2 = 1;
        } else {
            i2 = 0;
        }
        double d2 = (((double) (this.f9429r - this.f9430s)) * 1000000.0d) / ((double) this.f9428q);
        long round = Math.round(this.f9418g);
        if (this.f9420i) {
            this.f9420i = false;
            this.f9418g = this.f9419h;
        } else {
            this.f9418g += d2;
        }
        this.f9417f.f(round, i2, this.f9426o, 0, (TrackOutput.CryptoData) null);
        this.f9432u = false;
        this.f9430s = 0;
        this.f9426o = 0;
    }

    @RequiresNonNull({"output"})
    private void h(ParsableBitArray parsableBitArray) throws ParserException {
        ImmutableList immutableList;
        MpeghUtil.Mpegh3daConfig h2 = MpeghUtil.h(parsableBitArray);
        this.f9428q = h2.f9437b;
        this.f9429r = h2.f9438c;
        long j2 = this.f9431t;
        long j3 = this.f9427p.f9434b;
        if (j2 != j3) {
            this.f9431t = j3;
            String str = "mhm1";
            if (h2.f9436a != -1) {
                str = str + String.format(".%02X", new Object[]{Integer.valueOf(h2.f9436a)});
            }
            byte[] bArr = h2.f9439d;
            if (bArr == null || bArr.length <= 0) {
                immutableList = null;
            } else {
                immutableList = ImmutableList.t(Util.f4719f, bArr);
            }
            this.f9417f.c(new Format.Builder().a0(this.f9416e).o0("audio/mhm1").p0(this.f9428q).O(str).b0(immutableList).K());
        }
        this.f9432u = true;
    }

    private boolean i() throws ParserException {
        int g2 = this.f9412a.g();
        this.f9413b.o(this.f9412a.e(), g2);
        boolean g3 = MpeghUtil.g(this.f9413b, this.f9427p);
        if (g3) {
            this.f9425n = 0;
            this.f9426o += this.f9427p.f9435c + g2;
        }
        return g3;
    }

    private boolean j(int i2) {
        return i2 == 1 || i2 == 17;
    }

    private boolean k(ParsableByteArray parsableByteArray) {
        int i2 = this.f9422k;
        if ((i2 & 2) == 0) {
            parsableByteArray.U(parsableByteArray.g());
            return false;
        } else if ((i2 & 4) != 0) {
            return true;
        } else {
            while (parsableByteArray.a() > 0) {
                int i3 = this.f9423l << 8;
                this.f9423l = i3;
                int H = i3 | parsableByteArray.H();
                this.f9423l = H;
                if (MpeghUtil.e(H)) {
                    parsableByteArray.U(parsableByteArray.f() - 3);
                    this.f9423l = 0;
                    return true;
                }
            }
            return false;
        }
    }

    @RequiresNonNull({"output"})
    private void l(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f9427p.f9435c - this.f9425n);
        this.f9417f.b(parsableByteArray, min);
        this.f9425n += min;
    }

    public void a() {
        this.f9415d = 0;
        this.f9423l = 0;
        this.f9412a.Q(2);
        this.f9425n = 0;
        this.f9426o = 0;
        this.f9428q = -2147483647;
        this.f9429r = -1;
        this.f9430s = 0;
        this.f9431t = -1;
        this.f9432u = false;
        this.f9420i = false;
        this.f9424m = true;
        this.f9421j = true;
        this.f9418g = -9.223372036854776E18d;
        this.f9419h = -9.223372036854776E18d;
    }

    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        Assertions.j(this.f9417f);
        while (parsableByteArray.a() > 0) {
            int i2 = this.f9415d;
            if (i2 != 0) {
                if (i2 == 1) {
                    c(parsableByteArray, this.f9412a, false);
                    if (this.f9412a.a() != 0) {
                        this.f9424m = false;
                    } else if (i()) {
                        this.f9412a.U(0);
                        TrackOutput trackOutput = this.f9417f;
                        ParsableByteArray parsableByteArray2 = this.f9412a;
                        trackOutput.b(parsableByteArray2, parsableByteArray2.g());
                        this.f9412a.Q(2);
                        this.f9414c.Q(this.f9427p.f9435c);
                        this.f9424m = true;
                        this.f9415d = 2;
                    } else if (this.f9412a.g() < 15) {
                        ParsableByteArray parsableByteArray3 = this.f9412a;
                        parsableByteArray3.T(parsableByteArray3.g() + 1);
                        this.f9424m = false;
                    }
                } else if (i2 == 2) {
                    if (j(this.f9427p.f9433a)) {
                        c(parsableByteArray, this.f9414c, true);
                    }
                    l(parsableByteArray);
                    int i3 = this.f9425n;
                    MpeghUtil.MhasPacketHeader mhasPacketHeader = this.f9427p;
                    if (i3 == mhasPacketHeader.f9435c) {
                        int i4 = mhasPacketHeader.f9433a;
                        if (i4 == 1) {
                            h(new ParsableBitArray(this.f9414c.e()));
                        } else if (i4 == 17) {
                            this.f9430s = MpeghUtil.f(new ParsableBitArray(this.f9414c.e()));
                        } else if (i4 == 2) {
                            g();
                        }
                        this.f9415d = 1;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (k(parsableByteArray)) {
                this.f9415d = 1;
            }
        }
    }

    public void d(long j2, int i2) {
        this.f9422k = i2;
        if (!this.f9421j && (this.f9426o != 0 || !this.f9424m)) {
            this.f9420i = true;
        }
        if (j2 == -9223372036854775807L) {
            return;
        }
        if (this.f9420i) {
            this.f9419h = (double) j2;
        } else {
            this.f9418g = (double) j2;
        }
    }

    public void e(boolean z2) {
    }

    public void f(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.f9416e = trackIdGenerator.b();
        this.f9417f = extractorOutput.d(trackIdGenerator.c(), 1);
    }
}
