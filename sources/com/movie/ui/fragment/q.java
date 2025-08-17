package com.movie.ui.fragment;

import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.SourceObservableUtils;
import io.reactivex.functions.Function;

public final /* synthetic */ class q implements Function {
    public final Object apply(Object obj) {
        return SourceObservableUtils.d((MediaSource) obj);
    }
}
