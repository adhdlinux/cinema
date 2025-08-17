package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

public final class zzacy implements zzaaw {
    public static final zzabd zza = zzacx.zza;
    private final byte[] zzb;
    private final zzfa zzc;
    private final zzabe zzd;
    private zzaaz zze;
    private zzabz zzf;
    private int zzg;
    private zzbz zzh;
    private zzabj zzi;
    private int zzj;
    private int zzk;
    private zzacw zzl;
    private int zzm;
    private long zzn;

    public zzacy() {
        this(0);
    }

    private final long zze(zzfa zzfa, boolean z2) {
        boolean z3;
        this.zzi.getClass();
        int zzc2 = zzfa.zzc();
        while (zzc2 <= zzfa.zzd() - 16) {
            zzfa.zzF(zzc2);
            if (zzabf.zzc(zzfa, this.zzi, this.zzk, this.zzd)) {
                zzfa.zzF(zzc2);
                return this.zzd.zza;
            }
            zzc2++;
        }
        if (z2) {
            while (zzc2 <= zzfa.zzd() - this.zzj) {
                zzfa.zzF(zzc2);
                try {
                    z3 = zzabf.zzc(zzfa, this.zzi, this.zzk, this.zzd);
                } catch (IndexOutOfBoundsException unused) {
                    z3 = false;
                }
                if (zzfa.zzc() <= zzfa.zzd() && z3) {
                    zzfa.zzF(zzc2);
                    return this.zzd.zza;
                }
                zzc2++;
            }
            zzfa.zzF(zzfa.zzd());
            return -1;
        }
        zzfa.zzF(zzc2);
        return -1;
    }

