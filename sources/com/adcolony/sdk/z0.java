package com.adcolony.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;
import com.adcolony.sdk.e0;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import org.json.JSONException;

class z0 {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f13541a = P();

    /* renamed from: b  reason: collision with root package name */
    static Handler f13542b;

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f13543b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f13544c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f13545d;

        a(Context context, String str, int i2) {
            this.f13543b = context;
            this.f13544c = str;
            this.f13545d = i2;
        }

        public void run() {
            Toast.makeText(this.f13543b, this.f13544c, this.f13545d).show();
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private long f13546a;

        /* renamed from: b  reason: collision with root package name */
        private long f13547b = System.currentTimeMillis();

        c(long j2) {
            a(j2);
        }

        /* access modifiers changed from: package-private */
        public void a(long j2) {
            this.f13546a = j2;
            this.f13547b = System.currentTimeMillis() + this.f13546a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return d() == 0;
        }

        /* access modifiers changed from: package-private */
        public long c() {
            return this.f13546a;
        }

        /* access modifiers changed from: package-private */
        public long d() {
            long currentTimeMillis = this.f13547b - System.currentTimeMillis();
            if (currentTimeMillis <= 0) {
                return 0;
            }
            return currentTimeMillis;
        }

        public String toString() {
            return String.valueOf(((double) d()) / 1000.0d);
        }
    }

    static boolean A(Runnable runnable) {
        Handler H;
        if (runnable == null || (H = H()) == null) {
            return false;
        }
        if (H.getLooper() != Looper.myLooper()) {
            return H.post(runnable);
        }
        runnable.run();
        return true;
    }

