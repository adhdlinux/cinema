package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.internal.http2.Http2;

public final class ByteBufferUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<byte[]> f17130a = new AtomicReference<>();

    static final class SafeArray {

        /* renamed from: a  reason: collision with root package name */
        final int f17133a;

        /* renamed from: b  reason: collision with root package name */
        final int f17134b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f17135c;

        SafeArray(byte[] bArr, int i2, int i3) {
            this.f17135c = bArr;
            this.f17133a = i2;
            this.f17134b = i3;
        }
    }

    private ByteBufferUtil() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.nio.channels.spi.AbstractInterruptibleChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.RandomAccessFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.RandomAccessFile} */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|11|12|13) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A[SYNTHETIC, Splitter:B:24:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e A[SYNTHETIC, Splitter:B:28:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer a(java.io.File r8) throws java.io.IOException {
        /*
            r0 = 0
            long r5 = r8.length()     // Catch:{ all -> 0x0043 }
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x003b
            r1 = 0
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0033
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "r"
            r7.<init>(r8, r1)     // Catch:{ all -> 0x0043 }
            java.nio.channels.FileChannel r0 = r7.getChannel()     // Catch:{ all -> 0x0031 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0031 }
            r3 = 0
            r1 = r0
            java.nio.MappedByteBuffer r8 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0031 }
            java.nio.MappedByteBuffer r8 = r8.load()     // Catch:{ all -> 0x0031 }
            r0.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r7.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return r8
        L_0x0031:
            r8 = move-exception
            goto L_0x0045
        L_0x0033:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "File unsuitable for memory mapping"
            r8.<init>(r1)     // Catch:{ all -> 0x0043 }
            throw r8     // Catch:{ all -> 0x0043 }
        L_0x003b:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "File too large to map into memory"
            r8.<init>(r1)     // Catch:{ all -> 0x0043 }
            throw r8     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r8 = move-exception
            r7 = r0
        L_0x0045:
            if (r0 == 0) goto L_0x004c
            r0.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r7 == 0) goto L_0x0051
            r7.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.a(java.io.File):java.nio.ByteBuffer");
    }

    public static ByteBuffer b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        byte[] andSet = f17130a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        }
        while (true) {
            int read = inputStream.read(andSet);
            if (read >= 0) {
                byteArrayOutputStream.write(andSet, 0, read);
            } else {
                f17130a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return (ByteBuffer) ByteBuffer.allocateDirect(byteArray.length).put(byteArray).position(0);
            }
        }
    }

    private static SafeArray c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] d(ByteBuffer byteBuffer) {
        SafeArray c2 = c(byteBuffer);
        if (c2 != null && c2.f17133a == 0 && c2.f17134b == c2.f17135c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001f */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[SYNTHETIC, Splitter:B:14:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0030 A[SYNTHETIC, Splitter:B:18:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(java.nio.ByteBuffer r4, java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
            r4.position(r0)
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x0025 }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ all -> 0x0023 }
            r1.write(r4)     // Catch:{ all -> 0x0023 }
            r1.force(r0)     // Catch:{ all -> 0x0023 }
            r1.close()     // Catch:{ all -> 0x0023 }
            r2.close()     // Catch:{ all -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            r2.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            return
        L_0x0023:
            r4 = move-exception
            goto L_0x0027
        L_0x0025:
            r4 = move-exception
            r2 = r1
        L_0x0027:
            if (r1 == 0) goto L_0x002e
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ByteBufferUtil.e(java.nio.ByteBuffer, java.io.File):void");
    }

    public static InputStream f(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    private static class ByteBufferStream extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        private final ByteBuffer f17131b;

        /* renamed from: c  reason: collision with root package name */
        private int f17132c = -1;

        ByteBufferStream(ByteBuffer byteBuffer) {
            this.f17131b = byteBuffer;
        }

        public int available() {
            return this.f17131b.remaining();
        }

        public synchronized void mark(int i2) {
            this.f17132c = this.f17131b.position();
        }

        public boolean markSupported() {
            return true;
        }

        public int read() {
            if (!this.f17131b.hasRemaining()) {
                return -1;
            }
            return this.f17131b.get() & 255;
        }

        public synchronized void reset() throws IOException {
            int i2 = this.f17132c;
            if (i2 != -1) {
                this.f17131b.position(i2);
            } else {
                throw new IOException("Cannot reset to unset mark position");
            }
        }

        public long skip(long j2) throws IOException {
            if (!this.f17131b.hasRemaining()) {
                return -1;
            }
            long min = Math.min(j2, (long) available());
            ByteBuffer byteBuffer = this.f17131b;
            byteBuffer.position((int) (((long) byteBuffer.position()) + min));
            return min;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            if (!this.f17131b.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i3, available());
            this.f17131b.get(bArr, i2, min);
            return min;
        }
    }
}
