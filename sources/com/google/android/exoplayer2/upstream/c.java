package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.common.base.Predicate;
import java.util.Map;

public final /* synthetic */ class c implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.j((Map.Entry) obj);
    }
}
