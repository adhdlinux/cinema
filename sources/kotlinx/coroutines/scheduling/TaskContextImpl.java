package kotlinx.coroutines.scheduling;

final class TaskContextImpl implements TaskContext {

    /* renamed from: a  reason: collision with root package name */
    private final int f40825a;

    public TaskContextImpl(int i2) {
        this.f40825a = i2;
    }

    public void a() {
    }

    public int b() {
        return this.f40825a;
    }
}
