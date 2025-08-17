package com.google.android.gms.internal.ads;

public abstract class zzbkt extends zzatr implements zzbku {
    public zzbkt() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbE(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 3
            if (r3 == r6) goto L_0x0063
            r6 = 4
            if (r3 == r6) goto L_0x005c
            r6 = 5
            if (r3 == r6) goto L_0x002e
            r6 = 6
            if (r3 == r6) goto L_0x001c
            r4 = 7
            if (r3 == r4) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            com.google.android.gms.internal.ads.zzbeo r3 = r2.zzc()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzats.zzf(r5, r3)
            goto L_0x006d
        L_0x001c:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzats.zzc(r4)
            r2.zze(r3)
            r5.writeNoException()
            goto L_0x006d
        L_0x002e:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x003e
            r6 = 0
            goto L_0x0052
        L_0x003e:
            java.lang.String r0 = "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbkx
            if (r1 == 0) goto L_0x004c
            r6 = r0
            com.google.android.gms.internal.ads.zzbkx r6 = (com.google.android.gms.internal.ads.zzbkx) r6
            goto L_0x0052
        L_0x004c:
            com.google.android.gms.internal.ads.zzbkv r0 = new com.google.android.gms.internal.ads.zzbkv
            r0.<init>(r6)
            r6 = r0
        L_0x0052:
            com.google.android.gms.internal.ads.zzats.zzc(r4)
            r2.zzf(r3, r6)
            r5.writeNoException()
            goto L_0x006d
        L_0x005c:
            r2.zzd()
            r5.writeNoException()
            goto L_0x006d
        L_0x0063:
            com.google.android.gms.ads.internal.client.zzdq r3 = r2.zzb()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzats.zzf(r5, r3)
        L_0x006d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbkt.zzbE(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
