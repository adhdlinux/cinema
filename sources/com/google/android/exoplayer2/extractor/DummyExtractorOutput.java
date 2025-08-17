package com.google.android.exoplayer2.extractor;

public final class DummyExtractorOutput implements ExtractorOutput {
    public TrackOutput d(int i2, int i3) {
        return new DummyTrackOutput();
    }

    public void m() {
    }

    public void u(SeekMap seekMap) {
    }
}
