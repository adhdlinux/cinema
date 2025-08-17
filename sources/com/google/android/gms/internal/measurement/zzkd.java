package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzkd extends zzim implements RandomAccess, zzkh, zzlq {
    private static final zzkd zza;
    private int[] zzb;
    private int zzc;

    static {
        zzkd zzkd = new zzkd(new int[0], 0);
        zza = zzkd;
        zzkd.zzb();
    }

    zzkd() {
        this(new int[10], 0);
    }

    public static zzkd zzf() {
        return zza;
    }

    private final String zzi(int i2) {
        int i3 = this.zzc;
        return "Index:" + i2 + ", Size:" + i3;
    }

    private final void zzj(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        int intValue = ((Integer) obj).intValue();
        zzbS();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i2));
        }
        int[] iArr = this.zzb;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i3 - i2);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.zzb, i2, iArr2, i2 + 1, this.zzc - i2);
            this.zzb = iArr2;
        }
        this.zzb[i2] = intValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbS();
        zzkk.zze(collection);
        if (!(collection instanceof zzkd)) {
            return super.addAll(collection);
        }
        zzkd zzkd = (zzkd) collection;
        int i2 = zzkd.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.zzb;
            if (i4 > iArr.length) {
                this.zzb = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(zzkd.zzb, 0, this.zzb, this.zzc, zzkd.zzc);
            this.zzc = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkd)) {
            return super.equals(obj);
        }
        zzkd zzkd = (zzkd) obj;
        if (this.zzc != zzkd.zzc) {
            return false;
        }
        int[] iArr = zzkd.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (this.zzb[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzj(i2);
        return Integer.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i2 = (i2 * 31) + this.zzb[i3];
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == intValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbS();
        zzj(i2);
        int[] iArr = this.zzb;
        int i3 = iArr[i2];
        int i4 = this.zzc;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zzbS();
        if (i3 >= i2) {
            int[] iArr = this.zzb;
            System.arraycopy(iArr, i3, iArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbS();
        zzj(i2);
        int[] iArr = this.zzb;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zze(int i2) {
        zzj(i2);
        return this.zzb[i2];
    }

    /* renamed from: zzg */
    public final zzkh zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzkd(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        zzbS();
        int i3 = this.zzc;
        int[] iArr = this.zzb;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        iArr3[i4] = i2;
    }

    private zzkd(int[] iArr, int i2) {
        this.zzb = iArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
