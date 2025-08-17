package com.movie.ui.activity.sources.seasonPack;

import com.database.MvDatabase;
import com.movie.data.api.realdebrid.RealDebridApi;
import dagger.MembersInjector;

public final class SeasonPackActivity_MembersInjector implements MembersInjector<SeasonPackActivity> {
    public static void a(SeasonPackActivity seasonPackActivity, MvDatabase mvDatabase) {
        seasonPackActivity.f32995e = mvDatabase;
    }

    public static void b(SeasonPackActivity seasonPackActivity, RealDebridApi realDebridApi) {
        seasonPackActivity.f32998h = realDebridApi;
    }
}
