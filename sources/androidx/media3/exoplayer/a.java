package androidx.media3.exoplayer;

import androidx.media3.exoplayer.AudioFocusManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioFocusManager.AudioFocusListener f5539b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5540c;

    public /* synthetic */ a(AudioFocusManager.AudioFocusListener audioFocusListener, int i2) {
        this.f5539b = audioFocusListener;
        this.f5540c = i2;
    }

    public final void run() {
        this.f5539b.b(this.f5540c);
    }
}
