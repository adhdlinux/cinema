package androidx.media3.datasource;

import androidx.media3.datasource.DefaultHttpDataSource;
import com.google.common.base.Predicate;
import java.util.Map;

public final /* synthetic */ class a implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.j((Map.Entry) obj);
    }
}
