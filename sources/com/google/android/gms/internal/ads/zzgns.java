package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgns extends zzgno implements RandomAccess, zzgrd {
    private static final zzgns zza = new zzgns(new boolean[0], 0, false);
    private boolean[] zzb;
    private int zzc;

    zzgns() {
        this(new boolean[10], 0, true);
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
        zzbH();
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
        zzbH();
        byte[] bArr = zzgpw.zzd;
        collection.getClass();
        if (!(collection instanceof zzgns)) {
            return super.addAll(collection);
        }
        zzgns zzgns = (zzgns) collection;
        int i2 = zzgns.zzc;
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
            System.arraycopy(zzgns.zzb, 0, this.zzb, this.zzc, zzgns.zzc);
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
        if (!(obj instanceof zzgns)) {
            return super.equals(obj);
        }
        zzgns zzgns = (zzgns) obj;
        if (this.zzc != zzgns.zzc) {
            return false;
        }
        boolean[] zArr = zzgns.zzb;
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
            i2 = (i2 * 31) + zzgpw.zza(this.zzb[i3]);
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
        zzbH();
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
        zzbH();
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
        zzbH();
        zzg(i2);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzgpv zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzgns(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z2) {
        zzbH();
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

    private zzgns(boolean[] zArr, int i2, boolean z2) {
        super(z2);
        this.zzb = zArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
