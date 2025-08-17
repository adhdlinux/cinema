package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;

public interface LoadControl {
    void a();

    Allocator b();

    boolean c();

    long d();

    void e(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    boolean f(long j2, float f2, boolean z2, long j3);

    void g();

    void h();

    boolean i(long j2, long j3, float f2);
}
