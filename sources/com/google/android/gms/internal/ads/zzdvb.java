package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

public final class zzdvb implements zzdvz {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdub zzb;
    private final zzfwn zzc;
    private final zzfai zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzdzx zzf;
    private final zzffy zzg;
    private final Context zzh;

    zzdvb(Context context, zzfai zzfai, zzdub zzdub, zzfwn zzfwn, ScheduledExecutorService scheduledExecutorService, zzdzx zzdzx, zzffy zzffy) {
        this.zzh = context;
        this.zzd = zzfai;
        this.zzb = zzdub;
        this.zzc = zzfwn;
        this.zze = scheduledExecutorService;
        this.zzf = zzdzx;
        this.zzg = zzffy;
    }

    public final zzfwm zzb(zzbue zzbue) {
        zzfwm zzb2 = this.zzb.zzb(zzbue);
        zzffn zza2 = zzffm.zza(this.zzh, 11);
        zzffx.zzd(zzb2, zza2);
        zzfwm zzm = zzfwc.zzm(zzb2, new zzduy(this), this.zzc);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfl)).booleanValue()) {
            Class<TimeoutException> cls = TimeoutException.class;
            zzm = zzfwc.zzf(zzfwc.zzn(zzm, (long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS, this.zze), cls, zzduz.zza, zzcae.zzf);
        }
        zzffx.zza(zzm, this.zzg, zza2);
        zzfwc.zzq(zzm, new zzdva(this), zzcae.zzf);
        return zzm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(InputStream inputStream) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zzd), zzezy.zza(new InputStreamReader(inputStream))));
    }
}
