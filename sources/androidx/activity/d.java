package androidx.activity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentDialog f51b;

    public /* synthetic */ d(ComponentDialog componentDialog) {
        this.f51b = componentDialog;
    }

    public final void run() {
        ComponentDialog.m0onBackPressedDispatcher$lambda1(this.f51b);
    }
}
