package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzakr {
    public static long zza(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 16);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzg(byteBuffer);
        return zze(byteBuffer, byteBuffer.position() + 12);
    }

    static Pair zzc(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair zzf = zzf(randomAccessFile, 0);
        if (zzf != null) {
            return zzf;
        }
        return zzf(randomAccessFile, 65535);
    }

    public static void zzd(ByteBuffer byteBuffer, long j2) {
        zzg(byteBuffer);
        int position = byteBuffer.position() + 16;
        if (j2 < 0 || j2 > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: " + j2);
        }
        byteBuffer.putInt(byteBuffer.position() + position, (int) j2);
    }

    private static long zze(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & 4294967295L;
    }

    private static Pair zzf(RandomAccessFile randomAccessFile, int i2) throws IOException {
        int i3;
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i2, -22 + length)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        zzg(allocate);
        int capacity2 = allocate.capacity();
        if (capacity2 >= 22) {
            int i4 = capacity2 - 22;
            int min = Math.min(i4, 65535);
            int i5 = 0;
            while (true) {
                if (i5 >= min) {
                    break;
                }
                i3 = i4 - i5;
                if (allocate.getInt(i3) == 101010256 && ((char) allocate.getShort(i3 + 20)) == i5) {
                    break;
                }
                i5++;
            }
        }
        i3 = -1;
        if (i3 == -1) {
            return null;
        }
        allocate.position(i3);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + ((long) i3)));
    }

    private static void zzg(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
