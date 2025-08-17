package androidx.media3.common;

public final class AuxEffectInfo {

    /* renamed from: a  reason: collision with root package name */
    public final int f3927a;

    /* renamed from: b  reason: collision with root package name */
    public final float f3928b;

    public AuxEffectInfo(int i2, float f2) {
        this.f3927a = i2;
        this.f3928b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        if (this.f3927a == auxEffectInfo.f3927a && Float.compare(auxEffectInfo.f3928b, this.f3928b) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f3927a) * 31) + Float.floatToIntBits(this.f3928b);
    }
}
