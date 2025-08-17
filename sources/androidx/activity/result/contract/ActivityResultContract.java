package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f87a;

        public SynchronousResult(T t2) {
            this.f87a = t2;
        }

        public final T a() {
            return this.f87a;
        }
    }

    public abstract Intent a(Context context, I i2);

    public SynchronousResult<O> b(Context context, I i2) {
        Intrinsics.f(context, "context");
        return null;
    }

    public abstract O c(int i2, Intent intent);
}
