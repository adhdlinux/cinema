package androidx.media3.exoplayer.audio;

import android.media.AudioRouting;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

public final /* synthetic */ class y0 implements AudioRouting.OnRoutingChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAudioSink.OnRoutingChangedListenerApi24 f5892a;

    public /* synthetic */ y0(DefaultAudioSink.OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24) {
        this.f5892a = onRoutingChangedListenerApi24;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.f5892a.b(audioRouting);
    }
}
