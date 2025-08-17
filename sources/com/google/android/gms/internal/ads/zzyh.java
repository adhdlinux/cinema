package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class zzyh {
    private static final Comparator zza = zzyd.zza;
    private static final Comparator zzb = zzye.zza;
    private final ArrayList zzc = new ArrayList();
    private final zzyg[] zzd = new zzyg[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzyh(int i2) {
    }

    public final float zza(float f2) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f3 = (float) this.zzg;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.size(); i3++) {
            zzyg zzyg = (zzyg) this.zzc.get(i3);
            i2 += zzyg.zzb;
            if (((float) i2) >= 0.5f * f3) {
                return zzyg.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzyg) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i2, float f2) {
        zzyg zzyg;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i3 = this.zzh;
        if (i3 > 0) {
            zzyg[] zzygArr = this.zzd;
            int i4 = i3 - 1;
            this.zzh = i4;
            zzyg = zzygArr[i4];
        } else {
            zzyg = new zzyg((zzyf) null);
        }
        int i5 = this.zzf;
        this.zzf = i5 + 1;
        zzyg.zza = i5;
        zzyg.zzb = i2;
        zzyg.zzc = f2;
        this.zzc.add(zzyg);
        this.zzg += i2;
        while (true) {
            int i6 = this.zzg;
            if (i6 > 2000) {
                int i7 = i6 - 2000;
                zzyg zzyg2 = (zzyg) this.zzc.get(0);
                int i8 = zzyg2.zzb;
                if (i8 <= i7) {
                    this.zzg -= i8;
                    this.zzc.remove(0);
                    int i9 = this.zzh;
                    if (i9 < 5) {
                        zzyg[] zzygArr2 = this.zzd;
                        this.zzh = i9 + 1;
                        zzygArr2[i9] = zzyg2;
                    }
                } else {
                    zzyg2.zzb = i8 - i7;
                    this.zzg -= i7;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
