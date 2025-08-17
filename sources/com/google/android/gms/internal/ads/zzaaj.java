package com.google.android.gms.internal.ads;

public final class zzaaj {
    public static void zza(long j2, zzfa zzfa, zzabz[] zzabzArr) {
        int i2;
        boolean z2;
        while (true) {
            boolean z3 = true;
            if (zzfa.zza() > 1) {
                int zzc = zzc(zzfa);
                int zzc2 = zzc(zzfa);
                int zzc3 = zzfa.zzc() + zzc2;
                if (zzc2 == -1 || zzc2 > zzfa.zza()) {
                    zzer.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzc3 = zzfa.zzd();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzk = zzfa.zzk();
                    int zzo = zzfa.zzo();
                    if (zzo == 49) {
                        i2 = zzfa.zze();
                        zzo = 49;
                    } else {
                        i2 = 0;
                    }
                    int zzk2 = zzfa.zzk();
                    if (zzo == 47) {
                        zzfa.zzG(1);
                        zzo = 47;
                    }
                    if (zzk == 181 && ((zzo == 49 || zzo == 47) && zzk2 == 3)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (zzo == 49) {
                        if (i2 != 1195456820) {
                            z3 = false;
                        }
                        z2 &= z3;
                    }
                    if (z2) {
                        zzb(j2, zzfa, zzabzArr);
                    }
                }
                zzfa.zzF(zzc3);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j2, zzfa zzfa, zzabz[] zzabzArr) {
        int zzk = zzfa.zzk();
        if ((zzk & 64) != 0) {
            int i2 = zzk & 31;
            zzfa.zzG(1);
            int zzc = zzfa.zzc();
            for (zzabz zzabz : zzabzArr) {
                int i3 = i2 * 3;
                zzfa.zzF(zzc);
                zzabz.zzq(zzfa, i3);
                if (j2 != -9223372036854775807L) {
                    zzabz.zzs(j2, 1, i3, 0, (zzaby) null);
                }
            }
        }
    }

    private static int zzc(zzfa zzfa) {
        int i2 = 0;
        while (zzfa.zza() != 0) {
            int zzk = zzfa.zzk();
            i2 += zzk;
            if (zzk != 255) {
                return i2;
            }
        }
        return -1;
    }
}
