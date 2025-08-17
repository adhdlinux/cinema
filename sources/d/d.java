package d;

import androidx.media3.datasource.cache.CacheSpan;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return LeastRecentlyUsedCacheEvictor.f((CacheSpan) obj, (CacheSpan) obj2);
    }
}
