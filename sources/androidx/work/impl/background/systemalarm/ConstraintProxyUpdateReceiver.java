package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    static final String f12361a = Logger.f("ConstrntProxyUpdtRecvr");

    public static Intent a(Context context, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z2).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z5);
        return intent;
    }

    public void onReceive(final Context context, final Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            Logger.c().a(f12361a, String.format("Ignoring unknown action %s", new Object[]{str}), new Throwable[0]);
            return;
        }
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        WorkManagerImpl.k(context).p().b(new Runnable() {
            public void run() {
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    Logger.c().a(ConstraintProxyUpdateReceiver.f12361a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                    PackageManagerHelper.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                    PackageManagerHelper.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                    PackageManagerHelper.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                    PackageManagerHelper.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                } finally {
                    goAsync.finish();
                }
            }
        });
    }
}
