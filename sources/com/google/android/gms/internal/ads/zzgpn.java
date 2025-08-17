package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgpn extends zzgno implements RandomAccess, zzgpr, zzgrd {
    private static final zzgpn zza = new zzgpn(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    zzgpn() {
        this(new int[10], 0, true);
    }

    public static zzgpn zzf() {
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
        zzbH();
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
        zzbH();
        byte[] bArr = zzgpw.zzd;
        collection.getClass();
        if (!(collection instanceof zzgpn)) {
            return super.addAll(collection);
        }
        zzgpn zzgpn = (zzgpn) collection;
        int i2 = zzgpn.zzc;
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
            System.arraycopy(zzgpn.zzb, 0, this.zzb, this.zzc, zzgpn.zzc);
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
        if (!(obj instanceof zzgpn)) {
            return super.equals(obj);
        }
        zzgpn zzgpn = (zzgpn) obj;
        if (this.zzc != zzgpn.zzc) {
            return false;
        }
        int[] iArr = zzgpn.zzb;
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
        zzbH();
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
        zzbH();
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
        zzbH();
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
    public final zzgpr zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzgpn(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int i2) {
        zzbH();
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

    private zzgpn(int[] iArr, int i2, boolean z2) {
        super(z2);
        this.zzb = iArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
