package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzbxy {
    static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i2 = indexOf + 1;
        return Uri.parse(str.substring(0, i2) + str2 + "=" + str3 + "&" + str.substring(i2));
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzt.zzn().zzu(context)) {
            return uri.toString();
        }
        String zza = zzt.zzn().zza(context);
        if (zza == null) {
            return uri.toString();
        }
        String str = (String) zzba.zzc().zzb(zzbbm.zzaf);
        String uri2 = uri.toString();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzae)).booleanValue() && uri2.contains(str)) {
            zzt.zzn().zzm(context, zza);
            return zzd(uri2, context).replace(str, zza);
        } else if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri2;
        } else {
            String uri3 = zza(zzd(uri2, context), "fbs_aeid", zza).toString();
            zzt.zzn().zzm(context, zza);
            return uri3;
        }
    }

    public static String zzc(String str, Context context, boolean z2) {
        String zza;
        if ((((Boolean) zzba.zzc().zzb(zzbbm.zzam)).booleanValue() && !z2) || !zzt.zzn().zzu(context) || TextUtils.isEmpty(str) || (zza = zzt.zzn().zza(context)) == null) {
            return str;
        }
        String str2 = (String) zzba.zzc().zzb(zzbbm.zzaf);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzae)).booleanValue() || !str.contains(str2)) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (zzt.zzp().zzg(str)) {
                zzt.zzn().zzm(context, zza);
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            } else if (!zzt.zzp().zzh(str)) {
                return str;
            } else {
                zzt.zzn().zzn(context, zza);
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            }
        } else if (zzt.zzp().zzg(str)) {
            zzt.zzn().zzm(context, zza);
            return zzd(str, context).replace(str2, zza);
        } else if (!zzt.zzp().zzh(str)) {
            return str;
        } else {
            zzt.zzn().zzn(context, zza);
            return zzd(str, context).replace(str2, zza);
        }
    }

    private static String zzd(String str, Context context) {
        String zze = zzt.zzn().zze(context);
        String zzc = zzt.zzn().zzc(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zze)) {
            str = zza(str, "gmp_app_id", zze).toString();
        }
        if (str.contains("fbs_aiid") || TextUtils.isEmpty(zzc)) {
            return str;
        }
        return zza(str, "fbs_aiid", zzc).toString();
    }
}
