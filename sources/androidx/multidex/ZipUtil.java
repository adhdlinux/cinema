package androidx.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import okhttp3.internal.http2.Http2;

final class ZipUtil {

    static class CentralDirectory {

        /* renamed from: a  reason: collision with root package name */
        long f10755a;

        /* renamed from: b  reason: collision with root package name */
        long f10756b;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    static long a(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j2 = centralDirectory.f10756b;
        randomAccessFile.seek(centralDirectory.f10755a);
        int min = (int) Math.min(16384, j2);
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        int read = randomAccessFile.read(bArr, 0, min);
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j2 -= (long) read;
            if (j2 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j2));
        }
        return crc32.getValue();
    }

    static CentralDirectory b(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j2 = 0;
        if (length >= 0) {
            long j3 = length - 65536;
            if (j3 >= 0) {
                j2 = j3;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.f10756b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    centralDirectory.f10755a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return centralDirectory;
                }
                length--;
            } while (length >= j2);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    static long c(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            return a(randomAccessFile, b(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
