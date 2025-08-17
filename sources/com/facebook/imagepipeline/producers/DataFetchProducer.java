package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DataFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "DataFetchProducer";

    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory) {
        super(CallerThreadExecutor.getInstance(), pooledByteBufferFactory);
    }

    static byte[] getData(String str) {
        Preconditions.checkArgument(Boolean.valueOf(str.substring(0, 5).equals("data:")));
        int indexOf = str.indexOf(44);
        String substring = str.substring(indexOf + 1, str.length());
        if (isBase64(str.substring(0, indexOf))) {
            return Base64.decode(substring, 0);
        }
        String decode = Uri.decode(substring);
        Preconditions.checkNotNull(decode);
        return decode.getBytes();
    }

    static boolean isBase64(String str) {
        if (!str.contains(";")) {
            return false;
        }
        String[] split = str.split(";");
        return split[split.length - 1].equals("base64");
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        byte[] data = getData(imageRequest.getSourceUri().toString());
        return getByteBufferBackedEncodedImage(new ByteArrayInputStream(data), data.length);
    }

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }
}
