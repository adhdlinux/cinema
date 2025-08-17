package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12453a = Logger.f("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Logger.c().a(f12453a, "Requesting diagnostics", new Throwable[0]);
            try {
                WorkManager.d(context).b(OneTimeWorkRequest.d(DiagnosticsWorker.class));
            } catch (IllegalStateException e2) {
                Logger.c().b(f12453a, "WorkManager is not initialized", e2);
            }
        }
    }
}
