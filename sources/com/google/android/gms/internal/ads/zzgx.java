package com.google.android.gms.internal.ads;

import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class zzgx extends zzgf {
    public final zzgj zzb;
    public final int zzc;

    public zzgx(zzgj zzgj, int i2, int i3) {
        super(zzb(2008, 1));
        this.zzb = zzgj;
        this.zzc = 1;
    }

    public static zzgx zza(IOException iOException, zzgj zzgj, int i2) {
        int i3;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i3 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i3 = GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION;
        } else if (message == null || !zzfon.zza(message).matches("cleartext.*not permitted.*")) {
            i3 = 2001;
        } else {
            i3 = 2007;
        }
        if (i3 == 2007) {
            return new zzgw(iOException, zzgj);
        }
        return new zzgx(iOException, zzgj, i3, i2);
    }

    private static int zzb(int i2, int i3) {
        return i2 == 2000 ? i3 != 1 ? 2000 : 2001 : i2;
    }

    public zzgx(IOException iOException, zzgj zzgj, int i2, int i3) {
        super((Throwable) iOException, zzb(i2, i3));
        this.zzb = zzgj;
        this.zzc = i3;
    }

    public zzgx(String str, zzgj zzgj, int i2, int i3) {
        super(str, zzb(i2, i3));
        this.zzb = zzgj;
        this.zzc = i3;
    }

    public zzgx(String str, IOException iOException, zzgj zzgj, int i2, int i3) {
        super(str, iOException, zzb(i2, i3));
        this.zzb = zzgj;
        this.zzc = i3;
    }
}
