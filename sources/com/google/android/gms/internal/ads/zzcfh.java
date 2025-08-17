package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzcfh implements zzfpx {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcgo zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzaqs zzf;
    public final /* synthetic */ zzbco zzg;
    public final /* synthetic */ zzbzx zzh;
    public final /* synthetic */ zzl zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzawz zzk;
    public final /* synthetic */ zzezn zzl;
    public final /* synthetic */ zzezq zzm;
    public final /* synthetic */ zzebl zzn;

    public /* synthetic */ zzcfh(Context context, zzcgo zzcgo, String str, boolean z2, boolean z3, zzaqs zzaqs, zzbco zzbco, zzbzx zzbzx, zzbce zzbce, zzl zzl2, zza zza2, zzawz zzawz, zzezn zzezn, zzezq zzezq, zzebl zzebl) {
        this.zza = context;
        this.zzb = zzcgo;
        this.zzc = str;
        this.zzd = z2;
        this.zze = z3;
        this.zzf = zzaqs;
        this.zzg = zzbco;
        this.zzh = zzbzx;
        this.zzi = zzl2;
        this.zzj = zza2;
        this.zzk = zzawz;
        this.zzl = zzezn;
        this.zzm = zzezq;
        this.zzn = zzebl;
    }

    public final Object zza() {
        Context context = this.zza;
        zzcgo zzcgo = this.zzb;
        String str = this.zzc;
        boolean z2 = this.zzd;
        boolean z3 = this.zze;
        zzaqs zzaqs = this.zzf;
        zzbco zzbco = this.zzg;
        zzbzx zzbzx = this.zzh;
        zzl zzl2 = this.zzi;
        zza zza2 = this.zzj;
        zzawz zzawz = this.zzk;
        zzezn zzezn = this.zzl;
        zzezq zzezq = this.zzm;
        zzebl zzebl = this.zzn;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i2 = zzcfs.zza;
            zzebl zzebl2 = zzebl;
            zzcfo zzcfo = new zzcfo(new zzcfs(new zzcgn(context), zzcgo, str, z2, z3, zzaqs, zzbco, zzbzx, (zzbce) null, zzl2, zza2, zzawz, zzezn, zzezq));
            zzcfo.setWebViewClient(zzt.zzq().zzd(zzcfo, zzawz, z3, zzebl2));
            zzcfo.setWebChromeClient(new zzcey(zzcfo));
            return zzcfo;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
