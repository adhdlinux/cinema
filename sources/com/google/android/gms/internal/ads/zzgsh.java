package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

public final class zzgsh {
    private static final zzgsh zza = new zzgsh(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzgsh() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgsh(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = i2;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzgsh zzc() {
        return zza;
    }

    static zzgsh zze(zzgsh zzgsh, zzgsh zzgsh2) {
        int i2 = zzgsh.zzb + zzgsh2.zzb;
        int[] copyOf = Arrays.copyOf(zzgsh.zzc, i2);
        System.arraycopy(zzgsh2.zzc, 0, copyOf, zzgsh.zzb, zzgsh2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgsh.zzd, i2);
        System.arraycopy(zzgsh2.zzd, 0, copyOf2, zzgsh.zzb, zzgsh2.zzb);
        return new zzgsh(i2, copyOf, copyOf2, true);
    }

    static zzgsh zzf() {
        return new zzgsh(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i2) {
        int[] iArr = this.zzc;
        if (i2 > iArr.length) {
            int i3 = this.zzb;
            int i4 = i3 + (i3 / 2);
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i2);
            this.zzd = Arrays.copyOf(this.zzd, i2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgsh)) {
            return false;
        }
        zzgsh zzgsh = (zzgsh) obj;
        int i2 = this.zzb;
        if (i2 == zzgsh.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgsh.zzc;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgsh.zzd;
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
        int i3 = i2 + 527;
        int[] iArr = this.zzc;
        int i4 = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 * 31) + i5;
        Object[] objArr = this.zzd;
        int i8 = this.zzb;
        for (int i9 = 0; i9 < i8; i9++) {
            i4 = (i4 * 31) + objArr[i9].hashCode();
        }
        return (i7 * 31) + i4;
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
                    i2 = zzgot.zzA(i9 << 3) + 8;
                } else if (i10 == 2) {
                    int i11 = zzgot.zzf;
                    int zzd2 = ((zzgoe) this.zzd[i7]).zzd();
                    i2 = zzgot.zzA(i9 << 3) + zzgot.zzA(zzd2) + zzd2;
                } else if (i10 == 3) {
                    int i12 = i9 << 3;
                    int i13 = zzgot.zzf;
                    i3 = ((zzgsh) this.zzd[i7]).zza();
                    int zzA = zzgot.zzA(i12);
                    i4 = zzA + zzA;
                } else if (i10 == 5) {
                    ((Integer) this.zzd[i7]).intValue();
                    i2 = zzgot.zzA(i9 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzgpy.zza());
                }
                i6 += i2;
            } else {
                int i14 = i9 << 3;
                i3 = zzgot.zzB(((Long) this.zzd[i7]).longValue());
                i4 = zzgot.zzA(i14);
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
            int i5 = zzgot.zzf;
            int zzd2 = ((zzgoe) this.zzd[i4]).zzd();
            int zzA = zzgot.zzA(zzd2) + zzd2;
            int zzA2 = zzgot.zzA(16);
            int zzA3 = zzgot.zzA(this.zzc[i4] >>> 3);
            int zzA4 = zzgot.zzA(8);
            i3 += zzA4 + zzA4 + zzA2 + zzA3 + zzgot.zzA(24) + zzA;
        }
        this.zze = i3;
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final zzgsh zzd(zzgsh zzgsh) {
        if (zzgsh.equals(zza)) {
            return this;
        }
        zzg();
        int i2 = this.zzb + zzgsh.zzb;
        zzl(i2);
        System.arraycopy(zzgsh.zzc, 0, this.zzc, this.zzb, zzgsh.zzb);
        System.arraycopy(zzgsh.zzd, 0, this.zzd, this.zzb, zzgsh.zzb);
        this.zzb = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.zzb; i3++) {
            zzgqy.zzb(sb, i2, String.valueOf(this.zzc[i3] >>> 3), this.zzd[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i2, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i3 = this.zzb;
        iArr[i3] = i2;
        this.zzd[i3] = obj;
        this.zzb = i3 + 1;
    }

    public final void zzk(zzgou zzgou) throws IOException {
        if (this.zzb != 0) {
            for (int i2 = 0; i2 < this.zzb; i2++) {
                int i3 = this.zzc[i2];
                Object obj = this.zzd[i2];
                int i4 = i3 & 7;
                int i5 = i3 >>> 3;
                if (i4 == 0) {
                    zzgou.zzt(i5, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    zzgou.zzm(i5, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    zzgou.zzd(i5, (zzgoe) obj);
                } else if (i4 == 3) {
                    zzgou.zzE(i5);
                    ((zzgsh) obj).zzk(zzgou);
                    zzgou.zzh(i5);
                } else if (i4 == 5) {
                    zzgou.zzk(i5, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzgpy.zza());
                }
            }
        }
    }
}
