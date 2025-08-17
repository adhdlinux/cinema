package com.google.android.gms.internal.ads;

import android.os.Parcelable;

public final class zzbuf implements Parcelable.Creator {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r18) {
        /*
            r17 = this;
            r0 = r18
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r18)
            r2 = 0
            r3 = 0
            r5 = r3
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = 0
            r16 = 0
        L_0x0015:
            int r2 = r18.dataPosition()
            if (r2 >= r1) goto L_0x007a
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r18)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x0075;
                case 2: goto L_0x006b;
                case 3: goto L_0x0061;
                case 4: goto L_0x005c;
                case 5: goto L_0x0057;
                case 6: goto L_0x004d;
                case 7: goto L_0x0048;
                case 8: goto L_0x0026;
                case 9: goto L_0x0043;
                case 10: goto L_0x0039;
                case 11: goto L_0x0034;
                case 12: goto L_0x002f;
                case 13: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0015
        L_0x002a:
            boolean r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x002f:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0015
        L_0x0034:
            java.lang.String r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzfcb> r3 = com.google.android.gms.internal.ads.zzfcb.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            com.google.android.gms.internal.ads.zzfcb r13 = (com.google.android.gms.internal.ads.zzfcb) r13
            goto L_0x0015
        L_0x0043:
            java.lang.String r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x0048:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x004d:
            android.os.Parcelable$Creator r3 = android.content.pm.PackageInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            android.content.pm.PackageInfo r10 = (android.content.pm.PackageInfo) r10
            goto L_0x0015
        L_0x0057:
            java.util.ArrayList r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0015
        L_0x005c:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0015
        L_0x0061:
            android.os.Parcelable$Creator r3 = android.content.pm.ApplicationInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r7 = r2
            android.content.pm.ApplicationInfo r7 = (android.content.pm.ApplicationInfo) r7
            goto L_0x0015
        L_0x006b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbzx> r3 = com.google.android.gms.internal.ads.zzbzx.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r6 = r2
            com.google.android.gms.internal.ads.zzbzx r6 = (com.google.android.gms.internal.ads.zzbzx) r6
            goto L_0x0015
        L_0x0075:
            android.os.Bundle r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0015
        L_0x007a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.internal.ads.zzbue r0 = new com.google.android.gms.internal.ads.zzbue
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuf.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbue[i2];
    }
}
