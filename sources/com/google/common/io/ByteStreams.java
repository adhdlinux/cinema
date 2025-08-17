package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public final class ByteStreams {

    /* renamed from: a  reason: collision with root package name */
    private static final OutputStream f30680a = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i2) {
        }

        public void write(byte[] bArr) {
            Preconditions.l(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) {
            Preconditions.l(bArr);
            Preconditions.p(i2, i3 + i2, bArr.length);
        }
    };

    private ByteStreams() {
    }

    private static byte[] a(Queue<byte[]> queue, int i2) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i2) {
            return remove;
        }
        int length = i2 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i2);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i2 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.l(inputStream);
        Preconditions.l(outputStream);
        byte[] c2 = c();
        long j2 = 0;
        while (true) {
            int read = inputStream.read(c2);
            if (read == -1) {
                return j2;
            }
            outputStream.write(c2, 0, read);
            j2 += (long) read;
        }
    }

    static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        Preconditions.l(inputStream);
        return f(inputStream, new ArrayDeque(20), 0);
    }

    static byte[] e(InputStream inputStream, long j2) throws IOException {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.g(z2, "expectedSize (%s) must be non-negative", j2);
        if (j2 <= 2147483639) {
            int i2 = (int) j2;
            byte[] bArr = new byte[i2];
            int i3 = i2;
            while (i3 > 0) {
                int i4 = i2 - i3;
                int read = inputStream.read(bArr, i4, i3);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i4);
                }
                i3 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return f(inputStream, arrayDeque, i2 + 1);
        }
        throw new OutOfMemoryError(j2 + " bytes is too large to fit in a byte array");
    }

    private static byte[] f(InputStream inputStream, Queue<byte[]> queue, int i2) throws IOException {
        int i3;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i2) * 2));
        while (i2 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i2);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i4 = 0;
            while (i4 < min2) {
                int read = inputStream.read(bArr, i4, min2 - i4);
                if (read == -1) {
                    return a(queue, i2);
                }
                i4 += read;
                i2 += read;
            }
            if (min < 4096) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            min = IntMath.d(min, i3);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
