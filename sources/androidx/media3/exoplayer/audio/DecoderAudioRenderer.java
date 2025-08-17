package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import android.os.Handler;
import android.os.SystemClock;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.i;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.MoreObjects;
import e.x;

public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    private T A;
    private DecoderInputBuffer B;
    private SimpleDecoderOutputBuffer C;
    private DrmSession D;
    private DrmSession E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private long M;
    private final long[] N;
    private int O;
    /* access modifiers changed from: private */
    public boolean P;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final AudioRendererEventListener.EventDispatcher f5713s;

    /* renamed from: t  reason: collision with root package name */
    private final AudioSink f5714t;

    /* renamed from: u  reason: collision with root package name */
    private final DecoderInputBuffer f5715u;

    /* renamed from: v  reason: collision with root package name */
    private DecoderCounters f5716v;

    /* renamed from: w  reason: collision with root package name */
    private Format f5717w;

    /* renamed from: x  reason: collision with root package name */
    private int f5718x;

    /* renamed from: y  reason: collision with root package name */
    private int f5719y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f5720z;

    private static final class Api23 {
        private Api23() {
        }

        public static void a(AudioSink audioSink, Object obj) {
            audioSink.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void a(Exception exc) {
            Log.d("DecoderAudioRenderer", "Audio sink error", exc);
            DecoderAudioRenderer.this.f5713s.n(exc);
        }

        public void b(long j2) {
            DecoderAudioRenderer.this.f5713s.H(j2);
        }

        public /* synthetic */ void c() {
            s.c(this);
        }

        public void d(int i2, long j2, long j3) {
            DecoderAudioRenderer.this.f5713s.J(i2, j2, j3);
        }

        public void e() {
            DecoderAudioRenderer.this.o0();
        }

        public /* synthetic */ void f() {
            s.b(this);
        }

        public void g() {
            boolean unused = DecoderAudioRenderer.this.P = true;
        }

        public /* synthetic */ void h() {
            s.a(this);
        }

        public void m(AudioSink.AudioTrackConfig audioTrackConfig) {
            DecoderAudioRenderer.this.f5713s.o(audioTrackConfig);
        }

        public void o(AudioSink.AudioTrackConfig audioTrackConfig) {
            DecoderAudioRenderer.this.f5713s.p(audioTrackConfig);
        }

        public void onSkipSilenceEnabledChanged(boolean z2) {
            DecoderAudioRenderer.this.f5713s.I(z2);
        }
    }

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    private boolean g0() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.C == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.A.a();
            this.C = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i2 = simpleDecoderOutputBuffer.skippedOutputBufferCount;
            if (i2 > 0) {
                this.f5716v.f5155f += i2;
                this.f5714t.m();
            }
            if (this.C.isFirstSample()) {
                q0();
            }
        }
        if (this.C.isEndOfStream()) {
            if (this.F == 2) {
                r0();
                m0();
                this.H = true;
            } else {
                this.C.release();
                this.C = null;
                try {
                    p0();
                } catch (AudioSink.WriteException e2) {
                    throw F(e2, e2.f5671d, e2.f5670c, 5002);
                }
            }
            return false;
        }
        if (this.H) {
            this.f5714t.t(k0(this.A).a().V(this.f5718x).W(this.f5719y).h0(this.f5717w.f4012k).T(this.f5717w.f4013l).a0(this.f5717w.f4002a).c0(this.f5717w.f4003b).d0(this.f5717w.f4004c).e0(this.f5717w.f4005d).q0(this.f5717w.f4006e).m0(this.f5717w.f4007f).K(), 0, j0(this.A));
            this.H = false;
        }
        AudioSink audioSink = this.f5714t;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.C;
        if (!audioSink.i(simpleDecoderOutputBuffer2.f5091c, simpleDecoderOutputBuffer2.timeUs, 1)) {
            return false;
        }
        this.f5716v.f5154e++;
        this.C.release();
        this.C = null;
        return true;
    }

    private boolean h0() throws DecoderException, ExoPlaybackException {
        T t2 = this.A;
        if (t2 == null || this.F == 2 || this.K) {
            return false;
        }
        if (this.B == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t2.d();
            this.B = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.F == 1) {
            this.B.setFlags(4);
            this.A.c(this.B);
            this.B = null;
            this.F = 2;
            return false;
        }
        FormatHolder I2 = I();
        int Z = Z(I2, this.B, 0);
        if (Z == -5) {
            n0(I2);
            return true;
        } else if (Z != -4) {
            if (Z == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.B.isEndOfStream()) {
            this.K = true;
            this.A.c(this.B);
            this.B = null;
            return false;
        } else {
            if (!this.f5720z) {
                this.f5720z = true;
                this.B.addFlag(134217728);
            }
            this.B.g();
            DecoderInputBuffer decoderInputBuffer2 = this.B;
            decoderInputBuffer2.f5065b = this.f5717w;
            this.A.c(decoderInputBuffer2);
            this.G = true;
            this.f5716v.f5152c++;
            this.B = null;
            return true;
        }
    }

    private void i0() throws ExoPlaybackException {
        if (this.F != 0) {
            r0();
            m0();
            return;
        }
        this.B = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.C;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.release();
            this.C = null;
        }
        Decoder decoder = (Decoder) Assertions.f(this.A);
        decoder.flush();
        decoder.e(K());
        this.G = false;
    }

    private void m0() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.A == null) {
            s0(this.E);
            DrmSession drmSession = this.D;
            if (drmSession != null) {
                cryptoConfig = drmSession.c();
                if (cryptoConfig == null && this.D.getError() == null) {
                    return;
                }
            } else {
                cryptoConfig = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.a("createAudioDecoder");
                T f02 = f0(this.f5717w, cryptoConfig);
                this.A = f02;
                f02.e(K());
                TraceUtil.b();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.f5713s.q(this.A.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.f5716v.f5150a++;
            } catch (DecoderException e2) {
                Log.d("DecoderAudioRenderer", "Audio codec error", e2);
                this.f5713s.m(e2);
                throw E(e2, this.f5717w, 4001);
            } catch (OutOfMemoryError e3) {
                throw E(e3, this.f5717w, 4001);
            }
        }
    }

    private void n0(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluation;
        Format format = (Format) Assertions.f(formatHolder.f5385b);
        u0(formatHolder.f5384a);
        Format format2 = this.f5717w;
        this.f5717w = format;
        this.f5718x = format.E;
        this.f5719y = format.F;
        T t2 = this.A;
        if (t2 == null) {
            m0();
            this.f5713s.u(this.f5717w, (DecoderReuseEvaluation) null);
            return;
        }
        if (this.E != this.D) {
            decoderReuseEvaluation = new DecoderReuseEvaluation(t2.getName(), format2, format, 0, 128);
        } else {
            decoderReuseEvaluation = e0(t2.getName(), format2, format);
        }
        if (decoderReuseEvaluation.f5165d == 0) {
            if (this.G) {
                this.F = 1;
            } else {
                r0();
                m0();
                this.H = true;
            }
        }
        this.f5713s.u(this.f5717w, decoderReuseEvaluation);
    }

    private void p0() throws AudioSink.WriteException {
        this.L = true;
        this.f5714t.j();
    }

    private void q0() {
        this.f5714t.m();
        if (this.O != 0) {
            t0(this.N[0]);
            int i2 = this.O - 1;
            this.O = i2;
            long[] jArr = this.N;
            System.arraycopy(jArr, 1, jArr, 0, i2);
        }
    }

    private void r0() {
        this.B = null;
        this.C = null;
        this.F = 0;
        this.G = false;
        T t2 = this.A;
        if (t2 != null) {
            this.f5716v.f5151b++;
            t2.release();
            this.f5713s.r(this.A.getName());
            this.A = null;
        }
        s0((DrmSession) null);
    }

    private void s0(DrmSession drmSession) {
        i.a(this.D, drmSession);
        this.D = drmSession;
    }

    private void t0(long j2) {
        this.M = j2;
        if (j2 != -9223372036854775807L) {
            this.f5714t.l(j2);
        }
    }

    private void u0(DrmSession drmSession) {
        i.a(this.E, drmSession);
        this.E = drmSession;
    }

    private void x0() {
        long k2 = this.f5714t.k(a());
        if (k2 != Long.MIN_VALUE) {
            if (!this.J) {
                k2 = Math.max(this.I, k2);
            }
            this.I = k2;
            this.J = false;
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.f5717w = null;
        this.H = true;
        t0(-9223372036854775807L);
        this.P = false;
        try {
            u0((DrmSession) null);
            r0();
            this.f5714t.reset();
        } finally {
            this.f5713s.s(this.f5716v);
        }
    }

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.f5716v = decoderCounters;
        this.f5713s.t(decoderCounters);
        if (H().f5509b) {
            this.f5714t.n();
        } else {
            this.f5714t.h();
        }
        this.f5714t.v(L());
        this.f5714t.y(G());
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        this.f5714t.flush();
        this.I = j2;
        this.P = false;
        this.J = true;
        this.K = false;
        this.L = false;
        if (this.A != null) {
            i0();
        }
    }

    /* access modifiers changed from: protected */
    public void V() {
        this.f5714t.play();
    }

    /* access modifiers changed from: protected */
    public void W() {
        x0();
        this.f5714t.pause();
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.X(formatArr, j2, j3, mediaPeriodId);
        this.f5720z = false;
        if (this.M == -9223372036854775807L) {
            t0(j3);
            return;
        }
        int i2 = this.O;
        if (i2 == this.N.length) {
            Log.h("DecoderAudioRenderer", "Too many stream changes, so dropping offset: " + this.N[this.O - 1]);
        } else {
            this.O = i2 + 1;
        }
        this.N[this.O - 1] = j3;
    }

    public boolean a() {
        return this.L && this.f5714t.a();
    }

    public PlaybackParameters b() {
        return this.f5714t.b();
    }

    public final int c(Format format) {
        int i2 = 0;
        if (!MimeTypes.o(format.f4015n)) {
            return x.a(0);
        }
        int w02 = w0(format);
        if (w02 <= 2) {
            return x.a(w02);
        }
        if (Util.f4714a >= 21) {
            i2 = 32;
        }
        return x.b(w02, 8, i2);
    }

    public void e(PlaybackParameters playbackParameters) {
        this.f5714t.e(playbackParameters);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation e0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    public void f(long j2, long j3) throws ExoPlaybackException {
        if (this.L) {
            try {
                this.f5714t.j();
            } catch (AudioSink.WriteException e2) {
                throw F(e2, e2.f5671d, e2.f5670c, 5002);
            }
        } else {
            if (this.f5717w == null) {
                FormatHolder I2 = I();
                this.f5715u.clear();
                int Z = Z(I2, this.f5715u, 2);
                if (Z == -5) {
                    n0(I2);
                } else if (Z == -4) {
                    Assertions.h(this.f5715u.isEndOfStream());
                    this.K = true;
                    try {
                        p0();
                        return;
                    } catch (AudioSink.WriteException e3) {
                        throw E(e3, (Format) null, 5002);
                    }
                } else {
                    return;
                }
            }
            m0();
            if (this.A != null) {
                try {
                    TraceUtil.a("drainAndFeed");
                    while (g0()) {
                    }
                    while (h0()) {
                    }
                    TraceUtil.b();
                    this.f5716v.c();
                } catch (DecoderException e4) {
                    Log.d("DecoderAudioRenderer", "Audio codec error", e4);
                    this.f5713s.m(e4);
                    throw E(e4, this.f5717w, 4003);
                } catch (AudioSink.ConfigurationException e5) {
                    throw E(e5, e5.f5663b, 5001);
                } catch (AudioSink.InitializationException e6) {
                    throw F(e6, e6.f5666d, e6.f5665c, 5001);
                } catch (AudioSink.WriteException e7) {
                    throw F(e7, e7.f5671d, e7.f5670c, 5002);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract T f0(Format format, CryptoConfig cryptoConfig) throws DecoderException;

    public boolean isReady() {
        if (this.f5714t.f() || (this.f5717w != null && (N() || this.C != null))) {
            return true;
        }
        return false;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.f5714t.d(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.f5714t.p((AudioAttributes) obj);
        } else if (i2 == 6) {
            this.f5714t.x((AuxEffectInfo) obj);
        } else if (i2 != 12) {
            if (i2 == 9) {
                this.f5714t.o(((Boolean) obj).booleanValue());
            } else if (i2 != 10) {
                super.j(i2, obj);
            } else {
                this.f5714t.g(((Integer) obj).intValue());
            }
        } else if (Util.f4714a >= 23) {
            Api23.a(this.f5714t, obj);
        }
    }

    /* access modifiers changed from: protected */
    public int[] j0(T t2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Format k0(T t2);

    /* access modifiers changed from: protected */
    public final int l0(Format format) {
        return this.f5714t.w(format);
    }

    public long n() {
        if (getState() == 2) {
            x0();
        }
        return this.I;
    }

    /* access modifiers changed from: protected */
    public void o0() {
        this.J = true;
    }

    public MediaClock s() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final boolean v0(Format format) {
        return this.f5714t.c(format);
    }

    public boolean w() {
        boolean z2 = this.P;
        this.P = false;
        return z2;
    }

    /* access modifiers changed from: protected */
    public abstract int w0(Format format);

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioCapabilities) null, audioProcessorArr);
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioSink) new DefaultAudioSink.Builder().j((AudioCapabilities) MoreObjects.a(audioCapabilities, AudioCapabilities.f5623c)).l(audioProcessorArr).i());
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1);
        this.f5713s = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.f5714t = audioSink;
        audioSink.r(new AudioSinkListener());
        this.f5715u = DecoderInputBuffer.i();
        this.F = 0;
        this.H = true;
        t0(-9223372036854775807L);
        this.N = new long[10];
    }
}
