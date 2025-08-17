package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class zzccs extends zzcbg implements TextureView.SurfaceTextureListener, zzcbq {
    private final zzcca zzc;
    private final zzccb zzd;
    private final zzcbz zze;
    private zzcbf zzf;
    private Surface zzg;
    private zzcbr zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl = 1;
    private zzcby zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzccs(Context context, zzccb zzccb, zzcca zzcca, boolean z2, boolean z3, zzcbz zzcbz) {
        super(context);
        this.zzc = zzcca;
        this.zzd = zzccb;
        this.zzn = z2;
        this.zze = zzcbz;
        setSurfaceTextureListener(this);
        zzccb.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + "/" + canonicalName + ":" + message;
    }

    private final void zzU() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzQ(true);
        }
    }

    private final void zzV() {
        if (!this.zzo) {
            this.zzo = true;
            zzs.zza.post(new zzccn(this));
            zzn();
            this.zzd.zzb();
            if (this.zzp) {
                zzp();
            }
        }
    }

    private final void zzW(boolean z2, Integer num) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null && !z2) {
            zzcbr.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z2) {
                if (zzad()) {
                    zzcbr.zzU();
                    zzY();
                } else {
                    zzbzr.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzcdl zzp2 = this.zzc.zzp(this.zzi);
                if (zzp2 instanceof zzcdu) {
                    zzcbr zza = ((zzcdu) zzp2).zza();
                    this.zzh = zza;
                    zza.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzbzr.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp2 instanceof zzcdr) {
                    zzcdr zzcdr = (zzcdr) zzp2;
                    String zzF = zzF();
                    ByteBuffer zzk2 = zzcdr.zzk();
                    boolean zzl2 = zzcdr.zzl();
                    String zzi2 = zzcdr.zzi();
                    if (zzi2 == null) {
                        zzbzr.zzj("Stream cache URL is null.");
                        return;
                    }
                    zzcbr zzE = zzE(num);
                    this.zzh = zzE;
                    zzE.zzG(new Uri[]{Uri.parse(zzi2)}, zzF, zzk2, zzl2);
                } else {
                    zzbzr.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i2 = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    uriArr[i2] = Uri.parse(strArr[i2]);
                    i2++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }

    private final void zzX() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ((Surface) null, true);
            zzcbr zzcbr = this.zzh;
            if (zzcbr != null) {
                zzcbr.zzL((zzcbq) null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            try {
                zzcbr.zzS(surface, z2);
            } catch (IOException e2) {
                zzbzr.zzk("", e2);
            }
        } else {
            zzbzr.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i2, int i3) {
        float f2 = i3 > 0 ? ((float) i2) / ((float) i3) : 1.0f;
        if (this.zzs != f2) {
            this.zzs = f2;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcbr zzcbr = this.zzh;
        return zzcbr != null && zzcbr.zzV() && !this.zzk;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.zzs;
        if (f2 != 0.0f && this.zzm == null) {
            float f3 = (float) measuredWidth;
            float f4 = f3 / ((float) measuredHeight);
            if (f2 > f4) {
                measuredHeight = (int) (f3 / f2);
            }
            if (f2 < f4) {
                measuredWidth = (int) (((float) measuredHeight) * f2);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcby zzcby = this.zzm;
        if (zzcby != null) {
            zzcby.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (this.zzn) {
            zzcby zzcby = new zzcby(getContext());
            this.zzm = zzcby;
            zzcby.zzd(surfaceTexture, i2, i3);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, (Integer) null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i2, i3);
        } else {
            zzaa();
        }
        zzs.zza.post(new zzccm(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcby zzcby = this.zzm;
        if (zzcby != null) {
            zzcby.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ((Surface) null, true);
        }
        zzs.zza.post(new zzccq(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        zzcby zzcby = this.zzm;
        if (zzcby != null) {
            zzcby.zzc(i2, i3);
        }
        zzs.zza.post(new zzccg(this, i2, i3));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i2) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i2);
        zzs.zza.post(new zzccp(this, i2));
        super.onWindowVisibilityChanged(i2);
    }

    public final void zzA(int i2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzN(i2);
        }
    }

    public final void zzB(int i2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzR(i2);
        }
    }

    public final void zzC(String str, String[] strArr, Integer num) {
        if (str != null) {
            boolean z2 = true;
            if (strArr == null) {
                this.zzj = new String[]{str};
            } else {
                this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzi;
            if (!this.zze.zzl || str2 == null || str.equals(str2) || this.zzl != 4) {
                z2 = false;
            }
            this.zzi = str;
            zzW(z2, num);
        }
    }

    public final void zzD(int i2, int i3) {
        this.zzq = i2;
        this.zzr = i3;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final zzcbr zzE(Integer num) {
        zzcem zzcem = new zzcem(this.zzc.getContext(), this.zze, this.zzc, num);
        zzbzr.zzi("ExoPlayerAdapter initialized.");
        return zzcem;
    }

    /* access modifiers changed from: package-private */
    public final String zzF() {
        return zzt.zzp().zzc(this.zzc.getContext(), this.zzc.zzn().zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z2, long j2) {
        this.zzc.zzv(z2, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i2, int i3) {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzj(i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            try {
                zzcbr.zzT(zza, false);
            } catch (IOException e2) {
                zzbzr.zzk("", e2);
            }
        } else {
            zzbzr.zzj("Trying to set volume before player is initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i2) {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.onWindowVisibilityChanged(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzcbf zzcbf = this.zzf;
        if (zzcbf != null) {
            zzcbf.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            return zzcbr.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzr;
    }

    public final int zze() {
        return this.zzq;
    }

    public final long zzf() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            return zzcbr.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            return zzcbr.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            return zzcbr.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z2, long j2) {
        if (this.zzc != null) {
            zzcae.zze.execute(new zzcco(this, z2, j2));
        }
    }

    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    public final void zzk(String str, Exception exc) {
        String zzT = zzT(str, exc);
        zzbzr.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        zzs.zza.post(new zzccf(this, zzT));
        zzt.zzo().zzt(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzT = zzT("onLoadException", exc);
        zzbzr.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        zzt.zzo().zzt(exc, "AdExoPlayerView.onException");
        zzs.zza.post(new zzcci(this, zzT));
    }

    public final void zzm(int i2) {
        if (this.zzl != i2) {
            this.zzl = i2;
            if (i2 == 3) {
                zzV();
            } else if (i2 == 4) {
                if (this.zze.zza) {
                    zzX();
                }
                this.zzd.zze();
                this.zzb.zzc();
                zzs.zza.post(new zzccl(this));
            }
        }
    }

    public final void zzn() {
        zzs.zza.post(new zzccj(this));
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzs.zza.post(new zzcck(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzs.zza.post(new zzcch(this));
            return;
        }
        this.zzp = true;
    }

    public final void zzq(int i2) {
        if (zzac()) {
            this.zzh.zzI((long) i2);
        }
    }

    public final void zzr(zzcbf zzcbf) {
        this.zzf = zzcbf;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzC(str, (String[]) null, (Integer) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f2, float f3) {
        zzcby zzcby = this.zzm;
        if (zzcby != null) {
            zzcby.zzf(f2, f3);
        }
    }

    public final void zzv() {
        zzs.zza.post(new zzccr(this));
    }

    public final Integer zzw() {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            return zzcbr.zzC();
        }
        return null;
    }

    public final void zzx(int i2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzJ(i2);
        }
    }

    public final void zzy(int i2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzK(i2);
        }
    }

    public final void zzz(int i2) {
        zzcbr zzcbr = this.zzh;
        if (zzcbr != null) {
            zzcbr.zzM(i2);
        }
    }
}
