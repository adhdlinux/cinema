package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final /* synthetic */ class zzgv implements zzfpi {
    public static final /* synthetic */ zzgv zza = new zzgv();

    private /* synthetic */ zzgv() {
    }

    public final boolean zza(Object obj) {
        String str = (String) obj;
        if (str == null) {
            return false;
        }
        String zza2 = zzfon.zza(str);
        if (TextUtils.isEmpty(zza2)) {
            return false;
        }
        if ((!zza2.contains("text") || zza2.contains("text/vtt")) && !zza2.contains("html") && !zza2.contains("xml")) {
            return true;
        }
        return false;
    }
}
