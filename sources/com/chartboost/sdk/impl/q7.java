package com.chartboost.sdk.impl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class q7 {

    /* renamed from: a  reason: collision with root package name */
    public final PackageManager f18430a;

    /* renamed from: b  reason: collision with root package name */
    public final Function0 f18431b;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f18432b = new a();

        public a() {
            super(0);
        }

        /* renamed from: a */
        public final Intent invoke() {
            return new Intent("android.intent.action.VIEW");
        }
    }

    public q7(PackageManager packageManager, Function0 function0) {
        Intrinsics.f(packageManager, "packageManager");
        Intrinsics.f(function0, "intentFactory");
        this.f18430a = packageManager;
        this.f18431b = function0;
    }

    public final List a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageManager.ResolveInfoFlags of = PackageManager.ResolveInfoFlags.of(65536);
            Intrinsics.e(of, "of(PackageManager.MATCH_DEFAULT_ONLY.toLong())");
            return a(intent, of);
        }
        List<ResolveInfo> queryIntentActivities = this.f18430a.queryIntentActivities(intent, 65536);
        Intrinsics.e(queryIntentActivities, "{\n            packageMan…H_DEFAULT_ONLY)\n        }");
        return queryIntentActivities;
    }

    public final boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            return !a(a(str)).isEmpty();
        } catch (Exception e2) {
            String a2 = r7.f18514a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "Cannot open URL", e2);
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q7(PackageManager packageManager, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(packageManager, (i2 & 2) != 0 ? a.f18432b : function0);
    }

    public final List a(Intent intent, PackageManager.ResolveInfoFlags resolveInfoFlags) {
        List queryIntentActivities = this.f18430a.queryIntentActivities(intent, resolveInfoFlags);
        Intrinsics.e(queryIntentActivities, "packageManager.queryInte…Activities(intent, flags)");
        return queryIntentActivities;
    }

    public final Intent a(String str) {
        Intent intent = (Intent) this.f18431b.invoke();
        intent.addFlags(268435456);
        intent.setData(Uri.parse(str));
        return intent;
    }
}
