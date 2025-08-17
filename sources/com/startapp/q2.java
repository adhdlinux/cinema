package com.startapp;

public class q2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35634a = "q2";

    /* renamed from: b  reason: collision with root package name */
    private static final int f35635b = 32;

    /* renamed from: c  reason: collision with root package name */
    private static final int f35636c = 40;

    /* renamed from: d  reason: collision with root package name */
    private static final int f35637d = 48;

    /* renamed from: e  reason: collision with root package name */
    private static final int f35638e = 123;

    /* renamed from: f  reason: collision with root package name */
    private static final int f35639f = 3;

    /* renamed from: g  reason: collision with root package name */
    private static final int f35640g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final long f35641h = 2208988800L;

    /* renamed from: i  reason: collision with root package name */
    private long f35642i;

    private long b(byte[] bArr, int i2) {
        return ((a(bArr, i2) - f35641h) * 1000) + ((a(bArr, i2 + 4) * 1000) / 4294967296L);
    }

    private void c(byte[] bArr, int i2) {
        for (int i3 = i2; i3 < i2 + 8; i3++) {
            bArr[i3] = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            java.net.DatagramSocket r1 = new java.net.DatagramSocket     // Catch:{ all -> 0x003e }
            r1.<init>()     // Catch:{ all -> 0x003e }
            r1.setSoTimeout(r7)     // Catch:{ all -> 0x003c }
            java.net.InetAddress r6 = java.net.InetAddress.getByName(r6)     // Catch:{ all -> 0x003c }
            r7 = 48
            byte[] r2 = new byte[r7]     // Catch:{ all -> 0x003c }
            java.net.DatagramPacket r3 = new java.net.DatagramPacket     // Catch:{ all -> 0x003c }
            r4 = 123(0x7b, float:1.72E-43)
            r3.<init>(r2, r7, r6, r4)     // Catch:{ all -> 0x003c }
            r6 = 27
            r2[r0] = r6     // Catch:{ all -> 0x003c }
            r6 = 40
            r5.c(r2, r6)     // Catch:{ all -> 0x003c }
            r1.send(r3)     // Catch:{ all -> 0x003c }
            java.net.DatagramPacket r6 = new java.net.DatagramPacket     // Catch:{ all -> 0x003c }
            r6.<init>(r2, r7)     // Catch:{ all -> 0x003c }
            r1.receive(r6)     // Catch:{ all -> 0x003c }
            r1.close()     // Catch:{ all -> 0x003c }
            r6 = 32
            long r6 = r5.b(r2, r6)     // Catch:{ all -> 0x003c }
            r5.f35642i = r6     // Catch:{ all -> 0x003c }
            r1.close()
            r6 = 1
            return r6
        L_0x003c:
            r6 = move-exception
            goto L_0x0040
        L_0x003e:
            r6 = move-exception
            r1 = 0
        L_0x0040:
            com.startapp.l2.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0048
            r1.close()
        L_0x0048:
            return r0
        L_0x0049:
            r6 = move-exception
            if (r1 == 0) goto L_0x004f
            r1.close()
        L_0x004f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.q2.a(java.lang.String, int):boolean");
    }

    public long a() {
        return this.f35642i;
    }

    private long a(byte[] bArr, int i2) {
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        byte b5 = bArr[i2 + 3];
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + y1.f36938c;
        }
        byte b9 = b5 & true;
        int i6 = b5;
        if (b9 == true) {
            i6 = (b5 & Byte.MAX_VALUE) + y1.f36938c;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }
}
