package com.movie.ui.adapter;

import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Observer f33115b;

    public /* synthetic */ b(Observer observer) {
        this.f33115b = observer;
    }

    public final void accept(Object obj) {
        CalendarAdapter.MovieHolder.y(this.f33115b, (CalendarAdapter.MovieHolder.HolderImage) obj);
    }
}
