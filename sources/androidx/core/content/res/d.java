package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f2538b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f2539c;

    public /* synthetic */ d(ResourcesCompat.FontCallback fontCallback, int i2) {
        this.f2538b = fontCallback;
        this.f2539c = i2;
    }

    public final void run() {
        this.f2538b.f(this.f2539c);
    }
}
