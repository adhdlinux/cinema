package com.movie.ui.activity.player.event;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class RequestAudioFocusEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerEventSource f32448a;

    public RequestAudioFocusEvent() {
        this((PlayerEventSource) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestAudioFocusEvent(PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RequestAudioFocusEvent) && this.f32448a == ((RequestAudioFocusEvent) obj).f32448a;
    }

    public int hashCode() {
        return this.f32448a.hashCode();
    }

    public String toString() {
        return "RequestAudioFocusEvent(source=" + this.f32448a + ')';
    }

    public RequestAudioFocusEvent(PlayerEventSource playerEventSource) {
        Intrinsics.f(playerEventSource, "source");
        this.f32448a = playerEventSource;
    }
}
