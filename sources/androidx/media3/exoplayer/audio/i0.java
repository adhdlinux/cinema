package androidx.media3.exoplayer.audio;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioTrack f5863b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSink.Listener f5864c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Handler f5865d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AudioSink.AudioTrackConfig f5866e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f5867f;

    public /* synthetic */ i0(AudioTrack audioTrack, AudioSink.Listener listener, Handler handler, AudioSink.AudioTrackConfig audioTrackConfig, ConditionVariable conditionVariable) {
        this.f5863b = audioTrack;
        this.f5864c = listener;
        this.f5865d = handler;
        this.f5866e = audioTrackConfig;
        this.f5867f = conditionVariable;
    }

    public final void run() {
        DefaultAudioSink.Z(this.f5863b, this.f5864c, this.f5865d, this.f5866e, this.f5867f);
    }
}
