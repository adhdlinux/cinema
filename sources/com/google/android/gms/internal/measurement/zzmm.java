package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

public final class zzmm {
    private static final zzmm zza = new zzmm(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmm() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmm(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzmm zzc() {
        return zza;
    }

    static zzmm zzd(zzmm zzmm, zzmm zzmm2) {
        int i2 = zzmm.zzb + zzmm2.zzb;
        int[] copyOf = Arrays.copyOf(zzmm.zzc, i2);
        System.arraycopy(zzmm2.zzc, 0, copyOf, zzmm.zzb, zzmm2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmm.zzd, i2);
        System.arraycopy(zzmm2.zzd, 0, copyOf2, zzmm.zzb, zzmm2.zzb);
        return new zzmm(i2, copyOf, copyOf2, true);
    }

    static zzmm zze() {
        return new zzmm(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmm)) {
            return false;
        }
        zzmm zzmm = (zzmm) obj;
        int i2 = this.zzb;
        if (i2 == zzmm.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmm.zzc;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmm.zzd;
                    int i4 = this.zzb;
                    int i5 = 0;
                    while (i5 < i4) {
                        if (objArr[i5].equals(objArr2[i5])) {
                            i5++;
                        }
                    }
                    return true;
                } else if (iArr[i3] != iArr2[i3]) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return i7 + i4;
    }

    public final int zza() {
        int i2;
        int i3;
        int i4;
        int i5 = this.zze;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.zzb; i7++) {
            int i8 = this.zzc[i7];
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i10 != 0) {
                if (i10 == 1) {
                    ((Long) this.zzd[i7]).longValue();
                    i2 = zzjj.zzA(i9 << 3) + 8;
                } else if (i10 == 2) {
                    int zzA = zzjj.zzA(i9 << 3);
                    int zzd2 = ((zzjb) this.zzd[i7]).zzd();
                    i6 += zzA + zzjj.zzA(zzd2) + zzd2;
                } else if (i10 == 3) {
                    int zzz = zzjj.zzz(i9);
                    i4 = zzz + zzz;
                    i3 = ((zzmm) this.zzd[i7]).zza();
                } else if (i10 == 5) {
                    ((Integer) this.zzd[i7]).intValue();
                    i2 = zzjj.zzA(i9 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzkm.zza());
                }
                i6 += i2;
            } else {
                long longValue = ((Long) this.zzd[i7]).longValue();
                i4 = zzjj.zzA(i9 << 3);
                i3 = zzjj.zzB(longValue);
            }
            i2 = i4 + i3;
            i6 += i2;
        }
        this.zze = i6;
        return i6;
    }

    public final int zzb() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int zzA = zzjj.zzA(8);
            int zzd2 = ((zzjb) this.zzd[i4]).zzd();
            i3 += zzA + zzA + zzjj.zzA(16) + zzjj.zzA(i5 >>> 3) + zzjj.zzA(24) + zzjj.zzA(zzd2) + zzd2;
        }
        this.zze = i3;
        return i3;
    }

    public final void zzf() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzll.zzb(sb, i2, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzh(int i2, Object obj) {
        int i3;
        if (this.zzf) {
            int i4 = this.zzb;
            int[] iArr = this.zzc;
            if (i4 == iArr.length) {
                if (i4 < 4) {
                    i3 = 8;
                } else {
                    i3 = i4 >> 1;
                }
                int i5 = i4 + i3;
                this.zzc = Arrays.copyOf(iArr, i5);
                this.zzd = Arrays.copyOf(this.zzd, i5);
            }
            int[] iArr2 = this.zzc;
            int i6 = this.zzb;
            iArr2[i6] = i2;
            this.zzd[i6] = obj;
            this.zzb = i6 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzi(zznd zznd) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i3 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i4 = i3 >>> 3;
                int i5 = i3 & 7;
                if (i5 == 0) {
                    zznd.zzt(i4, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zznd.zzm(i4, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zznd.zzd(i4, (zzjb) obj);
                } else if (i5 == 3) {
                    zznd.zzE(i4);
                    ((zzmm) obj).zzi(zznd);
                    zznd.zzh(i4);
                } else if (i5 == 5) {
                    zznd.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzkm.zza());
                }
            }
        }
    }
}
