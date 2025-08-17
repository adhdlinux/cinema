package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCKRDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCKRSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCKRProber extends CharsetProber {

    /* renamed from: f  reason: collision with root package name */
    private static final SMModel f41899f = new EUCKRSMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41900b = new CodingStateMachine(f41899f);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41901c;

    /* renamed from: d  reason: collision with root package name */
    private EUCKRDistributionAnalysis f41902d = new EUCKRDistributionAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f41903e = new byte[2];

    public EUCKRProber() {
        j();
    }

    public String c() {
        return Constants.f41853j;
    }

    public float d() {
        return this.f41902d.a();
    }

    public CharsetProber.ProbingState e() {
        return this.f41901c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41900b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41901c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41901c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41900b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41903e;
                        bArr2[1] = bArr[i2];
                        this.f41902d.d(bArr2, 0, b2);
                    } else {
                        this.f41902d.d(bArr, i5 - 1, b2);
                    }
                }
                i5++;
            }
        }
        this.f41903e[0] = bArr[i4 - 1];
        if (this.f41901c == CharsetProber.ProbingState.DETECTING && this.f41902d.c() && d() > 0.95f) {
            this.f41901c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41901c;
    }

    public final void j() {
        this.f41900b.d();
        this.f41901c = CharsetProber.ProbingState.DETECTING;
        this.f41902d.e();
        Arrays.fill(this.f41903e, (byte) 0);
    }
}
