package org.mozilla.universalchardet.prober.statemachine;

public abstract class SMModel {

    /* renamed from: a  reason: collision with root package name */
    protected PkgInt f42039a;

    /* renamed from: b  reason: collision with root package name */
    protected int f42040b;

    /* renamed from: c  reason: collision with root package name */
    protected PkgInt f42041c;

    /* renamed from: d  reason: collision with root package name */
    protected int[] f42042d;

    /* renamed from: e  reason: collision with root package name */
    protected String f42043e;

    public SMModel(PkgInt pkgInt, int i2, PkgInt pkgInt2, int[] iArr, String str) {
        this.f42039a = pkgInt;
        this.f42040b = i2;
        this.f42041c = pkgInt2;
        this.f42042d = (int[]) iArr.clone();
        this.f42043e = str;
    }

    public int a(int i2) {
        return this.f42042d[i2];
    }

    public int b(byte b2) {
        return this.f42039a.d(b2 & 255);
    }

    public String c() {
        return this.f42043e;
    }

    public int d(int i2, int i3) {
        return this.f42041c.d((i3 * this.f42040b) + i2);
    }
}
