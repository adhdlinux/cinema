package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView.AudioTrackSelectionAdapter f28285b;

    public /* synthetic */ c(StyledPlayerControlView.AudioTrackSelectionAdapter audioTrackSelectionAdapter) {
        this.f28285b = audioTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.f28285b.m(view);
    }
}
