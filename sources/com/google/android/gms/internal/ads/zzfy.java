package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public abstract class zzfy implements zzge {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzgj zzd;

    protected zzfy(boolean z2) {
        this.zza = z2;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzhg zzhg) {
        zzhg.getClass();
        if (!this.zzb.contains(zzhg)) {
            this.zzb.add(zzhg);
            this.zzc++;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzg(int i2) {
        zzgj zzgj = this.zzd;
        int i3 = zzfj.zza;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            ((zzhg) this.zzb.get(i4)).zza(this, zzgj, this.zza, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzh() {
        zzgj zzgj = this.zzd;
        int i2 = zzfj.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzhg) this.zzb.get(i3)).zzb(this, zzgj, this.zza);
        }
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzgj zzgj) {
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhg) this.zzb.get(i2)).zzc(this, zzgj, this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzgj zzgj) {
        this.zzd = zzgj;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhg) this.zzb.get(i2)).zzd(this, zzgj, this.zza);
        }
    }
}
