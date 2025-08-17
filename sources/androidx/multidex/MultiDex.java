package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public final class MultiDex {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<File> f10745a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f10746b = n(System.getProperty("java.vm.version"));

    private static final class V19 {
        private V19() {
        }

        static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it2.next());
                }
                Field a2 = MultiDex.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a2.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Class<ArrayList> cls = ArrayList.class;
            return (Object[]) MultiDex.h(obj, "makeDexElements", cls, File.class, cls).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private MultiDex() {
    }

    private static void d(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:39|40|41|42|43) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void e(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = f10745a
            monitor-enter(r0)
            boolean r1 = r0.contains(r6)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x000b:
            r0.add(r6)     // Catch:{ all -> 0x0096 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r3.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x0096 }
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = ": SDK version higher than "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            r1 = 20
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = " should be backed by "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "case here: java.vm.version=\""
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{ all -> 0x0096 }
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "\""
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0096 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x0096 }
            java.lang.ClassLoader r1 = j(r5)     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0055
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x0055:
            d(r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r2 = move-exception
            java.lang.String r3 = "MultiDex"
            java.lang.String r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r3, r4, r2)     // Catch:{ all -> 0x0096 }
        L_0x0061:
            java.io.File r7 = k(r5, r7, r8)     // Catch:{ all -> 0x0096 }
            androidx.multidex.MultiDexExtractor r8 = new androidx.multidex.MultiDexExtractor     // Catch:{ all -> 0x0096 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0096 }
            r6 = 0
            java.util.List r6 = r8.z(r5, r9, r6)     // Catch:{ all -> 0x0091 }
            m(r1, r7, r6)     // Catch:{ IOException -> 0x0073 }
            goto L_0x0085
        L_0x0073:
            r6 = move-exception
            if (r10 == 0) goto L_0x0090
            java.lang.String r10 = "MultiDex"
            java.lang.String r2 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r10, r2, r6)     // Catch:{ all -> 0x0091 }
            r6 = 1
            java.util.List r5 = r8.z(r5, r9, r6)     // Catch:{ all -> 0x0091 }
            m(r1, r7, r5)     // Catch:{ all -> 0x0091 }
        L_0x0085:
            r8.close()     // Catch:{ IOException -> 0x008a }
            r5 = 0
            goto L_0x008b
        L_0x008a:
            r5 = move-exception
        L_0x008b:
            if (r5 != 0) goto L_0x008f
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0096 }
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0095:
            throw r5     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.e(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* access modifiers changed from: private */
    public static void f(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field g2 = g(obj, str);
        Object[] objArr2 = (Object[]) g2.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g2.set(obj, objArr3);
    }

    /* access modifiers changed from: private */
    public static Field g(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    public static Method h(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e2) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e2);
            return null;
        }
    }

    private static File k(Context context, File file, String str) throws IOException {
        File file2 = new File(file, "code_cache");
        try {
            o(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            o(file2);
        }
        File file3 = new File(file2, str);
        o(file3);
        return file3;
    }

    public static void l(Context context) {
        Log.i("MultiDex", "Installing application");
        if (f10746b) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            ApplicationInfo i2 = i(context);
            if (i2 == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            e(context, new File(i2.sourceDir), new File(i2.dataDir), "secondary-dexes", "", true);
            Log.i("MultiDex", "install done");
        } catch (Exception e2) {
            Log.e("MultiDex", "MultiDex installation failure", e2);
            throw new RuntimeException("MultiDex installation failed (" + e2.getMessage() + ").");
        }
    }

    private static void m(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (!list.isEmpty()) {
            V19.a(classLoader, list, file);
        }
    }

    static boolean n(String str) {
        String str2;
        String str3;
        boolean z2 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            String str4 = null;
            if (stringTokenizer.hasMoreTokens()) {
                str3 = stringTokenizer.nextToken();
            } else {
                str3 = null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                str4 = stringTokenizer.nextToken();
            }
            if (!(str3 == null || str4 == null)) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    int parseInt2 = Integer.parseInt(str4);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z2 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        if (z2) {
            str2 = " has multidex support";
        } else {
            str2 = " does not have multidex support";
        }
        sb.append(str2);
        Log.i("MultiDex", sb.toString());
        return z2;
    }

    private static void o(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}
