package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {

    /* renamed from: a  reason: collision with root package name */
    private final OggPageHeader f24725a = new OggPageHeader();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f24726b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c  reason: collision with root package name */
    private int f24727c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f24728d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24729e;

    OggPacket() {
    }

    private int a(int i2) {
        int i3;
        int i4 = 0;
        this.f24728d = 0;
        do {
            int i5 = this.f24728d;
            int i6 = i2 + i5;
            OggPageHeader oggPageHeader = this.f24725a;
            if (i6 >= oggPageHeader.f24736g) {
                break;
            }
            int[] iArr = oggPageHeader.f24739j;
            this.f24728d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public OggPageHeader b() {
        return this.f24725a;
    }

    public ParsableByteArray c() {
        return this.f24726b;
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
        Assertions.g(z2);
        if (this.f24729e) {
            this.f24729e = false;
            this.f24726b.Q(0);
        }
        while (!this.f24729e) {
            if (this.f24727c < 0) {
                if (!this.f24725a.c(extractorInput) || !this.f24725a.a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.f24725a;
                int i3 = oggPageHeader.f24737h;
                if ((oggPageHeader.f24731b & 1) == 1 && this.f24726b.g() == 0) {
                    i3 += a(0);
                    i2 = this.f24728d + 0;
                } else {
                    i2 = 0;
                }
                if (!ExtractorUtil.e(extractorInput, i3)) {
                    return false;
                }
                this.f24727c = i2;
            }
            int a2 = a(this.f24727c);
            int i4 = this.f24727c + this.f24728d;
            if (a2 > 0) {
                ParsableByteArray parsableByteArray = this.f24726b;
                parsableByteArray.c(parsableByteArray.g() + a2);
                if (!ExtractorUtil.d(extractorInput, this.f24726b.e(), this.f24726b.g(), a2)) {
                    return false;
                }
                ParsableByteArray parsableByteArray2 = this.f24726b;
                parsableByteArray2.T(parsableByteArray2.g() + a2);
                if (this.f24725a.f24739j[i4 - 1] != 255) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f24729e = z3;
            }
            if (i4 == this.f24725a.f24736g) {
                i4 = -1;
            }
            this.f24727c = i4;
        }
        return true;
    }

    public void e() {
        this.f24725a.b();
        this.f24726b.Q(0);
        this.f24727c = -1;
        this.f24729e = false;
    }

    public void f() {
        if (this.f24726b.e().length != 65025) {
            ParsableByteArray parsableByteArray = this.f24726b;
            parsableByteArray.S(Arrays.copyOf(parsableByteArray.e(), Math.max(65025, this.f24726b.g())), this.f24726b.g());
        }
    }
}
