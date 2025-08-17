package com.movie.ui.adapter;

import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33126c;

    public /* synthetic */ h(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33125b = movieHolder;
        this.f33126c = calendarItem;
    }

    public final void accept(Object obj) {
        this.f33125b.r(this.f33126c, (CalendarAdapter.MovieHolder.HolderImage) obj);
    }
}
