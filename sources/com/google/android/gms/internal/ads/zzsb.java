package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzsb implements zzsk {
    public static final /* synthetic */ zzsb zza = new zzsb();

    private /* synthetic */ zzsb() {
    }

    public final int zza(Object obj) {
        int i2 = zzsl.zza;
        String str = ((zzrs) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzfj.zza >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return 0;
        }
        return -1;
    }
}
