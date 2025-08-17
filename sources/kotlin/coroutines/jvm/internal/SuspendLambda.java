package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

public abstract class SuspendLambda extends ContinuationImpl implements FunctionBase<Object> {
    private final int arity;

    public SuspendLambda(int i2, Continuation<Object> continuation) {
        super(continuation);
        this.arity = i2;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f2 = Reflection.f(this);
        Intrinsics.e(f2, "renderLambdaToString(this)");
        return f2;
    }

    public SuspendLambda(int i2) {
        this(i2, (Continuation<Object>) null);
    }
}
