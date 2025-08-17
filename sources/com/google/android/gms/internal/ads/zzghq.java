package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

public final class zzghq {
    private ArrayList zza = new ArrayList();
    private zzghn zzb = zzghn.zza;
    private Integer zzc = null;

    public final zzghq zza(zzfxs zzfxs, int i2, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzghs(zzfxs, i2, str, str2, (zzghr) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzghq zzb(zzghn zzghn) {
        if (this.zza != null) {
            this.zzb = zzghn;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzghq zzc(int i2) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i2);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzghu zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    int zza2 = ((zzghs) arrayList.get(i2)).zza();
                    i2++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzghu zzghu = new zzghu(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzght) null);
            this.zza = null;
            return zzghu;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
