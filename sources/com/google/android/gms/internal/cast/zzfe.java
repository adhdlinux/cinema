package com.google.android.gms.internal.cast;

import java.util.Arrays;

public final class zzfe extends zzfb {
    public zzfe() {
        super(4);
    }

    public final zzfe zzb(Object obj) {
        obj.getClass();
        int i2 = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i2) {
            this.zza = Arrays.copyOf(objArr, zzfc.zza(length, i2));
            this.zzc = false;
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
            this.zzc = false;
        }
        Object[] objArr2 = this.zza;
        int i3 = this.zzb;
        this.zzb = i3 + 1;
        objArr2[i3] = obj;
        return this;
    }

    public final zzfh zzc() {
        this.zzc = true;
        return zzfh.zzi(this.zza, this.zzb);
    }
}
