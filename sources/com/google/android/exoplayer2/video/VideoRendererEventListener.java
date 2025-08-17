package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import w0.d;
import w0.e;
import w0.f;
import w0.g;
import w0.h;
import w0.i;
import w0.j;
import w0.k;
import w0.l;
import w0.m;

public interface VideoRendererEventListener {

    public static final class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f28954a;

        /* renamed from: b  reason: collision with root package name */
        private final VideoRendererEventListener f28955b;

        public EventDispatcher(Handler handler, VideoRendererEventListener videoRendererEventListener) {
            Handler handler2;
            if (videoRendererEventListener != null) {
                handler2 = (Handler) Assertions.e(handler);
            } else {
                handler2 = null;
            }
            this.f28954a = handler2;
            this.f28955b = videoRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j2, long j3) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).c(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).b(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DecoderCounters decoderCounters) {
            decoderCounters.c();
            ((VideoRendererEventListener) Util.j(this.f28955b)).o(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(int i2, long j2) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).h(i2, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void u(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).w(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).x(format);
            ((VideoRendererEventListener) Util.j(this.f28955b)).n(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j2) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).i(obj, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void x(long j2, int i2) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).l(j2, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).g(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void z(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.j(this.f28955b)).onVideoSizeChanged(videoSize);
        }

        public void A(Object obj) {
            if (this.f28954a != null) {
                this.f28954a.post(new k(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        public void B(long j2, int i2) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new h(this, j2, i2));
            }
        }

        public void C(Exception exc) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new j(this, exc));
            }
        }

        public void D(VideoSize videoSize) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new g(this, videoSize));
            }
        }

        public void k(String str, long j2, long j3) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new m(this, str, j2, j3));
            }
        }

        public void l(String str) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new f(this, str));
            }
        }

        public void m(DecoderCounters decoderCounters) {
            decoderCounters.c();
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new d(this, decoderCounters));
            }
        }

        public void n(int i2, long j2) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new l(this, i2, j2));
            }
        }

        public void o(DecoderCounters decoderCounters) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new e(this, decoderCounters));
            }
        }

        public void p(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.f28954a;
            if (handler != null) {
                handler.post(new i(this, format, decoderReuseEvaluation));
            }
        }
    }

    void b(String str);

    void c(String str, long j2, long j3);

    void g(Exception exc);

    void h(int i2, long j2);

    void i(Object obj, long j2);

    void l(long j2, int i2);

    void n(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void o(DecoderCounters decoderCounters);

    void onVideoSizeChanged(VideoSize videoSize);

    void w(DecoderCounters decoderCounters);

    @Deprecated
    void x(Format format);
}
