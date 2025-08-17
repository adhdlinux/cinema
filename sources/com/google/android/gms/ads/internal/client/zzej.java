package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbkf;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfpw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class zzej {
    private static zzej zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public final ArrayList zzc = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public boolean zze = false;
    private final Object zzf = new Object();
    private zzco zzg;
    /* access modifiers changed from: private */
    public OnAdInspectorClosedListener zzh = null;
    private RequestConfiguration zzi = new RequestConfiguration.Builder().build();

    private zzej() {
    }

    private final void zzA(Context context) {
        if (this.zzg == null) {
            this.zzg = (zzco) new zzaq(zzay.zza(), context).zzd(context, false);
        }
    }

    private final void zzB(RequestConfiguration requestConfiguration) {
        try {
            this.zzg.zzu(new zzff(requestConfiguration));
        } catch (RemoteException e2) {
            zzbzr.zzh("Unable to set request configuration parcel.", e2);
        }
    }

    public static zzej zzf() {
        zzej zzej;
        synchronized (zzej.class) {
            if (zza == null) {
                zza = new zzej();
            }
            zzej = zza;
        }
        return zzej;
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzy(List list) {
        AdapterStatus.State state;
        HashMap hashMap = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzbkf zzbkf = (zzbkf) it2.next();
            String str = zzbkf.zza;
            if (zzbkf.zzb) {
                state = AdapterStatus.State.READY;
            } else {
                state = AdapterStatus.State.NOT_READY;
            }
            hashMap.put(str, new zzbkn(state, zzbkf.zzd, zzbkf.zzc));
        }
        return new zzbko(hashMap);
    }

    private final void zzz(Context context, String str) {
        try {
            zzbnp.zza().zzb(context, (String) null);
            this.zzg.zzk();
            this.zzg.zzl((String) null, ObjectWrapper.wrap(null));
        } catch (RemoteException e2) {
            zzbzr.zzk("MobileAdsSettingManager initialization failed", e2);
        }
    }

    public final float zza() {
        float f2;
        synchronized (this.zzf) {
            zzco zzco = this.zzg;
            f2 = 1.0f;
            if (zzco == null) {
                return 1.0f;
            }
            try {
                f2 = zzco.zze();
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to get app volume.", e2);
            }
        }
        return f2;
    }

    public final RequestConfiguration zzc() {
        return this.zzi;
    }

    public final InitializationStatus zze() {
        boolean z2;
        InitializationStatus zzy;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                zzy = zzy(this.zzg.zzg());
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to get Initialization status.");
                return new zzeb(this);
            }
        }
        return zzy;
    }

    public final String zzh() {
        boolean z2;
        String zzc2;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc2 = zzfpw.zzc(this.zzg.zzf());
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to get internal version.", e2);
                return "";
            }
        }
        return zzc2;
    }

    public final void zzl(Context context) {
        synchronized (this.zzf) {
            zzA(context);
            try {
                this.zzg.zzi();
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final void zzm(boolean z2) {
        boolean z3;
        String str;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to enable/disable Same App Key.");
            try {
                this.zzg.zzj(z2);
            } catch (RemoteException e2) {
                if (z2) {
                    str = "enable";
                } else {
                    str = "disable";
                }
                zzbzr.zzh("Unable to " + str + " Same App Key.", e2);
                if (e2.getMessage() != null) {
                    if (e2.getMessage().toLowerCase(Locale.ROOT).contains("paid")) {
                        throw new IllegalStateException(e2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r3 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r4 = r2.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        zzA(r3);
        r2.zzg.zzs(new com.google.android.gms.ads.internal.client.zzei(r2, (com.google.android.gms.ads.internal.client.zzeh) null));
        r2.zzg.zzo(new com.google.android.gms.internal.ads.zzbnt());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r2.zzi.getTagForChildDirectedTreatment() != -1) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r2.zzi.getTagForUnderAgeOfConsent() == -1) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        zzB(r2.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.google.android.gms.internal.ads.zzbzr.zzk("MobileAdsSettingManager initialization failed", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        throw new java.lang.IllegalArgumentException("Context cannot be null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzn(android.content.Context r3, java.lang.String r4, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r5) {
        /*
            r2 = this;
            java.lang.Object r4 = r2.zzb
            monitor-enter(r4)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x0010
            if (r5 == 0) goto L_0x000e
            java.util.ArrayList r3 = r2.zzc     // Catch:{ all -> 0x00d8 }
            r3.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x000e:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x0010:
            boolean r0 = r2.zze     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x001f
            if (r5 == 0) goto L_0x001d
            com.google.android.gms.ads.initialization.InitializationStatus r3 = r2.zze()     // Catch:{ all -> 0x00d8 }
            r5.onInitializationComplete(r3)     // Catch:{ all -> 0x00d8 }
        L_0x001d:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x001f:
            r0 = 1
            r2.zzd = r0     // Catch:{ all -> 0x00d8 }
            if (r5 == 0) goto L_0x0029
            java.util.ArrayList r0 = r2.zzc     // Catch:{ all -> 0x00d8 }
            r0.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            if (r3 == 0) goto L_0x00d0
            java.lang.Object r4 = r2.zzf
            monitor-enter(r4)
            r5 = 0
            r2.zzA(r3)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzco r0 = r2.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzei r1 = new com.google.android.gms.ads.internal.client.zzei     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>(r2, r5)     // Catch:{ RemoteException -> 0x0060 }
            r0.zzs(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzco r0 = r2.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.internal.ads.zzbnt r1 = new com.google.android.gms.internal.ads.zzbnt     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0060 }
            r0.zzo(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x0060 }
            r1 = -1
            if (r0 != r1) goto L_0x0058
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x0060 }
            if (r0 == r1) goto L_0x0066
        L_0x0058:
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            r2.zzB(r0)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0066
        L_0x005e:
            r3 = move-exception
            goto L_0x00ce
        L_0x0060:
            r0 = move-exception
            java.lang.String r1 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzbzr.zzk(r1, r0)     // Catch:{ all -> 0x005e }
        L_0x0066:
            com.google.android.gms.internal.ads.zzbbm.zza(r3)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zza     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjI     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            java.lang.String r0 = "Initializing on bg thread"
            com.google.android.gms.internal.ads.zzbzr.zze(r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.ThreadPoolExecutor r0 = com.google.android.gms.internal.ads.zzbzg.zza     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzec r1 = new com.google.android.gms.ads.internal.client.zzec     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x0099:
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zzb     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjI     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            java.util.concurrent.ExecutorService r0 = com.google.android.gms.internal.ads.zzbzg.zzb     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzed r1 = new com.google.android.gms.ads.internal.client.zzed     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r0 = "Initializing on calling thread"
            com.google.android.gms.internal.ads.zzbzr.zze(r0)     // Catch:{ all -> 0x005e }
            r2.zzz(r3, r5)     // Catch:{ all -> 0x005e }
        L_0x00cc:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            return
        L_0x00ce:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            throw r3
        L_0x00d0:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Context cannot be null."
            r3.<init>(r4)
            throw r3
        L_0x00d8:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzej.zzn(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, (String) null);
        }
    }

    public final void zzq(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzf) {
            zzA(context);
            this.zzh = onAdInspectorClosedListener;
            try {
                this.zzg.zzm(new zzeg((zzef) null));
            } catch (RemoteException unused) {
                zzbzr.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzr(Context context, String str) {
        boolean z2;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzg.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to open debug menu.", e2);
            }
        }
    }

    public final void zzs(Class cls) {
        synchronized (this.zzf) {
            try {
                this.zzg.zzh(cls.getCanonicalName());
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to register RtbAdapter", e2);
            }
        }
    }

    public final void zzt(boolean z2) {
        boolean z3;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzg.zzp(z2);
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to set app mute state.", e2);
            }
        }
    }

    public final void zzu(float f2) {
        boolean z2;
        boolean z3 = true;
        if (f2 < 0.0f || f2 > 1.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzf) {
            if (this.zzg == null) {
                z3 = false;
            }
            Preconditions.checkState(z3, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzg.zzq(f2);
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to set app volume.", e2);
            }
        }
    }

    public final void zzv(String str) {
        boolean z2;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzg.zzt(str);
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to set plugin.", e2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzi     // Catch:{ all -> 0x0030 }
            r4.zzi = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.ads.internal.client.zzco r2 = r4.zzg     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzB(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzej.zzw(com.google.android.gms.ads.RequestConfiguration):void");
    }

    public final boolean zzx() {
        boolean z2;
        synchronized (this.zzf) {
            zzco zzco = this.zzg;
            z2 = false;
            if (zzco == null) {
                return false;
            }
            try {
                z2 = zzco.zzv();
            } catch (RemoteException e2) {
                zzbzr.zzh("Unable to get app mute state.", e2);
            }
        }
        return z2;
    }
}
