package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class PesReader implements TsPayloadReader {

    /* renamed from: a  reason: collision with root package name */
    private final ElementaryStreamReader f25027a;

    /* renamed from: b  reason: collision with root package name */
    private final ParsableBitArray f25028b = new ParsableBitArray(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f25029c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f25030d;

    /* renamed from: e  reason: collision with root package name */
    private TimestampAdjuster f25031e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25032f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25033g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25034h;

    /* renamed from: i  reason: collision with root package name */
    private int f25035i;

    /* renamed from: j  reason: collision with root package name */
    private int f25036j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25037k;

    /* renamed from: l  reason: collision with root package name */
    private long f25038l;

    public PesReader(ElementaryStreamReader elementaryStreamReader) {
        this.f25027a = elementaryStreamReader;
    }

    private boolean d(ParsableByteArray parsableByteArray, byte[] bArr, int i2) {
        int min = Math.min(parsableByteArray.a(), i2 - this.f25030d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.V(min);
        } else {
            parsableByteArray.l(bArr, this.f25030d, min);
        }
        int i3 = this.f25030d + min;
        this.f25030d = i3;
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    private boolean e() {
        this.f25028b.p(0);
        int h2 = this.f25028b.h(24);
        if (h2 != 1) {
            Log.i("PesReader", "Unexpected start code prefix: " + h2);
            this.f25036j = -1;
            return false;
        }
        this.f25028b.r(8);
        int h3 = this.f25028b.h(16);
        this.f25028b.r(5);
        this.f25037k = this.f25028b.g();
        this.f25028b.r(2);
        this.f25032f = this.f25028b.g();
        this.f25033g = this.f25028b.g();
        this.f25028b.r(6);
        int h4 = this.f25028b.h(8);
        this.f25035i = h4;
        if (h3 == 0) {
            this.f25036j = -1;
        } else {
            int i2 = ((h3 + 6) - 9) - h4;
            this.f25036j = i2;
            if (i2 < 0) {
                Log.i("PesReader", "Found negative packet payload size: " + this.f25036j);
                this.f25036j = -1;
            }
        }
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    private void f() {
        this.f25028b.p(0);
        this.f25038l = -9223372036854775807L;
        if (this.f25032f) {
            this.f25028b.r(4);
            this.f25028b.r(1);
            this.f25028b.r(1);
            long h2 = (((long) this.f25028b.h(3)) << 30) | ((long) (this.f25028b.h(15) << 15)) | ((long) this.f25028b.h(15));
            this.f25028b.r(1);
            if (!this.f25034h && this.f25033g) {
                this.f25028b.r(4);
                this.f25028b.r(1);
                this.f25028b.r(1);
                this.f25028b.r(1);
                this.f25031e.b((((long) this.f25028b.h(3)) << 30) | ((long) (this.f25028b.h(15) << 15)) | ((long) this.f25028b.h(15)));
                this.f25034h = true;
            }
            this.f25038l = this.f25031e.b(h2);
        }
    }

    private void g(int i2) {
        this.f25029c = i2;
        this.f25030d = 0;
    }

    public final void a() {
        this.f25029c = 0;
        this.f25030d = 0;
        this.f25034h = false;
        this.f25027a.a();
    }

    public void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        this.f25031e = timestampAdjuster;
        this.f25027a.e(extractorOutput, trackIdGenerator);
    }

    public final void c(ParsableByteArray parsableByteArray, int i2) throws ParserException {
        Assertions.i(this.f25031e);
        if ((i2 & 1) != 0) {
            int i3 = this.f25029c;
            if (!(i3 == 0 || i3 == 1)) {
                if (i3 == 2) {
                    Log.i("PesReader", "Unexpected start indicator reading extended header");
                } else if (i3 == 3) {
                    if (this.f25036j != -1) {
                        Log.i("PesReader", "Unexpected start indicator: expected " + this.f25036j + " more bytes");
                    }
                    this.f25027a.f();
                } else {
                    throw new IllegalStateException();
                }
            }
            g(1);
        }
        while (parsableByteArray.a() > 0) {
            int i4 = this.f25029c;
            if (i4 != 0) {
                int i5 = 0;
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (d(parsableByteArray, this.f25028b.f28757a, Math.min(10, this.f25035i)) && d(parsableByteArray, (byte[]) null, this.f25035i)) {
                            f();
                            if (this.f25037k) {
                                i5 = 4;
                            }
                            i2 |= i5;
                            this.f25027a.d(this.f25038l, i2);
                            g(3);
                        }
                    } else if (i4 == 3) {
                        int a2 = parsableByteArray.a();
                        int i6 = this.f25036j;
                        if (i6 != -1) {
                            i5 = a2 - i6;
                        }
                        if (i5 > 0) {
                            a2 -= i5;
                            parsableByteArray.T(parsableByteArray.f() + a2);
                        }
                        this.f25027a.c(parsableByteArray);
                        int i7 = this.f25036j;
                        if (i7 != -1) {
                            int i8 = i7 - a2;
                            this.f25036j = i8;
                            if (i8 == 0) {
                                this.f25027a.f();
                                g(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (d(parsableByteArray, this.f25028b.f28757a, 9)) {
                    if (e()) {
                        i5 = 2;
                    }
                    g(i5);
                }
            } else {
                parsableByteArray.V(parsableByteArray.a());
            }
        }
    }
}
