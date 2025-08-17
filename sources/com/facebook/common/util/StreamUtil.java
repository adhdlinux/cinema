package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
public class StreamUtil {
    public static byte[] getBytesFromStream(InputStream inputStream) throws IOException {
        return getBytesFromStream(inputStream, inputStream.available());
    }

    public static long skip(InputStream inputStream, long j2) throws IOException {
        boolean z2;
        Preconditions.checkNotNull(inputStream);
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        long j3 = j2;
        while (j3 > 0) {
            long skip = inputStream.skip(j3);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    return j2 - j3;
                }
                skip = 1;
            }
            j3 -= skip;
        }
        return j2;
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i2) throws IOException {
        AnonymousClass1 r02 = new ByteArrayOutputStream(i2) {
            public byte[] toByteArray() {
                int i2 = this.count;
                byte[] bArr = this.buf;
                if (i2 == bArr.length) {
                    return bArr;
                }
                return super.toByteArray();
            }
        };
        ByteStreams.copy(inputStream, r02);
        return r02.toByteArray();
    }
}
