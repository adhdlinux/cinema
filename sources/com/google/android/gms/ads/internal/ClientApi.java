package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbjg;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbux;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcgu;
import com.google.android.gms.internal.ads.zzdhu;
import com.google.android.gms.internal.ads.zzdhw;
import com.google.android.gms.internal.ads.zzdri;
import com.google.android.gms.internal.ads.zzeip;
import com.google.android.gms.internal.ads.zzeun;
import com.google.android.gms.internal.ads.zzeuo;
import com.google.android.gms.internal.ads.zzewb;
import com.google.android.gms.internal.ads.zzexs;
import com.google.android.gms.internal.ads.zzezg;
import java.util.HashMap;

public class ClientApi extends zzcd {
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeip(zzcgu.zza(context, zzbnw, i2), context, str);
    }

    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeun zzr = zzcgu.zza(context, zzbnw, i2).zzr();
        zzr.zza(str);
        zzr.zzb(context);
        zzeuo zzc = zzr.zzc();
        if (i2 >= ((Integer) zzba.zzc().zzb(zzbbm.zzeX)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzewb zzs = zzcgu.zza(context, zzbnw, i2).zzs();
        zzs.zzc(context);
        zzs.zza(zzq);
        zzs.zzb(str);
        return zzs.zzd().zza();
    }

    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexs zzt = zzcgu.zza(context, zzbnw, i2).zzt();
        zzt.zzc(context);
        zzt.zza(zzq);
        zzt.zzb(str);
        return zzt.zzd().zza();
    }

    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i2) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzq, str, new zzbzx(ModuleDescriptor.MODULE_VERSION, i2, true, false));
    }

    public final zzco zzg(IObjectWrapper iObjectWrapper, int i2) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbnw) null, i2).zzb();
    }

    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbnw zzbnw, int i2) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnw, i2).zzk();
    }

    public final zzbev zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdhw((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    public final zzbfb zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdhu((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbjj zzk(IObjectWrapper iObjectWrapper, zzbnw zzbnw, int i2, zzbjg zzbjg) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdri zzi = zzcgu.zza(context, zzbnw, i2).zzi();
        zzi.zzb(context);
        zzi.zza(zzbjg);
        return zzi.zzc().zzd();
    }

    public final zzbrm zzl(IObjectWrapper iObjectWrapper, zzbnw zzbnw, int i2) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnw, i2).zzl();
    }

    public final zzbrt zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzt(activity);
        }
        int i2 = zza.zzk;
        if (i2 == 1) {
            return new zzs(activity);
        }
        if (i2 == 2) {
            return new zzae(activity);
        }
        if (i2 == 3) {
            return new zzaf(activity);
        }
        if (i2 == 4) {
            return new zzy(activity, zza);
        }
        if (i2 != 5) {
            return new zzt(activity);
        }
        return new zzac(activity);
    }

    public final zzbux zzn(IObjectWrapper iObjectWrapper, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezg zzu = zzcgu.zza(context, zzbnw, i2).zzu();
        zzu.zzb(context);
        return zzu.zzc().zzb();
    }

    public final zzbvn zzo(IObjectWrapper iObjectWrapper, String str, zzbnw zzbnw, int i2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezg zzu = zzcgu.zza(context, zzbnw, i2).zzu();
        zzu.zzb(context);
        zzu.zza(str);
        return zzu.zzc().zza();
    }

    public final zzbyi zzp(IObjectWrapper iObjectWrapper, zzbnw zzbnw, int i2) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnw, i2).zzo();
    }
}
