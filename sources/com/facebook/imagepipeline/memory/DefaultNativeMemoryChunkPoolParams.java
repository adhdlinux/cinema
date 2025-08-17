package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.infer.annotation.Nullsafe;
import com.google.ar.core.ImageMetadata;
import com.google.protobuf.CodedOutputStream;
import okhttp3.internal.http2.Http2;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultNativeMemoryChunkPoolParams {
    private static final int LARGE_BUCKET_LENGTH = 2;
    private static final int SMALL_BUCKET_LENGTH = 5;

    public static PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(1024, 5);
        sparseIntArray.put(2048, 5);
        sparseIntArray.put(CodedOutputStream.DEFAULT_BUFFER_SIZE, 5);
        sparseIntArray.put(8192, 5);
        sparseIntArray.put(Http2.INITIAL_MAX_FRAME_SIZE, 5);
        sparseIntArray.put(32768, 5);
        sparseIntArray.put(65536, 5);
        sparseIntArray.put(131072, 5);
        sparseIntArray.put(262144, 2);
        sparseIntArray.put(ImageMetadata.LENS_APERTURE, 2);
        sparseIntArray.put(1048576, 2);
        return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), sparseIntArray);
    }

    private static int getMaxSizeHardCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return min / 2;
        }
        return (min / 4) * 3;
    }

    private static int getMaxSizeSoftCap() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return 3145728;
        }
        return min < 33554432 ? 6291456 : 12582912;
    }
}
