package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f2536b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f2537c;

    public /* synthetic */ c(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f2536b = fontCallback;
        this.f2537c = typeface;
    }

    public final void run() {
        this.f2536b.g(this.f2537c);
    }
}
