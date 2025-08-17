package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

public class DelayedWorkTracker {

    /* renamed from: d  reason: collision with root package name */
    static final String f12340d = Logger.f("DelayedWorkTracker");

    /* renamed from: a  reason: collision with root package name */
    final GreedyScheduler f12341a;

    /* renamed from: b  reason: collision with root package name */
    private final RunnableScheduler f12342b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Runnable> f12343c = new HashMap();

    public DelayedWorkTracker(GreedyScheduler greedyScheduler, RunnableScheduler runnableScheduler) {
        this.f12341a = greedyScheduler;
        this.f12342b = runnableScheduler;
    }

    public void a(final WorkSpec workSpec) {
        Runnable remove = this.f12343c.remove(workSpec.f12516a);
        if (remove != null) {
            this.f12342b.a(remove);
        }
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                Logger.c().a(DelayedWorkTracker.f12340d, String.format("Scheduling work %s", new Object[]{workSpec.f12516a}), new Throwable[0]);
                DelayedWorkTracker.this.f12341a.c(workSpec);
            }
        };
        this.f12343c.put(workSpec.f12516a, r02);
        long currentTimeMillis = System.currentTimeMillis();
        this.f12342b.b(workSpec.a() - currentTimeMillis, r02);
    }

    public void b(String str) {
        Runnable remove = this.f12343c.remove(str);
        if (remove != null) {
            this.f12342b.a(remove);
        }
    }
}
