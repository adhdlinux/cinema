package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.google.protobuf.CodedOutputStream;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SoLoader {
    static final boolean DEBUG = false;
    private static final String[] DEFAULT_DENY_LIST = {System.mapLibraryName("breakpad")};
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING = true;
    static final String TAG = "SoLoader";
    private static int sAppType = 0;
    private static ApplicationSoSource sApplicationSoSource;
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    public static SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public static final AtomicInteger sSoSourcesVersion = new AtomicInteger(0);
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    @DoNotOptimize
    @TargetApi(14)
    static class Api14Utils {
        Api14Utils() {
        }

        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            } else {
                throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
            }
        }
    }

    interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.sSoSourcesVersion.getAndIncrement();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    private static void AddBackupSoSource(Context context, ArrayList<SoSource> arrayList, int i2) throws IOException {
        if ((sFlags & 8) != 0) {
            sBackupSoSources = null;
            File soStorePath = UnpackingSoSource.getSoStorePath(context, SO_STORE_NAME_MAIN);
            try {
                SysUtil.dumbDeleteRecursive(soStorePath);
            } catch (IOException e2) {
                Log.w(TAG, "Failed to delete " + soStorePath.getCanonicalPath(), e2);
            }
        } else {
            File file = new File(context.getApplicationInfo().sourceDir);
            ArrayList arrayList2 = new ArrayList();
            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i2);
            arrayList2.add(apkSoSource);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
            }
            addBackupSoSourceFromSplitApk(context, i2, arrayList2);
            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
            arrayList.addAll(0, arrayList2);
        }
    }

    private static void AddSystemLibSoSource(ArrayList<SoSource> arrayList, String[] strArr) {
        String str;
        if (SysUtil.is64Bit()) {
            str = "/system/lib64:/vendor/lib64";
        } else {
            str = "/system/lib:/vendor/lib";
        }
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str + ":" + str2;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(":")))) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding system library source: " + str3);
            }
            arrayList.add(new DirectorySoSource(new File(str3), 2, strArr));
        }
    }

    private static void addApplicationSoSource(Context context, ArrayList<SoSource> arrayList, int i2) {
        sApplicationSoSource = new ApplicationSoSource(context, i2);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
        }
        arrayList.add(0, sApplicationSoSource);
    }

    private static void addBackupSoSourceFromSplitApk(Context context, int i2, ArrayList<UnpackingSoSource> arrayList) {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup sources from split apks");
            }
            String[] strArr = context.getApplicationInfo().splitSourceDirs;
            int length = strArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                File file = new File(strArr[i3]);
                StringBuilder sb = new StringBuilder();
                sb.append(SO_STORE_NAME_SPLIT);
                int i5 = i4 + 1;
                sb.append(i4);
                ApkSoSource apkSoSource = new ApkSoSource(context, file, sb.toString(), i2);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "adding backup source: " + apkSoSource.toString());
                }
                arrayList.add(apkSoSource);
                i3++;
                i4 = i5;
            }
        }
    }

    private static void addDirectApkSoSource(Context context, ArrayList<SoSource> arrayList) {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding directApk sources from split apks");
            }
            for (String file : context.getApplicationInfo().splitSourceDirs) {
                DirectApkSoSource directApkSoSource = new DirectApkSoSource(new File(file));
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "adding directApk source: " + directApkSoSource.toString());
                }
                arrayList.add(0, directApkSoSource);
            }
        }
        DirectApkSoSource directApkSoSource2 = new DirectApkSoSource(context);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "adding directApk source: " + directApkSoSource2.toString());
        }
        arrayList.add(0, directApkSoSource2);
    }

    /* JADX INFO: finally extract failed */
    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        String str = soSourceAbis2[i2];
                        boolean z2 = false;
                        for (int i3 = 0; i3 < supportedAbis.length && !z2; i3++) {
                            z2 = str.equals(supportedAbis[i3]);
                        }
                        if (!z2) {
                            Log.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        } else {
                            i2++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r12, int r13, android.os.StrictMode.ThreadPolicy r14) throws java.lang.UnsatisfiedLinkError {
        /*
            java.lang.String r0 = " result: "
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()
            r2.lock()
            com.facebook.soloader.SoSource[] r2 = sSoSources     // Catch:{ all -> 0x018a }
            java.lang.String r3 = "couldn't find DSO to load: "
            java.lang.String r4 = "SoLoader"
            if (r2 == 0) goto L_0x015c
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.readLock()
            r2.unlock()
            r2 = 1
            r5 = 0
            if (r14 != 0) goto L_0x0024
            android.os.StrictMode$ThreadPolicy r14 = android.os.StrictMode.allowThreadDiskReads()
            r6 = 1
            goto L_0x0025
        L_0x0024:
            r6 = 0
        L_0x0025:
            boolean r7 = SYSTRACE_LIBRARY_LOADING
            if (r7 == 0) goto L_0x0030
            java.lang.String r7 = "SoLoader.loadLibrary["
            java.lang.String r8 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r7, r12, r8)
        L_0x0030:
            r7 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x0113 }
            r1.lock()     // Catch:{ all -> 0x0113 }
            r1 = 0
            r8 = 0
        L_0x003a:
            if (r1 != 0) goto L_0x008c
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x0080 }
            int r10 = r9.length     // Catch:{ all -> 0x0080 }
            if (r8 >= r10) goto L_0x008c
            r9 = r9[r8]     // Catch:{ all -> 0x0080 }
            int r1 = r9.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0080 }
            if (r1 != r7) goto L_0x007d
            com.facebook.soloader.UnpackingSoSource[] r9 = sBackupSoSources     // Catch:{ all -> 0x0080 }
            if (r9 == 0) goto L_0x007d
            boolean r8 = android.util.Log.isLoggable(r4, r7)     // Catch:{ all -> 0x0080 }
            if (r8 == 0) goto L_0x0067
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r8.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r9 = "Trying backup SoSource for "
            r8.append(r9)     // Catch:{ all -> 0x0080 }
            r8.append(r12)     // Catch:{ all -> 0x0080 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0080 }
            android.util.Log.d(r4, r8)     // Catch:{ all -> 0x0080 }
        L_0x0067:
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x0080 }
            int r9 = r8.length     // Catch:{ all -> 0x0080 }
            r10 = 0
        L_0x006b:
            if (r10 >= r9) goto L_0x008c
            r11 = r8[r10]     // Catch:{ all -> 0x0080 }
            r11.prepare((java.lang.String) r12)     // Catch:{ all -> 0x0080 }
            int r11 = r11.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0080 }
            if (r11 != r2) goto L_0x007a
            r1 = r11
            goto L_0x008c
        L_0x007a:
            int r10 = r10 + 1
            goto L_0x006b
        L_0x007d:
            int r8 = r8 + 1
            goto L_0x003a
        L_0x0080:
            r13 = move-exception
            r5 = r1
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock     // Catch:{ all -> 0x0113 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x0113 }
            r1.unlock()     // Catch:{ all -> 0x0113 }
            throw r13     // Catch:{ all -> 0x0113 }
        L_0x008c:
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock     // Catch:{ all -> 0x0110 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r13.readLock()     // Catch:{ all -> 0x0110 }
            r2.unlock()     // Catch:{ all -> 0x0110 }
            boolean r2 = SYSTRACE_LIBRARY_LOADING
            if (r2 == 0) goto L_0x009c
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x009c:
            if (r6 == 0) goto L_0x00a1
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x00a1:
            if (r1 == 0) goto L_0x00a5
            if (r1 != r7) goto L_0x0125
        L_0x00a5:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r3)
            r14.append(r12)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r13.readLock()
            r12.lock()
        L_0x00b7:
            com.facebook.soloader.SoSource[] r12 = sSoSources
            int r12 = r12.length
            if (r5 >= r12) goto L_0x00d7
            java.lang.String r12 = "\n\tSoSource "
            r14.append(r12)
            r14.append(r5)
            java.lang.String r12 = ": "
            r14.append(r12)
            com.facebook.soloader.SoSource[] r12 = sSoSources
            r12 = r12[r5]
            java.lang.String r12 = r12.toString()
            r14.append(r12)
            int r5 = r5 + 1
            goto L_0x00b7
        L_0x00d7:
            com.facebook.soloader.ApplicationSoSource r12 = sApplicationSoSource
            if (r12 == 0) goto L_0x00f4
            android.content.Context r12 = r12.getUpdatedContext()
            java.io.File r12 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r12)
            java.lang.String r13 = "\n\tNative lib dir: "
            r14.append(r13)
            java.lang.String r12 = r12.getAbsolutePath()
            r14.append(r12)
            java.lang.String r12 = "\n"
            r14.append(r12)
        L_0x00f4:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            r14.append(r0)
            r14.append(r1)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError
            r13.<init>(r12)
            throw r13
        L_0x0110:
            r13 = move-exception
            r5 = r1
            goto L_0x0114
        L_0x0113:
            r13 = move-exception
        L_0x0114:
            boolean r1 = SYSTRACE_LIBRARY_LOADING
            if (r1 == 0) goto L_0x011b
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x011b:
            if (r6 == 0) goto L_0x0120
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x0120:
            if (r5 == 0) goto L_0x0126
            if (r5 != r7) goto L_0x0125
            goto L_0x0126
        L_0x0125:
            return
        L_0x0126:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r3)
            r14.append(r12)
            java.lang.String r12 = r13.getMessage()
            if (r12 != 0) goto L_0x013b
            java.lang.String r12 = r13.toString()
        L_0x013b:
            java.lang.String r1 = " caused by: "
            r14.append(r1)
            r14.append(r12)
            r13.printStackTrace()
            r14.append(r0)
            r14.append(r5)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r14 = new java.lang.UnsatisfiedLinkError
            r14.<init>(r12)
            r14.initCause(r13)
            throw r14
        L_0x015c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r13.<init>()     // Catch:{ all -> 0x018a }
            java.lang.String r14 = "Could not load: "
            r13.append(r14)     // Catch:{ all -> 0x018a }
            r13.append(r12)     // Catch:{ all -> 0x018a }
            java.lang.String r14 = " because no SO source exists"
            r13.append(r14)     // Catch:{ all -> 0x018a }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x018a }
            android.util.Log.e(r4, r13)     // Catch:{ all -> 0x018a }
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x018a }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
            r14.<init>()     // Catch:{ all -> 0x018a }
            r14.append(r3)     // Catch:{ all -> 0x018a }
            r14.append(r12)     // Catch:{ all -> 0x018a }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x018a }
            r13.<init>(r12)     // Catch:{ all -> 0x018a }
            throw r13     // Catch:{ all -> 0x018a }
        L_0x018a:
            r12 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    private static int getAppType(Context context, int i2) {
        int i3 = sAppType;
        if (i3 != 0) {
            return i3;
        }
        int i4 = 1;
        if ((i2 & 32) == 0 && context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i5 = applicationInfo.flags;
            if ((i5 & 1) != 0) {
                if ((i5 & 128) != 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i4);
            }
        }
        return i4;
    }

    private static int getApplicationSoSourceFlags() {
        int i2 = sAppType;
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2 || i2 == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i2 = 0;
                while (strArr == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i2 >= soSourceArr.length) {
                        break;
                    }
                    strArr = soSourceArr[i2].getLibraryDependencies(str);
                    i2++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i2 = 0;
                while (str2 == null) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i2 >= soSourceArr.length) {
                        break;
                    }
                    str2 = soSourceArr[i2].getLibraryPath(str);
                    i2++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static Method getNativeLoadRuntimeMethod() {
        Class<String> cls = String.class;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{cls, ClassLoader.class, cls});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w(TAG, "Cannot get nativeLoad method", e2);
            }
        }
        return null;
    }

    public static File getSoFile(String str) {
        String mapLibName = MergedSoMapping.mapLibName(str);
        if (mapLibName != null) {
            str = mapLibName;
        }
        String mapLibraryName = System.mapLibraryName(str);
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                int i2 = 0;
                while (true) {
                    SoSource[] soSourceArr = sSoSources;
                    if (i2 >= soSourceArr.length) {
                        break;
                    }
                    try {
                        File soFileByName = soSourceArr[i2].getSoFileByName(mapLibraryName);
                        if (soFileByName != null) {
                            return soFileByName;
                        }
                        i2++;
                    } catch (IOException unused) {
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static void init(Context context, int i2) throws IOException {
        init(context, i2, (SoFileLoader) null, DEFAULT_DENY_LIST);
    }

    private static synchronized void initSoLoader(SoFileLoader soFileLoader) {
        final boolean z2;
        String str;
        synchronized (SoLoader.class) {
            if (soFileLoader == null) {
                if (sSoFileLoader != null) {
                    return;
                }
            }
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            if (nativeLoadRuntimeMethod != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = Api14Utils.getClassLoaderLdLoadLibrary();
            } else {
                str = null;
            }
            final String str2 = str;
            final String makeNonZipPath = makeNonZipPath(str2);
            sSoFileLoader = new SoFileLoader() {
                private String getLibHash(String str) {
                    FileInputStream fileInputStream;
                    try {
                        File file = new File(str);
                        MessageDigest instance = MessageDigest.getInstance("MD5");
                        fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                instance.update(bArr, 0, read);
                            } else {
                                String format = String.format("%32x", new Object[]{new BigInteger(1, instance.digest())});
                                fileInputStream.close();
                                return format;
                            }
                        }
                    } catch (IOException | SecurityException | NoSuchAlgorithmException e2) {
                        return e2.toString();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }

                /* JADX WARNING: type inference failed for: r1v0 */
                /* JADX WARNING: type inference failed for: r1v10 */
                /* JADX WARNING: type inference failed for: r1v12 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
                    if (r1 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00c9
                        r0 = 4
                        r10 = r10 & r0
                        r1 = 1
                        r2 = 0
                        if (r10 != r0) goto L_0x000c
                        r10 = 1
                        goto L_0x000d
                    L_0x000c:
                        r10 = 0
                    L_0x000d:
                        if (r10 == 0) goto L_0x0012
                        java.lang.String r10 = r3
                        goto L_0x0014
                    L_0x0012:
                        java.lang.String r10 = r4
                    L_0x0014:
                        r0 = 0
                        java.lang.Runtime r3 = r5     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        monitor-enter(r3)     // Catch:{ IllegalAccessException -> 0x0080, IllegalArgumentException -> 0x007e, InvocationTargetException -> 0x007c, all -> 0x0077 }
                        java.lang.reflect.Method r4 = r6     // Catch:{ all -> 0x0069 }
                        java.lang.Runtime r5 = r5     // Catch:{ all -> 0x0069 }
                        r6 = 3
                        java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0069 }
                        r6[r2] = r9     // Catch:{ all -> 0x0069 }
                        java.lang.Class<com.facebook.soloader.SoLoader> r2 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ all -> 0x0069 }
                        r6[r1] = r2     // Catch:{ all -> 0x0069 }
                        r1 = 2
                        r6[r1] = r10     // Catch:{ all -> 0x0069 }
                        java.lang.Object r1 = r4.invoke(r5, r6)     // Catch:{ all -> 0x0069 }
                        java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0069 }
                        if (r1 != 0) goto L_0x0063
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        if (r1 == 0) goto L_0x00cc
                        java.lang.String r0 = "SoLoader"
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.String r3 = "Error when loading lib: "
                        r2.append(r3)
                        r2.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r2.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r2.append(r9)
                        java.lang.String r9 = " search path is "
                        r2.append(r9)
                        r2.append(r10)
                        java.lang.String r9 = r2.toString()
                        android.util.Log.e(r0, r9)
                        goto L_0x00cc
                    L_0x0063:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0075 }
                        r0.<init>(r1)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ all -> 0x0075 }
                    L_0x0069:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x006d:
                        monitor-exit(r3)     // Catch:{ all -> 0x0075 }
                        throw r0     // Catch:{ IllegalAccessException -> 0x0073, IllegalArgumentException -> 0x0071, InvocationTargetException -> 0x006f }
                    L_0x006f:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0071:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0073:
                        r0 = move-exception
                        goto L_0x0084
                    L_0x0075:
                        r0 = move-exception
                        goto L_0x006d
                    L_0x0077:
                        r1 = move-exception
                        r7 = r1
                        r1 = r0
                        r0 = r7
                        goto L_0x009c
                    L_0x007c:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x007e:
                        r1 = move-exception
                        goto L_0x0081
                    L_0x0080:
                        r1 = move-exception
                    L_0x0081:
                        r7 = r1
                        r1 = r0
                        r0 = r7
                    L_0x0084:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
                        r2.<init>()     // Catch:{ all -> 0x009b }
                        java.lang.String r3 = "Error: Cannot load "
                        r2.append(r3)     // Catch:{ all -> 0x009b }
                        r2.append(r9)     // Catch:{ all -> 0x009b }
                        java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x009b }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x009b }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x009b }
                        throw r2     // Catch:{ all -> 0x009b }
                    L_0x009b:
                        r0 = move-exception
                    L_0x009c:
                        if (r1 == 0) goto L_0x00c8
                        java.lang.String r2 = "SoLoader"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "Error when loading lib: "
                        r3.append(r4)
                        r3.append(r1)
                        java.lang.String r1 = " lib hash: "
                        r3.append(r1)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r3.append(r9)
                        java.lang.String r9 = " search path is "
                        r3.append(r9)
                        r3.append(r10)
                        java.lang.String r9 = r3.toString()
                        android.util.Log.e(r2, r9)
                    L_0x00c8:
                        throw r0
                    L_0x00c9:
                        java.lang.System.load(r9)
                    L_0x00cc:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                public void loadBytes(String str, ElfByteChannel elfByteChannel, int i2) {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    private static void initSoSources(Context context, int i2, String[] strArr) throws IOException {
        if (sSoSources == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                sFlags = i2;
                ArrayList arrayList = new ArrayList();
                AddSystemLibSoSource(arrayList, strArr);
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        sBackupSoSources = null;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "adding exo package source: lib-main");
                        }
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if (SysUtil.isSupportedDirectLoad(context, sAppType)) {
                            addDirectApkSoSource(context, arrayList);
                        }
                        addApplicationSoSource(context, arrayList, getApplicationSoSourceFlags());
                        AddBackupSoSource(context, arrayList, 1);
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i3 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Preparing SO source: " + soSourceArr[i3]);
                    }
                    soSourceArr[i3].prepare(makePrepareFlags);
                    length = i3;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
                }
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    public static boolean isInitialized() {
        boolean z2;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            reentrantReadWriteLock.readLock().unlock();
            return z2;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    static void loadLibraryBySoName(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i2, threadPolicy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x014c, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r11 + "', which has been merged into '" + r10 + "'.  See comment for details.", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x014f, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0151, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0154, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0155, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0156, code lost:
        r0.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x015f, code lost:
        return !r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0162, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0163, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x016c, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r0 = sSoSourcesLock;
        r0.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r3 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r7 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        if (r2.contains(r10) == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        if (r12 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0054, code lost:
        r0.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005b, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005e, code lost:
        if (r3 != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0068, code lost:
        android.util.Log.d(TAG, "About to load: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x007e, code lost:
        doLoadLibraryBySoName(r10, r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0087, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0089, code lost:
        android.util.Log.d(TAG, "Loaded: " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009f, code lost:
        r14 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a1, code lost:
        monitor-enter(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r2.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a5, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00aa, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ab, code lost:
        r11 = r10.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00af, code lost:
        if (r11 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c8, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r10, r11.substring(r11.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00cd, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d2, code lost:
        if ((r13 & 16) != 0) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00d8, code lost:
        if (android.text.TextUtils.isEmpty(r11) != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00e0, code lost:
        if (sLoadedAndMergedLibraries.contains(r11) == false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e2, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e3, code lost:
        if (r12 == null) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00e5, code lost:
        if (r1 != false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00e7, code lost:
        r12 = SYSTRACE_LIBRARY_LOADING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00e9, code lost:
        if (r12 == false) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00eb, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r11, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00f8, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x00fa, code lost:
        android.util.Log.d(TAG, "About to merge: " + r11 + " / " + r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0118, code lost:
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r11);
        sLoadedAndMergedLibraries.add(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0120, code lost:
        if (r12 == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0126, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0128, code lost:
        r12 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, android.os.StrictMode.ThreadPolicy r14) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 != 0) goto L_0x0010
            java.util.Set<java.lang.String> r0 = sLoadedAndMergedLibraries
            boolean r0 = r0.contains(r11)
            if (r0 == 0) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.Class<com.facebook.soloader.SoLoader> r0 = com.facebook.soloader.SoLoader.class
            monitor-enter(r0)
            java.util.HashSet<java.lang.String> r2 = sLoadedLibraries     // Catch:{ all -> 0x016d }
            boolean r3 = r2.contains(r10)     // Catch:{ all -> 0x016d }
            r4 = 1
            if (r3 == 0) goto L_0x0022
            if (r12 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x016d }
            return r1
        L_0x0020:
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            java.util.Map<java.lang.String, java.lang.Object> r5 = sLoadingLibraries     // Catch:{ all -> 0x016d }
            boolean r6 = r5.containsKey(r10)     // Catch:{ all -> 0x016d }
            if (r6 == 0) goto L_0x0030
            java.lang.Object r5 = r5.get(r10)     // Catch:{ all -> 0x016d }
            goto L_0x0039
        L_0x0030:
            java.lang.Object r6 = new java.lang.Object     // Catch:{ all -> 0x016d }
            r6.<init>()     // Catch:{ all -> 0x016d }
            r5.put(r10, r6)     // Catch:{ all -> 0x016d }
            r5 = r6
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x016d }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r0.readLock()
            r6.lock()
            monitor-enter(r5)     // Catch:{ all -> 0x0162 }
            r6 = 3
            if (r3 != 0) goto L_0x00d0
            java.lang.Class<com.facebook.soloader.SoLoader> r7 = com.facebook.soloader.SoLoader.class
            monitor-enter(r7)     // Catch:{ all -> 0x00cd }
            boolean r8 = r2.contains(r10)     // Catch:{ all -> 0x00ca }
            if (r8 == 0) goto L_0x005d
            if (r12 != 0) goto L_0x005c
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            monitor-exit(r5)     // Catch:{ all -> 0x00cd }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r0.readLock()
            r10.unlock()
            return r1
        L_0x005c:
            r3 = 1
        L_0x005d:
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x00d0
            java.lang.String r7 = "SoLoader"
            boolean r7 = android.util.Log.isLoggable(r7, r6)     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            if (r7 == 0) goto L_0x007e
            java.lang.String r7 = "SoLoader"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            r8.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            java.lang.String r9 = "About to load: "
            r8.append(r9)     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            r8.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            java.lang.String r8 = r8.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            android.util.Log.d(r7, r8)     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
        L_0x007e:
            doLoadLibraryBySoName(r10, r13, r14)     // Catch:{ UnsatisfiedLinkError -> 0x00aa }
            java.lang.String r14 = "SoLoader"
            boolean r14 = android.util.Log.isLoggable(r14, r6)     // Catch:{ all -> 0x00cd }
            if (r14 == 0) goto L_0x009f
            java.lang.String r14 = "SoLoader"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r7.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.String r8 = "Loaded: "
            r7.append(r8)     // Catch:{ all -> 0x00cd }
            r7.append(r10)     // Catch:{ all -> 0x00cd }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00cd }
            android.util.Log.d(r14, r7)     // Catch:{ all -> 0x00cd }
        L_0x009f:
            java.lang.Class<com.facebook.soloader.SoLoader> r14 = com.facebook.soloader.SoLoader.class
            monitor-enter(r14)     // Catch:{ all -> 0x00cd }
            r2.add(r10)     // Catch:{ all -> 0x00a7 }
            monitor-exit(r14)     // Catch:{ all -> 0x00a7 }
            goto L_0x00d0
        L_0x00a7:
            r10 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00a7 }
            throw r10     // Catch:{ all -> 0x00cd }
        L_0x00aa:
            r10 = move-exception
            java.lang.String r11 = r10.getMessage()     // Catch:{ all -> 0x00cd }
            if (r11 == 0) goto L_0x00c9
            java.lang.String r12 = "unexpected e_machine:"
            boolean r12 = r11.contains(r12)     // Catch:{ all -> 0x00cd }
            if (r12 == 0) goto L_0x00c9
            java.lang.String r12 = "unexpected e_machine:"
            int r12 = r11.lastIndexOf(r12)     // Catch:{ all -> 0x00cd }
            java.lang.String r11 = r11.substring(r12)     // Catch:{ all -> 0x00cd }
            com.facebook.soloader.SoLoader$WrongAbiError r12 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x00cd }
            r12.<init>(r10, r11)     // Catch:{ all -> 0x00cd }
            throw r12     // Catch:{ all -> 0x00cd }
        L_0x00c9:
            throw r10     // Catch:{ all -> 0x00cd }
        L_0x00ca:
            r10 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00ca }
            throw r10     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r10 = move-exception
            goto L_0x0160
        L_0x00d0:
            r13 = r13 & 16
            if (r13 != 0) goto L_0x0155
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00cd }
            if (r13 != 0) goto L_0x00e3
            java.util.Set<java.lang.String> r13 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x00cd }
            boolean r13 = r13.contains(r11)     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x00e3
            r1 = 1
        L_0x00e3:
            if (r12 == 0) goto L_0x0155
            if (r1 != 0) goto L_0x0155
            boolean r12 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00cd }
            if (r12 == 0) goto L_0x00f2
            java.lang.String r13 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r14 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r13, r11, r14)     // Catch:{ all -> 0x00cd }
        L_0x00f2:
            java.lang.String r13 = "SoLoader"
            boolean r13 = android.util.Log.isLoggable(r13, r6)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            if (r13 == 0) goto L_0x0118
            java.lang.String r13 = "SoLoader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            r14.<init>()     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            java.lang.String r1 = "About to merge: "
            r14.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            r14.append(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            java.lang.String r1 = " / "
            r14.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            r14.append(r10)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            java.lang.String r14 = r14.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            android.util.Log.d(r13, r14)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
        L_0x0118:
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            java.util.Set<java.lang.String> r13 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            r13.add(r11)     // Catch:{ UnsatisfiedLinkError -> 0x0128 }
            if (r12 == 0) goto L_0x0155
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00cd }
            goto L_0x0155
        L_0x0126:
            r10 = move-exception
            goto L_0x014d
        L_0x0128:
            r12 = move-exception
            java.lang.RuntimeException r13 = new java.lang.RuntimeException     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r14.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r0 = "Failed to call JNI_OnLoad from '"
            r14.append(r0)     // Catch:{ all -> 0x0126 }
            r14.append(r11)     // Catch:{ all -> 0x0126 }
            java.lang.String r11 = "', which has been merged into '"
            r14.append(r11)     // Catch:{ all -> 0x0126 }
            r14.append(r10)     // Catch:{ all -> 0x0126 }
            java.lang.String r10 = "'.  See comment for details."
            r14.append(r10)     // Catch:{ all -> 0x0126 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x0126 }
            r13.<init>(r10, r12)     // Catch:{ all -> 0x0126 }
            throw r13     // Catch:{ all -> 0x0126 }
        L_0x014d:
            boolean r11 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00cd }
            if (r11 == 0) goto L_0x0154
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00cd }
        L_0x0154:
            throw r10     // Catch:{ all -> 0x00cd }
        L_0x0155:
            monitor-exit(r5)     // Catch:{ all -> 0x00cd }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r0.readLock()
            r10.unlock()
            r10 = r3 ^ 1
            return r10
        L_0x0160:
            monitor-exit(r5)     // Catch:{ all -> 0x00cd }
            throw r10     // Catch:{ all -> 0x0162 }
        L_0x0162:
            r10 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r11 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r11 = r11.readLock()
            r11.unlock()
            throw r10
        L_0x016d:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016d }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    private static Boolean loadLibraryOnNonAndroid(String str) {
        Boolean valueOf;
        if (sSoSources != null) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        boolean z2 = !sLoadedLibraries.contains(str);
                        if (z2) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper != null) {
                                systemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                        valueOf = Boolean.valueOf(z2);
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return valueOf;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(":", arrayList);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "makeLdLibraryPath final path: " + join);
            }
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    private static int makePrepareFlags() {
        int i2;
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if ((sFlags & 2) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            reentrantReadWriteLock.writeLock().unlock();
            return i2;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = sSoSources;
            SoSource[] soSourceArr2 = new SoSource[(soSourceArr.length + 1)];
            soSourceArr2[0] = soSource;
            System.arraycopy(soSourceArr, 0, soSourceArr2, 1, soSourceArr.length);
            sSoSources = soSourceArr2;
            sSoSourcesVersion.getAndIncrement();
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Prepended to SO sources: " + soSource);
            }
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean useDepsFile(Context context, String str) throws IOException {
        return NativeDeps.useDepsFile(SysUtil.makeApkDepBlock(new File(context.getApplicationInfo().sourceDir), context), str);
    }

    public static void init(Context context, int i2, SoFileLoader soFileLoader) throws IOException {
        init(context, i2, soFileLoader, DEFAULT_DENY_LIST);
    }

    public static boolean loadLibrary(String str, int i2) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        Boolean loadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (loadLibraryOnNonAndroid != null) {
            return loadLibraryOnNonAndroid.booleanValue();
        }
        int i3 = sAppType;
        if ((i3 == 2 || i3 == 3) && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        }
        String mapLibName = MergedSoMapping.mapLibName(str);
        return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i2, (StrictMode.ThreadPolicy) null);
    }

    private static boolean loadLibraryBySoName(String str, String str2, String str3, int i2, StrictMode.ThreadPolicy threadPolicy) {
        boolean z2;
        boolean z3 = false;
        do {
            try {
                z3 = loadLibraryBySoNameImpl(str, str2, str3, i2, threadPolicy);
                z2 = false;
                continue;
            } catch (UnsatisfiedLinkError e2) {
                int i3 = sSoSourcesVersion.get();
                sSoSourcesLock.writeLock().lock();
                try {
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        z2 = false;
                    } else {
                        Log.w(TAG, "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                        sSoSourcesVersion.getAndIncrement();
                        z2 = true;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion.get() == i3) {
                        throw e2;
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z2);
        return z3;
    }

    public static void init(Context context, int i2, SoFileLoader soFileLoader, String[] strArr) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            if (SysUtil.isDisabledExtractNativeLibs(context)) {
                i2 |= 8;
            }
            sAppType = getAppType(context, i2);
            initSoLoader(soFileLoader);
            initSoSources(context, i2, strArr);
            NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void init(Context context, boolean z2) {
        try {
            init(context, z2 ? 1 : 0, (SoFileLoader) null, DEFAULT_DENY_LIST);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
