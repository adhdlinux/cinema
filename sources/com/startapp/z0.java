package com.startapp;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.google.protobuf.CodedOutputStream;
import com.startapp.networkTest.enums.IdleStates;
import com.startapp.networkTest.enums.MemoryStates;
import com.startapp.networkTest.enums.MultiSimVariants;
import com.startapp.networkTest.enums.Os;
import com.startapp.networkTest.enums.PhoneTypes;
import com.startapp.networkTest.enums.ScreenStates;
import com.startapp.networkTest.enums.SimStates;
import com.startapp.networkTest.enums.ThreeState;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36977a = "z0";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f36978b = false;

    private static o1 a(Context context) {
        o1 o1Var = new o1();
        o1Var.MissingPermission = true;
        return o1Var;
    }

    public static f1 b(Context context) {
        String[] strArr;
        f1 f1Var = new f1();
        f1Var.DeviceManufacturer = Build.MANUFACTURER;
        f1Var.DeviceName = Build.MODEL;
        f1Var.OS = Os.Android;
        f1Var.OSVersion = Build.VERSION.RELEASE;
        f1Var.BuildFingerprint = Build.FINGERPRINT;
        f1Var.DeviceUpTime = SystemClock.elapsedRealtime();
        f1Var.UserLocal = Locale.getDefault().toString();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            f1Var.SimOperator = f3.a(telephonyManager.getSimOperator());
            f1Var.SimOperatorName = f3.a(telephonyManager.getSimOperatorName());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                String a2 = telephonyManager.getTypeAllocationCode();
                if (a2 == null || a2.isEmpty()) {
                    String a3 = telephonyManager.getManufacturerCode();
                    if (a3 != null && !a3.isEmpty()) {
                        f1Var.TAC = a3;
                    }
                } else {
                    f1Var.TAC = a2;
                }
            }
            SimStates simStates = SimStates.Unknown;
            int simState = telephonyManager.getSimState();
            if (simState == 1) {
                simStates = SimStates.Absent;
            } else if (simState == 2) {
                simStates = SimStates.PinRequired;
            } else if (simState == 3) {
                simStates = SimStates.PukRequired;
            } else if (simState == 4) {
                simStates = SimStates.NetworkLocked;
            } else if (simState == 5) {
                simStates = SimStates.Ready;
            }
            f1Var.SimState = simStates;
            if (i2 >= 23) {
                try {
                    f1Var.PhoneCount = ((Integer) telephonyManager.getClass().getDeclaredMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
                } catch (Throwable th) {
                    l2.b(th);
                }
            }
            PhoneTypes phoneTypes = PhoneTypes.Unknown;
            int phoneType = telephonyManager.getPhoneType();
            if (phoneType == 0) {
                phoneTypes = PhoneTypes.None;
            } else if (phoneType == 1) {
                phoneTypes = PhoneTypes.GSM;
            } else if (phoneType == 2) {
                phoneTypes = PhoneTypes.CDMA;
            } else if (phoneType == 3) {
                phoneTypes = PhoneTypes.SIP;
            }
            f1Var.PhoneType = phoneTypes;
        }
        f1Var.IsRooted = a();
        if (Build.VERSION.SDK_INT <= 24) {
            strArr = d3.a("/proc/version");
        } else {
            strArr = d3.b("uname -a");
        }
        if (strArr.length > 0) {
            f1Var.OsSystemVersion = f3.a(strArr[0]);
        }
        f1Var.BluetoothInfo = a(context);
        f1Var.PowerSaveMode = g(context);
        f1Var.MultiSimInfo = f(context);
        f1Var.HostAppInfo = c(context);
        return f1Var;
    }

    private static p1 c(Context context) {
        int i2;
        p1 p1Var = new p1();
        p1Var.AppPackageName = context.getPackageName();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            } catch (Throwable th) {
                l2.b(th);
            }
        }
        if (applicationInfo != null) {
            p1Var.AppTargetVersion = applicationInfo.targetSdkVersion;
            p1Var.AppName = (String) applicationInfo.loadLabel(context.getPackageManager());
            if (Build.VERSION.SDK_INT >= 26) {
                p1Var.AppCategory = t2.a(applicationInfo.category);
            }
        }
        ArrayList<m1> arrayList = new ArrayList<>();
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).requestedPermissions) {
                m1 m1Var = new m1();
                m1Var.Permission = str.toLowerCase();
                if (str.equalsIgnoreCase("android.permission.PACKAGE_USAGE_STATS")) {
                    m1Var.IsGranted = t2.b(context) ? 1 : 0;
                } else {
                    if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    m1Var.IsGranted = i2;
                }
                arrayList.add(m1Var);
            }
        } catch (Throwable th2) {
            p1Var.AppPermissions = arrayList;
            throw th2;
        }
        p1Var.AppPermissions = arrayList;
        return p1Var;
    }

    public static IdleStates d(Context context) {
        PowerManager powerManager;
        IdleStates idleStates = IdleStates.Unknown;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
            if (i2 >= 24) {
                try {
                    if (((Boolean) powerManager.getClass().getDeclaredMethod("isLightDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue()) {
                        idleStates = IdleStates.LightIdle;
                    }
                } catch (Throwable th) {
                    l2.b(th);
                }
            }
            if (idleStates != IdleStates.LightIdle) {
                if (powerManager.isDeviceIdleMode()) {
                    return IdleStates.DeepIdle;
                }
                return IdleStates.NonIdle;
            }
        }
        return idleStates;
    }

    @SuppressLint({"NewApi"})
    public static h1 e(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        h1 h1Var = new h1();
        long j2 = memoryInfo.availMem;
        h1Var.MemoryFree = j2;
        long j3 = memoryInfo.totalMem;
        h1Var.MemoryTotal = j3;
        h1Var.MemoryUsed = j3 - j2;
        if (memoryInfo.lowMemory) {
            h1Var.MemoryState = MemoryStates.Low;
        } else {
            h1Var.MemoryState = MemoryStates.Normal;
        }
        return h1Var;
    }

    public static q1 f(Context context) {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        SimStates simStates;
        Method method5;
        Method method6;
        Method method7;
        Method method8;
        int i2;
        int i3;
        boolean z2;
        q1 q1Var = new q1();
        if (Build.VERSION.SDK_INT >= 22 && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            char c2 = 65535;
            if (subscriptionManager != null) {
                q1Var.ActiveSimCount = subscriptionManager.getActiveSubscriptionInfoCount();
                q1Var.ActiveSimCountMax = subscriptionManager.getActiveSubscriptionInfoCountMax();
                List<SubscriptionInfo> a2 = subscriptionManager.getActiveSubscriptionInfoList();
                if (a2 != null && a2.size() > 0) {
                    r1[] r1VarArr = new r1[a2.size()];
                    int i4 = 0;
                    for (SubscriptionInfo subscriptionInfo : a2) {
                        r1 r1Var = new r1();
                        try {
                            if (subscriptionInfo.getCarrierName() != null) {
                                r1Var.CarrierName = f3.a(subscriptionInfo.getCarrierName().toString());
                            }
                        } catch (Throwable th) {
                            l2.b(th);
                        }
                        try {
                            if (subscriptionInfo.getCountryIso() != null) {
                                r1Var.CountryIso = f3.a(subscriptionInfo.getCountryIso());
                            }
                        } catch (Throwable th2) {
                            l2.b(th2);
                        }
                        try {
                            if (subscriptionInfo.getIccId() != null) {
                                r1Var.IccId = a(f3.a(subscriptionInfo.getIccId()));
                            }
                        } catch (Throwable th3) {
                            l2.b(th3);
                        }
                        if (subscriptionInfo.getMcc() == Integer.MAX_VALUE) {
                            i2 = -1;
                        } else {
                            i2 = subscriptionInfo.getMcc();
                        }
                        r1Var.Mcc = i2;
                        if (subscriptionInfo.getMnc() == Integer.MAX_VALUE) {
                            i3 = -1;
                        } else {
                            i3 = subscriptionInfo.getMnc();
                        }
                        r1Var.Mnc = i3;
                        r1Var.SimSlotIndex = subscriptionInfo.getSimSlotIndex();
                        r1Var.SubscriptionId = subscriptionInfo.getSubscriptionId();
                        if (subscriptionInfo.getDataRoaming() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        r1Var.DataRoaming = z2;
                        a(context, r1Var.SubscriptionId, r1Var);
                        r1VarArr[i4] = r1Var;
                        i4++;
                    }
                    q1Var.SimInfos = new ArrayList<>(Arrays.asList(r1VarArr));
                }
                try {
                    method5 = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e2) {
                    l2.b(e2);
                    method5 = null;
                }
                if (method5 == null) {
                    try {
                        method5 = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        l2.b(e3);
                    }
                }
                if (method5 != null) {
                    try {
                        q1Var.DefaultDataSimId = ((Integer) method5.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Throwable th4) {
                        l2.a(th4);
                    }
                }
                try {
                    method6 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e4) {
                    l2.b(e4);
                    method6 = null;
                }
                if (method6 == null) {
                    try {
                        method6 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubId", new Class[0]);
                    } catch (NoSuchMethodException e5) {
                        l2.b(e5);
                    }
                }
                if (method6 != null) {
                    try {
                        q1Var.DefaultSmsSimId = ((Integer) method6.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Throwable th5) {
                        l2.a(th5);
                    }
                }
                try {
                    method7 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e6) {
                    l2.b(e6);
                    method7 = null;
                }
                if (method7 == null) {
                    try {
                        method7 = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubId", new Class[0]);
                    } catch (NoSuchMethodException e7) {
                        l2.b(e7);
                    }
                }
                if (method7 != null) {
                    try {
                        q1Var.DefaultSimId = ((Integer) method7.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Throwable th6) {
                        l2.a(th6);
                    }
                }
                try {
                    method8 = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubscriptionId", new Class[0]);
                } catch (NoSuchMethodException e8) {
                    l2.b(e8);
                    method8 = null;
                }
                if (method8 == null) {
                    try {
                        method8 = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubId", new Class[0]);
                    } catch (NoSuchMethodException e9) {
                        l2.b(e9);
                    }
                }
                if (method8 != null) {
                    try {
                        q1Var.DefaultVoiceSimId = ((Integer) method8.invoke(subscriptionManager, new Object[0])).intValue();
                    } catch (Throwable th7) {
                        l2.a(th7);
                    }
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    method = telephonyManager.getClass().getDeclaredMethod("getMultiSimConfiguration", new Class[0]);
                } catch (NoSuchMethodException e10) {
                    l2.b(e10);
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(telephonyManager, new Object[0]);
                        if (invoke instanceof Enum) {
                            String obj = invoke.toString();
                            int hashCode = obj.hashCode();
                            if (hashCode != 2107724) {
                                if (hashCode != 2107742) {
                                    if (hashCode == 2584894) {
                                        if (obj.equals("TSTS")) {
                                            c2 = 2;
                                        }
                                    }
                                } else if (obj.equals("DSDS")) {
                                    c2 = 1;
                                }
                            } else if (obj.equals("DSDA")) {
                                c2 = 0;
                            }
                            if (c2 == 0) {
                                q1Var.MultiSimVariant = MultiSimVariants.DSDA;
                            } else if (c2 == 1) {
                                q1Var.MultiSimVariant = MultiSimVariants.DSDS;
                            } else if (c2 != 2) {
                                q1Var.MultiSimVariant = MultiSimVariants.Unknown;
                            } else {
                                q1Var.MultiSimVariant = MultiSimVariants.TSTS;
                            }
                        }
                    } catch (Throwable th8) {
                        l2.a(th8);
                    }
                }
                Iterator<r1> it2 = q1Var.SimInfos.iterator();
                while (it2.hasNext()) {
                    r1 next = it2.next();
                    try {
                        method2 = telephonyManager.getClass().getDeclaredMethod("getSimState", new Class[]{Integer.TYPE});
                    } catch (NoSuchMethodException e11) {
                        l2.b(e11);
                        method2 = null;
                    }
                    if (method2 != null) {
                        try {
                            switch (((Integer) method2.invoke(telephonyManager, new Object[]{Integer.valueOf(next.SimSlotIndex)})).intValue()) {
                                case 1:
                                    simStates = SimStates.Absent;
                                    break;
                                case 2:
                                    simStates = SimStates.PinRequired;
                                    break;
                                case 3:
                                    simStates = SimStates.PukRequired;
                                    break;
                                case 4:
                                    simStates = SimStates.NetworkLocked;
                                    break;
                                case 5:
                                    simStates = SimStates.Ready;
                                    break;
                                case 6:
                                    simStates = SimStates.NotReady;
                                    break;
                                case 7:
                                    simStates = SimStates.PermanentlyDisabled;
                                    break;
                                case 8:
                                    simStates = SimStates.CardIoError;
                                    break;
                                case 9:
                                    simStates = SimStates.CardRestricted;
                                    break;
                                default:
                                    simStates = SimStates.Unknown;
                                    break;
                            }
                            next.SimState = simStates;
                        } catch (Throwable th9) {
                            l2.a(th9);
                        }
                    }
                    try {
                        method3 = telephonyManager.getClass().getDeclaredMethod("getSubscriberId", new Class[]{Integer.TYPE});
                    } catch (NoSuchMethodException e12) {
                        l2.b(e12);
                        method3 = null;
                    }
                    if (method3 != null) {
                        try {
                            next.IMSI = b(f3.a((String) method3.invoke(telephonyManager, new Object[]{Integer.valueOf(next.SubscriptionId)})));
                        } catch (Throwable th10) {
                            l2.a(th10);
                        }
                    }
                    try {
                        method4 = telephonyManager.getClass().getDeclaredMethod("getGroupIdLevel1", new Class[]{Integer.TYPE});
                    } catch (NoSuchMethodException e13) {
                        l2.b(e13);
                        method4 = null;
                    }
                    if (method4 != null) {
                        try {
                            next.GroupIdentifierLevel1 = f3.a((String) method4.invoke(telephonyManager, new Object[]{Integer.valueOf(next.SubscriptionId)}));
                        } catch (Throwable th11) {
                            l2.a(th11);
                        }
                    }
                }
            }
        }
        return q1Var;
    }

    private static ThreeState g(Context context) {
        try {
            String string = Settings.System.getString(context.getContentResolver(), "user_powersaver_enable");
            if (string == null) {
                int i2 = Build.VERSION.SDK_INT;
                if (Build.MANUFACTURER.toLowerCase().startsWith("sony") && i2 < 23) {
                    return ThreeState.Unknown;
                }
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    if (powerManager.isPowerSaveMode()) {
                        return ThreeState.Enabled;
                    }
                    return ThreeState.Disabled;
                }
                return ThreeState.Unknown;
            } else if (string.equals("1")) {
                return ThreeState.Enabled;
            } else {
                return ThreeState.Disabled;
            }
        } catch (Throwable th) {
            l2.a(th);
        }
    }

    public static ScreenStates h(Context context) {
        ScreenStates screenStates = ScreenStates.Unknown;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return screenStates;
        }
        if (powerManager.isScreenOn()) {
            return ScreenStates.On;
        }
        return ScreenStates.Off;
    }

    public static r1 i(Context context) {
        return f(context).getDefaultDataSimInfo();
    }

    public static r1 j(Context context) {
        return f(context).getDefaultVoiceSimInfo();
    }

    public static k1 k(Context context) {
        k1 k1Var = new k1();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        k1Var.StorageInternalSize = ((long) statFs.getBlockCount()) * blockSize;
        k1Var.StorageInternalAvailable = blockSize * ((long) statFs.getAvailableBlocks());
        k1Var.StorageInternalAudio = a(context, MediaStore.Audio.Media.INTERNAL_CONTENT_URI);
        k1Var.StorageInternalImages = a(context, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        k1Var.StorageInternalVideo = a(context, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        if (b()) {
            try {
                StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize2 = (long) statFs2.getBlockSize();
                k1Var.StorageExternalSize = ((long) statFs2.getBlockCount()) * blockSize2;
                k1Var.StorageExternalAvailable = blockSize2 * ((long) statFs2.getAvailableBlocks());
            } catch (IllegalArgumentException unused) {
                k1Var.StorageExternalSize = -1;
                k1Var.StorageExternalAvailable = -1;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                k1Var.StorageExternalAudio = a(context, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                k1Var.StorageExternalImages = a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                k1Var.StorageExternalVideo = a(context, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            }
        }
        return k1Var;
    }

    private static boolean a() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static long a(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_size"}, (String) null, (String[]) null, (String) null);
            long j2 = 0;
            if (cursor != null) {
                if (cursor.getCount() == 0) {
                    cursor.close();
                    return 0;
                }
                while (cursor.moveToNext()) {
                    j2 += cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return j2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static l1 a(b1 b1Var) {
        l1 l1Var = new l1();
        l1Var.MobileRxBytes = g3.e();
        l1Var.MobileTxBytes = g3.f();
        l1Var.TotalRxBytes = TrafficStats.getTotalRxBytes();
        l1Var.TotalTxBytes = TrafficStats.getTotalTxBytes();
        if (b1Var != null) {
            l1Var.WifiRxBytes = b1Var.d();
            l1Var.WifiTxBytes = b1Var.e();
        } else {
            l1Var.WifiRxBytes = -1;
            l1Var.WifiTxBytes = -1;
        }
        return l1Var;
    }

    public static r1 a(int i2, Context context) {
        return f(context).getSimInfoSubId(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A[SYNTHETIC, Splitter:B:16:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A[SYNTHETIC, Splitter:B:22:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r9, int r10, com.startapp.r1 r11) {
        /*
            java.lang.String r0 = "type"
            java.lang.String r1 = "apn"
            r2 = -1
            if (r10 == r2) goto L_0x0019
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "content://telephony/carriers/preferapn/subId/"
            r2.append(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            goto L_0x001b
        L_0x0019:
            java.lang.String r10 = "content://telephony/carriers/preferapn"
        L_0x001b:
            r2 = 0
            android.net.Uri r4 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x0059 }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ all -> 0x0059 }
            java.lang.String[] r5 = new java.lang.String[]{r1, r0}     // Catch:{ all -> 0x0059 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0059 }
            if (r9 == 0) goto L_0x0052
            boolean r10 = r9.moveToFirst()     // Catch:{ all -> 0x004f }
            if (r10 == 0) goto L_0x0052
            int r10 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x004f }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x004f }
            int r0 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ all -> 0x004f }
            r11.Apn = r10     // Catch:{ all -> 0x004f }
            r11.ApnTypes = r0     // Catch:{ all -> 0x004f }
            r9.close()     // Catch:{ all -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r10 = move-exception
            r2 = r9
            goto L_0x005a
        L_0x0052:
            r2 = r9
        L_0x0053:
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0059:
            r10 = move-exception
        L_0x005a:
            com.startapp.l2.a((java.lang.Throwable) r10)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0067
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r9 = move-exception
            com.startapp.l2.b(r9)
        L_0x0067:
            return
        L_0x0068:
            r9 = move-exception
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ all -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r10 = move-exception
            com.startapp.l2.b(r10)
        L_0x0073:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.z0.a(android.content.Context, int, com.startapp.r1):void");
    }

    private static String a(String str) {
        int ordinal;
        if (str.length() == 0 || (ordinal = w0.b().SIMINFO_ICCID_RECORDTYPE().ordinal()) == 0) {
            return str;
        }
        if (ordinal != 1) {
            return "";
        }
        if (str.length() < 11) {
            return str.replaceAll("[\\d\\w]", "*");
        }
        String substring = str.substring(0, 7);
        String replaceAll = str.substring(7, str.length()).replaceAll("[\\d\\w]", "*");
        return substring + replaceAll;
    }

    private static boolean b() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            l2.a(th);
            return false;
        }
    }

    private static String b(String str) {
        int ordinal;
        if (str.length() == 0 || (ordinal = w0.b().SIMINFO_IMSI_RECORDTYPE().ordinal()) == 0) {
            return str;
        }
        if (ordinal != 1) {
            return "";
        }
        if (str.length() < 14) {
            return str.replaceAll("[\\d\\w]", "*");
        }
        String substring = str.substring(0, 10);
        String replaceAll = str.substring(10, str.length()).replaceAll("[\\d\\w]", "*");
        return substring + replaceAll;
    }
}
