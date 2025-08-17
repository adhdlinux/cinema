package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public interface Job extends CoroutineContext.Element {
    public static final Key E0 = Key.f40660b;

    public static final class DefaultImpls {
        public static /* synthetic */ void a(Job job, CancellationException cancellationException, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    cancellationException = null;
                }
                job.L(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R b(Job job, R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.a(job, r2, function2);
        }

        public static <E extends CoroutineContext.Element> E c(Job job, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.b(job, key);
        }

        public static /* synthetic */ DisposableHandle d(Job job, boolean z2, boolean z3, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z2 = false;
                }
                if ((i2 & 2) != 0) {
                    z3 = true;
                }
                return job.q(z2, z3, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static CoroutineContext e(Job job, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(job, key);
        }

        public static CoroutineContext f(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(job, coroutineContext);
        }
    }

    public static final class Key implements CoroutineContext.Key<Job> {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ Key f40660b = new Key();

        private Key() {
        }
    }

    void L(CancellationException cancellationException);

    boolean isActive();

    ChildHandle m0(ChildJob childJob);

    DisposableHandle q(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1);

    CancellationException s();

    boolean start();

    DisposableHandle z(Function1<? super Throwable, Unit> function1);
}
