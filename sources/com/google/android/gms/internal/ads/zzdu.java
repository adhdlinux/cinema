package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzdu implements zzdr {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdp zze;
    private zzdp zzf;
    private zzdp zzg;
    private zzdp zzh;
    private boolean zzi;
    private zzdt zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzdu() {
        zzdp zzdp = zzdp.zza;
        this.zze = zzdp;
        this.zzf = zzdp;
        this.zzg = zzdp;
        this.zzh = zzdp;
        ByteBuffer byteBuffer = zzdr.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    public final zzdp zza(zzdp zzdp) throws zzdq {
        if (zzdp.zzd == 2) {
            int i2 = this.zzb;
            if (i2 == -1) {
                i2 = zzdp.zzb;
            }
            this.zze = zzdp;
            zzdp zzdp2 = new zzdp(i2, zzdp.zzc, 2);
            this.zzf = zzdp2;
            this.zzi = true;
            return zzdp2;
        }
        throw new zzdq("Unhandled input format:", zzdp);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzdt zzdt = this.zzj;
        if (zzdt != null && (zza = zzdt.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzdt.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzdr.zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            zzdp zzdp = this.zze;
            this.zzg = zzdp;
            zzdp zzdp2 = this.zzf;
            this.zzh = zzdp2;
            if (this.zzi) {
                this.zzj = new zzdt(zzdp.zzb, zzdp.zzc, this.zzc, this.zzd, zzdp2.zzb);
            } else {
                zzdt zzdt = this.zzj;
                if (zzdt != null) {
                    zzdt.zzc();
                }
            }
        }
        this.zzm = zzdr.zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzdt zzdt = this.zzj;
        if (zzdt != null) {
            zzdt.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzdt zzdt = this.zzj;
            zzdt.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += (long) remaining;
            zzdt.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzdp zzdp = zzdp.zza;
        this.zze = zzdp;
        this.zzf = zzdp;
        this.zzg = zzdp;
        this.zzh = zzdp;
        ByteBuffer byteBuffer = zzdr.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzdt zzdt = this.zzj;
        return zzdt == null || zzdt.zza() == 0;
    }

    public final long zzi(long j2) {
        long j3 = this.zzo;
        if (j3 < 1024) {
            return (long) (((double) this.zzc) * ((double) j2));
        }
        long j4 = this.zzn;
        zzdt zzdt = this.zzj;
        zzdt.getClass();
        long zzb2 = j4 - ((long) zzdt.zzb());
        int i2 = this.zzh.zzb;
        int i3 = this.zzg.zzb;
        if (i2 == i3) {
            return zzfj.zzp(j2, zzb2, j3);
        }
        return zzfj.zzp(j2, zzb2 * ((long) i2), j3 * ((long) i3));
    }

    public final void zzj(float f2) {
        if (this.zzd != f2) {
            this.zzd = f2;
            this.zzi = true;
        }
    }

    public final void zzk(float f2) {
        if (this.zzc != f2) {
            this.zzc = f2;
            this.zzi = true;
        }
    }
}
