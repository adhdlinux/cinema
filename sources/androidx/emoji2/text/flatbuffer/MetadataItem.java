package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class MetadataItem extends Table {
    public MetadataItem f(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
        return this;
    }

    public void g(int i2, ByteBuffer byteBuffer) {
        c(i2, byteBuffer);
    }

    public int h(int i2) {
        int b2 = b(16);
        if (b2 != 0) {
            return this.f3143b.getInt(d(b2) + (i2 * 4));
        }
        return 0;
    }

    public int i() {
        int b2 = b(16);
        if (b2 != 0) {
            return e(b2);
        }
        return 0;
    }

    public boolean j() {
        int b2 = b(6);
        return (b2 == 0 || this.f3143b.get(b2 + this.f3142a) == 0) ? false : true;
    }

    public short k() {
        int b2 = b(14);
        if (b2 != 0) {
            return this.f3143b.getShort(b2 + this.f3142a);
        }
        return 0;
    }

    public int l() {
        int b2 = b(4);
        if (b2 != 0) {
            return this.f3143b.getInt(b2 + this.f3142a);
        }
        return 0;
    }

    public short m() {
        int b2 = b(8);
        if (b2 != 0) {
            return this.f3143b.getShort(b2 + this.f3142a);
        }
        return 0;
    }

    public short n() {
        int b2 = b(12);
        if (b2 != 0) {
            return this.f3143b.getShort(b2 + this.f3142a);
        }
        return 0;
    }
}
