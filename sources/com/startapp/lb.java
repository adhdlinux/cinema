package com.startapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.ads.AudienceNetworkActivity;
import com.startapp.sdk.ads.banner.banner3d.Banner3DAd;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.nativead.NativeAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class lb {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Activity, Integer> f34876a = new WeakHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static volatile Intent f34877b;

    public interface a {
        void a(int i2, String str);

        void a(boolean z2, long j2, long j3, boolean z3);
    }

    public static class b {
        public static StackTraceElement[] a() {
            return Thread.currentThread().getStackTrace();
        }
    }

    public static String a(Drawable drawable, int i2, int i3, Bitmap.Config config) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, config);
        Drawable mutate = drawable.mutate();
        mutate.setBounds(0, 0, i2, i3);
        mutate.draw(new Canvas(createBitmap));
        qa qaVar = new qa(i2 * i3);
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, qaVar);
        return new String(Base64.encode(qaVar.a(), 0, qaVar.b(), 2));
    }

    public static <T> boolean b(T t2, T t3) {
        Object obj;
        boolean z2 = false;
        try {
            Class<?> cls = t3.getClass();
            LinkedList<Field> linkedList = new LinkedList<>();
            linkedList.addAll(Arrays.asList(cls.getDeclaredFields()));
            if (cls.getSuperclass() != null) {
                a((List<Field>) linkedList, (Class<?>) cls.getSuperclass());
            }
            for (Field field : linkedList) {
                int modifiers = field.getModifiers();
                if (!Modifier.isTransient(modifiers)) {
                    if (!Modifier.isStatic(modifiers)) {
                        field.setAccessible(true);
                        if (field.get(t2) == null && (obj = field.get(t3)) != null) {
                            field.set(t2, obj);
                            z2 = true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return z2;
    }

    public static String c(Context context) {
        ComponentName component;
        Intent a2 = a(context, (String) null);
        if (a2 == null || (component = a2.getComponent()) == null) {
            return null;
        }
        return component.getClassName();
    }

    public static boolean d(Context context) {
        boolean z2 = false;
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            boolean z3 = false;
            int i2 = 0;
            while (!z3) {
                try {
                    if (i2 >= activityInfoArr.length) {
                        return z3;
                    }
                    int i3 = i2 + 1;
                    ActivityInfo activityInfo = activityInfoArr[i2];
                    if (activityInfo.name.equals(OverlayActivity.class.getName())) {
                        int i4 = activityInfo.flags & 512;
                        i2 = i3;
                        z3 = i4 == 0;
                    } else {
                        i2 = i3;
                    }
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                    z2 = z3;
                    return z2;
                }
            }
            return z3;
        } catch (PackageManager.NameNotFoundException | Exception unused2) {
            return z2;
        }
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next != null && next.importance == 100 && packageName.equals(next.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            if (!a(th, (Class<? extends Throwable>) SecurityException.class) && !a(th, (Class<? extends Throwable>) RemoteException.class)) {
                y8.a(context, th);
            }
        }
    }

    public static boolean f(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null || (applicationInfo.flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        return ComponentLocator.a(context).e().a();
    }

    public static String c(String str) throws IOException {
        return Base64.encodeToString(fc.a(a(str)), 10);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r8.getPackageName()     // Catch:{ all -> 0x0009 }
            goto L_0x000b
        L_0x0009:
            r1 = r0
        L_0x000b:
            if (r9 != 0) goto L_0x000e
            r9 = r1
        L_0x000e:
            if (r9 != 0) goto L_0x0011
            return r0
        L_0x0011:
            boolean r2 = r9.equals(r1)
            if (r2 == 0) goto L_0x0021
            android.content.Intent r2 = f34877b
            if (r2 == 0) goto L_0x0021
            android.content.Intent r8 = new android.content.Intent
            r8.<init>(r2)
            return r8
        L_0x0021:
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            java.lang.Thread r3 = r3.getThread()
            if (r2 != r3) goto L_0x0032
            r2 = 100
            goto L_0x0034
        L_0x0032:
            r2 = 5000(0x1388, double:2.4703E-320)
        L_0x0034:
            r4 = 1
            android.content.Intent[] r4 = new android.content.Intent[r4]
            r5 = 0
            r4[r5] = r0
            monitor-enter(r4)
            java.lang.Thread r6 = new java.lang.Thread     // Catch:{ all -> 0x004b }
            com.startapp.kb r7 = new com.startapp.kb     // Catch:{ all -> 0x004b }
            r7.<init>(r4, r8, r9)     // Catch:{ all -> 0x004b }
            r6.<init>(r7)     // Catch:{ all -> 0x004b }
            r6.start()     // Catch:{ all -> 0x004b }
            r4.wait(r2)     // Catch:{ all -> 0x004b }
        L_0x004b:
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            r8 = r4[r5]
            if (r8 == 0) goto L_0x005f
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x005e
            f34877b = r8
            android.content.Intent r9 = new android.content.Intent
            r9.<init>(r8)
            return r9
        L_0x005e:
            return r8
        L_0x005f:
            return r0
        L_0x0060:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.lb.a(android.content.Context, java.lang.String):android.content.Intent");
    }

    public static boolean d(String str) {
        if (str == null) {
            return false;
        }
        try {
            String[] split = new URL(MetaData.f36379h.c()).getHost().split("\\.");
            if (split.length > 1) {
                Locale locale = Locale.ENGLISH;
                return str.toLowerCase(locale).contains(split[1].toLowerCase(locale));
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public static long e(String str) {
        long j2;
        if (str == null || str.length() < 1) {
            return 0;
        }
        int length = str.length() - 1;
        long j3 = 0;
        long j4 = 0;
        char c2 = 0;
        boolean z2 = true;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (charAt == 'm' && c2 == 's') {
                    j4 = 1;
                    length--;
                    c2 = charAt;
                } else if (z2) {
                    if (charAt == 's') {
                        j2 = 1000;
                    } else if (charAt == 'm') {
                        j2 = 60000;
                    } else if (charAt == 'h') {
                        j2 = 3600000;
                    } else if (charAt == 'd') {
                        j2 = SignalManager.TWENTY_FOUR_HOURS_MILLIS;
                    }
                    j4 = j2;
                    z2 = false;
                    length--;
                    c2 = charAt;
                }
            } else if (j4 != 0) {
                j3 += ((long) (charAt - '0')) * j4;
                j4 *= 10;
                z2 = true;
                length--;
                c2 = charAt;
            }
            return (long) (~length);
        }
        return j3;
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        return r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        return r7.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.Throwable r7) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0029 }
            r0.<init>()     // Catch:{ all -> 0x0029 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x0029 }
            java.util.zip.DeflaterOutputStream r2 = new java.util.zip.DeflaterOutputStream     // Catch:{ all -> 0x0029 }
            android.util.Base64OutputStream r3 = new android.util.Base64OutputStream     // Catch:{ all -> 0x0029 }
            r4 = 10
            r3.<init>(r0, r4)     // Catch:{ all -> 0x0029 }
            java.util.zip.Deflater r4 = new java.util.zip.Deflater     // Catch:{ all -> 0x0029 }
            r5 = 9
            r6 = 1
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ all -> 0x0029 }
            a((java.lang.Throwable) r7, (java.io.PrintWriter) r1)     // Catch:{ all -> 0x0029 }
            r1.close()     // Catch:{ all -> 0x0029 }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x0029 }
            return r7
        L_0x0029:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002e }
            return r7
        L_0x002e:
            java.lang.String r7 = r7.getMessage()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.lb.b(java.lang.Throwable):java.lang.String");
    }

    public static String a(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static boolean b(Context context, String str) {
        if (!str.startsWith("sms:") && !str.startsWith("smsto:")) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            y8.a(context, th);
            return false;
        }
    }

    public static int a(Activity activity, int i2, boolean z2) {
        if (z2) {
            if (!f34876a.containsKey(activity)) {
                f34876a.put(activity, Integer.valueOf(activity.getRequestedOrientation()));
            }
            if (i2 == activity.getResources().getConfiguration().orientation) {
                return hc.a(activity, i2, false);
            }
            return hc.a(activity, i2, true);
        } else if (!f34876a.containsKey(activity)) {
            return -1;
        } else {
            int intValue = f34876a.get(activity).intValue();
            int i3 = hc.f34643a;
            try {
                activity.setRequestedOrientation(intValue);
            } catch (Throwable unused) {
            }
            f34876a.remove(activity);
            return intValue;
        }
    }

    public static <T> List<T> b(List<T> list) {
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public static String b(Context context) {
        PackageManager packageManager;
        String str = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
            packageManager = null;
        }
        if (packageManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 29) {
            try {
                InstallSourceInfo a2 = packageManager.getInstallSourceInfo(context.getPackageName());
                if (a2 != null) {
                    str = a2.getInstallingPackageName();
                }
            } catch (Throwable unused2) {
            }
        }
        if (str != null) {
            return str;
        }
        try {
            return packageManager.getInstallerPackageName(context.getPackageName());
        } catch (Throwable unused3) {
            return str;
        }
    }

    public static void a(Activity activity, boolean z2) {
        a(activity, activity.getResources().getConfiguration().orientation, z2);
    }

    public static List<Field> a(List<Field> list, Class<?> cls) {
        list.addAll(Arrays.asList(cls.getDeclaredFields()));
        if (cls.getSuperclass() != null) {
            a(list, (Class<?>) cls.getSuperclass());
        }
        return list;
    }

    public static String a(Context context) {
        ActivityInfo activityInfo;
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
                return "";
            }
            String str = activityInfo.packageName;
            return str != null ? str.toLowerCase() : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(WebView webView, boolean z2, String str, Object... objArr) {
        if (webView != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                if (objArr != null) {
                    for (int i2 = 0; i2 < objArr.length; i2++) {
                        if (!z2 || !(objArr[i2] instanceof String)) {
                            sb.append(objArr[i2]);
                        } else {
                            sb.append("\"");
                            sb.append(objArr[i2]);
                            sb.append("\"");
                        }
                        if (i2 < objArr.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append(")");
                webView.loadUrl("javascript:" + sb.toString());
            } catch (Exception unused) {
            }
        }
    }

    public static <T> T a(String str, Class<T> cls) throws SDKException {
        T a2 = h0.a(str, cls);
        if (a2 != null) {
            return a2;
        }
        throw new SDKException();
    }

    public static boolean a(Context context, WebView webView, String str) {
        try {
            webView.loadDataWithBaseURL(MetaData.f36379h.m(), str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, AudienceNetworkActivity.WEBVIEW_ENCODING, (String) null);
            return true;
        } catch (Throwable th) {
            y8.a(context, th);
            return false;
        }
    }

    public static <T> boolean a(T t2, T t3) {
        if (t2 == null) {
            return t3 == null;
        }
        return t2.equals(t3);
    }

    public static byte[] a(String str) throws IOException {
        byte[] bytes = str.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
        deflaterOutputStream.write(bytes);
        deflaterOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String a(int... iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        char c2 = (char) length;
        for (int i2 = 0; i2 < length; i2++) {
            c2 = (char) (c2 + iArr[i2]);
            cArr[i2] = c2;
        }
        return new String(cArr);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static <T> String a(Iterable<T> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (T next : iterable) {
            if (z2) {
                sb.append(str);
            }
            sb.append(next);
            z2 = true;
        }
        return sb.toString();
    }

    public static StackTraceElement a(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        StackTraceElement[] a2 = b.a();
        if (a2 == null) {
            return null;
        }
        String name = b.class.getName();
        int length = a2.length;
        for (int i3 = 0; i3 < length; i3++) {
            StackTraceElement stackTraceElement = a2[i3];
            if (stackTraceElement != null && name.equals(stackTraceElement.getClassName())) {
                int i4 = i3 + 3 + i2;
                if (i4 < length) {
                    return a2[i4];
                }
                return null;
            }
        }
        return null;
    }

    public static String a(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return "null";
        }
        return stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName() + "()";
    }

    public static List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (d(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void a(Context context, boolean z2, String str, boolean z3) {
        if (z2) {
            Log.e("StartAppSDK", str);
        } else {
            Log.i("StartAppSDK", str);
        }
        boolean z4 = f(context) || hc.c(context);
        if (z3 && z4) {
            y8 y8Var = new y8(z8.f36995b);
            y8Var.f36954d = "Log for a publisher";
            y8Var.f36955e = str;
            y8Var.a(context);
        }
    }

    public static String a(Ad ad) {
        if (ad instanceof VideoEnabledAd) {
            VideoEnabledAd videoEnabledAd = (VideoEnabledAd) ad;
            if (videoEnabledAd.getType() == Ad.AdType.VIDEO) {
                return "VIDEO";
            }
            return videoEnabledAd.getType() == Ad.AdType.REWARDED_VIDEO ? "REWARDED_VIDEO" : "INTERSTITIAL";
        } else if (ad instanceof ReturnAd) {
            return "RETURN";
        } else {
            if (ad instanceof OfferWallAd) {
                return "OFFER_WALL";
            }
            if (ad instanceof OfferWall3DAd) {
                return "OFFER_WALL_3D";
            }
            if (ad instanceof BannerStandardAd) {
                BannerStandardAd bannerStandardAd = (BannerStandardAd) ad;
                if (bannerStandardAd.u() == 0) {
                    return AdPreferences.TYPE_BANNER;
                }
                if (bannerStandardAd.u() == 1) {
                    return "MREC";
                }
                return bannerStandardAd.u() == 2 ? "COVER" : "BANNER_UNDEFINED";
            } else if (ad instanceof Banner3DAd) {
                return "BANNER_3D";
            } else {
                if (ad instanceof NativeAd) {
                    return "NATIVE";
                }
                return ad instanceof SplashAd ? "SPLASH" : "UNDEFINED";
            }
        }
    }

    public static void a(Context context, Object obj, Throwable th) {
        if (obj.getClass().getName().startsWith("com.startapp.")) {
            y8.a(context, th);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        String className;
        ib ibVar = new ib(th);
        while (ibVar.hasNext()) {
            Throwable a2 = ibVar.next();
            if (ibVar.f34698d) {
                printWriter.println('-');
            }
            printWriter.println(a2.toString().trim());
            StackTraceElement[] stackTrace = a2.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                StackTraceElement stackTraceElement = null;
                int i2 = 0;
                int i3 = 0;
                boolean z2 = false;
                while (i2 < length) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    if (!(stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null)) {
                        boolean z3 = i2 < 3;
                        boolean startsWith = className.startsWith("com.startapp.");
                        if (z3 || startsWith || z2) {
                            if (i3 > 0) {
                                printWriter.print(' ');
                                printWriter.println(i3);
                                i3 = 0;
                            }
                            if (stackTraceElement != null) {
                                printWriter.print(' ');
                                printWriter.print(stackTraceElement.getClassName());
                                printWriter.print('.');
                                printWriter.print(stackTraceElement.getMethodName());
                                printWriter.println("()");
                                stackTraceElement = null;
                            }
                            printWriter.print(' ');
                            printWriter.print(stackTraceElement2.getClassName());
                            printWriter.print('.');
                            printWriter.print(stackTraceElement2.getMethodName());
                            printWriter.println("()");
                        } else {
                            if (stackTraceElement != null) {
                                i3++;
                            }
                            stackTraceElement = stackTraceElement2;
                        }
                        z2 = startsWith;
                    }
                    i2++;
                }
                if (stackTraceElement != null) {
                    i3++;
                }
                if (i3 > 0) {
                    printWriter.print(' ');
                    printWriter.println(i3);
                }
            }
        }
    }

    public static StackTraceElement a(Throwable th) {
        String className;
        Throwable th2 = th;
        while (true) {
            StackTraceElement stackTraceElement = null;
            if (th2 == null) {
                return null;
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        StackTraceElement stackTraceElement2 = stackTrace[i2];
                        if (stackTraceElement2 != null && (className = stackTraceElement2.getClassName()) != null && className.startsWith("com.startapp.")) {
                            stackTraceElement = stackTraceElement2;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            if (stackTraceElement != null) {
                return stackTraceElement;
            }
            th2 = th2.getCause();
        }
    }

    public static boolean a(Throwable th, Class<? extends Throwable> cls) {
        while (th != null) {
            if (cls.isInstance(th)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
