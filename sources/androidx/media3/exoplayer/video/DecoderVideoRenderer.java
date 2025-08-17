package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.media3.common.Format;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.i;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import com.google.android.gms.cast.framework.media.NotificationOptions;

public abstract class DecoderVideoRenderer extends BaseRenderer {
    private DecoderInputBuffer A;
    private VideoDecoderOutputBuffer B;
    private int C;
    private Object D;
    private Surface E;
    private VideoDecoderOutputBufferRenderer F;
    private VideoFrameMetadataListener G;
    private DrmSession H;
    private DrmSession I;
    private int J;
    private boolean K;
    private int L;
    private long M;
    private long N = -9223372036854775807L;
    private boolean O;
    private boolean P;
    private boolean Q;
    private VideoSize R;
    private long S;
    private int T;
    private int U;
    private int V;
    private long W;
    private long X;
    protected DecoderCounters Y;

    /* renamed from: s  reason: collision with root package name */
    private final long f7632s;

    /* renamed from: t  reason: collision with root package name */
    private final int f7633t;

    /* renamed from: u  reason: collision with root package name */
    private final VideoRendererEventListener.EventDispatcher f7634u;

    /* renamed from: v  reason: collision with root package name */
    private final TimedValueQueue<Format> f7635v = new TimedValueQueue<>();

    /* renamed from: w  reason: collision with root package name */
    private final DecoderInputBuffer f7636w = DecoderInputBuffer.i();

    /* renamed from: x  reason: collision with root package name */
    private Format f7637x;

    /* renamed from: y  reason: collision with root package name */
    private Format f7638y;

    /* renamed from: z  reason: collision with root package name */
    private Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> f7639z;

    protected DecoderVideoRenderer(long j2, Handler handler, VideoRendererEventListener videoRendererEventListener, int i2) {
        super(2);
        this.f7632s = j2;
        this.f7633t = i2;
        this.f7634u = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.J = 0;
        this.C = -1;
        this.L = 0;
        this.Y = new DecoderCounters();
    }

    private void D0(DrmSession drmSession) {
        i.a(this.H, drmSession);
        this.H = drmSession;
    }

    private void F0() {
        long j2;
        if (this.f7632s > 0) {
            j2 = SystemClock.elapsedRealtime() + this.f7632s;
        } else {
            j2 = -9223372036854775807L;
        }
        this.N = j2;
    }

    private void H0(DrmSession drmSession) {
        i.a(this.I, drmSession);
        this.I = drmSession;
    }

