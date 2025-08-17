package com.startapp;

import java.util.Arrays;

public abstract class hf {

    /* renamed from: a  reason: collision with root package name */
    public final int f34660a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34661b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34662c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34663d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f34664a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f34665b;

        /* renamed from: c  reason: collision with root package name */
        public int f34666c;

        /* renamed from: d  reason: collision with root package name */
        public int f34667d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f34668e;

        /* renamed from: f  reason: collision with root package name */
        public int f34669f;

        /* renamed from: g  reason: collision with root package name */
        public int f34670g;

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{a.class.getSimpleName(), Arrays.toString(this.f34665b), Integer.valueOf(this.f34669f), Boolean.valueOf(this.f34668e), Integer.valueOf(this.f34664a), 0L, Integer.valueOf(this.f34670g), Integer.valueOf(this.f34666c), Integer.valueOf(this.f34667d)});
        }
    }

    public hf(int i2, int i3, int i4, int i5) {
        boolean z2;
        this.f34660a = i2;
        this.f34661b = i3;
        int i6 = 0;
        if (i4 <= 0 || i5 <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f34662c = z2 ? (i4 / i3) * i3 : i6;
        this.f34663d = i5;
    }

    public byte[] a(int i2, a aVar) {
        byte[] bArr = aVar.f34665b;
        if (bArr != null && bArr.length >= aVar.f34666c + i2) {
            return bArr;
        }
        if (bArr == null) {
            aVar.f34665b = new byte[8192];
            aVar.f34666c = 0;
            aVar.f34667d = 0;
        } else {
            byte[] bArr2 = new byte[(bArr.length * 2)];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f34665b = bArr2;
        }
        return aVar.f34665b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[LOOP:0: B:1:0x0003->B:12:0x001e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r8) {
        /*
            r7 = this;
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x0003:
            if (r2 >= r0) goto L_0x0022
            byte r3 = r8[r2]
            r4 = 61
            r5 = 1
            if (r4 == r3) goto L_0x0021
            if (r3 < 0) goto L_0x001a
            byte[] r4 = com.startapp.gf.f34598h
            int r6 = r4.length
            if (r3 >= r6) goto L_0x001a
            byte r3 = r4[r3]
            r4 = -1
            if (r3 == r4) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x001e
            goto L_0x0021
        L_0x001e:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x0021:
            return r5
        L_0x0022:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.hf.a(byte[]):boolean");
    }
}
