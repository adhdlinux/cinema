package com.google.android.exoplayer2.extractor.jpeg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ForwardingExtractorInput;
import com.google.android.exoplayer2.util.Assertions;

final class StartOffsetExtractorInput extends ForwardingExtractorInput {

    /* renamed from: b  reason: collision with root package name */
    private final long f24407b;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j2) {
        super(extractorInput);
        boolean z2;
        if (extractorInput.getPosition() >= j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f24407b = j2;
    }

    public long g() {
        return super.g() - this.f24407b;
    }

    public long getLength() {
        return super.getLength() - this.f24407b;
    }

    public long getPosition() {
        return super.getPosition() - this.f24407b;
    }
}
