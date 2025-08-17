package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView.AudioTrackSelectionAdapter f10179b;

    public /* synthetic */ a(PlayerControlView.AudioTrackSelectionAdapter audioTrackSelectionAdapter) {
        this.f10179b = audioTrackSelectionAdapter;
    }

    public final void onClick(View view) {
        this.f10179b.m(view);
    }
}
