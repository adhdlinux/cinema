package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class zzds implements zzdr {
    protected zzdp zzb;
    protected zzdp zzc;
    private zzdp zzd;
    private zzdp zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzds() {
        ByteBuffer byteBuffer = zzdr.zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzdp zzdp = zzdp.zza;
        this.zzd = zzdp;
        this.zze = zzdp;
        this.zzb = zzdp;
        this.zzc = zzdp;
    }

    public final zzdp zza(zzdp zzdp) throws zzdq {
        this.zzd = zzdp;
        this.zze = zzi(zzdp);
        if (zzg()) {
            return this.zze;
        }
        return zzdp.zza;
    }

    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zzdr.zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zzdr.zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zzdr.zza;
        zzdp zzdp = zzdp.zza;
        this.zzd = zzdp;
        this.zze = zzdp;
        this.zzb = zzdp;
        this.zzc = zzdp;
        zzm();
    }

    public boolean zzg() {
        return this.zze != zzdp.zza;
    }

    public boolean zzh() {
        return this.zzh && this.zzg == zzdr.zza;
    }

    /* access modifiers changed from: protected */
    public zzdp zzi(zzdp zzdp) throws zzdq {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer zzj(int i2) {
        if (this.zzf.capacity() < i2) {
            this.zzf = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void zzk() {
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    /* access modifiers changed from: protected */
    public void zzm() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
