package com.bumptech.glide.request;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    public static RequestOptions f0(Class<?> cls) {
        return (RequestOptions) new RequestOptions().e(cls);
    }

    public static RequestOptions g0(DiskCacheStrategy diskCacheStrategy) {
        return (RequestOptions) new RequestOptions().f(diskCacheStrategy);
    }

    public static RequestOptions h0(Key key) {
        return (RequestOptions) new RequestOptions().X(key);
    }
}
