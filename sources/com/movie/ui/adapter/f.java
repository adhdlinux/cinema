package com.movie.ui.adapter;

import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class f implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33121b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33122c;

    public /* synthetic */ f(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33121b = movieHolder;
        this.f33122c = calendarItem;
    }

    public final void subscribe(Observer observer) {
        this.f33121b.w(this.f33122c, observer);
    }
}
