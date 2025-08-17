package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.internal.http2.Http2Connection;

public final class TaskLoggerKt {
    public static final String formatDuration(long j2) {
        String str;
        if (j2 <= -999500000) {
            str = ((j2 - ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        } else if (j2 <= -999500) {
            str = ((j2 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j2 <= 0) {
            str = ((j2 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500) {
            str = ((j2 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j2 < 999500000) {
            str = ((j2 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j2 + ((long) 500000000)) / ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.e(format, "format(format, *args)");
        return format;
    }

    /* access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.Companion.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.getName$okhttp());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.e(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final <T> T logElapsed(Task task, TaskQueue taskQueue, Function0<? extends T> function0) {
        long j2;
        Intrinsics.f(task, "task");
        Intrinsics.f(taskQueue, "queue");
        Intrinsics.f(function0, "block");
        boolean isLoggable = TaskRunner.Companion.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j2 = taskQueue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, taskQueue, "starting");
        } else {
            j2 = -1;
        }
        try {
            T invoke = function0.invoke();
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, taskQueue, "finished run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j2));
            }
            InlineMarker.a(1);
            return invoke;
        } catch (Throwable th) {
            InlineMarker.b(1);
            if (isLoggable) {
                log(task, taskQueue, "failed a run in " + formatDuration(taskQueue.getTaskRunner$okhttp().getBackend().nanoTime() - j2));
            }
            InlineMarker.a(1);
            throw th;
        }
    }

    public static final void taskLog(Task task, TaskQueue taskQueue, Function0<String> function0) {
        Intrinsics.f(task, "task");
        Intrinsics.f(taskQueue, "queue");
        Intrinsics.f(function0, "messageBlock");
        if (TaskRunner.Companion.getLogger().isLoggable(Level.FINE)) {
            log(task, taskQueue, function0.invoke());
        }
    }
}
