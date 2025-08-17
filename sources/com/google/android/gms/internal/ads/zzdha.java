package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Collections;
import java.util.List;

public final class zzdha {
    private int zza;
    private zzdq zzb;
    private zzbej zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzel zzg;
    private Bundle zzh;
    private zzcez zzi;
    private zzcez zzj;
    private zzcez zzk;
    private zzfgw zzl;
    private View zzm;
    private zzfwm zzn;
    private View zzo;
    private IObjectWrapper zzp;
    private double zzq;
    private zzber zzr;
    private zzber zzs;
    private String zzt;
    private final SimpleArrayMap zzu = new SimpleArrayMap();
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private float zzw;
    private String zzx;

    public static zzdha zzae(zzboh zzboh) {
        try {
            zzdgz zzai = zzai(zzboh.zzg(), (zzbol) null);
            zzbej zzh2 = zzboh.zzh();
            String zzo2 = zzboh.zzo();
            List zzr2 = zzboh.zzr();
            String zzm2 = zzboh.zzm();
            Bundle zzf2 = zzboh.zzf();
            String zzn2 = zzboh.zzn();
            IObjectWrapper zzl2 = zzboh.zzl();
            String zzq2 = zzboh.zzq();
            String zzp2 = zzboh.zzp();
            double zze2 = zzboh.zze();
            zzber zzi2 = zzboh.zzi();
            zzdha zzdha = new zzdha();
            zzdha.zza = 2;
            zzdha.zzb = zzai;
            zzdha.zzc = zzh2;
            zzdha.zzd = (View) zzak(zzboh.zzj());
            zzdha.zzX("headline", zzo2);
            zzdha.zze = zzr2;
            zzdha.zzX("body", zzm2);
            zzdha.zzh = zzf2;
            zzdha.zzX("call_to_action", zzn2);
            zzdha.zzm = (View) zzak(zzboh.zzk());
            zzdha.zzp = zzl2;
            zzdha.zzX("store", zzq2);
            zzdha.zzX(InAppPurchaseMetaData.KEY_PRICE, zzp2);
            zzdha.zzq = zze2;
            zzdha.zzr = zzi2;
            return zzdha;
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzdha zzaf(zzboi zzboi) {
        try {
            zzdgz zzai = zzai(zzboi.zzf(), (zzbol) null);
            zzbej zzg2 = zzboi.zzg();
            String zzo2 = zzboi.zzo();
            List zzp2 = zzboi.zzp();
            String zzm2 = zzboi.zzm();
            Bundle zze2 = zzboi.zze();
            String zzn2 = zzboi.zzn();
            IObjectWrapper zzk2 = zzboi.zzk();
            String zzl2 = zzboi.zzl();
            zzber zzh2 = zzboi.zzh();
            zzdha zzdha = new zzdha();
            zzdha.zza = 1;
            zzdha.zzb = zzai;
            zzdha.zzc = zzg2;
            zzdha.zzd = (View) zzak(zzboi.zzi());
            zzdha.zzX("headline", zzo2);
            zzdha.zze = zzp2;
            zzdha.zzX("body", zzm2);
            zzdha.zzh = zze2;
            zzdha.zzX("call_to_action", zzn2);
            zzdha.zzm = (View) zzak(zzboi.zzj());
            zzdha.zzp = zzk2;
            zzdha.zzX("advertiser", zzl2);
            zzdha.zzs = zzh2;
            return zzdha;
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public static zzdha zzag(zzboh zzboh) {
        try {
            return zzaj(zzai(zzboh.zzg(), (zzbol) null), zzboh.zzh(), (View) zzak(zzboh.zzj()), zzboh.zzo(), zzboh.zzr(), zzboh.zzm(), zzboh.zzf(), zzboh.zzn(), (View) zzak(zzboh.zzk()), zzboh.zzl(), zzboh.zzq(), zzboh.zzp(), zzboh.zze(), zzboh.zzi(), (String) null, 0.0f);
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to get native ad assets from app install ad mapper", e2);
            return null;
        }
    }

    public static zzdha zzah(zzboi zzboi) {
        try {
            return zzaj(zzai(zzboi.zzf(), (zzbol) null), zzboi.zzg(), (View) zzak(zzboi.zzi()), zzboi.zzo(), zzboi.zzp(), zzboi.zzm(), zzboi.zze(), zzboi.zzn(), (View) zzak(zzboi.zzj()), zzboi.zzk(), (String) null, (String) null, -1.0d, zzboi.zzh(), zzboi.zzl(), 0.0f);
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to get native ad assets from content ad mapper", e2);
            return null;
        }
    }

    private static zzdgz zzai(zzdq zzdq, zzbol zzbol) {
        if (zzdq == null) {
            return null;
        }
        return new zzdgz(zzdq, zzbol);
    }

    private static zzdha zzaj(zzdq zzdq, zzbej zzbej, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d2, zzber zzber, String str6, float f2) {
        zzdha zzdha = new zzdha();
        zzdha.zza = 6;
        zzdha.zzb = zzdq;
        zzdha.zzc = zzbej;
        zzdha.zzd = view;
        String str7 = str;
        zzdha.zzX("headline", str);
        zzdha.zze = list;
        String str8 = str2;
        zzdha.zzX("body", str2);
        zzdha.zzh = bundle;
        String str9 = str3;
        zzdha.zzX("call_to_action", str3);
        zzdha.zzm = view2;
        zzdha.zzp = iObjectWrapper;
        String str10 = str4;
        zzdha.zzX("store", str4);
        String str11 = str5;
        zzdha.zzX(InAppPurchaseMetaData.KEY_PRICE, str5);
        zzdha.zzq = d2;
        zzdha.zzr = zzber;
        zzdha.zzX("advertiser", str6);
        zzdha.zzQ(f2);
        return zzdha;
    }

    private static Object zzak(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdha zzs(zzbol zzbol) {
        try {
            return zzaj(zzai(zzbol.zzj(), zzbol), zzbol.zzk(), (View) zzak(zzbol.zzm()), zzbol.zzs(), zzbol.zzv(), zzbol.zzq(), zzbol.zzi(), zzbol.zzr(), (View) zzak(zzbol.zzn()), zzbol.zzo(), zzbol.zzu(), zzbol.zzt(), zzbol.zze(), zzbol.zzl(), zzbol.zzp(), zzbol.zzf());
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    public final synchronized String zzA() {
        return zzE("headline");
    }

    public final synchronized String zzB() {
        return this.zzx;
    }

    public final synchronized String zzC() {
        return zzE(InAppPurchaseMetaData.KEY_PRICE);
    }

    public final synchronized String zzD() {
        return zzE("store");
    }

    public final synchronized String zzE(String str) {
        return (String) this.zzv.get(str);
    }

    public final synchronized List zzF() {
        return this.zze;
    }

    public final synchronized List zzG() {
        return this.zzf;
    }

    public final synchronized void zzH() {
        zzcez zzcez = this.zzi;
        if (zzcez != null) {
            zzcez.destroy();
            this.zzi = null;
        }
        zzcez zzcez2 = this.zzj;
        if (zzcez2 != null) {
            zzcez2.destroy();
            this.zzj = null;
        }
        zzcez zzcez3 = this.zzk;
        if (zzcez3 != null) {
            zzcez3.destroy();
            this.zzk = null;
        }
        this.zzl = null;
        this.zzu.clear();
        this.zzv.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzm = null;
        this.zzo = null;
        this.zzp = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
    }

    public final synchronized void zzI(zzbej zzbej) {
        this.zzc = zzbej;
    }

    public final synchronized void zzJ(String str) {
        this.zzt = str;
    }

    public final synchronized void zzK(zzel zzel) {
        this.zzg = zzel;
    }

    public final synchronized void zzL(zzber zzber) {
        this.zzr = zzber;
    }

    public final synchronized void zzM(String str, zzbed zzbed) {
        if (zzbed == null) {
            this.zzu.remove(str);
        } else {
            this.zzu.put(str, zzbed);
        }
    }

    public final synchronized void zzN(zzcez zzcez) {
        this.zzj = zzcez;
    }

    public final synchronized void zzO(List list) {
        this.zze = list;
    }

    public final synchronized void zzP(zzber zzber) {
        this.zzs = zzber;
    }

    public final synchronized void zzQ(float f2) {
        this.zzw = f2;
    }

    public final synchronized void zzR(List list) {
        this.zzf = list;
    }

    public final synchronized void zzS(zzcez zzcez) {
        this.zzk = zzcez;
    }

    public final synchronized void zzT(zzfwm zzfwm) {
        this.zzn = zzfwm;
    }

    public final synchronized void zzU(String str) {
        this.zzx = str;
    }

    public final synchronized void zzV(zzfgw zzfgw) {
        this.zzl = zzfgw;
    }

    public final synchronized void zzW(double d2) {
        this.zzq = d2;
    }

    public final synchronized void zzX(String str, String str2) {
        if (str2 == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, str2);
        }
    }

    public final synchronized void zzY(int i2) {
        this.zza = i2;
    }

    public final synchronized void zzZ(zzdq zzdq) {
        this.zzb = zzdq;
    }

    public final synchronized double zza() {
        return this.zzq;
    }

    public final synchronized void zzaa(View view) {
        this.zzm = view;
    }

    public final synchronized void zzab(zzcez zzcez) {
        this.zzi = zzcez;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized boolean zzad() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzw;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzm;
    }

    public final synchronized View zzg() {
        return this.zzo;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzu;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzv;
    }

    public final synchronized zzdq zzj() {
        return this.zzb;
    }

    public final synchronized zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbej zzl() {
        return this.zzc;
    }

    public final zzber zzm() {
        List list = this.zze;
        if (list != null && !list.isEmpty()) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzbeq.zzg((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzber zzn() {
        return this.zzr;
    }

    public final synchronized zzber zzo() {
        return this.zzs;
    }

    public final synchronized zzcez zzp() {
        return this.zzj;
    }

    public final synchronized zzcez zzq() {
        return this.zzk;
    }

    public final synchronized zzcez zzr() {
        return this.zzi;
    }

    public final synchronized zzfgw zzt() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzu() {
        return this.zzp;
    }

    public final synchronized zzfwm zzv() {
        return this.zzn;
    }

    public final synchronized String zzw() {
        return zzE("advertiser");
    }

    public final synchronized String zzx() {
        return zzE("body");
    }

    public final synchronized String zzy() {
        return zzE("call_to_action");
    }

    public final synchronized String zzz() {
        return this.zzt;
    }
}
