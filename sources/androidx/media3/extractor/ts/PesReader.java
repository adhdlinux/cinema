package androidx.media3.extractor.ts;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ts.TsPayloadReader;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class PesReader implements TsPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final ElementaryStreamReader f9448a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f9449b = new ParsableBitArray(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f9450c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f9451d;

    /* renamed from: e  reason: collision with root package name */
    private TimestampAdjuster f9452e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9453f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9454g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9455h;

    /* renamed from: i  reason: collision with root package name */
    private int f9456i;

    /* renamed from: j  reason: collision with root package name */
    private int f9457j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9458k;

    /* renamed from: l  reason: collision with root package name */
    private long f9459l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f9448a = elementaryStreamReader;
    }

    private boolean e(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f9451d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.V(min);
        } else {
            parsableByteArray.l(bArr, this.f9451d, min);
        }
        int i3 = this.f9451d + min;
        this.f9451d = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    private boolean f() {
        this.f9449b.p(0);
        int h2 = this.f9449b.h(24);
        if (h2 != 1) {
            Log.h("PesReader", "Unexpected start code prefix: " + h2);
            this.f9457j = -1;
            return false;
        }
        this.f9449b.r(8);
        int h3 = this.f9449b.h(16);
        this.f9449b.r(5);
        this.f9458k = this.f9449b.g();
        this.f9449b.r(2);
        this.f9453f = this.f9449b.g();
        this.f9454g = this.f9449b.g();
        this.f9449b.r(6);
        int h4 = this.f9449b.h(8);
        this.f9456i = h4;
        if (h3 == 0) {
            this.f9457j = -1;
        } else {
            int i2 = ((h3 + 6) - 9) - h4;
            this.f9457j = i2;
            if (i2 < 0) {
                Log.h("PesReader", "Found negative packet payload size: " + this.f9457j);
                this.f9457j = -1;
            }
        }
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    private void g() {
        this.f9449b.p(0);
        this.f9459l = -9223372036854775807L;
        if (this.f9453f) {
            this.f9449b.r(4);
            this.f9449b.r(1);
            this.f9449b.r(1);
            long h2 = (((long) this.f9449b.h(3)) << 30) | ((long) (this.f9449b.h(15) << 15)) | ((long) this.f9449b.h(15));
            this.f9449b.r(1);
            if (!this.f9455h && this.f9454g) {
                this.f9449b.r(4);
                this.f9449b.r(1);
                this.f9449b.r(1);
                this.f9449b.r(1);
                this.f9452e.b((((long) this.f9449b.h(3)) << 30) | ((long) (this.f9449b.h(15) << 15)) | ((long) this.f9449b.h(15)));
                this.f9455h = true;
            }
            this.f9459l = this.f9452e.b(h2);
        }
    }

    private void h(int i2) {
        this.f9450c = i2;
        this.f9451d = 0;
    }

    public void a() {
        this.f9450c = 0;
        this.f9451d = 0;
        this.f9455h = false;
        this.f9448a.a();
    }

    public void b(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        int i3;
        int i4;
        int i5;
        boolean z2;
        Assertions.j(this.f9452e);
        if ((i2 & 1) != 0) {
            int i6 = this.f9450c;
            if (!(i6 == 0 || i6 == 1)) {
                if (i6 == 2) {
                    Log.h("PesReader", "Unexpected start indicator reading extended header");
                } else if (i6 == 3) {
                    if (this.f9457j != -1) {
                        Log.h("PesReader", "Unexpected start indicator: expected " + this.f9457j + " more bytes");
                    }
                    if (parsableByteArray.g() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.f9448a.e(z2);
                } else {
                    throw new IllegalStateException();
                }
            }
            h(1);
        }
        while (parsableByteArray.a() > 0) {
            int i7 = this.f9450c;
            if (i7 == 0) {
                parsableByteArray.V(parsableByteArray.a());
            } else if (i7 != 1) {
                if (i7 == 2) {
                    if (e(parsableByteArray, this.f9449b.f4688a, Math.min(10, this.f9456i)) && e(parsableByteArray, (byte[]) null, this.f9456i)) {
                        g();
                        if (this.f9458k) {
                            i4 = 4;
                        } else {
                            i4 = 0;
                        }
                        i2 |= i4;
                        this.f9448a.d(this.f9459l, i2);
                        h(3);
                    }
                } else if (i7 == 3) {
                    int a2 = parsableByteArray.a();
                    int i8 = this.f9457j;
                    if (i8 == -1) {
                        i5 = 0;
                    } else {
                        i5 = a2 - i8;
                    }
                    if (i5 > 0) {
                        a2 -= i5;
                        parsableByteArray.T(parsableByteArray.f() + a2);
                    }
                    this.f9448a.b(parsableByteArray);
                    int i9 = this.f9457j;
                    if (i9 != -1) {
                        int i10 = i9 - a2;
                        this.f9457j = i10;
                        if (i10 == 0) {
                            this.f9448a.e(false);
                            h(1);
                        }
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (e(parsableByteArray, this.f9449b.f4688a, 9)) {
                if (f()) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                h(i3);
            }
        }
    }

    public void c(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f9452e = timestampAdjuster;
        this.f9448a.f(extractorOutput, trackIdGenerator);
    }

    public boolean d(boolean z2) {
        return this.f9450c == 3 && this.f9457j == -1 && (!z2 || !(this.f9448a instanceof H262Reader));
    }
}
