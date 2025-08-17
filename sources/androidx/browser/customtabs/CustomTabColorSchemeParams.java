package androidx.browser.customtabs;

import android.os.Bundle;

public final class CustomTabColorSchemeParams {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f1585a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f1586b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f1587c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f1588d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f1589a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f1590b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f1591c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f1592d;

        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f1589a, this.f1590b, this.f1591c, this.f1592d);
        }
    }

    CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f1585a = num;
        this.f1586b = num2;
        this.f1587c = num3;
        this.f1588d = num4;
    }

    /* access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1585a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1586b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1587c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f1588d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
