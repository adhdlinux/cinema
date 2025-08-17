package com.movie.ui.activity.settings.subfragment;

import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class c0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PremiumAccountFragment.AnonymousClass15 f32642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f32643c;

    public /* synthetic */ c0(PremiumAccountFragment.AnonymousClass15 r12, String str) {
        this.f32642b = r12;
        this.f32643c = str;
    }

    public final void accept(Object obj) {
        this.f32642b.c(this.f32643c, (Boolean) obj);
    }
}
