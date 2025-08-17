package androidx.media3.extractor.jpeg;

import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ForwardingSeekMap;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;

public final class StartOffsetExtractorOutput implements ExtractorOutput {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f8258b;

    /* renamed from: c  reason: collision with root package name */
    private final ExtractorOutput f8259c;

    public StartOffsetExtractorOutput(long j2, ExtractorOutput extractorOutput) {
        this.f8258b = j2;
        this.f8259c = extractorOutput;
    }

    public TrackOutput d(int i2, int i3) {
        return this.f8259c.d(i2, i3);
    }

    public void m() {
        this.f8259c.m();
    }

    public void r(final SeekMap seekMap) {
        this.f8259c.r(new ForwardingSeekMap(seekMap) {
            public SeekMap.SeekPoints d(long j2) {
                SeekMap.SeekPoints d2 = seekMap.d(j2);
                SeekPoint seekPoint = d2.f8070a;
                SeekPoint seekPoint2 = new SeekPoint(seekPoint.f8075a, seekPoint.f8076b + StartOffsetExtractorOutput.this.f8258b);
                SeekPoint seekPoint3 = d2.f8071b;
                return new SeekMap.SeekPoints(seekPoint2, new SeekPoint(seekPoint3.f8075a, seekPoint3.f8076b + StartOffsetExtractorOutput.this.f8258b));
            }
        });
    }
}
