package com.movie.ui.activity.settings.subfragment;

import com.movie.ui.activity.settings.subfragment.SubtitleFragment;
import com.utils.subtitle.services.openSubtitle.models.LoginResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class f0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleFragment.AnonymousClass3.AnonymousClass1 f32648b;

    public /* synthetic */ f0(SubtitleFragment.AnonymousClass3.AnonymousClass1 r12) {
        this.f32648b = r12;
    }

    public final void accept(Object obj) {
        this.f32648b.c((LoginResponse) obj);
    }
}
