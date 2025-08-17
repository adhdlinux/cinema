package kotlinx.coroutines;

public interface ChildHandle extends DisposableHandle {
    boolean b(Throwable th);
}
