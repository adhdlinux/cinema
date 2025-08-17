package com.chartboost.sdk.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import kotlin.jvm.internal.Intrinsics;

public final class w0 extends v0 {

    /* renamed from: b  reason: collision with root package name */
    public final ContentResolver f18883b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w0(Context context, ContentResolver contentResolver) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(contentResolver, "contentResolver");
        this.f18883b = contentResolver;
    }

    public u0 b() {
        boolean z2;
        yb ybVar = yb.TRACKING_UNKNOWN;
        String str = null;
        try {
            if (Settings.Secure.getInt(this.f18883b, "limit_ad_tracking") != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            String string = Settings.Secure.getString(this.f18883b, "advertising_id");
            if (!z2 && !Intrinsics.a(string, "00000000-0000-0000-0000-000000000000")) {
                if (!a()) {
                    ybVar = yb.TRACKING_ENABLED;
                    str = string;
                    return new u0(ybVar, str);
                }
            }
            ybVar = yb.TRACKING_LIMITED;
        } catch (Settings.SettingNotFoundException unused) {
        }
        return new u0(ybVar, str);
    }
}
