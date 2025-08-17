package com.google.android.exoplayer2;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import java.io.IOException;

public abstract class BaseRenderer implements Renderer, RendererCapabilities {

    /* renamed from: b  reason: collision with root package name */
    private final int f22801b;

    /* renamed from: c  reason: collision with root package name */
    private final FormatHolder f22802c = new FormatHolder();

    /* renamed from: d  reason: collision with root package name */
    private RendererConfiguration f22803d;

    /* renamed from: e  reason: collision with root package name */
    private int f22804e;

    /* renamed from: f  reason: collision with root package name */
    private PlayerId f22805f;

    /* renamed from: g  reason: collision with root package name */
    private int f22806g;

    /* renamed from: h  reason: collision with root package name */
    private SampleStream f22807h;

    /* renamed from: i  reason: collision with root package name */
    private Format[] f22808i;

    /* renamed from: j  reason: collision with root package name */
    private long f22809j;

    /* renamed from: k  reason: collision with root package name */
    private long f22810k;

    /* renamed from: l  reason: collision with root package name */
    private long f22811l = Long.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private boolean f22812m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f22813n;

    public BaseRenderer(int i2) {
        this.f22801b = i2;
    }

    private void L(long j2, boolean z2) throws ExoPlaybackException {
        this.f22812m = false;
        this.f22810k = j2;
        this.f22811l = j2;
        F(j2, z2);
    }

    /* access modifiers changed from: protected */
    public final PlayerId A() {
        return (PlayerId) Assertions.e(this.f22805f);
    }

    /* access modifiers changed from: protected */
    public final Format[] B() {
        return (Format[]) Assertions.e(this.f22808i);
    }

    /* access modifiers changed from: protected */
    public final boolean C() {
        return g() ? this.f22812m : ((SampleStream) Assertions.e(this.f22807h)).isReady();
    }

    /* access modifiers changed from: protected */
    public abstract void D();

    /* access modifiers changed from: protected */
    public void E(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public abstract void F(long j2, boolean z2) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void G() {
    }

    /* access modifiers changed from: protected */
    public void H() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void I() {
    }

    /* access modifiers changed from: protected */
    public abstract void J(Format[] formatArr, long j2, long j3) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public final int K(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        int m2 = ((SampleStream) Assertions.e(this.f22807h)).m(formatHolder, decoderInputBuffer, i2);
        if (m2 == -4) {
            if (decoderInputBuffer.k()) {
                this.f22811l = Long.MIN_VALUE;
                if (this.f22812m) {
                    return -4;
                }
                return -3;
            }
            long j2 = decoderInputBuffer.f23963f + this.f22809j;
            decoderInputBuffer.f23963f = j2;
            this.f22811l = Math.max(this.f22811l, j2);
        } else if (m2 == -5) {
            Format format = (Format) Assertions.e(formatHolder.f23112b);
            if (format.f23075q != Clock.MAX_TIME) {
                formatHolder.f23112b = format.b().k0(format.f23075q + this.f22809j).G();
            }
        }
        return m2;
    }

    /* access modifiers changed from: protected */
    public int M(long j2) {
        return ((SampleStream) Assertions.e(this.f22807h)).d(j2 - this.f22809j);
    }

    public final int d() {
        return this.f22801b;
    }

    public final void disable() {
        boolean z2 = true;
        if (this.f22806g != 1) {
            z2 = false;
        }
        Assertions.g(z2);
        this.f22802c.a();
        this.f22806g = 0;
        this.f22807h = null;
        this.f22808i = null;
        this.f22812m = false;
        D();
    }

    public final boolean g() {
        return this.f22811l == Long.MIN_VALUE;
    }

    public final int getState() {
        return this.f22806g;
    }

    public final SampleStream getStream() {
        return this.f22807h;
    }

    public final void h(int i2, PlayerId playerId) {
        this.f22804e = i2;
        this.f22805f = playerId;
    }

    public final void i() {
        this.f22812m = true;
    }

    public void j(int i2, Object obj) throws ExoPlaybackException {
    }

    public final void k() throws IOException {
        ((SampleStream) Assertions.e(this.f22807h)).a();
    }

    public final boolean l() {
        return this.f22812m;
    }

    public final RendererCapabilities m() {
        return this;
    }

    public /* synthetic */ void o(float f2, float f3) {
        a2.a(this, f2, f3);
    }

    public int p() throws ExoPlaybackException {
        return 0;
    }

    public final long q() {
        return this.f22811l;
    }

    public final void r(long j2) throws ExoPlaybackException {
        L(j2, false);
    }

    public final void reset() {
        boolean z2;
        if (this.f22806g == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f22802c.a();
        G();
    }

    public MediaClock s() {
        return null;
    }

    public final void start() throws ExoPlaybackException {
        boolean z2 = true;
        if (this.f22806g != 1) {
            z2 = false;
        }
        Assertions.g(z2);
        this.f22806g = 2;
        H();
    }

    public final void stop() {
        boolean z2;
        if (this.f22806g == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f22806g = 1;
        I();
    }

    public final void t(Format[] formatArr, SampleStream sampleStream, long j2, long j3) throws ExoPlaybackException {
        Assertions.g(!this.f22812m);
        this.f22807h = sampleStream;
        if (this.f22811l == Long.MIN_VALUE) {
            this.f22811l = j2;
        }
        this.f22808i = formatArr;
        this.f22809j = j3;
        J(formatArr, j2, j3);
    }

    public final void u(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j2, boolean z2, boolean z3, long j3, long j4) throws ExoPlaybackException {
        boolean z4;
        boolean z5 = z2;
        if (this.f22806g == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.g(z4);
        this.f22803d = rendererConfiguration;
        this.f22806g = 1;
        E(z2, z3);
        t(formatArr, sampleStream, j3, j4);
        long j5 = j2;
        L(j2, z2);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException v(Throwable th, Format format, int i2) {
        return w(th, format, false, i2);
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException w(Throwable th, Format format, boolean z2, int i2) {
        int i3;
        if (format != null && !this.f22813n) {
            this.f22813n = true;
            try {
                int f2 = b2.f(c(format));
                this.f22813n = false;
                i3 = f2;
            } catch (ExoPlaybackException unused) {
                this.f22813n = false;
            } catch (Throwable th2) {
                this.f22813n = false;
                throw th2;
            }
            return ExoPlaybackException.f(th, getName(), z(), format, i3, z2, i2);
        }
        i3 = 4;
        return ExoPlaybackException.f(th, getName(), z(), format, i3, z2, i2);
    }

    /* access modifiers changed from: protected */
    public final RendererConfiguration x() {
        return (RendererConfiguration) Assertions.e(this.f22803d);
    }

    /* access modifiers changed from: protected */
    public final FormatHolder y() {
        this.f22802c.a();
        return this.f22802c;
    }

    /* access modifiers changed from: protected */
    public final int z() {
        return this.f22804e;
    }
}
