package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgov extends zzgno implements RandomAccess, zzgrd {
    private static final zzgov zza = new zzgov(new double[0], 0, false);
    private double[] zzb;
    private int zzc;

    zzgov() {
        this(new double[10], 0, true);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzbH();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        double[] dArr = this.zzb;
        if (i3 < dArr.length) {
            System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
        } else {
            double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            System.arraycopy(this.zzb, i2, dArr2, i2 + 1, this.zzc - i2);
            this.zzb = dArr2;
        }
        this.zzb[i2] = doubleValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbH();
        byte[] bArr = zzgpw.zzd;
        collection.getClass();
        if (!(collection instanceof zzgov)) {
            return super.addAll(collection);
        }
        zzgov zzgov = (zzgov) collection;
        int i2 = zzgov.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.zzb;
            if (i4 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(zzgov.zzb, 0, this.zzb, this.zzc, zzgov.zzc);
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
        if (!(obj instanceof zzgov)) {
            return super.equals(obj);
        }
        zzgov zzgov = (zzgov) obj;
        if (this.zzc != zzgov.zzc) {
            return false;
        }
        double[] dArr = zzgov.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (Double.doubleToLongBits(this.zzb[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzg(i2);
        return Double.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            long doubleToLongBits = Double.doubleToLongBits(this.zzb[i3]);
            byte[] bArr = zzgpw.zzd;
            i2 = (i2 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == doubleValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbH();
        zzg(i2);
        double[] dArr = this.zzb;
        double d2 = dArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zzbH();
        if (i3 >= i2) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i3, dArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbH();
        zzg(i2);
        double[] dArr = this.zzb;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* bridge */ /* synthetic */ zzgpv zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzgov(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d2) {
        zzbH();
        int i2 = this.zzc;
        double[] dArr = this.zzb;
        if (i2 == dArr.length) {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i2);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        dArr3[i3] = d2;
    }

    private zzgov(double[] dArr, int i2, boolean z2) {
        super(z2);
        this.zzb = dArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
