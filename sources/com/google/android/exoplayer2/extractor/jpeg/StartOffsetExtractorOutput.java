package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class StartOffsetExtractorOutput implements ExtractorOutput {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f24408b;

    /* renamed from: c  reason: collision with root package name */
    private final ExtractorOutput f24409c;

    public StartOffsetExtractorOutput(long j2, ExtractorOutput extractorOutput) {
        this.f24408b = j2;
        this.f24409c = extractorOutput;
    }

    public TrackOutput d(int i2, int i3) {
        return this.f24409c.d(i2, i3);
    }

    public void m() {
        this.f24409c.m();
    }

    public void u(final SeekMap seekMap) {
        this.f24409c.u(new SeekMap() {
            public SeekMap.SeekPoints d(long j2) {
                SeekMap.SeekPoints d2 = seekMap.d(j2);
                SeekPoint seekPoint = d2.f24232a;
                SeekPoint seekPoint2 = new SeekPoint(seekPoint.f24237a, seekPoint.f24238b + StartOffsetExtractorOutput.this.f24408b);
                SeekPoint seekPoint3 = d2.f24233b;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.f24237a, seekPoint3.f24238b + StartOffsetExtractorOutput.this.f24408b));
            }

            public boolean f() {
                return seekMap.f();
            }

            public long h() {
                return seekMap.h();
            }
        });
    }
}
