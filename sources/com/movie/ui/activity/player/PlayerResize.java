package com.movie.ui.activity.player;

import com.yoku.marumovie.R;
import kotlin.enums.EnumEntriesKt;

public enum PlayerResize {
    Fit(R.string.resize_fit),
    Fill(R.string.resize_fill),
    Zoom(R.string.resize_zoom);
    

    /* renamed from: b  reason: collision with root package name */
    private final int f32412b;

    static {
        PlayerResize[] a2;
        f32411g = EnumEntriesKt.a(a2);
    }

    private PlayerResize(int i2) {
        this.f32412b = i2;
    }

    public final int b() {
        return this.f32412b;
    }
}
