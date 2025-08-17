package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<CoroutineContext> f40609f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ boolean f40610g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineContextKt$foldCopies$folded$1(Ref$ObjectRef<CoroutineContext> ref$ObjectRef, boolean z2) {
        super(2);
        this.f40609f = ref$ObjectRef;
        this.f40610g = z2;
    }

    /* renamed from: a */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        CoroutineContext.Element element2 = ((CoroutineContext) this.f40609f.f40429b).get(element.getKey());
        if (element2 == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.f40610g) {
                copyableThreadContextElement = copyableThreadContextElement.B();
            }
            return coroutineContext.plus(copyableThreadContextElement);
        }
        Ref$ObjectRef<CoroutineContext> ref$ObjectRef = this.f40609f;
        ref$ObjectRef.f40429b = ((CoroutineContext) ref$ObjectRef.f40429b).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).i(element2));
    }
}
