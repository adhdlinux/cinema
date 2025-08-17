package rx.functions;

import java.util.concurrent.Callable;

public final class Actions {

    /* renamed from: a  reason: collision with root package name */
    private static final EmptyAction f42074a = new EmptyAction((AnonymousClass1) null);

    /* renamed from: rx.functions.Actions$1  reason: invalid class name */
    final class AnonymousClass1 implements Callable {
    }

    private static final class EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> implements Action0, Action1<T0> {
        private EmptyAction() {
        }

        public void call() {
        }

        /* synthetic */ EmptyAction(AnonymousClass1 r12) {
            this();
        }
    }

    private Actions() {
        throw new IllegalStateException("No instances!");
    }

    public static final <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> EmptyAction<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9> a() {
        return f42074a;
    }
}
