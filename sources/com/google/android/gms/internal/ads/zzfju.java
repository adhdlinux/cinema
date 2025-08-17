package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfju {
    private final Context zza;
    private final Executor zzb;
    private final zzfjb zzc;
    private final zzfjd zzd;
    private final zzfjt zze;
    private final zzfjt zzf;
    private Task zzg;
    private Task zzh;

    zzfju(Context context, Executor executor, zzfjb zzfjb, zzfjd zzfjd, zzfjr zzfjr, zzfjs zzfjs) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfjb;
        this.zzd = zzfjd;
        this.zze = zzfjr;
        this.zzf = zzfjs;
    }

    public static zzfju zze(Context context, Executor executor, zzfjb zzfjb, zzfjd zzfjd) {
        zzfju zzfju = new zzfju(context, executor, zzfjb, zzfjd, new zzfjr(), new zzfjs());
        if (zzfju.zzd.zzd()) {
            zzfju.zzg = zzfju.zzh(new zzfjo(zzfju));
        } else {
            zzfju.zzg = Tasks.forResult(zzfju.zze.zza());
        }
        zzfju.zzh = zzfju.zzh(new zzfjp(zzfju));
        return zzfju;
    }

    private static zzaon zzg(Task task, zzaon zzaon) {
        if (!task.isSuccessful()) {
            return zzaon;
        }
        return (zzaon) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfjq(this));
    }

    public final zzaon zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzaon zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzaon zzc() throws Exception {
        Context context = this.zza;
        zzanq zza2 = zzaon.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza2.zzs(id);
            zza2.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzab(6);
        }
        return (zzaon) zza2.zzal();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzaon zzd() throws Exception {
        Context context = this.zza;
        return zzfjj.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
