package com.movie.ui.adapter;

import android.view.View;
import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33113b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33114c;

    public /* synthetic */ a(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33113b = movieHolder;
        this.f33114c = calendarItem;
    }

    public final void onClick(View view) {
        this.f33113b.p(this.f33114c, view);
    }
}
