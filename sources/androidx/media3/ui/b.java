package androidx.media3.ui;

import android.view.View;
import androidx.media3.ui.PlayerControlView;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlayerControlView.PlaybackSpeedAdapter f10180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f10181c;

    public /* synthetic */ b(PlayerControlView.PlaybackSpeedAdapter playbackSpeedAdapter, int i2) {
        this.f10180b = playbackSpeedAdapter;
        this.f10181c = i2;
    }

    public final void onClick(View view) {
        this.f10180b.e(this.f10181c, view);
    }
}
