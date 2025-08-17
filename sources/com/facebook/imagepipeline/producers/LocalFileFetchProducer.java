package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class LocalFileFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalFileFetchProducer";

    public LocalFileFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        super(executor, pooledByteBufferFactory);
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        return getEncodedImage(new FileInputStream(imageRequest.getSourceFile().toString()), (int) imageRequest.getSourceFile().length());
    }

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
