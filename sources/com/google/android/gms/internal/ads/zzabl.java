package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzabl {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i2 = zzfj.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzbz zzbz) {
        for (int i2 = 0; i2 < zzbz.zza(); i2++) {
            zzby zzb2 = zzbz.zzb(i2);
            if (zzb2 instanceof zzaeg) {
                zzaeg zzaeg = (zzaeg) zzb2;
                if ("iTunSMPB".equals(zzaeg.zzb) && zzc(zzaeg.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzaep) {
                zzaep zzaep = (zzaep) zzb2;
                if ("com.apple.iTunes".equals(zzaep.zza) && "iTunSMPB".equals(zzaep.zzb) && zzc(zzaep.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
