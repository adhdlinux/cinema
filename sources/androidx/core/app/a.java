package androidx.core.app;

import android.app.Activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f2474b;

    public /* synthetic */ a(Activity activity) {
        this.f2474b = activity;
    }

    public final void run() {
        ActivityCompat.d(this.f2474b);
    }
}
