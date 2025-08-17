package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzgcz {
    int[] zza;
    private final int zzb;

    public zzgcz(byte[] bArr, int i2) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzgcv.zzd(bArr);
            this.zzb = i2;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i2);

    /* access modifiers changed from: package-private */
    public final ByteBuffer zzc(byte[] bArr, int i2) {
        int[] zzb2 = zzb(zzgcv.zzd(bArr), i2);
        int[] iArr = (int[]) zzb2.clone();
        zzgcv.zzc(iArr);
        for (int i3 = 0; i3 < 16; i3++) {
            zzb2[i3] = zzb2[i3] + iArr[i3];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb2, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length == zza()) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining / 64;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                if (i3 >= i4) {
                    return allocate.array();
                }
                ByteBuffer zzc = zzc(bArr, this.zzb + i3);
                if (i3 == i4 - 1) {
                    zzgmg.zza(allocate, byteBuffer, zzc, remaining % 64);
                } else {
                    zzgmg.zza(allocate, byteBuffer, zzc, 64);
                }
                i3++;
            }
        } else {
            int zza2 = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza2);
        }
    }
}
