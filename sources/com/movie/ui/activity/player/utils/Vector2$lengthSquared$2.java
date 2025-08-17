package com.movie.ui.activity.player.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Vector2$lengthSquared$2 extends Lambda implements Function0<Float> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Vector2 f32506f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Vector2$lengthSquared$2(Vector2 vector2) {
        super(0);
        this.f32506f = vector2;
    }

    /* renamed from: b */
    public final Float invoke() {
        return Float.valueOf((this.f32506f.c() * this.f32506f.c()) + (this.f32506f.d() * this.f32506f.d()));
    }
}
