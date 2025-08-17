package com.facebook.common.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface DiskTrimmable {
    void trimToMinimum();

    void trimToNothing();
}
