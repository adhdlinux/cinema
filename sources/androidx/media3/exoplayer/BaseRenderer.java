package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import e.w;
import e.x;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {

    /* renamed from: b  reason: collision with root package name */
    private final Object f5133b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final int f5134c;

    /* renamed from: d  reason: collision with root package name */
    private final FormatHolder f5135d;

    /* renamed from: e  reason: collision with root package name */
    private RendererConfiguration f5136e;

    /* renamed from: f  reason: collision with root package name */
    private int f5137f;

    /* renamed from: g  reason: collision with root package name */
    private PlayerId f5138g;

    /* renamed from: h  reason: collision with root package name */
    private Clock f5139h;

    /* renamed from: i  reason: collision with root package name */
    private int f5140i;

    /* renamed from: j  reason: collision with root package name */
    private SampleStream f5141j;

    /* renamed from: k  reason: collision with root package name */
    private Format[] f5142k;

    /* renamed from: l  reason: collision with root package name */
    private long f5143l;

    /* renamed from: m  reason: collision with root package name */
    private long f5144m;

    /* renamed from: n  reason: collision with root package name */
    private long f5145n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5146o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f5147p;

    /* renamed from: q  reason: collision with root package name */
    private Timeline f5148q;

    /* renamed from: r  reason: collision with root package name */
    private RendererCapabilities.Listener f5149r;

    public BaseRenderer(int i2) {
        this.f5134c = i2;
        this.f5135d = new FormatHolder();
        this.f5145n = Long.MIN_VALUE;
        this.f5148q = Timeline.f4346a;
    }

    private void a0(long j2, boolean z2) throws ExoPlaybackException {
        this.f5146o = false;
        this.f5144m = j2;
        this.f5145n = j2;
        R(j2, z2);
    }

    public /* synthetic */ long A(long j2, long j3) {
        return w.b(this, j2, j3);
    }

    public final void B(Timeline timeline) {
        if (!Util.c(this.f5148q, timeline)) {
            this.f5148q = timeline;
            Y(timeline);
        }
    }

    public final void C(RendererCapabilities.Listener listener) {
        synchronized (this.f5133b) {
            this.f5149r = listener;
        }
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException E(Throwable th, Format format, int i2) {
        return F(th, format, false, i2);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException F(Throwable th, Format format, boolean z2, int i2) {
        int i3;
        if (format != null && !this.f5147p) {
            this.f5147p = true;
            try {
                int i4 = x.i(c(format));
                this.f5147p = false;
                i3 = i4;
            } catch (ExoPlaybackException unused) {
                this.f5147p = false;
            } catch (Throwable th2) {
                this.f5147p = false;
                throw th2;
            }
            return ExoPlaybackException.d(th, getName(), J(), format, i3, z2, i2);
        }
        i3 = 4;
        return ExoPlaybackException.d(th, getName(), J(), format, i3, z2, i2);
    }

    /* access modifiers changed from: protected */
    public final Clock G() {
        return (Clock) Assertions.f(this.f5139h);
    }

    /* access modifiers changed from: protected */
    public final RendererConfiguration H() {
        return (RendererConfiguration) Assertions.f(this.f5136e);
    }

    /* access modifiers changed from: protected */
    public final FormatHolder I() {
        this.f5135d.a();
        return this.f5135d;
    }

    /* access modifiers changed from: protected */
    public final int J() {
        return this.f5137f;
    }

    /* access modifiers changed from: protected */
    public final long K() {
        return this.f5144m;
    }

    /* access modifiers changed from: protected */
    public final PlayerId L() {
        return (PlayerId) Assertions.f(this.f5138g);
    }

    /* access modifiers changed from: protected */
    public final Format[] M() {
        return (Format[]) Assertions.f(this.f5142k);
    }

    /* access modifiers changed from: protected */
    public final boolean N() {
        return g() ? this.f5146o : ((SampleStream) Assertions.f(this.f5141j)).isReady();
    }

    /* access modifiers changed from: protected */
    public abstract void O();

    /* access modifiers changed from: protected */
    public void P(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void Q() {
    }

    /* access modifiers changed from: protected */
    public abstract void R(long j2, boolean z2) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void S() {
    }

    /* access modifiers changed from: protected */
    public final void T() {
        RendererCapabilities.Listener listener;
        synchronized (this.f5133b) {
            listener = this.f5149r;
        }
        if (listener != null) {
            listener.d(this);
        }
    }

    /* access modifiers changed from: protected */
    public void U() {
    }

    /* access modifiers changed from: protected */
    public void V() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void W() {
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void Y(Timeline timeline) {
    }

    /* access modifiers changed from: protected */
    public final int Z(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        int m2 = ((SampleStream) Assertions.f(this.f5141j)).m(formatHolder, decoderInputBuffer, i2);
        if (m2 == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.f5145n = Long.MIN_VALUE;
                if (this.f5146o) {
                    return -4;
                }
                return -3;
            }
            long j2 = decoderInputBuffer.f5069f + this.f5143l;
            decoderInputBuffer.f5069f = j2;
            this.f5145n = Math.max(this.f5145n, j2);
        } else if (m2 == -5) {
            Format format = (Format) Assertions.f(formatHolder.f5385b);
            if (format.f4020s != com.facebook.common.time.Clock.MAX_TIME) {
                formatHolder.f5385b = format.a().s0(format.f4020s + this.f5143l).K();
            }
        }
        return m2;
    }

    /* access modifiers changed from: protected */
    public int b0(long j2) {
        return ((SampleStream) Assertions.f(this.f5141j)).d(j2 - this.f5143l);
    }

    public final int d() {
        return this.f5134c;
    }

    public final void disable() {
        boolean z2 = true;
        if (this.f5140i != 1) {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5135d.a();
        this.f5140i = 0;
        this.f5141j = null;
        this.f5142k = null;
        this.f5146o = false;
        O();
    }

    public final boolean g() {
        return this.f5145n == Long.MIN_VALUE;
    }

    public final int getState() {
        return this.f5140i;
    }

    public final SampleStream getStream() {
        return this.f5141j;
    }

    public /* synthetic */ void h() {
        w.a(this);
    }

    public final void i() {
        this.f5146o = true;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
    }

    public final void k() throws IOException {
        ((SampleStream) Assertions.f(this.f5141j)).a();
    }

    public final boolean l() {
        return this.f5146o;
    }

    public final RendererCapabilities m() {
        return this;
    }

    public /* synthetic */ void o(float f2, float f3) {
        w.c(this, f2, f3);
    }

    public int p() throws ExoPlaybackException {
        return 0;
    }

    public final long q() {
        return this.f5145n;
    }

    public final void r(long j2) throws ExoPlaybackException {
        a0(j2, false);
    }

    public final void release() {
        boolean z2;
        if (this.f5140i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        S();
    }

    public final void reset() {
        boolean z2;
        if (this.f5140i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5135d.a();
        U();
    }

    public MediaClock s() {
        return null;
    }

    public final void start() throws ExoPlaybackException {
        boolean z2 = true;
        if (this.f5140i != 1) {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5140i = 2;
        V();
    }

    public final void stop() {
        boolean z2;
        if (this.f5140i == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f5140i = 1;
        W();
    }

    public final void t() {
        synchronized (this.f5133b) {
            this.f5149r = null;
        }
    }

    public final void u(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z2, boolean z3, long j3, long j4, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        boolean z4;
        boolean z5 = z2;
        if (this.f5140i == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.h(z4);
        this.f5136e = rendererConfiguration;
        this.f5140i = 1;
        P(z5, z3);
        x(formatArr, sampleStream, j3, j4, mediaPeriodId);
        a0(j3, z5);
    }

    public final void v(int i2, PlayerId playerId, Clock clock) {
        this.f5137f = i2;
        this.f5138g = playerId;
        this.f5139h = clock;
        Q();
    }

    public final void x(Format[] formatArr, SampleStream sampleStream, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        Assertions.h(!this.f5146o);
        this.f5141j = sampleStream;
        if (this.f5145n == Long.MIN_VALUE) {
            this.f5145n = j2;
        }
        this.f5142k = formatArr;
        this.f5143l = j3;
        X(formatArr, j2, j3, mediaPeriodId);
    }
}
