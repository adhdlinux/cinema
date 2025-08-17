package com.google.android.gms.cast;

import android.os.Parcelable;

public final class zzd implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
        L_0x000d:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0051
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 2: goto L_0x004c;
                case 3: goto L_0x0047;
                case 4: goto L_0x0040;
                case 5: goto L_0x003b;
                case 6: goto L_0x0036;
                case 7: goto L_0x002c;
                case 8: goto L_0x0027;
                case 9: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000d
        L_0x0022:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x0027:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x002c:
            android.os.Parcelable$Creator r2 = android.net.Uri.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r8 = r1
            android.net.Uri r8 = (android.net.Uri) r8
            goto L_0x000d
        L_0x0036:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x003b:
            java.util.ArrayList r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r12, r1)
            goto L_0x000d
        L_0x0040:
            android.os.Parcelable$Creator<com.google.android.gms.common.images.WebImage> r2 = com.google.android.gms.common.images.WebImage.CREATOR
            java.util.ArrayList r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r12, r1, r2)
            goto L_0x000d
        L_0x0047:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x004c:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r12, r1)
            goto L_0x000d
        L_0x0051:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.cast.ApplicationMetadata r12 = new com.google.android.gms.cast.ApplicationMetadata
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.zzd.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ApplicationMetadata[i2];
    }
}
