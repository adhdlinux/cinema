package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class zzahm implements zzaaw {
    public static final zzabd zza = zzahl.zza;
    private zzaaz zzb;
    private zzahu zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zze(zzaax zzaax) throws IOException {
        zzaho zzaho = new zzaho();
        if (zzaho.zzb(zzaax, true) && (zzaho.zza & 2) == 2) {
            int min = Math.min(zzaho.zze, 8);
            zzfa zzfa = new zzfa(min);
            ((zzaam) zzaax).zzm(zzfa.zzH(), 0, min, false);
            zzfa.zzF(0);
            if (zzfa.zza() >= 5 && zzfa.zzk() == 127 && zzfa.zzs() == 1179402563) {
                this.zzc = new zzahk();
            } else {
                zzfa.zzF(0);
                try {
                    if (zzacf.zzd(1, zzfa, true)) {
                        this.zzc = new zzahw();
                    }
                } catch (zzcd unused) {
                }
                zzfa.zzF(0);
                if (zzahq.zzd(zzfa)) {
                    this.zzc = new zzahq();
                }
            }
            return true;
        }
        return false;
    }

    public final int zza(zzaax zzaax, zzabs zzabs) throws IOException {
        zzdy.zzb(this.zzb);
        if (this.zzc == null) {
            if (zze(zzaax)) {
                zzaax.zzj();
            } else {
                throw zzcd.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zzabz zzv = this.zzb.zzv(0, 1);
            this.zzb.zzC();
            this.zzc.zzh(this.zzb, zzv);
            this.zzd = true;
        }
        return this.zzc.zze(zzaax, zzabs);
    }

    public final void zzb(zzaaz zzaaz) {
        this.zzb = zzaaz;
    }

    public final void zzc(long j2, long j3) {
        zzahu zzahu = this.zzc;
        if (zzahu != null) {
            zzahu.zzj(j2, j3);
        }
    }

    public final boolean zzd(zzaax zzaax) throws IOException {
        try {
            return zze(zzaax);
        } catch (zzcd unused) {
            return false;
        }
    }
}
