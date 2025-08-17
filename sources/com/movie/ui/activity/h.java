package com.movie.ui.activity;

import com.movie.data.model.CalendarItem;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarActivity f32246b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f32247c;

    public /* synthetic */ h(CalendarActivity calendarActivity, CalendarItem calendarItem) {
        this.f32246b = calendarActivity;
        this.f32247c = calendarItem;
    }

    public final void accept(Object obj) {
        this.f32246b.T(this.f32247c, obj);
    }
}
