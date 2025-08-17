package com.google.android.gms.internal.cast;

final class zzfs extends zzfh {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfs(Object[] objArr, int i2, int i3) {
        this.zza = objArr;
        this.zzb = i2;
        this.zzc = i3;
    }

    public final Object get(int i2) {
        zzeu.zza(i2, this.zzc, "index");
        Object obj = this.zza[i2 + i2 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
