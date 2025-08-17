package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView.TrackSelectionAdapter f28290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player f28291c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TrackGroup f28292d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView.TrackInformation f28293e;

    public /* synthetic */ g(StyledPlayerControlView.TrackSelectionAdapter trackSelectionAdapter, Player player, TrackGroup trackGroup, StyledPlayerControlView.TrackInformation trackInformation) {
        this.f28290b = trackSelectionAdapter;
        this.f28291c = player;
        this.f28292d = trackGroup;
        this.f28293e = trackInformation;
    }

    public final void onClick(View view) {
        this.f28290b.e(this.f28291c, this.f28292d, this.f28293e, view);
    }
}
