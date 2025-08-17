package com.google.android.gms.internal.cast;

public abstract class zzak extends zzb implements zzal {
    public zzak() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            switch(r3) {
                case 1: goto L_0x00bb;
                case 2: goto L_0x00a5;
                case 3: goto L_0x0093;
                case 4: goto L_0x0079;
                case 5: goto L_0x006a;
                case 6: goto L_0x0062;
                case 7: goto L_0x0054;
                case 8: goto L_0x0041;
                case 9: goto L_0x0035;
                case 10: goto L_0x002a;
                case 11: goto L_0x0022;
                case 12: goto L_0x0014;
                case 13: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r3 = 0
            return r3
        L_0x0005:
            int r3 = r4.readInt()
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            r2.zzj(r3)
            r5.writeNoException()
            goto L_0x00e8
        L_0x0014:
            boolean r3 = r2.zzk()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.cast.zzc.zza
            r5.writeInt(r3)
            goto L_0x00e8
        L_0x0022:
            r2.zzf()
            r5.writeNoException()
            goto L_0x00e8
        L_0x002a:
            r5.writeNoException()
            r3 = 12451000(0xbdfcb8, float:1.7447567E-38)
            r5.writeInt(r3)
            goto L_0x00e8
        L_0x0035:
            java.lang.String r3 = r2.zzc()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x00e8
        L_0x0041:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            android.os.Bundle r3 = r2.zzb(r3)
            r5.writeNoException()
            com.google.android.gms.internal.cast.zzc.zzd(r5, r3)
            goto L_0x00e8
        L_0x0054:
            boolean r3 = r2.zzl()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.cast.zzc.zza
            r5.writeInt(r3)
            goto L_0x00e8
        L_0x0062:
            r2.zzh()
            r5.writeNoException()
            goto L_0x00e8
        L_0x006a:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            r2.zzi(r3)
            r5.writeNoException()
            goto L_0x00e8
        L_0x0079:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.cast.zzc.zza(r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            int r6 = r4.readInt()
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            boolean r3 = r2.zzm(r3, r6)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x00e8
        L_0x0093:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.cast.zzc.zza(r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            r2.zzg(r3)
            r5.writeNoException()
            goto L_0x00e8
        L_0x00a5:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.cast.zzc.zza(r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            int r6 = r4.readInt()
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            r2.zzd(r3, r6)
            r5.writeNoException()
            goto L_0x00e8
        L_0x00bb:
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.cast.zzc.zza(r4, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x00cb
            r6 = 0
            goto L_0x00df
        L_0x00cb:
            java.lang.String r0 = "com.google.android.gms.cast.framework.internal.IMediaRouterCallback"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.cast.zzan
            if (r1 == 0) goto L_0x00d9
            r6 = r0
            com.google.android.gms.internal.cast.zzan r6 = (com.google.android.gms.internal.cast.zzan) r6
            goto L_0x00df
        L_0x00d9:
            com.google.android.gms.internal.cast.zzam r0 = new com.google.android.gms.internal.cast.zzam
            r0.<init>(r6)
            r6 = r0
        L_0x00df:
            com.google.android.gms.internal.cast.zzc.zzb(r4)
            r2.zze(r3, r6)
            r5.writeNoException()
        L_0x00e8:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzak.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
