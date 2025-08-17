package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.IOException;

public final class zzabf {
    public static int zza(zzfa zzfa, int i2) {
        switch (i2) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return zzfa.zzk() + 1;
            case 7:
                return zzfa.zzo() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return UserVerificationMethods.USER_VERIFY_HANDPRINT << (i2 - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzaax zzaax, zzabj zzabj) throws IOException {
        boolean z2;
        int i2;
        zzaax.zzj();
        zzaam zzaam = (zzaam) zzaax;
        zzaam.zzl(1, false);
        byte[] bArr = new byte[1];
        zzaam.zzm(bArr, 0, 1, false);
        byte b2 = bArr[0] & 1;
        if (1 != b2) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzaam.zzl(2, false);
        if (1 != b2) {
            i2 = 6;
        } else {
            i2 = 7;
        }
        zzfa zzfa = new zzfa(i2);
        zzfa.zzE(zzaba.zza(zzaax, zzfa.zzH(), 0, i2));
        zzaax.zzj();
        zzabe zzabe = new zzabe();
        if (zzd(zzfa, zzabj, z2, zzabe)) {
            return zzabe.zza;
        }
        throw zzcd.zza((String) null, (Throwable) null);
    }

    public static boolean zzc(zzfa zzfa, zzabj zzabj, int i2, zzabe zzabe) {
        boolean z2;
        int zza;
        zzfa zzfa2 = zzfa;
        zzabj zzabj2 = zzabj;
        int zzc = zzfa.zzc();
        long zzs = zzfa.zzs();
        long j2 = zzs >>> 16;
        if (j2 != ((long) i2)) {
            return false;
        }
        if ((j2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j3 = zzs >> 12;
        long j4 = zzs >> 8;
        long j5 = zzs >> 4;
        long j6 = zzs >> 1;
        long j7 = zzs & 1;
        int i3 = (int) (j5 & 15);
        if (i3 <= 7) {
            if (i3 != zzabj2.zzg - 1) {
                return false;
            }
        } else if (i3 > 10 || zzabj2.zzg != 2) {
            return false;
        }
        int i4 = (int) (j6 & 7);
        if ((i4 != 0 && i4 != zzabj2.zzi) || j7 == 1 || !zzd(zzfa2, zzabj2, z2, zzabe) || (zza = zza(zzfa2, (int) (j3 & 15))) == -1 || zza > zzabj2.zzb) {
            return false;
        }
        int i5 = zzabj2.zze;
        int i6 = (int) (j4 & 15);
        if (i6 != 0) {
            if (i6 <= 11) {
                if (i6 != zzabj2.zzf) {
                    return false;
                }
            } else if (i6 == 12) {
                if (zzfa.zzk() * 1000 != i5) {
                    return false;
                }
            } else if (i6 > 14) {
                return false;
            } else {
                int zzo = zzfa.zzo();
                if (i6 == 14) {
                    zzo *= 10;
                }
                if (zzo != i5) {
                    return false;
                }
            }
        }
        if (zzfa.zzk() == zzfj.zze(zzfa.zzH(), zzc, zzfa.zzc() - 1, 0)) {
            return true;
        }
        return false;
    }

    private static boolean zzd(zzfa zzfa, zzabj zzabj, boolean z2, zzabe zzabe) {
        try {
            long zzu = zzfa.zzu();
            if (!z2) {
                zzu *= (long) zzabj.zzb;
            }
            zzabe.zza = zzu;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
