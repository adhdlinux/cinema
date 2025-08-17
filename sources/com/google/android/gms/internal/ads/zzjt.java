package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

final class zzjt implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzzr, zzot, zzvq, zzso, zzhw, zzhs, zzii {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzjx zza;

    /* synthetic */ zzjt(zzjx zzjx, zzjs zzjs) {
        this.zza = zzjx;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        zzjx.zzP(this.zza, surfaceTexture);
        this.zza.zzag(i2, i3);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzaj((Object) null);
        this.zza.zzag(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.zza.zzag(i2, i3);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.zza.zzag(i3, i4);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzag(0, 0);
    }

    public final void zza(boolean z2) {
        this.zza.zzan();
    }

    public final void zzb(Exception exc) {
        this.zza.zzr.zzv(exc);
    }

    public final void zzc(String str, long j2, long j3) {
        this.zza.zzr.zzw(str, j2, j3);
    }

    public final void zzd(String str) {
        this.zza.zzr.zzx(str);
    }

    public final void zze(zzhz zzhz) {
        this.zza.zzr.zzy(zzhz);
        this.zza.zzL = null;
        this.zza.zzS = null;
    }

    public final void zzf(zzhz zzhz) {
        this.zza.zzS = zzhz;
        this.zza.zzr.zzz(zzhz);
    }

    public final void zzg(zzam zzam, zzia zzia) {
        this.zza.zzL = zzam;
        this.zza.zzr.zzA(zzam, zzia);
    }

    public final void zzh(long j2) {
        this.zza.zzr.zzB(j2);
    }

    public final void zzi(Exception exc) {
        this.zza.zzr.zzC(exc);
    }

    public final void zzj(int i2, long j2, long j3) {
        this.zza.zzr.zzD(i2, j2, j3);
    }

    public final void zzk(int i2, long j2) {
        this.zza.zzr.zzE(i2, j2);
    }

    public final void zzl(Object obj, long j2) {
        this.zza.zzr.zzF(obj, j2);
        zzjx zzjx = this.zza;
        if (zzjx.zzN == obj) {
            zzeo zzD = zzjx.zzl;
            zzD.zzd(26, zzjp.zza);
            zzD.zzc();
        }
    }

    public final void zzm(boolean z2) {
        zzjx zzjx = this.zza;
        if (zzjx.zzW != z2) {
            zzjx.zzW = z2;
            zzeo zzD = this.zza.zzl;
            zzD.zzd(23, new zzjq(z2));
            zzD.zzc();
        }
    }

    public final void zzn(Exception exc) {
        this.zza.zzr.zzG(exc);
    }

    public final void zzo(String str, long j2, long j3) {
        this.zza.zzr.zzH(str, j2, j3);
    }

    public final void zzp(String str) {
        this.zza.zzr.zzI(str);
    }

    public final void zzq(zzhz zzhz) {
        this.zza.zzr.zzJ(zzhz);
        this.zza.zzK = null;
        this.zza.zzR = null;
    }

    public final void zzr(zzhz zzhz) {
        this.zza.zzR = zzhz;
        this.zza.zzr.zzK(zzhz);
    }

    public final void zzs(long j2, int i2) {
        this.zza.zzr.zzL(j2, i2);
    }

    public final void zzt(zzam zzam, zzia zzia) {
        this.zza.zzK = zzam;
        this.zza.zzr.zzM(zzam, zzia);
    }

    public final void zzu(zzdn zzdn) {
        this.zza.zzab = zzdn;
        zzeo zzD = this.zza.zzl;
        zzD.zzd(25, new zzjr(zzdn));
        zzD.zzc();
    }
}
