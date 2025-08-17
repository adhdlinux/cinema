package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import java.util.LinkedHashMap;
import java.util.Map;

final class FullSegmentEncryptionKeyCache {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<Uri, byte[]> f6299a;

    public FullSegmentEncryptionKeyCache(int i2) {
        final int i3 = i2;
        this.f6299a = new LinkedHashMap<Uri, byte[]>(i2 + 1, 1.0f, false) {
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
        return this.f6299a.get(uri);
    }

    public byte[] b(Uri uri, byte[] bArr) {
        return this.f6299a.put((Uri) Assertions.f(uri), (byte[]) Assertions.f(bArr));
    }

    public byte[] c(Uri uri) {
        return this.f6299a.remove(Assertions.f(uri));
    }
}
