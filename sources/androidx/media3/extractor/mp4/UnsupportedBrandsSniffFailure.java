package androidx.media3.extractor.mp4;

import androidx.media3.extractor.SniffFailure;
import com.google.common.primitives.ImmutableIntArray;

public final class UnsupportedBrandsSniffFailure implements SniffFailure {

    /* renamed from: a  reason: collision with root package name */
    public final int f8702a;

    /* renamed from: b  reason: collision with root package name */
    public final ImmutableIntArray f8703b;

    public UnsupportedBrandsSniffFailure(int i2, int[] iArr) {
        ImmutableIntArray immutableIntArray;
        this.f8702a = i2;
        if (iArr != null) {
            immutableIntArray = ImmutableIntArray.a(iArr);
        } else {
            immutableIntArray = ImmutableIntArray.e();
        }
        this.f8703b = immutableIntArray;
    }
}
