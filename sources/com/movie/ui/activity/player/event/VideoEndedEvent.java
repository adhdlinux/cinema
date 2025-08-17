package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VideoEndedEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerEventSource f32457a;

    public VideoEndedEvent() {
        this((PlayerEventSource) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoEndedEvent(PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VideoEndedEvent) && this.f32457a == ((VideoEndedEvent) obj).f32457a;
    }

    public int hashCode() {
        return this.f32457a.hashCode();
    }

    public String toString() {
        return "VideoEndedEvent(source=" + this.f32457a + ')';
    }

    public VideoEndedEvent(PlayerEventSource playerEventSource) {
        Intrinsics.f(playerEventSource, "source");
        this.f32457a = playerEventSource;
    }
}
