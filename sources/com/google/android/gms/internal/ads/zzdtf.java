package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdtf implements zzo, zzcgk {
    private final Context zza;
    private final zzbzx zzb;
    private zzdsx zzc;
    private zzcez zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzda zzh;
    private boolean zzi;

    zzdtf(Context context, zzbzx zzbzx) {
        this.zza = context;
        this.zzb = zzbzx;
    }

    private final synchronized boolean zzl(zzda zzda) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            zzbzr.zzj("Ad inspector had an internal error.");
            try {
                zzda.zze(zzfbi.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzbzr.zzj("Ad inspector had an internal error.");
            try {
                zzda.zze(zzfbi.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzt.zzB().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzba.zzc().zzb(zzbbm.zzix)).intValue())) {
                    return true;
                }
            }
            zzbzr.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzda.zze(zzfbi.zzd(19, (String) null, (zze) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x0012
            java.lang.String r4 = "Ad inspector loaded."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x002e }
            r3.zze = r0     // Catch:{ all -> 0x002e }
            java.lang.String r4 = ""
            r3.zzk(r4)     // Catch:{ all -> 0x002e }
            monitor-exit(r3)
            return
        L_0x0012:
            java.lang.String r4 = "Ad inspector failed to load."
            com.google.android.gms.internal.ads.zzbzr.zzj(r4)     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.zzda r4 = r3.zzh     // Catch:{ RemoteException -> 0x0025 }
            if (r4 == 0) goto L_0x0025
            r1 = 17
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r1 = com.google.android.gms.internal.ads.zzfbi.zzd(r1, r2, r2)     // Catch:{ RemoteException -> 0x0025 }
            r4.zze(r1)     // Catch:{ RemoteException -> 0x0025 }
        L_0x0025:
            r3.zzi = r0     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.ads.zzcez r4 = r3.zzd     // Catch:{ all -> 0x002e }
            r4.destroy()     // Catch:{ all -> 0x002e }
            monitor-exit(r3)
            return
        L_0x002e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtf.zza(boolean):void");
    }

    public final synchronized void zzb() {
        this.zzf = true;
        zzk("");
    }

    public final void zzbF() {
    }

    public final void zzbo() {
    }

    public final void zzby() {
    }

    public final void zze() {
    }

    public final synchronized void zzf(int i2) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            zzda zzda = this.zzh;
            if (zzda != null) {
                try {
                    zzda.zze((zze) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcez zzcez = this.zzd;
        if (zzcez == null || zzcez.zzaz()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdsx zzdsx) {
        this.zzc = zzdsx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze2 = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze2.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze2.toString());
    }

    public final synchronized void zzj(zzda zzda, zzbjb zzbjb, zzbiu zzbiu) {
        zzda zzda2 = zzda;
        synchronized (this) {
            if (zzl(zzda)) {
                try {
                    zzt.zzz();
                    zzcez zza2 = zzcfl.zza(this.zza, zzcgo.zza(), "", false, false, (zzaqs) null, (zzbco) null, this.zzb, (zzbce) null, (zzl) null, (zza) null, zzawz.zza(), (zzezn) null, (zzezq) null, (zzebl) null);
                    this.zzd = zza2;
                    zzcgm zzN = zza2.zzN();
                    if (zzN == null) {
                        zzbzr.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzda2.zze(zzfbi.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.zzh = zzda2;
                        zzN.zzM((com.google.android.gms.ads.internal.client.zza) null, (zzbhc) null, (zzo) null, (zzbhe) null, (zzz) null, false, (zzbil) null, (zzb) null, (zzbqx) null, (zzbws) null, (zzeba) null, (zzfgr) null, (zzdqa) null, (zzfev) null, zzbjb, (zzdcu) null, new zzbja(this.zza), zzbiu);
                        zzN.zzA(this);
                        this.zzd.loadUrl((String) zzba.zzc().zzb(zzbbm.zziv));
                        zzt.zzi();
                        zzm.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzt.zzB().currentTimeMillis();
                    }
                } catch (zzcfk e2) {
                    zzbzr.zzk("Failed to obtain a web view for the ad inspector", e2);
                    try {
                        zzda2.zze(zzfbi.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                    } catch (RemoteException unused2) {
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzfwn r0 = com.google.android.gms.internal.ads.zzcae.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzdte r1 = new com.google.android.gms.internal.ads.zzdte     // Catch:{ all -> 0x0018 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtf.zzk(java.lang.String):void");
    }
}
