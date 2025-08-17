package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public final class zzapb {
    private final byte[] zza = new byte[UserVerificationMethods.USER_VERIFY_HANDPRINT];
    private int zzb;
    private int zzc;

    public zzapb(byte[] bArr) {
        for (int i2 = 0; i2 < 256; i2++) {
            this.zza[i2] = (byte) i2;
        }
        byte b2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zza;
            byte b3 = bArr2[i3];
            b2 = (b2 + b3 + bArr[i3 % bArr.length]) & 255;
            bArr2[i3] = bArr2[b2];
            bArr2[b2] = b3;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i2 = this.zzb;
        int i3 = this.zzc;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.zza;
            i2 = (i2 + 1) & JfifUtil.MARKER_FIRST_BYTE;
            byte b2 = bArr2[i2];
            i3 = (i3 + b2) & JfifUtil.MARKER_FIRST_BYTE;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b2;
            bArr[i4] = (byte) (bArr2[(bArr2[i2] + b2) & JfifUtil.MARKER_FIRST_BYTE] ^ bArr[i4]);
        }
        this.zzb = i2;
        this.zzc = i3;
    }
}
