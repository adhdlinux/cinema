package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f16247a = new byte[UserVerificationMethods.USER_VERIFY_HANDPRINT];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f16248b;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f16249c;

    /* renamed from: d  reason: collision with root package name */
    private int f16250d = 0;

    private boolean b() {
        return this.f16249c.f16235b != 0;
    }

    private int d() {
        try {
            return this.f16248b.get() & 255;
        } catch (Exception unused) {
            this.f16249c.f16235b = 1;
            return 0;
        }
    }

    private void e() {
        boolean z2;
        this.f16249c.f16237d.f16223a = n();
        this.f16249c.f16237d.f16224b = n();
        this.f16249c.f16237d.f16225c = n();
        this.f16249c.f16237d.f16226d = n();
        int d2 = d();
        boolean z3 = false;
        if ((d2 & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int pow = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        GifFrame gifFrame = this.f16249c.f16237d;
        if ((d2 & 64) != 0) {
            z3 = true;
        }
        gifFrame.f16227e = z3;
        if (z2) {
            gifFrame.f16233k = g(pow);
        } else {
            gifFrame.f16233k = null;
        }
        this.f16249c.f16237d.f16232j = this.f16248b.position();
        r();
        if (!b()) {
            GifHeader gifHeader = this.f16249c;
            gifHeader.f16236c++;
            gifHeader.f16238e.add(gifHeader.f16237d);
        }
    }

    private void f() {
        int d2 = d();
        this.f16250d = d2;
        if (d2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    int i4 = this.f16250d;
                    if (i2 < i4) {
                        i3 = i4 - i2;
                        this.f16248b.get(this.f16247a, i2, i3);
                        i2 += i3;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f16250d, e2);
                    }
                    this.f16249c.f16235b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f16248b.get(bArr);
            iArr = new int[UserVerificationMethods.USER_VERIFY_HANDPRINT];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | -16777216 | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f16249c.f16235b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i2) {
        boolean z2 = false;
        while (!z2 && !b() && this.f16249c.f16236c <= i2) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    q();
                } else if (d3 == 249) {
                    this.f16249c.f16237d = new GifFrame();
                    j();
                } else if (d3 == 254) {
                    q();
                } else if (d3 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.f16247a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d2 == 44) {
                GifHeader gifHeader = this.f16249c;
                if (gifHeader.f16237d == null) {
                    gifHeader.f16237d = new GifFrame();
                }
                e();
            } else if (d2 != 59) {
                this.f16249c.f16235b = 1;
            } else {
                z2 = true;
            }
        }
    }

    private void j() {
        d();
        int d2 = d();
        GifFrame gifFrame = this.f16249c.f16237d;
        int i2 = (d2 & 28) >> 2;
        gifFrame.f16229g = i2;
        boolean z2 = true;
        if (i2 == 0) {
            gifFrame.f16229g = 1;
        }
        if ((d2 & 1) == 0) {
            z2 = false;
        }
        gifFrame.f16228f = z2;
        int n2 = n();
        if (n2 < 2) {
            n2 = 10;
        }
        GifFrame gifFrame2 = this.f16249c.f16237d;
        gifFrame2.f16231i = n2 * 10;
        gifFrame2.f16230h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f16249c.f16235b = 1;
            return;
        }
        l();
        if (this.f16249c.f16241h && !b()) {
            GifHeader gifHeader = this.f16249c;
            gifHeader.f16234a = g(gifHeader.f16242i);
            GifHeader gifHeader2 = this.f16249c;
            gifHeader2.f16245l = gifHeader2.f16234a[gifHeader2.f16243j];
        }
    }

    private void l() {
        boolean z2;
        this.f16249c.f16239f = n();
        this.f16249c.f16240g = n();
        int d2 = d();
        GifHeader gifHeader = this.f16249c;
        if ((d2 & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        gifHeader.f16241h = z2;
        gifHeader.f16242i = (int) Math.pow(2.0d, (double) ((d2 & 7) + 1));
        this.f16249c.f16243j = d();
        this.f16249c.f16244k = d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m() {
        /*
            r3 = this;
        L_0x0000:
            r3.f()
            byte[] r0 = r3.f16247a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.f16249c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f16246m = r0
        L_0x001b:
            int r0 = r3.f16250d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.m():void");
    }

    private int n() {
        return this.f16248b.getShort();
    }

    private void o() {
        this.f16248b = null;
        Arrays.fill(this.f16247a, (byte) 0);
        this.f16249c = new GifHeader();
        this.f16250d = 0;
    }

    private void q() {
        int d2;
        do {
            d2 = d();
            this.f16248b.position(Math.min(this.f16248b.position() + d2, this.f16248b.limit()));
        } while (d2 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f16248b = null;
        this.f16249c = null;
    }

    public GifHeader c() {
        if (this.f16248b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f16249c;
        } else {
            k();
            if (!b()) {
                h();
                GifHeader gifHeader = this.f16249c;
                if (gifHeader.f16236c < 0) {
                    gifHeader.f16235b = 1;
                }
            }
            return this.f16249c;
        }
    }

    public GifHeaderParser p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f16248b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f16248b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
