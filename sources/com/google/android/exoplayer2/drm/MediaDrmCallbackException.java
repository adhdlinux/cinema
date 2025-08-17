package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MediaDrmCallbackException extends IOException {

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f24111b;

    /* renamed from: c  reason: collision with root package name */
    public final Uri f24112c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, List<String>> f24113d;

    /* renamed from: e  reason: collision with root package name */
    public final long f24114e;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, Throwable th) {
        super(th);
        this.f24111b = dataSpec;
        this.f24112c = uri;
        this.f24113d = map;
        this.f24114e = j2;
    }
}
