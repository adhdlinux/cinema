package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class TsDurationReader {

    /* renamed from: a  reason: collision with root package name */
    private final int f25081a;

    /* renamed from: b  reason: collision with root package name */
    private final TimestampAdjuster f25082b = new TimestampAdjuster(0);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f25083c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private boolean f25084d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25085e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25086f;

    /* renamed from: g  reason: collision with root package name */
    private long f25087g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f25088h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private long f25089i = -9223372036854775807L;

    TsDurationReader(int i2) {
        this.f25081a = i2;
    }

    private int a(ExtractorInput extractorInput) {
        this.f25083c.R(Util.f28813f);
        this.f25084d = true;
        extractorInput.e();
        return 0;
    }

    private int f(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        int min = (int) Math.min((long) this.f25081a, extractorInput.getLength());
        long j2 = (long) 0;
        if (extractorInput.getPosition() != j2) {
            positionHolder.f24231a = j2;
            return 1;
        }
        this.f25083c.Q(min);
        extractorInput.e();
        extractorInput.m(this.f25083c.e(), 0, min);
        this.f25087g = g(this.f25083c, i2);
        this.f25085e = true;
        return 0;
    }

    private long g(ParsableByteArray parsableByteArray, int i2) {
        int g2 = parsableByteArray.g();
        for (int f2 = parsableByteArray.f(); f2 < g2; f2++) {
            if (parsableByteArray.e()[f2] == 71) {
                long c2 = TsUtil.c(parsableByteArray, f2, i2);
                if (c2 != -9223372036854775807L) {
                    return c2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        long length = extractorInput.getLength();
        int min = (int) Math.min((long) this.f25081a, length);
        long j2 = length - ((long) min);
        if (extractorInput.getPosition() != j2) {
            positionHolder.f24231a = j2;
            return 1;
        }
        this.f25083c.Q(min);
        extractorInput.e();
        extractorInput.m(this.f25083c.e(), 0, min);
        this.f25088h = i(this.f25083c, i2);
        this.f25086f = true;
        return 0;
    }

    private long i(ParsableByteArray parsableByteArray, int i2) {
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        for (int i3 = g2 - 188; i3 >= f2; i3--) {
            if (TsUtil.b(parsableByteArray.e(), f2, g2, i3)) {
                long c2 = TsUtil.c(parsableByteArray, i3, i2);
                if (c2 != -9223372036854775807L) {
                    return c2;
                }
            }
        }
        return -9223372036854775807L;
    }

    public long b() {
        return this.f25089i;
    }

    public TimestampAdjuster c() {
        return this.f25082b;
    }

    public boolean d() {
        return this.f25084d;
    }

    public int e(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        if (i2 <= 0) {
            return a(extractorInput);
        }
        if (!this.f25086f) {
            return h(extractorInput, positionHolder, i2);
        }
        if (this.f25088h == -9223372036854775807L) {
            return a(extractorInput);
        }
        if (!this.f25085e) {
            return f(extractorInput, positionHolder, i2);
        }
        long j2 = this.f25087g;
        if (j2 == -9223372036854775807L) {
            return a(extractorInput);
        }
        long b2 = this.f25082b.b(this.f25088h) - this.f25082b.b(j2);
        this.f25089i = b2;
        if (b2 < 0) {
            Log.i("TsDurationReader", "Invalid duration: " + this.f25089i + ". Using TIME_UNSET instead.");
            this.f25089i = -9223372036854775807L;
        }
        return a(extractorInput);
    }
}
