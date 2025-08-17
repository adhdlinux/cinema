package androidx.media3.exoplayer.video;

import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;

public interface VideoRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7757a;

        /* renamed from: b  reason: collision with root package name */
        private final VideoRendererEventListener f7758b;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            Handler handler2;
            if (videoRendererEventListener != null) {
                handler2 = (Handler) Assertions.f(handler);
            } else {
                handler2 = null;
            }
            this.f7757a = handler2;
            this.f7758b = videoRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j2, long j3) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).c(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).b(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((VideoRendererEventListener) Util.i(this.f7758b)).D(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(int i2, long j2) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).h(i2, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void u(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).t(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).C(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j2) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).i(obj, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(long j2, int i2) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).l(j2, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).g(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.i(this.f7758b)).n(videoSize);
        }

        public void A(Object obj) {
            if (this.f7757a != null) {
                this.f7757a.post(new m(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        public void B(long j2, int i2) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new o(this, j2, i2));
            }
        }

        public void C(Exception exc) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new n(this, exc));
            }
        }

        public void D(VideoSize videoSize) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new t(this, videoSize));
            }
        }

        public void k(String str, long j2, long j3) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new r(this, str, j2, j3));
            }
        }

        public void l(String str) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new u(this, str));
            }
        }

        public void m(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new q(this, decoderCounters));
            }
        }

        public void n(int i2, long j2) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new l(this, i2, j2));
            }
        }

        public void o(DecoderCounters decoderCounters) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new p(this, decoderCounters));
            }
        }

        public void p(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f7757a;
            if (handler != null) {
                handler.post(new s(this, format, decoderReuseEvaluation));
            }
        }
    }

    void C(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void D(DecoderCounters decoderCounters);

    void b(String str);

    void c(String str, long j2, long j3);

    void g(Exception exc);

    void h(int i2, long j2);

    void i(Object obj, long j2);

    void l(long j2, int i2);

    void n(VideoSize videoSize);

    void t(DecoderCounters decoderCounters);
}
