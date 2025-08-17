package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzdlf extends zzbfk {
    private final Context zza;
    private final zzdha zzb;
    private zzdia zzc;
    /* access modifiers changed from: private */
    public zzdgv zzd;

    public zzdlf(Context context, zzdha zzdha, zzdia zzdia, zzdgv zzdgv) {
        this.zza = context;
        this.zzb = zzdha;
        this.zzc = zzdia;
        this.zzd = zzdgv;
    }

    private final zzbee zzd(String str) {
        return new zzdle(this, "_videoMediaView");
    }

    public final zzdq zze() {
        return this.zzb.zzj();
    }

    public final zzbeo zzf() throws RemoteException {
        return this.zzd.zzc().zza();
    }

    public final zzber zzg(String str) {
        return (zzber) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzz();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        SimpleArrayMap zzh = this.zzb.zzh();
        SimpleArrayMap zzi = this.zzb.zzi();
        String[] strArr = new String[(zzh.size() + zzi.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < zzh.size(); i3++) {
            strArr[i2] = (String) zzh.j(i3);
            i2++;
        }
        for (int i4 = 0; i4 < zzi.size(); i4++) {
            strArr[i2] = (String) zzi.j(i4);
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public final void zzl() {
        zzdgv zzdgv = this.zzd;
        if (zzdgv != null) {
            zzdgv.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        String zzB = this.zzb.zzB();
        if ("Google".equals(zzB)) {
            zzbzr.zzj("Illegal argument specified for omid partner name.");
        } else if (TextUtils.isEmpty(zzB)) {
            zzbzr.zzj("Not starting OMID session. OM partner name has not been configured.");
        } else {
            zzdgv zzdgv = this.zzd;
            if (zzdgv != null) {
                zzdgv.zzt(zzB, false);
            }
        }
    }

    public final void zzn(String str) {
        zzdgv zzdgv = this.zzd;
        if (zzdgv != null) {
            zzdgv.zzE(str);
        }
    }

    public final void zzo() {
        zzdgv zzdgv = this.zzd;
        if (zzdgv != null) {
            zzdgv.zzH();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdgv zzdgv;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzt() != null && (zzdgv = this.zzd) != null) {
            zzdgv.zzI((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdgv zzdgv = this.zzd;
        if ((zzdgv == null || zzdgv.zzV()) && this.zzb.zzq() != null && this.zzb.zzr() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdia zzdia;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdia = this.zzc) == null || !zzdia.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzp().zzao(zzd("_videoMediaView"));
        return true;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdia zzdia;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdia = this.zzc) == null || !zzdia.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzr().zzao(zzd("_videoMediaView"));
        return true;
    }

    public final boolean zzt() {
        zzfgw zzt = this.zzb.zzt();
        if (zzt != null) {
            zzt.zzA().zzi(zzt);
            if (this.zzb.zzq() == null) {
                return true;
            }
            this.zzb.zzq().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzbzr.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
