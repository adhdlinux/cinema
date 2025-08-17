package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

public class zzehj extends zzbob {
    private final zzcve zza;
    private final zzdcs zzb;
    private final zzcvy zzc;
    private final zzcwn zzd;
    private final zzcws zze;
    private final zzdaa zzf;
    private final zzcxm zzg;
    private final zzddk zzh;
    private final zzczw zzi;
    private final zzcvt zzj;

    public zzehj(zzcve zzcve, zzdcs zzdcs, zzcvy zzcvy, zzcwn zzcwn, zzcws zzcws, zzdaa zzdaa, zzcxm zzcxm, zzddk zzddk, zzczw zzczw, zzcvt zzcvt) {
        this.zza = zzcve;
        this.zzb = zzdcs;
        this.zzc = zzcvy;
        this.zzd = zzcwn;
        this.zze = zzcws;
        this.zzf = zzdaa;
        this.zzg = zzcxm;
        this.zzh = zzddk;
        this.zzi = zzczw;
        this.zzj = zzcvt;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzr();
    }

    public final void zzf() {
        this.zzg.zzf(4);
    }

    public final void zzg(int i2) {
    }

    public final void zzh(zze zze2) {
    }

    public final void zzi(int i2, String str) {
    }

    @Deprecated
    public final void zzj(int i2) throws RemoteException {
        zzk(new zze(i2, "", "undefined", (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzfbi.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, "undefined", (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzn();
    }

    public final void zzp() {
        this.zzg.zzb();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzbz(str, str2);
    }

    public final void zzr(zzbfl zzbfl, String str) {
    }

    public void zzs(zzbvg zzbvg) {
    }

    public void zzt(zzbvk zzbvk) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
