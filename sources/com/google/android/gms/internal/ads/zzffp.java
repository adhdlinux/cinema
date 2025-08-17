package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Iterator;

public final class zzffp implements zzffn {
    private final Context zza;
    /* access modifiers changed from: private */
    public long zzb = 0;
    /* access modifiers changed from: private */
    public long zzc = -1;
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public int zze = 0;
    /* access modifiers changed from: private */
    public String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    /* access modifiers changed from: private */
    public String zzj = "";
    /* access modifiers changed from: private */
    public String zzk = "";
    /* access modifiers changed from: private */
    public String zzl = "";
    private boolean zzm = false;
    private boolean zzn = false;
    /* access modifiers changed from: private */
    public final int zzo;
    /* access modifiers changed from: private */
    public int zzp = 2;
    /* access modifiers changed from: private */
    public int zzq = 2;

    zzffp(Context context, int i2) {
        this.zza = context;
        this.zzo = i2;
    }

    public final synchronized zzffp zzH(int i2) {
        this.zzp = i2;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zza(zze zze2) {
        zzq(zze2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzb(zzezy zzezy) {
        zzr(zzezy);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzc(String str) {
        zzs(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzd(String str) {
        zzt(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zze(String str) {
        zzu(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzf(boolean z2) {
        zzv(z2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzg(Throwable th) {
        zzw(th);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzh() {
        zzx();
        return this;
    }

    public final /* bridge */ /* synthetic */ zzffn zzi() {
        zzy();
        return this;
    }

    public final synchronized boolean zzj() {
        return this.zzn;
    }

    public final boolean zzk() {
        return !TextUtils.isEmpty(this.zzh);
    }

    public final synchronized zzffr zzl() {
        if (this.zzm) {
            return null;
        }
        this.zzm = true;
        if (!this.zzn) {
            zzx();
        }
        if (this.zzc < 0) {
            zzy();
        }
        return new zzffr(this, (zzffq) null);
    }

    public final /* bridge */ /* synthetic */ zzffn zzm(int i2) {
        zzH(i2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzffp zzq(com.google.android.gms.ads.internal.client.zze r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.os.IBinder r3 = r3.zze     // Catch:{ all -> 0x0023 }
            if (r3 != 0) goto L_0x0007
            monitor-exit(r2)
            return r2
        L_0x0007:
            com.google.android.gms.internal.ads.zzcuz r3 = (com.google.android.gms.internal.ads.zzcuz) r3     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r3.zzk()     // Catch:{ all -> 0x0023 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0015
            r2.zzf = r0     // Catch:{ all -> 0x0023 }
        L_0x0015:
            java.lang.String r3 = r3.zzi()     // Catch:{ all -> 0x0023 }
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            r2.zzg = r3     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return r2
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffp.zzq(com.google.android.gms.ads.internal.client.zze):com.google.android.gms.internal.ads.zzffp");
    }

    public final synchronized zzffp zzr(zzezy zzezy) {
        if (!TextUtils.isEmpty(zzezy.zzb.zzb)) {
            this.zzf = zzezy.zzb.zzb;
        }
        Iterator it2 = zzezy.zza.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            zzezn zzezn = (zzezn) it2.next();
            if (!TextUtils.isEmpty(zzezn.zzac)) {
                this.zzg = zzezn.zzac;
                break;
            }
        }
        return this;
    }

    public final synchronized zzffp zzs(String str) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzip)).booleanValue()) {
            this.zzl = str;
        }
        return this;
    }

    public final synchronized zzffp zzt(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzffp zzu(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzffp zzv(boolean z2) {
        this.zzd = z2;
        return this;
    }

    public final synchronized zzffp zzw(Throwable th) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzip)).booleanValue()) {
            this.zzk = zzbsw.zzd(th);
            this.zzj = (String) zzfpu.zzc(zzfos.zzc(10)).zzd(zzbsw.zzc(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzffp zzx() {
        this.zze = zzt.zzq().zzn(this.zza);
        Resources resources = this.zza.getResources();
        int i2 = 2;
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                i2 = configuration.orientation == 2 ? 4 : 3;
            }
        }
        this.zzq = i2;
        this.zzb = zzt.zzB().elapsedRealtime();
        this.zzn = true;
        return this;
    }

    public final synchronized zzffp zzy() {
        this.zzc = zzt.zzB().elapsedRealtime();
        return this;
    }
}
