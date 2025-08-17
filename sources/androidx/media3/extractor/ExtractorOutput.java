package androidx.media3.extractor;

public interface ExtractorOutput {

    /* renamed from: y0  reason: collision with root package name */
    public static final ExtractorOutput f8013y0 = new ExtractorOutput() {
        public TrackOutput d(int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        public void m() {
            throw new UnsupportedOperationException();
        }

        public void r(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }
    };

    TrackOutput d(int i2, int i3);

    void m();

    void r(SeekMap seekMap);
}
