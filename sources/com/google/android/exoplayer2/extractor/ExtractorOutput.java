package com.google.android.exoplayer2.extractor;

public interface ExtractorOutput {

    /* renamed from: z0  reason: collision with root package name */
    public static final ExtractorOutput f24202z0 = new ExtractorOutput() {
        public TrackOutput d(int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        public void m() {
            throw new UnsupportedOperationException();
        }

        public void u(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }
    };

    TrackOutput d(int i2, int i3);

    void m();

    void u(SeekMap seekMap);
}
