package com.utils.installer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.yoku.marumovie.R;
import kotlin.jvm.internal.Intrinsics;

public final class ApkInstaller$installActionReceiver$1 extends BroadcastReceiver {
    ApkInstaller$installActionReceiver$1() {
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.f(context, "context");
        Intrinsics.f(intent, "intent");
        int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 1);
        if (intExtra == -1) {
            Intent intent2 = new Intent("PROGRESS_UPDATE_ACTION");
            intent2.putExtra("EXTRA_PROGRESS", 100);
            intent2.putExtra("EXTRA_INSTALL_STATUS", context.getString(R.string.update_notification_wating_user_action));
            context.sendBroadcast(intent2);
            Intent intent3 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
            if (intent3 != null) {
                intent3.addFlags(268435456);
            }
            context.startActivity(intent3);
        } else if (intExtra != 0) {
            Intent intent4 = new Intent("PROGRESS_UPDATE_ACTION");
            intent4.putExtra("EXTRA_PROGRESS", 100);
            intent4.putExtra("EXTRA_INSTALL_STATUS", context.getString(R.string.update_notification_failed));
            context.sendBroadcast(intent4);
        } else {
            Intent intent5 = new Intent("PROGRESS_UPDATE_ACTION");
            intent5.putExtra("EXTRA_PROGRESS", 100);
            intent5.putExtra("EXTRA_INSTALL_STATUS", context.getString(R.string.update_notification_success));
            context.sendBroadcast(intent5);
        }
    }
}
