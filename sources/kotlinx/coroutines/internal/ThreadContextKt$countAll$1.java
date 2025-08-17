package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

final class ThreadContextKt$countAll$1 extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadContextKt$countAll$1 f40777f = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    /* renamed from: a */
    public final Object invoke(Object obj, CoroutineContext.Element element) {
        Integer num;
        int i2;
        if (!(element instanceof ThreadContextElement)) {
            return obj;
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            return element;
        }
        return Integer.valueOf(i2 + 1);
    }
}
