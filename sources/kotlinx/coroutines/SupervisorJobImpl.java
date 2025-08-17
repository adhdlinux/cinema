package kotlinx.coroutines;

final class SupervisorJobImpl extends JobImpl {
    public SupervisorJobImpl(Job job) {
        super(job);
    }

    public boolean x(Throwable th) {
        return false;
    }
}
