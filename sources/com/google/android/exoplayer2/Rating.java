package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;

public abstract class Rating implements Bundleable {

    /* renamed from: b  reason: collision with root package name */
    static final String f23448b = Util.u0(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Bundleable.Creator<Rating> f23449c = new z1();

    Rating() {
    }

    /* access modifiers changed from: private */
    public static Rating b(Bundle bundle) {
        int i2 = bundle.getInt(f23448b, -1);
        if (i2 == 0) {
            return HeartRating.f23115h.a(bundle);
        }
        if (i2 == 1) {
            return PercentageRating.f23366f.a(bundle);
        }
        if (i2 == 2) {
            return StarRating.f23464h.a(bundle);
        }
        if (i2 == 3) {
            return ThumbRating.f23478h.a(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i2);
    }
}
