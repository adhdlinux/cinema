package kotlinx.coroutines;

public final class NonDisposableHandle implements DisposableHandle, ChildHandle {

    /* renamed from: b  reason: collision with root package name */
    public static final NonDisposableHandle f40684b = new NonDisposableHandle();

    private NonDisposableHandle() {
    }

    public boolean b(Throwable th) {
        return false;
    }

    public void dispose() {
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
