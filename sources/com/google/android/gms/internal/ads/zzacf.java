package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

public final class zzacf {
    public static int zza(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    public static zzbz zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            int i3 = zzfj.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzer.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzads.zzb(new zzfa(Base64.decode(split[1], 0))));
                } catch (RuntimeException e2) {
                    zzer.zzg("VorbisUtil", "Failed to parse vorbis picture", e2);
                }
            } else {
                arrayList.add(new zzaff(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbz((List) arrayList);
    }

    public static zzacc zzc(zzfa zzfa, boolean z2, boolean z3) throws zzcd {
        if (z2) {
            zzd(3, zzfa, false);
        }
        String zzx = zzfa.zzx((int) zzfa.zzq(), zzfot.zzc);
        int length = zzx.length();
        long zzq = zzfa.zzq();
        String[] strArr = new String[((int) zzq)];
        int i2 = length + 15;
        for (int i3 = 0; ((long) i3) < zzq; i3++) {
            String zzx2 = zzfa.zzx((int) zzfa.zzq(), zzfot.zzc);
            strArr[i3] = zzx2;
            i2 = i2 + 4 + zzx2.length();
        }
        if (!z3 || (zzfa.zzk() & 1) != 0) {
            return new zzacc(zzx, strArr, i2 + 1);
        }
        throw zzcd.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i2, zzfa zzfa, boolean z2) throws zzcd {
        if (zzfa.zza() < 7) {
            if (z2) {
                return false;
            }
            int zza = zzfa.zza();
            throw zzcd.zza("too short header: " + zza, (Throwable) null);
        } else if (zzfa.zzk() != i2) {
            if (z2) {
                return false;
            }
            throw zzcd.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i2))), (Throwable) null);
        } else if (zzfa.zzk() == 118 && zzfa.zzk() == 111 && zzfa.zzk() == 114 && zzfa.zzk() == 98 && zzfa.zzk() == 105 && zzfa.zzk() == 115) {
            return true;
        } else {
            if (z2) {
                return false;
            }
            throw zzcd.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
