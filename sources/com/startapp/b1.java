package com.startapp;

import android.content.Context;
import android.net.ConnectivityManager;
import com.startapp.networkTest.data.WifiInfo;
import com.startapp.networkTest.enums.WifiStates;
import java.lang.reflect.Method;

public class b1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f34225a = "b1";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f34226b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final int f34227c = -1;

    /* renamed from: d  reason: collision with root package name */
    private WifiStates f34228d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectivityManager f34229e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34230f = false;

    /* renamed from: g  reason: collision with root package name */
    private Context f34231g;

    /* renamed from: h  reason: collision with root package name */
    private String f34232h = "";

    /* renamed from: i  reason: collision with root package name */
    private boolean f34233i;

    /* renamed from: j  reason: collision with root package name */
    private Method f34234j;

    public b1(Context context) {
        this.f34231g = context.getApplicationContext();
        this.f34229e = (ConnectivityManager) context.getSystemService("connectivity");
        this.f34228d = WifiStates.Unknown;
        a();
    }

    private String a(String str) {
        int ordinal;
        if (str.length() == 0 || (ordinal = w0.b().WIFIINFO_BSSID_RECORDTYPE().ordinal()) == 0) {
            return str;
        }
        if (ordinal != 1) {
            return "";
        }
        if (str.length() != 17) {
            return "xx:xx:xx:xx:xx:xx";
        }
        return str.substring(0, 9) + "xx:xx:xx";
    }

    private void a() {
    }

    private String b(String str) {
        return (str.length() == 0 || w0.b().WIFIINFO_SSID_RECORDTYPE().ordinal() == 0) ? str : "";
    }

    public WifiInfo c() {
        WifiInfo wifiInfo = new WifiInfo();
        wifiInfo.MissingPermission = true;
        try {
            this.f34231g.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE");
            return wifiInfo;
        } catch (Throwable th) {
            l2.a(th);
            return wifiInfo;
        }
    }

    public long d() {
        if (this.f34232h.length() == 0) {
            c();
        }
        if (this.f34232h.length() == 0) {
            return -1;
        }
        return g3.a(this.f34232h);
    }

    public long e() {
        String str = this.f34232h;
        if (str == null || str.length() == 0) {
            c();
        }
        String str2 = this.f34232h;
        if (str2 == null || str2.length() == 0) {
            return -1;
        }
        return g3.b(this.f34232h);
    }

    public void f() {
    }

    public void g() {
    }

    private int[] b() {
        int[] iArr = {-1, 0};
        if (this.f34233i) {
            return iArr;
        }
        String[] a2 = d3.a("/proc/net/wireless");
        if (a2.length == 0) {
            this.f34233i = true;
            return iArr;
        }
        if (a2.length > 2) {
            int i2 = 2;
            while (i2 < a2.length) {
                String[] a3 = f3.a(a2[i2].trim().split(" "));
                if (a3.length <= 4 || !a3[0].equals("wlan0:")) {
                    i2++;
                } else {
                    try {
                        return new int[]{Integer.parseInt(a3[2].replace(".", "")), Integer.parseInt(a3[3].replace(".", ""))};
                    } catch (NumberFormatException unused) {
                        return iArr;
                    }
                }
            }
        }
        return iArr;
    }
}
