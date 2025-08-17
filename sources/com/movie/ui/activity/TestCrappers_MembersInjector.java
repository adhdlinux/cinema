package com.movie.ui.activity;

import com.movie.data.api.imdb.IMDBApi;
import com.movie.data.api.tmdb.TMDBApi;
import dagger.MembersInjector;

public final class TestCrappers_MembersInjector implements MembersInjector<TestCrappers> {
    public static void a(TestCrappers testCrappers, IMDBApi iMDBApi) {
        testCrappers.f32173c = iMDBApi;
    }

    public static void b(TestCrappers testCrappers, TMDBApi tMDBApi) {
        testCrappers.f32174d = tMDBApi;
    }
}
