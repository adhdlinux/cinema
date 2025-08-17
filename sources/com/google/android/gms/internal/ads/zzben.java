package com.google.android.gms.internal.ads;

public abstract class zzben extends zzatr implements zzbeo {
    public zzben() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbE(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 2: goto L_0x0084;
                case 3: goto L_0x0072;
                case 4: goto L_0x0067;
                case 5: goto L_0x005c;
                case 6: goto L_0x0051;
                case 7: goto L_0x0046;
                case 8: goto L_0x0039;
                case 9: goto L_0x0013;
                case 10: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            boolean r2 = r1.zzk()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzats.zza
            r4.writeInt(r2)
            goto L_0x008e
        L_0x0013:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x001b
            r2 = 0
            goto L_0x002f
        L_0x001b:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbfz
            if (r0 == 0) goto L_0x0029
            r2 = r5
            com.google.android.gms.internal.ads.zzbfz r2 = (com.google.android.gms.internal.ads.zzbfz) r2
            goto L_0x002f
        L_0x0029:
            com.google.android.gms.internal.ads.zzbfz r5 = new com.google.android.gms.internal.ads.zzbfz
            r5.<init>(r2)
            r2 = r5
        L_0x002f:
            com.google.android.gms.internal.ads.zzats.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x008e
        L_0x0039:
            boolean r2 = r1.zzl()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzats.zza
            r4.writeInt(r2)
            goto L_0x008e
        L_0x0046:
            com.google.android.gms.ads.internal.client.zzdq r2 = r1.zzh()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzats.zzf(r4, r2)
            goto L_0x008e
        L_0x0051:
            float r2 = r1.zzf()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x008e
        L_0x005c:
            float r2 = r1.zzg()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x008e
        L_0x0067:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzats.zzf(r4, r2)
            goto L_0x008e
        L_0x0072:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzats.zzc(r3)
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x008e
        L_0x0084:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
        L_0x008e:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzben.zzbE(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
