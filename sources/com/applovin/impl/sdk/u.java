package com.applovin.impl.sdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.g;
import java.util.concurrent.TimeUnit;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private final m f15777a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f15778b;

    /* renamed from: c  reason: collision with root package name */
    private t f15779c;

    u(m mVar) {
        this.f15777a = mVar;
        this.f15778b = (LocationManager) mVar.L().getSystemService("location");
    }

    @SuppressLint({"MissingPermission"})
    private Location a(String str, String str2) {
        v A;
        StringBuilder sb;
        String str3;
        if (!g.a(str2, this.f15777a.L())) {
            return null;
        }
        try {
            return this.f15778b.getLastKnownLocation(str);
        } catch (SecurityException e2) {
            th = e2;
            if (v.a()) {
                A = this.f15777a.A();
                sb = new StringBuilder();
                sb.append("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": access denied.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (IllegalArgumentException e3) {
            th = e3;
            if (v.a()) {
                A = this.f15777a.A();
                sb = new StringBuilder();
                sb.append("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": device does not support this location provider.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (NullPointerException e4) {
            th = e4;
            if (v.a()) {
                A = this.f15777a.A();
                sb = new StringBuilder();
                sb.append("Failed to retrieve location from ");
                sb.append(str);
                str3 = ": location provider is not available.";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        } catch (Throwable th) {
            th = th;
            if (v.a()) {
                A = this.f15777a.A();
                sb = new StringBuilder();
                sb.append("Failed to retrieve location from ");
                sb.append(str);
                str3 = ".";
                sb.append(str3);
                A.b("LocationManager", sb.toString(), th);
            }
            return null;
        }
    }

    public boolean a() {
        return g.a("android.permission.ACCESS_COARSE_LOCATION", this.f15777a.L());
    }

    public boolean b() {
        return g.h() ? this.f15778b.isLocationEnabled() : !g.c() || Settings.Secure.getInt(this.f15777a.L().getContentResolver(), "location_mode", 0) != 0;
    }

    public t c() {
        if (!this.f15777a.p().isLocationCollectionEnabled() || !((Boolean) this.f15777a.a(b.dW)).booleanValue()) {
            return null;
        }
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f15777a.a(b.dX)).longValue());
        if (this.f15779c != null && System.currentTimeMillis() - this.f15779c.c() < millis) {
            return this.f15779c;
        }
        Location a2 = a("gps", "android.permission.ACCESS_FINE_LOCATION");
        if (a2 == null) {
            a2 = a("network", "android.permission.ACCESS_COARSE_LOCATION");
        }
        if (a2 != null) {
            this.f15779c = new t(a2.getLatitude(), a2.getLongitude(), System.currentTimeMillis());
        }
        return this.f15779c;
    }
}
