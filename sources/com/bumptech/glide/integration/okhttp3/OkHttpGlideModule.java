package com.bumptech.glide.integration.okhttp3;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import java.io.InputStream;

@Deprecated
public class OkHttpGlideModule implements GlideModule {
    public void a(Context context, GlideBuilder glideBuilder) {
    }

    public void b(Context context, Glide glide, Registry registry) {
        registry.r(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory());
    }
}
