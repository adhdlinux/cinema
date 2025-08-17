package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public interface AudioRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f23686a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioRendererEventListener f23687b;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            Handler handler2;
            if (audioRendererEventListener != null) {
                handler2 = (Handler) Assertions.e(handler);
            } else {
                handler2 = null;
            }
            this.f23686a = handler2;
            this.f23687b = audioRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void A(int i2, long j2, long j3) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).k(i2, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).j(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).a(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j2, long j3) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).e(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).d(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((AudioRendererEventListener) Util.j(this.f23687b)).s(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).m(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).C(format);
            ((AudioRendererEventListener) Util.j(this.f23687b)).t(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(long j2) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).f(j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(boolean z2) {
            ((AudioRendererEventListener) Util.j(this.f23687b)).onSkipSilenceEnabledChanged(z2);
        }

        public void B(long j2) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new e(this, j2));
            }
        }

        public void C(boolean z2) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new k(this, z2));
            }
        }

        public void D(int i2, long j2, long j3) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new l(this, i2, j2, j3));
            }
        }

        public void k(Exception exc) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new i(this, exc));
            }
        }

        public void l(Exception exc) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new h(this, exc));
            }
        }

        public void m(String str, long j2, long j3) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new j(this, str, j2, j3));
            }
        }

        public void n(String str) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new c(this, str));
            }
        }

        public void o(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new f(this, decoderCounters));
            }
        }

        public void p(DecoderCounters decoderCounters) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new g(this, decoderCounters));
            }
        }

        public void q(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f23686a;
            if (handler != null) {
                handler.post(new d(this, format, decoderReuseEvaluation));
            }
        }
    }

    @Deprecated
    void C(Format format);

    void a(Exception exc);

    void d(String str);

    void e(String str, long j2, long j3);

    void f(long j2);

    void j(Exception exc);

    void k(int i2, long j2, long j3);

    void m(DecoderCounters decoderCounters);

    void onSkipSilenceEnabledChanged(boolean z2);

    void s(DecoderCounters decoderCounters);

    void t(Format format, DecoderReuseEvaluation decoderReuseEvaluation);
}
