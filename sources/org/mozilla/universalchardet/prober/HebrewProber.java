package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;

public class HebrewProber extends CharsetProber {

    /* renamed from: b  reason: collision with root package name */
    private int f41922b;

    /* renamed from: c  reason: collision with root package name */
    private int f41923c;

    /* renamed from: d  reason: collision with root package name */
    private byte f41924d;

    /* renamed from: e  reason: collision with root package name */
    private byte f41925e;

    /* renamed from: f  reason: collision with root package name */
    private CharsetProber f41926f = null;

    /* renamed from: g  reason: collision with root package name */
    private CharsetProber f41927g = null;

    public HebrewProber() {
        j();
    }

    protected static boolean l(byte b2) {
        byte b3 = b2 & 255;
        return b3 == 234 || b3 == 237 || b3 == 239 || b3 == 243 || b3 == 245;
    }

    protected static boolean m(byte b2) {
        byte b3 = b2 & 255;
        return b3 == 235 || b3 == 238 || b3 == 240 || b3 == 244;
    }

    public String c() {
        int i2 = this.f41922b - this.f41923c;
        if (i2 >= 5) {
            return Constants.f41863t;
        }
        if (i2 <= -5) {
            return Constants.f41849f;
        }
        float d2 = this.f41926f.d() - this.f41927g.d();
        if (d2 > 0.01f) {
            return Constants.f41863t;
        }
        if (d2 < -0.01f) {
            return Constants.f41849f;
        }
        if (i2 < 0) {
            return Constants.f41849f;
        }
        return Constants.f41863t;
    }

    public float d() {
        return 0.0f;
    }

    public CharsetProber.ProbingState e() {
        CharsetProber.ProbingState e2 = this.f41926f.e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (e2 == probingState && this.f41927g.e() == probingState) {
            return probingState;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        CharsetProber.ProbingState e2 = e();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (e2 == probingState) {
            return probingState;
        }
        int i4 = i3 + i2;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 == 32) {
                if (this.f41925e != 32) {
                    if (l(this.f41924d)) {
                        this.f41922b++;
                    } else if (m(this.f41924d)) {
                        this.f41923c++;
                    }
                }
            } else if (this.f41925e == 32 && l(this.f41924d) && b2 != 32) {
                this.f41923c++;
            }
            this.f41925e = this.f41924d;
            this.f41924d = b2;
            i2++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    public final void j() {
        this.f41922b = 0;
        this.f41923c = 0;
        this.f41924d = 32;
        this.f41925e = 32;
    }

    public void n(CharsetProber charsetProber, CharsetProber charsetProber2) {
        this.f41926f = charsetProber;
        this.f41927g = charsetProber2;
    }
}
