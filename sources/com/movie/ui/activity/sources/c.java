package com.movie.ui.activity.sources;

import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.SourceObservableUtils;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return SourceObservableUtils.b((MediaSource) obj);
    }
}
