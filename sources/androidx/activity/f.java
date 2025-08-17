package androidx.activity;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f53b;

    public /* synthetic */ f(OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f53b = onBackPressedDispatcher;
    }

    public final void run() {
        this.f53b.f();
    }
}
