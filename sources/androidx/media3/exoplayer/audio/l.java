package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f5875b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5876c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5877d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f5878e;

    public /* synthetic */ l(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.f5875b = eventDispatcher;
        this.f5876c = str;
        this.f5877d = j2;
        this.f5878e = j3;
    }

    public final void run() {
        this.f5875b.z(this.f5876c, this.f5877d, this.f5878e);
    }
}
