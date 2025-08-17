package androidx.media3.exoplayer.analytics;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import java.util.List;

public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void C(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void D(DecoderCounters decoderCounters);

    void E(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId);

    void Q(AnalyticsListener analyticsListener);

    void Z(Player player, Looper looper);

    void a(Exception exc);

    void b(String str);

    void c(String str, long j2, long j3);

    void d(String str);

    void e(String str, long j2, long j3);

    void f(long j2);

    void g(Exception exc);

    void h(int i2, long j2);

    void i(Object obj, long j2);

    void j(Exception exc);

    void k(int i2, long j2, long j3);

    void l(long j2, int i2);

    void m(AudioSink.AudioTrackConfig audioTrackConfig);

    void o(AudioSink.AudioTrackConfig audioTrackConfig);

    void q();

    void release();

    void s(DecoderCounters decoderCounters);

    void t(DecoderCounters decoderCounters);

    void w(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void x(DecoderCounters decoderCounters);
}
