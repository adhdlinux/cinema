package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcl;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfbb {
    private static zzfbb zza;
    private final Context zzb;
    private final zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    @VisibleForTesting
    zzfbb(Context context, zzcl zzcl) {
        this.zzb = context;
        this.zzc = zzcl;
    }

    @VisibleForTesting
    static zzcl zza(Context context) {
        try {
            return zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            zzbzr.zzh("Failed to retrieve lite SDK info.", e2);
            return null;
        }
    }

    public static zzfbb zzd(Context context) {
        synchronized (zzfbb.class) {
            zzfbb zzfbb = zza;
            if (zzfbb != null) {
                return zzfbb;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbdh.zzb.zze()).longValue();
            zzcl zzcl = null;
            if (longValue > 0 && longValue <= 232400000) {
                zzcl = zza(applicationContext);
            }
            zzfbb zzfbb2 = new zzfbb(applicationContext, zzcl);
            zza = zzfbb2;
            return zzfbb2;
        }
    }

    private final zzen zzg() {
        zzcl zzcl = this.zzc;
        if (zzcl != null) {
            try {
                return zzcl.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbnw zzb() {
        return (zzbnw) this.zzd.get();
    }

    public final zzbzx zzc(int i2, boolean z2, int i3) {
        zzen zzg;
        zzt.zzp();
        boolean zzA = zzs.zzA(this.zzb);
        zzbzx zzbzx = new zzbzx(ModuleDescriptor.MODULE_VERSION, i3, true, zzA);
        if (((Boolean) zzbdh.zzc.zze()).booleanValue() && (zzg = zzg()) != null) {
            return new zzbzx(ModuleDescriptor.MODULE_VERSION, zzg.zza(), true, zzA);
        }
        return zzbzx;
    }

    public final String zze() {
        zzen zzg = zzg();
        if (zzg != null) {
            return zzg.zzb();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.internal.ads.zzbnw r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdh.zza
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.ads.internal.client.zzcl r0 = r3.zzc
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x001c
        L_0x0015:
            com.google.android.gms.internal.ads.zzbnw r0 = r0.getAdapterCreator()     // Catch:{ RemoteException -> 0x001a }
            goto L_0x001c
        L_0x001a:
            goto L_0x0013
        L_0x001c:
            java.util.concurrent.atomic.AtomicReference r2 = r3.zzd
            if (r0 == 0) goto L_0x0021
            r4 = r0
        L_0x0021:
            com.google.android.gms.internal.ads.zzfba.zza(r2, r1, r4)
            return
        L_0x0025:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfba.zza(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbb.zzf(com.google.android.gms.internal.ads.zzbnw):void");
    }
}
