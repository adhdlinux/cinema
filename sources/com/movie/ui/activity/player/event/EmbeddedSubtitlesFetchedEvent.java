package com.movie.ui.activity.player.event;

import com.movie.ui.activity.player.utils.SubtitleData;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class EmbeddedSubtitlesFetchedEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final List<SubtitleData> f32419a;

    /* renamed from: b  reason: collision with root package name */
    private final PlayerEventSource f32420b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmbeddedSubtitlesFetchedEvent(List list, PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public final List<SubtitleData> a() {
        return this.f32419a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmbeddedSubtitlesFetchedEvent)) {
            return false;
        }
        EmbeddedSubtitlesFetchedEvent embeddedSubtitlesFetchedEvent = (EmbeddedSubtitlesFetchedEvent) obj;
        return Intrinsics.a(this.f32419a, embeddedSubtitlesFetchedEvent.f32419a) && this.f32420b == embeddedSubtitlesFetchedEvent.f32420b;
    }

    public int hashCode() {
        return (this.f32419a.hashCode() * 31) + this.f32420b.hashCode();
    }

    public String toString() {
        return "EmbeddedSubtitlesFetchedEvent(tracks=" + this.f32419a + ", source=" + this.f32420b + ')';
    }

    public EmbeddedSubtitlesFetchedEvent(List<SubtitleData> list, PlayerEventSource playerEventSource) {
        Intrinsics.f(list, "tracks");
        Intrinsics.f(playerEventSource, "source");
        this.f32419a = list;
        this.f32420b = playerEventSource;
    }
}
