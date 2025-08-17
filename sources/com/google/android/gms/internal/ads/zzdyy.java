package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.DateTimeConstants;

public final class zzdyy implements zzfdo {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzffn zzc;
    private final zzffy zzd;

    public zzdyy(String str, zzffy zzffy, zzffn zzffn) {
        this.zzb = str;
        this.zzd = zzffy;
        this.zzc = zzffn;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdtx zzdtx;
        String str;
        zzdyx zzdyx = (zzdyx) obj;
        int optInt = zzdyx.zza.optInt("http_timeout_millis", DateTimeConstants.MILLIS_PER_MINUTE);
        zzbuh zza2 = zzdyx.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzdyx.zzb.zzh() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzaL)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null) {
                                Locale locale = Locale.ROOT;
                                if (group.toLowerCase(locale).startsWith("id=") || group.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.concat("; ");
                                    }
                                    str = str.concat(group);
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("Cookie", str);
                    }
                } else {
                    hashMap.put("Cookie", this.zzb);
                }
            }
            if (zzdyx.zzb.zzi()) {
                zzdyz.zza(hashMap, zzdyx.zza);
            }
            if (zzdyx.zzb != null && !TextUtils.isEmpty(zzdyx.zzb.zzd())) {
                str2 = zzdyx.zzb.zzd();
            }
            zzffy zzffy = this.zzd;
            zzffn zzffn = this.zzc;
            zzffn.zzf(true);
            zzffy.zza(zzffn);
            return new zzdyt(zzdyx.zzb.zze(), optInt, hashMap, str2.getBytes(zzfot.zzc), "", zzdyx.zzb.zzi());
        }
        if (zza2.zza() == 1) {
            if (zza2.zzf() != null) {
                str2 = TextUtils.join(", ", zza2.zzf());
                zzbzr.zzg(str2);
            }
            zzdtx = new zzdtx(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdtx = new zzdtx(1);
        }
        zzffy zzffy2 = this.zzd;
        zzffn zzffn2 = this.zzc;
        zzffn2.zzg(zzdtx);
        zzffn2.zzf(false);
        zzffy2.zza(zzffn2);
        throw zzdtx;
    }
}
