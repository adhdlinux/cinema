package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgql extends zzgno implements RandomAccess, zzgpu, zzgrd {
    private static final zzgql zza = new zzgql(new long[0], 0, false);
    private long[] zzb;
    private int zzc;

    zzgql() {
        this(new long[10], 0, true);
    }

    public static zzgql zzf() {
        return zza;
    }

    private final String zzh(int i2) {
        int i3 = this.zzc;
        return "Index:" + i2 + ", Size:" + i3;
    }

    private final void zzi(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i2));
        }
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        long longValue = ((Long) obj).longValue();
        zzbH();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i2));
        }
        long[] jArr = this.zzb;
        if (i3 < jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
        } else {
            long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            System.arraycopy(this.zzb, i2, jArr2, i2 + 1, this.zzc - i2);
            this.zzb = jArr2;
        }
        this.zzb[i2] = longValue;
        this.zzc++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        zzbH();
        byte[] bArr = zzgpw.zzd;
        collection.getClass();
        if (!(collection instanceof zzgql)) {
            return super.addAll(collection);
        }
        zzgql zzgql = (zzgql) collection;
        int i2 = zzgql.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.zzb;
            if (i4 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(zzgql.zzb, 0, this.zzb, this.zzc, zzgql.zzc);
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
        if (!(obj instanceof zzgql)) {
            return super.equals(obj);
        }
        zzgql zzgql = (zzgql) obj;
        if (this.zzc != zzgql.zzc) {
            return false;
        }
        long[] jArr = zzgql.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (this.zzb[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzi(i2);
        return Long.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            long j2 = this.zzb[i3];
            byte[] bArr = zzgpw.zzd;
            i2 = (i2 * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == longValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbH();
        zzi(i2);
        long[] jArr = this.zzb;
        long j2 = jArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Long.valueOf(j2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zzbH();
        if (i3 >= i2) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, i3, jArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbH();
        zzi(i2);
        long[] jArr = this.zzb;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    public final int size() {
        return this.zzc;
    }

    /* renamed from: zza */
    public final zzgpu zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzgql(Arrays.copyOf(this.zzb, i2), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i2) {
        zzi(i2);
        return this.zzb[i2];
    }

    public final void zzg(long j2) {
        zzbH();
        int i2 = this.zzc;
        long[] jArr = this.zzb;
        if (i2 == jArr.length) {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i2);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        jArr3[i3] = j2;
    }

    private zzgql(long[] jArr, int i2, boolean z2) {
        super(z2);
        this.zzb = jArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
