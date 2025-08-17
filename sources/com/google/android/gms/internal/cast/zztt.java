package com.google.android.gms.internal.cast;

import java.io.IOException;

final class zztt implements zzua {
    private final zztp zza;
    private final zzur zzb;
    private final boolean zzc;
    private final zzrx zzd;

    private zztt(zzur zzur, zzrx zzrx, zztp zztp) {
        this.zzb = zzur;
        this.zzc = zzrx.zzc(zztp);
        this.zzd = zzrx;
        this.zza = zztp;
    }

    static zztt zzi(zzur zzur, zzrx zzrx, zztp zztp) {
        return new zztt(zzur, zzrx, zztp);
    }

    public final int zza(Object obj) {
        zzur zzur = this.zzb;
        int zzb2 = zzur.zzb(zzur.zzc(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zzc() {
        zztp zztp = this.zza;
        if (zztp instanceof zzsh) {
            return ((zzsh) zztp).zzw();
        }
        return zztp.zzB().zzr();
    }

    public final void zzd(Object obj) {
        this.zzb.zze(obj);
        this.zzd.zzb(obj);
    }

    public final void zze(Object obj, Object obj2) {
        zzuc.zzB(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzf(Object obj, zzvi zzvi) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzg(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzh(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
