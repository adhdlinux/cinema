package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface ResourceReleaser<T> {
    void release(T t2);
}
