package com.movie;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public final /* synthetic */ class b implements Consumer {
    public final void accept(Object obj) {
        FreeMoviesApp.u((ResponseBody) obj);
    }
}
