package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public abstract class BroadcastReceiverConstraintTracker<T> extends ConstraintTracker<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final String f12430h = Logger.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f12431g = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                BroadcastReceiverConstraintTracker.this.h(context, intent);
            }
        }
    };

    public BroadcastReceiverConstraintTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public void e() {
        Logger.c().a(f12430h, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f12435b.registerReceiver(this.f12431g, g());
    }

    public void f() {
        Logger.c().a(f12430h, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f12435b.unregisterReceiver(this.f12431g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
