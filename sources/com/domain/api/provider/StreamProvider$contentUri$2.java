package com.domain.api.provider;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class StreamProvider$contentUri$2 extends Lambda implements Function0<Uri> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ StreamProvider f19366f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StreamProvider$contentUri$2(StreamProvider streamProvider) {
        super(0);
        this.f19366f = streamProvider;
    }

    /* renamed from: b */
    public final Uri invoke() {
        Context context = this.f19366f.getContext();
        if (context != null) {
            return ProviderContract.a(context, this.f19366f.getClass()).a();
        }
        throw new IllegalStateException("getContentUri() should not be called before onCreate()");
    }
}
