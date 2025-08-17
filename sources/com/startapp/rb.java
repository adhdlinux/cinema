package com.startapp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import com.google.protobuf.CodedOutputStream;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class rb {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35787a = lb.a(71, 13, -10, 14, -3, -6, -5, -54, 66, -11, 13, -5, -4, 10, 0, -10, 6, -1, -64, 19, 2, 0, 2, 14, 0, 12);

    /* renamed from: b  reason: collision with root package name */
    public static final String f35788b = lb.a(66, 3, 5, -9);

    /* renamed from: c  reason: collision with root package name */
    public static final String f35789c = lb.a(61, 12, -14, 17, 1, -14);

    /* renamed from: d  reason: collision with root package name */
    public static final String f35790d = lb.a(56, -1, 2, 8, -4, 11, -3, 6, -7, -10);

    /* renamed from: e  reason: collision with root package name */
    public static final String f35791e = lb.a(86, -19, 3, -12, -2, 19, -11, 6, -1);

    /* renamed from: f  reason: collision with root package name */
    public final Context f35792f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f35793g = new AtomicInteger(0);

    public rb(Context context) {
        this.f35792f = context;
    }

    public void a(int i2, boolean z2) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[4];
        int i3 = 0;
        objArr[0] = Integer.valueOf(this.f35793g.incrementAndGet());
        Context context = this.f35792f;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("com_startapp_sdk_aar", "integer", context.getPackageName());
            if (identifier != 0) {
                i3 = resources.getInteger(identifier);
            }
        } catch (Throwable unused) {
        }
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(z2 ? 1 : 0);
        String format = String.format(locale, "cnt=%d,aar=%d,mds=%d,ibt=%d", objArr);
        y8 y8Var = new y8(z8.f36995b);
        y8Var.f36954d = MobileAdsBridgeBase.initializeMethodName;
        y8Var.f36955e = format;
        y8Var.a(this.f35792f);
    }

    public String a() {
        Context context = this.f35792f;
        StringBuilder sb = new StringBuilder();
        String str = f35787a;
        sb.append(str);
        sb.append(f35789c);
        String str2 = f35791e;
        sb.append(str2);
        String[] strArr = {sb.toString(), str + f35788b + str2, str + f35790d + str2};
        int[] iArr = new int[3];
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE);
            String[] strArr2 = packageInfo.requestedPermissions;
            if (strArr2 != null) {
                int length = strArr2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    for (int i3 = 0; i3 < 3; i3++) {
                        if (strArr[i3].equals(packageInfo.requestedPermissions[i2])) {
                            if ((packageInfo.requestedPermissionsFlags[i2] & 2) == 2) {
                                iArr[i3] = 2;
                            } else {
                                iArr[i3] = 1;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        StringBuilder sb2 = new StringBuilder(3);
        for (int i4 = 0; i4 < 3; i4++) {
            sb2.append(iArr[i4]);
        }
        return sb2.toString();
    }
}
