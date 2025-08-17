package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class TracksChangedEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerEventSource f32456a;

    public TracksChangedEvent() {
        this((PlayerEventSource) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TracksChangedEvent(PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TracksChangedEvent) && this.f32456a == ((TracksChangedEvent) obj).f32456a;
    }

    public int hashCode() {
        return this.f32456a.hashCode();
    }

    public String toString() {
        return "TracksChangedEvent(source=" + this.f32456a + ')';
    }

    public TracksChangedEvent(PlayerEventSource playerEventSource) {
        Intrinsics.f(playerEventSource, "source");
        this.f32456a = playerEventSource;
    }
}
