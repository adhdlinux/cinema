package com.chartboost.sdk.internal.Libraries;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.chartboost.sdk.impl.a9;
import com.chartboost.sdk.impl.pa;
import com.chartboost.sdk.impl.w7;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class CBUtility {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19140a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.chartboost.sdk.impl.a9[] r0 = com.chartboost.sdk.impl.a9.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19140a = r0
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.LANDSCAPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.LANDSCAPE_REVERSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.LANDSCAPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.LANDSCAPE_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.PORTRAIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.PORTRAIT_REVERSE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.PORTRAIT_LEFT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f19140a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.chartboost.sdk.impl.a9 r1 = com.chartboost.sdk.impl.a9.PORTRAIT_RIGHT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.Libraries.CBUtility.a.<clinit>():void");
        }
    }

    public static a9 a(Context context) {
        if (context == null) {
            return a9.PORTRAIT;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return a9.PORTRAIT;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay == null) {
            return a9.PORTRAIT;
        }
        int rotation = defaultDisplay.getRotation();
        boolean z2 = defaultDisplay.getWidth() != defaultDisplay.getHeight() ? defaultDisplay.getWidth() < defaultDisplay.getHeight() : context.getResources().getConfiguration().orientation != 2;
        if (!(rotation == 0 || rotation == 2)) {
            z2 = !z2;
        }
        if (z2) {
            if (rotation == 1) {
                return a9.LANDSCAPE_LEFT;
            }
            if (rotation == 2) {
                return a9.PORTRAIT_REVERSE;
            }
            if (rotation != 3) {
                return a9.PORTRAIT;
            }
            return a9.LANDSCAPE_RIGHT;
        } else if (rotation == 1) {
            return a9.PORTRAIT_LEFT;
        } else {
            if (rotation == 2) {
                return a9.LANDSCAPE_REVERSE;
            }
            if (rotation != 3) {
                return a9.LANDSCAPE;
            }
            return a9.PORTRAIT_RIGHT;
        }
    }

    public static String b(Context context) {
        switch (a.f19140a[a(context).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return "landscape";
            case 5:
            case 6:
            case 7:
            case 8:
                return "portrait";
            default:
                return "unknown";
        }
    }

    public static void throwProguardError(Exception exc) {
        if (exc instanceof NoSuchMethodException) {
            w7.b("CBUtility", "Chartboost library error! Have you used proguard on your application? Make sure to add the line '-keep class com.chartboost.sdk.** { *; }' to your proguard config file.");
        } else if (exc == null || exc.getMessage() == null) {
            w7.b("CBUtility", "Unknown Proguard error");
        } else {
            w7.b("CBUtility", exc.getMessage());
        }
    }

    public static String b() {
        return String.format("%s %s %s", new Object[]{"Chartboost-Android-SDK", "", "9.7.0"});
    }

    public static void b(Activity activity, pa paVar) {
        if (activity != null && !a(activity) && paVar.f18373q && paVar.f18377u) {
            activity.setRequestedOrientation(-1);
        }
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ZZZZ", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date());
    }

    public static void a(Activity activity, pa paVar) {
        if (activity != null && !a(activity) && paVar.f18373q && paVar.f18377u) {
            a9 a2 = a((Context) activity);
            if (a2 == a9.PORTRAIT || a2 == a9.PORTRAIT_RIGHT) {
                activity.setRequestedOrientation(1);
            } else if (a2 == a9.PORTRAIT_REVERSE || a2 == a9.PORTRAIT_LEFT) {
                activity.setRequestedOrientation(9);
            } else if (a2 == a9.LANDSCAPE || a2 == a9.LANDSCAPE_LEFT) {
                activity.setRequestedOrientation(0);
            } else {
                activity.setRequestedOrientation(8);
            }
        }
    }

    public static boolean a(a9 a9Var) {
        return a9Var == a9.PORTRAIT || a9Var == a9.PORTRAIT_REVERSE || a9Var == a9.PORTRAIT_LEFT || a9Var == a9.PORTRAIT_RIGHT;
    }

    public static ArrayList a(File file, boolean z2) {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && !file2.getName().equals(".nomedia")) {
                    arrayList.add(file2);
                } else if (file2.isDirectory() && z2) {
                    arrayList.addAll(a(file2, z2));
                }
            }
        }
        return arrayList;
    }

    public static boolean a(Activity activity) {
        if (activity == null || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getBackground() == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || activity.getWindow().getDecorView().getBackground().getAlpha() == 255) {
            return false;
        }
        return true;
    }
}
