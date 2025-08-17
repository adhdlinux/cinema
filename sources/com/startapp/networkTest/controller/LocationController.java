package com.startapp.networkTest.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.startapp.l2;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.LocationProviders;
import com.startapp.r2;
import com.startapp.w0;
import com.startapp.w2;
import java.util.List;

public class LocationController {

    /* renamed from: a  reason: collision with root package name */
    private static double f34974a = 0.0d;

    /* renamed from: b  reason: collision with root package name */
    private static double f34975b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    private static final String f34976c = "LocationController";

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f34977d = false;

    /* renamed from: e  reason: collision with root package name */
    private LocationManager f34978e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f34979f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LocationInfo f34980g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Location f34981h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f34982i;

    /* renamed from: j  reason: collision with root package name */
    private b f34983j;

    /* renamed from: k  reason: collision with root package name */
    private long f34984k = 4000;

    /* renamed from: l  reason: collision with root package name */
    private boolean f34985l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public c f34986m;

    public enum ProviderMode {
        Passive,
        Network,
        Gps,
        GpsAndNetwork,
        RailNet
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34993a;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
        static {
            /*
                com.startapp.networkTest.controller.LocationController.ProviderMode.values()
                r0 = 5
                int[] r0 = new int[r0]
                f34993a = r0
                com.startapp.networkTest.controller.LocationController$ProviderMode r1 = com.startapp.networkTest.controller.LocationController.ProviderMode.Gps     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0011 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r0 = f34993a     // Catch:{ NoSuchFieldError -> 0x001c }
                com.startapp.networkTest.controller.LocationController$ProviderMode r1 = com.startapp.networkTest.controller.LocationController.ProviderMode.GpsAndNetwork     // Catch:{ NoSuchFieldError -> 0x001c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001c }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = f34993a     // Catch:{ NoSuchFieldError -> 0x0027 }
                com.startapp.networkTest.controller.LocationController$ProviderMode r1 = com.startapp.networkTest.controller.LocationController.ProviderMode.Network     // Catch:{ NoSuchFieldError -> 0x0027 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0027 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0027 }
            L_0x0027:
                int[] r0 = f34993a     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.startapp.networkTest.controller.LocationController$ProviderMode r1 = com.startapp.networkTest.controller.LocationController.ProviderMode.Passive     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.networkTest.controller.LocationController.a.<clinit>():void");
        }
    }

    public class b implements LocationListener {
        private b() {
        }

        public void onLocationChanged(Location location) {
            if (location != null && location.getProvider() != null) {
                if (LocationController.this.f34981h == null || location.getProvider().equals("gps") || LocationController.this.f34981h.getProvider() == null || !LocationController.this.f34981h.getProvider().equals("gps") || SystemClock.elapsedRealtime() - LocationController.this.f34979f >= 5000) {
                    Location unused = LocationController.this.f34981h = location;
                    long unused2 = LocationController.this.f34982i = SystemClock.elapsedRealtime();
                    LocationInfo unused3 = LocationController.this.f34980g = LocationController.b(location);
                    LocationController.this.f34980g.LocationAge = 0;
                    long unused4 = LocationController.this.f34979f = SystemClock.elapsedRealtime();
                    if (LocationController.this.f34986m != null) {
                        LocationController.this.f34986m.a(LocationController.this.f34980g);
                    }
                    if (location.getProvider().equals("gps")) {
                        w0.f().a(location);
                    }
                }
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }

        public /* synthetic */ b(LocationController locationController, a aVar) {
            this();
        }
    }

    public interface c {
        void a(LocationInfo locationInfo);
    }

    public LocationController(Context context) {
        this.f34978e = (LocationManager) context.getSystemService("location");
        this.f34983j = new b(this, (a) null);
    }

    public long e() {
        return this.f34984k;
    }

    public void f() {
        b bVar;
        LocationManager locationManager = this.f34978e;
        if (!(locationManager == null || (bVar = this.f34983j) == null)) {
            try {
                locationManager.removeUpdates(bVar);
            } catch (Throwable th) {
                l2.a(th);
            }
        }
        this.f34985l = false;
    }

    @SuppressLint({"NewApi"})
    private void d() {
        Location location;
        List<String> allProviders = this.f34978e.getAllProviders();
        Location location2 = null;
        if (allProviders != null && allProviders.size() > 0) {
            Location location3 = null;
            for (int i2 = 0; i2 < allProviders.size(); i2++) {
                try {
                    location = this.f34978e.getLastKnownLocation(allProviders.get(i2));
                } catch (SecurityException e2) {
                    l2.b(e2);
                    location = null;
                    location3 = location;
                } catch (Throwable th) {
                    l2.a(th);
                    location = null;
                    location3 = location;
                }
                if (location != null && (location3 == null || location.getTime() > location3.getTime())) {
                    location3 = location;
                }
            }
            location2 = location3;
        }
        if (location2 != null) {
            this.f34981h = location2;
            this.f34982i = location2.getElapsedRealtimeNanos() / 1000000;
            this.f34980g = b(location2);
        }
    }

