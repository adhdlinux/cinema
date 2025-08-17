package androidx.media3.exoplayer;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal f6281b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerMessage f6282c;

    public /* synthetic */ h0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.f6281b = exoPlayerImplInternal;
        this.f6282c = playerMessage;
    }

    public final void run() {
        this.f6281b.b0(this.f6282c);
    }
}
