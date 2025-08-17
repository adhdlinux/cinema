package androidx.mediarouter.media;

import android.os.Build;
import android.os.Bundle;

public class MediaRouterParams {

    /* renamed from: a  reason: collision with root package name */
    final int f10649a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f10650b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f10651c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f10652d;

    /* renamed from: e  reason: collision with root package name */
    final Bundle f10653e;

    MediaRouterParams(Builder builder) {
        Bundle bundle;
        this.f10649a = builder.f10654a;
        this.f10650b = builder.f10655b;
        this.f10651c = builder.f10656c;
        this.f10652d = builder.f10657d;
        Bundle bundle2 = builder.f10658e;
        if (bundle2 == null) {
            bundle = Bundle.EMPTY;
        } else {
            bundle = new Bundle(bundle2);
        }
        this.f10653e = bundle;
    }

    public int a() {
        return this.f10649a;
    }

    public Bundle b() {
        return this.f10653e;
    }

    public boolean c() {
        return this.f10650b;
    }

    public boolean d() {
        return this.f10651c;
    }

    public boolean e() {
        return this.f10652d;
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        int f10654a = 1;

        /* renamed from: b  reason: collision with root package name */
        boolean f10655b;

        /* renamed from: c  reason: collision with root package name */
        boolean f10656c;

        /* renamed from: d  reason: collision with root package name */
        boolean f10657d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f10658e;

        public Builder() {
            boolean z2 = true;
            this.f10655b = Build.VERSION.SDK_INT < 30 ? false : z2;
        }

        public MediaRouterParams a() {
            return new MediaRouterParams(this);
        }

        public Builder b(int i2) {
            this.f10654a = i2;
            return this;
        }

        public Builder c(boolean z2) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f10655b = z2;
            }
            return this;
        }

        public Builder d(boolean z2) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f10656c = z2;
            }
            return this;
        }

        public Builder e(boolean z2) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f10657d = z2;
            }
            return this;
        }

        public Builder(MediaRouterParams mediaRouterParams) {
            boolean z2 = true;
            this.f10655b = Build.VERSION.SDK_INT < 30 ? false : z2;
            if (mediaRouterParams != null) {
                this.f10654a = mediaRouterParams.f10649a;
                this.f10656c = mediaRouterParams.f10651c;
                this.f10657d = mediaRouterParams.f10652d;
                this.f10655b = mediaRouterParams.f10650b;
                this.f10658e = mediaRouterParams.f10653e == null ? null : new Bundle(mediaRouterParams.f10653e);
                return;
            }
            throw new NullPointerException("params should not be null!");
        }
    }
}
