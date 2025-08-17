package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public final class zzhf implements zzge {
    private final zzge zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map zzd = Collections.emptyMap();

    public zzhf(zzge zzge) {
        this.zza = zzge;
    }

    public final int zza(byte[] bArr, int i2, int i3) throws IOException {
        int zza2 = this.zza.zza(bArr, i2, i3);
        if (zza2 != -1) {
            this.zzb += (long) zza2;
        }
        return zza2;
    }

    public final long zzb(zzgj zzgj) throws IOException {
        this.zzc = zzgj.zza;
        this.zzd = Collections.emptyMap();
        long zzb2 = this.zza.zzb(zzgj);
        Uri zzc2 = zzc();
        zzc2.getClass();
        this.zzc = zzc2;
        this.zzd = zze();
        return zzb2;
    }

    public final Uri zzc() {
        return this.zza.zzc();
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final Map zze() {
        return this.zza.zze();
    }

    public final void zzf(zzhg zzhg) {
        zzhg.getClass();
        this.zza.zzf(zzhg);
    }

    public final long zzg() {
        return this.zzb;
    }

    public final Uri zzh() {
        return this.zzc;
    }

    public final Map zzi() {
        return this.zzd;
    }
}
