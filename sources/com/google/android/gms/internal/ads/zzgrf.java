package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzgrf extends zzgno implements RandomAccess {
    private static final zzgrf zza = new zzgrf(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    zzgrf() {
        this(new Object[10], 0, true);
    }

    public static zzgrf zze() {
        return zza;
    }

    private final String zzf(int i2) {
        int i3 = this.zzc;
        return "Index:" + i2 + ", Size:" + i3;
    }

    private final void zzg(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
    }

    public final void add(int i2, Object obj) {
        int i3;
        zzbH();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        Object[] objArr = this.zzb;
        if (i3 < objArr.length) {
            System.arraycopy(objArr, i2, objArr, i2 + 1, i3 - i2);
        } else {
            Object[] objArr2 = new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.zzb, i2, objArr2, i2 + 1, this.zzc - i2);
            this.zzb = objArr2;
        }
        this.zzb[i2] = obj;
        this.zzc++;
        this.modCount++;
    }

    public final Object get(int i2) {
        zzg(i2);
        return this.zzb[i2];
    }

    public final Object remove(int i2) {
        zzbH();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj = objArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(objArr, i2 + 1, objArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i2, Object obj) {
        zzbH();
        zzg(i2);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzgpv zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzgrf(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzgrf(Object[] objArr, int i2, boolean z2) {
        super(z2);
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean add(Object obj) {
        zzbH();
        int i2 = this.zzc;
        Object[] objArr = this.zzb;
        if (i2 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i2 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        objArr2[i3] = obj;
        this.modCount++;
        return true;
    }
}
