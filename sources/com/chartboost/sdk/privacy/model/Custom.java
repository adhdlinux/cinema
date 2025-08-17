package com.chartboost.sdk.privacy.model;

import com.chartboost.sdk.impl.a5;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Custom extends GenericDataUseConsent {

    /* renamed from: d  reason: collision with root package name */
    public final String f19187d;

    /* renamed from: e  reason: collision with root package name */
    public final String f19188e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Custom(String str, String str2) {
        super((a5) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.f(str, "customPrivacyStandard");
        Intrinsics.f(str2, "customConsent");
        this.f19187d = str;
        this.f19188e = str2;
        b();
    }

    private final boolean d(String str) {
        int length = str.length();
        return 1 <= length && length < 100;
    }

    public final void b() {
        if (this.f19187d.length() == 0 || this.f19188e.length() == 0) {
            a("Invalid Custom privacy standard name. Values cannot be null");
        } else if (c(this.f19187d)) {
            a("Invalid Custom privacy standard name. Cannot use GDPR as privacy standard");
        } else if (!d(this.f19187d) || !d(this.f19188e)) {
            a("Invalid Custom consent values. Use valid values between 1 and 100 characters. privacyStandard: " + this.f19187d + " consent: " + this.f19188e);
        } else {
            b(this.f19187d);
            a((Object) this.f19188e);
        }
    }

    public final boolean c(String str) {
        String str2;
        String obj;
        if (str == null || (obj = StringsKt__StringsKt.N0(str).toString()) == null) {
            str2 = null;
        } else {
            str2 = obj.toLowerCase(Locale.ROOT);
            Intrinsics.e(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        return Intrinsics.a(GDPR.GDPR_STANDARD, str2);
    }

    public String getConsent() {
        Object a2 = a();
        Intrinsics.d(a2, "null cannot be cast to non-null type kotlin.String");
        return (String) a2;
    }
}
