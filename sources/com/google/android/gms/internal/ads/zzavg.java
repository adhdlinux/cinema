package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

public final class zzavg extends zzavb {
    private MessageDigest zzb;

    public final byte[] zzb(String str) {
        byte[] bArr;
        byte[] bArr2;
        String[] split = str.split(" ");
        int length = split.length;
        int i2 = 4;
        if (length == 1) {
            int zza = zzavf.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr = allocate.array();
        } else {
            if (length < 5) {
                bArr2 = new byte[(length + length)];
                for (int i3 = 0; i3 < split.length; i3++) {
                    int zza2 = zzavf.zza(split[i3]);
                    char c2 = (zza2 >> 16) ^ ((char) zza2);
                    byte b2 = (byte) c2;
                    byte[] bArr3 = {b2, (byte) (c2 >> 8)};
                    int i4 = i3 + i3;
                    bArr2[i4] = b2;
                    bArr2[i4 + 1] = bArr3[1];
                }
            } else {
                bArr2 = new byte[length];
                for (int i5 = 0; i5 < split.length; i5++) {
                    int zza3 = zzavf.zza(split[i5]);
                    bArr2[i5] = (byte) ((zza3 >> 24) ^ (((zza3 & JfifUtil.MARKER_FIRST_BYTE) ^ ((zza3 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) ^ ((zza3 >> 16) & JfifUtil.MARKER_FIRST_BYTE)));
                }
            }
            bArr = bArr2;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            messageDigest.reset();
            this.zzb.update(bArr);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i2 = length2;
            }
            byte[] bArr5 = new byte[i2];
            System.arraycopy(digest, 0, bArr5, 0, i2);
            return bArr5;
        }
    }
}
