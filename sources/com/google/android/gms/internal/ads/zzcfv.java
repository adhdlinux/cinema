package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

public final class zzcfv extends zzdp {
    private final zzcca zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private zzdt zzf;
    private boolean zzg;
    private boolean zzh = true;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbfz zzn;

    public zzcfv(zzcca zzcca, float f2, boolean z2, boolean z3) {
        this.zza = zzcca;
        this.zzi = f2;
        this.zzc = z2;
        this.zzd = z3;
    }

    private final void zzw(int i2, int i3, boolean z2, boolean z3) {
        zzcae.zze.execute(new zzcfu(this, i2, i3, z2, z3));
    }

    private final void zzx(String str, Map map) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("action", str);
        zzcae.zze.execute(new zzcft(this, hashMap));
    }

    public final void zzc(float f2, float f3, int i2, boolean z2, float f4) {
        boolean z3;
        boolean z4;
        int i3;
        synchronized (this.zzb) {
            z3 = true;
            if (f3 == this.zzi) {
                if (f4 == this.zzk) {
                    z3 = false;
                }
            }
            this.zzi = f3;
            this.zzj = f2;
            z4 = this.zzh;
            this.zzh = z2;
            i3 = this.zze;
            this.zze = i2;
            float f5 = this.zzk;
            this.zzk = f4;
            if (Math.abs(f4 - f5) > 1.0E-4f) {
                this.zza.zzF().invalidate();
            }
        }
        if (z3) {
            try {
                zzbfz zzbfz = this.zzn;
                if (zzbfz != null) {
                    zzbfz.zze();
                }
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
        zzw(i3, i2, z4, z2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i2, int i3, boolean z2, boolean z3) {
        boolean z4;
        int i4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        zzdt zzdt;
        zzdt zzdt2;
        zzdt zzdt3;
        synchronized (this.zzb) {
            boolean z9 = this.zzg;
            boolean z10 = false;
            if (z9 || i3 != 1) {
                i4 = i3;
                z4 = false;
            } else {
                i3 = 1;
                i4 = 1;
                z4 = true;
            }
            if (i2 != i3) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5 || i4 != 1) {
                z6 = false;
            } else {
                z6 = true;
                i4 = 1;
            }
            if (!z5 || i4 != 2) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (!z5 || i4 != 3) {
                z8 = false;
            } else {
                z8 = true;
            }
            if (z9 || z4) {
                z10 = true;
            }
            this.zzg = z10;
            if (z4) {
                try {
                    zzdt zzdt4 = this.zzf;
                    if (zzdt4 != null) {
                        zzdt4.zzi();
                    }
                } catch (RemoteException e2) {
                    zzbzr.zzl("#007 Could not call remote method.", e2);
                }
            }
            if (z6 && (zzdt3 = this.zzf) != null) {
                zzdt3.zzh();
            }
            if (z7 && (zzdt2 = this.zzf) != null) {
                zzdt2.zzg();
            }
            if (z8) {
                zzdt zzdt5 = this.zzf;
                if (zzdt5 != null) {
                    zzdt5.zze();
                }
                this.zza.zzw();
            }
            if (!(z2 == z3 || (zzdt = this.zzf) == null)) {
                zzdt.zzf(z3);
            }
        }
    }

    public final float zze() {
        float f2;
        synchronized (this.zzb) {
            f2 = this.zzk;
        }
        return f2;
    }

    public final float zzf() {
        float f2;
        synchronized (this.zzb) {
            f2 = this.zzj;
        }
        return f2;
    }

    public final float zzg() {
        float f2;
        synchronized (this.zzb) {
            f2 = this.zzi;
        }
        return f2;
    }

    public final int zzh() {
        int i2;
        synchronized (this.zzb) {
            i2 = this.zze;
        }
        return i2;
    }

    public final zzdt zzi() throws RemoteException {
        zzdt zzdt;
        synchronized (this.zzb) {
            zzdt = this.zzf;
        }
        return zzdt;
    }

    public final void zzj(boolean z2) {
        String str;
        if (true != z2) {
            str = "unmute";
        } else {
            str = "mute";
        }
        zzx(str, (Map) null);
    }

    public final void zzk() {
        zzx("pause", (Map) null);
    }

    public final void zzl() {
        zzx("play", (Map) null);
    }

    public final void zzm(zzdt zzdt) {
        synchronized (this.zzb) {
            this.zzf = zzdt;
        }
    }

    public final void zzn() {
        zzx("stop", (Map) null);
    }

    public final boolean zzo() {
        boolean z2;
        boolean zzp = zzp();
        synchronized (this.zzb) {
            z2 = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z2;
    }

    public final boolean zzp() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = false;
            if (this.zzc && this.zzl) {
                z2 = true;
            }
        }
        return z2;
    }

    public final boolean zzq() {
        boolean z2;
        synchronized (this.zzb) {
            z2 = this.zzh;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(zzfl zzfl) {
        String str;
        String str2;
        String str3;
        boolean z2 = zzfl.zza;
        boolean z3 = zzfl.zzb;
        boolean z4 = zzfl.zzc;
        synchronized (this.zzb) {
            this.zzl = z3;
            this.zzm = z4;
        }
        if (true != z2) {
            str = "0";
        } else {
            str = "1";
        }
        String str4 = str;
        if (true != z3) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        String str5 = str2;
        if (true != z4) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", str4, "customControlsRequested", str5, "clickToExpandRequested", str3));
    }

    public final void zzt(float f2) {
        synchronized (this.zzb) {
            this.zzj = f2;
        }
    }

    public final void zzu() {
        boolean z2;
        int i2;
        synchronized (this.zzb) {
            z2 = this.zzh;
            i2 = this.zze;
            this.zze = 3;
        }
        zzw(i2, 3, z2, z2);
    }

    public final void zzv(zzbfz zzbfz) {
        synchronized (this.zzb) {
            this.zzn = zzbfz;
        }
    }
}
