package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zziq extends zzim implements RandomAccess, zzlq {
    private static final zziq zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zziq zziq = new zziq(new boolean[0], 0);
        zza = zziq;
        zziq.zzb();
    }

    zziq() {
        this(new boolean[10], 0);
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

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbS();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        boolean[] zArr = this.zzb;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.zzb, i2, zArr2, i2 + 1, this.zzc - i2);
            this.zzb = zArr2;
        }
        this.zzb[i2] = booleanValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbS();
        zzkk.zze(collection);
        if (!(collection instanceof zziq)) {
            return super.addAll(collection);
        }
        zziq zziq = (zziq) collection;
        int i2 = zziq.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.zzb;
            if (i4 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(zziq.zzb, 0, this.zzb, this.zzc, zziq.zzc);
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
        if (!(obj instanceof zziq)) {
            return super.equals(obj);
        }
        zziq zziq = (zziq) obj;
        if (this.zzc != zziq.zzc) {
            return false;
        }
        boolean[] zArr = zziq.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (this.zzb[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzg(i2);
        return Boolean.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i2 = (i2 * 31) + zzkk.zza(this.zzb[i3]);
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == booleanValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbS();
        zzg(i2);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Boolean.valueOf(z2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zzbS();
        if (i3 >= i2) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i3, zArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbS();
        zzg(i2);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzkj zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zziq(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z2) {
        zzbS();
        int i2 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        zArr3[i3] = z2;
    }

    private zziq(boolean[] zArr, int i2) {
        this.zzb = zArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
