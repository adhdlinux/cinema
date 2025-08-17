package com.movie.ui.activity;

import com.movie.data.model.AppConfig;
import com.movie.ui.activity.MemberActivationActivity;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemberActivationActivity.AnonymousClass4 f32186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f32187c;

    public /* synthetic */ a0(MemberActivationActivity.AnonymousClass4 r12, String str) {
        this.f32186b = r12;
        this.f32187c = str;
    }

    public final void accept(Object obj) {
        this.f32186b.d(this.f32187c, (AppConfig) obj);
    }
}
