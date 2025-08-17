package okhttp3.internal.concurrent;

import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class TaskRunner$runnable$1 implements Runnable {
    final /* synthetic */ TaskRunner this$0;

    TaskRunner$runnable$1(TaskRunner taskRunner) {
        this.this$0 = taskRunner;
    }

    public void run() {
        Task awaitTaskToRun;
        long j2;
        while (true) {
            TaskRunner taskRunner = this.this$0;
            synchronized (taskRunner) {
                awaitTaskToRun = taskRunner.awaitTaskToRun();
            }
            if (awaitTaskToRun != null) {
                TaskQueue queue$okhttp = awaitTaskToRun.getQueue$okhttp();
                Intrinsics.c(queue$okhttp);
                TaskRunner taskRunner2 = this.this$0;
                boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
                if (isLoggable) {
                    j2 = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime();
                    TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "starting");
                } else {
                    j2 = -1;
                }
                try {
                    taskRunner2.runTask(awaitTaskToRun);
                    Unit unit = Unit.f40298a;
                    if (isLoggable) {
                        long nanoTime = queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j2;
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "finished run in " + TaskLoggerKt.formatDuration(nanoTime));
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        TaskLoggerKt.log(awaitTaskToRun, queue$okhttp, "failed a run in " + TaskLoggerKt.formatDuration(queue$okhttp.getTaskRunner$okhttp().getBackend().nanoTime() - j2));
                    }
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
