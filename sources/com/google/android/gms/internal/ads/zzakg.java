package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

final class zzakg {
    public static Pair zza(zzaax zzaax) throws IOException {
        zzaax.zzj();
        zzakf zzd = zzd(1684108385, zzaax, new zzfa(8));
        ((zzaam) zzaax).zzo(8, false);
        return Pair.create(Long.valueOf(zzaax.zzf()), Long.valueOf(zzd.zzb));
    }

    public static zzake zzb(zzaax zzaax) throws IOException {
        boolean z2;
        byte[] bArr;
        zzaax zzaax2 = zzaax;
        zzfa zzfa = new zzfa(16);
        zzakf zzd = zzd(1718449184, zzaax2, zzfa);
        if (zzd.zzb >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        zzaam zzaam = (zzaam) zzaax2;
        zzaam.zzm(zzfa.zzH(), 0, 16, false);
        zzfa.zzF(0);
        int zzi = zzfa.zzi();
        int zzi2 = zzfa.zzi();
        int zzh = zzfa.zzh();
        int zzh2 = zzfa.zzh();
        int zzi3 = zzfa.zzi();
        int zzi4 = zzfa.zzi();
        int i2 = ((int) zzd.zzb) - 16;
        if (i2 > 0) {
            bArr = new byte[i2];
            zzaam.zzm(bArr, 0, i2, false);
        } else {
            bArr = zzfj.zzf;
        }
        byte[] bArr2 = bArr;
        ((zzaam) zzaax2).zzo((int) (zzaax.zze() - zzaax.zzf()), false);
        return new zzake(zzi, zzi2, zzh, zzh2, zzi3, zzi4, bArr2);
    }

    public static boolean zzc(zzaax zzaax) throws IOException {
        zzfa zzfa = new zzfa(8);
        int i2 = zzakf.zza(zzaax, zzfa).zza;
        if (i2 != 1380533830 && i2 != 1380333108) {
            return false;
        }
        ((zzaam) zzaax).zzm(zzfa.zzH(), 0, 4, false);
        zzfa.zzF(0);
        int zze = zzfa.zze();
        if (zze == 1463899717) {
            return true;
        }
        zzer.zzc("WavHeaderReader", "Unsupported form type: " + zze);
        return false;
    }

    private static zzakf zzd(int i2, zzaax zzaax, zzfa zzfa) throws IOException {
        zzakf zza = zzakf.zza(zzaax, zzfa);
        while (true) {
            int i3 = zza.zza;
            if (i3 == i2) {
                return zza;
            }
            zzer.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i3);
            long j2 = zza.zzb + 8;
            if (j2 <= 2147483647L) {
                ((zzaam) zzaax).zzo((int) j2, false);
                zza = zzakf.zza(zzaax, zzfa);
            } else {
                int i4 = zza.zza;
                throw zzcd.zzc("Chunk is too large (~2GB+) to skip; id: " + i4);
            }
        }
    }
}
