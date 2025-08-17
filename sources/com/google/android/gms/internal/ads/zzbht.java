package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

final class zzbht implements zzbij {
    zzbht() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfnk zzj = zzfnl.zzj();
        zzj.zzb((String) map.get("appId"));
        zzj.zzh(zzcez.getWidth());
        zzj.zzg(zzcez.zzF().getWindowToken());
        if (!map.containsKey("gravityX") || !map.containsKey("gravityY")) {
            zzj.zzd(81);
        } else {
            zzj.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        }
        if (map.containsKey("verticalMargin")) {
            zzj.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzj.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzj.zza((String) map.get("enifd"));
        }
        try {
            zzt.zzj().zzj(zzcez, zzj.zzi());
        } catch (NullPointerException e2) {
            zzt.zzo().zzu(e2, "DefaultGmsgHandlers.ShowLMDOverlay");
            zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
