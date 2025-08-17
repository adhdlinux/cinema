package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class AsyncDifferConfig<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f10997a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f10998b;

    /* renamed from: c  reason: collision with root package name */
    private final DiffUtil.ItemCallback<T> f10999c;

    public static final class Builder<T> {

        /* renamed from: d  reason: collision with root package name */
        private static final Object f11000d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private static Executor f11001e;

        /* renamed from: a  reason: collision with root package name */
        private Executor f11002a;

        /* renamed from: b  reason: collision with root package name */
        private Executor f11003b;

        /* renamed from: c  reason: collision with root package name */
        private final DiffUtil.ItemCallback<T> f11004c;

        public Builder(DiffUtil.ItemCallback<T> itemCallback) {
            this.f11004c = itemCallback;
        }

        public AsyncDifferConfig<T> a() {
            if (this.f11003b == null) {
                synchronized (f11000d) {
                    if (f11001e == null) {
                        f11001e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f11003b = f11001e;
            }
            return new AsyncDifferConfig<>(this.f11002a, this.f11003b, this.f11004c);
        }
    }

    AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.f10997a = executor;
        this.f10998b = executor2;
        this.f10999c = itemCallback;
    }

    public Executor a() {
        return this.f10998b;
    }

    public DiffUtil.ItemCallback<T> b() {
        return this.f10999c;
    }

    public Executor c() {
        return this.f10997a;
    }
}
