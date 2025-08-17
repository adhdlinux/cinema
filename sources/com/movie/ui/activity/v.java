package com.movie.ui.activity;

import com.movie.data.model.cinema.KeyResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MemberActivationActivity f33039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33040c;

    public /* synthetic */ v(MemberActivationActivity memberActivationActivity, String str) {
        this.f33039b = memberActivationActivity;
        this.f33040c = str;
    }

    public final void accept(Object obj) {
        this.f33039b.K(this.f33040c, (KeyResponse) obj);
    }
}
