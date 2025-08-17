package com.facebook.imagepipeline.backends.okhttp3;

import android.content.Context;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.infer.annotation.Nullsafe;
import okhttp3.OkHttpClient;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class OkHttpImagePipelineConfigFactory {
    public static ImagePipelineConfig.Builder newBuilder(Context context, OkHttpClient okHttpClient) {
        return ImagePipelineConfig.newBuilder(context).setNetworkFetcher(new OkHttpNetworkFetcher(okHttpClient));
    }
}
