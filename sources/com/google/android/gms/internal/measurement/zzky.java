package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzky extends zzim implements RandomAccess, zzki, zzlq {
    private static final zzky zza;
    private long[] zzb;
    private int zzc;

    static {
        zzky zzky = new zzky(new long[0], 0);
        zza = zzky;
        zzky.zzb();
    }

    zzky() {
        this(new long[10], 0);
    }

    public static zzky zzf() {
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
        zzbS();
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
        zzbS();
        zzkk.zze(collection);
        if (!(collection instanceof zzky)) {
            return super.addAll(collection);
        }
        zzky zzky = (zzky) collection;
        int i2 = zzky.zzc;
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
            System.arraycopy(zzky.zzb, 0, this.zzb, this.zzc, zzky.zzc);
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
        if (!(obj instanceof zzky)) {
            return super.equals(obj);
        }
        zzky zzky = (zzky) obj;
        if (this.zzc != zzky.zzc) {
            return false;
        }
        long[] jArr = zzky.zzb;
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
            i2 = (i2 * 31) + zzkk.zzc(this.zzb[i3]);
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
        zzbS();
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
        zzbS();
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
        zzbS();
        zzi(i2);
        long[] jArr = this.zzb;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    public final int size() {
        return this.zzc;
    }

    public final long zza(int i2) {
        zzi(i2);
        return this.zzb[i2];
    }

    /* renamed from: zze */
    public final zzki zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzky(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(long j2) {
        zzbS();
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

    private zzky(long[] jArr, int i2) {
        this.zzb = jArr;
        this.zzc = i2;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
