package com.movie.ui.activity.player.utils;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

public final class Vector2 {

    /* renamed from: a  reason: collision with root package name */
    private final float f32501a;

    /* renamed from: b  reason: collision with root package name */
    private final float f32502b;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f32503c = LazyKt__LazyJVMKt.b(new Vector2$lengthSquared$2(this));

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f32504d = LazyKt__LazyJVMKt.b(new Vector2$length$2(this));

    public Vector2(float f2, float f3) {
        this.f32501a = f2;
        this.f32502b = f3;
    }

    /* access modifiers changed from: private */
    public final float b() {
        return ((Number) this.f32503c.getValue()).floatValue();
    }

    public final float c() {
        return this.f32501a;
    }

    public final float d() {
        return this.f32502b;
    }

    public final Vector2 e(Vector2 vector2) {
        Intrinsics.f(vector2, "other");
        return new Vector2(this.f32501a - vector2.f32501a, this.f32502b - vector2.f32502b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vector2)) {
            return false;
        }
        Vector2 vector2 = (Vector2) obj;
        return Float.compare(this.f32501a, vector2.f32501a) == 0 && Float.compare(this.f32502b, vector2.f32502b) == 0;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f32501a) * 31) + Float.floatToIntBits(this.f32502b);
    }

    public String toString() {
        return '(' + this.f32501a + ", " + this.f32502b + ')';
    }
}
