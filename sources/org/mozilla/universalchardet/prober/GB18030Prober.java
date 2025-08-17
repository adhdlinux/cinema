package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.GB2312DistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.GB18030SMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class GB18030Prober extends CharsetProber {

    /* renamed from: f  reason: collision with root package name */
    private static final SMModel f41917f = new GB18030SMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41918b = new CodingStateMachine(f41917f);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41919c;

    /* renamed from: d  reason: collision with root package name */
    private GB2312DistributionAnalysis f41920d = new GB2312DistributionAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f41921e = new byte[2];

    public GB18030Prober() {
        j();
    }

    public String c() {
        return Constants.f41851h;
    }

    public float d() {
        return this.f41920d.a();
    }

    public CharsetProber.ProbingState e() {
        return this.f41919c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41918b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41919c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41919c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41918b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41921e;
                        bArr2[1] = bArr[i2];
                        this.f41920d.d(bArr2, 0, b2);
                    } else {
                        this.f41920d.d(bArr, i5 - 1, b2);
                    }
                }
                i5++;
            }
        }
        this.f41921e[0] = bArr[i4 - 1];
        if (this.f41919c == CharsetProber.ProbingState.DETECTING && this.f41920d.c() && d() > 0.95f) {
            this.f41919c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41919c;
    }

    public final void j() {
        this.f41918b.d();
        this.f41919c = CharsetProber.ProbingState.DETECTING;
        this.f41920d.e();
        Arrays.fill(this.f41921e, (byte) 0);
    }
}
