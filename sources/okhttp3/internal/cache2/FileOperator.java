package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel2) {
        Intrinsics.f(fileChannel2, "fileChannel");
        this.fileChannel = fileChannel2;
    }

    public final void read(long j2, Buffer buffer, long j3) {
        Intrinsics.f(buffer, "sink");
        if (j3 >= 0) {
            while (j3 > 0) {
                long transferTo = this.fileChannel.transferTo(j2, j3, buffer);
                j2 += transferTo;
                j3 -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long j2, Buffer buffer, long j3) throws IOException {
        Intrinsics.f(buffer, "source");
        if (j3 < 0 || j3 > buffer.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j4 = j2;
        long j5 = j3;
        while (j5 > 0) {
            long transferFrom = this.fileChannel.transferFrom(buffer, j4, j5);
            j4 += transferFrom;
            j5 -= transferFrom;
        }
    }
}
