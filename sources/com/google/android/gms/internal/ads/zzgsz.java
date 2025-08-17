package com.google.android.gms.internal.ads;

import com.google.android.gms.location.GeofenceStatusCodes;

final class zzgsz implements zzgpq {
    static final zzgpq zza = new zzgsz();

    private zzgsz() {
    }

    public final boolean zza(int i2) {
        if (!(i2 == 0 || i2 == 1 || i2 == 2 || i2 == 1999)) {
            switch (i2) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION /*1004*/:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
