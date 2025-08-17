package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class zzaqn {
    protected static volatile zzfld zza = null;
    /* access modifiers changed from: private */
    public static final ConditionVariable zzc = new ConditionVariable();
    private static volatile Random zzd = null;
    protected volatile Boolean zzb;
    /* access modifiers changed from: private */
    public final zzart zze;

    public zzaqn(zzart zzart) {
        this.zze = zzart;
        zzart.zzk().execute(new zzaqm(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return zze().nextInt();
        }
    }

    private static Random zze() {
        if (zzd == null) {
            synchronized (zzaqn.class) {
                if (zzd == null) {
                    zzd = new Random();
                }
            }
        }
        return zzd;
    }

    public final void zzc(int i2, int i3, long j2, String str, Exception exc) {
        try {
            zzc.block();
            if (this.zzb.booleanValue() && zza != null) {
                zzanc zza2 = zzang.zza();
                zza2.zza(this.zze.zza.getPackageName());
                zza2.zze(j2);
                if (str != null) {
                    zza2.zzb(str);
                }
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    exc.printStackTrace(new PrintWriter(stringWriter));
                    zza2.zzf(stringWriter.toString());
                    zza2.zzd(exc.getClass().getName());
                }
                zzflc zza3 = zza.zza(((zzang) zza2.zzal()).zzax());
                zza3.zza(i2);
                if (i3 != -1) {
                    zza3.zzb(i3);
                }
                zza3.zzc();
            }
        } catch (Exception unused) {
        }
    }
}
