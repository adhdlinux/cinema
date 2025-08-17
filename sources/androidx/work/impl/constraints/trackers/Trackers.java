package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class Trackers {

    /* renamed from: e  reason: collision with root package name */
    private static Trackers f12448e;

    /* renamed from: a  reason: collision with root package name */
    private BatteryChargingTracker f12449a;

    /* renamed from: b  reason: collision with root package name */
    private BatteryNotLowTracker f12450b;

    /* renamed from: c  reason: collision with root package name */
    private NetworkStateTracker f12451c;

    /* renamed from: d  reason: collision with root package name */
    private StorageNotLowTracker f12452d;

    private Trackers(Context context, TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.f12449a = new BatteryChargingTracker(applicationContext, taskExecutor);
        this.f12450b = new BatteryNotLowTracker(applicationContext, taskExecutor);
        this.f12451c = new NetworkStateTracker(applicationContext, taskExecutor);
        this.f12452d = new StorageNotLowTracker(applicationContext, taskExecutor);
    }

    public static synchronized Trackers c(Context context, TaskExecutor taskExecutor) {
        Trackers trackers;
        synchronized (Trackers.class) {
            if (f12448e == null) {
                f12448e = new Trackers(context, taskExecutor);
            }
            trackers = f12448e;
        }
        return trackers;
    }

    public BatteryChargingTracker a() {
        return this.f12449a;
    }

    public BatteryNotLowTracker b() {
        return this.f12450b;
    }

    public NetworkStateTracker d() {
        return this.f12451c;
    }

    public StorageNotLowTracker e() {
        return this.f12452d;
    }
}
