package org.mozilla.universalchardet.prober;

import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.statemachine.CodingStateMachine;
import org.mozilla.universalchardet.prober.statemachine.HZSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022CNSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022JPSMModel;
import org.mozilla.universalchardet.prober.statemachine.ISO2022KRSMModel;

public class EscCharsetProber extends CharsetProber {

    /* renamed from: f  reason: collision with root package name */
    private static final HZSMModel f41909f = new HZSMModel();

    /* renamed from: g  reason: collision with root package name */
    private static final ISO2022CNSMModel f41910g = new ISO2022CNSMModel();

    /* renamed from: h  reason: collision with root package name */
    private static final ISO2022JPSMModel f41911h = new ISO2022JPSMModel();

    /* renamed from: i  reason: collision with root package name */
    private static final ISO2022KRSMModel f41912i = new ISO2022KRSMModel();

    /* renamed from: b  reason: collision with root package name */
    private CodingStateMachine[] f41913b;

    /* renamed from: c  reason: collision with root package name */
    private int f41914c;

    /* renamed from: d  reason: collision with root package name */
    private CharsetProber.ProbingState f41915d;

    /* renamed from: e  reason: collision with root package name */
    private String f41916e;

    public EscCharsetProber() {
        CodingStateMachine[] codingStateMachineArr = new CodingStateMachine[4];
        this.f41913b = codingStateMachineArr;
        codingStateMachineArr[0] = new CodingStateMachine(f41909f);
        this.f41913b[1] = new CodingStateMachine(f41910g);
        this.f41913b[2] = new CodingStateMachine(f41911h);
        this.f41913b[3] = new CodingStateMachine(f41912i);
        j();
    }

    public String c() {
        return this.f41916e;
    }

    public float d() {
        return 0.99f;
    }

    public CharsetProber.ProbingState e() {
        return this.f41915d;
    }

    public CharsetProber.ProbingState f(byte[] bArr, int i2, int i3) {
        int i4 = i3 + i2;
        while (i2 < i4 && this.f41915d == CharsetProber.ProbingState.DETECTING) {
            for (int i5 = this.f41914c - 1; i5 >= 0; i5--) {
                int c2 = this.f41913b[i5].c(bArr[i2]);
                if (c2 == 1) {
                    int i6 = this.f41914c - 1;
                    this.f41914c = i6;
                    if (i6 <= 0) {
                        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
                        this.f41915d = probingState;
                        return probingState;
                    } else if (i5 != i6) {
                        CodingStateMachine[] codingStateMachineArr = this.f41913b;
                        CodingStateMachine codingStateMachine = codingStateMachineArr[i6];
                        codingStateMachineArr[i6] = codingStateMachineArr[i5];
                        codingStateMachineArr[i5] = codingStateMachine;
                    }
                } else if (c2 == 2) {
                    this.f41915d = CharsetProber.ProbingState.FOUND_IT;
                    this.f41916e = this.f41913b[i5].a();
                    return this.f41915d;
                }
            }
            i2++;
        }
        return this.f41915d;
    }

    public final void j() {
        this.f41915d = CharsetProber.ProbingState.DETECTING;
        int i2 = 0;
        while (true) {
            CodingStateMachine[] codingStateMachineArr = this.f41913b;
            if (i2 < codingStateMachineArr.length) {
                codingStateMachineArr[i2].d();
                i2++;
            } else {
                this.f41914c = codingStateMachineArr.length;
                this.f41916e = null;
                return;
            }
        }
    }
}