    private boolean K0(long j2) {
        boolean z2;
        if (getState() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i2 = this.L;
        if (i2 == 0) {
            return z2;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3) {
            long P0 = Util.P0(SystemClock.elapsedRealtime()) - this.W;
            if (!z2 || !L0(j2, P0)) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException();
    }

    private boolean e0(long j2, long j3) throws ExoPlaybackException, DecoderException {
        if (this.B == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) ((Decoder) Assertions.f(this.f7639z)).a();
            this.B = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.Y;
            int i2 = decoderCounters.f5155f;
            int i3 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            decoderCounters.f5155f = i2 + i3;
            this.V -= i3;
        }
        if (this.B.isEndOfStream()) {
            if (this.J == 2) {
                A0();
                n0();
            } else {
                this.B.release();
                this.B = null;
                this.Q = true;
            }
            return false;
        }
        boolean z02 = z0(j2, j3);
        if (z02) {
            x0(((VideoDecoderOutputBuffer) Assertions.f(this.B)).timeUs);
            this.B = null;
        }
        return z02;
    }

    private boolean g0() throws DecoderException, ExoPlaybackException {
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.f7639z;
        if (decoder == null || this.J == 2 || this.P) {
            return false;
        }
        if (this.A == null) {
            DecoderInputBuffer d2 = decoder.d();
            this.A = d2;
            if (d2 == null) {
                return false;
            }
        }
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.f(this.A);
        if (this.J == 1) {
            decoderInputBuffer.setFlags(4);
            ((Decoder) Assertions.f(this.f7639z)).c(decoderInputBuffer);
            this.A = null;
            this.J = 2;
            return false;
        }
        FormatHolder I2 = I();
        int Z = Z(I2, decoderInputBuffer, 0);
        if (Z == -5) {
            t0(I2);
            return true;
        } else if (Z != -4) {
            if (Z == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (decoderInputBuffer.isEndOfStream()) {
            this.P = true;
            ((Decoder) Assertions.f(this.f7639z)).c(decoderInputBuffer);
            this.A = null;
            return false;
        } else {
            if (this.O) {
                this.f7635v.a(decoderInputBuffer.f5069f, (Format) Assertions.f(this.f7637x));
                this.O = false;
            }
            decoderInputBuffer.g();
            decoderInputBuffer.f5065b = this.f7637x;
            y0(decoderInputBuffer);
            ((Decoder) Assertions.f(this.f7639z)).c(decoderInputBuffer);
            this.V++;
            this.K = true;
            this.Y.f5152c++;
            this.A = null;
            return true;
        }
    }

    private boolean i0() {
        return this.C != -1;
    }

    private static boolean j0(long j2) {
        return j2 < -30000;
    }

    private static boolean k0(long j2) {
        return j2 < -500000;
    }

    private void l0(int i2) {
        this.L = Math.min(this.L, i2);
    }

    private void n0() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.f7639z == null) {
            D0(this.I);
            DrmSession drmSession = this.H;
            if (drmSession != null) {
                cryptoConfig = drmSession.c();
                if (cryptoConfig == null && this.H.getError() == null) {
                    return;
                }
            } else {
                cryptoConfig = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> d02 = d0((Format) Assertions.f(this.f7637x), cryptoConfig);
                this.f7639z = d02;
                d02.e(K());
                E0(this.C);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.f7634u.k(((Decoder) Assertions.f(this.f7639z)).getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.Y.f5150a++;
            } catch (DecoderException e2) {
                Log.d("DecoderVideoRenderer", "Video codec error", e2);
                this.f7634u.C(e2);
                throw E(e2, this.f7637x, 4001);
            } catch (OutOfMemoryError e3) {
                throw E(e3, this.f7637x, 4001);
            }
        }
    }

    private void o0() {
        if (this.T > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f7634u.n(this.T, elapsedRealtime - this.S);
            this.T = 0;
            this.S = elapsedRealtime;
        }
    }

    private void p0() {
        if (this.L != 3) {
            this.L = 3;
            Object obj = this.D;
            if (obj != null) {
                this.f7634u.A(obj);
            }
        }
    }

    private void q0(int i2, int i3) {
        VideoSize videoSize = this.R;
        if (videoSize == null || videoSize.f4488a != i2 || videoSize.f4489b != i3) {
            VideoSize videoSize2 = new VideoSize(i2, i3);
            this.R = videoSize2;
            this.f7634u.D(videoSize2);
        }
    }

    private void r0() {
        Object obj;
        if (this.L == 3 && (obj = this.D) != null) {
            this.f7634u.A(obj);
        }
    }

    private void s0() {
        VideoSize videoSize = this.R;
        if (videoSize != null) {
            this.f7634u.D(videoSize);
        }
    }

    private void u0() {
        s0();
        l0(1);
        if (getState() == 2) {
            F0();
        }
    }

    private void v0() {
        this.R = null;
        l0(1);
    }

    private void w0() {
        s0();
        r0();
    }

    private boolean z0(long j2, long j3) throws ExoPlaybackException, DecoderException {
        boolean z2;
        if (this.M == -9223372036854775807L) {
            this.M = j2;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) Assertions.f(this.B);
        long j4 = videoDecoderOutputBuffer.timeUs;
        long j5 = j4 - j2;
        if (i0()) {
            Format j6 = this.f7635v.j(j4);
            if (j6 != null) {
                this.f7638y = j6;
            } else if (this.f7638y == null) {
                this.f7638y = this.f7635v.i();
            }
            long j7 = j4 - this.X;
            if (K0(j5)) {
                B0(videoDecoderOutputBuffer, j7, (Format) Assertions.f(this.f7638y));
                return true;
            }
            if (getState() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || j2 == this.M || (I0(j5, j3) && m0(j2))) {
                return false;
            }
            if (J0(j5, j3)) {
                f0(videoDecoderOutputBuffer);
                return true;
            }
            if (j5 < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                B0(videoDecoderOutputBuffer, j7, (Format) Assertions.f(this.f7638y));
                return true;
            }
            return false;
        } else if (!j0(j5)) {
            return false;
        } else {
            M0(videoDecoderOutputBuffer);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void A0() {
        this.A = null;
        this.B = null;
        this.J = 0;
        this.K = false;
        this.V = 0;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.f7639z;
        if (decoder != null) {
            this.Y.f5151b++;
            decoder.release();
            this.f7634u.l(this.f7639z.getName());
            this.f7639z = null;
        }
        D0((DrmSession) null);
    }

    /* access modifiers changed from: protected */
    public void B0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j2, Format format) throws DecoderException {
        boolean z2;
        boolean z3;
        VideoFrameMetadataListener videoFrameMetadataListener = this.G;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.e(j2, G().nanoTime(), format, (MediaFormat) null);
        }
        this.W = Util.P0(SystemClock.elapsedRealtime());
        int i2 = videoDecoderOutputBuffer.mode;
        if (i2 != 1 || this.E == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (i2 != 0 || this.F == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || z2) {
            q0(videoDecoderOutputBuffer.width, videoDecoderOutputBuffer.height);
            if (z3) {
                ((VideoDecoderOutputBufferRenderer) Assertions.f(this.F)).setOutputBuffer(videoDecoderOutputBuffer);
            } else {
                C0(videoDecoderOutputBuffer, (Surface) Assertions.f(this.E));
            }
            this.U = 0;
            this.Y.f5154e++;
            p0();
            return;
        }
        f0(videoDecoderOutputBuffer);
    }

    /* access modifiers changed from: protected */
    public abstract void C0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    /* access modifiers changed from: protected */
    public abstract void E0(int i2);

    /* access modifiers changed from: protected */
    public final void G0(Object obj) {
        if (obj instanceof Surface) {
            this.E = (Surface) obj;
            this.F = null;
            this.C = 1;
        } else if (obj instanceof VideoDecoderOutputBufferRenderer) {
            this.E = null;
            this.F = (VideoDecoderOutputBufferRenderer) obj;
            this.C = 0;
        } else {
            this.E = null;
            this.F = null;
            this.C = -1;
            obj = null;
        }
        if (this.D != obj) {
            this.D = obj;
            if (obj != null) {
                if (this.f7639z != null) {
                    E0(this.C);
                }
                u0();
                return;
            }
            v0();
        } else if (obj != null) {
            w0();
        }
    }

    /* access modifiers changed from: protected */
    public boolean I0(long j2, long j3) {
        return k0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean J0(long j2, long j3) {
        return j0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean L0(long j2, long j3) {
        return j0(j2) && j3 > 100000;
    }

    /* access modifiers changed from: protected */
    public void M0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.Y.f5155f++;
        videoDecoderOutputBuffer.release();
    }

    /* access modifiers changed from: protected */
    public void N0(int i2, int i3) {
        DecoderCounters decoderCounters = this.Y;
        decoderCounters.f5157h += i2;
        int i4 = i2 + i3;
        decoderCounters.f5156g += i4;
        this.T += i4;
        int i5 = this.U + i4;
        this.U = i5;
        decoderCounters.f5158i = Math.max(i5, decoderCounters.f5158i);
        int i6 = this.f7633t;
        if (i6 > 0 && this.T >= i6) {
            o0();
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.f7637x = null;
        this.R = null;
        l0(0);
        try {
            H0((DrmSession) null);
            A0();
        } finally {
            this.f7634u.m(this.Y);
        }
    }

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.Y = decoderCounters;
        this.f7634u.o(decoderCounters);
        this.L = z3 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) throws ExoPlaybackException {
        this.P = false;
        this.Q = false;
        l0(1);
        this.M = -9223372036854775807L;
        this.U = 0;
        if (this.f7639z != null) {
            h0();
        }
        if (z2) {
            F0();
        } else {
            this.N = -9223372036854775807L;
        }
        this.f7635v.c();
    }

    /* access modifiers changed from: protected */
    public void V() {
        this.T = 0;
        this.S = SystemClock.elapsedRealtime();
        this.W = Util.P0(SystemClock.elapsedRealtime());
    }

    /* access modifiers changed from: protected */
    public void W() {
        this.N = -9223372036854775807L;
        o0();
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        this.X = j3;
        super.X(formatArr, j2, j3, mediaPeriodId);
    }

    public boolean a() {
        return this.Q;
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation c0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    /* access modifiers changed from: protected */
    public abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> d0(Format format, CryptoConfig cryptoConfig) throws DecoderException;

    public void f(long j2, long j3) throws ExoPlaybackException {
        if (!this.Q) {
            if (this.f7637x == null) {
                FormatHolder I2 = I();
                this.f7636w.clear();
                int Z = Z(I2, this.f7636w, 2);
                if (Z == -5) {
                    t0(I2);
                } else if (Z == -4) {
                    Assertions.h(this.f7636w.isEndOfStream());
                    this.P = true;
                    this.Q = true;
                    return;
                } else {
                    return;
                }
            }
            n0();
            if (this.f7639z != null) {
                try {
                    TraceUtil.a("drainAndFeed");
                    while (e0(j2, j3)) {
                    }
                    while (g0()) {
                    }
                    TraceUtil.b();
                    this.Y.c();
                } catch (DecoderException e2) {
                    Log.d("DecoderVideoRenderer", "Video codec error", e2);
                    this.f7634u.C(e2);
                    throw E(e2, this.f7637x, 4003);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        N0(0, 1);
        videoDecoderOutputBuffer.release();
    }

    public void h() {
        if (this.L == 0) {
            this.L = 1;
        }
    }

    /* access modifiers changed from: protected */
    public void h0() throws ExoPlaybackException {
        this.V = 0;
        if (this.J != 0) {
            A0();
            n0();
            return;
        }
        this.A = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.B;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.release();
            this.B = null;
        }
        Decoder decoder = (Decoder) Assertions.f(this.f7639z);
        decoder.flush();
        decoder.e(K());
        this.K = false;
    }

    public boolean isReady() {
        if (this.f7637x != null && ((N() || this.B != null) && (this.L == 3 || !i0()))) {
            this.N = -9223372036854775807L;
            return true;
        } else if (this.N == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.N) {
                return true;
            }
            this.N = -9223372036854775807L;
            return false;
        }
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 1) {
            G0(obj);
        } else if (i2 == 7) {
            this.G = (VideoFrameMetadataListener) obj;
        } else {
            super.j(i2, obj);
        }
    }

    /* access modifiers changed from: protected */
    public boolean m0(long j2) throws ExoPlaybackException {
        int b02 = b0(j2);
        if (b02 == 0) {
            return false;
        }
        this.Y.f5159j++;
        N0(b02, this.V);
        h0();
        return true;
    }

    /* access modifiers changed from: protected */
    public void t0(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluation;
        this.O = true;
        Format format = (Format) Assertions.f(formatHolder.f5385b);
        H0(formatHolder.f5384a);
        Format format2 = this.f7637x;
        this.f7637x = format;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.f7639z;
        if (decoder == null) {
            n0();
            this.f7634u.p((Format) Assertions.f(this.f7637x), (DecoderReuseEvaluation) null);
            return;
        }
        if (this.I != this.H) {
            decoderReuseEvaluation = new DecoderReuseEvaluation(decoder.getName(), (Format) Assertions.f(format2), format, 0, 128);
        } else {
            decoderReuseEvaluation = c0(decoder.getName(), (Format) Assertions.f(format2), format);
        }
        if (decoderReuseEvaluation.f5165d == 0) {
            if (this.K) {
                this.J = 1;
            } else {
                A0();
                n0();
            }
        }
        this.f7634u.p((Format) Assertions.f(this.f7637x), decoderReuseEvaluation);
    }

    /* access modifiers changed from: protected */
    public void x0(long j2) {
        this.V--;
    }

    /* access modifiers changed from: protected */
    public void y0(DecoderInputBuffer decoderInputBuffer) {
    }
}
