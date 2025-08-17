package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class StatusEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Loading f32452a;

    /* renamed from: b  reason: collision with root package name */
    private final Loading f32453b;

    /* renamed from: c  reason: collision with root package name */
    private final PlayerEventSource f32454c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StatusEvent(Loading loading, Loading loading2, PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(loading, loading2, (i2 & 4) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusEvent)) {
            return false;
        }
        StatusEvent statusEvent = (StatusEvent) obj;
        return this.f32452a == statusEvent.f32452a && this.f32453b == statusEvent.f32453b && this.f32454c == statusEvent.f32454c;
    }

    public int hashCode() {
        return (((this.f32452a.hashCode() * 31) + this.f32453b.hashCode()) * 31) + this.f32454c.hashCode();
    }

    public String toString() {
        return "StatusEvent(wasPlaying=" + this.f32452a + ", isPlaying=" + this.f32453b + ", source=" + this.f32454c + ')';
    }

    public StatusEvent(Loading loading, Loading loading2, PlayerEventSource playerEventSource) {
        Intrinsics.f(loading, "wasPlaying");
        Intrinsics.f(loading2, "isPlaying");
        Intrinsics.f(playerEventSource, "source");
        this.f32452a = loading;
        this.f32453b = loading2;
        this.f32454c = playerEventSource;
    }
}
