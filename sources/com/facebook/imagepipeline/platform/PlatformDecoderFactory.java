package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class PlatformDecoderFactory {
    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z2) {
        if (Build.VERSION.SDK_INT >= 26) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads));
        }
        int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
        return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools$SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
    }
}
