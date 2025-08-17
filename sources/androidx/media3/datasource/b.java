package androidx.media3.datasource;

import androidx.media3.datasource.DefaultHttpDataSource;
import com.google.common.base.Predicate;

public final /* synthetic */ class b implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.k((String) obj);
    }
}
