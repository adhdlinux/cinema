package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCTWDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCTWSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCTWProber extends CharsetProber {

    /* renamed from: f  reason: collision with root package name */
    private static final SMModel f41904f = new EUCTWSMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41905b = new CodingStateMachine(f41904f);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41906c;

    /* renamed from: d  reason: collision with root package name */
    private EUCTWDistributionAnalysis f41907d = new EUCTWDistributionAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f41908e = new byte[2];

    public EUCTWProber() {
        j();
    }

    public String c() {
        return Constants.f41854k;
    }

    public float d() {
        return this.f41907d.a();
    }

    public CharsetProber.ProbingState e() {
        return this.f41906c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41905b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41906c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41906c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41905b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41908e;
                        bArr2[1] = bArr[i2];
                        this.f41907d.d(bArr2, 0, b2);
                    } else {
                        this.f41907d.d(bArr, i5 - 1, b2);
                    }
                }
                i5++;
            }
        }
        this.f41908e[0] = bArr[i4 - 1];
        if (this.f41906c == CharsetProber.ProbingState.DETECTING && this.f41907d.c() && d() > 0.95f) {
            this.f41906c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41906c;
    }

    public final void j() {
        this.f41905b.d();
        this.f41906c = CharsetProber.ProbingState.DETECTING;
        this.f41907d.e();
        Arrays.fill(this.f41908e, (byte) 0);
    }
}
