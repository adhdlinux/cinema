package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;

public class TestScheduler extends Scheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<TimedAction> f42141a = new PriorityQueue(11, new CompareActionsByTime());

    /* renamed from: b  reason: collision with root package name */
    private long f42142b;

    private static class CompareActionsByTime implements Comparator<TimedAction> {
        private CompareActionsByTime() {
        }

        /* renamed from: a */
        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            if (timedAction.f42145a == timedAction2.f42145a) {
                return Long.valueOf(timedAction.f42148d).compareTo(Long.valueOf(timedAction2.f42148d));
            }
            return Long.valueOf(timedAction.f42145a).compareTo(Long.valueOf(timedAction2.f42145a));
        }
    }

    private final class InnerTestScheduler extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        private final BooleanSubscription f42143b;

        private InnerTestScheduler() {
            this.f42143b = new BooleanSubscription();
        }

        public boolean isUnsubscribed() {
            return this.f42143b.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f42143b.unsubscribe();
        }
    }

    private static final class TimedAction {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final long f42145a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Action0 f42146b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler.Worker f42147c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f42148d;

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", new Object[]{Long.valueOf(this.f42145a), this.f42146b.toString()});
        }
    }

    private void a(long j2) {
        long j3;
        while (!this.f42141a.isEmpty()) {
            TimedAction peek = this.f42141a.peek();
            if (peek.f42145a > j2) {
                break;
            }
            if (peek.f42145a == 0) {
                j3 = this.f42142b;
            } else {
                j3 = peek.f42145a;
            }
            this.f42142b = j3;
            this.f42141a.remove();
            if (!peek.f42147c.isUnsubscribed()) {
                peek.f42146b.call();
            }
        }
        this.f42142b = j2;
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        advanceTimeTo(this.f42142b + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        a(timeUnit.toNanos(j2));
    }

    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.f42142b);
    }

    public void triggerActions() {
        a(this.f42142b);
    }
}
