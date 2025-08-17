package androidx.activity;

import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<Cancellable> f31b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private Consumer<Boolean> f32c;

    public OnBackPressedCallback(boolean z2) {
        this.f30a = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(Cancellable cancellable) {
        this.f31b.add(cancellable);
    }

    public abstract void b();

    public final boolean c() {
        return this.f30a;
    }

    public final void d() {
        Iterator<Cancellable> it2 = this.f31b.iterator();
        while (it2.hasNext()) {
            it2.next().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void e(Cancellable cancellable) {
        this.f31b.remove(cancellable);
    }

    public final void f(boolean z2) {
        this.f30a = z2;
        Consumer<Boolean> consumer = this.f32c;
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z2));
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Consumer<Boolean> consumer) {
        this.f32c = consumer;
    }
}
