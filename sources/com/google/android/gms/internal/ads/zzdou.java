package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;

public final class zzdou implements zzcyb, zzcwu, zzcvj, zzcwa, zza, zzdan {
    private final zzawz zza;
    private boolean zzb = false;

    public zzdou(zzawz zzawz, zzexi zzexi) {
        this.zza = zzawz;
        zzawz.zzc(2);
        if (zzexi != null) {
            zzawz.zzc(1101);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
            return;
        }
        this.zza.zzc(8);
    }

    public final void zza(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzc(101);
                return;
            case 2:
                this.zza.zzc(102);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(104);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    public final void zzb(zzezz zzezz) {
        this.zza.zzb(new zzdoq(zzezz));
    }

    public final void zzbA(zzbue zzbue) {
    }

    public final void zzd() {
        this.zza.zzc(1109);
    }

    public final void zze(zzaxu zzaxu) {
        this.zza.zzb(new zzdot(zzaxu));
        this.zza.zzc(1103);
    }

    public final void zzf(zzaxu zzaxu) {
        this.zza.zzb(new zzdos(zzaxu));
        this.zza.zzc(1102);
    }

    public final void zzh(boolean z2) {
        this.zza.zzc(true != z2 ? 1108 : 1107);
    }

    public final void zzi(zzaxu zzaxu) {
        this.zza.zzb(new zzdor(zzaxu));
        this.zza.zzc(1104);
    }

    public final void zzk(boolean z2) {
        this.zza.zzc(true != z2 ? 1106 : 1105);
    }

    public final synchronized void zzl() {
        this.zza.zzc(6);
    }

    public final void zzn() {
        this.zza.zzc(3);
    }
}
