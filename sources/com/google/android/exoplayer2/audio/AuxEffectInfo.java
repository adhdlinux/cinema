package com.google.android.exoplayer2.audio;

public final class AuxEffectInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f23734a;

    /* renamed from: b  reason: collision with root package name */
    public final float f23735b;

    public AuxEffectInfo(int i2, float f2) {
        this.f23734a = i2;
        this.f23735b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        if (this.f23734a == auxEffectInfo.f23734a && Float.compare(auxEffectInfo.f23735b, this.f23735b) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f23734a) * 31) + Float.floatToIntBits(this.f23735b);
    }
}
