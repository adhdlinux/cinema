package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class Sniffer {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f24486a = new ParsableByteArray(8);

    /* renamed from: b  reason: collision with root package name */
    private int f24487b;

    private long a(ExtractorInput extractorInput) throws IOException {
        int i2 = 0;
        extractorInput.m(this.f24486a.e(), 0, 1);
        byte b2 = this.f24486a.e()[0] & 255;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((b2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = b2 & (~i3);
        extractorInput.m(this.f24486a.e(), 1, i4);
        while (i2 < i4) {
            i2++;
            i5 = (this.f24486a.e()[i2] & 255) + (i5 << 8);
        }
        this.f24487b += i4 + 1;
        return (long) i5;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        long a2;
        int i2;
        long length = extractorInput.getLength();
        long j2 = 1024;
        int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j2 = length;
        }
        int i4 = (int) j2;
        extractorInput.m(this.f24486a.e(), 0, 4);
        long J = this.f24486a.J();
        this.f24487b = 4;
        while (J != 440786851) {
            int i5 = this.f24487b + 1;
            this.f24487b = i5;
            if (i5 == i4) {
                return false;
            }
            extractorInput.m(this.f24486a.e(), 0, 1);
            J = ((J << 8) & -256) | ((long) (this.f24486a.e()[0] & 255));
        }
        long a3 = a(extractorInput);
        long j3 = (long) this.f24487b;
        if (a3 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j3 + a3 >= length) {
            return false;
        }
        while (true) {
            int i6 = this.f24487b;
            long j4 = j3 + a3;
            if (((long) i6) < j4) {
                if (a(extractorInput) != Long.MIN_VALUE && a2 >= 0 && a2 <= 2147483647L) {
                    if (i2 != 0) {
                        int a4 = (int) (a2 = a(extractorInput));
                        extractorInput.h(a4);
                        this.f24487b += a4;
                    }
                }
            } else if (((long) i6) == j4) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
