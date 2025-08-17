package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSink.Listener f5873b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f5874c;

    public /* synthetic */ k0(AudioSink.Listener listener, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.f5873b = listener;
        this.f5874c = audioTrackConfig;
    }

    public final void run() {
        this.f5873b.o(this.f5874c);
    }
}
