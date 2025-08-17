package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbzr;

abstract class zzax {
    private static final zzce zza;

    static {
        zzce zzcc;
        zzce zzce = null;
        try {
            Object newInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbzr.zzj("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    if (queryLocalInterface instanceof zzce) {
                        zzcc = (zzce) queryLocalInterface;
                    } else {
                        zzcc = new zzcc(iBinder);
                    }
                    zzce = zzcc;
                }
            }
        } catch (Exception unused) {
            zzbzr.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzce;
    }

    zzax() {
    }

    private final Object zze() {
        zzce zzce = zza;
        if (zzce != null) {
            try {
                return zzb(zzce);
            } catch (RemoteException e2) {
                zzbzr.zzk("Cannot invoke local loader using ClientApi class.", e2);
                return null;
            }
        } else {
            zzbzr.zzj("ClientApi class cannot be loaded.");
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e2) {
            zzbzr.zzk("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza();

    /* access modifiers changed from: protected */
    public abstract Object zzb(zzce zzce) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract Object zzc() throws RemoteException;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd(android.content.Context r9, boolean r10) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x0015
            com.google.android.gms.ads.internal.client.zzay.zzb()
            r1 = 12451000(0xbdfcb8, float:1.7447567E-38)
            boolean r1 = com.google.android.gms.internal.ads.zzbzk.zzs(r9, r1)
            if (r1 != 0) goto L_0x0015
            java.lang.String r10 = "Google Play Services is not available."
            com.google.android.gms.internal.ads.zzbzr.zze(r10)
            r10 = 1
        L_0x0015:
            java.lang.String r1 = "com.google.android.gms.ads.dynamite"
            int r2 = com.google.android.gms.dynamite.DynamiteModule.getLocalVersion(r9, r1)
            int r1 = com.google.android.gms.dynamite.DynamiteModule.getRemoteVersion(r9, r1)
            r3 = 0
            if (r2 <= r1) goto L_0x0024
            r1 = 0
            goto L_0x0025
        L_0x0024:
            r1 = 1
        L_0x0025:
            r1 = r1 ^ r0
            com.google.android.gms.internal.ads.zzbbm.zza(r9)
            com.google.android.gms.internal.ads.zzbcr r2 = com.google.android.gms.internal.ads.zzbda.zza
            java.lang.Object r2 = r2.zze()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0039
        L_0x0037:
            r10 = 0
            goto L_0x004d
        L_0x0039:
            com.google.android.gms.internal.ads.zzbcr r2 = com.google.android.gms.internal.ads.zzbda.zzb
            java.lang.Object r2 = r2.zze()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x004a
            r10 = 1
            r3 = 1
            goto L_0x004d
        L_0x004a:
            r10 = r10 | r1
            r3 = r10
            goto L_0x0037
        L_0x004d:
            if (r3 == 0) goto L_0x005c
            java.lang.Object r9 = r8.zze()
            if (r9 != 0) goto L_0x00a2
            if (r10 != 0) goto L_0x00a2
            java.lang.Object r9 = r8.zzf()
            goto L_0x00a2
        L_0x005c:
            java.lang.Object r10 = r8.zzf()
            if (r10 != 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzbcr r1 = com.google.android.gms.internal.ads.zzbdn.zza
            java.lang.Object r1 = r1.zze()
            java.lang.Long r1 = (java.lang.Long) r1
            int r1 = r1.intValue()
            java.util.Random r2 = com.google.android.gms.ads.internal.client.zzay.zze()
            int r1 = r2.nextInt(r1)
            if (r1 != 0) goto L_0x009a
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            java.lang.String r1 = "action"
            java.lang.String r2 = "dynamite_load"
            r6.putString(r1, r2)
            java.lang.String r1 = "is_missing"
            r6.putInt(r1, r0)
            com.google.android.gms.internal.ads.zzbzk r2 = com.google.android.gms.ads.internal.client.zzay.zzb()
            com.google.android.gms.internal.ads.zzbzx r0 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.String r4 = r0.zza
            java.lang.String r5 = "gmob-apps"
            r7 = 1
            r3 = r9
            r2.zzn(r3, r4, r5, r6, r7)
        L_0x009a:
            if (r10 != 0) goto L_0x00a1
            java.lang.Object r9 = r8.zze()
            goto L_0x00a2
        L_0x00a1:
            r9 = r10
        L_0x00a2:
            if (r9 != 0) goto L_0x00a8
            java.lang.Object r9 = r8.zza()
        L_0x00a8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzax.zzd(android.content.Context, boolean):java.lang.Object");
    }
}
