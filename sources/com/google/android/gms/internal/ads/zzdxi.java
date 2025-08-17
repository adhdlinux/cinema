package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzt;
import com.uwetrottmann.trakt5.TraktV2;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.json.JSONObject;

public final class zzdxi {
    public zzfwm zza;
    /* access modifiers changed from: private */
    public final zzcxz zzb;
    private final zzdwq zzc;
    private final zzfel zzd;
    private final zzfai zze;
    private final zzbzx zzf;
    private final zzfgb zzg;
    private final zzffy zzh;
    private final Context zzi;
    private final zzfwn zzj;

    zzdxi(zzcxz zzcxz, zzdwq zzdwq, zzfel zzfel, zzfai zzfai, zzbzx zzbzx, zzfgb zzfgb, zzffy zzffy, Context context, zzfwn zzfwn) {
        this.zzb = zzcxz;
        this.zzc = zzdwq;
        this.zzd = zzfel;
        this.zze = zzfai;
        this.zzf = zzbzx;
        this.zzg = zzfgb;
        this.zzh = zzffy;
        this.zzi = context;
        this.zzj = zzfwn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbtm zza(zzbue zzbue, zzdyt zzdyt) {
        Context context = this.zzi;
        zzdyt.zzc.put(TraktV2.HEADER_CONTENT_TYPE, zzdyt.zze);
        zzdyt.zzc.put("User-Agent", zzt.zzp().zzc(context, zzbue.zzb.zza));
        String str = zzdyt.zza;
        int i2 = zzdyt.zzb;
        Map map = zzdyt.zzc;
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbtm(str, i2, bundle, zzdyt.zzd, zzdyt.zzf, zzbue.zzd, zzbue.zzh);
    }

    public final zzfwm zzc(zzbue zzbue, JSONObject jSONObject, zzbuh zzbuh) {
        this.zzb.zzbA(zzbue);
        zzfdq zza2 = this.zzd.zzb(zzfef.PROXY, zzfwc.zzl(this.zzd.zzb(zzfef.PREPARE_HTTP_REQUEST, zzfwc.zzh(new zzdyx(jSONObject, zzbuh))).zze(new zzdyy(zzbue.zzg, this.zzh, zzffm.zza(this.zzi, 9))).zza(), new zzdxg(this, zzbue), this.zzj)).zzf(new zzdxd(this.zzc)).zza();
        this.zza = zza2;
        zzfwm zzm = zzfwc.zzm(this.zzd.zzb(zzfef.PRE_PROCESS, zza2).zze(new zzdxf(jSONObject, zzbuh)).zzf(zzt.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzdyg.zza, zzbmw.zzb)).zza(), new zzdxe(this), this.zzj);
        zzfwc.zzq(zzm, new zzdxh(this), this.zzj);
        return zzm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(InputStream inputStream) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zze), zzezy.zza(new InputStreamReader(inputStream))));
    }
}
