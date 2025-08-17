package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class PsDurationReader {

    /* renamed from: a  reason: collision with root package name */
    private final TimestampAdjuster f25041a = new TimestampAdjuster(0);

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f25042b = new ParsableByteArray();

    /* renamed from: c  reason: collision with root package name */
    private boolean f25043c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25044d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25045e;

    /* renamed from: f  reason: collision with root package name */
    private long f25046f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f25047g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f25048h = -9223372036854775807L;

    PsDurationReader() {
    }

    private static boolean a(byte[] bArr) {
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return true;
        }
        return false;
    }

    private int b(ExtractorInput extractorInput) {
        this.f25042b.R(Util.f28813f);
        this.f25043c = true;
        extractorInput.e();
        return 0;
    }

    private int f(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int min = (int) Math.min(20000, extractorInput.getLength());
        long j2 = (long) 0;
        if (extractorInput.getPosition() != j2) {
            positionHolder.f24231a = j2;
            return 1;
        }
        this.f25042b.Q(min);
        extractorInput.e();
        extractorInput.m(this.f25042b.e(), 0, min);
        this.f25046f = i(this.f25042b);
        this.f25044d = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray) {
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2 - 3; f2++) {
            if (f(parsableByteArray.e(), f2) == 442) {
                parsableByteArray.U(f2 + 4);
                long l2 = l(parsableByteArray);
                if (l2 != -9223372036854775807L) {
                    return l2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        long length = extractorInput.getLength();
        int min = (int) Math.min(20000, length);
        long j2 = length - ((long) min);
        if (extractorInput.getPosition() != j2) {
            positionHolder.f24231a = j2;
            return 1;
        }
        this.f25042b.Q(min);
        extractorInput.e();
        extractorInput.m(this.f25042b.e(), 0, min);
        this.f25047g = k(this.f25042b);
        this.f25045e = true;
        return 0;
    }

    private long k(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        for (int g2 = parsableByteArray.g() - 4; g2 >= f2; g2--) {
            if (f(parsableByteArray.e(), g2) == 442) {
                parsableByteArray.U(g2 + 4);
                long l2 = l(parsableByteArray);
                if (l2 != -9223372036854775807L) {
                    return l2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(ParsableByteArray parsableByteArray) {
        int f2 = parsableByteArray.f();
        if (parsableByteArray.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.l(bArr, 0, 9);
        parsableByteArray.U(f2);
        if (!a(bArr)) {
            return -9223372036854775807L;
        }
        return m(bArr);
    }

    private static long m(byte[] bArr) {
        byte b2 = bArr[0];
        byte b3 = bArr[2];
        return (((((long) b2) & 56) >> 3) << 30) | ((((long) b2) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) b3) & 248) >> 3) << 15) | ((((long) b3) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public long c() {
        return this.f25048h;
    }

    public TimestampAdjuster d() {
        return this.f25041a;
    }

    public boolean e() {
        return this.f25043c;
    }

    public int g(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (!this.f25045e) {
            return j(extractorInput, positionHolder);
        }
        if (this.f25047g == -9223372036854775807L) {
            return b(extractorInput);
        }
        if (!this.f25044d) {
            return h(extractorInput, positionHolder);
        }
        long j2 = this.f25046f;
        if (j2 == -9223372036854775807L) {
            return b(extractorInput);
        }
        long b2 = this.f25041a.b(this.f25047g) - this.f25041a.b(j2);
        this.f25048h = b2;
        if (b2 < 0) {
            Log.i("PsDurationReader", "Invalid duration: " + this.f25048h + ". Using TIME_UNSET instead.");
            this.f25048h = -9223372036854775807L;
        }
        return b(extractorInput);
    }
}
