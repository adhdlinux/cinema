package b0;

import com.chartboost.sdk.impl.d5;
import java.lang.Thread;

public final /* synthetic */ class n implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f12748a;

    public /* synthetic */ n(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f12748a = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        d5.a(this.f12748a, thread, th);
    }
}
