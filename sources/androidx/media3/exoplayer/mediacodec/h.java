package androidx.media3.exoplayer.mediacodec;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecCallback f6759b;

    public /* synthetic */ h(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback) {
        this.f6759b = asynchronousMediaCodecCallback;
    }

    public final void run() {
        this.f6759b.n();
    }
}
