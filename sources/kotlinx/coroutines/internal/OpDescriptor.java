package kotlinx.coroutines.internal;

import kotlinx.coroutines.DebugStringsKt;

public abstract class OpDescriptor {
    public abstract Object a(Object obj);

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
