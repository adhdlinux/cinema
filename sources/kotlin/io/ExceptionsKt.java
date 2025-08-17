package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class ExceptionsKt {
    /* access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }
}
