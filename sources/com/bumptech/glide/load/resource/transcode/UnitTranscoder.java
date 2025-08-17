package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitTranscoder<?> f16968a = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> b() {
        return f16968a;
    }

    public Resource<Z> a(Resource<Z> resource, Options options) {
        return resource;
    }
}
