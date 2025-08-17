package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.common.base.Predicate;

public final /* synthetic */ class b implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.k((String) obj);
    }
}
