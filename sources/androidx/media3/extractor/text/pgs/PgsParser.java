package androidx.media3.extractor.text.pgs;

import android.graphics.Bitmap;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.f;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

public final class PgsParser implements SubtitleParser {

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f8963a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f8964b = new ParsableByteArray();

    /* renamed from: c  reason: collision with root package name */
    private final CueBuilder f8965c = new CueBuilder();

    /* renamed from: d  reason: collision with root package name */
    private Inflater f8966d;

    private static final class CueBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f8967a = new ParsableByteArray();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f8968b = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];

        /* renamed from: c  reason: collision with root package name */
        private boolean f8969c;

        /* renamed from: d  reason: collision with root package name */
        private int f8970d;

        /* renamed from: e  reason: collision with root package name */
        private int f8971e;

        /* renamed from: f  reason: collision with root package name */
        private int f8972f;

        /* renamed from: g  reason: collision with root package name */
        private int f8973g;

        /* renamed from: h  reason: collision with root package name */
        private int f8974h;

        /* renamed from: i  reason: collision with root package name */
        private int f8975i;

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
                        this.f8974h = parsableByteArray.N();
                        this.f8975i = parsableByteArray.N();
                        this.f8967a.Q(K - 4);
                        i3 -= 7;
                    } else {
                        return;
                    }
                }
                int f2 = this.f8967a.f();
                int g2 = this.f8967a.g();
                if (f2 < g2 && i3 > 0) {
                    int min = Math.min(i3, g2 - f2);
                    parsableByteArray.l(this.f8967a.e(), f2, min);
                    this.f8967a.U(f2 + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void f(ParsableByteArray parsableByteArray, int i2) {
            if (i2 >= 19) {
                this.f8970d = parsableByteArray.N();
                this.f8971e = parsableByteArray.N();
                parsableByteArray.V(11);
                this.f8972f = parsableByteArray.N();
                this.f8973g = parsableByteArray.N();
            }
        }

        /* access modifiers changed from: private */
        public void g(ParsableByteArray parsableByteArray, int i2) {
            if (i2 % 5 == 2) {
                parsableByteArray.V(2);
                Arrays.fill(this.f8968b, 0);
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
                    this.f8968b[H] = (Util.p((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, JfifUtil.MARKER_FIRST_BYTE) << 8) | (H5 << 24) | (Util.p((int) ((1.402d * d3) + d2), 0, JfifUtil.MARKER_FIRST_BYTE) << 16) | Util.p((int) (d2 + (d4 * 1.772d)), 0, JfifUtil.MARKER_FIRST_BYTE);
                }
                this.f8969c = true;
            }
        }

        public Cue d() {
            int i2;
            int i3;
            int i4;
            if (this.f8970d == 0 || this.f8971e == 0 || this.f8974h == 0 || this.f8975i == 0 || this.f8967a.g() == 0 || this.f8967a.f() != this.f8967a.g() || !this.f8969c) {
                return null;
            }
            this.f8967a.U(0);
            int i5 = this.f8974h * this.f8975i;
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int H = this.f8967a.H();
                if (H != 0) {
                    i4 = i6 + 1;
                    iArr[i6] = this.f8968b[H];
                } else {
                    int H2 = this.f8967a.H();
                    if (H2 != 0) {
                        if ((H2 & 64) == 0) {
                            i2 = H2 & 63;
                        } else {
                            i2 = ((H2 & 63) << 8) | this.f8967a.H();
                        }
                        if ((H2 & 128) == 0) {
                            i3 = this.f8968b[0];
                        } else {
                            i3 = this.f8968b[this.f8967a.H()];
                        }
                        i4 = i2 + i6;
                        Arrays.fill(iArr, i6, i4, i3);
                    }
                }
                i6 = i4;
            }
            return new Cue.Builder().f(Bitmap.createBitmap(iArr, this.f8974h, this.f8975i, Bitmap.Config.ARGB_8888)).k(((float) this.f8972f) / ((float) this.f8970d)).l(0).h(((float) this.f8973g) / ((float) this.f8971e), 0).i(0).n(((float) this.f8974h) / ((float) this.f8970d)).g(((float) this.f8975i) / ((float) this.f8971e)).a();
        }

        public void h() {
            this.f8970d = 0;
            this.f8971e = 0;
            this.f8972f = 0;
            this.f8973g = 0;
            this.f8974h = 0;
            this.f8975i = 0;
            this.f8967a.Q(0);
            this.f8969c = false;
        }
    }

    private void d(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() > 0 && parsableByteArray.j() == 120) {
            if (this.f8966d == null) {
                this.f8966d = new Inflater();
            }
            if (Util.A0(parsableByteArray, this.f8964b, this.f8966d)) {
                parsableByteArray.S(this.f8964b.e(), this.f8964b.g());
            }
        }
    }

    private static Cue e(ParsableByteArray parsableByteArray, CueBuilder cueBuilder) {
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

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        this.f8963a.S(bArr, i3 + i2);
        this.f8963a.U(i2);
        d(this.f8963a);
        this.f8965c.h();
        ArrayList arrayList = new ArrayList();
        while (this.f8963a.a() >= 3) {
            Cue e2 = e(this.f8963a, this.f8965c);
            if (e2 != null) {
                arrayList.add(e2);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return f.a(this, bArr, i2, i3);
    }

    public int c() {
        return 2;
    }

    public /* synthetic */ void reset() {
        f.b(this);
    }
}
