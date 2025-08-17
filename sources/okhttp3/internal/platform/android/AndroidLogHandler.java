package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.Intrinsics;

public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        Intrinsics.f(logRecord, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = logRecord.getLoggerName();
        Intrinsics.e(loggerName, "record.loggerName");
        int access$getAndroidLevel = AndroidLogKt.getAndroidLevel(logRecord);
        String message = logRecord.getMessage();
        Intrinsics.e(message, "record.message");
        androidLog.androidLog$okhttp(loggerName, access$getAndroidLevel, message, logRecord.getThrown());
    }
}
