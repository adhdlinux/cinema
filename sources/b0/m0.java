package b0;

import android.media.MediaPlayer;
import com.chartboost.sdk.impl.q0;

public final /* synthetic */ class m0 implements MediaPlayer.OnErrorListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q0 f12747b;

    public /* synthetic */ m0(q0 q0Var) {
        this.f12747b = q0Var;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return q0.b(this.f12747b, mediaPlayer, i2, i3);
    }
}
