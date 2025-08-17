package com.google.android.gms.internal.ads;

public final class zzof {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;

    public final zzof zza(boolean z2) {
        this.zza = true;
        return this;
    }

    public final zzof zzb(boolean z2) {
        this.zzb = z2;
        return this;
    }

    public final zzof zzc(boolean z2) {
        this.zzc = z2;
        return this;
    }

    public final zzoh zzd() {
        if (this.zza || (!this.zzb && !this.zzc)) {
            return new zzoh(this, (zzog) null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
