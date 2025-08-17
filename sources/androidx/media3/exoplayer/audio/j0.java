package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;

public final /* synthetic */ class j0 implements AudioCapabilitiesReceiver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAudioSink f5870a;

    public /* synthetic */ j0(DefaultAudioSink defaultAudioSink) {
        this.f5870a = defaultAudioSink;
    }

    public final void a(AudioCapabilities audioCapabilities) {
        this.f5870a.d0(audioCapabilities);
    }
}
