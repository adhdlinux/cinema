package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;

public final class LruCache implements Cache {
    final android.util.LruCache<String, BitmapAndSize> cache;

    static final class BitmapAndSize {
        final Bitmap bitmap;
        final int byteCount;

        BitmapAndSize(Bitmap bitmap2, int i2) {
            this.bitmap = bitmap2;
            this.byteCount = i2;
        }
    }

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public void clear() {
        this.cache.evictAll();
    }

    public void clearKeyUri(String str) {
        for (String next : this.cache.snapshot().keySet()) {
            if (next.startsWith(str) && next.length() > str.length() && next.charAt(str.length()) == 10) {
                this.cache.remove(next);
            }
        }
    }

    public int evictionCount() {
        return this.cache.evictionCount();
    }

    public Bitmap get(String str) {
        BitmapAndSize bitmapAndSize = this.cache.get(str);
        if (bitmapAndSize != null) {
            return bitmapAndSize.bitmap;
        }
        return null;
    }

    public int hitCount() {
        return this.cache.hitCount();
    }

    public int maxSize() {
        return this.cache.maxSize();
    }

    public int missCount() {
        return this.cache.missCount();
    }

    public int putCount() {
        return this.cache.putCount();
    }

    public void set(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        if (bitmapBytes > maxSize()) {
            this.cache.remove(str);
        } else {
            this.cache.put(str, new BitmapAndSize(bitmap, bitmapBytes));
        }
    }

    public int size() {
        return this.cache.size();
    }

    public LruCache(int i2) {
        this.cache = new android.util.LruCache<String, BitmapAndSize>(i2) {
            /* access modifiers changed from: protected */
            public int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.byteCount;
            }
        };
    }
}
