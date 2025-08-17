package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DirectApkSoSource extends SoSource {
    private final File mApkFile;
    private final String mDirectApkLdPath;
    private final Set<String> mLibsInApk;

    public DirectApkSoSource(Context context) {
        this.mLibsInApk = Collections.synchronizedSet(new HashSet());
        this.mDirectApkLdPath = getDirectApkLdPath("");
        this.mApkFile = new File(context.getApplicationInfo().sourceDir);
    }

    private static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        boolean z2 = SoLoader.SYSTRACE_LIBRARY_LOADING;
        if (z2) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            String[] dependencies = NativeDeps.getDependencies(str, elfByteChannel);
            if (z2) {
                Api18TraceUtils.endSection();
            }
            return dependencies;
        } catch (Throwable th) {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
            throw th;
        }
    }

    private static String getDirectApkLdPath(String str) {
        String classLoaderLdLoadLibrary = SoLoader.Api14Utils.getClassLoaderLdLoadLibrary();
        if (classLoaderLdLoadLibrary == null) {
            return null;
        }
        for (String str2 : classLoaderLdLoadLibrary.split(":")) {
            if (str2.contains(str + ".apk!/")) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = getDependencies(r8, r2);
        r3 = r8.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r4 >= r3) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r7.mLibsInApk.contains(r5) != false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r5.startsWith("/") == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r9 | 1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r2 = new com.facebook.soloader.ElfZipFileChannel(r1, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadDependencies(java.lang.String r8, int r9, android.os.StrictMode.ThreadPolicy r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "/"
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            java.io.File r2 = r7.mApkFile
            r1.<init>(r2)
            java.util.Enumeration r2 = r1.entries()     // Catch:{ all -> 0x006c }
        L_0x000d:
            boolean r3 = r2.hasMoreElements()     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.nextElement()     // Catch:{ all -> 0x006c }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x000d
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r5.<init>()     // Catch:{ all -> 0x006c }
            r5.append(r0)     // Catch:{ all -> 0x006c }
            r5.append(r8)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006c }
            boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x000d
            com.facebook.soloader.ElfZipFileChannel r2 = new com.facebook.soloader.ElfZipFileChannel     // Catch:{ all -> 0x006c }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x006c }
            java.lang.String[] r8 = getDependencies(r8, r2)     // Catch:{ all -> 0x005e }
            int r3 = r8.length     // Catch:{ all -> 0x005e }
            r4 = 0
        L_0x003f:
            if (r4 >= r3) goto L_0x005a
            r5 = r8[r4]     // Catch:{ all -> 0x005e }
            java.util.Set<java.lang.String> r6 = r7.mLibsInApk     // Catch:{ all -> 0x005e }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0057
            boolean r6 = r5.startsWith(r0)     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            r6 = r9 | 1
            com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r6, r10)     // Catch:{ all -> 0x005e }
        L_0x0057:
            int r4 = r4 + 1
            goto L_0x003f
        L_0x005a:
            r2.close()     // Catch:{ all -> 0x006c }
            goto L_0x0068
        L_0x005e:
            r8 = move-exception
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r9 = move-exception
            r8.addSuppressed(r9)     // Catch:{ all -> 0x006c }
        L_0x0067:
            throw r8     // Catch:{ all -> 0x006c }
        L_0x0068:
            r1.close()
            return
        L_0x006c:
            r8 = move-exception
            r1.close()     // Catch:{ all -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r9 = move-exception
            r8.addSuppressed(r9)
        L_0x0075:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.DirectApkSoSource.loadDependencies(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        } else if (!this.mLibsInApk.contains(str) || TextUtils.isEmpty(this.mDirectApkLdPath)) {
            Log.d("SoLoader", str + " not found on " + this.mDirectApkLdPath);
            return 0;
        } else {
            loadDependencies(str, i2, threadPolicy);
            int i3 = i2 | 4;
            try {
                SoFileLoader soFileLoader = SoLoader.sSoFileLoader;
                soFileLoader.load(this.mDirectApkLdPath + File.separator + str, i3);
                Log.d("SoLoader", str + " found on DirectAPKSoSource: " + i3);
                return 1;
            } catch (UnsatisfiedLinkError e2) {
                Log.w("SoLoader", str + " not found on DirectAPKSoSource: " + i3, e2);
                return 0;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void prepare(int i2) throws IOException {
        String str;
        int indexOf;
        int i3;
        if (TextUtils.isEmpty(this.mDirectApkLdPath) || (indexOf = this.mDirectApkLdPath.indexOf(33)) < 0 || (i3 = indexOf + 2) >= this.mDirectApkLdPath.length()) {
            str = null;
        } else {
            str = this.mDirectApkLdPath.substring(i3);
        }
        if (str != null) {
            ZipFile zipFile = new ZipFile(this.mApkFile);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (zipEntry != null && zipEntry.getName().startsWith(str) && zipEntry.getName().endsWith(".so") && zipEntry.getMethod() == 0) {
                        this.mLibsInApk.add(zipEntry.getName().substring(str.length() + 1));
                    }
                }
                zipFile.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            return;
        }
        throw th;
    }

    public String toString() {
        return getClass().getName() + "[root = " + this.mDirectApkLdPath + ']';
    }

    public File unpackLibrary(String str) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    public DirectApkSoSource(File file) {
        this.mLibsInApk = Collections.synchronizedSet(new HashSet());
        this.mDirectApkLdPath = getDirectApkLdPath(SysUtil.getBaseName(file.getName()));
        this.mApkFile = file;
    }
}
