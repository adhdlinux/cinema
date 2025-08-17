package okhttp3.logging;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

public final class HttpLoggingInterceptor$Logger$Companion$DEFAULT$1 implements HttpLoggingInterceptor.Logger {
    HttpLoggingInterceptor$Logger$Companion$DEFAULT$1() {
    }

    public void log(String str) {
        Intrinsics.g(str, "message");
        Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
    }
}
