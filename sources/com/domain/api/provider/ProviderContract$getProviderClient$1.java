package com.domain.api.provider;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

public final class ProviderContract$getProviderClient$1 implements ProviderClient {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f19354b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Context f19355c;

    ProviderContract$getProviderClient$1(Uri uri, Context context) {
        this.f19354b = uri;
        this.f19355c = context;
    }

    public Uri a() {
        Uri uri = this.f19354b;
        Intrinsics.e(uri, "contentUri");
        return uri;
    }

    public Uri b(ContentValues contentValues) {
        Intrinsics.f(contentValues, "values");
        return this.f19355c.getContentResolver().insert(this.f19354b, contentValues);
    }
}
