package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

public final class DebugStringsKt {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation<?> continuation) {
        Object obj;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        String str = obj;
        if (e2 != null) {
            str = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) str;
    }
}
