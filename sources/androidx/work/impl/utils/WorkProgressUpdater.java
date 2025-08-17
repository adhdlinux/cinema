package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkProgressUpdater implements ProgressUpdater {

    /* renamed from: c  reason: collision with root package name */
    static final String f12626c = Logger.f("WorkProgressUpdater");

    /* renamed from: a  reason: collision with root package name */
    final WorkDatabase f12627a;

    /* renamed from: b  reason: collision with root package name */
    final TaskExecutor f12628b;

    public WorkProgressUpdater(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.f12627a = workDatabase;
        this.f12628b = taskExecutor;
    }

    public ListenableFuture<Void> a(Context context, final UUID uuid, final Data data) {
        final SettableFuture s2 = SettableFuture.s();
        this.f12628b.b(new Runnable() {
            public void run() {
                String uuid = uuid.toString();
                Logger c2 = Logger.c();
                String str = WorkProgressUpdater.f12626c;
                c2.a(str, String.format("Updating progress for %s (%s)", new Object[]{uuid, data}), new Throwable[0]);
                WorkProgressUpdater.this.f12627a.c();
                try {
                    WorkSpec g2 = WorkProgressUpdater.this.f12627a.D().g(uuid);
                    if (g2 != null) {
                        if (g2.f12517b == WorkInfo.State.RUNNING) {
                            WorkProgressUpdater.this.f12627a.C().b(new WorkProgress(uuid, data));
                        } else {
                            Logger.c().h(str, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid}), new Throwable[0]);
                        }
                        s2.o(null);
                        WorkProgressUpdater.this.f12627a.t();
                        WorkProgressUpdater.this.f12627a.g();
                        return;
                    }
                    throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                } catch (Throwable th) {
                    WorkProgressUpdater.this.f12627a.g();
                    throw th;
                }
            }
        });
        return s2;
    }
}
