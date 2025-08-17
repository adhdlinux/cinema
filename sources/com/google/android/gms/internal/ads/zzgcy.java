package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

public final class zzgcy extends zzgcz {
    public zzgcy(byte[] bArr, int i2) throws InvalidKeyException {
        super(bArr, i2);
    }

    public final int zza() {
        return 12;
    }

    public final int[] zzb(int[] iArr, int i2) {
        int length = iArr.length;
        if (length == 3) {
            int[] iArr2 = new int[16];
            zzgcv.zzb(iArr2, this.zza);
            iArr2[12] = i2;
            System.arraycopy(iArr, 0, iArr2, 13, 3);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(length * 32)}));
    }
}