    private final void zzf() {
        zzabj zzabj = this.zzi;
        int i2 = zzfj.zza;
        this.zzf.zzs((this.zzn * 1000000) / ((long) zzabj.zze), 1, this.zzm, 0, (zzaby) null);
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        boolean zzn2;
        zzabv zzabv;
        zzaax zzaax2 = zzaax;
        int i2 = this.zzg;
        boolean z2 = true;
        if (i2 == 0) {
            zzaax.zzj();
            long zze2 = zzaax.zze();
            zzbz zza2 = zzabg.zza(zzaax2, true);
            ((zzaam) zzaax2).zzo((int) (zzaax.zze() - zze2), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        } else if (i2 == 1) {
            ((zzaam) zzaax2).zzm(this.zzb, 0, 42, false);
            zzaax.zzj();
            this.zzg = 2;
            return 0;
        } else if (i2 == 2) {
            zzfa zzfa = new zzfa(4);
            ((zzaam) zzaax2).zzn(zzfa.zzH(), 0, 4, false);
            if (zzfa.zzs() == 1716281667) {
                this.zzg = 3;
                return 0;
            }
            throw zzcd.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i2 == 3) {
            zzabj zzabj = this.zzi;
            do {
                zzaax.zzj();
                zzez zzez = new zzez(new byte[4], 4);
                zzaam zzaam = (zzaam) zzaax2;
                zzaam.zzm(zzez.zza, 0, 4, false);
                zzn2 = zzez.zzn();
                int zzd2 = zzez.zzd(7);
                int zzd3 = zzez.zzd(24) + 4;
                if (zzd2 == 0) {
                    byte[] bArr = new byte[38];
                    zzaam.zzn(bArr, 0, 38, false);
                    zzabj = new zzabj(bArr, 4);
                } else if (zzabj == null) {
                    throw new IllegalArgumentException();
                } else if (zzd2 == 3) {
                    zzfa zzfa2 = new zzfa(zzd3);
                    zzaam.zzn(zzfa2.zzH(), 0, zzd3, false);
                    zzabj = zzabj.zzf(zzabg.zzb(zzfa2));
                } else if (zzd2 == 4) {
                    zzfa zzfa3 = new zzfa(zzd3);
                    zzaam.zzn(zzfa3.zzH(), 0, zzd3, false);
                    zzfa3.zzG(4);
                    zzabj = zzabj.zzg(Arrays.asList(zzacf.zzc(zzfa3, false, false).zzb));
                } else if (zzd2 == 6) {
                    zzfa zzfa4 = new zzfa(zzd3);
                    zzaam.zzn(zzfa4.zzH(), 0, zzd3, false);
                    zzfa4.zzG(4);
                    zzabj = zzabj.zze(zzfsc.zzm(zzads.zzb(zzfa4)));
                } else {
                    zzaam.zzo(zzd3, false);
                }
                int i3 = zzfj.zza;
                this.zzi = zzabj;
            } while (!zzn2);
            zzabj.getClass();
            this.zzj = Math.max(zzabj.zzc, 6);
            this.zzf.zzk(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        } else if (i2 != 4) {
            this.zzf.getClass();
            zzabj zzabj2 = this.zzi;
            zzabj2.getClass();
            zzacw zzacw = this.zzl;
            if (zzacw != null && zzacw.zze()) {
                return zzacw.zza(zzaax2, zzabs);
            }
            if (this.zzn == -1) {
                this.zzn = zzabf.zzb(zzaax2, zzabj2);
                return 0;
            }
            zzfa zzfa5 = this.zzc;
            int zzd4 = zzfa5.zzd();
            if (zzd4 < 32768) {
                int zza3 = zzaax2.zza(zzfa5.zzH(), zzd4, 32768 - zzd4);
                if (zza3 != -1) {
                    z2 = false;
                }
                if (!z2) {
                    this.zzc.zzE(zzd4 + zza3);
                } else if (this.zzc.zza() == 0) {
                    zzf();
                    return -1;
                }
            } else {
                z2 = false;
            }
            zzfa zzfa6 = this.zzc;
            int zzc2 = zzfa6.zzc();
            int i4 = this.zzm;
            int i5 = this.zzj;
            if (i4 < i5) {
                zzfa6.zzG(Math.min(i5 - i4, zzfa6.zza()));
            }
            long zze3 = zze(this.zzc, z2);
            zzfa zzfa7 = this.zzc;
            int zzc3 = zzfa7.zzc() - zzc2;
            zzfa7.zzF(zzc2);
            zzabx.zzb(this.zzf, this.zzc, zzc3);
            this.zzm += zzc3;
            if (zze3 != -1) {
                zzf();
                this.zzm = 0;
                this.zzn = zze3;
            }
            zzfa zzfa8 = this.zzc;
            if (zzfa8.zza() >= 16) {
                return 0;
            }
            int zza4 = zzfa8.zza();
            System.arraycopy(zzfa8.zzH(), zzfa8.zzc(), zzfa8.zzH(), 0, zza4);
            this.zzc.zzF(0);
            this.zzc.zzE(zza4);
            return 0;
        } else {
            zzaax.zzj();
            zzfa zzfa9 = new zzfa(2);
            ((zzaam) zzaax2).zzm(zzfa9.zzH(), 0, 2, false);
            int zzo = zzfa9.zzo();
            if ((zzo >> 2) == 16382) {
                zzaax.zzj();
                this.zzk = zzo;
                zzaaz zzaaz = this.zze;
                int i6 = zzfj.zza;
                long zzf2 = zzaax.zzf();
                long zzd5 = zzaax.zzd();
                zzabj zzabj3 = this.zzi;
                zzabj3.getClass();
                if (zzabj3.zzk != null) {
                    zzabv = new zzabh(zzabj3, zzf2);
                } else if (zzd5 == -1 || zzabj3.zzj <= 0) {
                    zzabv = new zzabu(zzabj3.zza(), 0);
                } else {
                    zzacw zzacw2 = new zzacw(zzabj3, this.zzk, zzf2, zzd5);
                    this.zzl = zzacw2;
                    zzabv = zzacw2.zzb();
                }
                zzaaz.zzN(zzabv);
                this.zzg = 5;
                return 0;
            }
            zzaax.zzj();
            throw zzcd.zza("First frame does not start with sync code.", (Throwable) null);
        }
    }

    public final void zzb(zzaaz zzaaz) {
        this.zze = zzaaz;
        this.zzf = zzaaz.zzv(0, 1);
        zzaaz.zzC();
    }

    public final void zzc(long j2, long j3) {
        long j4 = 0;
        if (j2 == 0) {
            this.zzg = 0;
        } else {
            zzacw zzacw = this.zzl;
            if (zzacw != null) {
                zzacw.zzd(j3);
            }
        }
        if (j3 != 0) {
            j4 = -1;
        }
        this.zzn = j4;
        this.zzm = 0;
        this.zzc.zzC(0);
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        zzabg.zza(zzaax, false);
        zzfa zzfa = new zzfa(4);
        ((zzaam) zzaax).zzm(zzfa.zzH(), 0, 4, false);
        if (zzfa.zzs() == 1716281667) {
            return true;
        }
        return false;
    }

    public zzacy(int i2) {
        this.zzb = new byte[42];
        this.zzc = new zzfa(new byte[32768], 0);
        this.zzd = new zzabe();
        this.zzg = 0;
    }
}
