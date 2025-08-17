package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public static final Key f40651c = new Key((DefaultConstructorMarker) null);

    public static final class Key extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        private Key() {
            super(CoroutineDispatcher.f40612b, AnonymousClass1.f40652f);
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract Executor r0();
}
