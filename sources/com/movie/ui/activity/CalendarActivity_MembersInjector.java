package com.movie.ui.activity;

import com.database.MvDatabase;
import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.api.tvmaze.TVMazeApi;
import com.movie.ui.helper.MoviesHelper;
import com.uwetrottmann.thetvdb.TheTvdb;
import dagger.MembersInjector;

public final class CalendarActivity_MembersInjector implements MembersInjector<CalendarActivity> {
    public static void a(CalendarActivity calendarActivity, IMDBApi iMDBApi) {
        calendarActivity.f32002g = iMDBApi;
    }

    public static void b(CalendarActivity calendarActivity, MoviesHelper moviesHelper) {
        calendarActivity.f32004i = moviesHelper;
    }

    public static void c(CalendarActivity calendarActivity, MvDatabase mvDatabase) {
        calendarActivity.f32000e = mvDatabase;
    }

    public static void d(CalendarActivity calendarActivity, TheTvdb theTvdb) {
        calendarActivity.f32003h = theTvdb;
    }

    public static void e(CalendarActivity calendarActivity, TMDBApi tMDBApi) {
        calendarActivity.f32001f = tMDBApi;
    }

    public static void f(CalendarActivity calendarActivity, TVMazeApi tVMazeApi) {
        calendarActivity.f31999d = tVMazeApi;
    }
}
