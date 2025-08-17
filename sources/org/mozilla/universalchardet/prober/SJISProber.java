package org.mozilla.universalchardet.prober;

import java.util.Arrays;
import org.mozilla.universalchardet.Constants;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;
import org.mozilla.universalchardet.prober.distributionanalysis.SJISDistributionAnalysis;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.SJISSMModel;
import org.mozilla.universalchardet.prober.statemachine.SMModel;

public class SJISProber extends CharsetProber {

    /* renamed from: g  reason: collision with root package name */
    private static final SMModel f41941g = new SJISSMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine f41942b = new CodingStateMachine(f41941g);

    /* renamed from: c  reason: collision with root package name */
    private CharsetProber.ProbingState f41943c;

    /* renamed from: d  reason: collision with root package name */
    private SJISContextAnalysis f41944d = new SJISContextAnalysis();

    /* renamed from: e  reason: collision with root package name */
    private SJISDistributionAnalysis f41945e = new SJISDistributionAnalysis();

    /* renamed from: f  reason: collision with root package name */
    private byte[] f41946f = new byte[2];

    public SJISProber() {
        j();
    }

    public String c() {
        return Constants.f41855l;
    }

    public float d() {
        return Math.max(this.f41944d.a(), this.f41945e.a());
    }

    public CharsetProber.ProbingState e() {
        return this.f41943c;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            int c2 = this.f41942b.c(bArr[i5]);
            if (c2 == 1) {
                this.f41943c = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (c2 == 2) {
                this.f41943c = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (c2 == 0) {
                    int b2 = this.f41942b.b();
                    if (i5 == i2) {
                        byte[] bArr2 = this.f41946f;
                        bArr2[1] = bArr[i2];
                        this.f41944d.d(bArr2, 2 - b2, b2);
                        this.f41945e.d(this.f41946f, 0, b2);
                    } else {
                        this.f41944d.d(bArr, (i5 + 1) - b2, b2);
                        this.f41945e.d(bArr, i5 - 1, b2);
                    }
                }
                i5++;
            }
        }
        this.f41946f[0] = bArr[i4 - 1];
        if (this.f41943c == CharsetProber.ProbingState.DETECTING && this.f41944d.c() && d() > 0.95f) {
            this.f41943c = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.f41943c;
    }

    public final void j() {
        this.f41942b.d();
        this.f41943c = CharsetProber.ProbingState.DETECTING;
        this.f41944d.e();
        this.f41945e.e();
        Arrays.fill(this.f41946f, (byte) 0);
    }
}
