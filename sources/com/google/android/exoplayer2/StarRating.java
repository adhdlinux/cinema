package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;

public final class StarRating extends Rating {

    /* renamed from: f  reason: collision with root package name */
    private static final String f23462f = Util.u0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f23463g = Util.u0(2);

    /* renamed from: h  reason: collision with root package name */
    public static final Bundleable.Creator<StarRating> f23464h = new c2();

    /* renamed from: d  reason: collision with root package name */
    private final int f23465d;

    /* renamed from: e  reason: collision with root package name */
    private final float f23466e;

    public StarRating(int i2) {
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        this.f23465d = i2;
        this.f23466e = -1.0f;
    }

    /* access modifiers changed from: private */
    public static StarRating d(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(Rating.f23448b, -1) == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        int i2 = bundle.getInt(f23462f, 5);
        float f2 = bundle.getFloat(f23463g, -1.0f);
        if (f2 == -1.0f) {
            return new StarRating(i2);
        }
        return new StarRating(i2, f2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        if (this.f23465d == starRating.f23465d && this.f23466e == starRating.f23466e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.f23465d), Float.valueOf(this.f23466e));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f23448b, 2);
        bundle.putInt(f23462f, this.f23465d);
        bundle.putFloat(f23463g, this.f23466e);
        return bundle;
    }

    public StarRating(int i2, float f2) {
        boolean z2 = true;
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        Assertions.b((f2 < 0.0f || f2 > ((float) i2)) ? false : z2, "starRating is out of range [0, maxStars]");
        this.f23465d = i2;
        this.f23466e = f2;
    }
}
