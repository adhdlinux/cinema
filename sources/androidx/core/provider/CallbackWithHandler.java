package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;

class CallbackWithHandler {

    /* renamed from: a  reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f2630a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f2631b;

    CallbackWithHandler(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f2630a = fontRequestCallback;
        this.f2631b = handler;
    }

    private void a(final int i2) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f2630a;
        this.f2631b.post(new Runnable() {
            public void run() {
                fontRequestCallback.a(i2);
            }
        });
    }

    private void c(final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f2630a;
        this.f2631b.post(new Runnable() {
            public void run() {
                fontRequestCallback.b(typeface);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f2659a);
        } else {
            a(typefaceResult.f2660b);
        }
    }
}
