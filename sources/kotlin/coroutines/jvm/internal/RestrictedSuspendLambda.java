package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements FunctionBase<Object> {

    /* renamed from: i  reason: collision with root package name */
    private final int f40377i;

    public RestrictedSuspendLambda(int i2, Continuation<Object> continuation) {
        super(continuation);
        this.f40377i = i2;
    }

    public int getArity() {
        return this.f40377i;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f2 = Reflection.f(this);
        Intrinsics.e(f2, "renderLambdaToString(this)");
        return f2;
    }
}
