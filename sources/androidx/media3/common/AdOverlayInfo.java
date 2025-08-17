package androidx.media3.common;

import android.view.View;

public final class AdOverlayInfo {

    /* renamed from: a  reason: collision with root package name */
    public final View f3873a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3874b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3875c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final View f3876a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3877b;

        /* renamed from: c  reason: collision with root package name */
        private String f3878c;

        public Builder(View view, int i2) {
            this.f3876a = view;
            this.f3877b = i2;
        }

        public AdOverlayInfo a() {
            return new AdOverlayInfo(this.f3876a, this.f3877b, this.f3878c);
        }

        public Builder b(String str) {
            this.f3878c = str;
            return this;
        }
    }

    @Deprecated
    public AdOverlayInfo(View view, int i2, String str) {
        this.f3873a = view;
        this.f3874b = i2;
        this.f3875c = str;
    }
}
