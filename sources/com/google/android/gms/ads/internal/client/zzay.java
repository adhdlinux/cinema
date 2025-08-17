package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzx;
import java.util.Random;

public final class zzay {
    private static final zzay zza = new zzay();
    private final zzbzk zzb;
    private final zzaw zzc;
    private final String zzd;
    private final zzbzx zze;
    private final Random zzf;

    protected zzay() {
        zzbzk zzbzk = new zzbzk();
        zzaw zzaw = new zzaw(new zzk(), new zzi(), new zzeq(), new zzbgq(), new zzbvz(), new zzbrq(), new zzbgr());
        String zzd2 = zzbzk.zzd();
        zzbzx zzbzx = new zzbzx(0, (int) ModuleDescriptor.MODULE_VERSION, true, false, false);
        Random random = new Random();
        this.zzb = zzbzk;
        this.zzc = zzaw;
        this.zzd = zzd2;
        this.zze = zzbzx;
        this.zzf = random;
    }

    public static zzaw zza() {
        return zza.zzc;
    }

    public static zzbzk zzb() {
        return zza.zzb;
    }

    public static zzbzx zzc() {
        return zza.zze;
    }

    public static String zzd() {
        return zza.zzd;
    }

    public static Random zze() {
        return zza.zzf;
    }
}
