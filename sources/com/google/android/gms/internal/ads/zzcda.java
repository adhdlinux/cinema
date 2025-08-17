package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;

public final class zzcda implements zzbij {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        float f2;
        zzcca zzcca = (zzcca) obj;
        zzcfv zzq = zzcca.zzq();
        if (zzq == null) {
            try {
                zzcfv zzcfv = new zzcfv(zzcca, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcca.zzC(zzcfv);
                zzq = zzcfv;
            } catch (NullPointerException e2) {
                e = e2;
                zzbzr.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzu(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e3) {
                e = e3;
                zzbzr.zzh("Unable to parse videoMeta message.", e);
                zzt.zzo().zzu(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i2 = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i2 = parseInt;
            }
        }
        String str = (String) map.get(ViewProps.ASPECT_RATIO);
        if (TextUtils.isEmpty(str)) {
            f2 = 0.0f;
        } else {
            f2 = Float.parseFloat(str);
        }
        if (zzbzr.zzm(3)) {
            zzbzr.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + i2 + " , aspectRatio : " + str);
        }
        zzq.zzc(parseFloat2, parseFloat, i2, equals, f2);
    }
}
