package androidx.media3.ui;

import android.view.View;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.ui.PlayerControlView;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView.TrackSelectionAdapter f10184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player f10185c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TrackGroup f10186d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView.TrackInformation f10187e;

    public /* synthetic */ e(PlayerControlView.TrackSelectionAdapter trackSelectionAdapter, Player player, TrackGroup trackGroup, PlayerControlView.TrackInformation trackInformation) {
        this.f10184b = trackSelectionAdapter;
        this.f10185c = player;
        this.f10186d = trackGroup;
        this.f10187e = trackInformation;
    }

    public final void onClick(View view) {
        this.f10184b.e(this.f10185c, this.f10186d, this.f10187e, view);
    }
}
