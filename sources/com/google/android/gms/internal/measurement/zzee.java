package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzga;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzee {
    private static volatile zzee zzc;
    protected final Clock zza;
    protected final ExecutorService zzb;
    /* access modifiers changed from: private */
    public final String zzd;
    private final AppMeasurementSdk zze;
    private final List zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public boolean zzh;
    private final String zzi;
    /* access modifiers changed from: private */
    public volatile zzcc zzj;

    protected zzee(Context context, String str, String str2, String str3, Bundle bundle) {
        boolean z2;
        if (str == null || !zzV(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.getInstance();
        zzbx.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzdi(this));
        boolean z3 = true;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzit.zzc(context, "google_app_id", zzga.zza(context)) != null && !zzR()) {
                this.zzi = null;
                this.zzh = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzV(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if (str2 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 ^ (str3 != null ? false : z3)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.zzi = str2;
        }
        zzU(new zzcx(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzed(this));
        }
    }

    protected static final boolean zzR() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzS(Exception exc, boolean z2, boolean z3) {
        this.zzh |= z2;
        if (z2) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z3) {
            zzA(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzT(String str, String str2, Bundle bundle, boolean z2, boolean z3, Long l2) {
        zzU(new zzdr(this, l2, str, str2, bundle, z2, z3));
    }

    /* access modifiers changed from: private */
    public final void zzU(zzdt zzdt) {
        this.zzb.execute(zzdt);
    }

    /* access modifiers changed from: private */
    public static final boolean zzV(String str, String str2) {
        return (str2 == null || str == null || zzR()) ? false : true;
    }

    public static zzee zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzee.class) {
                if (zzc == null) {
                    zzc = new zzee(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final void zzA(int i2, String str, Object obj, Object obj2, Object obj3) {
        zzU(new zzdg(this, false, 5, str, obj, (Object) null, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4.zzj == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        android.util.Log.w(r4.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdp(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(com.google.android.gms.measurement.internal.zzhj r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            int r2 = r2.size()     // Catch:{ all -> 0x0055 }
            if (r1 >= r2) goto L_0x002b
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0055 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0055 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0055 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = r4.zzd     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "OnEventListener already registered."
            android.util.Log.w(r5, r1)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            return
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            com.google.android.gms.internal.measurement.zzdv r1 = new com.google.android.gms.internal.measurement.zzdv     // Catch:{ all -> 0x0055 }
            r1.<init>(r5)     // Catch:{ all -> 0x0055 }
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0055 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0055 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0055 }
            r2.add(r3)     // Catch:{ all -> 0x0055 }
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj
            if (r5 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0045 }
            return
        L_0x0045:
            java.lang.String r5 = r4.zzd
            java.lang.String r0 = "Failed to register event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r5, r0)
        L_0x004c:
            com.google.android.gms.internal.measurement.zzdp r5 = new com.google.android.gms.internal.measurement.zzdp
            r5.<init>(r4, r1)
            r4.zzU(r5)
            return
        L_0x0055:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0055 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzB(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final void zzC() {
        zzU(new zzcv(this));
    }

    public final void zzD(Bundle bundle) {
        zzU(new zzcn(this, bundle));
    }

    public final void zzE(Bundle bundle) {
        zzU(new zzct(this, bundle));
    }

    public final void zzF(Bundle bundle) {
        zzU(new zzcu(this, bundle));
    }

    public final void zzG(Activity activity, String str, String str2) {
        zzU(new zzcr(this, activity, str, str2));
    }

    public final void zzH(boolean z2) {
        zzU(new zzdm(this, z2));
    }

    public final void zzI(Bundle bundle) {
        zzU(new zzdn(this, bundle));
    }

    public final void zzJ(zzhi zzhi) {
        zzdu zzdu = new zzdu(zzhi);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzdu);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzU(new zzdo(this, zzdu));
    }

    public final void zzK(Boolean bool) {
        zzU(new zzcs(this, bool));
    }

    public final void zzL(long j2) {
        zzU(new zzcw(this, j2));
    }

    public final void zzM(String str) {
        zzU(new zzcq(this, str));
    }

    public final void zzN(String str, String str2, Object obj, boolean z2) {
        zzU(new zzds(this, str, str2, obj, z2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r3.zzj == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.zzj.unregisterOnMeasurementEventListener(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        android.util.Log.w(r3.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdq(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.measurement.internal.zzhj r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x005b }
            int r2 = r2.size()     // Catch:{ all -> 0x005b }
            if (r1 >= r2) goto L_0x002b
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x005b }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x005b }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x005b }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x005b }
            if (r2 == 0) goto L_0x0028
            java.util.List r4 = r3.zzf     // Catch:{ all -> 0x005b }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x005b }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x005b }
            goto L_0x002c
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != 0) goto L_0x0037
            java.lang.String r4 = r3.zzd     // Catch:{ all -> 0x005b }
            java.lang.String r1 = "OnEventListener had not been registered."
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return
        L_0x0037:
            java.util.List r1 = r3.zzf     // Catch:{ all -> 0x005b }
            r1.remove(r4)     // Catch:{ all -> 0x005b }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj
            if (r0 == 0) goto L_0x0052
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            r0.unregisterOnMeasurementEventListener(r4)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x004b }
            return
        L_0x004b:
            java.lang.String r0 = r3.zzd
            java.lang.String r1 = "Failed to unregister event listener on calling thread. Trying again on the dynamite thread."
            android.util.Log.w(r0, r1)
        L_0x0052:
            com.google.android.gms.internal.measurement.zzdq r0 = new com.google.android.gms.internal.measurement.zzdq
            r0.<init>(r3, r4)
            r3.zzU(r0)
            return
        L_0x005b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzO(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final int zza(String str) {
        zzbz zzbz = new zzbz();
        zzU(new zzdj(this, str, zzbz));
        Integer num = (Integer) zzbz.zze(zzbz.zzb(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzbz zzbz = new zzbz();
        zzU(new zzdc(this, zzbz));
        Long l2 = (Long) zzbz.zze(zzbz.zzb(500), Long.class);
        if (l2 != null) {
            return l2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i2 = this.zzg + 1;
        this.zzg = i2;
        return nextLong + ((long) i2);
    }

    public final Bundle zzc(Bundle bundle, boolean z2) {
        zzbz zzbz = new zzbz();
        zzU(new zzdh(this, bundle, zzbz));
        if (z2) {
            return zzbz.zzb(5000);
        }
        return null;
    }

    public final AppMeasurementSdk zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzcc zzf(Context context, boolean z2) {
        try {
            return zzcb.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e2) {
            zzS(e2, true, false);
            return null;
        }
    }

    public final Object zzh(int i2) {
        zzbz zzbz = new zzbz();
        zzU(new zzdl(this, zzbz, i2));
        return zzbz.zze(zzbz.zzb(15000), Object.class);
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        zzbz zzbz = new zzbz();
        zzU(new zzdk(this, zzbz));
        return zzbz.zzc(120000);
    }

    public final String zzl() {
        zzbz zzbz = new zzbz();
        zzU(new zzdb(this, zzbz));
        return zzbz.zzc(50);
    }

    public final String zzm() {
        zzbz zzbz = new zzbz();
        zzU(new zzde(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzn() {
        zzbz zzbz = new zzbz();
        zzU(new zzdd(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzo() {
        zzbz zzbz = new zzbz();
        zzU(new zzda(this, zzbz));
        return zzbz.zzc(500);
    }

    public final List zzp(String str, String str2) {
        zzbz zzbz = new zzbz();
        zzU(new zzcp(this, str, str2, zzbz));
        List list = (List) zzbz.zze(zzbz.zzb(5000), List.class);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public final Map zzq(String str, String str2, boolean z2) {
        zzbz zzbz = new zzbz();
        zzU(new zzdf(this, str, str2, z2, zzbz));
        Bundle zzb2 = zzbz.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String next : zzb2.keySet()) {
            Object obj = zzb2.get(next);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public final void zzu(String str) {
        zzU(new zzcy(this, str));
    }

    public final void zzv(String str, String str2, Bundle bundle) {
        zzU(new zzco(this, str, str2, bundle));
    }

    public final void zzw(String str) {
        zzU(new zzcz(this, str));
    }

    public final void zzx(String str, Bundle bundle) {
        zzT((String) null, str, bundle, false, true, (Long) null);
    }

    public final void zzy(String str, String str2, Bundle bundle) {
        zzT(str, str2, bundle, true, true, (Long) null);
    }

    public final void zzz(String str, String str2, Bundle bundle, long j2) {
        zzT(str, str2, bundle, true, false, Long.valueOf(j2));
    }
}
