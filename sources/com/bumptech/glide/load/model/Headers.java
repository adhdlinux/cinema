package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

public interface Headers {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final Headers f16703a = new Headers() {
        public Map<String, String> a() {
            return Collections.emptyMap();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final Headers f16704b = new LazyHeaders.Builder().a();

    Map<String, String> a();
}
