package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbmk extends zzcaq {
    private final Object zza = new Object();
    private final zzbb zzb;
    private boolean zzc;
    private int zzd;

    public zzbmk(zzbb zzbb) {
        this.zzb = zzbb;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbmf zza() {
        boolean z2;
        zzbmf zzbmf = new zzbmf(this);
        synchronized (this.zza) {
            zzi(new zzbmg(this, zzbmf), new zzbmh(this, zzbmf));
            if (this.zzd >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            this.zzd++;
        }
        return zzbmf;
    }

    public final void zzb() {
        boolean z2;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            zze.zza("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            zzc();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc() {
        boolean z2;
        synchronized (this.zza) {
            if (this.zzd >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            if (!this.zzc || this.zzd != 0) {
                zze.zza("There are still references to the engine. Not destroying.");
            } else {
                zze.zza("No reference is left (including root). Cleaning up engine.");
                zzi(new zzbmj(this), new zzcam());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        boolean z2;
        synchronized (this.zza) {
            if (this.zzd > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2);
            zze.zza("Releasing 1 reference for JS Engine");
            this.zzd--;
            zzc();
        }
    }
}
