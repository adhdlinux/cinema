package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzfts extends zzfsh {
    static final zzfts zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzfts(objArr, 0, objArr, 0, 0);
    }

    zzfts(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.zzb = objArr;
        this.zze = i2;
        this.zzc = objArr2;
        this.zzf = i3;
        this.zzg = i4;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.zzc;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int zzb2 = zzfru.zzb(obj);
        while (true) {
            int i2 = zzb2 & this.zzf;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzb2 = i2 + 1;
        }
    }

    public final int hashCode() {
        return this.zze;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzb, 0, objArr, i2, this.zzg);
        return i2 + this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    public final zzfuc zze() {
        return zzd().listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzfsc zzi() {
        return zzfsc.zzi(this.zzb, this.zzg);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzr() {
        return true;
    }
}
