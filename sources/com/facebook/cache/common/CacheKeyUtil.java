package com.facebook.cache.common;

import com.facebook.common.util.SecureHashUtil;
import com.facebook.infer.annotation.Nullsafe;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Nullsafe(Nullsafe.Mode.STRICT)
public final class CacheKeyUtil {
    public static String getFirstResourceId(CacheKey cacheKey) {
        try {
            if (cacheKey instanceof MultiCacheKey) {
                return secureHashKey(((MultiCacheKey) cacheKey).getCacheKeys().get(0));
            }
            return secureHashKey(cacheKey);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static List<String> getResourceIds(CacheKey cacheKey) {
        ArrayList arrayList;
        String str;
        try {
            if (cacheKey instanceof MultiCacheKey) {
                List<CacheKey> cacheKeys = ((MultiCacheKey) cacheKey).getCacheKeys();
                arrayList = new ArrayList(cacheKeys.size());
                for (int i2 = 0; i2 < cacheKeys.size(); i2++) {
                    arrayList.add(secureHashKey(cacheKeys.get(i2)));
                }
            } else {
                arrayList = new ArrayList(1);
                if (cacheKey.isResourceIdForDebugging()) {
                    str = cacheKey.getUriString();
                } else {
                    str = secureHashKey(cacheKey);
                }
                arrayList.add(str);
            }
            return arrayList;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String secureHashKey(CacheKey cacheKey) throws UnsupportedEncodingException {
        return SecureHashUtil.makeSHA1HashBase64(cacheKey.getUriString().getBytes("UTF-8"));
    }
}
