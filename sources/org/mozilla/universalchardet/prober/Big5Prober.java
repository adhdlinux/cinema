package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.Big5DistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.Big5SMModel;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class Big5Prober extends CharsetProber {

    /* renamed from: f  reason: collision with root package name */
    private static final SMModel f41883f = new Big5SMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41884b = new CodingStateMachine(f41883f);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41885c;

    /* renamed from: d  reason: collision with root package name */
    private Big5DistributionAnalysis f41886d = new Big5DistributionAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f41887e = new byte[2];

    public Big5Prober() {
        j();
    }

    public String c() {
        return Constants.f41850g;
    }

    public float d() {
        return this.f41886d.a();
    }

    public CharsetProber.ProbingState e() {
        return this.f41885c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41884b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41885c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41885c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41884b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41887e;
                        bArr2[1] = bArr[i2];
                        this.f41886d.d(bArr2, 0, b2);
                    } else {
                        this.f41886d.d(bArr, i5 - 1, b2);
                    }
                }
                i5++;
            }
        }
        this.f41887e[0] = bArr[i4 - 1];
        if (this.f41885c == CharsetProber.ProbingState.DETECTING && this.f41886d.c() && d() > 0.95f) {
            this.f41885c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41885c;
    }

    public final void j() {
        this.f41884b.d();
        this.f41885c = CharsetProber.ProbingState.DETECTING;
        this.f41886d.e();
        Arrays.fill(this.f41887e, (byte) 0);
    }
}
