package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView.TextTrackSelectionAdapter f10183b;

    public /* synthetic */ d(PlayerControlView.TextTrackSelectionAdapter textTrackSelectionAdapter) {
        this.f10183b = textTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.f10183b.l(view);
    }
}
