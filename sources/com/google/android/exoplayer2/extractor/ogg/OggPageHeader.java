package com.google.android.exoplayer2.extractor.ogg;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class OggPageHeader {

    /* renamed from: a  reason: collision with root package name */
    public int f24730a;

    /* renamed from: b  reason: collision with root package name */
    public int f24731b;

    /* renamed from: c  reason: collision with root package name */
    public long f24732c;

    /* renamed from: d  reason: collision with root package name */
    public long f24733d;

    /* renamed from: e  reason: collision with root package name */
    public long f24734e;

    /* renamed from: f  reason: collision with root package name */
    public long f24735f;

    /* renamed from: g  reason: collision with root package name */
    public int f24736g;

    /* renamed from: h  reason: collision with root package name */
    public int f24737h;

    /* renamed from: i  reason: collision with root package name */
    public int f24738i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f24739j = new int[JfifUtil.MARKER_FIRST_BYTE];

    /* renamed from: k  reason: collision with root package name */
    private final ParsableByteArray f24740k = new ParsableByteArray((int) JfifUtil.MARKER_FIRST_BYTE);

    OggPageHeader() {
    }

    public boolean a(ExtractorInput extractorInput, boolean z2) throws IOException {
        b();
        this.f24740k.Q(27);
        if (!ExtractorUtil.b(extractorInput, this.f24740k.e(), 0, 27, z2) || this.f24740k.J() != 1332176723) {
            return false;
        }
        int H = this.f24740k.H();
        this.f24730a = H;
        if (H == 0) {
            this.f24731b = this.f24740k.H();
            this.f24732c = this.f24740k.v();
            this.f24733d = this.f24740k.x();
            this.f24734e = this.f24740k.x();
            this.f24735f = this.f24740k.x();
            int H2 = this.f24740k.H();
            this.f24736g = H2;
            this.f24737h = H2 + 27;
            this.f24740k.Q(H2);
            if (!ExtractorUtil.b(extractorInput, this.f24740k.e(), 0, this.f24736g, z2)) {
                return false;
            }
            for (int i2 = 0; i2 < this.f24736g; i2++) {
                this.f24739j[i2] = this.f24740k.H();
                this.f24738i += this.f24739j[i2];
            }
            return true;
        } else if (z2) {
            return false;
        } else {
            throw ParserException.e("unsupported bit stream revision");
        }
    }

    public void b() {
        this.f24730a = 0;
        this.f24731b = 0;
        this.f24732c = 0;
        this.f24733d = 0;
        this.f24734e = 0;
        this.f24735f = 0;
        this.f24736g = 0;
        this.f24737h = 0;
        this.f24738i = 0;
    }

    public boolean c(ExtractorInput extractorInput) throws IOException {
        return d(extractorInput, -1);
    }

    public boolean d(ExtractorInput extractorInput, long j2) throws IOException {
        boolean z2;
        int i2;
        if (extractorInput.getPosition() == extractorInput.g()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f24740k.Q(4);
        while (true) {
            i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if ((i2 == 0 || extractorInput.getPosition() + 4 < j2) && ExtractorUtil.b(extractorInput, this.f24740k.e(), 0, 4, true)) {
                this.f24740k.U(0);
                if (this.f24740k.J() == 1332176723) {
                    extractorInput.e();
                    return true;
                }
                extractorInput.k(1);
            }
        }
        do {
            if ((i2 != 0 && extractorInput.getPosition() >= j2) || extractorInput.a(1) == -1) {
                return false;
            }
            break;
        } while (extractorInput.a(1) == -1);
        return false;
    }
}
