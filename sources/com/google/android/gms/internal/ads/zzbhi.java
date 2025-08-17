package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;

public final /* synthetic */ class zzbhi implements zzfov {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbhi(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzbij zzbij = zzbii.zza;
        if (str2 != null) {
            if (((Boolean) zzbde.zzf.zze()).booleanValue()) {
                String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                String host = Uri.parse(str).getHost();
                int i2 = 0;
                while (true) {
                    if (i2 < 3) {
                        if (host.endsWith(strArr[i2])) {
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            String str3 = (String) zzbde.zza.zze();
            String str4 = (String) zzbde.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                str = str.replace(str3, str2);
            }
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str);
                if (TextUtils.isEmpty(parse.getQueryParameter(str4))) {
                    return parse.buildUpon().appendQueryParameter(str4, str2).toString();
                }
            }
        }
        return str;
    }
}
