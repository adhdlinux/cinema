package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzeqn implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;
    private final zzbzx zzc;
    private final String zzd;

    zzeqn(zzfwn zzfwn, Context context, zzbzx zzbzx, String str) {
        this.zza = zzfwn;
        this.zzb = context;
        this.zzc = zzbzx;
        this.zzd = str;
    }

    public final int zza() {
        return 35;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzeqm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqo zzc() throws Exception {
        int i2;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzt.zzp();
        boolean zzA = zzs.zzA(this.zzb);
        String str = this.zzc.zza;
        zzt.zzp();
        boolean zzB = zzs.zzB();
        zzt.zzp();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i2 = 0;
        } else {
            i2 = applicationInfo.targetSdkVersion;
        }
        return new zzeqo(isCallerInstantApp, zzA, str, zzB, i2, DynamiteModule.getRemoteVersion(this.zzb, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(this.zzb, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
