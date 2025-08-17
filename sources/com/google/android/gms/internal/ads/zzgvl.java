package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzgvl implements zzamw {
    private static final zzgvw zza = zzgvw.zzb(zzgvl.class);
    protected final String zzb;
    boolean zzc;
    boolean zzd;
    long zze;
    long zzf = -1;
    zzgvq zzg;
    private zzamx zzh;
    private ByteBuffer zzi;
    private ByteBuffer zzj = null;

    protected zzgvl(String str) {
        this.zzb = str;
        this.zzd = true;
        this.zzc = true;
    }

    private final synchronized void zzd() {
        String str;
        if (!this.zzd) {
            try {
                zzgvw zzgvw = zza;
                String str2 = this.zzb;
                if (str2.length() != 0) {
                    str = "mem mapping ".concat(str2);
                } else {
                    str = new String("mem mapping ");
                }
                zzgvw.zza(str);
                this.zzi = this.zzg.zzd(this.zze, this.zzf);
                this.zzd = true;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb(zzgvq zzgvq, ByteBuffer byteBuffer, long j2, zzamt zzamt) throws IOException {
        this.zze = zzgvq.zzb();
        byteBuffer.remaining();
        this.zzf = j2;
        this.zzg = zzgvq;
        zzgvq.zze(zzgvq.zzb() + j2);
        this.zzd = false;
        this.zzc = false;
        zzg();
    }

    public final void zzc(zzamx zzamx) {
        this.zzh = zzamx;
    }

    /* access modifiers changed from: protected */
    public abstract void zzf(ByteBuffer byteBuffer);

    public final synchronized void zzg() {
        String str;
        zzd();
        zzgvw zzgvw = zza;
        String str2 = this.zzb;
        if (str2.length() != 0) {
            str = "parsing details of ".concat(str2);
        } else {
            str = new String("parsing details of ");
        }
        zzgvw.zza(str);
        ByteBuffer byteBuffer = this.zzi;
        if (byteBuffer != null) {
            this.zzc = true;
            byteBuffer.rewind();
            zzf(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzj = byteBuffer.slice();
            }
            this.zzi = null;
        }
    }
}
