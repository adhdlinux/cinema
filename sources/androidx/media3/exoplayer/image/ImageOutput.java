package androidx.media3.exoplayer.image;

import android.graphics.Bitmap;

public interface ImageOutput {

    /* renamed from: a  reason: collision with root package name */
    public static final ImageOutput f6606a = new ImageOutput() {
        public void a() {
        }

        public void onImageAvailable(long j2, Bitmap bitmap) {
        }
    };

    void a();

    void onImageAvailable(long j2, Bitmap bitmap);
}
