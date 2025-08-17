package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

class ExceptionsKt__ExceptionsKt {
    public static void a(Throwable th, Throwable th2) {
        Intrinsics.f(th, "<this>");
        Intrinsics.f(th2, "exception");
        if (th != th2) {
            PlatformImplementationsKt.f40382a.a(th, th2);
        }
    }

    public static String b(Throwable th) {
        Intrinsics.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.e(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
