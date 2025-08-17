package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class zzdo {
    private final zzfsc zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdp zzd;
    private zzdp zze;
    private boolean zzf;

    public zzdo(zzfsc zzfsc) {
        this.zza = zzfsc;
        zzdp zzdp = zzdp.zza;
        this.zzd = zzdp;
        this.zze = zzdp;
        this.zzf = false;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        boolean z2;
        ByteBuffer byteBuffer2;
        do {
            z2 = false;
            for (int i2 = 0; i2 <= zzi(); i2++) {
                if (!this.zzc[i2].hasRemaining()) {
                    zzdr zzdr = (zzdr) this.zzb.get(i2);
                    if (!zzdr.zzh()) {
                        if (i2 > 0) {
                            byteBuffer2 = this.zzc[i2 - 1];
                        } else if (byteBuffer.hasRemaining()) {
                            byteBuffer2 = byteBuffer;
                        } else {
                            byteBuffer2 = zzdr.zza;
                        }
                        zzdr.zze(byteBuffer2);
                        this.zzc[i2] = zzdr.zzb();
                        boolean z3 = true;
                        if (((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining()) <= 0 && !this.zzc[i2].hasRemaining()) {
                            z3 = false;
                        }
                        z2 |= z3;
                    } else if (!this.zzc[i2].hasRemaining() && i2 < zzi()) {
                        ((zzdr) this.zzb.get(i2 + 1)).zzd();
                    }
                }
            }
        } while (z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdo)) {
            return false;
        }
        zzdo zzdo = (zzdo) obj;
        if (this.zza.size() != zzdo.zza.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            if (this.zza.get(i2) != zzdo.zza.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdp zza(zzdp zzdp) throws zzdq {
        if (!zzdp.equals(zzdp.zza)) {
            for (int i2 = 0; i2 < this.zza.size(); i2++) {
                zzdr zzdr = (zzdr) this.zza.get(i2);
                zzdp zza2 = zzdr.zza(zzdp);
                if (zzdr.zzg()) {
                    zzdy.zzf(!zza2.equals(zzdp.zza));
                    zzdp = zza2;
                }
            }
            this.zze = zzdp;
            return zzdp;
        }
        throw new zzdq("Unhandled input format:", zzdp);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdr.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (!byteBuffer.hasRemaining()) {
            zzj(zzdr.zza);
        }
        return byteBuffer;
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            zzdr zzdr = (zzdr) this.zza.get(i2);
            zzdr.zzc();
            if (zzdr.zzg()) {
                this.zzb.add(zzdr);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i3 = 0; i3 <= zzi(); i3++) {
            this.zzc[i3] = ((zzdr) this.zzb.get(i3)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzf) {
            this.zzf = true;
            ((zzdr) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzf) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i2 = 0; i2 < this.zza.size(); i2++) {
            zzdr zzdr = (zzdr) this.zza.get(i2);
            zzdr.zzc();
            zzdr.zzf();
        }
        this.zzc = new ByteBuffer[0];
        zzdp zzdp = zzdp.zza;
        this.zzd = zzdp;
        this.zze = zzdp;
        this.zzf = false;
    }

    public final boolean zzg() {
        if (!this.zzf || !((zzdr) this.zzb.get(zzi())).zzh() || this.zzc[zzi()].hasRemaining()) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
