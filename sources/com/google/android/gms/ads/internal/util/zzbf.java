package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzbf {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze = 0;

    /* synthetic */ zzbf(zzbd zzbd, zzbe zzbe) {
        int size = zzbd.zzb.size();
        this.zza = (String[]) zzbd.zza.toArray(new String[size]);
        this.zzb = zzc(zzbd.zzb);
        this.zzc = zzc(zzbd.zzc);
        this.zzd = new int[size];
    }

    private static final double[] zzc(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = ((Double) list.get(i2)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList(this.zza.length);
        int i2 = 0;
        while (true) {
            String[] strArr = this.zza;
            if (i2 >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i2];
            double d2 = this.zzc[i2];
            double d3 = this.zzb[i2];
            int i3 = this.zzd[i2];
            arrayList.add(new zzbc(str, d2, d3, ((double) i3) / ((double) this.zze), i3));
            i2++;
        }
    }

    public final void zzb(double d2) {
        this.zze++;
        int i2 = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i2 < dArr.length) {
                double d3 = dArr[i2];
                if (d3 <= d2 && d2 < this.zzb[i2]) {
                    int[] iArr = this.zzd;
                    iArr[i2] = iArr[i2] + 1;
                }
                if (d2 >= d3) {
                    i2++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
