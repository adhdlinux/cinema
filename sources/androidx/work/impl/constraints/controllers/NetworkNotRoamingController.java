package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkNotRoamingController extends ConstraintController<NetworkState> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f12427e = Logger.f("NetworkNotRoamingCtrlr");

    public NetworkNotRoamingController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).d());
    }

    /* access modifiers changed from: package-private */
    public boolean b(WorkSpec workSpec) {
        return workSpec.f12525j.b() == NetworkType.NOT_ROAMING;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(NetworkState networkState) {
        if (Build.VERSION.SDK_INT < 24) {
            Logger.c().a(f12427e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !networkState.a();
        } else if (!networkState.a() || !networkState.c()) {
            return true;
        } else {
            return false;
        }
    }
}
