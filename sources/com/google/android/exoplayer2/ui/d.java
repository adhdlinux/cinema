package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView.PlaybackSpeedAdapter f28286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f28287c;

    public /* synthetic */ d(StyledPlayerControlView.PlaybackSpeedAdapter playbackSpeedAdapter, int i2) {
        this.f28286b = playbackSpeedAdapter;
        this.f28287c = i2;
    }

    public final void onClick(View view) {
        this.f28286b.e(this.f28287c, view);
    }
}
