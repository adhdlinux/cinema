package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.SequenceModel;

public class SingleByteCharsetProber extends CharsetProber {

    /* renamed from: b  reason: collision with root package name */
    private CharsetProber.ProbingState f41947b;

    /* renamed from: c  reason: collision with root package name */
    private SequenceModel f41948c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41949d;

    /* renamed from: e  reason: collision with root package name */
    private short f41950e;

    /* renamed from: f  reason: collision with root package name */
    private int f41951f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f41952g;

    /* renamed from: h  reason: collision with root package name */
    private int f41953h;

    /* renamed from: i  reason: collision with root package name */
    private int f41954i;

    /* renamed from: j  reason: collision with root package name */
    private CharsetProber f41955j;

    public SingleByteCharsetProber(SequenceModel sequenceModel) {
        this.f41948c = sequenceModel;
        this.f41949d = false;
        this.f41955j = null;
        this.f41952g = new int[4];
        j();
    }

    public String c() {
        CharsetProber charsetProber = this.f41955j;
        if (charsetProber == null) {
            return this.f41948c.a();
        }
        return charsetProber.c();
    }

    public float d() {
        int i2 = this.f41951f;
        if (i2 <= 0) {
            return 0.01f;
        }
        float d2 = ((((((float) this.f41952g[3]) * 1.0f) / ((float) i2)) / this.f41948c.d()) * ((float) this.f41954i)) / ((float) this.f41953h);
        if (d2 >= 1.0f) {
            return 0.99f;
        }
        return d2;
    }

    public CharsetProber.ProbingState e() {
        return this.f41947b;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4) {
            short b2 = this.f41948c.b(bArr[i2]);
            if (b2 < 250) {
                this.f41953h++;
            }
            if (b2 < 64) {
                this.f41954i++;
                short s2 = this.f41950e;
                if (s2 < 64) {
                    this.f41951f++;
                    if (!this.f41949d) {
                        int[] iArr = this.f41952g;
                        byte c2 = this.f41948c.c((s2 * 64) + b2);
                        iArr[c2] = iArr[c2] + 1;
                    } else {
                        int[] iArr2 = this.f41952g;
                        byte c3 = this.f41948c.c((b2 * 64) + s2);
                        iArr2[c3] = iArr2[c3] + 1;
                    }
                }
            }
            this.f41950e = b2;
            i2++;
        }
        if (this.f41947b == CharsetProber.ProbingState.DETECTING && this.f41951f > 1024) {
            float d2 = d();
            if (d2 > 0.95f) {
                this.f41947b = CharsetProber.ProbingState.FOUND_IT;
            } else if (d2 < 0.05f) {
                this.f41947b = CharsetProber.ProbingState.NOT_ME;
            }
        }
        return this.f41947b;
    }

    public final void j() {
        this.f41947b = CharsetProber.ProbingState.DETECTING;
        this.f41950e = 255;
        for (int i2 = 0; i2 < 4; i2++) {
            this.f41952g[i2] = 0;
        }
        this.f41951f = 0;
        this.f41953h = 0;
        this.f41954i = 0;
    }

    public SingleByteCharsetProber(SequenceModel sequenceModel, boolean z2, CharsetProber charsetProber) {
        this.f41948c = sequenceModel;
        this.f41949d = z2;
        this.f41955j = charsetProber;
        this.f41952g = new int[4];
        j();
    }
}
