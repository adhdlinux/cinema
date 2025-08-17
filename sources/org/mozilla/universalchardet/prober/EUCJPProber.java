package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.EUCJPDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.EUCJPSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class EUCJPProber extends CharsetProber {

    /* renamed from: g  reason: collision with root package name */
    private static final SMModel f41893g = new EUCJPSMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41894b = new CodingStateMachine(f41893g);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41895c;

    /* renamed from: d  reason: collision with root package name */
    private EUCJPContextAnalysis f41896d = new EUCJPContextAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private EUCJPDistributionAnalysis f41897e = new EUCJPDistributionAnalysis();

    /* renamed from: f  reason: collision with root package name */
    private byte[] f41898f = new byte[2];

    public EUCJPProber() {
        j();
    }

    public String c() {
        return Constants.f41852i;
    }

    public float d() {
        return Math.max(this.f41896d.a(), this.f41897e.a());
    }

    public CharsetProber.ProbingState e() {
        return this.f41895c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41894b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41895c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41895c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41894b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41898f;
                        bArr2[1] = bArr[i2];
                        this.f41896d.d(bArr2, 0, b2);
                        this.f41897e.d(this.f41898f, 0, b2);
                    } else {
                        int i6 = i5 - 1;
                        this.f41896d.d(bArr, i6, b2);
                        this.f41897e.d(bArr, i6, b2);
                    }
                }
                i5++;
            }
        }
        this.f41898f[0] = bArr[i4 - 1];
        if (this.f41895c == CharsetProber.ProbingState.DETECTING && this.f41896d.c() && d() > 0.95f) {
            this.f41895c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41895c;
    }

    public final void j() {
        this.f41894b.d();
        this.f41895c = CharsetProber.ProbingState.DETECTING;
        this.f41896d.e();
        this.f41897e.e();
        Arrays.fill(this.f41898f, (byte) 0);
    }
}
