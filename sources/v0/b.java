package v0;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;

public final /* synthetic */ class b {
    static {
        CacheKeyFactory cacheKeyFactory = CacheKeyFactory.f28580a;
    }

    public static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.f28347i;
        return str != null ? str : dataSpec.f28339a.toString();
    }
}
