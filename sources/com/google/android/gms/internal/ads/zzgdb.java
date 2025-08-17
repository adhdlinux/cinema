package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

abstract class zzgdb {
    private final zzgcz zza;
    private final zzgcz zzb;

    public zzgdb(byte[] bArr) throws GeneralSecurityException {
        if (zzgdh.zza(1)) {
            this.zza = zza(bArr, 1);
            this.zzb = zza(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    /* access modifiers changed from: package-private */
    public abstract zzgcz zza(byte[] bArr, int i2) throws InvalidKeyException;

    public final byte[] zzb(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i2;
        int i3;
        if (byteBuffer.remaining() >= 16) {
            int position = byteBuffer.position();
            byte[] bArr3 = new byte[16];
            byteBuffer.position(byteBuffer.limit() - 16);
            byteBuffer.get(bArr3);
            byteBuffer.position(position);
            byteBuffer.limit(byteBuffer.limit() - 16);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            try {
                byte[] bArr4 = new byte[32];
                this.zzb.zzc(bArr, 0).get(bArr4);
                int length = bArr2.length;
                int i4 = length & 15;
                if (i4 == 0) {
                    i2 = length;
                } else {
                    i2 = (length + 16) - i4;
                }
                int remaining = byteBuffer.remaining();
                int i5 = remaining % 16;
                if (i5 == 0) {
                    i3 = remaining;
                } else {
                    i3 = (remaining + 16) - i5;
                }
                int i6 = i3 + i2;
                ByteBuffer order = ByteBuffer.allocate(i6 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(i2);
                order.put(byteBuffer);
                order.position(i6);
                order.putLong((long) length);
                order.putLong((long) remaining);
                if (MessageDigest.isEqual(zzgde.zza(bArr4, order.array()), bArr3)) {
                    byteBuffer.position(position);
                    return this.zza.zzd(bArr, byteBuffer);
                }
                throw new GeneralSecurityException("invalid MAC");
            } catch (GeneralSecurityException e2) {
                throw new AEADBadTagException(e2.toString());
            }
        } else {
            throw new GeneralSecurityException("ciphertext too short");
        }
    }
}
