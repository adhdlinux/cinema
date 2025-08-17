package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import java.io.IOException;

public interface Renderer extends PlayerMessage.Target {

    public interface WakeupListener {
        void a();

        void b();
    }

    long A(long j2, long j3);

    void B(Timeline timeline);

    boolean a();

    int d();

    void disable();

    void f(long j2, long j3) throws ExoPlaybackException;

    boolean g();

    String getName();

    int getState();

    SampleStream getStream();

    void h();

    void i();

    boolean isReady();

    void k() throws IOException;

    boolean l();

    RendererCapabilities m();

    void o(float f2, float f3) throws ExoPlaybackException;

    long q();

    void r(long j2) throws ExoPlaybackException;

    void release();

    void reset();

    MediaClock s();

    void start() throws ExoPlaybackException;

    void stop();

    void u(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z2, boolean z3, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException;

    void v(int i2, PlayerId playerId, Clock clock);

    void x(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException;
}
