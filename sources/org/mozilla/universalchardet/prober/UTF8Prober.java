package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SMModel;
import org.mozilla.universalchardet.prober.statemachine.UTF8SMModel;

public class UTF8Prober extends CharsetProber {

    /* renamed from: e  reason: collision with root package name */
    private static final SMModel f41956e = new UTF8SMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41957b = new CodingStateMachine(f41956e);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41958c;

    /* renamed from: d  reason: collision with root package name */
    private int f41959d = 0;

    public UTF8Prober() {
        j();
    }

    public String c() {
        return Constants.f41864u;
    }

    public float d() {
        float f2 = 0.99f;
        if (this.f41959d >= 6) {
            return 0.99f;
        }
        for (int i2 = 0; i2 < this.f41959d; i2++) {
            f2 *= 0.5f;
        }
        return 1.0f - f2;
    }

    public CharsetProber.ProbingState e() {
        return this.f41958c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (true) {
            if (i2 >= i4) {
                break;
            }
            int c2 = this.f41957b.c(bArr[i2]);
            if (c2 == 1) {
                this.f41958c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41958c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0 && this.f41957b.b() >= 2) {
                    this.f41959d++;
                }
                i2++;
            }
        }
        if (this.f41958c == CharsetProber.ProbingState.DETECTING && d() > 0.95f) {
            this.f41958c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41958c;
    }

    public final void j() {
        this.f41957b.d();
        this.f41959d = 0;
        this.f41958c = CharsetProber.ProbingState.DETECTING;
    }
}
