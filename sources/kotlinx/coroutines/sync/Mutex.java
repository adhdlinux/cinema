package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

public interface Mutex {
    Object a(Object obj, Continuation<? super Unit> continuation);

    void b(Object obj);
}
