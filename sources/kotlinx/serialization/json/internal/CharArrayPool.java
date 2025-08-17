package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

public final class CharArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public static final CharArrayPool f41199a = new CharArrayPool();

    /* renamed from: b  reason: collision with root package name */
    private static final ArrayDeque<char[]> f41200b = new ArrayDeque<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f41201c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f41202d;

    static {
        Object obj;
        int i2;
        try {
            Result.Companion companion = Result.f40263c;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.e(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            obj = Result.b(StringsKt__StringNumberConversionsKt.k(property));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.g(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 1048576;
        }
        f41202d = i2;
    }

    private CharArrayPool() {
    }

    public final void a(char[] cArr) {
        Intrinsics.f(cArr, "array");
        synchronized (this) {
            int i2 = f41201c;
            if (cArr.length + i2 < f41202d) {
                f41201c = i2 + cArr.length;
                f41200b.addLast(cArr);
            }
            Unit unit = Unit.f40298a;
        }
    }

    public final char[] b() {
        char[] m2;
        synchronized (this) {
            m2 = f41200b.m();
            if (m2 != null) {
                f41201c -= m2.length;
            } else {
                m2 = null;
            }
        }
        if (m2 == null) {
            return new char[128];
        }
        return m2;
    }
}
