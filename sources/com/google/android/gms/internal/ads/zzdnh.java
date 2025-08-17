package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdnh {
    private final zzcve zza;
    private final zzdcs zzb;
    /* access modifiers changed from: private */
    public final zzcwn zzc;
    private final zzcxa zzd;
    private final zzcxm zze;
    private final zzdaa zzf;
    private final Executor zzg;
    private final zzdco zzh;
    private final zzcnx zzi;
    private final zzb zzj;
    private final zzbws zzk;
    private final zzaqs zzl;
    /* access modifiers changed from: private */
    public final zzczr zzm;
    private final zzeba zzn;
    private final zzfgr zzo;
    private final zzdqa zzp;
    private final zzfev zzq;

    public zzdnh(zzcve zzcve, zzcwn zzcwn, zzcxa zzcxa, zzcxm zzcxm, zzdaa zzdaa, Executor executor, zzdco zzdco, zzcnx zzcnx, zzb zzb2, zzbws zzbws, zzaqs zzaqs, zzczr zzczr, zzeba zzeba, zzfgr zzfgr, zzdqa zzdqa, zzfev zzfev, zzdcs zzdcs) {
        this.zza = zzcve;
        this.zzc = zzcwn;
        this.zzd = zzcxa;
        this.zze = zzcxm;
        this.zzf = zzdaa;
        this.zzg = executor;
        this.zzh = zzdco;
        this.zzi = zzcnx;
        this.zzj = zzb2;
        this.zzk = zzbws;
        this.zzl = zzaqs;
        this.zzm = zzczr;
        this.zzn = zzeba;
        this.zzo = zzfgr;
        this.zzp = zzdqa;
        this.zzq = zzfev;
        this.zzb = zzdcs;
    }

    public static final zzfwm zzj(zzcez zzcez, String str, String str2) {
        zzcaj zzcaj = new zzcaj();
        zzcez.zzN().zzA(new zzdnf(zzcaj));
        zzcez.zzab(str, str2, (String) null);
        return zzcaj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzbz(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcez zzcez, zzcez zzcez2, Map map) {
        this.zzi.zzh(zzcez);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzcez zzcez, boolean z2, zzbil zzbil) {
        zzcez zzcez2 = zzcez;
        zzcgm zzN = zzcez.zzN();
        zzdmy zzdmy = r4;
        zzdmy zzdmy2 = new zzdmy(this);
        zzcxa zzcxa = this.zzd;
        zzcxm zzcxm = this.zze;
        zzdmz zzdmz = r7;
        zzdmz zzdmz2 = new zzdmz(this);
        zzdna zzdna = r10;
        zzdna zzdna2 = new zzdna(this);
        zzb zzb2 = this.zzj;
        zzdng zzdng = r12;
        zzdng zzdng2 = new zzdng(this);
        zzN.zzM(zzdmy, zzcxa, zzcxm, zzdmz, zzdna, z2, zzbil, zzb2, zzdng, this.zzk, this.zzn, this.zzo, this.zzp, this.zzq, (zzbjb) null, this.zzb, (zzbja) null, (zzbiu) null);
        zzcez zzcez3 = zzcez;
        zzcez3.setOnTouchListener(new zzdnb(this));
        zzcez3.setOnClickListener(new zzdnc(this));
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
            this.zzl.zzc().zzo((View) zzcez3);
        }
        this.zzh.zzm(zzcez3, this.zzg);
        this.zzh.zzm(new zzdnd(zzcez3), this.zzg);
        this.zzh.zza((View) zzcez3);
        zzcez3.zzad("/trackActiveViewUnit", new zzdne(this, zzcez3));
        this.zzi.zzi(zzcez3);
    }
}
