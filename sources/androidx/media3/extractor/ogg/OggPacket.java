package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorUtil;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f8728a = new OggPageHeader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f8729b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f8730c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f8731d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8732e;

    OggPacket() {
    }

    private int a(int i2) {
        int i3;
        int i4 = 0;
        this.f8731d = 0;
        do {
            int i5 = this.f8731d;
            int i6 = i2 + i5;
            OggPageHeader oggPageHeader = this.f8728a;
            if (i6 >= oggPageHeader.f8739g) {
                break;
            }
            int[] iArr = oggPageHeader.f8742j;
            this.f8731d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public OggPageHeader b() {
        return this.f8728a;
    }

    public ParsableByteArray c() {
        return this.f8729b;
    }

    public boolean d(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        boolean z3;
        int i2;
        if (extractorInput != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.f8732e) {
            this.f8732e = false;
            this.f8729b.Q(0);
        }
        while (!this.f8732e) {
            if (this.f8730c < 0) {
                if (!this.f8728a.c(extractorInput) || !this.f8728a.a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.f8728a;
                int i3 = oggPageHeader.f8740h;
                if ((oggPageHeader.f8734b & 1) == 1 && this.f8729b.g() == 0) {
                    i3 += a(0);
                    i2 = this.f8731d + 0;
                } else {
                    i2 = 0;
                }
                if (!ExtractorUtil.e(extractorInput, i3)) {
                    return false;
                }
                this.f8730c = i2;
            }
            int a2 = a(this.f8730c);
            int i4 = this.f8730c + this.f8731d;
            if (a2 > 0) {
                ParsableByteArray parsableByteArray = this.f8729b;
                parsableByteArray.c(parsableByteArray.g() + a2);
                if (!ExtractorUtil.d(extractorInput, this.f8729b.e(), this.f8729b.g(), a2)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.f8729b;
                parsableByteArray2.T(parsableByteArray2.g() + a2);
                if (this.f8728a.f8742j[i4 - 1] != 255) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f8732e = z3;
            }
            if (i4 == this.f8728a.f8739g) {
                i4 = -1;
            }
            this.f8730c = i4;
        }
        return true;
    }

    public void e() {
        this.f8728a.b();
        this.f8729b.Q(0);
        this.f8730c = -1;
        this.f8732e = false;
    }

    public void f() {
        if (this.f8729b.e().length != 65025) {
            ParsableByteArray parsableByteArray = this.f8729b;
            parsableByteArray.S(Arrays.copyOf(parsableByteArray.e(), Math.max(65025, this.f8729b.g())), this.f8729b.g());
        }
    }
}
