package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;

public final class PercentageRating extends Rating {

    /* renamed from: e  reason: collision with root package name */
    private static final String f23365e = Util.u0(1);

    /* renamed from: f  reason: collision with root package name */
    public static final Bundleable.Creator<PercentageRating> f23366f = new t1();

    /* renamed from: d  reason: collision with root package name */
    private final float f23367d;

    public PercentageRating() {
        this.f23367d = -1.0f;
    }

    /* access modifiers changed from: private */
    public static PercentageRating d(Bundle bundle) {
        boolean z2 = true;
        if (bundle.getInt(Rating.f23448b, -1) != 1) {
            z2 = false;
        }
        Assertions.a(z2);
        float f2 = bundle.getFloat(f23365e, -1.0f);
        if (f2 == -1.0f) {
            return new PercentageRating();
        }
        return new PercentageRating(f2);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof PercentageRating) && this.f23367d == ((PercentageRating) obj).f23367d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Float.valueOf(this.f23367d));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f23448b, 1);
        bundle.putFloat(f23365e, this.f23367d);
        return bundle;
    }

    public PercentageRating(float f2) {
        Assertions.b(f2 >= 0.0f && f2 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f23367d = f2;
    }
}
