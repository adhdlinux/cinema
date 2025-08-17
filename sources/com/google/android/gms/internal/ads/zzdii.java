package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.ads.AudienceNetworkActivity;
import java.util.Map;

public final /* synthetic */ class zzdii implements zzbij {
    public final /* synthetic */ zzdim zza;

    public /* synthetic */ zzdii(zzdim zzdim) {
        this.zza = zzdim;
    }

    public final void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        zzcez.zzN().zzA(new zzdil(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcez.loadData(str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8");
        } else {
            zzcez.loadDataWithBaseURL(str2, str, AudienceNetworkActivity.WEBVIEW_MIME_TYPE, "UTF-8", (String) null);
        }
    }
}
