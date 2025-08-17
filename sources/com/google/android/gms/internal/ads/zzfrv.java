package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

class zzfrv extends zzfrw {
    Object[] zza;
    int zzb = 0;
    boolean zzc;

    zzfrv(int i2) {
        this.zza = new Object[i2];
    }

    private final void zzf(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i2) {
            this.zza = Arrays.copyOf(objArr, zzfrw.zze(length, i2));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
    }

    public final zzfrv zza(Object obj) {
        obj.getClass();
        zzf(this.zzb + 1);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr[i2] = obj;
        return this;
    }

    public /* bridge */ /* synthetic */ zzfrw zzb(Object obj) {
        throw null;
    }

    public final zzfrw zzc(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzf(this.zzb + collection.size());
            if (collection instanceof zzfrx) {
                this.zzb = ((zzfrx) collection).zza(this.zza, this.zzb);
                return this;
            }
        }
        for (Object zzb2 : iterable) {
            zzb(zzb2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object[] objArr, int i2) {
        zzftk.zzb(objArr, 2);
        zzf(this.zzb + 2);
        System.arraycopy(objArr, 0, this.zza, this.zzb, 2);
        this.zzb += 2;
    }
}
