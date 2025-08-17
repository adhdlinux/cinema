package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkConnectedController extends ConstraintController<NetworkState> {
    public NetworkConnectedController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).d());
    }

    /* access modifiers changed from: package-private */
    public boolean b(WorkSpec workSpec) {
        return workSpec.f12525j.b() == NetworkType.CONNECTED;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(NetworkState networkState) {
        if (Build.VERSION.SDK_INT < 26) {
            return !networkState.a();
        }
        if (!networkState.a() || !networkState.d()) {
            return true;
        }
        return false;
    }
}
