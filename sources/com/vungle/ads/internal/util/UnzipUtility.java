package com.vungle.ads.internal.util;

import com.vungle.ads.internal.util.Logger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    public static final UnzipUtility INSTANCE = new UnzipUtility();
    private static final String TAG = UnzipUtility.class.getCanonicalName();

    public interface Filter {
        boolean matches(String str);
    }

    public static final class ZipSecurityException extends IOException {
        public ZipSecurityException(String str) {
            super(str);
        }
    }

    private UnzipUtility() {
    }

    public static /* synthetic */ List unzip$default(UnzipUtility unzipUtility, String str, String str2, Filter filter, int i2, Object obj) throws IOException {
        if ((i2 & 4) != 0) {
            filter = null;
        }
        return unzipUtility.unzip(str, str2, filter);
    }

    private final String validateFilename(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        String canonicalPath2 = new File(str2).getCanonicalPath();
        Intrinsics.e(canonicalPath, "canonicalPath");
        Intrinsics.e(canonicalPath2, "canonicalID");
        if (StringsKt__StringsJVMKt.G(canonicalPath, canonicalPath2, false, 2, (Object) null)) {
            return canonicalPath;
        }
        Logger.Companion companion = Logger.Companion;
        String str3 = TAG;
        Intrinsics.e(str3, "TAG");
        companion.e(str3, "File is outside extraction target directory.");
        throw new ZipSecurityException("File is outside extraction target directory.");
    }

    public final void extractFile(InputStream inputStream, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        Intrinsics.f(inputStream, "zipIn");
        File file = new File(str);
        FileUtility.delete(file);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                FileUtility fileUtility = FileUtility.INSTANCE;
                fileUtility.closeQuietly(inputStream);
                fileUtility.closeQuietly(bufferedOutputStream);
                fileUtility.closeQuietly(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        FileUtility fileUtility2 = FileUtility.INSTANCE;
                        fileUtility2.closeQuietly(inputStream);
                        fileUtility2.closeQuietly(bufferedOutputStream);
                        fileUtility2.closeQuietly(fileOutputStream);
                        return;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                FileUtility fileUtility3 = FileUtility.INSTANCE;
                fileUtility3.closeQuietly(inputStream);
                fileUtility3.closeQuietly(bufferedOutputStream);
                fileUtility3.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            fileOutputStream = null;
            th = th4;
            bufferedOutputStream = null;
            FileUtility fileUtility32 = FileUtility.INSTANCE;
            fileUtility32.closeQuietly(inputStream);
            fileUtility32.closeQuietly(bufferedOutputStream);
            fileUtility32.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    public final List<File> unzip(String str, String str2) throws IOException {
        Intrinsics.f(str2, "destDirectory");
        return unzip$default(this, str, str2, (Filter) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e A[SYNTHETIC, Splitter:B:37:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.io.File> unzip(java.lang.String r6, java.lang.String r7, com.vungle.ads.internal.util.UnzipUtility.Filter r8) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "destDirectory"
            kotlin.jvm.internal.Intrinsics.f(r7, r0)
            if (r6 == 0) goto L_0x0010
            int r0 = r6.length()
            if (r0 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = 0
            goto L_0x0011
        L_0x0010:
            r0 = 1
        L_0x0011:
            if (r0 != 0) goto L_0x00aa
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r6 = r0.exists()
            if (r6 == 0) goto L_0x00a2
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            boolean r1 = r6.exists()
            if (r1 != 0) goto L_0x002c
            r6.mkdirs()
        L_0x002c:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r1 = 0
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ all -> 0x009b }
            r2.<init>(r0)     // Catch:{ all -> 0x009b }
            java.util.Enumeration r0 = r2.entries()     // Catch:{ all -> 0x0098 }
        L_0x003b:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x0098 }
            java.util.zip.ZipEntry r1 = (java.util.zip.ZipEntry) r1     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r3.<init>()     // Catch:{ all -> 0x0098 }
            r3.append(r7)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ all -> 0x0098 }
            r3.append(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = r1.getName()     // Catch:{ all -> 0x0098 }
            r3.append(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0098 }
            if (r8 == 0) goto L_0x0067
            boolean r4 = r8.matches(r3)     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x003b
        L_0x0067:
            r5.validateFilename(r3, r7)     // Catch:{ all -> 0x0098 }
            boolean r4 = r1.isDirectory()     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x007f
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0098 }
            r1.<init>(r3)     // Catch:{ all -> 0x0098 }
            boolean r3 = r1.exists()     // Catch:{ all -> 0x0098 }
            if (r3 != 0) goto L_0x003b
            r1.mkdirs()     // Catch:{ all -> 0x0098 }
            goto L_0x003b
        L_0x007f:
            java.io.InputStream r1 = r2.getInputStream(r1)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "zipFile.getInputStream(entry)"
            kotlin.jvm.internal.Intrinsics.e(r1, r4)     // Catch:{ all -> 0x0098 }
            r5.extractFile(r1, r3)     // Catch:{ all -> 0x0098 }
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0098 }
            r1.<init>(r3)     // Catch:{ all -> 0x0098 }
            r6.add(r1)     // Catch:{ all -> 0x0098 }
            goto L_0x003b
        L_0x0094:
            r2.close()     // Catch:{ IOException -> 0x0097 }
        L_0x0097:
            return r6
        L_0x0098:
            r6 = move-exception
            r1 = r2
            goto L_0x009c
        L_0x009b:
            r6 = move-exception
        L_0x009c:
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ IOException -> 0x00a1 }
        L_0x00a1:
            throw r6
        L_0x00a2:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "File does not exist"
            r6.<init>(r7)
            throw r6
        L_0x00aa:
            java.io.IOException r6 = new java.io.IOException
            java.lang.String r7 = "Path is empty"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.UnzipUtility.unzip(java.lang.String, java.lang.String, com.vungle.ads.internal.util.UnzipUtility$Filter):java.util.List");
    }
}
