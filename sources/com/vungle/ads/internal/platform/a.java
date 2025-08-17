package com.vungle.ads.internal.platform;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class a implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidPlatform f37902a;

    public /* synthetic */ a(AndroidPlatform androidPlatform) {
        this.f37902a = androidPlatform;
    }

    public final void onSuccess(Object obj) {
        AndroidPlatform.m196updateAppSetID$lambda2(this.f37902a, (AppSetIdInfo) obj);
    }
}
