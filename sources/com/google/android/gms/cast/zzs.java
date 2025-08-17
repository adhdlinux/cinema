package com.google.android.gms.cast;

import android.os.Parcelable;

public final class zzs implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r24) {
        /*
            r23 = this;
            r0 = r24
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r24)
            r2 = 0
            r3 = 0
            r4 = -1
            r6 = r2
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r12 = r10
            r15 = r12
            r16 = r15
            r18 = r16
            r19 = r18
            r20 = r19
            r22 = r20
            r11 = 0
            r13 = 0
            r14 = -1
            r17 = 0
            r21 = 0
        L_0x0021:
            int r2 = r24.dataPosition()
            if (r2 >= r1) goto L_0x0093
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r24)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x008e;
                case 3: goto L_0x0089;
                case 4: goto L_0x0084;
                case 5: goto L_0x007f;
                case 6: goto L_0x007a;
                case 7: goto L_0x0075;
                case 8: goto L_0x006e;
                case 9: goto L_0x0069;
                case 10: goto L_0x0064;
                case 11: goto L_0x005f;
                case 12: goto L_0x005a;
                case 13: goto L_0x0055;
                case 14: goto L_0x0050;
                case 15: goto L_0x004b;
                case 16: goto L_0x0046;
                case 17: goto L_0x0041;
                case 18: goto L_0x0036;
                default: goto L_0x0032;
            }
        L_0x0032:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0021
        L_0x0036:
            android.os.Parcelable$Creator<com.google.android.gms.cast.internal.zzz> r3 = com.google.android.gms.cast.internal.zzz.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r22 = r2
            com.google.android.gms.cast.internal.zzz r22 = (com.google.android.gms.cast.internal.zzz) r22
            goto L_0x0021
        L_0x0041:
            boolean r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0021
        L_0x0046:
            java.lang.String r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x004b:
            byte[] r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createByteArray(r0, r2)
            goto L_0x0021
        L_0x0050:
            java.lang.String r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0055:
            int r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0021
        L_0x005a:
            java.lang.String r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x005f:
            java.lang.String r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0064:
            int r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0021
        L_0x0069:
            int r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0021
        L_0x006e:
            android.os.Parcelable$Creator<com.google.android.gms.common.images.WebImage> r3 = com.google.android.gms.common.images.WebImage.CREATOR
            java.util.ArrayList r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x0021
        L_0x0075:
            int r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0021
        L_0x007a:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x007f:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0084:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0089:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x008e:
            java.lang.String r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0021
        L_0x0093:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.cast.CastDevice r0 = new com.google.android.gms.cast.CastDevice
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.zzs.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CastDevice[i2];
    }
}
