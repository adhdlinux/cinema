package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12360a = Logger.f("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    static void a(Context context, List<WorkSpec> list) {
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (WorkSpec workSpec : list) {
            Constraints constraints = workSpec.f12525j;
            z3 |= constraints.f();
            z4 |= constraints.g();
            z5 |= constraints.i();
            if (constraints.b() != NetworkType.NOT_REQUIRED) {
                z2 = true;
            } else {
                z2 = false;
            }
            z6 |= z2;
            if (z3 && z4 && z5 && z6) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.a(context, z3, z4, z5, z6));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.c().a(f12360a, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(CommandHandler.a(context));
    }
}
