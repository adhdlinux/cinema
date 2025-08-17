package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public final class zzfuf {
    private static final OutputStream zza = new zzfue();

    public static byte[] zza(InputStream inputStream) throws IOException {
        int i2;
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int highestOneBit = Integer.highestOneBit(0);
        int min = Math.min(8192, Math.max(128, highestOneBit + highestOneBit));
        int i3 = 0;
        while (i3 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i3);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i4 = 0;
            while (i4 < min2) {
                int read = inputStream.read(bArr, i4, min2 - i4);
                if (read == -1) {
                    return zzb(arrayDeque, i3);
                }
                i4 += read;
                i3 += read;
            }
            if (min < 4096) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            min = zzfuk.zzc(((long) min) * ((long) i2));
        }
        if (inputStream.read() == -1) {
            return zzb(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzb(Queue queue, int i2) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i2);
        int i3 = i2 - length;
        while (i3 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(i3, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i2 - i3, min);
            i3 -= min;
        }
        return copyOf;
    }
}
