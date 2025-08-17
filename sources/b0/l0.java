package b0;

import android.media.MediaPlayer;
import com.chartboost.sdk.impl.q0;

public final /* synthetic */ class l0 implements MediaPlayer.OnCompletionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q0 f12743b;

    public /* synthetic */ l0(q0 q0Var) {
        this.f12743b = q0Var;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        q0.a(this.f12743b, mediaPlayer);
    }
}
