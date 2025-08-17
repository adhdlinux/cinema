package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;

@Nullsafe(Nullsafe.Mode.STRICT)
public class MultiCacheKey implements CacheKey {
    final List<CacheKey> mCacheKeys;

    public MultiCacheKey(List<CacheKey> list) {
        this.mCacheKeys = (List) Preconditions.checkNotNull(list);
    }

    public boolean containsUri(Uri uri) {
        for (int i2 = 0; i2 < this.mCacheKeys.size(); i2++) {
            if (this.mCacheKeys.get(i2).containsUri(uri)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.mCacheKeys.equals(((MultiCacheKey) obj).mCacheKeys);
        }
        return false;
    }

    public List<CacheKey> getCacheKeys() {
        return this.mCacheKeys;
    }

    public String getUriString() {
        return this.mCacheKeys.get(0).getUriString();
    }

    public int hashCode() {
        return this.mCacheKeys.hashCode();
    }

    public boolean isResourceIdForDebugging() {
        return false;
    }

    public String toString() {
        return "MultiCacheKey:" + this.mCacheKeys.toString();
    }
}
