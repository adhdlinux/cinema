package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;

public final class HeartRating extends Rating {

    /* renamed from: f  reason: collision with root package name */
    private static final String f23113f = Util.u0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f23114g = Util.u0(2);

    /* renamed from: h  reason: collision with root package name */
    public static final Bundleable.Creator<HeartRating> f23115h = new z0();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23116d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f23117e;

    public HeartRating() {
        this.f23116d = false;
        this.f23117e = false;
    }

    /* access modifiers changed from: private */
    public static HeartRating d(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(Rating.f23448b, -1) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (bundle.getBoolean(f23113f, false)) {
            return new HeartRating(bundle.getBoolean(f23114g, false));
        }
        return new HeartRating();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        if (this.f23117e == heartRating.f23117e && this.f23116d == heartRating.f23116d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Boolean.valueOf(this.f23116d), Boolean.valueOf(this.f23117e));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f23448b, 0);
        bundle.putBoolean(f23113f, this.f23116d);
        bundle.putBoolean(f23114g, this.f23117e);
        return bundle;
    }

    public HeartRating(boolean z2) {
        this.f23116d = true;
        this.f23117e = z2;
    }
}
