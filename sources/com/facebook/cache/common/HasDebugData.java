package com.facebook.cache.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface HasDebugData {
    String getDebugData();
}
