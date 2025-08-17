package com.movie.ui.activity.sources;

import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class f0 implements Predicate {
    public final boolean test(Object obj) {
        return Utils.m(((MediaSource) obj).getStreamLink());
    }
}
