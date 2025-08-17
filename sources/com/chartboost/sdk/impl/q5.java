package com.chartboost.sdk.impl;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Format;
import kotlin.jvm.internal.Intrinsics;

public abstract class q5 {
    public static final int a(ExoPlayer exoPlayer) {
        Intrinsics.f(exoPlayer, "<this>");
        Format a2 = exoPlayer.a();
        if (a2 != null) {
            return a2.f23077s;
        }
        return 1;
    }

    public static final int b(ExoPlayer exoPlayer) {
        Intrinsics.f(exoPlayer, "<this>");
        Format a2 = exoPlayer.a();
        if (a2 != null) {
            return a2.f23076r;
        }
        return 1;
    }
}
