package com.google.android.gms.internal.cast;

import java.util.Arrays;

public final class zzus {
    private static final zzus zza = new zzus(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzus() {
        this(0, new int[8], new Object[8], true);
    }

    private zzus(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z2;
    }

    public static zzus zzc() {
        return zza;
    }

    static zzus zze(zzus zzus, zzus zzus2) {
        int i2 = zzus.zzb;
        int i3 = zzus2.zzb;
        int[] copyOf = Arrays.copyOf(zzus.zzc, 0);
        System.arraycopy(zzus2.zzc, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzus.zzd, 0);
        System.arraycopy(zzus2.zzd, 0, copyOf2, 0, 0);
        return new zzus(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzus)) {
            return false;
        }
        zzus zzus = (zzus) obj;
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        this.zze = 0;
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final zzus zzd(zzus zzus) {
        if (zzus.equals(zza)) {
            return this;
        }
        if (this.zzf) {
            int[] iArr = this.zzc;
            int length = iArr.length;
            System.arraycopy(zzus.zzc, 0, iArr, 0, 0);
            System.arraycopy(zzus.zzd, 0, this.zzd, 0, 0);
            this.zzb = 0;
            return this;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzf() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzg(StringBuilder sb, int i2) {
    }
}
