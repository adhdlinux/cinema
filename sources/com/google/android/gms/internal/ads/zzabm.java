package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

public final class zzabm {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final float zzf;
    public final String zzg;

    private zzabm(List list, int i2, int i3, int i4, int i5, int i6, int i7, float f2, String str) {
        this.zza = list;
        this.zzb = i2;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = f2;
        this.zzg = str;
    }

    public static zzabm zza(zzfa zzfa) throws zzcd {
        List list;
        int i2;
        int i3;
        zzfa zzfa2 = zzfa;
        try {
            zzfa2.zzG(21);
            int zzk = zzfa.zzk() & 3;
            int zzk2 = zzfa.zzk();
            int zzc2 = zzfa.zzc();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < zzk2; i6++) {
                zzfa2.zzG(1);
                int zzo = zzfa.zzo();
                for (int i7 = 0; i7 < zzo; i7++) {
                    int zzo2 = zzfa.zzo();
                    i5 += zzo2 + 4;
                    zzfa2.zzG(zzo2);
                }
            }
            zzfa2.zzF(zzc2);
            byte[] bArr = new byte[i5];
            String str = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            int i14 = -1;
            float f2 = 1.0f;
            while (i8 < zzk2) {
                int zzk3 = zzfa.zzk() & 63;
                int zzo3 = zzfa.zzo();
                int i15 = 0;
                while (i15 < zzo3) {
                    int zzo4 = zzfa.zzo();
                    int i16 = zzk2;
                    System.arraycopy(zzfu.zza, i4, bArr, i9, 4);
                    int i17 = i9 + 4;
                    System.arraycopy(zzfa.zzH(), zzfa.zzc(), bArr, i17, zzo4);
                    if (zzk3 == 33 && i15 == 0) {
                        zzfr zzc3 = zzfu.zzc(bArr, i17 + 2, i17 + zzo4);
                        i10 = zzc3.zzg;
                        i11 = zzc3.zzh;
                        i12 = zzc3.zzj;
                        int i18 = zzc3.zzk;
                        int i19 = zzc3.zzl;
                        float f3 = zzc3.zzi;
                        i3 = zzk3;
                        i2 = zzo3;
                        int i20 = i19;
                        str = zzea.zzb(zzc3.zza, zzc3.zzb, zzc3.zzc, zzc3.zzd, zzc3.zze, zzc3.zzf);
                        i15 = 0;
                        int i21 = i20;
                        f2 = f3;
                        i13 = i18;
                        i14 = i21;
                    } else {
                        i3 = zzk3;
                        i2 = zzo3;
                    }
                    i9 = i17 + zzo4;
                    zzfa2.zzG(zzo4);
                    i15++;
                    zzk2 = i16;
                    zzk3 = i3;
                    zzo3 = i2;
                    i4 = 0;
                }
                int i22 = zzk2;
                i8++;
                i4 = 0;
            }
            if (i5 == 0) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzabm(list, zzk + 1, i10, i11, i12, i13, i14, f2, str);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw zzcd.zza("Error parsing HEVC config", e2);
        }
    }
}
