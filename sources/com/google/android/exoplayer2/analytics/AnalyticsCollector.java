package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import java.util.List;

public interface AnalyticsCollector extends Player.Listener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    void A(AnalyticsListener analyticsListener);

    void D(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId);

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

    void m(DecoderCounters decoderCounters);

    void n(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void o(DecoderCounters decoderCounters);

    void q();

    void release();

    void s(DecoderCounters decoderCounters);

    void t(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void w(DecoderCounters decoderCounters);

    void x(Player player, Looper looper);
}
