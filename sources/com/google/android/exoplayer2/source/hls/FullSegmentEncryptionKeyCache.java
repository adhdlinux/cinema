package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map;

final class FullSegmentEncryptionKeyCache {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Uri, byte[]> f26391a;

    public FullSegmentEncryptionKeyCache(int i2) {
        final int i3 = i2;
        this.f26391a = new LinkedHashMap<Uri, byte[]>(this, i2 + 1, 1.0f, false) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
                return size() > i3;
            }
        };
    }

    public byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f26391a.get(uri);
    }

    public byte[] b(Uri uri, byte[] bArr) {
        return this.f26391a.put((Uri) Assertions.e(uri), (byte[]) Assertions.e(bArr));
    }

    public byte[] c(Uri uri) {
        return this.f26391a.remove(Assertions.e(uri));
    }
}
