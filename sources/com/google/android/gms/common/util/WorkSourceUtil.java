package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj = null;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ad  */
    static {
        /*
            java.lang.String r0 = "add"
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            int r2 = android.os.Process.myUid()
            zza = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r5[r3] = r6     // Catch:{ Exception -> 0x0018 }
            java.lang.reflect.Method r5 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r5 = r4
        L_0x001a:
            zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 2
            if (r5 == 0) goto L_0x0032
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0032 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0032 }
            r5[r3] = r8     // Catch:{ Exception -> 0x0032 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0032 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r0 = r4
        L_0x0033:
            zzc = r0
            java.lang.String r0 = "size"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x003e }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r0 = r4
        L_0x003f:
            zzd = r0
            java.lang.String r0 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x004e }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004e }
            r5[r3] = r8     // Catch:{ Exception -> 0x004e }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x004e }
            goto L_0x0050
        L_0x004e:
            r0 = r4
        L_0x0050:
            zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = "getName"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0065 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0065 }
            r5[r3] = r8     // Catch:{ Exception -> 0x0065 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0065 }
            goto L_0x0067
        L_0x0065:
        L_0x0066:
            r0 = r4
        L_0x0067:
            zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r5 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x0080
            java.lang.String r0 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x007a }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r8)     // Catch:{ Exception -> 0x007a }
            goto L_0x0081
        L_0x007a:
            r0 = move-exception
            java.lang.String r8 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r8, r0)
        L_0x0080:
            r0 = r4
        L_0x0081:
            zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00a4
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x009e }
            java.lang.String r8 = "addNode"
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x009e }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009e }
            r7[r3] = r9     // Catch:{ Exception -> 0x009e }
            r7[r2] = r6     // Catch:{ Exception -> 0x009e }
            java.lang.reflect.Method r0 = r0.getMethod(r8, r7)     // Catch:{ Exception -> 0x009e }
            goto L_0x00a5
        L_0x009e:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain class"
            android.util.Log.w(r5, r6, r0)
        L_0x00a4:
            r0 = r4
        L_0x00a5:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00b9
            java.lang.String r0 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00b9 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r3)     // Catch:{ Exception -> 0x00b9 }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00ba }
            goto L_0x00ba
        L_0x00b9:
            r0 = r4
        L_0x00ba:
            zzi = r0
            zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void add(WorkSource workSource, int i2, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i2), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    @KeepForSdk
    public static WorkSource fromPackage(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i2 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i2, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i2 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i2 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i2 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i2, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i3 = zza;
                if (i2 != i3) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i2), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i3), str2});
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e2);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int get(WorkSource workSource, int i2) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    @KeepForSdk
    public static String getName(WorkSource workSource, int i2) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @KeepForSdk
    public static List<String> getNames(WorkSource workSource) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i2 = 0;
        } else {
            i2 = size(workSource);
        }
        if (i2 != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                String name = getName(workSource, i3);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z2 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z2 = true;
            }
            Boolean valueOf = Boolean.valueOf(z2);
            zzj = valueOf;
            boolean booleanValue2 = valueOf.booleanValue();
            return booleanValue2;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e2) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e2);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }
}
