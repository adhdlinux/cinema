package com.google.android.gms.internal.ads;

import com.unity3d.services.core.device.MimeTypes;

final class zzadf extends zzade {
    private final zzfa zzb = new zzfa(zzfu.zza);
    private final zzfa zzc = new zzfa(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzadf(zzabz zzabz) {
        super(zzabz);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfa zzfa) throws zzadd {
        int zzk = zzfa.zzk();
        int i2 = zzk >> 4;
        int i3 = zzk & 15;
        if (i3 == 7) {
            this.zzg = i2;
            if (i2 != 5) {
                return true;
            }
            return false;
        }
        throw new zzadd("Video format not supported: " + i3);
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfa zzfa, long j2) throws zzcd {
        int i2;
        int zzk = zzfa.zzk();
        long zzf2 = (long) zzfa.zzf();
        if (zzk == 0) {
            if (!this.zze) {
                zzfa zzfa2 = new zzfa(new byte[zzfa.zza()]);
                zzfa.zzB(zzfa2.zzH(), 0, zzfa.zza());
                zzaab zza = zzaab.zza(zzfa2);
                this.zzd = zza.zzb;
                zzak zzak = new zzak();
                zzak.zzS(MimeTypes.VIDEO_H264);
                zzak.zzx(zza.zzi);
                zzak.zzX(zza.zzc);
                zzak.zzF(zza.zzd);
                zzak.zzP(zza.zzh);
                zzak.zzI(zza.zza);
                this.zza.zzk(zzak.zzY());
                this.zze = true;
                return false;
            }
        } else if (zzk == 1 && this.zze) {
            if (this.zzg == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!this.zzf && i2 == 0) {
                return false;
            }
            byte[] zzH = this.zzc.zzH();
            zzH[0] = 0;
            zzH[1] = 0;
            zzH[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzfa.zza() > 0) {
                zzfa.zzB(this.zzc.zzH(), i3, this.zzd);
                this.zzc.zzF(0);
                int zzn = this.zzc.zzn();
                this.zzb.zzF(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzfa, zzn);
                i4 = i4 + 4 + zzn;
            }
            this.zza.zzs(j2 + (zzf2 * 1000), i2, i4, 0, (zzaby) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
