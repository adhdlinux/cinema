package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class AbstractCollection$toString$1 extends Lambda implements Function1<E, CharSequence> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ AbstractCollection<E> f40301f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractCollection$toString$1(AbstractCollection<? extends E> abstractCollection) {
        super(1);
        this.f40301f = abstractCollection;
    }

    /* renamed from: a */
    public final CharSequence invoke(E e2) {
        return e2 == this.f40301f ? "(this Collection)" : String.valueOf(e2);
    }
}
