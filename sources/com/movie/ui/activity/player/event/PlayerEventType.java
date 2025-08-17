package com.movie.ui.activity.player.event;

import kotlin.enums.EnumEntriesKt;

public enum PlayerEventType {
    Pause(0),
    Play(1),
    SeekForward(2),
    SeekBack(3),
    PlayPauseToggle(4),
    ToggleMute(5),
    Lock(6),
    ToggleHide(7),
    ShowSpeed(8),
    ShowSources(9),
    Resize(10),
    SearchSubtitlesOnline(14);
    

    /* renamed from: b  reason: collision with root package name */
    private final int f32447b;

    static {
        PlayerEventType[] a2;
        f32446p = EnumEntriesKt.a(a2);
    }

    private PlayerEventType(int i2) {
        this.f32447b = i2;
    }
}
