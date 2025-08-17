package com.google.android.gms.internal.ads;

final class zznv {
    final /* synthetic */ zznw zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzto zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zznv(zznw zznw, String str, int i2, zzto zzto) {
        this.zza = zznw;
        this.zzb = str;
        this.zzc = i2;
        this.zzd = zzto == null ? -1 : zzto.zzd;
        if (zzto != null && zzto.zzb()) {
            this.zze = zzto;
        }
    }

    public final void zzg(int i2, zzto zzto) {
        if (this.zzd == -1 && i2 == this.zzc && zzto != null) {
            this.zzd = zzto.zzd;
        }
    }

    public final boolean zzj(int i2, zzto zzto) {
        if (zzto == null) {
            return i2 == this.zzc;
        }
        zzto zzto2 = this.zze;
        return zzto2 == null ? !zzto.zzb() && zzto.zzd == this.zzd : zzto.zzd == zzto2.zzd && zzto.zzb == zzto2.zzb && zzto.zzc == zzto2.zzc;
    }

    public final boolean zzk(zzlt zzlt) {
        zzto zzto = zzlt.zzd;
        if (zzto != null) {
            long j2 = this.zzd;
            if (j2 == -1) {
                return false;
            }
            if (zzto.zzd > j2) {
                return true;
            }
            if (this.zze == null) {
                return false;
            }
            int zza2 = zzlt.zzb.zza(zzto.zza);
            int zza3 = zzlt.zzb.zza(this.zze.zza);
            zzto zzto2 = zzlt.zzd;
            if (zzto2.zzd < this.zze.zzd || zza2 < zza3) {
                return false;
            }
            if (zza2 > zza3) {
                return true;
            }
            if (zzto2.zzb()) {
                zzto zzto3 = zzlt.zzd;
                int i2 = zzto3.zzb;
                int i3 = zzto3.zzc;
                zzto zzto4 = this.zze;
                int i4 = zzto4.zzb;
                if (i2 > i4) {
                    return true;
                }
                if (i2 != i4 || i3 <= zzto4.zzc) {
                    return false;
                }
                return true;
            }
            int i5 = zzlt.zzd.zze;
            if (i5 == -1 || i5 > this.zze.zzb) {
                return true;
            }
            return false;
        } else if (this.zzc != zzlt.zzc) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.zzc()) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzl(com.google.android.gms.internal.ads.zzcw r7, com.google.android.gms.internal.ads.zzcw r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.zzc()
            if (r0 >= r7) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            r0 = -1
            goto L_0x004a
        L_0x0013:
            com.google.android.gms.internal.ads.zznw r1 = r6.zza
            com.google.android.gms.internal.ads.zzcv r1 = r1.zzc
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zznw r0 = r6.zza
            com.google.android.gms.internal.ads.zzcv r0 = r0.zzc
            int r0 = r0.zzo
        L_0x0026:
            com.google.android.gms.internal.ads.zznw r1 = r6.zza
            com.google.android.gms.internal.ads.zzcv r1 = r1.zzc
            int r1 = r1.zzp
            if (r0 > r1) goto L_0x0011
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L_0x0047
            com.google.android.gms.internal.ads.zznw r7 = r6.zza
            com.google.android.gms.internal.ads.zzct r7 = r7.zzd
            com.google.android.gms.internal.ads.zzct r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzd
            goto L_0x004a
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x004a:
            r6.zzc = r0
            if (r0 != r3) goto L_0x004f
            return r2
        L_0x004f:
            com.google.android.gms.internal.ads.zzto r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L_0x005e
            return r0
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zzl(com.google.android.gms.internal.ads.zzcw, com.google.android.gms.internal.ads.zzcw):boolean");
    }
}
