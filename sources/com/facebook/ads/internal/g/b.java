package com.facebook.ads.internal.g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.ads.internal.q.a.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f20170a = Build.VERSION.RELEASE;

    /* renamed from: b  reason: collision with root package name */
    private final Context f20171b;

    public b(Context context) {
        this.f20171b = context.getApplicationContext();
    }

    public String a() {
        String str = Build.MANUFACTURER;
        return (str == null || str.length() <= 0) ? "" : str;
    }

    public String b() {
        String str = Build.MODEL;
        return (str == null || str.length() <= 0) ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = r0.getNetworkOperatorName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c() {
        /*
            r2 = this;
            android.content.Context r0 = r2.f20171b
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.getNetworkOperatorName()
            if (r0 == 0) goto L_0x0019
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0019
            return r0
        L_0x0019:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.b.c():java.lang.String");
    }

    public String d() {
        try {
            CharSequence applicationLabel = this.f20171b.getPackageManager().getApplicationLabel(this.f20171b.getPackageManager().getApplicationInfo(f(), 0));
            return (applicationLabel == null || applicationLabel.length() <= 0) ? "" : applicationLabel.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r0 = r2.f20171b.getPackageManager().getInstallerPackageName(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
        /*
            r2 = this;
            java.lang.String r0 = r2.f()     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            int r1 = r0.length()     // Catch:{ Exception -> 0x001f }
            if (r1 < 0) goto L_0x001f
            android.content.Context r1 = r2.f20171b     // Catch:{ Exception -> 0x001f }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x001f }
            java.lang.String r0 = r1.getInstallerPackageName(r0)     // Catch:{ Exception -> 0x001f }
            if (r0 == 0) goto L_0x001f
            int r1 = r0.length()     // Catch:{ Exception -> 0x001f }
            if (r1 <= 0) goto L_0x001f
            return r0
        L_0x001f:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.g.b.e():java.lang.String");
    }

    public String f() {
        return PendingIntent.getActivity(this.f20171b, 0, new Intent(), 0).getCreatorPackage();
    }

    public String g() {
        try {
            return this.f20171b.getPackageManager().getPackageInfo(f(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public int h() {
        try {
            return this.f20171b.getPackageManager().getPackageInfo(f(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public boolean i() {
        return this.f20171b.checkCallingOrSelfPermission("android.permission.BIND_ACCESSIBILITY_SERVICE") == 0;
    }

    public int j() {
        return e.b(this.f20171b);
    }
}
