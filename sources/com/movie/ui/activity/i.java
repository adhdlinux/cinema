package com.movie.ui.activity;

import com.movie.data.model.CalendarItem;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CalendarActivity f32248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CalendarItem f32249c;

    public /* synthetic */ i(CalendarActivity calendarActivity, CalendarItem calendarItem) {
        this.f32248b = calendarActivity;
        this.f32249c = calendarItem;
    }

    public final void accept(Object obj) {
        this.f32248b.U(this.f32249c, (Throwable) obj);
    }
}
