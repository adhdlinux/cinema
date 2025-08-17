package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ContextScope;

public final class CoroutineScopeKt {
    public static final CoroutineScope a(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.E0) == null) {
            coroutineContext = coroutineContext.plus(JobKt__JobKt.b((Job) null, 1, (Object) null));
        }
        return new ContextScope(coroutineContext);
    }

    public static final boolean b(CoroutineScope coroutineScope) {
        Job job = (Job) coroutineScope.c().get(Job.E0);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }
}
