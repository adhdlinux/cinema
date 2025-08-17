package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzavl implements Comparator {
    public zzavl(zzavm zzavm) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzava zzava = (zzava) obj;
        zzava zzava2 = (zzava) obj2;
        if (zzava.zzd() < zzava2.zzd()) {
            return -1;
        }
        if (zzava.zzd() <= zzava2.zzd()) {
            if (zzava.zzb() < zzava2.zzb()) {
                return -1;
            }
            if (zzava.zzb() <= zzava2.zzb()) {
                float zza = (zzava.zza() - zzava.zzd()) * (zzava.zzc() - zzava.zzb());
                float zza2 = (zzava2.zza() - zzava2.zzd()) * (zzava2.zzc() - zzava2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza < zza2) {
                    return 1;
                }
                return 0;
            }
        }
        return 1;
    }
}
