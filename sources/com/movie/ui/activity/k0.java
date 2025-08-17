package com.movie.ui.activity;

import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.BaseResolver;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public final /* synthetic */ class k0 implements Function {
    public final Object apply(Object obj) {
        return BaseResolver.m((MediaSource) obj).subscribeOn(Schedulers.c());
    }
}
