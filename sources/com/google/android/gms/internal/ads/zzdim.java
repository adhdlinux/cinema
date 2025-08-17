package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdim {
    private final zzdni zza;
    private final zzdlx zzb;
    private final zzcoh zzc;
    private final zzdhi zzd;

    public zzdim(zzdni zzdni, zzdlx zzdlx, zzcoh zzcoh, zzdhi zzdhi) {
        this.zza = zzdni;
        this.zzb = zzdlx;
        this.zzc = zzcoh;
        this.zzd = zzdhi;
    }

    public final View zza() throws zzcfk {
        zzcez zza2 = this.zza.zza(zzq.zzc(), (zzezn) null, (zzezq) null);
        ((View) zza2).setVisibility(8);
        zza2.zzad("/sendMessageToSdk", new zzdig(this));
        zza2.zzad("/adMuted", new zzdih(this));
        this.zzb.zzj(new WeakReference(zza2), "/loadHtml", new zzdii(this));
        this.zzb.zzj(new WeakReference(zza2), "/showOverlay", new zzdij(this));
        this.zzb.zzj(new WeakReference(zza2), "/hideOverlay", new zzdik(this));
        return (View) zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcez zzcez, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcez zzcez, Map map) {
        this.zzd.zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzcez zzcez, Map map) {
        zzbzr.zzi("Showing native ads overlay.");
        zzcez.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcez zzcez, Map map) {
        zzbzr.zzi("Hiding native ads overlay.");
        zzcez.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
