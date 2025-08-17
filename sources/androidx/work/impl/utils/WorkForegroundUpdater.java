package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public class WorkForegroundUpdater implements ForegroundUpdater {

    /* renamed from: d  reason: collision with root package name */
    private static final String f12617d = Logger.f("WMFgUpdater");

    /* renamed from: a  reason: collision with root package name */
    private final TaskExecutor f12618a;

    /* renamed from: b  reason: collision with root package name */
    final ForegroundProcessor f12619b;

    /* renamed from: c  reason: collision with root package name */
    final WorkSpecDao f12620c;

    public WorkForegroundUpdater(WorkDatabase workDatabase, ForegroundProcessor foregroundProcessor, TaskExecutor taskExecutor) {
        this.f12619b = foregroundProcessor;
        this.f12618a = taskExecutor;
        this.f12620c = workDatabase.D();
    }

    public ListenableFuture<Void> a(Context context, UUID uuid, ForegroundInfo foregroundInfo) {
        SettableFuture s2 = SettableFuture.s();
        final SettableFuture settableFuture = s2;
        final UUID uuid2 = uuid;
        final ForegroundInfo foregroundInfo2 = foregroundInfo;
        final Context context2 = context;
        this.f12618a.b(new Runnable() {
            public void run() {
                try {
                    if (!settableFuture.isCancelled()) {
                        String uuid = uuid2.toString();
                        WorkInfo.State f2 = WorkForegroundUpdater.this.f12620c.f(uuid);
                        if (f2 == null || f2.a()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.f12619b.b(uuid, foregroundInfo2);
                        context2.startService(SystemForegroundDispatcher.a(context2, uuid, foregroundInfo2));
                    }
                    settableFuture.o(null);
                } catch (Throwable th) {
                    settableFuture.p(th);
                }
            }
        });
        return s2;
    }
}