    static String B() {
        Context a2 = a.a();
        if (a2 == null) {
            return "1.0";
        }
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            new e0.a().c("Failed to retrieve package info.").d(e0.f13114i);
            return "1.0";
        }
    }

    static boolean C(Runnable runnable) {
        Handler H;
        if (runnable == null || (H = H()) == null) {
            return false;
        }
        H.removeCallbacks(runnable);
        return true;
    }

    static boolean D(String str) {
        Application application;
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        try {
            if (a2 instanceof Application) {
                application = (Application) a2;
            } else {
                application = ((Activity) a2).getApplication();
            }
            application.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    static int E() {
        Context a2 = a.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            new e0.a().c("Failed to retrieve package info.").d(e0.f13114i);
            return 0;
        }
    }

    static int F(String str) {
        str.hashCode();
        if (!str.equals("portrait")) {
            return !str.equals("landscape") ? -1 : 1;
        }
        return 0;
    }

    static String G(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private static Handler H() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            return null;
        }
        if (f13542b == null) {
            f13542b = new Handler(mainLooper);
        }
        return f13542b;
    }

    static e1 I(Context context) {
        e1 c2 = c0.c();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE);
                if (packageInfo.requestedPermissions != null) {
                    c2 = c0.c();
                    int i2 = 0;
                    while (true) {
                        String[] strArr = packageInfo.requestedPermissions;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        c2.g(strArr[i2]);
                        i2++;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return c2;
    }

    static boolean J(String str) {
        if (str != null && str.length() <= 128) {
            return true;
        }
        new e0.a().c("String must be non-null and the max length is 128 characters.").d(e0.f13111f);
        return false;
    }

    static int K(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    static int L(String str) {
        try {
            return (int) Long.parseLong(str, 16);
        } catch (NumberFormatException unused) {
            new e0.a().c("Unable to parse '").c(str).c("' as a color.").d(e0.f13112g);
            return -16777216;
        }
    }

    static String M() {
        Context a2 = a.a();
        if (!(a2 instanceof Activity) || a2.getResources().getConfiguration().orientation != 1) {
            return "landscape";
        }
        return "portrait";
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", r1).parse(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return new java.text.SimpleDateFormat("yyyy-MM-dd", r1).parse(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.util.Date N(java.lang.String r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r2 = "yyyy-MM-dd'T'HH:mmZ"
            r0.<init>(r2, r1)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ssZ"
            r2.<init>(r3, r1)
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy-MM-dd"
            r3.<init>(r4, r1)
            java.util.Date r5 = r0.parse(r5)     // Catch:{ Exception -> 0x001c }
            return r5
        L_0x001c:
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x0021 }
            return r5
        L_0x0021:
            java.util.Date r5 = r3.parse(r5)     // Catch:{ Exception -> 0x0026 }
            return r5
        L_0x0026:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.z0.N(java.lang.String):java.util.Date");
    }

    static boolean O() {
        Context a2 = a.a();
        if (a2 == null || Build.VERSION.SDK_INT < 24 || !(a2 instanceof Activity) || !((Activity) a2).isInMultiWindowMode()) {
            return false;
        }
        return true;
    }

    static ExecutorService P() {
        return new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    static double a(AudioManager audioManager) {
        if (audioManager == null) {
            new e0.a().c("getAudioVolume() called with a null AudioManager").d(e0.f13114i);
            return 0.0d;
        }
        try {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            if (streamMaxVolume == 0.0d) {
                return 0.0d;
            }
            return streamVolume / streamMaxVolume;
        } catch (Exception e2) {
            new e0.a().c("Exception occurred when accessing AudioManager: ").c(e2.toString()).d(e0.f13114i);
            return 0.0d;
        }
    }

    static int b(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[0]) / a.f().x0().U());
    }

    static int c(String str) {
        CRC32 crc32 = new CRC32();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            crc32.update(str.charAt(i2));
        }
        return (int) crc32.getValue();
    }

    static AudioManager d(Context context) {
        if (context != null) {
            return (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        new e0.a().c("getAudioManager called with a null Context").d(e0.f13114i);
        return null;
    }

    static e1 e(int i2) {
        e1 c2 = c0.c();
        for (int i3 = 0; i3 < i2; i3++) {
            c0.j(c2, f());
        }
        return c2;
    }

    static String f() {
        return UUID.randomUUID().toString();
    }

    static String g(e1 e1Var) throws JSONException {
        String str = "";
        for (int i2 = 0; i2 < e1Var.e(); i2++) {
            if (i2 > 0) {
                str = str + ",";
            }
            switch (e1Var.f(i2)) {
                case 1:
                    str = str + "MO";
                    break;
                case 2:
                    str = str + "TU";
                    break;
                case 3:
                    str = str + "WE";
                    break;
                case 4:
                    str = str + "TH";
                    break;
                case 5:
                    str = str + "FR";
                    break;
                case 6:
                    str = str + "SA";
                    break;
                case 7:
                    str = str + "SU";
                    break;
            }
        }
        return str;
    }

    static String h(v0 v0Var) {
        f1 m2 = v0Var.m();
        String E = c0.E(m2, "adc_alt_id");
        if (!E.isEmpty()) {
            return E;
        }
        String f2 = f();
        c0.n(m2, "adc_alt_id", f2);
        v0Var.d(m2);
        return f2;
    }

    private static void i(Vibrator vibrator, long j2) {
        vibrator.vibrate(VibrationEffect.createOneShot(j2, -1));
    }

    static boolean j(Context context, long j2) {
        try {
            Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
            if (vibrator == null || !vibrator.hasVibrator()) {
                return false;
            }
            y(vibrator, j2);
            return true;
        } catch (Exception unused) {
            new e0.a().c("Vibrate command failed.").d(e0.f13111f);
            return false;
        }
    }

    static boolean k(Intent intent) {
        return l(intent, false);
    }

    static boolean l(Intent intent, boolean z2) {
        try {
            Context a2 = a.a();
            if (a2 == null) {
                return false;
            }
            if (!(a2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            AdColonyInterstitial q02 = a.f().q0();
            if (q02 != null && q02.z()) {
                q02.s().q();
            }
            if (z2) {
                a2.startActivity(Intent.createChooser(intent, "Handle this via..."));
                return true;
            }
            a2.startActivity(intent);
            return true;
        } catch (Exception e2) {
            new e0.a().c(e2.toString()).d(e0.f13112g);
            return false;
        }
    }

    static boolean m(Runnable runnable) {
        return q(f13541a, runnable);
    }

    static boolean n(Runnable runnable, long j2) {
        if (runnable == null) {
            return false;
        }
        if (j2 <= 0) {
            return A(runnable);
        }
        Handler H = H();
        if (H != null) {
            return H.postDelayed(runnable, j2);
        }
        return false;
    }

    static boolean o(String str, int i2) {
        Context a2 = a.a();
        if (a2 == null) {
            return false;
        }
        A(new a(a2, str, i2));
        return true;
    }

    static boolean p(String str, File file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e2) {
                        throw new RuntimeException("Unable to process file for MD5", e2);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                            new e0.a().c("Exception on closing MD5 input stream").d(e0.f13114i);
                        }
                        throw th;
                    }
                }
                boolean equals = str.equals(String.format("%40s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0'));
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    new e0.a().c("Exception on closing MD5 input stream").d(e0.f13114i);
                }
                return equals;
            } catch (FileNotFoundException unused3) {
                new e0.a().c("Exception while getting FileInputStream").d(e0.f13114i);
                return false;
            }
        } catch (NoSuchAlgorithmException unused4) {
            new e0.a().c("Exception while getting Digest").d(e0.f13114i);
            return false;
        }
    }

    static boolean q(ExecutorService executorService, Runnable runnable) {
        try {
            executorService.execute(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    static int r(Context context) {
        int i2;
        if (context == null) {
            return 0;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            i2 = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        } else {
            i2 = context.getResources().getIdentifier("navigation_bar_height_landscape", "dimen", "android");
        }
        if (i2 > 0) {
            return context.getResources().getDimensionPixelSize(i2);
        }
        return 0;
    }

    static int s(View view) {
        if (view == null) {
            return 0;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return (int) (((float) iArr[1]) / a.f().x0().U());
    }

    static int t(v0 v0Var) {
        boolean z2 = false;
        try {
            Context a2 = a.a();
            if (a2 == null) {
                return 0;
            }
            int i2 = (int) (a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0).lastUpdateTime / 1000);
            f1 m2 = v0Var.m();
            int i3 = 1;
            if (!m2.j("last_update")) {
                z2 = true;
                i3 = 2;
            } else if (c0.A(m2, "last_update") != i2) {
                z2 = true;
            } else {
                i3 = 0;
            }
            if (z2) {
                try {
                    c0.u(m2, "last_update", i2);
                    v0Var.d(m2);
                } catch (Exception unused) {
                    return i3;
                }
            }
            return i3;
        } catch (Exception unused2) {
            return 0;
        }
    }

    static f1 u(f1 f1Var) {
        f1Var.J("launch_metadata");
        return f1Var;
    }

    static String v() {
        Application application;
        Context a2 = a.a();
        if (a2 == null) {
            return "";
        }
        if (a2 instanceof Application) {
            application = (Application) a2;
        } else {
            application = ((Activity) a2).getApplication();
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(a2.getPackageName(), 0)).toString();
        } catch (Exception unused) {
            new e0.a().c("Failed to retrieve application label.").d(e0.f13114i);
            return "";
        }
    }

    static String w(e1 e1Var) throws JSONException {
        String str = "";
        for (int i2 = 0; i2 < e1Var.e(); i2++) {
            if (i2 > 0) {
                str = str + ",";
            }
            str = str + e1Var.f(i2);
        }
        return str;
    }

    static String x(String str) {
        try {
            return d1.a(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void y(Vibrator vibrator, long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            i(vibrator, j2);
        } else {
            vibrator.vibrate(j2);
        }
    }

    static boolean z(AudioManager audioManager) {
        if (audioManager == null) {
            new e0.a().c("isAudioEnabled() called with a null AudioManager").d(e0.f13114i);
            return false;
        }
        try {
            if (audioManager.getStreamVolume(3) > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            new e0.a().c("Exception occurred when accessing AudioManager.getStreamVolume: ").c(e2.toString()).d(e0.f13114i);
            return false;
        }
    }
}
