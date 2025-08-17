package kotlin.io;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        kotlin.io.CloseableKt.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r2, java.nio.charset.Charset r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            java.lang.String r2 = kotlin.io.TextStreamsKt.e(r0)     // Catch:{ all -> 0x001d }
            r3 = 0
            kotlin.io.CloseableKt.a(r0, r3)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r3 = move-exception
            kotlin.io.CloseableKt.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.a(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String b(File file, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.f40513b;
        }
        return a(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.a(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(java.io.File r1, byte[] r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r1, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.f(r2, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x0019 }
            kotlin.Unit r1 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0019 }
            r1 = 0
            kotlin.io.CloseableKt.a(r0, r1)
            return
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FilesKt__FileReadWriteKt.c(java.io.File, byte[]):void");
    }

    public static void d(File file, String str, Charset charset) {
        Intrinsics.f(file, "<this>");
        Intrinsics.f(str, "text");
        Intrinsics.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
        c(file, bytes);
    }
}
