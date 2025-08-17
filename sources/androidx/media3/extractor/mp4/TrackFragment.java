package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class TrackFragment {

    /* renamed from: a  reason: collision with root package name */
    public DefaultSampleValues f8676a;

    /* renamed from: b  reason: collision with root package name */
    public long f8677b;

    /* renamed from: c  reason: collision with root package name */
    public long f8678c;

    /* renamed from: d  reason: collision with root package name */
    public long f8679d;

    /* renamed from: e  reason: collision with root package name */
    public int f8680e;

    /* renamed from: f  reason: collision with root package name */
    public int f8681f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f8682g = new long[0];

    /* renamed from: h  reason: collision with root package name */
    public int[] f8683h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    public int[] f8684i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public long[] f8685j = new long[0];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f8686k = new boolean[0];

    /* renamed from: l  reason: collision with root package name */
    public boolean f8687l;

    /* renamed from: m  reason: collision with root package name */
    public boolean[] f8688m = new boolean[0];

    /* renamed from: n  reason: collision with root package name */
    public TrackEncryptionBox f8689n;

    /* renamed from: o  reason: collision with root package name */
    public final ParsableByteArray f8690o = new ParsableByteArray();

    /* renamed from: p  reason: collision with root package name */
    public boolean f8691p;

    /* renamed from: q  reason: collision with root package name */
    public long f8692q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f8693r;

    public void a(ParsableByteArray parsableByteArray) {
        parsableByteArray.l(this.f8690o.e(), 0, this.f8690o.g());
        this.f8690o.U(0);
        this.f8691p = false;
    }

    public void b(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.f8690o.e(), 0, this.f8690o.g());
        this.f8690o.U(0);
        this.f8691p = false;
    }

    public long c(int i2) {
        return this.f8685j[i2];
    }

    public void d(int i2) {
        this.f8690o.Q(i2);
        this.f8687l = true;
        this.f8691p = true;
    }

    public void e(int i2, int i3) {
        this.f8680e = i2;
        this.f8681f = i3;
        if (this.f8683h.length < i2) {
            this.f8682g = new long[i2];
            this.f8683h = new int[i2];
        }
        if (this.f8684i.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f8684i = new int[i4];
            this.f8685j = new long[i4];
            this.f8686k = new boolean[i4];
            this.f8688m = new boolean[i4];
        }
    }

    public void f() {
        this.f8680e = 0;
        this.f8692q = 0;
        this.f8693r = false;
        this.f8687l = false;
        this.f8691p = false;
        this.f8689n = null;
    }

    public boolean g(int i2) {
        return this.f8687l && this.f8688m[i2];
    }
}
