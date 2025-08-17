package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks = new ArrayList();
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch = new CountDownLatch(1);

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        public long runOnce() {
            this.latch.countDown();
            return -1;
        }
    }

    public TaskQueue(TaskRunner taskRunner2, String str) {
        Intrinsics.f(taskRunner2, "taskRunner");
        Intrinsics.f(str, "name");
        this.taskRunner = taskRunner2;
        this.name = str;
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j2, boolean z2, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        Intrinsics.f(str, "name");
        Intrinsics.f(function0, "block");
        taskQueue.schedule(new TaskQueue$execute$1(str, z2, function0), j2);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        taskQueue.schedule(task, j2);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.f40298a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            Intrinsics.c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z2 = false;
        for (int size = this.futureTasks.size() - 1; -1 < size; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void execute(String str, long j2, boolean z2, Function0<Unit> function0) {
        Intrinsics.f(str, "name");
        Intrinsics.f(function0, "block");
        schedule(new TaskQueue$execute$1(str, z2, function0), j2);
    }

    public final Task getActiveTask$okhttp() {
        return this.activeTask;
    }

    public final boolean getCancelActiveTask$okhttp() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    public final String getName$okhttp() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> a02;
        synchronized (this.taskRunner) {
            a02 = CollectionsKt___CollectionsKt.a0(this.futureTasks);
        }
        return a02;
    }

    public final boolean getShutdown$okhttp() {
        return this.shutdown;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask != null || !this.futureTasks.isEmpty()) {
                Task task = this.activeTask;
                if (task instanceof AwaitIdleTask) {
                    CountDownLatch latch = ((AwaitIdleTask) task).getLatch();
                    return latch;
                }
                for (Task next : this.futureTasks) {
                    if (next instanceof AwaitIdleTask) {
                        CountDownLatch latch2 = ((AwaitIdleTask) next).getLatch();
                        return latch2;
                    }
                }
                AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
                if (scheduleAndDecide$okhttp(awaitIdleTask, 0, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                CountDownLatch latch3 = awaitIdleTask.getLatch();
                return latch3;
            }
            CountDownLatch countDownLatch = new CountDownLatch(0);
            return countDownLatch;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void schedule(okhttp3.internal.concurrent.Task r3, long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            okhttp3.internal.concurrent.TaskRunner r0 = r2.taskRunner
            monitor-enter(r0)
            boolean r1 = r2.shutdown     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0040
            boolean r4 = r3.getCancelable()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x0027
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0050 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0050 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0050 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x0025
            java.lang.String r4 = "schedule canceled (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0050 }
        L_0x0025:
            monitor-exit(r0)
            return
        L_0x0027:
            okhttp3.internal.concurrent.TaskRunner$Companion r4 = okhttp3.internal.concurrent.TaskRunner.Companion     // Catch:{ all -> 0x0050 }
            java.util.logging.Logger r4 = r4.getLogger()     // Catch:{ all -> 0x0050 }
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch:{ all -> 0x0050 }
            boolean r4 = r4.isLoggable(r5)     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x003a
            java.lang.String r4 = "schedule failed (queue is shutdown)"
            okhttp3.internal.concurrent.TaskLoggerKt.log(r3, r2, r4)     // Catch:{ all -> 0x0050 }
        L_0x003a:
            java.util.concurrent.RejectedExecutionException r3 = new java.util.concurrent.RejectedExecutionException     // Catch:{ all -> 0x0050 }
            r3.<init>()     // Catch:{ all -> 0x0050 }
            throw r3     // Catch:{ all -> 0x0050 }
        L_0x0040:
            r1 = 0
            boolean r3 = r2.scheduleAndDecide$okhttp(r3, r4, r1)     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x004c
            okhttp3.internal.concurrent.TaskRunner r3 = r2.taskRunner     // Catch:{ all -> 0x0050 }
            r3.kickCoordinator$okhttp(r2)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            kotlin.Unit r3 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)
            return
        L_0x0050:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.schedule(okhttp3.internal.concurrent.Task, long):void");
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long j2, boolean z2) {
        boolean z3;
        String str;
        Intrinsics.f(task, "task");
        task.initQueue$okhttp(this);
        long nanoTime = this.taskRunner.getBackend().nanoTime();
        long j3 = nanoTime + j2;
        int indexOf = this.futureTasks.indexOf(task);
        if (indexOf != -1) {
            if (task.getNextExecuteNanoTime$okhttp() <= j3) {
                if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(indexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j3);
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            if (z2) {
                str = "run again after " + TaskLoggerKt.formatDuration(j3 - nanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j3 - nanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it2 = this.futureTasks.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            }
            if (it2.next().getNextExecuteNanoTime$okhttp() - nanoTime > j2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            i2 = this.futureTasks.size();
        }
        this.futureTasks.add(i2, task);
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z2) {
        this.cancelActiveTask = z2;
    }

    public final void setShutdown$okhttp(boolean z2) {
        this.shutdown = z2;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                Unit unit = Unit.f40298a;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j2, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        Intrinsics.f(str, "name");
        Intrinsics.f(function0, "block");
        taskQueue.schedule(new TaskQueue$schedule$2(str, function0), j2);
    }

    public final void schedule(String str, long j2, Function0<Long> function0) {
        Intrinsics.f(str, "name");
        Intrinsics.f(function0, "block");
        schedule(new TaskQueue$schedule$2(str, function0), j2);
    }
}
