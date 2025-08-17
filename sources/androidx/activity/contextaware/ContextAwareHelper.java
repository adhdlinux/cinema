package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ContextAwareHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Set<OnContextAvailableListener> f49a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f50b;

    public void a(OnContextAvailableListener onContextAvailableListener) {
        if (this.f50b != null) {
            onContextAvailableListener.a(this.f50b);
        }
        this.f49a.add(onContextAvailableListener);
    }

    public void b() {
        this.f50b = null;
    }

    public void c(Context context) {
        this.f50b = context;
        for (OnContextAvailableListener a2 : this.f49a) {
            a2.a(context);
        }
    }

    public Context d() {
        return this.f50b;
    }

    public void e(OnContextAvailableListener onContextAvailableListener) {
        this.f49a.remove(onContextAvailableListener);
    }
}
