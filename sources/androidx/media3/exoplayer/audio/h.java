package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f5859c;

    public /* synthetic */ h(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f5858b = eventDispatcher;
        this.f5859c = audioTrackConfig;
    }

    public final void run() {
        this.f5858b.x(this.f5859c);
    }
}
