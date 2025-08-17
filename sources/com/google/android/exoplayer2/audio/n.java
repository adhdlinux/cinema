package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer2.util.ConditionVariable;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioTrack f23925b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f23926c;

    public /* synthetic */ n(AudioTrack audioTrack, ConditionVariable conditionVariable) {
        this.f23925b = audioTrack;
        this.f23926c = conditionVariable;
    }

    public final void run() {
        DefaultAudioSink.Y(this.f23925b, this.f23926c);
    }
}
