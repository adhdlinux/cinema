package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements Function2<Boolean, CoroutineContext.Element, Boolean> {

    /* renamed from: f  reason: collision with root package name */
    public static final CoroutineContextKt$hasCopyableElements$1 f40611f = new CoroutineContextKt$hasCopyableElements$1();

    CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    public final Boolean a(boolean z2, CoroutineContext.Element element) {
        return Boolean.valueOf(z2 || (element instanceof CopyableThreadContextElement));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2);
    }
}
