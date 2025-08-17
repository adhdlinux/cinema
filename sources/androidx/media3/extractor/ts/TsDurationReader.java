package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;

final class TsDurationReader {

    /* renamed from: a  reason: collision with root package name */
    private final int f9502a;

    /* renamed from: b  reason: collision with root package name */
    private final TimestampAdjuster f9503b = new TimestampAdjuster(0);

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f9504c = new ParsableByteArray();

    /* renamed from: d  reason: collision with root package name */
    private boolean f9505d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9506e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9507f;

    /* renamed from: g  reason: collision with root package name */
    private long f9508g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f9509h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private long f9510i = -9223372036854775807L;

    TsDurationReader(int i2) {
        this.f9502a = i2;
    }

    private int a(ExtractorInput extractorInput) {
        this.f9504c.R(Util.f4719f);
        this.f9505d = true;
        extractorInput.e();
        return 0;
    }

    private int f(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        int min = (int) Math.min((long) this.f9502a, extractorInput.getLength());
        long j2 = (long) 0;
        if (extractorInput.getPosition() != j2) {
            positionHolder.f8069a = j2;
            return 1;
        }
        this.f9504c.Q(min);
        extractorInput.e();
        extractorInput.m(this.f9504c.e(), 0, min);
        this.f9508g = g(this.f9504c, i2);
        this.f9506e = true;
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
        int min = (int) Math.min((long) this.f9502a, length);
        long j2 = length - ((long) min);
        if (extractorInput.getPosition() != j2) {
            positionHolder.f8069a = j2;
            return 1;
        }
        this.f9504c.Q(min);
        extractorInput.e();
        extractorInput.m(this.f9504c.e(), 0, min);
        this.f9509h = i(this.f9504c, i2);
        this.f9507f = true;
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
        return this.f9510i;
    }

    public TimestampAdjuster c() {
        return this.f9503b;
    }

    public boolean d() {
        return this.f9505d;
    }

    public int e(ExtractorInput extractorInput, PositionHolder positionHolder, int i2) throws IOException {
        if (i2 <= 0) {
            return a(extractorInput);
        }
        if (!this.f9507f) {
            return h(extractorInput, positionHolder, i2);
        }
        if (this.f9509h == -9223372036854775807L) {
            return a(extractorInput);
        }
        if (!this.f9506e) {
            return f(extractorInput, positionHolder, i2);
        }
        long j2 = this.f9508g;
        if (j2 == -9223372036854775807L) {
            return a(extractorInput);
        }
        this.f9510i = this.f9503b.c(this.f9509h) - this.f9503b.b(j2);
        return a(extractorInput);
    }
}
