package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class TrackFragment {

    /* renamed from: a  reason: collision with root package name */
    public DefaultSampleValues f24675a;

    /* renamed from: b  reason: collision with root package name */
    public long f24676b;

    /* renamed from: c  reason: collision with root package name */
    public long f24677c;

    /* renamed from: d  reason: collision with root package name */
    public long f24678d;

    /* renamed from: e  reason: collision with root package name */
    public int f24679e;

    /* renamed from: f  reason: collision with root package name */
    public int f24680f;

    /* renamed from: g  reason: collision with root package name */
    public long[] f24681g = new long[0];

    /* renamed from: h  reason: collision with root package name */
    public int[] f24682h = new int[0];

    /* renamed from: i  reason: collision with root package name */
    public int[] f24683i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public long[] f24684j = new long[0];

    /* renamed from: k  reason: collision with root package name */
    public boolean[] f24685k = new boolean[0];

    /* renamed from: l  reason: collision with root package name */
    public boolean f24686l;

    /* renamed from: m  reason: collision with root package name */
    public boolean[] f24687m = new boolean[0];

    /* renamed from: n  reason: collision with root package name */
    public TrackEncryptionBox f24688n;

    /* renamed from: o  reason: collision with root package name */
    public final ParsableByteArray f24689o = new ParsableByteArray();

    /* renamed from: p  reason: collision with root package name */
    public boolean f24690p;

    /* renamed from: q  reason: collision with root package name */
    public long f24691q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f24692r;

    public void a(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.f24689o.e(), 0, this.f24689o.g());
        this.f24689o.U(0);
        this.f24690p = false;
    }

    public void b(ParsableByteArray parsableByteArray) {
        parsableByteArray.l(this.f24689o.e(), 0, this.f24689o.g());
        this.f24689o.U(0);
        this.f24690p = false;
    }

    public long c(int i2) {
        return this.f24684j[i2];
    }

    public void d(int i2) {
        this.f24689o.Q(i2);
        this.f24686l = true;
        this.f24690p = true;
    }

    public void e(int i2, int i3) {
        this.f24679e = i2;
        this.f24680f = i3;
        if (this.f24682h.length < i2) {
            this.f24681g = new long[i2];
            this.f24682h = new int[i2];
        }
        if (this.f24683i.length < i3) {
            int i4 = (i3 * 125) / 100;
            this.f24683i = new int[i4];
            this.f24684j = new long[i4];
            this.f24685k = new boolean[i4];
            this.f24687m = new boolean[i4];
        }
    }

    public void f() {
        this.f24679e = 0;
        this.f24691q = 0;
        this.f24692r = false;
        this.f24686l = false;
        this.f24690p = false;
        this.f24688n = null;
    }

    public boolean g(int i2) {
        return this.f24686l && this.f24687m[i2];
    }
}
