package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;

public final class ThumbRating extends Rating {

    /* renamed from: f  reason: collision with root package name */
    private static final String f23476f = Util.u0(1);

    /* renamed from: g  reason: collision with root package name */
    private static final String f23477g = Util.u0(2);

    /* renamed from: h  reason: collision with root package name */
    public static final Bundleable.Creator<ThumbRating> f23478h = new e2();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f23479d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f23480e;

    public ThumbRating() {
        this.f23479d = false;
        this.f23480e = false;
    }

    /* access modifiers changed from: private */
    public static ThumbRating d(Bundle bundle) {
        boolean z2;
        if (bundle.getInt(Rating.f23448b, -1) == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (bundle.getBoolean(f23476f, false)) {
            return new ThumbRating(bundle.getBoolean(f23477g, false));
        }
        return new ThumbRating();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        if (this.f23480e == thumbRating.f23480e && this.f23479d == thumbRating.f23479d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Boolean.valueOf(this.f23479d), Boolean.valueOf(this.f23480e));
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.f23448b, 3);
        bundle.putBoolean(f23476f, this.f23479d);
        bundle.putBoolean(f23477g, this.f23480e);
        return bundle;
    }

    public ThumbRating(boolean z2) {
        this.f23479d = true;
        this.f23480e = z2;
    }
}
