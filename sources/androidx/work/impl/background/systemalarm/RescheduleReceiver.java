package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12381a = Logger.f("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        Logger.c().a(f12381a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                WorkManagerImpl.k(context).t(goAsync());
            } catch (IllegalStateException e2) {
                Logger.c().b(f12381a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            context.startService(CommandHandler.d(context));
        }
    }
}
