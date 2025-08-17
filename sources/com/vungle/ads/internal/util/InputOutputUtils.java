package com.vungle.ads.internal.util;

public final class InputOutputUtils {
    public static final InputOutputUtils INSTANCE = new InputOutputUtils();

    private InputOutputUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        kotlin.io.CloseableKt.a(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        kotlin.io.CloseableKt.a(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String convertForSending(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "stringToConvert"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            int r1 = r4.length()
            r0.<init>(r1)
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0041 }
            r1.<init>(r0)     // Catch:{ all -> 0x0041 }
            java.nio.charset.Charset r2 = kotlin.text.Charsets.f40513b     // Catch:{ all -> 0x003a }
            byte[] r4 = r4.getBytes(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.e(r4, r2)     // Catch:{ all -> 0x003a }
            r1.write(r4)     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ all -> 0x003a }
            byte[] r4 = r0.toByteArray()     // Catch:{ all -> 0x003a }
            r2 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch:{ all -> 0x003a }
            java.lang.String r2 = "encodeToString(compressed, Base64.NO_WRAP)"
            kotlin.jvm.internal.Intrinsics.e(r4, r2)     // Catch:{ all -> 0x003a }
            r2 = 0
            kotlin.io.CloseableKt.a(r1, r2)     // Catch:{ all -> 0x0041 }
            kotlin.io.CloseableKt.a(r0, r2)
            return r4
        L_0x003a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003c }
        L_0x003c:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r1, r4)     // Catch:{ all -> 0x0041 }
            throw r2     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r0, r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.InputOutputUtils.convertForSending(java.lang.String):java.lang.String");
    }
}
