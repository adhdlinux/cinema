package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ResizedEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f32449a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32450b;

    /* renamed from: c  reason: collision with root package name */
    private final PlayerEventSource f32451c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResizedEvent(int i2, int i3, PlayerEventSource playerEventSource, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, (i4 & 4) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public final int a() {
        return this.f32449a;
    }

    public final int b() {
        return this.f32450b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResizedEvent)) {
            return false;
        }
        ResizedEvent resizedEvent = (ResizedEvent) obj;
        return this.f32449a == resizedEvent.f32449a && this.f32450b == resizedEvent.f32450b && this.f32451c == resizedEvent.f32451c;
    }

    public int hashCode() {
        return (((this.f32449a * 31) + this.f32450b) * 31) + this.f32451c.hashCode();
    }

    public String toString() {
        return "ResizedEvent(height=" + this.f32449a + ", width=" + this.f32450b + ", source=" + this.f32451c + ')';
    }

    public ResizedEvent(int i2, int i3, PlayerEventSource playerEventSource) {
        Intrinsics.f(playerEventSource, "source");
        this.f32449a = i2;
        this.f32450b = i3;
        this.f32451c = playerEventSource;
    }
}
