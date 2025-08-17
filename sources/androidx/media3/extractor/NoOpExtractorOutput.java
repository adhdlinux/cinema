package androidx.media3.extractor;

public final class NoOpExtractorOutput implements ExtractorOutput {
    public TrackOutput d(int i2, int i3) {
        return new DiscardingTrackOutput();
    }

    public void m() {
    }

    public void r(SeekMap seekMap) {
    }
}
