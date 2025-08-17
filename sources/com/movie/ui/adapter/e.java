package com.movie.ui.adapter;

import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final /* synthetic */ class e implements ObservableSource {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33119b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33120c;

    public /* synthetic */ e(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33119b = movieHolder;
        this.f33120c = calendarItem;
    }

    public final void subscribe(Observer observer) {
        this.f33119b.v(this.f33120c, observer);
    }
}
