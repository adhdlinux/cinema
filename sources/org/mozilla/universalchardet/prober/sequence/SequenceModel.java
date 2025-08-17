package org.mozilla.universalchardet.prober.sequence;

public abstract class SequenceModel {

    /* renamed from: a  reason: collision with root package name */
    protected short[] f41990a;

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f41991b;

    /* renamed from: c  reason: collision with root package name */
    protected float f41992c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f41993d;

    /* renamed from: e  reason: collision with root package name */
    protected String f41994e;

    public SequenceModel(short[] sArr, byte[] bArr, float f2, boolean z2, String str) {
        this.f41990a = (short[]) sArr.clone();
        this.f41991b = (byte[]) bArr.clone();
        this.f41992c = f2;
        this.f41993d = z2;
        this.f41994e = str;
    }

    public String a() {
        return this.f41994e;
    }

    public short b(byte b2) {
        return this.f41990a[b2 & 255];
    }

    public byte c(int i2) {
        return this.f41991b[i2];
    }

    public float d() {
        return this.f41992c;
    }
}
