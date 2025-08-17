package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    public NetworkUnmeteredController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).d());
    }

    /* access modifiers changed from: package-private */
    public boolean b(WorkSpec workSpec) {
        if (workSpec.f12525j.b() == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && workSpec.f12525j.b() == NetworkType.TEMPORARILY_UNMETERED)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(NetworkState networkState) {
        return !networkState.a() || networkState.b();
    }
}
