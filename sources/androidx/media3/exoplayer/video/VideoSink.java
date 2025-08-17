package androidx.media3.exoplayer.video;

import android.view.Surface;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Size;
import java.util.List;
import java.util.concurrent.Executor;

public interface VideoSink {

    public interface Listener {

        /* renamed from: a  reason: collision with root package name */
        public static final Listener f7759a = new Listener() {
            public void a(VideoSink videoSink) {
            }

            public void b(VideoSink videoSink, VideoSize videoSize) {
            }

            public void c(VideoSink videoSink) {
            }
        };

        void a(VideoSink videoSink);

        void b(VideoSink videoSink, VideoSize videoSize);

        void c(VideoSink videoSink);
    }

    public static final class VideoSinkException extends Exception {

        /* renamed from: b  reason: collision with root package name */
        public final Format f7760b;

        public VideoSinkException(Throwable th, Format format) {
            super(th);
            this.f7760b = format;
        }
    }

    boolean a();

    Surface b();

    void d(VideoFrameMetadataListener videoFrameMetadataListener);

    long e(long j2, boolean z2);

    void f(long j2, long j3) throws VideoSinkException;

    void g();

    void h();

    void i(List<Effect> list);

    boolean isInitialized();

    boolean isReady();

    void j(int i2, Format format);

    void k(long j2, long j3);

    boolean l();

    void m(Format format) throws VideoSinkException;

    void n(boolean z2);

    void o();

    void p(Surface surface, Size size);

    void r();

    void release();

    void s();

    void setPlaybackSpeed(float f2);

    void u(boolean z2);

    void v(Listener listener, Executor executor);
}
