package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class HandlerDispatcherKt {

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerDispatcher f40707a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        HandlerDispatcher handlerDispatcher = null;
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(new HandlerContext(a(Looper.getMainLooper(), true), (String) null, 2, (DefaultConstructorMarker) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (!Result.g(obj)) {
            handlerDispatcher = obj;
        }
        f40707a = handlerDispatcher;
    }

    public static final Handler a(Looper looper, boolean z2) {
        if (!z2) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            Intrinsics.d(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
