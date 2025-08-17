package com.movie.ui.adapter;

import android.view.View;
import com.movie.data.model.CalendarItem;
import com.movie.ui.adapter.CalendarAdapter;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarAdapter.MovieHolder f33117b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f33118c;

    public /* synthetic */ d(CalendarAdapter.MovieHolder movieHolder, CalendarItem calendarItem) {
        this.f33117b = movieHolder;
        this.f33118c = calendarItem;
    }

    public final void onClick(View view) {
        this.f33117b.q(this.f33118c, view);
    }
}
