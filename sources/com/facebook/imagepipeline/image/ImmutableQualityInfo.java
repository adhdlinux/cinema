package com.facebook.imagepipeline.image;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ImmutableQualityInfo implements QualityInfo {
    public static final QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
    boolean mIsOfFullQuality;
    boolean mIsOfGoodEnoughQuality;
    int mQuality;

    private ImmutableQualityInfo(int i2, boolean z2, boolean z3) {
        this.mQuality = i2;
        this.mIsOfGoodEnoughQuality = z2;
        this.mIsOfFullQuality = z3;
    }

    public static QualityInfo of(int i2, boolean z2, boolean z3) {
        return new ImmutableQualityInfo(i2, z2, z3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableQualityInfo)) {
            return false;
        }
        ImmutableQualityInfo immutableQualityInfo = (ImmutableQualityInfo) obj;
        if (this.mQuality == immutableQualityInfo.mQuality && this.mIsOfGoodEnoughQuality == immutableQualityInfo.mIsOfGoodEnoughQuality && this.mIsOfFullQuality == immutableQualityInfo.mIsOfFullQuality) {
            return true;
        }
        return false;
    }

    public int getQuality() {
        return this.mQuality;
    }

    public int hashCode() {
        int i2 = 0;
        int i3 = this.mQuality ^ (this.mIsOfGoodEnoughQuality ? 4194304 : 0);
        if (this.mIsOfFullQuality) {
            i2 = 8388608;
        }
        return i3 ^ i2;
    }

    public boolean isOfFullQuality() {
        return this.mIsOfFullQuality;
    }

    public boolean isOfGoodEnoughQuality() {
        return this.mIsOfGoodEnoughQuality;
    }
}
