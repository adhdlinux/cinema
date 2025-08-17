package com.movie.ui.adapter;

import com.movie.data.model.tmvdb.TvTMDB;
import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Observer f33128c;

    public /* synthetic */ j(CalendarAdapter.MovieHolder movieHolder, Observer observer) {
        this.f33127b = movieHolder;
        this.f33128c = observer;
    }

    public final void accept(Object obj) {
        this.f33127b.t(this.f33128c, (TvTMDB.ResultsBean) obj);
    }
}
