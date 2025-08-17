package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTimeConstants;

public final class zzm {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = DateTimeConstants.MILLIS_PER_MINUTE;

    public final zzl zza() {
        return new zzl(8, -1, this.zza, -1, this.zzb, this.zzc, this.zzd, false, (String) null, (zzfh) null, (Location) null, (String) null, this.zze, this.zzf, this.zzg, (String) null, (String) null, false, (zzc) null, this.zzh, this.zzi, this.zzj, this.zzk, (String) null);
    }

    public final zzm zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzm zzc(int i2) {
        this.zzk = i2;
        return this;
    }

    public final zzm zzd(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzm zze(List list) {
        this.zzb = list;
        return this;
    }

    public final zzm zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final zzm zzg(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzm zzh(int i2) {
        this.zzh = i2;
        return this;
    }
}
