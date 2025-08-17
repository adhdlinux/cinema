package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;

public final class FastServiceLoaderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f40736a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        f40736a = Result.h(obj);
    }

    public static final boolean a() {
        return f40736a;
    }
}
