package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultFlexByteArrayPoolParams {
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

    private DefaultFlexByteArrayPoolParams() {
    }

    public static SparseIntArray generateBuckets(int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i2 <= i3) {
            sparseIntArray.put(i2, i4);
            i2 *= 2;
        }
        return sparseIntArray;
    }

    public static PoolParams get() {
        int i2 = DEFAULT_MAX_NUM_THREADS;
        return new PoolParams(4194304, i2 * 4194304, generateBuckets(DEFAULT_MIN_BYTE_ARRAY_SIZE, 4194304, i2), DEFAULT_MIN_BYTE_ARRAY_SIZE, 4194304, i2);
    }
}
