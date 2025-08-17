package com.facebook.drawable.base;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface DrawableWithCaches {
    void dropCaches();
}
