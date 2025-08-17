package com.movie.ui.customdialog;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public final /* synthetic */ class h implements Function {
    public final Object apply(Object obj) {
        return Observable.fromIterable((List) obj).subscribeOn(Schedulers.a());
    }
}