    public LocationInfo c() {
        if (this.f34980g == null) {
            d();
        }
        if (this.f34980g == null) {
            LocationInfo locationInfo = new LocationInfo();
            this.f34980g = locationInfo;
            locationInfo.LocationProvider = LocationProviders.Unknown;
        }
        LocationInfo locationInfo2 = this.f34980g;
        if (locationInfo2.LocationProvider != LocationProviders.Unknown) {
            locationInfo2.LocationAge = SystemClock.elapsedRealtime() - this.f34982i;
        }
        LocationInfo locationInfo3 = this.f34980g;
        f34974a = locationInfo3.LocationLatitude;
        f34975b = locationInfo3.LocationLongitude;
        try {
            return (LocationInfo) locationInfo3.clone();
        } catch (Throwable th) {
            l2.a(th);
            return this.f34980g;
        }
    }

    /* access modifiers changed from: private */
    public static LocationInfo b(Location location) {
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.LocationAccuracyHorizontal = (double) location.getAccuracy();
        if (Build.VERSION.SDK_INT < 26 || !location.hasVerticalAccuracy()) {
            locationInfo.LocationAccuracyVertical = (double) location.getAccuracy();
        } else {
            locationInfo.LocationAccuracyVertical = (double) location.getVerticalAccuracyMeters();
        }
        long d2 = r2.d();
        locationInfo.locationTimestampMillis = d2;
        locationInfo.LocationTimestamp = w2.b(d2);
        locationInfo.LocationAltitude = location.getAltitude();
        locationInfo.LocationBearing = (double) location.getBearing();
        locationInfo.LocationLatitude = location.getLatitude();
        locationInfo.LocationLongitude = location.getLongitude();
        locationInfo.IsMocked = location.isFromMockProvider() ? 1 : 0;
        if (location.getProvider() == null) {
            locationInfo.LocationProvider = LocationProviders.Unknown;
        } else if (location.getProvider().equals("gps")) {
            locationInfo.LocationProvider = LocationProviders.Gps;
        } else if (location.getProvider().equals("network")) {
            locationInfo.LocationProvider = LocationProviders.Network;
        } else if (location.getProvider().equals("fused")) {
            locationInfo.LocationProvider = LocationProviders.Fused;
        } else {
            locationInfo.LocationProvider = LocationProviders.Unknown;
        }
        locationInfo.LocationSpeed = (double) location.getSpeed();
        return locationInfo;
    }

    public void a(ProviderMode providerMode) {
        LocationManager locationManager;
        boolean z2;
        boolean z3;
        if (providerMode != null && (locationManager = this.f34978e) != null) {
            this.f34985l = true;
            List<String> allProviders = locationManager.getAllProviders();
            boolean z4 = false;
            if (allProviders != null) {
                z3 = false;
                z2 = false;
                boolean z5 = false;
                for (String next : allProviders) {
                    next.hashCode();
                    char c2 = 65535;
                    switch (next.hashCode()) {
                        case -792039641:
                            if (next.equals("passive")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 102570:
                            if (next.equals("gps")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1843485230:
                            if (next.equals("network")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            z5 = true;
                            break;
                        case 1:
                            z3 = true;
                            break;
                        case 2:
                            z2 = true;
                            break;
                    }
                }
                z4 = z5;
            } else {
                z3 = false;
                z2 = false;
            }
            try {
                int ordinal = providerMode.ordinal();
                if (ordinal != 0) {
                    if (ordinal != 1) {
                        if (ordinal != 2) {
                            if (ordinal == 3) {
                                if (z3) {
                                    this.f34978e.requestLocationUpdates("gps", 500, 5.0f, this.f34983j);
                                }
                                if (z2) {
                                    this.f34978e.requestLocationUpdates("network", 0, 0.0f, this.f34983j);
                                }
                            }
                        } else if (z3) {
                            this.f34978e.requestLocationUpdates("gps", 500, 5.0f, this.f34983j);
                        }
                    } else if (z2) {
                        this.f34978e.requestLocationUpdates("network", 0, 0.0f, this.f34983j);
                    }
                } else if (z4) {
                    this.f34978e.requestLocationUpdates("passive", 0, 0.0f, this.f34983j);
                }
            } catch (SecurityException e2) {
                l2.b(e2);
            } catch (Throwable th) {
                l2.a(th);
            }
        }
    }

    public void a(c cVar) {
        this.f34986m = cVar;
    }

    public static double a() {
        return f34974a;
    }

    public void a(long j2) {
        this.f34984k = j2;
    }

    public static double b() {
        return f34975b;
    }
}
