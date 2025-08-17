package org.mozilla.universalchardet.prober.statemachine;

public class CodingStateMachine {

    /* renamed from: a  reason: collision with root package name */
    protected SMModel f42003a;

    /* renamed from: b  reason: collision with root package name */
    protected int f42004b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int f42005c;

    /* renamed from: d  reason: collision with root package name */
    protected int f42006d;

    public CodingStateMachine(SMModel sMModel) {
        this.f42003a = sMModel;
    }

    public String a() {
        return this.f42003a.c();
    }

    public int b() {
        return this.f42005c;
    }

    public int c(byte b2) {
        int b3 = this.f42003a.b(b2);
        if (this.f42004b == 0) {
            this.f42006d = 0;
            this.f42005c = this.f42003a.a(b3);
        }
        int d2 = this.f42003a.d(b3, this.f42004b);
        this.f42004b = d2;
        this.f42006d++;
        return d2;
    }

    public void d() {
        this.f42004b = 0;
    }
}
