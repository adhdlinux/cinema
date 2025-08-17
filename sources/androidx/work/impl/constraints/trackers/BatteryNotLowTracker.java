package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.applovin.sdk.AppLovinEventTypes;

public class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f12429i = Logger.f("BatteryNotLowTracker");

    public BatteryNotLowTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public void h(Context context, Intent intent) {
        if (intent.getAction() != null) {
            Logger.c().a(f12429i, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                d(Boolean.TRUE);
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                d(Boolean.FALSE);
            }
        }
    }

    /* renamed from: i */
    public Boolean b() {
        Intent registerReceiver = this.f12435b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z2 = false;
        if (registerReceiver == null) {
            Logger.c().b(f12429i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }
}
