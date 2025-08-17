package kotlinx.coroutines.scheduling;

public final class NanoTimeSource extends SchedulerTimeSource {

    /* renamed from: a  reason: collision with root package name */
    public static final NanoTimeSource f40817a = new NanoTimeSource();

    private NanoTimeSource() {
    }

    public long a() {
        return System.nanoTime();
    }
}
