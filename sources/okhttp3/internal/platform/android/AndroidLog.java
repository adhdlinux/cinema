package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

@SuppressSignatureCheck
public final class AndroidLog {
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final int MAX_LOG_LENGTH = 4000;
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();
    private static final Map<String, String> knownLoggers;

    static {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Class<OkHttpClient> cls = OkHttpClient.class;
        Package packageR = cls.getPackage();
        if (packageR != null) {
            str = packageR.getName();
        } else {
            str = null;
        }
        if (str != null) {
            linkedHashMap.put(str, "OkHttp");
        }
        String name = cls.getName();
        Intrinsics.e(name, "OkHttpClient::class.java.name");
        linkedHashMap.put(name, "okhttp.OkHttpClient");
        String name2 = Http2.class.getName();
        Intrinsics.e(name2, "Http2::class.java.name");
        linkedHashMap.put(name2, "okhttp.Http2");
        String name3 = TaskRunner.class.getName();
        Intrinsics.e(name3, "TaskRunner::class.java.name");
        linkedHashMap.put(name3, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt__MapsKt.u(linkedHashMap);
    }

    private AndroidLog() {
    }

    private final void enableLogging(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else if (Log.isLoggable(str2, 4)) {
                level = Level.INFO;
            } else {
                level = Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? StringsKt___StringsKt.V0(str, 23) : str2;
    }

    public final void androidLog$okhttp(String str, int i2, String str2, Throwable th) {
        int min;
        Intrinsics.f(str, "loggerName");
        Intrinsics.f(str2, "message");
        String loggerTag = loggerTag(str);
        if (Log.isLoggable(loggerTag, i2)) {
            if (th != null) {
                str2 = str2 + 10 + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                int V = StringsKt__StringsKt.V(str2, 10, i3, false, 4, (Object) null);
                if (V == -1) {
                    V = length;
                }
                while (true) {
                    min = Math.min(V, i3 + MAX_LOG_LENGTH);
                    String substring = str2.substring(i3, min);
                    Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i2, loggerTag, substring);
                    if (min >= V) {
                        break;
                    }
                    i3 = min;
                }
                i3 = min + 1;
            }
        }
    }

    public final void enable() {
        for (Map.Entry next : knownLoggers.entrySet()) {
            enableLogging((String) next.getKey(), (String) next.getValue());
        }
    }
}
