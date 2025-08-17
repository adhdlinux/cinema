package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzfjb {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    zzfjb(Context context, Executor executor, Task task, boolean z2) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z2;
    }

    public static zzfjb zza(Context context, Executor executor, boolean z2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z2) {
            executor.execute(new zzfix(context, taskCompletionSource));
        } else {
            executor.execute(new zzfiy(taskCompletionSource));
        }
        return new zzfjb(context, executor, taskCompletionSource.getTask(), z2);
    }

    static void zzg(int i2) {
        zzf = i2;
    }

    private final Task zzh(int i2, long j2, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfiz.zza);
        }
        zzanc zza2 = zzang.zza();
        zza2.zza(this.zzb.getPackageName());
        zza2.zze(j2);
        zza2.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zza2.zzf(stringWriter.toString());
            zza2.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zza2.zzb(str2);
        }
        if (str != null) {
            zza2.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new zzfja(zza2, i2));
    }

    public final Task zzb(int i2, String str) {
        return zzh(i2, 0, (Exception) null, (String) null, (Map) null, str);
    }

    public final Task zzc(int i2, long j2, Exception exc) {
        return zzh(i2, j2, exc, (String) null, (Map) null, (String) null);
    }

    public final Task zzd(int i2, long j2) {
        return zzh(i2, j2, (Exception) null, (String) null, (Map) null, (String) null);
    }

    public final Task zze(int i2, long j2, String str) {
        return zzh(i2, j2, (Exception) null, (String) null, (Map) null, str);
    }

    public final Task zzf(int i2, long j2, String str, Map map) {
        return zzh(i2, j2, (Exception) null, str, (Map) null, (String) null);
    }
}
