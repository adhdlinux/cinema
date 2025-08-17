package com.movie.ui.adapter;

import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33130b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f33131c;

    public /* synthetic */ l(CalendarAdapter.MovieHolder movieHolder, String str) {
        this.f33130b = movieHolder;
        this.f33131c = str;
    }

    public final Object apply(Object obj) {
        return this.f33130b.x(this.f33131c, (ResponseBody) obj);
    }
}
