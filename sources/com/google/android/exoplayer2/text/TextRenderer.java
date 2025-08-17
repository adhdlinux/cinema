package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.b2;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private SubtitleOutputBuffer A;
    private int B;
    private long C;
    private long D;
    private long E;

    /* renamed from: o  reason: collision with root package name */
    private final Handler f27267o;

    /* renamed from: p  reason: collision with root package name */
    private final TextOutput f27268p;

    /* renamed from: q  reason: collision with root package name */
    private final SubtitleDecoderFactory f27269q;

    /* renamed from: r  reason: collision with root package name */
    private final FormatHolder f27270r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f27271s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f27272t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f27273u;

    /* renamed from: v  reason: collision with root package name */
    private int f27274v;

    /* renamed from: w  reason: collision with root package name */
    private Format f27275w;

    /* renamed from: x  reason: collision with root package name */
    private SubtitleDecoder f27276x;

    /* renamed from: y  reason: collision with root package name */
    private SubtitleInputBuffer f27277y;

    /* renamed from: z  reason: collision with root package name */
    private SubtitleOutputBuffer f27278z;

    public TextRenderer(TextOutput textOutput, Looper looper) {
        this(textOutput, looper, SubtitleDecoderFactory.f27252a);
    }

    private void N() {
        Y(new CueGroup(ImmutableList.r(), Q(this.E)));
    }

    @SideEffectFree
    @RequiresNonNull({"subtitle"})
    private long O(long j2) {
        int a2 = this.f27278z.a(j2);
        if (a2 == 0 || this.f27278z.d() == 0) {
            return this.f27278z.f23969c;
        }
        if (a2 != -1) {
            return this.f27278z.c(a2 - 1);
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.f27278z;
        return subtitleOutputBuffer.c(subtitleOutputBuffer.d() - 1);
    }

    private long P() {
        if (this.B == -1) {
            return Clock.MAX_TIME;
        }
        Assertions.e(this.f27278z);
        if (this.B >= this.f27278z.d()) {
            return Clock.MAX_TIME;
        }
        return this.f27278z.c(this.B);
    }

    @SideEffectFree
    private long Q(long j2) {
        boolean z2;
        boolean z3 = true;
        if (j2 != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (this.D == -9223372036854775807L) {
            z3 = false;
        }
        Assertions.g(z3);
        return j2 - this.D;
    }

    private void R(SubtitleDecoderException subtitleDecoderException) {
        Log.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f27275w, subtitleDecoderException);
        N();
        W();
    }

    private void S() {
        this.f27273u = true;
        this.f27276x = this.f27269q.a((Format) Assertions.e(this.f27275w));
    }

    private void T(CueGroup cueGroup) {
        this.f27268p.onCues((List<Cue>) cueGroup.f27240b);
        this.f27268p.onCues(cueGroup);
    }

    private void U() {
        this.f27277y = null;
        this.B = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.f27278z;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.p();
            this.f27278z = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.A;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.p();
            this.A = null;
        }
    }

    private void V() {
        U();
        ((SubtitleDecoder) Assertions.e(this.f27276x)).release();
        this.f27276x = null;
        this.f27274v = 0;
    }

    private void W() {
        V();
        S();
    }

    private void Y(CueGroup cueGroup) {
        Handler handler = this.f27267o;
        if (handler != null) {
            handler.obtainMessage(0, cueGroup).sendToTarget();
        } else {
            T(cueGroup);
        }
    }

    /* access modifiers changed from: protected */
    public void D() {
        this.f27275w = null;
        this.C = -9223372036854775807L;
        N();
        this.D = -9223372036854775807L;
        this.E = -9223372036854775807L;
        V();
    }

    /* access modifiers changed from: protected */
    public void F(long j2, boolean z2) {
        this.E = j2;
        N();
        this.f27271s = false;
        this.f27272t = false;
        this.C = -9223372036854775807L;
        if (this.f27274v != 0) {
            W();
            return;
        }
        U();
        ((SubtitleDecoder) Assertions.e(this.f27276x)).flush();
    }

    /* access modifiers changed from: protected */
    public void J(Format[] formatArr, long j2, long j3) {
        this.D = j3;
        this.f27275w = formatArr[0];
        if (this.f27276x != null) {
            this.f27274v = 1;
        } else {
            S();
        }
    }

    public void X(long j2) {
        Assertions.g(l());
        this.C = j2;
    }

    public boolean a() {
        return this.f27272t;
    }

    public int c(Format format) {
        int i2;
        if (this.f27269q.c(format)) {
            if (format.H == 0) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            return b2.a(i2);
        } else if (MimeTypes.r(format.f23071m)) {
            return b2.a(1);
        } else {
            return b2.a(0);
        }
    }

    public void f(long j2, long j3) {
        boolean z2;
        boolean z3;
        this.E = j2;
        if (l()) {
            long j4 = this.C;
            if (j4 != -9223372036854775807L && j2 >= j4) {
                U();
                this.f27272t = true;
            }
        }
        if (!this.f27272t) {
            if (this.A == null) {
                ((SubtitleDecoder) Assertions.e(this.f27276x)).b(j2);
                try {
                    this.A = (SubtitleOutputBuffer) ((SubtitleDecoder) Assertions.e(this.f27276x)).a();
                } catch (SubtitleDecoderException e2) {
                    R(e2);
                    return;
                }
            }
            if (getState() == 2) {
                if (this.f27278z != null) {
                    long P = P();
                    z2 = false;
                    while (P <= j2) {
                        this.B++;
                        P = P();
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                SubtitleOutputBuffer subtitleOutputBuffer = this.A;
                if (subtitleOutputBuffer != null) {
                    if (subtitleOutputBuffer.k()) {
                        if (!z2 && P() == Clock.MAX_TIME) {
                            if (this.f27274v == 2) {
                                W();
                            } else {
                                U();
                                this.f27272t = true;
                            }
                        }
                    } else if (subtitleOutputBuffer.f23969c <= j2) {
                        SubtitleOutputBuffer subtitleOutputBuffer2 = this.f27278z;
                        if (subtitleOutputBuffer2 != null) {
                            subtitleOutputBuffer2.p();
                        }
                        this.B = subtitleOutputBuffer.a(j2);
                        this.f27278z = subtitleOutputBuffer;
                        this.A = null;
                        z2 = true;
                    }
                }
                if (z2) {
                    Assertions.e(this.f27278z);
                    Y(new CueGroup(this.f27278z.b(j2), Q(O(j2))));
                }
                if (this.f27274v != 2) {
                    while (!this.f27271s) {
                        try {
                            SubtitleInputBuffer subtitleInputBuffer = this.f27277y;
                            if (subtitleInputBuffer == null) {
                                subtitleInputBuffer = (SubtitleInputBuffer) ((SubtitleDecoder) Assertions.e(this.f27276x)).d();
                                if (subtitleInputBuffer != null) {
                                    this.f27277y = subtitleInputBuffer;
                                } else {
                                    return;
                                }
                            }
                            if (this.f27274v == 1) {
                                subtitleInputBuffer.o(4);
                                ((SubtitleDecoder) Assertions.e(this.f27276x)).c(subtitleInputBuffer);
                                this.f27277y = null;
                                this.f27274v = 2;
                                return;
                            }
                            int K = K(this.f27270r, subtitleInputBuffer, 0);
                            if (K == -4) {
                                if (subtitleInputBuffer.k()) {
                                    this.f27271s = true;
                                    this.f27273u = false;
                                } else {
                                    Format format = this.f27270r.f23112b;
                                    if (format != null) {
                                        subtitleInputBuffer.f27264j = format.f23075q;
                                        subtitleInputBuffer.r();
                                        boolean z4 = this.f27273u;
                                        if (!subtitleInputBuffer.m()) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        this.f27273u = z4 & z3;
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.f27273u) {
                                    ((SubtitleDecoder) Assertions.e(this.f27276x)).c(subtitleInputBuffer);
                                    this.f27277y = null;
                                }
                            } else if (K == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e3) {
                            R(e3);
                            return;
                        }
                    }
                }
            }
        }
    }

    public String getName() {
        return "TextRenderer";
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            T((CueGroup) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isReady() {
        return true;
    }

    public TextRenderer(TextOutput textOutput, Looper looper, SubtitleDecoderFactory subtitleDecoderFactory) {
        super(3);
        Handler handler;
        this.f27268p = (TextOutput) Assertions.e(textOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.v(looper, this);
        }
        this.f27267o = handler;
        this.f27269q = subtitleDecoderFactory;
        this.f27270r = new FormatHolder();
        this.C = -9223372036854775807L;
        this.D = -9223372036854775807L;
        this.E = -9223372036854775807L;
    }
}
