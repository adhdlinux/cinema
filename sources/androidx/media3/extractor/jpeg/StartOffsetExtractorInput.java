package androidx.media3.extractor.jpeg;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ForwardingExtractorInput;

final class StartOffsetExtractorInput extends ForwardingExtractorInput {

    /* renamed from: b  reason: collision with root package name */
    private final long f8257b;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j2) {
        super(extractorInput);
        boolean z2;
        if (extractorInput.getPosition() >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f8257b = j2;
    }

    public long g() {
        return super.g() - this.f8257b;
    }

    public long getLength() {
        return super.getLength() - this.f8257b;
    }

    public long getPosition() {
        return super.getPosition() - this.f8257b;
    }
}
