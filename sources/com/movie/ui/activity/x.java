package com.movie.ui.activity;

import com.movie.data.model.AppConfig;
import com.movie.ui.activity.MemberActivationActivity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemberActivationActivity.AnonymousClass1 f33042b;

    public /* synthetic */ x(MemberActivationActivity.AnonymousClass1 r12) {
        this.f33042b = r12;
    }

    public final void accept(Object obj) {
        this.f33042b.d((AppConfig) obj);
    }
}
