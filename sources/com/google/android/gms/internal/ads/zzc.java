package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

public final class zzc {
    public static final zzn zza = zzb.zza;
    private static final String zzi = Integer.toString(0, 36);
    private static final String zzj = Integer.toString(1, 36);
    private static final String zzk = Integer.toString(2, 36);
    private static final String zzl = Integer.toString(3, 36);
    private static final String zzm = Integer.toString(4, 36);
    private static final String zzn = Integer.toString(5, 36);
    private static final String zzo = Integer.toString(6, 36);
    private static final String zzp = Integer.toString(7, 36);
    public final long zzb;
    public final int zzc;
    public final Uri[] zzd;
    public final int[] zze;
    public final long[] zzf;
    public final long zzg;
    public final boolean zzh;

    public zzc(long j2) {
        this(0, -1, -1, new int[0], new Uri[0], new long[0], 0, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzc.class == obj.getClass()) {
            zzc zzc2 = (zzc) obj;
            if (this.zzc != zzc2.zzc || !Arrays.equals(this.zzd, zzc2.zzd) || !Arrays.equals(this.zze, zzc2.zze) || !Arrays.equals(this.zzf, zzc2.zzf)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzc * 31) - 1) * 961) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze)) * 31) + Arrays.hashCode(this.zzf)) * 961;
    }

    public final int zza(int i2) {
        int i3;
        int i4 = i2 + 1;
        while (true) {
            int[] iArr = this.zze;
            if (i4 >= iArr.length || (i3 = iArr[i4]) == 0 || i3 == 1) {
                return i4;
            }
            i4++;
        }
        return i4;
    }

    public final zzc zzb(int i2) {
        int[] iArr = this.zze;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzf;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new zzc(0, 0, -1, copyOf, (Uri[]) Arrays.copyOf(this.zzd, 0), copyOf2, 0, false);
    }

    private zzc(long j2, int i2, int i3, int[] iArr, Uri[] uriArr, long[] jArr, long j3, boolean z2) {
        zzdy.zzd(iArr.length == uriArr.length);
        this.zzb = 0;
        this.zzc = i2;
        this.zze = iArr;
        this.zzd = uriArr;
        this.zzf = jArr;
        this.zzg = 0;
        this.zzh = false;
    }
}
