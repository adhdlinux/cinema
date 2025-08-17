package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;

final class VideoFrameRenderControl {

    /* renamed from: a  reason: collision with root package name */
    private final FrameRenderer f7747a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoFrameReleaseControl f7748b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoFrameReleaseControl.FrameReleaseInfo f7749c = new VideoFrameReleaseControl.FrameReleaseInfo();

    /* renamed from: d  reason: collision with root package name */
    private final TimedValueQueue<VideoSize> f7750d = new TimedValueQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final TimedValueQueue<Long> f7751e = new TimedValueQueue<>();

    /* renamed from: f  reason: collision with root package name */
    private final LongArrayQueue f7752f = new LongArrayQueue();

    /* renamed from: g  reason: collision with root package name */
    private VideoSize f7753g;

    /* renamed from: h  reason: collision with root package name */
    private VideoSize f7754h = VideoSize.f4483e;

    /* renamed from: i  reason: collision with root package name */
    private long f7755i;

    /* renamed from: j  reason: collision with root package name */
    private long f7756j = -9223372036854775807L;

    interface FrameRenderer {
        void a();

        void b(long j2, long j3, long j4, boolean z2);

        void n(VideoSize videoSize);
    }

    public VideoFrameRenderControl(FrameRenderer frameRenderer, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.f7747a = frameRenderer;
        this.f7748b = videoFrameReleaseControl;
    }

    private void a() {
        Assertions.j(Long.valueOf(this.f7752f.d()));
        this.f7747a.a();
    }

    private static <T> T c(TimedValueQueue<T> timedValueQueue) {
        boolean z2;
        if (timedValueQueue.l() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        while (timedValueQueue.l() > 1) {
            timedValueQueue.i();
        }
        return Assertions.f(timedValueQueue.i());
    }

    private boolean f(long j2) {
        Long j3 = this.f7751e.j(j2);
        if (j3 == null || j3.longValue() == this.f7755i) {
            return false;
        }
        this.f7755i = j3.longValue();
        return true;
    }

    private boolean g(long j2) {
        VideoSize j3 = this.f7750d.j(j2);
        if (j3 == null || j3.equals(VideoSize.f4483e) || j3.equals(this.f7754h)) {
            return false;
        }
        this.f7754h = j3;
        return true;
    }

    private void j(boolean z2) {
        long j2;
        long longValue = ((Long) Assertions.j(Long.valueOf(this.f7752f.d()))).longValue();
        if (g(longValue)) {
            this.f7747a.n(this.f7754h);
        }
        if (z2) {
            j2 = -1;
        } else {
            j2 = this.f7749c.g();
        }
        this.f7747a.b(j2, longValue, this.f7755i, this.f7748b.i());
    }

    public void b() {
        this.f7752f.a();
        this.f7756j = -9223372036854775807L;
        if (this.f7751e.l() > 0) {
            this.f7751e.a(0, Long.valueOf(((Long) c(this.f7751e)).longValue()));
        }
        if (this.f7753g != null) {
            this.f7750d.c();
        } else if (this.f7750d.l() > 0) {
            this.f7753g = (VideoSize) c(this.f7750d);
        }
    }

    public boolean d(long j2) {
        long j3 = this.f7756j;
        return j3 != -9223372036854775807L && j3 >= j2;
    }

    public boolean e() {
        return this.f7748b.d(true);
    }

    public void h(long j2, long j3) {
        this.f7751e.a(j2, Long.valueOf(j3));
    }

    public void i(long j2, long j3) throws ExoPlaybackException {
        while (!this.f7752f.c()) {
            long b2 = this.f7752f.b();
            if (f(b2)) {
                this.f7748b.j();
            }
            int c2 = this.f7748b.c(b2, j2, j3, this.f7755i, false, this.f7749c);
            boolean z2 = true;
            if (c2 == 0 || c2 == 1) {
                this.f7756j = b2;
                if (c2 != 0) {
                    z2 = false;
                }
                j(z2);
            } else if (c2 == 2 || c2 == 3 || c2 == 4) {
                this.f7756j = b2;
                a();
            } else if (c2 != 5) {
                throw new IllegalStateException(String.valueOf(c2));
            } else {
                return;
            }
        }
    }

    public void k(float f2) {
        boolean z2;
        if (f2 > 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f7748b.r(f2);
    }
}
