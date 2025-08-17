package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.LinkedList;

final class zzfbt {
    private final LinkedList zza = new LinkedList();
    private final int zzb;
    private final int zzc;
    private final zzfcs zzd;

    public zzfbt(int i2, int i3) {
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = new zzfcs();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzt.zzB().currentTimeMillis() - ((zzfcd) this.zza.getFirst()).zzd >= ((long) this.zzc)) {
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzfcd zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfcd zzfcd = (zzfcd) this.zza.remove();
        if (zzfcd != null) {
            this.zzd.zzh();
        }
        return zzfcd;
    }

    public final zzfcr zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzfcd zzfcd) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfcd);
        return true;
    }
}
