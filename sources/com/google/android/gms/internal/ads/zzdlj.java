package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.common.util.UriUtil;
import java.util.Map;

public final class zzdlj implements zzbij {
    private final zzbfv zza;
    private final zzdlx zzb;
    private final zzgvy zzc;

    public zzdlj(zzdhl zzdhl, zzdha zzdha, zzdlx zzdlx, zzgvy zzgvy) {
        this.zza = zzdhl.zzc(zzdha.zzz());
        this.zzb = zzdlx;
        this.zzc = zzgvy;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get(UriUtil.LOCAL_ASSET_SCHEME);
        try {
            this.zza.zze((zzbfl) this.zzc.zzb(), str);
        } catch (RemoteException e2) {
            zzbzr.zzk("Failed to call onCustomClick for asset " + str + ".", e2);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzi("/nativeAdCustomClick", this);
        }
    }
}
