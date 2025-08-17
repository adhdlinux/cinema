package com.google.android.gms.internal.ads;

import java.util.Collections;

final class zzacz extends zzade {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzacz(zzabz zzabz) {
        super(zzabz);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfa zzfa) throws zzadd {
        String str;
        if (!this.zzc) {
            int zzk = zzfa.zzk();
            int i2 = zzk >> 4;
            this.zze = i2;
            if (i2 == 2) {
                int i3 = zzb[(zzk >> 2) & 3];
                zzak zzak = new zzak();
                zzak.zzS("audio/mpeg");
                zzak.zzw(1);
                zzak.zzT(i3);
                this.zza.zzk(zzak.zzY());
                this.zzd = true;
            } else if (i2 == 7 || i2 == 8) {
                zzak zzak2 = new zzak();
                if (i2 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zzak2.zzS(str);
                zzak2.zzw(1);
                zzak2.zzT(8000);
                this.zza.zzk(zzak2.zzY());
                this.zzd = true;
            } else if (i2 != 10) {
                throw new zzadd("Audio format not supported: " + i2);
            }
            this.zzc = true;
        } else {
            zzfa.zzG(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfa zzfa, long j2) throws zzcd {
        if (this.zze == 2) {
            int zza = zzfa.zza();
            this.zza.zzq(zzfa, zza);
            this.zza.zzs(j2, 1, zza, 0, (zzaby) null);
            return true;
        }
        int zzk = zzfa.zzk();
        if (zzk == 0 && !this.zzd) {
            int zza2 = zzfa.zza();
            byte[] bArr = new byte[zza2];
            zzfa.zzB(bArr, 0, zza2);
            zzzt zza3 = zzzu.zza(bArr);
            zzak zzak = new zzak();
            zzak.zzS("audio/mp4a-latm");
            zzak.zzx(zza3.zzc);
            zzak.zzw(zza3.zzb);
            zzak.zzT(zza3.zza);
            zzak.zzI(Collections.singletonList(bArr));
            this.zza.zzk(zzak.zzY());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzk != 1) {
            return false;
        } else {
            int zza4 = zzfa.zza();
            this.zza.zzq(zzfa, zza4);
            this.zza.zzs(j2, 1, zza4, 0, (zzaby) null);
            return true;
        }
    }
}
