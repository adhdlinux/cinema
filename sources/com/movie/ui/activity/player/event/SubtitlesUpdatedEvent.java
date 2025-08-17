package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SubtitlesUpdatedEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerEventSource f32455a;

    public SubtitlesUpdatedEvent() {
        this((PlayerEventSource) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubtitlesUpdatedEvent(PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubtitlesUpdatedEvent) && this.f32455a == ((SubtitlesUpdatedEvent) obj).f32455a;
    }

    public int hashCode() {
        return this.f32455a.hashCode();
    }

    public String toString() {
        return "SubtitlesUpdatedEvent(source=" + this.f32455a + ')';
    }

    public SubtitlesUpdatedEvent(PlayerEventSource playerEventSource) {
        Intrinsics.f(playerEventSource, "source");
        this.f32455a = playerEventSource;
    }
}
