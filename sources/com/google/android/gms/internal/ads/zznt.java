package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zznt implements zzls {
    private final zzdz zza;
    private final zzct zzb;
    private final zzcv zzc = new zzcv();
    private final zzns zzd;
    private final SparseArray zze;
    private zzeo zzf;
    private zzcp zzg;
    private zzei zzh;
    private boolean zzi;

    public zznt(zzdz zzdz) {
        zzdz.getClass();
        this.zza = zzdz;
        this.zzf = new zzeo(zzfj.zzu(), zzdz, zzmc.zza);
        zzct zzct = new zzct();
        this.zzb = zzct;
        this.zzd = new zzns(zzct);
        this.zze = new SparseArray();
    }

    public static /* synthetic */ void zzT(zznt zznt) {
        zzlt zzR = zznt.zzR();
        zznt.zzW(zzR, 1028, new zzmo(zzR));
        zznt.zzf.zze();
    }

    private final zzlt zzX(zzto zzto) {
        zzcw zzcw;
        this.zzg.getClass();
        if (zzto == null) {
            zzcw = null;
        } else {
            zzcw = this.zzd.zza(zzto);
        }
        if (zzto != null && zzcw != null) {
            return zzS(zzcw, zzcw.zzn(zzto.zza, this.zzb).zzd, zzto);
        }
        int zzd2 = this.zzg.zzd();
        zzcw zzn = this.zzg.zzn();
        if (zzd2 >= zzn.zzc()) {
            zzn = zzcw.zza;
        }
        return zzS(zzn, zzd2, (zzto) null);
    }

    private final zzlt zzY(int i2, zzto zzto) {
        zzcp zzcp = this.zzg;
        zzcp.getClass();
        if (zzto == null) {
            zzcw zzn = zzcp.zzn();
            if (i2 >= zzn.zzc()) {
                zzn = zzcw.zza;
            }
            return zzS(zzn, i2, (zzto) null);
        } else if (this.zzd.zza(zzto) != null) {
            return zzX(zzto);
        } else {
            return zzS(zzcw.zza, i2, zzto);
        }
    }

    private final zzlt zzZ() {
        return zzX(this.zzd.zzd());
    }

    private final zzlt zzaa() {
        return zzX(this.zzd.zze());
    }

    private final zzlt zzab(zzcf zzcf) {
        zzbw zzbw;
        if (!(zzcf instanceof zzih) || (zzbw = ((zzih) zzcf).zzj) == null) {
            return zzR();
        }
        return zzX(new zzto(zzbw));
    }

    public final void zzA(zzam zzam, zzia zzia) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1009, new zzng(zzaa, zzam, zzia));
    }

    public final void zzB(long j2) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1010, new zznj(zzaa, j2));
    }

    public final void zzC(Exception exc) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1014, new zzmg(zzaa, exc));
    }

    public final void zzD(int i2, long j2, long j3) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1011, new zzlz(zzaa, i2, j2, j3));
    }

    public final void zzE(int i2, long j2) {
        zzlt zzZ = zzZ();
        zzW(zzZ, 1018, new zzmr(zzZ, i2, j2));
    }

    public final void zzF(Object obj, long j2) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 26, new zznn(zzaa, obj, j2));
    }

    public final void zzG(Exception exc) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1030, new zzme(zzaa, exc));
    }

    public final void zzH(String str, long j2, long j3) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1016, new zzmn(zzaa, str, j3, j2));
    }

    public final void zzI(String str) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1019, new zzly(zzaa, str));
    }

    public final void zzJ(zzhz zzhz) {
        zzlt zzZ = zzZ();
        zzW(zzZ, 1020, new zznm(zzZ, zzhz));
    }

    public final void zzK(zzhz zzhz) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1015, new zzms(zzaa, zzhz));
    }

    public final void zzL(long j2, int i2) {
        zzlt zzZ = zzZ();
        zzW(zzZ, 1021, new zzmi(zzZ, j2, i2));
    }

    public final void zzM(zzam zzam, zzia zzia) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1017, new zzlx(zzaa, zzam, zzia));
    }

    public final void zzN() {
        zzei zzei = this.zzh;
        zzdy.zzb(zzei);
        zzei.zzh(new zzni(this));
    }

    public final void zzO(zzlv zzlv) {
        this.zzf.zzf(zzlv);
    }

    public final void zzP(zzcp zzcp, Looper looper) {
        boolean z2 = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z2 = false;
        }
        zzdy.zzf(z2);
        zzcp.getClass();
        this.zzg = zzcp;
        this.zzh = this.zza.zzb(looper, (Handler.Callback) null);
        this.zzf = this.zzf.zza(looper, new zzmm(this, zzcp));
    }

    public final void zzQ(List list, zzto zzto) {
        zzns zzns = this.zzd;
        zzcp zzcp = this.zzg;
        zzcp.getClass();
        zzns.zzh(list, zzto, zzcp);
    }

    /* access modifiers changed from: protected */
    public final zzlt zzR() {
        return zzX(this.zzd.zzb());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final zzlt zzS(zzcw zzcw, int i2, zzto zzto) {
        zzto zzto2;
        zzcw zzcw2 = zzcw;
        int i3 = i2;
        boolean z2 = true;
        if (true == zzcw.zzo()) {
            zzto2 = null;
        } else {
            zzto2 = zzto;
        }
        long zza2 = this.zza.zza();
        if (!zzcw2.equals(this.zzg.zzn()) || i3 != this.zzg.zzd()) {
            z2 = false;
        }
        long j2 = 0;
        if (zzto2 == null || !zzto2.zzb()) {
            if (z2) {
                j2 = this.zzg.zzj();
            } else if (!zzcw.zzo()) {
                long j3 = zzcw2.zze(i3, this.zzc, 0).zzm;
                j2 = zzfj.zzq(0);
            }
        } else if (z2 && this.zzg.zzb() == zzto2.zzb && this.zzg.zzc() == zzto2.zzc) {
            j2 = this.zzg.zzk();
        }
        return new zzlt(zza2, zzcw, i2, zzto2, j2, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzcp zzcp, zzlv zzlv, zzah zzah) {
        zzlv.zzi(zzcp, new zzlu(zzah, this.zze));
    }

    public final void zzV(int i2, long j2, long j3) {
        zzlt zzX = zzX(this.zzd.zzc());
        zzW(zzX, 1006, new zzmf(zzX, i2, j2, j3));
    }

    /* access modifiers changed from: protected */
    public final void zzW(zzlt zzlt, int i2, zzel zzel) {
        this.zze.put(i2, zzlt);
        zzeo zzeo = this.zzf;
        zzeo.zzd(i2, zzel);
        zzeo.zzc();
    }

    public final void zza(zzcl zzcl) {
        zzlt zzR = zzR();
        zzW(zzR, 13, new zzmj(zzR, zzcl));
    }

    public final void zzac(int i2, zzto zzto, zztk zztk) {
        zzlt zzY = zzY(i2, zzto);
        zzW(zzY, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION, new zzmd(zzY, zztk));
    }

    public final void zzad(int i2, zzto zzto, zztf zztf, zztk zztk) {
        zzlt zzY = zzY(i2, zzto);
        zzW(zzY, 1002, new zzmt(zzY, zztf, zztk));
    }

    public final void zzae(int i2, zzto zzto, zztf zztf, zztk zztk) {
        zzlt zzY = zzY(i2, zzto);
        zzW(zzY, 1001, new zznd(zzY, zztf, zztk));
    }

    public final void zzaf(int i2, zzto zzto, zztf zztf, zztk zztk, IOException iOException, boolean z2) {
        zzlt zzY = zzY(i2, zzto);
        zzW(zzY, 1003, new zzmp(zzY, zztf, zztk, iOException, z2));
    }

    public final void zzag(int i2, zzto zzto, zztf zztf, zztk zztk) {
        zzlt zzY = zzY(i2, zzto);
        zzW(zzY, 1000, new zzmy(zzY, zztf, zztk));
    }

    public final void zzb(boolean z2) {
        zzlt zzR = zzR();
        zzW(zzR, 3, new zznq(zzR, z2));
    }

    public final void zzc(boolean z2) {
        zzlt zzR = zzR();
        zzW(zzR, 7, new zzmz(zzR, z2));
    }

    public final void zzd(zzbp zzbp, int i2) {
        zzlt zzR = zzR();
        zzW(zzR, 1, new zznc(zzR, zzbp, i2));
    }

    public final void zze(zzbv zzbv) {
        zzlt zzR = zzR();
        zzW(zzR, 14, new zznf(zzR, zzbv));
    }

    public final void zzf(boolean z2, int i2) {
        zzlt zzR = zzR();
        zzW(zzR, 5, new zzmx(zzR, z2, i2));
    }

    public final void zzg(zzch zzch) {
        zzlt zzR = zzR();
        zzW(zzR, 12, new zzmb(zzR, zzch));
    }

    public final void zzh(int i2) {
        zzlt zzR = zzR();
        zzW(zzR, 4, new zznb(zzR, i2));
    }

    public final void zzi(int i2) {
        zzlt zzR = zzR();
        zzW(zzR, 6, new zznp(zzR, i2));
    }

    public final void zzj(zzcf zzcf) {
        zzlt zzab = zzab(zzcf);
        zzW(zzab, 10, new zzmu(zzab, zzcf));
    }

    public final void zzk(zzcf zzcf) {
        zzlt zzab = zzab(zzcf);
        zzW(zzab, 10, new zzne(zzab, zzcf));
    }

    public final void zzl(boolean z2, int i2) {
        zzlt zzR = zzR();
        zzW(zzR, -1, new zzlw(zzR, z2, i2));
    }

    public final void zzm(zzco zzco, zzco zzco2, int i2) {
        if (i2 == 1) {
            this.zzi = false;
            i2 = 1;
        }
        zzns zzns = this.zzd;
        zzcp zzcp = this.zzg;
        zzcp.getClass();
        zzns.zzg(zzcp);
        zzlt zzR = zzR();
        zzW(zzR, 11, new zzmh(zzR, i2, zzco, zzco2));
    }

    public final void zzn(boolean z2) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 23, new zzna(zzaa, z2));
    }

    public final void zzo(int i2, int i3) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 24, new zzno(zzaa, i2, i3));
    }

    public final void zzp(zzcw zzcw, int i2) {
        zzns zzns = this.zzd;
        zzcp zzcp = this.zzg;
        zzcp.getClass();
        zzns.zzi(zzcp);
        zzlt zzR = zzR();
        zzW(zzR, 0, new zzmq(zzR, i2));
    }

    public final void zzq(zzdh zzdh) {
        zzlt zzR = zzR();
        zzW(zzR, 2, new zzmk(zzR, zzdh));
    }

    public final void zzr(zzdn zzdn) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 25, new zznl(zzaa, zzdn));
    }

    public final void zzs(float f2) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 22, new zzma(zzaa, f2));
    }

    public final void zzt(zzlv zzlv) {
        this.zzf.zzb(zzlv);
    }

    public final void zzu() {
        if (!this.zzi) {
            zzlt zzR = zzR();
            this.zzi = true;
            zzW(zzR, -1, new zznk(zzR));
        }
    }

    public final void zzv(Exception exc) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1029, new zzml(zzaa, exc));
    }

    public final void zzw(String str, long j2, long j3) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1008, new zzmv(zzaa, str, j3, j2));
    }

    public final void zzx(String str) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1012, new zznr(zzaa, str));
    }

    public final void zzy(zzhz zzhz) {
        zzlt zzZ = zzZ();
        zzW(zzZ, 1013, new zznh(zzZ, zzhz));
    }

    public final void zzz(zzhz zzhz) {
        zzlt zzaa = zzaa();
        zzW(zzaa, 1007, new zzmw(zzaa, zzhz));
    }
}
