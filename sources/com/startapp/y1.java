package com.startapp;

import java.nio.ByteBuffer;
import java.util.Random;

public class y1 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36936a = 65507;

    /* renamed from: b  reason: collision with root package name */
    public static final byte f36937b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final byte f36938c = Byte.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private static final byte f36939d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f36940e = 8;

    /* renamed from: f  reason: collision with root package name */
    private final byte f36941f;

    public y1(byte b2) {
        this.f36941f = b2;
    }

    public ByteBuffer a(short s2, short s3, byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        } else if (bArr.length > f36936a) {
            bArr = a(f36936a);
        }
        int length = bArr.length + 8;
        byte[] bArr2 = new byte[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        wrap.put(this.f36941f);
        wrap.put(f36939d);
        int position = wrap.position();
        wrap.position(position + 2);
        wrap.putShort(s3);
        wrap.putShort(s2);
        wrap.put(bArr);
        wrap.putShort(position, a(bArr2, length));
        wrap.flip();
        return wrap;
    }

    private static short a(byte[] bArr, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4 += 2) {
            int i5 = i3 + ((bArr[i4] & 255) << 8);
            i3 = (i5 >> 16) + (65535 & i5);
        }
        for (int i6 = 1; i6 < i2; i6 += 2) {
            int i7 = i3 + (bArr[i6] & 255);
            i3 = (i7 >> 16) + (i7 & 65535);
        }
        return (short) (((i3 & 65535) + (i3 >> 16)) ^ 65535);
    }

    public static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        new Random().nextBytes(bArr);
        return bArr;
    }
}
