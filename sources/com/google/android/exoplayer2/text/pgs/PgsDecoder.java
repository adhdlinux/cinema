package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class PgsDecoder extends SimpleSubtitleDecoder {

    /* renamed from: o  reason: collision with root package name */
    private final ParsableByteArray f27422o = new ParsableByteArray();

    /* renamed from: p  reason: collision with root package name */
    private final ParsableByteArray f27423p = new ParsableByteArray();

    /* renamed from: q  reason: collision with root package name */
    private final CueBuilder f27424q = new CueBuilder();

    /* renamed from: r  reason: collision with root package name */
    private Inflater f27425r;

    private static final class CueBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f27426a = new ParsableByteArray();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f27427b = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];

        /* renamed from: c  reason: collision with root package name */
        private boolean f27428c;

        /* renamed from: d  reason: collision with root package name */
        private int f27429d;

        /* renamed from: e  reason: collision with root package name */
        private int f27430e;

        /* renamed from: f  reason: collision with root package name */
        private int f27431f;

        /* renamed from: g  reason: collision with root package name */
        private int f27432g;

        /* renamed from: h  reason: collision with root package name */
        private int f27433h;

        /* renamed from: i  reason: collision with root package name */
        private int f27434i;

        /* access modifiers changed from: private */
        public void e(ParsableByteArray parsableByteArray, int i2) {
            boolean z2;
            int K;
            if (i2 >= 4) {
                parsableByteArray.V(3);
                if ((parsableByteArray.H() & 128) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int i3 = i2 - 4;
                if (z2) {
                    if (i3 >= 7 && (K = parsableByteArray.K()) >= 4) {
                        this.f27433h = parsableByteArray.N();
                        this.f27434i = parsableByteArray.N();
                        this.f27426a.Q(K - 4);
                        i3 -= 7;
                    } else {
                        return;
                    }
                }
                int f2 = this.f27426a.f();
                int g2 = this.f27426a.g();
                if (f2 < g2 && i3 > 0) {
                    int min = Math.min(i3, g2 - f2);
                    parsableByteArray.l(this.f27426a.e(), f2, min);
                    this.f27426a.U(f2 + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void f(ParsableByteArray parsableByteArray, int i2) {
            if (i2 >= 19) {
                this.f27429d = parsableByteArray.N();
                this.f27430e = parsableByteArray.N();
                parsableByteArray.V(11);
                this.f27431f = parsableByteArray.N();
                this.f27432g = parsableByteArray.N();
            }
        }

        /* access modifiers changed from: private */
        public void g(ParsableByteArray parsableByteArray, int i2) {
            if (i2 % 5 == 2) {
                parsableByteArray.V(2);
                Arrays.fill(this.f27427b, 0);
                int i3 = i2 / 5;
                for (int i4 = 0; i4 < i3; i4++) {
                    int H = parsableByteArray.H();
                    int H2 = parsableByteArray.H();
                    int H3 = parsableByteArray.H();
                    int H4 = parsableByteArray.H();
                    int H5 = parsableByteArray.H();
                    double d2 = (double) H2;
                    double d3 = (double) (H3 - 128);
                    double d4 = (double) (H4 - 128);
                    this.f27427b[H] = (Util.q((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, JfifUtil.MARKER_FIRST_BYTE) << 8) | (H5 << 24) | (Util.q((int) ((1.402d * d3) + d2), 0, JfifUtil.MARKER_FIRST_BYTE) << 16) | Util.q((int) (d2 + (d4 * 1.772d)), 0, JfifUtil.MARKER_FIRST_BYTE);
                }
                this.f27428c = true;
            }
        }

        public Cue d() {
            int i2;
            int i3;
            int i4;
            if (this.f27429d == 0 || this.f27430e == 0 || this.f27433h == 0 || this.f27434i == 0 || this.f27426a.g() == 0 || this.f27426a.f() != this.f27426a.g() || !this.f27428c) {
                return null;
            }
            this.f27426a.U(0);
            int i5 = this.f27433h * this.f27434i;
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int H = this.f27426a.H();
                if (H != 0) {
                    i4 = i6 + 1;
                    iArr[i6] = this.f27427b[H];
                } else {
                    int H2 = this.f27426a.H();
                    if (H2 != 0) {
                        if ((H2 & 64) == 0) {
                            i2 = H2 & 63;
                        } else {
                            i2 = ((H2 & 63) << 8) | this.f27426a.H();
                        }
                        if ((H2 & 128) == 0) {
                            i3 = 0;
                        } else {
                            i3 = this.f27427b[this.f27426a.H()];
                        }
                        i4 = i2 + i6;
                        Arrays.fill(iArr, i6, i4, i3);
                    }
                }
                i6 = i4;
            }
            return new Cue.Builder().f(Bitmap.createBitmap(iArr, this.f27433h, this.f27434i, Bitmap.Config.ARGB_8888)).k(((float) this.f27431f) / ((float) this.f27429d)).l(0).h(((float) this.f27432g) / ((float) this.f27430e), 0).i(0).n(((float) this.f27433h) / ((float) this.f27429d)).g(((float) this.f27434i) / ((float) this.f27430e)).a();
        }

        public void h() {
            this.f27429d = 0;
            this.f27430e = 0;
            this.f27431f = 0;
            this.f27432g = 0;
            this.f27433h = 0;
            this.f27434i = 0;
            this.f27426a.Q(0);
            this.f27428c = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
    }

    private void B(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() > 0 && parsableByteArray.j() == 120) {
            if (this.f27425r == null) {
                this.f27425r = new Inflater();
            }
            if (Util.t0(parsableByteArray, this.f27423p, this.f27425r)) {
                parsableByteArray.S(this.f27423p.e(), this.f27423p.g());
            }
        }
    }

    private static Cue C(ParsableByteArray parsableByteArray, CueBuilder cueBuilder) {
        int g2 = parsableByteArray.g();
        int H = parsableByteArray.H();
        int N = parsableByteArray.N();
        int f2 = parsableByteArray.f() + N;
        Cue cue = null;
        if (f2 > g2) {
            parsableByteArray.U(g2);
            return null;
        }
        if (H != 128) {
            switch (H) {
                case 20:
                    cueBuilder.g(parsableByteArray, N);
                    break;
                case 21:
                    cueBuilder.e(parsableByteArray, N);
                    break;
                case 22:
                    cueBuilder.f(parsableByteArray, N);
                    break;
            }
        } else {
            cue = cueBuilder.d();
            cueBuilder.h();
        }
        parsableByteArray.U(f2);
        return cue;
    }

    /* access modifiers changed from: protected */
    public Subtitle z(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        this.f27422o.S(bArr, i2);
        B(this.f27422o);
        this.f27424q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f27422o.a() >= 3) {
            Cue C = C(this.f27422o, this.f27424q);
            if (C != null) {
                arrayList.add(C);
            }
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList));
    }
}
