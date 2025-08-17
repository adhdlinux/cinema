package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.vungle.ads.internal.signals.SignalManager;
import java.util.Calendar;

class TwilightManager {

    /* renamed from: d  reason: collision with root package name */
    private static TwilightManager f530d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f531a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f532b;

    /* renamed from: c  reason: collision with root package name */
    private final TwilightState f533c = new TwilightState();

    private static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        boolean f534a;

        /* renamed from: b  reason: collision with root package name */
        long f535b;

        TwilightState() {
        }
    }

    TwilightManager(Context context, LocationManager locationManager) {
        this.f531a = context;
        this.f532b = locationManager;
    }

    static TwilightManager a(Context context) {
        if (f530d == null) {
            Context applicationContext = context.getApplicationContext();
            f530d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f530d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location;
        Location location2 = null;
        if (PermissionChecker.c(this.f531a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (PermissionChecker.c(this.f531a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 == null || location == null) {
            if (location2 != null) {
                return location2;
            }
            return location;
        } else if (location2.getTime() > location.getTime()) {
            return location2;
        } else {
            return location;
        }
    }

    private Location c(String str) {
        try {
            if (this.f532b.isProviderEnabled(str)) {
                return this.f532b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f533c.f535b > System.currentTimeMillis();
    }

    private void f(Location location) {
        boolean z2;
        long j2;
        long j3;
        TwilightState twilightState = this.f533c;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator b2 = TwilightCalculator.b();
        TwilightCalculator twilightCalculator = b2;
        twilightCalculator.a(currentTimeMillis - SignalManager.TWENTY_FOUR_HOURS_MILLIS, location.getLatitude(), location.getLongitude());
        twilightCalculator.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        if (b2.f529c == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j4 = b2.f528b;
        long j5 = b2.f527a;
        long j6 = currentTimeMillis + SignalManager.TWENTY_FOUR_HOURS_MILLIS;
        long j7 = j5;
        double latitude = location.getLatitude();
        long j8 = j4;
        b2.a(j6, latitude, location.getLongitude());
        long j9 = b2.f528b;
        if (j8 == -1 || j7 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j7) {
                j3 = j9 + 0;
            } else if (currentTimeMillis > j8) {
                j3 = j7 + 0;
            } else {
                j3 = j8 + 0;
            }
            j2 = j3 + 60000;
        }
        twilightState.f534a = z2;
        twilightState.f535b = j2;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        TwilightState twilightState = this.f533c;
        if (e()) {
            return twilightState.f534a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return twilightState.f534a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        if (i2 < 6 || i2 >= 22) {
            return true;
        }
        return false;
    }
}
