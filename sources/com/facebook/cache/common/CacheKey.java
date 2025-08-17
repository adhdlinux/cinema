package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface CacheKey {
    boolean containsUri(Uri uri);

    boolean equals(Object obj);

    String getUriString();

    int hashCode();

    boolean isResourceIdForDebugging();

    String toString();
}
