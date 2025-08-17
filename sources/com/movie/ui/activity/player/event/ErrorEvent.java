package com.movie.ui.activity.player.event;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ErrorEvent extends PlayerEvent {

    /* renamed from: a  reason: collision with root package name */
    private final Throwable f32421a;

    /* renamed from: b  reason: collision with root package name */
    private final PlayerEventSource f32422b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorEvent(Throwable th, PlayerEventSource playerEventSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i2 & 2) != 0 ? PlayerEventSource.Player : playerEventSource);
    }

    public final Throwable a() {
        return this.f32421a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorEvent)) {
            return false;
        }
        ErrorEvent errorEvent = (ErrorEvent) obj;
        return Intrinsics.a(this.f32421a, errorEvent.f32421a) && this.f32422b == errorEvent.f32422b;
    }

    public int hashCode() {
        return (this.f32421a.hashCode() * 31) + this.f32422b.hashCode();
    }

    public String toString() {
        return "ErrorEvent(error=" + this.f32421a + ", source=" + this.f32422b + ')';
    }

    public ErrorEvent(Throwable th, PlayerEventSource playerEventSource) {
        Intrinsics.f(th, MRAIDPresenter.ERROR);
        Intrinsics.f(playerEventSource, "source");
        this.f32421a = th;
        this.f32422b = playerEventSource;
    }
}
