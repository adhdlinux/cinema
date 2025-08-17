package com.facebook.cache.common;

import com.facebook.cache.common.CacheEventListener;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface CacheEvent {
    CacheKey getCacheKey();

    long getCacheLimit();

    long getCacheSize();

    CacheEventListener.EvictionReason getEvictionReason();

    IOException getException();

    long getItemSize();

    String getResourceId();
}
