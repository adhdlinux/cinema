package com.vungle.ads.internal.util;

import android.os.Build;
import android.webkit.URLUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.internal.util.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;

public final class FileUtility {
    public static final FileUtility INSTANCE = new FileUtility();
    private static final String TAG = FileUtility.class.getSimpleName();
    private static final List<Class<?>> allowedClasses = CollectionsKt__CollectionsKt.i(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);
    private static ObjectInputStreamProvider objectInputStreamProvider = new c();

    public interface ObjectInputStreamProvider {
        ObjectInputStream provideObjectInputStream(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    private FileUtility() {
    }

    public static final void delete(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (!file.delete()) {
                        Logger.Companion companion = Logger.Companion;
                        String str = TAG;
                        Intrinsics.e(str, "TAG");
                        companion.d(str, "Failed to delete file: " + file);
                    }
                }
            } catch (Exception e2) {
                Logger.Companion companion2 = Logger.Companion;
                String str2 = TAG;
                Intrinsics.e(str2, "TAG");
                companion2.e(str2, "Failed to delete file: " + e2.getLocalizedMessage());
            }
        }
    }

    public static final void deleteAndLogIfFailed(File file) {
        Intrinsics.f(file, "file");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else if (!file.delete()) {
                Logger.Companion companion = Logger.Companion;
                String str = TAG;
                Intrinsics.e(str, "TAG");
                companion.e(str, "Cannot delete " + file.getName());
            }
        } catch (Exception e2) {
            Logger.Companion companion2 = Logger.Companion;
            String str2 = TAG;
            Intrinsics.e(str2, "TAG");
            companion2.e(str2, "Cannot delete " + file.getName(), e2);
        }
    }

    public static final void deleteContents(File file) {
        Intrinsics.f(file, "folder");
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete(delete);
            }
        }
    }

    public static /* synthetic */ void getAllowedClasses$vungle_ads_release$annotations() {
    }

    private final String getIndentString(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("|  ");
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "sb.toString()");
        return sb2;
    }

    public static /* synthetic */ String guessFileName$default(FileUtility fileUtility, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        return fileUtility.guessFileName(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: objectInputStreamProvider$lambda-0  reason: not valid java name */
    public static final ObjectInputStream m223objectInputStreamProvider$lambda0(InputStream inputStream) {
        return new SafeObjectInputStream(inputStream, allowedClasses);
    }

    public static final void printDirectoryTree(File file) {
    }

    private final void printDirectoryTree(File file, int i2, StringBuilder sb) {
        if (file != null) {
            if (file.isDirectory()) {
                sb.append(getIndentString(i2));
                sb.append("+--");
                sb.append(file.getName());
                sb.append("/\n");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            printDirectoryTree(file2, i2 + 1, sb);
                        } else {
                            Intrinsics.e(file2, "file");
                            printFile(file2, i2 + 1, sb);
                        }
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("folder is not a Directory".toString());
        }
    }

    private final void printFile(File file, int i2, StringBuilder sb) {
        sb.append(getIndentString(i2));
        sb.append("+--");
        sb.append(file.getName());
        sb.append(10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T readSerializable(java.io.File r8) {
        /*
            java.lang.String r0 = "TAG"
            java.lang.String r1 = "file"
            kotlin.jvm.internal.Intrinsics.f(r8, r1)
            boolean r1 = r8.exists()
            r2 = 0
            if (r1 != 0) goto L_0x000f
            return r2
        L_0x000f:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0083, ClassNotFoundException -> 0x0060, Exception -> 0x003d, all -> 0x0039 }
            r1.<init>(r8)     // Catch:{ IOException -> 0x0083, ClassNotFoundException -> 0x0060, Exception -> 0x003d, all -> 0x0039 }
            com.vungle.ads.internal.util.FileUtility$ObjectInputStreamProvider r3 = objectInputStreamProvider     // Catch:{ IOException -> 0x0036, ClassNotFoundException -> 0x0033, Exception -> 0x0030, all -> 0x002d }
            java.io.ObjectInputStream r3 = r3.provideObjectInputStream(r1)     // Catch:{ IOException -> 0x0036, ClassNotFoundException -> 0x0033, Exception -> 0x0030, all -> 0x002d }
            java.lang.Object r8 = r3.readObject()     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0029, Exception -> 0x0027 }
            com.vungle.ads.internal.util.FileUtility r0 = INSTANCE
            r0.closeQuietly(r3)
            r0.closeQuietly(r1)
            return r8
        L_0x0027:
            r4 = move-exception
            goto L_0x0040
        L_0x0029:
            r4 = move-exception
            goto L_0x0063
        L_0x002b:
            r4 = move-exception
            goto L_0x0086
        L_0x002d:
            r8 = move-exception
            goto L_0x00b3
        L_0x0030:
            r4 = move-exception
            r3 = r2
            goto L_0x0040
        L_0x0033:
            r4 = move-exception
            r3 = r2
            goto L_0x0063
        L_0x0036:
            r4 = move-exception
            r3 = r2
            goto L_0x0086
        L_0x0039:
            r8 = move-exception
            r1 = r2
            goto L_0x00b3
        L_0x003d:
            r4 = move-exception
            r1 = r2
            r3 = r1
        L_0x0040:
            com.vungle.ads.internal.util.Logger$Companion r5 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.internal.Intrinsics.e(r6, r0)     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = "cannot read serializable "
            r0.append(r7)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00b1 }
            r0.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b1 }
            r5.e(r6, r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00a5
        L_0x0060:
            r4 = move-exception
            r1 = r2
            r3 = r1
        L_0x0063:
            com.vungle.ads.internal.util.Logger$Companion r5 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.internal.Intrinsics.e(r6, r0)     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = "ClassNotFoundException: "
            r0.append(r7)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00b1 }
            r0.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b1 }
            r5.e(r6, r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00a5
        L_0x0083:
            r4 = move-exception
            r1 = r2
            r3 = r1
        L_0x0086:
            com.vungle.ads.internal.util.Logger$Companion r5 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00b1 }
            kotlin.jvm.internal.Intrinsics.e(r6, r0)     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            java.lang.String r7 = "IOException: "
            r0.append(r7)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x00b1 }
            r0.append(r4)     // Catch:{ all -> 0x00b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b1 }
            r5.e(r6, r0)     // Catch:{ all -> 0x00b1 }
        L_0x00a5:
            com.vungle.ads.internal.util.FileUtility r0 = INSTANCE
            r0.closeQuietly(r3)
            r0.closeQuietly(r1)
            delete(r8)     // Catch:{ IOException -> 0x00b0 }
        L_0x00b0:
            return r2
        L_0x00b1:
            r8 = move-exception
            r2 = r3
        L_0x00b3:
            com.vungle.ads.internal.util.FileUtility r0 = INSTANCE
            r0.closeQuietly(r2)
            r0.closeQuietly(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.FileUtility.readSerializable(java.io.File):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeSerializable(java.io.File r4, java.io.Serializable r5) {
        /*
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x000e
            deleteAndLogIfFailed(r4)
        L_0x000e:
            if (r5 != 0) goto L_0x0011
            return
        L_0x0011:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0031, all -> 0x002f }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0031, all -> 0x002f }
            r4.writeObject(r5)     // Catch:{ IOException -> 0x002d, all -> 0x002b }
            r4.reset()     // Catch:{ IOException -> 0x002d, all -> 0x002b }
            com.vungle.ads.internal.util.FileUtility r5 = INSTANCE
            r5.closeQuietly(r4)
            r5.closeQuietly(r1)
            goto L_0x0056
        L_0x002b:
            r5 = move-exception
            goto L_0x0059
        L_0x002d:
            r5 = move-exception
            goto L_0x0033
        L_0x002f:
            r5 = move-exception
            goto L_0x005a
        L_0x0031:
            r5 = move-exception
            r4 = r0
        L_0x0033:
            r0 = r1
            goto L_0x003a
        L_0x0035:
            r5 = move-exception
            r1 = r0
            goto L_0x005a
        L_0x0038:
            r5 = move-exception
            r4 = r0
        L_0x003a:
            com.vungle.ads.internal.util.Logger$Companion r1 = com.vungle.ads.internal.util.Logger.Companion     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0057 }
            java.lang.String r3 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r2, r3)     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0057 }
            r1.e(r2, r5)     // Catch:{ all -> 0x0057 }
            com.vungle.ads.internal.util.FileUtility r5 = INSTANCE
            r5.closeQuietly(r4)
            r5.closeQuietly(r0)
        L_0x0056:
            return
        L_0x0057:
            r5 = move-exception
            r1 = r0
        L_0x0059:
            r0 = r4
        L_0x005a:
            com.vungle.ads.internal.util.FileUtility r4 = INSTANCE
            r4.closeQuietly(r0)
            r4.closeQuietly(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.FileUtility.writeSerializable(java.io.File, java.io.Serializable):void");
    }

    public final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final List<Class<?>> getAllowedClasses$vungle_ads_release() {
        return allowedClasses;
    }

    public final ObjectInputStreamProvider getObjectInputStreamProvider() {
        return objectInputStreamProvider;
    }

    public final String guessFileName(String str, String str2) {
        Intrinsics.f(str, ImagesContract.URL);
        String guessFileName = URLUtil.guessFileName(str, (String) null, str2);
        Intrinsics.e(guessFileName, "guessFileName(url, null, ext)");
        return guessFileName;
    }

    public final boolean isValidUrl(String str) {
        return !(str == null || str.length() == 0) && HttpUrl.Companion.parse(str) != null;
    }

    public final String readString(File file) {
        Intrinsics.f(file, "file");
        if (!file.exists()) {
            return null;
        }
        try {
            return FilesKt__FileReadWriteKt.b(file, (Charset) null, 1, (Object) null);
        } catch (IOException e2) {
            Logger.Companion companion = Logger.Companion;
            String str = TAG;
            Intrinsics.e(str, "TAG");
            companion.e(str, "IOException: " + e2.getMessage());
            return null;
        } catch (Exception e3) {
            Logger.Companion companion2 = Logger.Companion;
            String str2 = TAG;
            Intrinsics.e(str2, "TAG");
            companion2.e(str2, "cannot read string " + e3.getMessage());
            return null;
        }
    }

    public final void setObjectInputStreamProvider(ObjectInputStreamProvider objectInputStreamProvider2) {
        Intrinsics.f(objectInputStreamProvider2, "<set-?>");
        objectInputStreamProvider = objectInputStreamProvider2;
    }

    public final long size(File file) {
        boolean z2;
        long j2 = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            if (listFiles.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                for (File size : listFiles) {
                    j2 += size(size);
                }
            }
        }
        return j2;
    }

    public final void writeString(File file, String str) {
        Intrinsics.f(file, "file");
        if (str != null) {
            try {
                FilesKt__FileReadWriteKt.d(file, str, Charsets.f40513b);
            } catch (IOException e2) {
                Logger.Companion companion = Logger.Companion;
                String str2 = TAG;
                Intrinsics.e(str2, "TAG");
                companion.e(str2, String.valueOf(e2.getMessage()));
            }
        }
    }
}
