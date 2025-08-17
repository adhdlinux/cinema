package androidx.media3.exoplayer.source;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

public interface ExternalLoader {

    public static final class LoadRequest {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f6913a;

        public LoadRequest(Uri uri) {
            this.f6913a = uri;
        }
    }

    ListenableFuture<?> a(LoadRequest loadRequest);
}
