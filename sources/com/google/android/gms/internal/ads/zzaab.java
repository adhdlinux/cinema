package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzaab {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final String zzi;

    private zzaab(List list, int i2, int i3, int i4, int i5, int i6, int i7, float f2, String str) {
        this.zza = list;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
        this.zzg = i7;
        this.zzh = f2;
        this.zzi = str;
    }

    public static zzaab zza(zzfa zzfa) throws zzcd {
        String str;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        try {
            zzfa.zzG(4);
            int zzk = (zzfa.zzk() & 3) + 1;
            if (zzk != 3) {
                ArrayList arrayList = new ArrayList();
                int zzk2 = zzfa.zzk() & 31;
                for (int i7 = 0; i7 < zzk2; i7++) {
                    arrayList.add(zzb(zzfa));
                }
                int zzk3 = zzfa.zzk();
                for (int i8 = 0; i8 < zzk3; i8++) {
                    arrayList.add(zzb(zzfa));
                }
                if (zzk2 > 0) {
                    zzft zze2 = zzfu.zze((byte[]) arrayList.get(0), zzk + 1, ((byte[]) arrayList.get(0)).length);
                    int i9 = zze2.zze;
                    int i10 = zze2.zzf;
                    int i11 = zze2.zzh;
                    int i12 = zze2.zzi;
                    int i13 = zze2.zzj;
                    float f3 = zze2.zzg;
                    str = zzea.zza(zze2.zza, zze2.zzb, zze2.zzc);
                    i3 = i12;
                    i2 = i13;
                    f2 = f3;
                    i6 = i9;
                    i5 = i10;
                    i4 = i11;
                } else {
                    str = null;
                    i6 = -1;
                    i5 = -1;
                    i4 = -1;
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new zzaab(arrayList, zzk, i6, i5, i4, i3, i2, f2, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw zzcd.zza("Error parsing AVC config", e2);
        }
    }

    private static byte[] zzb(zzfa zzfa) {
        int zzo = zzfa.zzo();
        int zzc2 = zzfa.zzc();
        zzfa.zzG(zzo);
        return zzea.zzc(zzfa.zzH(), zzc2, zzo);
    }
}
