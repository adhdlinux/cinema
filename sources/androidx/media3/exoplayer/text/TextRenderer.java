package androidx.media3.exoplayer.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.extractor.text.CueDecoder;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import com.facebook.common.time.Clock;
import com.google.common.collect.ImmutableList;
import e.x;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private SubtitleOutputBuffer A;
    private SubtitleOutputBuffer B;
    private int C;
    private final Handler D;
    private final TextOutput E;
    private final FormatHolder F;
    private boolean G;
    private boolean H;
    private Format I;
    private long J;
    private long K;
    private long L;
    private boolean M;

    /* renamed from: s  reason: collision with root package name */
    private final CueDecoder f7328s;

    /* renamed from: t  reason: collision with root package name */
    private final DecoderInputBuffer f7329t;

    /* renamed from: u  reason: collision with root package name */
    private CuesResolver f7330u;

    /* renamed from: v  reason: collision with root package name */
    private final SubtitleDecoderFactory f7331v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f7332w;

    /* renamed from: x  reason: collision with root package name */
    private int f7333x;

    /* renamed from: y  reason: collision with root package name */
    private SubtitleDecoder f7334y;

    /* renamed from: z  reason: collision with root package name */
    private SubtitleInputBuffer f7335z;

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.f7326a);
    }

    @RequiresNonNull({"streamFormat"})
    private void c0() {
        boolean z2;
        if (this.M || Objects.equals(this.I.f4015n, "application/cea-608") || Objects.equals(this.I.f4015n, "application/x-mp4-cea-608") || Objects.equals(this.I.f4015n, "application/cea-708")) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.i(z2, "Legacy decoding is disabled, can't handle " + this.I.f4015n + " samples (expected " + "application/x-media3-cues" + ").");
    }

    private void d0() {
        t0(new CueGroup(ImmutableList.r(), h0(this.K)));
    }

    @SideEffectFree
    @RequiresNonNull({"subtitle"})
    private long f0(long j2) {
        int a2 = this.A.a(j2);
        if (a2 == 0 || this.A.d() == 0) {
            return this.A.timeUs;
        }
        if (a2 != -1) {
            return this.A.c(a2 - 1);
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.A;
        return subtitleOutputBuffer.c(subtitleOutputBuffer.d() - 1);
    }

    private long g0() {
        if (this.C == -1) {
            return Clock.MAX_TIME;
        }
        Assertions.f(this.A);
        if (this.C >= this.A.d()) {
            return Clock.MAX_TIME;
        }
        return this.A.c(this.C);
    }

    @SideEffectFree
    private long h0(long j2) {
        boolean z2;
        boolean z3 = true;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (this.J == -9223372036854775807L) {
            z3 = false;
        }
        Assertions.h(z3);
        return j2 - this.J;
    }

    private void i0(SubtitleDecoderException subtitleDecoderException) {
        Log.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.I, subtitleDecoderException);
        d0();
        r0();
    }

    private void j0() {
        this.f7332w = true;
        SubtitleDecoder a2 = this.f7331v.a((Format) Assertions.f(this.I));
        this.f7334y = a2;
        a2.e(K());
    }

    private void k0(CueGroup cueGroup) {
        this.E.onCues(cueGroup.f4595a);
        this.E.A(cueGroup);
    }

    @SideEffectFree
    private static boolean l0(Format format) {
        return Objects.equals(format.f4015n, "application/x-media3-cues");
    }

    @RequiresNonNull({"this.cuesResolver"})
    private boolean m0(long j2) {
        if (this.G || Z(this.F, this.f7329t, 0) != -4) {
            return false;
        }
        if (this.f7329t.isEndOfStream()) {
            this.G = true;
            return false;
        }
        this.f7329t.g();
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.f(this.f7329t.f5067d);
        CuesWithTiming a2 = this.f7328s.a(this.f7329t.f5069f, byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        this.f7329t.clear();
        return this.f7330u.b(a2, j2);
    }

    private void n0() {
        this.f7335z = null;
        this.C = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.A;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.release();
            this.A = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.B;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.release();
            this.B = null;
        }
    }

    private void o0() {
        n0();
        ((SubtitleDecoder) Assertions.f(this.f7334y)).release();
        this.f7334y = null;
        this.f7333x = 0;
    }

    @RequiresNonNull({"this.cuesResolver"})
    private void p0(long j2) {
        boolean m02 = m0(j2);
        long d2 = this.f7330u.d(this.K);
        int i2 = (d2 > Long.MIN_VALUE ? 1 : (d2 == Long.MIN_VALUE ? 0 : -1));
        if (i2 == 0 && this.G && !m02) {
            this.H = true;
        }
        if (i2 != 0 && d2 <= j2) {
            m02 = true;
        }
        if (m02) {
            ImmutableList<Cue> a2 = this.f7330u.a(j2);
            long c2 = this.f7330u.c(j2);
            t0(new CueGroup(a2, h0(c2)));
            this.f7330u.e(c2);
        }
        this.K = j2;
    }

    private void q0(long j2) {
        boolean z2;
        boolean z3;
        this.K = j2;
        if (this.B == null) {
            ((SubtitleDecoder) Assertions.f(this.f7334y)).b(j2);
            try {
                this.B = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.f(this.f7334y)).a();
            } catch (SubtitleDecoderException e2) {
                i0(e2);
                return;
            }
        }
        if (getState() == 2) {
            if (this.A != null) {
                long g02 = g0();
                z2 = false;
                while (g02 <= j2) {
                    this.C++;
                    g02 = g0();
                    z2 = true;
                }
            } else {
                z2 = false;
            }
            SubtitleOutputBuffer subtitleOutputBuffer = this.B;
            if (subtitleOutputBuffer != null) {
                if (subtitleOutputBuffer.isEndOfStream()) {
                    if (!z2 && g0() == Clock.MAX_TIME) {
                        if (this.f7333x == 2) {
                            r0();
                        } else {
                            n0();
                            this.H = true;
                        }
                    }
                } else if (subtitleOutputBuffer.timeUs <= j2) {
                    SubtitleOutputBuffer subtitleOutputBuffer2 = this.A;
                    if (subtitleOutputBuffer2 != null) {
                        subtitleOutputBuffer2.release();
                    }
                    this.C = subtitleOutputBuffer.a(j2);
                    this.A = subtitleOutputBuffer;
                    this.B = null;
                    z2 = true;
                }
            }
            if (z2) {
                Assertions.f(this.A);
                t0(new CueGroup(this.A.b(j2), h0(f0(j2))));
            }
            if (this.f7333x != 2) {
                while (!this.G) {
                    try {
                        SubtitleInputBuffer subtitleInputBuffer = this.f7335z;
                        if (subtitleInputBuffer == null) {
                            subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.f(this.f7334y)).d();
                            if (subtitleInputBuffer != null) {
                                this.f7335z = subtitleInputBuffer;
                            } else {
                                return;
                            }
                        }
                        if (this.f7333x == 1) {
                            subtitleInputBuffer.setFlags(4);
                            ((SubtitleDecoder) Assertions.f(this.f7334y)).c(subtitleInputBuffer);
                            this.f7335z = null;
                            this.f7333x = 2;
                            return;
                        }
                        int Z = Z(this.F, subtitleInputBuffer, 0);
                        if (Z == -4) {
                            if (subtitleInputBuffer.isEndOfStream()) {
                                this.G = true;
                                this.f7332w = false;
                            } else {
                                Format format = this.F.f5385b;
                                if (format != null) {
                                    subtitleInputBuffer.f8795j = format.f4020s;
                                    subtitleInputBuffer.g();
                                    boolean z4 = this.f7332w;
                                    if (!subtitleInputBuffer.isKeyFrame()) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    this.f7332w = z4 & z3;
                                } else {
                                    return;
                                }
                            }
                            if (!this.f7332w) {
                                ((SubtitleDecoder) Assertions.f(this.f7334y)).c(subtitleInputBuffer);
                                this.f7335z = null;
                            }
                        } else if (Z == -3) {
                            return;
                        }
                    } catch (SubtitleDecoderException e3) {
                        i0(e3);
                        return;
                    }
                }
            }
        }
    }

    private void r0() {
        o0();
        j0();
    }

    private void t0(CueGroup cueGroup) {
        Handler handler = this.D;
        if (handler != null) {
            handler.obtainMessage(1, cueGroup).sendToTarget();
        } else {
            k0(cueGroup);
        }
    }

    /* access modifiers changed from: protected */
    public void O() {
        this.I = null;
        this.L = -9223372036854775807L;
        d0();
        this.J = -9223372036854775807L;
        this.K = -9223372036854775807L;
        if (this.f7334y != null) {
            o0();
        }
    }

    /* access modifiers changed from: protected */
    public void R(long j2, boolean z2) {
        this.K = j2;
        CuesResolver cuesResolver = this.f7330u;
        if (cuesResolver != null) {
            cuesResolver.clear();
        }
        d0();
        this.G = false;
        this.H = false;
        this.L = -9223372036854775807L;
        Format format = this.I;
        if (format != null && !l0(format)) {
            if (this.f7333x != 0) {
                r0();
                return;
            }
            n0();
            SubtitleDecoder subtitleDecoder = (SubtitleDecoder) Assertions.f(this.f7334y);
            subtitleDecoder.flush();
            subtitleDecoder.e(K());
        }
    }

    /* access modifiers changed from: protected */
    public void X(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) {
        CuesResolver cuesResolver;
        this.J = j3;
        Format format = formatArr[0];
        this.I = format;
        if (!l0(format)) {
            c0();
            if (this.f7334y != null) {
                this.f7333x = 1;
            } else {
                j0();
            }
        } else {
            if (this.I.H == 1) {
                cuesResolver = new MergingCuesResolver();
            } else {
                cuesResolver = new ReplacingCuesResolver();
            }
            this.f7330u = cuesResolver;
        }
    }

    public boolean a() {
        return this.H;
    }

    public int c(Format format) {
        int i2;
        if (l0(format) || this.f7331v.c(format)) {
            if (format.K == 0) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            return x.a(i2);
        } else if (MimeTypes.r(format.f4015n)) {
            return x.a(1);
        } else {
            return x.a(0);
        }
    }

    @Deprecated
    public void e0(boolean z2) {
        this.M = z2;
    }

    public void f(long j2, long j3) {
        if (l()) {
            long j4 = this.L;
            if (j4 != -9223372036854775807L && j2 >= j4) {
                n0();
                this.H = true;
            }
        }
        if (!this.H) {
            if (l0((Format) Assertions.f(this.I))) {
                Assertions.f(this.f7330u);
                p0(j2);
                return;
            }
            c0();
            q0(j2);
        }
    }

    public String getName() {
        return "TextRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            k0((CueGroup) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isReady() {
        return true;
    }

    public void s0(long j2) {
        Assertions.h(l());
        this.L = j2;
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.E = (TextOutput) Assertions.f(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.z(looper, this);
        }
        this.D = handler;
        this.f7331v = subtitleDecoderFactory;
        this.f7328s = new CueDecoder();
        this.f7329t = new DecoderInputBuffer(1);
        this.F = new FormatHolder();
        this.L = -9223372036854775807L;
        this.J = -9223372036854775807L;
        this.K = -9223372036854775807L;
        this.M = false;
    }
}
