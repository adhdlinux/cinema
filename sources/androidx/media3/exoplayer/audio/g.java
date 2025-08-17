package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5856b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f5857c;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f5856b = eventDispatcher;
        this.f5857c = audioTrackConfig;
    }

    public final void run() {
        this.f5856b.y(this.f5857c);
    }
}
