package androidx.activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f46b;

    public /* synthetic */ a(ComponentActivity componentActivity) {
        this.f46b = componentActivity;
    }

    public final void run() {
        this.f46b.invalidateMenu();
    }
}
