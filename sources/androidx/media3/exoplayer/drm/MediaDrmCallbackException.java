package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MediaDrmCallbackException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f6247b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f6248c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<String>> f6249d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6250e;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, Throwable th) {
        super(th);
        this.f6247b = dataSpec;
        this.f6248c = uri;
        this.f6249d = map;
        this.f6250e = j2;
    }
}
