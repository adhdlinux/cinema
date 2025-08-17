package com.domain.api.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

public final class ProviderContract {

    /* renamed from: a  reason: collision with root package name */
    public static final ProviderContract f19353a = new ProviderContract();

    private ProviderContract() {
    }

    public static final ProviderClient a(Context context, Class<? extends StreamProvider> cls) {
        Intrinsics.f(context, "context");
        Intrinsics.f(cls, "provider");
        ComponentName componentName = new ComponentName(context, cls);
        try {
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(componentName, 0);
            Intrinsics.e(providerInfo, "pm.getProviderInfo(componentName, 0)");
            String str = providerInfo.authority;
            Intrinsics.e(str, "info.authority");
            return b(context, str);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Invalid MuzeiArtProvider: " + componentName + ", is your provider disabled?", e2);
        }
    }

    public static final ProviderClient b(Context context, String str) {
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "authority");
        return new ProviderContract$getProviderClient$1(new Uri.Builder().scheme("content").authority(str).build(), context);
    }
}
