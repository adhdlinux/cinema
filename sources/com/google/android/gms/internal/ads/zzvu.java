package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzvu extends zzvw {
    private final zzxo zzd;
    private final zzfsc zze;
    private final zzdz zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzvu(zzcy zzcy, int[] iArr, int i2, zzxo zzxo, long j2, long j3, long j4, int i3, int i4, float f2, float f3, List list, zzdz zzdz) {
        super(zzcy, iArr, 0);
        zzcy zzcy2 = zzcy;
        int[] iArr2 = iArr;
        this.zzd = zzxo;
        this.zze = zzfsc.zzj(list);
        this.zzf = zzdz;
    }

    static /* bridge */ /* synthetic */ zzfsc zzf(zzwz[] zzwzArr) {
        int i2;
        int i3;
        zzfsc zzfsc;
        double d2;
        long j2;
        ArrayList arrayList = new ArrayList();
        char c2 = 0;
        int i4 = 0;
        while (true) {
            i2 = 2;
            i3 = 1;
            if (i4 >= 2) {
                break;
            }
            zzwz zzwz = zzwzArr[i4];
            if (zzwz == null || zzwz.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfrz zzfrz = new zzfrz();
                zzfrz.zzf(new zzvs(0, 0));
                arrayList.add(zzfrz);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzwz zzwz2 = zzwzArr[i5];
            if (zzwz2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzwz2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzwz2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    long j3 = (long) zzwz2.zza.zzb(iArr[i6]).zzi;
                    long[] jArr2 = jArr[i5];
                    if (j3 == -1) {
                        j3 = 0;
                    }
                    jArr2[i6] = j3;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            if (jArr4.length == 0) {
                j2 = 0;
            } else {
                j2 = jArr4[0];
            }
            jArr3[i7] = j2;
        }
        zzg(arrayList, jArr3);
        zzfsn zza = zzftg.zzc(zzftl.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i2) {
            int length = jArr[i8].length;
            if (length > i3) {
                double[] dArr = new double[length];
                int i9 = 0;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    double d3 = 0.0d;
                    if (i9 >= jArr5.length) {
                        break;
                    }
                    long j4 = jArr5[i9];
                    if (j4 != -1) {
                        d3 = Math.log((double) j4);
                    }
                    dArr[i9] = d3;
                    i9++;
                }
                int i10 = length - 1;
                double d4 = dArr[i10] - dArr[c2];
                int i11 = 0;
                while (i11 < i10) {
                    double d5 = dArr[i11];
                    i11++;
                    double d6 = d5 + dArr[i11];
                    if (d4 == 0.0d) {
                        d2 = 1.0d;
                    } else {
                        d2 = ((d6 * 0.5d) - dArr[c2]) / d4;
                    }
                    zza.zzq(Double.valueOf(d2), Integer.valueOf(i8));
                    c2 = 0;
                }
            }
            i8++;
            c2 = 0;
            i2 = 2;
            i3 = 1;
        }
        zzfsc zzj = zzfsc.zzj(zza.zzr());
        for (int i12 = 0; i12 < zzj.size(); i12++) {
            int intValue = ((Integer) zzj.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j5 = jArr3[i14];
                jArr3[i14] = j5 + j5;
            }
        }
        zzg(arrayList, jArr3);
        zzfrz zzfrz2 = new zzfrz();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfrz zzfrz3 = (zzfrz) arrayList.get(i15);
            if (zzfrz3 == null) {
                zzfsc = zzfsc.zzl();
            } else {
                zzfsc = zzfrz3.zzi();
            }
            zzfrz2.zzf(zzfsc);
        }
        return zzfrz2.zzi();
    }

    private static void zzg(List list, long[] jArr) {
        long j2 = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            j2 += jArr[i2];
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzfrz zzfrz = (zzfrz) list.get(i3);
            if (zzfrz != null) {
                zzfrz.zzf(new zzvs(j2, jArr[i3]));
            }
        }
    }
}
