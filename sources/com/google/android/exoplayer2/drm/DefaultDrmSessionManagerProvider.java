package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Object f24070a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private MediaItem.DrmConfiguration f24071b;

    /* renamed from: c  reason: collision with root package name */
    private DrmSessionManager f24072c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource.Factory f24073d;

    /* renamed from: e  reason: collision with root package name */
    private String f24074e;

    private DrmSessionManager b(MediaItem.DrmConfiguration drmConfiguration) {
        String str;
        DataSource.Factory factory = this.f24073d;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().c(this.f24074e);
        }
        Uri uri = drmConfiguration.f23168c;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(str, drmConfiguration.f23173h, factory);
        UnmodifiableIterator<Map.Entry<String, String>> h2 = drmConfiguration.f23170e.entrySet().iterator();
        while (h2.hasNext()) {
            Map.Entry next = h2.next();
            httpMediaDrmCallback.e((String) next.getKey(), (String) next.getValue());
        }
        DefaultDrmSessionManager a2 = new DefaultDrmSessionManager.Builder().e(drmConfiguration.f23166a, FrameworkMediaDrm.f24103d).b(drmConfiguration.f23171f).c(drmConfiguration.f23172g).d(Ints.n(drmConfiguration.f23175j)).a(httpMediaDrmCallback);
        a2.E(0, drmConfiguration.c());
        return a2;
    }

    public DrmSessionManager a(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.e(mediaItem.f23129c);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.f23129c.f23204c;
        if (drmConfiguration == null || Util.f28808a < 18) {
            return DrmSessionManager.f24090a;
        }
        synchronized (this.f24070a) {
            if (!Util.c(drmConfiguration, this.f24071b)) {
                this.f24071b = drmConfiguration;
                this.f24072c = b(drmConfiguration);
            }
            drmSessionManager = (DrmSessionManager) Assertions.e(this.f24072c);
        }
        return drmSessionManager;
    }
}
