package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class StorageNotLowController extends ConstraintController<Boolean> {
    public StorageNotLowController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.c(context, taskExecutor).e());
    }

    /* access modifiers changed from: package-private */
    public boolean b(WorkSpec workSpec) {
        return workSpec.f12525j.i();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean c(Boolean bool) {
        return !bool.booleanValue();
    }
}
