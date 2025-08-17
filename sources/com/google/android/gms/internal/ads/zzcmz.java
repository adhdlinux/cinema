package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzcmz implements zzcmj {
    private final CookieManager zza;

    public zzcmz(Context context) {
        this.zza = zzt.zzq().zzb(context);
    }

    public final void zza(Map map) {
        if (this.zza != null) {
            if (((String) map.get("clear")) != null) {
                String str = (String) zzba.zzc().zzb(zzbbm.zzaK);
                String cookie = this.zza.getCookie(str);
                if (cookie != null) {
                    List zzf = zzfpu.zzc(zzfos.zzc(';')).zzf(cookie);
                    int i2 = 0;
                    while (i2 < zzf.size()) {
                        CookieManager cookieManager = this.zza;
                        Iterator it2 = zzfpu.zzc(zzfos.zzc('=')).zzd((String) zzf.get(i2)).iterator();
                        it2.getClass();
                        if (it2.hasNext()) {
                            cookieManager.setCookie(str, String.valueOf((String) it2.next()).concat(String.valueOf((String) zzba.zzc().zzb(zzbbm.zzax))));
                            i2++;
                        } else {
                            throw new IndexOutOfBoundsException("position (0) must be less than the number of elements that remained (" + 0 + ")");
                        }
                    }
                    return;
                }
                return;
            }
            String str2 = (String) map.get("cookie");
            if (!TextUtils.isEmpty(str2)) {
                this.zza.setCookie((String) zzba.zzc().zzb(zzbbm.zzaK), str2);
            }
        }
    }
}
