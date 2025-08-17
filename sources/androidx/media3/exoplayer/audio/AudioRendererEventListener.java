package androidx.media3.exoplayer.audio;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;

public interface AudioRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f5655a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioRendererEventListener f5656b;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            Handler handler2;
            if (audioRendererEventListener != null) {
                handler2 = (Handler) Assertions.f(handler);
            } else {
                handler2 = null;
            }
            this.f5655a = handler2;
            this.f5656b = audioRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(String str) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).d(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void B(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((AudioRendererEventListener) Util.i(this.f5656b)).x(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void C(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).s(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void D(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).w(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void E(long j2) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).f(j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void F(boolean z2) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).onSkipSilenceEnabledChanged(z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void G(int i2, long j2, long j3) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).k(i2, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Exception exc) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).j(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Exception exc) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).a(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).m(audioTrackConfig);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).o(audioTrackConfig);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(String str, long j2, long j3) {
            ((AudioRendererEventListener) Util.i(this.f5656b)).e(str, j2, j3);
        }

        public void H(long j2) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new k(this, j2));
            }
        }

        public void I(boolean z2) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new p(this, z2));
            }
        }

        public void J(int i2, long j2, long j3) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new q(this, i2, j2, j3));
            }
        }

        public void m(Exception exc) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new f(this, exc));
            }
        }

        public void n(Exception exc) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new m(this, exc));
            }
        }

        public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new h(this, audioTrackConfig));
            }
        }

        public void p(AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new g(this, audioTrackConfig));
            }
        }

        public void q(String str, long j2, long j3) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new l(this, str, j2, j3));
            }
        }

        public void r(String str) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new n(this, str));
            }
        }

        public void s(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new i(this, decoderCounters));
            }
        }

        public void t(DecoderCounters decoderCounters) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new j(this, decoderCounters));
            }
        }

        public void u(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f5655a;
            if (handler != null) {
                handler.post(new o(this, format, decoderReuseEvaluation));
            }
        }
    }

    void a(Exception exc);

    void d(String str);

    void e(String str, long j2, long j3);

    void f(long j2);

    void j(Exception exc);

    void k(int i2, long j2, long j3);

    void m(AudioSink.AudioTrackConfig audioTrackConfig);

    void o(AudioSink.AudioTrackConfig audioTrackConfig);

    void onSkipSilenceEnabledChanged(boolean z2);

    void s(DecoderCounters decoderCounters);

    void w(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void x(DecoderCounters decoderCounters);
}
