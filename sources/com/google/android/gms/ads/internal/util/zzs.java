package com.google.android.gms.ads.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzceq;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.android.gms.internal.ads.zzdnl;
import com.google.android.gms.internal.ads.zzezn;
import com.google.android.gms.internal.ads.zzezq;
import com.google.android.gms.internal.ads.zzfmd;
import com.google.android.gms.internal.ads.zzfos;
import com.google.android.gms.internal.ads.zzfpu;
import com.google.android.gms.internal.ads.zzfwc;
import com.google.android.gms.internal.ads.zzfwm;
import com.google.android.gms.internal.ads.zzgws;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.joda.time.DateTimeConstants;

public final class zzs {
    public static final zzfmd zza = new zzf(Looper.getMainLooper());
    private final AtomicReference zzb = new AtomicReference((Object) null);
    private final AtomicReference zzc = new AtomicReference((Object) null);
    /* access modifiers changed from: private */
    public boolean zzd = true;
    private final Object zze = new Object();
    private String zzf;
    private boolean zzg = false;
    private boolean zzh = false;
    private final Executor zzi = Executors.newSingleThreadExecutor();

    public static final boolean zzA(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        } catch (Throwable th) {
            zzbzr.zzh("Error loading class.", th);
            zzt.zzo().zzu(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzB() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public static final boolean zzC(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                return true;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static final boolean zzD(Context context) {
        Bundle zzU = zzU(context);
        String string = zzU.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
        if (!TextUtils.isEmpty(zzV(zzU)) || TextUtils.isEmpty(string)) {
            return false;
        }
        return true;
    }

    public static final boolean zzE(Context context) {
        Window window;
        if (!(!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null)) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
            window.getDecorView().getWindowVisibleDisplayFrame(rect2);
            if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static final void zzF(View view, int i2, MotionEvent motionEvent) {
        int i3;
        String str;
        int i4;
        int i5;
        String str2;
        zzezn zzD;
        View view2 = view;
        int[] iArr = new int[2];
        Rect rect = new Rect();
        try {
            String packageName = view.getContext().getPackageName();
            if (view2 instanceof zzdnl) {
                view2 = ((zzdnl) view2).getChildAt(0);
            }
            if ((view2 instanceof zzg) || (view2 instanceof NativeAdView)) {
                str = "NATIVE";
                i3 = 1;
            } else {
                str = "UNKNOWN";
                i3 = 0;
            }
            if (view2.getLocalVisibleRect(rect)) {
                i4 = rect.width();
                i5 = rect.height();
            } else {
                i5 = 0;
                i4 = 0;
            }
            zzt.zzp();
            long zzs = zzs(view2);
            view2.getLocationOnScreen(iArr);
            int i6 = iArr[0];
            int i7 = iArr[1];
            String str3 = "none";
            if (view2 instanceof zzcfw) {
                zzezq zzP = ((zzcfw) view2).zzP();
                if (zzP != null) {
                    str2 = zzP.zzb;
                    int hashCode = view2.hashCode();
                    view2.setContentDescription(str2 + ":" + hashCode);
                    if ((view2 instanceof zzceq) && (zzD = ((zzceq) view2).zzD()) != null) {
                        str = zzezn.zza(zzD.zzb);
                        i3 = zzD.zzf;
                        str3 = zzD.zzF;
                    }
                    zzbzr.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", new Object[]{Integer.valueOf(view2.hashCode()), packageName, str3, str2, str, Integer.valueOf(i3), view2.getClass().getName(), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(zzs), Integer.toString(i2, 2)}));
                }
            }
            str2 = str3;
            str = zzezn.zza(zzD.zzb);
            i3 = zzD.zzf;
            str3 = zzD.zzF;
            zzbzr.zzi(String.format(Locale.US, "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>", new Object[]{Integer.valueOf(view2.hashCode()), packageName, str3, str2, str, Integer.valueOf(i3), view2.getClass().getName(), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(view2.getWidth()), Integer.valueOf(view2.getHeight()), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(zzs), Integer.toString(i2, 2)}));
        } catch (Exception e2) {
            zzbzr.zzh("Failure getting view location.", e2);
        }
    }

    public static final AlertDialog.Builder zzG(Context context) {
        return new AlertDialog.Builder(context, zzt.zzq().zza());
    }

    public static final void zzH(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        for (String zzby : arrayList) {
            new zzby(context, str, zzby).zzb();
        }
    }

    public static final void zzI(Context context, Throwable th) {
        if (context != null) {
            try {
                if (((Boolean) zzbdn.zzb.zze()).booleanValue()) {
                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                }
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static final String zzJ(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public static final int zzK(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            zzbzr.zzj("Could not parse value:".concat(e2.toString()));
            return 0;
        }
    }

    public static final Map zzL(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
        }
        return hashMap;
    }

    public static final int[] zzM(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzr();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] zzN(android.app.Activity r6) {
        /*
            android.view.Window r0 = r6.getWindow()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0021
            r4 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r4)
            if (r0 == 0) goto L_0x0021
            int[] r4 = new int[r1]
            int r5 = r0.getTop()
            r4[r3] = r5
            int r0 = r0.getBottom()
            r4[r2] = r0
            goto L_0x0025
        L_0x0021:
            int[] r4 = zzr()
        L_0x0025:
            int[] r0 = new int[r1]
            com.google.android.gms.internal.ads.zzbzk r1 = com.google.android.gms.ads.internal.client.zzay.zzb()
            r5 = r4[r3]
            int r1 = r1.zzb(r6, r5)
            r0[r3] = r1
            com.google.android.gms.internal.ads.zzbzk r1 = com.google.android.gms.ads.internal.client.zzay.zzb()
            r3 = r4[r2]
            int r6 = r1.zzb(r6, r3)
            r0[r2] = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.zzN(android.app.Activity):int[]");
    }

    public static final boolean zzO(View view, PowerManager powerManager, KeyguardManager keyguardManager) {
        boolean z2;
        if (zzt.zzp().zzd || keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode() || zzl(view)) {
            z2 = true;
        } else {
            z2 = false;
        }
        long zzs = zzs(view);
        if (view.getVisibility() == 0 && view.isShown() && ((powerManager == null || powerManager.isScreenOn()) && z2)) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzbh)).booleanValue() || view.getLocalVisibleRect(new Rect()) || view.getGlobalVisibleRect(new Rect())) {
                if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjj)).booleanValue()) {
                    return true;
                }
                if (zzs < ((long) ((Integer) zzba.zzc().zzb(zzbbm.zzjl)).intValue())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static final void zzP(Context context, Intent intent) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjB)).booleanValue()) {
            try {
                zzX(context, intent);
            } catch (SecurityException e2) {
                zzbzr.zzk("", e2);
                zzt.zzo().zzu(e2, "AdUtil.startActivityWithUnknownContext");
            }
        } else {
            zzX(context, intent);
        }
    }

    public static final void zzQ(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzm(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            zzbzr.zze("Opening " + uri2 + " in a new browser.");
        } catch (ActivityNotFoundException e2) {
            zzbzr.zzh("No browser is found.", e2);
        }
    }

    public static final int[] zzR(Activity activity) {
        int[] zzM = zzM(activity);
        return new int[]{zzay.zzb().zzb(activity, zzM[0]), zzay.zzb().zzb(activity, zzM[1])};
    }

    public static final boolean zzS(View view, Context context) {
        PowerManager powerManager;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        } else {
            powerManager = null;
        }
        return zzO(view, powerManager, zzT(context));
    }

    private static KeyguardManager zzT(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static Bundle zzU(Context context) {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            zze.zzb("Error getting metadata", e2);
            return null;
        }
    }

    private static String zzV(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    private static boolean zzW(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = (Pattern) atomicReference.get();
            if (pattern == null || !str2.equals(pattern.pattern())) {
                pattern = Pattern.compile(str2);
                atomicReference.set(pattern);
            }
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    private static final void zzX(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static int zza(int i2) {
        if (i2 >= 5000) {
            return i2;
        }
        if (i2 <= 0) {
            return DateTimeConstants.MILLIS_PER_MINUTE;
        }
        zzbzr.zzj("HTTP timeout too low: " + i2 + " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        return DateTimeConstants.MILLIS_PER_MINUTE;
    }

    public static List zzd() {
        zzbbe zzbbe = zzbbm.zza;
        List<String> zzb2 = zzba.zza().zzb();
        ArrayList arrayList = new ArrayList();
        for (String zzd2 : zzb2) {
            for (String valueOf : zzfpu.zzc(zzfos.zzc(',')).zzd(zzd2)) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException unused) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzl(android.view.View r2) {
        /*
            android.view.View r2 = r2.getRootView()
            r0 = 0
            if (r2 != 0) goto L_0x0009
        L_0x0007:
            r2 = r0
            goto L_0x0013
        L_0x0009:
            android.content.Context r2 = r2.getContext()
            boolean r1 = r2 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0007
            android.app.Activity r2 = (android.app.Activity) r2
        L_0x0013:
            r1 = 0
            if (r2 != 0) goto L_0x0017
            return r1
        L_0x0017:
            android.view.Window r2 = r2.getWindow()
            if (r2 != 0) goto L_0x001e
            goto L_0x0022
        L_0x001e:
            android.view.WindowManager$LayoutParams r0 = r2.getAttributes()
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r2 = r0.flags
            r0 = 524288(0x80000, float:7.34684E-40)
            r2 = r2 & r0
            if (r2 == 0) goto L_0x002d
            r2 = 1
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.zzl(android.view.View):boolean");
    }

    public static final void zzm(Context context, Intent intent) {
        Bundle bundle;
        if (intent != null) {
            if (intent.getExtras() != null) {
                bundle = intent.getExtras();
            } else {
                bundle = new Bundle();
            }
            bundle.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(bundle);
        }
    }

    public static final String zzn(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzV(zzU(context));
    }

    static final String zzo() {
        StringBuilder sb = new StringBuilder(UserVerificationMethods.USER_VERIFY_HANDPRINT);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        String str = Build.VERSION.RELEASE;
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        String str2 = Build.DEVICE;
        if (str2 != null) {
            sb.append("; ");
            sb.append(str2);
            String str3 = Build.DISPLAY;
            if (str3 != null) {
                sb.append(" Build/");
                sb.append(str3);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzp() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return str + " " + str2;
    }

    public static final DisplayMetrics zzq(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzr() {
        return new int[]{0, 0};
    }

    public static final long zzs(View view) {
        float f2;
        int i2;
        float f3 = Float.MAX_VALUE;
        Object obj = view;
        do {
            f2 = 0.0f;
            if (!(obj instanceof View)) {
                break;
            }
            View view2 = (View) obj;
            f3 = Math.min(f3, view2.getAlpha());
            i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            obj = view2.getParent();
        } while (i2 > 0);
        if (f3 >= 0.0f) {
            f2 = f3;
        }
        return (long) Math.round(f2 * 100.0f);
    }

    public static final WebResourceResponse zzt(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", zzt.zzp().zzc(context, str));
            hashMap.put("Cache-Control", "max-stale=3600");
            String str3 = (String) new zzbo(context).zzb(0, str2, hashMap, (byte[]) null).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e2) {
            zzbzr.zzk("Could not fetch MRAID JS.", e2);
        }
        return null;
    }

    public static final String zzu() {
        Resources zzd2 = zzt.zzo().zzd();
        if (zzd2 != null) {
            return zzd2.getString(R.string.s7);
        }
        return "Test Ad";
    }

    public static final zzbr zzv(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbzr.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            if (queryLocalInterface instanceof zzbr) {
                return (zzbr) queryLocalInterface;
            }
            return new zzbp(iBinder);
        } catch (Exception e2) {
            zzt.zzo().zzu(e2, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public static final boolean zzw(Context context, String str) {
        Context zza2 = zzbus.zza(context);
        if (Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean zzx(Context context) {
        try {
            return DeviceProperties.isBstar(context);
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    public static final boolean zzy(String str) {
        if (!zzbzq.zzk()) {
            return false;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzeI)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzba.zzc().zzb(zzbbm.zzeK);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(";")) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzba.zzc().zzb(zzbbm.zzeJ);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(";")) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean zzz(Context context) {
        KeyguardManager zzT;
        if (context == null || (zzT = zzT(context)) == null || !zzT.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public final zzfwm zzb(Uri uri) {
        return zzfwc.zzj(new zzl(uri), this.zzi);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:11|12|(1:14)(3:15|(1:17)(1:18)|19)|20|21|22|(1:24)|25|(1:27)|28|(3:29|30|(1:32))|36|37|38) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083 A[Catch:{ Exception -> 0x0099 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzc(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zze
            monitor-enter(r0)
            java.lang.String r1 = r4.zzf     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            return r1
        L_0x0009:
            if (r6 != 0) goto L_0x0011
            java.lang.String r5 = zzo()     // Catch:{ all -> 0x00ba }
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            return r5
        L_0x0011:
            com.google.android.gms.ads.internal.util.zzce r1 = com.google.android.gms.ads.internal.util.zzce.zza()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = r1.zza     // Catch:{ Exception -> 0x0045 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0045 }
            if (r2 != 0) goto L_0x001e
            goto L_0x0041
        L_0x001e:
            boolean r2 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ Exception -> 0x0045 }
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.ads.internal.util.zzcc r2 = new com.google.android.gms.ads.internal.util.zzcc     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r2 = com.google.android.gms.ads.internal.util.zzcb.zza(r5, r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0045 }
            goto L_0x003f
        L_0x0030:
            android.content.Context r2 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r5)     // Catch:{ Exception -> 0x0045 }
            com.google.android.gms.ads.internal.util.zzcd r3 = new com.google.android.gms.ads.internal.util.zzcd     // Catch:{ Exception -> 0x0045 }
            r3.<init>(r2, r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r2 = com.google.android.gms.ads.internal.util.zzcb.zza(r5, r3)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0045 }
        L_0x003f:
            r1.zza = r2     // Catch:{ Exception -> 0x0045 }
        L_0x0041:
            java.lang.String r1 = r1.zza     // Catch:{ Exception -> 0x0045 }
            r4.zzf = r1     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            java.lang.String r1 = r4.zzf     // Catch:{ all -> 0x00ba }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = android.webkit.WebSettings.getDefaultUserAgent(r5)     // Catch:{ all -> 0x00ba }
            r4.zzf = r1     // Catch:{ all -> 0x00ba }
        L_0x0053:
            java.lang.String r1 = r4.zzf     // Catch:{ all -> 0x00ba }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = zzo()     // Catch:{ all -> 0x00ba }
            r4.zzf = r1     // Catch:{ all -> 0x00ba }
        L_0x0061:
            java.lang.String r1 = r4.zzf     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r2.<init>()     // Catch:{ all -> 0x00ba }
            r2.append(r1)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = " (Mobile; "
            r2.append(r1)     // Catch:{ all -> 0x00ba }
            r2.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x00ba }
            r4.zzf = r6     // Catch:{ all -> 0x00ba }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r5 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r5)     // Catch:{ Exception -> 0x0099 }
            boolean r5 = r5.isCallerInstantApp()     // Catch:{ Exception -> 0x0099 }
            if (r5 == 0) goto L_0x00a3
            java.lang.String r5 = r4.zzf     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r6.<init>()     // Catch:{ Exception -> 0x0099 }
            r6.append(r5)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = ";aia"
            r6.append(r5)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0099 }
            r4.zzf = r5     // Catch:{ Exception -> 0x0099 }
            goto L_0x00a3
        L_0x0099:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbza r6 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "AdUtil.getUserAgent"
            r6.zzu(r5, r1)     // Catch:{ all -> 0x00ba }
        L_0x00a3:
            java.lang.String r5 = r4.zzf     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r6.<init>()     // Catch:{ all -> 0x00ba }
            r6.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = ")"
            r6.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x00ba }
            r4.zzf = r5     // Catch:{ all -> 0x00ba }
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            return r5
        L_0x00ba:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzs.zzc(android.content.Context, java.lang.String):java.lang.String");
    }

    public final void zzf(Context context, String str, boolean z2, HttpURLConnection httpURLConnection, boolean z3, int i2) {
        int zza2 = zza(i2);
        zzbzr.zzi("HTTP timeout: " + zza2 + " milliseconds.");
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("User-Agent"))) {
            httpURLConnection.setRequestProperty("User-Agent", zzc(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    public final boolean zzg(String str) {
        return zzW(str, this.zzb, (String) zzba.zzc().zzb(zzbbm.zzac));
    }

    public final boolean zzh(String str) {
        return zzW(str, this.zzc, (String) zzba.zzc().zzb(zzbbm.zzad));
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final boolean zzi(Context context) {
        if (this.zzh) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbbm.zza(context);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzp(this, (zzo) null), intentFilter);
        } else {
            Intent unused = context.getApplicationContext().registerReceiver(new zzp(this, (zzo) null), intentFilter, 4);
        }
        this.zzh = true;
        return true;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final boolean zzj(Context context) {
        if (this.zzg) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbbm.zza(context);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzr(this, (zzq) null), intentFilter);
        } else {
            Intent unused = context.getApplicationContext().registerReceiver(new zzr(this, (zzq) null), intentFilter, 4);
        }
        this.zzg = true;
        return true;
    }

    public final int zzk(Context context, Uri uri) {
        int i2;
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!(context instanceof Activity)) {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i2 = 2;
        } else {
            i2 = 0;
        }
        zzbbe zzbbe = zzbbm.zzen;
        zzbbe zzbbe2 = zzbbm.zzeo;
        if (true == ((Boolean) zzba.zzc().zzb(zzbbe)).equals(zzba.zzc().zzb(zzbbe2))) {
            i2 = 9;
        }
        if (i2 != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i2;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
            zzbcn zzbcn = new zzbcn();
            zzbcn.zze(new zzn(this, zzbcn, context, uri));
            zzbcn.zzb((Activity) context);
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbe2)).booleanValue()) {
            return 5;
        }
        CustomTabsIntent a2 = new CustomTabsIntent.Builder().a();
        a2.f1615a.setPackage(zzgws.zza(context));
        a2.a(context, uri);
        return 5;
    }
}
