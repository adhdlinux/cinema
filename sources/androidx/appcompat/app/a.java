package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f570b;

    public /* synthetic */ a(Context context) {
        this.f570b = context;
    }

    public final void run() {
        AppCompatDelegate.w(this.f570b);
    }
}
