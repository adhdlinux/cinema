package com.vungle.ads.internal;

import android.content.Context;
import kotlin.Lazy;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f37842b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37843c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ VungleInitializer f37844d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Lazy f37845e;

    public /* synthetic */ b(Context context, String str, VungleInitializer vungleInitializer, Lazy lazy) {
        this.f37842b = context;
        this.f37843c = str;
        this.f37844d = vungleInitializer;
        this.f37845e = lazy;
    }

    public final void run() {
        VungleInitializer.m160init$lambda2(this.f37842b, this.f37843c, this.f37844d, this.f37845e);
    }
}
