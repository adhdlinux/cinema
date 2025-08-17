package com.movie.ui.activity.player;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PlayerActivity$onBackPressed$1 extends Lambda implements Function0<Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ PlayerActivity f32406f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlayerActivity$onBackPressed$1(PlayerActivity playerActivity) {
        super(0);
        this.f32406f = playerActivity;
    }

    public final void invoke() {
        this.f32406f.r1();
        this.f32406f.finish();
    }
}
