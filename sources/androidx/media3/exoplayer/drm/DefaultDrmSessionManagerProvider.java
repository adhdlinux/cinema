package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6215a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private MediaItem.DrmConfiguration f6216b;

    /* renamed from: c  reason: collision with root package name */
    private DrmSessionManager f6217c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource.Factory f6218d;

    /* renamed from: e  reason: collision with root package name */
    private String f6219e;

    /* renamed from: f  reason: collision with root package name */
    private LoadErrorHandlingPolicy f6220f;

    private DrmSessionManager b(MediaItem.DrmConfiguration drmConfiguration) {
        String str;
        DataSource.Factory factory = this.f6218d;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().e(this.f6219e);
        }
        Uri uri = drmConfiguration.f4130c;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(str, drmConfiguration.f4135h, factory);
        UnmodifiableIterator<Map.Entry<String, String>> h2 = drmConfiguration.f4132e.entrySet().iterator();
        while (h2.hasNext()) {
            Map.Entry next = h2.next();
            httpMediaDrmCallback.e((String) next.getKey(), (String) next.getValue());
        }
        DefaultDrmSessionManager.Builder e2 = new DefaultDrmSessionManager.Builder().f(drmConfiguration.f4128a, FrameworkMediaDrm.f6239d).c(drmConfiguration.f4133f).d(drmConfiguration.f4134g).e(Ints.n(drmConfiguration.f4137j));
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f6220f;
        if (loadErrorHandlingPolicy != null) {
            e2.b(loadErrorHandlingPolicy);
        }
        DefaultDrmSessionManager a2 = e2.a(httpMediaDrmCallback);
        a2.E(0, drmConfiguration.c());
        return a2;
    }

    public DrmSessionManager a(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.f(mediaItem.f4079b);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.f4079b.f4173c;
        if (drmConfiguration == null) {
            return DrmSessionManager.f6227a;
        }
        synchronized (this.f6215a) {
            if (!Util.c(drmConfiguration, this.f6216b)) {
                this.f6216b = drmConfiguration;
                this.f6217c = b(drmConfiguration);
            }
            drmSessionManager = (DrmSessionManager) Assertions.f(this.f6217c);
        }
        return drmSessionManager;
    }
}
