package com.google.android.gms.cast.framework.media;

import android.os.Parcelable;

public final class zza implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = 0
            r9 = 0
        L_0x000c:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0044
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x003f;
                case 3: goto L_0x003a;
                case 4: goto L_0x0035;
                case 5: goto L_0x002b;
                case 6: goto L_0x0026;
                case 7: goto L_0x0021;
                default: goto L_0x001d;
            }
        L_0x001d:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x000c
        L_0x0021:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r11, r1)
            goto L_0x000c
        L_0x0026:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r11, r1)
            goto L_0x000c
        L_0x002b:
            android.os.Parcelable$Creator<com.google.android.gms.cast.framework.media.NotificationOptions> r2 = com.google.android.gms.cast.framework.media.NotificationOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r2)
            r7 = r1
            com.google.android.gms.cast.framework.media.NotificationOptions r7 = (com.google.android.gms.cast.framework.media.NotificationOptions) r7
            goto L_0x000c
        L_0x0035:
            android.os.IBinder r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r11, r1)
            goto L_0x000c
        L_0x003a:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x003f:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r11, r1)
            goto L_0x000c
        L_0x0044:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.google.android.gms.cast.framework.media.CastMediaOptions r11 = new com.google.android.gms.cast.framework.media.CastMediaOptions
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.zza.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CastMediaOptions[i2];
    }
}
