package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {
    public static MetadataList h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new MetadataList());
    }

    public static MetadataList i(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList f(int i2, ByteBuffer byteBuffer) {
        g(i2, byteBuffer);
        return this;
    }

    public void g(int i2, ByteBuffer byteBuffer) {
        c(i2, byteBuffer);
    }

    public MetadataItem j(MetadataItem metadataItem, int i2) {
        int b2 = b(6);
        if (b2 != 0) {
            return metadataItem.f(a(d(b2) + (i2 * 4)), this.f3143b);
        }
        return null;
    }

    public int k() {
        int b2 = b(6);
        if (b2 != 0) {
            return e(b2);
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
}
