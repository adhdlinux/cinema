package org.mozilla.universalchardet.prober;

import com.startapp.y1;
import java.nio.ByteBuffer;

public abstract class CharsetProber {

    /* renamed from: a  reason: collision with root package name */
    private boolean f41888a = true;

    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    private boolean h(byte b2) {
        return (b2 & y1.f36938c) == 0;
    }

    private boolean i(byte b2) {
        byte b3 = b2 & 255;
        return b3 < 65 || (b3 > 90 && b3 < 97) || b3 > 122;
    }

    public ByteBuffer a(byte[] bArr, int i2, int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        int i4 = i3 + i2;
        int i5 = i2;
        boolean z2 = false;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 == 62) {
                z2 = false;
            } else if (b2 == 60) {
                z2 = true;
            }
            if (h(b2) && i(b2)) {
                if (i2 > i5 && !z2) {
                    allocate.put(bArr, i5, i2 - i5);
                    allocate.put((byte) 32);
                }
                i5 = i2 + 1;
            }
            i2++;
        }
        if (!z2 && i2 > i5) {
            allocate.put(bArr, i5, i2 - i5);
        }
        return allocate;
    }

    public ByteBuffer b(byte[] bArr, int i2, int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        int i4 = i3 + i2;
        int i5 = i2;
        boolean z2 = false;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (!h(b2)) {
                z2 = true;
            } else if (i(b2)) {
                if (!z2 || i2 <= i5) {
                    i5 = i2 + 1;
                } else {
                    allocate.put(bArr, i5, i2 - i5);
                    allocate.put((byte) 32);
                    i5 = i2 + 1;
                    z2 = false;
                }
            }
            i2++;
        }
        if (z2 && i2 > i5) {
            allocate.put(bArr, i5, i2 - i5);
        }
        return allocate;
    }

    public abstract String c();

    public abstract float d();

    public abstract ProbingState e();

    public abstract ProbingState f(byte[] bArr, int i2, int i3);

    public boolean g() {
        return this.f41888a;
    }

    public abstract void j();

    public void k(boolean z2) {
        this.f41888a = z2;
    }
}
