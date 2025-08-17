package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.selects.SelectInstance;

final class MutexImpl$onSelectCancellationUnlockConstructor$1 extends Lambda implements Function3<SelectInstance<?>, Object, Object, Function1<? super Throwable, ? extends Unit>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MutexImpl f40850f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$onSelectCancellationUnlockConstructor$1(MutexImpl mutexImpl) {
        super(3);
        this.f40850f = mutexImpl;
    }

    /* renamed from: a */
    public final Function1<Throwable, Unit> invoke(SelectInstance<?> selectInstance, final Object obj, Object obj2) {
        final MutexImpl mutexImpl = this.f40850f;
        return new Function1<Throwable, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f40298a;
            }

            public final void invoke(Throwable th) {
                mutexImpl.b(obj);
            }
        };
    }
}
