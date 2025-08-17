package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class MetadataListReader {

    private static class ByteBufferReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f3120a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f3120a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public void a(int i2) throws IOException {
            ByteBuffer byteBuffer = this.f3120a;
            byteBuffer.position(byteBuffer.position() + i2);
        }

        public int b() throws IOException {
            return this.f3120a.getInt();
        }

        public long c() throws IOException {
            return MetadataListReader.c(this.f3120a.getInt());
        }

        public long getPosition() {
            return (long) this.f3120a.position();
        }

        public int readUnsignedShort() throws IOException {
            return MetadataListReader.d(this.f3120a.getShort());
        }
    }

    private static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f3121a;

        /* renamed from: b  reason: collision with root package name */
        private final long f3122b;

        OffsetInfo(long j2, long j3) {
            this.f3121a = j2;
            this.f3122b = j3;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f3121a;
        }
    }

    private interface OpenTypeReader {
        void a(int i2) throws IOException;

        int b() throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo a(OpenTypeReader openTypeReader) throws IOException {
        long j2;
        openTypeReader.a(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.a(6);
            int i2 = 0;
            while (true) {
                if (i2 >= readUnsignedShort) {
                    j2 = -1;
                    break;
                }
                int b2 = openTypeReader.b();
                openTypeReader.a(4);
                j2 = openTypeReader.c();
                openTypeReader.a(4);
                if (1835365473 == b2) {
                    break;
                }
                i2++;
            }
            if (j2 != -1) {
                openTypeReader.a((int) (j2 - openTypeReader.getPosition()));
                openTypeReader.a(12);
                long c2 = openTypeReader.c();
                for (int i3 = 0; ((long) i3) < c2; i3++) {
                    int b3 = openTypeReader.b();
                    long c3 = openTypeReader.c();
                    long c4 = openTypeReader.c();
                    if (1164798569 == b3 || 1701669481 == b3) {
                        return new OffsetInfo(c3 + j2, c4);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    static MetadataList b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).a());
        return MetadataList.h(duplicate);
    }

    static long c(int i2) {
        return ((long) i2) & 4294967295L;
    }

    static int d(short s2) {
        return s2 & 65535;
    }
}
