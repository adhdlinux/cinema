package com.movie.ui.adapter;

import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class g implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33124c;

    public /* synthetic */ g(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33123b = movieHolder;
        this.f33124c = calendarItem;
    }

    public final void subscribe(Observer observer) {
        this.f33123b.A(this.f33124c, observer);
    }
}
