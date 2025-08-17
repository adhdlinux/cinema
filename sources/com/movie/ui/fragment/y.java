package com.movie.ui.fragment;

import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class y implements Predicate {
    public final boolean test(Object obj) {
        return Utils.m(((MediaSource) obj).getStreamLink());
    }
}
