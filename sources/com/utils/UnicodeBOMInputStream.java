package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class UnicodeBOMInputStream extends InputStream {

    /* renamed from: b  reason: collision with root package name */
    private final PushbackInputStream f37597b;

    /* renamed from: c  reason: collision with root package name */
    private final BOM f37598c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37599d = false;

    public static final class BOM {

        /* renamed from: c  reason: collision with root package name */
        public static final BOM f37600c = new BOM(new byte[0], "NONE");

        /* renamed from: d  reason: collision with root package name */
        public static final BOM f37601d = new BOM(new byte[]{-17, -69, -65}, "UTF-8");

        /* renamed from: e  reason: collision with root package name */
        public static final BOM f37602e = new BOM(new byte[]{-1, -2}, "UTF-16 little-endian");

        /* renamed from: f  reason: collision with root package name */
        public static final BOM f37603f = new BOM(new byte[]{-2, -1}, "UTF-16 big-endian");

        /* renamed from: g  reason: collision with root package name */
        public static final BOM f37604g = new BOM(new byte[]{-1, -2, 0, 0}, "UTF-32 little-endian");

        /* renamed from: h  reason: collision with root package name */
        public static final BOM f37605h = new BOM(new byte[]{0, 0, -2, -1}, "UTF-32 big-endian");

        /* renamed from: a  reason: collision with root package name */
        final byte[] f37606a;

        /* renamed from: b  reason: collision with root package name */
        private final String f37607b;

        private BOM(byte[] bArr, String str) {
            this.f37606a = bArr;
            this.f37607b = str;
        }

        public final String toString() {
            return this.f37607b;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UnicodeBOMInputStream(java.io.InputStream r11) throws java.lang.NullPointerException, java.io.IOException {
        /*
            r10 = this;
            r10.<init>()
            r0 = 0
            r10.f37599d = r0
            if (r11 == 0) goto L_0x0083
            java.io.PushbackInputStream r1 = new java.io.PushbackInputStream
            r2 = 4
            r1.<init>(r11, r2)
            r10.f37597b = r1
            byte[] r11 = new byte[r2]
            int r3 = r1.read(r11)
            r4 = -2
            r5 = -1
            r6 = 2
            r7 = 1
            if (r3 == r6) goto L_0x0061
            r8 = 3
            if (r3 == r8) goto L_0x004a
            if (r3 == r2) goto L_0x0022
            goto L_0x0079
        L_0x0022:
            byte r2 = r11[r0]
            if (r2 != r5) goto L_0x0037
            byte r9 = r11[r7]
            if (r9 != r4) goto L_0x0037
            byte r9 = r11[r6]
            if (r9 != 0) goto L_0x0037
            byte r9 = r11[r8]
            if (r9 != 0) goto L_0x0037
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37604g
            r10.f37598c = r2
            goto L_0x007d
        L_0x0037:
            if (r2 != 0) goto L_0x004a
            byte r2 = r11[r7]
            if (r2 != 0) goto L_0x004a
            byte r2 = r11[r6]
            if (r2 != r4) goto L_0x004a
            byte r2 = r11[r8]
            if (r2 != r5) goto L_0x004a
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37605h
            r10.f37598c = r2
            goto L_0x007d
        L_0x004a:
            byte r2 = r11[r0]
            r8 = -17
            if (r2 != r8) goto L_0x0061
            byte r2 = r11[r7]
            r8 = -69
            if (r2 != r8) goto L_0x0061
            byte r2 = r11[r6]
            r6 = -65
            if (r2 != r6) goto L_0x0061
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37601d
            r10.f37598c = r2
            goto L_0x007d
        L_0x0061:
            byte r2 = r11[r0]
            if (r2 != r5) goto L_0x006e
            byte r6 = r11[r7]
            if (r6 != r4) goto L_0x006e
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37602e
            r10.f37598c = r2
            goto L_0x007d
        L_0x006e:
            if (r2 != r4) goto L_0x0079
            byte r2 = r11[r7]
            if (r2 != r5) goto L_0x0079
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37603f
            r10.f37598c = r2
            goto L_0x007d
        L_0x0079:
            com.utils.UnicodeBOMInputStream$BOM r2 = com.utils.UnicodeBOMInputStream.BOM.f37600c
            r10.f37598c = r2
        L_0x007d:
            if (r3 <= 0) goto L_0x0082
            r1.unread(r11, r0, r3)
        L_0x0082:
            return
        L_0x0083:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r0 = "invalid input stream: null is not allowed"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.UnicodeBOMInputStream.<init>(java.io.InputStream):void");
    }

    public final BOM a() {
        return this.f37598c;
    }

    public int available() throws IOException {
        return this.f37597b.available();
    }

    public void close() throws IOException {
        this.f37597b.close();
    }

    public synchronized void mark(int i2) {
        this.f37597b.mark(i2);
    }

    public boolean markSupported() {
        return this.f37597b.markSupported();
    }

    public int read() throws IOException {
        return this.f37597b.read();
    }

    public synchronized void reset() throws IOException {
        this.f37597b.reset();
    }

    public long skip(long j2) throws IOException {
        return this.f37597b.skip(j2);
    }

    public int read(byte[] bArr) throws IOException, NullPointerException {
        return this.f37597b.read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException, NullPointerException {
        return this.f37597b.read(bArr, i2, i3);
    }
}
