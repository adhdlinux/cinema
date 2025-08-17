package com.movie.ui.activity.sources;

import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {
    public final Object apply(Object obj) {
        return BaseProvider.e(((MediaSource) obj).getProviderName());
    }
}
