package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class QualifiedResourceFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "QualifiedResourceFetchProducer";
    private final ContentResolver mContentResolver;

    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        InputStream openInputStream = this.mContentResolver.openInputStream(imageRequest.getSourceUri());
        Preconditions.checkNotNull(openInputStream, "ContentResolver returned null InputStream");
        return getEncodedImage(openInputStream, -1);
    }

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
